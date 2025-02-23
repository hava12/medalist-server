terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 5.0"
    }
  }
}

provider "aws" {
  region = "ap-northeast-2"
}

resource "aws_instance" "app_server" {
  ami           = "ami-075e056c0f3d02523"  # AMI ID (Amazon Linux 2 등)
  instance_type = "t3.micro"
  key_name      = "ec2-key-pair"  # EC2 SSH 접속을 위한 키페어 이름

  # 보안 그룹 설정: 기존 SG가 있으면 그것을 사용, 없으면 새로 생성된 SG 사용
  security_groups = try([data.aws_security_group.existing_sg.id], try([aws_security_group.app_sg[0].id], []))

  tags = {
    Name = "AppServer"
  }

  user_data = <<-EOF
              #!/bin/bash
              sudo apt update -y
              sudo apt install -y openjdk-17-jdk
              EOF
}

# 기존 Security Group이 있는지 확인
data "aws_security_group" "existing_sg" {
  filter {
    name   = "group-name"
    values = ["app-security-group"]
  }
}

# 존재하면 해당 Security Group을 사용, 없으면 새로 생성
resource "aws_security_group" "app_sg" {
  count = length(data.aws_security_group.existing_sg) > 0 ? 0 : 1

  name        = "app-security-group"
  description = "Security group for application server"
  vpc_id      = "vpc-0996c7416f8922952"

  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port   = 80
    to_port     = 80
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

# EC2 Public IP 출력
output "ec2_public_ip" {
  value = aws_instance.app_server.public_ip
}

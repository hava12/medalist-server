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
  ami           = "ami-12345678"  # 원하는 AMI ID (Amazon Linux 2 등)
  instance_type = "t3.micro"
  key_name      = "my-key"  # EC2 SSH 접속을 위한 키페어 이름
  security_groups = [aws_security_group.app_sg.name]  # 보안 그룹 연결

  tags = {
    Name = "AppServer"
  }

  user_data = <<-EOF
              #!/bin/bash
              sudo apt update -y
              sudo apt install -y openjdk-17-jdk
              EOF
}

# 보안 그룹 (EC2의 인바운드/아웃바운드 트래픽 제어)
resource "aws_security_group" "app_sg" {
  name        = "app-security-group"
  description = "Security group for application server"

  # SSH 접속 허용 (보안을 위해 특정 IP로 제한 가능)
  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]  # 필요 시 특정 IP로 변경
  }

  # HTTP 트래픽 허용 (80번 포트)
  ingress {
    from_port   = 80
    to_port     = 80
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  # HTTPS 트래픽 허용 (443번 포트)
  ingress {
    from_port   = 443
    to_port     = 443
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  # 모든 아웃바운드 트래픽 허용
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

description = "apps module"
plugins {
    id("org.springframework.boot") version "3.4.2"
    id("io.spring.dependency-management") version "1.1.3"
    kotlin("jvm") version "1.8.0"
}

dependencies {
    api("org.springframework.boot:spring-boot-starter-web")
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    api("org.springframework.boot:spring-boot-starter-security")
    api("org.springframework.boot:spring-boot-starter-web")
    api("org.projectlombok:lombok")
    api("org.projectlombok:lombok")
    api("org.springframework.boot:spring-boot-starter-test")
    api("org.springframework.security:spring-security-test")
    api("org.junit.platform:junit-platform-launcher")
}
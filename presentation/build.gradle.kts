plugins {
    id("org.springframework.boot") version "3.4.2"
    id("io.spring.dependency-management") version "1.1.3"
    kotlin("jvm") version "1.8.0"
    kotlin("plugin.spring") version "1.8.0"
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
}

tasks.bootJar {
    enabled = false
}

tasks.jar {
    enabled = true
}

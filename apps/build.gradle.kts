description = "apps module"
plugins {
    id("org.springframework.boot") version "3.4.2"
    id("io.spring.dependency-management") version "1.1.3"
    kotlin("jvm") version "1.8.0"
    kotlin("plugin.spring") version "1.8.0"
}

dependencies {
}

tasks.bootJar {
    enabled = false
}

tasks.jar {
    enabled = true
}

plugins {
    id("org.springframework.boot") version "3.4.2"
    id("io.spring.dependency-management") version "1.1.3"
    kotlin("jvm") version "1.8.0"
    kotlin("plugin.spring") version "1.8.0"
}

dependencies {
    implementation(project(":application"))
    implementation("org.springframework.boot:spring-boot-starter-web")

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
}

tasks.bootJar {
    enabled = false
}

tasks.jar {
    enabled = true
}

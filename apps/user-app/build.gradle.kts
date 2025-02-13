plugins {
    id("org.springframework.boot") version "3.4.2"
    id("io.spring.dependency-management") version "1.1.3"
    kotlin("jvm") version "1.8.0"
    kotlin("plugin.spring") version "1.8.0"
}

dependencies {
    implementation(project(":presentation-module"))

    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation("org.testcontainers:junit-jupiter")
    implementation("org.springframework.boot:spring-boot-testcontainers")
    implementation("org.testcontainers:mysql")

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

}

tasks.bootJar {
    enabled = true
}

tasks.jar {
    enabled = true
}

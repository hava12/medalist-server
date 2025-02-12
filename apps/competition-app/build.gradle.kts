plugins {
    id("org.springframework.boot") version "3.4.2"
    id("io.spring.dependency-management") version "1.1.3"
    kotlin("jvm") version "1.8.0"
    kotlin("plugin.spring") version "1.8.0"
}

group = "com"
version = "0.0.1-SNAPSHOT"

dependencies {
    implementation(project(":presentation-module"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("mysql:mysql-connector-java:8.0.33")
    implementation("org.testcontainers:testcontainers-bom:1.20.2")

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    testImplementation("org.testcontainers:mysql")
    testImplementation("org.testcontainers:junit-jupiter")

//    testImplementation("org.springframework.boot:spring-boot-test")

}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.bootJar {
    enabled = true
}

tasks.jar {
    enabled = true
}
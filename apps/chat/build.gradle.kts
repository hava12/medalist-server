plugins {
    id("org.springframework.boot") version "3.4.2"
    id("io.spring.dependency-management") version "1.1.3"
    kotlin("jvm") version "1.8.0"
    kotlin("plugin.spring") version "1.8.0"
}
group = "com"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":presentation-module"))

    implementation("org.springframework.boot:spring-boot-starter-web")

    // 웹소켓
    implementation("org.springframework.boot:spring-boot-starter-websocket")

    implementation("org.testcontainers:junit-jupiter")
    implementation("org.springframework.boot:spring-boot-testcontainers")
    implementation("org.testcontainers:mysql")
    implementation("mysql:mysql-connector-java:8.0.32")

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.bootJar {
    enabled = true
}

tasks.jar {
    enabled = true
}

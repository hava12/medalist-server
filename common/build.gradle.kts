plugins {
    java
//    checkstyle
}

group = "com"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
//    maven {
//        name = "GitHubPackages"
//        url = uri(project.findProperty("url") as String)
//        credentials {
//            username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
//            password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
//        }
//    }
}

dependencies {
//    implementation("com.hava12.custom-checkstyle:custom-checkstyle:1.0.0-SNAPSHOT")
//    checkstyle("com.hava12.custom-checkstyle:custom-checkstyle:1.0.0-SNAPSHOT")
}

//checkstyle {
//    toolVersion = "10.21.1"  // Checkstyle 버전
//    configFile = file("config/checkstyle/checkstyle-custom.xml")
//    isShowViolations = true
//}

//tasks.register<Checkstyle>("checkCommon") {
//    configFile = file("config/checkstyle/checkstyle-common.xml")
//    source = fileTree("src/common/java")
//    classpath = files()
//    reports {
//        html.required.set(true)
//        xml.required.set(false)
//    }
//}
//
//tasks.register<Checkstyle>("checkPresentation") {
//    configFile = file("config/checkstyle/checkstyle-rules.xml")
//    source = fileTree("src/presentation/java")
//    classpath = files()
//    reports {
//        html.required.set(true)
//        xml.required.set(false)
//    }
//}
//
//tasks.named("check") {
//    dependsOn("checkCommon", "checkPresentation")
//}
////tasks.withType<Checkstyle> {
////    reports {
////        xml.required.set(false)
////        html.required.set(true) // HTML 리포트 활성화
////    }
//}
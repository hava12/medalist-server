rootProject.name = "medalist"

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
    plugins {
        id("java-library")
    }
    includeBuild("gradle/custom-plugins/convention")
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.6.0"
}

module(name=":presentation-module", "presentation")

module(name=":apps", "apps")
module(name=":apps:user-app-module", "apps/user-app")
module(name=":apps:competition-app-module", "apps/competition-app")

fun module(name: String, path: String) {
    include(name)
    project(name).projectDir = file(path)
}


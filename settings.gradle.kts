rootProject.name = "medalist"

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

module(":presentation", "presentation")

fun module(name: String, path: String) {
    include(name)
    project(name).projectDir = file(path)
}


rootProject.name = "medalist"

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.6.0"
}

module(name=":presentation-module", "presentation")

module(name=":apps", "apps")
module(name=":apps:user-app-module", "apps/user-app")
module(name=":apps:competition-app-module", "apps/competition-app")
module(name=":apps:chatting-app-module", "apps/chat")

module(name=":common", "common")
module(name=":application", "application")
module(name=":domain", "domain")

fun module(name: String, path: String) {
    include(name)
    project(name).projectDir = file(path)
}
include("apps:chat")
findProject(":apps:chat")?.name = "chat"
include("apps:chat")
findProject(":apps:chat")?.name = "chat"

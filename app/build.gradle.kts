plugins {
    id("configuration.application")
    id("convention.kotlin")
    id("convention.compose")
    id("convention.hilt")
    id("convention.navigation")
    id("convention.network")
    id("convention.packaging")
}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":core:extension"))
    implementation(project(":core:navigation"))
    implementation(project(":core:reducer"))
    implementation(project(":core:ui"))

    implementation(project(":feature:characters"))
    implementation(project(":feature:splash"))
}
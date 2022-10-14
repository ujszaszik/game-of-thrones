plugins {
    id("configuration.library")
    id("convention.kotlin")
    id("convention.packaging")
    id("convention.compose")
    id("convention.hilt")
    id("convention.navigation")
    id("convention.network")
    id("convention.room")
}

android {
    namespace = "hu.ujszaszik.characters"
}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":core:extension"))
    implementation(project(":core:navigation"))
    implementation(project(":core:reducer"))
    implementation(project(":core:ui"))
}
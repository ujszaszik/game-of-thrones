plugins {
    id("configuration.library")
    id("convention.kotlin")
    id("convention.compose")
    id("convention.hilt")
    id("convention.navigation")
}

android {
    namespace = "hu.ujszaszik.splash"
}

dependencies {
    implementation(project(":core:extension"))
    implementation(project(":core:navigation"))
    implementation(project(":core:reducer"))
    implementation(project(":core:ui"))
}
plugins {
    id("configuration.library")
    id("convention.kotlin")
    id("convention.hilt")
    id("convention.compose")
    id("convention.navigation")
}

android {
    namespace = "hu.ujszaszik.navigation"
}

dependencies {
    implementation(project(":core:extension"))
}
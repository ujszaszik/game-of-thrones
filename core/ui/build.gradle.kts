plugins {
    id("configuration.library")
    id("convention.kotlin")
    id("convention.compose")
    id("convention.hilt")
}

android {
    namespace = "hu.ujszaszik.ui"
}

dependencies {
    implementation(project(":core:extension"))
}
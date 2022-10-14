plugins {
    id("configuration.library")
    id("convention.kotlin")
    id("convention.hilt")
    id("convention.network")
}

dependencies {
    implementation(project(":core:extension"))
    implementation(project(":core:reducer"))
}

android {
    namespace = "hu.ujszaszik.data"
}
plugins {
    id("configuration.application")
    id("convention.kotlin")
    id("convention.compose")
    id("convention.hilt")
    id("convention.navigation")
    id("convention.network")
    id("convention.packaging")
    id("io.gitlab.arturbosch.detekt").version("1.21.0")
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

android {
    detekt {
        config = files("detekt_config.yml")
        parallel = true
        buildUponDefaultConfig = false
        allRules = true
        debug = true
        basePath = projectDir.absolutePath
    }
}
package hu.ujszaszik.buildlogic.configuration.application

object AppConfig {

    private const val COMPILE_SDK = 33
    private const val MIN_SDK = 24
    private const val TARGET_SDK = 33

    private const val JUNIT_RUNNER = "androidx.test.runner.AndroidJUnitRunner"

    val defaultConfig = ApplicationConfig(
        applicationId = "hu.ujszaszik.gameofthrones",
        compileSdk = COMPILE_SDK,
        minSdk = MIN_SDK,
        targetSdk = TARGET_SDK,
        versionCode = 1,
        versionName = "1.0.0",
        buildToolsVersion = "31.0.0",
        testInstrumentationRunner = JUNIT_RUNNER
    )
}
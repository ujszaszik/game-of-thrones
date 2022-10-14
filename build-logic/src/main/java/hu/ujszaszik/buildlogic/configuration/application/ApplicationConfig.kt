package hu.ujszaszik.buildlogic.configuration.application

data class ApplicationConfig(
    val compileSdk: Int,
    val minSdk: Int,
    val targetSdk: Int,
    val applicationId: String,
    val buildToolsVersion: String,
    val versionCode: Int,
    val versionName: String,
    val testInstrumentationRunner: String
)
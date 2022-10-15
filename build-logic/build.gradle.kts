plugins {
    `kotlin-dsl`
}

group = "hu.ujszaszik.gameofthrones.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    compileOnly(libs.android.gradle)
    compileOnly(libs.kotlin.gradle)
}

gradlePlugin {
    plugins {
        val domain = "hu.ujszaszik"
        val prefix = "buildlogic"
        registerConfigurationPlugins(domain, prefix)
        registerConventionPlugins(domain, prefix)
    }
}

fun NamedDomainObjectContainer<PluginDeclaration>.registerConfigurationPlugins(
    domain: String,
    prefix: String
) {
    val configurationID = "configuration"
    val configurationPrefix = "$domain.$prefix.$configurationID"
    val configurationPostfix = "ConfigPlugin"

    register("applicationPlugin") {
        id = "$configurationID.application"
        implementationClass = "$configurationPrefix.application.Application$configurationPostfix"
    }

    register("libraryPlugin") {
        id = "$configurationID.library"
        implementationClass = "$configurationPrefix.library.Library$configurationPostfix"
    }

}

fun NamedDomainObjectContainer<PluginDeclaration>.registerConventionPlugins(
    domain: String,
    prefix: String
) {
    val conventionID = "convention"
    val conventionPrefix = "$domain.$prefix.$conventionID"
    val conventionPostfix = "ConventionPlugin"

    register("composePlugin") {
        id = "$conventionID.compose"
        implementationClass = "$conventionPrefix.compose.Compose$conventionPostfix"
    }

    register("hiltPlugin") {
        id = "$conventionID.hilt"
        implementationClass = "$conventionPrefix.hilt.Hilt$conventionPostfix"
    }

    register("kotlinPlugin") {
        id = "$conventionID.kotlin"
        implementationClass = "$conventionPrefix.kotlin.Kotlin$conventionPostfix"
    }

    register("navigationPlugin") {
        id = "$conventionID.navigation"
        implementationClass = "$conventionPrefix.navigation.Navigation$conventionPostfix"
    }

    register("networkPlugin") {
        id = "$conventionID.network"
        implementationClass = "$conventionPrefix.network.Network$conventionPostfix"
    }

    register("packagingPlugin") {
        id = "$conventionID.packaging"
        implementationClass = "$conventionPrefix.packaging.Packaging$conventionPostfix"
    }

    register("roomPlugin") {
        id = "$conventionID.room"
        implementationClass = "$conventionPrefix.room.Room$conventionPostfix"
    }

    register("testingPlugin") {
        id = "$conventionID.testing"
        implementationClass = "$conventionPrefix.testing.Testing$conventionPostfix"
    }
}
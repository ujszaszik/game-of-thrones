package hu.ujszaszik.buildlogic.configuration.library

import com.android.build.api.dsl.LibraryExtension
import hu.ujszaszik.buildlogic.common.project.androidLibraryConfig
import hu.ujszaszik.buildlogic.common.project.implementation
import hu.ujszaszik.buildlogic.common.versioncatalog.bundleOf
import hu.ujszaszik.buildlogic.configuration.application.AppConfig
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

@Suppress("UnstableApiUsage")
class LibraryConfigPlugin : Plugin<Project> {

    private val appConfig = AppConfig.defaultConfig

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply(ANDROID_LIBRARY_PLUGIN_ID)
            val extension = extensions.getByType<LibraryExtension>()
            configureLibrary(extension)
        }
    }

    private fun Project.configureLibrary(applicationExtension: LibraryExtension) {
        applicationExtension.apply {
            compileSdk = appConfig.compileSdk

            defaultConfig {
                minSdk = appConfig.minSdk
                testInstrumentationRunner = appConfig.testInstrumentationRunner
            }

            dependencies {
                implementation(bundleOf(ANDROID_LIBS_BUNDLE_ID))
            }
        }
        configureBuildTypes()
    }

    private fun Project.configureBuildTypes() {
        androidLibraryConfig {
            buildTypes {
                debug {
                    isMinifyEnabled = false
                }
                release {
                    isMinifyEnabled = true
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                }
            }
        }
    }

    companion object {
        private const val ANDROID_LIBRARY_PLUGIN_ID = "com.android.library"
        private const val ANDROID_LIBS_BUNDLE_ID = "androidLibs"
    }
}
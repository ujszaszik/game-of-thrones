package hu.ujszaszik.buildlogic.configuration.application

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import hu.ujszaszik.buildlogic.common.project.androidApplicationConfig
import hu.ujszaszik.buildlogic.common.project.implementation
import hu.ujszaszik.buildlogic.common.versioncatalog.bundleOf
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

@Suppress("UnstableApiUsage")
class ApplicationConfigPlugin : Plugin<Project> {

    private val appConfig = AppConfig.defaultConfig

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply(ANDROID_APPLICATION_PLUGIN_ID)
            val extension = extensions.getByType<BaseAppModuleExtension>()
            configureApplication(extension)
        }
    }

    private fun Project.configureApplication(applicationExtension: ApplicationExtension) {
        applicationExtension.apply {
            namespace = appConfig.applicationId
            compileSdk = appConfig.compileSdk

            defaultConfig {
                applicationId = appConfig.applicationId
                minSdk = appConfig.minSdk
                targetSdk = appConfig.targetSdk
                versionCode = appConfig.versionCode
                versionName = appConfig.versionName

                testInstrumentationRunner = appConfig.testInstrumentationRunner
            }

            dependencies {
                implementation(bundleOf(ANDROID_LIBS_BUNDLE_ID))
            }
        }
        configureBuildTypes()
    }

    private fun Project.configureBuildTypes() {
        androidApplicationConfig {
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
        private const val ANDROID_APPLICATION_PLUGIN_ID = "com.android.application"
        private const val ANDROID_LIBS_BUNDLE_ID = "androidLibs"
    }
}
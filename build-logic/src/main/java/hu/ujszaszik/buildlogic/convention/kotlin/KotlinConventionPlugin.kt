package hu.ujszaszik.buildlogic.convention.kotlin

import com.android.build.api.dsl.CommonExtension
import hu.ujszaszik.buildlogic.common.project.getSafeDomainExtensionType
import hu.ujszaszik.buildlogic.common.project.implementation
import hu.ujszaszik.buildlogic.common.versioncatalog.bundleOf
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

class KotlinConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply(ANDROID_KOTLIN_PLUGIN_ID)
            pluginManager.apply(KOTLIN_KAPT_PLUGIN_ID)
            plugins.apply(SERIALIZATION_PLUGIN_ID)
            configureApplication(getSafeDomainExtensionType())
        }
    }

    private fun Project.configureApplication(commonExtension: CommonExtension<*, *, *, *>) {
        commonExtension.apply {
            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_11
                targetCompatibility = JavaVersion.VERSION_11
            }
            kotlinOptions {
                jvmTarget = "11"
            }
            dependencies {
                implementation(bundleOf(KOTLIN_BUNDLE_ID))
            }
        }
    }

    private fun CommonExtension<*, *, *, *>.kotlinOptions(block: KotlinJvmOptions.() -> Unit) {
        (this as ExtensionAware).extensions.configure("kotlinOptions", block)
    }

    companion object {
        private const val ANDROID_KOTLIN_PLUGIN_ID = "org.jetbrains.kotlin.android"
        private const val KOTLIN_KAPT_PLUGIN_ID = "kotlin-kapt"
        private const val SERIALIZATION_PLUGIN_ID = "kotlinx-serialization"
        private const val KOTLIN_BUNDLE_ID = "kotlinLibs"
    }
}
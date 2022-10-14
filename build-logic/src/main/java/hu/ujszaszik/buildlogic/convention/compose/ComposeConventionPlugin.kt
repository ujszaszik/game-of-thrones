package hu.ujszaszik.buildlogic.convention.compose

import com.android.build.api.dsl.CommonExtension
import hu.ujszaszik.buildlogic.common.project.debugImplementation
import hu.ujszaszik.buildlogic.common.project.getSafeDomainExtensionType
import hu.ujszaszik.buildlogic.common.project.implementation
import hu.ujszaszik.buildlogic.common.versioncatalog.bundleOf
import hu.ujszaszik.buildlogic.common.versioncatalog.versionOf
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

@Suppress("UnstableApiUsage")
class ComposeConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            configureCompose(getSafeDomainExtensionType())
        }
    }

    private fun Project.configureCompose(commonExtension: CommonExtension<*, *, *, *>) {
        commonExtension.apply {
            buildFeatures {
                compose = true
            }
            composeOptions {
                kotlinCompilerExtensionVersion = versionOf(COMPOSE_COMPILER_VERSION_ID)
            }
            dependencies {
                implementation(bundleOf(ACCOMPANIST_BUNDLE_ID))
                implementation(bundleOf(COMPOSE_BUNDLE_ID))
                debugImplementation(bundleOf(COMPOSE_DEBUG_BUNDLE_ID))
            }
        }
    }

    companion object {
        private const val COMPOSE_COMPILER_VERSION_ID = "compose-kotlin-compiler"
        private const val ACCOMPANIST_BUNDLE_ID = "accompanistLibs"
        private const val COMPOSE_BUNDLE_ID = "composeLibs"
        private const val COMPOSE_DEBUG_BUNDLE_ID = "composeDebugLibs"
    }
}
package hu.ujszaszik.buildlogic.convention.testing

import com.android.build.api.dsl.CommonExtension
import hu.ujszaszik.buildlogic.common.project.getSafeDomainExtensionType
import hu.ujszaszik.buildlogic.common.project.testImplementation
import hu.ujszaszik.buildlogic.common.versioncatalog.bundleOf
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

@Suppress("UnstableApiUsage")
class TestingConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            configureTesting(getSafeDomainExtensionType())
        }
    }

    private fun Project.configureTesting(commonExtension: CommonExtension<*, *, *, *>) {
        commonExtension.apply {
            testOptions {
                unitTests.isReturnDefaultValues = true
                unitTests.isIncludeAndroidResources = true
                animationsDisabled = true
            }
            dependencies {
                testImplementation(bundleOf(TESTING_BUNDLE_ID))
            }
        }
    }

    companion object {
        private const val TESTING_BUNDLE_ID = "testingLibs"
    }
}
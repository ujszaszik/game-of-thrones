package hu.ujszaszik.buildlogic.convention.navigation

import com.android.build.api.dsl.CommonExtension
import hu.ujszaszik.buildlogic.common.project.getSafeDomainExtensionType
import hu.ujszaszik.buildlogic.common.project.implementation
import hu.ujszaszik.buildlogic.common.versioncatalog.bundleOf
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class NavigationConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            configureNavigation(getSafeDomainExtensionType())
        }
    }

    private fun Project.configureNavigation(commonExtension: CommonExtension<*, *, *, *>) {
        commonExtension.apply {
            dependencies {
                implementation(bundleOf(NAVIGATION_BUNDLE_ID))
            }
        }
    }

    companion object {
        private const val NAVIGATION_BUNDLE_ID = "navigationLibs"
    }
}
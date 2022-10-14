package hu.ujszaszik.buildlogic.convention.network

import com.android.build.api.dsl.CommonExtension
import hu.ujszaszik.buildlogic.common.project.getSafeDomainExtensionType
import hu.ujszaszik.buildlogic.common.project.implementation
import hu.ujszaszik.buildlogic.common.versioncatalog.bundleOf
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class NetworkConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            configureNetwork(getSafeDomainExtensionType())
        }
    }

    private fun Project.configureNetwork(commonExtension: CommonExtension<*, *, *, *>) {
        commonExtension.apply {
            dependencies {
                implementation(bundleOf(NETWORK_BUNDLE_ID))
            }
        }
    }

    companion object {
        private const val NETWORK_BUNDLE_ID = "networkLibs"
    }
}
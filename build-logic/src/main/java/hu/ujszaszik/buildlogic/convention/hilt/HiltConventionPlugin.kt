package hu.ujszaszik.buildlogic.convention.hilt

import com.android.build.api.dsl.CommonExtension
import hu.ujszaszik.buildlogic.common.project.getSafeDomainExtensionType
import hu.ujszaszik.buildlogic.common.project.implementation
import hu.ujszaszik.buildlogic.common.project.kapt
import hu.ujszaszik.buildlogic.common.versioncatalog.bundleOf
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class HiltConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            plugins.apply(HILT_PLUGIN_ID)
            configureHilt(getSafeDomainExtensionType())
        }
    }

    private fun Project.configureHilt(commonExtension: CommonExtension<*, *, *, *>) {
        commonExtension.apply {
            dependencies {
                implementation(bundleOf(HILT_BUNDLE_ID))
                kapt(bundleOf(HILT_KAPT_BUNDLE_ID))
            }
        }
    }

    companion object {
        private const val HILT_PLUGIN_ID = "dagger.hilt.android.plugin"
        private const val HILT_BUNDLE_ID = "hiltLibs"
        private const val HILT_KAPT_BUNDLE_ID = "hiltKaptLibs"
    }
}
package hu.ujszaszik.buildlogic.convention.packaging

import com.android.build.api.dsl.CommonExtension
import hu.ujszaszik.buildlogic.common.project.getSafeDomainExtensionType
import org.gradle.api.Plugin
import org.gradle.api.Project

@Suppress("UnstableApiUsage")
class PackagingConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            configurePackaging(getSafeDomainExtensionType())
        }
    }

    private fun Project.configurePackaging(commonExtension: CommonExtension<*, *, *, *>) {
        commonExtension.apply {
            packagingOptions {
                resources {
                    excludes += "/META-INF/{AL2.0,LGPL2.1}"
                }
                resources.excludes.add("META-INF/*.kotlin_module")
                resources.excludes.add("**/attach_hotspot_windows.dll")
                resources.excludes.add("META-INF/licenses/**")
                resources.excludes.add("META-INF/AL2.0")
                resources.excludes.add("META-INF/LGPL2.1")
            }
        }
    }

}
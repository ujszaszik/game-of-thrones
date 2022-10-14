package hu.ujszaszik.buildlogic.convention.room

import com.android.build.api.dsl.CommonExtension
import hu.ujszaszik.buildlogic.common.project.getSafeDomainExtensionType
import hu.ujszaszik.buildlogic.common.project.implementation
import hu.ujszaszik.buildlogic.common.project.kapt
import hu.ujszaszik.buildlogic.common.versioncatalog.bundleOf
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class RoomConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            configureRoom(getSafeDomainExtensionType())
        }
    }

    private fun Project.configureRoom(commonExtension: CommonExtension<*, *, *, *>) {
        commonExtension.apply {
            dependencies {
                implementation(bundleOf(ROOM_BUNDLE_ID))
                kapt(bundleOf(ROOM_KAPT_BUNDLE_ID))
            }
        }
    }

    companion object {
        private const val ROOM_BUNDLE_ID = "roomLibs"
        private const val ROOM_KAPT_BUNDLE_ID = "roomKaptLibs"
    }
}
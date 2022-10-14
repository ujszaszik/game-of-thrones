package hu.ujszaszik.buildlogic.common.versioncatalog

import org.gradle.api.Project
import org.gradle.api.artifacts.ExternalModuleDependencyBundle
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

private const val LIBS_CATALOG_ID = "libs"

val Project.libs: VersionCatalog
    get() = extensions.getByType<VersionCatalogsExtension>().named(LIBS_CATALOG_ID)

fun Project.versionOf(id: String): String {
    return libs.findVersion(id).get().toString()
}

fun Project.bundleOf(id: String): ExternalModuleDependencyBundle {
    return libs.findBundle(id).get().get()
}
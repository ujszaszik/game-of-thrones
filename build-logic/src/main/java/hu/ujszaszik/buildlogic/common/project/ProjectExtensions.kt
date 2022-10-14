package hu.ujszaszik.buildlogic.common.project

import com.android.build.api.dsl.CommonExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.UnknownDomainObjectException
import org.gradle.api.artifacts.ExternalModuleDependencyBundle
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.getByType

fun Project.getSafeDomainExtensionType(): CommonExtension<*, *, *, *> {
    return try {
        extensions.getByType<BaseAppModuleExtension>()
    } catch (thr: UnknownDomainObjectException) {
        extensions.getByType<LibraryExtension>()
    }
}

fun Project.applyPluginVersion(id: String, versionName: String) {
    pluginManager.findPlugin(id).apply { version = versionName }
}

fun Project.androidApplicationConfig(configure: Action<BaseAppModuleExtension>): Unit =
    (this as ExtensionAware).extensions.configure("android", configure)

fun Project.androidLibraryConfig(configure: Action<LibraryExtension>): Unit =
    (this as ExtensionAware).extensions.configure("android", configure)

fun DependencyHandler.implementation(bundle: ExternalModuleDependencyBundle) =
    bundle.forEach { add("implementation", it.toString()) }

fun DependencyHandler.debugImplementation(bundle: ExternalModuleDependencyBundle) =
    bundle.forEach { add("debugImplementation", it.toString()) }

fun DependencyHandler.kapt(bundle: ExternalModuleDependencyBundle) =
    bundle.forEach { add("kapt", it.toString()) }
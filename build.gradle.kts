buildscript {

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(libs.bundles.classpathLibs)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
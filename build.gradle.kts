// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version Versions.GRADLE apply false
    id("com.android.library") version Versions.GRADLE apply false
    id("com.google.devtools.ksp") version Versions.KOTLIN_KSP apply false
    id("org.jetbrains.kotlin.android") version Versions.KOTLIN apply false
    id("androidx.navigation.safeargs") version Versions.NAVIGATION apply false
}
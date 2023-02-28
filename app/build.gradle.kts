plugins {
    id("com.android.application")
    id("com.google.devtools.ksp")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.kapt")
    id("androidx.navigation.safeargs")
}

@Suppress("UnstableApiUsage")
android {
    namespace = Configs.NAMESPACE
    compileSdk = Configs.Sdk.COMPILER

    defaultConfig {
        applicationId = Configs.APP_ID
        minSdk = Configs.Sdk.MINIMAL
        targetSdk = Configs.Sdk.TARGET
        versionCode = Configs.Version.CODE
        versionName = Configs.Version.NAME
        testInstrumentationRunner = Configs.Tester.INSTRUMENT_RUNNER
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
        debug {
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-dev"
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = freeCompilerArgs + "-opt-in=kotlinx.serialization.ExperimentalSerializationApi"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }

    // KSP - To use generated sources
    kotlin.sourceSets {
        main { kotlin.srcDir("build/generated/ksp/main/kotlin") }
        test { kotlin.srcDir("build/generated/ksp/test/kotlin") }
    }
}

dependencies {
    implementation(Dependencies.Kotlinx.COROUTINE)
    implementation(Dependencies.AndroidX.CORE)
    implementation(Dependencies.AndroidX.APPCOMPAT)
    implementation(Dependencies.AndroidX.CONSTRAINT)
    implementation(Dependencies.AndroidX.SECURITY)
    implementation(Dependencies.AndroidX.LEGACY)
    implementation(Dependencies.AndroidX.Navigation.UI)
    implementation(Dependencies.AndroidX.Navigation.FRAGMENT)
    implementation(Dependencies.AndroidX.Lifecycle.LIVEDATA)
    implementation(Dependencies.AndroidX.Lifecycle.VIEWMODEL)
    implementation(Dependencies.Ui.MATERIAL)

    // Koin Injection
    ksp(Dependencies.Koin.KSP_COMPILER)
    implementation(Dependencies.Koin.ANDROID)
    implementation(Dependencies.Koin.ANNOTATIONS)

    // Ktor Client
    implementation(Dependencies.Ktor.ANDROID)
    implementation(Dependencies.Ktor.LOGGING)
    implementation(Dependencies.Ktor.JSON_SERIALIZATION)
    implementation(Dependencies.Ktor.CONTENT_NEGOTIATION)

    // Test Implementation
    testImplementation(Dependencies.Test.JUNIT)
    androidTestImplementation(Dependencies.Test.JUNIT_ANDROID)
    androidTestImplementation(Dependencies.Test.ESPRESSO)
}
object Dependencies {

    object Kotlinx {
        const val COROUTINE = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINE}"
    }

    object AndroidX {
        const val CORE = "androidx.core:core-ktx:${Versions.CORE}"
        const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.APPCOMPAT}"
        const val CONSTRAINT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT}"
        const val SECURITY = "androidx.security:security-crypto:${Versions.SECURITY}"
        const val LEGACY = "androidx.legacy:legacy-support-v4:${Versions.LEGACY}"

        object Navigation {
            const val UI = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"
            const val FRAGMENT = "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}"
        }

        object Lifecycle {
            const val LIVEDATA = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE}"
            const val VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE}"
        }
    }

    object Ui {
        const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    }

    object Koin {
        const val ANDROID = "io.insert-koin:koin-android:${Versions.KOIN}"
        const val ANNOTATIONS = "io.insert-koin:koin-annotations:${Versions.KOIN_KSP}"
        const val KSP_COMPILER = "io.insert-koin:koin-ksp-compiler:${Versions.KOIN_KSP}"
    }

    object Ktor {
        const val ANDROID = "io.ktor:ktor-client-android:${Versions.KTOR}"
        const val LOGGING = "io.ktor:ktor-client-logging:${Versions.KTOR}"
        const val JSON_SERIALIZATION = "io.ktor:ktor-serialization-kotlinx-json:${Versions.KTOR}"
        const val CONTENT_NEGOTIATION = "io.ktor:ktor-client-content-negotiation:${Versions.KTOR}"
    }

    object Test {
        const val JUNIT = "junit:junit:${Versions.JUNIT}"
        const val JUNIT_ANDROID = "androidx.test.ext:junit:${Versions.JUNIT_ANDROID}"
        const val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"
    }
}
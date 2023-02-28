object Configs {
    const val NAMESPACE = "com.apps"
    const val APP_ID = "com.apps"

    // SDK Versions
    object Sdk {
        const val COMPILER = 33
        const val MINIMAL = 23
        const val TARGET = 33
    }

    // App Version
    object Version {
        private const val MAJOR = 1
        private const val MINOR = 0
        private const val PATCH = 0

        const val CODE = MAJOR * 10000 + MINOR * 1000 + PATCH * 100
        const val NAME = "$MAJOR.$MINOR.$PATCH"
    }

    // Tester
    object Tester {
        const val INSTRUMENT_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
    }
}
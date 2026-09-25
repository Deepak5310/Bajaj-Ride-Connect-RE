plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.bajaj.rideconnect.re"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.bajaj.rideconnect.re"
        minSdk = 27
        targetSdk = 37
        versionCode = 3
        versionName = "3.0.0"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

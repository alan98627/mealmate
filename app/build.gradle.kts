plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.mealmate"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.mealmate"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        // Enable BuildConfig field generation
        buildConfigField("String", "MAPS_API_KEY", "\"${properties["MAPS_API_KEY"]}\"")

        // For manifest placeholder
        manifestPlaceholders["MAPS_API_KEY"] = properties["MAPS_API_KEY"] as? String ?: ""

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.firebase.auth)
    implementation(libs.firebase.firestore)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    implementation ("com.google.android.gms:play-services-auth:20.7.0")
    implementation ("com.github.bumptech.glide:glide:4.16.0")
    implementation ("com.github.dhaval2404:imagepicker:2.1")
    implementation ("com.google.android.gms:play-services-maps:18.2.0")
    implementation ("com.google.android.gms:play-services-location:21.0.1")
    androidTestImplementation(libs.espresso.core)
}
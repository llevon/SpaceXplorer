plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id ("kotlin-kapt")
    id ("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.spacexplorer"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.spacexplorer"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
    }

    kapt {
        correctErrorTypes = true
    }

}

dependencies {

    //hilt
    implementation ("com.google.dagger:hilt-android:2.44")
    implementation(libs.androidx.runtime.android)
    kapt ("com.google.dagger:hilt-compiler:2.44")

    //GraphQL
    implementation("com.apollographql.apollo3:apollo-runtime:3.6.2") 
    implementation("com.apollographql.apollo3:apollo-coroutines-support:3.6.2")

    implementation("androidx.fragment:fragment-ktx:1.7.1")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

kapt {
    correctErrorTypes = true
}
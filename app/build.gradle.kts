plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.kapt")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.example.portioli"
    compileSdk = ConfigVersions.compileSdkVersion

    defaultConfig {
        applicationId = "com.example.portioli"
        minSdk = ConfigVersions.minSdkVersion
        targetSdk = ConfigVersions.targetSdkVersion
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    packaging {
        resources.excludes.addAll(
            listOf(
                "META-INF/LICENSE.md",
                "META-INF/LICENSE-notice.md",
                "META-INF/gradle/incremental.annotation.processors"
                //"/META-INF/{AL2.0,LGPL2.1}"
            )
        )
    }
}

dependencies {

    implementation(Libs.kotlin_std_lib)
    implementation(Libs.fragment)
    implementation(Libs.app_compat)
    implementation(Libs.recyclerview)
    //implementation(Libs.androidx_annotations)
    implementation(Libs.androidx_legacy)

    // Material design
    implementation(Libs.material_design)

    // Constraint layout
    implementation(Libs.constraintLayout)

    // Architectural components
    implementation(Libs.viewmodelKtx)
    implementation(Libs.livedataKtx)
    implementation(Libs.lifecycleRuntime)
    implementation(Libs.runtimeKtx)
    implementation(Libs.lifecycleCompiler)

    // Activity Ktx for viewModels()
    implementation(Libs.activityKtx)

    // Coroutines
    implementation(Libs.coroutines)
    implementation(Libs.coroutinesCore)
    // implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.7.3")
    // implementation(Libs.playServicesCoroutines)


    // Navigation components
    implementation(Libs.navigationFragmentKtx)
    implementation(Libs.navigationUiKtx)

    // Dagger - Hilt
    implementation(Libs.hilt)
    implementation(Libs.hiltCompiler)
    kapt(Libs.androidxHiltCompiler)

    //Firebase
//    implementation(Libs.firebase)
//    // Firebase Firestore
//    implementation("com.google.firebase:firebase-firestore:24.9.1")
//    // Firebase storage
//    implementation("com.google.firebase:firebase-storage:20.3.0")
//    // Firebase BoM
//    implementation(Libs.firebaseBom)
//    // Firebase auth
//    implementation("com.google.firebase:firebase-auth:22.3.0")

    // Glide
    implementation(Libs.glide)
    kapt(Libs.glideCompiler)

    //Viewpager2 indicator
    implementation(Libs.viewPagerIndicator)

    //StepView
    implementation(Libs.stepView)

}
// Non-existent type correction. Needed for Hilt.
kapt {
    correctErrorTypes = true
}
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidMultiplatformLibrary)
}

kotlin {
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "SharedLogic"
            isStatic = true
        }
    }
    
    androidLibrary {
       namespace = "com.reza.news.app.sharedLogic"
       compileSdk = libs.versions.android.compileSdk.get().toInt()
       minSdk = libs.versions.android.minSdk.get().toInt()
    
       compilerOptions {
           jvmTarget = JvmTarget.JVM_11
       }
       androidResources {
           enable = true
       }
       withHostTest {
           isIncludeAndroidResources = true
       }
    }
    
    sourceSets {
        commonMain.dependencies {
            // Network
            api(project(":core:network"))

            // DI (Core Only)
            implementation(libs.koin.core)

            // Lifecycle Core (This allows you to write actual multiplatform ViewModels)
            // Note: Make sure libs.androidx.lifecycle.runtimeCompose points to the core Multiplatform Lifecycle artifact in your TOML if you use it here.
            // Usually, for commonMain ViewModels, you want: "androidx.lifecycle:lifecycle-viewmodel"
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        androidMain.dependencies {
            implementation(libs.koin.android)
        }
        iosMain.dependencies {
        }
    }
}
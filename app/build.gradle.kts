plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.jetbrains.kotlin)
}

android {
  namespace = "com.pedro.streamer"
  compileSdk = 35

  defaultConfig {
    applicationId = "com.pedro.streamer"
    minSdk = 16
    targetSdk = 35
    versionCode = libs.versions.versionCode.get().toInt()
    versionName = libs.versions.versionName.get()
    multiDexEnabled = true
  }
  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
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
    buildConfig = true
  }
}

dependencies {
  implementation(project(":library"))
  implementation(project(":extra-sources"))
  implementation(libs.androidx.constraintlayout)
  implementation(libs.androidx.appcompat)
  implementation(libs.androidx.multidex)
}
allprojects {
  repositories {
    maven { url 'https://jitpack.io' }
  }
}
dependencies {
  implementation 'com.github.pedroSG94.RootEncoder:library:2.6.1'
  //Optional, allow use CameraXSource and CameraUvcSource 
  implementation 'com.github.pedroSG94.RootEncoder:extra-sources:2.6.1'
  classpath 'com.android.tools.build:gradle:8.3.0'
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript{

    val agp_version by extra("8.3.1")
    repositories {
        google()
        mavenCentral()
        maven ( url = "https://jitpack.io" )
    }
}
plugins {
    id("com.android.application") version "8.3.1" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
    id("com.google.dagger.hilt.android") version "2.43.2" apply false
}
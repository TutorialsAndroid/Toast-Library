plugins {
    alias(libs.plugins.android.library)
    id("maven-publish")
}
group= "com.github.TutorialsAndroid"

extra["PUBLISH_GROUP_ID"] = "io.github.tutorialsandroid"
extra["PUBLISH_VERSION"] = "3.0.9"
extra["PUBLISH_ARTIFACT_ID"] = "toastlibrary"

extra["PUBLISH_DESCRIPTION"] = "ToastLib is a lightweight Android library that provides customizable, modern toast messages with icons, colors, gravity control, and clean API usage. It works reliably on Android 11+ using custom layouts instead of deprecated system toast styling."
extra["PUBLISH_URL"] = "https://github.com/TutorialsAndroid/Toast-Library"

extra["PUBLISH_LICENSE_NAME"] = "Apache License"
extra["PUBLISH_LICENSE_URL"] = "https://github.com/TutorialsAndroid/Toast-Library/blob/master/LICENSE"

extra["PUBLISH_DEVELOPER_ID"] = "tutorialsandroid"
extra["PUBLISH_DEVELOPER_NAME"] = "Akshay Masram"
extra["PUBLISH_DEVELOPER_EMAIL"] = "akshaysunilmasram@yahoo.com"

extra["PUBLISH_SCM_CONNECTION"] = "scm:git:github.com/TutorialsAndroid/Toast-Library.git"
extra["PUBLISH_SCM_DEVELOPER_CONNECTION"] =
    "scm:git:ssh://github.com/TutorialsAndroid/Toast-Library.git"
extra["PUBLISH_SCM_URL"] = "https://github.com/TutorialsAndroid/Toast-Library/tree/master"

android {
    namespace = "com.app.toastlibrary"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }

}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.ext.junit)
}
apply(from = "${rootDir}/scripts/publish-module.gradle")
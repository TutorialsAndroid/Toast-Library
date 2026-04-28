# ToastLib

[![](https://jitpack.io/v/TutorialsAndroid/Toast-Library.svg)](https://jitpack.io/#TutorialsAndroid/Toast-Library)

**ToastLib** is a lightweight Android library that provides customizable, modern toast messages with icons, colors, gravity control, and clean API usage. It works reliably on Android 11+ using custom layouts instead of deprecated system toast styling.

---

# ❤️ Support the Project

If you find **ToastLib** useful, please consider supporting the project:

⭐ Star this repository  
🐛 Report issues  
💡 Suggest new features

And don’t forget to follow me on Instagram for more developer content:

📸 https://instagram.com/coderx09

Thanks for your support! 🚀

---

## ✨ Features

* ✅ Success / Error / Info / Default toast variants
* 🎨 Colored rounded backgrounds
* 🧩 Built-in vector icons
* 📍 Custom toast gravity support (TOP / CENTER / BOTTOM)
* 📱 Android 11+ compatible
* 🧼 Clean static API
* ⚡ Lightweight & dependency-free

---

# 📦 Installation (JitPack)

## Step 1: Add JitPack repository

### Latest Android Studio (Gradle Kotlin DSL – settings.gradle.kts)

```kotlin
pluginManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}
```

---

## Step 2: Add dependency

### Using version catalog (libs.versions.toml) – Recommended (Latest Android Studio)

```toml
[versions]
toastlib = "v2.0.0"

[libraries]
toastlib = { module = "com.github.TutorialsAndroid:toastlibrary", version.ref = "toastlib" }
```

Then inside module `build.gradle.kts`

```kotlin
dependencies {
    implementation(libs.toastlib)
}
```

---

## Alternative: Without version catalog

Add inside **app/build.gradle.kts**

```kotlin
dependencies {
    implementation("com.github.TutorialsAndroid:toastlibrary:v2.0.0")
}
```

---

# 🚀 Usage

Import the library

```java
import com.app.toastlibrary.ToastLib;
```

---

## Success Toast

```java
ToastLib.success(this, "Saved successfully");
```

---

## Error Toast

```java
ToastLib.error(this, "Something went wrong");
```

---

## Info Toast

```java
ToastLib.info(this, "Welcome back!");
```

---

## Default Toast

```java
ToastLib.show(this, "Default toast");
```

---

## Custom Gravity Toast

```java
ToastLib.show(
        this,
        "Top message",
        ToastLib.ToastType.INFO,
        Gravity.TOP
);
```

---

# 🎨 Toast Types Available

| Type    | Method             |
| ------- | ------------------ |
| Success | ToastLib.success() |
| Error   | ToastLib.error()   |
| Info    | ToastLib.info()    |
| Default | ToastLib.show()    |

---

# 📱 Compatibility

| Android Version | Supported          |
| --------------- | ------------------ |
| Android 7+      | ✅                  |
| Android 11+     | ✅ Fully compatible |
| Android 15+     | ✅ Tested           |

---

# 🏗 Example Project Setup Structure

```
Project
 ├── app
 ├── toastlibrary
 └── gradle
```

---

# 🧪 Example Implementation Inside Activity

```java
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ToastLib.success(this, "Saved successfully");
    }
}
```

---

# 📌 Why ToastLib?

Android default Toast customization stopped working reliably after Android 11.

ToastLib solves this by:

* Using custom layouts
* Supporting vector icons
* Providing background variants
* Maintaining backward compatibility

---

# 🛠 Roadmap

Upcoming features:

* ⏳ Toast animations
* 🎯 Builder pattern API
* 🌙 Dark mode auto adaptation
* 🎭 Custom icon support API

---

# 🤝 Contributing

Pull requests are welcome!

If you'd like to improve ToastLib:

1. Fork repository
2. Create feature branch
3. Commit changes
4. Submit PR

---

# 📄 License

MIT License

---

# ⭐ Support

If this library helped you, consider giving it a **star ⭐ on GitHub**.

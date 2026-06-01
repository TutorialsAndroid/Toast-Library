# ToastLib

[![](https://jitpack.io/v/TutorialsAndroid/Toast-Library.svg)](https://jitpack.io/#TutorialsAndroid/Toast-Library)
![Platform](https://img.shields.io/badge/platform-Android-brightgreen.svg)
![Language](https://img.shields.io/badge/language-Java-orange.svg)
![License](https://img.shields.io/badge/license-MIT-blue.svg)

**ToastLib** is a lightweight Android Java library for modern, icon-based custom toast messages. It provides clean static APIs, a powerful builder API, custom icons, custom colors, gravity control, duration control, and safe one-toast-at-a-time behavior.

---

## 🚀 What is new in v3.0.0

ToastLib v3.0.0 is a major feature upgrade focused on customization, API flexibility, and production-ready behavior.

### New features

- ✅ New **Warning Toast** type
- ✅ New **Builder API**
- ✅ Custom background color support
- ✅ Custom text color support
- ✅ Custom icon support
- ✅ Icon tint control
- ✅ Hide icon option
- ✅ Custom corner radius
- ✅ Custom padding
- ✅ Custom text size and text style
- ✅ Custom gravity support
- ✅ Custom x/y offset support
- ✅ Short and long duration helpers
- ✅ Top and center toast helper methods
- ✅ `cancelCurrent()` API to manually dismiss active toast
- ✅ One-toast-at-a-time behavior to avoid toast stacking
- ✅ Safer `ApplicationContext` usage internally
- ✅ Backward compatible with old v2.0.0 methods

---

## ✨ Features

- Success / Error / Info / Warning / Normal toast variants
- Beautiful rounded custom layout
- Built-in icon support
- Builder pattern for advanced customization
- Fully Java-based API
- Lightweight and dependency-free library module
- Works with Android apps using Java or Kotlin
- Clean and beginner-friendly usage

---

# 📦 Installation

ToastLib is available through **JitPack**.

## Step 1: Add JitPack repository

Add this inside your root `settings.gradle.kts`:

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

For Groovy `settings.gradle`:

```gradle
pluginManagement {
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

---

## Step 2: Add dependency

### Version catalog

Add this inside `gradle/libs.versions.toml`:

```toml
[versions]
toastlib = "v3.0.0"

[libraries]
toastlib = { module = "com.github.TutorialsAndroid:toastlibrary", version.ref = "toastlib" }
```

Then add this inside your app module `build.gradle.kts`:

```kotlin
dependencies {
    implementation(libs.toastlib)
}
```

### Direct dependency

Kotlin DSL:

```kotlin
dependencies {
    implementation("com.github.TutorialsAndroid:toastlibrary:v3.0.0")
}
```

Groovy:

```gradle
dependencies {
    implementation 'com.github.TutorialsAndroid:toastlibrary:v3.0.0'
}
```

---

# 🚀 Quick Usage

Import ToastLib:

```java
import com.app.toastlibrary.ToastLib;
```

## Success toast

```java
ToastLib.success(this, "Saved successfully");
```

## Error toast

```java
ToastLib.error(this, "Something went wrong");
```

## Info toast

```java
ToastLib.info(this, "Welcome back!");
```

## Warning toast

```java
ToastLib.warning(this, "Please check this action");
```

## Normal toast

```java
ToastLib.show(this, "Default toast");
```

---

# 🎯 Toast Types

| Type | Method |
|---|---|
| Success | `ToastLib.success(context, message)` |
| Error | `ToastLib.error(context, message)` |
| Info | `ToastLib.info(context, message)` |
| Warning | `ToastLib.warning(context, message)` |
| Normal | `ToastLib.show(context, message)` |

---

# 🧩 Builder API

Use the builder API when you need more control.

```java
ToastLib.builder(this)
        .message("Builder API toast")
        .type(ToastLib.ToastType.SUCCESS)
        .longDuration()
        .gravity(Gravity.BOTTOM)
        .cornerRadiusDp(24)
        .paddingDp(18, 14)
        .maxLines(2)
        .show();
```

---

# 🎨 Custom Brand Toast

```java
ToastLib.builder(this)
        .message("Custom brand toast")
        .icon(R.drawable.ic_launcher_foreground)
        .backgroundColor(Color.parseColor("#7C3AED"))
        .textColor(Color.WHITE)
        .iconTint(Color.WHITE)
        .show();
```

---

# 📍 Gravity Examples

## Top toast

```java
ToastLib.top(this, "Top notification", ToastLib.ToastType.INFO);
```

## Center toast

```java
ToastLib.center(this, "Centered alert", ToastLib.ToastType.WARNING);
```

## Manual gravity

```java
ToastLib.show(
        this,
                "Custom gravity toast",
        ToastLib.ToastType.INFO,
        Gravity.TOP
        );
```

---

# ⏱ Duration

```java
ToastLib.longToast(this, "This toast stays longer");
```

Using builder:

```java
ToastLib.builder(this)
        .message("Long builder toast")
        .longDuration()
        .show();
```

---

# 🖼 Icon Options

## Hide icon

```java
ToastLib.builder(this)
        .message("Clean toast without icon")
        .hideIcon()
        .show();
```

## Custom icon without tint

```java
ToastLib.builder(this)
        .message("Custom icon toast")
        .icon(R.drawable.ic_launcher_foreground)
        .disableIconTint()
        .show();
```

---

# 🧼 Cancel Current Toast

ToastLib v3.0.0 automatically cancels the previous toast before showing a new one. You can also manually cancel it:

```java
ToastLib.cancelCurrent();
```

---

# 🧪 Complete Activity Example

```java
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ToastLib.success(this, "Saved successfully");

        ToastLib.builder(this)
                .message("Advanced toast")
                .type(ToastLib.ToastType.INFO)
                .longDuration()
                .gravity(Gravity.TOP)
                .show();
    }
}
```

---

# 📱 Compatibility

| Android Version | Status |
|---|---|
| Android 7+ | Supported |
| Android 11+ | Supported |
| Android 15+ | Tested |
| Java projects | Supported |
| Kotlin projects | Supported |

---

# 📁 Suggested Project Structure

```text
Project
├── app
│   └── sample usage
├── toastlibrary
│   ├── java/com/app/toastlibrary/ToastLib.java
│   └── res/layout/toast_layout.xml
└── README.md
```

---

# 🧱 Migration from v2.0.0 to v3.0.0

No breaking changes for basic usage.

Old code continues to work:

```java
ToastLib.success(this, "Saved successfully");
ToastLib.error(this, "Something went wrong");
ToastLib.info(this, "Welcome back!");
ToastLib.show(this, "Default toast");
```

New code can use:

```java
ToastLib.warning(this, "Please check this");
ToastLib.builder(this)
        .message("Fully customized toast")
        .backgroundColor(Color.BLACK)
        .textColor(Color.WHITE)
        .show();
```

---

# ❤️ Support the Project

If ToastLib helped you, please support the project:

- ⭐ Star the repository
- 🐛 Report bugs
- 💡 Suggest new features
- 🔁 Share it with Android developers

Follow for more Android content:

📸 https://instagram.com/coderx09

---

# 🤝 Contributing

Pull requests are welcome.

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test the sample app
5. Submit a pull request

---

# 📄 License

MIT License

---

# ⭐ Show Your Support

Give this project a star if it helped you.

## Flutter Dynamic App Shortcuts 🚀
---
A complete example showing how to implement Android Dynamic App Shortcuts in a Flutter application using Kotlin. These shortcuts appear when the user long-presses the app icon on the home screen and work reliably across Samsung, Pixel, OnePlus, and other launchers.
---
## ✨ Features
```
📱 Android dynamic shortcuts (runtime-created)

📌 Multiple shortcuts support (Profile, Settings, Notifications, etc.)

🔁 No duplicate shortcut creation

⚡ Instant visibility on long-press

🔗 Ready for Flutter navigation via intent extras

✅ Works with Flutter Embedding v2
```
## 📋 Requirements
```
Flutter 3.x+

Android API 25+ (Android 7.1 and above)

Kotlin enabled Android module

Flutter embedding v2
```
## Preview
![Screenshot_20260106_154106_One_UI_Home 1](https://github.com/user-attachments/assets/ccab7d5e-20c4-4d8d-b9d6-711b5de8b8e9)

## 📂 Project Structure
```
android/
└── app/
└── src/main/
├── AndroidManifest.xml
├── kotlin/com/example/flutter_short_bread/
│ └── MainActivity.kt
```
## 🧩 AndroidManifest.xml Setup
```
<activity
android:name=".MainActivity"
android:exported="true"
android:launchMode="singleTop"
android:theme="@style/LaunchTheme">


<intent-filter>
<action android:name="android.intent.action.MAIN" />
<category android:name="android.intent.category.LAUNCHER" />
</intent-filter>
</activity>
```

## 🧠 MainActivity.kt (Multiple Shortcuts)
```
package com.example.flutter_short_bread


import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import android.os.Build
import io.flutter.embedding.android.FlutterActivity


class MainActivity : FlutterActivity() {


override fun onStart() {
super.onStart()
createDynamicShortcuts()
}


private fun createDynamicShortcuts() {
if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N_MR1) return


val shortcutManager = getSystemService(ShortcutManager::class.java)


// Avoid duplicate creation
if (shortcutManager.dynamicShortcuts.isNotEmpty()) return


val shortcuts = listOf(
ShortcutInfo.Builder(this, "shortcut_profile")
.setShortLabel("Profile")
.setLongLabel("Open Profile")
.setIcon(Icon.createWithResource(this, R.mipmap.ic_launcher))
.setIntent(
Intent(Intent.ACTION_VIEW, null, this, MainActivity::class.java)
.putExtra("shortcut", "profile")
)
.build(),


ShortcutInfo.Builder(this, "shortcut_settings")
.setShortLabel("Settings")
.setLongLabel("Open Settings")
.setIcon(Icon.createWithResource(this, R.mipmap.ic_launcher))
.setIntent(
Intent(Intent.ACTION_VIEW, null, this, MainActivity::class.java)
.putExtra("shortcut", "settings")
)
.build(),


ShortcutInfo.Builder(this, "shortcut_notifications")
.setShortLabel("Notifications")
.setLongLabel("View Notifications")
.setIcon(Icon.createWithResource(this, R.mipmap.ic_launcher))
.setIntent(
Intent(Intent.ACTION_VIEW, null, this, MainActivity::class.java)
.putExtra("shortcut", "notifications")
)
.build()
)


shortcutManager.dynamicShortcuts = shortcuts
}
}
```

## 📌 Android Shortcut Limits
```
🔢 Maximum 5 dynamic shortcuts per app

🆔 Shortcut IDs must be unique

🔄 Shortcuts persist until app uninstall or replaced
```
## ▶️ How to Test
```
Uninstall the app from the device

Run the app once:
---
flutter clean
flutter pub get
flutter run
---
Go to the home screen

Long-press the app icon

Shortcuts will appear 🎉
```
## 📄 License
```
MIT License

Copyright (c) 2025 Excelsior Technologies

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
```

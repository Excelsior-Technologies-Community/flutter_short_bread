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

        // Prevent duplicate shortcuts
        if (shortcutManager.dynamicShortcuts.isNotEmpty()) return

        val shortcuts = mutableListOf<ShortcutInfo>()

        // 🔹 Shortcut 1: Profile
        shortcuts.add(
            ShortcutInfo.Builder(this, "shortcut_profile")
                .setShortLabel("Profile")
                .setLongLabel("Open Profile")
                .setIcon(Icon.createWithResource(this, R.mipmap.ic_launcher))
                .setIntent(
                    Intent(Intent.ACTION_VIEW, null, this, MainActivity::class.java)
                        .putExtra("shortcut", "profile")
                )
                .build()
        )

        // 🔹 Shortcut 2: Settings
        shortcuts.add(
            ShortcutInfo.Builder(this, "shortcut_settings")
                .setShortLabel("Settings")
                .setLongLabel("Open Settings")
                .setIcon(Icon.createWithResource(this, R.mipmap.ic_launcher))
                .setIntent(
                    Intent(Intent.ACTION_VIEW, null, this, MainActivity::class.java)
                        .putExtra("shortcut", "settings")
                )
                .build()
        )

        // 🔹 Shortcut 3: Notifications
        shortcuts.add(
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


//package com.example.flutter_short_bread
//import io.flutter.embedding.android.FlutterActivity
//class MainActivity : FlutterActivity()

package com.bajaj.rideconnect.re

import android.Manifest
import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.TextView

class MainActivity : Activity() {

    private var tvOverlayTitle: TextView? = null
    private var btnGrantOverlay: TextView? = null
    private var tvNotificationTitle: TextView? = null
    private var btnGrantNotification: TextView? = null
    private var tvLocationTitle: TextView? = null
    private var btnGrantLocation: TextView? = null
    private var btnLaunchCoPilot: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (areAllPermissionsGranted()) {
            launchCoPilotAndMaps()
            return
        }

        setContentView(R.layout.activity_main)
        bindViews()
        setupListeners()
    }

    override fun onResume() {
        super.onResume()
        if (areAllPermissionsGranted()) {
            launchCoPilotAndMaps()
        } else {
            updatePermissionStates()
        }
    }

    private fun bindViews() {
        tvOverlayTitle = findViewById(R.id.tvOverlayTitle)
        btnGrantOverlay = findViewById(R.id.btnGrantOverlay)
        tvNotificationTitle = findViewById(R.id.tvNotificationTitle)
        btnGrantNotification = findViewById(R.id.btnGrantNotification)
        tvLocationTitle = findViewById(R.id.tvLocationTitle)
        btnGrantLocation = findViewById(R.id.btnGrantLocation)
        btnLaunchCoPilot = findViewById(R.id.btnLaunchCoPilot)
    }

    private fun setupListeners() {
        btnGrantOverlay?.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                try {
                    val intent = Intent(
                        Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:$packageName")
                    )
                    startActivity(intent)
                } catch (e: Exception) {
                    val fallback = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION)
                    startActivity(fallback)
                }
            }
        }

        btnGrantNotification?.setOnClickListener {
            val intent = Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS)
            startActivity(intent)
        }

        btnGrantLocation?.setOnClickListener {
            requestPermissions(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ),
                RC_LOCATION
            )
        }

        btnLaunchCoPilot?.setOnClickListener {
            if (areAllPermissionsGranted()) {
                launchCoPilotAndMaps()
            } else {
                updatePermissionStates()
            }
        }
    }

    private fun isOverlayGranted(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Settings.canDrawOverlays(this)
        } else {
            true
        }
    }

    private fun isNotificationListenerGranted(): Boolean {
        val flat = Settings.Secure.getString(contentResolver, "enabled_notification_listeners")
        if (!flat.isNullOrEmpty()) {
            val names = flat.split(":")
            for (name in names) {
                val cn = ComponentName.unflattenFromString(name)
                if (cn != null && cn.packageName == packageName) {
                    return true
                }
            }
        }
        return false
    }

    private fun isLocationGranted(): Boolean {
        return checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
    }

    private fun areAllPermissionsGranted(): Boolean {
        return isOverlayGranted() && isNotificationListenerGranted() && isLocationGranted()
    }

    private fun updatePermissionStates() {
        val overlayOk = isOverlayGranted()
        val notifOk = isNotificationListenerGranted()
        val locationOk = isLocationGranted()

        val colorOk = getColor(R.color.pulsar_green)
        val colorAction = getColor(R.color.pulsar_cyan)

        if (overlayOk) {
            btnGrantOverlay?.text = getString(R.string.perm_all_granted)
            btnGrantOverlay?.setTextColor(colorOk)
            btnGrantOverlay?.isEnabled = false
        } else {
            btnGrantOverlay?.text = getString(R.string.perm_overlay_btn)
            btnGrantOverlay?.setTextColor(colorAction)
            btnGrantOverlay?.isEnabled = true
        }

        if (notifOk) {
            btnGrantNotification?.text = getString(R.string.perm_all_granted)
            btnGrantNotification?.setTextColor(colorOk)
            btnGrantNotification?.isEnabled = false
        } else {
            btnGrantNotification?.text = getString(R.string.perm_notification_btn)
            btnGrantNotification?.setTextColor(colorAction)
            btnGrantNotification?.isEnabled = true
        }

        if (locationOk) {
            btnGrantLocation?.text = getString(R.string.perm_all_granted)
            btnGrantLocation?.setTextColor(colorOk)
            btnGrantLocation?.isEnabled = false
        } else {
            btnGrantLocation?.text = getString(R.string.perm_location_btn)
            btnGrantLocation?.setTextColor(colorAction)
            btnGrantLocation?.isEnabled = true
        }

        val allOk = overlayOk && notifOk && locationOk
        btnLaunchCoPilot?.isEnabled = allOk
        btnLaunchCoPilot?.alpha = if (allOk) 1.0f else 0.5f
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == RC_LOCATION) {
            if (areAllPermissionsGranted()) {
                launchCoPilotAndMaps()
            } else {
                updatePermissionStates()
            }
        }
    }

    private fun launchCoPilotAndMaps() {
        Log.i(TAG, "All permissions granted. Launching services & Google Maps.")

        PulsarForegroundService.start(this)
        FloatingHudService.start(this)

        try {
            val mapsIntent = packageManager.getLaunchIntentForPackage("com.google.android.apps.maps")
            if (mapsIntent != null) {
                mapsIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(mapsIntent)
            }
        } catch (e: Exception) {
            Log.w(TAG, "Could not open Google Maps: ${e.message}")
        }

        finish()
    }

    companion object {
        private const val TAG = "MainActivity"
        private const val RC_LOCATION = 101
    }
}

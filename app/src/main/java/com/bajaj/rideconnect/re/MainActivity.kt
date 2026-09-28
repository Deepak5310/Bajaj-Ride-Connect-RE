package com.bajaj.rideconnect.re

import android.Manifest
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import com.bajaj.rideconnect.re.ui.cockpit.CockpitHud
import com.bajaj.rideconnect.re.ui.theme.CockpitBlack
import com.bajaj.rideconnect.re.ui.theme.MyPulsarTheme

class MainActivity : ComponentActivity() {

    private var hasLaunchedCoPilot = false

    private val btPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) {
        checkPermissionsAndProceed()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        checkPermissionsAndProceed()

        setContent {
            MyPulsarTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = CockpitBlack
                ) {
                    CockpitHud(onRequestNotificationPermission = {
                        openNotificationListenerSettings()
                    })
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (!isFinishing && !hasLaunchedCoPilot) {
            checkPermissionsAndProceed()
        }
    }

    private fun hasBluetoothPermissions(): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val connectGranted = ContextCompat.checkSelfPermission(
                this, Manifest.permission.BLUETOOTH_CONNECT
            ) == PackageManager.PERMISSION_GRANTED
            val scanGranted = ContextCompat.checkSelfPermission(
                this, Manifest.permission.BLUETOOTH_SCAN
            ) == PackageManager.PERMISSION_GRANTED
            return connectGranted && scanGranted
        }
        return true
    }

    private fun checkPermissionsAndProceed() {
        if (!hasBluetoothPermissions()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                btPermissionLauncher.launch(
                    arrayOf(
                        Manifest.permission.BLUETOOTH_CONNECT, Manifest.permission.BLUETOOTH_SCAN
                    )
                )
            }
            return
        }

        if (Settings.canDrawOverlays(this)) {
            launchCoPilotAndMaps()
        } else {
            requestOverlayPermission()
        }
    }

    private fun launchCoPilotAndMaps() {
        if (hasLaunchedCoPilot) return
        hasLaunchedCoPilot = true
        if (resources.configuration.orientation != Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, getString(R.string.toast_rotate_landscape), Toast.LENGTH_SHORT)
                .show()
        }
        FloatingHudService.start(this)
        launchGoogleMaps()
        finish()
    }

    private fun requestOverlayPermission() {
        if (!Settings.canDrawOverlays(this)) {
            try {
                val intent = Intent(
                    Settings.ACTION_MANAGE_OVERLAY_PERMISSION, "package:$packageName".toUri()
                )
                startActivity(intent)
            } catch (_: Exception) {
                startActivity(Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION))
            }
        }
    }

    private fun launchGoogleMaps() {
        try {
            val intent = Intent(Intent.ACTION_VIEW, "google.navigation:q=".toUri()).apply {
                setPackage("com.google.android.apps.maps")
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            startActivity(intent)
        } catch (_: ActivityNotFoundException) {
            Toast.makeText(this, getString(R.string.maps_not_installed), Toast.LENGTH_SHORT).show()
        }
    }

    private fun openNotificationListenerSettings() {
        try {
            startActivity(Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS))
        } catch (_: Exception) {
            Toast.makeText(
                this, getString(R.string.notification_settings_not_found), Toast.LENGTH_SHORT
            ).show()
        }
    }
}
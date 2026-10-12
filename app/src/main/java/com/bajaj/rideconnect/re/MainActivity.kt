package com.bajaj.rideconnect.re

import android.Manifest
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.net.toUri

class MainActivity : ComponentActivity() {

    private var hasLaunchedCoPilot = false
    private var hasRequestedPermissions = false
    private var isRequestingPermissions = false
    private var hasRequestedOverlay = false
    private var isRequestingOverlay = false

    private val permissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) {
        isRequestingPermissions = false
        checkPermissionsAndProceed()
    }

    private val overlayPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        isRequestingOverlay = false
        checkPermissionsAndProceed()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkPermissionsAndProceed()
    }

    override fun onResume() {
        super.onResume()
        PulsarNotificationService.requestRebindIfGranted(this)
        if (isFinishing || hasLaunchedCoPilot) return

        if (isRequestingOverlay && Settings.canDrawOverlays(this)) {
            isRequestingOverlay = false
            checkPermissionsAndProceed()
            return
        }

        if (!isRequestingPermissions && !isRequestingOverlay) {
            checkPermissionsAndProceed()
        }
    }

    private fun isGranted(permission: String): Boolean =
        ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED

    private fun hasBluetoothPermissions(): Boolean =
        Build.VERSION.SDK_INT < Build.VERSION_CODES.S || (isGranted(Manifest.permission.BLUETOOTH_CONNECT) && isGranted(
            Manifest.permission.BLUETOOTH_SCAN
        ))

    private fun getMissingPermissions(): List<String> {
        val missing = mutableListOf<String>()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if (!isGranted(Manifest.permission.BLUETOOTH_CONNECT)) missing.add(Manifest.permission.BLUETOOTH_CONNECT)
            if (!isGranted(Manifest.permission.BLUETOOTH_SCAN)) missing.add(Manifest.permission.BLUETOOTH_SCAN)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (!isGranted(Manifest.permission.POST_NOTIFICATIONS)) missing.add(Manifest.permission.POST_NOTIFICATIONS)
        }
        return missing
    }

    private fun checkPermissionsAndProceed() {
        if (isFinishing || hasLaunchedCoPilot || isRequestingPermissions || isRequestingOverlay) return

        if (!hasRequestedPermissions) {
            val missing = getMissingPermissions()
            if (missing.isNotEmpty()) {
                hasRequestedPermissions = true
                isRequestingPermissions = true
                permissionLauncher.launch(missing.toTypedArray())
                return
            }
            hasRequestedPermissions = true
        }

        if (!hasBluetoothPermissions()) {
            Toast.makeText(
                this, getString(R.string.permission_bluetooth_required), Toast.LENGTH_LONG
            ).show()
            finish()
            return
        }

        if (!Settings.canDrawOverlays(this)) {
            if (hasRequestedOverlay) {
                Toast.makeText(
                    this, getString(R.string.permission_overlay_required), Toast.LENGTH_LONG
                ).show()
                finish()
                return
            }
            requestOverlayPermission()
            return
        }

        launchCoPilotAndMaps()
    }

    private fun launchCoPilotAndMaps() {
        if (hasLaunchedCoPilot) return
        hasLaunchedCoPilot = true
        FloatingHudService.start(this)
        launchGoogleMaps()
        finish()
    }

    private fun requestOverlayPermission() {
        if (isRequestingOverlay || Settings.canDrawOverlays(this)) return
        isRequestingOverlay = true
        hasRequestedOverlay = true
        try {
            val intent = Intent(
                Settings.ACTION_MANAGE_OVERLAY_PERMISSION, "package:$packageName".toUri()
            )
            overlayPermissionLauncher.launch(intent)
        } catch (_: Exception) {
            try {
                overlayPermissionLauncher.launch(Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION))
            } catch (_: Exception) {
                isRequestingOverlay = false
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
            try {
                val genericIntent = Intent(Intent.ACTION_VIEW, "geo:0,0?q=".toUri()).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                startActivity(genericIntent)
            } catch (_: Exception) {
                Toast.makeText(this, getString(R.string.maps_not_installed), Toast.LENGTH_SHORT).show()
            }
        }
    }
}
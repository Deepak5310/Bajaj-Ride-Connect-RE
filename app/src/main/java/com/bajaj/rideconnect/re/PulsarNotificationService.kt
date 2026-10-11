package com.bajaj.rideconnect.re

import android.app.Notification
import android.content.ComponentName
import android.content.Context
import android.provider.Settings
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log
import androidx.core.app.NotificationManagerCompat
import java.lang.ref.WeakReference

class PulsarNotificationService : NotificationListenerService() {

    override fun onListenerConnected() {
        super.onListenerConnected()
        Log.i(TAG, "Pulsar Notification Listener connected.")
        notifyUpdate()
    }

    override fun onListenerDisconnected() {
        super.onListenerDisconnected()
        Log.i(TAG, "Pulsar Notification Listener disconnected.")
        notifyUpdate()
    }

    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        handleMediaNotification(sbn)
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification?) {
        handleMediaNotification(sbn)
    }

    private fun handleMediaNotification(sbn: StatusBarNotification?) {
        val notification = sbn?.notification ?: return
        if (notification.extras?.containsKey(Notification.EXTRA_MEDIA_SESSION) == true) {
            notifyUpdate()
        }
    }

    private fun notifyUpdate() {
        sessionListenerRef?.get()?.onMediaSessionUpdate()
    }

    fun interface SessionUpdateListener {
        fun onMediaSessionUpdate()
    }

    companion object {
        private const val TAG = "PulsarNotificationSvc"

        @Volatile
        private var sessionListenerRef: WeakReference<SessionUpdateListener>? = null

        fun setSessionUpdateListener(listener: SessionUpdateListener?) {
            sessionListenerRef = listener?.let { WeakReference(it) }
        }

        fun requestRebindIfGranted(context: Context) {
            if (isNotificationListenerGranted(context)) {
                try {
                    requestRebind(ComponentName(context, PulsarNotificationService::class.java))
                } catch (e: Exception) {
                    Log.w(TAG, "Failed to request rebind: ${e.message}")
                }
            }
        }

        fun isNotificationListenerGranted(context: Context): Boolean {
            val pkgName = context.packageName
            val packages = NotificationManagerCompat.getEnabledListenerPackages(context)
            if (packages.contains(pkgName)) return true

            val flat = Settings.Secure.getString(
                context.contentResolver, "enabled_notification_listeners"
            ) ?: return false
            return flat.split(":").any { name ->
                ComponentName.unflattenFromString(name)?.packageName == pkgName
            }
        }
    }
}
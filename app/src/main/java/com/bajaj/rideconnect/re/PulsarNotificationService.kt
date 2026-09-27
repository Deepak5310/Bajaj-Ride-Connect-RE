package com.bajaj.rideconnect.re

import android.app.Notification
import android.content.ComponentName
import android.content.Context
import android.provider.Settings
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log
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
        sbn ?: return
        val notification = sbn.notification ?: return
        if (notification.extras?.containsKey(Notification.EXTRA_MEDIA_SESSION) == true) {
            notifyUpdate()
        }
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification?) {
        sbn ?: return
        val notification = sbn.notification ?: return
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

        fun isNotificationListenerGranted(context: Context): Boolean {
            val pkgName = context.packageName
            val flat = Settings.Secure.getString(
                context.contentResolver, "enabled_notification_listeners"
            ) ?: return false
            return flat.split(":").any { name ->
                ComponentName.unflattenFromString(name)?.packageName == pkgName
            }
        }
    }
}
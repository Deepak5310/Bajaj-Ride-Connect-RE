package com.bajaj.rideconnect.re

import android.app.Notification
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log

class PulsarNotificationService : NotificationListenerService() {

    override fun onListenerConnected() {
        super.onListenerConnected()
        instance = this
        Log.i(TAG, "Pulsar Notification Listener Connected & Active.")
        PulsarForegroundService.start(this)

        MediaStateListener.instance?.refreshMediaSessions()
        recalculateUnreadMessages()
    }

    override fun onListenerDisconnected() {
        super.onListenerDisconnected()
        instance = null
        Log.i(TAG, "Pulsar Notification Listener Disconnected.")
    }

    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        sbn ?: return

        val notification = sbn.notification
        if (notification?.extras?.containsKey(Notification.EXTRA_MEDIA_SESSION) == true) {
            MediaStateListener.instance?.refreshMediaSessions()
        }

        if (isMessageNotification(sbn)) {
            synchronized(activeMessageKeys) {
                activeMessageKeys.add(sbn.key)
            }
            notifyTelemetry()
        }
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification?) {
        sbn ?: return

        val notification = sbn.notification
        if (notification?.extras?.containsKey(Notification.EXTRA_MEDIA_SESSION) == true) {
            MediaStateListener.instance?.refreshMediaSessions()
        }

        if (isMessageNotification(sbn)) {
            synchronized(activeMessageKeys) {
                activeMessageKeys.remove(sbn.key)
            }
            notifyTelemetry()
        }
    }

    private fun isMessageNotification(sbn: StatusBarNotification?): Boolean {
        val n = sbn?.notification ?: return false
        if (Notification.CATEGORY_MESSAGE == n.category || Notification.CATEGORY_SOCIAL == n.category) {
            return true
        }
        val pkg = sbn.packageName
        if (pkg != null) {
            val lower = pkg.lowercase()
            return lower.contains("messaging") ||
                lower.contains("mms") ||
                lower.contains("sms") ||
                lower.contains("whatsapp") ||
                lower.contains("telegram")
        }
        return false
    }

    private fun recalculateUnreadMessages() {
        try {
            val active = activeNotifications
            if (active != null) {
                synchronized(activeMessageKeys) {
                    activeMessageKeys.clear()
                    for (sbn in active) {
                        if (isMessageNotification(sbn)) {
                            activeMessageKeys.add(sbn.key)
                        }
                    }
                }
                notifyTelemetry()
            }
        } catch (e: Exception) {
            Log.w(TAG, "Error querying active notifications: ${e.message}")
        }
    }

    private fun notifyTelemetry() {
        PhoneStateMonitor.instance?.triggerImmediateUpdate()
    }

    companion object {
        private const val TAG = "PulsarNotificationSvc"

        @Volatile
        @JvmStatic
        var instance: PulsarNotificationService? = null
            private set

        private val activeMessageKeys = HashSet<String>()

        @JvmStatic
        fun getUnreadMessageCount(): Int {
            synchronized(activeMessageKeys) {
                return activeMessageKeys.size
            }
        }
    }
}

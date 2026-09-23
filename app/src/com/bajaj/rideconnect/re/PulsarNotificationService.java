package com.bajaj.rideconnect.re;

import android.app.Notification;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

import java.util.HashSet;
import java.util.Set;

/**
 * Pulsar Notification & Media Session Hook Service.
 * Provides BIND_NOTIFICATION_LISTENER_SERVICE capability required by Android
 * for MediaSessionManager (Spotify, YT Music, etc.) and tracks incoming message/SMS alerts
 * for digital speedometer cluster telemetry (Char 0210).
 */
public class PulsarNotificationService extends NotificationListenerService {

    private static final String TAG = "PulsarNotificationSvc";
    private static PulsarNotificationService instance;
    private static final Set<String> activeMessageKeys = new HashSet<>();

    public static PulsarNotificationService getInstance() {
        return instance;
    }

    public static int getUnreadMessageCount() {
        synchronized (activeMessageKeys) {
            return activeMessageKeys.size();
        }
    }

    @Override
    public void onListenerConnected() {
        super.onListenerConnected();
        instance = this;
        Log.i(TAG, "Pulsar Notification Listener Connected & Active.");
        PulsarForegroundService.start(this);

        MediaStateListener msl = MediaStateListener.getInstance();
        if (msl != null) {
            msl.refreshMediaSessions();
        }
        recalculateUnreadMessages();
    }

    @Override
    public void onListenerDisconnected() {
        super.onListenerDisconnected();
        instance = null;
        Log.i(TAG, "Pulsar Notification Listener Disconnected.");
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        if (sbn == null) return;

        Notification notification = sbn.getNotification();
        if (notification != null && notification.extras != null) {
            if (notification.extras.containsKey(Notification.EXTRA_MEDIA_SESSION)) {
                MediaStateListener msl = MediaStateListener.getInstance();
                if (msl != null) {
                    msl.refreshMediaSessions();
                }
            }
        }

        // Track incoming messages (SMS, messaging apps)
        if (isMessageNotification(sbn)) {
            synchronized (activeMessageKeys) {
                activeMessageKeys.add(sbn.getKey());
            }
            notifyTelemetry();
        }
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        if (sbn == null) return;

        Notification notification = sbn.getNotification();
        if (notification != null && notification.extras != null) {
            if (notification.extras.containsKey(Notification.EXTRA_MEDIA_SESSION)) {
                MediaStateListener msl = MediaStateListener.getInstance();
                if (msl != null) {
                    msl.refreshMediaSessions();
                }
            }
        }

        if (isMessageNotification(sbn)) {
            synchronized (activeMessageKeys) {
                activeMessageKeys.remove(sbn.getKey());
            }
            notifyTelemetry();
        }
    }

    private boolean isMessageNotification(StatusBarNotification sbn) {
        if (sbn == null || sbn.getNotification() == null) return false;
        Notification n = sbn.getNotification();
        if (Notification.CATEGORY_MESSAGE.equals(n.category) ||
            Notification.CATEGORY_SOCIAL.equals(n.category)) {
            return true;
        }
        String pkg = sbn.getPackageName();
        if (pkg != null) {
            String lower = pkg.toLowerCase();
            return lower.contains("messaging") ||
                   lower.contains("mms") ||
                   lower.contains("sms") ||
                   lower.contains("whatsapp") ||
                   lower.contains("telegram");
        }
        return false;
    }

    private void recalculateUnreadMessages() {
        try {
            StatusBarNotification[] active = getActiveNotifications();
            if (active != null) {
                synchronized (activeMessageKeys) {
                    activeMessageKeys.clear();
                    for (StatusBarNotification sbn : active) {
                        if (isMessageNotification(sbn)) {
                            activeMessageKeys.add(sbn.getKey());
                        }
                    }
                }
                notifyTelemetry();
            }
        } catch (Exception e) {
            Log.w(TAG, "Error querying active notifications: " + e.getMessage());
        }
    }

    private void notifyTelemetry() {
        PhoneStateMonitor monitor = PhoneStateMonitor.getInstance();
        if (monitor != null) {
            monitor.triggerImmediateUpdate();
        }
    }
}


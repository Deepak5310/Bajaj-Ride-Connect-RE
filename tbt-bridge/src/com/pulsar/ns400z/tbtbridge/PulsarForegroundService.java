package com.pulsar.ns400z.tbtbridge;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

/**
 * Android 14/15 Compliant Persistent Foreground Service (FOREGROUND_SERVICE_TYPE_CONNECTED_DEVICE).
 * Keeps Bluetooth GATT connection alive, coordinates telemetry, media, and navigation pipelines.
 */
public class PulsarForegroundService extends Service implements PulsarBleManager.BleListener {

    private static final String TAG = "PulsarForegroundService";
    public static final String CHANNEL_ID = "pulsar_connect_live_channel";
    public static final int NOTIFICATION_ID = 4001;

    public static final String ACTION_START = "com.pulsar.ns400z.tbtbridge.START_SERVICE";
    public static final String ACTION_STOP = "com.pulsar.ns400z.tbtbridge.STOP_SERVICE";
    public static final String ACTION_CONNECT = "com.pulsar.ns400z.tbtbridge.CONNECT_BLE";

    private static PulsarForegroundService instance;

    private PulsarBleManager bleManager;
    private MediaStateListener mediaListener;
    private TelephonyCallHandler callHandler;
    private PhoneStateMonitor phoneMonitor;

    private boolean isConnected = false;
    private String activeManeuver = "Navigation Idle";
    private String activeStreet = "--";

    public static PulsarForegroundService getInstance() {
        return instance;
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, PulsarForegroundService.class);
        intent.setAction(ACTION_START);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Log.i(TAG, "PulsarForegroundService onCreate()");

        createNotificationChannel();
        startForegroundWithNotification("Initializing Pulsar Connect...", "Connecting to NS400Z Cluster...");

        bleManager = PulsarBleManager.getInstance(this);
        bleManager.addListener(this);

        mediaListener = new MediaStateListener(this, bleManager);
        callHandler = new TelephonyCallHandler(this, bleManager);
        phoneMonitor = new PhoneStateMonitor(this, bleManager, callHandler);
        phoneMonitor.start();

        // Connect to motorcycle cluster
        bleManager.startScanOrConnect();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null && intent.getAction() != null) {
            String action = intent.getAction();
            if (ACTION_STOP.equals(action)) {
                stopForeground(true);
                stopSelf();
                return START_NOT_STICKY;
            } else if (ACTION_CONNECT.equals(action)) {
                bleManager.startScanOrConnect();
            }
        }
        return START_STICKY;
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "Pulsar NS400Z Live Service",
                    NotificationManager.IMPORTANCE_LOW
            );
            channel.setDescription("Background Bluetooth Link and Real-time Navigation Stream");
            channel.setShowBadge(false);
            NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            if (nm != null) {
                nm.createNotificationChannel(channel);
            }
        }
    }

    private void startForegroundWithNotification(String title, String content) {
        Notification notification = buildNotification(title, content);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            startForeground(NOTIFICATION_ID, notification, ServiceInfo.FOREGROUND_SERVICE_TYPE_CONNECTED_DEVICE);
        } else {
            startForeground(NOTIFICATION_ID, notification);
        }
    }

    private Notification buildNotification(String title, String content) {
        Intent launchIntent = new Intent(this, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(
                this, 0, launchIntent,
                PendingIntent.FLAG_UPDATE_CURRENT | (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M ? PendingIntent.FLAG_IMMUTABLE : 0)
        );

        Notification.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder = new Notification.Builder(this, CHANNEL_ID);
        } else {
            builder = new Notification.Builder(this);
        }

        builder.setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(android.R.drawable.ic_dialog_map)
                .setContentIntent(pi)
                .setOngoing(true);

        return builder.build();
    }

    private void updateNotification() {
        String title = isConnected ? "Pulsar NS400Z: Connected" : "Pulsar NS400Z: Disconnected";
        String content = "Nav: " + activeManeuver + " (" + activeStreet + ")";
        if (mediaListener != null && mediaListener.isPlaying()) {
            content += " | ♫ " + mediaListener.getCurrentTitle();
        }

        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (nm != null) {
            nm.notify(NOTIFICATION_ID, buildNotification(title, content));
        }
    }

    public void updateNavStatus(String maneuver, String street) {
        this.activeManeuver = maneuver;
        this.activeStreet = street;
        updateNotification();
    }

    @Override
    public void onConnectionStateChanged(boolean connected, String deviceName, String deviceAddress) {
        this.isConnected = connected;
        updateNotification();

        // Frames sent while disconnected are dropped by PulsarBleManager, and the
        // cluster loses its now-playing state on every power-cycle/reconnect.
        // Re-push the current media state as soon as the link is up. This fires
        // twice per connection (pre- and post-service-discovery); the first call
        // is dropped harmlessly, the second lands once 0610 is bound.
        if (connected && mediaListener != null) {
            mediaListener.syncMetadata();
        }
    }

    @Override
    public void onPacketSent(String charUuid, byte[] frame, boolean success) {
        // Telemetry/TBT dispatched
    }

    @Override
    public void onHandlebarEvent(PulsarProtocol.HandlebarEvent event) {
        Log.i(TAG, "Handlebar switch event received from cluster!");
        if (mediaListener != null) {
            mediaListener.handleHandlebarMedia(event);
        }
        if (callHandler != null) {
            callHandler.handleHandlebarCallAction(event);
        }
    }

    public void refreshMediaSessions() {
        if (mediaListener != null) {
            mediaListener.initMediaSessions();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        instance = null;
        Log.i(TAG, "PulsarForegroundService onDestroy()");
        if (phoneMonitor != null) {
            phoneMonitor.stop();
        }
        if (bleManager != null) {
            bleManager.removeListener(this);
            bleManager.disconnect();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

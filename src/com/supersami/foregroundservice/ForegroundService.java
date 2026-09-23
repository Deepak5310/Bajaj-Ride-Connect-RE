package com.supersami.foregroundservice;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

/* JADX INFO: loaded from: classes4.dex */
public class ForegroundService extends Service {
    private static Bundle lastNotificationConfig;
    private static ForegroundService mInstance;
    public Bundle taskConfig;
    private int running = 0;
    private Handler handler = new Handler();
    private Runnable runnableCode = new Runnable() { // from class: com.supersami.foregroundservice.ForegroundService.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(ForegroundService.this.getApplicationContext(), (Class<?>) ForegroundServiceTask.class);
            intent.putExtras(ForegroundService.this.taskConfig);
            ForegroundService.this.getApplicationContext().startService(intent);
            ForegroundService.this.taskConfig.getDouble("delay");
            int i = (int) ForegroundService.this.taskConfig.getDouble("loopDelay");
            Log.d("SuperLog", "" + i);
            ForegroundService.this.handler.postDelayed(this, (long) i);
        }
    };

    private boolean ping() {
        return true;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    public static boolean isServiceCreated() {
        try {
            ForegroundService foregroundService = mInstance;
            return foregroundService != null && foregroundService.ping();
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public static ForegroundService getInstance() {
        if (isServiceCreated()) {
            return mInstance;
        }
        return null;
    }

    public int isRunning() {
        return this.running;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.running = 0;
        mInstance = this;
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.handler.removeCallbacks(this.runnableCode);
        this.running = 0;
        mInstance = null;
    }

    private boolean startService(Bundle bundle) {
        try {
            startForeground((int) bundle.getDouble("id"), NotificationHelper.getInstance(getApplicationContext()).buildNotification(getApplicationContext(), bundle));
            this.running++;
            lastNotificationConfig = bundle;
            return true;
        } catch (Exception e) {
            Log.e("ForegroundService", "Failed to start service: " + e.getMessage());
            return false;
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        String action = intent.getAction();
        if (action != null) {
            if (action.equals("com.supersami.foregroundservice.service_start") && intent.getExtras() != null && intent.getExtras().containsKey("com.supersami.foregroundservice.notif_config")) {
                startService(intent.getExtras().getBundle("com.supersami.foregroundservice.notif_config"));
            }
            if (action.equals("com.supersami.foregroundservice.service_update_notification")) {
                if (intent.getExtras() != null && intent.getExtras().containsKey("com.supersami.foregroundservice.notif_config")) {
                    Bundle bundle = intent.getExtras().getBundle("com.supersami.foregroundservice.notif_config");
                    if (this.running <= 0) {
                        Log.d("ForegroundService", "Update Notification called without a running service, trying to restart service.");
                        startService(bundle);
                    } else {
                        try {
                            int i3 = (int) bundle.getDouble("id");
                            Notification notificationBuildNotification = NotificationHelper.getInstance(getApplicationContext()).buildNotification(getApplicationContext(), bundle);
                            getApplicationContext();
                            ((NotificationManager) getSystemService("notification")).notify(i3, notificationBuildNotification);
                            lastNotificationConfig = bundle;
                        } catch (Exception e) {
                            Log.e("ForegroundService", "Failed to update notification: " + e.getMessage());
                        }
                    }
                }
            } else if (action.equals("com.supersami.foregroundservice.service_run_task")) {
                int i4 = this.running;
                if (i4 <= 0 && lastNotificationConfig == null) {
                    Log.e("ForegroundService", "Service is not running to run tasks.");
                    stopSelf();
                    return 2;
                }
                if (i4 <= 0) {
                    Log.d("ForegroundService", "Run Task called without a running service, trying to restart service.");
                    if (!startService(lastNotificationConfig)) {
                        Log.e("ForegroundService", "Service is not running to run tasks.");
                        return 3;
                    }
                }
                if (intent.getExtras() != null && intent.getExtras().containsKey("com.supersami.foregroundservice.task_config")) {
                    Bundle bundle2 = intent.getExtras().getBundle("com.supersami.foregroundservice.task_config");
                    this.taskConfig = bundle2;
                    try {
                        if (bundle2.getBoolean("onLoop")) {
                            this.handler.post(this.runnableCode);
                        } else {
                            runHeadlessTask(this.taskConfig);
                        }
                    } catch (Exception e2) {
                        Log.e("ForegroundService", "Failed to start task: " + e2.getMessage());
                    }
                }
            } else {
                if (action.equals("com.supersami.foregroundservice.service_stop")) {
                    int i5 = this.running;
                    if (i5 > 0) {
                        int i6 = i5 - 1;
                        this.running = i6;
                        if (i6 == 0) {
                            stopSelf();
                            lastNotificationConfig = null;
                        }
                    } else {
                        Log.d("ForegroundService", "Service is not running to stop.");
                        stopSelf();
                        lastNotificationConfig = null;
                    }
                    return 2;
                }
                if (action.equals("com.supersami.foregroundservice.service_all")) {
                    this.running = 0;
                    mInstance = null;
                    lastNotificationConfig = null;
                    stopSelf();
                    return 2;
                }
            }
        }
        return 3;
    }

    public void runHeadlessTask(Bundle bundle) {
        final Intent intent = new Intent(getApplicationContext(), (Class<?>) ForegroundServiceTask.class);
        intent.putExtras(bundle);
        int i = (int) bundle.getDouble("delay");
        if (i <= 0) {
            getApplicationContext().startService(intent);
        } else {
            new Handler().postDelayed(new Runnable() { // from class: com.supersami.foregroundservice.ForegroundService.2
                @Override // java.lang.Runnable
                public void run() {
                    if (ForegroundService.this.running <= 0) {
                        return;
                    }
                    try {
                        ForegroundService.this.getApplicationContext().startService(intent);
                    } catch (Exception e) {
                        Log.e("ForegroundService", "Failed to start delayed headless task: " + e.getMessage());
                    }
                }
            }, i);
        }
    }
}

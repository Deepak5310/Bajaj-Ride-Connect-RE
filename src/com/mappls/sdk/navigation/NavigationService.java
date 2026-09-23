package com.mappls.sdk.navigation;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.mappls.sdk.maps.location.engine.LocationEngine;
import com.mappls.sdk.maps.location.engine.LocationEngineCallback;
import com.mappls.sdk.maps.location.engine.LocationEngineProvider;
import com.mappls.sdk.maps.location.engine.LocationEngineRequest;
import com.mappls.sdk.maps.location.engine.LocationEngineResult;
import com.mappls.sdk.navigation.apis.NavigationLogger;
import com.mappls.sdk.navigation.util.GPSInfo;

/* JADX INFO: loaded from: classes4.dex */
public class NavigationService extends Service implements LocationListener {
    public static final /* synthetic */ int o = 0;
    private int c;
    private String d;
    private int e;
    private Handler f;
    private PendingIntent g;
    private NavigationLocationProvider h;
    private Handler j;
    private LocationEngine k;
    private com.mappls.sdk.navigation.location.d m;
    protected int a = 0;
    private c b = new c();
    private GPSInfo i = new GPSInfo();
    com.mappls.sdk.navigation.location.a l = new com.mappls.sdk.navigation.location.a() { // from class: com.mappls.sdk.navigation.NavigationService$$ExternalSyntheticLambda0
        @Override // com.mappls.sdk.navigation.location.a
        public final void a(GPSInfo gPSInfo) {
            this.f$0.a(gPSInfo);
        }
    };

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    LocationEngineCallback<LocationEngineResult> f707n = new b();

    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            NavigationContext.getNavigationContext().getNotificationHelper().refreshNotifications();
        }
    }

    final class b implements LocationEngineCallback<LocationEngineResult> {
        b() {
        }

        @Override // com.mappls.sdk.maps.location.engine.LocationEngineCallback
        public final void onFailure(Exception exc) {
        }

        @Override // com.mappls.sdk.maps.location.engine.LocationEngineCallback
        public final void onSuccess(LocationEngineResult locationEngineResult) {
            LocationEngineResult locationEngineResult2 = locationEngineResult;
            if ((NavigationService.this.i == null || !NavigationService.this.i.fixed) && MapplsNavigationHelper.getInstance().isGPSCheckEnableForLocationChange()) {
                return;
            }
            NavigationService.this.onLocationChanged(locationEngineResult2.getLastLocation());
        }
    }

    public static class c extends Binder {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(GPSInfo gPSInfo) {
        this.i = gPSInfo;
        NavigationLocationProvider navigationLocationProvider = this.h;
        if (navigationLocationProvider != null) {
            navigationLocationProvider.setSatelliteInfo(gPSInfo);
        }
    }

    protected final Handler a() {
        return this.f;
    }

    public final void a(Context context, int i) {
        int i2 = this.a;
        if ((i2 & i) > 0) {
            this.a = i2 - i;
        }
        if (this.a == 0) {
            NavigationLogger.d("stopIfNeeded", new Object[0]);
            context.stopService(new Intent(context, (Class<?>) NavigationService.class));
        } else {
            NotificationHelper notificationHelper = NavigationContext.getNavigationContext().getNotificationHelper();
            notificationHelper.updateTopNotification();
            notificationHelper.refreshNotifications();
        }
    }

    public final int b() {
        return this.e;
    }

    public final int c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public final int e() {
        return this.a;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.b;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        HandlerThread handlerThread = new HandlerThread("NavigationService");
        handlerThread.start();
        this.j = new Handler(handlerThread.getLooper());
        NavigationLogger.d("onCreate", new Object[0]);
        this.k = LocationEngineProvider.getBestLocationEngine(this);
        this.m = com.mappls.sdk.navigation.location.b.a(this);
        LocationEngineRequest locationEngineRequestBuild = new LocationEngineRequest.Builder(0L).setFastestInterval(0L).setPriority(0).build();
        if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            this.k.requestLocationUpdates(locationEngineRequestBuild, this.f707n, Looper.getMainLooper());
            this.m.a(this.l);
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        NavigationLogger.d("onDestroy", new Object[0]);
        NavigationContext.getNavigationContext().i = null;
        this.a = 0;
        try {
            this.m.a();
        } catch (SecurityException unused) {
            NavigationLogger.d("Location SERVICE permission not granted", new Object[0]);
        }
        if (this.g != null) {
            ((AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(this.g);
        }
        stopForeground(true);
        NavigationContext.getNavigationContext().getNotificationHelper().updateTopNotification();
        NavigationContext navigationContext = NavigationContext.getNavigationContext();
        navigationContext.g.postDelayed(new a(), 500L);
        if (NavigationContext.getNavigationContext().l != null) {
            NavigationContext.getNavigationContext().l.b(false);
            NavigationContext.getNavigationContext().l.a(false);
        }
        this.l = null;
        this.b = null;
        this.d = null;
        Handler handler = this.f;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f = null;
        }
        LocationEngine locationEngine = this.k;
        if (locationEngine != null) {
            locationEngine.removeLocationUpdates(this.f707n);
            this.k = null;
            this.f707n = null;
        }
        this.g = null;
        this.h = null;
        this.i = null;
        Handler handler2 = this.j;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
            this.j = null;
        }
    }

    @Override // android.location.LocationListener
    public final void onLocationChanged(Location location) {
        NavigationLogger.d("onLocationChanged", new Object[0]);
        if (location != null) {
            NavigationContext.getNavigationContext().setCurrentLocation(location);
            NavLocation navLocationConvertLocation = NavigationLocationProvider.convertLocation(location, this);
            if (this.c != 0) {
                LocationEngine locationEngine = this.k;
                if (locationEngine != null) {
                    locationEngine.removeLocationUpdates(this.f707n);
                }
                NavigationLogger.d("Its one time location request releasing wake lock", new Object[0]);
            }
            NavigationLocationProvider navigationLocationProvider = this.h;
            if (navigationLocationProvider != null) {
                navigationLocationProvider.setLocationFromService(location, navLocationConvertLocation, this.c == 0);
            }
        }
    }

    @Override // android.location.LocationListener
    public final void onProviderDisabled(String str) {
    }

    @Override // android.location.LocationListener
    public final void onProviderEnabled(String str) {
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        NavigationLogger.d("onStartCommand", new Object[0]);
        this.f = new Handler();
        NavigationContext.getNavigationContext().k();
        this.a = intent.getIntExtra("SERVICE_USED_BY", 0);
        this.c = intent.getIntExtra("SERVICE_OFF_INTERVAL", 0);
        if ((this.a & 1) != 0) {
            this.c = 0;
        }
        this.d = "gps";
        int i3 = this.c / 5;
        this.e = i3;
        int iMin = Math.min(i3, 720000);
        this.e = iMin;
        int iMax = Math.max(iMin, HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT);
        this.e = iMax;
        this.e = Math.min(iMax, this.c);
        this.h = NavigationContext.getNavigationContext().getLocationProvider();
        NavigationContext.getNavigationContext().i = this;
        if (this.c == 0) {
        } else {
            AlarmManager alarmManager = (AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM);
            this.g = PendingIntent.getBroadcast(this, 0, new Intent(this, (Class<?>) OnNavigationServiceAlarmReceiver.class), Build.VERSION.SDK_INT >= 31 ? 33554432 : 134217728);
            alarmManager.setRepeating(2, SystemClock.elapsedRealtime() + 500, this.c, this.g);
        }
        Notification notificationBuildTopNotification = NavigationContext.getNavigationContext().getNotificationHelper().buildTopNotification();
        if (notificationBuildTopNotification == null) {
            return 3;
        }
        Integer navigationNotificationId = MapplsNavigationHelper.getInstance().getNotificationManagerCallback() != null ? MapplsNavigationHelper.getInstance().getNotificationManagerCallback().getNavigationNotificationId() : null;
        if (navigationNotificationId == null) {
            navigationNotificationId = 100;
        }
        startForeground(navigationNotificationId.intValue(), notificationBuildTopNotification);
        NavigationContext.getNavigationContext().getNotificationHelper().refreshNotifications();
        return 3;
    }

    @Override // android.location.LocationListener
    public final void onStatusChanged(String str, int i, Bundle bundle) {
    }

    @Override // android.app.Service
    public final void onTaskRemoved(Intent intent) {
        if (MapplsNavigationHelper.getInstance().isCloseServiceOnRemovingTask()) {
            NavigationContext.getNavigationContext().getNotificationHelper().removeNotifications();
            if (NavigationContext.getNavigationContext().i != null) {
                NavigationLogger.d("onTaskRemoved", new Object[0]);
                stopSelf();
            }
        }
    }
}

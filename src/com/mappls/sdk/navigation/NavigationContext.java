package com.mappls.sdk.navigation;

import android.app.Activity;
import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.view.accessibility.AccessibilityManager;
import androidx.core.app.ActivityCompat;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.navigation.apis.NavigationLogger;
import com.mappls.sdk.navigation.model.NavigationPath;
import com.mappls.sdk.navigation.routing.NavigationStep;
import com.mappls.sdk.navigation.util.SavingTrackHelper;
import com.mappls.sdk.traffic.db.BeaconDatabase;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class NavigationContext {
    private static NavigationContext w;
    private Context a;
    final c b;
    i f;
    Handler g;
    SavingTrackHelper h;
    NavigationService i;
    NavigationLocationProvider j;
    com.mappls.sdk.navigation.util.b k;
    com.mappls.sdk.navigation.routing.d l;
    com.mappls.sdk.navigation.session.a m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    com.mappls.sdk.navigation.voice.e f705n;
    NotificationHelper o;
    w p;
    com.mappls.sdk.navigation.refresh.i q;
    com.mappls.sdk.navigation.helpers.b r;
    private Locale t;
    private File u;
    private BeaconDatabase v;
    public Location d = null;
    s e = null;
    private Locale s = null;
    private final t c = new t();

    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            while (true) {
                NavigationContext navigationContext = NavigationContext.this;
                if (navigationContext.i == null) {
                    NavigationContext.a(navigationContext);
                    return;
                } else {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                        NavigationLogger.e(e);
                    }
                }
            }
        }
    }

    private NavigationContext(Context context) {
        this.a = context;
        this.b = new c(context);
        new HashMap();
        NavigationLogger.setApplication(this);
    }

    static void a(NavigationContext navigationContext) {
        navigationContext.getClass();
        System.runFinalizersOnExit(true);
        System.exit(0);
    }

    public static NavigationContext getNavigationContext() {
        NavigationContext navigationContext = w;
        if (navigationContext != null) {
            return navigationContext;
        }
        throw new NullPointerException("NavigationContext has not been initialized properly. Call NavigationContext.init(Application) in your Application.onCreate() method and NavigationContext.terminate() in your Application.onTerminate() method.");
    }

    /* JADX WARN: Code duplicated, block: B:36:0x011d  */
    public static void init(Application application) {
        w = new NavigationContext(application);
        MapplsNavigationHelper.getInstance().init(application);
        try {
            com.mappls.sdk.traffic.a.b().a(application);
            w.v = BeaconDatabase.a(application);
        } catch (Exception e) {
            NavigationLogger.e(e);
        }
        w.g = new Handler();
        NavigationContext navigationContext = w;
        i iVar = new i();
        navigationContext.f = iVar;
        iVar.a = new s(application, new com.mappls.sdk.navigation.apis.d(application));
        NavigationContext navigationContext2 = w;
        navigationContext2.e = navigationContext2.f.a;
        navigationContext2.b.a();
        w.e.o();
        NavigationContext navigationContext3 = w;
        navigationContext3.u = navigationContext3.e.h();
        if (!s.a(w.u)) {
            w.getClass();
            NavigationContext navigationContext4 = w;
            navigationContext4.u = navigationContext4.e.j();
        }
        NavigationContext navigationContext5 = w;
        Configuration configuration = navigationContext5.a.getResources().getConfiguration();
        String str = (String) navigationContext5.e.p.get();
        String[] strArrSplit = str.split("_");
        String str2 = strArrSplit[0];
        String str3 = strArrSplit.length > 1 ? strArrSplit[1] : "";
        if (navigationContext5.t == null) {
            navigationContext5.t = Locale.getDefault();
        }
        if ("".equals(str2) || configuration.locale.equals(str)) {
            if ("".equals(str2) && navigationContext5.t != null) {
                Locale locale = Locale.getDefault();
                Locale locale2 = navigationContext5.t;
                if (locale != locale2) {
                    Locale.setDefault(locale2);
                    configuration.locale = navigationContext5.t;
                    navigationContext5.s = null;
                }
            }
            w.b.c();
            if (!((Boolean) w.e.s0.get()).booleanValue()) {
                w.p.b();
            }
            q.a(application);
            NavigationContext navigationContext6 = w;
            navigationContext6.h.clearPreviousData();
            navigationContext6.b.e();
            getNavigationContext().b.b();
        }
        navigationContext5.s = !"".equals(str3) ? new Locale(str2, str3) : new Locale(str2);
        Locale.setDefault(navigationContext5.s);
        configuration.locale = navigationContext5.s;
        navigationContext5.a.getResources().updateConfiguration(configuration, navigationContext5.a.getResources().getDisplayMetrics());
        w.b.c();
        if (!((Boolean) w.e.s0.get()).booleanValue()) {
            w.p.b();
        }
        q.a(application);
        NavigationContext navigationContext7 = w;
        navigationContext7.h.clearPreviousData();
        navigationContext7.b.e();
        getNavigationContext().b.b();
    }

    public static boolean isLocationEnabled(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "location_mode") != 0;
        } catch (Settings.SettingNotFoundException unused) {
            return false;
        }
    }

    public static void terminate() {
        NavigationLogger.setApplication(null);
        if (MapplsNavigationHelper.getInstance().isCloseServiceOnRemovingTask()) {
            MapplsNavigationHelper.getInstance().stopNavigation();
            com.mappls.sdk.navigation.routing.d dVar = w.l;
            if (dVar != null) {
                dVar.o().getClass();
                com.mappls.sdk.navigation.routing.h.h();
            }
            w.getNotificationHelper().removeNotifications();
        }
    }

    public final void a(Runnable runnable) {
        this.g.post(runnable);
    }

    public final boolean a() {
        com.mappls.sdk.navigation.apis.a aVar = (com.mappls.sdk.navigation.apis.a) k().i.get();
        if (aVar == com.mappls.sdk.navigation.apis.a.ON) {
            return true;
        }
        if (aVar == com.mappls.sdk.navigation.apis.a.OFF) {
            return false;
        }
        return ((AccessibilityManager) this.a.getSystemService("accessibility")).isEnabled();
    }

    public final String b() {
        return Build.BRAND + ':' + Build.MODEL + ':' + Settings.Secure.getString(this.a.getContentResolver(), "android_id");
    }

    public final i c() {
        return this.f;
    }

    public void closeApplicationAnywayImpl(Activity activity, boolean z) {
        activity.finish();
        if (this.i == null) {
            System.runFinalizersOnExit(true);
            System.exit(0);
        } else if (z) {
            NavigationLogger.d("closeApplicationAnywayImpl", new Object[0]);
            this.a.stopService(new Intent(this.a, (Class<?>) NavigationService.class));
            new Thread(new a()).start();
        }
    }

    public final BeaconDatabase e() {
        return this.v;
    }

    public final NavigationService f() {
        return this.i;
    }

    public final com.mappls.sdk.navigation.session.a g() {
        return this.m;
    }

    public NavigationPath getCalculatedRoute() {
        NavigationPath navigationPath = new NavigationPath();
        navigationPath.setPath(this.l.k().getImmutableAllLocations());
        return navigationPath;
    }

    public Location getCurrentLocation() {
        if (isLocationEnabled(this.a)) {
            return this.d;
        }
        return null;
    }

    public NavigationLocationProvider getLocationProvider() {
        return this.j;
    }

    public NotificationHelper getNotificationHelper() {
        return this.o;
    }

    public List<NavigationStep> getRouteDirections() {
        return this.l.k().getImmutableAllDirections();
    }

    public final com.mappls.sdk.navigation.routing.d h() {
        return this.l;
    }

    public final com.mappls.sdk.navigation.refresh.i i() {
        return this.q;
    }

    public final SavingTrackHelper j() {
        return this.h;
    }

    public final s k() {
        if (this.e == null) {
            NavigationLogger.e("Trying to access settings before they were created", new Object[0]);
        }
        return this.e;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002d  */
    public final int l() {
        boolean z;
        boolean z2 = PreferenceManager.getDefaultSharedPreferences(this.a).getBoolean("bluetooth_phone_call_switch_preference", false);
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (ActivityCompat.checkSelfPermission(this.a, "android.permission.BLUETOOTH_CONNECT") == 0 && defaultAdapter != null && defaultAdapter.isEnabled()) {
            z = defaultAdapter.getProfileConnectionState(1) == 2;
        }
        return (z2 && z) ? 0 : 3;
    }

    public final w m() {
        return this.p;
    }

    public final t n() {
        return this.c;
    }

    public final com.mappls.sdk.navigation.helpers.b o() {
        return this.r;
    }

    public void onAutoDriveEnabled() {
        p locationSimulation = getLocationProvider().getLocationSimulation();
        com.mappls.sdk.navigation.routing.d dVar = this.l;
        if (locationSimulation.a() || !dVar.q() || !dVar.t() || dVar.s()) {
            return;
        }
        locationSimulation.c();
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.s == null || configuration.locale.getLanguage().equals(this.s.getLanguage())) {
            return;
        }
        this.a.getResources().updateConfiguration(configuration, this.a.getResources().getDisplayMetrics());
        Locale.setDefault(this.s);
    }

    public final void p() {
        this.g.post(new j());
    }

    public final void q() {
        this.g.post(new k());
    }

    public void setCurrentLocation(Location location) {
        this.d = location;
    }

    public void stopNavigation() {
        NavigationLogger.d("stopNavigation", new Object[0]);
        if (this.j.getLocationSimulation().a()) {
            this.j.getLocationSimulation().d();
        }
        this.p.b();
        this.l.o().getClass();
        com.mappls.sdk.navigation.routing.h.d();
        this.l.a((String) null, (List<LatLng>) new ArrayList(), true);
        this.l.b(false);
        this.l.a(false);
        d unused = s.this.H0;
        s sVar = this.e;
        s.t<d> tVar = sVar.I0;
        d dVar = (d) ((s.j) sVar.A0).get();
        s.g gVar = (s.g) tVar;
        gVar.getClass();
        gVar.set(dVar);
        this.p.a(false);
        NavigationService navigationService = this.i;
        if (navigationService != null) {
            navigationService.stopSelf();
        }
    }

    public final void a(int i, int i2) {
        Intent intent = new Intent(this.a, (Class<?>) NavigationService.class);
        if (this.i != null) {
            NavigationLogger.d("startNavigationService", new Object[0]);
            NavigationService navigationService = this.i;
            i |= navigationService.a;
            i2 = Math.min(navigationService.c(), i2);
            this.i.stopSelf();
        }
        intent.putExtra("SERVICE_USED_BY", i);
        intent.putExtra("SERVICE_OFF_INTERVAL", i2);
        this.a.startService(intent);
    }

    public final File d() {
        return new File(this.u, "nav_track/recordings/");
    }
}

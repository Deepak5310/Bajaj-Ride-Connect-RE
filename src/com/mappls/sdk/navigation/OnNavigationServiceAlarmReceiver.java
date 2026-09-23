package com.mappls.sdk.navigation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mappls.sdk.navigation.apis.NavigationLogger;

/* JADX INFO: loaded from: classes4.dex */
public class OnNavigationServiceAlarmReceiver extends BroadcastReceiver {

    final class a implements Runnable {
        final /* synthetic */ LocationManager a;
        final /* synthetic */ NavigationService b;

        a(LocationManager locationManager, NavigationService navigationService) {
            this.a = locationManager;
            this.b = navigationService;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.removeUpdates(this.b);
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        NavigationService navigationService = NavigationContext.getNavigationContext().i;
        LocationManager locationManager = (LocationManager) navigationService.getSystemService(FirebaseAnalytics.Param.LOCATION);
        try {
            locationManager.requestLocationUpdates(navigationService.d(), 0L, 0.0f, navigationService);
            if (navigationService.c() > navigationService.b()) {
                navigationService.a().postDelayed(new a(locationManager, navigationService), navigationService.b());
            }
        } catch (RuntimeException e) {
            NavigationLogger.d(e);
            e.printStackTrace();
        }
    }
}

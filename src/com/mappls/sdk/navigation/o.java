package com.mappls.sdk.navigation;

import com.google.android.gms.common.ConnectionResult;
import com.mappls.sdk.navigation.apis.NavigationLogger;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class o extends Thread {
    final /* synthetic */ List a;
    final /* synthetic */ boolean b = false;
    final /* synthetic */ float c = 1.0f;
    final /* synthetic */ p d;

    final class a implements Runnable {
        final /* synthetic */ NavLocation a;

        a(NavLocation navLocation) {
            this.a = navLocation;
        }

        @Override // java.lang.Runnable
        public final void run() {
            o.this.d.b.setLocationFromSimulation(this.a);
        }
    }

    o(p pVar, ArrayList arrayList) {
        this.d = pVar;
        this.a = arrayList;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        NavLocation navLocation;
        float fMax;
        NavLocation navLocation2 = this.a.isEmpty() ? null : new NavLocation((NavLocation) this.a.remove(0));
        long time = navLocation2 == null ? 0L : navLocation2.getTime();
        p pVar = this.d;
        List list = this.a;
        pVar.getClass();
        float fMax2 = list.isEmpty() ? 20.0f : Math.max(20.0f, navLocation2.distanceTo((NavLocation) list.get(0)) / 2.0f);
        while (!this.a.isEmpty() && this.d.a != null) {
            boolean z = this.b;
            int time2 = ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;
            float time3 = 1.5f;
            if (z) {
                navLocation = (NavLocation) this.a.remove(0);
                fMax = navLocation.distanceTo(navLocation2);
                if (!this.a.isEmpty()) {
                    time2 = (int) (((NavLocation) this.a.get(0)).getTime() - navLocation.getTime());
                    time3 = (navLocation.getTime() - time) / 1000.0f;
                    time = navLocation.getTime();
                }
            } else if (navLocation2.distanceTo((NavLocation) this.a.get(0)) > fMax2) {
                fMax = fMax2;
                navLocation = p.a(navLocation2, (NavLocation) this.a.get(0), fMax2);
            } else {
                navLocation = new NavLocation((NavLocation) this.a.remove(0));
                p pVar2 = this.d;
                List list2 = this.a;
                pVar2.getClass();
                fMax = list2.isEmpty() ? 20.0f : Math.max(20.0f, navLocation.distanceTo((NavLocation) list2.get(0)) / 2.0f);
            }
            if (time3 != 0.0f) {
                navLocation.setSpeed((fMax / time3) * this.c);
            }
            navLocation.setTime(System.currentTimeMillis());
            if (!navLocation.hasAccuracy() || Double.isNaN(navLocation.getAccuracy())) {
                navLocation.setAccuracy(5.0f);
            }
            if (navLocation2 != null && navLocation2.distanceTo(navLocation) > 3.0f) {
                navLocation.setBearing(navLocation2.bearingTo(navLocation));
            }
            NavigationContext.getNavigationContext().g.post(new a(navLocation));
            try {
                Thread.sleep((long) (time2 / this.c));
            } catch (InterruptedException e) {
                NavigationLogger.d(e);
            }
            navLocation2 = navLocation;
            fMax2 = fMax;
        }
        this.d.d();
    }
}

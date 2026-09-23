package com.google.android.libraries.navigation.internal.xe;

import android.content.Context;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.google.android.libraries.navigation.RoadSnappedLocationProvider;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fx implements RoadSnappedLocationProvider {
    private final c a;
    private final com.google.android.libraries.navigation.internal.vt.d b;

    public fx(com.google.android.libraries.navigation.internal.vt.d dVar, Context context, com.google.android.libraries.navigation.internal.ia.b bVar, ScheduledExecutorService scheduledExecutorService) {
        this.b = dVar;
        this.a = new g(context, bVar, new h(context), scheduledExecutorService);
    }

    @Override // com.google.android.libraries.navigation.RoadSnappedLocationProvider
    public final synchronized void addLocationListener(RoadSnappedLocationProvider.LocationListener locationListener) {
        try {
            try {
                c cVar = this.a;
                if (((g) cVar).d.compareAndSet(false, true)) {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("com.google.android.libraries.navigation.EVENT_TRACK_HANDSHAKE_DRIVER");
                    intentFilter.addAction("com.google.android.libraries.navigation.EVENT_TRACK_START_RECORDING");
                    intentFilter.addAction("com.google.android.libraries.navigation.EVENT_TRACK_STOP_RECORDING");
                    intentFilter.addAction("com.google.android.libraries.navigation.EVENT_TRACK_COLLECT_DUMP");
                    try {
                        ContextCompat.registerReceiver(((g) cVar).b, ((g) cVar).f, intentFilter, 4);
                        ((g) cVar).c();
                    } catch (RuntimeException unused) {
                        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1997)).p("Failed to start receiver.");
                    }
                }
                this.b.b(new fw(locationListener));
            } catch (Error e) {
                e = e;
                com.google.android.libraries.navigation.environment.b.c(e);
                throw e;
            }
        } catch (RuntimeException e2) {
            e = e2;
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.RoadSnappedLocationProvider
    public final synchronized void removeLocationListener(RoadSnappedLocationProvider.LocationListener locationListener) {
        try {
            this.a.a();
            this.b.c(new fw(locationListener));
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.navigation.RoadSnappedLocationProvider
    public final void resetFreeNav() {
        try {
            this.b.a();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }
}

package com.google.android.libraries.navigation.internal.dh;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.mappls.sdk.navigation.NavigationConstants;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class af {
    public final com.google.android.libraries.navigation.internal.ia.e a;
    private final ah b;

    public af(com.google.android.libraries.navigation.internal.ia.e eVar, SensorManager sensorManager, bn bnVar, com.google.android.libraries.navigation.internal.mj.a aVar) {
        this.a = eVar;
        this.b = new ah(new ae(this), sensorManager, bnVar, aVar);
    }

    public final void a() {
        com.google.android.libraries.navigation.internal.ra.c.g.f();
        ah ahVar = this.b;
        ahVar.m = false;
        ahVar.h.cancel(false);
        if (ahVar.h.isDone() && !ahVar.h.isCancelled()) {
            try {
                com.google.android.libraries.navigation.internal.aac.az.n(ahVar.h);
            } catch (ExecutionException unused) {
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 390)).p("Encountered exception when flushing sensors.");
            }
        }
        ahVar.a.unregisterListener(ahVar);
        ahVar.l = true;
        ahVar.q = 0L;
        ahVar.b(ahVar.j / 1000000);
        ahVar.j = 0L;
        ahVar.k = false;
        ahVar.p = 0.0f;
        ahVar.o = 0.0f;
    }

    public final boolean b(com.google.android.libraries.navigation.internal.kl.a aVar) {
        com.google.android.libraries.navigation.internal.ra.c.g.f();
        ah ahVar = this.b;
        ahVar.i = aVar;
        Sensor sensor = ahVar.c;
        boolean z = false;
        boolean z2 = sensor == null;
        ahVar.f395n = z2;
        Sensor sensor2 = z2 ? ahVar.d : sensor;
        if (sensor2 == null || sensor == null || ahVar.f == null || ahVar.e == null) {
            Sensor sensor3 = ahVar.d;
            Sensor sensor4 = ahVar.f;
            Sensor sensor5 = ahVar.e;
            ahVar.m = true;
        } else {
            ahVar.r = ahVar.b.a() - ahVar.b.e().toMillis();
            ahVar.l = true;
            ahVar.a();
            Handler handler = new Handler();
            boolean zRegisterListener = ahVar.a.registerListener(ahVar, sensor2, NavigationConstants.UI_HANDLER_LOCATION_SERVICE, 500000, handler);
            Sensor sensor6 = ahVar.e;
            if (sensor6 != null) {
                zRegisterListener &= ahVar.a.registerListener(ahVar, sensor6, AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH, 500000, handler);
            }
            Sensor sensor7 = ahVar.f;
            if (sensor7 != null) {
                zRegisterListener = ahVar.a.registerListener(ahVar, sensor7, AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH, 500000, handler) & zRegisterListener;
            }
            Sensor sensor8 = ahVar.g;
            if (sensor8 != null) {
                ahVar.a.registerListener(ahVar, sensor8, AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH, 500000, handler);
            }
            ahVar.m = true;
            ahVar.c();
            z = zRegisterListener;
        }
        com.google.android.apps.gmm.location.navigation.ap.a(aVar, 11, z);
        return z;
    }
}

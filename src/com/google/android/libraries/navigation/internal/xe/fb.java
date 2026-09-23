package com.google.android.libraries.navigation.internal.xe;

import com.google.android.libraries.navigation.ArrivalEvent;
import com.google.android.libraries.navigation.Navigator;
import com.google.android.libraries.navigation.Waypoint;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fb {
    private final Navigator.ArrivalListener a;

    public fb(Navigator.ArrivalListener arrivalListener) {
        this.a = arrivalListener;
    }

    public final void a(com.google.android.libraries.navigation.internal.bp.ck ckVar, boolean z) {
        try {
            this.a.onArrival(new ArrivalEvent(new Waypoint(ckVar), z));
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }
}

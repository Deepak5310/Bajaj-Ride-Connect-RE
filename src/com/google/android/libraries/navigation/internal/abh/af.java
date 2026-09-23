package com.google.android.libraries.navigation.internal.abh;

import android.os.RemoteException;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class af {
    public static final String a = "af";
    public final Executor b;
    public final com.google.android.libraries.navigation.internal.abf.z c;
    public boolean d;
    public boolean e;
    public int f;
    public int g;
    public com.google.android.libraries.navigation.internal.ly.z h;
    public com.google.android.libraries.navigation.internal.ly.ab i;
    public com.google.android.libraries.navigation.internal.ly.ad j;
    public final CopyOnWriteArraySet k;
    private com.google.android.libraries.navigation.internal.ly.x l;

    public af() {
        Executor executorA = com.google.android.libraries.navigation.internal.abf.ah.a();
        com.google.android.libraries.navigation.internal.abf.z zVar = com.google.android.libraries.navigation.internal.abf.z.a;
        this.b = executorA;
        com.google.android.libraries.navigation.internal.abf.s.k(zVar, "uiThreadChecker");
        this.c = zVar;
        this.d = false;
        this.e = false;
        this.f = -1;
        synchronized (this) {
            this.g = 0;
        }
        this.l = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = new CopyOnWriteArraySet();
    }

    public final void a() {
        if (f()) {
            return;
        }
        this.f = -1;
        com.google.android.libraries.navigation.internal.ly.x xVar = this.l;
        if (xVar != null) {
            try {
                ((com.google.android.gms.maps.w) xVar).a.onCameraIdle();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
    }

    public final void b(com.google.android.libraries.navigation.internal.ly.x xVar) {
        this.c.a();
        this.l = xVar;
    }

    public final void c(com.google.android.libraries.navigation.internal.ly.z zVar) {
        this.c.a();
        this.h = zVar;
    }

    public final void d(com.google.android.libraries.navigation.internal.ly.ab abVar) {
        this.c.a();
        this.i = abVar;
    }

    public final void e(com.google.android.libraries.navigation.internal.ly.ad adVar) {
        this.c.a();
        this.j = adVar;
    }

    public final boolean f() {
        return this.d || this.e;
    }
}

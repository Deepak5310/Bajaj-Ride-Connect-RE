package com.google.android.libraries.navigation.internal.abm;

import android.os.RemoteException;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.libraries.navigation.internal.abh.el;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ap {
    public final com.google.android.libraries.navigation.internal.abf.z a;
    public final dl b;
    public final el c;
    public final ac d;
    public final Map e;
    public com.google.android.libraries.navigation.internal.ly.av f;
    public com.google.android.libraries.navigation.internal.ly.az g;
    public com.google.android.libraries.navigation.internal.ly.bn h;
    public final f i;
    public com.google.android.libraries.navigation.internal.ol.z j;

    public ap(dl dlVar, el elVar, com.google.android.libraries.navigation.internal.abf.z zVar, f fVar) {
        this.b = dlVar;
        this.c = elVar;
        com.google.android.libraries.navigation.internal.abf.s.k(zVar, "MapEventManagerPhoenix.uiThreadChecker");
        this.a = zVar;
        this.i = fVar;
        this.d = new ac(dlVar);
        this.f = null;
        this.g = null;
        this.e = new HashMap();
    }

    public final void a(com.google.android.libraries.navigation.internal.oe.x xVar) {
        this.a.a();
        com.google.android.libraries.navigation.internal.abf.s.k(xVar, "point");
        com.google.android.libraries.navigation.internal.ly.az azVar = this.g;
        if (azVar == null) {
            return;
        }
        try {
            azVar.a(f.d(xVar.t()));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void b() {
        this.d.f();
    }
}

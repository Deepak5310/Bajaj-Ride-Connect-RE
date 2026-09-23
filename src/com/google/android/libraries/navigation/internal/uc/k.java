package com.google.android.libraries.navigation.internal.uc;

import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.al;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class k {
    public final g a;
    public final Float b;
    public final Float c;
    public final boolean d;
    public final com.google.android.libraries.navigation.internal.ue.b e;

    protected k(j jVar) {
        g gVar = jVar.a;
        ar.q(gVar);
        this.a = gVar;
        this.b = jVar.b;
        this.c = jVar.c;
        this.d = jVar.d;
        this.e = jVar.e;
    }

    public j a() {
        return new j(this);
    }

    protected ak b() {
        ak akVarB = al.b(this);
        akVarB.g("cameraMode", this.a);
        akVarB.g("zoomOverride", this.b);
        akVarB.g("tiltOverride", this.c);
        ak akVarE = akVarB.e("skipCameraAnimations", this.d);
        akVarE.g("compassModeOverride", this.e);
        return akVarE;
    }

    public final Float c() {
        if (this.a.a()) {
            return this.b;
        }
        return null;
    }

    public final String toString() {
        return b().toString();
    }
}

package com.google.android.libraries.navigation.internal.abn;

import com.google.android.gms.maps.model.CameraPosition;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ak implements v {
    boolean a;
    private final float b;
    private final ac c;
    private final long d;
    private final c e;
    private final int f;
    private v g;
    private CameraPosition h;
    private boolean i;

    public ak(float f, ac acVar, long j, c cVar) {
        synchronized (this) {
            this.b = f;
            this.c = acVar;
            this.d = j;
            this.e = cVar;
            this.f = 1;
            this.g = null;
            this.h = null;
            this.i = false;
            this.a = false;
        }
    }

    private final synchronized void b(be beVar) {
        CameraPosition cameraPositionE;
        ac acVar = this.c;
        CameraPosition cameraPositionF = beVar.f();
        if (acVar == null) {
            CameraPosition.Builder builder = CameraPosition.builder(cameraPositionF);
            builder.zoom(cameraPositionF.zoom + this.b);
            cameraPositionE = builder.build();
        } else {
            cameraPositionE = beVar.e(cameraPositionF, this.b, this.c, this.e);
        }
        CameraPosition cameraPosition = cameraPositionE;
        long j = this.d;
        this.g = j == 0 ? new ax(cameraPosition, true, this.f) : new aj(cameraPosition, true, true, j, this.f);
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final int a() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final synchronized CameraPosition c(be beVar, long j) {
        CameraPosition cameraPositionC;
        if (this.g == null) {
            b(beVar);
        }
        cameraPositionC = this.g.c(beVar, j);
        this.h = cameraPositionC;
        return cameraPositionC;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final CameraPosition d() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final /* synthetic */ com.google.android.libraries.navigation.internal.pd.e e() {
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x003f  */
    public final synchronized boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ak)) {
            return false;
        }
        ak akVar = (ak) obj;
        synchronized (akVar) {
            if (this.b == akVar.b && com.google.android.libraries.navigation.internal.abf.r.a(this.c, akVar.c) && this.d == akVar.d && com.google.android.libraries.navigation.internal.abf.r.a(this.g, akVar.g)) {
                boolean z2 = akVar.i;
                if (this.f == akVar.f) {
                    boolean z3 = akVar.a;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
        }
        return z;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final com.google.android.libraries.navigation.internal.abf.q f() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final synchronized void h(boolean z) {
    }

    public final synchronized int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.b), this.c, Long.valueOf(this.d), this.g, false, false, Integer.valueOf(this.f)});
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final synchronized boolean i() {
        return this.g.i();
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final boolean j() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final synchronized boolean k(CameraPosition cameraPosition, be beVar) {
        return this.g.k(cameraPosition, beVar);
    }

    public final synchronized String toString() {
        com.google.android.libraries.navigation.internal.abf.aj ajVarD;
        com.google.android.libraries.navigation.internal.abf.aj ajVarB = com.google.android.libraries.navigation.internal.abf.aj.f(this).b("zoomBy", this.b);
        ajVarB.g("focusPixel", this.c);
        ajVarD = ajVarB.d("durationMs", this.d);
        ajVarD.g("actualAnimation", this.g);
        return ajVarD.e("hasReachedClampingLimit", false).c("animationReason", this.f).e("isOuterExhausted", false).toString();
    }
}

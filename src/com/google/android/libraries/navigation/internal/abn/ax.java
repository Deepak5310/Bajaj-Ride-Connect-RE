package com.google.android.libraries.navigation.internal.abn;

import com.google.android.gms.maps.model.CameraPosition;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ax implements v {
    private final CameraPosition a;
    private final boolean b;
    private final int d;
    private final boolean c = true;
    private boolean f = false;
    private CameraPosition e = null;

    public ax(CameraPosition cameraPosition, boolean z, int i) {
        this.a = cameraPosition;
        this.b = z;
        this.d = i;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final int a() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final CameraPosition c(be beVar, long j) {
        CameraPosition cameraPositionF = beVar.f();
        this.e = cameraPositionF;
        if (com.google.android.libraries.navigation.internal.abf.r.a(cameraPositionF, this.a)) {
            this.f = true;
        }
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final CameraPosition d() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final /* synthetic */ com.google.android.libraries.navigation.internal.pd.e e() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ax)) {
            return false;
        }
        ax axVar = (ax) obj;
        if (com.google.android.libraries.navigation.internal.abf.r.a(this.a, axVar.a) && this.b == axVar.b) {
            boolean z = axVar.c;
            if (this.d == axVar.d) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final com.google.android.libraries.navigation.internal.abf.q f() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final void h(boolean z) {
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Boolean.valueOf(this.b), true, Integer.valueOf(this.d)});
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final boolean i() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final boolean j() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final boolean k(CameraPosition cameraPosition, be beVar) {
        if (com.google.android.libraries.navigation.internal.abf.r.a(this.e, cameraPosition)) {
            this.f = true;
        }
        return true;
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.abf.aj ajVarF = com.google.android.libraries.navigation.internal.abf.aj.f(this);
        ajVarF.g(FirebaseAnalytics.Param.DESTINATION, this.a);
        return ajVarF.e("isUserGesture", this.b).e("allowClamp", true).c("animationReason", this.d).toString();
    }
}

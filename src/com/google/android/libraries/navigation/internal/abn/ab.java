package com.google.android.libraries.navigation.internal.abn;

import com.google.android.gms.maps.model.CameraPosition;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ab implements v, w {
    public final v a;
    private volatile boolean b = false;

    public ab(v vVar) {
        this.a = vVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final int a() {
        return this.a.a();
    }

    public final void b() {
        this.b = true;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final CameraPosition c(be beVar, long j) {
        CameraPosition cameraPositionC = this.a.c(beVar, j);
        if (this.b) {
            return null;
        }
        return cameraPositionC;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final CameraPosition d() {
        return this.a.d();
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final /* synthetic */ com.google.android.libraries.navigation.internal.pd.e e() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ab)) {
            return false;
        }
        ab abVar = (ab) obj;
        return com.google.android.libraries.navigation.internal.abf.r.a(this.a, abVar.a) && com.google.android.libraries.navigation.internal.abf.r.a(Boolean.valueOf(this.b), Boolean.valueOf(abVar.b));
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final com.google.android.libraries.navigation.internal.abf.q f() {
        return this.a.f();
    }

    @Override // com.google.android.libraries.navigation.internal.abn.w
    public final v g() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final void h(boolean z) {
        this.a.h(z);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a});
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final boolean i() {
        return this.b || this.a.i();
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final boolean j() {
        return this.a.j();
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final boolean k(CameraPosition cameraPosition, be beVar) {
        if (this.b) {
            return false;
        }
        return this.a.k(cameraPosition, beVar);
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.abf.aj ajVarF = com.google.android.libraries.navigation.internal.abf.aj.f(this);
        ajVarF.g("animation", this.a);
        return ajVarF.e("isCancelled", this.b).toString();
    }
}

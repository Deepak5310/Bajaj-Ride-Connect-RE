package com.google.android.libraries.navigation.internal.abn;

import com.google.android.gms.maps.model.CameraPosition;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements v, w {
    private final v a;
    private final av b;

    public b(v vVar, com.google.android.libraries.navigation.internal.ly.g gVar) {
        this.a = vVar;
        this.b = new av(gVar);
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final int a() {
        return this.a.a();
    }

    public final com.google.android.libraries.navigation.internal.ly.g b() {
        return this.b.a;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final CameraPosition c(be beVar, long j) {
        return this.a.c(beVar, j);
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
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return com.google.android.libraries.navigation.internal.abf.r.a(this.a, bVar.a) && com.google.android.libraries.navigation.internal.abf.r.a(b(), bVar.b());
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
        if (z) {
            this.b.a();
        } else {
            this.b.b();
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b});
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final boolean i() {
        return this.a.i();
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final boolean j() {
        return this.a.j();
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final boolean k(CameraPosition cameraPosition, be beVar) {
        return this.a.k(cameraPosition, beVar);
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.abf.aj ajVarF = com.google.android.libraries.navigation.internal.abf.aj.f(this);
        ajVarF.g("animation", this.a);
        ajVarF.g("callback", b());
        return ajVarF.toString();
    }
}

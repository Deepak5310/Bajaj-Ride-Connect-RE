package com.google.android.libraries.navigation.internal.bd;

import com.google.android.libraries.navigation.internal.afl.lz;
import com.google.android.libraries.navigation.internal.bp.ai;
import com.google.android.libraries.navigation.internal.gg.o;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class b extends g {
    public final f a;
    public final boolean b = false;
    public final boolean c = false;
    public final com.google.android.libraries.navigation.internal.bs.b d = null;
    public final lz e = null;
    public final ai f = null;
    public final boolean g = false;
    public final o h = null;

    public b(f fVar, boolean z, boolean z2, com.google.android.libraries.navigation.internal.bs.b bVar, lz lzVar, ai aiVar, boolean z3, o oVar) {
        this.a = fVar;
    }

    @Override // com.google.android.libraries.navigation.internal.bd.g
    public final f a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.bd.g
    public final ai b() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.bd.g
    public final com.google.android.libraries.navigation.internal.bs.b c() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.bd.g
    public final o d() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.bd.g
    public final lz e() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (this.a.equals(gVar.a())) {
                gVar.f();
                gVar.h();
                gVar.k();
                gVar.c();
                gVar.e();
                gVar.b();
                gVar.g();
                gVar.j();
                gVar.i();
                gVar.d();
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.bd.g
    public final boolean f() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.bd.g
    public final boolean g() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.bd.g
    public final boolean h() {
        return false;
    }

    public final int hashCode() {
        return (((((((this.a.hashCode() ^ 1000003) * 1000003) ^ 1237) * 1000003) ^ 1237) * (-429739981)) ^ 1237) * 583896283;
    }

    @Override // com.google.android.libraries.navigation.internal.bd.g
    public final void i() {
    }

    @Override // com.google.android.libraries.navigation.internal.bd.g
    public final void j() {
    }

    @Override // com.google.android.libraries.navigation.internal.bd.g
    public final void k() {
    }

    public final String toString() {
        return "{" + String.valueOf(this.a) + ", false, false, null, null, null, null, false, null, 0, null}";
    }
}

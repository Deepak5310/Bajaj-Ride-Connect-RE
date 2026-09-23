package com.google.android.libraries.navigation.internal.fr;

import com.google.android.libraries.navigation.internal.db.ar;
import com.google.android.libraries.navigation.internal.db.as;
import com.google.android.libraries.navigation.internal.yx.al;
import com.google.android.libraries.navigation.internal.zr.ak;
import com.google.android.libraries.navigation.internal.zr.am;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o {
    private as a = null;
    private as b = null;
    private long c;
    private com.google.android.libraries.navigation.internal.kd.j d;
    private com.google.android.libraries.navigation.internal.kd.j e;
    private com.google.android.libraries.navigation.internal.kd.g f;

    public o() {
        i();
    }

    private static float h(as asVar, as asVar2) {
        com.google.android.libraries.navigation.internal.db.r rVar = (com.google.android.libraries.navigation.internal.db.r) asVar;
        double d = rVar.b;
        com.google.android.libraries.navigation.internal.db.r rVar2 = (com.google.android.libraries.navigation.internal.db.r) asVar2;
        double d2 = rVar2.b;
        if (d == d2 && rVar.c == rVar2.c) {
            return 0.0f;
        }
        return ar.a(d, rVar.c, d2, rVar2.c);
    }

    private final void i() {
        this.d = new com.google.android.libraries.navigation.internal.kd.j(100.0f);
        this.e = new com.google.android.libraries.navigation.internal.kd.j(10000.0f);
        this.f = new com.google.android.libraries.navigation.internal.kd.g();
    }

    final synchronized float a() {
        as asVar;
        as asVar2 = this.a;
        if (asVar2 != null && (asVar = this.b) != null) {
            return h(asVar, asVar2);
        }
        return 0.0f;
    }

    final synchronized ak b() {
        return this.d.a();
    }

    final synchronized ak c() {
        return this.e.a();
    }

    final synchronized am d() {
        return this.f.a();
    }

    final synchronized void e() {
        i();
        this.a = null;
        this.b = null;
        this.c = 0L;
    }

    final synchronized boolean g() {
        return this.d.a > 0 && this.e.a > 0;
    }

    public final synchronized String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB;
        akVarB = al.b(this);
        akVarB.g("accuracyTracker", this.d);
        akVarB.g("locationFixAgeTracker", this.e);
        akVarB.g("locationDistanceTracker", this.f);
        return akVarB.toString();
    }

    final synchronized void f(as asVar, long j) {
        if (this.a == null) {
            this.a = asVar;
        } else {
            this.e.b(j - this.c);
            this.f.b(h(asVar, this.b));
        }
        this.d.b(((com.google.android.libraries.navigation.internal.db.r) asVar).d);
        this.b = asVar;
        this.c = j;
    }
}

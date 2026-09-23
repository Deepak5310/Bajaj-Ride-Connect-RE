package com.google.android.libraries.navigation.internal.bp;

import com.google.android.libraries.navigation.internal.adr.Cif;
import com.google.android.libraries.navigation.internal.adr.hv;
import com.google.android.libraries.navigation.internal.adr.ia;
import com.google.android.libraries.navigation.internal.adr.ib;
import com.google.android.libraries.navigation.internal.adr.jo;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bt {
    public final ib a;
    public final int b;

    public bt(ib ibVar, int i) {
        this.a = ibVar;
        this.b = i;
    }

    public final int a() {
        return this.a.d.size();
    }

    public final bq b(int i, int i2, int i3) {
        com.google.android.libraries.navigation.internal.yx.ar.a(i >= 0);
        com.google.android.libraries.navigation.internal.yx.ar.a(i < a());
        bp bpVarA = ca.a((hv) this.a.d.get(i), i2, null, null);
        bpVarA.g = i3;
        bpVarA.x = this;
        return new bq(bpVarA);
    }

    public final com.google.android.libraries.navigation.internal.adr.bq c() {
        Cif cif = this.a.c;
        if (cif == null) {
            cif = Cif.a;
        }
        com.google.android.libraries.navigation.internal.adr.p pVar = cif.k;
        if (pVar == null) {
            pVar = com.google.android.libraries.navigation.internal.adr.p.a;
        }
        com.google.android.libraries.navigation.internal.adr.bq bqVar = pVar.d;
        return bqVar == null ? com.google.android.libraries.navigation.internal.adr.bq.a : bqVar;
    }

    public final com.google.android.libraries.navigation.internal.adr.bs d() {
        Cif cif = this.a.c;
        if (cif == null) {
            cif = Cif.a;
        }
        com.google.android.libraries.navigation.internal.adr.p pVar = cif.k;
        if (pVar == null) {
            pVar = com.google.android.libraries.navigation.internal.adr.p.a;
        }
        com.google.android.libraries.navigation.internal.adr.bs bsVar = pVar.c;
        return bsVar == null ? com.google.android.libraries.navigation.internal.adr.bs.a : bsVar;
    }

    public final hv e(int i) {
        return (hv) this.a.d.get(i);
    }

    public final ia f() {
        ia iaVar = this.a.f;
        return iaVar == null ? ia.a : iaVar;
    }

    public final Cif g() {
        Cif cif = this.a.c;
        return cif == null ? Cif.a : cif;
    }

    public final jo h() {
        jo joVar = this.a.e;
        return joVar == null ? jo.a : joVar;
    }

    public final boolean i() {
        Cif cif = this.a.c;
        if (cif == null) {
            cif = Cif.a;
        }
        com.google.android.libraries.navigation.internal.adr.p pVar = cif.k;
        if (pVar == null) {
            pVar = com.google.android.libraries.navigation.internal.adr.p.a;
        }
        return (pVar.b & 2) != 0;
    }

    public final boolean j() {
        return (this.a.b & 8) != 0;
    }
}

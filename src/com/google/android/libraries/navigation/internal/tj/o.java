package com.google.android.libraries.navigation.internal.tj;

import com.google.android.libraries.navigation.internal.adr.kq;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bh;
import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.al;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o {
    public final bh a;
    public final com.google.android.libraries.navigation.internal.se.b[] b;
    public final kq c;
    public final long d;
    private final int e;

    public o(n nVar) {
        bh bhVar = nVar.a;
        ar.r(bhVar, "routes");
        this.a = bhVar;
        com.google.android.libraries.navigation.internal.se.b[] bVarArr = nVar.b;
        ar.r(bVarArr, "navGuidanceStates");
        this.b = bVarArr;
        int i = nVar.c;
        this.e = i;
        this.c = nVar.e;
        this.d = nVar.d;
        ar.b(bhVar.d() == bVarArr.length, "routes size == route states size");
        ar.b(bhVar.k(), "routes.hasSelected()");
        ar.b(bhVar.f() == bVarArr[bhVar.a()].b, "selected route == guided route");
        ar.b(i < bVarArr.length, "betterRouteIndex in bounds");
    }

    public final bg a() {
        return c().b;
    }

    public final com.google.android.libraries.navigation.internal.se.b b() {
        int i = this.e;
        if (i < 0) {
            return null;
        }
        return this.b[i];
    }

    public final com.google.android.libraries.navigation.internal.se.b c() {
        return this.b[this.a.a()];
    }

    public final String toString() {
        ak akVarC = al.b(this).c("betterRouteIndex", this.e);
        akVarC.g("betterRoutePromptDetails", this.c);
        return akVarC.d("nextGuidanceTime", this.d).toString();
    }
}

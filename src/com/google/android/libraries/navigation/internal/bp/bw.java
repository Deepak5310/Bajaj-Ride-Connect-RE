package com.google.android.libraries.navigation.internal.bp;

import com.google.android.libraries.navigation.internal.adr.dh;
import j$.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bw {
    public final dh a;
    public final int b;
    public final Duration c;
    public final int d;
    public final boolean e;
    public final int f;
    public final String g;
    public bq h;
    public final List i;

    public bw(bv bvVar) {
        this.a = bvVar.a;
        this.b = bvVar.b;
        this.c = bvVar.c;
        this.d = bvVar.d;
        this.e = bvVar.e;
        this.f = bvVar.f;
        this.g = bvVar.g;
        this.h = bvVar.h;
        this.i = bvVar.i;
    }

    public final bq a() {
        bq bqVar = this.h;
        com.google.android.libraries.navigation.internal.yx.ar.q(bqVar);
        return bqVar;
    }

    public final String b() {
        String str = this.g;
        if (str != null) {
            return str;
        }
        bq bqVar = this.h;
        com.google.android.libraries.navigation.internal.yx.ar.q(bqVar);
        return bqVar.q;
    }

    public final List c() {
        ArrayList arrayList = new ArrayList();
        for (com.google.android.libraries.navigation.internal.yx.br brVar : this.i) {
            if (((com.google.android.libraries.navigation.internal.yx.an) brVar.a()).g()) {
                arrayList.add((bz) ((com.google.android.libraries.navigation.internal.yx.an) brVar.a()).c());
            }
        }
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bw)) {
            return false;
        }
        bw bwVar = (bw) obj;
        return com.google.android.libraries.navigation.internal.yx.am.a(this.a, bwVar.a) && this.b == bwVar.b && this.d == bwVar.d && com.google.android.libraries.navigation.internal.yx.am.a(this.c, bwVar.c) && this.e == bwVar.e && this.f == bwVar.f && com.google.android.libraries.navigation.internal.yx.am.a(this.g, bwVar.g) && com.google.android.libraries.navigation.internal.yx.am.a(this.h, bwVar.h) && this.i.equals(bwVar.i);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Integer.valueOf(this.b), Integer.valueOf(this.d), this.c, Boolean.valueOf(this.e), Integer.valueOf(this.f), this.g, this.h, this.i});
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        akVarB.h();
        akVarB.g("guidanceType", this.a);
        com.google.android.libraries.navigation.internal.yx.ak akVarC = akVarB.c("relevanceRangeEndMeters", this.b).c("minRelevanceDistanceMeters", this.d);
        akVarC.g("minRelevanceDuration", this.c);
        com.google.android.libraries.navigation.internal.yx.ak akVarC2 = akVarC.e("isNextStepRelevant", this.e).c("guidanceIndex", this.f);
        akVarC2.g("spokenText", b());
        bq bqVar = this.h;
        akVarC2.g("step#", bqVar != null ? Integer.valueOf(bqVar.i) : null);
        akVarC2.g("overrideText", this.g);
        akVarC2.g("guidanceWithDistanceMessages", this.i.toString());
        return akVarC2.toString();
    }
}

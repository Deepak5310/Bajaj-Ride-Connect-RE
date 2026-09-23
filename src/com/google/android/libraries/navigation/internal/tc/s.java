package com.google.android.libraries.navigation.internal.tc;

import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.bp.bf;
import com.google.android.libraries.navigation.internal.bp.ck;
import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.zr.dq;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class s {
    public final long a;
    public final al b;
    public final ck[] c;
    public final com.google.android.libraries.navigation.internal.oe.x d;
    public bf e;
    public boolean f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public dq m;

    public s(long j, al alVar, ck[] ckVarArr, com.google.android.libraries.navigation.internal.oe.x xVar) {
        this.a = j;
        this.b = alVar;
        this.c = ckVarArr;
        this.d = xVar;
    }

    final void a(ak akVar) {
        akVar.g("TRAVEL_MODE", this.b);
        akVar.c("BASE_ESTIMATE_SECONDS", this.i);
        if (this.f) {
            akVar.c("TRAFFIC_ESTIMATE_SECONDS", this.h);
        }
        int i = this.j;
        if (i > 0) {
            akVar.c("OPTIMISTIC_TRAFFIC_ESTIMATE_SECONDS", i);
        }
        int i2 = this.k;
        if (i2 > 0) {
            akVar.c("PESSIMISTIC_TRAFFIC_ESTIMATE_SECONDS", i2);
        }
        int i3 = this.l;
        if (i3 > 0) {
            akVar.c("HISTORICAL_TRAFFIC_ESTIMATE_SECONDS", i3);
        }
        akVar.c("LENGTH_METERS", this.g);
        ck[] ckVarArr = this.c;
        if (ckVarArr != null) {
            akVar.c("NUM_DESTINATIONS", ckVarArr.length - 1);
        }
        dq dqVar = this.m;
        if (dqVar != null) {
            akVar.g("ROAD_TRAFFIC_EXPERIMENTAL_DATA", dqVar.toString());
        }
    }

    public final String toString() {
        ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        a(akVarB);
        return akVarB.toString();
    }
}

package com.google.android.libraries.navigation.internal.dh;

import app.notifee.core.event.LogEvent;
import com.google.android.libraries.navigation.internal.acu.bv;
import com.google.android.libraries.navigation.internal.acu.bx;
import com.google.maps.android.BuildConfig;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aq extends com.google.android.libraries.navigation.internal.kp.c implements com.google.android.libraries.navigation.internal.ic.a {
    private final bx a;

    public aq(com.google.android.libraries.navigation.internal.db.r rVar) {
        this.a = rVar.l().J;
    }

    private static String f(bx bxVar) {
        String strG;
        String strG2;
        String strG3;
        String strG4;
        String strG5;
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(bxVar);
        String strG6 = null;
        if ((bxVar.b & 1) != 0) {
            bv bvVar = bxVar.c;
            if (bvVar == null) {
                bvVar = bv.a;
            }
            strG = g(bvVar);
        } else {
            strG = null;
        }
        akVarB.g("snapped", strG);
        if ((bxVar.b & 2) != 0) {
            bv bvVar2 = bxVar.d;
            if (bvVar2 == null) {
                bvVar2 = bv.a;
            }
            strG2 = g(bvVar2);
        } else {
            strG2 = null;
        }
        akVarB.g("snappedRoad", strG2);
        if ((bxVar.b & 4) != 0) {
            bv bvVar3 = bxVar.e;
            if (bvVar3 == null) {
                bvVar3 = bv.a;
            }
            strG3 = g(bvVar3);
        } else {
            strG3 = null;
        }
        akVarB.g("likeliest", strG3);
        if ((bxVar.b & 8) != 0) {
            bv bvVar4 = bxVar.f;
            if (bvVar4 == null) {
                bvVar4 = bv.a;
            }
            strG4 = g(bvVar4);
        } else {
            strG4 = null;
        }
        akVarB.g("likeliestRoad", strG4);
        com.google.android.libraries.navigation.internal.yx.ak akVarB2 = akVarB.b("likeliestProbability", (bxVar.b & 16) != 0 ? bxVar.g : Float.NaN);
        if ((bxVar.b & 32) != 0) {
            bv bvVar5 = bxVar.h;
            if (bvVar5 == null) {
                bvVar5 = bv.a;
            }
            strG5 = g(bvVar5);
        } else {
            strG5 = null;
        }
        akVarB2.g("projected", strG5);
        if ((bxVar.b & 64) != 0) {
            bv bvVar6 = bxVar.i;
            if (bvVar6 == null) {
                bvVar6 = bv.a;
            }
            strG6 = g(bvVar6);
        }
        akVarB2.g("projectedRoad", strG6);
        return akVarB2.c("routeMatchingCount", bxVar.j).toString();
    }

    private static String g(bv bvVar) {
        return com.google.android.libraries.navigation.internal.yx.al.b(bvVar).d("polyline_id", bvVar.b).d("seg_addr", bvVar.c).d("owner_addr", bvVar.d).c("owner_use_count", bvVar.e).c("map", bvVar.f).e("patched", bvVar.g).e("curved", bvVar.h).c("sx", bvVar.i).c("sy", bvVar.j).c("ex", bvVar.k).c("ey", bvVar.l).toString();
    }

    @Override // com.google.android.libraries.navigation.internal.kp.c
    public final com.google.android.libraries.navigation.internal.kp.f c() {
        com.google.android.libraries.navigation.internal.kp.f fVar = new com.google.android.libraries.navigation.internal.kp.f("segment-debug");
        bx bxVar = this.a;
        fVar.m(LogEvent.LEVEL_INFO, bxVar == null ? BuildConfig.TRAVIS : f(bxVar));
        return fVar;
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        bx bxVar = this.a;
        akVarB.g(LogEvent.LEVEL_INFO, bxVar == null ? BuildConfig.TRAVIS : f(bxVar));
        return akVarB.toString();
    }
}

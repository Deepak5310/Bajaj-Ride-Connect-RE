package com.google.android.libraries.navigation.internal.bs;

import com.google.android.libraries.navigation.internal.adr.bm;
import com.google.android.libraries.navigation.internal.adr.ka;
import com.google.android.libraries.navigation.internal.adu.s;
import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.ady.h;
import com.google.android.libraries.navigation.internal.afl.bz;
import com.google.android.libraries.navigation.internal.afl.lr;
import com.google.android.libraries.navigation.internal.bp.cn;
import com.google.android.libraries.navigation.internal.gg.c;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public final lr a;
    public final bz b;
    public final h c;
    public final bm.a d;
    public final ev e;
    public final ev f;
    public final com.google.android.libraries.navigation.internal.acc.b g;
    public final com.google.android.libraries.navigation.internal.aes.h h;
    public final boolean i;
    public final Long j;
    public final boolean k;
    public final boolean l;
    public final HashMap m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final s f359n;
    private final c o;

    static {
        TimeUnit.MINUTES.toMillis(1L);
    }

    public b(lr lrVar, ev evVar, ev evVar2, bz bzVar, h hVar, com.google.android.libraries.navigation.internal.acc.b bVar, com.google.android.libraries.navigation.internal.aes.h hVar2, bm.a aVar, boolean z, Long l, boolean z2, boolean z3, s sVar, HashMap map) {
        if (!evVar.isEmpty()) {
            cn.a(evVar.size());
        }
        this.a = lrVar;
        this.e = evVar;
        this.f = evVar2;
        this.b = bzVar;
        this.c = hVar;
        this.g = bVar;
        this.h = hVar2;
        this.d = aVar;
        this.i = z;
        this.j = null;
        this.k = z2;
        this.l = false;
        this.f359n = null;
        this.m = map;
        this.o = new c();
    }

    public final al a() {
        ka kaVar = this.a.f;
        if (kaVar == null) {
            kaVar = ka.a;
        }
        al alVarB = al.b(kaVar.c);
        return alVarB == null ? al.MIXED : alVarB;
    }

    public final String toString() {
        return "options=" + this.a + "\nwaypoints=" + this.e + "\nviapoints=" + this.f + "\ninputCamera=" + this.g + "\nuserLocation=" + this.h + "\npreferredTransitPattern=null\npreferredTransitPatternToken=null\nunspecifiedTransitPattern=null\ntransitPatternMatchingMode=null\nsavedTripIdnull\ntransitRouteStartSpecifier=null\nrouteShouldSkipInitialNonTransitLeg=false\nloggingParams=null\nrestrictToIndashIncidents=" + this.i + "\ndisableTraffic=" + this.k + "\nskipAdditionalDirectionsData=false\npromotedPinAdsRequestOptions=null\ndetailLevel=null\nminimumDetailLevels=" + this.m + "\ndelegatingCancellationHandle=" + this.o + "\nlocalQueryIntentParamsToken=null\n";
    }
}

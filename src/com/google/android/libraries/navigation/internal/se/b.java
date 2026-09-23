package com.google.android.libraries.navigation.internal.se;

import com.google.android.libraries.navigation.internal.adr.ii;
import com.google.android.libraries.navigation.internal.bp.ae;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.db.y;
import com.google.android.libraries.navigation.internal.oe.ag;
import com.google.android.libraries.navigation.internal.oe.an;
import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.am;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.firebase.analytics.FirebaseAnalytics;
import j$.time.Duration;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public static final Duration a = Duration.ofSeconds(-1);
    public final bg b;
    public final bq c;
    public final boolean d;
    public final int e;
    public final int f;
    public final int g;
    public final double h;
    public final double i;
    public final int j;
    public final int k;
    public final ae l;
    public final boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f572n;
    public final boolean o;
    public final y p;
    public final ag q;
    private final int r;
    private final ae s;

    public b(a aVar) {
        bg bgVar = aVar.a;
        ar.q(bgVar);
        this.b = bgVar;
        this.c = aVar.b;
        this.d = aVar.c;
        this.r = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.h;
        this.h = aVar.i;
        this.j = aVar.k;
        this.i = aVar.j;
        this.k = aVar.g;
        this.s = aVar.l;
        this.l = aVar.m;
        this.m = aVar.f571n;
        this.f572n = aVar.o;
        this.o = aVar.p;
        this.p = aVar.q;
        this.q = aVar.r;
    }

    public final double a() {
        int i;
        if (this.c == null || (i = this.j) == -1) {
            return 0.0d;
        }
        return this.b.J - i;
    }

    public final int b() {
        return (int) this.s.c().toSeconds();
    }

    public final int c() {
        return (int) this.l.c().toSeconds();
    }

    public final an d(float f) {
        int i = this.r;
        if (i < 0) {
            bq bqVar = this.c;
            if (bqVar == null) {
                return null;
            }
            i = bqVar.k;
        }
        int i2 = i + 1;
        an anVarY = this.b.y();
        if (i2 >= anVarY.a()) {
            return null;
        }
        if (f < 0.0f) {
            return new an(anVarY, i2, anVarY.a());
        }
        return new an(anVarY, i2, Math.min(anVarY.a(), this.b.h(this.b.a(i2) + ((double) f)) + 1));
    }

    public final ii.a e() {
        return this.b.E();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return am.a(this.b, bVar.b) && am.a(this.c, bVar.c) && this.r == bVar.r && this.e == bVar.e && this.f == bVar.f && this.g == bVar.g && this.h == bVar.h && this.j == bVar.j && this.i == bVar.i && am.a(this.s, bVar.s) && am.a(this.l, bVar.l) && am.a(this.p, bVar.p) && this.m == bVar.m && this.f572n == bVar.f572n && this.o == bVar.o && am.a(this.q, bVar.q);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c, Integer.valueOf(this.r), Integer.valueOf(this.e), Integer.valueOf(this.f), Integer.valueOf(this.g), Double.valueOf(this.h), Double.valueOf(this.i), Integer.valueOf(this.j), this.s, this.l, Boolean.valueOf(this.m), Boolean.valueOf(this.f572n), Boolean.valueOf(this.o), this.p, this.q});
    }

    public final String toString() {
        ak akVar = new ak("b");
        akVar.g(PlaceTypes.ROUTE, this.b);
        bq bqVar = this.c;
        ak akVarC = akVar.c("curStep", bqVar == null ? -1 : bqVar.i).c("curSegment", this.r).c("lastViapoint", this.e).c("metersToNextStep", this.f).c("secondsToNextStep", this.g).a("secondsToNextEvent", this.h).a("metersFromStart", this.i).c("metersRemaining", this.j).c("metersRemainingToNextDestination", this.k);
        akVarC.g("combinedSecondsRemaining", this.s);
        akVarC.g("combinedSecondsRemainingToNextDestination", this.l);
        ak akVarE = akVarC.e("isOnRoute", this.m).e("hasEverBeenOnRoute", this.f572n).e("routeCompletedSuccessfully", this.o);
        akVarE.g(FirebaseAnalytics.Param.LOCATION, this.p);
        akVarE.g("projection", this.q);
        return akVarE.toString();
    }
}

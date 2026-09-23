package com.google.android.libraries.navigation.internal.be;

import com.google.android.libraries.navigation.internal.oe.ad;
import com.google.android.libraries.navigation.internal.oe.x;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements Comparable {
    public static final e a = new e();
    private static final Comparator d = ComparisonsKt.compareBy(c.a, d.a);
    public final int b;
    public final double c;
    private final ad e;

    public f(int i, double d2, ad polyline) {
        Intrinsics.checkNotNullParameter(polyline, "polyline");
        this.b = i;
        this.c = d2;
        this.e = polyline;
    }

    public final double a() {
        double d2 = this.c;
        if (d2 < 0.0d) {
            return d2;
        }
        if (this.b != this.e.e() - 2) {
            return 0.0d;
        }
        return Math.max(0.0d, this.c - ((double) this.e.c(this.b)));
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final int compareTo(f other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (this.e == other.e) {
            return d.compare(this, other);
        }
        throw new IllegalArgumentException("PolylinePosition.compareTo requires other position to be on same polyline instance");
    }

    public final f c() {
        if (a() < 0.0d) {
            ad adVar = this.e;
            Intrinsics.checkNotNullParameter(adVar, "<this>");
            f fVarA = a.a(adVar, 0, 0.0d);
            Intrinsics.checkNotNull(fVarA);
            return fVarA;
        }
        if (a() <= 0.0d) {
            return this;
        }
        ad adVar2 = this.e;
        Intrinsics.checkNotNullParameter(adVar2, "<this>");
        f fVarA2 = a.a(adVar2, adVar2.e() - 1, 0.0d);
        Intrinsics.checkNotNull(fVarA2);
        return fVarA2;
    }

    public final x d() {
        x xVarB = ((x) this.e.q().get(this.b)).B((x) this.e.q().get(this.b + 1), (float) (this.c / ((double) this.e.c(this.b))));
        Intrinsics.checkNotNullExpressionValue(xVarB, "interpolate(...)");
        return xVarB;
    }

    public final ad e(f end) {
        Intrinsics.checkNotNullParameter(end, "end");
        if (this.e != end.e) {
            throw new IllegalArgumentException("PolylinePosition.getPolylineBetweenPositions requires other position to be on same polyline instance");
        }
        List listMutableListOf = CollectionsKt.mutableListOf(d());
        if (end.compareTo(this) <= 0) {
            ad adVarN = ad.n(listMutableListOf);
            Intrinsics.checkNotNullExpressionValue(adVarN, "fromPoints(...)");
            return adVarN;
        }
        if (end.a() < 0.0d || a() > 0.0d) {
            listMutableListOf.add(end.d());
            ad adVarN2 = ad.n(listMutableListOf);
            Intrinsics.checkNotNullExpressionValue(adVarN2, "fromPoints(...)");
            return adVarN2;
        }
        if (a() < 0.0d) {
            List listQ = this.e.q();
            Intrinsics.checkNotNullExpressionValue(listQ, "getVertices(...)");
            listMutableListOf.add(CollectionsKt.first(listQ));
        }
        int i = this.b + 1;
        int i2 = end.b;
        if (i <= i2) {
            while (true) {
                listMutableListOf.add(this.e.q().get(i));
                if (i == i2) {
                    break;
                }
                i++;
            }
        }
        if (end.a() > 0.0d) {
            List listQ2 = this.e.q();
            Intrinsics.checkNotNullExpressionValue(listQ2, "getVertices(...)");
            listMutableListOf.add(CollectionsKt.last(listQ2));
        }
        x xVarD = end.d();
        if (!Intrinsics.areEqual(xVarD, CollectionsKt.last(listMutableListOf))) {
            listMutableListOf.add(xVarD);
        }
        ad adVarN3 = ad.n(listMutableListOf);
        Intrinsics.checkNotNullExpressionValue(adVarN3, "fromPoints(...)");
        return adVarN3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.e == fVar.e && this.b == fVar.b && this.c == fVar.c;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.b), Double.valueOf(this.c), Integer.valueOf(System.identityHashCode(this.e)));
    }

    public final String toString() {
        return "PolylinePosition(routePolylineSegmentIndex=" + this.b + ", routePolylineSegmentDistanceWu=" + this.c + ")";
    }
}

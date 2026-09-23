package com.google.android.libraries.navigation.internal.ck;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class be {
    public static final bd a = new bd();
    public final com.google.android.libraries.navigation.internal.ady.al b;
    public final boolean c;
    public final boolean d;
    public final List e;
    public final boolean f;
    public final List g;
    public final List h;
    public final List i;
    public final int j;
    public final float k;
    public final j l;
    public final List m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f367n;
    private final com.google.android.libraries.navigation.internal.oe.ad o;
    private final List p;

    public /* synthetic */ be(com.google.android.libraries.navigation.internal.ady.al travelMode, boolean z, boolean z2, com.google.android.libraries.navigation.internal.oe.ad polyline, List list, boolean z3, List list2, List list3, List list4, List list5, int i, float f, j jVar, int i2) {
        List vertexBreaks = (i2 & 16) != 0 ? CollectionsKt.emptyList() : list;
        boolean z4 = (!((i2 & 32) == 0)) | z3;
        List trafficProblemVisualizations = (i2 & 64) != 0 ? CollectionsKt.emptyList() : list2;
        List styleableTrafficRoadStretches = (i2 & 128) != 0 ? CollectionsKt.emptyList() : list3;
        List styleableADRoadStretches = (i2 & 256) != 0 ? CollectionsKt.emptyList() : list4;
        List styledPolylineStretches = (i2 & 512) != 0 ? CollectionsKt.emptyList() : list5;
        int i3 = (i2 & 1024) != 0 ? 0 : i;
        float f2 = (i2 & 2048) != 0 ? 0.0f : f;
        int i4 = i2 & 2;
        boolean z5 = (i2 & 4) == 0;
        boolean z6 = i4 == 0;
        j debugRenderUseCase = j.NONE;
        Intrinsics.checkNotNullParameter(travelMode, "travelMode");
        Intrinsics.checkNotNullParameter(polyline, "polyline");
        Intrinsics.checkNotNullParameter(vertexBreaks, "vertexBreaks");
        Intrinsics.checkNotNullParameter(trafficProblemVisualizations, "trafficProblemVisualizations");
        Intrinsics.checkNotNullParameter(styleableTrafficRoadStretches, "styleableTrafficRoadStretches");
        Intrinsics.checkNotNullParameter(styleableADRoadStretches, "styleableADRoadStretches");
        Intrinsics.checkNotNullParameter(styledPolylineStretches, "styledPolylineStretches");
        Intrinsics.checkNotNullParameter(debugRenderUseCase, "debugRenderUseCase");
        this.b = travelMode;
        this.c = z6 & z;
        this.d = z5 & z2;
        this.o = polyline;
        this.e = vertexBreaks;
        this.f = z4;
        this.g = trafficProblemVisualizations;
        this.h = styleableTrafficRoadStretches;
        this.p = styleableADRoadStretches;
        this.i = styledPolylineStretches;
        this.j = i3;
        this.k = f2;
        this.l = debugRenderUseCase;
        List listQ = polyline.q();
        Intrinsics.checkNotNullExpressionValue(listQ, "getVertices(...)");
        this.m = listQ;
        this.f367n = polyline.a();
    }

    @JvmStatic
    public static final a a(com.google.android.libraries.navigation.internal.oe.ad adVar, com.google.android.libraries.navigation.internal.ady.al alVar) {
        return bd.a(adVar, alVar);
    }

    @JvmStatic
    public static final a b(List points, com.google.android.libraries.navigation.internal.ady.al travelMode) {
        Intrinsics.checkNotNullParameter(points, "points");
        Intrinsics.checkNotNullParameter(travelMode, "travelMode");
        com.google.android.libraries.navigation.internal.oe.ad adVarN = com.google.android.libraries.navigation.internal.oe.ad.n(points);
        Intrinsics.checkNotNullExpressionValue(adVarN, "fromPoints(...)");
        return bd.a(adVarN, travelMode);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof be)) {
            return false;
        }
        be beVar = (be) obj;
        return this.b == beVar.b && this.c == beVar.c && this.d == beVar.d && Intrinsics.areEqual(this.o, beVar.o) && Intrinsics.areEqual(this.e, beVar.e) && this.f == beVar.f && Intrinsics.areEqual(this.g, beVar.g) && Intrinsics.areEqual(this.h, beVar.h) && Intrinsics.areEqual(this.p, beVar.p) && Intrinsics.areEqual(this.i, beVar.i) && this.j == beVar.j && Float.compare(this.k, beVar.k) == 0 && this.l == beVar.l;
    }

    public final int hashCode() {
        int iHashCode = this.b.hashCode() * 31;
        com.google.android.libraries.navigation.internal.oe.ad adVar = this.o;
        return ((((((((((((((((((((((iHashCode + bc.a(this.c)) * 31) + bc.a(this.d)) * 31) + adVar.hashCode()) * 31) + this.e.hashCode()) * 31) + bc.a(this.f)) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.p.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j) * 31) + Float.floatToIntBits(this.k)) * 31) + this.l.hashCode();
    }

    public final String toString() {
        return "RenderablePolyline(travelMode=" + this.b + ", isIndeterminateRoute=" + this.c + ", isIndoors=" + this.d + ", polyline=" + this.o + ", vertexBreaks=" + this.e + ", isActive=" + this.f + ", trafficProblemVisualizations=" + this.g + ", styleableTrafficRoadStretches=" + this.h + ", styleableADRoadStretches=" + this.p + ", styledPolylineStretches=" + this.i + ", zWithinGrade=" + this.j + ", distanceAlongLine=" + this.k + ", debugRenderUseCase=" + this.l + ")";
    }
}

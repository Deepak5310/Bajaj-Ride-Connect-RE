package com.google.android.libraries.navigation.internal.cq;

import com.google.android.libraries.navigation.internal.aaq.an;
import com.google.android.libraries.navigation.internal.adg.ex;
import java.util.Objects;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aa {
    public static final q a = new q();
    public final int b;
    public final int c;
    public final String d;
    public final k e;
    public final an f;
    public final ex g;
    public final ex h;
    public final ex i;
    public final ex j;
    public final ex k;
    public final w l;
    public final com.google.android.libraries.navigation.internal.qk.t m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Function1 f379n;
    public final Integer o;
    public final String p;
    public final String q;
    public final String r;
    public final com.google.android.libraries.navigation.internal.ado.j s;
    public final com.google.android.libraries.navigation.internal.afd.a t;

    public aa(int i, int i2, String decorationInstanceId, k decorationCategory, an anVar, ex layoutStyle, ex expandedLtrLayoutStyle, ex expandedRtlLayoutStyle, ex iconStyle, ex titleStyle, w wVar, com.google.android.libraries.navigation.internal.qk.t useCase, Function1 pickHandlerCreator, Integer num, String str, String str2, com.google.android.libraries.navigation.internal.afd.a aVar, String str3, com.google.android.libraries.navigation.internal.ado.j jVar) {
        Intrinsics.checkNotNullParameter(decorationInstanceId, "decorationInstanceId");
        Intrinsics.checkNotNullParameter(decorationCategory, "decorationCategory");
        Intrinsics.checkNotNullParameter(layoutStyle, "layoutStyle");
        Intrinsics.checkNotNullParameter(expandedLtrLayoutStyle, "expandedLtrLayoutStyle");
        Intrinsics.checkNotNullParameter(expandedRtlLayoutStyle, "expandedRtlLayoutStyle");
        Intrinsics.checkNotNullParameter(iconStyle, "iconStyle");
        Intrinsics.checkNotNullParameter(titleStyle, "titleStyle");
        Intrinsics.checkNotNullParameter(useCase, "useCase");
        Intrinsics.checkNotNullParameter(pickHandlerCreator, "pickHandlerCreator");
        this.b = i;
        this.c = i2;
        this.d = decorationInstanceId;
        this.e = decorationCategory;
        this.f = anVar;
        this.g = layoutStyle;
        this.h = expandedLtrLayoutStyle;
        this.i = expandedRtlLayoutStyle;
        this.j = iconStyle;
        this.k = titleStyle;
        this.l = wVar;
        this.m = useCase;
        this.f379n = pickHandlerCreator;
        this.o = num;
        this.p = str;
        this.q = str2;
        this.t = aVar;
        this.r = str3;
        this.s = jVar;
        Objects.toString(decorationCategory);
        Objects.toString(useCase);
        Objects.toString(anVar);
    }

    @JvmStatic
    public static final p a() {
        a aVar = new a();
        ex exVar = ex.LEGEND_STYLE_ROUTE_DECORATION_CALLOUT_LAYOUT;
        Objects.requireNonNull(exVar);
        aVar.b = exVar;
        aVar.i |= 32;
        ex exVar2 = ex.LEGEND_STYLE_ROUTE_DECORATION_CALLOUT_TITLE;
        Objects.requireNonNull(exVar2);
        aVar.e = exVar2;
        aVar.i |= 512;
        ex exVar3 = ex.LEGEND_STYLE_ROUTE_DECORATION_CALLOUT_EXTRA_PADDING_LAYOUT;
        Objects.requireNonNull(exVar3);
        aVar.c = exVar3;
        aVar.i |= 64;
        ex exVar4 = ex.LEGEND_STYLE_ROUTE_DECORATION_CALLOUT_EXTRA_PADDING_LAYOUT_RTL;
        Objects.requireNonNull(exVar4);
        aVar.d = exVar4;
        aVar.i |= 128;
        return aVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof aa)) {
            return false;
        }
        aa aaVar = (aa) obj;
        return this.b == aaVar.b && this.c == aaVar.c && Intrinsics.areEqual(this.d, aaVar.d) && this.e == aaVar.e && Intrinsics.areEqual(this.f, aaVar.f) && this.g == aaVar.g && this.h == aaVar.h && this.i == aaVar.i && this.j == aaVar.j && this.k == aaVar.k && Intrinsics.areEqual(this.l, aaVar.l) && this.m == aaVar.m && Intrinsics.areEqual(this.f379n, aaVar.f379n) && Intrinsics.areEqual(this.o, aaVar.o) && Intrinsics.areEqual(this.p, aaVar.p) && Intrinsics.areEqual(this.q, aaVar.q) && Intrinsics.areEqual(this.t, aaVar.t) && Intrinsics.areEqual(this.r, aaVar.r) && Intrinsics.areEqual(this.s, aaVar.s);
    }

    public final int hashCode() {
        int iN;
        int iHashCode = (((((this.b * 31) + this.c) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
        an anVar = this.f;
        int iN2 = 0;
        if (anVar == null) {
            iN = 0;
        } else if (anVar.H()) {
            iN = anVar.n();
        } else {
            int iN3 = anVar.ak;
            if (iN3 == 0) {
                iN3 = anVar.n();
                anVar.ak = iN3;
            }
            iN = iN3;
        }
        int iHashCode2 = ((((((((((((iHashCode * 31) + iN) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31;
        w wVar = this.l;
        int iHashCode3 = (((((iHashCode2 + (wVar == null ? 0 : wVar.hashCode())) * 31) + this.m.hashCode()) * 31) + this.f379n.hashCode()) * 31;
        Integer num = this.o;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.p;
        int iHashCode5 = (iHashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.q;
        int iHashCode6 = (iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        com.google.android.libraries.navigation.internal.afd.a aVar = this.t;
        int iHashCode7 = (iHashCode6 + (aVar == null ? 0 : aVar.hashCode())) * 31;
        String str3 = this.r;
        int iHashCode8 = (iHashCode7 + (str3 == null ? 0 : str3.hashCode())) * 31;
        com.google.android.libraries.navigation.internal.ado.j jVar = this.s;
        if (jVar != null) {
            if (jVar.H()) {
                iN2 = jVar.n();
            } else {
                iN2 = jVar.ak;
                if (iN2 == 0) {
                    iN2 = jVar.n();
                    jVar.ak = iN2;
                }
            }
        }
        return iHashCode8 + iN2;
    }

    public final String toString() {
        return "StyledPolylineCallout(startOffsetMeters=" + this.b + ", lengthMeters=" + this.c + ", decorationInstanceId=" + this.d + ", decorationCategory=" + this.e + ", decorationType=" + this.f + ", layoutStyle=" + this.g + ", expandedLtrLayoutStyle=" + this.h + ", expandedRtlLayoutStyle=" + this.i + ", iconStyle=" + this.j + ", titleStyle=" + this.k + ", legacyStyles=" + this.l + ", useCase=" + this.m + ", pickHandlerCreator=" + this.f379n + ", minZoomLevel=" + this.o + ", title=" + this.p + ", accessibilityLabel=" + this.q + ", veType=" + this.t + ", ved=" + this.r + ", loggingMetadata=" + this.s + ")";
    }
}

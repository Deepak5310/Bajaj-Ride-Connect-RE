package com.google.android.libraries.navigation.internal.cq;

import com.google.android.libraries.navigation.internal.ol.aq;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class w {
    public static final s a = new s();
    public final aq b;
    public final com.google.android.libraries.navigation.internal.oo.f c;
    public final aq d;
    public final com.google.android.libraries.navigation.internal.oo.f e;
    public final aq f;
    public final com.google.android.libraries.navigation.internal.oo.f g;
    public final aq h;
    public final com.google.android.libraries.navigation.internal.oo.f i;
    public final aq j;
    public final com.google.android.libraries.navigation.internal.oo.f k;

    public w(aq layoutMapStyle, com.google.android.libraries.navigation.internal.oo.f layoutStyle, aq iconMapStyle, com.google.android.libraries.navigation.internal.oo.f iconStyle, aq aqVar, com.google.android.libraries.navigation.internal.oo.f fVar, aq aqVar2, com.google.android.libraries.navigation.internal.oo.f fVar2, aq aqVar3, com.google.android.libraries.navigation.internal.oo.f fVar3) {
        Intrinsics.checkNotNullParameter(layoutMapStyle, "layoutMapStyle");
        Intrinsics.checkNotNullParameter(layoutStyle, "layoutStyle");
        Intrinsics.checkNotNullParameter(iconMapStyle, "iconMapStyle");
        Intrinsics.checkNotNullParameter(iconStyle, "iconStyle");
        this.b = layoutMapStyle;
        this.c = layoutStyle;
        this.d = iconMapStyle;
        this.e = iconStyle;
        this.f = aqVar;
        this.g = fVar;
        this.h = aqVar2;
        this.i = fVar2;
        this.j = aqVar3;
        this.k = fVar3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return Intrinsics.areEqual(this.b, wVar.b) && Intrinsics.areEqual(this.c, wVar.c) && Intrinsics.areEqual(this.d, wVar.d) && Intrinsics.areEqual(this.e, wVar.e) && Intrinsics.areEqual(this.f, wVar.f) && Intrinsics.areEqual(this.g, wVar.g) && Intrinsics.areEqual(this.h, wVar.h) && Intrinsics.areEqual(this.i, wVar.i) && Intrinsics.areEqual(this.j, wVar.j) && Intrinsics.areEqual(this.k, wVar.k);
    }

    public final int hashCode() {
        int iHashCode = (((((this.b.hashCode() * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
        aq aqVar = this.f;
        int iHashCode2 = ((iHashCode * 31) + (aqVar == null ? 0 : aqVar.hashCode())) * 31;
        com.google.android.libraries.navigation.internal.oo.f fVar = this.g;
        int iHashCode3 = (iHashCode2 + (fVar == null ? 0 : fVar.hashCode())) * 31;
        aq aqVar2 = this.h;
        int iHashCode4 = (iHashCode3 + (aqVar2 == null ? 0 : aqVar2.hashCode())) * 31;
        com.google.android.libraries.navigation.internal.oo.f fVar2 = this.i;
        int iHashCode5 = (iHashCode4 + (fVar2 == null ? 0 : fVar2.hashCode())) * 31;
        aq aqVar3 = this.j;
        int iHashCode6 = (iHashCode5 + (aqVar3 == null ? 0 : aqVar3.hashCode())) * 31;
        com.google.android.libraries.navigation.internal.oo.f fVar3 = this.k;
        return iHashCode6 + (fVar3 != null ? fVar3.hashCode() : 0);
    }

    public final String toString() {
        return "LegacyStyles(layoutMapStyle=" + this.b + ", layoutStyle=" + this.c + ", iconMapStyle=" + this.d + ", iconStyle=" + this.e + ", spacerMapStyle=" + this.f + ", spacerStyle=" + this.g + ", textIconMapStyle=" + this.h + ", textIconStyle=" + this.i + ", titleMapStyle=" + this.j + ", titleStyle=" + this.k + ")";
    }
}

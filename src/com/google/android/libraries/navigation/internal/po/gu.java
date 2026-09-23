package com.google.android.libraries.navigation.internal.po;

import android.graphics.Point;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class gu {
    private final com.google.android.libraries.navigation.internal.pb.t a;

    public gu(com.google.android.libraries.navigation.internal.pb.t tVar) {
        this.a = tVar;
    }

    public final Point a(com.google.android.libraries.navigation.internal.oe.r rVar) {
        int[] iArrR = com.google.android.libraries.navigation.internal.pb.j.r(this.a, com.google.android.libraries.navigation.internal.oe.h.c(rVar));
        if (iArrR == null) {
            return null;
        }
        return new Point(iArrR[0], iArrR[1]);
    }

    public final com.google.android.libraries.navigation.internal.oe.r b(Point point) {
        com.google.android.libraries.navigation.internal.oe.x xVarJ = com.google.android.libraries.navigation.internal.pb.j.j(this.a, point.x, point.y, new float[8]);
        if (xVarJ == null) {
            return null;
        }
        return com.google.android.libraries.navigation.internal.oe.h.a(xVarJ);
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        akVarB.g("camera", this.a);
        return akVarB.toString();
    }
}

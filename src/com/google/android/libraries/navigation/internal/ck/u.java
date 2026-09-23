package com.google.android.libraries.navigation.internal.ck;

import com.google.android.libraries.navigation.internal.yz.gi;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class u {
    private final com.google.android.libraries.navigation.internal.afo.a a;

    public u(com.google.android.libraries.navigation.internal.afo.a labelManager) {
        Intrinsics.checkNotNullParameter(labelManager, "labelManager");
        this.a = labelManager;
    }

    public final t a(gi zoomToIcon, com.google.android.libraries.navigation.internal.oe.r latlng) {
        Intrinsics.checkNotNullParameter(zoomToIcon, "zoomToIcon");
        Intrinsics.checkNotNullParameter(latlng, "latlng");
        Object objA = this.a.a();
        Intrinsics.checkNotNullExpressionValue(objA, "get(...)");
        return new t(zoomToIcon, latlng, (com.google.android.libraries.navigation.internal.ot.h) objA);
    }
}

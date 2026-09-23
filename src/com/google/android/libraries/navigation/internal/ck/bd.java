package com.google.android.libraries.navigation.internal.ck;

import java.util.Objects;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bd {
    @JvmStatic
    public static final a a(com.google.android.libraries.navigation.internal.oe.ad polyline, com.google.android.libraries.navigation.internal.ady.al travelMode) {
        Intrinsics.checkNotNullParameter(polyline, "polyline");
        Intrinsics.checkNotNullParameter(travelMode, "travelMode");
        a aVar = new a();
        Objects.requireNonNull(polyline);
        aVar.c = polyline;
        aVar.f = (short) (aVar.f | 8);
        Objects.requireNonNull(travelMode);
        aVar.a = travelMode;
        aVar.f = (short) (aVar.f | 1);
        return aVar;
    }
}

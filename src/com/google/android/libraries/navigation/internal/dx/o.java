package com.google.android.libraries.navigation.internal.dx;

import com.google.android.libraries.navigation.internal.ace.mw;
import com.google.android.libraries.navigation.internal.hn.r;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o {
    private final r a;

    public o(r midTripParameters, com.google.android.libraries.navigation.internal.av.a projectedLifecycle) {
        Intrinsics.checkNotNullParameter(midTripParameters, "midTripParameters");
        Intrinsics.checkNotNullParameter(projectedLifecycle, "projectedLifecycle");
        this.a = midTripParameters;
    }

    public final boolean a() {
        return ((mw) this.a.b()).b;
    }
}

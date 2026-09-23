package com.google.android.libraries.navigation.internal.cu;

import com.google.android.libraries.navigation.internal.hn.r;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    public final r a;
    private final Lazy b;

    public d(r mapContentParameters) {
        Intrinsics.checkNotNullParameter(mapContentParameters, "mapContentParameters");
        this.a = mapContentParameters;
        this.b = LazyKt.lazy(new c(this));
    }

    public final boolean a() {
        return ((Boolean) this.b.getValue()).booleanValue();
    }
}

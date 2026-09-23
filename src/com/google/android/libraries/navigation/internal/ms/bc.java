package com.google.android.libraries.navigation.internal.ms;

import java.util.HashSet;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bc {
    public final Function1 a;

    public bc(Function1 invalidate) {
        Intrinsics.checkNotNullParameter(invalidate, "invalidate");
        this.a = invalidate;
        new HashSet();
    }
}

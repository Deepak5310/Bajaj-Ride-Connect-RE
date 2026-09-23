package com.google.android.libraries.navigation.internal.cv;

import com.google.android.libraries.navigation.internal.nt.m;
import com.google.android.libraries.navigation.internal.nt.o;
import com.google.android.libraries.navigation.internal.nt.p;
import java.util.EnumSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e {
    private final p a = new p();

    public static final EnumSet b() {
        EnumSet enumSetNoneOf = EnumSet.noneOf(a.class);
        Intrinsics.checkNotNullExpressionValue(enumSetNoneOf, "noneOf(...)");
        return enumSetNoneOf;
    }

    public static final void c(a layer) {
        Intrinsics.checkNotNullParameter(layer, "layer");
    }

    public final m a() {
        o oVar = this.a.a;
        Intrinsics.checkNotNullExpressionValue(oVar, "getObservableState(...)");
        return oVar;
    }
}

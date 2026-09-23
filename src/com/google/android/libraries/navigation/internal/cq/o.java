package com.google.android.libraries.navigation.internal.cq;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class o extends FunctionReferenceImpl implements Function1 {
    public o(Object obj) {
        super(1, obj, com.google.android.libraries.navigation.internal.yx.aa.class, "apply", "apply(Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        y p0 = (y) obj;
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (z) ((com.google.android.libraries.navigation.internal.yx.aa) this.receiver).ak(p0);
    }
}

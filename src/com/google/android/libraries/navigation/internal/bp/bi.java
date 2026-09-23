package com.google.android.libraries.navigation.internal.bp;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class bi {
    public static com.google.android.libraries.navigation.internal.oe.x a(bj bjVar, bq step) {
        Intrinsics.checkNotNullParameter(step, "step");
        List listQ = ((ag) bjVar).a.q();
        Intrinsics.checkNotNullExpressionValue(listQ, "getVertices(...)");
        return (com.google.android.libraries.navigation.internal.oe.x) CollectionsKt.getOrNull(listQ, bjVar.a(step));
    }
}

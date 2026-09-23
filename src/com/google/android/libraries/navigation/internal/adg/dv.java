package com.google.android.libraries.navigation.internal.adg;

import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dv {
    public static final du a = new du();
    private final dq b;

    public dv(dq dqVar) {
        this.b = dqVar;
    }

    public final /* synthetic */ dt a() {
        com.google.android.libraries.navigation.internal.ael.bi biVarT = this.b.t();
        Intrinsics.checkNotNullExpressionValue(biVarT, "build(...)");
        return (dt) biVarT;
    }

    public final /* synthetic */ com.google.android.libraries.navigation.internal.aem.a b() {
        List listUnmodifiableList = Collections.unmodifiableList(((dt) this.b.b).c);
        Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "getElementList(...)");
        return new com.google.android.libraries.navigation.internal.aem.a(listUnmodifiableList);
    }

    public final /* synthetic */ void c(com.google.android.libraries.navigation.internal.aem.a aVar, dp value) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        this.b.e(value);
    }
}

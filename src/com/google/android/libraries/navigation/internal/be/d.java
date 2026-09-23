package com.google.android.libraries.navigation.internal.be;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class d extends Lambda implements Function1 {
    public static final d a = new d();

    public d() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        f it2 = (f) obj;
        Intrinsics.checkNotNullParameter(it2, "it");
        return Double.valueOf(it2.c);
    }
}

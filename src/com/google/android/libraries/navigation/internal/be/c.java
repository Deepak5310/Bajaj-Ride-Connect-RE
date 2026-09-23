package com.google.android.libraries.navigation.internal.be;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c extends Lambda implements Function1 {
    public static final c a = new c();

    public c() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        f it2 = (f) obj;
        Intrinsics.checkNotNullParameter(it2, "it");
        return Integer.valueOf(it2.b);
    }
}

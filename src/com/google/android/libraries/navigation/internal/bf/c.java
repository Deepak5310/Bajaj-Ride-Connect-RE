package com.google.android.libraries.navigation.internal.bf;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements d {
    public static final c a = new c();
    private static final f b;

    static {
        f fVar = f.a;
        Intrinsics.checkNotNullExpressionValue(fVar, "getDefaultInstance(...)");
        b = fVar;
    }

    private c() {
    }

    @Override // com.google.android.libraries.navigation.internal.bf.d
    public final f a() {
        return b;
    }
}

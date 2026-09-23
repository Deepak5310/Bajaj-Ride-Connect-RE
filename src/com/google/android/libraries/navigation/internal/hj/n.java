package com.google.android.libraries.navigation.internal.hj;

import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n extends i {
    public static final l a = new l();
    private final boolean b;
    private final String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(String name, String type) {
        super(name, type);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        if (!Intrinsics.areEqual("com.google", type)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        LazyKt.lazy(new m(this));
        f fVar = f.UNKNOWN;
        this.b = true;
        this.d = name;
    }

    @Override // com.google.android.libraries.navigation.internal.hj.i
    public final String c() {
        throw new IllegalStateException("Must set accountIdProvider when using Gaia GmmAccounts");
    }

    @Override // com.google.android.libraries.navigation.internal.hj.i
    public final String d() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.hj.i
    public final boolean e() {
        return this.b;
    }
}

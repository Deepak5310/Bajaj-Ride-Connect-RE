package com.google.android.libraries.navigation.internal.hj;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o extends i {
    private final boolean a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(String sessionId) {
        super("incognito@".concat(String.valueOf(StringsKt.removePrefix(sessionId, (CharSequence) "incognito@"))), "com.google.android.apps.maps");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        f fVar = f.UNKNOWN;
        this.a = true;
    }

    @Override // com.google.android.libraries.navigation.internal.hj.i
    public final boolean f() {
        return this.a;
    }
}

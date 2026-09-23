package com.google.android.libraries.navigation.internal.hx;

import android.os.HandlerThread;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class z extends HandlerThread implements ao {
    private final ap a;

    public z(ap apVar) {
        super(apVar.N, apVar.b());
        this.a = apVar;
    }

    @Override // com.google.android.libraries.navigation.internal.hx.ao
    public final ap a() {
        return this.a;
    }
}

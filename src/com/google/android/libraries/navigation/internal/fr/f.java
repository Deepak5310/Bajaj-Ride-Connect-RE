package com.google.android.libraries.navigation.internal.fr;

import java.util.concurrent.Executor;
import org.chromium.net.CronetEngine;
import org.chromium.net.NetworkQualityRttListener;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class f extends NetworkQualityRttListener {
    final /* synthetic */ e a;
    final /* synthetic */ com.google.android.libraries.navigation.internal.agl.a b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Executor executor, e eVar, com.google.android.libraries.navigation.internal.agl.a aVar) {
        super(executor);
        this.a = eVar;
        this.b = aVar;
    }

    @Override // org.chromium.net.NetworkQualityRttListener
    public final void onRttObservation(int i, long j, int i2) {
        this.a.f(((CronetEngine) this.b.a()).getEffectiveConnectionType());
    }
}

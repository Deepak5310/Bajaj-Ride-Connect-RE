package com.google.android.libraries.navigation.internal.xd;

import android.content.Context;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.runtime.TransportRuntime;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class q implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;

    public q(com.google.android.libraries.navigation.internal.agl.a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        TransportRuntime.initialize((Context) ((com.google.android.libraries.navigation.internal.afr.g) this.a).a);
        TransportFactory transportFactoryNewFactory = TransportRuntime.getInstance().newFactory("cct");
        com.google.android.libraries.navigation.internal.afr.j.d(transportFactoryNewFactory);
        return transportFactoryNewFactory;
    }
}

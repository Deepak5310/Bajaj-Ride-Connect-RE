package com.google.android.libraries.navigation.internal.fy;

import java.net.URL;
import org.chromium.net.CronetEngine;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;

    public c(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2) {
        aVar.getClass();
        this.a = aVar;
        this.b = aVar2;
    }

    public final /* synthetic */ e a(URL url) {
        CronetEngine cronetEngine = (CronetEngine) this.a.a();
        cronetEngine.getClass();
        ((g) this.b.a()).getClass();
        url.getClass();
        return new b(cronetEngine, url);
    }
}

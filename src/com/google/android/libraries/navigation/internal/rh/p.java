package com.google.android.libraries.navigation.internal.rh;

import com.google.android.libraries.navigation.internal.adg.bg;
import com.google.android.libraries.navigation.internal.yx.an;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p {
    private final com.google.android.libraries.navigation.internal.ob.g a;
    private final an b;
    private final s c;
    private final com.google.android.libraries.navigation.internal.rl.u d;

    public p(com.google.android.libraries.navigation.internal.ob.g gVar, com.google.android.libraries.navigation.internal.rl.u uVar, an anVar, s sVar) {
        this.a = gVar;
        this.d = uVar;
        this.b = anVar;
        this.c = sVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* bridge */ /* synthetic */ r a(bg bgVar, com.google.android.libraries.navigation.internal.rl.d dVar) {
        return new o(bgVar, this.a, this.b, dVar, new com.google.android.libraries.navigation.internal.or.a(this.c.a.getAndIncrement()));
    }
}

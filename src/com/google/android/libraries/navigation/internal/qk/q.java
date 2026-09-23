package com.google.android.libraries.navigation.internal.qk;

import com.google.android.libraries.navigation.internal.yz.ev;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class q {
    public t a;
    public final com.google.android.libraries.navigation.internal.oe.x b;
    public boolean c;
    public com.google.android.libraries.navigation.internal.adg.b d;
    public o e;
    public ev f;
    public com.google.android.libraries.navigation.internal.pb.k g;
    public com.google.android.libraries.navigation.internal.rf.g h;
    public al i;

    public q(t tVar, com.google.android.libraries.navigation.internal.oe.x xVar, com.google.android.libraries.navigation.internal.adg.b bVar, com.google.android.libraries.navigation.internal.rf.g gVar, o oVar, al alVar, ev evVar, com.google.android.libraries.navigation.internal.pb.k kVar) {
        com.google.android.libraries.navigation.internal.oe.x xVar2 = new com.google.android.libraries.navigation.internal.oe.x();
        this.b = xVar2;
        this.c = false;
        this.a = tVar;
        if (xVar != null) {
            xVar2.W(xVar);
            this.c = true;
        }
        this.d = bVar;
        this.h = gVar;
        this.e = oVar;
        this.i = alVar;
        this.f = evVar;
        this.g = kVar;
    }

    public final com.google.android.libraries.navigation.internal.oe.x a() {
        if (this.c) {
            return this.b;
        }
        return null;
    }
}

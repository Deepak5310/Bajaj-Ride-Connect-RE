package com.google.android.libraries.geo.mapcore.internal.model;

import com.google.android.libraries.navigation.internal.adg.jd;
import com.google.android.libraries.navigation.internal.adg.jf;
import com.google.android.libraries.navigation.internal.yz.ev;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class ci {
    public final com.google.android.libraries.navigation.internal.agh.be a = new com.google.android.libraries.navigation.internal.agh.bu();
    public final ev b;

    public ci(jf jfVar) {
        this.b = ev.o(jfVar.c);
        for (jd jdVar : jfVar.b) {
            this.a.a((jdVar.b << 32) | ((long) jdVar.c), jdVar.d);
        }
    }
}

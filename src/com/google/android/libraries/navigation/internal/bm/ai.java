package com.google.android.libraries.navigation.internal.bm;

import com.google.android.libraries.navigation.internal.adr.el;
import com.google.android.libraries.navigation.internal.adr.fg;
import com.google.android.libraries.navigation.internal.adr.fh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ai {
    final /* synthetic */ am a;

    public ai(am amVar) {
        this.a = amVar;
    }

    public final void a(el elVar, com.google.android.libraries.navigation.internal.yx.an anVar) {
        fg fgVar = (elVar.c == 22 ? (fh) elVar.d : fh.a).k;
        if (fgVar == null) {
            fgVar = fg.a;
        }
        com.google.android.libraries.navigation.internal.pf.c cVarA = com.google.android.libraries.navigation.internal.pf.c.a(elVar, com.google.android.libraries.navigation.internal.oe.ad.m(fgVar.c == 1 ? (com.google.android.libraries.navigation.internal.adr.ab) fgVar.d : com.google.android.libraries.navigation.internal.adr.ab.a), anVar);
        if (cVarA != null) {
            this.a.c.g(new com.google.android.libraries.navigation.internal.pi.x(cVarA));
        }
    }
}

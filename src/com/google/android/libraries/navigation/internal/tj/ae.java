package com.google.android.libraries.navigation.internal.tj;

import com.google.android.libraries.navigation.internal.adr.eu;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.afl.fr;
import com.google.android.libraries.navigation.internal.afl.fs;
import com.google.android.libraries.navigation.internal.sk.dt;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ae {
    public final dt a;
    private final Executor b;
    private final com.google.android.libraries.navigation.internal.rw.f c;
    private final com.google.android.libraries.navigation.internal.mj.a d;
    private final com.google.android.libraries.navigation.internal.hn.r e;
    private final com.google.android.libraries.navigation.internal.sn.h f;

    public ae(Executor executor, com.google.android.libraries.navigation.internal.rw.f fVar, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.hn.r rVar, com.google.android.libraries.navigation.internal.sn.h hVar, dt dtVar) {
        this.b = executor;
        this.c = fVar;
        this.d = aVar;
        this.e = rVar;
        this.f = hVar;
        this.a = dtVar;
    }

    public final com.google.android.libraries.navigation.internal.vn.d a(com.google.android.libraries.navigation.internal.tt.d dVar) {
        fr frVar = ((fs) this.e.b()).aF;
        if (frVar == null) {
            frVar = fr.a;
        }
        if (frVar.d && dVar.F() == eu.b) {
            return new com.google.android.libraries.navigation.internal.vn.d(com.google.android.libraries.navigation.internal.vn.c.PREROLL_SOUND_ONLY, null, "", null, null, com.google.android.libraries.navigation.internal.dw.g.i);
        }
        com.google.android.libraries.navigation.internal.adr.n nVar = (com.google.android.libraries.navigation.internal.adr.n) com.google.android.libraries.navigation.internal.hc.a.e(dVar.e(), (dg) com.google.android.libraries.navigation.internal.adr.n.a.aH(7, null), com.google.android.libraries.navigation.internal.adr.n.a);
        if (nVar != null) {
            return this.f.c(com.google.android.libraries.navigation.internal.dw.g.i, ev.q(nVar), -1, null);
        }
        return null;
    }
}

package com.google.android.libraries.navigation.internal.bi;

import com.google.android.libraries.navigation.internal.adq.be;
import com.google.android.libraries.navigation.internal.adr.ls;
import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.afl.lj;
import com.google.android.libraries.navigation.internal.afl.lz;
import com.google.android.libraries.navigation.internal.afl.mj;
import com.google.android.libraries.navigation.internal.yx.an;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class m {
    private static final com.google.android.libraries.navigation.internal.zb.j b = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.bi.m");
    public final an a;
    private final com.google.android.libraries.navigation.internal.gq.j c;

    public m(an anVar, com.google.android.libraries.navigation.internal.gq.j jVar) {
        this.a = an.i(anVar.g() ? (com.google.android.libraries.navigation.internal.az.a) ((com.google.android.libraries.navigation.internal.agl.a) anVar.c()).a() : null);
        this.c = jVar;
    }

    public static boolean b(lz lzVar) {
        lj ljVar = lzVar.c;
        if (ljVar == null) {
            ljVar = lj.a;
        }
        return ljVar.c.size() >= 2;
    }

    public static int c(lz lzVar) {
        lj ljVar = lzVar.c;
        if (ljVar == null) {
            ljVar = lj.a;
        }
        mj mjVar = ljVar.f319n;
        if (mjVar == null) {
            mjVar = mj.a;
        }
        if ((mjVar.b & 1) == 0) {
            return 0;
        }
        mj mjVar2 = ljVar.f319n;
        if (mjVar2 == null) {
            mjVar2 = mj.a;
        }
        int iA = be.a(mjVar2.c);
        return iA == 0 ? be.a : iA;
    }

    private static boolean d(lz lzVar) {
        lj ljVar = lzVar.c;
        if (ljVar == null) {
            ljVar = lj.a;
        }
        Iterator it2 = ljVar.c.iterator();
        while (it2.hasNext()) {
            com.google.android.libraries.navigation.internal.adr.lj ljVarB = com.google.android.libraries.navigation.internal.adr.lj.b(((ls) it2.next()).k);
            if (ljVarB == null) {
                ljVarB = com.google.android.libraries.navigation.internal.adr.lj.ENTITY_TYPE_DEFAULT;
            }
            if (ljVarB == com.google.android.libraries.navigation.internal.adr.lj.ENTITY_TYPE_MY_LOCATION) {
                return true;
            }
        }
        return false;
    }

    public final j a(lz lzVar, boolean z, long j, h hVar, boolean z2) {
        lz lzVar2;
        com.google.android.libraries.navigation.internal.gh.d dVar;
        com.google.android.libraries.navigation.internal.gg.e eVar;
        a aVar = new a();
        aVar.f = (byte) (aVar.f | 4);
        Objects.requireNonNull(lzVar);
        aVar.a = lzVar;
        aVar.c = z;
        byte b2 = aVar.f;
        aVar.d = j;
        aVar.f = (byte) (b2 | 3);
        com.google.android.libraries.navigation.internal.gd.i iVar = new com.google.android.libraries.navigation.internal.gh.d(this.c.b()).b;
        bb bbVar = (bb) iVar.aH(5, null);
        bbVar.x(iVar);
        com.google.android.libraries.navigation.internal.gd.f fVar = (com.google.android.libraries.navigation.internal.gd.f) bbVar;
        boolean zD = d(lzVar);
        if (!fVar.b.H()) {
            fVar.v();
        }
        com.google.android.libraries.navigation.internal.gd.i iVar2 = (com.google.android.libraries.navigation.internal.gd.i) fVar.b;
        iVar2.b |= 2;
        iVar2.d = zD;
        if (!fVar.b.H()) {
            fVar.v();
        }
        com.google.android.libraries.navigation.internal.gd.i iVar3 = (com.google.android.libraries.navigation.internal.gd.i) fVar.b;
        iVar3.b |= 512;
        iVar3.l = true;
        com.google.android.libraries.navigation.internal.gd.i iVar4 = (com.google.android.libraries.navigation.internal.gd.i) fVar.t();
        com.google.android.libraries.navigation.internal.gh.c cVar = new com.google.android.libraries.navigation.internal.gh.c();
        com.google.android.libraries.navigation.internal.gd.j jVar = (com.google.android.libraries.navigation.internal.gd.j) com.google.android.libraries.navigation.internal.gd.k.a.q();
        if (!jVar.b.H()) {
            jVar.v();
        }
        com.google.android.libraries.navigation.internal.gd.k kVar = (com.google.android.libraries.navigation.internal.gd.k) jVar.b;
        kVar.b |= 2;
        kVar.d = 1;
        cVar.a((com.google.android.libraries.navigation.internal.gd.k) jVar.t());
        cVar.a = iVar4;
        aVar.b = new com.google.android.libraries.navigation.internal.gh.d(cVar);
        aVar.e = new l(this, hVar);
        if (aVar.f != 7 || (lzVar2 = aVar.a) == null || (dVar = aVar.b) == null || (eVar = aVar.e) == null) {
            throw new IllegalStateException();
        }
        return new b(lzVar2, dVar, aVar.c, aVar.d, eVar);
    }
}

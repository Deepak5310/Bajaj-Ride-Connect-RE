package com.google.android.libraries.navigation.internal.qx;

import com.google.android.libraries.navigation.internal.ael.x;
import com.google.android.libraries.navigation.internal.afm.ah;
import com.google.android.libraries.navigation.internal.afm.ai;
import com.google.android.libraries.navigation.internal.km.aq;
import com.google.android.libraries.navigation.internal.yx.am;
import com.google.android.libraries.navigation.internal.yx.bj;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class m implements com.google.android.libraries.navigation.internal.gg.e {
    final /* synthetic */ q a;
    private final String b;
    private final com.google.android.libraries.navigation.internal.qz.k c;

    public m(q qVar, String str, com.google.android.libraries.navigation.internal.qz.k kVar) {
        this.a = qVar;
        this.b = str;
        this.c = kVar;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.e
    public final void a(com.google.android.libraries.navigation.internal.gg.i iVar, com.google.android.libraries.navigation.internal.gg.o oVar) {
        if (am.a(oVar, com.google.android.libraries.navigation.internal.gg.o.b)) {
            this.c.o(2);
        } else {
            this.c.o(1);
        }
        this.c.j(false);
        this.c.i();
        ((com.google.android.libraries.navigation.internal.kk.l) ((com.google.android.libraries.navigation.internal.kl.b) this.a.b.a()).a(com.google.android.libraries.navigation.internal.km.p.ax)).a(iVar.b.c.toMillis() - iVar.b.b.toMillis());
        ((com.google.android.libraries.navigation.internal.kk.k) ((com.google.android.libraries.navigation.internal.kl.b) this.a.b.a()).a(com.google.android.libraries.navigation.internal.km.p.ay)).a(oVar.e().y);
    }

    @Override // com.google.android.libraries.navigation.internal.gg.e
    public final /* bridge */ /* synthetic */ void b(com.google.android.libraries.navigation.internal.gg.i iVar, Object obj) {
        com.google.android.libraries.navigation.internal.gj.f fVar = (com.google.android.libraries.navigation.internal.gj.f) obj;
        ah ahVar = (ah) ai.a.q();
        if (!ahVar.b.H()) {
            ahVar.v();
        }
        ai aiVar = (ai) ahVar.b;
        aiVar.b |= 4;
        aiVar.e = 0L;
        if (!ahVar.b.H()) {
            ahVar.v();
        }
        ai aiVar2 = (ai) ahVar.b;
        aiVar2.b |= 2;
        aiVar2.d = 200;
        String str = this.b;
        if (!ahVar.b.H()) {
            ahVar.v();
        }
        ai aiVar3 = (ai) ahVar.b;
        str.getClass();
        aiVar3.b |= 1;
        aiVar3.c = str;
        x xVar = fVar.c;
        if (!ahVar.b.H()) {
            ahVar.v();
        }
        ai aiVar4 = (ai) ahVar.b;
        xVar.getClass();
        aiVar4.b |= 8;
        aiVar4.f = xVar;
        String str2 = fVar.d;
        if ((fVar.b & 2) != 0 && !str2.isEmpty()) {
            List listI = bj.b(';').i(str2);
            if (!listI.isEmpty()) {
                String str3 = (String) listI.get(0);
                if (!ahVar.b.H()) {
                    ahVar.v();
                }
                ai aiVar5 = (ai) ahVar.b;
                str3.getClass();
                aiVar5.b |= 16;
                aiVar5.g = str3;
            }
        }
        final ai aiVar6 = (ai) ahVar.t();
        synchronized (this.c) {
            boolean zR = this.c.r(aiVar6);
            if (this.a.l != null && zR && this.c.b) {
                this.a.f.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qx.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        m mVar = this.a;
                        if (mVar.a.l != null) {
                            mVar.a.l.a(aiVar6);
                        }
                    }
                });
            }
            this.c.j(false);
            this.c.i();
        }
        ((com.google.android.libraries.navigation.internal.kk.l) ((com.google.android.libraries.navigation.internal.kl.b) this.a.b.a()).a(com.google.android.libraries.navigation.internal.km.p.ax)).a(iVar.b.c.toMillis() - iVar.b.b.toMillis());
        ((com.google.android.libraries.navigation.internal.kk.k) ((com.google.android.libraries.navigation.internal.kl.b) this.a.b.a()).a(com.google.android.libraries.navigation.internal.km.p.ay)).a(aq.SUCCESS.y);
    }
}

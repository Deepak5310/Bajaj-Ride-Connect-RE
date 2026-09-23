package com.google.android.libraries.navigation.internal.vd;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.google.android.libraries.navigation.internal.adg.cx;
import com.google.android.libraries.navigation.internal.adg.dy;
import com.google.android.libraries.navigation.internal.adg.ef;
import com.google.android.libraries.navigation.internal.adg.fr;
import com.google.android.libraries.navigation.internal.adg.fs;
import com.google.android.libraries.navigation.internal.adg.fu;
import com.google.android.libraries.navigation.internal.adg.jr;
import com.google.android.libraries.navigation.internal.cl.ai;
import com.google.android.libraries.navigation.internal.cl.aj;
import com.google.android.libraries.navigation.internal.cl.t;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.po.aa;
import com.google.android.libraries.navigation.internal.po.dh;
import com.google.android.libraries.navigation.internal.po.fk;
import com.google.android.libraries.navigation.internal.qk.u;
import com.google.android.libraries.navigation.internal.qk.v;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class r extends com.google.android.libraries.navigation.internal.ia.k {
    public r(Class cls, q qVar, ap apVar) {
        super(cls, qVar, apVar, null);
    }

    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        int i;
        com.google.android.libraries.navigation.internal.cs.a aVar2;
        Bitmap bitmapCreateBitmap;
        q qVar = (q) this.c;
        com.google.android.libraries.navigation.internal.ve.a aVar3 = (com.google.android.libraries.navigation.internal.ve.a) aVar;
        com.google.android.libraries.navigation.internal.vg.b bVarE = aVar3.e();
        Drawable drawableC = aVar3.c();
        if (drawableC != null) {
            int iCeil = (int) Math.ceil(qVar.e.getResources().getDisplayMetrics().density);
            if (drawableC.getIntrinsicWidth() <= 0 || drawableC.getIntrinsicHeight() <= 0) {
                bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            } else {
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(drawableC.getIntrinsicWidth(), drawableC.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                int i2 = ai.PHONE.d * iCeil;
                bitmapCreateBitmap = Bitmap.createScaledBitmap(bitmapCreateBitmap2, i2, i2, true);
            }
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawableC.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawableC.draw(canvas);
            String strA = com.google.android.libraries.navigation.internal.ks.a.a(bitmapCreateBitmap);
            i = iCeil;
            bVarE = new com.google.android.libraries.navigation.internal.vg.a(strA, strA);
        } else {
            i = 1;
        }
        if (bVarE == null) {
            return;
        }
        x xVarD = aVar3.d();
        String strF = aVar3.f();
        if (qVar.p == null) {
            qVar.q = qVar.c.K();
            qVar.p = new t(qVar.e, ((fk) qVar.c.b()).I, qVar.d, qVar.q, false, qVar.j, qVar.k, qVar.l, qVar.m);
        }
        if (!qVar.o) {
            t tVar = qVar.p;
            ar.q(tVar);
            com.google.android.libraries.navigation.internal.oj.c cVarC = tVar.c();
            t tVar2 = qVar.p;
            ar.q(tVar2);
            if (tVar2.n(cVarC, 1L, qVar.q ? ((com.google.android.libraries.navigation.internal.vg.a) bVarE).b : ((com.google.android.libraries.navigation.internal.vg.a) bVarE).a, xVarD, null, i)) {
                ar.q(cVarC);
                q.a(cVarC.c(), q.r.a);
                aa aaVarN = ((dh) qVar.f).n(((com.google.android.libraries.navigation.internal.oj.a) cVarC).e(), jr.WORLD_ENCODING_LAT_LNG_E7);
                if (strF != null) {
                    aaVarN.k(new p(qVar, bVarE, strF));
                }
                com.google.android.libraries.navigation.internal.qk.i iVar = qVar.g;
                com.google.android.libraries.navigation.internal.qk.g gVarG = com.google.android.libraries.navigation.internal.qk.h.g();
                gVarG.b(aaVarN);
                gVarG.c(qVar.h);
                gVarG.f(com.google.android.libraries.navigation.internal.qk.t.JAMCIDENTS);
                gVarG.d(0);
                gVarG.e(aj.b);
                com.google.android.libraries.navigation.internal.qk.ai aiVar = new com.google.android.libraries.navigation.internal.qk.ai(iVar, gVarG.g());
                qVar.f637n.add(aiVar);
                aiVar.f();
                return;
            }
            return;
        }
        t tVar3 = qVar.p;
        ar.q(tVar3);
        com.google.android.libraries.navigation.internal.oj.c cVarB = tVar3.b();
        t tVar4 = qVar.p;
        ar.q(tVar4);
        ar.q(cVarB);
        if (tVar4.i(cVarB, 1L, qVar.q ? ((com.google.android.libraries.navigation.internal.vg.a) bVarE).b : ((com.google.android.libraries.navigation.internal.vg.a) bVarE).a, xVarD, null, i)) {
            if (strF != null) {
                aVar2 = new com.google.android.libraries.navigation.internal.cs.a() { // from class: com.google.android.libraries.navigation.internal.vd.o
                };
                dy dyVarC = cVarB.c();
                fr frVar = (fr) fs.a.q();
                frVar.C(fu.w, cx.a);
                fs fsVar = (fs) frVar.t();
                if (!dyVarC.b.H()) {
                    dyVarC.v();
                }
                ef efVar = (ef) dyVarC.b;
                ef efVar2 = ef.a;
                fsVar.getClass();
                efVar.u = fsVar;
                efVar.b |= 65536;
            } else {
                aVar2 = null;
            }
            ar.q(cVarB);
            q.a(cVarB.c(), q.r.a);
            com.google.android.libraries.navigation.internal.op.f fVarE = ((com.google.android.libraries.navigation.internal.oj.b) cVarB).e();
            u uVarJ = v.j();
            uVarJ.d(fVarE);
            uVarJ.f(qVar.h);
            ((com.google.android.libraries.navigation.internal.qk.c) uVarJ).a = xVarD;
            uVarJ.i(com.google.android.libraries.navigation.internal.qk.t.JAMCIDENTS);
            uVarJ.g(0);
            uVarJ.h(aj.b);
            uVarJ.j();
            aVar2.getClass();
            throw null;
        }
    }
}

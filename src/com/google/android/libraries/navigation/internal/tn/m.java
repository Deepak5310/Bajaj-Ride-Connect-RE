package com.google.android.libraries.navigation.internal.tn;

import android.app.Application;
import android.content.Context;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.adr.ar;
import com.google.android.libraries.navigation.internal.adr.bm;
import com.google.android.libraries.navigation.internal.adr.gj;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.bp.bs;
import com.google.android.libraries.navigation.internal.bp.ca;
import com.google.android.libraries.navigation.internal.bp.ck;
import com.google.android.libraries.navigation.internal.hf.u;
import com.google.android.libraries.navigation.internal.nc.ap;
import com.google.android.libraries.navigation.internal.yx.aq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.gs;
import j$.util.DesugarTimeZone;
import java.util.Collection;
import java.util.TimeZone;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m {
    public static final ap a = com.google.android.libraries.navigation.internal.nc.a.g(48);
    public final Context b;
    private final com.google.android.libraries.navigation.internal.afo.a c;
    private final com.google.android.libraries.navigation.internal.mj.a d;
    private final com.google.android.libraries.navigation.internal.hf.n e;
    private final com.google.android.libraries.navigation.internal.hf.n.a f;
    private final com.google.android.libraries.navigation.internal.up.g g;
    private final int h;

    public m(Application application, com.google.android.libraries.navigation.internal.afo.a aVar, com.google.android.libraries.navigation.internal.up.g gVar, com.google.android.libraries.navigation.internal.mj.a aVar2) {
        this.b = application;
        this.c = aVar;
        this.g = gVar;
        this.d = aVar2;
        this.e = new com.google.android.libraries.navigation.internal.hf.n(application.getResources());
        com.google.android.libraries.navigation.internal.hf.n.a aVar3 = new com.google.android.libraries.navigation.internal.hf.n.a();
        aVar3.c();
        this.f = aVar3;
        this.h = application.getResources().getColor(com.google.android.libraries.navigation.internal.dw.a.a);
    }

    private final ev d(com.google.android.libraries.navigation.internal.up.g gVar, Collection collection, int i, int i2) {
        com.google.android.libraries.navigation.internal.up.a aVar = new com.google.android.libraries.navigation.internal.up.a(this.b, collection.size(), 1, Integer.MAX_VALUE, true, null, true, i2, 1.0f, 1.0f, 1.0f, 0, null, null);
        gVar.e(collection, i, false, null, aVar);
        return aVar.d();
    }

    /* JADX WARN: Code duplicated, block: B:71:0x0296  */
    public final p a(com.google.android.libraries.navigation.internal.tj.j jVar) {
        Spannable spannableB;
        String str;
        String str2;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("NavigationSummarizer.generateSummary");
        try {
            o oVarA = p.a();
            bq bqVar = jVar.c().c;
            bg bgVar = jVar.c().b;
            int iC = jVar.c().c();
            int i = jVar.c().k;
            int i2 = 1;
            boolean z = iC != -1;
            boolean z2 = i != -1;
            if (z) {
                long epochSecond = ((long) iC) + this.d.f().getEpochSecond();
                Context context = this.b;
                TimeZone timeZone = DesugarTimeZone.getTimeZone(bgVar.M().getId());
                if (bgVar.g.a.h.size() > 0) {
                    ar arVar = ((gj) bgVar.g.a.h.get(0)).f;
                    if (arVar == null) {
                        arVar = ar.a;
                    }
                    str2 = arVar.d;
                    if (aq.c(str2)) {
                        str2 = "";
                    }
                } else {
                    str2 = "";
                }
                String string = com.google.android.libraries.navigation.internal.hf.s.a(context, epochSecond, timeZone, str2).a.toString();
                com.google.android.libraries.navigation.internal.hf.l lVarE = this.e.e(com.google.android.libraries.navigation.internal.hg.a.a);
                lVarE.a(string);
                oVarA.k(lVarE.b());
                com.google.android.libraries.navigation.internal.hf.l lVarE2 = this.e.e(com.google.android.libraries.navigation.internal.f.h.e);
                lVarE2.a(string);
                oVarA.j(lVarE2.b());
            }
            if (z2) {
                oVarA.e(((com.google.android.libraries.navigation.internal.hf.c) this.c.a()).g(i, bgVar.O, this.f, null));
            }
            p pVarA = oVarA.a();
            if (z && z2) {
                Spanned spannedE = u.e(this.b.getResources(), iC, 2);
                oVarA.i(spannedE);
                com.google.android.libraries.navigation.internal.hf.l lVarE3 = this.e.e(com.google.android.libraries.navigation.internal.dw.h.R);
                lVarE3.a(spannedE, ((b) pVarA).c);
                oVarA.g(lVarE3.b());
                if (bgVar.u() != null) {
                    com.google.android.libraries.navigation.internal.hf.l lVarE4 = this.e.e(com.google.android.libraries.navigation.internal.dw.h.S);
                    lVarE4.a(spannedE, ((b) pVarA).c, bgVar.u().V());
                    oVarA.h(lVarE4.b());
                }
            }
            if (jVar.h) {
                String strV = bgVar.u() != null ? bgVar.u().V() : this.b.getString(com.google.android.libraries.navigation.internal.dw.h.c);
                oVarA.l(strV);
                oVarA.b(strV);
            } else if (com.google.android.libraries.navigation.internal.up.b.b(jVar)) {
                String string2 = this.b.getString(com.google.android.libraries.navigation.internal.up.b.a(jVar));
                oVarA.l(string2);
                oVarA.b(string2);
            } else if (bqVar == null) {
                String string3 = this.b.getString(com.google.android.libraries.navigation.internal.dw.h.l);
                oVarA.l(string3);
                oVarA.b(string3);
            } else {
                bm.a aVar = bgVar.O;
                int i3 = jVar.c().f;
                boolean zE = jVar.e();
                com.google.android.libraries.navigation.internal.yx.ar.q(aVar);
                o oVarA2 = p.a();
                Context context2 = this.b;
                com.google.android.libraries.navigation.internal.hf.c cVar = (com.google.android.libraries.navigation.internal.hf.c) this.c.a();
                Spanned spanned = bqVar.p;
                if (i3 <= 0) {
                    spannableB = com.google.android.libraries.navigation.internal.up.a.o(context2, bqVar);
                } else {
                    CharSequence charSequenceK = com.google.android.libraries.navigation.internal.up.a.k(cVar, i3, aVar);
                    com.google.android.libraries.navigation.internal.hf.l lVarE5 = new com.google.android.libraries.navigation.internal.hf.n(context2.getResources()).e(com.google.android.libraries.navigation.internal.dw.h.j);
                    lVarE5.a(charSequenceK, spanned);
                    spannableB = lVarE5.b();
                    Object[] spans = spannableB.getSpans(0, spannableB.length(), bs.class);
                    int length = spans.length;
                    int i4 = 0;
                    while (i4 < length) {
                        bs bsVar = (bs) spans[i4];
                        spannableB.setSpan(new StyleSpan(i2), spannableB.getSpanStart(bsVar), spannableB.getSpanEnd(bsVar), 33);
                        spannableB.removeSpan(bsVar);
                        i4++;
                        spans = spans;
                        length = length;
                        i2 = 1;
                    }
                }
                oVarA2.l(spannableB);
                oVarA2.c(com.google.android.libraries.navigation.internal.up.a.o(this.b, bqVar));
                oVarA2.f(com.google.android.libraries.navigation.internal.up.a.k((com.google.android.libraries.navigation.internal.hf.c) this.c.a(), i3, aVar));
                oVarA2.b(c(bqVar, false, zE));
                oVarA2.m(b(bqVar, true));
                p pVarA2 = oVarA2.a();
                oVarA.l(((b) pVarA2).b);
                oVarA.c(((b) pVarA2).i);
                oVarA.f(((b) pVarA2).j);
                oVarA.b(((b) pVarA2).k);
                oVarA.m(((b) pVarA2).l);
            }
            ck ckVarU = bgVar.u();
            this.b.getResources();
            int iOrdinal = ckVarU.s().ordinal();
            String strY = (iOrdinal == 1 || iOrdinal == 2 || iOrdinal != 5 || aq.c(ckVarU.y())) ? null : ckVarU.y();
            if (strY == null) {
                com.google.android.libraries.navigation.internal.adr.b bVar = (com.google.android.libraries.navigation.internal.adr.b) com.google.android.libraries.navigation.internal.hc.a.e(ckVarU.d(), (dg) com.google.android.libraries.navigation.internal.adr.b.a.aH(7, null), com.google.android.libraries.navigation.internal.adr.b.a);
                if (bVar != null) {
                    int i5 = bVar.b;
                    if ((i5 & 1) != 0) {
                        str = bVar.d;
                    } else if ((i5 & 4) != 0) {
                        str = bVar.e;
                    } else {
                        str = null;
                    }
                } else {
                    str = null;
                }
                strY = str == null ? ckVarU.aa() : str;
            }
            oVarA.d(strY);
            p pVarA3 = oVarA.a();
            if (dVarB != null) {
                Trace.endSection();
            }
            return pVarA3;
        } catch (Throwable th) {
            if (dVarB == null) {
                throw th;
            }
            try {
                Trace.endSection();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    public final CharSequence b(bq bqVar, boolean z) {
        return c(bqVar, z, false);
    }

    public final CharSequence c(bq bqVar, boolean z, boolean z2) {
        bs bsVarC = ca.c(bqVar);
        if (z2 && bsVarC != null) {
            com.google.android.libraries.navigation.internal.up.a aVar = new com.google.android.libraries.navigation.internal.up.a(this.b, 1, 1, -1, true, null, false, this.h, 1.0f, 1.0f, 1.0f, 0, null, null);
            this.g.g(bsVarC, aVar);
            return (CharSequence) aVar.d().get(0);
        }
        com.google.android.libraries.navigation.internal.up.e eVarF = com.google.android.libraries.navigation.internal.up.g.f(this.b, bqVar, 2);
        if (eVarF.a.isEmpty()) {
            return bqVar.p;
        }
        CharSequence charSequence = (CharSequence) gs.c(d(this.g, eVarF.a, eVarF.c, this.h), "");
        if (z) {
            return charSequence;
        }
        CharSequence charSequence2 = (CharSequence) gs.c(d(this.g, eVarF.b, eVarF.d, this.h), "");
        return !TextUtils.isEmpty(charSequence2) ? TextUtils.concat(charSequence, StringUtils.SPACE, charSequence2) : charSequence;
    }
}

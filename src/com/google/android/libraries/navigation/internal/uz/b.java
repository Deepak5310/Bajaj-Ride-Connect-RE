package com.google.android.libraries.navigation.internal.uz;

import android.content.Context;
import android.text.Spanned;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.aap.l;
import com.google.android.libraries.navigation.internal.ace.ej;
import com.google.android.libraries.navigation.internal.adr.Cif;
import com.google.android.libraries.navigation.internal.adr.bm;
import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.gw.x;
import com.google.android.libraries.navigation.internal.hn.r;
import com.google.android.libraries.navigation.internal.jy.aa;
import com.google.android.libraries.navigation.internal.jy.p;
import com.google.android.libraries.navigation.internal.ms.at;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.nc.ah;
import com.google.android.libraries.navigation.internal.nc.aj;
import com.google.android.libraries.navigation.internal.nc.j;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.List;
import java.util.Optional;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class b implements com.google.android.libraries.navigation.internal.va.b {
    private final bq a;
    private final String b;
    private final CharSequence c;
    private final CharSequence d;
    private final CharSequence e;
    private final ah f;
    private final ah g;
    private final List h;
    private final CharSequence j;
    private final CharSequence k;
    private final aa m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final r f631n;
    private final Runnable i = null;
    private final boolean l = true;

    public b(Context context, bq bqVar, String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, ah ahVar, ah ahVar2, List list, Runnable runnable, r rVar) {
        al alVarB;
        this.a = bqVar;
        this.b = str;
        this.c = charSequence;
        this.d = charSequence2;
        this.e = charSequence3;
        this.f = ahVar;
        this.g = ahVar2;
        this.h = list;
        this.f631n = rVar;
        Cif cif = bqVar.a;
        if (cif == null || (1 & cif.b) == 0) {
            alVarB = null;
        } else {
            alVarB = al.b(cif.c);
            if (alVarB == null) {
                alVarB = al.DRIVE;
            }
        }
        this.m = p(alVarB == al.BICYCLE ? com.google.android.libraries.navigation.internal.afe.c.j : com.google.android.libraries.navigation.internal.afe.i.z, str);
        this.j = charSequence;
        this.k = charSequence3 != null ? context.getString(com.google.android.libraries.navigation.internal.bx.g.s, charSequence3) : null;
    }

    public static b e(c cVar, com.google.android.libraries.navigation.internal.cc.b bVar, Context context, bq bqVar, bg bgVar, com.google.android.libraries.navigation.internal.hf.c cVar2, bm.a aVar, com.google.android.libraries.navigation.internal.bn.d dVar, boolean z, Runnable runnable, Integer num) {
        String str;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("DirectionsStepViewModelImpl.createStepViewModel");
        try {
            String strD = bqVar.H;
            if (strD == null) {
                int i = bqVar.l;
                if (i > 0) {
                    strD = cVar2.d(i, aVar, true, true);
                    str = strD;
                } else {
                    str = null;
                }
            } else {
                str = strD;
            }
            ah ahVarO = o(bqVar, dVar, false);
            ah ahVarO2 = o(bqVar, dVar, true);
            ev<com.google.android.libraries.navigation.internal.cb.b> evVarC = com.google.android.libraries.navigation.internal.cc.a.c(bVar, bqVar.z, null);
            String str2 = bqVar.F;
            Spanned spanned = bqVar.p;
            CharSequence charSequence = bqVar.s;
            ((at) cVar.a.a()).getClass();
            evVarC.getClass();
            ((com.google.android.libraries.navigation.internal.fz.d) cVar.b.a()).getClass();
            r rVar = (r) cVar.c.a();
            rVar.getClass();
            b bVar2 = new b(context, bqVar, str2, spanned, charSequence, str, ahVarO, ahVarO2, evVarC, null, rVar);
            if (dVarB != null) {
                Trace.endSection();
            }
            return bVar2;
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

    private static ah o(bq bqVar, com.google.android.libraries.navigation.internal.bn.d dVar, boolean z) {
        String str = bqVar.G;
        if (str != null) {
            ah ahVarB = dVar.b(str, com.google.android.libraries.navigation.internal.bn.a.TRANSIT_AUTO, z, x.c);
            return ahVarB == null ? aj.c() : ahVarB;
        }
        com.google.android.libraries.navigation.internal.bl.d.a aVarF = com.google.android.libraries.navigation.internal.bl.d.f(bqVar);
        return j.j(new com.google.android.libraries.navigation.internal.bl.a(new Object[]{aVarF}, aVarF), j.f(z ? com.google.android.libraries.navigation.internal.f.b.h : com.google.android.libraries.navigation.internal.f.b.s));
    }

    private static aa p(com.google.android.libraries.navigation.internal.afd.a aVar, String str) {
        com.google.android.libraries.navigation.internal.zb.j jVar = aa.a;
        com.google.android.libraries.navigation.internal.jy.x xVar = new com.google.android.libraries.navigation.internal.jy.x();
        xVar.i = aVar;
        return xVar.a(str).b();
    }

    @Override // com.google.android.libraries.navigation.internal.ai.a
    public cs.a a(p pVar) {
        return cs.a.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ai.a
    public Boolean b() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.va.b
    public aa c(Optional<com.google.android.libraries.navigation.internal.afd.a> optional) {
        if (!optional.isPresent()) {
            return this.m;
        }
        return p(optional.get(), this.b);
    }

    @Override // com.google.android.libraries.navigation.internal.va.b
    public ah d() {
        return com.google.android.libraries.navigation.internal.af.e.d(this.f, this.g);
    }

    @Override // com.google.android.libraries.navigation.internal.va.b
    public Boolean f() {
        return Boolean.valueOf(this.a.d == l.DESTINATION);
    }

    @Override // com.google.android.libraries.navigation.internal.va.b
    public CharSequence g() {
        return this.k;
    }

    @Override // com.google.android.libraries.navigation.internal.va.b
    public CharSequence h() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.va.b
    public CharSequence i() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.va.b
    public CharSequence j() {
        return this.j;
    }

    @Override // com.google.android.libraries.navigation.internal.va.b
    public CharSequence k() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.va.b
    public List<com.google.android.libraries.navigation.internal.cb.b> l() {
        return this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.va.b
    public boolean m() {
        boolean z = ((ej) this.f631n.b()).b;
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.va.b
    public boolean n() {
        return true;
    }
}

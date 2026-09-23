package com.google.android.libraries.navigation.internal.abl;

import android.graphics.Bitmap;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.google.android.libraries.navigation.internal.abh.ec;
import com.google.android.libraries.navigation.internal.abh.gr;
import com.google.android.libraries.navigation.internal.abh.gu;
import com.google.android.libraries.navigation.internal.abh.id;
import com.google.android.libraries.navigation.internal.adi.ag;
import com.google.android.libraries.navigation.internal.adi.ai;
import com.google.android.libraries.navigation.internal.adi.aj;
import com.google.android.libraries.navigation.internal.adi.ao;
import com.google.android.libraries.navigation.internal.adi.ap;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class i {
    public static final String a = "i";
    public static final com.google.android.libraries.navigation.internal.b.x b = new c();
    public final TextView c;
    public final Calendar d;
    public volatile int e = 1;
    public volatile String f = null;
    public volatile aj g;
    public volatile String h;
    public List i;
    public aa j;
    public Bitmap k;
    public String l;
    private final j m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final com.google.android.libraries.navigation.internal.b.w f131n;
    private final k o;
    private final boolean p;
    private final ec q;
    private final String r;
    private final id s;
    private final com.google.android.libraries.navigation.internal.abh.d t;
    private com.google.android.libraries.navigation.internal.c.m u;
    private com.google.android.libraries.navigation.internal.c.q v;
    private final Executor w;

    public i(j jVar, TextView textView, com.google.android.libraries.navigation.internal.b.w wVar, k kVar, Calendar calendar, boolean z, ec ecVar, final gu guVar, com.google.android.libraries.navigation.internal.abh.d dVar, String str, id idVar, Executor executor) {
        this.m = jVar;
        this.c = textView;
        this.f131n = wVar;
        this.o = kVar;
        this.d = calendar;
        this.p = z;
        this.q = ecVar;
        this.t = dVar;
        this.r = str;
        this.w = executor;
        this.s = idVar;
        guVar.c(new gr() { // from class: com.google.android.libraries.navigation.internal.abl.b
            @Override // com.google.android.libraries.navigation.internal.abh.gr
            public final void k() {
                i iVar = this.a;
                gu guVar2 = guVar;
                String str2 = guVar2.h;
                aj ajVar = guVar2.i;
                List list = guVar2.j;
                iVar.h = str2;
                iVar.g = ajVar;
                iVar.i = list;
                iVar.b();
            }
        });
    }

    private final boolean e() {
        if (this.u != null) {
            return (this.k == null || (this.p && this.l == null)) ? false : true;
        }
        return true;
    }

    final void a() {
        com.google.android.libraries.navigation.internal.c.m mVar = this.u;
        if (mVar != null) {
            mVar.g();
            this.u = null;
            this.k = null;
        }
        com.google.android.libraries.navigation.internal.c.q qVar = this.v;
        if (qVar != null) {
            qVar.g();
            this.v = null;
            this.l = null;
        }
    }

    final void b() {
        this.q.b(false);
        aa aaVarE = this.o.e();
        if (aaVarE.f <= 0 || aaVarE.g <= 0 || this.g == null || com.google.android.libraries.navigation.internal.abf.x.a(this.h)) {
            return;
        }
        com.google.android.libraries.navigation.internal.adi.h hVar = this.g.g;
        if (hVar == null) {
            hVar = com.google.android.libraries.navigation.internal.adi.h.a;
        }
        int i = aaVarE.f;
        int i2 = aaVarE.g;
        float f = hVar.c;
        int iCeil = (int) Math.ceil(Math.max(i / 2048.0f, i2 / 2048.0f));
        this.j = new aa(aaVarE.e, i, i2, f, aaVarE.a, aaVarE.b, aaVarE.c, aaVarE.d);
        if (this.e == 0) {
            a();
            c();
            return;
        }
        String strD = t.d(this.g, this.j, this.e, null, this.h, iCeil, this.f, this.i, this.s);
        com.google.android.libraries.navigation.internal.c.m mVar = this.u;
        if (mVar != null && strD.equals(mVar.c)) {
            if (e()) {
                this.q.b(true);
                return;
            }
            return;
        }
        a();
        this.u = (com.google.android.libraries.navigation.internal.c.m) this.f131n.a(new g(strD, new d(this, iCeil), this.r));
        if (this.p) {
            aj ajVar = this.g;
            aa aaVar = this.j;
            int i3 = this.e;
            String str = this.h;
            ag agVar = (ag) aj.a.r(ajVar);
            ao aoVarC = t.c(ajVar);
            if (!agVar.b.H()) {
                agVar.v();
            }
            aj ajVar2 = (aj) agVar.b;
            ajVar2.g = null;
            ajVar2.b &= -17;
            int i4 = ai.f;
            if (!agVar.b.H()) {
                agVar.v();
            }
            aj ajVar3 = (aj) agVar.b;
            int i5 = i4 - 1;
            if (i4 == 0) {
                throw null;
            }
            ajVar3.f = i5;
            ajVar3.b |= 8;
            t.f(agVar, aaVar, 1);
            t.g(agVar, aoVarC, i3);
            ap apVar = (ap) aoVarC.t();
            if (!agVar.b.H()) {
                agVar.v();
            }
            aj ajVar4 = (aj) agVar.b;
            apVar.getClass();
            ajVar4.e = apVar;
            ajVar4.b |= 2;
            this.v = (com.google.android.libraries.navigation.internal.c.q) this.f131n.a(new h(t.e((aj) agVar.t(), str), new e(this), this.r));
        }
        if (this.t != null) {
            this.f131n.a(new g(t.d(this.g, this.j, this.e, this.t, this.h, iCeil, "", this.i, this.s), new f(this), this.r));
        }
    }

    public final void c() {
        if (e()) {
            Bitmap bitmap = this.k;
            j jVar = this.m;
            aa aaVar = this.j;
            jVar.c = bitmap;
            jVar.d = aaVar;
            jVar.a.postInvalidate();
            this.w.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abl.a
                @Override // java.lang.Runnable
                public final void run() {
                    i iVar = this.a;
                    String str = iVar.l;
                    TextView textView = iVar.c;
                    if (str != null) {
                        textView.setText(str);
                    } else {
                        textView.setText("");
                    }
                }
            });
            this.q.b(true);
        }
    }

    public final void d() {
        if (this.e == 4 || this.e == 2 || (this.f != null && this.e == 1)) {
            this.c.setTextColor(-1);
        } else {
            this.c.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
    }
}

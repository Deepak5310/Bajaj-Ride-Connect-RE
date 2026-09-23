package com.google.android.libraries.navigation.internal.tc;

import android.os.SystemClock;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.zr.dc;
import com.google.android.libraries.navigation.internal.zr.dd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class m implements com.google.android.libraries.navigation.internal.rw.m, com.google.android.libraries.navigation.internal.rw.r, com.google.android.libraries.navigation.internal.rw.w, com.google.android.libraries.navigation.internal.rw.x, com.google.android.libraries.navigation.internal.rw.aa {
    final /* synthetic */ n a;
    private com.google.android.libraries.navigation.internal.se.b b;

    public m(n nVar) {
        this.a = nVar;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.m
    public final void a(com.google.android.libraries.navigation.internal.tj.o oVar) {
        this.a.m = true;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.aa
    public final void av(com.google.android.libraries.navigation.internal.tj.o oVar, int i, boolean z) {
        if (z) {
            this.a.d(oVar.a(), oVar.c(), this.b);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.rw.w
    public final void b(int i) {
        r rVar = this.a.e;
        if (rVar == null || i != 2) {
            return;
        }
        rVar.b.c();
        q qVar = (q) rVar.a.aO(rVar.c);
        if (qVar != null) {
            qVar.c();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.rw.x
    public final void c(com.google.android.libraries.navigation.internal.tj.o oVar, boolean z) {
        com.google.android.libraries.navigation.internal.db.r rVar;
        com.google.android.libraries.navigation.internal.se.b bVarC = oVar.c();
        bg bgVar = bVarC.b;
        bq bqVar = bVarC.c;
        if (!z) {
            this.a.d(oVar.a(), oVar.c(), this.b);
        }
        aa aaVar = this.a.c;
        if (aaVar == null || bqVar == null) {
            return;
        }
        bq bqVar2 = aaVar.a;
        if (bqVar2 == null || bqVar.N != bqVar2 || bqVar.k >= bgVar.m.e() || (rVar = aaVar.d) == null) {
            aaVar.e = false;
        } else {
            boolean z2 = rVar.e(aaVar.a.c) <= 100.0f;
            if (aaVar.e && z2) {
                bq bqVar3 = aaVar.a;
                long jElapsedRealtime = SystemClock.elapsedRealtime() - aaVar.b;
                int seconds = (int) bqVar3.f355n.toSeconds();
                dc dcVar = (dc) dd.a.q();
                if (!dcVar.b.H()) {
                    dcVar.v();
                }
                dd ddVar = (dd) dcVar.b;
                ddVar.b |= 1;
                ddVar.c = seconds;
                int i = aaVar.c;
                if (seconds != i) {
                    if (!dcVar.b.H()) {
                        dcVar.v();
                    }
                    dd ddVar2 = (dd) dcVar.b;
                    ddVar2.b |= 2;
                    ddVar2.d = i;
                }
                if (!dcVar.b.H()) {
                    dcVar.v();
                }
                dd ddVar3 = (dd) dcVar.b;
                ddVar3.b |= 4;
                ddVar3.e = (int) (jElapsedRealtime / 1000);
                int i2 = bqVar3.l;
                if (!dcVar.b.H()) {
                    dcVar.v();
                }
                dd ddVar4 = (dd) dcVar.b;
                ddVar4.b |= 8;
                ddVar4.f = i2;
                aaVar.f.add((dd) dcVar.t());
            }
            aaVar.e = false;
            if (z2 && bqVar.l >= 300) {
                double dA = bgVar.a(aaVar.a.k);
                double dI = ((double) bgVar.i()) - bgVar.a(bqVar.k);
                if (dA > 1000.0d && dI > 1000.0d) {
                    aaVar.e = true;
                    bq bqVar4 = bqVar.N;
                    aaVar.c = (int) Math.round((bqVar4 != null ? com.google.android.libraries.navigation.internal.aaa.a.a(bgVar.J(bgVar.a(bqVar4.k))) : 0.0d) - com.google.android.libraries.navigation.internal.aaa.a.a(bgVar.J(bgVar.a(bqVar.k))));
                    aaVar.b = SystemClock.elapsedRealtime();
                }
            }
        }
        aaVar.a = bqVar;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.r
    public final void j(com.google.android.libraries.navigation.internal.tj.o oVar, com.google.android.libraries.navigation.internal.db.r rVar) {
        this.b = oVar.c();
    }
}

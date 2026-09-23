package com.google.android.libraries.navigation.internal.ky;

import android.os.SystemClock;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.ael.bb;
import java.util.ArrayList;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class h {
    public final e a;
    public final com.google.android.libraries.navigation.internal.afk.a b;
    protected boolean c;
    public ArrayList d;
    public ArrayList e;
    public final boolean f;
    public Set g;
    public String h;
    public final t i;
    public final bj j;
    public boolean k;
    public int l;

    protected h(e eVar) {
        com.google.android.libraries.navigation.internal.afk.a aVar = (com.google.android.libraries.navigation.internal.afk.a) com.google.android.libraries.navigation.internal.afk.b.a.q();
        this.b = aVar;
        this.c = false;
        this.d = null;
        this.e = null;
        this.f = true;
        this.k = false;
        this.a = eVar;
        this.h = eVar.h;
        q qVar = eVar.f.getApplicationContext() instanceof q ? (q) eVar.f.getApplicationContext() : (q) s.a.get();
        t tVarA = qVar != null ? qVar.a() : null;
        if (tVarA == null) {
            this.i = null;
        } else if (tVarA.a() == com.google.android.libraries.navigation.internal.afk.f.CPS_APP_PROCESS_GLOBAL_PROVIDER || tVarA.a() == com.google.android.libraries.navigation.internal.afk.f.NON_CPS_APP_PROCESS_GLOBAL_PROVIDER) {
            this.i = tVarA;
        } else {
            this.i = null;
        }
        this.j = qVar != null ? qVar.b() : null;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!aVar.b.H()) {
            aVar.v();
        }
        com.google.android.libraries.navigation.internal.afk.b bVar = (com.google.android.libraries.navigation.internal.afk.b) aVar.b;
        bVar.b |= 1;
        bVar.c = jCurrentTimeMillis;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(TimeZone.getDefault().getOffset(((com.google.android.libraries.navigation.internal.afk.b) aVar.b).c));
        if (!aVar.b.H()) {
            aVar.v();
        }
        com.google.android.libraries.navigation.internal.afk.b bVar2 = (com.google.android.libraries.navigation.internal.afk.b) aVar.b;
        bVar2.b |= 131072;
        bVar2.g = seconds;
        if (com.google.android.libraries.navigation.internal.nd.a.b(eVar.f)) {
            if (!aVar.b.H()) {
                aVar.v();
            }
            com.google.android.libraries.navigation.internal.afk.b bVar3 = (com.google.android.libraries.navigation.internal.afk.b) aVar.b;
            bVar3.b |= 8388608;
            bVar3.h = true;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime != 0) {
            if (!aVar.b.H()) {
                aVar.v();
            }
            com.google.android.libraries.navigation.internal.afk.b bVar4 = (com.google.android.libraries.navigation.internal.afk.b) aVar.b;
            bVar4.b |= 2;
            bVar4.d = jElapsedRealtime;
        }
    }

    public final h a(int[] iArr) {
        if (this.a.c()) {
            throw new IllegalArgumentException("addExperimentIds forbidden on deidentified logger");
        }
        if (iArr != null && (iArr.length) != 0) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            for (int i : iArr) {
                this.d.add(Integer.valueOf(i));
            }
        }
        return this;
    }

    public abstract h b();

    public abstract com.google.android.libraries.navigation.internal.me.w c();

    public final void d(t tVar) {
        com.google.android.libraries.navigation.internal.afk.g gVar = ((com.google.android.libraries.navigation.internal.afk.b) this.b.b).j;
        if (gVar == null) {
            gVar = com.google.android.libraries.navigation.internal.afk.g.a;
        }
        bb bbVar = (bb) gVar.aH(5, null);
        bbVar.x(gVar);
        com.google.android.libraries.navigation.internal.afk.d dVar = (com.google.android.libraries.navigation.internal.afk.d) bbVar;
        com.google.android.libraries.navigation.internal.afk.f fVarA = tVar.a();
        if (!dVar.b.H()) {
            dVar.v();
        }
        com.google.android.libraries.navigation.internal.afk.g gVar2 = (com.google.android.libraries.navigation.internal.afk.g) dVar.b;
        gVar2.d = fVarA.l;
        gVar2.b |= 2;
        com.google.android.libraries.navigation.internal.afa.d dVar2 = ((com.google.android.libraries.navigation.internal.afk.g) dVar.b).c;
        if (dVar2 == null) {
            dVar2 = com.google.android.libraries.navigation.internal.afa.d.a;
        }
        bb bbVar2 = (bb) dVar2.aH(5, null);
        bbVar2.x(dVar2);
        com.google.android.libraries.navigation.internal.afa.c cVar = (com.google.android.libraries.navigation.internal.afa.c) bbVar2;
        com.google.android.libraries.navigation.internal.afa.b bVar = ((com.google.android.libraries.navigation.internal.afa.d) cVar.b).c;
        if (bVar == null) {
            bVar = com.google.android.libraries.navigation.internal.afa.b.a;
        }
        bb bbVar3 = (bb) bVar.aH(5, null);
        bbVar3.x(bVar);
        com.google.android.libraries.navigation.internal.afa.a aVar = (com.google.android.libraries.navigation.internal.afa.a) bbVar3;
        if (!aVar.b.H()) {
            aVar.v();
        }
        com.google.android.libraries.navigation.internal.afa.b bVar2 = (com.google.android.libraries.navigation.internal.afa.b) aVar.b;
        bVar2.b |= 1;
        bVar2.c = 79508299;
        if (!cVar.b.H()) {
            cVar.v();
        }
        com.google.android.libraries.navigation.internal.afa.d dVar3 = (com.google.android.libraries.navigation.internal.afa.d) cVar.b;
        com.google.android.libraries.navigation.internal.afa.b bVar3 = (com.google.android.libraries.navigation.internal.afa.b) aVar.t();
        bVar3.getClass();
        dVar3.c = bVar3;
        dVar3.b |= 1;
        com.google.android.libraries.navigation.internal.afk.a aVar2 = this.b;
        if (!dVar.b.H()) {
            dVar.v();
        }
        com.google.android.libraries.navigation.internal.afk.g gVar3 = (com.google.android.libraries.navigation.internal.afk.g) dVar.b;
        com.google.android.libraries.navigation.internal.afa.d dVar4 = (com.google.android.libraries.navigation.internal.afa.d) cVar.t();
        dVar4.getClass();
        gVar3.c = dVar4;
        gVar3.b |= 1;
        com.google.android.libraries.navigation.internal.afk.g gVar4 = (com.google.android.libraries.navigation.internal.afk.g) dVar.t();
        if (!aVar2.b.H()) {
            aVar2.v();
        }
        com.google.android.libraries.navigation.internal.afk.b bVar4 = (com.google.android.libraries.navigation.internal.afk.b) aVar2.b;
        gVar4.getClass();
        bVar4.j = gVar4;
        bVar4.b |= 268435456;
    }

    public final int e() {
        int i = this.l;
        return i != 0 ? i : this.a.f477n;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AbstractLogEventBuilderuploadAccount: null, logSourceName: ");
        sb.append(this.h);
        sb.append(", qosTier: ");
        int iE = e();
        int i = iE - 1;
        if (iE == 0) {
            throw null;
        }
        sb.append(i);
        sb.append(", veMessage: null, testCodes: null, mendelPackages: null, experimentIds: ");
        ArrayList arrayList = this.d;
        sb.append(arrayList != null ? e.a(arrayList) : null);
        sb.append(", experimentTokens: ");
        ArrayList arrayList2 = this.e;
        sb.append(arrayList2 != null ? e.a(arrayList2) : null);
        sb.append(", addPhenotype: true]");
        return sb.toString();
    }
}

package com.google.android.libraries.navigation.internal.kh;

import android.database.sqlite.SQLiteDatabase;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.afl.pe;
import com.google.android.libraries.navigation.internal.afl.pf;
import com.google.android.libraries.navigation.internal.afl.pg;
import com.google.android.libraries.navigation.internal.gq.ao;
import com.google.android.libraries.navigation.internal.yz.no;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class l extends p {
    public final t a;
    public final boolean b;
    private final ao e;
    private final Executor f;
    private final com.google.android.libraries.navigation.internal.mj.a g;

    public l(com.google.android.libraries.navigation.internal.di.b bVar, ao aoVar, Executor executor, t tVar, com.google.android.libraries.navigation.internal.mj.a aVar, boolean z) {
        super(bVar);
        this.e = aoVar;
        this.f = executor;
        this.a = tVar;
        this.g = aVar;
        this.b = true;
    }

    private final boolean j(com.google.android.libraries.navigation.internal.hj.i iVar) {
        return iVar.e() && iVar.equals(f());
    }

    @Override // com.google.android.libraries.navigation.internal.kh.p
    protected final void a(com.google.android.libraries.navigation.internal.hj.i iVar, com.google.android.libraries.navigation.internal.ke.c cVar, y yVar) {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("GmmServerLoggingClient.process");
        try {
            i(iVar, cVar, yVar);
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.kh.p
    protected final void b(o oVar) {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("GmmServerLoggingClient.send");
        try {
            com.google.android.libraries.navigation.internal.hj.i iVar = ((b) oVar).a;
            if (!iVar.f() || iVar.equals(f())) {
                pf pfVar = (pf) pg.a.q();
                no it2 = ((b) oVar).b.iterator();
                while (it2.hasNext()) {
                    pe peVarE = ((com.google.android.libraries.navigation.internal.ke.c) it2.next()).e();
                    if (!pfVar.b.H()) {
                        pfVar.v();
                    }
                    pg pgVar = (pg) pfVar.b;
                    peVarE.getClass();
                    bz bzVar = pgVar.c;
                    if (!bzVar.c()) {
                        pgVar.c = bi.A(bzVar);
                    }
                    pgVar.c.add(peVarE);
                }
                long jA = this.g.a();
                if (!pfVar.b.H()) {
                    pfVar.v();
                }
                pg pgVar2 = (pg) pfVar.b;
                pgVar2.b |= 1;
                pgVar2.d = jA;
                boolean zJ = j(iVar);
                if (!pfVar.b.H()) {
                    pfVar.v();
                }
                pg pgVar3 = (pg) pfVar.b;
                pgVar3.b |= 2;
                pgVar3.e = zJ;
                com.google.android.libraries.navigation.internal.gh.c cVarB = this.e.b();
                cVarB.e = true != iVar.e() ? null : iVar;
                com.google.android.libraries.navigation.internal.gd.f fVar = (com.google.android.libraries.navigation.internal.gd.f) com.google.android.libraries.navigation.internal.gd.i.a.q();
                boolean zJ2 = j(iVar);
                if (!fVar.b.H()) {
                    fVar.v();
                }
                com.google.android.libraries.navigation.internal.gd.i iVar2 = (com.google.android.libraries.navigation.internal.gd.i) fVar.b;
                iVar2.b |= 1;
                iVar2.c = zJ2;
                cVarB.a = (com.google.android.libraries.navigation.internal.gd.i) fVar.t();
                com.google.android.libraries.navigation.internal.gd.j jVar = (com.google.android.libraries.navigation.internal.gd.j) com.google.android.libraries.navigation.internal.gd.k.a.q();
                int i = ((com.google.android.libraries.navigation.internal.gd.k) jVar.b).d;
                if (((b) oVar).c == y.HIGH) {
                    com.google.android.libraries.navigation.internal.gh.c cVarB2 = this.e.b();
                    int i2 = i + 1;
                    if (!jVar.b.H()) {
                        jVar.v();
                    }
                    com.google.android.libraries.navigation.internal.gd.k kVar = (com.google.android.libraries.navigation.internal.gd.k) jVar.b;
                    kVar.b |= 2;
                    kVar.d = i2;
                    cVarB2.a((com.google.android.libraries.navigation.internal.gd.k) jVar.t());
                }
                this.e.c().a((pg) pfVar.t(), new k(this, oVar), this.f);
                com.google.android.libraries.navigation.internal.gh.c cVarB3 = this.e.b();
                if (!jVar.b.H()) {
                    jVar.v();
                }
                com.google.android.libraries.navigation.internal.gd.k kVar2 = (com.google.android.libraries.navigation.internal.gd.k) jVar.b;
                kVar2.b |= 2;
                kVar2.d = i;
                cVarB3.a((com.google.android.libraries.navigation.internal.gd.k) jVar.t());
            }
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.kh.p
    protected final boolean c() {
        return true;
    }

    public final void d() {
        t tVar = this.a;
        final i iVar = tVar.c;
        Objects.requireNonNull(iVar);
        tVar.a(new com.google.android.libraries.navigation.internal.hb.b() { // from class: com.google.android.libraries.navigation.internal.kh.r
            @Override // com.google.android.libraries.navigation.internal.hb.b
            public final Object a(Object obj, Object obj2) {
                final long jLongValue = ((Long) obj).longValue();
                final long jLongValue2 = ((Long) obj2).longValue();
                return iVar.a(new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.kh.f
                    @Override // com.google.android.libraries.navigation.internal.yx.aa
                    public final Object ak(Object obj3) {
                        return ((SQLiteDatabase) obj3).query("userevent3_table", i.a, "timestamp > ?", new String[]{Long.toString(jLongValue)}, null, null, "timestamp", Long.toString(jLongValue2));
                    }
                });
            }
        });
        h(this.a.d, y.HIGH);
    }

    public final void e(final com.google.android.libraries.navigation.internal.hj.i iVar) {
        final t tVar = this.a;
        tVar.a(new com.google.android.libraries.navigation.internal.hb.b() { // from class: com.google.android.libraries.navigation.internal.kh.s
            @Override // com.google.android.libraries.navigation.internal.hb.b
            public final Object a(Object obj, Object obj2) {
                final long jLongValue = ((Long) obj).longValue();
                final long jLongValue2 = ((Long) obj2).longValue();
                final com.google.android.libraries.navigation.internal.hj.i iVar2 = iVar;
                return tVar.c.a(new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.kh.e
                    @Override // com.google.android.libraries.navigation.internal.yx.aa
                    public final Object ak(Object obj3) {
                        return ((SQLiteDatabase) obj3).query("userevent3_table", i.a, "user_account_id = ? AND timestamp > ?", new String[]{i.b(iVar2), Long.toString(jLongValue)}, null, null, "timestamp", Long.toString(jLongValue2));
                    }
                });
            }
        });
        h(this.a.d, y.HIGH);
    }
}

package com.google.android.libraries.navigation.internal.la;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.libraries.navigation.internal.aac.ac;
import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.be;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.ck;
import com.google.android.libraries.navigation.internal.ky.aq;
import com.google.android.libraries.navigation.internal.ky.au;
import com.google.android.libraries.navigation.internal.ld.ab;
import com.google.android.libraries.navigation.internal.le.ai;
import com.google.android.libraries.navigation.internal.le.av;
import com.google.android.libraries.navigation.internal.le.bi;
import com.google.android.libraries.navigation.internal.lh.ba;
import com.google.android.libraries.navigation.internal.lh.bb;
import com.google.android.libraries.navigation.internal.lh.bc;
import com.google.android.libraries.navigation.internal.lh.bd;
import com.google.android.libraries.navigation.internal.me.ah;
import com.google.android.libraries.navigation.internal.yx.aa;
import com.google.android.libraries.navigation.internal.yx.br;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i extends com.google.android.libraries.navigation.internal.ld.o implements com.google.android.libraries.navigation.internal.ky.p {
    public static final /* synthetic */ int a = 0;
    private final br l;

    static {
        new AtomicBoolean(false);
    }

    public i(Context context, br brVar) {
        com.google.android.libraries.navigation.internal.ld.k kVar = com.google.android.libraries.navigation.internal.ky.o.d;
        com.google.android.libraries.navigation.internal.ld.f fVar = com.google.android.libraries.navigation.internal.ld.g.a;
        com.google.android.libraries.navigation.internal.ld.m mVar = new com.google.android.libraries.navigation.internal.ld.m();
        mVar.a = new com.google.android.libraries.navigation.internal.le.h();
        super(context, kVar, fVar, mVar.a());
        this.l = brVar;
    }

    public static boolean c(bj bjVar) {
        if (bjVar.isDone() && !bjVar.isCancelled()) {
            try {
                ck.a(bjVar);
                return true;
            } catch (RuntimeException | ExecutionException unused) {
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.ky.p
    public final com.google.android.libraries.navigation.internal.me.w a(com.google.android.libraries.navigation.internal.ky.n nVar) {
        return k(nVar, new aa() { // from class: com.google.android.libraries.navigation.internal.la.e
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                return this.a.b((com.google.android.libraries.navigation.internal.ky.h) obj, au.b);
            }
        });
    }

    public final com.google.android.libraries.navigation.internal.me.w b(com.google.android.libraries.navigation.internal.ky.h hVar, au auVar) {
        h hVar2 = new h(this, hVar, this.j, auVar);
        boolean z = true;
        if (!hVar2.i && !((Boolean) com.google.android.libraries.navigation.internal.le.q.b.get()).booleanValue()) {
            z = false;
        }
        hVar2.i = z;
        ai aiVar = this.k;
        aiVar.p.sendMessage(aiVar.p.obtainMessage(4, new av(new com.google.android.libraries.navigation.internal.le.c(hVar2), aiVar.l.get(), this)));
        bc bcVar = new bc();
        ba baVar = bd.a;
        com.google.android.libraries.navigation.internal.me.aa aaVar = new com.google.android.libraries.navigation.internal.me.aa();
        hVar2.c(new bb(hVar2, aaVar, bcVar, baVar));
        return aaVar.a;
    }

    public final void d(final a aVar) {
        if (aVar.a.isEmpty()) {
            ah.b(ab.a);
            return;
        }
        bi biVar = new bi();
        biVar.a = new com.google.android.libraries.navigation.internal.le.bd() { // from class: com.google.android.libraries.navigation.internal.la.d
            @Override // com.google.android.libraries.navigation.internal.le.bd
            public final void a(Object obj, Object obj2) throws RemoteException {
                int i = i.a;
                ((r) ((j) obj).u()).e(new f((com.google.android.libraries.navigation.internal.me.aa) obj2), aVar);
            }
        };
        biVar.b = new com.google.android.libraries.navigation.internal.lc.d[]{aq.a};
        biVar.b();
        f(biVar.a());
    }

    private static final com.google.android.libraries.navigation.internal.me.w k(final com.google.android.libraries.navigation.internal.ky.h hVar, final aa aaVar) {
        bj bjVarH;
        com.google.android.libraries.navigation.internal.afk.f fVar;
        if (hVar.k) {
            bjVarH = be.a;
        } else {
            hVar.k = true;
            com.google.android.libraries.navigation.internal.ky.r rVar = hVar.a.k;
            com.google.android.libraries.navigation.internal.ky.t tVarA = rVar != null ? rVar.a() : null;
            if (tVarA != null && (fVar = ((com.google.android.libraries.navigation.internal.ky.j) tVarA).a) != com.google.android.libraries.navigation.internal.afk.f.LOGGER_OVERRIDE_PROVIDER && fVar != com.google.android.libraries.navigation.internal.afk.f.LOGGER_DEFERRING_PROVIDER) {
                tVarA = null;
            }
            if (tVarA == null || ((com.google.android.libraries.navigation.internal.ky.j) tVarA).a != com.google.android.libraries.navigation.internal.afk.f.LOGGER_OVERRIDE_PROVIDER) {
                com.google.android.libraries.navigation.internal.ky.t tVar = hVar.i;
                if (tVar != null && tVar.a() == com.google.android.libraries.navigation.internal.afk.f.CPS_APP_PROCESS_GLOBAL_PROVIDER) {
                    hVar.d(tVar);
                } else if (tVarA != null) {
                    hVar.d(tVarA);
                } else if (tVar != null) {
                    hVar.d(tVar);
                }
            } else {
                hVar.d(tVarA);
            }
            if (hVar.a.c()) {
                bjVarH = be.a;
            } else {
                final bj bjVarH2 = az.h(null);
                bjVarH = com.google.android.libraries.navigation.internal.aac.j.h(com.google.android.libraries.navigation.internal.aac.j.i(bjVarH2, new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.ky.f
                    @Override // com.google.android.libraries.navigation.internal.aac.t
                    public final bj a(Object obj) {
                        if (((u) obj) != null) {
                            return bjVarH2;
                        }
                        bj bjVar = hVar.j;
                        return bjVar == null ? az.h(null) : bjVar;
                    }
                }, ac.INSTANCE), new aa() { // from class: com.google.android.libraries.navigation.internal.ky.g
                    @Override // com.google.android.libraries.navigation.internal.yx.aa
                    public final Object ak(Object obj) {
                        u uVar = (u) obj;
                        if (uVar != null) {
                            h hVar2 = hVar;
                            com.google.android.libraries.navigation.internal.afk.g gVar = ((com.google.android.libraries.navigation.internal.afk.b) hVar2.b.b).j;
                            if (gVar == null) {
                                gVar = com.google.android.libraries.navigation.internal.afk.g.a;
                            }
                            com.google.android.libraries.navigation.internal.ael.bb bbVar = (com.google.android.libraries.navigation.internal.ael.bb) gVar.aH(5, null);
                            bbVar.x(gVar);
                            com.google.android.libraries.navigation.internal.afk.d dVar = (com.google.android.libraries.navigation.internal.afk.d) bbVar;
                            com.google.android.libraries.navigation.internal.afk.g gVar2 = ((com.google.android.libraries.navigation.internal.afk.b) hVar2.b.b).j;
                            if (gVar2 == null) {
                                gVar2 = com.google.android.libraries.navigation.internal.afk.g.a;
                            }
                            com.google.android.libraries.navigation.internal.aba.f fVar2 = gVar2.e;
                            if (fVar2 == null) {
                                fVar2 = com.google.android.libraries.navigation.internal.aba.f.a;
                            }
                            com.google.android.libraries.navigation.internal.ael.bb bbVar2 = (com.google.android.libraries.navigation.internal.ael.bb) fVar2.aH(5, null);
                            bbVar2.x(fVar2);
                            com.google.android.libraries.navigation.internal.aba.e eVar = (com.google.android.libraries.navigation.internal.aba.e) bbVar2;
                            String strB = uVar.b();
                            if (!eVar.b.H()) {
                                eVar.v();
                            }
                            com.google.android.libraries.navigation.internal.aba.f fVar3 = (com.google.android.libraries.navigation.internal.aba.f) eVar.b;
                            strB.getClass();
                            fVar3.c = strB;
                            com.google.android.libraries.navigation.internal.aba.b bVarA = uVar.a();
                            if (!eVar.b.H()) {
                                eVar.v();
                            }
                            com.google.android.libraries.navigation.internal.aba.f fVar4 = (com.google.android.libraries.navigation.internal.aba.f) eVar.b;
                            bVarA.getClass();
                            fVar4.d = bVarA;
                            fVar4.b |= 1;
                            if (!dVar.b.H()) {
                                dVar.v();
                            }
                            com.google.android.libraries.navigation.internal.afk.g gVar3 = (com.google.android.libraries.navigation.internal.afk.g) dVar.b;
                            com.google.android.libraries.navigation.internal.aba.f fVar5 = (com.google.android.libraries.navigation.internal.aba.f) eVar.t();
                            fVar5.getClass();
                            gVar3.e = fVar5;
                            gVar3.b |= 4;
                            com.google.android.libraries.navigation.internal.afk.g gVar4 = (com.google.android.libraries.navigation.internal.afk.g) dVar.t();
                            com.google.android.libraries.navigation.internal.afk.a aVar = hVar2.b;
                            if (!aVar.b.H()) {
                                aVar.v();
                            }
                            com.google.android.libraries.navigation.internal.afk.b bVar = (com.google.android.libraries.navigation.internal.afk.b) aVar.b;
                            gVar4.getClass();
                            bVar.j = gVar4;
                            bVar.b |= 268435456;
                        }
                        return null;
                    }
                }, ac.INSTANCE);
            }
        }
        return c(bjVarH) ? (com.google.android.libraries.navigation.internal.me.w) aaVar.ak(hVar) : com.google.android.libraries.navigation.internal.wu.b.a(bjVarH).b(ac.INSTANCE, new com.google.android.libraries.navigation.internal.me.e() { // from class: com.google.android.libraries.navigation.internal.la.c
            @Override // com.google.android.libraries.navigation.internal.me.e
            public final Object a(com.google.android.libraries.navigation.internal.me.w wVar) {
                int i = i.a;
                if (wVar.e()) {
                    return (com.google.android.libraries.navigation.internal.me.w) aaVar.ak(hVar);
                }
                wVar.c();
                return wVar;
            }
        });
    }
}

package com.google.android.libraries.navigation.internal.vx;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.aac.as;
import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.adr.at;
import com.google.android.libraries.navigation.internal.afl.lz;
import com.google.android.libraries.navigation.internal.afl.mb;
import com.google.android.libraries.navigation.internal.bp.af;
import com.google.android.libraries.navigation.internal.bp.ah;
import com.google.android.libraries.navigation.internal.bp.ai;
import com.google.android.libraries.navigation.internal.bp.ck;
import com.google.android.libraries.navigation.internal.bp.cn;
import com.google.android.libraries.navigation.internal.sk.eo;
import com.google.android.libraries.navigation.internal.sx.an;
import com.google.android.libraries.navigation.internal.sx.ap;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import j$.time.Instant;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class p implements as {
    final /* synthetic */ com.google.android.libraries.navigation.internal.vp.f a;
    final /* synthetic */ bj b;
    final /* synthetic */ u c;
    final /* synthetic */ com.google.android.libraries.navigation.internal.vw.f d;

    public p(u uVar, com.google.android.libraries.navigation.internal.vw.f fVar, com.google.android.libraries.navigation.internal.vp.f fVar2, bj bjVar) {
        this.d = fVar;
        this.a = fVar2;
        this.b = bjVar;
        this.c = uVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void a(Throwable th) {
        com.google.android.libraries.navigation.internal.vw.f fVar = this.d;
        if (fVar != null) {
            fVar.a();
        }
        if (th instanceof an) {
            this.a.a(com.google.android.libraries.navigation.internal.vp.c.NETWORK_ERROR);
        } else if (th instanceof s) {
            this.a.a(com.google.android.libraries.navigation.internal.vp.c.LOCATION_DISABLED);
        } else if (!(th instanceof TimeoutException)) {
            this.a.a(com.google.android.libraries.navigation.internal.vp.c.NO_ROUTE_FOUND);
        }
        this.c.e();
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00f0 A[Catch: ExecutionException -> 0x017f, PHI: r1
      0x00f0: PHI (r1v8 com.google.android.libraries.navigation.internal.yz.ev) = 
      (r1v4 com.google.android.libraries.navigation.internal.yz.ev)
      (r1v16 com.google.android.libraries.navigation.internal.yz.ev)
     binds: [B:55:0x0137, B:36:0x00ee] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #4 {ExecutionException -> 0x017f, blocks: (B:20:0x004c, B:22:0x0076, B:23:0x0078, B:37:0x00f0, B:57:0x013a, B:68:0x017e, B:67:0x017b, B:63:0x0175), top: B:90:0x004c, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x0175 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:? A[Catch: ExecutionException -> 0x017f, SYNTHETIC, TRY_LEAVE, TryCatch #4 {ExecutionException -> 0x017f, blocks: (B:20:0x004c, B:22:0x0076, B:23:0x0078, B:37:0x00f0, B:57:0x013a, B:68:0x017e, B:67:0x017b, B:63:0x0175), top: B:90:0x004c, inners: #3 }] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final /* bridge */ /* synthetic */ void b(Object obj) throws Throwable {
        boolean z;
        Throwable th;
        ev evVarP;
        com.google.android.libraries.navigation.internal.sx.as asVar = (com.google.android.libraries.navigation.internal.sx.as) obj;
        com.google.android.libraries.navigation.internal.vw.f fVar = this.d;
        if (fVar != null) {
            fVar.a();
        }
        af afVar = asVar.c;
        if (afVar != null && !afVar.m()) {
            if (afVar.g() == at.WAYPOINT_FAILURE) {
                this.a.a(com.google.android.libraries.navigation.internal.vp.c.WAYPOINT_ERROR);
            } else if (afVar.g() == at.NO_ROUTES_FOUND) {
                this.a.a(com.google.android.libraries.navigation.internal.vp.c.NO_ROUTE_FOUND);
            } else if (afVar.g() == at.NAVIGATION_NOT_ALLOWED) {
                this.a.a(com.google.android.libraries.navigation.internal.vp.c.NAVIGATION_DISALLOWED);
            }
            this.c.e();
            return;
        }
        try {
            ap apVar = (ap) Objects.requireNonNull((ap) az.n(this.b));
            com.google.android.libraries.navigation.internal.vp.f fVar2 = this.a;
            u uVar = this.c;
            af afVar2 = (af) Objects.requireNonNull(afVar);
            com.google.android.libraries.navigation.internal.bs.b bVarB = uVar.d.b(apVar);
            lz lzVarD = uVar.d.d(bVarB);
            com.google.android.libraries.navigation.internal.adv.b bVar = bVarB.a.s;
            if (bVar == null) {
                bVar = com.google.android.libraries.navigation.internal.adv.b.a;
            }
            boolean z2 = bVar.b;
            ev evVar = bVarB.e;
            com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("DirectionsFetcherImpl.refineWaypoints()");
            if (z2) {
                boolean z3 = dVarB == null;
                try {
                    ev evVarA = com.google.android.libraries.navigation.internal.bt.j.a(afVar2, uVar.a);
                    int i = ((lv) evVarA).c;
                    ck[] ckVarArr = new ck[i];
                    try {
                        ckVarArr[0] = com.google.android.libraries.navigation.internal.bt.k.a(afVar2.k(), uVar.a, (ck) evVar.get(0), afVar2.h(0));
                        for (int i2 = 1; i2 < ((lv) evVarA).c - 1; i2++) {
                            ckVarArr[i2] = (ck) evVarA.get(i2);
                        }
                        ckVarArr[i - 1] = com.google.android.libraries.navigation.internal.bt.k.a(afVar2.k(), uVar.a, (ck) evVar.get(evVar.size() - 1), afVar2.h(afVar2.d() - 1));
                        evVarP = ev.p(ckVarArr);
                        if (dVarB != null) {
                            Trace.endSection();
                        }
                        ah ahVar = new ah();
                        ahVar.a = afVar2;
                        ahVar.c = bVarB.a();
                        ahVar.d(evVarP);
                        ahVar.c(bVarB.a);
                        ahVar.a(bVarB.b);
                        ahVar.j = Instant.ofEpochMilli(uVar.e.f().toEpochMilli());
                        ahVar.b(lzVarD);
                        fVar2.b(new ai(ahVar));
                    } catch (Throwable th2) {
                        th = th2;
                        th = th;
                        z = z3;
                        if (true != z) {
                            throw th;
                        }
                        try {
                            Trace.endSection();
                            throw th;
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                            throw th;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } else {
                z = dVarB == null;
                try {
                    int iD = afVar2.d();
                    cn.a(iD);
                    ck[] ckVarArr2 = new ck[iD];
                    ar.a(evVar.size() == iD);
                    for (int i3 = 0; i3 < iD; i3++) {
                        ckVarArr2[i3] = com.google.android.libraries.navigation.internal.bt.k.a(afVar2.k(), uVar.a, (ck) evVar.get(i3), afVar2.h(i3));
                    }
                    evVarP = ev.p(ckVarArr2);
                    if (dVarB != null) {
                        Trace.endSection();
                    }
                    ah ahVar2 = new ah();
                    ahVar2.a = afVar2;
                    ahVar2.c = bVarB.a();
                    ahVar2.d(evVarP);
                    ahVar2.c(bVarB.a);
                    ahVar2.a(bVarB.b);
                    ahVar2.j = Instant.ofEpochMilli(uVar.e.f().toEpochMilli());
                    ahVar2.b(lzVarD);
                    fVar2.b(new ai(ahVar2));
                } catch (Throwable th5) {
                    th = th5;
                    if (true != z) {
                        throw th;
                    }
                    Trace.endSection();
                    throw th;
                }
            }
        } catch (ExecutionException unused) {
        }
        if (afVar != null) {
            u uVar2 = this.c;
            if (((eo) uVar2.f.a()).e()) {
                mb mbVar = afVar.a.g;
                if (mbVar == null) {
                    mbVar = mb.a;
                }
                if ((mbVar.b & 1) != 0) {
                    ((eo) uVar2.f.a()).c(mbVar.c, mbVar.d);
                }
            }
        }
        this.c.e();
    }
}

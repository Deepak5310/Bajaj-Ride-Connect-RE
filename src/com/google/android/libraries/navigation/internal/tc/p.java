package com.google.android.libraries.navigation.internal.tc;

import android.location.Location;
import com.google.android.libraries.navigation.internal.ady.ad;
import com.google.android.libraries.navigation.internal.db.ar;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.zr.cr;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p extends com.google.android.libraries.navigation.internal.ia.k {
    private final int f;

    public p(int i, Class cls, n nVar, ap apVar, Executor executor) {
        super(cls, nVar, apVar, executor);
        this.f = i;
    }

    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        switch (this.f) {
            case 0:
                n nVar = (n) this.c;
                boolean z = ((com.google.android.libraries.navigation.internal.uf.a) aVar).a;
                nVar.k = false;
                break;
            case 1:
                ((n) this.c).e();
                break;
            case 2:
                ((n) this.c).p = cr.b;
                break;
            case 3:
                n nVar2 = (n) this.c;
                int i = com.google.android.libraries.navigation.internal.km.l.a;
                int i2 = com.google.android.libraries.navigation.internal.fp.a.a;
                Location location = ((com.google.android.libraries.navigation.internal.dh.a) aVar).a;
                d dVar = nVar2.d;
                if (dVar != null) {
                    dVar.a(location);
                }
                break;
            case 4:
                n nVar3 = (n) this.c;
                com.google.android.libraries.navigation.internal.db.r rVarD = ((com.google.android.libraries.navigation.internal.db.s) aVar).d();
                if (rVarD != null) {
                    u uVar = nVar3.b;
                    if (uVar != null) {
                        uVar.f = rVarD;
                    }
                    aa aaVar = nVar3.c;
                    if (aaVar != null) {
                        aaVar.d = rVarD;
                    }
                    d dVar2 = nVar3.d;
                    if (dVar2 != null && rVarD.B()) {
                        Location location2 = dVar2.f;
                        if (location2 != null) {
                            com.google.android.libraries.navigation.internal.kd.g gVar = dVar2.b;
                            com.google.android.libraries.navigation.internal.oe.r rVar = new com.google.android.libraries.navigation.internal.oe.r(location2.getLatitude(), dVar2.f.getLongitude());
                            gVar.b(ar.a(rVarD.b, rVarD.c, rVar.a, rVar.b));
                        }
                        com.google.android.libraries.navigation.internal.db.r rVar2 = dVar2.g;
                        if (rVar2 != null) {
                            long jA = com.google.android.libraries.navigation.internal.ja.a.a(rVar2.g);
                            if (!rVarD.x() || com.google.android.libraries.navigation.internal.ja.a.a(rVarD.g) <= jA || rVarD.l().m) {
                                dVar2.e += (double) rVar2.d(rVarD);
                            } else {
                                dVar2.e += ((double) (rVarD.f * (com.google.android.libraries.navigation.internal.ja.a.a(rVarD.g) - jA))) / 1000.0d;
                            }
                        }
                        dVar2.g = rVarD;
                    }
                    r rVar3 = nVar3.e;
                    if (rVar3 != null) {
                        if (rVarD.l().b()) {
                            rVar3.d = rVarD.l().y;
                        }
                        rVar3.b.a(rVarD);
                        long j = rVarD.l().s;
                        if (j != -1) {
                            q qVar = (q) rVar3.a.aO(j);
                            if (qVar == null) {
                                qVar = new q();
                                rVar3.a.a(j, qVar);
                            }
                            qVar.a(rVarD);
                            rVar3.c = j;
                        }
                    }
                }
                nVar3.l = rVarD;
                break;
            case 5:
                n nVar4 = (n) this.c;
                com.google.android.libraries.navigation.internal.tf.b bVar = (com.google.android.libraries.navigation.internal.tf.b) aVar;
                if (bVar.c - nVar4.i > n.a) {
                    nVar4.g = nVar4.c();
                    nVar4.h = 0.0d;
                }
                nVar4.i = bVar.c;
                nVar4.h += bVar.c();
                if (bVar.b != ad.REROUTE_TYPE_AVOIDS_CLOSURE) {
                    nVar4.j -= bVar.c();
                }
                break;
            case 6:
                n nVar5 = (n) this.c;
                if (((com.google.android.libraries.navigation.internal.tf.a) aVar) == com.google.android.libraries.navigation.internal.tf.a.a) {
                    nVar5.f590n = true;
                }
                break;
            case 7:
                long j2 = ((com.google.android.libraries.navigation.internal.sr.g) aVar).a;
                break;
            default:
                ((n) this.c).o = true;
                break;
        }
    }
}

package com.google.android.libraries.navigation.internal.qp;

import com.google.android.libraries.geo.mapcore.internal.model.cg;
import com.google.android.libraries.navigation.internal.ael.bh;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements y {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.qp.e");
    private final cg b;
    private final String c;

    public e(cg cgVar, String str) {
        this.b = cgVar;
        this.c = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.qp.y
    public final void a(com.google.android.libraries.navigation.internal.pt.d dVar, com.google.android.libraries.navigation.internal.adi.ag agVar) {
        for (int i = 0; i < ((com.google.android.libraries.navigation.internal.adi.aj) agVar.b).d.size(); i++) {
            int iA = com.google.android.libraries.navigation.internal.adi.w.a(agVar.c(i).c);
            if (iA == 0) {
                iA = com.google.android.libraries.navigation.internal.adi.w.a;
            }
            if (iA == com.google.android.libraries.navigation.internal.adi.w.g) {
                if (agVar.c(i).d.equals(this.c)) {
                    if (i == -1) {
                        break;
                    }
                    com.google.android.libraries.geo.mapcore.internal.model.b bVar = (com.google.android.libraries.geo.mapcore.internal.model.b) this.b;
                    ev evVar = bVar.c;
                    if (evVar != null) {
                        ev evVar2 = bVar.d;
                        com.google.android.libraries.navigation.internal.aah.a aVar = (com.google.android.libraries.navigation.internal.aah.a) com.google.android.libraries.navigation.internal.aah.d.a.q();
                        if (!evVar.isEmpty()) {
                            com.google.android.libraries.navigation.internal.aah.b bVar2 = (com.google.android.libraries.navigation.internal.aah.b) com.google.android.libraries.navigation.internal.aah.c.a.q();
                            com.google.android.libraries.navigation.internal.aah.e eVar = (com.google.android.libraries.navigation.internal.aah.e) com.google.android.libraries.navigation.internal.aah.j.a.q();
                            int i2 = com.google.android.libraries.navigation.internal.aah.g.d;
                            if (!eVar.b.H()) {
                                eVar.v();
                            }
                            com.google.android.libraries.navigation.internal.aah.j jVar = (com.google.android.libraries.navigation.internal.aah.j) eVar.b;
                            int i3 = i2 - 1;
                            if (i2 == 0) {
                                throw null;
                            }
                            jVar.d = i3;
                            jVar.b |= 2;
                            int i4 = com.google.android.libraries.navigation.internal.aah.i.f;
                            if (!eVar.b.H()) {
                                eVar.v();
                            }
                            com.google.android.libraries.navigation.internal.aah.j jVar2 = (com.google.android.libraries.navigation.internal.aah.j) eVar.b;
                            int i5 = i4 - 1;
                            if (i4 == 0) {
                                throw null;
                            }
                            jVar2.c = i5;
                            jVar2.b |= 1;
                            if (!bVar2.b.H()) {
                                bVar2.v();
                            }
                            com.google.android.libraries.navigation.internal.aah.c cVar = (com.google.android.libraries.navigation.internal.aah.c) bVar2.b;
                            com.google.android.libraries.navigation.internal.aah.j jVar3 = (com.google.android.libraries.navigation.internal.aah.j) eVar.t();
                            jVar3.getClass();
                            cVar.c = jVar3;
                            cVar.b |= 1;
                            bVar2.a(evVar);
                            aVar.b((com.google.android.libraries.navigation.internal.aah.c) bVar2.t());
                        }
                        if (evVar2 != null) {
                            com.google.android.libraries.navigation.internal.aah.b bVar3 = (com.google.android.libraries.navigation.internal.aah.b) com.google.android.libraries.navigation.internal.aah.c.a.q();
                            com.google.android.libraries.navigation.internal.aah.e eVar2 = (com.google.android.libraries.navigation.internal.aah.e) com.google.android.libraries.navigation.internal.aah.j.a.q();
                            int i6 = com.google.android.libraries.navigation.internal.aah.g.b;
                            if (!eVar2.b.H()) {
                                eVar2.v();
                            }
                            com.google.android.libraries.navigation.internal.aah.j jVar4 = (com.google.android.libraries.navigation.internal.aah.j) eVar2.b;
                            int i7 = i6 - 1;
                            if (i6 == 0) {
                                throw null;
                            }
                            jVar4.d = i7;
                            jVar4.b |= 2;
                            int i8 = com.google.android.libraries.navigation.internal.aah.i.b;
                            if (!eVar2.b.H()) {
                                eVar2.v();
                            }
                            com.google.android.libraries.navigation.internal.aah.j jVar5 = (com.google.android.libraries.navigation.internal.aah.j) eVar2.b;
                            int i9 = i8 - 1;
                            if (i8 == 0) {
                                throw null;
                            }
                            jVar5.c = i9;
                            jVar5.b |= 1;
                            if (!bVar3.b.H()) {
                                bVar3.v();
                            }
                            com.google.android.libraries.navigation.internal.aah.c cVar2 = (com.google.android.libraries.navigation.internal.aah.c) bVar3.b;
                            com.google.android.libraries.navigation.internal.aah.j jVar6 = (com.google.android.libraries.navigation.internal.aah.j) eVar2.t();
                            jVar6.getClass();
                            cVar2.c = jVar6;
                            cVar2.b |= 1;
                            bVar3.a(evVar2);
                            aVar.a(bVar3);
                        }
                        com.google.android.libraries.navigation.internal.adf.a aVar2 = (com.google.android.libraries.navigation.internal.adf.a) com.google.android.libraries.navigation.internal.adf.b.a.q();
                        aVar2.C(com.google.android.libraries.navigation.internal.aah.d.b, (com.google.android.libraries.navigation.internal.aah.d) aVar.t());
                        agVar.f((com.google.android.libraries.navigation.internal.adf.b) aVar2.t());
                    }
                    com.google.android.libraries.geo.mapcore.internal.model.b bVar4 = (com.google.android.libraries.geo.mapcore.internal.model.b) this.b;
                    com.google.android.libraries.navigation.internal.aas.b bVar5 = bVar4.e;
                    if (bVar4.f != null) {
                        com.google.android.libraries.navigation.internal.adf.a aVar3 = (com.google.android.libraries.navigation.internal.adf.a) com.google.android.libraries.navigation.internal.adf.b.a.q();
                        bh bhVar = com.google.android.libraries.navigation.internal.aep.h.b;
                        com.google.android.libraries.navigation.internal.aep.a aVar4 = (com.google.android.libraries.navigation.internal.aep.a) com.google.android.libraries.navigation.internal.aep.h.a.q();
                        Boolean bool = ((com.google.android.libraries.geo.mapcore.internal.model.b) this.b).f;
                        ar.q(bool);
                        boolean zBooleanValue = bool.booleanValue();
                        if (!aVar4.b.H()) {
                            aVar4.v();
                        }
                        com.google.android.libraries.navigation.internal.aep.h hVar = (com.google.android.libraries.navigation.internal.aep.h) aVar4.b;
                        hVar.c |= 1;
                        hVar.d = zBooleanValue;
                        aVar3.C(bhVar, (com.google.android.libraries.navigation.internal.aep.h) aVar4.t());
                        agVar.f((com.google.android.libraries.navigation.internal.adf.b) aVar3.t());
                    }
                    ev evVar3 = ((com.google.android.libraries.geo.mapcore.internal.model.b) this.b).g;
                    if (evVar3 != null) {
                        ar.q(evVar3);
                        if (!evVar3.isEmpty()) {
                            ArrayList arrayList = new ArrayList();
                            ev evVar4 = ((com.google.android.libraries.geo.mapcore.internal.model.b) this.b).g;
                            ar.q(evVar4);
                            int size = evVar4.size();
                            for (int i10 = 0; i10 < size; i10++) {
                                long jLongValue = ((Long) evVar4.get(i10)).longValue();
                                com.google.android.libraries.navigation.internal.aep.e eVar3 = (com.google.android.libraries.navigation.internal.aep.e) com.google.android.libraries.navigation.internal.aep.f.a.q();
                                if (!eVar3.b.H()) {
                                    eVar3.v();
                                }
                                com.google.android.libraries.navigation.internal.aep.f fVar = (com.google.android.libraries.navigation.internal.aep.f) eVar3.b;
                                fVar.b |= 1;
                                fVar.c = jLongValue;
                                arrayList.add((com.google.android.libraries.navigation.internal.aep.f) eVar3.t());
                            }
                            com.google.android.libraries.navigation.internal.adf.a aVar5 = (com.google.android.libraries.navigation.internal.adf.a) com.google.android.libraries.navigation.internal.adf.b.a.q();
                            bh bhVar2 = com.google.android.libraries.navigation.internal.aep.h.b;
                            com.google.android.libraries.navigation.internal.aep.a aVar6 = (com.google.android.libraries.navigation.internal.aep.a) com.google.android.libraries.navigation.internal.aep.h.a.q();
                            com.google.android.libraries.navigation.internal.aep.d dVar2 = (com.google.android.libraries.navigation.internal.aep.d) com.google.android.libraries.navigation.internal.aep.g.a.q();
                            if (!dVar2.b.H()) {
                                dVar2.v();
                            }
                            com.google.android.libraries.navigation.internal.aep.g gVar = (com.google.android.libraries.navigation.internal.aep.g) dVar2.b;
                            bz bzVar = gVar.b;
                            if (!bzVar.c()) {
                                gVar.b = bi.A(bzVar);
                            }
                            com.google.android.libraries.navigation.internal.ael.b.m(arrayList, gVar.b);
                            com.google.android.libraries.navigation.internal.aep.g gVar2 = (com.google.android.libraries.navigation.internal.aep.g) dVar2.t();
                            if (!aVar6.b.H()) {
                                aVar6.v();
                            }
                            com.google.android.libraries.navigation.internal.aep.h hVar2 = (com.google.android.libraries.navigation.internal.aep.h) aVar6.b;
                            gVar2.getClass();
                            hVar2.f = gVar2;
                            hVar2.c |= 4;
                            aVar5.C(bhVar2, (com.google.android.libraries.navigation.internal.aep.h) aVar6.t());
                            agVar.f((com.google.android.libraries.navigation.internal.adf.b) aVar5.t());
                        }
                    }
                    if (((com.google.android.libraries.geo.mapcore.internal.model.b) this.b).h != null) {
                        com.google.android.libraries.navigation.internal.adf.a aVar7 = (com.google.android.libraries.navigation.internal.adf.a) com.google.android.libraries.navigation.internal.adf.b.a.q();
                        bh bhVar3 = com.google.android.libraries.navigation.internal.aep.h.b;
                        com.google.android.libraries.navigation.internal.aep.a aVar8 = (com.google.android.libraries.navigation.internal.aep.a) com.google.android.libraries.navigation.internal.aep.h.a.q();
                        com.google.android.libraries.navigation.internal.aaj.b bVar6 = ((com.google.android.libraries.geo.mapcore.internal.model.b) this.b).h;
                        ar.q(bVar6);
                        if (!aVar8.b.H()) {
                            aVar8.v();
                        }
                        com.google.android.libraries.navigation.internal.aep.h hVar3 = (com.google.android.libraries.navigation.internal.aep.h) aVar8.b;
                        hVar3.g = bVar6;
                        hVar3.c |= 8;
                        aVar7.C(bhVar3, (com.google.android.libraries.navigation.internal.aep.h) aVar8.t());
                        agVar.f((com.google.android.libraries.navigation.internal.adf.b) aVar7.t());
                    }
                    if (((com.google.android.libraries.geo.mapcore.internal.model.b) this.b).r != null) {
                        com.google.android.libraries.navigation.internal.adf.a aVar9 = (com.google.android.libraries.navigation.internal.adf.a) com.google.android.libraries.navigation.internal.adf.b.a.q();
                        bh bhVar4 = com.google.android.libraries.navigation.internal.aep.h.b;
                        com.google.android.libraries.navigation.internal.aep.a aVar10 = (com.google.android.libraries.navigation.internal.aep.a) com.google.android.libraries.navigation.internal.aep.h.a.q();
                        com.google.android.libraries.navigation.internal.aep.c cVar3 = ((com.google.android.libraries.geo.mapcore.internal.model.b) this.b).r;
                        ar.q(cVar3);
                        if (!aVar10.b.H()) {
                            aVar10.v();
                        }
                        com.google.android.libraries.navigation.internal.aep.h hVar4 = (com.google.android.libraries.navigation.internal.aep.h) aVar10.b;
                        hVar4.h = cVar3;
                        hVar4.c |= 16;
                        aVar9.C(bhVar4, (com.google.android.libraries.navigation.internal.aep.h) aVar10.t());
                        agVar.f((com.google.android.libraries.navigation.internal.adf.b) aVar9.t());
                        return;
                    }
                    return;
                }
            }
        }
        ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1104)).p("Paint request template does not have search results AUX Layer.");
    }

    @Override // com.google.android.libraries.navigation.internal.qp.y
    public final boolean b(List list, aa aaVar) {
        return true;
    }
}

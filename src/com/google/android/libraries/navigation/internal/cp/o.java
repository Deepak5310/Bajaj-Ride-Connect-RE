package com.google.android.libraries.navigation.internal.cp;

import android.content.Context;
import com.google.android.libraries.navigation.internal.aaq.ad;
import com.google.android.libraries.navigation.internal.aaq.ae;
import com.google.android.libraries.navigation.internal.aaq.ak;
import com.google.android.libraries.navigation.internal.aaq.w;
import com.google.android.libraries.navigation.internal.ace.nq;
import com.google.android.libraries.navigation.internal.adg.ex;
import com.google.android.libraries.navigation.internal.adq.ah;
import com.google.android.libraries.navigation.internal.adr.Cdo;
import com.google.android.libraries.navigation.internal.adr.bm;
import com.google.android.libraries.navigation.internal.adr.ee;
import com.google.android.libraries.navigation.internal.adr.ef;
import com.google.android.libraries.navigation.internal.adr.el;
import com.google.android.libraries.navigation.internal.adr.fb;
import com.google.android.libraries.navigation.internal.adr.ff;
import com.google.android.libraries.navigation.internal.adr.fg;
import com.google.android.libraries.navigation.internal.adr.fh;
import com.google.android.libraries.navigation.internal.adr.fp;
import com.google.android.libraries.navigation.internal.adr.gn;
import com.google.android.libraries.navigation.internal.ael.by;
import com.google.android.libraries.navigation.internal.cl.ai;
import com.google.android.libraries.navigation.internal.cl.aj;
import com.google.android.libraries.navigation.internal.cn.aa;
import com.google.android.libraries.navigation.internal.cn.s;
import com.google.android.libraries.navigation.internal.cn.v;
import com.google.android.libraries.navigation.internal.cn.x;
import com.google.android.libraries.navigation.internal.cn.z;
import com.google.android.libraries.navigation.internal.cq.ac;
import com.google.android.libraries.navigation.internal.cq.af;
import com.google.android.libraries.navigation.internal.cq.ag;
import com.google.android.libraries.navigation.internal.hf.u;
import com.google.android.libraries.navigation.internal.iv.ab;
import com.google.android.libraries.navigation.internal.ol.ax;
import com.google.android.libraries.navigation.internal.qk.t;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yx.aq;
import com.google.android.libraries.navigation.internal.yx.as;
import com.google.android.libraries.navigation.internal.yz.br;
import com.google.android.libraries.navigation.internal.yz.de;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.fw;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.gl;
import com.google.android.libraries.navigation.internal.yz.lr;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.yz.ma;
import com.google.android.libraries.navigation.internal.yz.nm;
import com.google.android.libraries.navigation.internal.yz.nn;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o implements aa {
    public v a;
    public aj b;
    private final Context c;
    private final an d;
    private final com.google.android.libraries.navigation.internal.cn.n e;
    private final com.google.android.libraries.navigation.internal.afo.a f;
    private final an g;
    private final com.google.android.libraries.navigation.internal.dx.i h;
    private ev i;
    private ev j;
    private ev k;
    private ev l;
    private fd m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f376n;

    public o(Context context, com.google.android.libraries.navigation.internal.cn.n nVar, an anVar, com.google.android.libraries.navigation.internal.afo.a aVar, an anVar2, com.google.android.libraries.navigation.internal.dx.i iVar) {
        int i = ev.d;
        this.i = lv.a;
        this.j = lv.a;
        this.k = lv.a;
        this.l = null;
        this.m = null;
        this.c = context;
        this.d = anVar;
        this.e = nVar;
        this.f = aVar;
        this.g = anVar2;
        com.google.android.libraries.navigation.internal.cn.b bVar = (com.google.android.libraries.navigation.internal.cn.b) nVar;
        this.f376n = bVar.e;
        this.h = iVar;
        ax axVar = bVar.f;
        if (axVar != null) {
            this.b = new aj(context, axVar, bVar.d);
        }
    }

    private static String g(int i) {
        double dRound = Math.round((((double) i) * 0.0011d) * 10.0d) / 10.0d;
        return dRound == Math.floor(dRound) ? Integer.toString((int) dRound) : Double.toString(dRound);
    }

    /* JADX WARN: Code duplicated, block: B:173:0x03a5  */
    /* JADX WARN: Code duplicated, block: B:22:0x0090  */
    /* JADX WARN: Code duplicated, block: B:256:0x057f  */
    /* JADX WARN: Code duplicated, block: B:286:0x0147 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x011e  */
    /* JADX WARN: Code duplicated, block: B:82:0x0124  */
    /* JADX WARN: Code duplicated, block: B:83:0x0127  */
    /* JADX WARN: Code duplicated, block: B:85:0x012b  */
    /* JADX WARN: Code duplicated, block: B:87:0x0137  */
    /* JADX WARN: Code duplicated, block: B:90:0x013d  */
    /* JADX WARN: Code duplicated, block: B:91:0x013f  */
    /* JADX WARN: Code duplicated, block: B:93:0x0142 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:94:0x0144  */
    /* JADX WARN: Code duplicated, block: B:97:0x0149  */
    /* JADX WARN: Multi-variable type inference failed */
    private final void h() {
        int i;
        ex exVar;
        com.google.android.libraries.navigation.internal.afd.a aVar;
        nn nnVar;
        Iterator it2;
        Iterator it3;
        String string;
        String string2;
        com.google.android.libraries.navigation.internal.cq.aa aaVarB;
        ev evVar;
        int i2;
        ev evVar2;
        int i3;
        int i4;
        int i5;
        int i6;
        com.google.android.libraries.navigation.internal.cq.k kVar;
        int iA;
        boolean z;
        com.google.android.libraries.navigation.internal.acg.c cVar;
        v vVar = this.a;
        if (vVar == null) {
            return;
        }
        ev evVar3 = this.i;
        ev evVar4 = this.j;
        ez ezVar = new ez();
        int i7 = 0;
        while (i7 < evVar3.size()) {
            com.google.android.libraries.navigation.internal.ach.j jVar = (com.google.android.libraries.navigation.internal.ach.j) evVar3.get(i7);
            ez ezVar2 = new ez();
            int i8 = 0;
            while (i8 < jVar.e.size()) {
                com.google.android.libraries.navigation.internal.ach.f fVar = (com.google.android.libraries.navigation.internal.ach.f) jVar.e.get(i8);
                int i9 = ev.d;
                eq eqVar = new eq();
                for (com.google.android.libraries.navigation.internal.ach.d dVar : fVar.e) {
                    if (!evVar4.isEmpty()) {
                        String str = dVar.e;
                        if (i7 < evVar4.size()) {
                            com.google.android.libraries.navigation.internal.acg.h hVar = (com.google.android.libraries.navigation.internal.acg.h) evVar4.get(i7);
                            if (i8 >= hVar.c.size() || (cVar = (com.google.android.libraries.navigation.internal.acg.c) Collections.unmodifiableMap(new by(((com.google.android.libraries.navigation.internal.acg.f) hVar.c.get(i8)).c, com.google.android.libraries.navigation.internal.acg.f.d)).get(str)) == null) {
                                cVar = com.google.android.libraries.navigation.internal.acg.c.DECORATION_RELEVANCE_STATE_UNSPECIFIED;
                            }
                        } else {
                            cVar = com.google.android.libraries.navigation.internal.acg.c.DECORATION_RELEVANCE_STATE_UNSPECIFIED;
                        }
                        if (cVar == com.google.android.libraries.navigation.internal.acg.c.PASSED) {
                            continue;
                        }
                    }
                    com.google.android.libraries.navigation.internal.aaq.an anVar = dVar.f;
                    if (anVar == null) {
                        anVar = com.google.android.libraries.navigation.internal.aaq.an.a;
                    }
                    int i10 = anVar.b;
                    if (i10 == 1) {
                        kVar = com.google.android.libraries.navigation.internal.cq.k.HEIGHT_RESTRICTION;
                    } else if (i10 == 17) {
                        kVar = com.google.android.libraries.navigation.internal.cq.k.WIDTH_RESTRICTION;
                    } else if (i10 == 2) {
                        kVar = com.google.android.libraries.navigation.internal.cq.k.WEIGHT_RESTRICTION;
                    } else if (i10 == 16) {
                        kVar = com.google.android.libraries.navigation.internal.cq.k.LENGTH_RESTRICTION;
                    } else if (i10 == 7) {
                        kVar = com.google.android.libraries.navigation.internal.cq.k.HAZMAT_RESTRICTION;
                    } else if (i10 == 6) {
                        kVar = com.google.android.libraries.navigation.internal.cq.k.TRUCKS_PROHIBITED_RESTRICTION;
                    } else if (i10 == 3) {
                        kVar = com.google.android.libraries.navigation.internal.cq.k.MARKED_BIKE_LANE;
                    } else if (i10 == 4) {
                        kVar = com.google.android.libraries.navigation.internal.cq.k.COMBINED_BIKE_LANE;
                    } else if (i10 == 5) {
                        kVar = com.google.android.libraries.navigation.internal.cq.k.STAIRS;
                    } else if (i10 == 8) {
                        kVar = com.google.android.libraries.navigation.internal.cq.k.HOV;
                    } else if (i10 == 11) {
                        kVar = com.google.android.libraries.navigation.internal.cq.k.LOW_DATA_QUALITY_ZONE;
                    } else if (i10 == 10) {
                        kVar = com.google.android.libraries.navigation.internal.cq.k.FLYOVER;
                    } else if (i10 == 9) {
                        kVar = com.google.android.libraries.navigation.internal.cq.k.UNPAVED_ROAD;
                    } else if (i10 != 12) {
                        i6 = anVar.b;
                        if (i6 == 13) {
                            kVar = com.google.android.libraries.navigation.internal.cq.k.NARROW_ROAD;
                        } else if (i6 != 14) {
                            kVar = com.google.android.libraries.navigation.internal.cq.k.UNKNOWN;
                        } else {
                            iA = ad.a(((ae) anVar.c).b);
                            if (iA == 0) {
                                iA = ad.a;
                            }
                            if (iA != ad.b) {
                                z = false;
                            } else {
                                z = true;
                            }
                            if (iA != 0) {
                                throw null;
                            }
                            if (z) {
                                kVar = com.google.android.libraries.navigation.internal.cq.k.ETC_ONLY_TOLL_GATE;
                            } else {
                                kVar = com.google.android.libraries.navigation.internal.cq.k.UNKNOWN;
                            }
                        }
                    } else {
                        int iA2 = com.google.android.libraries.navigation.internal.aap.p.a(((w) anVar.c).b);
                        if (iA2 == 0) {
                            iA2 = com.google.android.libraries.navigation.internal.aap.p.a;
                        }
                        boolean z2 = iA2 == com.google.android.libraries.navigation.internal.aap.p.c;
                        if (iA2 == 0) {
                            throw null;
                        }
                        if (z2) {
                            kVar = com.google.android.libraries.navigation.internal.cq.k.ICY_ROAD;
                        } else {
                            i6 = anVar.b;
                            if (i6 == 13) {
                                kVar = com.google.android.libraries.navigation.internal.cq.k.NARROW_ROAD;
                            } else if (i6 != 14) {
                                kVar = com.google.android.libraries.navigation.internal.cq.k.UNKNOWN;
                            } else {
                                iA = ad.a(((ae) anVar.c).b);
                                if (iA == 0) {
                                    iA = ad.a;
                                }
                                if (iA != ad.b) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                                if (iA != 0) {
                                    throw null;
                                }
                                if (z) {
                                    kVar = com.google.android.libraries.navigation.internal.cq.k.ETC_ONLY_TOLL_GATE;
                                } else {
                                    kVar = com.google.android.libraries.navigation.internal.cq.k.UNKNOWN;
                                }
                            }
                        }
                    }
                    int iOrdinal = kVar.ordinal();
                    if (iOrdinal == 6 || iOrdinal == 8 || iOrdinal == 10 || iOrdinal == 12) {
                        com.google.android.libraries.navigation.internal.aaq.an anVar2 = dVar.f;
                        if (anVar2 == null) {
                            anVar2 = com.google.android.libraries.navigation.internal.aaq.an.a;
                        }
                        com.google.android.libraries.navigation.internal.ach.c cVar2 = dVar.c == 3 ? (com.google.android.libraries.navigation.internal.ach.c) dVar.d : com.google.android.libraries.navigation.internal.ach.c.a;
                        com.google.android.libraries.navigation.internal.cq.e eVar = new com.google.android.libraries.navigation.internal.cq.e();
                        eVar.e(cVar2.c);
                        eVar.d(cVar2.d);
                        eVar.c(dVar.e);
                        eVar.b(kVar);
                        eVar.b = anVar2;
                        eqVar.h(eVar.a());
                        evVar3 = evVar3;
                    }
                }
                ev evVar5 = evVar3;
                ev evVarT = ev.t(com.google.android.libraries.navigation.internal.cq.k.HEIGHT_RESTRICTION, com.google.android.libraries.navigation.internal.cq.k.WEIGHT_RESTRICTION, com.google.android.libraries.navigation.internal.cq.k.HAZMAT_RESTRICTION, com.google.android.libraries.navigation.internal.cq.k.TRUCKS_PROHIBITED_RESTRICTION);
                if (eqVar.g().isEmpty()) {
                    evVar = evVar4;
                } else {
                    ev evVarG = eqVar.g();
                    ArrayList arrayList = new ArrayList();
                    int i11 = ((lv) evVarT).c;
                    nm nmVarF = nm.f();
                    int i12 = 0;
                    while (i12 < i11) {
                        com.google.android.libraries.navigation.internal.cq.k kVar2 = (com.google.android.libraries.navigation.internal.cq.k) evVarT.get(i12);
                        int i13 = ((lv) evVarG).c;
                        ev evVar6 = evVarT;
                        int i14 = 0;
                        while (true) {
                            i2 = i12 + 1;
                            if (i14 < i13) {
                                ac acVar = (ac) evVarG.get(i14);
                                ev evVar7 = evVar4;
                                if (acVar.c() != kVar2) {
                                    evVar2 = evVarG;
                                    i3 = i11;
                                } else {
                                    nm nmVarF2 = nm.f();
                                    evVar2 = evVarG;
                                    int iB = acVar.b();
                                    i3 = i11;
                                    int iB2 = acVar.b() + acVar.a();
                                    if (iB < iB2) {
                                        nmVarF2.a(lr.c(Integer.valueOf(iB), Integer.valueOf(iB2)));
                                        nmVarF2.d(nmVarF.e());
                                        Iterator it4 = nmVarF2.e().iterator();
                                        int i15 = 0;
                                        while (it4.hasNext()) {
                                            lr lrVar = (lr) it4.next();
                                            Iterator it5 = it4;
                                            com.google.android.libraries.navigation.internal.cq.e eVar2 = new com.google.android.libraries.navigation.internal.cq.e();
                                            eVar2.e(((Integer) lrVar.e()).intValue());
                                            eVar2.d(((Integer) lrVar.f()).intValue() - ((Integer) lrVar.e()).intValue());
                                            eVar2.c(String.format(Locale.US, "%s-%d", acVar.f(), Integer.valueOf(i15)));
                                            eVar2.b(kVar2);
                                            eVar2.b = acVar.d();
                                            acVar.e();
                                            eVar2.a = null;
                                            arrayList.add(eVar2.a());
                                            i13 = i13;
                                            it4 = it5;
                                            i15++;
                                            i12 = i12;
                                        }
                                        i4 = i12;
                                        i5 = i13;
                                        nmVarF.b(nmVarF2.e());
                                    }
                                    i14++;
                                    evVar4 = evVar7;
                                    evVarG = evVar2;
                                    i13 = i5;
                                    i11 = i3;
                                    i12 = i4;
                                }
                                i4 = i12;
                                i5 = i13;
                                i14++;
                                evVar4 = evVar7;
                                evVarG = evVar2;
                                i13 = i5;
                                i11 = i3;
                                i12 = i4;
                            }
                        }
                        evVarT = evVar6;
                        i12 = i2;
                    }
                    evVar = evVar4;
                    Collections.sort(arrayList, new Comparator() { // from class: com.google.android.libraries.navigation.internal.ck.bx
                        @Override // java.util.Comparator
                        public final int compare(Object obj, Object obj2) {
                            return Integer.compare(((com.google.android.libraries.navigation.internal.cq.ac) obj).b(), ((com.google.android.libraries.navigation.internal.cq.ac) obj2).b());
                        }
                    });
                    ezVar2.f(Integer.valueOf(i8), ev.o(arrayList));
                }
                i8++;
                evVar3 = evVar5;
                evVar4 = evVar;
            }
            ev evVar8 = evVar3;
            ev evVar9 = evVar4;
            if (!ezVar2.d().isEmpty()) {
                ezVar.f(Long.valueOf(jVar.c), ezVar2.d());
            }
            i7++;
            evVar3 = evVar8;
            evVar4 = evVar9;
        }
        fd fdVarD = ezVar.d();
        ez ezVar3 = new ez();
        nn nnVarListIterator = fdVarD.entrySet().listIterator();
        while (nnVarListIterator.hasNext()) {
            Map.Entry entry = (Map.Entry) nnVarListIterator.next();
            ez ezVar4 = new ez();
            Iterator it6 = ((Map) entry.getValue()).entrySet().iterator();
            while (it6.hasNext()) {
                Map.Entry entry2 = (Map.Entry) it6.next();
                int i16 = ev.d;
                eq eqVar2 = new eq();
                Iterator it7 = ((List) entry2.getValue()).iterator();
                while (it7.hasNext()) {
                    ac acVar2 = (ac) it7.next();
                    Context context = this.c;
                    com.google.android.libraries.navigation.internal.aaq.an anVarD = acVar2.d();
                    if (anVarD == null) {
                        nnVar = nnVarListIterator;
                        it2 = it6;
                        it3 = it7;
                        aaVarB = null;
                    } else {
                        int i17 = anVarD.b;
                        if (i17 == 1) {
                            int iA3 = com.google.android.libraries.navigation.internal.aao.b.a(((com.google.android.libraries.navigation.internal.aaq.k) anVarD.c).c);
                            if (iA3 == 0) {
                                iA3 = com.google.android.libraries.navigation.internal.aao.b.a;
                            }
                            if (iA3 == com.google.android.libraries.navigation.internal.aao.b.c) {
                                exVar = ex.LEGEND_STYLE_ROUTE_DECORATION_TRUCK_HEIGHT_RESTRICTION_YELLOW_CAUTION_CALLOUT_ICON;
                            } else if (iA3 == com.google.android.libraries.navigation.internal.aao.b.d) {
                                exVar = ex.LEGEND_STYLE_ROUTE_DECORATION_TRUCK_HEIGHT_RESTRICTION_RED_HAZARD_CALLOUT_ICON;
                            } else {
                                exVar = null;
                            }
                            i = 6;
                        } else {
                            if (i17 == 2) {
                                int iA4 = com.google.android.libraries.navigation.internal.aao.b.a(((ak) anVarD.c).c);
                                if (iA4 == 0) {
                                    iA4 = com.google.android.libraries.navigation.internal.aao.b.a;
                                }
                                if (iA4 == com.google.android.libraries.navigation.internal.aao.b.d) {
                                    exVar = ex.LEGEND_STYLE_ROUTE_DECORATION_TRUCK_WEIGHT_RESTRICTION_RED_HAZARD_CALLOUT_ICON;
                                } else {
                                    exVar = null;
                                }
                            } else if (i17 == 7) {
                                exVar = ex.LEGEND_STYLE_ROUTE_DECORATION_TRUCK_HAZMAT_RESTRICTION_RED_HAZARD_CALLOUT_ICON;
                            } else {
                                i = 6;
                                exVar = i17 == 6 ? ex.LEGEND_STYLE_ROUTE_DECORATION_TRUCK_PROHIBITED_RESTRICTION_RED_HAZARD_CALLOUT_ICON : null;
                            }
                            i = 6;
                        }
                        int iOrdinal2 = acVar2.c().ordinal();
                        if (iOrdinal2 == i) {
                            aVar = com.google.android.libraries.navigation.internal.afe.j.s;
                        } else if (iOrdinal2 == 8) {
                            aVar = com.google.android.libraries.navigation.internal.afe.j.u;
                        } else if (iOrdinal2 != 10) {
                            aVar = iOrdinal2 != 12 ? null : com.google.android.libraries.navigation.internal.afe.j.t;
                        } else {
                            aVar = com.google.android.libraries.navigation.internal.afe.j.r;
                        }
                        int i18 = anVarD.b;
                        nnVar = nnVarListIterator;
                        if (i18 == 1) {
                            int i19 = ((com.google.android.libraries.navigation.internal.aaq.k) anVarD.c).b;
                            if (i19 > 0) {
                                Integer[] numArrL = l(i19);
                                it2 = it6;
                                Integer num = numArrL[0];
                                num.intValue();
                                Integer num2 = numArrL[1];
                                if (num2.intValue() > 0) {
                                    it3 = it7;
                                    string = context.getResources().getString(com.google.android.libraries.navigation.internal.bx.g.w, num, num2);
                                } else {
                                    it3 = it7;
                                    string = context.getResources().getString(com.google.android.libraries.navigation.internal.bx.g.v, num);
                                }
                            } else {
                                it2 = it6;
                                it3 = it7;
                                string = context.getString(com.google.android.libraries.navigation.internal.bx.g.z);
                            }
                        } else {
                            it2 = it6;
                            it3 = it7;
                            if (i18 == 2) {
                                int i20 = ((ak) anVarD.c).b;
                                string = i20 > 0 ? context.getResources().getString(com.google.android.libraries.navigation.internal.bx.g.I, g(i20)) : context.getString(com.google.android.libraries.navigation.internal.bx.g.H);
                            } else if (i18 == 7) {
                                string = context.getString(com.google.android.libraries.navigation.internal.bx.g.u);
                            } else {
                                string = i18 == 6 ? context.getString(com.google.android.libraries.navigation.internal.bx.g.F) : null;
                            }
                        }
                        int i21 = anVarD.b;
                        if (i21 != 1) {
                            if (i21 == 2) {
                                string2 = ((ak) anVarD.c).b > 0 ? context.getString(com.google.android.libraries.navigation.internal.bx.g.g, context.getResources().getString(com.google.android.libraries.navigation.internal.bx.g.J, g((anVarD.b == 2 ? (ak) anVarD.c : ak.a).b))) : context.getString(com.google.android.libraries.navigation.internal.bx.g.f);
                            } else if (i21 == 7) {
                                string2 = context.getString(com.google.android.libraries.navigation.internal.bx.g.b);
                            } else {
                                string2 = i21 == 6 ? context.getString(com.google.android.libraries.navigation.internal.bx.g.e) : "";
                            }
                            if (exVar != null || aVar == null) {
                                aaVarB = null;
                            } else if (string == null) {
                                aaVarB = null;
                            } else {
                                com.google.android.libraries.navigation.internal.cq.p pVarA = com.google.android.libraries.navigation.internal.cq.aa.a();
                                pVarA.f(exVar);
                                pVarA.j(string);
                                pVarA.c(string2);
                                com.google.android.libraries.navigation.internal.cq.a aVar2 = (com.google.android.libraries.navigation.internal.cq.a) pVarA;
                                aVar2.g = 0;
                                aVar2.i |= 8192;
                                pVarA.k(t.POLYLINE_DECORATION);
                                pVarA.e(acVar2.f());
                                pVarA.i(acVar2.b());
                                pVarA.g(acVar2.a());
                                pVarA.l(aVar);
                                pVarA.d(acVar2.c());
                                aVar2.a = acVar2.d();
                                aVar2.i |= 16;
                                pVarA.h(null);
                                aaVarB = pVarA.b();
                            }
                        } else if (((com.google.android.libraries.navigation.internal.aaq.k) anVarD.c).b > 0) {
                            Integer[] numArrL2 = l((anVarD.b == 1 ? (com.google.android.libraries.navigation.internal.aaq.k) anVarD.c : com.google.android.libraries.navigation.internal.aaq.k.a).b);
                            Integer num3 = numArrL2[0];
                            num3.intValue();
                            Integer num4 = numArrL2[1];
                            string2 = context.getString(com.google.android.libraries.navigation.internal.bx.g.d, num4.intValue() > 0 ? context.getResources().getString(com.google.android.libraries.navigation.internal.bx.g.x, num3, num4) : context.getResources().getString(com.google.android.libraries.navigation.internal.bx.g.y, num3));
                        } else {
                            string2 = context.getString(com.google.android.libraries.navigation.internal.bx.g.c);
                        }
                        if (exVar != null) {
                            aaVarB = null;
                        } else {
                            aaVarB = null;
                        }
                    }
                    if (aaVarB != null) {
                        eqVar2.h(aaVarB);
                    }
                    nnVarListIterator = nnVar;
                    it6 = it2;
                    it7 = it3;
                }
                ezVar4.f((Integer) entry2.getKey(), eqVar2.g());
                nnVarListIterator = nnVarListIterator;
                it6 = it6;
            }
            ezVar3.f((Long) entry.getKey(), ezVar4.d());
            nnVarListIterator = nnVarListIterator;
        }
        fd fdVarD2 = ezVar3.d();
        fd[] fdVarArr = {ma.b};
        ez ezVar5 = new ez();
        ezVar5.b(fdVarD2);
        nn nnVarListIterator2 = fdVarArr[0].entrySet().listIterator();
        while (nnVarListIterator2.hasNext()) {
            Map.Entry entry3 = (Map.Entry) nnVarListIterator2.next();
            Map map = (Map) fdVarD2.get(entry3.getKey());
            if (map == null) {
                ezVar5.g(entry3);
            } else {
                ez ezVar6 = new ez();
                ezVar6.b(map);
                for (Integer num5 : ((Map) entry3.getValue()).keySet()) {
                    num5.intValue();
                    List list = (List) map.get(num5);
                    if (list == null) {
                        ezVar6.f(num5, (List) ((Map) entry3.getValue()).get(num5));
                    } else {
                        int i22 = ev.d;
                        eq eqVar3 = new eq();
                        eqVar3.j(list);
                        eqVar3.j((Iterable) ((Map) entry3.getValue()).get(num5));
                        ezVar6.f(num5, eqVar3.g());
                    }
                }
                ezVar5.f((Long) entry3.getKey(), ezVar6.c());
            }
        }
        fd fdVarC = ezVar5.c();
        fd fdVar = this.m;
        if (fdVar == null) {
            vVar.l(fdVarC);
            this.m = fdVarC;
            return;
        }
        Stream streamFlatMap = fdVar.values().stream().flatMap(new Function() { // from class: com.google.android.libraries.navigation.internal.cp.f
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((Map) obj).values().stream();
            }
        }).flatMap(new Function() { // from class: com.google.android.libraries.navigation.internal.cp.g
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((List) obj).stream();
            }
        });
        int i23 = ev.d;
        if (j((ev) streamFlatMap.collect(br.a), (ev) fdVarC.values().stream().flatMap(new Function() { // from class: com.google.android.libraries.navigation.internal.cp.h
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((Map) obj).values().stream();
            }
        }).flatMap(new Function() { // from class: com.google.android.libraries.navigation.internal.cp.i
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((List) obj).stream();
            }
        }).collect(br.a))) {
            vVar.l(fdVarC);
            this.m = fdVarC;
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x028d  */
    /* JADX WARN: Code duplicated, block: B:102:0x0294  */
    /* JADX WARN: Code duplicated, block: B:104:0x029e  */
    /* JADX WARN: Code duplicated, block: B:105:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:108:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:113:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:115:0x02be  */
    /* JADX WARN: Code duplicated, block: B:118:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:127:0x0322  */
    /* JADX WARN: Code duplicated, block: B:130:0x0328  */
    /* JADX WARN: Code duplicated, block: B:132:0x032e  */
    /* JADX WARN: Code duplicated, block: B:133:0x0333  */
    /* JADX WARN: Code duplicated, block: B:136:0x0339  */
    /* JADX WARN: Code duplicated, block: B:139:0x033f  */
    /* JADX WARN: Code duplicated, block: B:145:0x0355  */
    /* JADX WARN: Code duplicated, block: B:146:0x035b  */
    /* JADX WARN: Code duplicated, block: B:148:0x035f  */
    /* JADX WARN: Code duplicated, block: B:150:0x0363  */
    /* JADX WARN: Code duplicated, block: B:153:0x0369  */
    /* JADX WARN: Code duplicated, block: B:155:0x036d  */
    /* JADX WARN: Code duplicated, block: B:158:0x0373  */
    /* JADX WARN: Code duplicated, block: B:159:0x038a  */
    /* JADX WARN: Code duplicated, block: B:161:0x0393  */
    /* JADX WARN: Code duplicated, block: B:163:0x0399  */
    /* JADX WARN: Code duplicated, block: B:164:0x039e  */
    /* JADX WARN: Code duplicated, block: B:167:0x03a4  */
    /* JADX WARN: Code duplicated, block: B:170:0x03ae  */
    /* JADX WARN: Code duplicated, block: B:172:0x03b2  */
    /* JADX WARN: Code duplicated, block: B:175:0x03b8  */
    /* JADX WARN: Code duplicated, block: B:177:0x03bc  */
    /* JADX WARN: Code duplicated, block: B:180:0x03c2  */
    /* JADX WARN: Code duplicated, block: B:182:0x03ce  */
    /* JADX WARN: Code duplicated, block: B:190:0x03ec  */
    /* JADX WARN: Code duplicated, block: B:191:0x03f1  */
    /* JADX WARN: Code duplicated, block: B:194:0x03f7  */
    /* JADX WARN: Code duplicated, block: B:197:0x040c  */
    /* JADX WARN: Code duplicated, block: B:201:0x041c  */
    /* JADX WARN: Code duplicated, block: B:205:0x0462  */
    /* JADX WARN: Code duplicated, block: B:207:0x0468  */
    /* JADX WARN: Code duplicated, block: B:208:0x046b  */
    /* JADX WARN: Code duplicated, block: B:211:0x0490  */
    /* JADX WARN: Code duplicated, block: B:212:0x049d  */
    /* JADX WARN: Code duplicated, block: B:214:0x04a3  */
    /* JADX WARN: Code duplicated, block: B:215:0x04ae  */
    /* JADX WARN: Code duplicated, block: B:218:0x04b6  */
    /* JADX WARN: Code duplicated, block: B:219:0x04b9  */
    /* JADX WARN: Code duplicated, block: B:221:0x04be  */
    /* JADX WARN: Code duplicated, block: B:224:0x04ca  */
    /* JADX WARN: Code duplicated, block: B:227:0x04d0  */
    /* JADX WARN: Code duplicated, block: B:229:0x04d6  */
    /* JADX WARN: Code duplicated, block: B:230:0x04db  */
    /* JADX WARN: Code duplicated, block: B:233:0x04e1  */
    /* JADX WARN: Code duplicated, block: B:236:0x04ec  */
    /* JADX WARN: Code duplicated, block: B:237:0x04ef  */
    /* JADX WARN: Code duplicated, block: B:240:0x04fb  */
    /* JADX WARN: Code duplicated, block: B:244:0x050f  */
    /* JADX WARN: Code duplicated, block: B:253:0x0548  */
    /* JADX WARN: Code duplicated, block: B:355:0x077a  */
    /* JADX WARN: Code duplicated, block: B:357:0x078b  */
    /* JADX WARN: Code duplicated, block: B:363:0x07ca  */
    /* JADX WARN: Code duplicated, block: B:366:0x0800  */
    /* JADX WARN: Code duplicated, block: B:367:0x0802  */
    /* JADX WARN: Code duplicated, block: B:369:0x0812 A[LOOP:2: B:368:0x0810->B:369:0x0812, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:373:0x0834  */
    /* JADX WARN: Code duplicated, block: B:406:0x0542 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:414:0x0871 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:419:0x078e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x023d  */
    /* JADX WARN: Code duplicated, block: B:74:0x0245  */
    /* JADX WARN: Code duplicated, block: B:77:0x024b  */
    /* JADX WARN: Code duplicated, block: B:78:0x024d  */
    /* JADX WARN: Code duplicated, block: B:81:0x0252  */
    /* JADX WARN: Code duplicated, block: B:83:0x0256  */
    /* JADX WARN: Code duplicated, block: B:84:0x025b  */
    /* JADX WARN: Code duplicated, block: B:87:0x0261  */
    /* JADX WARN: Code duplicated, block: B:89:0x0267  */
    /* JADX WARN: Code duplicated, block: B:91:0x026b  */
    /* JADX WARN: Code duplicated, block: B:94:0x0278  */
    /* JADX WARN: Code duplicated, block: B:96:0x0282  */
    /* JADX WARN: Code duplicated, block: B:97:0x0287  */
    /* JADX WARN: Multi-variable type inference failed */
    private final void i(final int i) {
        ev evVar;
        ArrayList arrayList;
        int i2;
        z zVar;
        ev evVarG;
        com.google.android.libraries.navigation.internal.ot.k kVar;
        ev evVarC;
        int i3;
        int i4;
        boolean z;
        int i5;
        com.google.android.libraries.navigation.internal.cq.g gVar;
        com.google.android.libraries.navigation.internal.cq.i iVar;
        com.google.android.libraries.navigation.internal.cn.q qVarB;
        fw fwVar;
        ev evVar2;
        int size;
        int i6;
        com.google.android.libraries.navigation.internal.ot.k kVarC;
        ev evVar3;
        ev evVar4;
        s sVar;
        eq eqVar;
        com.google.android.libraries.navigation.internal.cn.b bVar;
        ax axVar;
        com.google.android.libraries.navigation.internal.mj.a aVar;
        ev evVar5;
        ax axVar2;
        Context context;
        com.google.android.libraries.navigation.internal.mj.a aVar2;
        com.google.android.libraries.navigation.internal.fz.d dVar;
        aj ajVar;
        com.google.android.libraries.navigation.internal.dx.i iVar2;
        el elVar;
        ax axVar3;
        Context context2;
        com.google.android.libraries.navigation.internal.mj.a aVar3;
        fp fpVarB;
        boolean z2;
        com.google.android.libraries.navigation.internal.adr.ex exVar;
        int i7;
        int i8;
        fh fhVar;
        fg fgVar;
        com.google.android.libraries.navigation.internal.bq.e eVarB;
        final com.google.android.libraries.navigation.internal.co.b bVar2;
        String strD;
        com.google.android.libraries.navigation.internal.co.a aVar4;
        String strE;
        fh fhVar2;
        fg fgVar2;
        fb fbVar;
        fb fbVar2;
        com.google.android.libraries.navigation.internal.mj.a aVar5;
        com.google.android.libraries.navigation.internal.iv.f fVar;
        fh fhVar3;
        fb fbVar3;
        long j;
        nq nqVarC;
        int i9;
        an anVarI;
        Long l;
        long jLongValue;
        List listK;
        String string;
        String str;
        int i10;
        long epochMilli;
        final long j2;
        com.google.android.libraries.navigation.internal.aap.d dVar2;
        com.google.android.libraries.navigation.internal.aap.d dVar3;
        int i11;
        String string2;
        Cdo cdoB;
        Cdo cdoB2;
        com.google.android.libraries.navigation.internal.afd.a aVar6;
        String str2;
        el elVar2;
        com.google.android.libraries.navigation.internal.afd.a aVar7;
        fh fhVar4;
        fg fgVar3;
        ef efVar;
        gn gnVar;
        com.google.android.libraries.navigation.internal.adr.aj ajVar2;
        boolean z3;
        ef efVar2;
        ee eeVar;
        ef efVar3;
        bm bmVar;
        o oVar = this;
        v vVar = oVar.a;
        if (vVar == null) {
            return;
        }
        int i12 = ev.d;
        eq eqVar2 = new eq();
        aj ajVar3 = oVar.b;
        if (ajVar3 != null && ((Boolean) oVar.g.b(new b()).e(false)).booleanValue()) {
            ev evVar6 = oVar.k;
            int i13 = ((lv) evVar6).c;
            int i14 = 0;
            while (i14 < i13) {
                z zVar2 = (z) evVar6.get(i14);
                ArrayList arrayList2 = new ArrayList();
                final com.google.android.libraries.navigation.internal.cn.n nVar = oVar.e;
                Context context3 = oVar.c;
                com.google.android.libraries.navigation.internal.dx.i iVar3 = oVar.h;
                com.google.android.libraries.navigation.internal.cn.q qVarB2 = zVar2.b();
                if (qVarB2 == null || (axVar = (bVar = (com.google.android.libraries.navigation.internal.cn.b) nVar).f) == null || (aVar = bVar.g) == null) {
                    evVar = evVar6;
                } else {
                    evVar = evVar6;
                    com.google.android.libraries.navigation.internal.fz.d dVar4 = bVar.h;
                    if (dVar4 != null) {
                        vVar = vVar;
                        ev evVar7 = (ev) ((com.google.android.libraries.navigation.internal.cn.d) qVarB2).a.stream().filter(new Predicate() { // from class: com.google.android.libraries.navigation.internal.cp.j
                            @Override // java.util.function.Predicate
                            public final boolean test(Object obj) {
                                el elVar3 = (el) obj;
                                com.google.android.libraries.navigation.internal.cn.b bVar3 = (com.google.android.libraries.navigation.internal.cn.b) nVar;
                                com.google.android.libraries.navigation.internal.cn.o oVar2 = bVar3.j;
                                if (oVar2 != null) {
                                    return !oVar2.a(elVar3, Integer.valueOf(i), bVar3.k, bVar3.c).booleanValue();
                                }
                                return false;
                            }
                        }).collect(br.a);
                        com.google.android.libraries.navigation.internal.ck.g gVar2 = new com.google.android.libraries.navigation.internal.ck.g();
                        eqVar2 = eqVar2;
                        gVar2.a = zVar2.a();
                        gVar2.q = (byte) (gVar2.q | 1);
                        Objects.requireNonNull(evVar7);
                        gVar2.b = evVar7;
                        Objects.requireNonNull(axVar);
                        gVar2.c = axVar;
                        Objects.requireNonNull(context3);
                        gVar2.d = context3;
                        Objects.requireNonNull(aVar);
                        gVar2.e = aVar;
                        Objects.requireNonNull(dVar4);
                        gVar2.f = dVar4;
                        Objects.requireNonNull(ajVar3);
                        gVar2.j = ajVar3;
                        gVar2.g = bVar.i;
                        gVar2.h = null;
                        gVar2.i = k(nVar) ? Integer.valueOf(oVar.f376n) : null;
                        boolean z4 = bVar.b;
                        gVar2.k = !z4;
                        byte b = gVar2.q;
                        gVar2.l = z4;
                        gVar2.f369n = bVar.d;
                        gVar2.q = (byte) (b | Ascii.SYN);
                        gVar2.m = zVar2.d();
                        gVar2.q = (byte) (gVar2.q | 8);
                        Objects.requireNonNull(iVar3);
                        gVar2.o = iVar3;
                        boolean z5 = bVar.c;
                        gVar2.p = z5;
                        int i15 = gVar2.q | 32;
                        gVar2.q = (byte) i15;
                        if (i15 != 63 || (evVar5 = gVar2.b) == null || (axVar2 = gVar2.c) == null || (context = gVar2.d) == null || (aVar2 = gVar2.e) == null || (dVar = gVar2.f) == null || (ajVar = gVar2.j) == null || (iVar2 = gVar2.o) == null) {
                            throw new IllegalStateException();
                        }
                        com.google.android.libraries.navigation.internal.ck.h hVar = new com.google.android.libraries.navigation.internal.ck.h(gVar2.a, evVar5, axVar2, context, aVar2, dVar, gVar2.g, null, gVar2.i, ajVar, gVar2.k, gVar2.l, gVar2.m, gVar2.f369n, iVar2, z5);
                        eq eqVar3 = new eq();
                        ev evVar8 = hVar.b;
                        int size2 = evVar8.size();
                        int i16 = 0;
                        int i17 = 0;
                        while (i16 < size2) {
                            el elVar3 = (el) evVar8.get(i16);
                            com.google.android.libraries.navigation.internal.co.c cVar = new com.google.android.libraries.navigation.internal.co.c();
                            Objects.requireNonNull(elVar3);
                            cVar.a = elVar3;
                            ax axVar4 = hVar.c;
                            Objects.requireNonNull(axVar4);
                            cVar.b = axVar4;
                            Context context4 = hVar.d;
                            Objects.requireNonNull(context4);
                            cVar.c = context4;
                            com.google.android.libraries.navigation.internal.mj.a aVar8 = hVar.e;
                            Objects.requireNonNull(aVar8);
                            cVar.d = aVar8;
                            com.google.android.libraries.navigation.internal.fz.d dVar5 = hVar.f;
                            Objects.requireNonNull(dVar5);
                            cVar.e = dVar5;
                            cVar.f = hVar.g;
                            cVar.i = hVar.k;
                            byte b2 = cVar.l;
                            cVar.j = hVar.f370n;
                            cVar.l = (byte) (b2 | 3);
                            cVar.g = null;
                            cVar.h = hVar.i;
                            com.google.android.libraries.navigation.internal.dx.i iVar4 = hVar.o;
                            Objects.requireNonNull(iVar4);
                            cVar.k = iVar4;
                            if (cVar.l == 3 && (elVar = cVar.a) != null && (axVar3 = cVar.b) != null && (context2 = cVar.c) != null && (aVar3 = cVar.d) != null) {
                                ev evVar9 = evVar8;
                                com.google.android.libraries.navigation.internal.fz.d dVar6 = cVar.e;
                                if (dVar6 != null) {
                                    aj ajVar4 = ajVar3;
                                    com.google.android.libraries.navigation.internal.dx.i iVar5 = cVar.k;
                                    if (iVar5 != null) {
                                        int i18 = size2;
                                        int i19 = i14;
                                        ArrayList arrayList3 = arrayList2;
                                        com.google.android.libraries.navigation.internal.co.d dVar7 = new com.google.android.libraries.navigation.internal.co.d(elVar, axVar3, context2, aVar3, dVar6, cVar.f, null, cVar.h, cVar.i, cVar.j, iVar5);
                                        el elVar4 = dVar7.a;
                                        ax axVar5 = dVar7.b;
                                        Context context5 = dVar7.c;
                                        com.google.android.libraries.navigation.internal.fz.d dVar8 = dVar7.e;
                                        boolean z6 = dVar7.j;
                                        fh fhVar5 = elVar4.c == 22 ? (fh) elVar4.d : fh.a;
                                        fy fyVarC = com.google.android.libraries.navigation.internal.br.l.c(elVar4);
                                        Integer num = dVar7.h;
                                        com.google.android.libraries.navigation.internal.aap.d dVar9 = fhVar5.d;
                                        if (dVar9 == null) {
                                            dVar9 = com.google.android.libraries.navigation.internal.aap.d.a;
                                        }
                                        if (dVar9.c <= 0) {
                                            fpVarB = fp.b(elVar4.g);
                                            if (fpVarB == null) {
                                                fpVarB = fp.UNKNOWN;
                                            }
                                            if (fpVarB == fp.ON_ROUTE_PROBLEM) {
                                                z2 = true;
                                            } else {
                                                z2 = false;
                                            }
                                            if (z2) {
                                                if (elVar4.c == 30) {
                                                    efVar3 = (ef) elVar4.d;
                                                } else {
                                                    efVar3 = ef.a;
                                                }
                                                bmVar = efVar3.c;
                                                if (bmVar == null) {
                                                    bmVar = bm.a;
                                                }
                                                i8 = bmVar.c;
                                                i7 = 0;
                                            } else {
                                                exVar = fhVar5.i;
                                                if (exVar == null) {
                                                    exVar = com.google.android.libraries.navigation.internal.adr.ex.a;
                                                }
                                                int i20 = exVar.c;
                                                i7 = exVar.d;
                                                i8 = i20;
                                            }
                                            if (z2) {
                                                if (elVar4.c == 30) {
                                                    efVar2 = (ef) elVar4.d;
                                                } else {
                                                    efVar2 = ef.a;
                                                }
                                                eeVar = efVar2.d;
                                                if (eeVar == null) {
                                                    eeVar = ee.a;
                                                }
                                                eVarB = com.google.android.libraries.navigation.internal.bq.e.a(eeVar, axVar5);
                                            } else {
                                                if (elVar4.c == 22) {
                                                    fhVar = (fh) elVar4.d;
                                                } else {
                                                    fhVar = fh.a;
                                                }
                                                fgVar = fhVar.k;
                                                if (fgVar == null) {
                                                    fgVar = fg.a;
                                                }
                                                eVarB = com.google.android.libraries.navigation.internal.bq.e.b(fgVar, axVar5);
                                            }
                                            if (eVarB.b) {
                                                if ((elVar4.b & 131072) != 0) {
                                                    strD = com.google.android.libraries.navigation.internal.br.l.d(elVar4, z6);
                                                    if (aq.c(strD)) {
                                                        eqVar3 = eqVar3;
                                                        aVar4 = new com.google.android.libraries.navigation.internal.co.a();
                                                        aVar4.a = i8;
                                                        byte b3 = aVar4.i;
                                                        aVar4.b = i7;
                                                        aVar4.i = (byte) (b3 | 3);
                                                        Objects.requireNonNull(strD);
                                                        aVar4.c = strD;
                                                        Objects.requireNonNull(elVar4);
                                                        aVar4.d = elVar4;
                                                        if (dVar7.i || com.google.android.libraries.navigation.internal.br.l.e(elVar4).isEmpty()) {
                                                            strE = null;
                                                        } else {
                                                            strE = com.google.android.libraries.navigation.internal.br.l.f(elVar4).isEmpty() ? com.google.android.libraries.navigation.internal.br.l.e(elVar4) : com.google.android.libraries.navigation.internal.br.l.e(elVar4) + StringUtils.SPACE + com.google.android.libraries.navigation.internal.br.l.f(elVar4);
                                                            strE.isEmpty();
                                                        }
                                                        aVar4.g = strE;
                                                        if (z2) {
                                                            if (elVar4.c == 30) {
                                                                efVar = (ef) elVar4.d;
                                                            } else {
                                                                efVar = ef.a;
                                                            }
                                                            gnVar = efVar.e;
                                                            if (gnVar == null) {
                                                                gnVar = gn.a;
                                                            }
                                                            ajVar2 = gnVar.d;
                                                            if (ajVar2 == null) {
                                                                ajVar2 = com.google.android.libraries.navigation.internal.adr.aj.a;
                                                            }
                                                            z3 = eVarB.c;
                                                            String str3 = ajVar2.c;
                                                            if (z3 || str3.isEmpty()) {
                                                                aVar4.a(true);
                                                            } else {
                                                                aVar4.f = str3;
                                                                aVar4.a(false);
                                                            }
                                                        } else if (eVarB.c) {
                                                            dVar2 = fhVar5.d;
                                                            if (dVar2 == null) {
                                                                dVar2 = com.google.android.libraries.navigation.internal.aap.d.a;
                                                            }
                                                            if (dVar2.c != 0) {
                                                                dVar3 = fhVar5.d;
                                                                if (dVar3 == null) {
                                                                    dVar3 = com.google.android.libraries.navigation.internal.aap.d.a;
                                                                }
                                                                i11 = dVar3.c;
                                                                if (i11 > 0) {
                                                                    string2 = context5.getString(com.google.android.libraries.navigation.internal.qr.e.g, u.e(context5.getResources(), i11, 2).toString());
                                                                } else {
                                                                    string2 = null;
                                                                }
                                                                aVar4.f = string2;
                                                                aVar4.a(true);
                                                            } else {
                                                                if (elVar4.c == 22) {
                                                                    fhVar2 = (fh) elVar4.d;
                                                                } else {
                                                                    fhVar2 = fh.a;
                                                                }
                                                                fgVar2 = fhVar2.k;
                                                                if (fgVar2 == null) {
                                                                    fgVar2 = fg.a;
                                                                }
                                                                if (com.google.android.libraries.navigation.internal.bq.e.b(fgVar2, axVar5).c) {
                                                                    fbVar = fhVar2.m;
                                                                    if (fbVar == null) {
                                                                        fbVar = fb.a;
                                                                    }
                                                                    if (fbVar.c <= 0) {
                                                                        aVar4.a(true);
                                                                    } else {
                                                                        fbVar2 = fhVar2.m;
                                                                        if (fbVar2 == null) {
                                                                            fbVar2 = fb.a;
                                                                        }
                                                                        if (fbVar2.f) {
                                                                            aVar5 = dVar7.d;
                                                                            fVar = dVar7.f;
                                                                            com.google.android.libraries.navigation.internal.dx.i iVar6 = dVar7.k;
                                                                            aVar4.a(true);
                                                                            if (fVar != null) {
                                                                                if (elVar4.c == 22) {
                                                                                    fhVar3 = (fh) elVar4.d;
                                                                                } else {
                                                                                    fhVar3 = fh.a;
                                                                                }
                                                                                fbVar3 = fhVar3.m;
                                                                                if (fbVar3 == null) {
                                                                                    fbVar3 = fb.a;
                                                                                }
                                                                                j = fbVar3.c;
                                                                                if (j >= 1) {
                                                                                    i9 = nqVarC.b;
                                                                                    if ((i9 & 2) != 0) {
                                                                                        gl glVarY = gl.y(de.d(nqVarC.d).c(new as() { // from class: com.google.android.libraries.navigation.internal.co.e
                                                                                            @Override // com.google.android.libraries.navigation.internal.yx.as
                                                                                            public final boolean a(Object obj) {
                                                                                                return ((Long) obj).longValue() > 0;
                                                                                            }
                                                                                        }).f());
                                                                                        Long lValueOf = Long.valueOf(j);
                                                                                        anVarI = an.i((Long) glVarY.floor(lValueOf));
                                                                                        l = (Long) anVarI.e(lValueOf);
                                                                                        jLongValue = l.longValue();
                                                                                        listK = fVar.k(ab.bU, new ArrayList());
                                                                                        if (listK.size() < nqVarC.c) {
                                                                                            if (anVarI.g()) {
                                                                                                i10 = com.google.android.libraries.navigation.internal.qr.e.d;
                                                                                            } else {
                                                                                                i10 = com.google.android.libraries.navigation.internal.qr.e.f;
                                                                                            }
                                                                                            string = context5.getString(i10, l);
                                                                                            epochMilli = aVar5.f().toEpochMilli();
                                                                                            j2 = (-86400000) + epochMilli;
                                                                                            if (!de.d(listK).i(new as() { // from class: com.google.android.libraries.navigation.internal.co.f
                                                                                                @Override // com.google.android.libraries.navigation.internal.yx.as
                                                                                                public final boolean a(Object obj) {
                                                                                                    return Long.parseLong((String) obj) > j2;
                                                                                                }
                                                                                            })) {
                                                                                                listK.add(Long.toString(epochMilli));
                                                                                                fVar.u(ab.bU, listK);
                                                                                            }
                                                                                        } else if (anVarI.g()) {
                                                                                            string = context5.getString(com.google.android.libraries.navigation.internal.qr.e.e, l);
                                                                                        } else {
                                                                                            string = Long.toString(jLongValue);
                                                                                        }
                                                                                        aVar4.f = string;
                                                                                        if (z6) {
                                                                                            str = nqVarC.f;
                                                                                        } else {
                                                                                            str = nqVarC.e;
                                                                                        }
                                                                                        aVar4.e = str;
                                                                                    }
                                                                                }
                                                                            }
                                                                        } else {
                                                                            aVar4.a(true);
                                                                        }
                                                                    }
                                                                } else {
                                                                    aVar4.a(true);
                                                                }
                                                            }
                                                        } else {
                                                            if (elVar4.c == 22) {
                                                                fhVar2 = (fh) elVar4.d;
                                                            } else {
                                                                fhVar2 = fh.a;
                                                            }
                                                            fgVar2 = fhVar2.k;
                                                            if (fgVar2 == null) {
                                                                fgVar2 = fg.a;
                                                            }
                                                            if (com.google.android.libraries.navigation.internal.bq.e.b(fgVar2, axVar5).c) {
                                                                aVar4.a(true);
                                                            } else {
                                                                fbVar = fhVar2.m;
                                                                if (fbVar == null) {
                                                                    fbVar = fb.a;
                                                                }
                                                                if (fbVar.c <= 0) {
                                                                    aVar4.a(true);
                                                                } else {
                                                                    fbVar2 = fhVar2.m;
                                                                    if (fbVar2 == null) {
                                                                        fbVar2 = fb.a;
                                                                    }
                                                                    if (fbVar2.f) {
                                                                        aVar5 = dVar7.d;
                                                                        fVar = dVar7.f;
                                                                        com.google.android.libraries.navigation.internal.dx.i iVar7 = dVar7.k;
                                                                        aVar4.a(true);
                                                                        if (fVar != null && dVar8.x().g() && iVar7.p() && dVar8.K().h) {
                                                                            if (elVar4.c == 22) {
                                                                                fhVar3 = (fh) elVar4.d;
                                                                            } else {
                                                                                fhVar3 = fh.a;
                                                                            }
                                                                            fbVar3 = fhVar3.m;
                                                                            if (fbVar3 == null) {
                                                                                fbVar3 = fb.a;
                                                                            }
                                                                            j = fbVar3.c;
                                                                            if (j >= 1 && (nqVarC = dVar8.x().c()) != null) {
                                                                                i9 = nqVarC.b;
                                                                                if ((i9 & 2) != 0 && (i9 & 4) != 0) {
                                                                                    gl glVarY2 = gl.y(de.d(nqVarC.d).c(new as() { // from class: com.google.android.libraries.navigation.internal.co.e
                                                                                        @Override // com.google.android.libraries.navigation.internal.yx.as
                                                                                        public final boolean a(Object obj) {
                                                                                            return ((Long) obj).longValue() > 0;
                                                                                        }
                                                                                    }).f());
                                                                                    Long lValueOf2 = Long.valueOf(j);
                                                                                    anVarI = an.i((Long) glVarY2.floor(lValueOf2));
                                                                                    l = (Long) anVarI.e(lValueOf2);
                                                                                    jLongValue = l.longValue();
                                                                                    listK = fVar.k(ab.bU, new ArrayList());
                                                                                    if (listK.size() < nqVarC.c) {
                                                                                        if (anVarI.g()) {
                                                                                            i10 = com.google.android.libraries.navigation.internal.qr.e.d;
                                                                                        } else {
                                                                                            i10 = com.google.android.libraries.navigation.internal.qr.e.f;
                                                                                        }
                                                                                        string = context5.getString(i10, l);
                                                                                        epochMilli = aVar5.f().toEpochMilli();
                                                                                        j2 = (-86400000) + epochMilli;
                                                                                        if (!de.d(listK).i(new as() { // from class: com.google.android.libraries.navigation.internal.co.f
                                                                                            @Override // com.google.android.libraries.navigation.internal.yx.as
                                                                                            public final boolean a(Object obj) {
                                                                                                return Long.parseLong((String) obj) > j2;
                                                                                            }
                                                                                        })) {
                                                                                            listK.add(Long.toString(epochMilli));
                                                                                            fVar.u(ab.bU, listK);
                                                                                        }
                                                                                    } else if (anVarI.g()) {
                                                                                        string = context5.getString(com.google.android.libraries.navigation.internal.qr.e.e, l);
                                                                                    } else {
                                                                                        string = Long.toString(jLongValue);
                                                                                    }
                                                                                    aVar4.f = string;
                                                                                    if (z6) {
                                                                                        str = nqVarC.f;
                                                                                    } else {
                                                                                        str = nqVarC.e;
                                                                                    }
                                                                                    aVar4.e = str;
                                                                                }
                                                                            }
                                                                        }
                                                                    } else {
                                                                        aVar4.a(true);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        cdoB = Cdo.b(elVar4.u);
                                                        if (cdoB == null) {
                                                            cdoB = Cdo.INCIDENT_OTHER;
                                                        }
                                                        if (cdoB != Cdo.INCIDENT_ROAD_CLOSED) {
                                                            if (elVar4.c == 22) {
                                                                fhVar4 = (fh) elVar4.d;
                                                            } else {
                                                                fhVar4 = fh.a;
                                                            }
                                                            fgVar3 = fhVar4.k;
                                                            if (fgVar3 == null) {
                                                                fgVar3 = fg.a;
                                                            }
                                                            if (ff.a(fgVar3.c) == 2) {
                                                                aVar6 = com.google.android.libraries.navigation.internal.afe.f.b;
                                                            }
                                                            Objects.requireNonNull(aVar6);
                                                            aVar4.j = aVar6;
                                                            if (aVar4.i == 7 || (str2 = aVar4.c) == null || (elVar2 = aVar4.d) == null || (aVar7 = aVar4.j) == null) {
                                                                throw new IllegalStateException();
                                                            }
                                                            bVar2 = new com.google.android.libraries.navigation.internal.co.b(aVar4.a, aVar4.b, str2, elVar2, aVar7, aVar4.e, aVar4.f, aVar4.g, aVar4.h);
                                                        }
                                                        EnumMap enumMap = com.google.android.libraries.navigation.internal.tt.e.b;
                                                        cdoB2 = Cdo.b(elVar4.u);
                                                        if (cdoB2 == null) {
                                                            cdoB2 = Cdo.INCIDENT_OTHER;
                                                        }
                                                        aVar6 = (com.google.android.libraries.navigation.internal.afd.a) enumMap.getOrDefault(cdoB2, com.google.android.libraries.navigation.internal.afe.o.g);
                                                        Objects.requireNonNull(aVar6);
                                                        aVar4.j = aVar6;
                                                        if (aVar4.i == 7) {
                                                        }
                                                        throw new IllegalStateException();
                                                    }
                                                } else {
                                                    eqVar3 = eqVar3;
                                                    bVar2 = null;
                                                }
                                            }
                                            bVar2 = null;
                                        } else {
                                            com.google.android.libraries.navigation.internal.aap.d dVar10 = fhVar5.d;
                                            if (dVar10 == null) {
                                                dVar10 = com.google.android.libraries.navigation.internal.aap.d.a;
                                            }
                                            if (dVar10.c <= 59) {
                                                i16 = i16;
                                                zVar2 = zVar2;
                                            } else {
                                                fpVarB = fp.b(elVar4.g);
                                                if (fpVarB == null) {
                                                    fpVarB = fp.UNKNOWN;
                                                }
                                                if (fpVarB == fp.ON_ROUTE_PROBLEM) {
                                                    z2 = true;
                                                } else {
                                                    z2 = false;
                                                }
                                                if (z2) {
                                                    if (elVar4.c == 30) {
                                                        efVar3 = (ef) elVar4.d;
                                                    } else {
                                                        efVar3 = ef.a;
                                                    }
                                                    bmVar = efVar3.c;
                                                    if (bmVar == null) {
                                                        bmVar = bm.a;
                                                    }
                                                    i8 = bmVar.c;
                                                    i7 = 0;
                                                } else {
                                                    exVar = fhVar5.i;
                                                    if (exVar == null) {
                                                        exVar = com.google.android.libraries.navigation.internal.adr.ex.a;
                                                    }
                                                    int i21 = exVar.c;
                                                    i7 = exVar.d;
                                                    i8 = i21;
                                                }
                                                if (z2) {
                                                    if (elVar4.c == 30) {
                                                        efVar2 = (ef) elVar4.d;
                                                    } else {
                                                        efVar2 = ef.a;
                                                    }
                                                    eeVar = efVar2.d;
                                                    if (eeVar == null) {
                                                        eeVar = ee.a;
                                                    }
                                                    eVarB = com.google.android.libraries.navigation.internal.bq.e.a(eeVar, axVar5);
                                                } else {
                                                    if (elVar4.c == 22) {
                                                        fhVar = (fh) elVar4.d;
                                                    } else {
                                                        fhVar = fh.a;
                                                    }
                                                    fgVar = fhVar.k;
                                                    if (fgVar == null) {
                                                        fgVar = fg.a;
                                                    }
                                                    eVarB = com.google.android.libraries.navigation.internal.bq.e.b(fgVar, axVar5);
                                                }
                                                if (eVarB.b) {
                                                    if ((elVar4.b & 131072) != 0) {
                                                        strD = com.google.android.libraries.navigation.internal.br.l.d(elVar4, z6);
                                                        if (aq.c(strD)) {
                                                            eqVar3 = eqVar3;
                                                            aVar4 = new com.google.android.libraries.navigation.internal.co.a();
                                                            aVar4.a = i8;
                                                            byte b4 = aVar4.i;
                                                            aVar4.b = i7;
                                                            aVar4.i = (byte) (b4 | 3);
                                                            Objects.requireNonNull(strD);
                                                            aVar4.c = strD;
                                                            Objects.requireNonNull(elVar4);
                                                            aVar4.d = elVar4;
                                                            if (dVar7.i) {
                                                                strE = null;
                                                            } else {
                                                                strE = null;
                                                            }
                                                            aVar4.g = strE;
                                                            if (z2) {
                                                                if (elVar4.c == 30) {
                                                                    efVar = (ef) elVar4.d;
                                                                } else {
                                                                    efVar = ef.a;
                                                                }
                                                                gnVar = efVar.e;
                                                                if (gnVar == null) {
                                                                    gnVar = gn.a;
                                                                }
                                                                ajVar2 = gnVar.d;
                                                                if (ajVar2 == null) {
                                                                    ajVar2 = com.google.android.libraries.navigation.internal.adr.aj.a;
                                                                }
                                                                z3 = eVarB.c;
                                                                String str4 = ajVar2.c;
                                                                if (z3) {
                                                                    aVar4.a(true);
                                                                } else {
                                                                    aVar4.a(true);
                                                                }
                                                            } else if (eVarB.c) {
                                                                if (elVar4.c == 22) {
                                                                    fhVar2 = (fh) elVar4.d;
                                                                } else {
                                                                    fhVar2 = fh.a;
                                                                }
                                                                fgVar2 = fhVar2.k;
                                                                if (fgVar2 == null) {
                                                                    fgVar2 = fg.a;
                                                                }
                                                                if (com.google.android.libraries.navigation.internal.bq.e.b(fgVar2, axVar5).c) {
                                                                    aVar4.a(true);
                                                                } else {
                                                                    fbVar = fhVar2.m;
                                                                    if (fbVar == null) {
                                                                        fbVar = fb.a;
                                                                    }
                                                                    if (fbVar.c <= 0) {
                                                                        aVar4.a(true);
                                                                    } else {
                                                                        fbVar2 = fhVar2.m;
                                                                        if (fbVar2 == null) {
                                                                            fbVar2 = fb.a;
                                                                        }
                                                                        if (fbVar2.f) {
                                                                            aVar5 = dVar7.d;
                                                                            fVar = dVar7.f;
                                                                            com.google.android.libraries.navigation.internal.dx.i iVar8 = dVar7.k;
                                                                            aVar4.a(true);
                                                                            if (fVar != null) {
                                                                                if (elVar4.c == 22) {
                                                                                    fhVar3 = (fh) elVar4.d;
                                                                                } else {
                                                                                    fhVar3 = fh.a;
                                                                                }
                                                                                fbVar3 = fhVar3.m;
                                                                                if (fbVar3 == null) {
                                                                                    fbVar3 = fb.a;
                                                                                }
                                                                                j = fbVar3.c;
                                                                                if (j >= 1) {
                                                                                    i9 = nqVarC.b;
                                                                                    if ((i9 & 2) != 0) {
                                                                                        gl glVarY3 = gl.y(de.d(nqVarC.d).c(new as() { // from class: com.google.android.libraries.navigation.internal.co.e
                                                                                            @Override // com.google.android.libraries.navigation.internal.yx.as
                                                                                            public final boolean a(Object obj) {
                                                                                                return ((Long) obj).longValue() > 0;
                                                                                            }
                                                                                        }).f());
                                                                                        Long lValueOf3 = Long.valueOf(j);
                                                                                        anVarI = an.i((Long) glVarY3.floor(lValueOf3));
                                                                                        l = (Long) anVarI.e(lValueOf3);
                                                                                        jLongValue = l.longValue();
                                                                                        listK = fVar.k(ab.bU, new ArrayList());
                                                                                        if (listK.size() < nqVarC.c) {
                                                                                            if (anVarI.g()) {
                                                                                                i10 = com.google.android.libraries.navigation.internal.qr.e.d;
                                                                                            } else {
                                                                                                i10 = com.google.android.libraries.navigation.internal.qr.e.f;
                                                                                            }
                                                                                            string = context5.getString(i10, l);
                                                                                            epochMilli = aVar5.f().toEpochMilli();
                                                                                            j2 = (-86400000) + epochMilli;
                                                                                            if (!de.d(listK).i(new as() { // from class: com.google.android.libraries.navigation.internal.co.f
                                                                                                @Override // com.google.android.libraries.navigation.internal.yx.as
                                                                                                public final boolean a(Object obj) {
                                                                                                    return Long.parseLong((String) obj) > j2;
                                                                                                }
                                                                                            })) {
                                                                                                listK.add(Long.toString(epochMilli));
                                                                                                fVar.u(ab.bU, listK);
                                                                                            }
                                                                                        } else if (anVarI.g()) {
                                                                                            string = context5.getString(com.google.android.libraries.navigation.internal.qr.e.e, l);
                                                                                        } else {
                                                                                            string = Long.toString(jLongValue);
                                                                                        }
                                                                                        aVar4.f = string;
                                                                                        if (z6) {
                                                                                            str = nqVarC.f;
                                                                                        } else {
                                                                                            str = nqVarC.e;
                                                                                        }
                                                                                        aVar4.e = str;
                                                                                    }
                                                                                }
                                                                            }
                                                                        } else {
                                                                            aVar4.a(true);
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                dVar2 = fhVar5.d;
                                                                if (dVar2 == null) {
                                                                    dVar2 = com.google.android.libraries.navigation.internal.aap.d.a;
                                                                }
                                                                if (dVar2.c != 0) {
                                                                    dVar3 = fhVar5.d;
                                                                    if (dVar3 == null) {
                                                                        dVar3 = com.google.android.libraries.navigation.internal.aap.d.a;
                                                                    }
                                                                    i11 = dVar3.c;
                                                                    if (i11 > 0) {
                                                                        string2 = context5.getString(com.google.android.libraries.navigation.internal.qr.e.g, u.e(context5.getResources(), i11, 2).toString());
                                                                    } else {
                                                                        string2 = null;
                                                                    }
                                                                    aVar4.f = string2;
                                                                    aVar4.a(true);
                                                                } else {
                                                                    if (elVar4.c == 22) {
                                                                        fhVar2 = (fh) elVar4.d;
                                                                    } else {
                                                                        fhVar2 = fh.a;
                                                                    }
                                                                    fgVar2 = fhVar2.k;
                                                                    if (fgVar2 == null) {
                                                                        fgVar2 = fg.a;
                                                                    }
                                                                    if (com.google.android.libraries.navigation.internal.bq.e.b(fgVar2, axVar5).c) {
                                                                        aVar4.a(true);
                                                                    } else {
                                                                        fbVar = fhVar2.m;
                                                                        if (fbVar == null) {
                                                                            fbVar = fb.a;
                                                                        }
                                                                        if (fbVar.c <= 0) {
                                                                            aVar4.a(true);
                                                                        } else {
                                                                            fbVar2 = fhVar2.m;
                                                                            if (fbVar2 == null) {
                                                                                fbVar2 = fb.a;
                                                                            }
                                                                            if (fbVar2.f) {
                                                                                aVar5 = dVar7.d;
                                                                                fVar = dVar7.f;
                                                                                com.google.android.libraries.navigation.internal.dx.i iVar9 = dVar7.k;
                                                                                aVar4.a(true);
                                                                                if (fVar != null) {
                                                                                    if (elVar4.c == 22) {
                                                                                        fhVar3 = (fh) elVar4.d;
                                                                                    } else {
                                                                                        fhVar3 = fh.a;
                                                                                    }
                                                                                    fbVar3 = fhVar3.m;
                                                                                    if (fbVar3 == null) {
                                                                                        fbVar3 = fb.a;
                                                                                    }
                                                                                    j = fbVar3.c;
                                                                                    if (j >= 1) {
                                                                                        i9 = nqVarC.b;
                                                                                        if ((i9 & 2) != 0) {
                                                                                            gl glVarY4 = gl.y(de.d(nqVarC.d).c(new as() { // from class: com.google.android.libraries.navigation.internal.co.e
                                                                                                @Override // com.google.android.libraries.navigation.internal.yx.as
                                                                                                public final boolean a(Object obj) {
                                                                                                    return ((Long) obj).longValue() > 0;
                                                                                                }
                                                                                            }).f());
                                                                                            Long lValueOf4 = Long.valueOf(j);
                                                                                            anVarI = an.i((Long) glVarY4.floor(lValueOf4));
                                                                                            l = (Long) anVarI.e(lValueOf4);
                                                                                            jLongValue = l.longValue();
                                                                                            listK = fVar.k(ab.bU, new ArrayList());
                                                                                            if (listK.size() < nqVarC.c) {
                                                                                                if (anVarI.g()) {
                                                                                                    i10 = com.google.android.libraries.navigation.internal.qr.e.d;
                                                                                                } else {
                                                                                                    i10 = com.google.android.libraries.navigation.internal.qr.e.f;
                                                                                                }
                                                                                                string = context5.getString(i10, l);
                                                                                                epochMilli = aVar5.f().toEpochMilli();
                                                                                                j2 = (-86400000) + epochMilli;
                                                                                                if (!de.d(listK).i(new as() { // from class: com.google.android.libraries.navigation.internal.co.f
                                                                                                    @Override // com.google.android.libraries.navigation.internal.yx.as
                                                                                                    public final boolean a(Object obj) {
                                                                                                        return Long.parseLong((String) obj) > j2;
                                                                                                    }
                                                                                                })) {
                                                                                                    listK.add(Long.toString(epochMilli));
                                                                                                    fVar.u(ab.bU, listK);
                                                                                                }
                                                                                            } else if (anVarI.g()) {
                                                                                                string = context5.getString(com.google.android.libraries.navigation.internal.qr.e.e, l);
                                                                                            } else {
                                                                                                string = Long.toString(jLongValue);
                                                                                            }
                                                                                            aVar4.f = string;
                                                                                            if (z6) {
                                                                                                str = nqVarC.f;
                                                                                            } else {
                                                                                                str = nqVarC.e;
                                                                                            }
                                                                                            aVar4.e = str;
                                                                                        }
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                aVar4.a(true);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            cdoB = Cdo.b(elVar4.u);
                                                            if (cdoB == null) {
                                                                cdoB = Cdo.INCIDENT_OTHER;
                                                            }
                                                            if (cdoB != Cdo.INCIDENT_ROAD_CLOSED) {
                                                                if (elVar4.c == 22) {
                                                                    fhVar4 = (fh) elVar4.d;
                                                                } else {
                                                                    fhVar4 = fh.a;
                                                                }
                                                                fgVar3 = fhVar4.k;
                                                                if (fgVar3 == null) {
                                                                    fgVar3 = fg.a;
                                                                }
                                                                if (ff.a(fgVar3.c) == 2) {
                                                                    aVar6 = com.google.android.libraries.navigation.internal.afe.f.b;
                                                                }
                                                                Objects.requireNonNull(aVar6);
                                                                aVar4.j = aVar6;
                                                                if (aVar4.i == 7) {
                                                                }
                                                                throw new IllegalStateException();
                                                            }
                                                            EnumMap enumMap2 = com.google.android.libraries.navigation.internal.tt.e.b;
                                                            cdoB2 = Cdo.b(elVar4.u);
                                                            if (cdoB2 == null) {
                                                                cdoB2 = Cdo.INCIDENT_OTHER;
                                                            }
                                                            aVar6 = (com.google.android.libraries.navigation.internal.afd.a) enumMap2.getOrDefault(cdoB2, com.google.android.libraries.navigation.internal.afe.o.g);
                                                            Objects.requireNonNull(aVar6);
                                                            aVar4.j = aVar6;
                                                            if (aVar4.i == 7) {
                                                            }
                                                            throw new IllegalStateException();
                                                        }
                                                    } else {
                                                        eqVar3 = eqVar3;
                                                        bVar2 = null;
                                                    }
                                                }
                                            }
                                            bVar2 = null;
                                        }
                                        if (bVar2 != null) {
                                            aj ajVar5 = hVar.j;
                                            long j3 = hVar.a;
                                            int i22 = i17 + 1;
                                            boolean z7 = hVar.l;
                                            final boolean z8 = hVar.m;
                                            boolean z9 = hVar.p;
                                            com.google.android.libraries.navigation.internal.yx.aa value = new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.ck.by
                                                @Override // com.google.android.libraries.navigation.internal.yx.aa
                                                public final Object ak(Object obj) {
                                                    com.google.android.libraries.navigation.internal.cq.y yVar = (com.google.android.libraries.navigation.internal.cq.y) obj;
                                                    com.google.android.libraries.navigation.internal.oe.ad adVar = yVar.b;
                                                    com.google.android.libraries.navigation.internal.pi.s sVar2 = yVar.c;
                                                    com.google.android.libraries.navigation.internal.bp.bg bgVar = yVar.d;
                                                    if (adVar == null || sVar2 == null || bgVar == null) {
                                                        return null;
                                                    }
                                                    return new bz(((com.google.android.libraries.navigation.internal.co.b) bVar2).d, adVar, z8, sVar2, bgVar);
                                                }
                                            };
                                            ai aiVar = z7 ? ai.CAR : ai.PHONE;
                                            String str5 = bVar2.e;
                                            boolean z10 = bVar2.f != null;
                                            int i23 = bVar2.a;
                                            com.google.android.libraries.navigation.internal.cq.p pVarA = com.google.android.libraries.navigation.internal.cq.aa.a();
                                            pVarA.i(i23);
                                            pVarA.g(bVar2.b);
                                            pVarA.e(String.format(Locale.US, "jamcident_%d_%d", Long.valueOf(j3), Integer.valueOf(i17)));
                                            pVarA.d(com.google.android.libraries.navigation.internal.cq.k.UNKNOWN);
                                            pVarA.f(ex.LEGEND_STYLE_UNDEFINED);
                                            com.google.android.libraries.navigation.internal.cq.r rVarA = new com.google.android.libraries.navigation.internal.cq.b().a(ajVar5.b());
                                            com.google.android.libraries.navigation.internal.oo.f fVarI = ajVar5.i();
                                            Objects.requireNonNull(fVarI);
                                            com.google.android.libraries.navigation.internal.cq.b bVar3 = (com.google.android.libraries.navigation.internal.cq.b) rVarA;
                                            bVar3.a = fVarI;
                                            com.google.android.libraries.navigation.internal.ol.aq aqVarC = ajVar5.c(bVar2.c, aiVar, 1);
                                            Objects.requireNonNull(aqVarC);
                                            bVar3.b = aqVarC;
                                            com.google.android.libraries.navigation.internal.oo.f fVarH = ajVar5.h(bVar2.c, aiVar, 1);
                                            Objects.requireNonNull(fVarH);
                                            bVar3.c = fVarH;
                                            bVar3.d = z10 ? ajVar5.d() : null;
                                            bVar3.e = z10 ? ajVar5.j() : null;
                                            bVar3.f = str5 != null ? ajVar5.e(str5, aiVar) : null;
                                            bVar3.g = str5 != null ? ajVar5.k(str5, aiVar) : null;
                                            bVar3.h = z10 ? (bVar2.h && str5 == null) ? ajVar5.f(aiVar) : ajVar5.g(aiVar) : null;
                                            bVar3.i = z10 ? (bVar2.h && str5 == null) ? ajVar5.l(aiVar) : ajVar5.m(aiVar) : null;
                                            com.google.android.libraries.navigation.internal.cq.w wVarB = rVarA.b();
                                            if (!((wVarB.f != null) ^ (wVarB.g != null))) {
                                                if (!((wVarB.h != null) ^ (wVarB.i != null))) {
                                                    if (!((wVarB.j != null) ^ (wVarB.k != null))) {
                                                        com.google.android.libraries.navigation.internal.cq.a aVar9 = (com.google.android.libraries.navigation.internal.cq.a) pVarA;
                                                        aVar9.f = wVarB;
                                                        aVar9.i |= 1024;
                                                        pVarA.j(bVar2.f);
                                                        pVarA.c(bVar2.g);
                                                        pVarA.k(t.JAMCIDENTS);
                                                        pVarA.l(bVar2.i);
                                                        aVar9.h = bVar2.d.e;
                                                        aVar9.i |= 131072;
                                                        com.google.android.libraries.navigation.internal.ado.i iVar10 = (com.google.android.libraries.navigation.internal.ado.i) com.google.android.libraries.navigation.internal.ado.j.a.q();
                                                        com.google.android.libraries.navigation.internal.adq.ae aeVar = (com.google.android.libraries.navigation.internal.adq.ae) ah.a.q();
                                                        com.google.android.libraries.navigation.internal.zq.i iVar11 = (com.google.android.libraries.navigation.internal.zq.i) com.google.android.libraries.navigation.internal.zq.l.a.q();
                                                        int i24 = z9 ? com.google.android.libraries.navigation.internal.zq.k.c : com.google.android.libraries.navigation.internal.zq.k.b;
                                                        if (!iVar11.b.H()) {
                                                            iVar11.v();
                                                        }
                                                        com.google.android.libraries.navigation.internal.zq.l lVar = (com.google.android.libraries.navigation.internal.zq.l) iVar11.b;
                                                        int i25 = i24 - 1;
                                                        if (i24 == 0) {
                                                            throw null;
                                                        }
                                                        lVar.c = i25;
                                                        lVar.b |= 1;
                                                        if (!aeVar.b.H()) {
                                                            aeVar.v();
                                                        }
                                                        ah ahVar = (ah) aeVar.b;
                                                        com.google.android.libraries.navigation.internal.zq.l lVar2 = (com.google.android.libraries.navigation.internal.zq.l) iVar11.t();
                                                        lVar2.getClass();
                                                        ahVar.g = lVar2;
                                                        ahVar.b |= 524288;
                                                        if (!iVar10.b.H()) {
                                                            iVar10.v();
                                                        }
                                                        com.google.android.libraries.navigation.internal.ado.j jVar = (com.google.android.libraries.navigation.internal.ado.j) iVar10.b;
                                                        ah ahVar2 = (ah) aeVar.t();
                                                        ahVar2.getClass();
                                                        jVar.c = ahVar2;
                                                        jVar.b |= 1;
                                                        pVarA.h((com.google.android.libraries.navigation.internal.ado.j) iVar10.t());
                                                        Intrinsics.checkNotNullParameter(value, "value");
                                                        eqVar3 = eqVar3;
                                                        eqVar3.h(pVarA.a(new com.google.android.libraries.navigation.internal.cq.o(value)).b());
                                                        i17 = i22;
                                                    }
                                                }
                                            }
                                            throw new IllegalArgumentException("Optional styles must have both the V2 and V3 styles provided");
                                        }
                                        eqVar3 = eqVar3;
                                        i16++;
                                        zVar2 = zVar2;
                                        evVar8 = evVar9;
                                        ajVar3 = ajVar4;
                                        size2 = i18;
                                        i14 = i19;
                                        arrayList2 = arrayList3;
                                    }
                                }
                            }
                            throw new IllegalStateException();
                        }
                        ajVar3 = ajVar3;
                        i2 = i14;
                        zVar = zVar2;
                        arrayList = arrayList2;
                        kVar = null;
                        evVarG = eqVar3.g();
                    }
                    evVarC = zVar.c();
                    i3 = ((lv) evVarC).c;
                    i4 = 0;
                    z = false;
                    while (i4 < i3) {
                        sVar = (s) evVarC.get(i4);
                        eqVar = new eq();
                        if (sVar.a() == 0) {
                            eqVar.j(evVarG);
                        }
                        com.google.android.libraries.navigation.internal.cq.l lVarC = com.google.android.libraries.navigation.internal.cq.m.c();
                        lVarC.c(sVar.a());
                        lVarC.b(eqVar.g());
                        arrayList.add(lVarC.a());
                        i4++;
                        z = true;
                    }
                    ArrayList arrayList4 = arrayList;
                    if (!evVarG.isEmpty() || z) {
                        i5 = 0;
                    } else {
                        com.google.android.libraries.navigation.internal.cq.l lVarC2 = com.google.android.libraries.navigation.internal.cq.m.c();
                        i5 = 0;
                        lVarC2.c(0);
                        lVarC2.b(evVarG);
                        arrayList4.add(lVarC2.a());
                    }
                    Collections.sort(arrayList4, Comparator.comparingInt(new ToIntFunction() { // from class: com.google.android.libraries.navigation.internal.cp.k
                        @Override // java.util.function.ToIntFunction
                        public final int applyAsInt(Object obj) {
                            return ((com.google.android.libraries.navigation.internal.cq.m) obj).a();
                        }
                    }));
                    gVar = new com.google.android.libraries.navigation.internal.cq.g();
                    gVar.a = zVar.a();
                    gVar.c = (byte) 1;
                    iVar = new com.google.android.libraries.navigation.internal.cq.i();
                    iVar.a = 3;
                    ev evVarO = ev.o(arrayList4);
                    Objects.requireNonNull(evVarO);
                    iVar.c = evVarO;
                    qVarB = zVar.b();
                    if (qVarB == null) {
                        kVarC = kVar;
                    } else {
                        fwVar = new fw();
                        evVar2 = ((com.google.android.libraries.navigation.internal.cn.d) qVarB).a;
                        size = evVar2.size();
                        for (i6 = i5; i6 < size; i6++) {
                            fwVar.k(com.google.android.libraries.navigation.internal.br.l.c((el) evVar2.get(i6)));
                        }
                        kVarC = com.google.android.libraries.navigation.internal.ot.k.c(com.google.android.libraries.navigation.internal.cl.u.a(fwVar.i()));
                    }
                    iVar.b = kVarC;
                    evVar3 = iVar.c;
                    if (evVar3 != null) {
                        throw new IllegalStateException();
                    }
                    ev evVarQ = ev.q(new com.google.android.libraries.navigation.internal.cq.j(iVar.a, iVar.b, evVar3));
                    Objects.requireNonNull(evVarQ);
                    gVar.b = evVarQ;
                    if (gVar.c == 1 || (evVar4 = gVar.b) == null) {
                        throw new IllegalStateException();
                    }
                    com.google.android.libraries.navigation.internal.cq.h hVar2 = new com.google.android.libraries.navigation.internal.cq.h(gVar.a, evVar4);
                    eq eqVar4 = eqVar2;
                    eqVar4.h(hVar2);
                    i14 = i2 + 1;
                    eqVar2 = eqVar4;
                    evVar6 = evVar;
                    i13 = i13;
                    vVar = vVar;
                    ajVar3 = ajVar3;
                    oVar = this;
                }
                i2 = i14;
                zVar = zVar2;
                arrayList = arrayList2;
                kVar = null;
                evVarG = lv.a;
                evVarC = zVar.c();
                i3 = ((lv) evVarC).c;
                i4 = 0;
                z = false;
                while (i4 < i3) {
                    sVar = (s) evVarC.get(i4);
                    eqVar = new eq();
                    if (sVar.a() == 0) {
                        eqVar.j(evVarG);
                    }
                    com.google.android.libraries.navigation.internal.cq.l lVarC3 = com.google.android.libraries.navigation.internal.cq.m.c();
                    lVarC3.c(sVar.a());
                    lVarC3.b(eqVar.g());
                    arrayList.add(lVarC3.a());
                    i4++;
                    z = true;
                }
                ArrayList arrayList5 = arrayList;
                if (evVarG.isEmpty()) {
                    i5 = 0;
                } else {
                    i5 = 0;
                }
                Collections.sort(arrayList5, Comparator.comparingInt(new ToIntFunction() { // from class: com.google.android.libraries.navigation.internal.cp.k
                    @Override // java.util.function.ToIntFunction
                    public final int applyAsInt(Object obj) {
                        return ((com.google.android.libraries.navigation.internal.cq.m) obj).a();
                    }
                }));
                gVar = new com.google.android.libraries.navigation.internal.cq.g();
                gVar.a = zVar.a();
                gVar.c = (byte) 1;
                iVar = new com.google.android.libraries.navigation.internal.cq.i();
                iVar.a = 3;
                ev evVarO2 = ev.o(arrayList5);
                Objects.requireNonNull(evVarO2);
                iVar.c = evVarO2;
                qVarB = zVar.b();
                if (qVarB == null) {
                    kVarC = kVar;
                } else {
                    fwVar = new fw();
                    evVar2 = ((com.google.android.libraries.navigation.internal.cn.d) qVarB).a;
                    size = evVar2.size();
                    while (i6 < size) {
                        fwVar.k(com.google.android.libraries.navigation.internal.br.l.c((el) evVar2.get(i6)));
                    }
                    kVarC = com.google.android.libraries.navigation.internal.ot.k.c(com.google.android.libraries.navigation.internal.cl.u.a(fwVar.i()));
                }
                iVar.b = kVarC;
                evVar3 = iVar.c;
                if (evVar3 != null) {
                    throw new IllegalStateException();
                }
                ev evVarQ2 = ev.q(new com.google.android.libraries.navigation.internal.cq.j(iVar.a, iVar.b, evVar3));
                Objects.requireNonNull(evVarQ2);
                gVar.b = evVarQ2;
                if (gVar.c == 1) {
                }
                throw new IllegalStateException();
            }
        }
        v vVar2 = vVar;
        ev evVarG2 = eqVar2.g();
        ev evVar10 = this.l;
        if (evVar10 == null) {
            vVar2.k(evVarG2);
            this.l = evVarG2;
        } else if (j((ev) evVar10.stream().flatMap(new Function() { // from class: com.google.android.libraries.navigation.internal.cp.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ag) obj).b().stream();
            }
        }).flatMap(new Function() { // from class: com.google.android.libraries.navigation.internal.cp.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((af) obj).b().stream();
            }
        }).flatMap(new Function() { // from class: com.google.android.libraries.navigation.internal.cp.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((com.google.android.libraries.navigation.internal.cq.m) obj).b().stream();
            }
        }).collect(br.a), (ev) evVarG2.stream().flatMap(new Function() { // from class: com.google.android.libraries.navigation.internal.cp.c
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ag) obj).b().stream();
            }
        }).flatMap(new Function() { // from class: com.google.android.libraries.navigation.internal.cp.d
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((af) obj).b().stream();
            }
        }).flatMap(new Function() { // from class: com.google.android.libraries.navigation.internal.cp.e
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((com.google.android.libraries.navigation.internal.cq.m) obj).b().stream();
            }
        }).collect(br.a))) {
            vVar2.k(evVarG2);
            this.l = evVarG2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean j(ev evVar, ev evVar2) {
        if (evVar.size() != evVar2.size()) {
            return true;
        }
        for (int i = 0; i < evVar.size(); i++) {
            com.google.android.libraries.navigation.internal.cq.aa aaVar = (com.google.android.libraries.navigation.internal.cq.aa) evVar.get(i);
            com.google.android.libraries.navigation.internal.cq.aa other = (com.google.android.libraries.navigation.internal.cq.aa) evVar2.get(i);
            Intrinsics.checkNotNullParameter(other, "other");
            if (aaVar.b != other.b || aaVar.c != other.c || !Intrinsics.areEqual(aaVar.d, other.d) || aaVar.g != other.g || aaVar.h != other.h || aaVar.i != other.i || aaVar.j != other.j || aaVar.k != other.k || !Intrinsics.areEqual(aaVar.l, other.l) || aaVar.m != other.m || !Intrinsics.areEqual(aaVar.o, other.o) || !Intrinsics.areEqual(aaVar.p, other.p) || !Intrinsics.areEqual(aaVar.q, other.q) || !Intrinsics.areEqual(aaVar.t, other.t) || !Intrinsics.areEqual(aaVar.r, other.r) || aaVar.e != other.e || !Intrinsics.areEqual(aaVar.f, other.f) || !Intrinsics.areEqual(aaVar.s, other.s)) {
                return true;
            }
        }
        return false;
    }

    private static boolean k(com.google.android.libraries.navigation.internal.cn.n nVar) {
        com.google.android.libraries.navigation.internal.cn.b bVar = (com.google.android.libraries.navigation.internal.cn.b) nVar;
        return bVar.c && !bVar.b;
    }

    private static Integer[] l(int i) {
        Integer numValueOf;
        double d = ((double) i) * 0.001d * 3.2808399200439453d;
        int iFloor = (int) Math.floor(d);
        int iRound = (int) Math.round((d - ((double) iFloor)) * 12.0d);
        if (iRound == 12) {
            numValueOf = Integer.valueOf(iFloor + 1);
            iRound = 0;
        } else {
            numValueOf = Integer.valueOf(iFloor);
        }
        return new Integer[]{numValueOf, Integer.valueOf(iRound)};
    }

    @Override // com.google.android.libraries.navigation.internal.cn.aa
    public final void a(v vVar) {
        this.a = vVar;
    }

    @Override // com.google.android.libraries.navigation.internal.cn.aa
    public final void b(x xVar) {
        com.google.android.libraries.navigation.internal.cn.j jVar = (com.google.android.libraries.navigation.internal.cn.j) xVar;
        this.i = jVar.b;
        this.j = jVar.c;
        this.k = jVar.a;
        i(((com.google.android.libraries.navigation.internal.cn.b) this.e).e);
        h();
    }

    @Override // com.google.android.libraries.navigation.internal.cn.aa
    public final boolean c() {
        return ((Boolean) this.g.b(new b()).e(false)).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.cn.aa
    public final boolean d() {
        return ((Boolean) this.g.b(new b()).e(false)).booleanValue();
    }

    @Override // com.google.android.libraries.navigation.internal.cn.aa
    public final void e(int i) {
        if (k(this.e)) {
            if (i - this.f376n > 100) {
                this.f376n = i;
            }
            i(i);
            h();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pc.e
    public final void f() {
    }
}

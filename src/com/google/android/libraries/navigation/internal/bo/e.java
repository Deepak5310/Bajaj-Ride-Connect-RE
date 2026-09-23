package com.google.android.libraries.navigation.internal.bo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import com.google.android.libraries.navigation.environment.ct;
import com.google.android.libraries.navigation.internal.adg.ef;
import com.google.android.libraries.navigation.internal.adg.jr;
import com.google.android.libraries.navigation.internal.afl.bn;
import com.google.android.libraries.navigation.internal.afl.bo;
import com.google.android.libraries.navigation.internal.afl.qj;
import com.google.android.libraries.navigation.internal.bp.ay;
import com.google.android.libraries.navigation.internal.bp.bf;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bj;
import com.google.android.libraries.navigation.internal.bp.bk;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.bp.bw;
import com.google.android.libraries.navigation.internal.cl.aq;
import com.google.android.libraries.navigation.internal.cl.at;
import com.google.android.libraries.navigation.internal.cl.au;
import com.google.android.libraries.navigation.internal.cl.av;
import com.google.android.libraries.navigation.internal.cl.az;
import com.google.android.libraries.navigation.internal.cl.ba;
import com.google.android.libraries.navigation.internal.cl.bc;
import com.google.android.libraries.navigation.internal.cl.bd;
import com.google.android.libraries.navigation.internal.cl.be;
import com.google.android.libraries.navigation.internal.po.fk;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.yz.ma;
import com.google.android.libraries.navigation.internal.yz.nn;
import com.google.android.libraries.navigation.internal.yz.no;
import j$.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e {
    private final boolean A;
    private final ev B;
    private final Rect C;
    private final Set D;
    private final Context E;
    private bc F;
    private final com.google.android.libraries.navigation.internal.cr.f G;
    public be a;
    public boolean b;
    public final t c;
    public final Object d;
    public final k e;
    public volatile boolean f;
    public av g;
    private final ev h;
    private final ba i;
    private fd j = ma.b;
    private final Map k = new HashMap();
    private final Map l = new HashMap();
    private final ev m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ev f349n;
    private bd o;
    private final boolean p;
    private boolean q;
    private int r;
    private final boolean s;
    private final boolean t;
    private final boolean u;
    private final com.google.android.libraries.navigation.internal.oa.e v;
    private final Resources w;
    private final com.google.android.libraries.navigation.internal.pi.s x;
    private final com.google.android.libraries.navigation.internal.qk.w y;
    private final boolean z;

    /* JADX WARN: Code duplicated, block: B:15:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:17:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:18:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:20:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:24:0x010d  */
    /* JADX WARN: Code duplicated, block: B:52:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:66:0x020c  */
    /* JADX WARN: Code duplicated, block: B:88:0x0115 A[SYNTHETIC] */
    public e(com.google.android.libraries.navigation.internal.pi.s sVar, ev evVar, Resources resources, final bq bqVar, com.google.android.libraries.navigation.internal.oa.e eVar, t tVar, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, Rect rect, com.google.android.libraries.navigation.internal.up.g gVar, ba baVar, boolean z6, be beVar, boolean z7, ct ctVar, com.google.android.libraries.navigation.internal.sg.a aVar, com.google.android.libraries.navigation.internal.fz.d dVar, Context context, final com.google.android.libraries.navigation.internal.iv.f fVar, com.google.android.libraries.navigation.internal.op.i iVar, com.google.android.libraries.navigation.internal.qk.w wVar, com.google.android.libraries.navigation.internal.cr.f fVar2, boolean z8, boolean z9, int i) {
        ay ayVar;
        k kVar;
        int i2;
        eq eqVar;
        bw bwVarC;
        bc bcVar;
        ev evVar2 = evVar;
        int i3 = ev.d;
        this.f349n = lv.a;
        this.o = bd.SHOW_ALTERNATES_ONLY;
        this.D = new HashSet();
        this.d = new Object();
        this.x = sVar;
        this.w = resources;
        this.s = z;
        this.q = z2;
        this.t = z3;
        this.p = z4;
        this.v = eVar;
        this.i = baVar;
        this.B = evVar2;
        this.C = rect;
        this.u = z6;
        this.a = beVar;
        this.c = tVar;
        this.y = wVar;
        this.G = fVar2;
        this.z = z8;
        this.A = false;
        eq eqVar2 = new eq();
        int i4 = 0;
        ay ayVar2 = null;
        while (i4 < evVar.size()) {
            ay ayVar3 = (ay) evVar2.get(i4);
            bg bgVarA = ayVar3.a();
            if (Objects.equals(bgVarA.j, com.google.android.libraries.navigation.internal.ady.al.TRANSIT)) {
                bo boVar = dVar.D().h;
                int iA = bn.a((boVar == null ? bo.a : boVar).b);
                if ((iA == 0 ? bn.a : iA) != bn.c) {
                    if (bgVarA.j.equals(com.google.android.libraries.navigation.internal.ady.al.BIKESHARING)) {
                        bcVar = new bc(bgVarA, bgVarA.m);
                    } else {
                        com.google.android.libraries.navigation.internal.oe.an anVarE = ayVar3.b().e();
                        bcVar = new bc(bgVarA, (anVarE == null ? bgVarA.y() : anVarE).c());
                    }
                    eqVar2.h(new d(bcVar, i4));
                    this.k.put(bcVar, Integer.valueOf((int) bcVar.a.H().toSeconds()));
                    this.l.put(bcVar, Integer.valueOf(bcVar.a.i()));
                    if (ayVar3.d()) {
                        this.D.add(bcVar);
                        this.F = bcVar;
                        ayVar2 = ayVar3;
                    }
                }
            } else {
                if (bgVarA.j.equals(com.google.android.libraries.navigation.internal.ady.al.BIKESHARING)) {
                    bcVar = new bc(bgVarA, bgVarA.m);
                } else {
                    com.google.android.libraries.navigation.internal.oe.an anVarE2 = ayVar3.b().e();
                    bcVar = new bc(bgVarA, (anVarE2 == null ? bgVarA.y() : anVarE2).c());
                }
                eqVar2.h(new d(bcVar, i4));
                this.k.put(bcVar, Integer.valueOf((int) bcVar.a.H().toSeconds()));
                this.l.put(bcVar, Integer.valueOf(bcVar.a.i()));
                if (ayVar3.d()) {
                    this.D.add(bcVar);
                    this.F = bcVar;
                    ayVar2 = ayVar3;
                }
            }
            i4++;
            evVar2 = evVar;
        }
        this.h = eqVar2.g();
        int i5 = bqVar != null ? bqVar.i : -1;
        if (ayVar2 == null || !z5) {
            this.m = lv.a;
        } else {
            if (!au.c.contains(ayVar2.a().j) || i5 < 0) {
                this.m = lv.a;
            } else {
                bg bgVarA2 = ayVar2.a();
                bj bjVarB = ayVar2.b();
                eq eqVar3 = new eq();
                while (true) {
                    if (i5 >= bgVarA2.l()) {
                        i2 = i5;
                        eqVar = eqVar3;
                        bwVarC = null;
                        break;
                    }
                    bq bqVarR = bgVarA2.r(i5);
                    i5++;
                    if (au.c(bqVarR)) {
                        g(bgVarA2.Y, aVar, z);
                        eqVar = eqVar3;
                        eqVar.h(new au(bgVarA2, bjVarB, bqVarR, rect, com.google.android.libraries.navigation.internal.up.a.n(gVar, bqVarR), true, dVar, iVar));
                        bwVarC = bqVarR.c();
                        i2 = i5;
                        break;
                    }
                }
                if (bwVarC != null && bwVarC.e && i2 < bgVarA2.l()) {
                    bq bqVarR2 = bgVarA2.r(i2);
                    if (au.c(bqVarR2)) {
                        g(bgVarA2.Y, aVar, z);
                        eqVar.h(new au(bgVarA2, bjVarB, bqVarR2, rect, com.google.android.libraries.navigation.internal.up.a.n(gVar, bqVarR2), false, dVar, iVar));
                    }
                }
                this.m = eqVar.g();
            }
        }
        if (!z7 || bqVar == null) {
            this.e = null;
        } else {
            qj qjVarW = dVar.W();
            final boolean z10 = qjVarW != null ? qjVarW.J : false;
            com.google.android.libraries.navigation.internal.po.bw bwVar = ((fk) eVar).J;
            int i6 = k.e;
            final ArrayList arrayList = new ArrayList();
            int size = evVar.size();
            int i7 = 0;
            do {
                if (i7 >= size) {
                    ayVar = null;
                    break;
                } else {
                    ayVar = (ay) evVar.get(i7);
                    i7++;
                }
            } while (!ayVar.d());
            if (ayVar == null) {
                kVar = null;
            } else {
                final bj bjVarB2 = ayVar.b();
                UByte$$ExternalSyntheticBackport0.m(Optional.empty(), new Consumer() { // from class: com.google.android.libraries.navigation.internal.bo.h
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        int i8 = k.e;
                        throw null;
                    }
                }, new Runnable() { // from class: com.google.android.libraries.navigation.internal.bo.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        int i8 = k.e;
                        boolean z11 = z10;
                        bq bqVar2 = bqVar;
                        if (z11 && bqVar2.M == null) {
                            return;
                        }
                        bj bjVar = bjVarB2;
                        int iA2 = bjVar.a(bqVar2);
                        com.google.android.libraries.navigation.internal.oe.ad adVar = null;
                        if (iA2 != -1) {
                            com.google.android.libraries.navigation.internal.oe.x xVarL = bjVar.d().l(iA2);
                            com.google.android.libraries.navigation.internal.oe.d dVar2 = new com.google.android.libraries.navigation.internal.oe.d(com.google.android.libraries.navigation.internal.oe.ai.h(xVarL, (int) (xVarL.e() * 18.0d)));
                            int iE = bjVar.d().e();
                            long[] jArr = new long[iE];
                            for (int i9 = 0; i9 < iE; i9++) {
                                jArr[i9] = i9;
                            }
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = new ArrayList();
                            dVar2.b(bjVar.d(), jArr, arrayList2, arrayList3);
                            if (!arrayList2.isEmpty()) {
                                if (arrayList2.size() == 1) {
                                    adVar = (com.google.android.libraries.navigation.internal.oe.ad) arrayList2.get(0);
                                } else {
                                    loop1: for (int i10 = 0; i10 < arrayList3.size(); i10++) {
                                        for (long j : (long[]) arrayList3.get(i10)) {
                                            if (j == iA2) {
                                                adVar = (com.google.android.libraries.navigation.internal.oe.ad) arrayList2.get(i10);
                                                break loop1;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (adVar != null) {
                            arrayList.add(adVar);
                        }
                    }
                });
                if (arrayList.isEmpty()) {
                    kVar = null;
                } else {
                    kVar = new k(bwVar, arrayList, k.a(bwVar, -1, true != z10 ? "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAIAAAACAAQMAAAD58POIAAAAA3NCSVQICAjb4U/gAAAABlBMVEUAAAAAAAClZ7nPAAAAAXRSTlMAQObYZgAAAAlwSFlzAAAOxAAADsQBlSsOGwAAACVJREFUSIljYAAD+////zAgg1GBUYFRgVGBUYFRgVGBUQFaCQAAAXeckHM1uEMAAAAASUVORK5CYII" : "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAIAAAACAAQMAAAD58POIAAAABlBMVEUAAAAAAAClZ7nPAAAAAXRSTlMAQObYZgAAACNJREFUSMdjgAD7////QFijAqMCowKjAmQIjIJRMApGASkAAH0w0Xp6ggEqAAAAAElFTkSuQmCC", "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAIAAAACAAQMAAAD58POIAAAAA3NCSVQICAjb4U/gAAAABlBMVEUAAAAAAAClZ7nPAAAAAXRSTlMAQObYZgAAAAlwSFlzAAAOxAAADsQBlSsOGwAAAJZJREFUSInt0LERwyAMhWH5KCg9AqMwmhmNUTyCSwqflSD7fNIjlzQpXOh1fA0/EMky8056Dg4ODo+Chfn4DvyePocOFc5aLig3TAh0gr3V3iugU3OHpiAhzB02hFVBhPThLWdqQSA9/vljn369GUg2VFItRFsuUA0EGyqpZDfCAbDsALkBpAE2gHkFiBUgDFAAJvL9ay/602YGRMNLmgAAAABJRU5ErkJggg", z10), k.a(bwVar, Color.argb(255, 0, 0, 128), true != z10 ? "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAIAAAACAAQMAAAD58POIAAAAA3NCSVQICAjb4U/gAAAABlBMVEUAAAAAAAClZ7nPAAAAAXRSTlMAQObYZgAAAAlwSFlzAAAOxAAADsQBlSsOGwAAACZJREFUSIljYAAB/gMMDMwfGBBgVGBUYFRgVGBUYFRgVGBUgGYCAPT14QGPN/OFAAAAAElFTkSuQmCC" : "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAIAAAACAAQMAAAD58POIAAAABlBMVEUAAAAAAAClZ7nPAAAAAXRSTlMAQObYZgAAACVJREFUSMdjAAP+AwwMzB/AzFGBUYFRgVEBcgRGwSgYBaOABAAAhaRyQ5iphr0AAAAASUVORK5CYII=", "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAIAAAACAAQMAAAD58POIAAAAA3NCSVQICAjb4U/gAAAABlBMVEUAAAAAAAClZ7nPAAAAAXRSTlMAQObYZgAAAAlwSFlzAAAOxAAADsQBlSsOGwAAANpJREFUSInt0b0RgzAMhmFxFC49gkdhNBiNURjBJQUXJV/kH0nucynsgp8HI947iLDiSbRm6mvChAkTfgY7M4D5KbB5SMwH0cJ8e6hTIjNOHYK8vPFVYC3DttPBfhRYXg6Izak9qhsb1FFtfOiQvgHhbhBzPypIVwPZ3ELrfAVS0EML9FC5VqGy2wDmqXIBFSpN0fy57ADbVbmACpUvqFBpYA1I1eW4M6EYYELxCROKiAFMKLpNKFJNKFIHMOVot6Gf1JeDfYDHwXY7SNlBHOByEE4H6+FgoX9fb+/26Kq784CsAAAAAElFTkSuQmCC", z10));
                }
            }
            this.e = kVar;
        }
        this.r = i;
        this.E = context;
        this.g = new av(((fk) eVar).I, resources, z6);
        k kVar2 = this.e;
        if (kVar2 != null) {
            kVar2.b();
        }
    }

    private static void g(long j, com.google.android.libraries.navigation.internal.sg.a aVar, boolean z) {
        if (z) {
            aVar.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a() {
        ev evVarG;
        int iIntValue;
        Object aiVar;
        bc bcVar;
        synchronized (this.d) {
            if (this.f) {
                int i = 0;
                if (this.j.size() != ((lv) this.h).c) {
                    ez ezVar = new ez();
                    ev evVar = this.h;
                    int i2 = ((lv) evVar).c;
                    int i3 = 0;
                    while (i3 < i2) {
                        d dVar = (d) evVar.get(i3);
                        bc bcVar2 = dVar.a;
                        if (this.k.containsKey(bcVar2)) {
                            boolean zContains = this.D.contains(bcVar2);
                            boolean z = bcVar2.a.Q == bf.OFFLINE ? 1 : i;
                            int iIntValue2 = ((Integer) this.k.get(bcVar2)).intValue();
                            if (this.a != be.DISTANCE) {
                                iIntValue = i;
                            } else if (this.l.containsKey(bcVar2)) {
                                iIntValue = ((Integer) this.l.get(bcVar2)).intValue();
                            }
                            int i4 = (!this.s || zContains || (bcVar = this.F) == null || !this.k.containsKey(bcVar)) ? i : 1;
                            if (this.a == be.DISTANCE) {
                                i4 &= this.l.containsKey(this.F) ? 1 : 0;
                            }
                            boolean z2 = i4;
                            if (z2 != 0) {
                                Integer num = (Integer) this.k.get(this.F);
                                ar.q(num);
                                iIntValue2 -= num.intValue();
                                if (this.a == be.DISTANCE) {
                                    Integer num2 = (Integer) this.l.get(this.F);
                                    ar.q(num2);
                                    iIntValue -= num2.intValue();
                                }
                            }
                            int i5 = iIntValue2;
                            int i6 = iIntValue;
                            bc bcVar3 = this.F;
                            String str = bcVar3 != null ? bcVar3.a.y : null;
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            ev evVar2 = this.B;
                            int size = evVar2.size();
                            ay ayVar = null;
                            for (int i7 = i; i7 < size; i7++) {
                                ay ayVar2 = (ay) evVar2.get(i7);
                                bg bgVarA = ayVar2.a();
                                arrayList2.addAll(bgVarA.B());
                                com.google.android.libraries.navigation.internal.oe.an anVarE = ayVar2.b().e();
                                if (anVarE == null) {
                                    anVarE = bgVarA.y();
                                }
                                com.google.android.libraries.navigation.internal.oe.ad adVarC = anVarE.c();
                                if (ayVar2.d()) {
                                    arrayList.add(i, adVarC);
                                    ayVar = ayVar2;
                                } else {
                                    arrayList.add(adVarC);
                                }
                            }
                            az azVar = new az(false, bcVar2, arrayList, new aq(this.C, arrayList2), ayVar != null ? new com.google.android.libraries.navigation.internal.cl.q(bcVar2, ayVar) : com.google.android.libraries.navigation.internal.cl.p.a);
                            if (this.z) {
                                bc bcVar4 = dVar.a;
                                ba baVar = this.i;
                                Context context = this.E;
                                bd bdVar = this.o;
                                be beVar = this.a;
                                boolean z3 = this.t;
                                bc.f(this.w, dVar.b);
                                com.google.android.libraries.navigation.internal.op.f fVarE = baVar.e(context, bdVar, bcVar4, beVar, zContains, z3, i5, i6, this.q, z2, this.s, this.p, z, str, false);
                                com.google.android.libraries.navigation.internal.cs.a aVar = new com.google.android.libraries.navigation.internal.cs.a() { // from class: com.google.android.libraries.navigation.internal.bo.b
                                };
                                com.google.android.libraries.navigation.internal.qk.u uVarJ = com.google.android.libraries.navigation.internal.qk.v.j();
                                uVarJ.d(fVarE);
                                uVarJ.f(azVar);
                                uVarJ.i(com.google.android.libraries.navigation.internal.qk.t.ROUTE_DURATION);
                                uVarJ.h(com.google.android.libraries.navigation.internal.cl.bo.a);
                                com.google.android.libraries.navigation.internal.qk.v vVarJ = uVarJ.j();
                                com.google.android.libraries.navigation.internal.qk.w wVar = this.y;
                                ar.q(wVar);
                                com.google.android.libraries.navigation.internal.cr.f fVar = this.G;
                                ar.q(fVar);
                                aiVar = new com.google.android.libraries.navigation.internal.qk.aj(wVar, vVarJ, fVar, aVar);
                            } else {
                                bc bcVar5 = dVar.a;
                                ba baVar2 = this.i;
                                Context context2 = this.E;
                                bd bdVar2 = this.o;
                                be beVar2 = this.a;
                                boolean z4 = this.t;
                                bc.f(this.w, dVar.b);
                                com.google.android.libraries.navigation.internal.po.aa aaVarN = ((fk) this.v).H.n(baVar2.f(context2, bdVar2, bcVar5, beVar2, zContains, z4, i5, i6, this.q, z2, this.s, this.p, z, str), jr.WORLD_ENCODING_LAT_LNG_E7);
                                aaVarN.k(new c(bcVar5, this.x));
                                com.google.android.libraries.navigation.internal.qk.g gVarG = com.google.android.libraries.navigation.internal.qk.h.g();
                                gVarG.b(aaVarN);
                                gVarG.c(azVar);
                                gVarG.f(com.google.android.libraries.navigation.internal.qk.t.ROUTE_DURATION);
                                gVarG.e(com.google.android.libraries.navigation.internal.cl.bo.a);
                                aiVar = new com.google.android.libraries.navigation.internal.qk.ai(((fk) this.v).K, gVarG.g());
                            }
                            ezVar.f(aiVar, Boolean.valueOf(zContains));
                        }
                        i3++;
                        i = 0;
                    }
                    this.j = ezVar.d();
                    synchronized (this.d) {
                        if (this.o != bd.SHOW_NONE) {
                            bd bdVar3 = this.o;
                            if (bdVar3 == bd.SHOW_ALTERNATES_ONLY || bdVar3 == bd.SHOW_ALTERNATES_AND_LOW_PRIORITY) {
                                nn nnVarListIterator = this.j.entrySet().listIterator();
                                while (nnVarListIterator.hasNext()) {
                                    Map.Entry entry = (Map.Entry) nnVarListIterator.next();
                                    boolean zBooleanValue = ((Boolean) entry.getValue()).booleanValue();
                                    com.google.android.libraries.navigation.internal.qk.ak akVar = (com.google.android.libraries.navigation.internal.qk.ak) entry.getKey();
                                    if (!zBooleanValue) {
                                        akVar.f();
                                    }
                                }
                            } else {
                                nn nnVarListIterator2 = this.j.keySet().listIterator();
                                while (nnVarListIterator2.hasNext()) {
                                    ((com.google.android.libraries.navigation.internal.qk.ak) nnVarListIterator2.next()).f();
                                }
                            }
                        }
                    }
                }
                if (this.f349n.isEmpty() && !this.m.isEmpty()) {
                    if (this.g == null) {
                        evVarG = lv.a;
                    } else {
                        eq eqVar = new eq();
                        ev evVar3 = this.m;
                        int i8 = ((lv) evVar3).c;
                        for (int i9 = 0; i9 < i8; i9++) {
                            au auVar = (au) evVar3.get(i9);
                            int i10 = !auVar.d ? 1 : 0;
                            if (this.z) {
                                ar.q(this.y);
                                av avVar = this.g;
                                ar.q(avVar);
                                ev evVar4 = lv.a;
                                ar.q(auVar.b);
                                com.google.android.libraries.navigation.internal.oo.f fVarE2 = avVar.e();
                                Object objG = avVar.g();
                                Object objF = avVar.f(auVar.a);
                                Object obj = avVar.d;
                                com.google.android.libraries.navigation.internal.oj.c cVarF = com.google.android.libraries.navigation.internal.oj.c.f(auVar.b, fVarE2, new com.google.android.libraries.navigation.internal.op.b());
                                auVar.a(cVarF, fVarE2, objG, objF, obj);
                                int i11 = ((lv) evVar4).c;
                                for (int i12 = 0; i12 < i11; i12++) {
                                    ((com.google.android.libraries.navigation.internal.cl.ak) evVar4.get(i12)).a();
                                }
                                com.google.android.libraries.navigation.internal.op.f fVarE3 = ((com.google.android.libraries.navigation.internal.oj.b) cVarF).e();
                                com.google.android.libraries.navigation.internal.qk.u uVarJ2 = com.google.android.libraries.navigation.internal.qk.v.j();
                                uVarJ2.d(fVarE3);
                                uVarJ2.f(auVar.e);
                                uVarJ2.i(com.google.android.libraries.navigation.internal.qk.t.NAVIGATION_MANEUVER);
                                uVarJ2.h(av.e);
                                uVarJ2.g(i10);
                                eqVar.h(new com.google.android.libraries.navigation.internal.qk.aj(this.y, uVarJ2.j(), null, null));
                            } else {
                                at atVar = this.g;
                                ar.q(atVar);
                                ef efVarB = auVar.b(atVar);
                                if (efVarB != null) {
                                    com.google.android.libraries.navigation.internal.po.aa aaVarN2 = ((fk) this.v).H.n(efVarB, jr.WORLD_ENCODING_LAT_LNG_E7);
                                    aaVarN2.l();
                                    com.google.android.libraries.navigation.internal.qk.g gVarG2 = com.google.android.libraries.navigation.internal.qk.h.g();
                                    gVarG2.b(aaVarN2);
                                    gVarG2.c(auVar.e);
                                    gVarG2.f(com.google.android.libraries.navigation.internal.qk.t.NAVIGATION_MANEUVER);
                                    gVarG2.e(av.e);
                                    gVarG2.d(i10);
                                    eqVar.h(new com.google.android.libraries.navigation.internal.qk.ai(((fk) this.v).K, gVarG2.g()));
                                }
                            }
                        }
                        evVarG = eqVar.g();
                    }
                    this.f349n = evVarG;
                    synchronized (this.d) {
                        no it2 = this.f349n.iterator();
                        while (it2.hasNext()) {
                            ((com.google.android.libraries.navigation.internal.qk.ak) it2.next()).f();
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b() {
        synchronized (this.d) {
            no it2 = this.f349n.iterator();
            while (it2.hasNext()) {
                ((com.google.android.libraries.navigation.internal.qk.ak) it2.next()).c();
            }
            this.f349n = lv.a;
        }
    }

    public final void c() {
        synchronized (this.d) {
            nn nnVarListIterator = this.j.keySet().listIterator();
            while (nnVarListIterator.hasNext()) {
                ((com.google.android.libraries.navigation.internal.qk.ak) nnVarListIterator.next()).c();
            }
            this.j = ma.b;
            b();
        }
    }

    public final void d(bd bdVar) {
        this.o = bdVar;
        synchronized (this.d) {
            c();
            a();
        }
    }

    public final void e(boolean z) {
        if (this.b || this.q == z) {
            return;
        }
        this.q = z;
        synchronized (this.d) {
            c();
            av avVar = this.g;
            if (avVar != null) {
                avVar.h();
                this.g = null;
            }
            this.g = new av(((fk) this.v).I, this.w, this.u);
            a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f(bk bkVar) {
        if (this.b) {
            return;
        }
        synchronized (this.d) {
            ev evVar = this.h;
            int i = ((lv) evVar).c;
            int i2 = 0;
            boolean z = false;
            for (int i3 = 0; i3 < i; i3++) {
                bc bcVar = ((d) evVar.get(i3)).a;
                Duration duration = (Duration) bkVar.a.get(bcVar.a.Y);
                Double dValueOf = duration == null ? null : Double.valueOf(com.google.android.libraries.navigation.internal.aaa.a.a(duration));
                if (dValueOf != null && dValueOf.doubleValue() < 2.147483647E9d && dValueOf.doubleValue() > -2.147483648E9d) {
                    if (this.k.containsKey(bcVar)) {
                        Integer num = (Integer) this.k.get(bcVar);
                        int iIntValue = dValueOf.intValue();
                        Integer numValueOf = Integer.valueOf(iIntValue);
                        if (!numValueOf.equals(num)) {
                            int iIntValue2 = num.intValue();
                            numValueOf.getClass();
                            if (!com.google.android.libraries.navigation.internal.hf.u.d(iIntValue2, iIntValue)) {
                                this.k.put(bcVar, numValueOf);
                                z = true;
                            }
                        }
                    } else {
                        z = true;
                    }
                }
            }
            ev evVar2 = this.h;
            int i4 = ((lv) evVar2).c;
            int i5 = 0;
            while (true) {
                if (i5 < i4) {
                    bc bcVar2 = ((d) evVar2.get(i5)).a;
                    Double d = bkVar.d(bcVar2.a.Y);
                    if (d != null) {
                        if (this.l.containsKey(bcVar2)) {
                            if (Math.abs(((Integer) this.l.get(bcVar2)).intValue() - ((int) d.doubleValue())) > (this.o == bd.SHOW_ALL ? 100 : 500)) {
                            }
                        }
                        ev evVar3 = this.h;
                        int i6 = ((lv) evVar3).c;
                        while (i2 < i6) {
                            bc bcVar3 = ((d) evVar3.get(i2)).a;
                            Double d2 = bkVar.d(bcVar3.a.Y);
                            if (d2 != null) {
                                this.l.put(bcVar3, Integer.valueOf((int) d2.doubleValue()));
                            }
                            i2++;
                        }
                        i2 = 1;
                    }
                    i5++;
                }
                if ((z && this.a == be.TIME) || (i2 != 0 && this.a == be.DISTANCE)) {
                    c();
                    a();
                }
                final t tVar = this.c;
                if (tVar != null && bkVar != null && bkVar.c(tVar.a.Y) != null) {
                    Double dC = bkVar.c(tVar.a.Y);
                    ar.q(dC);
                    tVar.c = dC.doubleValue();
                    tVar.b.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.bo.q
                        @Override // java.lang.Runnable
                        public final void run() {
                            while (true) {
                                t tVar2 = tVar;
                                if (tVar2.e.isEmpty()) {
                                    return;
                                }
                                com.google.android.libraries.navigation.internal.cm.a aVar = (com.google.android.libraries.navigation.internal.cm.a) tVar2.e.peek();
                                ar.q(aVar);
                                if (aVar.b - 20.0d > tVar2.c) {
                                    return;
                                }
                                t.b((com.google.android.libraries.navigation.internal.cm.a) tVar2.e.remove());
                                if (tVar2.e() && tVar2.d()) {
                                    ((com.google.android.libraries.navigation.internal.cm.a) tVar2.e.getLast()).a.d();
                                }
                            }
                        }
                    });
                }
            }
        }
    }

    public final String toString() {
        return com.google.android.libraries.navigation.internal.yx.al.b(this).toString();
    }
}

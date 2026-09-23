package com.google.android.libraries.navigation.internal.xe;

import android.R;
import android.content.Context;
import android.graphics.Typeface;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.google.android.libraries.geo.mapcore.internal.ui.CompassButtonView;
import java.util.Objects;
import java.util.Optional;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class dk extends com.google.android.libraries.navigation.internal.ms.bt<Cdo> {
    public static final com.google.android.libraries.navigation.internal.nc.a A;
    public static final com.google.android.libraries.navigation.internal.nc.a B;
    public static final com.google.android.libraries.navigation.internal.nc.a C;
    public static final com.google.android.libraries.navigation.internal.nc.a D;
    public static final com.google.android.libraries.navigation.internal.nc.a E;
    public static final com.google.android.libraries.navigation.internal.nc.a F;
    public static final com.google.android.libraries.navigation.internal.nc.a G;
    public static final com.google.android.libraries.navigation.internal.nc.a H;
    public static final com.google.android.libraries.navigation.internal.nc.a I;
    public static final com.google.android.libraries.navigation.internal.nc.a J;
    public static final com.google.android.libraries.navigation.internal.nc.a K;
    public static final com.google.android.libraries.navigation.internal.nc.a L;
    public static final com.google.android.libraries.navigation.internal.nc.a M;
    public static final com.google.android.libraries.navigation.internal.nc.a N;
    public static final com.google.android.libraries.navigation.internal.nc.a O;
    public static final com.google.android.libraries.navigation.internal.nc.a P;
    public static final com.google.android.libraries.navigation.internal.nc.a Q;
    public static final com.google.android.libraries.navigation.internal.nc.a R;
    public static final com.google.android.libraries.navigation.internal.nc.ap S;
    public static final com.google.android.libraries.navigation.internal.nc.ap T;
    public static final com.google.android.libraries.navigation.internal.nc.ap U;
    private static final com.google.android.libraries.navigation.internal.ms.by V;
    public static final com.google.android.libraries.navigation.internal.ms.cc a = new com.google.android.libraries.navigation.internal.ms.cc();
    public static final com.google.android.libraries.navigation.internal.ms.cc b = new com.google.android.libraries.navigation.internal.ms.cc();
    public static final com.google.android.libraries.navigation.internal.ms.cc c = new com.google.android.libraries.navigation.internal.ms.cc();
    public static final com.google.android.libraries.navigation.internal.ms.cc d = new com.google.android.libraries.navigation.internal.ms.cc();
    public static final com.google.android.libraries.navigation.internal.ms.cc f = new com.google.android.libraries.navigation.internal.ms.cc();
    public static final com.google.android.libraries.navigation.internal.ms.cc g = new com.google.android.libraries.navigation.internal.ms.cc();
    public static final com.google.android.libraries.navigation.internal.ms.cc h = new com.google.android.libraries.navigation.internal.ms.cc();
    public static final com.google.android.libraries.navigation.internal.ms.cc i = new com.google.android.libraries.navigation.internal.ms.cc();
    public static final com.google.android.libraries.navigation.internal.ms.cc j = new com.google.android.libraries.navigation.internal.ms.cc();
    public static final com.google.android.libraries.navigation.internal.ms.cc k = new com.google.android.libraries.navigation.internal.ms.cc();
    public static final com.google.android.libraries.navigation.internal.ms.cc l = new com.google.android.libraries.navigation.internal.ms.cc();
    public static final com.google.android.libraries.navigation.internal.ms.cc m = new com.google.android.libraries.navigation.internal.ms.cc();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final com.google.android.libraries.navigation.internal.ms.cc f648n = new com.google.android.libraries.navigation.internal.ms.cc();
    public static final com.google.android.libraries.navigation.internal.ms.cc o = new com.google.android.libraries.navigation.internal.ms.cc();
    public static final com.google.android.libraries.navigation.internal.ms.cc p = new com.google.android.libraries.navigation.internal.ms.cc();
    public static final com.google.android.libraries.navigation.internal.ms.cc q = new com.google.android.libraries.navigation.internal.ms.cc();
    public static final com.google.android.libraries.navigation.internal.nc.a r = com.google.android.libraries.navigation.internal.nc.a.g(40);
    public static final com.google.android.libraries.navigation.internal.nc.a s = com.google.android.libraries.navigation.internal.nc.a.g(20);
    public static final com.google.android.libraries.navigation.internal.nc.a t = com.google.android.libraries.navigation.internal.nc.a.g(20);
    public static final com.google.android.libraries.navigation.internal.nc.a u = com.google.android.libraries.navigation.internal.nc.a.g(12);
    public static final com.google.android.libraries.navigation.internal.nc.a v = com.google.android.libraries.navigation.internal.nc.a.g(40);
    public static final com.google.android.libraries.navigation.internal.nc.a w = com.google.android.libraries.navigation.internal.nc.a.g(16);
    public static final com.google.android.libraries.navigation.internal.nc.a x;
    public static final com.google.android.libraries.navigation.internal.nc.a y;
    public static final com.google.android.libraries.navigation.internal.nc.a z;

    static {
        com.google.android.libraries.navigation.internal.nc.a aVarG = com.google.android.libraries.navigation.internal.nc.a.g(5);
        x = aVarG;
        com.google.android.libraries.navigation.internal.nc.a aVarG2 = com.google.android.libraries.navigation.internal.nc.a.g(8);
        y = aVarG2;
        z = com.google.android.libraries.navigation.internal.nc.a.i(26);
        A = com.google.android.libraries.navigation.internal.nc.a.i(14);
        B = com.google.android.libraries.navigation.internal.nc.a.i(14);
        C = com.google.android.libraries.navigation.internal.nc.a.i(24);
        D = com.google.android.libraries.navigation.internal.nc.a.i(14);
        E = com.google.android.libraries.navigation.internal.nc.a.i(14);
        F = com.google.android.libraries.navigation.internal.nc.a.i(24);
        G = com.google.android.libraries.navigation.internal.nc.a.i(22);
        H = com.google.android.libraries.navigation.internal.nc.a.g(20);
        I = com.google.android.libraries.navigation.internal.nc.a.g(8);
        J = com.google.android.libraries.navigation.internal.nc.a.g(9);
        K = com.google.android.libraries.navigation.internal.nc.a.g(7);
        L = com.google.android.libraries.navigation.internal.nc.a.i(30);
        M = com.google.android.libraries.navigation.internal.nc.a.i(30);
        N = com.google.android.libraries.navigation.internal.nc.a.g(238);
        O = com.google.android.libraries.navigation.internal.nc.a.g(171);
        P = com.google.android.libraries.navigation.internal.nc.a.g(24);
        Q = com.google.android.libraries.navigation.internal.nc.a.g(12);
        R = com.google.android.libraries.navigation.internal.nc.a.g(20);
        S = com.google.android.libraries.navigation.internal.nc.j.k(com.google.android.libraries.navigation.internal.f.c.c);
        T = com.google.android.libraries.navigation.internal.nc.j.k(com.google.android.libraries.navigation.internal.f.c.b);
        U = com.google.android.libraries.navigation.internal.nc.p.c(new com.google.android.libraries.navigation.internal.nc.n(com.google.android.libraries.navigation.internal.uo.bg.c, aVarG2, aVarG2), aVarG);
        V = new com.google.android.libraries.navigation.internal.ms.by() { // from class: com.google.android.libraries.navigation.internal.xe.bq
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar, Context context) {
                Cdo cdo = (Cdo) csVar;
                com.google.android.libraries.navigation.internal.ms.cc ccVar = dk.a;
                com.google.android.libraries.navigation.internal.uk.a.InterfaceC0037a interfaceC0037aC = cdo.c();
                if (interfaceC0037aC != null) {
                    return interfaceC0037aC.a(false, false, true, cdo.u().booleanValue());
                }
                return null;
            }
        };
        com.google.android.libraries.navigation.internal.ms.da.b(new com.google.android.libraries.navigation.internal.ms.by() { // from class: com.google.android.libraries.navigation.internal.xe.cb
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar, Context context) {
                com.google.android.libraries.navigation.internal.tz.l lVar;
                com.google.android.libraries.navigation.internal.tz.l lVar2;
                com.google.android.libraries.navigation.internal.tz.l lVar3;
                com.google.android.libraries.navigation.internal.tz.r rVar;
                com.google.android.libraries.navigation.internal.tz.r rVar2;
                com.google.android.libraries.navigation.internal.tz.r rVar3;
                com.google.android.libraries.navigation.internal.tz.r rVar4;
                com.google.android.libraries.navigation.internal.nc.x xVarB;
                com.google.android.libraries.navigation.internal.nc.x xVarA;
                Cdo cdo = (Cdo) csVar;
                com.google.android.libraries.navigation.internal.ms.cc ccVar = dk.a;
                com.google.android.libraries.navigation.internal.tz.k kVarM = com.google.android.libraries.navigation.internal.tz.l.m();
                kVarM.b(ViewCompat.MEASURED_STATE_MASK);
                kVarM.d(-7829368);
                kVarM.c(-1);
                kVarM.e();
                com.google.android.libraries.navigation.internal.tz.l lVarA = kVarM.a();
                com.google.android.libraries.navigation.internal.tz.k kVarM2 = com.google.android.libraries.navigation.internal.tz.l.m();
                kVarM2.b(-1);
                kVarM2.d(-7829368);
                kVarM2.c(ViewCompat.MEASURED_STATE_MASK);
                kVarM2.e();
                com.google.android.libraries.navigation.internal.tz.l lVarA2 = kVarM2.a();
                com.google.android.libraries.navigation.internal.tz.k kVarM3 = com.google.android.libraries.navigation.internal.tz.l.m();
                kVarM3.b(ViewCompat.MEASURED_STATE_MASK);
                kVarM3.c(-1);
                com.google.android.libraries.navigation.internal.tz.l lVarA3 = kVarM3.a();
                com.google.android.libraries.navigation.internal.tz.q qVarH = com.google.android.libraries.navigation.internal.tz.r.h();
                qVarH.f(26);
                qVarH.g(1);
                qVarH.h(Typeface.DEFAULT);
                qVarH.d(14);
                qVarH.e(1);
                qVarH.b(14);
                qVarH.c(1);
                com.google.android.libraries.navigation.internal.tz.r rVarA = qVarH.a();
                com.google.android.libraries.navigation.internal.tz.q qVarH2 = com.google.android.libraries.navigation.internal.tz.r.h();
                qVarH2.f(24);
                qVarH2.g(0);
                qVarH2.h(Typeface.DEFAULT);
                qVarH2.d(14);
                qVarH2.e(0);
                qVarH2.b(14);
                qVarH2.c(0);
                com.google.android.libraries.navigation.internal.tz.r rVarA2 = qVarH2.a();
                com.google.android.libraries.navigation.internal.tz.q qVarH3 = com.google.android.libraries.navigation.internal.tz.r.h();
                qVarH3.f(24);
                qVarH3.g(0);
                qVarH3.h(Typeface.DEFAULT);
                qVarH3.d(14);
                qVarH3.b(14);
                com.google.android.libraries.navigation.internal.tz.r rVarA3 = qVarH3.a();
                com.google.android.libraries.navigation.internal.tz.q qVarH4 = com.google.android.libraries.navigation.internal.tz.r.h();
                qVarH4.f(24);
                qVarH4.g(0);
                qVarH4.h(Typeface.DEFAULT);
                qVarH4.d(24);
                qVarH4.e(0);
                qVarH4.b(24);
                qVarH4.c(0);
                com.google.android.libraries.navigation.internal.tz.r rVarA4 = qVarH4.a();
                com.google.android.libraries.navigation.internal.tz.e eVar = new com.google.android.libraries.navigation.internal.tz.e();
                eVar.a(16);
                eVar.b(lVarA);
                eVar.d(lVarA2);
                eVar.k(lVarA3);
                eVar.i(rVarA);
                eVar.j(rVarA2);
                eVar.g = 102;
                eVar.f609n = (byte) (eVar.f609n | 2);
                eVar.c(rVarA4);
                eVar.g(-1);
                eVar.e(ViewCompat.MEASURED_STATE_MASK);
                eVar.h(rVarA3);
                eVar.f(16);
                eVar.f609n = (byte) (eVar.f609n | 96);
                eVar.a(dk.w.e(context));
                com.google.android.libraries.navigation.internal.xj.d dVarJ = cdo.j();
                com.google.android.libraries.navigation.internal.xj.c cVar = cdo.u().booleanValue() ? com.google.android.libraries.navigation.internal.xj.c.NIGHT : com.google.android.libraries.navigation.internal.xj.c.DAY;
                com.google.android.libraries.navigation.internal.tz.k kVarM4 = com.google.android.libraries.navigation.internal.tz.l.m();
                kVarM4.b(dVarJ.a(com.google.android.libraries.navigation.internal.xj.a.PRIMARY, cVar).b(context));
                kVarM4.d(dVarJ.a(com.google.android.libraries.navigation.internal.xj.a.SECONDARY, cVar).b(context));
                kVarM4.c(-1);
                kVarM4.e();
                com.google.android.libraries.navigation.internal.uk.a.d dVarE = cdo.e();
                if (dVarE != null) {
                    com.google.android.libraries.navigation.internal.nc.x xVarC = dVarE.c(true);
                    if (xVarC != null) {
                        ((com.google.android.libraries.navigation.internal.tz.a) kVarM4).f = Optional.of(Integer.valueOf(((com.google.android.libraries.navigation.internal.nc.ae) xVarC).a));
                    }
                    com.google.android.libraries.navigation.internal.nc.x xVarB2 = dVarE.b(true);
                    if (xVarB2 != null) {
                        ((com.google.android.libraries.navigation.internal.tz.a) kVarM4).c = Optional.of(Integer.valueOf(((com.google.android.libraries.navigation.internal.nc.ae) xVarB2).a));
                    }
                    com.google.android.libraries.navigation.internal.nc.x xVarA2 = dVarE.a(true);
                    if (xVarA2 != null) {
                        ((com.google.android.libraries.navigation.internal.tz.a) kVarM4).d = Optional.of(Integer.valueOf(((com.google.android.libraries.navigation.internal.nc.ae) xVarA2).a));
                    }
                }
                com.google.android.libraries.navigation.internal.uk.a.b bVarD = cdo.d();
                if (bVarD != null && (xVarA = bVarD.a(true)) != null) {
                    ((com.google.android.libraries.navigation.internal.tz.a) kVarM4).e = Optional.of(Integer.valueOf(xVarA.b(context)));
                }
                eVar.b(kVarM4.a());
                com.google.android.libraries.navigation.internal.tz.k kVarM5 = com.google.android.libraries.navigation.internal.tz.l.m();
                kVarM5.b(com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.w.a.i(), com.google.android.libraries.navigation.internal.w.a.j()).b(context));
                kVarM5.d(com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.w.a.j(), com.google.android.libraries.navigation.internal.w.a.k()).b(context));
                kVarM5.c(-1);
                kVarM5.e();
                eVar.d(kVarM5.a());
                com.google.android.libraries.navigation.internal.tz.k kVarM6 = com.google.android.libraries.navigation.internal.tz.l.m();
                kVarM6.b(com.google.android.libraries.navigation.internal.w.a.j().b(context));
                kVarM6.c(-1);
                eVar.k(kVarM6.a());
                com.google.android.libraries.navigation.internal.vb.j jVar = (com.google.android.libraries.navigation.internal.vb.j) cdo.e();
                com.google.android.libraries.navigation.internal.nc.bh bhVar = jVar.a;
                Typeface typeface = bhVar != null ? ((com.google.android.libraries.navigation.internal.nc.bg) bhVar).a : null;
                if (typeface == null) {
                    typeface = com.google.android.libraries.navigation.internal.ms.ad.e;
                }
                com.google.android.libraries.navigation.internal.nc.a aVar = jVar.b;
                if (aVar == null) {
                    aVar = dk.z;
                }
                com.google.android.libraries.navigation.internal.tz.q qVarH5 = com.google.android.libraries.navigation.internal.tz.r.h();
                qVarH5.f(aVar.e(context));
                qVarH5.g(1);
                qVarH5.h(typeface);
                qVarH5.d(dk.A.e(context));
                qVarH5.e(1);
                qVarH5.b(dk.B.e(context));
                qVarH5.c(1);
                eVar.i(qVarH5.a());
                com.google.android.libraries.navigation.internal.uk.a.d dVarE2 = cdo.e();
                Typeface typefaceI = dk.i(dVarE2);
                com.google.android.libraries.navigation.internal.nc.a aVar2 = ((com.google.android.libraries.navigation.internal.vb.j) dVarE2).c;
                if (aVar2 == null) {
                    aVar2 = dk.C;
                }
                com.google.android.libraries.navigation.internal.tz.q qVarH6 = com.google.android.libraries.navigation.internal.tz.r.h();
                qVarH6.f(aVar2.e(context));
                qVarH6.g(0);
                qVarH6.h(typefaceI);
                qVarH6.d(dk.D.e(context));
                qVarH6.e(0);
                qVarH6.b(dk.E.e(context));
                qVarH6.c(0);
                eVar.j(qVarH6.a());
                com.google.android.libraries.navigation.internal.uk.a.d dVarE3 = cdo.e();
                Typeface typefaceI2 = dk.i(dVarE3);
                com.google.android.libraries.navigation.internal.vb.j jVar2 = (com.google.android.libraries.navigation.internal.vb.j) dVarE3;
                com.google.android.libraries.navigation.internal.nc.a aVar3 = jVar2.f;
                if (aVar3 == null) {
                    aVar3 = dk.F;
                }
                com.google.android.libraries.navigation.internal.nc.a aVar4 = jVar2.g;
                if (aVar4 == null) {
                    aVar4 = dk.F;
                }
                com.google.android.libraries.navigation.internal.tz.q qVarH7 = com.google.android.libraries.navigation.internal.tz.r.h();
                qVarH7.f(aVar3.e(context));
                qVarH7.g(0);
                qVarH7.h(typefaceI2);
                qVarH7.d(dk.F.e(context));
                qVarH7.e(0);
                qVarH7.b(aVar4.e(context));
                qVarH7.c(0);
                eVar.c(qVarH7.a());
                com.google.android.libraries.navigation.internal.nc.x xVarD = cdo.e().d(true);
                eVar.g(xVarD != null ? ((com.google.android.libraries.navigation.internal.nc.ae) xVarD).a : -1);
                eVar.e(cdo.j().a(com.google.android.libraries.navigation.internal.xj.a.SECONDARY, cdo.u().booleanValue() ? com.google.android.libraries.navigation.internal.xj.c.NIGHT : com.google.android.libraries.navigation.internal.xj.c.DAY).b(context));
                com.google.android.libraries.navigation.internal.uk.a.d dVarE4 = cdo.e();
                Typeface typefaceI3 = dk.i(dVarE4);
                com.google.android.libraries.navigation.internal.nc.a aVar5 = ((com.google.android.libraries.navigation.internal.vb.j) dVarE4).e;
                if (aVar5 == null) {
                    aVar5 = dk.G;
                }
                com.google.android.libraries.navigation.internal.tz.q qVarH8 = com.google.android.libraries.navigation.internal.tz.r.h();
                qVarH8.f(aVar5.e(context));
                qVarH8.g(0);
                qVarH8.h(typefaceI3);
                eVar.h(qVarH8.a());
                eVar.f(dk.w.e(context));
                com.google.android.libraries.navigation.internal.uk.a.b bVarD2 = cdo.d();
                if (bVarD2 != null && (xVarB = bVarD2.b(true)) != null) {
                    eVar.m = Optional.of(Integer.valueOf(xVarB.b(context)));
                }
                if (eVar.f609n != 127 || (lVar = eVar.b) == null || (lVar2 = eVar.c) == null || (lVar3 = eVar.d) == null || (rVar = eVar.e) == null || (rVar2 = eVar.f) == null || (rVar3 = eVar.h) == null || (rVar4 = eVar.k) == null) {
                    throw new IllegalStateException();
                }
                return new com.google.android.libraries.navigation.internal.tz.f(eVar.a, lVar, lVar2, lVar3, rVar, rVar2, eVar.g, rVar3, eVar.i, eVar.j, rVar4, eVar.l, eVar.m);
            }
        });
        com.google.android.libraries.navigation.internal.ms.da.b(new com.google.android.libraries.navigation.internal.ms.by() { // from class: com.google.android.libraries.navigation.internal.xe.cm
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar, Context context) {
                com.google.android.libraries.navigation.internal.ms.cc ccVar = dk.a;
                com.google.android.libraries.navigation.internal.tz.c cVar = new com.google.android.libraries.navigation.internal.tz.c();
                cVar.g(com.google.android.libraries.navigation.internal.tz.t.e());
                cVar.k(com.google.android.libraries.navigation.internal.tz.t.e());
                com.google.android.libraries.navigation.internal.tz.t tVarE = com.google.android.libraries.navigation.internal.tz.t.e();
                Objects.requireNonNull(tVarE);
                cVar.a = tVarE;
                cVar.d(com.google.android.libraries.navigation.internal.tz.t.e());
                cVar.e(com.google.android.libraries.navigation.internal.tz.t.e());
                cVar.j(com.google.android.libraries.navigation.internal.tz.t.e());
                cVar.h(30);
                cVar.i(30);
                cVar.b = com.google.android.libraries.navigation.internal.nc.a.g(72).d(context);
                cVar.h = (short) (cVar.h | 8);
                cVar.c = com.google.android.libraries.navigation.internal.nc.a.g(72).d(context);
                cVar.h = (short) (cVar.h | 16);
                cVar.d = com.google.android.libraries.navigation.internal.nc.a.g(36).d(context);
                cVar.h = (short) (cVar.h | 32);
                cVar.e = com.google.android.libraries.navigation.internal.nc.a.g(36).d(context);
                cVar.h = (short) (cVar.h | 65);
                cVar.f = com.google.android.libraries.navigation.internal.tz.n.r(37, context);
                cVar.h = (short) (cVar.h | 128);
                cVar.c(com.google.android.libraries.navigation.internal.tz.n.r(6, context));
                cVar.f(0.8648649f);
                cVar.g = 0.8648649f;
                cVar.h = (short) (cVar.h | 1024);
                com.google.android.libraries.navigation.internal.tz.i iVar = new com.google.android.libraries.navigation.internal.tz.i();
                iVar.d(dk.I.e(context));
                iVar.e(0);
                iVar.c(dk.I.e(context));
                iVar.b(0);
                cVar.g(iVar.a());
                cVar.c(dk.J.e(context));
                com.google.android.libraries.navigation.internal.tz.i iVar2 = new com.google.android.libraries.navigation.internal.tz.i();
                iVar2.d(0);
                iVar2.e(0);
                iVar2.c(0);
                iVar2.b(0);
                cVar.d(iVar2.a());
                com.google.android.libraries.navigation.internal.tz.i iVar3 = new com.google.android.libraries.navigation.internal.tz.i();
                iVar3.d(dk.H.e(context));
                iVar3.e(dk.I.e(context));
                iVar3.c(dk.H.e(context));
                iVar3.b(dk.I.e(context));
                cVar.e(iVar3.a());
                com.google.android.libraries.navigation.internal.tz.i iVar4 = new com.google.android.libraries.navigation.internal.tz.i();
                iVar4.d(0);
                iVar4.e(dk.I.e(context));
                iVar4.c(0);
                iVar4.b(dk.I.e(context));
                cVar.k(iVar4.a());
                com.google.android.libraries.navigation.internal.tz.i iVar5 = new com.google.android.libraries.navigation.internal.tz.i();
                iVar5.d(dk.H.e(context));
                iVar5.e(dk.K.e(context));
                iVar5.c(dk.H.e(context));
                iVar5.b(dk.K.e(context));
                cVar.j(iVar5.a());
                cVar.i(dk.L.d(context));
                cVar.h(dk.M.d(context));
                cVar.f(Math.max(cVar.a(), 0.8648649f));
                return cVar.b();
            }
        });
    }

    static int b(Context context) {
        return com.google.android.libraries.navigation.internal.nc.a.f(context.getResources().getConfiguration().screenWidthDp * 0.5f).e(context);
    }

    public static boolean c(Context context) {
        return com.google.android.libraries.navigation.internal.ms.aq.c(context);
    }

    public static boolean h(Cdo cdo, Context context) {
        return cdo.l().booleanValue() && c(context);
    }

    public static Typeface i(com.google.android.libraries.navigation.internal.uk.a.d dVar) {
        com.google.android.libraries.navigation.internal.nc.bh bhVar;
        Typeface typeface;
        return (dVar == null || (bhVar = ((com.google.android.libraries.navigation.internal.vb.j) dVar).d) == null || (typeface = ((com.google.android.libraries.navigation.internal.nc.bg) bhVar).a) == null) ? com.google.android.libraries.navigation.internal.ms.ad.e : typeface;
    }

    @Override // com.google.android.libraries.navigation.internal.ms.bt
    protected final com.google.android.libraries.navigation.internal.mx.g a() {
        com.google.android.libraries.navigation.internal.mx.e eVar = new com.google.android.libraries.navigation.internal.mx.e(RelativeLayout.class, new com.google.android.libraries.navigation.internal.mx.aa(c), com.google.android.libraries.navigation.internal.ms.ah.O(new com.google.android.libraries.navigation.internal.ms.dd() { // from class: com.google.android.libraries.navigation.internal.xe.bu
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar) {
                return ((Cdo) csVar).o();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.ac(com.google.android.libraries.navigation.internal.ms.bz.j()), com.google.android.libraries.navigation.internal.ms.ah.ae(com.google.android.libraries.navigation.internal.ms.da.b(new com.google.android.libraries.navigation.internal.ms.by() { // from class: com.google.android.libraries.navigation.internal.xe.cf
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar, Context context) {
                return Integer.valueOf(com.google.android.libraries.navigation.internal.ms.aq.b(context) ? dk.b(context) : -1);
            }
        })), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.aA(com.google.android.libraries.navigation.internal.nc.a.g(0)), com.google.android.libraries.navigation.internal.ms.ah.ay(com.google.android.libraries.navigation.internal.nc.a.g(0)), com.google.android.libraries.navigation.internal.ms.ah.aw(com.google.android.libraries.navigation.internal.nc.a.g(0)), new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, new com.google.android.libraries.navigation.internal.mx.aa(o), com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.ab(com.google.android.libraries.navigation.internal.uo.bg.a), com.google.android.libraries.navigation.internal.ms.ah.H(com.google.android.libraries.navigation.internal.ms.da.b(new com.google.android.libraries.navigation.internal.ms.by() { // from class: com.google.android.libraries.navigation.internal.xe.cw
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar, Context context) {
                return Boolean.valueOf(dk.h((Cdo) csVar, context));
            }
        })), com.google.android.libraries.navigation.internal.ms.ah.n(V)), com.google.android.libraries.navigation.internal.ms.ah.c(new com.google.android.libraries.navigation.internal.uo.k(), new com.google.android.libraries.navigation.internal.ms.dd() { // from class: com.google.android.libraries.navigation.internal.xe.cx
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar) {
                return ((Cdo) csVar).f();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new com.google.android.libraries.navigation.internal.mx.m[0]));
        com.google.android.libraries.navigation.internal.mx.e eVar2 = new com.google.android.libraries.navigation.internal.mx.e(RelativeLayout.class, new com.google.android.libraries.navigation.internal.mx.aa(f), com.google.android.libraries.navigation.internal.ms.ah.ac(com.google.android.libraries.navigation.internal.ms.bz.g()), com.google.android.libraries.navigation.internal.ms.ah.ae(com.google.android.libraries.navigation.internal.ms.da.b(new com.google.android.libraries.navigation.internal.ms.by() { // from class: com.google.android.libraries.navigation.internal.xe.cy
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar, Context context) {
                return Integer.valueOf(com.google.android.libraries.navigation.internal.ms.aq.b(context) ? dk.b(context) : -1);
            }
        })), com.google.android.libraries.navigation.internal.ms.ah.T(-2));
        com.google.android.libraries.navigation.internal.mx.e eVar3 = new com.google.android.libraries.navigation.internal.mx.e(RelativeLayout.class, new com.google.android.libraries.navigation.internal.mx.aa(d), com.google.android.libraries.navigation.internal.ms.ah.H(new com.google.android.libraries.navigation.internal.ms.dd() { // from class: com.google.android.libraries.navigation.internal.xe.df
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar) {
                return ((Cdo) csVar).n();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.ac(com.google.android.libraries.navigation.internal.ms.bz.g()), com.google.android.libraries.navigation.internal.ms.ah.ae(com.google.android.libraries.navigation.internal.ms.da.b(new com.google.android.libraries.navigation.internal.ms.by() { // from class: com.google.android.libraries.navigation.internal.xe.dg
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar, Context context) {
                return Integer.valueOf(com.google.android.libraries.navigation.internal.ms.aq.b(context) ? dk.b(context) : -1);
            }
        })), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.c(new com.google.android.libraries.navigation.internal.un.f(), new com.google.android.libraries.navigation.internal.ms.dd() { // from class: com.google.android.libraries.navigation.internal.xe.de
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar) {
                return ((Cdo) csVar).h();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new com.google.android.libraries.navigation.internal.mx.m[0]));
        com.google.android.libraries.navigation.internal.mx.e eVar4 = new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.G(new com.google.android.libraries.navigation.internal.ms.dd() { // from class: com.google.android.libraries.navigation.internal.xe.dh
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar) {
                com.google.android.libraries.navigation.internal.ms.cc ccVar = dk.a;
                return Boolean.valueOf(!((Cdo) csVar).n().booleanValue());
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.ae(com.google.android.libraries.navigation.internal.ms.da.b(new com.google.android.libraries.navigation.internal.ms.by() { // from class: com.google.android.libraries.navigation.internal.xe.di
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar, Context context) {
                return Integer.valueOf(com.google.android.libraries.navigation.internal.ms.aq.b(context) ? dk.b(context) : -1);
            }
        })), com.google.android.libraries.navigation.internal.ms.ah.S(x), com.google.android.libraries.navigation.internal.ms.ah.q(Integer.valueOf(com.google.android.libraries.navigation.internal.f.d.a)), com.google.android.libraries.navigation.internal.ms.ah.ac(com.google.android.libraries.navigation.internal.ms.bz.c(eVar3)));
        com.google.android.libraries.navigation.internal.mx.e eVar5 = new com.google.android.libraries.navigation.internal.mx.e(RelativeLayout.class, new com.google.android.libraries.navigation.internal.mx.aa(m), com.google.android.libraries.navigation.internal.ms.ch.b(new com.google.android.libraries.navigation.internal.ms.by() { // from class: com.google.android.libraries.navigation.internal.xe.dj
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar, Context context) {
                com.google.android.libraries.navigation.internal.ms.cc ccVar = dk.a;
                return ((Cdo) csVar).n();
            }
        }, com.google.android.libraries.navigation.internal.ms.ah.ac(com.google.android.libraries.navigation.internal.ms.bz.c(eVar3)), com.google.android.libraries.navigation.internal.ms.ah.ac(com.google.android.libraries.navigation.internal.ms.bz.g())), com.google.android.libraries.navigation.internal.ms.ah.ae(com.google.android.libraries.navigation.internal.ms.da.b(new com.google.android.libraries.navigation.internal.ms.by() { // from class: com.google.android.libraries.navigation.internal.xe.br
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar, Context context) {
                return Integer.valueOf(com.google.android.libraries.navigation.internal.ms.aq.b(context) ? dk.b(context) : -1);
            }
        })), com.google.android.libraries.navigation.internal.ms.ah.T(-2));
        com.google.android.libraries.navigation.internal.mx.e eVar6 = new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.b(new com.google.android.libraries.navigation.internal.xg.p(), new com.google.android.libraries.navigation.internal.ms.dd() { // from class: com.google.android.libraries.navigation.internal.xe.bs
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar) {
                return ((Cdo) csVar).k();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new com.google.android.libraries.navigation.internal.ms.dd() { // from class: com.google.android.libraries.navigation.internal.xe.bt
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar) {
                com.google.android.libraries.navigation.internal.ms.cc ccVar = dk.a;
                ((Cdo) csVar).k();
                return false;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new com.google.android.libraries.navigation.internal.mx.m[0]), com.google.android.libraries.navigation.internal.ms.ah.b(new com.google.android.libraries.navigation.internal.xg.n(), new com.google.android.libraries.navigation.internal.ms.dd() { // from class: com.google.android.libraries.navigation.internal.xe.bs
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar) {
                return ((Cdo) csVar).k();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new com.google.android.libraries.navigation.internal.ms.dd() { // from class: com.google.android.libraries.navigation.internal.xe.bv
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar) {
                com.google.android.libraries.navigation.internal.ms.cc ccVar = dk.a;
                return Boolean.valueOf(((Cdo) csVar).k() != null);
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new com.google.android.libraries.navigation.internal.mx.m[0]));
        com.google.android.libraries.navigation.internal.ms.cc ccVar = a;
        com.google.android.libraries.navigation.internal.ms.bz[] bzVarArr = {com.google.android.libraries.navigation.internal.ms.bz.h()};
        com.google.android.libraries.navigation.internal.nc.a aVar = r;
        com.google.android.libraries.navigation.internal.nc.a aVar2 = t;
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr = {new com.google.android.libraries.navigation.internal.mx.aa(ccVar), com.google.android.libraries.navigation.internal.ms.ah.H(new com.google.android.libraries.navigation.internal.ms.dd() { // from class: com.google.android.libraries.navigation.internal.xe.by
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar) {
                return ((Cdo) csVar).m();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.ac(bzVarArr), com.google.android.libraries.navigation.internal.ms.ah.af(aVar), com.google.android.libraries.navigation.internal.ms.ah.S(aVar), com.google.android.libraries.navigation.internal.ms.ah.ab(s), com.google.android.libraries.navigation.internal.ms.ah.X(aVar2)};
        int i2 = CompassButtonView.g;
        com.google.android.libraries.navigation.internal.ms.cc ccVar2 = q;
        com.google.android.libraries.navigation.internal.nc.a aVar3 = Q;
        com.google.android.libraries.navigation.internal.mx.e eVar7 = new com.google.android.libraries.navigation.internal.mx.e(RelativeLayout.class, com.google.android.libraries.navigation.internal.ms.ah.H(com.google.android.libraries.navigation.internal.ms.da.b(new com.google.android.libraries.navigation.internal.ms.by() { // from class: com.google.android.libraries.navigation.internal.xe.bw
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar, Context context) {
                Cdo cdo = (Cdo) csVar;
                com.google.android.libraries.navigation.internal.ms.cc ccVar3 = dk.a;
                boolean z2 = true;
                if (!cdo.m().booleanValue() && !cdo.p(com.google.android.libraries.navigation.internal.afl.fv.a.UPPER_RIGHT, com.google.android.libraries.navigation.internal.ms.aq.b(context)).booleanValue()) {
                    z2 = false;
                }
                return Boolean.valueOf(z2);
            }
        })), com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-1), com.google.android.libraries.navigation.internal.ms.ah.ba(com.google.android.libraries.navigation.internal.ms.da.b(new com.google.android.libraries.navigation.internal.ms.by() { // from class: com.google.android.libraries.navigation.internal.xe.bx
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar, Context context) {
                Cdo cdo = (Cdo) csVar;
                com.google.android.libraries.navigation.internal.ms.cc ccVar3 = dk.a;
                if (!cdo.o().booleanValue() || dk.h(cdo, context) || com.google.android.libraries.navigation.internal.ms.aq.b(context)) {
                    return com.google.android.libraries.navigation.internal.nc.a.g(0);
                }
                return dk.c(context) ? com.google.android.libraries.navigation.internal.uo.bg.a : com.google.android.libraries.navigation.internal.uo.bg.c;
            }
        })), new com.google.android.libraries.navigation.internal.mx.e(CompassButtonView.class, mVarArr), new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, new com.google.android.libraries.navigation.internal.mx.aa(ccVar2), eVar6, com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.X(aVar3), com.google.android.libraries.navigation.internal.ms.bk.b(com.google.android.libraries.navigation.internal.ms.da.b(new com.google.android.libraries.navigation.internal.ms.by() { // from class: com.google.android.libraries.navigation.internal.xe.bz
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar, Context context) {
                com.google.android.libraries.navigation.internal.ms.cc ccVar3 = dk.a;
                return ((Cdo) csVar).p(com.google.android.libraries.navigation.internal.afl.fv.a.UPPER_RIGHT, com.google.android.libraries.navigation.internal.ms.aq.b(context));
            }
        }), new com.google.android.libraries.navigation.internal.mx.m[0]), com.google.android.libraries.navigation.internal.ms.ah.ac(com.google.android.libraries.navigation.internal.ms.bz.m(ccVar), com.google.android.libraries.navigation.internal.ms.bz.h()), com.google.android.libraries.navigation.internal.ms.ah.aA(P)));
        com.google.android.libraries.navigation.internal.nc.ap apVar = S;
        com.google.android.libraries.navigation.internal.nc.ap apVar2 = T;
        com.google.android.libraries.navigation.internal.mx.e eVar8 = new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, new com.google.android.libraries.navigation.internal.mx.aa(b), com.google.android.libraries.navigation.internal.ms.ah.G(new com.google.android.libraries.navigation.internal.ms.dd() { // from class: com.google.android.libraries.navigation.internal.xe.ca
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar) {
                Cdo cdo = (Cdo) csVar;
                com.google.android.libraries.navigation.internal.ms.cc ccVar3 = dk.a;
                boolean z2 = true;
                if (!cdo.q().booleanValue() && !cdo.z()) {
                    z2 = false;
                }
                return Boolean.valueOf(z2);
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.ay(apVar), com.google.android.libraries.navigation.internal.ms.ah.aw(apVar), com.google.android.libraries.navigation.internal.ms.ah.au(apVar2), new com.google.android.libraries.navigation.internal.mx.e(ImageView.class, com.google.android.libraries.navigation.internal.ms.ah.G(new com.google.android.libraries.navigation.internal.ms.dd() { // from class: com.google.android.libraries.navigation.internal.xe.cc
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar) {
                Cdo cdo = (Cdo) csVar;
                com.google.android.libraries.navigation.internal.ms.cc ccVar3 = dk.a;
                boolean z2 = true;
                if (!cdo.q().booleanValue() && !cdo.z()) {
                    z2 = false;
                }
                return Boolean.valueOf(z2);
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.aK(Integer.valueOf(com.google.android.libraries.navigation.internal.f.d.f425n)), com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.T(-2)));
        com.google.android.libraries.navigation.internal.mx.e eVar9 = new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, new com.google.android.libraries.navigation.internal.mx.aa(f648n), com.google.android.libraries.navigation.internal.ms.ah.H(new com.google.android.libraries.navigation.internal.ms.dd() { // from class: com.google.android.libraries.navigation.internal.xe.cd
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar) {
                return ((Cdo) csVar).r();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.ay(apVar), com.google.android.libraries.navigation.internal.ms.ah.aw(apVar), com.google.android.libraries.navigation.internal.ms.ah.au(apVar2), com.google.android.libraries.navigation.internal.ms.ah.v(false), com.google.android.libraries.navigation.internal.ms.ah.x(false), com.google.android.libraries.navigation.internal.ms.ah.d(new com.google.android.libraries.navigation.internal.uv.ao(), new com.google.android.libraries.navigation.internal.ms.dd() { // from class: com.google.android.libraries.navigation.internal.xe.ce
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar) {
                return ((Cdo) csVar).g();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new com.google.android.libraries.navigation.internal.mx.m[0]));
        com.google.android.libraries.navigation.internal.nc.a aVarG = com.google.android.libraries.navigation.internal.nc.a.g(12);
        com.google.android.libraries.navigation.internal.mx.e eVar10 = new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, com.google.android.libraries.navigation.internal.ms.ah.aq(1), com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.ac(com.google.android.libraries.navigation.internal.ms.bz.c(eVar2), com.google.android.libraries.navigation.internal.ms.bz.i()), com.google.android.libraries.navigation.internal.ms.ah.ba(com.google.android.libraries.navigation.internal.ms.da.b(new com.google.android.libraries.navigation.internal.ms.by() { // from class: com.google.android.libraries.navigation.internal.xe.ci
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar, Context context) {
                Cdo cdo = (Cdo) csVar;
                com.google.android.libraries.navigation.internal.ms.cc ccVar3 = dk.a;
                com.google.android.libraries.navigation.internal.nc.ap apVarG = com.google.android.libraries.navigation.internal.nc.a.g(0);
                if (!com.google.android.libraries.navigation.internal.ms.aq.b(context)) {
                    return apVarG;
                }
                if (cdo.n().booleanValue()) {
                    apVarG = com.google.android.libraries.navigation.internal.nc.p.c(apVarG, dk.U);
                }
                return com.google.android.libraries.navigation.internal.nc.p.c(apVarG, new com.google.android.libraries.navigation.internal.nc.a(com.google.android.libraries.navigation.internal.nc.a.c(0, 0, cdo.a())));
            }
        })), eVar9, eVar8, new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.H(new com.google.android.libraries.navigation.internal.ms.dd() { // from class: com.google.android.libraries.navigation.internal.xe.cg
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar) {
                return ((Cdo) csVar).q();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), new com.google.android.libraries.navigation.internal.mx.aa(j), com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.ar(aVarG, aVarG, aVarG, aVarG), new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.p(com.google.android.libraries.navigation.internal.af.e.d(com.google.android.libraries.navigation.internal.nc.j.g(com.google.android.libraries.navigation.internal.f.d.p), com.google.android.libraries.navigation.internal.nc.j.h(com.google.android.libraries.navigation.internal.f.d.p, com.google.android.libraries.navigation.internal.nc.j.f(com.google.android.libraries.navigation.internal.f.b.t)))), new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ch.e(com.google.android.libraries.navigation.internal.ms.e.BACKGROUND_COLOR, Integer.valueOf(R.color.transparent)), new com.google.android.libraries.navigation.internal.mx.e(TextView.class, new com.google.android.libraries.navigation.internal.mx.aa(i), com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.S(v), com.google.android.libraries.navigation.internal.ms.ah.Q(8388691), com.google.android.libraries.navigation.internal.ms.ah.I(16), com.google.android.libraries.navigation.internal.ms.ah.ay(com.google.android.libraries.navigation.internal.nc.a.g(6)), com.google.android.libraries.navigation.internal.ms.ah.aw(com.google.android.libraries.navigation.internal.nc.a.g(14)), com.google.android.libraries.navigation.internal.ms.ch.e(com.google.android.libraries.navigation.internal.ms.e.TEXT, com.google.android.libraries.navigation.internal.nc.j.m(com.google.android.libraries.navigation.internal.dw.h.av)), com.google.android.libraries.navigation.internal.ms.ah.an(new com.google.android.libraries.navigation.internal.ms.o(new com.google.android.libraries.navigation.internal.ms.dd() { // from class: com.google.android.libraries.navigation.internal.xe.ch
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar) {
                ((Cdo) csVar).b();
                return null;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        })), com.google.android.libraries.navigation.internal.ms.ch.e(com.google.android.libraries.navigation.internal.ms.e.DRAWABLE_START, com.google.android.libraries.navigation.internal.nc.j.g(com.google.android.libraries.navigation.internal.dw.c.s)), com.google.android.libraries.navigation.internal.w.e.d(), com.google.android.libraries.navigation.internal.ms.ah.aR(com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.nc.j.f(com.google.android.libraries.navigation.internal.v.a.d), com.google.android.libraries.navigation.internal.w.a.r())), com.google.android.libraries.navigation.internal.ms.ah.p(com.google.android.libraries.navigation.internal.w.d.b()))))), new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, new com.google.android.libraries.navigation.internal.mx.aa(k), com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.T(-2)));
        com.google.android.libraries.navigation.internal.mx.e eVar11 = new com.google.android.libraries.navigation.internal.mx.e(RelativeLayout.class, new com.google.android.libraries.navigation.internal.mx.aa(l), com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.ac(com.google.android.libraries.navigation.internal.ms.bz.c(eVar2), com.google.android.libraries.navigation.internal.ms.bz.h()));
        com.google.android.libraries.navigation.internal.mx.e eVar12 = new com.google.android.libraries.navigation.internal.mx.e(RelativeLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.au(R), com.google.android.libraries.navigation.internal.ms.ah.aw(aVar3), com.google.android.libraries.navigation.internal.ms.ah.ay(aVar3), com.google.android.libraries.navigation.internal.ms.ah.ac(com.google.android.libraries.navigation.internal.ms.bz.c(eVar11), com.google.android.libraries.navigation.internal.ms.bz.h()), com.google.android.libraries.navigation.internal.ms.bk.b(com.google.android.libraries.navigation.internal.ms.da.b(new com.google.android.libraries.navigation.internal.ms.by() { // from class: com.google.android.libraries.navigation.internal.xe.cj
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar, Context context) {
                com.google.android.libraries.navigation.internal.ms.cc ccVar3 = dk.a;
                return ((Cdo) csVar).p(com.google.android.libraries.navigation.internal.afl.fv.a.LOWER_RIGHT, com.google.android.libraries.navigation.internal.ms.aq.b(context));
            }
        }), new com.google.android.libraries.navigation.internal.mx.m[0]), eVar6);
        com.google.android.libraries.navigation.internal.mx.e eVar13 = new com.google.android.libraries.navigation.internal.mx.e(RelativeLayout.class, new com.google.android.libraries.navigation.internal.mx.aa(p), com.google.android.libraries.navigation.internal.ms.ah.H(new com.google.android.libraries.navigation.internal.ms.dd() { // from class: com.google.android.libraries.navigation.internal.xe.ck
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar) {
                return Boolean.valueOf(((Cdo) csVar).z());
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.ac(com.google.android.libraries.navigation.internal.ms.bz.c(eVar11), com.google.android.libraries.navigation.internal.ms.bz.h()), com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.aw(apVar), com.google.android.libraries.navigation.internal.ms.ah.au(apVar2), com.google.android.libraries.navigation.internal.ms.ah.ay(apVar), new com.google.android.libraries.navigation.internal.mx.e(ImageView.class, com.google.android.libraries.navigation.internal.ms.ah.H(new com.google.android.libraries.navigation.internal.ms.dd() { // from class: com.google.android.libraries.navigation.internal.xe.ck
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar) {
                return Boolean.valueOf(((Cdo) csVar).z());
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.aK(Integer.valueOf(com.google.android.libraries.navigation.internal.f.d.f425n)), com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.T(-2)));
        com.google.android.libraries.navigation.internal.mx.e eVar14 = new com.google.android.libraries.navigation.internal.mx.e(RelativeLayout.class, new com.google.android.libraries.navigation.internal.mx.aa(g), com.google.android.libraries.navigation.internal.ms.ah.H(new com.google.android.libraries.navigation.internal.ms.dd() { // from class: com.google.android.libraries.navigation.internal.xe.cl
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar) {
                return ((Cdo) csVar).s();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.ac(com.google.android.libraries.navigation.internal.ms.bz.g()), com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2));
        com.google.android.libraries.navigation.internal.mx.e eVar15 = new com.google.android.libraries.navigation.internal.mx.e(RelativeLayout.class, new com.google.android.libraries.navigation.internal.mx.aa(h), com.google.android.libraries.navigation.internal.ms.bk.b(new com.google.android.libraries.navigation.internal.ms.dd() { // from class: com.google.android.libraries.navigation.internal.xe.cn
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar) {
                return ((Cdo) csVar).t();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new com.google.android.libraries.navigation.internal.mx.m[0]), com.google.android.libraries.navigation.internal.ms.ah.ac(com.google.android.libraries.navigation.internal.ms.bz.n(eVar), com.google.android.libraries.navigation.internal.ms.bz.g(), com.google.android.libraries.navigation.internal.ms.bz.h()), com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.Q(8388693), com.google.android.libraries.navigation.internal.ms.ah.I(16), com.google.android.libraries.navigation.internal.ms.ah.at(com.google.android.libraries.navigation.internal.ms.da.b(new com.google.android.libraries.navigation.internal.ms.by() { // from class: com.google.android.libraries.navigation.internal.xe.co
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar, Context context) {
                return Integer.valueOf(com.google.android.libraries.navigation.internal.nc.j.k(dk.c(context) ? com.google.android.libraries.navigation.internal.dw.b.c : com.google.android.libraries.navigation.internal.dw.b.b).e(context));
            }
        })), com.google.android.libraries.navigation.internal.ms.ah.c(new gu(), new com.google.android.libraries.navigation.internal.ms.dd() { // from class: com.google.android.libraries.navigation.internal.xe.cp
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar) {
                return ((Cdo) csVar).i();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new com.google.android.libraries.navigation.internal.mx.m[0]));
        com.google.android.libraries.navigation.internal.mx.e eVar16 = new com.google.android.libraries.navigation.internal.mx.e(RelativeLayout.class, eVar7, eVar2, eVar13, eVar12, eVar10, eVar11, com.google.android.libraries.navigation.internal.ms.ch.b(new com.google.android.libraries.navigation.internal.ms.by() { // from class: com.google.android.libraries.navigation.internal.xe.cq
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar, Context context) {
                Cdo cdo = (Cdo) csVar;
                boolean z2 = false;
                if (dk.h(cdo, context) && cdo.o().booleanValue()) {
                    z2 = true;
                }
                return Boolean.valueOf(z2);
            }
        }, com.google.android.libraries.navigation.internal.ms.ah.ac(com.google.android.libraries.navigation.internal.ms.bz.n(eVar)), com.google.android.libraries.navigation.internal.ms.ah.ac(com.google.android.libraries.navigation.internal.ms.bz.j())), com.google.android.libraries.navigation.internal.ms.ch.b(new com.google.android.libraries.navigation.internal.ms.by() { // from class: com.google.android.libraries.navigation.internal.xe.cr
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar, Context context) {
                com.google.android.libraries.navigation.internal.ms.cc ccVar3 = dk.a;
                return Boolean.valueOf(com.google.android.libraries.navigation.internal.ms.aq.b(context));
            }
        }, com.google.android.libraries.navigation.internal.ms.ah.ac(com.google.android.libraries.navigation.internal.ms.bz.g()), com.google.android.libraries.navigation.internal.ms.ah.ac(com.google.android.libraries.navigation.internal.ms.bz.c(eVar5))), com.google.android.libraries.navigation.internal.ms.ah.ax(new com.google.android.libraries.navigation.internal.ms.dd() { // from class: com.google.android.libraries.navigation.internal.xe.cs
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar) {
                return ((Cdo) csVar).x();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.az(new com.google.android.libraries.navigation.internal.ms.dd() { // from class: com.google.android.libraries.navigation.internal.xe.ct
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar) {
                return ((Cdo) csVar).y();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.av(new com.google.android.libraries.navigation.internal.ms.dd() { // from class: com.google.android.libraries.navigation.internal.xe.cu
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar) {
                return ((Cdo) csVar).w();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.at(new com.google.android.libraries.navigation.internal.ms.dd() { // from class: com.google.android.libraries.navigation.internal.xe.cv
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar) {
                return ((Cdo) csVar).v();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }));
        final com.google.android.libraries.navigation.internal.ms.dd ddVarB = com.google.android.libraries.navigation.internal.ms.da.b(new com.google.android.libraries.navigation.internal.ms.by() { // from class: com.google.android.libraries.navigation.internal.xe.cz
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar, Context context) {
                com.google.android.libraries.navigation.internal.ms.cc ccVar3 = dk.a;
                return ((Cdo) csVar).p(com.google.android.libraries.navigation.internal.afl.fv.a.UPPER_LEFT_ABSOLUTE_POSITION, com.google.android.libraries.navigation.internal.ms.aq.b(context));
            }
        });
        final com.google.android.libraries.navigation.internal.ms.dd ddVarB2 = com.google.android.libraries.navigation.internal.ms.da.b(new com.google.android.libraries.navigation.internal.ms.by() { // from class: com.google.android.libraries.navigation.internal.xe.da
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar, Context context) {
                com.google.android.libraries.navigation.internal.ms.cc ccVar3 = dk.a;
                return ((Cdo) csVar).p(com.google.android.libraries.navigation.internal.afl.fv.a.UPPER_LEFT_ABSOLUTE_POSITION_PRE_ADAPTIVE_TURN_CARDS, com.google.android.libraries.navigation.internal.ms.aq.b(context));
            }
        });
        final com.google.android.libraries.navigation.internal.ms.dd ddVarB3 = com.google.android.libraries.navigation.internal.ms.da.b(new com.google.android.libraries.navigation.internal.ms.by() { // from class: com.google.android.libraries.navigation.internal.xe.db
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar, Context context) {
                com.google.android.libraries.navigation.internal.ms.cc ccVar3 = dk.a;
                return ((Cdo) csVar).p(com.google.android.libraries.navigation.internal.afl.fv.a.UPPER_RIGHT_ABSOLUTE_POSITION, com.google.android.libraries.navigation.internal.ms.aq.b(context));
            }
        });
        return new com.google.android.libraries.navigation.internal.mx.e(RelativeLayout.class, eVar, new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, new com.google.android.libraries.navigation.internal.mx.aa(ccVar2), com.google.android.libraries.navigation.internal.ms.bk.b(new com.google.android.libraries.navigation.internal.ms.dd() { // from class: com.google.android.libraries.navigation.internal.xe.dc
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar) {
                Cdo cdo = (Cdo) csVar;
                com.google.android.libraries.navigation.internal.ms.cc ccVar3 = dk.a;
                boolean z2 = true;
                if (!((Boolean) ddVarB.a(cdo)).booleanValue() && !((Boolean) ddVarB3.a(cdo)).booleanValue() && !((Boolean) ddVarB2.a(cdo)).booleanValue()) {
                    z2 = false;
                }
                return Boolean.valueOf(z2);
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new com.google.android.libraries.navigation.internal.mx.m[0]), com.google.android.libraries.navigation.internal.ms.ah.ac(com.google.android.libraries.navigation.internal.ms.bz.j()), com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.T(-2), new com.google.android.libraries.navigation.internal.mx.r(ddVarB2, com.google.android.libraries.navigation.internal.ms.ah.ab(O), com.google.android.libraries.navigation.internal.ms.ah.ab(N)), new com.google.android.libraries.navigation.internal.mx.r(ddVarB, com.google.android.libraries.navigation.internal.ms.ah.Z(aVar2), com.google.android.libraries.navigation.internal.ms.ah.Z(com.google.android.libraries.navigation.internal.nc.a.g(0))), new com.google.android.libraries.navigation.internal.mx.r(ddVarB3, com.google.android.libraries.navigation.internal.ms.ah.X(aVar3), com.google.android.libraries.navigation.internal.ms.ah.X(com.google.android.libraries.navigation.internal.nc.a.g(0))), new com.google.android.libraries.navigation.internal.mx.r(ddVarB2, com.google.android.libraries.navigation.internal.ms.ah.Z(u), new com.google.android.libraries.navigation.internal.mx.r(ddVarB, com.google.android.libraries.navigation.internal.ms.ah.Z(aVar2), com.google.android.libraries.navigation.internal.ms.ah.Z(com.google.android.libraries.navigation.internal.nc.a.g(0)))), new com.google.android.libraries.navigation.internal.mx.r(new com.google.android.libraries.navigation.internal.ms.dd() { // from class: com.google.android.libraries.navigation.internal.xe.dd
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(com.google.android.libraries.navigation.internal.ms.cs csVar) {
                Cdo cdo = (Cdo) csVar;
                com.google.android.libraries.navigation.internal.ms.cc ccVar3 = dk.a;
                boolean z2 = true;
                if (!((Boolean) ddVarB.a(cdo)).booleanValue() && !((Boolean) ddVarB2.a(cdo)).booleanValue()) {
                    z2 = false;
                }
                return Boolean.valueOf(z2);
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, com.google.android.libraries.navigation.internal.ms.ah.ac(com.google.android.libraries.navigation.internal.ms.bz.i()), com.google.android.libraries.navigation.internal.ms.ah.ac(com.google.android.libraries.navigation.internal.ms.bz.h())), eVar6), eVar16, eVar5, eVar3, eVar4, eVar15, eVar14);
    }
}

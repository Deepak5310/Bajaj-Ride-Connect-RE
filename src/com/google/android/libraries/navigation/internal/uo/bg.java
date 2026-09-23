package com.google.android.libraries.navigation.internal.uo;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.drew.metadata.exif.ExifDirectoryBase;
import com.google.android.apps.gmm.base.views.squeezedlabel.SqueezedLabelView;
import com.google.android.libraries.geo.navcore.ui.header.views.ManeuverImageView;
import com.google.android.libraries.geo.navcore.ui.header.views.MultiIconView;
import com.google.android.libraries.geo.navcore.ui.header.views.NextTurnTextView;
import com.google.android.libraries.geo.navcore.ui.header.views.StepCueView;
import com.google.android.libraries.navigation.internal.ms.bk;
import com.google.android.libraries.navigation.internal.ms.bt;
import com.google.android.libraries.navigation.internal.ms.by;
import com.google.android.libraries.navigation.internal.ms.bz;
import com.google.android.libraries.navigation.internal.ms.cc;
import com.google.android.libraries.navigation.internal.ms.ch;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.ms.da;
import com.google.android.libraries.navigation.internal.ms.dd;
import com.google.android.libraries.navigation.internal.nc.bh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bg extends bt<com.google.android.libraries.navigation.internal.uk.a> implements com.google.android.libraries.navigation.internal.yt.e {
    private static final dd A;
    private static final com.google.android.libraries.geo.navcore.ui.header.views.m B;
    private static final dd C;
    private static final dd D;
    private static final dd E;
    private static final dd F;
    private static final dd G;
    private static final dd H;
    private static final dd I;
    private static final dd J;
    private static final dd K;
    private static final dd L;
    private static final dd M;
    private static final dd N;
    private static final dd O;
    private static final dd P;
    private static final dd Q;
    private static final dd R;
    private static final dd S;
    static final com.google.android.libraries.navigation.internal.nc.ap b;
    public static final com.google.android.libraries.navigation.internal.nc.ap c;
    public static final com.google.android.libraries.navigation.internal.nc.a d;
    public static final com.google.android.libraries.navigation.internal.nc.a f;
    public static final bh g;
    public static final com.google.android.libraries.navigation.internal.nc.x h;
    public static final com.google.android.libraries.navigation.internal.nc.ap i;
    public static final com.google.android.libraries.navigation.internal.nc.ap j;
    public static final com.google.android.libraries.navigation.internal.nc.ap k;
    public static final Typeface l;
    public static final dd m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final dd f620n;
    public static final com.google.android.libraries.navigation.internal.aj.c o;
    public static final dd p;
    private static final com.google.android.libraries.navigation.internal.nc.a r;
    private static final cc s;
    private static final cc t;
    private static final com.google.android.libraries.navigation.internal.aj.b u;
    private static final dd v;
    private static final dd w;
    private static final dd x;
    private static final dd y;
    private static final dd z;
    private static final com.google.android.libraries.navigation.internal.xn.a q = com.google.android.libraries.navigation.internal.xn.a.d("QuantumNavigationHeaderStepLayout");
    public static final com.google.android.libraries.navigation.internal.nc.ap a = com.google.android.libraries.navigation.internal.nc.a.g(88);

    static {
        com.google.android.libraries.navigation.internal.nc.a aVarG = com.google.android.libraries.navigation.internal.nc.a.g(96);
        b = aVarG;
        c = com.google.android.libraries.navigation.internal.nc.p.c(aVarG, com.google.android.libraries.navigation.internal.nc.a.g(48));
        d = com.google.android.libraries.navigation.internal.nc.a.g(30);
        f = com.google.android.libraries.navigation.internal.nc.a.g(28);
        r = com.google.android.libraries.navigation.internal.nc.a.g(16);
        g = com.google.android.libraries.navigation.internal.dv.a.a;
        h = com.google.android.libraries.navigation.internal.w.a.r();
        i = com.google.android.libraries.navigation.internal.nc.a.i(16);
        j = com.google.android.libraries.navigation.internal.nc.a.g(24);
        k = com.google.android.libraries.navigation.internal.nc.a.g(28);
        l = com.google.android.libraries.navigation.internal.ms.ad.e;
        s = new cc();
        t = new cc();
        m = da.b(new by() { // from class: com.google.android.libraries.navigation.internal.uo.bb
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                return Boolean.valueOf(bg.i(context));
            }
        });
        f620n = da.b(new by() { // from class: com.google.android.libraries.navigation.internal.uo.s
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                com.google.android.libraries.navigation.internal.nc.ap apVar = bg.a;
                boolean z2 = true;
                if (!com.google.android.libraries.navigation.internal.ms.aq.b(context) && (!com.google.android.libraries.navigation.internal.nu.a.b(context) || !com.google.android.libraries.navigation.internal.nu.a.c(context))) {
                    z2 = false;
                }
                return Boolean.valueOf(z2);
            }
        });
        o = com.google.android.libraries.navigation.internal.aj.c.a;
        com.google.android.libraries.navigation.internal.aj.b bVar = new com.google.android.libraries.navigation.internal.aj.b();
        bVar.i = com.google.android.libraries.navigation.internal.k.a.a;
        bVar.j = ExifDirectoryBase.TAG_SUB_IFD_OFFSET;
        bVar.k = 500;
        u = bVar;
        v = da.b(new by() { // from class: com.google.android.libraries.navigation.internal.uo.aa
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                com.google.android.libraries.navigation.internal.uk.a aVar = (com.google.android.libraries.navigation.internal.uk.a) csVar;
                int iB = aVar.b(48, false, ((Boolean) bg.f620n.a(aVar)).booleanValue());
                if (!aVar.q().booleanValue()) {
                    return bg.o;
                }
                com.google.android.libraries.navigation.internal.uk.a aVarK = aVar.k();
                if (aVarK == null) {
                    return bg.c(iB);
                }
                if (aVar.t().equals(aVarK.t())) {
                    return bg.o;
                }
                return aVar.t().booleanValue() ? bg.c(iB) : bg.h(iB);
            }
        });
        w = new dd() { // from class: com.google.android.libraries.navigation.internal.uo.ab
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.uk.a aVar = (com.google.android.libraries.navigation.internal.uk.a) csVar;
                com.google.android.libraries.navigation.internal.nc.ap apVar = bg.a;
                com.google.android.libraries.navigation.internal.uk.a aVarK = aVar.k();
                boolean z2 = true;
                if (!aVar.t().booleanValue() && (aVarK == null || !aVarK.t().booleanValue())) {
                    z2 = false;
                }
                return Boolean.valueOf(z2);
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        };
        x = new dd() { // from class: com.google.android.libraries.navigation.internal.uo.ac
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.uk.a aVarK;
                com.google.android.libraries.navigation.internal.uk.a aVar = (com.google.android.libraries.navigation.internal.uk.a) csVar;
                com.google.android.libraries.navigation.internal.nc.ap apVar = bg.a;
                return (aVar.t().booleanValue() || (aVarK = aVar.k()) == null || !aVarK.t().booleanValue()) ? aVar.l() : aVarK.l();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        };
        y = new dd() { // from class: com.google.android.libraries.navigation.internal.uo.ad
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.uk.a aVar = (com.google.android.libraries.navigation.internal.uk.a) csVar;
                com.google.android.libraries.navigation.internal.nc.ap apVar = bg.a;
                com.google.android.libraries.navigation.internal.uk.a aVarK = aVar.k();
                boolean z2 = true;
                if (!aVar.u().booleanValue() && (aVarK == null || !aVarK.u().booleanValue())) {
                    z2 = false;
                }
                return Boolean.valueOf(z2);
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        };
        z = new dd() { // from class: com.google.android.libraries.navigation.internal.uo.ae
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.uk.a aVarK;
                com.google.android.libraries.navigation.internal.uk.a aVar = (com.google.android.libraries.navigation.internal.uk.a) csVar;
                com.google.android.libraries.navigation.internal.nc.ap apVar = bg.a;
                return (aVar.u().booleanValue() || (aVarK = aVar.k()) == null || !aVarK.u().booleanValue()) ? aVar.e() : aVarK.e();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        };
        A = new dd() { // from class: com.google.android.libraries.navigation.internal.uo.af
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.uk.a aVar = (com.google.android.libraries.navigation.internal.uk.a) csVar;
                com.google.android.libraries.navigation.internal.nc.ap apVar = bg.a;
                int iB = aVar.b(48, false, true);
                if (!aVar.q().booleanValue()) {
                    return bg.o;
                }
                com.google.android.libraries.navigation.internal.uk.a aVarK = aVar.k();
                if (aVarK == null) {
                    return bg.c(iB);
                }
                if (aVar.u().equals(aVarK.u())) {
                    return bg.o;
                }
                return aVar.u().booleanValue() ? bg.c(iB) : bg.h(iB);
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        };
        com.google.android.libraries.navigation.internal.nc.a aVar = com.google.android.libraries.navigation.internal.vb.h.a;
        B = new com.google.android.libraries.geo.navcore.ui.header.views.m(com.google.android.libraries.navigation.internal.vb.h.a, com.google.android.libraries.navigation.internal.vb.h.b, com.google.android.libraries.navigation.internal.vb.h.c, com.google.android.libraries.navigation.internal.vb.h.d, com.google.android.libraries.navigation.internal.vb.h.e, com.google.android.libraries.navigation.internal.ms.ad.e, com.google.android.libraries.navigation.internal.nc.a.g(0));
        p = new dd() { // from class: com.google.android.libraries.navigation.internal.uo.ag
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.uk.a aVar2 = (com.google.android.libraries.navigation.internal.uk.a) csVar;
                com.google.android.libraries.navigation.internal.nc.ap apVar = bg.a;
                boolean z2 = false;
                if (!aVar2.v().booleanValue() && (aVar2.o().booleanValue() || aVar2.p().booleanValue())) {
                    z2 = true;
                }
                return Boolean.valueOf(z2);
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        };
        C = new dd() { // from class: com.google.android.libraries.navigation.internal.uo.ai
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.uk.a aVar2 = (com.google.android.libraries.navigation.internal.uk.a) csVar;
                com.google.android.libraries.navigation.internal.nc.ap apVar = bg.a;
                return aVar2.h().a(true, false, aVar2.q().booleanValue(), aVar2.w().booleanValue());
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        };
        D = da.b(new by() { // from class: com.google.android.libraries.navigation.internal.uo.bc
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                com.google.android.libraries.navigation.internal.uk.a aVar2 = (com.google.android.libraries.navigation.internal.uk.a) csVar;
                return aVar2.h().a(false, ((Boolean) bg.f620n.a(aVar2)).booleanValue(), aVar2.q().booleanValue(), aVar2.w().booleanValue());
            }
        });
        E = da.b(new by() { // from class: com.google.android.libraries.navigation.internal.uo.bd
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                com.google.android.libraries.navigation.internal.uk.a aVar2 = (com.google.android.libraries.navigation.internal.uk.a) csVar;
                return Integer.valueOf((int) ((aVar2.h().b(((Boolean) bg.f620n.a(aVar2)).booleanValue(), aVar2.q().booleanValue(), aVar2.w().booleanValue()) + 48) * context.getResources().getDisplayMetrics().density));
            }
        });
        F = new dd() { // from class: com.google.android.libraries.navigation.internal.uo.be
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.uk.a aVar2 = (com.google.android.libraries.navigation.internal.uk.a) csVar;
                com.google.android.libraries.navigation.internal.nc.ap apVar = bg.a;
                return aVar2.h().a(false, true, aVar2.q().booleanValue(), aVar2.w().booleanValue());
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        };
        G = da.b(new by() { // from class: com.google.android.libraries.navigation.internal.uo.bf
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                com.google.android.libraries.navigation.internal.uk.a aVar2 = (com.google.android.libraries.navigation.internal.uk.a) csVar;
                return Integer.valueOf((int) ((aVar2.h().b(true, aVar2.q().booleanValue(), aVar2.w().booleanValue()) + 48) * context.getResources().getDisplayMetrics().density));
            }
        });
        H = new dd() { // from class: com.google.android.libraries.navigation.internal.uo.m
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.uk.a aVar2 = (com.google.android.libraries.navigation.internal.uk.a) csVar;
                com.google.android.libraries.navigation.internal.nc.ap apVar = bg.a;
                return aVar2.i().a(aVar2.q().booleanValue());
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        };
        I = new dd() { // from class: com.google.android.libraries.navigation.internal.uo.n
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.uk.a aVar2 = (com.google.android.libraries.navigation.internal.uk.a) csVar;
                com.google.android.libraries.navigation.internal.nc.ap apVar = bg.a;
                return aVar2.i().b(aVar2.q().booleanValue());
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        };
        J = new dd() { // from class: com.google.android.libraries.navigation.internal.uo.o
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.uk.a aVar2 = (com.google.android.libraries.navigation.internal.uk.a) csVar;
                com.google.android.libraries.navigation.internal.nc.ap apVar = bg.a;
                com.google.android.libraries.navigation.internal.uk.a.d dVarJ = aVar2.j();
                aVar2.q().booleanValue();
                bh bhVarL = dVarJ.l();
                return bhVarL == null ? bg.g : bhVarL;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        };
        K = new dd() { // from class: com.google.android.libraries.navigation.internal.uo.p
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.uk.a aVar2 = (com.google.android.libraries.navigation.internal.uk.a) csVar;
                com.google.android.libraries.navigation.internal.nc.ap apVar = bg.a;
                com.google.android.libraries.navigation.internal.nc.x xVarD = aVar2.j().d(aVar2.q().booleanValue());
                return xVarD == null ? bg.h : xVarD;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        };
        L = new dd() { // from class: com.google.android.libraries.navigation.internal.uo.q
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.uk.a aVar2 = (com.google.android.libraries.navigation.internal.uk.a) csVar;
                com.google.android.libraries.navigation.internal.nc.ap apVar = bg.a;
                com.google.android.libraries.navigation.internal.uk.a.d dVarJ = aVar2.j();
                aVar2.q().booleanValue();
                com.google.android.libraries.navigation.internal.nc.a aVarK = dVarJ.k();
                return aVarK == null ? bg.i : aVarK;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        };
        M = new dd() { // from class: com.google.android.libraries.navigation.internal.uo.r
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.uk.a aVar2 = (com.google.android.libraries.navigation.internal.uk.a) csVar;
                com.google.android.libraries.navigation.internal.nc.ap apVar = bg.a;
                com.google.android.libraries.navigation.internal.uk.a.d dVarJ = aVar2.j();
                aVar2.q().booleanValue();
                bh bhVarE = dVarJ.e();
                return bhVarE == null ? new com.google.android.libraries.navigation.internal.nc.bg(null) : bhVarE;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        };
        N = new dd() { // from class: com.google.android.libraries.navigation.internal.uo.t
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.uk.a aVar2 = (com.google.android.libraries.navigation.internal.uk.a) csVar;
                com.google.android.libraries.navigation.internal.nc.ap apVar = bg.a;
                com.google.android.libraries.navigation.internal.uk.a.d dVarJ = aVar2.j();
                aVar2.q().booleanValue();
                com.google.android.libraries.navigation.internal.nc.a aVarG2 = dVarJ.g();
                return aVarG2 == null ? bg.j : aVarG2;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        };
        O = da.b(new by() { // from class: com.google.android.libraries.navigation.internal.uo.u
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                com.google.android.libraries.navigation.internal.uk.a aVar2 = (com.google.android.libraries.navigation.internal.uk.a) csVar;
                com.google.android.libraries.navigation.internal.nc.ap apVar = bg.a;
                com.google.android.libraries.navigation.internal.uk.a.d dVarJ = aVar2.j();
                aVar2.q().booleanValue();
                com.google.android.libraries.navigation.internal.nc.a aVarG2 = dVarJ.g();
                return aVarG2 != null ? com.google.android.libraries.navigation.internal.nc.a.f((aVarG2.a(context) / context.getResources().getDisplayMetrics().density) * (bg.k.a(context) / bg.k.a(context))) : bg.k;
            }
        });
        P = da.b(new by() { // from class: com.google.android.libraries.navigation.internal.uo.v
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                com.google.android.libraries.navigation.internal.uk.a aVar2 = (com.google.android.libraries.navigation.internal.uk.a) csVar;
                com.google.android.libraries.navigation.internal.nc.ap apVar = bg.a;
                com.google.android.libraries.navigation.internal.uk.a.d dVarJ = aVar2.j();
                aVar2.q().booleanValue();
                bh bhVarJ = dVarJ.j();
                Typeface typeface = bhVarJ != null ? ((com.google.android.libraries.navigation.internal.nc.bg) bhVarJ).a : null;
                return typeface == null ? bg.l : typeface;
            }
        });
        Q = new dd() { // from class: com.google.android.libraries.navigation.internal.uo.x
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.uk.a aVar2 = (com.google.android.libraries.navigation.internal.uk.a) csVar;
                com.google.android.libraries.navigation.internal.nc.ap apVar = bg.a;
                return aVar2.j().c(aVar2.q().booleanValue());
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        };
        R = new dd() { // from class: com.google.android.libraries.navigation.internal.uo.y
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.uk.a aVar2 = (com.google.android.libraries.navigation.internal.uk.a) csVar;
                com.google.android.libraries.navigation.internal.nc.ap apVar = bg.a;
                com.google.android.libraries.navigation.internal.uk.a.d dVarJ = aVar2.j();
                aVar2.q().booleanValue();
                bh bhVarJ = dVarJ.j();
                return bhVarJ == null ? new com.google.android.libraries.navigation.internal.nc.bg(null) : bhVarJ;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        };
        S = new dd() { // from class: com.google.android.libraries.navigation.internal.uo.z
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.uk.a aVar2 = (com.google.android.libraries.navigation.internal.uk.a) csVar;
                com.google.android.libraries.navigation.internal.nc.ap apVar = bg.a;
                com.google.android.libraries.navigation.internal.nc.x xVarC = aVar2.j().c(aVar2.q().booleanValue());
                return xVarC == null ? com.google.android.libraries.navigation.internal.w.a.r() : xVarC;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        };
    }

    public static com.google.android.libraries.navigation.internal.aj.c c(int i2) {
        com.google.android.libraries.navigation.internal.aj.b bVar = u;
        bVar.a(com.google.android.libraries.navigation.internal.nc.a.g(-i2), com.google.android.libraries.navigation.internal.nc.a.g(0));
        return new com.google.android.libraries.navigation.internal.aj.c(bVar);
    }

    public static com.google.android.libraries.navigation.internal.aj.c h(int i2) {
        com.google.android.libraries.navigation.internal.aj.b bVar = u;
        bVar.a(com.google.android.libraries.navigation.internal.nc.a.g(0), com.google.android.libraries.navigation.internal.nc.a.g(-i2));
        return new com.google.android.libraries.navigation.internal.aj.c(bVar);
    }

    public static boolean i(Context context) {
        if (com.google.android.libraries.navigation.internal.ms.aq.c(context)) {
            return true;
        }
        return com.google.android.libraries.navigation.internal.nu.a.b(context) && com.google.android.libraries.navigation.internal.nu.a.c(context);
    }

    @SafeVarargs
    private static com.google.android.libraries.navigation.internal.mx.g j(com.google.android.libraries.navigation.internal.mx.m... mVarArr) {
        com.google.android.libraries.navigation.internal.mx.e eVar = new com.google.android.libraries.navigation.internal.mx.e(View.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.S(com.google.android.libraries.navigation.internal.nc.a.g(3)), com.google.android.libraries.navigation.internal.ms.ah.q(Integer.valueOf(com.google.android.libraries.navigation.internal.dw.c.x)));
        eVar.e(mVarArr);
        return eVar;
    }

    private static final com.google.android.libraries.navigation.internal.mx.k k() {
        return new com.google.android.libraries.navigation.internal.mx.k(new com.google.android.libraries.navigation.internal.mx.m[]{com.google.android.libraries.navigation.internal.ms.ah.aP(Integer.valueOf(com.google.android.libraries.navigation.internal.f.i.a)), com.google.android.libraries.navigation.internal.ms.ah.aR(com.google.android.libraries.navigation.internal.w.a.r())});
    }

    @Override // com.google.android.libraries.navigation.internal.ms.bt
    protected final com.google.android.libraries.navigation.internal.mx.g a() {
        bz[] bzVarArr = {bz.i()};
        dd ddVar = p;
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr = {com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.am(com.google.android.libraries.navigation.internal.nc.a.g(88)), com.google.android.libraries.navigation.internal.ms.ah.R(new dd() { // from class: com.google.android.libraries.navigation.internal.uo.aj
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((Boolean) bg.m.a((com.google.android.libraries.navigation.internal.uk.a) csVar)).booleanValue() ? bg.a : bg.b;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.ac(bzVarArr), com.google.android.libraries.navigation.internal.ab.d.b(com.google.android.libraries.navigation.internal.afe.i.S), com.google.android.libraries.navigation.internal.ms.ah.an(new com.google.android.libraries.navigation.internal.ms.o(new dd() { // from class: com.google.android.libraries.navigation.internal.uo.ak
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.uk.a) csVar).g();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        })), com.google.android.libraries.navigation.internal.ms.ah.L(4), com.google.android.libraries.navigation.internal.ms.ah.H(ddVar)};
        dd ddVar2 = C;
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr2 = {com.google.android.libraries.navigation.internal.z.c.b(), com.google.android.libraries.navigation.internal.ms.ah.H(new dd() { // from class: com.google.android.libraries.navigation.internal.uo.l
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.uk.a) csVar).p();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), ManeuverImageView.a(new dd() { // from class: com.google.android.libraries.navigation.internal.uo.w
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.uk.a) csVar).d();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), ManeuverImageView.b(H), com.google.android.libraries.navigation.internal.ms.ah.L(2)};
        dd ddVar3 = m;
        com.google.android.libraries.navigation.internal.mx.e eVar = new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, com.google.android.libraries.navigation.internal.ms.ah.aq(1), com.google.android.libraries.navigation.internal.ms.ah.I(17), com.google.android.libraries.navigation.internal.ms.ah.ay(com.google.android.libraries.navigation.internal.nc.a.g(8)), com.google.android.libraries.navigation.internal.ms.ah.aw(com.google.android.libraries.navigation.internal.nc.a.g(8)), com.google.android.libraries.navigation.internal.ms.ah.o(ddVar2), new com.google.android.libraries.navigation.internal.mx.e(ManeuverImageView.class, mVarArr2), new com.google.android.libraries.navigation.internal.mx.e(SqueezedLabelView.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.aM(new dd() { // from class: com.google.android.libraries.navigation.internal.uo.ah
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.uk.a) csVar).y();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), k(), com.google.android.libraries.navigation.internal.ms.ah.L(2), com.google.android.libraries.navigation.internal.ms.ah.E(true), com.google.android.libraries.navigation.internal.ms.ah.H(new dd() { // from class: com.google.android.libraries.navigation.internal.uo.as
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.uk.a) csVar).o();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.aW(M), new com.google.android.libraries.navigation.internal.mx.r(ddVar3, SqueezedLabelView.a(N), SqueezedLabelView.a(O)), com.google.android.libraries.navigation.internal.ms.ah.aj(1), com.google.android.libraries.navigation.internal.ms.ah.M(false), com.google.android.libraries.navigation.internal.ms.ah.aa(new dd() { // from class: com.google.android.libraries.navigation.internal.uo.ba
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return com.google.android.libraries.navigation.internal.nc.a.g(((Boolean) bg.m.a((com.google.android.libraries.navigation.internal.uk.a) csVar)).booleanValue() ? 0 : 4);
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        })));
        eVar.e(mVarArr);
        bz[] bzVarArr2 = {bz.h(), bz.s(eVar)};
        dd ddVar4 = new dd() { // from class: com.google.android.libraries.navigation.internal.uo.ar
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.uk.a) csVar).m();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        };
        com.google.android.libraries.geo.navcore.ui.header.views.m mVar = B;
        dd ddVar5 = P;
        dd ddVar6 = Q;
        com.google.android.libraries.navigation.internal.mx.e eVar2 = new com.google.android.libraries.navigation.internal.mx.e(StepCueView.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.R(new dd() { // from class: com.google.android.libraries.navigation.internal.uo.ao
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((Boolean) bg.m.a((com.google.android.libraries.navigation.internal.uk.a) csVar)).booleanValue() ? bg.a : bg.c;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.ac(bzVarArr2), ch.e(com.google.android.libraries.navigation.internal.ms.e.ALIGN_WITH_PARENT_IF_MISSING, true), com.google.android.libraries.navigation.internal.ms.ah.I(8388627), com.google.android.libraries.navigation.internal.ms.ah.L(4), com.google.android.libraries.navigation.internal.ms.ah.ax(new dd() { // from class: com.google.android.libraries.navigation.internal.uo.ap
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.uk.a aVar = (com.google.android.libraries.navigation.internal.uk.a) csVar;
                return com.google.android.libraries.navigation.internal.nc.a.g((((Boolean) bg.m.a(aVar)).booleanValue() && ((Boolean) bg.p.a(aVar)).booleanValue()) ? 0 : 10);
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.aw(com.google.android.libraries.navigation.internal.nc.a.g(15)), com.google.android.libraries.navigation.internal.ms.ah.o(ddVar2), com.google.android.libraries.navigation.internal.ab.d.b(com.google.android.libraries.navigation.internal.afe.i.S), new com.google.android.libraries.navigation.internal.mx.aa(s), com.google.android.libraries.navigation.internal.ms.ah.an(new com.google.android.libraries.navigation.internal.ms.o(new dd() { // from class: com.google.android.libraries.navigation.internal.uo.ak
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.uk.a) csVar).g();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        })), bk.a(new dd() { // from class: com.google.android.libraries.navigation.internal.uo.aq
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.nc.ap apVar = bg.a;
                return ((com.google.android.libraries.navigation.internal.uk.a) csVar).v();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new com.google.android.libraries.navigation.internal.mx.m[0]), new com.google.android.libraries.navigation.internal.mx.ac(com.google.android.libraries.geo.navcore.ui.header.views.b.STEP_CUE, ddVar4, com.google.android.libraries.geo.navcore.ui.header.views.a.a), new com.google.android.libraries.navigation.internal.mx.ac(com.google.android.libraries.geo.navcore.ui.header.views.b.ALLOW_TWO_LINES, ddVar3, com.google.android.libraries.geo.navcore.ui.header.views.a.a), ch.f(com.google.android.libraries.geo.navcore.ui.header.views.b.STEP_CUE_VIEW_STYLE, mVar, com.google.android.libraries.geo.navcore.ui.header.views.a.a), new com.google.android.libraries.navigation.internal.mx.ac(com.google.android.libraries.geo.navcore.ui.header.views.b.TYPEFACE, ddVar5, com.google.android.libraries.geo.navcore.ui.header.views.a.a), new com.google.android.libraries.navigation.internal.mx.ac(com.google.android.libraries.geo.navcore.ui.header.views.b.TEXT_COLOR, ddVar6, com.google.android.libraries.geo.navcore.ui.header.views.a.a), new com.google.android.libraries.navigation.internal.mx.ac(com.google.android.libraries.geo.navcore.ui.header.views.b.STEP_CUE_SECONDARY_TEXT_COLOR, ddVar6, com.google.android.libraries.geo.navcore.ui.header.views.a.a), new com.google.android.libraries.navigation.internal.mx.ac(com.google.android.libraries.geo.navcore.ui.header.views.b.STEP_CUE_FIRST_ROW_TEXT_SIZE, new dd() { // from class: com.google.android.libraries.navigation.internal.uo.at
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.uk.a aVar = (com.google.android.libraries.navigation.internal.uk.a) csVar;
                com.google.android.libraries.navigation.internal.nc.ap apVar = bg.a;
                com.google.android.libraries.navigation.internal.uk.a.d dVarJ = aVar.j();
                aVar.q().booleanValue();
                return dVarJ.h();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, com.google.android.libraries.geo.navcore.ui.header.views.a.a), new com.google.android.libraries.navigation.internal.mx.ac(com.google.android.libraries.geo.navcore.ui.header.views.b.STEP_CUE_SECOND_ROW_TEXT_SIZE, new dd() { // from class: com.google.android.libraries.navigation.internal.uo.au
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.uk.a aVar = (com.google.android.libraries.navigation.internal.uk.a) csVar;
                com.google.android.libraries.navigation.internal.nc.ap apVar = bg.a;
                com.google.android.libraries.navigation.internal.uk.a.d dVarJ = aVar.j();
                aVar.q().booleanValue();
                return dVarJ.i();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, com.google.android.libraries.geo.navcore.ui.header.views.a.a));
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr3 = {com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.R(new dd() { // from class: com.google.android.libraries.navigation.internal.uo.av
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((Boolean) bg.m.a((com.google.android.libraries.navigation.internal.uk.a) csVar)).booleanValue() ? bg.a : bg.c;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.ac(bz.i()), com.google.android.libraries.navigation.internal.ms.ah.I(16), com.google.android.libraries.navigation.internal.ab.d.b(com.google.android.libraries.navigation.internal.afe.i.S), com.google.android.libraries.navigation.internal.ms.ah.an(new com.google.android.libraries.navigation.internal.ms.o(new dd() { // from class: com.google.android.libraries.navigation.internal.uo.ak
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.uk.a) csVar).g();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        })), com.google.android.libraries.navigation.internal.ms.ah.L(4), bk.b(new dd() { // from class: com.google.android.libraries.navigation.internal.uo.al
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.uk.a) csVar).v();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new com.google.android.libraries.navigation.internal.mx.m[0])};
        com.google.android.libraries.navigation.internal.nc.a aVar = r;
        dd ddVar7 = R;
        dd ddVar8 = S;
        com.google.android.libraries.navigation.internal.mx.e eVar3 = new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ay(com.google.android.libraries.navigation.internal.nc.a.g(15)), com.google.android.libraries.navigation.internal.ms.ah.aw(com.google.android.libraries.navigation.internal.nc.a.g(15)), com.google.android.libraries.navigation.internal.ms.ah.o(ddVar2), com.google.android.libraries.navigation.internal.ms.ah.I(8388611), com.google.android.libraries.navigation.internal.ms.ah.aq(1), new com.google.android.libraries.navigation.internal.mx.e(SqueezedLabelView.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.T(-2), k(), SqueezedLabelView.b(d), SqueezedLabelView.c(aVar), com.google.android.libraries.navigation.internal.ms.ah.aH(true), com.google.android.libraries.navigation.internal.ms.ah.C(TextUtils.TruncateAt.END), com.google.android.libraries.navigation.internal.ms.ah.aM(new dd() { // from class: com.google.android.libraries.navigation.internal.uo.ax
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.uk.a) csVar).B();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.aW(ddVar7), com.google.android.libraries.navigation.internal.ms.ah.aQ(ddVar8), com.google.android.libraries.navigation.internal.ms.ah.H(ddVar3)), new com.google.android.libraries.navigation.internal.mx.e(SqueezedLabelView.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.T(-2), k(), SqueezedLabelView.a(new dd() { // from class: com.google.android.libraries.navigation.internal.uo.ay
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((Boolean) bg.m.a((com.google.android.libraries.navigation.internal.uk.a) csVar)).booleanValue() ? bg.d : bg.f;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), SqueezedLabelView.c(aVar), com.google.android.libraries.navigation.internal.ms.ah.aH(true), com.google.android.libraries.navigation.internal.ms.ah.C(TextUtils.TruncateAt.END), com.google.android.libraries.navigation.internal.ms.ah.aW(ddVar7), com.google.android.libraries.navigation.internal.ms.ah.aQ(ddVar8), com.google.android.libraries.navigation.internal.ms.ah.aL(new by() { // from class: com.google.android.libraries.navigation.internal.uo.az
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                com.google.android.libraries.navigation.internal.uk.a aVar2 = (com.google.android.libraries.navigation.internal.uk.a) csVar;
                return ((Boolean) bg.m.a(aVar2)).booleanValue() ? aVar2.C() : aVar2.A();
            }
        })));
        eVar3.e(mVarArr3);
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr4 = {com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), new com.google.android.libraries.navigation.internal.mx.aa(t), com.google.android.libraries.navigation.internal.ms.ah.L(4), new com.google.android.libraries.navigation.internal.mx.r(ddVar3, com.google.android.libraries.navigation.internal.ms.ah.ac(bz.n(eVar2), bz.i()), com.google.android.libraries.navigation.internal.ms.ah.ac(bz.n(eVar2), bz.s(eVar))), com.google.android.libraries.navigation.internal.ms.ah.an(new com.google.android.libraries.navigation.internal.ms.o(new dd() { // from class: com.google.android.libraries.navigation.internal.uo.ak
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.uk.a) csVar).g();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }))};
        com.google.android.libraries.navigation.internal.mx.e eVar4 = new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, com.google.android.libraries.navigation.internal.ms.ah.H(w), com.google.android.libraries.navigation.internal.ms.ah.aq(1), new com.google.android.libraries.navigation.internal.mx.e(MultiIconView.class, com.google.android.libraries.navigation.internal.ms.ah.ae(new dd() { // from class: com.google.android.libraries.navigation.internal.uo.aw
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return Integer.valueOf(true != ((Boolean) bg.f620n.a((com.google.android.libraries.navigation.internal.uk.a) csVar)).booleanValue() ? -1 : -2);
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.R(E), com.google.android.libraries.navigation.internal.ms.ah.ay(com.google.android.libraries.navigation.internal.nc.a.g(14)), com.google.android.libraries.navigation.internal.ms.ah.aw(com.google.android.libraries.navigation.internal.nc.a.g(14)), com.google.android.libraries.navigation.internal.ms.ah.o(D), new com.google.android.libraries.navigation.internal.mx.ac(com.google.android.libraries.geo.navcore.ui.header.views.b.MULTI_ICON_VIEW_ICONS, x, com.google.android.libraries.geo.navcore.ui.header.views.a.a)), j(com.google.android.libraries.navigation.internal.ms.ah.G(f620n)), com.google.android.libraries.navigation.internal.aj.c.a(v), com.google.android.libraries.navigation.internal.ms.ah.L(4));
        eVar4.e(mVarArr4);
        com.google.android.libraries.navigation.internal.mx.g gVarJ = j(com.google.android.libraries.navigation.internal.ms.ah.ac(bz.i(), bz.n(eVar), bz.f(eVar)), com.google.android.libraries.navigation.internal.ms.ah.H(ddVar));
        com.google.android.libraries.navigation.internal.mx.e eVar5 = new com.google.android.libraries.navigation.internal.mx.e(View.class, com.google.android.libraries.navigation.internal.ms.ah.af(com.google.android.libraries.navigation.internal.nc.a.g(3)), com.google.android.libraries.navigation.internal.ms.ah.S(com.google.android.libraries.navigation.internal.nc.a.g(51)), com.google.android.libraries.navigation.internal.ms.ah.q(Integer.valueOf(com.google.android.libraries.navigation.internal.dw.c.f415n)), com.google.android.libraries.navigation.internal.ms.ah.ac(bz.n(eVar2), bz.f(eVar)), com.google.android.libraries.navigation.internal.ms.ah.G(new dd() { // from class: com.google.android.libraries.navigation.internal.uo.am
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.uk.a aVar2 = (com.google.android.libraries.navigation.internal.uk.a) csVar;
                boolean z2 = true;
                if (!((Boolean) bg.m.a(aVar2)).booleanValue() && !aVar2.v().booleanValue()) {
                    z2 = false;
                }
                return Boolean.valueOf(z2);
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }));
        com.google.android.libraries.navigation.internal.mx.g gVarJ2 = j(new com.google.android.libraries.navigation.internal.mx.r(ddVar3, com.google.android.libraries.navigation.internal.ms.ah.ac(bz.h(), bz.n(eVar2), bz.l(eVar2)), com.google.android.libraries.navigation.internal.ms.ah.ac(bz.h(), bz.n(eVar2), bz.s(eVar5))), com.google.android.libraries.navigation.internal.ms.ah.G(new dd() { // from class: com.google.android.libraries.navigation.internal.uo.al
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.uk.a) csVar).v();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }));
        com.google.android.libraries.navigation.internal.mx.g gVarJ3 = j(com.google.android.libraries.navigation.internal.ms.ah.ac(bz.n(eVar3), bz.l(eVar3), bz.f(eVar3)), com.google.android.libraries.navigation.internal.ms.ah.H(new dd() { // from class: com.google.android.libraries.navigation.internal.uo.al
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.uk.a) csVar).v();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }));
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr5 = {com.google.android.libraries.navigation.internal.ms.ah.ag(-2), new com.google.android.libraries.navigation.internal.mx.r(ddVar3, com.google.android.libraries.navigation.internal.ms.ah.ac(bz.i(), bz.n(eVar2)), com.google.android.libraries.navigation.internal.ms.ah.ac(bz.s(eVar), bz.n(eVar2)))};
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr6 = {com.google.android.libraries.navigation.internal.ms.ah.aW(J), com.google.android.libraries.navigation.internal.ms.ah.R(G), com.google.android.libraries.navigation.internal.ms.ah.o(F), com.google.android.libraries.navigation.internal.ms.ah.H(y)};
        com.google.android.libraries.geo.navcore.ui.header.views.i iVar = new com.google.android.libraries.geo.navcore.ui.header.views.i();
        int i2 = NextTurnTextView.a;
        com.google.android.libraries.navigation.internal.mx.e eVar6 = new com.google.android.libraries.navigation.internal.mx.e(NextTurnTextView.class, com.google.android.libraries.navigation.internal.ms.ah.I(17), com.google.android.libraries.navigation.internal.ms.ah.ay(com.google.android.libraries.navigation.internal.nc.a.g(10)), com.google.android.libraries.navigation.internal.ms.ah.aw(com.google.android.libraries.navigation.internal.nc.a.g(10)), ManeuverImageView.a(z), com.google.android.libraries.navigation.internal.aj.c.a(A), ManeuverImageView.b(I), com.google.android.libraries.navigation.internal.ms.ah.aQ(K), com.google.android.libraries.navigation.internal.ms.ah.aS(L), ch.f(com.google.android.libraries.geo.navcore.ui.header.views.b.NEXT_TURN_TEXT_VIEW_STYLE, iVar, com.google.android.libraries.geo.navcore.ui.header.views.a.a), com.google.android.libraries.navigation.internal.ms.ah.L(4));
        eVar6.e(mVarArr6);
        eVar6.e(mVarArr5);
        return new com.google.android.libraries.navigation.internal.mx.e(RelativeLayout.class, gVarJ2, eVar5, gVarJ, gVarJ3, eVar4, eVar6, eVar, eVar2, eVar3, com.google.android.libraries.navigation.internal.ms.ah.z(new dd() { // from class: com.google.android.libraries.navigation.internal.uo.an
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.uk.a) csVar).E();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }));
    }

    @Override // com.google.android.libraries.navigation.internal.yt.e
    public final com.google.android.libraries.navigation.internal.xn.a b() {
        return q;
    }
}

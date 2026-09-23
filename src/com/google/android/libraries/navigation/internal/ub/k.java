package com.google.android.libraries.navigation.internal.ub;

import android.content.res.Resources;
import android.graphics.Point;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.jy.t;
import com.google.android.libraries.navigation.internal.oe.an;
import com.google.android.libraries.navigation.internal.oe.r;
import com.google.android.libraries.navigation.internal.pb.x;
import com.google.android.libraries.navigation.internal.pi.p;
import com.google.android.libraries.navigation.internal.pi.s;
import com.google.android.libraries.navigation.internal.uc.o;
import com.google.android.libraries.navigation.internal.uc.q;
import com.google.android.libraries.navigation.internal.xe.bp;
import com.google.android.libraries.navigation.internal.yx.am;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.kc;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.EnumMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class k extends c implements l, p {
    private static final EnumMap v;
    private static final EnumMap w;
    private static final EnumMap x;
    private final x A;
    private boolean B;
    private com.google.android.libraries.navigation.internal.se.b C;
    private com.google.android.libraries.navigation.internal.se.b[] D;
    private bq E;
    private o F;
    private final boolean G;
    private final com.google.android.libraries.navigation.internal.afo.a H;
    private final boolean y;
    private final com.google.android.libraries.navigation.internal.og.n z;

    static {
        EnumMap enumMapG = kc.g(al.class);
        v = enumMapG;
        al alVar = al.DRIVE;
        Float fValueOf = Float.valueOf(50000.0f);
        enumMapG.put(alVar, fValueOf);
        enumMapG.put(al.TAXICAB, fValueOf);
        enumMapG.put(al.TWO_WHEELER, fValueOf);
        enumMapG.put(al.BICYCLE, Float.valueOf(12000.0f));
        enumMapG.put(al.WALK, Float.valueOf(3000.0f));
        EnumMap enumMapG2 = kc.g(al.class);
        w = enumMapG2;
        al alVar2 = al.DRIVE;
        Float fValueOf2 = Float.valueOf(250.0f);
        enumMapG2.put(alVar2, fValueOf2);
        enumMapG2.put(al.TAXICAB, fValueOf2);
        enumMapG2.put(al.TWO_WHEELER, fValueOf2);
        enumMapG2.put(al.BICYCLE, Float.valueOf(100.0f));
        enumMapG2.put(al.WALK, Float.valueOf(50.0f));
        EnumMap enumMapG3 = kc.g(al.class);
        x = enumMapG3;
        al alVar3 = al.DRIVE;
        Float fValueOf3 = Float.valueOf(2500.0f);
        enumMapG3.put(alVar3, fValueOf3);
        enumMapG3.put(al.TAXICAB, fValueOf3);
        enumMapG3.put(al.TWO_WHEELER, fValueOf3);
        enumMapG3.put(al.BICYCLE, Float.valueOf(1000.0f));
        enumMapG3.put(al.WALK, Float.valueOf(500.0f));
    }

    public k(com.google.android.libraries.navigation.internal.uc.f fVar, com.google.android.libraries.navigation.internal.fz.d dVar, t tVar, com.google.android.libraries.navigation.internal.ni.a aVar, Resources resources, com.google.android.libraries.navigation.internal.oa.k kVar, com.google.android.libraries.navigation.internal.og.b bVar, com.google.android.libraries.navigation.internal.p.a aVar2, com.google.android.libraries.navigation.internal.uh.p pVar, com.google.android.libraries.navigation.internal.dq.c cVar, Executor executor, s sVar, com.google.android.libraries.navigation.internal.ue.c cVar2, float f, com.google.android.libraries.navigation.internal.uc.t tVar2, com.google.android.libraries.navigation.internal.afo.a aVar3, com.google.android.libraries.navigation.internal.afo.a aVar4) {
        super(resources, kVar, bVar, ((com.google.android.libraries.navigation.internal.oo.b) aVar4.a()).h(), aVar2, cVar, executor, sVar, cVar2, pVar, fVar, dVar, tVar, com.google.android.libraries.navigation.internal.si.e.GUIDED_NAV, f, new b(), tVar2, aVar3, aVar4);
        this.C = null;
        this.D = new com.google.android.libraries.navigation.internal.se.b[0];
        this.G = true;
        this.y = true;
        if (((com.google.android.libraries.navigation.internal.oo.b) aVar4.a()).s().a()) {
            this.z = new com.google.android.libraries.navigation.internal.og.n(aVar);
            this.A = null;
        } else {
            this.z = null;
            this.A = new x(aVar);
        }
        this.H = aVar4;
    }

    static an z(float f, com.google.android.libraries.navigation.internal.se.b bVar) {
        an anVarD = bVar.d(f);
        return anVarD == null ? bVar.b.y() : anVarD;
    }

    protected void A() {
        ax();
    }

    @Override // com.google.android.libraries.navigation.internal.ub.l
    public final void B() {
        this.f610n = com.google.android.libraries.navigation.internal.uc.g.FREE_MOVEMENT;
        p();
    }

    protected boolean C(r rVar, boolean z) {
        n();
        com.google.android.libraries.navigation.internal.pb.f fVar = new com.google.android.libraries.navigation.internal.pb.f(rVar, this.f.a().c(), ((bp) this.g).e());
        fVar.a = true != z ? -1 : 0;
        fVar.b = a;
        u(fVar);
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.ub.c
    protected com.google.android.libraries.navigation.internal.uc.n e(boolean z) {
        if (this.r == null) {
            return com.google.android.libraries.navigation.internal.uc.n.b;
        }
        Point pointA = this.g.a();
        com.google.android.libraries.navigation.internal.uc.l lVarC = c();
        com.google.android.libraries.navigation.internal.db.r rVar = this.r;
        com.google.android.libraries.navigation.internal.se.b bVar = this.C;
        com.google.android.libraries.navigation.internal.uc.n nVarC = lVarC.c(rVar, bVar != null ? bVar.c : null, bVar, ((bp) this.g).e(), this.s, pointA.x, pointA.y, this.h.getDisplayMetrics().density);
        com.google.android.libraries.navigation.internal.pd.i iVar = ((com.google.android.libraries.navigation.internal.uc.d) nVarC).a;
        iVar.a(this.r.m(), this.r.f());
        this.i.f(iVar, z);
        return nVarC;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0031 A[Catch: all -> 0x0141, TryCatch #0 {all -> 0x0141, blocks: (B:3:0x0006, B:5:0x000b, B:7:0x000f, B:9:0x001e, B:11:0x0021, B:15:0x0031, B:17:0x0037, B:18:0x003c, B:20:0x0040, B:22:0x0050, B:24:0x0058, B:39:0x00b7, B:80:0x0140, B:79:0x013d, B:25:0x0080, B:27:0x0084, B:28:0x0086, B:30:0x0096, B:31:0x009b, B:33:0x009f, B:35:0x00ad, B:41:0x00bc, B:45:0x00d6, B:47:0x00da, B:68:0x0127, B:49:0x00e0, B:51:0x00ee, B:55:0x00fd, B:56:0x0100, B:58:0x010a, B:61:0x0111, B:65:0x0117, B:67:0x011e, B:53:0x00f5, B:34:0x00a7, B:76:0x0138), top: B:88:0x0006, inners: #1, #3 }] */
    /* JADX WARN: Code duplicated, block: B:17:0x0037 A[Catch: all -> 0x0141, TryCatch #0 {all -> 0x0141, blocks: (B:3:0x0006, B:5:0x000b, B:7:0x000f, B:9:0x001e, B:11:0x0021, B:15:0x0031, B:17:0x0037, B:18:0x003c, B:20:0x0040, B:22:0x0050, B:24:0x0058, B:39:0x00b7, B:80:0x0140, B:79:0x013d, B:25:0x0080, B:27:0x0084, B:28:0x0086, B:30:0x0096, B:31:0x009b, B:33:0x009f, B:35:0x00ad, B:41:0x00bc, B:45:0x00d6, B:47:0x00da, B:68:0x0127, B:49:0x00e0, B:51:0x00ee, B:55:0x00fd, B:56:0x0100, B:58:0x010a, B:61:0x0111, B:65:0x0117, B:67:0x011e, B:53:0x00f5, B:34:0x00a7, B:76:0x0138), top: B:88:0x0006, inners: #1, #3 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x0058 A[Catch: all -> 0x0141, TRY_LEAVE, TryCatch #0 {all -> 0x0141, blocks: (B:3:0x0006, B:5:0x000b, B:7:0x000f, B:9:0x001e, B:11:0x0021, B:15:0x0031, B:17:0x0037, B:18:0x003c, B:20:0x0040, B:22:0x0050, B:24:0x0058, B:39:0x00b7, B:80:0x0140, B:79:0x013d, B:25:0x0080, B:27:0x0084, B:28:0x0086, B:30:0x0096, B:31:0x009b, B:33:0x009f, B:35:0x00ad, B:41:0x00bc, B:45:0x00d6, B:47:0x00da, B:68:0x0127, B:49:0x00e0, B:51:0x00ee, B:55:0x00fd, B:56:0x0100, B:58:0x010a, B:61:0x0111, B:65:0x0117, B:67:0x011e, B:53:0x00f5, B:34:0x00a7, B:76:0x0138), top: B:88:0x0006, inners: #1, #3 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0084 A[Catch: all -> 0x0135, TryCatch #1 {all -> 0x0135, blocks: (B:25:0x0080, B:27:0x0084, B:28:0x0086, B:30:0x0096, B:31:0x009b, B:33:0x009f, B:35:0x00ad, B:41:0x00bc, B:45:0x00d6, B:47:0x00da, B:68:0x0127, B:49:0x00e0, B:51:0x00ee, B:55:0x00fd, B:56:0x0100, B:58:0x010a, B:61:0x0111, B:65:0x0117, B:67:0x011e, B:53:0x00f5, B:34:0x00a7), top: B:89:0x0080, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0096 A[Catch: all -> 0x0135, TryCatch #1 {all -> 0x0135, blocks: (B:25:0x0080, B:27:0x0084, B:28:0x0086, B:30:0x0096, B:31:0x009b, B:33:0x009f, B:35:0x00ad, B:41:0x00bc, B:45:0x00d6, B:47:0x00da, B:68:0x0127, B:49:0x00e0, B:51:0x00ee, B:55:0x00fd, B:56:0x0100, B:58:0x010a, B:61:0x0111, B:65:0x0117, B:67:0x011e, B:53:0x00f5, B:34:0x00a7), top: B:89:0x0080, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x009f A[Catch: all -> 0x0135, TryCatch #1 {all -> 0x0135, blocks: (B:25:0x0080, B:27:0x0084, B:28:0x0086, B:30:0x0096, B:31:0x009b, B:33:0x009f, B:35:0x00ad, B:41:0x00bc, B:45:0x00d6, B:47:0x00da, B:68:0x0127, B:49:0x00e0, B:51:0x00ee, B:55:0x00fd, B:56:0x0100, B:58:0x010a, B:61:0x0111, B:65:0x0117, B:67:0x011e, B:53:0x00f5, B:34:0x00a7), top: B:89:0x0080, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00a7 A[Catch: all -> 0x0135, TryCatch #1 {all -> 0x0135, blocks: (B:25:0x0080, B:27:0x0084, B:28:0x0086, B:30:0x0096, B:31:0x009b, B:33:0x009f, B:35:0x00ad, B:41:0x00bc, B:45:0x00d6, B:47:0x00da, B:68:0x0127, B:49:0x00e0, B:51:0x00ee, B:55:0x00fd, B:56:0x0100, B:58:0x010a, B:61:0x0111, B:65:0x0117, B:67:0x011e, B:53:0x00f5, B:34:0x00a7), top: B:89:0x0080, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00b3 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:39:0x00b7 A[Catch: all -> 0x0141, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0141, blocks: (B:3:0x0006, B:5:0x000b, B:7:0x000f, B:9:0x001e, B:11:0x0021, B:15:0x0031, B:17:0x0037, B:18:0x003c, B:20:0x0040, B:22:0x0050, B:24:0x0058, B:39:0x00b7, B:80:0x0140, B:79:0x013d, B:25:0x0080, B:27:0x0084, B:28:0x0086, B:30:0x0096, B:31:0x009b, B:33:0x009f, B:35:0x00ad, B:41:0x00bc, B:45:0x00d6, B:47:0x00da, B:68:0x0127, B:49:0x00e0, B:51:0x00ee, B:55:0x00fd, B:56:0x0100, B:58:0x010a, B:61:0x0111, B:65:0x0117, B:67:0x011e, B:53:0x00f5, B:34:0x00a7, B:76:0x0138), top: B:88:0x0006, inners: #1, #3 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00bc A[Catch: all -> 0x0135, TRY_ENTER, TryCatch #1 {all -> 0x0135, blocks: (B:25:0x0080, B:27:0x0084, B:28:0x0086, B:30:0x0096, B:31:0x009b, B:33:0x009f, B:35:0x00ad, B:41:0x00bc, B:45:0x00d6, B:47:0x00da, B:68:0x0127, B:49:0x00e0, B:51:0x00ee, B:55:0x00fd, B:56:0x0100, B:58:0x010a, B:61:0x0111, B:65:0x0117, B:67:0x011e, B:53:0x00f5, B:34:0x00a7), top: B:89:0x0080, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00d2 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:49:0x00e0 A[Catch: all -> 0x0135, TryCatch #1 {all -> 0x0135, blocks: (B:25:0x0080, B:27:0x0084, B:28:0x0086, B:30:0x0096, B:31:0x009b, B:33:0x009f, B:35:0x00ad, B:41:0x00bc, B:45:0x00d6, B:47:0x00da, B:68:0x0127, B:49:0x00e0, B:51:0x00ee, B:55:0x00fd, B:56:0x0100, B:58:0x010a, B:61:0x0111, B:65:0x0117, B:67:0x011e, B:53:0x00f5, B:34:0x00a7), top: B:89:0x0080, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00ee A[Catch: all -> 0x0135, TryCatch #1 {all -> 0x0135, blocks: (B:25:0x0080, B:27:0x0084, B:28:0x0086, B:30:0x0096, B:31:0x009b, B:33:0x009f, B:35:0x00ad, B:41:0x00bc, B:45:0x00d6, B:47:0x00da, B:68:0x0127, B:49:0x00e0, B:51:0x00ee, B:55:0x00fd, B:56:0x0100, B:58:0x010a, B:61:0x0111, B:65:0x0117, B:67:0x011e, B:53:0x00f5, B:34:0x00a7), top: B:89:0x0080, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x00f3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x00f5 A[Catch: all -> 0x0135, TryCatch #1 {all -> 0x0135, blocks: (B:25:0x0080, B:27:0x0084, B:28:0x0086, B:30:0x0096, B:31:0x009b, B:33:0x009f, B:35:0x00ad, B:41:0x00bc, B:45:0x00d6, B:47:0x00da, B:68:0x0127, B:49:0x00e0, B:51:0x00ee, B:55:0x00fd, B:56:0x0100, B:58:0x010a, B:61:0x0111, B:65:0x0117, B:67:0x011e, B:53:0x00f5, B:34:0x00a7), top: B:89:0x0080, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x00fd A[Catch: all -> 0x0135, TryCatch #1 {all -> 0x0135, blocks: (B:25:0x0080, B:27:0x0084, B:28:0x0086, B:30:0x0096, B:31:0x009b, B:33:0x009f, B:35:0x00ad, B:41:0x00bc, B:45:0x00d6, B:47:0x00da, B:68:0x0127, B:49:0x00e0, B:51:0x00ee, B:55:0x00fd, B:56:0x0100, B:58:0x010a, B:61:0x0111, B:65:0x0117, B:67:0x011e, B:53:0x00f5, B:34:0x00a7), top: B:89:0x0080, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x010a A[Catch: all -> 0x0135, TryCatch #1 {all -> 0x0135, blocks: (B:25:0x0080, B:27:0x0084, B:28:0x0086, B:30:0x0096, B:31:0x009b, B:33:0x009f, B:35:0x00ad, B:41:0x00bc, B:45:0x00d6, B:47:0x00da, B:68:0x0127, B:49:0x00e0, B:51:0x00ee, B:55:0x00fd, B:56:0x0100, B:58:0x010a, B:61:0x0111, B:65:0x0117, B:67:0x011e, B:53:0x00f5, B:34:0x00a7), top: B:89:0x0080, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x011e A[Catch: all -> 0x0135, TryCatch #1 {all -> 0x0135, blocks: (B:25:0x0080, B:27:0x0084, B:28:0x0086, B:30:0x0096, B:31:0x009b, B:33:0x009f, B:35:0x00ad, B:41:0x00bc, B:45:0x00d6, B:47:0x00da, B:68:0x0127, B:49:0x00e0, B:51:0x00ee, B:55:0x00fd, B:56:0x0100, B:58:0x010a, B:61:0x0111, B:65:0x0117, B:67:0x011e, B:53:0x00f5, B:34:0x00a7), top: B:89:0x0080, outer: #0 }] */
    @Override // com.google.android.libraries.navigation.internal.uh.o
    public final void f(com.google.android.libraries.navigation.internal.ui.a aVar, com.google.android.libraries.navigation.internal.ui.a aVar2) {
        com.google.android.libraries.navigation.internal.uc.k kVar;
        boolean z;
        boolean z2;
        com.google.android.libraries.navigation.internal.db.r rVar;
        com.google.android.libraries.navigation.internal.nw.d dVarB;
        boolean zA;
        com.google.android.libraries.navigation.internal.uc.g gVar;
        com.google.android.libraries.navigation.internal.uc.g gVar2;
        com.google.android.libraries.navigation.internal.uc.g gVar3;
        com.google.android.libraries.navigation.internal.uc.g gVar4;
        r rVarN;
        com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("NavigationCameraController.onNavigationUiStateChanged");
        try {
            com.google.android.libraries.navigation.internal.tj.j jVar = aVar.h;
            boolean z3 = true;
            if (jVar == null) {
                if (aVar.l != null) {
                    throw null;
                }
                A();
                ((com.google.android.libraries.navigation.internal.dp.g) this.i).g.l(true);
            } else if (aVar2 != null) {
                com.google.android.libraries.navigation.internal.tj.j jVar2 = aVar2.h;
                boolean z4 = aVar.g;
                boolean z5 = aVar2.g;
                com.google.android.libraries.navigation.internal.uc.k kVar2 = aVar.c;
                com.google.android.libraries.navigation.internal.uc.k kVar3 = aVar2.c;
                if (jVar != jVar2 || z4 != z5 || kVar2 != kVar3) {
                    kVar = aVar.c;
                    z = kVar instanceof o;
                    if (z) {
                        this.F = (o) kVar;
                    }
                    if (jVar.h || (rVarN = jVar.c().b.u().n()) == null || !C(rVarN, kVar.d)) {
                        this.C = jVar.c();
                        this.D = jVar.g();
                        bg bgVar = this.C.b;
                        this.q = bgVar.j;
                        this.B = jVar.f;
                        this.E = aVar.j;
                        z2 = aVar.g;
                        al alVar = bgVar.j;
                        rVar = jVar.a;
                        dVarB = com.google.android.libraries.navigation.internal.nw.e.b("AbstractCameraController.updateInternalState");
                        try {
                            this.q = alVar;
                            if (rVar != null) {
                                this.r = rVar;
                            }
                            s(alVar);
                            ((com.google.android.libraries.navigation.internal.dp.g) this.i).g.x();
                            if (kVar instanceof com.google.android.libraries.navigation.internal.uc.p) {
                                this.l = (com.google.android.libraries.navigation.internal.uc.p) kVar;
                            }
                            if (kVar instanceof q) {
                                this.k = ((q) kVar).f;
                            } else {
                                int i = ev.d;
                                this.k = lv.a;
                            }
                            if (kVar.a == com.google.android.libraries.navigation.internal.uc.g.INSPECT_POINT_ON_ROUTE || z) {
                                zA = kVar.a.a();
                                boolean zA2 = am.a(kVar.c(), this.s);
                                gVar = this.f610n;
                                gVar2 = kVar.a;
                                if (gVar == gVar2 || ((zA && !zA2) || this.t != z2 || this.o != kVar.e)) {
                                    this.f610n = gVar2;
                                    this.o = kVar.e;
                                    this.t = z2;
                                    gVar3 = this.f610n;
                                    gVar4 = com.google.android.libraries.navigation.internal.uc.g.FOLLOWING;
                                    if (z2) {
                                        this.s = c.c;
                                    } else if (zA) {
                                        this.s = kVar.c();
                                    }
                                    if (gVar3 != gVar4) {
                                        ax();
                                    }
                                    com.google.android.libraries.navigation.internal.dq.i iVar = ((com.google.android.libraries.navigation.internal.dp.g) this.i).g;
                                    if (!this.t && this.f610n == com.google.android.libraries.navigation.internal.uc.g.FOLLOWING && this.u) {
                                        z3 = false;
                                    }
                                    iVar.l(z3);
                                    if (this.t) {
                                        ((com.google.android.libraries.navigation.internal.dp.g) this.i).g.w();
                                    }
                                }
                                super.d(kVar.d);
                                if (dVarB != null) {
                                    Trace.endSection();
                                }
                            } else if (dVarB != null) {
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
                }
            } else {
                kVar = aVar.c;
                z = kVar instanceof o;
                if (z) {
                    this.F = (o) kVar;
                }
                if (jVar.h) {
                    this.C = jVar.c();
                    this.D = jVar.g();
                    bg bgVar2 = this.C.b;
                    this.q = bgVar2.j;
                    this.B = jVar.f;
                    this.E = aVar.j;
                    z2 = aVar.g;
                    al alVar2 = bgVar2.j;
                    rVar = jVar.a;
                    dVarB = com.google.android.libraries.navigation.internal.nw.e.b("AbstractCameraController.updateInternalState");
                    this.q = alVar2;
                    if (rVar != null) {
                        this.r = rVar;
                    }
                    s(alVar2);
                    ((com.google.android.libraries.navigation.internal.dp.g) this.i).g.x();
                    if (kVar instanceof com.google.android.libraries.navigation.internal.uc.p) {
                        this.l = (com.google.android.libraries.navigation.internal.uc.p) kVar;
                    }
                    if (kVar instanceof q) {
                        this.k = ((q) kVar).f;
                    } else {
                        int i2 = ev.d;
                        this.k = lv.a;
                    }
                    if (kVar.a == com.google.android.libraries.navigation.internal.uc.g.INSPECT_POINT_ON_ROUTE) {
                        zA = kVar.a.a();
                        boolean zA3 = am.a(kVar.c(), this.s);
                        gVar = this.f610n;
                        gVar2 = kVar.a;
                        if (gVar == gVar2) {
                            this.f610n = gVar2;
                            this.o = kVar.e;
                            this.t = z2;
                            gVar3 = this.f610n;
                            gVar4 = com.google.android.libraries.navigation.internal.uc.g.FOLLOWING;
                            if (z2) {
                                this.s = c.c;
                            } else if (zA) {
                                this.s = kVar.c();
                            }
                            if (gVar3 != gVar4) {
                                ax();
                            }
                            com.google.android.libraries.navigation.internal.dq.i iVar2 = ((com.google.android.libraries.navigation.internal.dp.g) this.i).g;
                            if (!this.t) {
                                z3 = false;
                            }
                            iVar2.l(z3);
                            if (this.t) {
                                ((com.google.android.libraries.navigation.internal.dp.g) this.i).g.w();
                            }
                        } else {
                            this.f610n = gVar2;
                            this.o = kVar.e;
                            this.t = z2;
                            gVar3 = this.f610n;
                            gVar4 = com.google.android.libraries.navigation.internal.uc.g.FOLLOWING;
                            if (z2) {
                                this.s = c.c;
                            } else if (zA) {
                                this.s = kVar.c();
                            }
                            if (gVar3 != gVar4) {
                                ax();
                            }
                            com.google.android.libraries.navigation.internal.dq.i iVar3 = ((com.google.android.libraries.navigation.internal.dp.g) this.i).g;
                            if (!this.t) {
                                z3 = false;
                            }
                            iVar3.l(z3);
                            if (this.t) {
                                ((com.google.android.libraries.navigation.internal.dp.g) this.i).g.w();
                            }
                        }
                        super.d(kVar.d);
                        if (dVarB != null) {
                            Trace.endSection();
                        }
                    } else {
                        zA = kVar.a.a();
                        boolean zA4 = am.a(kVar.c(), this.s);
                        gVar = this.f610n;
                        gVar2 = kVar.a;
                        if (gVar == gVar2) {
                            this.f610n = gVar2;
                            this.o = kVar.e;
                            this.t = z2;
                            gVar3 = this.f610n;
                            gVar4 = com.google.android.libraries.navigation.internal.uc.g.FOLLOWING;
                            if (z2) {
                                this.s = c.c;
                            } else if (zA) {
                                this.s = kVar.c();
                            }
                            if (gVar3 != gVar4) {
                                ax();
                            }
                            com.google.android.libraries.navigation.internal.dq.i iVar4 = ((com.google.android.libraries.navigation.internal.dp.g) this.i).g;
                            if (!this.t) {
                                z3 = false;
                            }
                            iVar4.l(z3);
                            if (this.t) {
                                ((com.google.android.libraries.navigation.internal.dp.g) this.i).g.w();
                            }
                        } else {
                            this.f610n = gVar2;
                            this.o = kVar.e;
                            this.t = z2;
                            gVar3 = this.f610n;
                            gVar4 = com.google.android.libraries.navigation.internal.uc.g.FOLLOWING;
                            if (z2) {
                                this.s = c.c;
                            } else if (zA) {
                                this.s = kVar.c();
                            }
                            if (gVar3 != gVar4) {
                                ax();
                            }
                            com.google.android.libraries.navigation.internal.dq.i iVar5 = ((com.google.android.libraries.navigation.internal.dp.g) this.i).g;
                            if (!this.t) {
                                z3 = false;
                            }
                            iVar5.l(z3);
                            if (this.t) {
                                ((com.google.android.libraries.navigation.internal.dp.g) this.i).g.w();
                            }
                        }
                        super.d(kVar.d);
                        if (dVarB != null) {
                            Trace.endSection();
                        }
                    }
                } else {
                    this.C = jVar.c();
                    this.D = jVar.g();
                    bg bgVar3 = this.C.b;
                    this.q = bgVar3.j;
                    this.B = jVar.f;
                    this.E = aVar.j;
                    z2 = aVar.g;
                    al alVar3 = bgVar3.j;
                    rVar = jVar.a;
                    dVarB = com.google.android.libraries.navigation.internal.nw.e.b("AbstractCameraController.updateInternalState");
                    this.q = alVar3;
                    if (rVar != null) {
                        this.r = rVar;
                    }
                    s(alVar3);
                    ((com.google.android.libraries.navigation.internal.dp.g) this.i).g.x();
                    if (kVar instanceof com.google.android.libraries.navigation.internal.uc.p) {
                        this.l = (com.google.android.libraries.navigation.internal.uc.p) kVar;
                    }
                    if (kVar instanceof q) {
                        this.k = ((q) kVar).f;
                    } else {
                        int i3 = ev.d;
                        this.k = lv.a;
                    }
                    if (kVar.a == com.google.android.libraries.navigation.internal.uc.g.INSPECT_POINT_ON_ROUTE) {
                        zA = kVar.a.a();
                        boolean zA5 = am.a(kVar.c(), this.s);
                        gVar = this.f610n;
                        gVar2 = kVar.a;
                        if (gVar == gVar2) {
                            this.f610n = gVar2;
                            this.o = kVar.e;
                            this.t = z2;
                            gVar3 = this.f610n;
                            gVar4 = com.google.android.libraries.navigation.internal.uc.g.FOLLOWING;
                            if (z2) {
                                this.s = c.c;
                            } else if (zA) {
                                this.s = kVar.c();
                            }
                            if (gVar3 != gVar4) {
                                ax();
                            }
                            com.google.android.libraries.navigation.internal.dq.i iVar6 = ((com.google.android.libraries.navigation.internal.dp.g) this.i).g;
                            if (!this.t) {
                                z3 = false;
                            }
                            iVar6.l(z3);
                            if (this.t) {
                                ((com.google.android.libraries.navigation.internal.dp.g) this.i).g.w();
                            }
                        } else {
                            this.f610n = gVar2;
                            this.o = kVar.e;
                            this.t = z2;
                            gVar3 = this.f610n;
                            gVar4 = com.google.android.libraries.navigation.internal.uc.g.FOLLOWING;
                            if (z2) {
                                this.s = c.c;
                            } else if (zA) {
                                this.s = kVar.c();
                            }
                            if (gVar3 != gVar4) {
                                ax();
                            }
                            com.google.android.libraries.navigation.internal.dq.i iVar7 = ((com.google.android.libraries.navigation.internal.dp.g) this.i).g;
                            if (!this.t) {
                                z3 = false;
                            }
                            iVar7.l(z3);
                            if (this.t) {
                                ((com.google.android.libraries.navigation.internal.dp.g) this.i).g.w();
                            }
                        }
                        super.d(kVar.d);
                        if (dVarB != null) {
                            Trace.endSection();
                        }
                    } else {
                        zA = kVar.a.a();
                        boolean zA6 = am.a(kVar.c(), this.s);
                        gVar = this.f610n;
                        gVar2 = kVar.a;
                        if (gVar == gVar2) {
                            this.f610n = gVar2;
                            this.o = kVar.e;
                            this.t = z2;
                            gVar3 = this.f610n;
                            gVar4 = com.google.android.libraries.navigation.internal.uc.g.FOLLOWING;
                            if (z2) {
                                this.s = c.c;
                            } else if (zA) {
                                this.s = kVar.c();
                            }
                            if (gVar3 != gVar4) {
                                ax();
                            }
                            com.google.android.libraries.navigation.internal.dq.i iVar8 = ((com.google.android.libraries.navigation.internal.dp.g) this.i).g;
                            if (!this.t) {
                                z3 = false;
                            }
                            iVar8.l(z3);
                            if (this.t) {
                                ((com.google.android.libraries.navigation.internal.dp.g) this.i).g.w();
                            }
                        } else {
                            this.f610n = gVar2;
                            this.o = kVar.e;
                            this.t = z2;
                            gVar3 = this.f610n;
                            gVar4 = com.google.android.libraries.navigation.internal.uc.g.FOLLOWING;
                            if (z2) {
                                this.s = c.c;
                            } else if (zA) {
                                this.s = kVar.c();
                            }
                            if (gVar3 != gVar4) {
                                ax();
                            }
                            com.google.android.libraries.navigation.internal.dq.i iVar9 = ((com.google.android.libraries.navigation.internal.dp.g) this.i).g;
                            if (!this.t) {
                                z3 = false;
                            }
                            iVar9.l(z3);
                            if (this.t) {
                                ((com.google.android.libraries.navigation.internal.dp.g) this.i).g.w();
                            }
                        }
                        super.d(kVar.d);
                        if (dVarB != null) {
                            Trace.endSection();
                        }
                    }
                }
            }
            if (dVarB2 != null) {
                Trace.endSection();
            }
        } catch (Throwable th3) {
            if (dVarB2 != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
            }
            throw th3;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ub.c
    protected final void q(boolean z) {
        ev evVarG;
        com.google.android.libraries.navigation.internal.se.b[] bVarArr;
        Float f = (Float) v.get(this.q);
        float fFloatValue = f != null ? f.floatValue() : -1.0f;
        if (this.r == null || (bVarArr = this.D) == null || bVarArr.length == 0 || this.B) {
            int i = ev.d;
            evVarG = lv.a;
        } else {
            int i2 = ev.d;
            eq eqVar = new eq();
            for (com.google.android.libraries.navigation.internal.se.b bVar : this.D) {
                eqVar.h(z(fFloatValue, bVar));
            }
            evVarG = eqVar.g();
        }
        com.google.android.libraries.navigation.internal.pd.d dVarB = b(true, evVarG);
        if (dVarB != null) {
            v(z, dVarB, a);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ub.c
    protected final void r(boolean z) {
        bq bqVar = this.E;
        ar.q(bqVar);
        Point pointA = this.g.a();
        super.w(c().b(bqVar, ((bp) this.g).e(), pointA.x, pointA.y), true != z ? -1 : 0, null);
    }

    @Override // com.google.android.libraries.navigation.internal.ub.c
    protected final void y() {
        ar.q(this.F);
        throw null;
    }
}

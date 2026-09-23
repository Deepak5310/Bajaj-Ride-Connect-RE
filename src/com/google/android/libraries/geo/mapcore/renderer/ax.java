package com.google.android.libraries.geo.mapcore.renderer;

import android.content.Context;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.os.Process;
import android.view.accessibility.AccessibilityManager;
import androidx.tracing.Trace;
import com.drew.metadata.exif.makernotes.FujifilmMakernoteDirectory;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.yz.no;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class ax implements bx {
    public static final Comparator a = new at();
    public static final Comparator b = new au();
    public static final Comparator c = new av();
    public static final Comparator d = new aw();
    public AccessibilityManager A;
    public AccessibilityManager.AccessibilityStateChangeListener B;
    private final long C;
    private final Set D;
    private Set E;
    private Set F;
    private final List G;
    private final CopyOnWriteArraySet H;
    private final CopyOnWriteArraySet I;
    private final eh J;
    private final eh K;
    private final dg L;
    private final eh M;
    private final dg N;
    private final eh O;
    private final eh P;
    private final eh Q;
    private final eh R;
    private final eh S;
    private final dg T;
    private final dg U;
    private final eh V;
    private final com.google.android.libraries.navigation.internal.yz.ev W;
    private Runnable X;
    private Runnable Y;
    private final AtomicBoolean Z;
    private final com.google.android.libraries.navigation.internal.nt.p aa;
    private LabelRenderer ab;
    private int ac;
    private dh ad;
    private l ae;
    private final n af;
    private com.google.android.libraries.navigation.internal.yz.ev ag;
    private com.google.android.libraries.navigation.internal.yz.ev ah;
    private bw ai;
    private final AtomicBoolean aj;
    private final FrameTimeOverlay ak;
    private boolean al;
    public final am e;
    public volatile cy f;
    public com.google.android.libraries.navigation.internal.yz.ev g;
    public final CopyOnWriteArraySet h;
    public final eh i;
    public final dg j;
    public eb k;
    public u l;
    public final ep m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ep f75n;
    public final ep o;
    public boolean p;
    public dp q;
    public final bv r;
    public final com.google.android.libraries.navigation.internal.kl.b s;
    public ej t;
    public final boolean u;
    public List v;
    public List w;
    public final az x;
    public final com.google.android.libraries.navigation.internal.ni.a y;
    public String z;

    /* JADX WARN: Code duplicated, block: B:72:0x026f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x0281 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:? A[Catch: all -> 0x0279, SYNTHETIC, TRY_LEAVE, TryCatch #6 {all -> 0x0279, blocks: (B:40:0x0258, B:57:0x0278, B:56:0x0275, B:52:0x026f), top: B:80:0x0098, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:85:? A[SYNTHETIC] */
    public ax(Context context, com.google.android.libraries.navigation.internal.kl.b bVar, com.google.android.libraries.navigation.internal.ni.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, Resources resources) throws Throwable {
        com.google.android.libraries.navigation.internal.nw.d dVar;
        Throwable th;
        com.google.android.libraries.navigation.internal.nw.a aVar3;
        Throwable th2;
        Resources resources2 = context.getResources();
        long jA = ((com.google.android.libraries.navigation.internal.om.l) aVar2.a()).a();
        ((com.google.android.libraries.navigation.internal.om.l) aVar2.a()).r();
        bv bvVar = new bv(resources2, jA);
        this.D = new HashSet();
        this.E = new LinkedHashSet();
        this.F = new HashSet();
        this.G = new ArrayList();
        int i = com.google.android.libraries.navigation.internal.yz.ev.d;
        this.g = lv.a;
        this.h = new CopyOnWriteArraySet();
        this.H = new CopyOnWriteArraySet();
        this.I = new CopyOnWriteArraySet();
        this.p = true;
        this.Z = new AtomicBoolean(true);
        this.aa = new com.google.android.libraries.navigation.internal.nt.p(true);
        this.af = new n();
        this.ai = bw.a;
        this.x = new az(false);
        this.aj = new AtomicBoolean(false);
        this.z = "";
        this.B = null;
        this.al = false;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("EntityRenderer");
        try {
            try {
                com.google.android.libraries.navigation.internal.nw.a aVarA = com.google.android.libraries.navigation.internal.nw.b.a("EntityRenderer");
                try {
                    this.r = bvVar;
                    this.s = bVar;
                    this.y = aVar;
                    AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
                    this.A = accessibilityManager;
                    try {
                        if (accessibilityManager != null) {
                            this.al = accessibilityManager.isEnabled() || this.A.isTouchExplorationEnabled();
                            if (bVar != null) {
                                bVar.b(com.google.android.libraries.navigation.internal.km.p.az, this.al);
                            }
                        } else {
                            this.al = false;
                            if (bVar != null) {
                                bVar.b(com.google.android.libraries.navigation.internal.km.p.az, this.al);
                            }
                        }
                        Comparator comparator = c;
                        eh ehVar = new eh(comparator);
                        this.J = ehVar;
                        eh ehVar2 = new eh(comparator);
                        this.K = ehVar2;
                        df dfVar = new df() { // from class: com.google.android.libraries.geo.mapcore.renderer.ao
                            @Override // com.google.android.libraries.geo.mapcore.renderer.df
                            public final int a(aj ajVar) {
                                return ajVar.h();
                            }
                        };
                        Comparator comparator2 = a;
                        dg dgVar = new dg(22, dfVar, comparator2);
                        this.L = dgVar;
                        eh ehVar3 = new eh(comparator2);
                        this.M = ehVar3;
                        dg dgVar2 = new dg(ch.values().length, new df() { // from class: com.google.android.libraries.geo.mapcore.renderer.ap
                            @Override // com.google.android.libraries.geo.mapcore.renderer.df
                            public final int a(aj ajVar) {
                                return ajVar.i().b();
                            }
                        }, null);
                        this.N = dgVar2;
                        eh ehVar4 = new eh("transit");
                        this.O = ehVar4;
                        eh ehVar5 = new eh("bicycling");
                        this.P = ehVar5;
                        Comparator comparator3 = b;
                        eh ehVar6 = new eh(comparator3);
                        this.i = ehVar6;
                        Comparator comparator4 = d;
                        eh ehVar7 = new eh(comparator4);
                        this.Q = ehVar7;
                        eh ehVar8 = new eh(comparator4);
                        this.R = ehVar8;
                        dVar = dVarB;
                        try {
                            eh ehVar9 = new eh(comparator3);
                            this.S = ehVar9;
                            aVar3 = aVarA;
                            try {
                                dg dgVar3 = new dg(ci.values().length, new df() { // from class: com.google.android.libraries.geo.mapcore.renderer.aq
                                    @Override // com.google.android.libraries.geo.mapcore.renderer.df
                                    public final int a(aj ajVar) {
                                        return ajVar.i().b();
                                    }
                                }, comparator3);
                                this.T = dgVar3;
                                dg dgVar4 = new dg(22, new df() { // from class: com.google.android.libraries.geo.mapcore.renderer.ar
                                    @Override // com.google.android.libraries.geo.mapcore.renderer.df
                                    public final int a(aj ajVar) {
                                        return ajVar.h();
                                    }
                                }, comparator2);
                                this.U = dgVar4;
                                dg dgVar5 = new dg(ck.values().length, new df() { // from class: com.google.android.libraries.geo.mapcore.renderer.as
                                    @Override // com.google.android.libraries.geo.mapcore.renderer.df
                                    public final int a(aj ajVar) {
                                        return ajVar.i().b();
                                    }
                                }, comparator3);
                                this.j = dgVar5;
                                eh ehVar10 = new eh(comparator4);
                                this.V = ehVar10;
                                this.W = com.google.android.libraries.navigation.internal.yz.ev.v(ehVar, ehVar2, dgVar, ehVar3, dgVar2, ehVar4, ehVar5, ehVar6, ehVar7, ehVar8, ehVar9, dgVar3, dgVar4, dgVar5, ehVar10);
                                int i2 = ((double) context.getResources().getDisplayMetrics().density) > 2.0d ? 2 : 1;
                                boolean zL = ((com.google.android.libraries.navigation.internal.om.l) aVar2.a()).L();
                                this.m = new ep("label_atlas_2", 2048, 256, 2, 4, 4, zL);
                                this.f75n = new ep("callout_atlas_2", i2 * 1024, i2 * 512, 2, 8, 32, zL);
                                boolean zM = ((com.google.android.libraries.navigation.internal.om.l) aVar2.a()).M();
                                this.u = zM;
                                if (zM) {
                                    this.o = new ep("area_atlas_2", 2048, 256, 2, 4, 4, zL);
                                } else {
                                    this.o = null;
                                }
                                this.ag = lv.a;
                                this.v = new ArrayList();
                                this.ah = lv.a;
                                this.w = new ArrayList();
                                this.ak = null;
                                if (((com.google.android.libraries.navigation.internal.om.l) aVar2.a()).k()) {
                                    this.e = new ay();
                                } else {
                                    this.e = new an();
                                }
                                this.C = ((com.google.android.libraries.navigation.internal.om.l) aVar2.a()).b() * 1000000;
                                if (aVar3 != null) {
                                    aVar3.close();
                                }
                                if (dVar != null) {
                                    Trace.endSection();
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                th2 = th;
                                if (aVar3 != null) {
                                    throw th2;
                                }
                                try {
                                    aVar3.close();
                                    throw th2;
                                } catch (Throwable th4) {
                                    th2.addSuppressed(th4);
                                    throw th2;
                                }
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            aVar3 = aVarA;
                        }
                    } catch (Throwable th6) {
                        th2 = th6;
                        aVar3 = aVarA;
                        dVar = dVarB;
                        if (aVar3 != null) {
                            throw th2;
                        }
                        aVar3.close();
                        throw th2;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    aVar3 = aVarA;
                    dVar = dVarB;
                }
            } catch (Throwable th8) {
                th = th8;
                th = th;
                if (dVar != null) {
                    throw th;
                }
                try {
                    Trace.endSection();
                    throw th;
                } catch (Throwable th9) {
                    th.addSuppressed(th9);
                    throw th;
                }
            }
        } catch (Throwable th10) {
            th = th10;
            dVar = dVarB;
            th = th;
            if (dVar != null) {
                throw th;
            }
            Trace.endSection();
            throw th;
        }
    }

    private final void A(boolean z) {
        Runnable runnable;
        Runnable runnable2 = this.X;
        if (runnable2 != null) {
            runnable2.run();
        }
        if (!z || (runnable = this.Y) == null) {
            return;
        }
        runnable.run();
    }

    private final synchronized com.google.android.libraries.navigation.internal.yz.ev z() {
        return this.g;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bx
    public final ax a() {
        return this;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bx
    public final bv b() {
        return this.r;
    }

    public final void c(aj ajVar) {
        d(ajVar, null);
    }

    public final void d(aj ajVar, com.google.android.libraries.navigation.internal.ol.au auVar) {
        am amVar = this.e;
        boolean zE = amVar.e();
        amVar.b(ajVar, auVar);
        A(zE);
    }

    public final synchronized void e(cb cbVar) {
        if (this.g.contains(cbVar)) {
            return;
        }
        com.google.android.libraries.navigation.internal.yz.eq eqVar = new com.google.android.libraries.navigation.internal.yz.eq();
        eqVar.j(this.g);
        eqVar.h(cbVar);
        this.g = eqVar.g();
    }

    public final void f(Runnable runnable) {
        this.H.add(runnable);
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x08cf */
    /* JADX WARN: Bottom block not found for handler: all -> 0x08f1 */
    /* JADX WARN: Bottom block not found for handler: all -> 0x0913 */
    /* JADX WARN: Bottom block not found for handler: all -> 0x0935 */
    /* JADX WARN: Bottom block not found for handler: all -> 0x0957 */
    /* JADX WARN: Bottom block not found for handler: all -> 0x0979 */
    /* JADX WARN: Bottom block not found for handler: all -> 0x099b */
    /* JADX WARN: Bottom block not found for handler: all -> 0x09bd */
    /* JADX WARN: Bottom block not found for handler: all -> 0x09df */
    /* JADX WARN: Bottom block not found for handler: all -> 0x0a01 */
    /* JADX WARN: Bottom block not found for handler: all -> 0x0a23 */
    /* JADX WARN: Bottom block not found for handler: all -> 0x0a45 */
    /* JADX WARN: Bottom block not found for handler: all -> 0x0a67 */
    /* JADX WARN: Code duplicated, block: B:1113:0x0a2b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1137:0x093d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1145:0x0c42 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1158:0x0a4d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1162:0x0c50 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1171:0x0b56 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1186:0x095f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1195:0x0b68 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1199:0x0a6f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1212:0x0b7a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1222:0x0981 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1234:0x0b8c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1257:0x09a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1259:0x08a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1263:0x0ca8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1276:0x08b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1280:0x0cb6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1300:0x09c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1322:0x08d7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1337:0x09e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1348:0x0bee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1358:0x08f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1360:0x0bfc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1371:0x0a09 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1391:0x091b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1439:? A[Catch: all -> 0x08ad, SYNTHETIC, TRY_LEAVE, TryCatch #100 {all -> 0x08ad, blocks: (B:468:0x0891, B:483:0x08ac, B:482:0x08a9, B:478:0x08a3), top: B:1267:0x05e2, inners: #96 }] */
    /* JADX WARN: Code duplicated, block: B:1441:? A[Catch: all -> 0x0a79, SYNTHETIC, TRY_LEAVE, TryCatch #65 {all -> 0x0a79, blocks: (B:470:0x0896, B:495:0x08be, B:494:0x08bb, B:516:0x08e0, B:515:0x08dd, B:537:0x0902, B:536:0x08ff, B:558:0x0924, B:557:0x0921, B:579:0x0946, B:578:0x0943, B:600:0x0968, B:599:0x0965, B:621:0x098a, B:620:0x0987, B:642:0x09ac, B:641:0x09a9, B:663:0x09ce, B:662:0x09cb, B:684:0x09f0, B:683:0x09ed, B:705:0x0a12, B:704:0x0a0f, B:726:0x0a34, B:725:0x0a31, B:747:0x0a56, B:746:0x0a53, B:768:0x0a78, B:767:0x0a75, B:721:0x0a2b, B:574:0x093d, B:742:0x0a4d, B:595:0x095f, B:763:0x0a6f, B:616:0x0981, B:637:0x09a3, B:490:0x08b5, B:658:0x09c5, B:511:0x08d7, B:679:0x09e7, B:532:0x08f9, B:700:0x0a09, B:553:0x091b), top: B:1207:0x033c, inners: #10, #24, #36, #52, #60, #74, #95, #106, #119, #131, #140, #152, #159, #170 }] */
    /* JADX WARN: Code duplicated, block: B:1445:? A[Catch: all -> 0x0a79, SYNTHETIC, TRY_LEAVE, TryCatch #65 {all -> 0x0a79, blocks: (B:470:0x0896, B:495:0x08be, B:494:0x08bb, B:516:0x08e0, B:515:0x08dd, B:537:0x0902, B:536:0x08ff, B:558:0x0924, B:557:0x0921, B:579:0x0946, B:578:0x0943, B:600:0x0968, B:599:0x0965, B:621:0x098a, B:620:0x0987, B:642:0x09ac, B:641:0x09a9, B:663:0x09ce, B:662:0x09cb, B:684:0x09f0, B:683:0x09ed, B:705:0x0a12, B:704:0x0a0f, B:726:0x0a34, B:725:0x0a31, B:747:0x0a56, B:746:0x0a53, B:768:0x0a78, B:767:0x0a75, B:721:0x0a2b, B:574:0x093d, B:742:0x0a4d, B:595:0x095f, B:763:0x0a6f, B:616:0x0981, B:637:0x09a3, B:490:0x08b5, B:658:0x09c5, B:511:0x08d7, B:679:0x09e7, B:532:0x08f9, B:700:0x0a09, B:553:0x091b), top: B:1207:0x033c, inners: #10, #24, #36, #52, #60, #74, #95, #106, #119, #131, #140, #152, #159, #170 }] */
    /* JADX WARN: Code duplicated, block: B:1449:? A[Catch: all -> 0x0a79, SYNTHETIC, TRY_LEAVE, TryCatch #65 {all -> 0x0a79, blocks: (B:470:0x0896, B:495:0x08be, B:494:0x08bb, B:516:0x08e0, B:515:0x08dd, B:537:0x0902, B:536:0x08ff, B:558:0x0924, B:557:0x0921, B:579:0x0946, B:578:0x0943, B:600:0x0968, B:599:0x0965, B:621:0x098a, B:620:0x0987, B:642:0x09ac, B:641:0x09a9, B:663:0x09ce, B:662:0x09cb, B:684:0x09f0, B:683:0x09ed, B:705:0x0a12, B:704:0x0a0f, B:726:0x0a34, B:725:0x0a31, B:747:0x0a56, B:746:0x0a53, B:768:0x0a78, B:767:0x0a75, B:721:0x0a2b, B:574:0x093d, B:742:0x0a4d, B:595:0x095f, B:763:0x0a6f, B:616:0x0981, B:637:0x09a3, B:490:0x08b5, B:658:0x09c5, B:511:0x08d7, B:679:0x09e7, B:532:0x08f9, B:700:0x0a09, B:553:0x091b), top: B:1207:0x033c, inners: #10, #24, #36, #52, #60, #74, #95, #106, #119, #131, #140, #152, #159, #170 }] */
    /* JADX WARN: Code duplicated, block: B:1453:? A[Catch: all -> 0x0a79, SYNTHETIC, TRY_LEAVE, TryCatch #65 {all -> 0x0a79, blocks: (B:470:0x0896, B:495:0x08be, B:494:0x08bb, B:516:0x08e0, B:515:0x08dd, B:537:0x0902, B:536:0x08ff, B:558:0x0924, B:557:0x0921, B:579:0x0946, B:578:0x0943, B:600:0x0968, B:599:0x0965, B:621:0x098a, B:620:0x0987, B:642:0x09ac, B:641:0x09a9, B:663:0x09ce, B:662:0x09cb, B:684:0x09f0, B:683:0x09ed, B:705:0x0a12, B:704:0x0a0f, B:726:0x0a34, B:725:0x0a31, B:747:0x0a56, B:746:0x0a53, B:768:0x0a78, B:767:0x0a75, B:721:0x0a2b, B:574:0x093d, B:742:0x0a4d, B:595:0x095f, B:763:0x0a6f, B:616:0x0981, B:637:0x09a3, B:490:0x08b5, B:658:0x09c5, B:511:0x08d7, B:679:0x09e7, B:532:0x08f9, B:700:0x0a09, B:553:0x091b), top: B:1207:0x033c, inners: #10, #24, #36, #52, #60, #74, #95, #106, #119, #131, #140, #152, #159, #170 }] */
    /* JADX WARN: Code duplicated, block: B:1457:? A[Catch: all -> 0x0a79, SYNTHETIC, TRY_LEAVE, TryCatch #65 {all -> 0x0a79, blocks: (B:470:0x0896, B:495:0x08be, B:494:0x08bb, B:516:0x08e0, B:515:0x08dd, B:537:0x0902, B:536:0x08ff, B:558:0x0924, B:557:0x0921, B:579:0x0946, B:578:0x0943, B:600:0x0968, B:599:0x0965, B:621:0x098a, B:620:0x0987, B:642:0x09ac, B:641:0x09a9, B:663:0x09ce, B:662:0x09cb, B:684:0x09f0, B:683:0x09ed, B:705:0x0a12, B:704:0x0a0f, B:726:0x0a34, B:725:0x0a31, B:747:0x0a56, B:746:0x0a53, B:768:0x0a78, B:767:0x0a75, B:721:0x0a2b, B:574:0x093d, B:742:0x0a4d, B:595:0x095f, B:763:0x0a6f, B:616:0x0981, B:637:0x09a3, B:490:0x08b5, B:658:0x09c5, B:511:0x08d7, B:679:0x09e7, B:532:0x08f9, B:700:0x0a09, B:553:0x091b), top: B:1207:0x033c, inners: #10, #24, #36, #52, #60, #74, #95, #106, #119, #131, #140, #152, #159, #170 }] */
    /* JADX WARN: Code duplicated, block: B:1461:? A[Catch: all -> 0x0a79, SYNTHETIC, TRY_LEAVE, TryCatch #65 {all -> 0x0a79, blocks: (B:470:0x0896, B:495:0x08be, B:494:0x08bb, B:516:0x08e0, B:515:0x08dd, B:537:0x0902, B:536:0x08ff, B:558:0x0924, B:557:0x0921, B:579:0x0946, B:578:0x0943, B:600:0x0968, B:599:0x0965, B:621:0x098a, B:620:0x0987, B:642:0x09ac, B:641:0x09a9, B:663:0x09ce, B:662:0x09cb, B:684:0x09f0, B:683:0x09ed, B:705:0x0a12, B:704:0x0a0f, B:726:0x0a34, B:725:0x0a31, B:747:0x0a56, B:746:0x0a53, B:768:0x0a78, B:767:0x0a75, B:721:0x0a2b, B:574:0x093d, B:742:0x0a4d, B:595:0x095f, B:763:0x0a6f, B:616:0x0981, B:637:0x09a3, B:490:0x08b5, B:658:0x09c5, B:511:0x08d7, B:679:0x09e7, B:532:0x08f9, B:700:0x0a09, B:553:0x091b), top: B:1207:0x033c, inners: #10, #24, #36, #52, #60, #74, #95, #106, #119, #131, #140, #152, #159, #170 }] */
    /* JADX WARN: Code duplicated, block: B:1465:? A[Catch: all -> 0x0a79, SYNTHETIC, TRY_LEAVE, TryCatch #65 {all -> 0x0a79, blocks: (B:470:0x0896, B:495:0x08be, B:494:0x08bb, B:516:0x08e0, B:515:0x08dd, B:537:0x0902, B:536:0x08ff, B:558:0x0924, B:557:0x0921, B:579:0x0946, B:578:0x0943, B:600:0x0968, B:599:0x0965, B:621:0x098a, B:620:0x0987, B:642:0x09ac, B:641:0x09a9, B:663:0x09ce, B:662:0x09cb, B:684:0x09f0, B:683:0x09ed, B:705:0x0a12, B:704:0x0a0f, B:726:0x0a34, B:725:0x0a31, B:747:0x0a56, B:746:0x0a53, B:768:0x0a78, B:767:0x0a75, B:721:0x0a2b, B:574:0x093d, B:742:0x0a4d, B:595:0x095f, B:763:0x0a6f, B:616:0x0981, B:637:0x09a3, B:490:0x08b5, B:658:0x09c5, B:511:0x08d7, B:679:0x09e7, B:532:0x08f9, B:700:0x0a09, B:553:0x091b), top: B:1207:0x033c, inners: #10, #24, #36, #52, #60, #74, #95, #106, #119, #131, #140, #152, #159, #170 }] */
    /* JADX WARN: Code duplicated, block: B:1469:? A[Catch: all -> 0x0a79, SYNTHETIC, TRY_LEAVE, TryCatch #65 {all -> 0x0a79, blocks: (B:470:0x0896, B:495:0x08be, B:494:0x08bb, B:516:0x08e0, B:515:0x08dd, B:537:0x0902, B:536:0x08ff, B:558:0x0924, B:557:0x0921, B:579:0x0946, B:578:0x0943, B:600:0x0968, B:599:0x0965, B:621:0x098a, B:620:0x0987, B:642:0x09ac, B:641:0x09a9, B:663:0x09ce, B:662:0x09cb, B:684:0x09f0, B:683:0x09ed, B:705:0x0a12, B:704:0x0a0f, B:726:0x0a34, B:725:0x0a31, B:747:0x0a56, B:746:0x0a53, B:768:0x0a78, B:767:0x0a75, B:721:0x0a2b, B:574:0x093d, B:742:0x0a4d, B:595:0x095f, B:763:0x0a6f, B:616:0x0981, B:637:0x09a3, B:490:0x08b5, B:658:0x09c5, B:511:0x08d7, B:679:0x09e7, B:532:0x08f9, B:700:0x0a09, B:553:0x091b), top: B:1207:0x033c, inners: #10, #24, #36, #52, #60, #74, #95, #106, #119, #131, #140, #152, #159, #170 }] */
    /* JADX WARN: Code duplicated, block: B:1473:? A[Catch: all -> 0x0a79, SYNTHETIC, TRY_LEAVE, TryCatch #65 {all -> 0x0a79, blocks: (B:470:0x0896, B:495:0x08be, B:494:0x08bb, B:516:0x08e0, B:515:0x08dd, B:537:0x0902, B:536:0x08ff, B:558:0x0924, B:557:0x0921, B:579:0x0946, B:578:0x0943, B:600:0x0968, B:599:0x0965, B:621:0x098a, B:620:0x0987, B:642:0x09ac, B:641:0x09a9, B:663:0x09ce, B:662:0x09cb, B:684:0x09f0, B:683:0x09ed, B:705:0x0a12, B:704:0x0a0f, B:726:0x0a34, B:725:0x0a31, B:747:0x0a56, B:746:0x0a53, B:768:0x0a78, B:767:0x0a75, B:721:0x0a2b, B:574:0x093d, B:742:0x0a4d, B:595:0x095f, B:763:0x0a6f, B:616:0x0981, B:637:0x09a3, B:490:0x08b5, B:658:0x09c5, B:511:0x08d7, B:679:0x09e7, B:532:0x08f9, B:700:0x0a09, B:553:0x091b), top: B:1207:0x033c, inners: #10, #24, #36, #52, #60, #74, #95, #106, #119, #131, #140, #152, #159, #170 }] */
    /* JADX WARN: Code duplicated, block: B:1477:? A[Catch: all -> 0x0a79, SYNTHETIC, TRY_LEAVE, TryCatch #65 {all -> 0x0a79, blocks: (B:470:0x0896, B:495:0x08be, B:494:0x08bb, B:516:0x08e0, B:515:0x08dd, B:537:0x0902, B:536:0x08ff, B:558:0x0924, B:557:0x0921, B:579:0x0946, B:578:0x0943, B:600:0x0968, B:599:0x0965, B:621:0x098a, B:620:0x0987, B:642:0x09ac, B:641:0x09a9, B:663:0x09ce, B:662:0x09cb, B:684:0x09f0, B:683:0x09ed, B:705:0x0a12, B:704:0x0a0f, B:726:0x0a34, B:725:0x0a31, B:747:0x0a56, B:746:0x0a53, B:768:0x0a78, B:767:0x0a75, B:721:0x0a2b, B:574:0x093d, B:742:0x0a4d, B:595:0x095f, B:763:0x0a6f, B:616:0x0981, B:637:0x09a3, B:490:0x08b5, B:658:0x09c5, B:511:0x08d7, B:679:0x09e7, B:532:0x08f9, B:700:0x0a09, B:553:0x091b), top: B:1207:0x033c, inners: #10, #24, #36, #52, #60, #74, #95, #106, #119, #131, #140, #152, #159, #170 }] */
    /* JADX WARN: Code duplicated, block: B:1481:? A[Catch: all -> 0x0a79, SYNTHETIC, TRY_LEAVE, TryCatch #65 {all -> 0x0a79, blocks: (B:470:0x0896, B:495:0x08be, B:494:0x08bb, B:516:0x08e0, B:515:0x08dd, B:537:0x0902, B:536:0x08ff, B:558:0x0924, B:557:0x0921, B:579:0x0946, B:578:0x0943, B:600:0x0968, B:599:0x0965, B:621:0x098a, B:620:0x0987, B:642:0x09ac, B:641:0x09a9, B:663:0x09ce, B:662:0x09cb, B:684:0x09f0, B:683:0x09ed, B:705:0x0a12, B:704:0x0a0f, B:726:0x0a34, B:725:0x0a31, B:747:0x0a56, B:746:0x0a53, B:768:0x0a78, B:767:0x0a75, B:721:0x0a2b, B:574:0x093d, B:742:0x0a4d, B:595:0x095f, B:763:0x0a6f, B:616:0x0981, B:637:0x09a3, B:490:0x08b5, B:658:0x09c5, B:511:0x08d7, B:679:0x09e7, B:532:0x08f9, B:700:0x0a09, B:553:0x091b), top: B:1207:0x033c, inners: #10, #24, #36, #52, #60, #74, #95, #106, #119, #131, #140, #152, #159, #170 }] */
    /* JADX WARN: Code duplicated, block: B:1485:? A[Catch: all -> 0x0a79, SYNTHETIC, TRY_LEAVE, TryCatch #65 {all -> 0x0a79, blocks: (B:470:0x0896, B:495:0x08be, B:494:0x08bb, B:516:0x08e0, B:515:0x08dd, B:537:0x0902, B:536:0x08ff, B:558:0x0924, B:557:0x0921, B:579:0x0946, B:578:0x0943, B:600:0x0968, B:599:0x0965, B:621:0x098a, B:620:0x0987, B:642:0x09ac, B:641:0x09a9, B:663:0x09ce, B:662:0x09cb, B:684:0x09f0, B:683:0x09ed, B:705:0x0a12, B:704:0x0a0f, B:726:0x0a34, B:725:0x0a31, B:747:0x0a56, B:746:0x0a53, B:768:0x0a78, B:767:0x0a75, B:721:0x0a2b, B:574:0x093d, B:742:0x0a4d, B:595:0x095f, B:763:0x0a6f, B:616:0x0981, B:637:0x09a3, B:490:0x08b5, B:658:0x09c5, B:511:0x08d7, B:679:0x09e7, B:532:0x08f9, B:700:0x0a09, B:553:0x091b), top: B:1207:0x033c, inners: #10, #24, #36, #52, #60, #74, #95, #106, #119, #131, #140, #152, #159, #170 }] */
    /* JADX WARN: Code duplicated, block: B:1489:? A[Catch: all -> 0x0a79, SYNTHETIC, TRY_LEAVE, TryCatch #65 {all -> 0x0a79, blocks: (B:470:0x0896, B:495:0x08be, B:494:0x08bb, B:516:0x08e0, B:515:0x08dd, B:537:0x0902, B:536:0x08ff, B:558:0x0924, B:557:0x0921, B:579:0x0946, B:578:0x0943, B:600:0x0968, B:599:0x0965, B:621:0x098a, B:620:0x0987, B:642:0x09ac, B:641:0x09a9, B:663:0x09ce, B:662:0x09cb, B:684:0x09f0, B:683:0x09ed, B:705:0x0a12, B:704:0x0a0f, B:726:0x0a34, B:725:0x0a31, B:747:0x0a56, B:746:0x0a53, B:768:0x0a78, B:767:0x0a75, B:721:0x0a2b, B:574:0x093d, B:742:0x0a4d, B:595:0x095f, B:763:0x0a6f, B:616:0x0981, B:637:0x09a3, B:490:0x08b5, B:658:0x09c5, B:511:0x08d7, B:679:0x09e7, B:532:0x08f9, B:700:0x0a09, B:553:0x091b), top: B:1207:0x033c, inners: #10, #24, #36, #52, #60, #74, #95, #106, #119, #131, #140, #152, #159, #170 }] */
    /* JADX WARN: Code duplicated, block: B:1493:? A[Catch: all -> 0x0a79, SYNTHETIC, TRY_LEAVE, TryCatch #65 {all -> 0x0a79, blocks: (B:470:0x0896, B:495:0x08be, B:494:0x08bb, B:516:0x08e0, B:515:0x08dd, B:537:0x0902, B:536:0x08ff, B:558:0x0924, B:557:0x0921, B:579:0x0946, B:578:0x0943, B:600:0x0968, B:599:0x0965, B:621:0x098a, B:620:0x0987, B:642:0x09ac, B:641:0x09a9, B:663:0x09ce, B:662:0x09cb, B:684:0x09f0, B:683:0x09ed, B:705:0x0a12, B:704:0x0a0f, B:726:0x0a34, B:725:0x0a31, B:747:0x0a56, B:746:0x0a53, B:768:0x0a78, B:767:0x0a75, B:721:0x0a2b, B:574:0x093d, B:742:0x0a4d, B:595:0x095f, B:763:0x0a6f, B:616:0x0981, B:637:0x09a3, B:490:0x08b5, B:658:0x09c5, B:511:0x08d7, B:679:0x09e7, B:532:0x08f9, B:700:0x0a09, B:553:0x091b), top: B:1207:0x033c, inners: #10, #24, #36, #52, #60, #74, #95, #106, #119, #131, #140, #152, #159, #170 }] */
    /* JADX WARN: Code duplicated, block: B:1503:? A[Catch: all -> 0x0b60, SYNTHETIC, TRY_LEAVE, TryCatch #47 {all -> 0x0b60, blocks: (B:773:0x0a85, B:848:0x0b5f, B:847:0x0b5c, B:843:0x0b56), top: B:1179:0x032c, inners: #43 }] */
    /* JADX WARN: Code duplicated, block: B:1505:? A[Catch: all -> 0x0b72, SYNTHETIC, TRY_LEAVE, TryCatch #59 {all -> 0x0b72, blocks: (B:775:0x0a8a, B:860:0x0b71, B:859:0x0b6e, B:855:0x0b68), top: B:1198:0x031d, inners: #57 }] */
    /* JADX WARN: Code duplicated, block: B:1507:? A[Catch: all -> 0x0b84, SYNTHETIC, TRY_LEAVE, TryCatch #73 {all -> 0x0b84, blocks: (B:777:0x0a8f, B:872:0x0b83, B:871:0x0b80, B:867:0x0b7a), top: B:1221:0x0317, inners: #68 }] */
    /* JADX WARN: Code duplicated, block: B:1509:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1523:? A[Catch: all -> 0x0bf8, SYNTHETIC, TRY_LEAVE, TryCatch #149 {all -> 0x0bf8, blocks: (B:139:0x0253, B:196:0x0302, B:946:0x0bf7, B:945:0x0bf4, B:140:0x0259, B:152:0x028b, B:153:0x028e, B:159:0x02a6, B:160:0x02a9, B:166:0x02c1, B:167:0x02c4, B:169:0x02c8, B:175:0x02e0, B:194:0x02ff, B:193:0x02fc, B:901:0x0bb1, B:900:0x0bae, B:919:0x0bcd, B:918:0x0bca, B:937:0x0be9, B:936:0x0be6, B:161:0x02af, B:164:0x02bc, B:892:0x0ba3, B:891:0x0ba0, B:162:0x02b5, B:887:0x0b9a, B:896:0x0ba8, B:154:0x0294, B:157:0x02a1, B:910:0x0bbf, B:909:0x0bbc, B:155:0x029a, B:905:0x0bb6, B:914:0x0bc4, B:141:0x025f, B:150:0x0286, B:928:0x0bdb, B:927:0x0bd8, B:142:0x0265, B:144:0x0269, B:146:0x026d, B:148:0x0271, B:923:0x0bd2, B:932:0x0be0, B:170:0x02ce, B:173:0x02db, B:185:0x02f1, B:184:0x02ee, B:189:0x02f6, B:941:0x0bee), top: B:1353:0x0253, inners: #139, #146 }] */
    /* JADX WARN: Code duplicated, block: B:1525:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1535:? A[Catch: all -> 0x0c4c, SYNTHETIC, TRY_LEAVE, TryCatch #34 {all -> 0x0c4c, blocks: (B:77:0x0187, B:109:0x01dc, B:999:0x0c4b, B:998:0x0c48, B:78:0x018d, B:79:0x0193, B:81:0x0199, B:87:0x01b5, B:106:0x01d4, B:105:0x01d1, B:107:0x01d5, B:82:0x01a5, B:85:0x01b0, B:97:0x01c6, B:96:0x01c3, B:101:0x01cb, B:994:0x0c42), top: B:1155:0x0187, outer: #94, inners: #22, #29 }] */
    /* JADX WARN: Code duplicated, block: B:1537:? A[Catch: all -> 0x0ca4, SYNTHETIC, TRY_LEAVE, TryCatch #94 {all -> 0x0ca4, blocks: (B:19:0x007f, B:41:0x00da, B:42:0x00dd, B:49:0x00f6, B:50:0x00fa, B:52:0x0100, B:53:0x010a, B:55:0x0112, B:58:0x0129, B:60:0x0131, B:63:0x0148, B:64:0x014e, B:66:0x0154, B:67:0x015e, B:75:0x017e, B:76:0x0181, B:111:0x01e1, B:112:0x01e4, B:122:0x020d, B:123:0x0210, B:133:0x0239, B:972:0x0c21, B:971:0x0c1e, B:990:0x0c3d, B:989:0x0c3a, B:1008:0x0c59, B:1007:0x0c56, B:1030:0x0c79, B:1029:0x0c76, B:62:0x0139, B:57:0x011a, B:1034:0x0c7d, B:1058:0x0ca3, B:1057:0x0ca0, B:113:0x01ea, B:120:0x0208, B:981:0x0c2f, B:980:0x0c2c, B:114:0x01f0, B:115:0x01f6, B:117:0x01fc, B:976:0x0c26, B:985:0x0c34, B:77:0x0187, B:109:0x01dc, B:999:0x0c4b, B:998:0x0c48, B:78:0x018d, B:79:0x0193, B:81:0x0199, B:87:0x01b5, B:106:0x01d4, B:105:0x01d1, B:107:0x01d5, B:82:0x01a5, B:85:0x01b0, B:97:0x01c6, B:96:0x01c3, B:101:0x01cb, B:994:0x0c42, B:1003:0x0c50, B:68:0x0164, B:73:0x0179, B:1021:0x0c6b, B:1020:0x0c68, B:69:0x016a, B:1012:0x0c5d, B:70:0x016b, B:71:0x0176, B:1016:0x0c62, B:1025:0x0c70, B:43:0x00de, B:45:0x00e6, B:47:0x00f3, B:20:0x0085, B:39:0x00d5, B:1049:0x0c95, B:1048:0x0c92, B:21:0x008b, B:23:0x008f, B:35:0x00cc, B:37:0x00d0, B:1037:0x0c80, B:1039:0x0c84, B:1040:0x0c87, B:24:0x0092, B:26:0x009a, B:28:0x00a2, B:29:0x00ad, B:30:0x00b3, B:32:0x00bb, B:1044:0x0c8c, B:1053:0x0c9a, B:124:0x0216, B:131:0x0234, B:963:0x0c13, B:962:0x0c10, B:967:0x0c18), top: B:1256:0x007f, outer: #104, inners: #12, #18, #34, #38, #58, #62, #66, #84, #89, #165, #168 }] */
    /* JADX WARN: Code duplicated, block: B:1548:? A[Catch: all -> 0x0cb2, SYNTHETIC, TRY_LEAVE, TryCatch #104 {all -> 0x0cb2, blocks: (B:18:0x0079, B:135:0x023e, B:1067:0x0cb1, B:1066:0x0cae, B:19:0x007f, B:41:0x00da, B:42:0x00dd, B:49:0x00f6, B:50:0x00fa, B:52:0x0100, B:53:0x010a, B:55:0x0112, B:58:0x0129, B:60:0x0131, B:63:0x0148, B:64:0x014e, B:66:0x0154, B:67:0x015e, B:75:0x017e, B:76:0x0181, B:111:0x01e1, B:112:0x01e4, B:122:0x020d, B:123:0x0210, B:133:0x0239, B:972:0x0c21, B:971:0x0c1e, B:990:0x0c3d, B:989:0x0c3a, B:1008:0x0c59, B:1007:0x0c56, B:1030:0x0c79, B:1029:0x0c76, B:62:0x0139, B:57:0x011a, B:1034:0x0c7d, B:1058:0x0ca3, B:1057:0x0ca0, B:113:0x01ea, B:120:0x0208, B:981:0x0c2f, B:980:0x0c2c, B:114:0x01f0, B:115:0x01f6, B:117:0x01fc, B:976:0x0c26, B:985:0x0c34, B:77:0x0187, B:109:0x01dc, B:999:0x0c4b, B:998:0x0c48, B:78:0x018d, B:79:0x0193, B:81:0x0199, B:87:0x01b5, B:106:0x01d4, B:105:0x01d1, B:107:0x01d5, B:82:0x01a5, B:85:0x01b0, B:97:0x01c6, B:96:0x01c3, B:101:0x01cb, B:994:0x0c42, B:1003:0x0c50, B:68:0x0164, B:73:0x0179, B:1021:0x0c6b, B:1020:0x0c68, B:69:0x016a, B:1012:0x0c5d, B:70:0x016b, B:71:0x0176, B:1016:0x0c62, B:1025:0x0c70, B:43:0x00de, B:45:0x00e6, B:47:0x00f3, B:20:0x0085, B:39:0x00d5, B:1049:0x0c95, B:1048:0x0c92, B:21:0x008b, B:23:0x008f, B:35:0x00cc, B:37:0x00d0, B:1037:0x0c80, B:1039:0x0c84, B:1040:0x0c87, B:24:0x0092, B:26:0x009a, B:28:0x00a2, B:29:0x00ad, B:30:0x00b3, B:32:0x00bb, B:1044:0x0c8c, B:1053:0x0c9a, B:124:0x0216, B:131:0x0234, B:963:0x0c13, B:962:0x0c10, B:967:0x0c18, B:1062:0x0ca8), top: B:1273:0x0079, inners: #94, #98 }] */
    /* JADX WARN: Code duplicated, block: B:1550:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:396:0x060b A[Catch: all -> 0x089d, TRY_ENTER, TryCatch #87 {all -> 0x089d, blocks: (B:388:0x05e8, B:396:0x060b, B:398:0x0654), top: B:1243:0x05e8 }] */
    /* JADX WARN: Code duplicated, block: B:398:0x0654 A[Catch: all -> 0x089d, TRY_LEAVE, TryCatch #87 {all -> 0x089d, blocks: (B:388:0x05e8, B:396:0x060b, B:398:0x0654), top: B:1243:0x05e8 }] */
    /* JADX WARN: Code duplicated, block: B:401:0x068e A[Catch: all -> 0x0741, TryCatch #25 {all -> 0x0741, blocks: (B:399:0x065a, B:401:0x068e, B:403:0x06a0), top: B:1139:0x065a }] */
    /* JADX WARN: Code duplicated, block: B:403:0x06a0 A[Catch: all -> 0x0741, TRY_LEAVE, TryCatch #25 {all -> 0x0741, blocks: (B:399:0x065a, B:401:0x068e, B:403:0x06a0), top: B:1139:0x065a }] */
    /* JADX WARN: Code duplicated, block: B:407:0x06c9 A[Catch: all -> 0x0721, TryCatch #1 {all -> 0x0721, blocks: (B:405:0x06b4, B:407:0x06c9, B:409:0x06d5, B:411:0x06e1), top: B:1096:0x06b4 }] */
    /* JADX WARN: Code duplicated, block: B:409:0x06d5 A[Catch: all -> 0x0721, TryCatch #1 {all -> 0x0721, blocks: (B:405:0x06b4, B:407:0x06c9, B:409:0x06d5, B:411:0x06e1), top: B:1096:0x06b4 }] */
    /* JADX WARN: Code duplicated, block: B:410:0x06df  */
    /* JADX WARN: Code duplicated, block: B:416:0x0723  */
    /* JADX WARN: Code duplicated, block: B:420:0x073d A[Catch: all -> 0x089b, TRY_ENTER, TRY_LEAVE, TryCatch #86 {all -> 0x089b, blocks: (B:431:0x0750, B:430:0x074d, B:420:0x073d, B:433:0x0757, B:435:0x075b, B:456:0x087d, B:466:0x088e, B:465:0x088b, B:426:0x0747, B:436:0x0761, B:438:0x0786, B:442:0x07c8, B:444:0x07f5, B:446:0x0805, B:448:0x0810, B:451:0x0869, B:454:0x0876, B:461:0x0885), top: B:1242:0x0652, inners: #33, #72, #78 }] */
    /* JADX WARN: Code duplicated, block: B:432:0x0751  */
    /* JADX WARN: Code duplicated, block: B:435:0x075b A[Catch: all -> 0x089b, TRY_LEAVE, TryCatch #86 {all -> 0x089b, blocks: (B:431:0x0750, B:430:0x074d, B:420:0x073d, B:433:0x0757, B:435:0x075b, B:456:0x087d, B:466:0x088e, B:465:0x088b, B:426:0x0747, B:436:0x0761, B:438:0x0786, B:442:0x07c8, B:444:0x07f5, B:446:0x0805, B:448:0x0810, B:451:0x0869, B:454:0x0876, B:461:0x0885), top: B:1242:0x0652, inners: #33, #72, #78 }] */
    /* JADX WARN: Code duplicated, block: B:438:0x0786 A[Catch: all -> 0x0881, TryCatch #72 {all -> 0x0881, blocks: (B:436:0x0761, B:438:0x0786, B:442:0x07c8, B:444:0x07f5, B:446:0x0805, B:448:0x0810, B:451:0x0869, B:454:0x0876), top: B:1219:0x0761, outer: #86 }] */
    /* JADX WARN: Code duplicated, block: B:450:0x0864  */
    /* JADX WARN: Code duplicated, block: B:454:0x0876 A[Catch: all -> 0x0881, TRY_LEAVE, TryCatch #72 {all -> 0x0881, blocks: (B:436:0x0761, B:438:0x0786, B:442:0x07c8, B:444:0x07f5, B:446:0x0805, B:448:0x0810, B:451:0x0869, B:454:0x0876), top: B:1219:0x0761, outer: #86 }] */
    /* JADX WARN: Code duplicated, block: B:456:0x087d A[Catch: all -> 0x089b, TRY_ENTER, TRY_LEAVE, TryCatch #86 {all -> 0x089b, blocks: (B:431:0x0750, B:430:0x074d, B:420:0x073d, B:433:0x0757, B:435:0x075b, B:456:0x087d, B:466:0x088e, B:465:0x088b, B:426:0x0747, B:436:0x0761, B:438:0x0786, B:442:0x07c8, B:444:0x07f5, B:446:0x0805, B:448:0x0810, B:451:0x0869, B:454:0x0876, B:461:0x0885), top: B:1242:0x0652, inners: #33, #72, #78 }] */
    /* JADX WARN: Code duplicated, block: B:771:0x0a7c  */
    @Override // com.google.android.libraries.geo.mapcore.renderer.bx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g() throws Throwable {
        com.google.android.libraries.navigation.internal.yz.ev evVarO;
        Throwable th;
        Throwable th2;
        Throwable th3;
        Throwable th4;
        com.google.android.libraries.navigation.internal.yz.ev evVar;
        lv lvVar;
        int i;
        com.google.android.libraries.navigation.internal.nw.d dVarB;
        Throwable th5;
        com.google.android.libraries.navigation.internal.nw.d dVarB2;
        Throwable th6;
        com.google.android.libraries.navigation.internal.nw.d dVarB3;
        Throwable th7;
        com.google.android.libraries.navigation.internal.nw.d dVarB4;
        Throwable th8;
        Throwable th9;
        com.google.android.libraries.navigation.internal.nw.d dVarB5;
        Throwable th10;
        com.google.android.libraries.navigation.internal.nw.d dVarB6;
        Throwable th11;
        com.google.android.libraries.navigation.internal.nw.d dVarB7;
        Throwable th12;
        com.google.android.libraries.navigation.internal.nw.d dVarB8;
        Throwable th13;
        com.google.android.libraries.navigation.internal.nw.d dVarB9;
        Throwable th14;
        com.google.android.libraries.navigation.internal.nw.d dVarB10;
        Throwable th15;
        com.google.android.libraries.navigation.internal.nw.d dVarB11;
        Throwable th16;
        com.google.android.libraries.navigation.internal.nw.d dVarB12;
        Throwable th17;
        com.google.android.libraries.navigation.internal.nw.d dVarB13;
        Throwable th18;
        Throwable th19;
        Throwable th20;
        float[] fArr;
        com.google.android.libraries.navigation.internal.nw.d dVarB14;
        ArrayList arrayList;
        int size;
        boolean z;
        byte b2;
        int i2;
        com.google.android.libraries.navigation.internal.rn.b bVarC;
        com.google.android.libraries.navigation.internal.nw.d dVarB15;
        ArrayList arrayList2;
        int size2;
        int i3;
        byte b3;
        ed edVar;
        com.google.android.libraries.navigation.internal.rn.b bVarA;
        byte b4;
        ArrayList arrayList3;
        int size3;
        int i4;
        com.google.android.libraries.navigation.internal.yz.ev evVarZ = z();
        lv lvVar2 = (lv) evVarZ;
        int i5 = lvVar2.c;
        for (int i6 = 0; i6 < i5; i6++) {
            ((cb) evVarZ.get(i6)).b();
        }
        if (this.k == null || this.l == null) {
            return;
        }
        ea.a(ea.IDLE, ea.BEGIN_FRAME);
        com.google.android.libraries.navigation.internal.nw.d dVarB16 = com.google.android.libraries.navigation.internal.nw.e.b("beginFrame");
        try {
            com.google.android.libraries.navigation.internal.nw.a aVarA = com.google.android.libraries.navigation.internal.nw.b.a("beginFrame");
            try {
                this.Z.set(false);
                this.aa.c(false);
                long jA = this.y.a();
                int iP = this.k.p();
                int iO = this.k.o();
                this.l.b(iP, iO);
                this.r.p();
                if (aVarA != null) {
                    aVarA.close();
                }
                if (dVarB16 != null) {
                    Trace.endSection();
                }
                ea.a(ea.BEGIN_FRAME, ea.UPDATE);
                com.google.android.libraries.navigation.internal.nw.d dVarB17 = com.google.android.libraries.navigation.internal.nw.e.b("update");
                try {
                    com.google.android.libraries.navigation.internal.nw.a aVarA2 = com.google.android.libraries.navigation.internal.nw.b.a("update");
                    try {
                        com.google.android.libraries.navigation.internal.nw.d dVarB18 = com.google.android.libraries.navigation.internal.nw.e.b("applyPending");
                        try {
                            com.google.android.libraries.navigation.internal.nw.a aVarA3 = com.google.android.libraries.navigation.internal.nw.b.a("applyPending");
                            try {
                                dp dpVar = this.q;
                                if (dpVar != null) {
                                    dpVar.a();
                                }
                                try {
                                    long j = this.C;
                                    if (j > 0) {
                                        long jNanoTime = System.nanoTime() + j;
                                        do {
                                            dm dmVarA = this.e.a();
                                            if (dmVarA == null) {
                                                break;
                                            } else {
                                                dmVarA.a(this.r, this.W, this.q);
                                            }
                                        } while (System.nanoTime() <= jNanoTime);
                                    } else {
                                        while (true) {
                                            dm dmVarA2 = this.e.a();
                                            if (dmVarA2 == null) {
                                                break;
                                            } else {
                                                dmVarA2.a(this.r, this.W, this.q);
                                            }
                                        }
                                    }
                                    dp dpVar2 = this.q;
                                    if (dpVar2 != null) {
                                        dpVar2.d();
                                    }
                                    if (aVarA3 != null) {
                                        aVarA3.close();
                                    }
                                    if (dVarB18 != null) {
                                        Trace.endSection();
                                    }
                                    synchronized (this) {
                                        if (this.G.isEmpty()) {
                                            evVarO = null;
                                        } else {
                                            evVarO = com.google.android.libraries.navigation.internal.yz.ev.o(this.G);
                                            this.G.clear();
                                        }
                                    }
                                    if (evVarO != null) {
                                        no it2 = evVarO.iterator();
                                        while (it2.hasNext()) {
                                            ((Runnable) it2.next()).run();
                                        }
                                    }
                                    if (!this.v.isEmpty() || !this.ag.isEmpty()) {
                                        this.ag = com.google.android.libraries.navigation.internal.yz.ev.o(this.v);
                                        this.v = new ArrayList();
                                    }
                                    if (!this.w.isEmpty() || !this.ah.isEmpty()) {
                                        this.ah = com.google.android.libraries.navigation.internal.yz.ev.o(this.w);
                                        this.w = new ArrayList();
                                    }
                                    Iterator it3 = this.h.iterator();
                                    while (it3.hasNext()) {
                                        ((Runnable) it3.next()).run();
                                    }
                                    com.google.android.libraries.navigation.internal.nw.d dVarB19 = com.google.android.libraries.navigation.internal.nw.e.b("swap scheduledBehaviors - activeBehaviors");
                                    try {
                                        com.google.android.libraries.navigation.internal.nw.a aVarA4 = com.google.android.libraries.navigation.internal.nw.b.a("swap scheduledBehaviors - activeBehaviors");
                                        try {
                                            synchronized (this) {
                                                try {
                                                    Set set = this.F;
                                                    this.F = this.E;
                                                    this.E = set;
                                                    set.clear();
                                                } catch (Throwable th21) {
                                                    throw th21;
                                                }
                                            }
                                            if (aVarA4 != null) {
                                                aVarA4.close();
                                            }
                                            if (dVarB19 != null) {
                                                Trace.endSection();
                                            }
                                            com.google.android.libraries.navigation.internal.nw.d dVarB20 = com.google.android.libraries.navigation.internal.nw.e.b("runScheduledBehaviors");
                                            try {
                                                com.google.android.libraries.navigation.internal.nw.a aVarA5 = com.google.android.libraries.navigation.internal.nw.b.a("runScheduledBehaviors");
                                                try {
                                                    for (Runnable runnable : this.F) {
                                                        com.google.android.libraries.navigation.internal.nw.d dVarB21 = com.google.android.libraries.navigation.internal.nw.e.b("runActiveBehavior");
                                                        try {
                                                            com.google.android.libraries.navigation.internal.nw.a aVarA6 = com.google.android.libraries.navigation.internal.nw.b.a("runActiveBehavior");
                                                            try {
                                                                runnable.run();
                                                                if (aVarA6 != null) {
                                                                    aVarA6.close();
                                                                }
                                                                if (dVarB21 != null) {
                                                                    Trace.endSection();
                                                                }
                                                            } catch (Throwable th22) {
                                                                if (aVarA6 == null) {
                                                                    throw th22;
                                                                }
                                                                try {
                                                                    aVarA6.close();
                                                                    throw th22;
                                                                } catch (Throwable th23) {
                                                                    th22.addSuppressed(th23);
                                                                    throw th22;
                                                                }
                                                                if (aVarA5 != null) {
                                                                    throw th;
                                                                }
                                                                try {
                                                                    aVarA5.close();
                                                                    throw th;
                                                                } catch (Throwable th24) {
                                                                    th.addSuppressed(th24);
                                                                    throw th;
                                                                }
                                                                if (aVarA2 == null) {
                                                                    throw th;
                                                                }
                                                                try {
                                                                    aVarA2.close();
                                                                    throw th;
                                                                } catch (Throwable th25) {
                                                                    th.addSuppressed(th25);
                                                                    throw th;
                                                                }
                                                            }
                                                        } catch (Throwable th26) {
                                                            if (dVarB21 == null) {
                                                                throw th26;
                                                            }
                                                            try {
                                                                Trace.endSection();
                                                                throw th26;
                                                            } catch (Throwable th27) {
                                                                th26.addSuppressed(th27);
                                                                throw th26;
                                                            }
                                                            if (dVarB20 != null) {
                                                                throw th;
                                                            }
                                                            try {
                                                                Trace.endSection();
                                                                throw th;
                                                            } catch (Throwable th28) {
                                                                th.addSuppressed(th28);
                                                                throw th;
                                                            }
                                                            if (dVarB17 == null) {
                                                                throw th;
                                                            }
                                                            try {
                                                                Trace.endSection();
                                                                throw th;
                                                            } catch (Throwable th29) {
                                                                th.addSuppressed(th29);
                                                                throw th;
                                                            }
                                                        }
                                                    }
                                                    this.F.clear();
                                                    if (aVarA5 != null) {
                                                        aVarA5.close();
                                                    }
                                                    if (dVarB20 != null) {
                                                        Trace.endSection();
                                                    }
                                                    com.google.android.libraries.navigation.internal.nw.d dVarB22 = com.google.android.libraries.navigation.internal.nw.e.b("onViewportChanged");
                                                    try {
                                                        com.google.android.libraries.navigation.internal.nw.a aVarA7 = com.google.android.libraries.navigation.internal.nw.b.a("onViewportChanged");
                                                        try {
                                                            Iterator it4 = this.H.iterator();
                                                            while (it4.hasNext()) {
                                                                ((Runnable) it4.next()).run();
                                                            }
                                                            if (aVarA7 != null) {
                                                                aVarA7.close();
                                                            }
                                                            if (dVarB22 != null) {
                                                                Trace.endSection();
                                                            }
                                                            com.google.android.libraries.navigation.internal.nw.d dVarB23 = com.google.android.libraries.navigation.internal.nw.e.b("updateEntities");
                                                            try {
                                                                com.google.android.libraries.navigation.internal.nw.a aVarA8 = com.google.android.libraries.navigation.internal.nw.b.a("updateEntities");
                                                                try {
                                                                    no it5 = this.W.iterator();
                                                                    while (it5.hasNext()) {
                                                                        ((dx) it5.next()).f(jA);
                                                                    }
                                                                    if (aVarA8 != null) {
                                                                        aVarA8.close();
                                                                    }
                                                                    if (dVarB23 != null) {
                                                                        Trace.endSection();
                                                                    }
                                                                    if (aVarA2 != null) {
                                                                        aVarA2.close();
                                                                    }
                                                                    if (dVarB17 != null) {
                                                                        Trace.endSection();
                                                                    }
                                                                    ea.a(ea.UPDATE, ea.PRE_DRAW);
                                                                    com.google.android.libraries.navigation.internal.nw.d dVarB24 = com.google.android.libraries.navigation.internal.nw.e.b("preDraw");
                                                                    try {
                                                                        com.google.android.libraries.navigation.internal.nw.a aVarA9 = com.google.android.libraries.navigation.internal.nw.b.a("preDraw");
                                                                        try {
                                                                            com.google.android.libraries.navigation.internal.nw.d dVarB25 = com.google.android.libraries.navigation.internal.nw.e.b("updateLabelingBehavior");
                                                                            try {
                                                                                com.google.android.libraries.navigation.internal.nw.a aVarA10 = com.google.android.libraries.navigation.internal.nw.b.a("updateLabelingBehavior");
                                                                                try {
                                                                                    if (this.f != null && this.ab != null && this.k != null) {
                                                                                        this.f.f(this.ab, this.k.p(), this.k.o());
                                                                                    }
                                                                                    if (aVarA10 != null) {
                                                                                        aVarA10.close();
                                                                                    }
                                                                                    if (dVarB25 != null) {
                                                                                        Trace.endSection();
                                                                                    }
                                                                                    com.google.android.libraries.navigation.internal.nw.d dVarB26 = com.google.android.libraries.navigation.internal.nw.e.b("labelAtlas2.uploadPendingBlocks");
                                                                                    try {
                                                                                        com.google.android.libraries.navigation.internal.nw.a aVarA11 = com.google.android.libraries.navigation.internal.nw.b.a("labelAtlas2.uploadPendingBlocks");
                                                                                        try {
                                                                                            this.m.i();
                                                                                            if (aVarA11 != null) {
                                                                                                aVarA11.close();
                                                                                            }
                                                                                            if (dVarB26 != null) {
                                                                                                Trace.endSection();
                                                                                            }
                                                                                            com.google.android.libraries.navigation.internal.nw.d dVarB27 = com.google.android.libraries.navigation.internal.nw.e.b("calloutAtlas2.uploadPendingBlocks");
                                                                                            try {
                                                                                                com.google.android.libraries.navigation.internal.nw.a aVarA12 = com.google.android.libraries.navigation.internal.nw.b.a("calloutAtlas2.uploadPendingBlocks");
                                                                                                try {
                                                                                                    this.f75n.i();
                                                                                                    if (aVarA12 != null) {
                                                                                                        aVarA12.close();
                                                                                                    }
                                                                                                    if (dVarB27 != null) {
                                                                                                        Trace.endSection();
                                                                                                    }
                                                                                                    if (this.o != null) {
                                                                                                        com.google.android.libraries.navigation.internal.nw.d dVarB28 = com.google.android.libraries.navigation.internal.nw.e.b("areaAtlas2.uploadPendingBlocks");
                                                                                                        try {
                                                                                                            com.google.android.libraries.navigation.internal.nw.a aVarA13 = com.google.android.libraries.navigation.internal.nw.b.a("areaAtlas2.uploadPendingBlocks");
                                                                                                            try {
                                                                                                                this.o.i();
                                                                                                                if (aVarA13 != null) {
                                                                                                                    aVarA13.close();
                                                                                                                }
                                                                                                                if (dVarB28 != null) {
                                                                                                                    Trace.endSection();
                                                                                                                }
                                                                                                            } catch (Throwable th30) {
                                                                                                                if (aVarA13 == null) {
                                                                                                                    throw th30;
                                                                                                                }
                                                                                                                try {
                                                                                                                    aVarA13.close();
                                                                                                                    throw th30;
                                                                                                                } catch (Throwable th31) {
                                                                                                                    th30.addSuppressed(th31);
                                                                                                                    throw th30;
                                                                                                                }
                                                                                                                if (aVarA9 == null) {
                                                                                                                    throw th;
                                                                                                                }
                                                                                                                try {
                                                                                                                    aVarA9.close();
                                                                                                                    throw th;
                                                                                                                } catch (Throwable th32) {
                                                                                                                    th.addSuppressed(th32);
                                                                                                                    throw th;
                                                                                                                }
                                                                                                            }
                                                                                                        } catch (Throwable th33) {
                                                                                                            if (dVarB28 == null) {
                                                                                                                throw th33;
                                                                                                            }
                                                                                                            try {
                                                                                                                Trace.endSection();
                                                                                                                throw th33;
                                                                                                            } catch (Throwable th34) {
                                                                                                                th33.addSuppressed(th34);
                                                                                                                throw th33;
                                                                                                            }
                                                                                                            if (dVarB24 == null) {
                                                                                                                throw th;
                                                                                                            }
                                                                                                            try {
                                                                                                                Trace.endSection();
                                                                                                                throw th;
                                                                                                            } catch (Throwable th35) {
                                                                                                                th.addSuppressed(th35);
                                                                                                                throw th;
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                    if (aVarA9 != null) {
                                                                                                        aVarA9.close();
                                                                                                    }
                                                                                                    if (dVarB24 != null) {
                                                                                                        Trace.endSection();
                                                                                                    }
                                                                                                    ea.a(ea.PRE_DRAW, ea.DRAW);
                                                                                                    com.google.android.libraries.navigation.internal.nw.d dVarB29 = com.google.android.libraries.navigation.internal.nw.e.b("draw");
                                                                                                    try {
                                                                                                        try {
                                                                                                            com.google.android.libraries.navigation.internal.nw.a aVarA14 = com.google.android.libraries.navigation.internal.nw.b.a("draw");
                                                                                                            try {
                                                                                                                try {
                                                                                                                    this.r.J(this.k.t, iP, iO);
                                                                                                                    com.google.android.libraries.navigation.internal.nw.d dVarB30 = com.google.android.libraries.navigation.internal.nw.e.b("drawMap");
                                                                                                                    try {
                                                                                                                        try {
                                                                                                                            com.google.android.libraries.navigation.internal.nw.a aVarA15 = com.google.android.libraries.navigation.internal.nw.b.a("drawMap");
                                                                                                                            try {
                                                                                                                                if (this.l == null || this.k == null) {
                                                                                                                                    evVar = evVarZ;
                                                                                                                                    lvVar = lvVar2;
                                                                                                                                    dVarB29 = dVarB29;
                                                                                                                                    i = 0;
                                                                                                                                } else {
                                                                                                                                    try {
                                                                                                                                        dVarB = com.google.android.libraries.navigation.internal.nw.e.b("drawUnderlays");
                                                                                                                                        try {
                                                                                                                                            com.google.android.libraries.navigation.internal.nw.a aVarA16 = com.google.android.libraries.navigation.internal.nw.b.a("drawUnderlays");
                                                                                                                                            try {
                                                                                                                                                this.J.c(this.l);
                                                                                                                                                if (aVarA16 != null) {
                                                                                                                                                    try {
                                                                                                                                                        aVarA16.close();
                                                                                                                                                    } catch (Throwable th36) {
                                                                                                                                                        th5 = th36;
                                                                                                                                                        dVarB29 = dVarB29;
                                                                                                                                                        if (dVarB != null) {
                                                                                                                                                            throw th5;
                                                                                                                                                        }
                                                                                                                                                        try {
                                                                                                                                                            Trace.endSection();
                                                                                                                                                            throw th5;
                                                                                                                                                        } catch (Throwable th37) {
                                                                                                                                                            th5.addSuppressed(th37);
                                                                                                                                                            throw th5;
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                                if (dVarB != null) {
                                                                                                                                                    try {
                                                                                                                                                        Trace.endSection();
                                                                                                                                                    } catch (Throwable th38) {
                                                                                                                                                        th4 = th38;
                                                                                                                                                        dVarB29 = dVarB29;
                                                                                                                                                        if (aVarA15 == null) {
                                                                                                                                                            throw th4;
                                                                                                                                                        }
                                                                                                                                                        try {
                                                                                                                                                            aVarA15.close();
                                                                                                                                                            throw th4;
                                                                                                                                                        } catch (Throwable th39) {
                                                                                                                                                            th4.addSuppressed(th39);
                                                                                                                                                            throw th4;
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                                dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("drawStencils");
                                                                                                                                                try {
                                                                                                                                                    com.google.android.libraries.navigation.internal.nw.a aVarA17 = com.google.android.libraries.navigation.internal.nw.b.a("drawStencils");
                                                                                                                                                    try {
                                                                                                                                                        this.K.c(this.l);
                                                                                                                                                        if (aVarA17 != null) {
                                                                                                                                                            try {
                                                                                                                                                                aVarA17.close();
                                                                                                                                                            } catch (Throwable th40) {
                                                                                                                                                                th6 = th40;
                                                                                                                                                                dVarB29 = dVarB29;
                                                                                                                                                                if (dVarB2 != null) {
                                                                                                                                                                    throw th6;
                                                                                                                                                                }
                                                                                                                                                                try {
                                                                                                                                                                    Trace.endSection();
                                                                                                                                                                    throw th6;
                                                                                                                                                                } catch (Throwable th41) {
                                                                                                                                                                    th6.addSuppressed(th41);
                                                                                                                                                                    throw th6;
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                        if (dVarB2 != null) {
                                                                                                                                                            Trace.endSection();
                                                                                                                                                        }
                                                                                                                                                        dVarB3 = com.google.android.libraries.navigation.internal.nw.e.b("drawBaseTiles");
                                                                                                                                                        try {
                                                                                                                                                            com.google.android.libraries.navigation.internal.nw.a aVarA18 = com.google.android.libraries.navigation.internal.nw.b.a("drawBaseTiles");
                                                                                                                                                            try {
                                                                                                                                                                this.L.c(this.l);
                                                                                                                                                                if (aVarA18 != null) {
                                                                                                                                                                    try {
                                                                                                                                                                        aVarA18.close();
                                                                                                                                                                    } catch (Throwable th42) {
                                                                                                                                                                        th7 = th42;
                                                                                                                                                                        dVarB29 = dVarB29;
                                                                                                                                                                        if (dVarB3 != null) {
                                                                                                                                                                            throw th7;
                                                                                                                                                                        }
                                                                                                                                                                        try {
                                                                                                                                                                            Trace.endSection();
                                                                                                                                                                            throw th7;
                                                                                                                                                                        } catch (Throwable th43) {
                                                                                                                                                                            th7.addSuppressed(th43);
                                                                                                                                                                            throw th7;
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                                if (dVarB3 != null) {
                                                                                                                                                                    Trace.endSection();
                                                                                                                                                                }
                                                                                                                                                                dVarB4 = com.google.android.libraries.navigation.internal.nw.e.b("drawIndoor");
                                                                                                                                                                try {
                                                                                                                                                                    com.google.android.libraries.navigation.internal.nw.a aVarA19 = com.google.android.libraries.navigation.internal.nw.b.a("drawIndoor");
                                                                                                                                                                    try {
                                                                                                                                                                        this.N.c(this.l);
                                                                                                                                                                        double dA = this.x.a(jA);
                                                                                                                                                                        if (dA != 0.0d) {
                                                                                                                                                                            try {
                                                                                                                                                                                l lVar = this.ae;
                                                                                                                                                                                if (lVar != null) {
                                                                                                                                                                                    lVar.a(this.ai, dA);
                                                                                                                                                                                    if (!this.x.c(jA)) {
                                                                                                                                                                                        o();
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            } catch (Throwable th44) {
                                                                                                                                                                                th9 = th44;
                                                                                                                                                                                if (aVarA19 == null) {
                                                                                                                                                                                    throw th9;
                                                                                                                                                                                }
                                                                                                                                                                                try {
                                                                                                                                                                                    aVarA19.close();
                                                                                                                                                                                    throw th9;
                                                                                                                                                                                } catch (Throwable th45) {
                                                                                                                                                                                    th9.addSuppressed(th45);
                                                                                                                                                                                    throw th9;
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                        if (aVarA19 != null) {
                                                                                                                                                                            try {
                                                                                                                                                                                aVarA19.close();
                                                                                                                                                                            } catch (Throwable th46) {
                                                                                                                                                                                th8 = th46;
                                                                                                                                                                                dVarB29 = dVarB29;
                                                                                                                                                                                if (dVarB4 != null) {
                                                                                                                                                                                    throw th8;
                                                                                                                                                                                }
                                                                                                                                                                                try {
                                                                                                                                                                                    Trace.endSection();
                                                                                                                                                                                    throw th8;
                                                                                                                                                                                } catch (Throwable th47) {
                                                                                                                                                                                    th8.addSuppressed(th47);
                                                                                                                                                                                    throw th8;
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                        if (dVarB4 != null) {
                                                                                                                                                                            Trace.endSection();
                                                                                                                                                                        }
                                                                                                                                                                        dVarB5 = com.google.android.libraries.navigation.internal.nw.e.b("drawOverlayTiles");
                                                                                                                                                                        try {
                                                                                                                                                                            com.google.android.libraries.navigation.internal.nw.a aVarA20 = com.google.android.libraries.navigation.internal.nw.b.a("drawOverlayTiles");
                                                                                                                                                                            try {
                                                                                                                                                                                this.M.c(this.l);
                                                                                                                                                                                if (aVarA20 != null) {
                                                                                                                                                                                    try {
                                                                                                                                                                                        aVarA20.close();
                                                                                                                                                                                    } catch (Throwable th48) {
                                                                                                                                                                                        th10 = th48;
                                                                                                                                                                                        dVarB29 = dVarB29;
                                                                                                                                                                                        if (dVarB5 != null) {
                                                                                                                                                                                            throw th10;
                                                                                                                                                                                        }
                                                                                                                                                                                        try {
                                                                                                                                                                                            Trace.endSection();
                                                                                                                                                                                            throw th10;
                                                                                                                                                                                        } catch (Throwable th49) {
                                                                                                                                                                                            th10.addSuppressed(th49);
                                                                                                                                                                                            throw th10;
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                                if (dVarB5 != null) {
                                                                                                                                                                                    Trace.endSection();
                                                                                                                                                                                }
                                                                                                                                                                                dVarB6 = com.google.android.libraries.navigation.internal.nw.e.b("drawTransit");
                                                                                                                                                                                try {
                                                                                                                                                                                    com.google.android.libraries.navigation.internal.nw.a aVarA21 = com.google.android.libraries.navigation.internal.nw.b.a("drawTransit");
                                                                                                                                                                                    try {
                                                                                                                                                                                        this.O.c(this.l);
                                                                                                                                                                                        if (aVarA21 != null) {
                                                                                                                                                                                            try {
                                                                                                                                                                                                aVarA21.close();
                                                                                                                                                                                            } catch (Throwable th50) {
                                                                                                                                                                                                th11 = th50;
                                                                                                                                                                                                dVarB29 = dVarB29;
                                                                                                                                                                                                if (dVarB6 != null) {
                                                                                                                                                                                                    throw th11;
                                                                                                                                                                                                }
                                                                                                                                                                                                try {
                                                                                                                                                                                                    Trace.endSection();
                                                                                                                                                                                                    throw th11;
                                                                                                                                                                                                } catch (Throwable th51) {
                                                                                                                                                                                                    th11.addSuppressed(th51);
                                                                                                                                                                                                    throw th11;
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                        if (dVarB6 != null) {
                                                                                                                                                                                            Trace.endSection();
                                                                                                                                                                                        }
                                                                                                                                                                                        dVarB7 = com.google.android.libraries.navigation.internal.nw.e.b("drawBicycling");
                                                                                                                                                                                        try {
                                                                                                                                                                                            com.google.android.libraries.navigation.internal.nw.a aVarA22 = com.google.android.libraries.navigation.internal.nw.b.a("drawBicycling");
                                                                                                                                                                                            try {
                                                                                                                                                                                                this.P.c(this.l);
                                                                                                                                                                                                if (aVarA22 != null) {
                                                                                                                                                                                                    try {
                                                                                                                                                                                                        aVarA22.close();
                                                                                                                                                                                                    } catch (Throwable th52) {
                                                                                                                                                                                                        th12 = th52;
                                                                                                                                                                                                        dVarB29 = dVarB29;
                                                                                                                                                                                                        if (dVarB7 != null) {
                                                                                                                                                                                                            throw th12;
                                                                                                                                                                                                        }
                                                                                                                                                                                                        try {
                                                                                                                                                                                                            Trace.endSection();
                                                                                                                                                                                                            throw th12;
                                                                                                                                                                                                        } catch (Throwable th53) {
                                                                                                                                                                                                            th12.addSuppressed(th53);
                                                                                                                                                                                                            throw th12;
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                                if (dVarB7 != null) {
                                                                                                                                                                                                    Trace.endSection();
                                                                                                                                                                                                }
                                                                                                                                                                                                dVarB8 = com.google.android.libraries.navigation.internal.nw.e.b("drawClientInjected");
                                                                                                                                                                                                try {
                                                                                                                                                                                                    com.google.android.libraries.navigation.internal.nw.a aVarA23 = com.google.android.libraries.navigation.internal.nw.b.a("drawClientInjected");
                                                                                                                                                                                                    try {
                                                                                                                                                                                                        this.i.c(this.l);
                                                                                                                                                                                                        if (aVarA23 != null) {
                                                                                                                                                                                                            try {
                                                                                                                                                                                                                aVarA23.close();
                                                                                                                                                                                                            } catch (Throwable th54) {
                                                                                                                                                                                                                th13 = th54;
                                                                                                                                                                                                                dVarB29 = dVarB29;
                                                                                                                                                                                                                if (dVarB8 != null) {
                                                                                                                                                                                                                    throw th13;
                                                                                                                                                                                                                }
                                                                                                                                                                                                                try {
                                                                                                                                                                                                                    Trace.endSection();
                                                                                                                                                                                                                    throw th13;
                                                                                                                                                                                                                } catch (Throwable th55) {
                                                                                                                                                                                                                    th13.addSuppressed(th55);
                                                                                                                                                                                                                    throw th13;
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                        if (dVarB8 != null) {
                                                                                                                                                                                                            Trace.endSection();
                                                                                                                                                                                                        }
                                                                                                                                                                                                        dVarB9 = com.google.android.libraries.navigation.internal.nw.e.b("drawPolylineOverlays");
                                                                                                                                                                                                        try {
                                                                                                                                                                                                            com.google.android.libraries.navigation.internal.nw.a aVarA24 = com.google.android.libraries.navigation.internal.nw.b.a("drawPolylineOverlays");
                                                                                                                                                                                                            try {
                                                                                                                                                                                                                this.Q.c(this.l);
                                                                                                                                                                                                                if (aVarA24 != null) {
                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                        aVarA24.close();
                                                                                                                                                                                                                    } catch (Throwable th56) {
                                                                                                                                                                                                                        th14 = th56;
                                                                                                                                                                                                                        dVarB29 = dVarB29;
                                                                                                                                                                                                                        if (dVarB9 != null) {
                                                                                                                                                                                                                            throw th14;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                        try {
                                                                                                                                                                                                                            Trace.endSection();
                                                                                                                                                                                                                            throw th14;
                                                                                                                                                                                                                        } catch (Throwable th57) {
                                                                                                                                                                                                                            th14.addSuppressed(th57);
                                                                                                                                                                                                                            throw th14;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                                if (dVarB9 != null) {
                                                                                                                                                                                                                    Trace.endSection();
                                                                                                                                                                                                                }
                                                                                                                                                                                                                if (this.p && !this.R.a.isEmpty()) {
                                                                                                                                                                                                                    com.google.android.libraries.navigation.internal.nw.d dVarB31 = com.google.android.libraries.navigation.internal.nw.e.b("drawBuildings");
                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                        com.google.android.libraries.navigation.internal.nw.a aVarA25 = com.google.android.libraries.navigation.internal.nw.b.a("drawBuildings");
                                                                                                                                                                                                                        try {
                                                                                                                                                                                                                            ((com.google.android.libraries.navigation.internal.km.t) this.s.a(com.google.android.libraries.navigation.internal.km.p.g)).b();
                                                                                                                                                                                                                            eh ehVar = this.R;
                                                                                                                                                                                                                            ArrayList arrayList4 = ehVar.a;
                                                                                                                                                                                                                            int size4 = arrayList4.size();
                                                                                                                                                                                                                            int i7 = 0;
                                                                                                                                                                                                                            while (i7 < size4) {
                                                                                                                                                                                                                                ((aj) arrayList4.get(i7)).b(jA);
                                                                                                                                                                                                                                i7++;
                                                                                                                                                                                                                                arrayList4 = arrayList4;
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                            Trace.setCounter("updatedEntities", ehVar.a.size());
                                                                                                                                                                                                                            this.af.a(this.R, this.l);
                                                                                                                                                                                                                            ((com.google.android.libraries.navigation.internal.km.t) this.s.a(com.google.android.libraries.navigation.internal.km.p.g)).c();
                                                                                                                                                                                                                            ((com.google.android.libraries.navigation.internal.km.t) this.s.a(com.google.android.libraries.navigation.internal.km.p.g)).a();
                                                                                                                                                                                                                            if (aVarA25 != null) {
                                                                                                                                                                                                                                aVarA25.close();
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                            if (dVarB31 != null) {
                                                                                                                                                                                                                                Trace.endSection();
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        } catch (Throwable th58) {
                                                                                                                                                                                                                            if (aVarA25 == null) {
                                                                                                                                                                                                                                throw th58;
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                aVarA25.close();
                                                                                                                                                                                                                                throw th58;
                                                                                                                                                                                                                            } catch (Throwable th59) {
                                                                                                                                                                                                                                th58.addSuppressed(th59);
                                                                                                                                                                                                                                throw th58;
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                            th4 = th38;
                                                                                                                                                                                                                            dVarB29 = dVarB29;
                                                                                                                                                                                                                            if (aVarA15 == null) {
                                                                                                                                                                                                                                throw th4;
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                            aVarA15.close();
                                                                                                                                                                                                                            throw th4;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    } catch (Throwable th60) {
                                                                                                                                                                                                                        if (dVarB31 == null) {
                                                                                                                                                                                                                            throw th60;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                        try {
                                                                                                                                                                                                                            Trace.endSection();
                                                                                                                                                                                                                            throw th60;
                                                                                                                                                                                                                        } catch (Throwable th61) {
                                                                                                                                                                                                                            th60.addSuppressed(th61);
                                                                                                                                                                                                                            throw th60;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                                dVarB10 = com.google.android.libraries.navigation.internal.nw.e.b("drawOccludedRoutes");
                                                                                                                                                                                                                try {
                                                                                                                                                                                                                    com.google.android.libraries.navigation.internal.nw.a aVarA26 = com.google.android.libraries.navigation.internal.nw.b.a("drawOccludedRoutes");
                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                        this.S.c(this.l);
                                                                                                                                                                                                                        if (aVarA26 != null) {
                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                aVarA26.close();
                                                                                                                                                                                                                            } catch (Throwable th62) {
                                                                                                                                                                                                                                th15 = th62;
                                                                                                                                                                                                                                dVarB29 = dVarB29;
                                                                                                                                                                                                                                if (dVarB10 != null) {
                                                                                                                                                                                                                                    throw th15;
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                try {
                                                                                                                                                                                                                                    Trace.endSection();
                                                                                                                                                                                                                                    throw th15;
                                                                                                                                                                                                                                } catch (Throwable th63) {
                                                                                                                                                                                                                                    th15.addSuppressed(th63);
                                                                                                                                                                                                                                    throw th15;
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                        if (dVarB10 != null) {
                                                                                                                                                                                                                            Trace.endSection();
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                        dVarB11 = com.google.android.libraries.navigation.internal.nw.e.b("drawGenericLabels");
                                                                                                                                                                                                                        try {
                                                                                                                                                                                                                            com.google.android.libraries.navigation.internal.nw.a aVarA27 = com.google.android.libraries.navigation.internal.nw.b.a("drawGenericLabels");
                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                this.T.c(this.l);
                                                                                                                                                                                                                                if (aVarA27 != null) {
                                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                                        aVarA27.close();
                                                                                                                                                                                                                                    } catch (Throwable th64) {
                                                                                                                                                                                                                                        th16 = th64;
                                                                                                                                                                                                                                        dVarB29 = dVarB29;
                                                                                                                                                                                                                                        if (dVarB11 != null) {
                                                                                                                                                                                                                                            throw th16;
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                        try {
                                                                                                                                                                                                                                            Trace.endSection();
                                                                                                                                                                                                                                            throw th16;
                                                                                                                                                                                                                                        } catch (Throwable th65) {
                                                                                                                                                                                                                                            th16.addSuppressed(th65);
                                                                                                                                                                                                                                            throw th16;
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                if (dVarB11 != null) {
                                                                                                                                                                                                                                    Trace.endSection();
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                dVarB12 = com.google.android.libraries.navigation.internal.nw.e.b("drawMyMaps");
                                                                                                                                                                                                                                try {
                                                                                                                                                                                                                                    com.google.android.libraries.navigation.internal.nw.a aVarA28 = com.google.android.libraries.navigation.internal.nw.b.a("drawMyMaps");
                                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                                        this.U.c(this.l);
                                                                                                                                                                                                                                        if (aVarA28 != null) {
                                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                                aVarA28.close();
                                                                                                                                                                                                                                            } catch (Throwable th66) {
                                                                                                                                                                                                                                                th17 = th66;
                                                                                                                                                                                                                                                dVarB29 = dVarB29;
                                                                                                                                                                                                                                                if (dVarB12 != null) {
                                                                                                                                                                                                                                                    throw th17;
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                try {
                                                                                                                                                                                                                                                    Trace.endSection();
                                                                                                                                                                                                                                                    throw th17;
                                                                                                                                                                                                                                                } catch (Throwable th67) {
                                                                                                                                                                                                                                                    th17.addSuppressed(th67);
                                                                                                                                                                                                                                                    throw th17;
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                        if (dVarB12 != null) {
                                                                                                                                                                                                                                            Trace.endSection();
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                        dVarB13 = com.google.android.libraries.navigation.internal.nw.e.b("drawNonPortedEntities");
                                                                                                                                                                                                                                        try {
                                                                                                                                                                                                                                            com.google.android.libraries.navigation.internal.nw.a aVarA29 = com.google.android.libraries.navigation.internal.nw.b.a("drawNonPortedEntities");
                                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                                this.j.c(this.l);
                                                                                                                                                                                                                                                if (aVarA29 != null) {
                                                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                                                        aVarA29.close();
                                                                                                                                                                                                                                                    } catch (Throwable th68) {
                                                                                                                                                                                                                                                        th18 = th68;
                                                                                                                                                                                                                                                        dVarB29 = dVarB29;
                                                                                                                                                                                                                                                        if (dVarB13 != null) {
                                                                                                                                                                                                                                                            throw th18;
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                        try {
                                                                                                                                                                                                                                                            Trace.endSection();
                                                                                                                                                                                                                                                            throw th18;
                                                                                                                                                                                                                                                        } catch (Throwable th69) {
                                                                                                                                                                                                                                                            th18.addSuppressed(th69);
                                                                                                                                                                                                                                                            throw th18;
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                if (dVarB13 != null) {
                                                                                                                                                                                                                                                    Trace.endSection();
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                if (this.ad != null) {
                                                                                                                                                                                                                                                    com.google.android.libraries.navigation.internal.nw.d dVarB32 = com.google.android.libraries.navigation.internal.nw.e.b("drawMeshPainter");
                                                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                                                        try {
                                                                                                                                                                                                                                                            com.google.android.libraries.navigation.internal.nw.a aVarA30 = com.google.android.libraries.navigation.internal.nw.b.a("drawMeshPainter");
                                                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                                                dh dhVar = this.ad;
                                                                                                                                                                                                                                                                u uVar = this.l;
                                                                                                                                                                                                                                                                if (dhVar.c.isEmpty()) {
                                                                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                                                                        if (dhVar.d.isEmpty()) {
                                                                                                                                                                                                                                                                            evVar = evVarZ;
                                                                                                                                                                                                                                                                            lvVar = lvVar2;
                                                                                                                                                                                                                                                                            dVarB29 = dVarB29;
                                                                                                                                                                                                                                                                        } else {
                                                                                                                                                                                                                                                                            bv bvVar = dhVar.b;
                                                                                                                                                                                                                                                                            GLES20.glDisable(2884);
                                                                                                                                                                                                                                                                            bv bvVar2 = dhVar.b;
                                                                                                                                                                                                                                                                            GLES20.glEnable(3042);
                                                                                                                                                                                                                                                                            bv bvVar3 = dhVar.b;
                                                                                                                                                                                                                                                                            GLES20.glEnable(2929);
                                                                                                                                                                                                                                                                            GLES20.glDepthMask(true);
                                                                                                                                                                                                                                                                            GLES20.glDepthFunc(513);
                                                                                                                                                                                                                                                                            bv bvVar4 = dhVar.b;
                                                                                                                                                                                                                                                                            GLES20.glDisable(2960);
                                                                                                                                                                                                                                                                            GLES20.glClearDepthf(1.0f);
                                                                                                                                                                                                                                                                            GLES20.glClear(256);
                                                                                                                                                                                                                                                                            fArr = ((v) uVar.e.get()).v;
                                                                                                                                                                                                                                                                            GLES20.glEnableVertexAttribArray(0);
                                                                                                                                                                                                                                                                            GLES20.glEnableVertexAttribArray(1);
                                                                                                                                                                                                                                                                            GLES20.glEnableVertexAttribArray(2);
                                                                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                                                                if (dhVar.c != null) {
                                                                                                                                                                                                                                                                                    dVarB15 = com.google.android.libraries.navigation.internal.nw.e.b("drawStaticMeshes");
                                                                                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                                                                                        GLES20.glUseProgram(dhVar.g);
                                                                                                                                                                                                                                                                                        GLES20.glUniform1i(dhVar.l, 0);
                                                                                                                                                                                                                                                                                        evVar = evVarZ;
                                                                                                                                                                                                                                                                                        GLES20.glUniform3f(dhVar.m, -fArr[8], fArr[9], fArr[10]);
                                                                                                                                                                                                                                                                                        dhVar.b.U(dhVar.k, uVar.G());
                                                                                                                                                                                                                                                                                        arrayList2 = dhVar.c;
                                                                                                                                                                                                                                                                                        size2 = arrayList2.size();
                                                                                                                                                                                                                                                                                        i3 = 0;
                                                                                                                                                                                                                                                                                        b3 = -1;
                                                                                                                                                                                                                                                                                        while (i3 < size2) {
                                                                                                                                                                                                                                                                                            edVar = (ed) arrayList2.get(i3);
                                                                                                                                                                                                                                                                                            ArrayList arrayList5 = arrayList2;
                                                                                                                                                                                                                                                                                            bVarA = edVar.a();
                                                                                                                                                                                                                                                                                            if (bVarA.a()) {
                                                                                                                                                                                                                                                                                                edVar.b();
                                                                                                                                                                                                                                                                                                float[] fArrC = edVar.c();
                                                                                                                                                                                                                                                                                                b4 = b3;
                                                                                                                                                                                                                                                                                                dVarB29 = dVarB29;
                                                                                                                                                                                                                                                                                                try {
                                                                                                                                                                                                                                                                                                    System.arraycopy(fArrC, 0, dhVar.i, 0, 16);
                                                                                                                                                                                                                                                                                                    dhVar.b.U(dhVar.j, dhVar.i);
                                                                                                                                                                                                                                                                                                    arrayList3 = bVarA.b;
                                                                                                                                                                                                                                                                                                    size3 = arrayList3.size();
                                                                                                                                                                                                                                                                                                    i4 = 0;
                                                                                                                                                                                                                                                                                                    while (i4 < size3) {
                                                                                                                                                                                                                                                                                                        com.google.android.libraries.navigation.internal.rn.a aVar = (com.google.android.libraries.navigation.internal.rn.a) arrayList3.get(i4);
                                                                                                                                                                                                                                                                                                        int i8 = aVar.b;
                                                                                                                                                                                                                                                                                                        int i9 = aVar.d;
                                                                                                                                                                                                                                                                                                        if (b4 != 0) {
                                                                                                                                                                                                                                                                                                            GLES20.glBindBuffer(34962, 0);
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                        GLES20.glVertexAttribPointer(0, 3, FujifilmMakernoteDirectory.TAG_MAX_APERTURE_AT_MIN_FOCAL, false, 32, 0);
                                                                                                                                                                                                                                                                                                        GLES20.glVertexAttribPointer(1, 2, FujifilmMakernoteDirectory.TAG_MAX_APERTURE_AT_MIN_FOCAL, false, 32, 12);
                                                                                                                                                                                                                                                                                                        GLES20.glVertexAttribPointer(2, 3, FujifilmMakernoteDirectory.TAG_MAX_APERTURE_AT_MIN_FOCAL, false, 32, 20);
                                                                                                                                                                                                                                                                                                        com.google.android.libraries.navigation.internal.rn.c cVar = aVar.f;
                                                                                                                                                                                                                                                                                                        int i10 = aVar.a;
                                                                                                                                                                                                                                                                                                        GLES20.glDrawArrays(4, 0, 0);
                                                                                                                                                                                                                                                                                                        i4++;
                                                                                                                                                                                                                                                                                                        arrayList3 = arrayList3;
                                                                                                                                                                                                                                                                                                        b4 = 0;
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                    b3 = b4;
                                                                                                                                                                                                                                                                                                } catch (Throwable th70) {
                                                                                                                                                                                                                                                                                                    th = th70;
                                                                                                                                                                                                                                                                                                    Throwable th71 = th;
                                                                                                                                                                                                                                                                                                    if (dVarB15 == null) {
                                                                                                                                                                                                                                                                                                        throw th71;
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                                                                                                        Trace.endSection();
                                                                                                                                                                                                                                                                                                        throw th71;
                                                                                                                                                                                                                                                                                                    } catch (Throwable th72) {
                                                                                                                                                                                                                                                                                                        th71.addSuppressed(th72);
                                                                                                                                                                                                                                                                                                        throw th71;
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                                                                                dVarB29 = dVarB29;
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                            i3++;
                                                                                                                                                                                                                                                                                            arrayList2 = arrayList5;
                                                                                                                                                                                                                                                                                            size2 = size2;
                                                                                                                                                                                                                                                                                            lvVar2 = lvVar2;
                                                                                                                                                                                                                                                                                            dVarB29 = dVarB29;
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                        lvVar = lvVar2;
                                                                                                                                                                                                                                                                                        dVarB29 = dVarB29;
                                                                                                                                                                                                                                                                                        if (dVarB15 != null) {
                                                                                                                                                                                                                                                                                            Trace.endSection();
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                    } catch (Throwable th73) {
                                                                                                                                                                                                                                                                                        th = th73;
                                                                                                                                                                                                                                                                                        dVarB29 = dVarB29;
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                } else {
                                                                                                                                                                                                                                                                                    evVar = evVarZ;
                                                                                                                                                                                                                                                                                    lvVar = lvVar2;
                                                                                                                                                                                                                                                                                    dVarB29 = dVarB29;
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                if (dhVar.d != null) {
                                                                                                                                                                                                                                                                                    dVarB14 = com.google.android.libraries.navigation.internal.nw.e.b("drawAnimatedMeshes");
                                                                                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                                                                                        GLES20.glUseProgram(dhVar.h);
                                                                                                                                                                                                                                                                                        GLES20.glEnableVertexAttribArray(3);
                                                                                                                                                                                                                                                                                        GLES20.glUniform1i(dhVar.p, 0);
                                                                                                                                                                                                                                                                                        dhVar.b.U(dhVar.o, uVar.G());
                                                                                                                                                                                                                                                                                        arrayList = dhVar.d;
                                                                                                                                                                                                                                                                                        size = arrayList.size();
                                                                                                                                                                                                                                                                                        z = false;
                                                                                                                                                                                                                                                                                        b2 = -1;
                                                                                                                                                                                                                                                                                        i2 = 0;
                                                                                                                                                                                                                                                                                        while (i2 < size) {
                                                                                                                                                                                                                                                                                            ec ecVar = (ec) arrayList.get(i2);
                                                                                                                                                                                                                                                                                            ArrayList arrayList6 = arrayList;
                                                                                                                                                                                                                                                                                            int i11 = size;
                                                                                                                                                                                                                                                                                            byte b5 = b2;
                                                                                                                                                                                                                                                                                            GLES20.glUniform3fv(dhVar.q, 1, ecVar.g(), 0);
                                                                                                                                                                                                                                                                                            GLES20.glUniform3fv(dhVar.r, 2, ecVar.f(), 0);
                                                                                                                                                                                                                                                                                            ecVar.k();
                                                                                                                                                                                                                                                                                            ecVar.i();
                                                                                                                                                                                                                                                                                            ecVar.i();
                                                                                                                                                                                                                                                                                            ecVar.j();
                                                                                                                                                                                                                                                                                            float fA = ecVar.a();
                                                                                                                                                                                                                                                                                            int iB = ecVar.b();
                                                                                                                                                                                                                                                                                            bVarC = ecVar.c();
                                                                                                                                                                                                                                                                                            if (!bVarC.a() && iB != -1) {
                                                                                                                                                                                                                                                                                                boolean zE = ecVar.e() | z;
                                                                                                                                                                                                                                                                                                ecVar.d();
                                                                                                                                                                                                                                                                                                System.arraycopy(ecVar.h(), 0, dhVar.i, 0, 16);
                                                                                                                                                                                                                                                                                                dhVar.b.U(dhVar.f80n, dhVar.i);
                                                                                                                                                                                                                                                                                                GLES20.glUniform1f(dhVar.s, fA);
                                                                                                                                                                                                                                                                                                ArrayList arrayList7 = bVarC.b;
                                                                                                                                                                                                                                                                                                int size5 = arrayList7.size();
                                                                                                                                                                                                                                                                                                int i12 = 0;
                                                                                                                                                                                                                                                                                                while (i12 < size5) {
                                                                                                                                                                                                                                                                                                    com.google.android.libraries.navigation.internal.rn.a aVar2 = (com.google.android.libraries.navigation.internal.rn.a) arrayList7.get(i12);
                                                                                                                                                                                                                                                                                                    int i13 = aVar2.e;
                                                                                                                                                                                                                                                                                                    int i14 = aVar2.b;
                                                                                                                                                                                                                                                                                                    int i15 = aVar2.c;
                                                                                                                                                                                                                                                                                                    int i16 = aVar2.d;
                                                                                                                                                                                                                                                                                                    if (b5 != 0) {
                                                                                                                                                                                                                                                                                                        GLES20.glBindBuffer(34962, 0);
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                    GLES20.glVertexAttribPointer(0, 4, FujifilmMakernoteDirectory.TAG_MAX_APERTURE_AT_MIN_FOCAL, false, 32, 0);
                                                                                                                                                                                                                                                                                                    GLES20.glVertexAttribPointer(1, 4, FujifilmMakernoteDirectory.TAG_MAX_APERTURE_AT_MIN_FOCAL, false, 32, 16);
                                                                                                                                                                                                                                                                                                    GLES20.glVertexAttribPointer(2, 4, FujifilmMakernoteDirectory.TAG_MAX_APERTURE_AT_MIN_FOCAL, false, 32, 0);
                                                                                                                                                                                                                                                                                                    GLES20.glVertexAttribPointer(3, 4, FujifilmMakernoteDirectory.TAG_MAX_APERTURE_AT_MIN_FOCAL, false, 32, 16);
                                                                                                                                                                                                                                                                                                    com.google.android.libraries.navigation.internal.rn.c cVar2 = aVar2.f;
                                                                                                                                                                                                                                                                                                    int i17 = aVar2.a;
                                                                                                                                                                                                                                                                                                    GLES20.glDrawArrays(4, 0, 0);
                                                                                                                                                                                                                                                                                                    i12++;
                                                                                                                                                                                                                                                                                                    b5 = 0;
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                z = zE;
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                            i2++;
                                                                                                                                                                                                                                                                                            arrayList = arrayList6;
                                                                                                                                                                                                                                                                                            size = i11;
                                                                                                                                                                                                                                                                                            b2 = b5;
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                        i = 0;
                                                                                                                                                                                                                                                                                        if (z) {
                                                                                                                                                                                                                                                                                            dhVar.a.o();
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                        if (dVarB14 != null) {
                                                                                                                                                                                                                                                                                            Trace.endSection();
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                    } catch (Throwable th74) {
                                                                                                                                                                                                                                                                                        if (dVarB14 == null) {
                                                                                                                                                                                                                                                                                            throw th74;
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                        try {
                                                                                                                                                                                                                                                                                            Trace.endSection();
                                                                                                                                                                                                                                                                                            throw th74;
                                                                                                                                                                                                                                                                                        } catch (Throwable th75) {
                                                                                                                                                                                                                                                                                            th74.addSuppressed(th75);
                                                                                                                                                                                                                                                                                            throw th74;
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                            } catch (Throwable th76) {
                                                                                                                                                                                                                                                                                th = th76;
                                                                                                                                                                                                                                                                                th20 = th;
                                                                                                                                                                                                                                                                                if (aVarA30 != null) {
                                                                                                                                                                                                                                                                                    throw th20;
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                try {
                                                                                                                                                                                                                                                                                    aVarA30.close();
                                                                                                                                                                                                                                                                                    throw th20;
                                                                                                                                                                                                                                                                                } catch (Throwable th77) {
                                                                                                                                                                                                                                                                                    th20.addSuppressed(th77);
                                                                                                                                                                                                                                                                                    throw th20;
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                        i = 0;
                                                                                                                                                                                                                                                                    } catch (Throwable th78) {
                                                                                                                                                                                                                                                                        th20 = th78;
                                                                                                                                                                                                                                                                        dVarB29 = dVarB29;
                                                                                                                                                                                                                                                                        if (aVarA30 != null) {
                                                                                                                                                                                                                                                                            throw th20;
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                        aVarA30.close();
                                                                                                                                                                                                                                                                        throw th20;
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                } else {
                                                                                                                                                                                                                                                                    bv bvVar5 = dhVar.b;
                                                                                                                                                                                                                                                                    GLES20.glDisable(2884);
                                                                                                                                                                                                                                                                    bv bvVar6 = dhVar.b;
                                                                                                                                                                                                                                                                    GLES20.glEnable(3042);
                                                                                                                                                                                                                                                                    bv bvVar7 = dhVar.b;
                                                                                                                                                                                                                                                                    GLES20.glEnable(2929);
                                                                                                                                                                                                                                                                    GLES20.glDepthMask(true);
                                                                                                                                                                                                                                                                    GLES20.glDepthFunc(513);
                                                                                                                                                                                                                                                                    bv bvVar8 = dhVar.b;
                                                                                                                                                                                                                                                                    GLES20.glDisable(2960);
                                                                                                                                                                                                                                                                    GLES20.glClearDepthf(1.0f);
                                                                                                                                                                                                                                                                    GLES20.glClear(256);
                                                                                                                                                                                                                                                                    fArr = ((v) uVar.e.get()).v;
                                                                                                                                                                                                                                                                    GLES20.glEnableVertexAttribArray(0);
                                                                                                                                                                                                                                                                    GLES20.glEnableVertexAttribArray(1);
                                                                                                                                                                                                                                                                    GLES20.glEnableVertexAttribArray(2);
                                                                                                                                                                                                                                                                    if (dhVar.c != null) {
                                                                                                                                                                                                                                                                        dVarB15 = com.google.android.libraries.navigation.internal.nw.e.b("drawStaticMeshes");
                                                                                                                                                                                                                                                                        GLES20.glUseProgram(dhVar.g);
                                                                                                                                                                                                                                                                        GLES20.glUniform1i(dhVar.l, 0);
                                                                                                                                                                                                                                                                        evVar = evVarZ;
                                                                                                                                                                                                                                                                        GLES20.glUniform3f(dhVar.m, -fArr[8], fArr[9], fArr[10]);
                                                                                                                                                                                                                                                                        dhVar.b.U(dhVar.k, uVar.G());
                                                                                                                                                                                                                                                                        arrayList2 = dhVar.c;
                                                                                                                                                                                                                                                                        size2 = arrayList2.size();
                                                                                                                                                                                                                                                                        i3 = 0;
                                                                                                                                                                                                                                                                        b3 = -1;
                                                                                                                                                                                                                                                                        while (i3 < size2) {
                                                                                                                                                                                                                                                                            edVar = (ed) arrayList2.get(i3);
                                                                                                                                                                                                                                                                            ArrayList arrayList8 = arrayList2;
                                                                                                                                                                                                                                                                            bVarA = edVar.a();
                                                                                                                                                                                                                                                                            if (bVarA.a()) {
                                                                                                                                                                                                                                                                                edVar.b();
                                                                                                                                                                                                                                                                                float[] fArrC2 = edVar.c();
                                                                                                                                                                                                                                                                                b4 = b3;
                                                                                                                                                                                                                                                                                dVarB29 = dVarB29;
                                                                                                                                                                                                                                                                                System.arraycopy(fArrC2, 0, dhVar.i, 0, 16);
                                                                                                                                                                                                                                                                                dhVar.b.U(dhVar.j, dhVar.i);
                                                                                                                                                                                                                                                                                arrayList3 = bVarA.b;
                                                                                                                                                                                                                                                                                size3 = arrayList3.size();
                                                                                                                                                                                                                                                                                i4 = 0;
                                                                                                                                                                                                                                                                                while (i4 < size3) {
                                                                                                                                                                                                                                                                                    com.google.android.libraries.navigation.internal.rn.a aVar3 = (com.google.android.libraries.navigation.internal.rn.a) arrayList3.get(i4);
                                                                                                                                                                                                                                                                                    int i18 = aVar3.b;
                                                                                                                                                                                                                                                                                    int i19 = aVar3.d;
                                                                                                                                                                                                                                                                                    if (b4 != 0) {
                                                                                                                                                                                                                                                                                        GLES20.glBindBuffer(34962, 0);
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                    GLES20.glVertexAttribPointer(0, 3, FujifilmMakernoteDirectory.TAG_MAX_APERTURE_AT_MIN_FOCAL, false, 32, 0);
                                                                                                                                                                                                                                                                                    GLES20.glVertexAttribPointer(1, 2, FujifilmMakernoteDirectory.TAG_MAX_APERTURE_AT_MIN_FOCAL, false, 32, 12);
                                                                                                                                                                                                                                                                                    GLES20.glVertexAttribPointer(2, 3, FujifilmMakernoteDirectory.TAG_MAX_APERTURE_AT_MIN_FOCAL, false, 32, 20);
                                                                                                                                                                                                                                                                                    com.google.android.libraries.navigation.internal.rn.c cVar3 = aVar3.f;
                                                                                                                                                                                                                                                                                    int i110 = aVar3.a;
                                                                                                                                                                                                                                                                                    GLES20.glDrawArrays(4, 0, 0);
                                                                                                                                                                                                                                                                                    i4++;
                                                                                                                                                                                                                                                                                    arrayList3 = arrayList3;
                                                                                                                                                                                                                                                                                    b4 = 0;
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                b3 = b4;
                                                                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                                                                dVarB29 = dVarB29;
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                            i3++;
                                                                                                                                                                                                                                                                            arrayList2 = arrayList8;
                                                                                                                                                                                                                                                                            size2 = size2;
                                                                                                                                                                                                                                                                            lvVar2 = lvVar2;
                                                                                                                                                                                                                                                                            dVarB29 = dVarB29;
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                        lvVar = lvVar2;
                                                                                                                                                                                                                                                                        dVarB29 = dVarB29;
                                                                                                                                                                                                                                                                        if (dVarB15 != null) {
                                                                                                                                                                                                                                                                            Trace.endSection();
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                                                        evVar = evVarZ;
                                                                                                                                                                                                                                                                        lvVar = lvVar2;
                                                                                                                                                                                                                                                                        dVarB29 = dVarB29;
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                    if (dhVar.d != null) {
                                                                                                                                                                                                                                                                        dVarB14 = com.google.android.libraries.navigation.internal.nw.e.b("drawAnimatedMeshes");
                                                                                                                                                                                                                                                                        GLES20.glUseProgram(dhVar.h);
                                                                                                                                                                                                                                                                        GLES20.glEnableVertexAttribArray(3);
                                                                                                                                                                                                                                                                        GLES20.glUniform1i(dhVar.p, 0);
                                                                                                                                                                                                                                                                        dhVar.b.U(dhVar.o, uVar.G());
                                                                                                                                                                                                                                                                        arrayList = dhVar.d;
                                                                                                                                                                                                                                                                        size = arrayList.size();
                                                                                                                                                                                                                                                                        z = false;
                                                                                                                                                                                                                                                                        b2 = -1;
                                                                                                                                                                                                                                                                        i2 = 0;
                                                                                                                                                                                                                                                                        while (i2 < size) {
                                                                                                                                                                                                                                                                            ec ecVar2 = (ec) arrayList.get(i2);
                                                                                                                                                                                                                                                                            ArrayList arrayList9 = arrayList;
                                                                                                                                                                                                                                                                            int i111 = size;
                                                                                                                                                                                                                                                                            byte b6 = b2;
                                                                                                                                                                                                                                                                            GLES20.glUniform3fv(dhVar.q, 1, ecVar2.g(), 0);
                                                                                                                                                                                                                                                                            GLES20.glUniform3fv(dhVar.r, 2, ecVar2.f(), 0);
                                                                                                                                                                                                                                                                            ecVar2.k();
                                                                                                                                                                                                                                                                            ecVar2.i();
                                                                                                                                                                                                                                                                            ecVar2.i();
                                                                                                                                                                                                                                                                            ecVar2.j();
                                                                                                                                                                                                                                                                            float fA2 = ecVar2.a();
                                                                                                                                                                                                                                                                            int iB2 = ecVar2.b();
                                                                                                                                                                                                                                                                            bVarC = ecVar2.c();
                                                                                                                                                                                                                                                                            if (!bVarC.a()) {
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                            i2++;
                                                                                                                                                                                                                                                                            arrayList = arrayList9;
                                                                                                                                                                                                                                                                            size = i111;
                                                                                                                                                                                                                                                                            b2 = b6;
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                        i = 0;
                                                                                                                                                                                                                                                                        if (z) {
                                                                                                                                                                                                                                                                            dhVar.a.o();
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                        if (dVarB14 != null) {
                                                                                                                                                                                                                                                                            Trace.endSection();
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                                                        i = 0;
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                if (aVarA30 != null) {
                                                                                                                                                                                                                                                                    aVarA30.close();
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                if (dVarB32 != null) {
                                                                                                                                                                                                                                                                    Trace.endSection();
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                            } catch (Throwable th79) {
                                                                                                                                                                                                                                                                th = th79;
                                                                                                                                                                                                                                                                dVarB29 = dVarB29;
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        } catch (Throwable th80) {
                                                                                                                                                                                                                                                            th = th80;
                                                                                                                                                                                                                                                            th19 = th;
                                                                                                                                                                                                                                                            if (dVarB32 != null) {
                                                                                                                                                                                                                                                                throw th19;
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                                                Trace.endSection();
                                                                                                                                                                                                                                                                throw th19;
                                                                                                                                                                                                                                                            } catch (Throwable th81) {
                                                                                                                                                                                                                                                                th19.addSuppressed(th81);
                                                                                                                                                                                                                                                                throw th19;
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    } catch (Throwable th82) {
                                                                                                                                                                                                                                                        th = th82;
                                                                                                                                                                                                                                                        dVarB29 = dVarB29;
                                                                                                                                                                                                                                                        th19 = th;
                                                                                                                                                                                                                                                        if (dVarB32 != null) {
                                                                                                                                                                                                                                                            throw th19;
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                        Trace.endSection();
                                                                                                                                                                                                                                                        throw th19;
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                } else {
                                                                                                                                                                                                                                                    evVar = evVarZ;
                                                                                                                                                                                                                                                    lvVar = lvVar2;
                                                                                                                                                                                                                                                    dVarB29 = dVarB29;
                                                                                                                                                                                                                                                    i = 0;
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            } catch (Throwable th83) {
                                                                                                                                                                                                                                                if (aVarA29 == null) {
                                                                                                                                                                                                                                                    throw th83;
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                try {
                                                                                                                                                                                                                                                    aVarA29.close();
                                                                                                                                                                                                                                                    throw th83;
                                                                                                                                                                                                                                                } catch (Throwable th84) {
                                                                                                                                                                                                                                                    th83.addSuppressed(th84);
                                                                                                                                                                                                                                                    throw th83;
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        } catch (Throwable th85) {
                                                                                                                                                                                                                                            th = th85;
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    } catch (Throwable th86) {
                                                                                                                                                                                                                                        if (aVarA28 == null) {
                                                                                                                                                                                                                                            throw th86;
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                        try {
                                                                                                                                                                                                                                            aVarA28.close();
                                                                                                                                                                                                                                            throw th86;
                                                                                                                                                                                                                                        } catch (Throwable th87) {
                                                                                                                                                                                                                                            th86.addSuppressed(th87);
                                                                                                                                                                                                                                            throw th86;
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                } catch (Throwable th88) {
                                                                                                                                                                                                                                    th = th88;
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            } catch (Throwable th89) {
                                                                                                                                                                                                                                if (aVarA27 == null) {
                                                                                                                                                                                                                                    throw th89;
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                try {
                                                                                                                                                                                                                                    aVarA27.close();
                                                                                                                                                                                                                                    throw th89;
                                                                                                                                                                                                                                } catch (Throwable th90) {
                                                                                                                                                                                                                                    th89.addSuppressed(th90);
                                                                                                                                                                                                                                    throw th89;
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        } catch (Throwable th91) {
                                                                                                                                                                                                                            th = th91;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    } catch (Throwable th92) {
                                                                                                                                                                                                                        if (aVarA26 == null) {
                                                                                                                                                                                                                            throw th92;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                        try {
                                                                                                                                                                                                                            aVarA26.close();
                                                                                                                                                                                                                            throw th92;
                                                                                                                                                                                                                        } catch (Throwable th93) {
                                                                                                                                                                                                                            th92.addSuppressed(th93);
                                                                                                                                                                                                                            throw th92;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                } catch (Throwable th94) {
                                                                                                                                                                                                                    th = th94;
                                                                                                                                                                                                                }
                                                                                                                                                                                                            } catch (Throwable th95) {
                                                                                                                                                                                                                if (aVarA24 == null) {
                                                                                                                                                                                                                    throw th95;
                                                                                                                                                                                                                }
                                                                                                                                                                                                                try {
                                                                                                                                                                                                                    aVarA24.close();
                                                                                                                                                                                                                    throw th95;
                                                                                                                                                                                                                } catch (Throwable th96) {
                                                                                                                                                                                                                    th95.addSuppressed(th96);
                                                                                                                                                                                                                    throw th95;
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        } catch (Throwable th97) {
                                                                                                                                                                                                            th = th97;
                                                                                                                                                                                                        }
                                                                                                                                                                                                    } catch (Throwable th98) {
                                                                                                                                                                                                        if (aVarA23 == null) {
                                                                                                                                                                                                            throw th98;
                                                                                                                                                                                                        }
                                                                                                                                                                                                        try {
                                                                                                                                                                                                            aVarA23.close();
                                                                                                                                                                                                            throw th98;
                                                                                                                                                                                                        } catch (Throwable th99) {
                                                                                                                                                                                                            th98.addSuppressed(th99);
                                                                                                                                                                                                            throw th98;
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                } catch (Throwable th100) {
                                                                                                                                                                                                    th = th100;
                                                                                                                                                                                                }
                                                                                                                                                                                            } catch (Throwable th101) {
                                                                                                                                                                                                if (aVarA22 == null) {
                                                                                                                                                                                                    throw th101;
                                                                                                                                                                                                }
                                                                                                                                                                                                try {
                                                                                                                                                                                                    aVarA22.close();
                                                                                                                                                                                                    throw th101;
                                                                                                                                                                                                } catch (Throwable th102) {
                                                                                                                                                                                                    th101.addSuppressed(th102);
                                                                                                                                                                                                    throw th101;
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        } catch (Throwable th103) {
                                                                                                                                                                                            th = th103;
                                                                                                                                                                                        }
                                                                                                                                                                                    } catch (Throwable th104) {
                                                                                                                                                                                        if (aVarA21 == null) {
                                                                                                                                                                                            throw th104;
                                                                                                                                                                                        }
                                                                                                                                                                                        try {
                                                                                                                                                                                            aVarA21.close();
                                                                                                                                                                                            throw th104;
                                                                                                                                                                                        } catch (Throwable th105) {
                                                                                                                                                                                            th104.addSuppressed(th105);
                                                                                                                                                                                            throw th104;
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                } catch (Throwable th106) {
                                                                                                                                                                                    th = th106;
                                                                                                                                                                                }
                                                                                                                                                                            } catch (Throwable th107) {
                                                                                                                                                                                if (aVarA20 == null) {
                                                                                                                                                                                    throw th107;
                                                                                                                                                                                }
                                                                                                                                                                                try {
                                                                                                                                                                                    aVarA20.close();
                                                                                                                                                                                    throw th107;
                                                                                                                                                                                } catch (Throwable th108) {
                                                                                                                                                                                    th107.addSuppressed(th108);
                                                                                                                                                                                    throw th107;
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        } catch (Throwable th109) {
                                                                                                                                                                            th = th109;
                                                                                                                                                                        }
                                                                                                                                                                    } catch (Throwable th110) {
                                                                                                                                                                        th9 = th110;
                                                                                                                                                                    }
                                                                                                                                                                } catch (Throwable th111) {
                                                                                                                                                                    th = th111;
                                                                                                                                                                    dVarB29 = dVarB29;
                                                                                                                                                                }
                                                                                                                                                            } catch (Throwable th112) {
                                                                                                                                                                if (aVarA18 == null) {
                                                                                                                                                                    throw th112;
                                                                                                                                                                }
                                                                                                                                                                try {
                                                                                                                                                                    aVarA18.close();
                                                                                                                                                                    throw th112;
                                                                                                                                                                } catch (Throwable th113) {
                                                                                                                                                                    th112.addSuppressed(th113);
                                                                                                                                                                    throw th112;
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        } catch (Throwable th114) {
                                                                                                                                                            th = th114;
                                                                                                                                                        }
                                                                                                                                                    } catch (Throwable th115) {
                                                                                                                                                        if (aVarA17 == null) {
                                                                                                                                                            throw th115;
                                                                                                                                                        }
                                                                                                                                                        try {
                                                                                                                                                            aVarA17.close();
                                                                                                                                                            throw th115;
                                                                                                                                                        } catch (Throwable th116) {
                                                                                                                                                            th115.addSuppressed(th116);
                                                                                                                                                            throw th115;
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                } catch (Throwable th117) {
                                                                                                                                                    th = th117;
                                                                                                                                                }
                                                                                                                                            } catch (Throwable th118) {
                                                                                                                                                if (aVarA16 == null) {
                                                                                                                                                    throw th118;
                                                                                                                                                }
                                                                                                                                                try {
                                                                                                                                                    aVarA16.close();
                                                                                                                                                    throw th118;
                                                                                                                                                } catch (Throwable th119) {
                                                                                                                                                    th118.addSuppressed(th119);
                                                                                                                                                    throw th118;
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        } catch (Throwable th120) {
                                                                                                                                            th = th120;
                                                                                                                                        }
                                                                                                                                    } catch (Throwable th121) {
                                                                                                                                        th = th121;
                                                                                                                                        th4 = th;
                                                                                                                                        if (aVarA15 == null) {
                                                                                                                                            throw th4;
                                                                                                                                        }
                                                                                                                                        aVarA15.close();
                                                                                                                                        throw th4;
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                if (aVarA15 != null) {
                                                                                                                                    aVarA15.close();
                                                                                                                                }
                                                                                                                                if (dVarB30 != null) {
                                                                                                                                    Trace.endSection();
                                                                                                                                }
                                                                                                                                if (aVarA14 != null) {
                                                                                                                                    aVarA14.close();
                                                                                                                                }
                                                                                                                                if (dVarB29 != null) {
                                                                                                                                    Trace.endSection();
                                                                                                                                }
                                                                                                                                ea.a(ea.DRAW, ea.POST_DRAW);
                                                                                                                                ea.a(ea.POST_DRAW, ea.END_FRAME);
                                                                                                                                com.google.android.libraries.navigation.internal.nw.d dVarB33 = com.google.android.libraries.navigation.internal.nw.e.b("endFrame");
                                                                                                                                try {
                                                                                                                                    com.google.android.libraries.navigation.internal.nw.a aVarA31 = com.google.android.libraries.navigation.internal.nw.b.a("endFrame");
                                                                                                                                    try {
                                                                                                                                        this.r.q();
                                                                                                                                        this.ac++;
                                                                                                                                        if (aVarA31 != null) {
                                                                                                                                            aVarA31.close();
                                                                                                                                        }
                                                                                                                                        if (dVarB33 != null) {
                                                                                                                                            Trace.endSection();
                                                                                                                                        }
                                                                                                                                        ea.a(ea.END_FRAME, ea.IDLE);
                                                                                                                                        int i20 = lvVar.c;
                                                                                                                                        for (int i21 = i; i21 < i20; i21++) {
                                                                                                                                            ((cb) evVar.get(i21)).a();
                                                                                                                                        }
                                                                                                                                        if (this.r.j) {
                                                                                                                                            o();
                                                                                                                                        }
                                                                                                                                        com.google.android.libraries.navigation.internal.nw.d dVarB34 = com.google.android.libraries.navigation.internal.nw.e.b("viewportLogging");
                                                                                                                                        try {
                                                                                                                                            com.google.android.libraries.navigation.internal.nw.a aVarA32 = com.google.android.libraries.navigation.internal.nw.b.a("viewportLogging");
                                                                                                                                            try {
                                                                                                                                                Iterator it6 = this.I.iterator();
                                                                                                                                                while (it6.hasNext()) {
                                                                                                                                                    ((Runnable) it6.next()).run();
                                                                                                                                                }
                                                                                                                                                if (aVarA32 != null) {
                                                                                                                                                    aVarA32.close();
                                                                                                                                                }
                                                                                                                                                if (dVarB34 != null) {
                                                                                                                                                    Trace.endSection();
                                                                                                                                                    return;
                                                                                                                                                }
                                                                                                                                                return;
                                                                                                                                            } catch (Throwable th122) {
                                                                                                                                                if (aVarA32 == null) {
                                                                                                                                                    throw th122;
                                                                                                                                                }
                                                                                                                                                try {
                                                                                                                                                    aVarA32.close();
                                                                                                                                                    throw th122;
                                                                                                                                                } catch (Throwable th123) {
                                                                                                                                                    th122.addSuppressed(th123);
                                                                                                                                                    throw th122;
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        } catch (Throwable th124) {
                                                                                                                                            if (dVarB34 == null) {
                                                                                                                                                throw th124;
                                                                                                                                            }
                                                                                                                                            try {
                                                                                                                                                Trace.endSection();
                                                                                                                                                throw th124;
                                                                                                                                            } catch (Throwable th125) {
                                                                                                                                                th124.addSuppressed(th125);
                                                                                                                                                throw th124;
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    } catch (Throwable th126) {
                                                                                                                                        if (aVarA31 == null) {
                                                                                                                                            throw th126;
                                                                                                                                        }
                                                                                                                                        try {
                                                                                                                                            aVarA31.close();
                                                                                                                                            throw th126;
                                                                                                                                        } catch (Throwable th127) {
                                                                                                                                            th126.addSuppressed(th127);
                                                                                                                                            throw th126;
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                } catch (Throwable th128) {
                                                                                                                                    if (dVarB33 == null) {
                                                                                                                                        throw th128;
                                                                                                                                    }
                                                                                                                                    try {
                                                                                                                                        Trace.endSection();
                                                                                                                                        throw th128;
                                                                                                                                    } catch (Throwable th129) {
                                                                                                                                        th128.addSuppressed(th129);
                                                                                                                                        throw th128;
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            } catch (Throwable th130) {
                                                                                                                                th = th130;
                                                                                                                                dVarB29 = dVarB29;
                                                                                                                            }
                                                                                                                        } catch (Throwable th131) {
                                                                                                                            th = th131;
                                                                                                                            th3 = th;
                                                                                                                            if (dVarB30 != null) {
                                                                                                                                throw th3;
                                                                                                                            }
                                                                                                                            try {
                                                                                                                                Trace.endSection();
                                                                                                                                throw th3;
                                                                                                                            } catch (Throwable th132) {
                                                                                                                                th3.addSuppressed(th132);
                                                                                                                                throw th3;
                                                                                                                            }
                                                                                                                        }
                                                                                                                    } catch (Throwable th133) {
                                                                                                                        th = th133;
                                                                                                                        dVarB29 = dVarB29;
                                                                                                                        th3 = th;
                                                                                                                        if (dVarB30 != null) {
                                                                                                                            throw th3;
                                                                                                                        }
                                                                                                                        Trace.endSection();
                                                                                                                        throw th3;
                                                                                                                    }
                                                                                                                } catch (Throwable th134) {
                                                                                                                    th = th134;
                                                                                                                    th2 = th;
                                                                                                                    if (aVarA14 != null) {
                                                                                                                        throw th2;
                                                                                                                    }
                                                                                                                    try {
                                                                                                                        aVarA14.close();
                                                                                                                        throw th2;
                                                                                                                    } catch (Throwable th135) {
                                                                                                                        th2.addSuppressed(th135);
                                                                                                                        throw th2;
                                                                                                                    }
                                                                                                                }
                                                                                                            } catch (Throwable th136) {
                                                                                                                th = th136;
                                                                                                                dVarB29 = dVarB29;
                                                                                                                th2 = th;
                                                                                                                if (aVarA14 != null) {
                                                                                                                    throw th2;
                                                                                                                }
                                                                                                                aVarA14.close();
                                                                                                                throw th2;
                                                                                                            }
                                                                                                        } catch (Throwable th137) {
                                                                                                            th = th137;
                                                                                                            th = th;
                                                                                                            if (dVarB29 != null) {
                                                                                                                throw th;
                                                                                                            }
                                                                                                            try {
                                                                                                                Trace.endSection();
                                                                                                                throw th;
                                                                                                            } catch (Throwable th138) {
                                                                                                                th.addSuppressed(th138);
                                                                                                                throw th;
                                                                                                            }
                                                                                                        }
                                                                                                    } catch (Throwable th139) {
                                                                                                        th = th139;
                                                                                                        dVarB29 = dVarB29;
                                                                                                        th = th;
                                                                                                        if (dVarB29 != null) {
                                                                                                            throw th;
                                                                                                        }
                                                                                                        Trace.endSection();
                                                                                                        throw th;
                                                                                                    }
                                                                                                } catch (Throwable th140) {
                                                                                                    if (aVarA12 == null) {
                                                                                                        throw th140;
                                                                                                    }
                                                                                                    try {
                                                                                                        aVarA12.close();
                                                                                                        throw th140;
                                                                                                    } catch (Throwable th141) {
                                                                                                        th140.addSuppressed(th141);
                                                                                                        throw th140;
                                                                                                    }
                                                                                                    if (aVarA9 == null) {
                                                                                                        throw th;
                                                                                                    }
                                                                                                    aVarA9.close();
                                                                                                    throw th;
                                                                                                }
                                                                                            } catch (Throwable th142) {
                                                                                                if (dVarB27 == null) {
                                                                                                    throw th142;
                                                                                                }
                                                                                                try {
                                                                                                    Trace.endSection();
                                                                                                    throw th142;
                                                                                                } catch (Throwable th143) {
                                                                                                    th142.addSuppressed(th143);
                                                                                                    throw th142;
                                                                                                }
                                                                                                if (dVarB24 == null) {
                                                                                                    throw th;
                                                                                                }
                                                                                                Trace.endSection();
                                                                                                throw th;
                                                                                            }
                                                                                        } catch (Throwable th144) {
                                                                                            if (aVarA11 == null) {
                                                                                                throw th144;
                                                                                            }
                                                                                            try {
                                                                                                aVarA11.close();
                                                                                                throw th144;
                                                                                            } catch (Throwable th145) {
                                                                                                th144.addSuppressed(th145);
                                                                                                throw th144;
                                                                                            }
                                                                                            if (aVarA9 == null) {
                                                                                                throw th;
                                                                                            }
                                                                                            aVarA9.close();
                                                                                            throw th;
                                                                                        }
                                                                                    } catch (Throwable th146) {
                                                                                        if (dVarB26 == null) {
                                                                                            throw th146;
                                                                                        }
                                                                                        try {
                                                                                            Trace.endSection();
                                                                                            throw th146;
                                                                                        } catch (Throwable th147) {
                                                                                            th146.addSuppressed(th147);
                                                                                            throw th146;
                                                                                        }
                                                                                        if (dVarB24 == null) {
                                                                                            throw th;
                                                                                        }
                                                                                        Trace.endSection();
                                                                                        throw th;
                                                                                    }
                                                                                } catch (Throwable th148) {
                                                                                    if (aVarA10 == null) {
                                                                                        throw th148;
                                                                                    }
                                                                                    try {
                                                                                        aVarA10.close();
                                                                                        throw th148;
                                                                                    } catch (Throwable th149) {
                                                                                        th148.addSuppressed(th149);
                                                                                        throw th148;
                                                                                    }
                                                                                    if (aVarA9 == null) {
                                                                                        throw th;
                                                                                    }
                                                                                    aVarA9.close();
                                                                                    throw th;
                                                                                }
                                                                            } catch (Throwable th150) {
                                                                                if (dVarB25 == null) {
                                                                                    throw th150;
                                                                                }
                                                                                try {
                                                                                    Trace.endSection();
                                                                                    throw th150;
                                                                                } catch (Throwable th151) {
                                                                                    th150.addSuppressed(th151);
                                                                                    throw th150;
                                                                                }
                                                                                if (dVarB24 == null) {
                                                                                    throw th;
                                                                                }
                                                                                Trace.endSection();
                                                                                throw th;
                                                                            }
                                                                        } catch (Throwable th152) {
                                                                            if (aVarA9 == null) {
                                                                                throw th152;
                                                                            }
                                                                            aVarA9.close();
                                                                            throw th152;
                                                                        }
                                                                    } catch (Throwable th153) {
                                                                        if (dVarB24 == null) {
                                                                            throw th153;
                                                                        }
                                                                        Trace.endSection();
                                                                        throw th153;
                                                                    }
                                                                } catch (Throwable th154) {
                                                                    if (aVarA8 == null) {
                                                                        throw th154;
                                                                    }
                                                                    try {
                                                                        aVarA8.close();
                                                                        throw th154;
                                                                    } catch (Throwable th155) {
                                                                        th154.addSuppressed(th155);
                                                                        throw th154;
                                                                    }
                                                                    if (aVarA2 == null) {
                                                                        throw th;
                                                                    }
                                                                    aVarA2.close();
                                                                    throw th;
                                                                }
                                                            } catch (Throwable th156) {
                                                                if (dVarB23 == null) {
                                                                    throw th156;
                                                                }
                                                                try {
                                                                    Trace.endSection();
                                                                    throw th156;
                                                                } catch (Throwable th157) {
                                                                    th156.addSuppressed(th157);
                                                                    throw th156;
                                                                }
                                                                if (dVarB17 == null) {
                                                                    throw th;
                                                                }
                                                                Trace.endSection();
                                                                throw th;
                                                            }
                                                        } catch (Throwable th158) {
                                                            if (aVarA7 == null) {
                                                                throw th158;
                                                            }
                                                            try {
                                                                aVarA7.close();
                                                                throw th158;
                                                            } catch (Throwable th159) {
                                                                th158.addSuppressed(th159);
                                                                throw th158;
                                                            }
                                                            if (aVarA2 == null) {
                                                                throw th;
                                                            }
                                                            aVarA2.close();
                                                            throw th;
                                                        }
                                                    } catch (Throwable th160) {
                                                        if (dVarB22 == null) {
                                                            throw th160;
                                                        }
                                                        try {
                                                            Trace.endSection();
                                                            throw th160;
                                                        } catch (Throwable th161) {
                                                            th160.addSuppressed(th161);
                                                            throw th160;
                                                        }
                                                        if (dVarB17 == null) {
                                                            throw th;
                                                        }
                                                        Trace.endSection();
                                                        throw th;
                                                    }
                                                } catch (Throwable th162) {
                                                    if (aVarA5 != null) {
                                                        throw th162;
                                                    }
                                                    aVarA5.close();
                                                    throw th162;
                                                    if (aVarA2 == null) {
                                                        throw th;
                                                    }
                                                    aVarA2.close();
                                                    throw th;
                                                }
                                            } catch (Throwable th163) {
                                                if (dVarB20 != null) {
                                                    throw th163;
                                                }
                                                Trace.endSection();
                                                throw th163;
                                                if (dVarB17 == null) {
                                                    throw th;
                                                }
                                                Trace.endSection();
                                                throw th;
                                            }
                                        } catch (Throwable th164) {
                                            if (aVarA4 == null) {
                                                throw th164;
                                            }
                                            try {
                                                aVarA4.close();
                                                throw th164;
                                            } catch (Throwable th165) {
                                                th164.addSuppressed(th165);
                                                throw th164;
                                            }
                                            if (aVarA2 == null) {
                                                throw th;
                                            }
                                            aVarA2.close();
                                            throw th;
                                        }
                                    } catch (Throwable th166) {
                                        if (dVarB19 == null) {
                                            throw th166;
                                        }
                                        try {
                                            Trace.endSection();
                                            throw th166;
                                        } catch (Throwable th167) {
                                            th166.addSuppressed(th167);
                                            throw th166;
                                        }
                                        if (dVarB17 == null) {
                                            throw th;
                                        }
                                        Trace.endSection();
                                        throw th;
                                    }
                                } catch (Throwable th168) {
                                    dp dpVar3 = this.q;
                                    if (dpVar3 == null) {
                                        throw th168;
                                    }
                                    dpVar3.d();
                                    throw th168;
                                }
                            } catch (Throwable th169) {
                                if (aVarA3 == null) {
                                    throw th169;
                                }
                                try {
                                    aVarA3.close();
                                    throw th169;
                                } catch (Throwable th170) {
                                    th169.addSuppressed(th170);
                                    throw th169;
                                }
                                if (aVarA2 == null) {
                                    throw th;
                                }
                                aVarA2.close();
                                throw th;
                            }
                        } catch (Throwable th171) {
                            if (dVarB18 == null) {
                                throw th171;
                            }
                            try {
                                Trace.endSection();
                                throw th171;
                            } catch (Throwable th172) {
                                th171.addSuppressed(th172);
                                throw th171;
                            }
                            if (dVarB17 == null) {
                                throw th;
                            }
                            Trace.endSection();
                            throw th;
                        }
                    } catch (Throwable th173) {
                        if (aVarA2 == null) {
                            throw th173;
                        }
                        aVarA2.close();
                        throw th173;
                    }
                } catch (Throwable th174) {
                    if (dVarB17 == null) {
                        throw th174;
                    }
                    Trace.endSection();
                    throw th174;
                }
            } catch (Throwable th175) {
                if (aVarA == null) {
                    throw th175;
                }
                try {
                    aVarA.close();
                    throw th175;
                } catch (Throwable th176) {
                    th175.addSuppressed(th176);
                    throw th175;
                }
            }
        } catch (Throwable th177) {
            if (dVarB16 == null) {
                throw th177;
            }
            try {
                Trace.endSection();
                throw th177;
            } catch (Throwable th178) {
                th177.addSuppressed(th178);
                throw th177;
            }
        }
        th7 = th;
        if (dVarB3 != null) {
            throw th7;
        }
        Trace.endSection();
        throw th7;
        th11 = th;
        if (dVarB6 != null) {
            throw th11;
        }
        Trace.endSection();
        throw th11;
        th14 = th;
        if (dVarB9 != null) {
            throw th14;
        }
        Trace.endSection();
        throw th14;
        th17 = th;
        if (dVarB12 != null) {
            throw th17;
        }
        Trace.endSection();
        throw th17;
        th6 = th;
        if (dVarB2 != null) {
            throw th6;
        }
        Trace.endSection();
        throw th6;
        th10 = th;
        if (dVarB5 != null) {
            throw th10;
        }
        Trace.endSection();
        throw th10;
        th13 = th;
        if (dVarB8 != null) {
            throw th13;
        }
        Trace.endSection();
        throw th13;
        th16 = th;
        if (dVarB11 != null) {
            throw th16;
        }
        Trace.endSection();
        throw th16;
        th5 = th;
        if (dVarB != null) {
            throw th5;
        }
        Trace.endSection();
        throw th5;
        th8 = th;
        if (dVarB4 != null) {
            throw th8;
        }
        Trace.endSection();
        throw th8;
        th12 = th;
        if (dVarB7 != null) {
            throw th12;
        }
        Trace.endSection();
        throw th12;
        th15 = th;
        if (dVarB10 != null) {
            throw th15;
        }
        Trace.endSection();
        throw th15;
        th18 = th;
        if (dVarB13 != null) {
            throw th18;
        }
        Trace.endSection();
        throw th18;
    }

    public final void h(aj ajVar) {
        ((dx) this.W.get(ajVar.y().ordinal())).d(ajVar);
        dp dpVar = this.q;
        if (dpVar != null) {
            dpVar.b();
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bx
    public final void i() {
        com.google.android.libraries.navigation.internal.yz.ev evVarZ = z();
        int i = ((lv) evVarZ).c;
        for (int i2 = 0; i2 < i; i2++) {
            ((cb) evVarZ.get(i2)).d();
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bx
    public final void j() {
        if (ea.i.get() == ea.INVALID) {
            ea.i.set(ea.IDLE);
            ea.j = System.nanoTime();
            ea.k = 0;
            Arrays.fill(ea.l, 0L);
            Arrays.fill(ea.m, 0L);
        }
        if (this.r.A()) {
            com.google.android.libraries.navigation.internal.yz.ev evVar = this.W;
            for (int i = 0; i < ((lv) evVar).c; i++) {
                ((dx) evVar.get(i)).e();
            }
            n nVar = this.af;
            nVar.a = null;
            nVar.c = 0;
            nVar.d = 0;
            nVar.e = 0;
            nVar.f = 0;
            nVar.g = 0;
            nVar.h = 0;
            nVar.i = 0;
            nVar.j = 0;
        }
        LabelRenderer labelRenderer = this.ab;
        if (labelRenderer != null) {
            labelRenderer.b.e();
            LayeredLabelRenderer layeredLabelRenderer = labelRenderer.a;
            if (layeredLabelRenderer != null) {
                layeredLabelRenderer.d.e();
            }
            this.ab = null;
        }
        bv bvVar = this.r;
        if (bvVar.A()) {
            bvVar.b = -1;
            while (true) {
                bw bwVar = bvVar.l;
                if (bwVar == null) {
                    break;
                } else {
                    bvVar.x(bwVar);
                }
            }
            Iterator it2 = bvVar.p.values().iterator();
            while (it2.hasNext()) {
                ((ee) it2.next()).w = 0;
            }
            ff ffVar = bvVar.m;
            if (ffVar != null) {
                ffVar.b(true);
                bvVar.m = null;
            }
        }
        this.r.b = Process.myTid();
        bv.a++;
        com.google.android.libraries.navigation.internal.yz.ev evVar2 = this.W;
        for (int i2 = 0; i2 < ((lv) evVar2).c; i2++) {
            ((dx) evVar2.get(i2)).a(this.r);
        }
        this.ab = new LabelRenderer(this, this.r);
        n nVar2 = this.af;
        bv bvVar2 = this.r;
        com.google.android.libraries.navigation.internal.yx.ar.k(nVar2.a == null);
        nVar2.a = bvVar2;
        q qVar = nVar2.b;
        o oVar = qVar.d;
        int iA = bvVar2.a(qVar.a, qVar.b, new String[]{oVar.a, oVar.b});
        nVar2.c = iA;
        nVar2.d = bvVar2.b(iA, nVar2.b.c.a);
        nVar2.e = bvVar2.b(nVar2.c, nVar2.b.c.b);
        nVar2.f = bvVar2.b(nVar2.c, nVar2.b.c.f);
        nVar2.g = bvVar2.b(nVar2.c, nVar2.b.c.c);
        nVar2.h = bvVar2.b(nVar2.c, nVar2.b.c.g);
        nVar2.i = bvVar2.b(nVar2.c, nVar2.b.c.d);
        nVar2.j = bvVar2.b(nVar2.c, nVar2.b.c.e);
        nVar2.k = bvVar2.b(nVar2.c, nVar2.b.c.h);
        nVar2.l = bvVar2.b(nVar2.c, nVar2.b.c.i);
        this.t = new ej(this.r);
        this.ae = new l(this.r);
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("labelAtlas2.resetContext");
        try {
            com.google.android.libraries.navigation.internal.nw.a aVarA = com.google.android.libraries.navigation.internal.nw.b.a("labelAtlas2.resetContext");
            try {
                this.m.h(this.r);
                if (aVarA != null) {
                    aVarA.close();
                }
                if (dVarB != null) {
                    Trace.endSection();
                }
                com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("calloutAtlas2.resetContext");
                try {
                    com.google.android.libraries.navigation.internal.nw.a aVarA2 = com.google.android.libraries.navigation.internal.nw.b.a("calloutAtlas2.resetContext");
                    try {
                        this.f75n.h(this.r);
                        if (aVarA2 != null) {
                            aVarA2.close();
                        }
                        if (dVarB2 != null) {
                            Trace.endSection();
                        }
                        if (this.o != null) {
                            com.google.android.libraries.navigation.internal.nw.d dVarB3 = com.google.android.libraries.navigation.internal.nw.e.b("areaAtlas2.resetContext");
                            try {
                                com.google.android.libraries.navigation.internal.nw.a aVarA3 = com.google.android.libraries.navigation.internal.nw.b.a("areaAtlas2.resetContext");
                                try {
                                    this.o.h(this.r);
                                    if (aVarA3 != null) {
                                        aVarA3.close();
                                    }
                                    if (dVarB3 != null) {
                                        Trace.endSection();
                                    }
                                } catch (Throwable th) {
                                    if (aVarA3 != null) {
                                        try {
                                            aVarA3.close();
                                        } catch (Throwable th2) {
                                            th.addSuppressed(th2);
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                if (dVarB3 != null) {
                                    try {
                                        Trace.endSection();
                                    } catch (Throwable th4) {
                                        th3.addSuppressed(th4);
                                    }
                                }
                                throw th3;
                            }
                        }
                        this.ad = new dh(this);
                        bw bwVarE = this.r.e("dimmer");
                        this.ai = bwVarE;
                        this.r.Y(bwVarE, 1, 1, 1, 2, new int[]{-2142220208});
                        com.google.android.libraries.navigation.internal.yz.ev evVarZ = z();
                        int i3 = ((lv) evVarZ).c;
                        for (int i4 = 0; i4 < i3; i4++) {
                            ((cb) evVarZ.get(i4)).e();
                        }
                    } catch (Throwable th5) {
                        if (aVarA2 != null) {
                            try {
                                aVarA2.close();
                            } catch (Throwable th6) {
                                th5.addSuppressed(th6);
                            }
                        }
                        throw th5;
                    }
                } catch (Throwable th7) {
                    if (dVarB2 != null) {
                        try {
                            Trace.endSection();
                        } catch (Throwable th8) {
                            th7.addSuppressed(th8);
                        }
                    }
                    throw th7;
                }
            } catch (Throwable th9) {
                if (aVarA != null) {
                    try {
                        aVarA.close();
                    } catch (Throwable th10) {
                        th9.addSuppressed(th10);
                    }
                }
                throw th9;
            }
        } catch (Throwable th11) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th12) {
                    th11.addSuppressed(th12);
                }
            }
            throw th11;
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bx
    public final void k() {
    }

    public final synchronized void l(Runnable runnable) {
        this.D.add(runnable);
    }

    public final void m(aj ajVar) {
        am amVar = this.e;
        boolean zE = amVar.e();
        amVar.d(ajVar);
        A(zE);
    }

    public final void n(Runnable runnable) {
        this.H.remove(runnable);
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bx
    public final void o() {
        if (this.aj.get()) {
            return;
        }
        this.aa.c(true);
        this.Z.set(true);
        Runnable runnable = this.X;
        if (runnable != null) {
            runnable.run();
        }
        com.google.android.libraries.navigation.internal.yz.ev evVarZ = z();
        int i = ((lv) evVarZ).c;
        for (int i2 = 0; i2 < i; i2++) {
            ((cb) evVarZ.get(i2)).c();
        }
    }

    public final synchronized void p(Runnable runnable) {
        this.E.add(runnable);
    }

    public final synchronized void q(Runnable runnable) {
        this.G.add(runnable);
    }

    public final synchronized void r(Runnable runnable) {
        if (this.D.contains(runnable)) {
            this.E.add(runnable);
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bx
    public final void s(Runnable runnable) {
        this.X = runnable;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bx
    public final void t(Runnable runnable) {
        this.Y = runnable;
    }

    public final synchronized void u() {
        this.D.clear();
        this.E.clear();
    }

    public final synchronized void v(Runnable runnable) {
        this.D.remove(runnable);
        this.E.remove(runnable);
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bx
    public final void w() {
        dm dmVarA = this.e.a();
        if (dmVarA == null) {
            return;
        }
        dp dpVar = this.q;
        if (dpVar != null) {
            dpVar.a();
        }
        try {
            dmVarA.a(this.r, this.W, this.q);
            if (this.q != null) {
            }
        } finally {
            dp dpVar2 = this.q;
            if (dpVar2 != null) {
                dpVar2.d();
            }
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bx
    public final boolean x() {
        return !this.e.e();
    }

    public final boolean y() {
        return this.Z.get();
    }
}

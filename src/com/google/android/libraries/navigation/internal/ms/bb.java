package com.google.android.libraries.navigation.internal.ms;

import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.View;
import android.view.ViewGroup;
import androidx.tracing.Trace;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bb {
    public final bg a;
    private final List b = new ArrayList();
    private final cx c;
    private final co d;
    private final ax e;
    private final MessageQueue f;

    public bb(ax axVar, bg bgVar, cx cxVar, co coVar) {
        this.e = axVar;
        com.google.android.libraries.navigation.internal.yx.ar.q(cxVar);
        this.c = cxVar;
        com.google.android.libraries.navigation.internal.yx.ar.q(coVar);
        this.d = coVar;
        this.a = bgVar;
        Looper mainLooper = Looper.getMainLooper();
        this.f = mainLooper.getQueue();
        new Handler(mainLooper);
    }

    private final void b(ba baVar, ck ckVar) {
        for (com.google.android.libraries.navigation.internal.mx.w wVar : baVar.a) {
            if (wVar != null && wVar.c()) {
                wVar.b(this.c, ckVar);
            }
        }
    }

    private final void c(az azVar) {
        azVar.k = null;
        azVar.a.b();
        azVar.b = null;
        azVar.c.b();
        azVar.d.clear();
        azVar.e = 0;
        azVar.f = null;
        azVar.g = null;
        azVar.h = 0;
        azVar.i = 0;
        azVar.j = null;
        synchronized (this.b) {
            this.b.add(azVar);
        }
    }

    private static final bx d(ba baVar) {
        int i = baVar.e;
        return new bx(i > 0 ? new bw[i] : bw.a, null);
    }

    private static final void e(List list, bx bxVar, ck ckVar) {
        Iterator it2 = list.iterator();
        int i = 0;
        while (it2.hasNext()) {
            com.google.android.libraries.navigation.internal.mx.w wVar = (com.google.android.libraries.navigation.internal.mx.w) it2.next();
            if (wVar != null && !wVar.c()) {
                bxVar.b[i] = wVar.d(ckVar);
                i++;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:110:0x0272  */
    /* JADX WARN: Code duplicated, block: B:131:0x0131 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:143:0x0258 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:45:0x00be A[Catch: all -> 0x00b6, TryCatch #3 {all -> 0x00b6, blocks: (B:36:0x00ad, B:38:0x00b1, B:45:0x00be, B:47:0x00cc, B:48:0x00d6, B:57:0x011c, B:61:0x0124, B:53:0x0105), top: B:136:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00cc A[Catch: all -> 0x00b6, TryCatch #3 {all -> 0x00b6, blocks: (B:36:0x00ad, B:38:0x00b1, B:45:0x00be, B:47:0x00cc, B:48:0x00d6, B:57:0x011c, B:61:0x0124, B:53:0x0105), top: B:136:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:51:0x0100 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x0102  */
    /* JADX WARN: Code duplicated, block: B:53:0x0105 A[Catch: all -> 0x00b6, TRY_ENTER, TryCatch #3 {all -> 0x00b6, blocks: (B:36:0x00ad, B:38:0x00b1, B:45:0x00be, B:47:0x00cc, B:48:0x00d6, B:57:0x011c, B:61:0x0124, B:53:0x0105), top: B:136:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:55:0x0119  */
    /* JADX WARN: Code duplicated, block: B:56:0x011b  */
    /* JADX WARN: Code duplicated, block: B:59:0x0122  */
    /* JADX WARN: Code duplicated, block: B:60:0x0123  */
    /* JADX WARN: Code duplicated, block: B:69:0x0166  */
    /* JADX WARN: Code duplicated, block: B:71:0x016b A[Catch: all -> 0x0278, TryCatch #4 {all -> 0x0278, blocks: (B:65:0x0151, B:71:0x016b, B:72:0x0184), top: B:137:0x012f }] */
    /* JADX WARN: Code duplicated, block: B:72:0x0184 A[Catch: all -> 0x0278, TRY_LEAVE, TryCatch #4 {all -> 0x0278, blocks: (B:65:0x0151, B:71:0x016b, B:72:0x0184), top: B:137:0x012f }] */
    /* JADX WARN: Code duplicated, block: B:77:0x01b1 A[Catch: all -> 0x0276, TryCatch #2 {all -> 0x0276, blocks: (B:75:0x0197, B:77:0x01b1, B:78:0x01b6, B:80:0x01bc, B:83:0x01c2, B:85:0x01cb, B:84:0x01c7, B:86:0x01d1, B:88:0x01da, B:90:0x01e6, B:97:0x0224, B:99:0x022c, B:102:0x0231, B:103:0x0254, B:104:0x0255, B:91:0x01fb, B:94:0x0201, B:96:0x0211, B:105:0x0258, B:106:0x026b, B:74:0x0194), top: B:135:0x0194 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x01c2 A[Catch: all -> 0x0276, TryCatch #2 {all -> 0x0276, blocks: (B:75:0x0197, B:77:0x01b1, B:78:0x01b6, B:80:0x01bc, B:83:0x01c2, B:85:0x01cb, B:84:0x01c7, B:86:0x01d1, B:88:0x01da, B:90:0x01e6, B:97:0x0224, B:99:0x022c, B:102:0x0231, B:103:0x0254, B:104:0x0255, B:91:0x01fb, B:94:0x0201, B:96:0x0211, B:105:0x0258, B:106:0x026b, B:74:0x0194), top: B:135:0x0194 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x01c7 A[Catch: all -> 0x0276, TryCatch #2 {all -> 0x0276, blocks: (B:75:0x0197, B:77:0x01b1, B:78:0x01b6, B:80:0x01bc, B:83:0x01c2, B:85:0x01cb, B:84:0x01c7, B:86:0x01d1, B:88:0x01da, B:90:0x01e6, B:97:0x0224, B:99:0x022c, B:102:0x0231, B:103:0x0254, B:104:0x0255, B:91:0x01fb, B:94:0x0201, B:96:0x0211, B:105:0x0258, B:106:0x026b, B:74:0x0194), top: B:135:0x0194 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x01da A[Catch: all -> 0x0276, TryCatch #2 {all -> 0x0276, blocks: (B:75:0x0197, B:77:0x01b1, B:78:0x01b6, B:80:0x01bc, B:83:0x01c2, B:85:0x01cb, B:84:0x01c7, B:86:0x01d1, B:88:0x01da, B:90:0x01e6, B:97:0x0224, B:99:0x022c, B:102:0x0231, B:103:0x0254, B:104:0x0255, B:91:0x01fb, B:94:0x0201, B:96:0x0211, B:105:0x0258, B:106:0x026b, B:74:0x0194), top: B:135:0x0194 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x01e6 A[Catch: all -> 0x0276, TryCatch #2 {all -> 0x0276, blocks: (B:75:0x0197, B:77:0x01b1, B:78:0x01b6, B:80:0x01bc, B:83:0x01c2, B:85:0x01cb, B:84:0x01c7, B:86:0x01d1, B:88:0x01da, B:90:0x01e6, B:97:0x0224, B:99:0x022c, B:102:0x0231, B:103:0x0254, B:104:0x0255, B:91:0x01fb, B:94:0x0201, B:96:0x0211, B:105:0x0258, B:106:0x026b, B:74:0x0194), top: B:135:0x0194 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x01fb A[Catch: all -> 0x0276, TryCatch #2 {all -> 0x0276, blocks: (B:75:0x0197, B:77:0x01b1, B:78:0x01b6, B:80:0x01bc, B:83:0x01c2, B:85:0x01cb, B:84:0x01c7, B:86:0x01d1, B:88:0x01da, B:90:0x01e6, B:97:0x0224, B:99:0x022c, B:102:0x0231, B:103:0x0254, B:104:0x0255, B:91:0x01fb, B:94:0x0201, B:96:0x0211, B:105:0x0258, B:106:0x026b, B:74:0x0194), top: B:135:0x0194 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x01ff A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:94:0x0201 A[Catch: all -> 0x0276, TryCatch #2 {all -> 0x0276, blocks: (B:75:0x0197, B:77:0x01b1, B:78:0x01b6, B:80:0x01bc, B:83:0x01c2, B:85:0x01cb, B:84:0x01c7, B:86:0x01d1, B:88:0x01da, B:90:0x01e6, B:97:0x0224, B:99:0x022c, B:102:0x0231, B:103:0x0254, B:104:0x0255, B:91:0x01fb, B:94:0x0201, B:96:0x0211, B:105:0x0258, B:106:0x026b, B:74:0x0194), top: B:135:0x0194 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x020e  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.google.android.libraries.navigation.internal.ms.az] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4, types: [com.google.android.libraries.navigation.internal.ms.az] */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3, types: [int] */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v45 */
    /* JADX WARN: Type inference failed for: r1v46 */
    /* JADX WARN: Type inference failed for: r23v0, types: [com.google.android.libraries.navigation.internal.ms.bb] */
    /* JADX WARN: Type inference failed for: r2v17, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v8, types: [com.google.android.libraries.navigation.internal.ms.bx] */
    public final ck a(bt btVar, com.google.android.libraries.navigation.internal.mx.g gVar, ViewGroup viewGroup, boolean z, View view, bk bkVar, boolean z2, com.google.android.libraries.navigation.internal.mx.j jVar) {
        cd cdVarB;
        az azVar;
        com.google.android.libraries.navigation.internal.mx.y yVar;
        ?? r12;
        Throwable th;
        Integer num;
        View viewA;
        ?? r4;
        View view2;
        boolean z3;
        bx bxVarD;
        by byVar;
        int i;
        ck ckVar;
        ?? r13;
        boolean z4;
        int size;
        ?? r14;
        ?? r1;
        ck ckVarA;
        com.google.android.libraries.navigation.internal.mx.i iVar;
        int i2;
        View childAt;
        ck ckVarA2;
        ?? r2;
        int id;
        boolean z5;
        List list;
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr;
        int size2;
        Object[] objArr;
        ?? r5;
        ay ayVar = new ay(btVar, gVar);
        if (ce.c()) {
            bt btVar2 = ayVar.a;
            com.google.android.libraries.navigation.internal.mx.g gVar2 = ayVar.b;
            com.google.android.libraries.navigation.internal.xn.a aVarC = com.google.android.libraries.navigation.internal.xn.a.c("CurvularInflater.inflateInternal ", btVar2.e.a);
            boolean z6 = gVar2 instanceof com.google.android.libraries.navigation.internal.mx.e;
            if (z6) {
                r5 = z6;
                aVarC = com.google.android.libraries.navigation.internal.xn.a.a(aVarC, com.google.android.libraries.navigation.internal.xn.a.c(", ", ((com.google.android.libraries.navigation.internal.mx.e) gVar2).a));
                r5 = ", ";
            }
            r5 = z6;
            cdVarB = ce.b(aVarC.a);
        } else {
            cdVarB = null;
        }
        try {
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                throw new IllegalStateException("Curvular inflation must only be done from the UI Thread. The current thread is " + String.valueOf(Thread.currentThread()));
            }
            synchronized (this.b) {
                if (this.b.isEmpty()) {
                    azVar = new az();
                } else {
                    List list2 = this.b;
                    azVar = (az) list2.remove(list2.size() - 1);
                }
            }
            az azVar2 = azVar;
            azVar2.k = gVar;
            azVar2.e = gVar.b();
            azVar2.b = jVar == null ? null : jVar.b;
            azVar2.b(gVar.c, false);
            boolean z7 = true;
            if (jVar != null) {
                azVar2.b(jVar.c, true);
            }
            if (azVar2.j != null) {
                azVar2.a.a();
                if (azVar2.c()) {
                    azVar2.c.a();
                }
            }
            if (view != null || bkVar != null) {
                yVar = null;
                if (yVar != null) {
                    list = azVar2.a.c;
                    mVarArr = yVar.b;
                    size2 = list.size();
                    if (size2 != 0) {
                        objArr = mVarArr;
                        Object[] objArr2 = (Object[]) Array.newInstance((Class<?>) com.google.android.libraries.navigation.internal.mx.m.class, size2);
                        list.toArray(objArr2);
                        objArr = objArr2;
                    }
                    objArr = mVarArr;
                    by byVar2 = yVar.a;
                    com.google.android.libraries.navigation.internal.mx.h hVar = new com.google.android.libraries.navigation.internal.mx.h(gVar, z2, jVar, (com.google.android.libraries.navigation.internal.mx.m[]) objArr);
                    hVar.f(ch.c(e.VIEW_STUB_STUB_IF, byVar2));
                    ckVarA = a(btVar, hVar, viewGroup, z, null, null, z2, jVar);
                    c(azVar2);
                } else {
                    if (view != null) {
                        view2 = view;
                    } else {
                        co coVar = this.d;
                        int i3 = azVar2.h;
                        int i4 = azVar2.i;
                        num = azVar2.g;
                        viewA = gVar.a(coVar, i4, num, viewGroup, z);
                    }
                    if (view != null) {
                        view2 = viewA;
                        r4 = num;
                        r4 = r5;
                        z3 = true;
                    } else {
                        view2 = viewA;
                        r4 = num;
                        r4 = r5;
                        z3 = false;
                    }
                    if (ck.j(view2) == null) {
                        z7 = false;
                    }
                    com.google.android.libraries.navigation.internal.yx.ar.k(z7);
                    bxVarD = d(azVar2.a);
                    byVar = azVar2.b;
                    try {
                        if (byVar != null) {
                            try {
                                i = -1;
                                an anVar = new an(view2, this.e, d(azVar2.c), byVar, bxVarD, azVar2.a(), btVar, azVar2.e, z3);
                                e(azVar2.c.a, anVar.a, anVar);
                                ckVar = anVar;
                                r13 = azVar2;
                                z4 = false;
                            } catch (Throwable th2) {
                                th = th2;
                                r4 = azVar2;
                                r12 = r4;
                                c(r12);
                                throw th;
                            }
                        } else {
                            z5 = false;
                            i = -1;
                            if (z2) {
                                ckVar = new cb(view2, this.e, bxVarD, azVar2.a(), btVar, azVar2.e, z3);
                                r13 = azVar2;
                                z4 = z5;
                            } else {
                                ax axVar = this.e;
                                cc ccVarA = azVar2.a();
                                int i5 = azVar2.e;
                                r12 = azVar2;
                                try {
                                    ckVar = new ck(view2, axVar, bxVarD, ccVarA, btVar, z3);
                                    z4 = z5;
                                    r13 = r12;
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            }
                        }
                        List list3 = r13.a.a;
                        r4 = ckVar.d;
                        e(list3, r4, ckVar);
                        view2.setTag(2131230834, ckVar);
                        b(r13.a, ckVar);
                        if (r13.c()) {
                            b(r13.c, ckVar);
                        }
                        if (view2.getId() == i && r13.f == null) {
                            if (bkVar == null) {
                                id = View.generateViewId();
                            } else {
                                id = bkVar.getId();
                            }
                            view2.setId(id);
                            view2.setSaveEnabled(z4);
                        }
                        size = r13.d.size();
                        r1 = z4;
                        for (r14 = z4; r14 < size; r14++) {
                            iVar = (com.google.android.libraries.navigation.internal.mx.i) r13.d.get(r14);
                            if (iVar instanceof com.google.android.libraries.navigation.internal.mx.j) {
                                com.google.android.libraries.navigation.internal.mx.j jVar2 = (com.google.android.libraries.navigation.internal.mx.j) iVar;
                                ckVarA2 = this.e.l().a(jVar2.a, (ViewGroup) view2, true, false, jVar2);
                                r2 = r1;
                            } else {
                                if (iVar instanceof com.google.android.libraries.navigation.internal.mx.g) {
                                    throw new com.google.android.libraries.navigation.internal.yx.cb("Internal error, child type not supported: ".concat(String.valueOf(String.valueOf(iVar))));
                                }
                                if (view != null) {
                                    int i6 = (r1 == true ? 1 : 0) + 1;
                                    childAt = ((ViewGroup) view).getChildAt(r1 == true ? 1 : 0);
                                    i2 = i6;
                                } else {
                                    i2 = r1 == true ? 1 : 0;
                                    childAt = null;
                                }
                                ckVarA2 = a(btVar, (com.google.android.libraries.navigation.internal.mx.g) iVar, (ViewGroup) view2, true, childAt, null, false, null);
                                r2 = i2;
                            }
                            if (ckVarA2.c.getParent() == null && !(view2 instanceof ViewGroup)) {
                                throw new com.google.android.libraries.navigation.internal.mv.a("Could not add child View to View of type " + view2.getClass().getName() + " - this is not a ViewGroup. Check your brackets. You may be including a member of a ViewGroup in a previous member.");
                            }
                            r1 = r2;
                        }
                        c(r13);
                        ckVarA = ckVar;
                    } catch (Throwable th4) {
                        th = th4;
                    }
                }
                if (cdVarB != null) {
                    Trace.endSection();
                }
                return ckVarA;
            }
            try {
                if ((gVar instanceof com.google.android.libraries.navigation.internal.mx.h) || (yVar = azVar2.j) == null) {
                    yVar = null;
                }
                if (yVar != null) {
                    list = azVar2.a.c;
                    mVarArr = yVar.b;
                    size2 = list.size();
                    if (size2 != 0) {
                        objArr = mVarArr;
                        Object[] objArr3 = (Object[]) Array.newInstance((Class<?>) com.google.android.libraries.navigation.internal.mx.m.class, size2);
                        list.toArray(objArr3);
                        objArr = objArr3;
                    }
                    objArr = mVarArr;
                    by byVar3 = yVar.a;
                    com.google.android.libraries.navigation.internal.mx.h hVar2 = new com.google.android.libraries.navigation.internal.mx.h(gVar, z2, jVar, (com.google.android.libraries.navigation.internal.mx.m[]) objArr);
                    hVar2.f(ch.c(e.VIEW_STUB_STUB_IF, byVar3));
                    ckVarA = a(btVar, hVar2, viewGroup, z, null, null, z2, jVar);
                    c(azVar2);
                } else {
                    if (view != null) {
                        view2 = view;
                    } else {
                        co coVar2 = this.d;
                        int i7 = azVar2.h;
                        int i8 = azVar2.i;
                        num = azVar2.g;
                        viewA = gVar.a(coVar2, i8, num, viewGroup, z);
                    }
                    if (view != null) {
                        view2 = viewA;
                        r4 = num;
                        r4 = r5;
                        z3 = true;
                    } else {
                        view2 = viewA;
                        r4 = num;
                        r4 = r5;
                        z3 = false;
                    }
                    if (ck.j(view2) == null) {
                        z7 = false;
                    }
                    com.google.android.libraries.navigation.internal.yx.ar.k(z7);
                    bxVarD = d(azVar2.a);
                    byVar = azVar2.b;
                    if (byVar != null) {
                        i = -1;
                        an anVar2 = new an(view2, this.e, d(azVar2.c), byVar, bxVarD, azVar2.a(), btVar, azVar2.e, z3);
                        e(azVar2.c.a, anVar2.a, anVar2);
                        ckVar = anVar2;
                        r13 = azVar2;
                        z4 = false;
                    } else {
                        z5 = false;
                        i = -1;
                        if (z2) {
                            ckVar = new cb(view2, this.e, bxVarD, azVar2.a(), btVar, azVar2.e, z3);
                            r13 = azVar2;
                            z4 = z5;
                        } else {
                            ax axVar2 = this.e;
                            cc ccVarA2 = azVar2.a();
                            int i9 = azVar2.e;
                            r12 = azVar2;
                            ckVar = new ck(view2, axVar2, bxVarD, ccVarA2, btVar, z3);
                            z4 = z5;
                            r13 = r12;
                        }
                    }
                    List list4 = r13.a.a;
                    r4 = ckVar.d;
                    e(list4, r4, ckVar);
                    view2.setTag(2131230834, ckVar);
                    b(r13.a, ckVar);
                    if (r13.c()) {
                        b(r13.c, ckVar);
                    }
                    if (view2.getId() == i) {
                        if (bkVar == null) {
                            id = View.generateViewId();
                        } else {
                            id = bkVar.getId();
                        }
                        view2.setId(id);
                        view2.setSaveEnabled(z4);
                    }
                    size = r13.d.size();
                    r1 = z4;
                    while (r14 < size) {
                        iVar = (com.google.android.libraries.navigation.internal.mx.i) r13.d.get(r14);
                        if (iVar instanceof com.google.android.libraries.navigation.internal.mx.j) {
                            com.google.android.libraries.navigation.internal.mx.j jVar3 = (com.google.android.libraries.navigation.internal.mx.j) iVar;
                            ckVarA2 = this.e.l().a(jVar3.a, (ViewGroup) view2, true, false, jVar3);
                            r2 = r1;
                        } else {
                            if (iVar instanceof com.google.android.libraries.navigation.internal.mx.g) {
                                throw new com.google.android.libraries.navigation.internal.yx.cb("Internal error, child type not supported: ".concat(String.valueOf(String.valueOf(iVar))));
                            }
                            if (view != null) {
                                int i10 = (r1 == true ? 1 : 0) + 1;
                                childAt = ((ViewGroup) view).getChildAt(r1 == true ? 1 : 0);
                                i2 = i10;
                            } else {
                                i2 = r1 == true ? 1 : 0;
                                childAt = null;
                            }
                            ckVarA2 = a(btVar, (com.google.android.libraries.navigation.internal.mx.g) iVar, (ViewGroup) view2, true, childAt, null, false, null);
                            r2 = i2;
                        }
                        if (ckVarA2.c.getParent() == null) {
                            throw new com.google.android.libraries.navigation.internal.mv.a("Could not add child View to View of type " + view2.getClass().getName() + " - this is not a ViewGroup. Check your brackets. You may be including a member of a ViewGroup in a previous member.");
                        }
                        r1 = r2;
                    }
                    c(r13);
                    ckVarA = ckVar;
                }
                if (cdVarB != null) {
                    Trace.endSection();
                }
                return ckVarA;
            } catch (Throwable th5) {
                th = th5;
                r12 = azVar2;
            }
            c(r12);
            throw th;
        } catch (Throwable th6) {
            if (cdVarB == null) {
                throw th6;
            }
            try {
                Trace.endSection();
                throw th6;
            } catch (Throwable th7) {
                th6.addSuppressed(th7);
                throw th6;
            }
        }
    }
}

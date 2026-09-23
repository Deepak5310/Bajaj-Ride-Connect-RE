package com.google.android.libraries.navigation.internal.fq;

import com.google.android.libraries.navigation.internal.agi.cj;
import com.google.android.libraries.navigation.internal.agi.em;
import com.google.android.libraries.navigation.internal.agi.ep;
import com.google.android.libraries.navigation.internal.agi.eq;
import com.google.android.libraries.navigation.internal.agi.et;
import com.google.android.libraries.navigation.internal.agi.gw;
import com.google.android.libraries.navigation.internal.km.an;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class k implements p {
    private static final com.google.android.libraries.navigation.internal.zb.j c = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.fq.k");
    public et a;
    protected int b;
    private final f d;
    private cj e;
    private int f;
    private com.google.android.libraries.navigation.internal.xn.a g;
    private final h h;
    private a i;

    public k(int i) {
        this(i, null, null);
    }

    private final synchronized Object s(Object obj) {
        Object objRemove;
        objRemove = this.a.remove(obj);
        if (objRemove != null) {
            this.f -= this.e.b(obj);
            n(obj, objRemove);
        }
        return objRemove;
    }

    @Override // com.google.android.libraries.navigation.internal.fq.p
    public final String a() {
        return "numItems: " + c() + " measuredSize: " + b();
    }

    public final synchronized int b() {
        return this.f;
    }

    public final synchronized int c() {
        return this.a.k;
    }

    public int d(Object obj) {
        return 1;
    }

    public final synchronized Object e(Object obj) {
        Object obj2;
        obj2 = this.a.get(obj);
        l(obj2);
        o(obj, obj2);
        return obj2;
    }

    public synchronized Object f(Object obj) {
        Object obj2;
        et etVar = this.a;
        obj2 = null;
        if (obj != null) {
            Object[] objArr = etVar.a;
            int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj.hashCode()) & etVar.c;
            Object obj3 = objArr[iE];
            if (obj3 != null) {
                if (!obj.equals(obj3)) {
                    while (true) {
                        iE = (iE + 1) & etVar.c;
                        Object obj4 = objArr[iE];
                        if (obj4 == null) {
                            break;
                        }
                        if (obj.equals(obj4)) {
                            etVar.o(iE);
                            obj2 = etVar.b[iE];
                            break;
                        }
                    }
                } else {
                    etVar.o(iE);
                    obj2 = etVar.b[iE];
                }
            }
        } else if (etVar.d) {
            etVar.o(etVar.h);
            obj2 = etVar.b[etVar.h];
        }
        l(obj2);
        o(obj, obj2);
        return obj2;
    }

    public final synchronized Object g(Object obj) {
        return s(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.fq.p
    public final synchronized void h(float f) {
        float f2 = 0.5f;
        if (f < 0.0f) {
            try {
                ((com.google.android.libraries.navigation.internal.zb.h) c.d(com.google.android.libraries.navigation.internal.nl.a.a).F(497)).s("fraction %f < 0", Float.valueOf(f));
                f = 0.5f;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (f > 1.0f) {
            ((com.google.android.libraries.navigation.internal.zb.h) c.d(com.google.android.libraries.navigation.internal.nl.a.a).F(496)).s("fraction %f > 1", Float.valueOf(f));
        } else {
            f2 = f;
        }
        q((int) (b() * f2));
        et etVar = this.a;
        etVar.t(etVar.k);
        cj cjVar = this.e;
        cjVar.v(cjVar.h);
    }

    public final synchronized Collection i() {
        return new ArrayList(this.a.values());
    }

    public final synchronized void j(int i) {
        this.b = i;
    }

    public synchronized void k() {
        q(0);
    }

    public final synchronized void l(Object obj) {
        a aVar = this.i;
        if (aVar != null) {
            if (obj != null) {
                aVar.a();
            } else {
                aVar.b();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0092 A[Catch: all -> 0x00e7, TryCatch #0 {all -> 0x00e7, blocks: (B:4:0x0003, B:7:0x001a, B:9:0x0020, B:10:0x0035, B:12:0x003a, B:14:0x003e, B:35:0x00cc, B:37:0x00da, B:38:0x00dd, B:15:0x004b, B:27:0x0086, B:29:0x0092, B:31:0x00b9, B:33:0x00c2, B:30:0x009d, B:16:0x0050, B:18:0x0061, B:20:0x0067, B:21:0x006f, B:23:0x0077, B:25:0x007d), top: B:44:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x009d A[Catch: all -> 0x00e7, TryCatch #0 {all -> 0x00e7, blocks: (B:4:0x0003, B:7:0x001a, B:9:0x0020, B:10:0x0035, B:12:0x003a, B:14:0x003e, B:35:0x00cc, B:37:0x00da, B:38:0x00dd, B:15:0x004b, B:27:0x0086, B:29:0x0092, B:31:0x00b9, B:33:0x00c2, B:30:0x009d, B:16:0x0050, B:18:0x0061, B:20:0x0067, B:21:0x006f, B:23:0x0077, B:25:0x007d), top: B:44:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x00c2 A[Catch: all -> 0x00e7, TryCatch #0 {all -> 0x00e7, blocks: (B:4:0x0003, B:7:0x001a, B:9:0x0020, B:10:0x0035, B:12:0x003a, B:14:0x003e, B:35:0x00cc, B:37:0x00da, B:38:0x00dd, B:15:0x004b, B:27:0x0086, B:29:0x0092, B:31:0x00b9, B:33:0x00c2, B:30:0x009d, B:16:0x0050, B:18:0x0061, B:20:0x0067, B:21:0x006f, B:23:0x0077, B:25:0x007d), top: B:44:0x0001 }] */
    public final synchronized void m(Object obj, Object obj2) {
        int i;
        Object objL;
        int i2;
        int i3;
        try {
            if (obj2 == null) {
                ((com.google.android.libraries.navigation.internal.zb.h) c.d(com.google.android.libraries.navigation.internal.nl.a.a).F(499)).s("insert() was invoked with null value. key is %s", obj);
                return;
            }
            int iD = d(obj2);
            if (iD <= 0) {
                ((com.google.android.libraries.navigation.internal.zb.h) c.d(com.google.android.libraries.navigation.internal.nl.a.a).F(498)).w("Entry %s has illegal size %d", obj2, iD);
            }
            et etVar = this.a;
            if (obj != null) {
                Object[] objArr = etVar.a;
                int iE = com.google.android.libraries.navigation.internal.agc.e.e(obj.hashCode()) & etVar.c;
                Object obj3 = objArr[iE];
                if (obj3 != null) {
                    if (obj3.equals(obj)) {
                        etVar.o(iE);
                        objL = etVar.l(iE, obj2);
                    } else {
                        while (true) {
                            iE = (iE + 1) & etVar.c;
                            Object obj4 = objArr[iE];
                            if (obj4 != null) {
                                if (obj4.equals(obj)) {
                                    etVar.o(iE);
                                    objL = etVar.l(iE, obj2);
                                }
                            }
                        }
                    }
                }
                i = iE;
                etVar.a[i] = obj;
                etVar.b[i] = obj2;
                i2 = etVar.k;
                if (i2 == 0) {
                    etVar.f = i;
                    etVar.e = i;
                    etVar.g[i] = -1;
                } else {
                    long[] jArr = etVar.g;
                    int i4 = etVar.f;
                    long j = jArr[i4];
                    jArr[i4] = j ^ (((((long) i) & 4294967295L) ^ j) & 4294967295L);
                    jArr[i] = ((((long) i4) & 4294967295L) << 32) | 4294967295L;
                    etVar.f = i;
                }
                i3 = i2 + 1;
                etVar.k = i3;
                if (i2 >= etVar.i) {
                    etVar.p(com.google.android.libraries.navigation.internal.agc.e.a(i3, 0.75f));
                }
                objL = null;
            } else if (etVar.d) {
                etVar.o(etVar.h);
                objL = etVar.l(etVar.h, obj2);
            } else {
                etVar.d = true;
                i = etVar.h;
                etVar.a[i] = obj;
                etVar.b[i] = obj2;
                i2 = etVar.k;
                if (i2 == 0) {
                    etVar.f = i;
                    etVar.e = i;
                    etVar.g[i] = -1;
                } else {
                    long[] jArr2 = etVar.g;
                    int i5 = etVar.f;
                    long j2 = jArr2[i5];
                    jArr2[i5] = j2 ^ (((((long) i) & 4294967295L) ^ j2) & 4294967295L);
                    jArr2[i] = ((((long) i5) & 4294967295L) << 32) | 4294967295L;
                    etVar.f = i;
                }
                i3 = i2 + 1;
                etVar.k = i3;
                if (i2 >= etVar.i) {
                    etVar.p(com.google.android.libraries.navigation.internal.agc.e.a(i3, 0.75f));
                }
                objL = null;
            }
            this.f = (this.f - this.e.a(obj, iD)) + iD;
            if (objL != null) {
                n(obj, objL);
            }
            p(obj, obj2);
            q(this.b);
        } catch (Throwable th) {
            throw th;
        }
    }

    protected void n(Object obj, Object obj2) {
    }

    protected void o(Object obj, Object obj2) {
    }

    protected void p(Object obj, Object obj2) {
    }

    public final synchronized void q(int i) {
        try {
            if (i != 0) {
                while (!this.a.isEmpty() && this.f > i) {
                    g(this.a.firstKey());
                }
                return;
            }
            this.e = new cj();
            if (!this.a.isEmpty()) {
                gw gwVarH = ((eq) this.a.d()).aU();
                while (gwVarH.hasNext()) {
                    ep epVarB = ((em) gwVarH).next();
                    n(epVarB.getKey(), epVarB.getValue());
                    epVarB.getKey();
                    epVarB.getValue();
                    epVarB.getKey();
                    epVarB.getValue();
                }
            }
            this.a = new et();
            this.f = 0;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean r() {
        return this.a.isEmpty();
    }

    public k(int i, h hVar, f fVar) {
        this(i, hVar, fVar, null);
    }

    public k(int i, h hVar, f fVar, com.google.android.libraries.navigation.internal.xn.a aVar) {
        com.google.android.libraries.navigation.internal.kl.a aVar2;
        this.a = new et();
        this.e = new cj();
        this.b = i;
        this.d = fVar;
        if (hVar == null) {
            this.h = h.OTHER;
        } else {
            this.h = hVar;
        }
        com.google.android.libraries.navigation.internal.xn.a aVarE = com.google.android.libraries.navigation.internal.xn.a.e(this.h);
        this.g = aVarE;
        if (aVar != null) {
            com.google.android.libraries.navigation.internal.xn.a aVarA = com.google.android.libraries.navigation.internal.xn.a.a(aVarE, com.google.android.libraries.navigation.internal.xn.a.d(": "));
            this.g = aVarA;
            this.g = com.google.android.libraries.navigation.internal.xn.a.a(aVarA, aVar);
        }
        if (fVar != null) {
            h hVar2 = this.h;
            if (hVar2.B && (aVar2 = fVar.c) != null) {
                this.i = b.a(hVar2.A, h.ALL_LRU.A, an.s, an.t, aVar2);
            }
        }
        if (fVar != null) {
            fVar.c(this, this.g);
        }
    }
}

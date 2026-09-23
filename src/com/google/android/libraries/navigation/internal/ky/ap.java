package com.google.android.libraries.navigation.internal.ky;

import androidx.collection.LongSparseArray;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.cy;
import com.google.android.libraries.navigation.internal.lh.be;
import com.google.android.libraries.navigation.internal.yx.br;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ap {
    public final ReentrantReadWriteLock d;
    public final o e;
    public boolean f;
    public volatile int g;
    public volatile Future h;
    public long i;
    public final Map j;
    public ah k;
    public final LinkedHashSet l;
    public final com.google.android.libraries.navigation.internal.ll.d m;
    private final String o;
    private volatile al p;
    public static final ab a = new ae(1);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Charset f475n = Charset.forName("UTF-8");
    static final ah b = new ah();
    public static final ah c = new ah();

    public ap(o oVar, String str, com.google.android.libraries.navigation.internal.ll.d dVar) {
        this.d = new ReentrantReadWriteLock();
        this.j = new TreeMap();
        this.k = b;
        this.l = new LinkedHashSet();
        this.p = null;
        this.e = oVar;
        be.j("GMM_REALTIME_COUNTERS");
        this.o = "GMM_REALTIME_COUNTERS";
        be.a(true);
        be.j(dVar);
        this.m = dVar;
        this.i = dVar.a();
    }

    public static long a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes(f475n));
            return ByteBuffer.wrap(messageDigest.digest()).getLong();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    public final aa b(String str, br brVar) {
        this.d.writeLock().lock();
        try {
            aa aaVar = (aa) brVar.a();
            this.j.put(str, aaVar);
            return aaVar;
        } finally {
            this.d.writeLock().unlock();
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.libraries.navigation.internal.ky.x] */
    public final ag c(String str) {
        ReentrantReadWriteLock reentrantReadWriteLock;
        ?? r0 = new Object() { // from class: com.google.android.libraries.navigation.internal.ky.x
            public final aa a(final String str2) {
                final ap apVar = this.a;
                return (ag) apVar.b(str2, new br() { // from class: com.google.android.libraries.navigation.internal.ky.v
                    @Override // com.google.android.libraries.navigation.internal.yx.br
                    public final Object a() {
                        return new ag(apVar, str2);
                    }
                });
            }
        };
        this.d.writeLock().lock();
        try {
            aa aaVarA = (aa) this.j.get(str);
            if (aaVarA == null) {
                aaVarA = r0.a(str);
                reentrantReadWriteLock = this.d;
            } else {
                reentrantReadWriteLock = this.d;
            }
            reentrantReadWriteLock.writeLock().unlock();
            return (ag) aaVarA;
        } catch (Throwable th) {
            this.d.writeLock().unlock();
            throw th;
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.android.libraries.navigation.internal.ky.w] */
    public final ao d(String str, ab abVar) {
        ac acVarA;
        ?? r2 = new Object() { // from class: com.google.android.libraries.navigation.internal.ky.w
            public final ac a(final String str2, final ab abVar2) {
                final ap apVar = this.a;
                return (ao) apVar.b(str2, new br() { // from class: com.google.android.libraries.navigation.internal.ky.y
                    @Override // com.google.android.libraries.navigation.internal.yx.br
                    public final Object a() {
                        return new ao(apVar, str2, abVar2);
                    }
                });
            }
        };
        this.d.writeLock().lock();
        try {
            aa aaVar = (aa) this.j.get(str);
            if (aaVar == null) {
                acVarA = r2.a(str, abVar);
            } else {
                try {
                    ac acVar = (ac) aaVar;
                    if (!abVar.equals(acVar.g)) {
                        throw new IllegalArgumentException("alias mismatch: " + str);
                    }
                    acVarA = acVar;
                } catch (ClassCastException e) {
                    throw new IllegalArgumentException("another type of counter exists with name: " + str, e);
                }
            }
            this.d.writeLock().unlock();
            return (ao) acVarA;
        } catch (Throwable th) {
            this.d.writeLock().unlock();
            throw th;
        }
    }

    public final void e() {
        this.d.writeLock().lock();
        try {
            ap apVar = new ap(this);
            this.d.writeLock().unlock();
            int size = apVar.l.size();
            n[] nVarArr = new n[size];
            Iterator it2 = apVar.l.iterator();
            int i = 0;
            while (it2.hasNext()) {
                ah ahVar = (ah) it2.next();
                o oVar = apVar.e;
                be.j(ahVar);
                aj ajVar = new aj(apVar, ahVar);
                ArrayList arrayList = new ArrayList(ajVar.b.j.size());
                for (aa aaVar : ajVar.b.j.values()) {
                    if (aaVar.c.containsKey(ajVar.a)) {
                        arrayList.add(aaVar);
                    }
                }
                com.google.android.libraries.navigation.internal.afk.l lVar = (com.google.android.libraries.navigation.internal.afk.l) com.google.android.libraries.navigation.internal.afk.m.a.q();
                long j = ajVar.b.i;
                if (!lVar.b.H()) {
                    lVar.v();
                }
                com.google.android.libraries.navigation.internal.afk.m mVar = (com.google.android.libraries.navigation.internal.afk.m) lVar.b;
                mVar.b |= 1;
                mVar.c = j;
                be.f(!c.equals(ajVar.a));
                if (!b.equals(ajVar.a)) {
                    cy cyVar = ajVar.a.a;
                    be.j(cyVar);
                    com.google.android.libraries.navigation.internal.ael.x xVarK = cyVar.k();
                    if (!lVar.b.H()) {
                        lVar.v();
                    }
                    com.google.android.libraries.navigation.internal.afk.m mVar2 = (com.google.android.libraries.navigation.internal.afk.m) lVar.b;
                    mVar2.b |= 4;
                    mVar2.e = xVarK;
                }
                int size2 = arrayList.size();
                int i2 = 0;
                while (i2 < size2) {
                    aa aaVar2 = (aa) arrayList.get(i2);
                    LongSparseArray longSparseArray = (LongSparseArray) aaVar2.c.get(ajVar.a);
                    be.j(longSparseArray);
                    com.google.android.libraries.navigation.internal.afk.j jVar = (com.google.android.libraries.navigation.internal.afk.j) com.google.android.libraries.navigation.internal.afk.k.a.q();
                    long jA = a(aaVar2.a);
                    if (!jVar.b.H()) {
                        jVar.v();
                    }
                    com.google.android.libraries.navigation.internal.afk.k kVar = (com.google.android.libraries.navigation.internal.afk.k) jVar.b;
                    Iterator it3 = it2;
                    kVar.b = 1;
                    kVar.c = Long.valueOf(jA);
                    ArrayList arrayList2 = new ArrayList(longSparseArray.size());
                    aj ajVar2 = ajVar;
                    int i3 = 0;
                    while (i3 < longSparseArray.size()) {
                        com.google.android.libraries.navigation.internal.afk.h hVar = (com.google.android.libraries.navigation.internal.afk.h) com.google.android.libraries.navigation.internal.afk.i.a.q();
                        ArrayList arrayList3 = arrayList;
                        int i4 = size2;
                        long j2 = ((long[]) longSparseArray.valueAt(i3))[0];
                        if (!hVar.b.H()) {
                            hVar.v();
                        }
                        com.google.android.libraries.navigation.internal.afk.i iVar = (com.google.android.libraries.navigation.internal.afk.i) hVar.b;
                        ap apVar2 = apVar;
                        iVar.b |= 2;
                        iVar.d = j2;
                        long jKeyAt = longSparseArray.keyAt(i3);
                        if (aaVar2 instanceof ag) {
                            be.f(jKeyAt == 0);
                        } else {
                            if (!hVar.b.H()) {
                                hVar.v();
                            }
                            com.google.android.libraries.navigation.internal.afk.i iVar2 = (com.google.android.libraries.navigation.internal.afk.i) hVar.b;
                            iVar2.b |= 1;
                            iVar2.c = jKeyAt;
                        }
                        arrayList2.add((com.google.android.libraries.navigation.internal.afk.i) hVar.t());
                        i3++;
                        apVar = apVar2;
                        arrayList = arrayList3;
                        size2 = i4;
                    }
                    ap apVar3 = apVar;
                    ArrayList arrayList4 = arrayList;
                    int i5 = size2;
                    Collections.sort(arrayList2, new Comparator() { // from class: com.google.android.libraries.navigation.internal.ky.ai
                        @Override // java.util.Comparator
                        public final int compare(Object obj, Object obj2) {
                            return Long.compare(((com.google.android.libraries.navigation.internal.afk.i) obj).c, ((com.google.android.libraries.navigation.internal.afk.i) obj2).c);
                        }
                    });
                    if (!jVar.b.H()) {
                        jVar.v();
                    }
                    com.google.android.libraries.navigation.internal.afk.k kVar2 = (com.google.android.libraries.navigation.internal.afk.k) jVar.b;
                    bz bzVar = kVar2.d;
                    if (!bzVar.c()) {
                        kVar2.d = bi.A(bzVar);
                    }
                    com.google.android.libraries.navigation.internal.ael.b.m(arrayList2, kVar2.d);
                    com.google.android.libraries.navigation.internal.afk.k kVar3 = (com.google.android.libraries.navigation.internal.afk.k) jVar.t();
                    if (!lVar.b.H()) {
                        lVar.v();
                    }
                    com.google.android.libraries.navigation.internal.afk.m mVar3 = (com.google.android.libraries.navigation.internal.afk.m) lVar.b;
                    kVar3.getClass();
                    bz bzVar2 = mVar3.d;
                    if (!bzVar2.c()) {
                        mVar3.d = bi.A(bzVar2);
                    }
                    mVar3.d.add(kVar3);
                    i2++;
                    ajVar = ajVar2;
                    apVar = apVar3;
                    it2 = it3;
                    arrayList = arrayList4;
                    size2 = i5;
                }
                nVarArr[i] = oVar.f((com.google.android.libraries.navigation.internal.afk.m) lVar.t());
                i++;
                apVar = apVar;
            }
            ap apVar4 = apVar;
            com.google.android.libraries.navigation.internal.me.w wVarC = null;
            for (int i6 = 0; i6 < size; i6++) {
                n nVar = nVarArr[i6];
                nVar.h = apVar4.o;
                wVarC = nVar.c();
            }
            if (wVarC != null) {
                return;
            }
            com.google.android.libraries.navigation.internal.me.ah.b(null);
        } catch (Throwable th) {
            this.d.writeLock().unlock();
            throw th;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        this.d.readLock().lock();
        try {
            sb.append("{");
            new com.google.android.libraries.navigation.internal.yx.ah(", ").h(sb, this.l);
            sb.append("}\n");
            new com.google.android.libraries.navigation.internal.yx.ah("\n").h(sb, this.j.values());
            return sb.toString();
        } finally {
            this.d.readLock().unlock();
        }
    }

    private ap(ap apVar) {
        aa adVar;
        this(apVar.e, apVar.o, apVar.m);
        ReentrantReadWriteLock.WriteLock writeLock = apVar.d.writeLock();
        writeLock.lock();
        try {
            this.k = apVar.k;
            this.i = apVar.i;
            for (Map.Entry entry : apVar.j.entrySet()) {
                Map map = this.j;
                String str = (String) entry.getKey();
                aa aaVar = (aa) entry.getValue();
                if (!(aaVar instanceof ag)) {
                    if (aaVar instanceof ao) {
                        adVar = new ao(this, (ao) aaVar);
                    } else if (aaVar instanceof ak) {
                        adVar = new ak(this, (ak) aaVar);
                    } else if (aaVar instanceof am) {
                        adVar = new am(this, (am) aaVar);
                    } else if (aaVar instanceof ad) {
                        adVar = new ad(this, (ad) aaVar);
                    } else {
                        throw new IllegalArgumentException("Unknown counter type: ".concat(String.valueOf(String.valueOf(aaVar))));
                    }
                } else {
                    adVar = new ag(this, (ag) aaVar);
                }
                map.put(str, adVar);
            }
            this.l.addAll(apVar.l);
            apVar.l.clear();
            apVar.i = this.m.a();
            writeLock.unlock();
        } catch (Throwable th) {
            writeLock.unlock();
            throw th;
        }
    }
}

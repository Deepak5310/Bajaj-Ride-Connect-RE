package com.google.android.libraries.navigation.internal.oz;

import android.util.LongSparseArray;
import com.google.android.libraries.navigation.internal.adg.am;
import com.google.android.libraries.navigation.internal.adg.df;
import com.google.android.libraries.navigation.internal.adg.ie;
import com.google.android.libraries.navigation.internal.agg.ey;
import com.google.android.libraries.navigation.internal.agg.ez;
import com.google.android.libraries.navigation.internal.agg.fa;
import com.google.android.libraries.navigation.internal.agg.fc;
import com.google.android.libraries.navigation.internal.agg.fd;
import com.google.android.libraries.navigation.internal.agi.ha;
import com.google.android.libraries.navigation.internal.agi.hc;
import com.google.android.libraries.navigation.internal.om.n;
import com.google.android.libraries.navigation.internal.yx.aa;
import com.google.android.libraries.navigation.internal.yz.de;
import com.google.android.libraries.navigation.internal.yz.eg;
import com.google.android.libraries.navigation.internal.yz.fw;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.la;
import com.google.android.libraries.navigation.internal.yz.mq;
import com.google.android.libraries.navigation.internal.yz.nn;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements f {
    public static final fy a;
    public final Map b = new HashMap();
    public final LongSparseArray c = new LongSparseArray();
    public final n d;
    public final com.google.android.libraries.navigation.internal.agl.a e;
    public final boolean f;
    private final com.google.android.libraries.navigation.internal.afo.a g;

    static {
        int i = ie.a;
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        a = new mq(Integer.valueOf(i2));
    }

    public d(boolean z, n nVar, com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.afo.a aVar2) {
        this.f = z;
        this.d = nVar;
        this.e = aVar;
        this.g = aVar2;
    }

    private final ez d(ez ezVar, long j) {
        eg egVar = (eg) this.c.get(j);
        if (egVar == null) {
            return fd.a;
        }
        int size = egVar.size();
        ey eyVar = new ey(size + size);
        Iterator itA = la.a(egVar);
        while (itA.hasNext()) {
            b bVar = (b) itA.next();
            if (com.google.android.libraries.navigation.internal.pa.a.b(bVar.a, ezVar)) {
                eyVar.addAll(a);
            } else {
                df dfVar = bVar.a.d;
                if (dfVar == null) {
                    dfVar = df.a;
                }
                if ((dfVar.b & 4) != 0) {
                    df dfVar2 = bVar.a.d;
                    if (dfVar2 == null) {
                        dfVar2 = df.a;
                    }
                    am amVar = dfVar2.e;
                    if (amVar == null) {
                        amVar = am.a;
                    }
                    eyVar.addAll(amVar.b);
                }
            }
        }
        if (eyVar.isEmpty()) {
            return fd.a;
        }
        fa faVar = fd.a;
        return new fc(eyVar);
    }

    @Override // com.google.android.libraries.navigation.internal.oz.f
    public final ez a(long j) {
        ez ezVarD;
        this.e.a();
        ez ezVar = ((com.google.android.libraries.navigation.internal.om.f) this.d).b;
        synchronized (this.c) {
            ezVarD = d(ezVar, j);
        }
        return ezVarD;
    }

    public final void b(List list) {
        hc hcVar = new hc();
        ArrayList arrayList = new ArrayList();
        synchronized (this.b) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                Set set = (Set) this.b.get((Long) it2.next());
                if (set != null) {
                    hcVar.addAll(set);
                }
            }
        }
        LongSparseArray longSparseArray = new LongSparseArray(list.size());
        n nVar = this.d;
        this.e.a();
        LongSparseArray longSparseArray2 = this.c;
        ez ezVar = ((com.google.android.libraries.navigation.internal.om.f) nVar).b;
        synchronized (longSparseArray2) {
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                Long l = (Long) it3.next();
                eg egVar = (eg) this.c.get(l.longValue());
                if (egVar != null) {
                    Iterable iterableH = de.d(egVar).e(new aa() { // from class: com.google.android.libraries.navigation.internal.oz.a
                        @Override // com.google.android.libraries.navigation.internal.yx.aa
                        public final Object ak(Object obj) {
                            fy fyVar = d.a;
                            return ((b) obj).a;
                        }
                    }).h();
                    if (iterableH instanceof Collection) {
                        arrayList.addAll((Collection) iterableH);
                    } else {
                        Iterator it4 = iterableH.iterator();
                        while (it4.hasNext()) {
                            arrayList.add(it4.next());
                        }
                    }
                    int size = egVar.size();
                    fw fwVarL = fy.l(size + size);
                    Iterator itA = la.a(egVar);
                    while (itA.hasNext()) {
                        b bVar = (b) itA.next();
                        if (com.google.android.libraries.navigation.internal.pa.a.b(bVar.a, ezVar)) {
                            fwVarL.k(a);
                        } else {
                            df dfVar = bVar.a.d;
                            if (dfVar == null) {
                                dfVar = df.a;
                            }
                            am amVar = dfVar.e;
                            if (amVar == null) {
                                amVar = am.a;
                            }
                            fwVarL.k(amVar.b);
                        }
                    }
                    longSparseArray.append(l.longValue(), fwVarL.i());
                }
            }
        }
        if (hcVar.isEmpty()) {
            return;
        }
        ha haVar = new ha(hcVar);
        while (haVar.hasNext()) {
            c cVar = (c) haVar.next();
            if (c(cVar.b.c())) {
                cVar.a.e(cVar.b.a());
            }
        }
        com.google.android.libraries.navigation.internal.pa.a.a(arrayList, ezVar, (com.google.android.libraries.navigation.internal.rc.f) this.g.a());
    }

    public final boolean c(com.google.android.libraries.navigation.internal.yz.fd fdVar) {
        if (!this.f) {
            return false;
        }
        n nVar = this.d;
        this.e.a();
        LongSparseArray longSparseArray = this.c;
        ez ezVar = ((com.google.android.libraries.navigation.internal.om.f) nVar).b;
        synchronized (longSparseArray) {
            nn nnVarListIterator = fdVar.entrySet().listIterator();
            while (nnVarListIterator.hasNext()) {
                Map.Entry entry = (Map.Entry) nnVarListIterator.next();
                if (!d(ezVar, ((Long) entry.getKey()).longValue()).equals(entry.getValue())) {
                    return true;
                }
            }
            return false;
        }
    }
}

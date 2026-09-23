package com.google.android.libraries.navigation.internal.yz;

import java.io.Serializable;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class nm extends ar implements Serializable {
    final NavigableMap a;
    private transient Set b;

    private nm(NavigableMap navigableMap) {
        this.a = navigableMap;
    }

    public static nm f() {
        return new nm(new TreeMap());
    }

    private final void g(lr lrVar) {
        if (lrVar.i()) {
            this.a.remove(lrVar.b);
        } else {
            this.a.put(lrVar.b, lrVar);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ar, com.google.android.libraries.navigation.internal.yz.lu
    public final void a(lr lrVar) {
        com.google.android.libraries.navigation.internal.yx.ar.q(lrVar);
        if (lrVar.i()) {
            return;
        }
        cv cvVar = lrVar.b;
        cv cvVar2 = lrVar.c;
        Map.Entry entryLowerEntry = this.a.lowerEntry(cvVar);
        if (entryLowerEntry != null) {
            lr lrVar2 = (lr) entryLowerEntry.getValue();
            if (lrVar2.c.compareTo(cvVar) >= 0) {
                if (lrVar2.c.compareTo(cvVar2) >= 0) {
                    cvVar2 = lrVar2.c;
                }
                cvVar = lrVar2.b;
            }
        }
        Map.Entry entryFloorEntry = this.a.floorEntry(cvVar2);
        if (entryFloorEntry != null) {
            lr lrVar3 = (lr) entryFloorEntry.getValue();
            if (lrVar3.c.compareTo(cvVar2) >= 0) {
                cvVar2 = lrVar3.c;
            }
        }
        this.a.subMap(cvVar, cvVar2).clear();
        g(new lr(cvVar, cvVar2));
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ar
    public final void c(lr lrVar) {
        com.google.android.libraries.navigation.internal.yx.ar.q(lrVar);
        if (lrVar.i()) {
            return;
        }
        Map.Entry entryLowerEntry = this.a.lowerEntry(lrVar.b);
        if (entryLowerEntry != null) {
            lr lrVar2 = (lr) entryLowerEntry.getValue();
            if (lrVar2.c.compareTo(lrVar.b) >= 0) {
                if (lrVar.g() && lrVar2.c.compareTo(lrVar.c) >= 0) {
                    g(new lr(lrVar.c, lrVar2.c));
                }
                g(new lr(lrVar2.b, lrVar.b));
            }
        }
        Map.Entry entryFloorEntry = this.a.floorEntry(lrVar.c);
        if (entryFloorEntry != null) {
            lr lrVar3 = (lr) entryFloorEntry.getValue();
            if (lrVar.g() && lrVar3.c.compareTo(lrVar.c) >= 0) {
                g(new lr(lrVar.c, lrVar3.c));
            }
        }
        this.a.subMap(lrVar.b, lrVar.c).clear();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.lu
    public final Set e() {
        Set set = this.b;
        if (set != null) {
            return set;
        }
        nl nlVar = new nl(this.a.values());
        this.b = nlVar;
        return nlVar;
    }
}

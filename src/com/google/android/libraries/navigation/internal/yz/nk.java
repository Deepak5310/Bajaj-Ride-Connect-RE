package com.google.android.libraries.navigation.internal.yz;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class nk implements lt {
    public final NavigableMap a = new TreeMap();

    private static lr d(lr lrVar, Object obj, Map.Entry entry) {
        return (entry != null && ((nj) entry.getValue()).a.h(lrVar) && ((nj) entry.getValue()).b.equals(obj)) ? lrVar.d(((nj) entry.getValue()).a) : lrVar;
    }

    private final void e(cv cvVar, cv cvVar2, Object obj) {
        this.a.put(cvVar, new nj(new lr(cvVar, cvVar2), obj));
    }

    @Override // com.google.android.libraries.navigation.internal.yz.lt
    public final Map a() {
        return new ni(this, this.a.values());
    }

    @Override // com.google.android.libraries.navigation.internal.yz.lt
    public final void b(lr lrVar, Object obj) {
        if (lrVar.i()) {
            return;
        }
        if (!lrVar.i()) {
            Map.Entry entryLowerEntry = this.a.lowerEntry(lrVar.b);
            if (entryLowerEntry != null) {
                nj njVar = (nj) entryLowerEntry.getValue();
                if (njVar.a().compareTo(lrVar.b) > 0) {
                    if (njVar.a().compareTo(lrVar.c) > 0) {
                        e(lrVar.c, njVar.a(), ((nj) entryLowerEntry.getValue()).b);
                    }
                    e(njVar.a.b, lrVar.b, ((nj) entryLowerEntry.getValue()).b);
                }
            }
            Map.Entry entryLowerEntry2 = this.a.lowerEntry(lrVar.c);
            if (entryLowerEntry2 != null) {
                nj njVar2 = (nj) entryLowerEntry2.getValue();
                if (njVar2.a().compareTo(lrVar.c) > 0) {
                    e(lrVar.c, njVar2.a(), ((nj) entryLowerEntry2.getValue()).b);
                }
            }
            this.a.subMap(lrVar.b, lrVar.c).clear();
        }
        this.a.put(lrVar.b, new nj(lrVar, obj));
    }

    @Override // com.google.android.libraries.navigation.internal.yz.lt
    public final void c(lr lrVar, Object obj) {
        if (this.a.isEmpty()) {
            b(lrVar, obj);
        } else {
            b(d(d(lrVar, obj, this.a.lowerEntry(lrVar.b)), obj, this.a.floorEntry(lrVar.c)), obj);
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof lt) {
            return a().equals(((lt) obj).a());
        }
        return false;
    }

    public final int hashCode() {
        return a().hashCode();
    }

    public final String toString() {
        return this.a.values().toString();
    }
}

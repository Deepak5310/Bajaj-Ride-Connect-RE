package com.google.android.libraries.navigation.internal.afx;

import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    public static final c a;
    private static final IdentityHashMap c;
    public final IdentityHashMap b;

    static {
        IdentityHashMap identityHashMap = new IdentityHashMap();
        c = identityHashMap;
        a = new c(identityHashMap);
    }

    public c(IdentityHashMap identityHashMap) {
        this.b = identityHashMap;
    }

    public final Object a(b bVar) {
        return this.b.get(bVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.b.size() != cVar.b.size()) {
            return false;
        }
        for (Map.Entry entry : this.b.entrySet()) {
            if (!cVar.b.containsKey(entry.getKey()) || !com.google.android.libraries.navigation.internal.yx.am.a(entry.getValue(), cVar.b.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int iHashCode = 0;
        for (Map.Entry entry : this.b.entrySet()) {
            iHashCode += Arrays.hashCode(new Object[]{entry.getKey(), entry.getValue()});
        }
        return iHashCode;
    }

    public final String toString() {
        return this.b.toString();
    }
}

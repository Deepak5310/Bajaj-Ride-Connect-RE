package com.google.android.libraries.navigation.internal.b;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o {
    public final int a;
    public final byte[] b;
    public final Map c;
    public final List d;
    public final boolean e;

    public o(int i, byte[] bArr, Map map, List list, boolean z) {
        this.a = i;
        this.b = bArr;
        this.c = map;
        this.d = list == null ? null : Collections.unmodifiableList(list);
        this.e = z;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public o(int i, byte[] bArr, boolean z, long j, List list) {
        Map treeMap;
        if (list == null) {
            treeMap = null;
        } else if (list.isEmpty()) {
            treeMap = Collections.emptyMap();
        } else {
            treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                k kVar = (k) it2.next();
                treeMap.put(kVar.a, kVar.b);
            }
        }
        this(i, bArr, treeMap, list, z);
    }
}

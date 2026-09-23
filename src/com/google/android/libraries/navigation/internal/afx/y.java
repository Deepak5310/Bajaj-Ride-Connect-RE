package com.google.android.libraries.navigation.internal.afx;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class y {
    static final com.google.android.libraries.navigation.internal.yx.ah a = com.google.android.libraries.navigation.internal.yx.ah.e(',');
    public static final y b = new y(l.a, false, new y(new k(), true, new y()));
    private final Map c;

    private y() {
        this.c = new LinkedHashMap(0);
    }

    private y(w wVar, boolean z, y yVar) {
        String strA = wVar.a();
        com.google.android.libraries.navigation.internal.yx.ar.b(!strA.contains(","), "Comma is currently not allowed in message encoding");
        int size = yVar.c.size();
        LinkedHashMap linkedHashMap = new LinkedHashMap(yVar.c.containsKey(wVar.a()) ? size : size + 1);
        for (x xVar : yVar.c.values()) {
            String strA2 = xVar.a.a();
            if (!strA2.equals(strA)) {
                linkedHashMap.put(strA2, new x(xVar.a, xVar.b));
            }
        }
        linkedHashMap.put(strA, new x(wVar, z));
        Map mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        this.c = mapUnmodifiableMap;
        com.google.android.libraries.navigation.internal.yx.ah ahVar = a;
        HashSet hashSet = new HashSet(mapUnmodifiableMap.size());
        for (Map.Entry entry : mapUnmodifiableMap.entrySet()) {
            if (((x) entry.getValue()).b) {
                hashSet.add((String) entry.getKey());
            }
        }
        ahVar.f(Collections.unmodifiableSet(hashSet));
        Charset.forName(CharEncoding.US_ASCII);
    }
}

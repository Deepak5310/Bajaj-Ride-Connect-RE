package com.google.android.libraries.navigation.internal.c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class l extends a {
    public static List a(Map map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() != null) {
                Iterator it2 = ((List) entry.getValue()).iterator();
                while (it2.hasNext()) {
                    arrayList.add(new com.google.android.libraries.navigation.internal.b.k((String) entry.getKey(), (String) it2.next()));
                }
            }
        }
        return arrayList;
    }
}

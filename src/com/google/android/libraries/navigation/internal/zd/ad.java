package com.google.android.libraries.navigation.internal.zd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ad extends ae {
    private final Map a;

    public ad(n nVar, n nVar2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        e(linkedHashMap, nVar);
        e(linkedHashMap, nVar2);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (((com.google.android.libraries.navigation.internal.zb.ac) entry.getKey()).b) {
                entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
            }
        }
        this.a = Collections.unmodifiableMap(linkedHashMap);
    }

    private static void e(Map map, n nVar) {
        for (int i = 0; i < nVar.b(); i++) {
            com.google.android.libraries.navigation.internal.zb.ac acVarC = nVar.c(i);
            Object obj = map.get(acVarC);
            if (acVarC.b) {
                List arrayList = (List) obj;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map.put(acVarC, arrayList);
                }
                arrayList.add(acVarC.c(nVar.e(i)));
            } else {
                map.put(acVarC, acVarC.c(nVar.e(i)));
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.zd.ae
    public final int a() {
        return this.a.size();
    }

    @Override // com.google.android.libraries.navigation.internal.zd.ae
    public final Object b(com.google.android.libraries.navigation.internal.zb.ac acVar) {
        com.google.android.libraries.navigation.internal.zj.b.a(!acVar.b, "key must be single valued");
        Object obj = this.a.get(acVar);
        if (obj != null) {
            return obj;
        }
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.zd.ae
    public final Set c() {
        return this.a.keySet();
    }

    @Override // com.google.android.libraries.navigation.internal.zd.ae
    public final void d(u uVar, Object obj) {
        for (Map.Entry entry : this.a.entrySet()) {
            com.google.android.libraries.navigation.internal.zb.ac acVar = (com.google.android.libraries.navigation.internal.zb.ac) entry.getKey();
            Object value = entry.getValue();
            if (acVar.b) {
                uVar.b(acVar, ((List) value).iterator(), obj);
            } else {
                uVar.a(acVar, value, obj);
            }
        }
    }
}

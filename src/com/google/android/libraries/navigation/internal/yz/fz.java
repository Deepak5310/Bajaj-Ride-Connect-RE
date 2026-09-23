package com.google.android.libraries.navigation.internal.yz;

import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fz extends fo {
    public final gc a() {
        Map map = this.a;
        if (map == null) {
            return cx.a;
        }
        Set<Map.Entry> setEntrySet = map.entrySet();
        if (setEntrySet.isEmpty()) {
            return cx.a;
        }
        ez ezVar = new ez(setEntrySet.size());
        int size = 0;
        for (Map.Entry entry : setEntrySet) {
            Object key = entry.getKey();
            fy fyVarO = fy.o(((fw) entry.getValue()).i());
            if (!fyVarO.isEmpty()) {
                ezVar.f(key, fyVarO);
                size += fyVarO.size();
            }
        }
        return new gc(ezVar.d(), size);
    }

    public final void b(Object obj, Object obj2) {
        super.f(obj, obj2);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fo
    public final ej c(int i) {
        return fy.l(4);
    }
}

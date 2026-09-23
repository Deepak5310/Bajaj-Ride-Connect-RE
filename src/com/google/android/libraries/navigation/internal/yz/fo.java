package com.google.android.libraries.navigation.internal.yz;

import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class fo {
    Map a;
    final int b = 4;

    public ej c(int i) {
        return ev.j(4);
    }

    public final fs d() {
        Map map = this.a;
        if (map == null) {
            return cw.a;
        }
        Set<Map.Entry> setEntrySet = map.entrySet();
        if (setEntrySet.isEmpty()) {
            return cw.a;
        }
        ez ezVar = new ez(setEntrySet.size());
        int i = 0;
        for (Map.Entry entry : setEntrySet) {
            Object key = entry.getKey();
            ev evVarG = ((eq) entry.getValue()).g();
            ezVar.f(key, evVarG);
            i += ((lv) evVarG).c;
        }
        return new ex(ezVar.d(), i);
    }

    final Map e() {
        Map map = this.a;
        if (map != null) {
            return map;
        }
        cc ccVar = new cc();
        this.a = ccVar;
        return ccVar;
    }

    public final void f(Object obj, Object obj2) {
        bs.a(obj, obj2);
        ej ejVarC = (ej) e().get(obj);
        if (ejVarC == null) {
            ejVarC = c(4);
            e().put(obj, ejVarC);
        }
        ejVarC.c(obj2);
    }
}

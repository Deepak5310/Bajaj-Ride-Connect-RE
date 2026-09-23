package com.google.android.libraries.navigation.internal.qk;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ah implements r {
    private final Map a;
    private final int b;
    private final Set c = new HashSet();

    public ah(Map map, int i) {
        this.a = map;
        this.b = i;
    }

    @Override // com.google.android.libraries.navigation.internal.qk.r
    public final boolean a(com.google.android.libraries.navigation.internal.op.g gVar, q qVar, p pVar) {
        return b(gVar, qVar, pVar, null);
    }

    @Override // com.google.android.libraries.navigation.internal.qk.r
    public final boolean b(com.google.android.libraries.navigation.internal.op.g gVar, q qVar, p pVar, s sVar) {
        r rVar = (r) this.a.get(gVar);
        if (rVar == null) {
            return false;
        }
        if (this.c.contains(gVar)) {
            if (rVar.b(gVar, qVar, pVar, sVar)) {
                return true;
            }
            this.c.remove(gVar);
            return false;
        }
        Set set = this.c;
        if (set.size() >= this.b || !rVar.b(gVar, qVar, pVar, sVar)) {
            return false;
        }
        this.c.add(gVar);
        return true;
    }
}

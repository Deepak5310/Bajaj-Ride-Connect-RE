package com.google.android.libraries.navigation.internal.abh;

import com.google.android.libraries.navigation.internal.yz.mb;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bo implements com.google.android.libraries.navigation.internal.ly.at {
    final ed b;
    public final dw d;
    public final ht e;
    private final gu f;
    private final String g;
    final Map a = new HashMap();
    public final Map c = new HashMap();

    public bo(dw dwVar, ed edVar, ht htVar, gu guVar, String str) {
        this.d = dwVar;
        this.b = edVar;
        this.e = htVar;
        this.g = str;
        this.f = guVar;
        a();
    }

    public final void a() {
        gu guVar = this.f;
        HashMap map = guVar.f;
        String str = this.g;
        if (!(map.containsKey(str) ? com.google.android.libraries.navigation.internal.yz.fy.o((Collection) guVar.f.get(str)) : mb.a).isEmpty() || this.f.a(this.g).isEmpty()) {
            return;
        }
        this.f.a(this.g).contains(com.google.android.libraries.navigation.internal.ace.fp.UNKNOWN_MAP_FACTS_TYPE);
    }
}

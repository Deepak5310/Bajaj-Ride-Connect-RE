package com.google.android.libraries.navigation.internal.yz;

import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class b extends dm {
    final /* synthetic */ g a;
    private final Map.Entry b;

    public b(g gVar, Map.Entry entry) {
        this.a = gVar;
        this.b = entry;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dm
    protected final Map.Entry a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dm, com.google.android.libraries.navigation.internal.yz.Cdo
    protected final /* synthetic */ Object aF() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dm, java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.a.b(obj);
        com.google.android.libraries.navigation.internal.yx.ar.l(this.a.entrySet().contains(this), "entry no longer in map");
        if (com.google.android.libraries.navigation.internal.yx.am.a(obj, getValue())) {
            return obj;
        }
        com.google.android.libraries.navigation.internal.yx.ar.f(!this.a.containsValue(obj), "value already present: %s", obj);
        Object value = this.b.setValue(obj);
        com.google.android.libraries.navigation.internal.yx.ar.l(com.google.android.libraries.navigation.internal.yx.am.a(obj, this.a.get(getKey())), "entry no longer in map");
        this.a.j(getKey(), true, value, obj);
        return value;
    }
}

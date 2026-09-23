package com.google.android.libraries.navigation.internal.xj;

import com.google.android.libraries.navigation.internal.nc.ae;
import com.google.android.libraries.navigation.internal.nc.j;
import java.util.EnumMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public final EnumMap a = new EnumMap(a.class);

    public b() {
        for (a aVar : a.values()) {
            this.a.put(aVar, new EnumMap(c.class));
        }
        b(a.PRIMARY, c.DAY, com.google.android.libraries.navigation.internal.v.a.g);
        b(a.PRIMARY, c.NIGHT, com.google.android.libraries.navigation.internal.v.a.g);
        b(a.SECONDARY, c.DAY, com.google.android.libraries.navigation.internal.v.a.h);
        b(a.SECONDARY, c.NIGHT, com.google.android.libraries.navigation.internal.v.a.h);
    }

    public final void a(a aVar, c cVar, int i) {
        ((EnumMap) this.a.get(aVar)).put(cVar, new ae(i));
    }

    public final void b(a aVar, c cVar, int i) {
        ((EnumMap) this.a.get(aVar)).put(cVar, j.f(i));
    }
}

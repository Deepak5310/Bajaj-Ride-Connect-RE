package com.google.android.libraries.navigation.internal.wy;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    private final Map a;

    public b() {
        HashMap map = new HashMap();
        this.a = map;
        map.put(0, null);
    }

    public final c a() {
        return new c(this.a);
    }

    public final void b(int[] iArr) {
        for (int i : iArr) {
            Map map = this.a;
            Integer numValueOf = Integer.valueOf(i);
            if (map.containsKey(numValueOf)) {
                throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.j(i, "Error: ", " was already added as a primaryvalue to the table."));
            }
            this.a.put(numValueOf, 0);
        }
    }
}

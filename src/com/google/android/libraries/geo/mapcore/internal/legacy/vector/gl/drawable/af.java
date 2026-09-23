package com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable;

import com.google.android.libraries.geo.mapcore.renderer.bt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class af {
    public static final int a = bt.a().b;
    public final List b = new ArrayList();
    public final Map c = new HashMap();

    public final short a(com.google.android.libraries.navigation.internal.qh.a aVar) {
        if (this.c.containsKey(aVar)) {
            return ((Short) this.c.get(aVar)).shortValue();
        }
        return (short) 0;
    }

    public final boolean b(com.google.android.libraries.navigation.internal.qh.a aVar) {
        return this.c.containsKey(aVar);
    }

    final synchronized void c(com.google.android.libraries.navigation.internal.qh.a aVar) {
        if (this.c.containsKey(aVar)) {
        } else {
            if (this.c.size() >= a) {
                return;
            }
            this.b.add(aVar);
            this.c.put(aVar, Short.valueOf((short) this.c.size()));
        }
    }
}

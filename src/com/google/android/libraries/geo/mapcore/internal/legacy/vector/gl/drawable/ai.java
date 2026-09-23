package com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class ai {
    public final Map a = new HashMap();
    private final int b;

    public ai(int i) {
        this.b = i;
    }

    public final byte a(ag agVar) {
        if (this.a.containsKey(agVar)) {
            return ((Byte) this.a.get(agVar)).byteValue();
        }
        return (byte) 0;
    }

    public final Set b() {
        return this.a.keySet();
    }

    public final int c(ag agVar) {
        if (this.a.containsKey(agVar)) {
            return 2;
        }
        Map map = this.a;
        if (map.size() >= this.b) {
            return 3;
        }
        this.a.put(agVar, Byte.valueOf((byte) this.a.size()));
        return 1;
    }
}

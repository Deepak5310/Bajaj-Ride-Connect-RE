package com.google.android.libraries.navigation.internal.afr;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i extends b {
    public static final k b = g.b(Collections.emptyMap());

    public i(Map map) {
        super(map);
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Map a() {
        LinkedHashMap linkedHashMapB = c.b(this.a.size());
        for (Map.Entry entry : this.a.entrySet()) {
            linkedHashMapB.put(entry.getKey(), ((k) entry.getValue()).a());
        }
        return Collections.unmodifiableMap(linkedHashMapB);
    }
}

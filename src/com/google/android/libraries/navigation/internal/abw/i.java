package com.google.android.libraries.navigation.internal.abw;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i extends LinkedHashMap {
    private final int a;
    private final com.google.android.libraries.navigation.internal.abs.c b;

    public i(int i, com.google.android.libraries.navigation.internal.abs.c cVar) {
        super(16, 0.75f, true);
        this.a = 16;
        this.b = cVar;
    }

    @Override // java.util.LinkedHashMap
    protected final boolean removeEldestEntry(Map.Entry entry) {
        if (size() <= this.a) {
            return false;
        }
        com.google.android.libraries.navigation.internal.abs.c cVar = this.b;
        entry.getKey();
        cVar.b(entry.getValue());
        return true;
    }
}

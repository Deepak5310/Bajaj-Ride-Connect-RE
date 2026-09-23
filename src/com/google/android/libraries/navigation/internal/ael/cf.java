package com.google.android.libraries.navigation.internal.ael;

import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cf implements Map.Entry {
    public Map.Entry a;

    public cf(Map.Entry entry) {
        this.a = entry;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.a.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (((ch) this.a.getValue()) == null) {
            return null;
        }
        throw null;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (!(obj instanceof cy)) {
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
        ch chVar = (ch) this.a.getValue();
        cy cyVar = chVar.a;
        chVar.b = null;
        chVar.a = (cy) obj;
        return cyVar;
    }
}

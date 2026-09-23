package com.google.android.libraries.navigation.internal.yz;

import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class dm extends Cdo implements Map.Entry {
    protected dm() {
    }

    protected abstract Map.Entry a();

    @Override // com.google.android.libraries.navigation.internal.yz.Cdo
    protected /* bridge */ /* synthetic */ Object aF() {
        throw null;
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        return a().equals(obj);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return a().getKey();
    }

    @Override // java.util.Map.Entry
    public Object getValue() {
        return a().getValue();
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return a().hashCode();
    }

    public Object setValue(Object obj) {
        return a().setValue(obj);
    }
}

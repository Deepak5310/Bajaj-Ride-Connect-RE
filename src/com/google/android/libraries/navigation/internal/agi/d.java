package com.google.android.libraries.navigation.internal.agi;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements br {
    protected Object a;

    public d() {
    }

    public d(Object obj) {
        this.a = obj;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.br
    public final int a() {
        return 0;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        if (obj instanceof br) {
            br brVar = (br) obj;
            return Objects.equals(this.a, brVar.getKey()) && brVar.a() == 0;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Object value = entry.getValue();
        return value != null && (value instanceof Integer) && Objects.equals(this.a, key) && ((Integer) value).intValue() == 0;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.a;
    }

    @Override // java.util.Map.Entry
    public final /* bridge */ /* synthetic */ Object getValue() {
        return 0;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object obj = this.a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @Override // java.util.Map.Entry
    public final /* bridge */ /* synthetic */ Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        return String.valueOf(this.a) + "->0";
    }
}

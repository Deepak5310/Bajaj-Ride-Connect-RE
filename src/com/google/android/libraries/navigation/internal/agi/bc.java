package com.google.android.libraries.navigation.internal.agi;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bc implements Map.Entry {
    int a;
    final /* synthetic */ bi b;

    public bc(bi biVar) {
        this.b = biVar;
    }

    public bc(bi biVar, int i) {
        this.b = biVar;
        this.a = i;
    }

    public final float a() {
        return this.b.b[this.a];
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return Objects.equals(this.b.a[this.a], entry.getKey()) && Float.floatToIntBits(this.b.b[this.a]) == Float.floatToIntBits(((Float) entry.getValue()).floatValue());
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.b.a[this.a];
    }

    @Override // java.util.Map.Entry
    @Deprecated
    public final /* bridge */ /* synthetic */ Object getValue() {
        return Float.valueOf(this.b.b[this.a]);
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object obj = this.b.a[this.a];
        return (obj == null ? 0 : obj.hashCode()) ^ Float.floatToIntBits(this.b.b[this.a]);
    }

    @Override // java.util.Map.Entry
    @Deprecated
    public final /* bridge */ /* synthetic */ Object setValue(Object obj) {
        float fFloatValue = ((Float) obj).floatValue();
        float[] fArr = this.b.b;
        int i = this.a;
        float f = fArr[i];
        fArr[i] = fFloatValue;
        return Float.valueOf(f);
    }

    public final String toString() {
        bi biVar = this.b;
        Object[] objArr = biVar.a;
        int i = this.a;
        return String.valueOf(objArr[i]) + "=>" + biVar.b[i];
    }
}

package com.google.android.libraries.navigation.internal.zz;

import com.google.android.libraries.navigation.internal.yx.am;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class t implements GenericArrayType, Serializable {
    private static final long serialVersionUID = 0;
    private final Type a;

    public t(Type type) {
        this.a = w.e.d(type);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof GenericArrayType) {
            return am.a(this.a, ((GenericArrayType) obj).getGenericComponentType());
        }
        return false;
    }

    @Override // java.lang.reflect.GenericArrayType
    public final Type getGenericComponentType() {
        return this.a;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return String.valueOf(ad.b(this.a)).concat("[]");
    }
}

package com.google.android.libraries.navigation.internal.zz;

import java.lang.reflect.ParameterizedType;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
enum s {
    OWNED_BY_ENCLOSING_CLASS,
    LOCAL_CLASS_HAS_NO_OWNER;

    static final s c;

    static {
        ParameterizedType parameterizedType = (ParameterizedType) Objects.requireNonNull((ParameterizedType) new q() { // from class: com.google.android.libraries.navigation.internal.zz.r
        }.getClass().getGenericSuperclass());
        for (s sVar : values()) {
            if (sVar.a(q.class) == parameterizedType.getOwnerType()) {
                c = sVar;
                return;
            }
        }
        throw new AssertionError();
    }

    final Class a(Class cls) {
        int iOrdinal = ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                throw null;
            }
            if (cls.isLocalClass()) {
                return null;
            }
        }
        return cls.getEnclosingClass();
    }
}

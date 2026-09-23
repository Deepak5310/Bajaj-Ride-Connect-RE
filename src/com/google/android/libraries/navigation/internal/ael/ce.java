package com.google.android.libraries.navigation.internal.ael;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum ce {
    VOID(Void.class),
    INT(Integer.class),
    LONG(Long.class),
    FLOAT(Float.class),
    DOUBLE(Double.class),
    BOOLEAN(Boolean.class),
    STRING(String.class),
    BYTE_STRING(x.class),
    ENUM(Integer.class),
    MESSAGE(Object.class);

    public final Class k;

    static {
        x xVar = x.b;
    }

    ce(Class cls) {
        this.k = cls;
    }
}

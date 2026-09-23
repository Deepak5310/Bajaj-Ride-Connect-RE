package com.google.android.libraries.navigation.internal.zg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
enum k {
    BOOLEAN,
    STRING,
    LONG,
    DOUBLE;

    public static k a(Object obj) {
        if (obj instanceof String) {
            return STRING;
        }
        if (obj instanceof Boolean) {
            return BOOLEAN;
        }
        if (obj instanceof Long) {
            return LONG;
        }
        if (obj instanceof Double) {
            return DOUBLE;
        }
        throw new AssertionError("invalid tag type: ".concat(String.valueOf(String.valueOf(obj.getClass()))));
    }
}

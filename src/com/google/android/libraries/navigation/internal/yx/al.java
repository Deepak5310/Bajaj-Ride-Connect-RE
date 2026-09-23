package com.google.android.libraries.navigation.internal.yx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class al {
    public static ak a(Class cls) {
        return new ak(cls.getSimpleName());
    }

    public static ak b(Object obj) {
        return new ak(obj.getClass().getSimpleName());
    }

    public static Object c(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        if (obj2 != null) {
            return obj2;
        }
        throw new NullPointerException("Both parameters are null");
    }
}

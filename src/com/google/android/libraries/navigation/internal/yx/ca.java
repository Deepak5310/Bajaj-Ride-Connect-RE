package com.google.android.libraries.navigation.internal.yx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ca {
    public static void a(boolean z) {
        if (!z) {
            throw new cb();
        }
    }

    public static void b(boolean z, String str, Object obj) {
        if (!z) {
            throw new cb(bq.a(str, obj));
        }
    }

    public static void c(boolean z, Object... objArr) {
        if (!z) {
            throw new cb(bq.a("Impossible -- JNI will throw a detailed java.lang.Error", objArr));
        }
    }
}

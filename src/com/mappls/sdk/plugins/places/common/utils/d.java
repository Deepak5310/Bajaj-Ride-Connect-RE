package com.mappls.sdk.plugins.places.common.utils;

/* JADX INFO: loaded from: classes4.dex */
public final class d<T> {
    public int a;
    public T b;
    public String c;

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/Object;TT;Ljava/lang/String;)V */
    /* JADX WARN: Multi-variable type inference failed */
    private d(int i, Object obj, String str) {
        this.a = i;
        this.b = obj;
        this.c = str;
    }

    public static d a() {
        return new d(2, null, null);
    }

    public static <T> d<T> a(T t) {
        return new d<>(1, t, null);
    }

    public static d a(String str) {
        return new d(3, null, str);
    }
}

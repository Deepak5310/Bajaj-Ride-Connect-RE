package com.google.android.libraries.navigation.internal.xn;

import com.google.android.libraries.navigation.internal.yx.aq;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public final String a;

    public a(String str) {
        this.a = str;
    }

    public static a a(a aVar, a aVar2) {
        return new a(String.valueOf(aVar.a).concat(String.valueOf(aVar2.a)));
    }

    public static a b(Class cls) {
        return c(null, cls);
    }

    public static a c(String str, Class cls) {
        if (aq.c(str)) {
            return new a(cls.getSimpleName());
        }
        return new a(String.valueOf(str).concat(String.valueOf(cls.getSimpleName())));
    }

    public static a d(String str) {
        return new a(str);
    }

    public static a e(Enum r1) {
        return f(null, r1);
    }

    public static a f(String str, Enum r2) {
        if (aq.c(str)) {
            return new a(r2.name());
        }
        return new a(String.valueOf(str).concat(String.valueOf(r2.name())));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.a.equals(((a) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return this.a;
    }
}

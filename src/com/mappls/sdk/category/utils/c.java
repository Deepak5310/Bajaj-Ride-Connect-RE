package com.mappls.sdk.category.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class c<T> {
    private final d a;
    private final T b;
    private final String c;

    public static final class a {
        public static c a() {
            return new c(d.b, null, null);
        }

        public static c a(Object obj) {
            return new c(d.a, obj, null);
        }

        public static c a(String msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            return new c(d.c, null, msg);
        }
    }

    public c(d status, T t, String str) {
        Intrinsics.checkNotNullParameter(status, "status");
        this.a = status;
        this.b = t;
        this.c = str;
    }

    public final T a() {
        return this.b;
    }

    public final String b() {
        return this.c;
    }

    public final d c() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.a == cVar.a && Intrinsics.areEqual(this.b, cVar.b) && Intrinsics.areEqual(this.c, cVar.c);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        T t = this.b;
        int iHashCode2 = (iHashCode + (t == null ? 0 : t.hashCode())) * 31;
        String str = this.c;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "Resource(status=" + this.a + ", data=" + this.b + ", message=" + this.c + ')';
    }
}

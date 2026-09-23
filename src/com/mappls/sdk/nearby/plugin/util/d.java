package com.mappls.sdk.nearby.plugin.util;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class d<T> {
    private final e a;
    private final T b;
    private final String c;

    public static final class a {
        public static d a() {
            return new d(e.b, null, null);
        }

        public static d a(Object obj) {
            return new d(e.a, obj, null);
        }

        public static d a(String msg, ArrayList arrayList) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            return new d(e.c, arrayList, msg);
        }
    }

    public d(e status, T t, String str) {
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

    public final e c() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.a == dVar.a && Intrinsics.areEqual(this.b, dVar.b) && Intrinsics.areEqual(this.c, dVar.c);
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

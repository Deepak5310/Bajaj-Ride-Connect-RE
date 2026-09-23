package com.mappls.sdk.direction.ui.common;

/* JADX INFO: loaded from: classes6.dex */
public final class b<T> {
    public final int a;
    public final String b;
    public final T c;

    /* JADX WARN: Multi-variable type inference failed */
    public b(int i, Object obj, String str) {
        this.a = i;
        this.c = obj;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.a != bVar.a) {
            return false;
        }
        String str = this.b;
        if (str == null ? bVar.b != null : !str.equals(bVar.b)) {
            return false;
        }
        T t = this.c;
        T t2 = bVar.c;
        if (t != null) {
            return t.equals(t2);
        }
        return t2 == null;
    }

    public final int hashCode() {
        int iA = d.a(this.a) * 31;
        String str = this.b;
        int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
        T t = this.c;
        return iHashCode + (t != null ? t.hashCode() : 0);
    }

    public final String toString() {
        return "Resource{status=" + c.a(this.a) + ", message='" + this.b + "', data=" + this.c + '}';
    }
}

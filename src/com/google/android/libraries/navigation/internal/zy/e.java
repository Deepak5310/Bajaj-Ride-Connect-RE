package com.google.android.libraries.navigation.internal.zy;

import com.google.android.libraries.navigation.internal.yx.ar;
import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements Serializable {
    public static final e a = new e(new int[0]);
    public final int[] b;
    public final transient int c;
    public final int d;

    public e(int[] iArr) {
        this(iArr, 0, iArr.length);
    }

    public e(int[] iArr, int i, int i2) {
        this.b = iArr;
        this.c = 0;
        this.d = i2;
    }

    public static e c(int i) {
        return new e(new int[]{i});
    }

    public final int a(int i) {
        ar.p(i, b());
        return this.b[i];
    }

    public final int b() {
        return this.d;
    }

    public final boolean d() {
        return this.d == 0;
    }

    public final int[] e() {
        return Arrays.copyOfRange(this.b, 0, this.d);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (b() != eVar.b()) {
            return false;
        }
        for (int i = 0; i < b(); i++) {
            if (a(i) != eVar.a(i)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.d; i2++) {
            i = (i * 31) + this.b[i2];
        }
        return i;
    }

    Object readResolve() {
        return d() ? a : this;
    }

    public final String toString() {
        if (d()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(b() * 5);
        sb.append('[');
        sb.append(this.b[0]);
        for (int i = 1; i < this.d; i++) {
            sb.append(", ");
            sb.append(this.b[i]);
        }
        sb.append(']');
        return sb.toString();
    }

    Object writeReplace() {
        return this.d < this.b.length ? new e(e()) : this;
    }
}

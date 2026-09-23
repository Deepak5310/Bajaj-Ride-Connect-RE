package com.google.android.libraries.navigation.internal.nc;

import android.graphics.PorterDuff;
import android.util.LruCache;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class j {
    public static final LruCache a = new b();
    public static final LruCache b = new c();
    public static final LruCache c = new d();
    public static final LruCache d = new e();
    public static final LruCache e;
    public static final LruCache f;
    public final int g;
    private final Object[] h;

    static {
        new f();
        e = new g();
        f = new h();
    }

    protected j(int i) {
        com.google.android.libraries.navigation.internal.yx.ar.b(i != 0, "Attempted to create AndroidResource with id == 0, which is an invalid ID. If it happened to you, it means that you should fix the code which caused that. Try falling back to null, transparent color, empty drawable, empty string, or anything which is appropriate in your context.");
        this.g = i;
        this.h = new Object[0];
    }

    public static t c(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        return new q(charSequence);
    }

    public static x f(int i) {
        return (x) b.get(Integer.valueOf(i));
    }

    public static ah g(int i) {
        return (ah) e.get(Integer.valueOf(i));
    }

    public static ah h(int i, x xVar) {
        return new v(g(i), xVar, PorterDuff.Mode.SRC_ATOP);
    }

    public static ah i(int i, x xVar) {
        return j(g(i), xVar);
    }

    public static ah j(ah ahVar, x xVar) {
        return new v(ahVar, xVar, PorterDuff.Mode.SRC_IN);
    }

    public static ap k(int i) {
        return (ap) d.get(Integer.valueOf(i));
    }

    public static t m(int i) {
        return (t) f.get(Integer.valueOf(i));
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return jVar.g == this.g && Arrays.equals(jVar.h, this.h);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.g), Integer.valueOf(Arrays.hashCode(this.h))});
    }

    public final String toString() {
        return String.format(Locale.US, "%s(id=%d)", getClass().getSimpleName(), Integer.valueOf(this.g));
    }
}

package com.google.android.libraries.navigation.internal.afk;

import kotlin.text.Typography;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class w {
    public static final w a;
    public static final w b;
    public static final w c;
    public static final w d;
    public static final w e;
    public static final w f;
    public static final w g;
    public static final w h;
    public static final w i;
    public static final w j;
    public static final w k;
    public static final w l;
    public static final w m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final w f294n;
    public final String o;

    static {
        w wVar = r.a;
        a = r.aC;
        b = r.bL;
        c = r.bV;
        d = r.bW;
        e = r.bX;
        f = r.ea;
        g = r.fo;
        w wVar2 = s.a;
        w wVar3 = t.a;
        h = t.cZ;
        i = t.ew;
        j = t.fI;
        k = t.hG;
        w wVar4 = u.a;
        l = u.cp;
        w wVar5 = v.a;
        m = v.eP;
        f294n = v.hX;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof w) {
            return this.o.equals(((w) obj).o);
        }
        return false;
    }

    public final int hashCode() {
        return this.o.hashCode();
    }

    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " name=" + this.o + Typography.greater;
    }
}

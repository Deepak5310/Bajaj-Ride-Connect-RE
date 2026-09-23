package com.google.android.libraries.navigation.internal.yz;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class lr extends ls implements Serializable, com.google.android.libraries.navigation.internal.yx.as {
    public static final lr a = new lr(ct.a, cr.a);
    private static final long serialVersionUID = 0;
    final cv b;
    final cv c;

    public lr(cv cvVar, cv cvVar2) {
        com.google.android.libraries.navigation.internal.yx.ar.q(cvVar);
        this.b = cvVar;
        com.google.android.libraries.navigation.internal.yx.ar.q(cvVar2);
        this.c = cvVar2;
        if (cvVar.compareTo(cvVar2) > 0 || cvVar == cr.a || cvVar2 == ct.a) {
            throw new IllegalArgumentException("Invalid range: ".concat(String.valueOf(j(cvVar, cvVar2))));
        }
    }

    static int b(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    public static lr c(Comparable comparable, Comparable comparable2) {
        return new lr(new cu(comparable), new cu(comparable2));
    }

    private static String j(cv cvVar, cv cvVar2) {
        StringBuilder sb = new StringBuilder(16);
        cvVar.c(sb);
        sb.append("..");
        cvVar2.d(sb);
        return sb.toString();
    }

    @Override // com.google.android.libraries.navigation.internal.yx.as
    @Deprecated
    public final /* synthetic */ boolean a(Object obj) {
        Comparable comparable = (Comparable) obj;
        com.google.android.libraries.navigation.internal.yx.ar.q(comparable);
        return this.b.e(comparable) && !this.c.e(comparable);
    }

    public final lr d(lr lrVar) {
        int iA = this.b.compareTo(lrVar.b);
        int iA2 = this.c.compareTo(lrVar.c);
        if (iA <= 0 && iA2 >= 0) {
            return this;
        }
        if (iA >= 0 && iA2 <= 0) {
            return lrVar;
        }
        cv cvVar = iA <= 0 ? this.b : lrVar.b;
        if (iA2 >= 0) {
            lrVar = this;
        }
        return new lr(cvVar, lrVar.c);
    }

    public final Comparable e() {
        return this.b.b();
    }

    @Override // com.google.android.libraries.navigation.internal.yx.as
    public final boolean equals(Object obj) {
        if (obj instanceof lr) {
            lr lrVar = (lr) obj;
            if (this.b.equals(lrVar.b) && this.c.equals(lrVar.c)) {
                return true;
            }
        }
        return false;
    }

    public final Comparable f() {
        return this.c.b();
    }

    public final boolean g() {
        return this.c != cr.a;
    }

    public final boolean h(lr lrVar) {
        return this.b.compareTo(lrVar.c) <= 0 && lrVar.b.compareTo(this.c) <= 0;
    }

    public final int hashCode() {
        return (this.b.hashCode() * 31) + this.c.hashCode();
    }

    public final boolean i() {
        return this.b.equals(this.c);
    }

    Object readResolve() {
        lr lrVar = a;
        return equals(lrVar) ? lrVar : this;
    }

    public final String toString() {
        return j(this.b, this.c);
    }
}

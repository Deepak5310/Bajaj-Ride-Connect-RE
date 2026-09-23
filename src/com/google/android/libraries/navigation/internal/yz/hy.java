package com.google.android.libraries.navigation.internal.yz;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class hy {
    boolean a;
    int b = -1;
    int c = -1;
    in d;
    in e;
    com.google.android.libraries.navigation.internal.yx.y f;

    final int a() {
        int i = this.c;
        if (i == -1) {
            return 4;
        }
        return i;
    }

    final int b() {
        int i = this.b;
        if (i == -1) {
            return 16;
        }
        return i;
    }

    public final hy c() {
        h(in.WEAK);
        return this;
    }

    final in d() {
        return (in) com.google.android.libraries.navigation.internal.yx.al.c(this.d, in.STRONG);
    }

    final in e() {
        return (in) com.google.android.libraries.navigation.internal.yx.al.c(this.e, in.STRONG);
    }

    public final ConcurrentMap f() {
        if (!this.a) {
            return new ConcurrentHashMap(b(), 0.75f, a());
        }
        if (d() == in.STRONG && e() == in.STRONG) {
            return new jk(this, io.a);
        }
        if (d() == in.STRONG && e() == in.WEAK) {
            return new jk(this, is.a);
        }
        if (d() == in.WEAK && e() == in.STRONG) {
            return new jk(this, iy.a);
        }
        if (d() == in.WEAK && e() == in.WEAK) {
            return new jk(this, jc.a);
        }
        throw new AssertionError();
    }

    public final void g(in inVar) {
        in inVar2 = this.d;
        com.google.android.libraries.navigation.internal.yx.ar.o(inVar2 == null, "Key strength was already set to %s", inVar2);
        com.google.android.libraries.navigation.internal.yx.ar.q(inVar);
        this.d = inVar;
        if (inVar != in.STRONG) {
            this.a = true;
        }
    }

    final void h(in inVar) {
        in inVar2 = this.e;
        com.google.android.libraries.navigation.internal.yx.ar.o(inVar2 == null, "Value strength was already set to %s", inVar2);
        com.google.android.libraries.navigation.internal.yx.ar.q(inVar);
        this.e = inVar;
        if (inVar != in.STRONG) {
            this.a = true;
        }
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        int i = this.b;
        if (i != -1) {
            akVarB.c("initialCapacity", i);
        }
        int i2 = this.c;
        if (i2 != -1) {
            akVarB.c("concurrencyLevel", i2);
        }
        in inVar = this.d;
        if (inVar != null) {
            akVarB.g("keyStrength", com.google.android.libraries.navigation.internal.yx.c.a(inVar.toString()));
        }
        in inVar2 = this.e;
        if (inVar2 != null) {
            akVarB.g("valueStrength", com.google.android.libraries.navigation.internal.yx.c.a(inVar2.toString()));
        }
        if (this.f != null) {
            akVarB.f("keyEquivalence");
        }
        return akVarB.toString();
    }
}

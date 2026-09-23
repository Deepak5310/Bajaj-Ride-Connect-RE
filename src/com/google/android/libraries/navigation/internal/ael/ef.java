package com.google.android.libraries.navigation.internal.ael;

import java.io.IOException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class ef {
    private static volatile int a = 100;

    public abstract int a(Object obj);

    public abstract int b(Object obj);

    public abstract Object c(Object obj);

    public abstract Object d(Object obj);

    public abstract Object e(Object obj, Object obj2);

    public abstract Object f();

    public abstract Object g(Object obj);

    public abstract void h(Object obj, int i, int i2);

    public abstract void i(Object obj, int i, long j);

    public abstract void j(Object obj, int i, Object obj2);

    public abstract void k(Object obj, int i, x xVar);

    public abstract void l(Object obj, int i, long j);

    public abstract void m(Object obj);

    public abstract void n(Object obj, Object obj2);

    public abstract void o(Object obj, Object obj2);

    public abstract void p(Object obj, ev evVar) throws IOException;

    public abstract void q(Object obj, ev evVar) throws IOException;

    final boolean r(Object obj, dl dlVar, int i) throws IOException {
        ad adVar = (ad) dlVar;
        int i2 = adVar.b;
        int iA = eu.a(i2);
        int iB = eu.b(i2);
        if (iB == 0) {
            l(obj, iA, dlVar.k());
            return true;
        }
        if (iB == 1) {
            i(obj, iA, dlVar.j());
            return true;
        }
        if (iB == 2) {
            k(obj, iA, dlVar.o());
            return true;
        }
        if (iB != 3) {
            if (iB == 4) {
                if (i != 0) {
                    return false;
                }
                throw new cc("Protocol message end-group tag did not match expected tag.");
            }
            if (iB != 5) {
                throw new cb();
            }
            h(obj, iA, dlVar.e());
            return true;
        }
        Object objF = f();
        int iC = eu.c(iA, 4);
        int i3 = i + 1;
        if (i3 >= a) {
            throw new cc("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        while (dlVar.c() != Integer.MAX_VALUE && r(objF, dlVar, i3)) {
        }
        if (iC != adVar.b) {
            throw new cc("Protocol message end-group tag did not match expected tag.");
        }
        j(obj, iA, g(objF));
        return true;
    }

    public abstract void s();
}

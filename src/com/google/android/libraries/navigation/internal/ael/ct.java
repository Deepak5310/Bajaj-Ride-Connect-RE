package com.google.android.libraries.navigation.internal.ael;

import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ct {
    public static final Map a(Object obj) {
        return (cs) obj;
    }

    public static final cq b(Object obj) {
        return ((cr) obj).a;
    }

    public static final Map c(Object obj) {
        return (cs) obj;
    }

    public static final int d(int i, Object obj, Object obj2) {
        cs csVar = (cs) obj;
        cr crVar = (cr) obj2;
        int iU = 0;
        if (!csVar.isEmpty()) {
            for (Map.Entry entry : csVar.entrySet()) {
                iU += ai.U(i) + ai.K(cr.a(crVar.a, entry.getKey(), entry.getValue()));
            }
        }
        return iU;
    }

    public static final boolean e(Object obj) {
        return !((cs) obj).b;
    }

    public static final Object f(Object obj, Object obj2) {
        cs csVarA = (cs) obj;
        cs csVar = (cs) obj2;
        if (!csVar.isEmpty()) {
            if (!csVarA.b) {
                csVarA = csVarA.a();
            }
            csVarA.b();
            if (!csVar.isEmpty()) {
                csVarA.putAll(csVar);
            }
        }
        return csVarA;
    }

    public static final Object g() {
        return cs.a.a();
    }

    public static final void h(Object obj) {
        ((cs) obj).c();
    }
}

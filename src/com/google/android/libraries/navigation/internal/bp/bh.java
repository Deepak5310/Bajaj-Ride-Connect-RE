package com.google.android.libraries.navigation.internal.bp;

import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class bh implements Iterable {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.bp.bh");
    public static final bh b;

    static {
        int i = ev.d;
        b = new m(lv.a, -1, null);
    }

    public static bh g(bg bgVar) {
        return h(0, ev.q(bgVar));
    }

    public static bh h(int i, List list) {
        if (list == null || list.isEmpty()) {
            return b;
        }
        if (i < list.size() && i >= 0) {
            return new m(ev.o(list), i, ((bg) list.get(0)).j);
        }
        ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(74)).t("selectedIndex %d not in loaded RouteList, which has size %d.", i, list.size());
        return b;
    }

    public static bh i(int i, bg... bgVarArr) {
        return h(i, Arrays.asList(bgVarArr));
    }

    public abstract int a();

    public abstract ev b();

    public abstract com.google.android.libraries.navigation.internal.ady.al c();

    public final int d() {
        return b().size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final bg e(int i) {
        return (bg) b().get(i);
    }

    public final bg f() {
        if (k()) {
            return e(a());
        }
        return null;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return b().iterator();
    }

    public final bh j(int i) {
        boolean z = false;
        if (i >= 0 && i < b().size()) {
            z = true;
        }
        com.google.android.libraries.navigation.internal.yx.ar.b(z, "The selected route index is out of bounds.");
        return new m(b(), i, c());
    }

    public final boolean k() {
        return !b().isEmpty();
    }

    public final boolean l() {
        return b().isEmpty();
    }
}

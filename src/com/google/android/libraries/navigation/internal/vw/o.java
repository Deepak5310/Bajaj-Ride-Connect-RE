package com.google.android.libraries.navigation.internal.vw;

import com.google.android.libraries.navigation.internal.bp.ck;
import com.google.android.libraries.navigation.internal.oe.an;
import com.google.android.libraries.navigation.internal.oe.r;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.xe.fe;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o {
    public ck b;
    public boolean a = false;
    public fe g = null;
    public final CopyOnWriteArrayList c = new CopyOnWriteArrayList();
    public final List d = new ArrayList();
    public com.google.android.libraries.navigation.internal.se.b e = null;
    public final CopyOnWriteArrayList f = new CopyOnWriteArrayList();

    public static r a(x xVar) {
        return new r(xVar.b(), xVar.d());
    }

    public final List b() {
        if (!e()) {
            return ev.o(new ArrayList());
        }
        an anVarD = this.e.d(-1.0f);
        if (anVarD == null) {
            return ev.q(a(this.e.b.m.k()));
        }
        ArrayList arrayList = new ArrayList(anVarD.a() + 1);
        if (!this.d.isEmpty()) {
            List list = this.d;
            arrayList.add(a((x) list.get(list.size() - 1)));
        }
        for (int i = 0; i < anVarD.a(); i++) {
            arrayList.add(a(anVarD.b(i)));
        }
        return ev.o(arrayList);
    }

    public final void c() {
        this.e = null;
        this.a = false;
    }

    public final void d() {
        this.d.clear();
    }

    public final boolean e() {
        return this.e != null;
    }
}

package com.google.android.libraries.navigation.internal.rl;

import com.google.android.libraries.navigation.internal.ol.ax;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class r implements s {
    public static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.rl.r");
    private final o b;
    private final List c = new ArrayList();
    private n d;
    private final com.google.android.libraries.navigation.internal.pm.a e;

    public r(int i, ax axVar, com.google.android.libraries.navigation.internal.pm.a aVar) {
        this.b = new o(i, axVar);
        this.e = aVar;
    }

    public final j a(i iVar, k kVar) {
        int iA;
        synchronized (this) {
            this.c.add(kVar);
            iA = this.b.a(iVar);
            this.d = null;
        }
        return new j(iA);
    }

    @Override // com.google.android.libraries.navigation.internal.rl.s
    public final synchronized l b() {
        if (this.d == null) {
            List list = this.c;
            this.d = new n(ev.o(list), this.e);
        }
        return this.d.a();
    }

    @Override // com.google.android.libraries.navigation.internal.rl.s
    public final p c() {
        return this.b.c();
    }
}

package com.google.android.libraries.navigation.internal.po;

import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dc {
    private final Set a = new HashSet();
    private com.google.android.libraries.navigation.internal.yz.ek b;
    private boolean c;
    private final com.google.android.libraries.navigation.internal.yx.aa d;

    public dc(com.google.android.libraries.navigation.internal.yx.aa aaVar) {
        int i = com.google.android.libraries.navigation.internal.yz.ev.d;
        this.b = lv.a;
        this.c = true;
        this.d = aaVar;
    }

    public final synchronized com.google.android.libraries.navigation.internal.yz.ek a() {
        return this.b;
    }

    public final synchronized boolean b(Object obj) {
        boolean zAdd;
        zAdd = this.a.add(obj);
        this.c |= zAdd;
        return zAdd;
    }

    public final synchronized boolean c(Object obj) {
        boolean zRemove;
        zRemove = this.a.remove(obj);
        this.c |= zRemove;
        return zRemove;
    }

    public final synchronized void d() {
        if (this.c) {
            this.b = (com.google.android.libraries.navigation.internal.yz.ek) this.d.ak(this.a);
            this.c = false;
        }
    }
}

package com.google.android.libraries.navigation.internal.po;

import com.google.android.libraries.navigation.internal.yz.mp;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class be {
    com.google.android.libraries.navigation.internal.ol.v a = null;
    com.google.android.libraries.navigation.internal.ol.v b = null;
    com.google.android.libraries.navigation.internal.ol.v c = null;
    private final bf d;

    public be(bf bfVar) {
        this.d = bfVar;
    }

    public final void a() {
        synchronized (this.d) {
            this.d.c(this);
        }
        for (com.google.android.libraries.navigation.internal.ol.v vVar : mp.f(this.a, this.b, this.c)) {
            if (vVar != null) {
                vVar.h();
            }
        }
        this.c = null;
        this.b = null;
        this.a = null;
    }

    public final void b() {
        com.google.android.libraries.navigation.internal.ol.v vVar = this.c;
        com.google.android.libraries.navigation.internal.ol.v vVar2 = this.b;
        if (vVar == vVar2) {
            return;
        }
        this.c = vVar2;
        if (vVar2 != null) {
            vVar2.m();
        }
        if (vVar != null) {
            vVar.h();
        }
    }

    public final void c(com.google.android.libraries.navigation.internal.ol.v vVar) {
        synchronized (this.d) {
            com.google.android.libraries.navigation.internal.ol.v vVar2 = this.a;
            if (vVar == vVar2) {
                return;
            }
            if (vVar2 != null && vVar2 != this.b && vVar2 != this.c) {
                vVar2.h();
            }
            this.a = vVar;
        }
    }
}

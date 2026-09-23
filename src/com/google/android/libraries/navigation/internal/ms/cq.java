package com.google.android.libraries.navigation.internal.ms;

import android.view.View;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cq {
    public ck a;

    public cq(ck ckVar) {
        this.a = ckVar;
    }

    public final View a() {
        return this.a.c;
    }

    public final void b() {
        this.a.m();
    }

    public final void c(cs csVar) {
        com.google.android.libraries.navigation.internal.yt.a aVarD = com.google.android.libraries.navigation.internal.yt.d.d("VH.bindModel ", csVar);
        try {
            this.a.q(csVar, 2);
            aVarD.close();
        } catch (Throwable th) {
            try {
                aVarD.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final void d() {
        this.a.g.f().b(this);
    }

    public final void e() {
        this.a.q(null, 2);
    }
}

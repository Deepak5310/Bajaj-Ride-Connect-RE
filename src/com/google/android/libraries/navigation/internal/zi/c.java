package com.google.android.libraries.navigation.internal.zi;

import com.google.android.libraries.navigation.internal.zd.ak;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class c {
    private final ak a;
    public int c = 0;
    public int d = -1;

    public c(ak akVar) {
        com.google.android.libraries.navigation.internal.zj.b.d(akVar, "context");
        this.a = akVar;
    }

    protected abstract Object a();

    protected abstract void b(int i, int i2, com.google.android.libraries.navigation.internal.zh.c cVar);

    public final d f() {
        return this.a.a;
    }

    public final String g() {
        return this.a.b;
    }
}

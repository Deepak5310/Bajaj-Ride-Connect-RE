package com.google.android.libraries.navigation.internal.ee;

import com.google.android.libraries.navigation.internal.yx.an;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class p {
    public static n h(int i) {
        c cVar = new c();
        cVar.a = i;
        cVar.b = (byte) (cVar.b | 1);
        cVar.g(false);
        cVar.f(false);
        if (i == 4) {
            cVar.f(true);
            cVar.g(true);
        }
        return cVar;
    }

    public abstract int a();

    public abstract int b();

    public abstract an c();

    public abstract an d();

    public abstract String e();

    public abstract boolean f();

    public abstract boolean g();
}

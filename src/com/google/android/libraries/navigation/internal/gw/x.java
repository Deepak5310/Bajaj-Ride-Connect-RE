package com.google.android.libraries.navigation.internal.gw;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class x {
    public static final x c = f().c();
    public static final x d;

    static {
        w wVarF = f();
        wVarF.b(true);
        d = wVarF.c();
    }

    public static w f() {
        d dVar = new d();
        dVar.d = (byte) (dVar.d | 1);
        dVar.b(false);
        return dVar;
    }

    public abstract com.google.android.libraries.navigation.internal.o.d a();

    public abstract Integer b();

    public abstract Integer c();

    public abstract boolean d();

    public abstract void e();
}

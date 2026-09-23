package com.google.android.libraries.navigation.internal.oe;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h {
    public static r a(x xVar) {
        return new r(xVar.b(), xVar.d());
    }

    public static t b(bd bdVar) {
        s sVar = new s();
        sVar.b(a(bdVar.c));
        sVar.b(a(bdVar.b));
        com.google.android.libraries.navigation.internal.yx.ar.l(!sVar.a(), "No points included");
        return new t(new r(sVar.a, sVar.c), new r(sVar.b, sVar.d));
    }

    public static x c(r rVar) {
        return x.A(rVar.a, rVar.b);
    }
}

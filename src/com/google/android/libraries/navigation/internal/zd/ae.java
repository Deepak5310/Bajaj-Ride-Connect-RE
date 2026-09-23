package com.google.android.libraries.navigation.internal.zd;

import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class ae {
    private static final ae a = new y();

    public abstract int a();

    public abstract Object b(com.google.android.libraries.navigation.internal.zb.ac acVar);

    public abstract Set c();

    public abstract void d(u uVar, Object obj);

    public static ae g(n nVar, n nVar2) {
        int iB = nVar2.b();
        if (iB == 0) {
            return a;
        }
        return iB <= 28 ? new ac(nVar, nVar2) : new ad(nVar, nVar2);
    }
}

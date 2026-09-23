package com.google.android.libraries.navigation.internal.jy;

import com.google.android.libraries.navigation.internal.yx.an;
import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class m implements Serializable {
    public static m e(com.google.android.libraries.navigation.internal.kb.c cVar, int i, an anVar) {
        return new c(cVar, new d(i), anVar);
    }

    public abstract l a();

    public abstract com.google.android.libraries.navigation.internal.kb.c b();

    public abstract an c();

    public final int d() {
        return ((d) a()).a;
    }

    public final boolean f(String str) {
        return b().equals(com.google.android.libraries.navigation.internal.kb.c.b(str).f());
    }

    public final boolean g() {
        return d() == 0;
    }
}

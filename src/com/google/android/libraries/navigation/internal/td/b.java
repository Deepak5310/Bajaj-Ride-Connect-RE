package com.google.android.libraries.navigation.internal.td;

import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.hj.i;
import com.google.android.libraries.navigation.internal.nt.f;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public final f a;
    private final com.google.android.libraries.navigation.internal.di.b b;

    public b(com.google.android.libraries.navigation.internal.di.b bVar, bn bnVar) {
        this.b = bVar;
        this.a = new f(bnVar);
        bVar.e().e(new a(this), bnVar);
    }

    public static String b(i iVar) {
        if (iVar.b()) {
            return "SIGNED_OUT";
        }
        return iVar.an() ? "UNKNOWN" : iVar.c();
    }

    public final com.google.android.libraries.navigation.internal.nt.a a() {
        return this.a.a;
    }

    public final String c() {
        return b(this.b.c());
    }
}

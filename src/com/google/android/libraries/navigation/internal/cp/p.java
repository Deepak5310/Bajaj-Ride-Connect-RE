package com.google.android.libraries.navigation.internal.cp;

import android.content.Context;
import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.yx.an;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p {
    private final Context a;
    private final com.google.android.libraries.navigation.internal.afo.a b;
    private final com.google.android.libraries.navigation.internal.dx.i c;

    public p(Context context, com.google.android.libraries.navigation.internal.afo.a aVar, com.google.android.libraries.navigation.internal.dx.i iVar) {
        this.a = context;
        this.b = aVar;
        this.c = iVar;
    }

    public final an a(com.google.android.libraries.navigation.internal.cn.n nVar) {
        al alVar = al.DRIVE;
        if (((com.google.android.libraries.navigation.internal.cn.b) nVar).a.ordinal() != 0) {
            return com.google.android.libraries.navigation.internal.yx.a.a;
        }
        Context context = this.a;
        com.google.android.libraries.navigation.internal.yx.a aVar = com.google.android.libraries.navigation.internal.yx.a.a;
        return an.j(new o(context, nVar, aVar, this.b, aVar, this.c));
    }
}

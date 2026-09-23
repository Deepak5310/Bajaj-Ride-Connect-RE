package com.google.android.libraries.navigation.internal.en;

import com.google.android.libraries.navigation.internal.adu.m;
import com.google.android.libraries.navigation.internal.ee.g;
import com.google.android.libraries.navigation.internal.ee.h;
import com.google.android.libraries.navigation.internal.ee.q;
import com.google.android.libraries.navigation.internal.ee.u;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends u {
    public a() {
        q qVar;
        int i = m.NAVIGATION_STATUS.eU;
        g gVar = new g();
        gVar.a = i;
        gVar.c = (byte) (gVar.c | 3);
        q qVar2 = q.DISABLED;
        Objects.requireNonNull(qVar2);
        gVar.b = qVar2;
        if (gVar.c != 3 || (qVar = gVar.b) == null) {
            throw new IllegalStateException();
        }
        super(new h(gVar.a, qVar));
    }
}

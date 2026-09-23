package com.google.android.libraries.navigation.internal.gh;

import android.accounts.Account;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.afl.bd;
import com.google.android.libraries.navigation.internal.gd.i;
import com.google.android.libraries.navigation.internal.gd.k;
import com.google.android.libraries.navigation.internal.gd.o;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    public long j;
    public com.google.android.libraries.navigation.internal.xn.a k;
    public i a = i.a;
    public k b = k.a;
    public o c = o.a;
    public com.google.android.libraries.navigation.internal.gd.e d = com.google.android.libraries.navigation.internal.gd.e.a;
    public Account e = null;
    public com.google.android.libraries.navigation.internal.io.b f = com.google.android.libraries.navigation.internal.io.b.b;
    public bd g = null;
    public dg h = null;
    public com.google.android.libraries.navigation.internal.gp.b l = null;
    public com.google.android.libraries.navigation.internal.gd.a i = com.google.android.libraries.navigation.internal.gd.a.GMM_API;

    public c() {
        com.google.android.libraries.navigation.internal.xn.a aVar = d.a;
        this.k = d.a;
    }

    public final void a(k kVar) {
        int i = kVar.c;
        ar.d(i >= 0, "negative retryDelayMs: %s", i);
        int i2 = kVar.d;
        ar.d(i2 > 0, "maxAttempts < 1: %s", i2);
        long j = kVar.e;
        ar.e(j >= 0, "negative singleAttemptTimeoutMs: %s", j);
        this.b = kVar;
    }

    public final void b(o oVar) {
        int i = oVar.b;
        ar.d(i >= 0, "negative maxDelayMs: %s", i);
        this.c = oVar;
    }
}

package com.google.android.libraries.navigation.internal.gm;

import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.aac.ca;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class y {
    public static final long a = TimeUnit.SECONDS.toMillis(25);
    public static final com.google.android.libraries.navigation.internal.gh.b b = new com.google.android.libraries.navigation.internal.gh.a("LowPrioritySend", "true");
    public final bn d;
    public final Object c = new Object();
    public ca e = new ca();
    public bj f = az.h(b);

    public y(bn bnVar) {
        this.d = bnVar;
    }

    public final void a() {
        ca caVar;
        synchronized (this.c) {
            caVar = this.e;
        }
        caVar.d(b);
    }
}

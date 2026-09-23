package com.google.android.apps.gmm.location.navigation;

import com.google.android.libraries.navigation.internal.agi.de;
import com.google.android.libraries.navigation.internal.agi.du;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.ma;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class ar {
    private static final fd a;
    private final com.google.android.libraries.navigation.internal.mj.a b;
    private final de c;

    static {
        com.google.android.libraries.navigation.internal.yz.bs.a("Car-GPS", 5000L);
        com.google.android.libraries.navigation.internal.yz.bs.a("geoa", 4000L);
        com.google.android.libraries.navigation.internal.yz.bs.a("Any GPS", 10000L);
        com.google.android.libraries.navigation.internal.yz.bs.a("bluewave", 1500L);
        a = ma.a(4, new Object[]{"Car-GPS", 5000L, "geoa", 4000L, "Any GPS", 10000L, "bluewave", 1500L});
    }

    public ar(com.google.android.libraries.navigation.internal.mj.a aVar) {
        du duVar = new du(((ma) a).d);
        this.c = duVar;
        this.b = aVar;
        duVar.a = Long.MIN_VALUE;
    }

    public final void a(String str) {
        this.c.b(str, this.b.a());
    }

    public final boolean b(String str) {
        long jLongValue = ((Long) a.getOrDefault(str, 0L)).longValue();
        long jQ = this.c.q(str);
        return jQ == Long.MIN_VALUE || this.b.a() - jQ > jLongValue;
    }
}

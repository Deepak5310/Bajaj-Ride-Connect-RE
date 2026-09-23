package com.google.android.libraries.navigation.internal.acw;

import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends bi implements cz {
    public static final b a;
    private static volatile dg h;
    public int b;
    public int e;
    public boolean f;
    public com.google.android.libraries.navigation.internal.aax.d g;
    private byte i = 2;
    public String c = "";
    public bz d = dj.b;

    static {
        b bVar = new b();
        a = bVar;
        bi.F(b.class, bVar);
    }

    private b() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.i);
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0002\u0001ဈ\u0000\u0002Л\u0003င\u0001\u0004ဇ\u0002\u0005ᐉ\u0003", new Object[]{"b", "c", "d", f.class, "e", "f", "g"});
        }
        if (i2 == 3) {
            return new b();
        }
        if (i2 == 4) {
            return new a();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.i = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = h;
        if (bcVar == null) {
            synchronized (b.class) {
                bcVar = h;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    h = bcVar;
                }
            }
        }
        return bcVar;
    }
}

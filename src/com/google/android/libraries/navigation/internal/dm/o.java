package com.google.android.libraries.navigation.internal.dm;

import com.google.android.libraries.navigation.internal.ael.bc;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cz;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o extends bi implements cz {
    public static final o a;
    private static volatile dg m;
    public int b;
    public com.google.android.libraries.navigation.internal.aeg.d f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private byte f399n = 2;
    public String c = "";
    public String d = "";
    public String e = "";
    public String g = "";
    public String h = "";
    public String i = "";
    public String j = "";
    public String k = "";
    public String l = "";

    static {
        o oVar = new o();
        a = oVar;
        bi.F(o.class, oVar);
    }

    private o() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f399n);
        }
        if (i2 == 2) {
            return new dk(a, "\u0004\t\u0000\u0001\u0001\f\t\u0000\u0000\u0001\u0001ဈ\u0000\u0002ဈ\u0001\u0004ဈ\u0003\u0005ᐉ\u0004\u0006ဈ\u0005\u0007ဈ\u0006\nဈ\t\u000bဈ\n\fဈ\u000b", new Object[]{"b", "c", "d", "e", "f", "g", "h", "j", "k", "l"});
        }
        if (i2 == 3) {
            return new o();
        }
        if (i2 == 4) {
            return new n();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.f399n = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        dg bcVar = m;
        if (bcVar == null) {
            synchronized (o.class) {
                bcVar = m;
                if (bcVar == null) {
                    bcVar = new bc(a);
                    m = bcVar;
                }
            }
        }
        return bcVar;
    }
}

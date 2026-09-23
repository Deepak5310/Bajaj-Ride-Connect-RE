package com.google.android.libraries.navigation.internal.adg;

import androidx.core.view.ViewCompat;
import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cr extends com.google.android.libraries.navigation.internal.ael.be implements com.google.android.libraries.navigation.internal.ael.bf {
    public static final cr a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg p;
    public int b;
    public int d;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f183n;
    public int o;
    private byte q = 2;
    public String c = "";
    public int e = -1;
    public int f = 1;
    public int m = ViewCompat.MEASURED_STATE_MASK;

    static {
        cr crVar = new cr();
        a = crVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(cr.class, crVar);
    }

    private cr() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.q);
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0003\u0003င\u0004\u0004င\u0005\u0005င\u0002\u0006ဆ\n\u0007ဆ\f\bဋ\u0001\tင\u0006\nင\u0007\u000bင\b\fင\t\rဋ\u000b", new Object[]{"b", "c", "f", "g", "h", "e", "m", "o", "d", ContextChain.TAG_INFRA, "j", "k", "l", "n"});
        }
        if (i2 == 3) {
            return new cr();
        }
        if (i2 == 4) {
            return new cq();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            this.q = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = p;
        if (bcVar == null) {
            synchronized (cr.class) {
                bcVar = p;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    p = bcVar;
                }
            }
        }
        return bcVar;
    }
}

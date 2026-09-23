package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fp extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final fp a;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static volatile com.google.android.libraries.navigation.internal.ael.dg f310n;
    public int b;
    public boolean c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;

    static {
        fp fpVar = new fp();
        a = fpVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(fp.class, fpVar);
    }

    private fp() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\t\u0000\u0001\u0003\f\t\u0000\u0000\u0000\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006င\u0005\u0007င\u0006\tင\b\nင\t\u000bင\n\fင\u000b", new Object[]{"b", "d", "e", "f", "g", "h", "j", "k", "l", "m"});
        }
        if (i2 == 3) {
            return new fp();
        }
        if (i2 == 4) {
            return new fo();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = f310n;
        if (bcVar == null) {
            synchronized (fp.class) {
                bcVar = f310n;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    f310n = bcVar;
                }
            }
        }
        return bcVar;
    }
}

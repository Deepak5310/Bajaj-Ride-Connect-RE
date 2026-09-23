package com.google.android.libraries.navigation.internal.afm;

import com.google.android.libraries.navigation.internal.ael.dk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class am extends com.google.android.libraries.navigation.internal.ael.bi implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final am a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg i;
    public int b;
    public int c;
    public int h;
    private byte j = 2;
    public String d = "";
    public int e = -2130839438;
    public String f = "";
    public String g = "";

    static {
        am amVar = new am();
        a = amVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(am.class, amVar);
    }

    private am() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i2, Object obj) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return Byte.valueOf(this.j);
        }
        if (i3 == 2) {
            return new dk(a, "\u0004\u0006\u0000\u00015>\u0006\u0000\u0000\u00015င\u00006ᔈ\u00017င\u00028ဈ\u00039ဈ\u0004>᠌\u0005", new Object[]{"b", "c", "d", "e", "f", "g", "h", bb.a});
        }
        if (i3 == 3) {
            return new am();
        }
        if (i3 == 4) {
            return new al();
        }
        if (i3 == 5) {
            return a;
        }
        if (i3 != 6) {
            this.j = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = i;
        if (bcVar == null) {
            synchronized (am.class) {
                bcVar = i;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    i = bcVar;
                }
            }
        }
        return bcVar;
    }
}

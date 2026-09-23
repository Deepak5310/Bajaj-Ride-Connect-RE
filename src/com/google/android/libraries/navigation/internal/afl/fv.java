package com.google.android.libraries.navigation.internal.afl;

import com.facebook.common.callercontext.ContextChain;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fv extends com.google.android.libraries.navigation.internal.ael.bi<fv, ft> implements com.google.android.libraries.navigation.internal.ael.cz {
    public static final fv a;
    private static volatile com.google.android.libraries.navigation.internal.ael.dg k;
    public boolean b;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean h;
    public boolean i;
    public boolean j;
    private int l;
    public String c = "";
    public int g = 1;

    /* JADX INFO: compiled from: PG */
    public enum a implements com.google.android.libraries.navigation.internal.ael.bm {
        UNKNOWN_REPORT_INCIDENT_FAB_POSITION(0),
        LOWER_RIGHT(1),
        UPPER_RIGHT(2),
        UPPER_RIGHT_ABSOLUTE_POSITION(4),
        UPPER_LEFT_ABSOLUTE_POSITION(5),
        UPPER_LEFT_ABSOLUTE_POSITION_PRE_ADAPTIVE_TURN_CARDS(6);

        private final int h;

        a(int i) {
            this.h = i;
        }

        public static a b(int i) {
            if (i == 0) {
                return UNKNOWN_REPORT_INCIDENT_FAB_POSITION;
            }
            if (i == 1) {
                return LOWER_RIGHT;
            }
            if (i == 2) {
                return UPPER_RIGHT;
            }
            if (i == 4) {
                return UPPER_RIGHT_ABSOLUTE_POSITION;
            }
            if (i == 5) {
                return UPPER_LEFT_ABSOLUTE_POSITION;
            }
            if (i != 6) {
                return null;
            }
            return UPPER_LEFT_ABSOLUTE_POSITION_PRE_ADAPTIVE_TURN_CARDS;
        }

        @Override // com.google.android.libraries.navigation.internal.ael.bm
        public final int a() {
            return this.h;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return Integer.toString(this.h);
        }
    }

    static {
        fv fvVar = new fv();
        a = fvVar;
        com.google.android.libraries.navigation.internal.ael.bi.F(fv.class, fvVar);
    }

    private fv() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bi
    public final Object aH(int i, Object obj) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            a aVar = a.UNKNOWN_REPORT_INCIDENT_FAB_POSITION;
            return new com.google.android.libraries.navigation.internal.ael.dk(a, "\u0001\t\u0000\u0001\u0001\u0010\t\u0000\u0000\u0000\u0001ဇ\u0002\u0002ဈ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\bဇ\u0007\t᠌\b\nဇ\t\fဇ\u000b\u0010ဇ\u000f", new Object[]{"l", "b", "c", "d", "e", "f", "g", fu.a, "h", ContextChain.TAG_INFRA, "j"});
        }
        if (i2 == 3) {
            return new fv();
        }
        if (i2 == 4) {
            return new ft();
        }
        if (i2 == 5) {
            return a;
        }
        if (i2 != 6) {
            throw null;
        }
        com.google.android.libraries.navigation.internal.ael.dg bcVar = k;
        if (bcVar == null) {
            synchronized (fv.class) {
                bcVar = k;
                if (bcVar == null) {
                    bcVar = new com.google.android.libraries.navigation.internal.ael.bc(a);
                    k = bcVar;
                }
            }
        }
        return bcVar;
    }
}

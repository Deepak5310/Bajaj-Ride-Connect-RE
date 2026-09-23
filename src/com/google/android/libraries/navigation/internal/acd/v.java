package com.google.android.libraries.navigation.internal.acd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum v implements com.google.android.libraries.navigation.internal.ael.bm {
    OTHER_CELL_NETWORK(0),
    EDGE(1),
    GPRS(2),
    UMTS(3),
    CDMA(4),
    CDMA2000_1XRTT(5),
    CDMA2000_1XEVDO_0(6),
    CDMA2000_1XEVDO_A(7),
    CDMA2000_1XEVDO_B(8),
    IDEN(9),
    HSPA(10),
    HSDPA(11),
    HSUPA(12),
    HSPAP(13),
    EHRPD(14),
    LTE(15),
    NRNSA(16),
    NR(17);

    public final int s;

    v(int i) {
        this.s = i;
    }

    public static v b(int i) {
        switch (i) {
            case 0:
                return OTHER_CELL_NETWORK;
            case 1:
                return EDGE;
            case 2:
                return GPRS;
            case 3:
                return UMTS;
            case 4:
                return CDMA;
            case 5:
                return CDMA2000_1XRTT;
            case 6:
                return CDMA2000_1XEVDO_0;
            case 7:
                return CDMA2000_1XEVDO_A;
            case 8:
                return CDMA2000_1XEVDO_B;
            case 9:
                return IDEN;
            case 10:
                return HSPA;
            case 11:
                return HSDPA;
            case 12:
                return HSUPA;
            case 13:
                return HSPAP;
            case 14:
                return EHRPD;
            case 15:
                return LTE;
            case 16:
                return NRNSA;
            case 17:
                return NR;
            default:
                return null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.s;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.s);
    }
}

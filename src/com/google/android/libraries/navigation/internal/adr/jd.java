package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum jd implements com.google.android.libraries.navigation.internal.ael.bm {
    DEFAULT_NONE(0),
    DING_DAH(6),
    DING_DEE(7),
    DING_DONG(8),
    DRING_DRING(9),
    TAH_LAH_LAH(10),
    TOO_LOO(11);

    private final int i;

    jd(int i) {
        this.i = i;
    }

    public static jd b(int i) {
        if (i == 0) {
            return DEFAULT_NONE;
        }
        switch (i) {
            case 6:
                return DING_DAH;
            case 7:
                return DING_DEE;
            case 8:
                return DING_DONG;
            case 9:
                return DRING_DRING;
            case 10:
                return TAH_LAH_LAH;
            case 11:
                return TOO_LOO;
            default:
                return null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.i;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.i);
    }
}

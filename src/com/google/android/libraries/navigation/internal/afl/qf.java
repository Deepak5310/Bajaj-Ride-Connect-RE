package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum qf implements com.google.android.libraries.navigation.internal.ael.bm {
    DEFAULT_MODE(0),
    DASH_NO_TILE_HASHING(1),
    DASH_WITH_TILE_HASHING(2),
    DIRECT_TO_PAINT(3);

    private static final com.google.android.libraries.navigation.internal.ael.bn f = new com.google.android.libraries.navigation.internal.ael.bn() { // from class: com.google.android.libraries.navigation.internal.afl.qd
        @Override // com.google.android.libraries.navigation.internal.ael.bn
        public final /* synthetic */ com.google.android.libraries.navigation.internal.ael.bm a(int i) {
            return qf.b(i);
        }
    };
    public final int e;

    qf(int i) {
        this.e = i;
    }

    public static qf b(int i) {
        if (i == 0) {
            return DEFAULT_MODE;
        }
        if (i == 1) {
            return DASH_NO_TILE_HASHING;
        }
        if (i == 2) {
            return DASH_WITH_TILE_HASHING;
        }
        if (i != 3) {
            return null;
        }
        return DIRECT_TO_PAINT;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.e;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.e);
    }
}

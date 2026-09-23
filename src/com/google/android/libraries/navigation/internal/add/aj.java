package com.google.android.libraries.navigation.internal.add;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum aj implements com.google.android.libraries.navigation.internal.ael.bm {
    UNKNOWN(0),
    STRAIGHT(1),
    STRAIGHT_TALL(2),
    SLIGHT(3),
    SLIGHT_TALL(4),
    NORMAL(5),
    NORMAL_SHORT(6),
    SHARP(7),
    SHARP_SHORT(8),
    UTURN(9),
    UTURN_SHORT(10),
    STUB(11),
    UNRECOGNIZED(-1);

    private final int o;

    aj(int i) {
        this.o = i;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.o;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(a());
    }
}

package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum hu implements com.google.android.libraries.navigation.internal.ael.bm {
    TURN_UNKNOWN(0),
    TURN_SLIGHT(1),
    TURN_NORMAL(2),
    TURN_SHARP(3),
    TURN_KEEP(4),
    TURN_UTURN(5),
    TURN_STRAIGHT(6),
    TURN_MERGE(7),
    TURN_FORK(8);

    public final int j;

    hu(int i) {
        this.j = i;
    }

    public static hu b(int i) {
        switch (i) {
            case 0:
                return TURN_UNKNOWN;
            case 1:
                return TURN_SLIGHT;
            case 2:
                return TURN_NORMAL;
            case 3:
                return TURN_SHARP;
            case 4:
                return TURN_KEEP;
            case 5:
                return TURN_UTURN;
            case 6:
                return TURN_STRAIGHT;
            case 7:
                return TURN_MERGE;
            case 8:
                return TURN_FORK;
            default:
                return null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.j;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.j);
    }
}

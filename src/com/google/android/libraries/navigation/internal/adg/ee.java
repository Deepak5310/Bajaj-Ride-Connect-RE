package com.google.android.libraries.navigation.internal.adg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum ee implements com.google.android.libraries.navigation.internal.ael.bm {
    BOTTOM_RIGHT_TO_TOP_LEFT(0),
    BOTTOM_RIGHT_TO_TOP_RIGHT(1),
    BOTTOM_CENTER_TO_TOP_CENTER(2),
    BOTTOM_LEFT_TO_TOP_LEFT(3),
    BOTTOM_LEFT_TO_TOP_RIGHT(4),
    TOP_RIGHT_TO_TOP_LEFT(5),
    CENTER_RIGHT_TO_CENTER_LEFT(6),
    BOTTOM_RIGHT_TO_BOTTOM_LEFT(7),
    TOP_LEFT_TO_TOP_RIGHT(8),
    CENTER_LEFT_TO_CENTER_RIGHT(9),
    BOTTOM_LEFT_TO_BOTTOM_RIGHT(10),
    TOP_RIGHT_TO_BOTTOM_LEFT(11),
    TOP_RIGHT_TO_BOTTOM_RIGHT(12),
    TOP_CENTER_TO_BOTTOM_CENTER(13),
    TOP_LEFT_TO_BOTTOM_LEFT(14),
    TOP_LEFT_TO_BOTTOM_RIGHT(15);

    public final int q;

    ee(int i) {
        this.q = i;
    }

    public static ee b(int i) {
        switch (i) {
            case 0:
                return BOTTOM_RIGHT_TO_TOP_LEFT;
            case 1:
                return BOTTOM_RIGHT_TO_TOP_RIGHT;
            case 2:
                return BOTTOM_CENTER_TO_TOP_CENTER;
            case 3:
                return BOTTOM_LEFT_TO_TOP_LEFT;
            case 4:
                return BOTTOM_LEFT_TO_TOP_RIGHT;
            case 5:
                return TOP_RIGHT_TO_TOP_LEFT;
            case 6:
                return CENTER_RIGHT_TO_CENTER_LEFT;
            case 7:
                return BOTTOM_RIGHT_TO_BOTTOM_LEFT;
            case 8:
                return TOP_LEFT_TO_TOP_RIGHT;
            case 9:
                return CENTER_LEFT_TO_CENTER_RIGHT;
            case 10:
                return BOTTOM_LEFT_TO_BOTTOM_RIGHT;
            case 11:
                return TOP_RIGHT_TO_BOTTOM_LEFT;
            case 12:
                return TOP_RIGHT_TO_BOTTOM_RIGHT;
            case 13:
                return TOP_CENTER_TO_BOTTOM_CENTER;
            case 14:
                return TOP_LEFT_TO_BOTTOM_LEFT;
            case 15:
                return TOP_LEFT_TO_BOTTOM_RIGHT;
            default:
                return null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.q;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.q);
    }
}

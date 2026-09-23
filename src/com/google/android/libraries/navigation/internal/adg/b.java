package com.google.android.libraries.navigation.internal.adg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum b implements com.google.android.libraries.navigation.internal.ael.bm {
    CENTER(1),
    LEFT(2),
    RIGHT(3),
    TOP(4),
    TOP_LEFT(5),
    TOP_RIGHT(6),
    BOTTOM(7),
    BOTTOM_LEFT(8),
    BOTTOM_RIGHT(9);

    public final int j;

    b(int i) {
        this.j = i;
    }

    public static b b(int i) {
        switch (i) {
            case 1:
                return CENTER;
            case 2:
                return LEFT;
            case 3:
                return RIGHT;
            case 4:
                return TOP;
            case 5:
                return TOP_LEFT;
            case 6:
                return TOP_RIGHT;
            case 7:
                return BOTTOM;
            case 8:
                return BOTTOM_LEFT;
            case 9:
                return BOTTOM_RIGHT;
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

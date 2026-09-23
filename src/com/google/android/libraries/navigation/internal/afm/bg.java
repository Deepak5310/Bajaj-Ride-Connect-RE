package com.google.android.libraries.navigation.internal.afm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum bg implements com.google.android.libraries.navigation.internal.ael.bm {
    FRONT(1),
    LEFT(2),
    BACK(3),
    RIGHT(4),
    UP(5),
    DOWN(6);

    private final int h;

    bg(int i) {
        this.h = i;
    }

    public static bg b(int i) {
        switch (i) {
            case 1:
                return FRONT;
            case 2:
                return LEFT;
            case 3:
                return BACK;
            case 4:
                return RIGHT;
            case 5:
                return UP;
            case 6:
                return DOWN;
            default:
                return null;
        }
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

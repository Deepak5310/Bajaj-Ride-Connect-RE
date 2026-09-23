package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum fy implements com.google.android.libraries.navigation.internal.ael.bm {
    SUMMARY(1),
    STEPS(2),
    DRAGGING(3),
    TURN_BY_TURN(4),
    MIXED(5),
    TURN_BY_TURN_STEPS(6);

    public final int g;

    fy(int i) {
        this.g = i;
    }

    public static fy b(int i) {
        switch (i) {
            case 1:
                return SUMMARY;
            case 2:
                return STEPS;
            case 3:
                return DRAGGING;
            case 4:
                return TURN_BY_TURN;
            case 5:
                return MIXED;
            case 6:
                return TURN_BY_TURN_STEPS;
            default:
                return null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.g;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.g);
    }
}

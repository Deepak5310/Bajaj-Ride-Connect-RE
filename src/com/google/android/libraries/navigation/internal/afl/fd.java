package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum fd implements com.google.android.libraries.navigation.internal.ael.bm {
    UNKNOWN_CAMERA_TYPE(0),
    CAMERA_3D(1),
    CAMERA_2D_NORTH_UP(2),
    CAMERA_2D_HEADING_UP(3);

    public final int e;

    fd(int i) {
        this.e = i;
    }

    public static fd b(int i) {
        if (i == 0) {
            return UNKNOWN_CAMERA_TYPE;
        }
        if (i == 1) {
            return CAMERA_3D;
        }
        if (i == 2) {
            return CAMERA_2D_NORTH_UP;
        }
        if (i != 3) {
            return null;
        }
        return CAMERA_2D_HEADING_UP;
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

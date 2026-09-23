package com.google.android.libraries.navigation.internal.zs;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum aq implements com.google.android.libraries.navigation.internal.ael.bm {
    UNKNOWN_CAMERA_TYPE(0),
    CAMERA_3D(1),
    CAMERA_2D_NORTH_UP(2),
    CAMERA_2D_HEADING_UP(3);

    private final int f;

    aq(int i) {
        this.f = i;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.f;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.f);
    }
}

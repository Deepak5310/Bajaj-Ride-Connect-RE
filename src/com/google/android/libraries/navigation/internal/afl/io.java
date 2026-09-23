package com.google.android.libraries.navigation.internal.afl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum io implements com.google.android.libraries.navigation.internal.ael.bm {
    UNKNOWN_RELEASE_LEVEL(0),
    DEV(100),
    FISHFOOD(200),
    DOGFOOD(300),
    PREVIEW(400),
    RELEASE(500);

    public final int g;

    io(int i) {
        this.g = i;
    }

    public static io b(int i) {
        if (i == 0) {
            return UNKNOWN_RELEASE_LEVEL;
        }
        if (i == 100) {
            return DEV;
        }
        if (i == 200) {
            return FISHFOOD;
        }
        if (i == 300) {
            return DOGFOOD;
        }
        if (i == 400) {
            return PREVIEW;
        }
        if (i != 500) {
            return null;
        }
        return RELEASE;
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

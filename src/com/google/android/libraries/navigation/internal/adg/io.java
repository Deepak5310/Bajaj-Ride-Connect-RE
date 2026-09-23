package com.google.android.libraries.navigation.internal.adg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum io implements com.google.android.libraries.navigation.internal.ael.bm {
    RECT(1),
    ROUNDED_RECT(2),
    PILL(3);

    public final int d;

    io(int i) {
        this.d = i;
    }

    public static io b(int i) {
        if (i == 1) {
            return RECT;
        }
        if (i == 2) {
            return ROUNDED_RECT;
        }
        if (i != 3) {
            return null;
        }
        return PILL;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.d;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.d);
    }
}

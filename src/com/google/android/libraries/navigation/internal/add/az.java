package com.google.android.libraries.navigation.internal.add;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum az implements com.google.android.libraries.navigation.internal.ael.bm {
    SIDE_UNSPECIFIED(0),
    SIDE_LEFT(1),
    SIDE_RIGHT(2),
    UNRECOGNIZED(-1);

    private final int f;

    az(int i) {
        this.f = i;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.f;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(a());
    }
}

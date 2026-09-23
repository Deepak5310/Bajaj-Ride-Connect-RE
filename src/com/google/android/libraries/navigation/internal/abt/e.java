package com.google.android.libraries.navigation.internal.abt;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends d {
    public final int e;
    public final int f;

    public e(String str, int i, int i2, int i3, int i4, int i5) {
        super(str, i, i2, i3);
        this.e = i4;
        this.f = i5;
    }

    @Override // com.google.android.libraries.navigation.internal.abt.d
    public final String toString() {
        return String.format("TileKey[%s@x%s,y%s,z%s]:[W%s,H%s]px", this.a, Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.f));
    }
}

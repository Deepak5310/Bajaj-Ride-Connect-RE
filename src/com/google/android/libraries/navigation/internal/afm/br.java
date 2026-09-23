package com.google.android.libraries.navigation.internal.afm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum br implements com.google.android.libraries.navigation.internal.ael.bm {
    DEFAULT_THUMBNAIL(0),
    HQ_THUMBNAIL(1),
    HQ_THUMBNAIL_REPROJECTED(2);

    private final int e;

    br(int i) {
        this.e = i;
    }

    public static br b(int i) {
        if (i == 0) {
            return DEFAULT_THUMBNAIL;
        }
        if (i == 1) {
            return HQ_THUMBNAIL;
        }
        if (i != 2) {
            return null;
        }
        return HQ_THUMBNAIL_REPROJECTED;
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

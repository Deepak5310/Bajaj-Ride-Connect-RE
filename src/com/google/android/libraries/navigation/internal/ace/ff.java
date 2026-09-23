package com.google.android.libraries.navigation.internal.ace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum ff implements com.google.android.libraries.navigation.internal.ael.bm {
    UNKNOWN_BASEMAP_PHOTOS_ROUTE_OVERVIEW_STATUS(0),
    ALWAYS_SHOW(1),
    SEND_PIPE_METADATA(2),
    NEVER_SHOW(3);

    private final int f;

    ff(int i) {
        this.f = i;
    }

    public static ff b(int i) {
        if (i == 0) {
            return UNKNOWN_BASEMAP_PHOTOS_ROUTE_OVERVIEW_STATUS;
        }
        if (i == 1) {
            return ALWAYS_SHOW;
        }
        if (i == 2) {
            return SEND_PIPE_METADATA;
        }
        if (i != 3) {
            return null;
        }
        return NEVER_SHOW;
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

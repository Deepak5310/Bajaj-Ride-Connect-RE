package com.google.android.libraries.navigation.internal.adi;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum c implements com.google.android.libraries.navigation.internal.ael.bm {
    MULTIZOOM_STYLE_TABLE(0),
    COMPACT_MULTIZOOM_STYLE_TABLE(1),
    COMPACT_MULTIZOOM_STYLE_TABLE_WITH_INLINING(2);

    public final int d;

    c(int i) {
        this.d = i;
    }

    public static c b(int i) {
        if (i == 0) {
            return MULTIZOOM_STYLE_TABLE;
        }
        if (i == 1) {
            return COMPACT_MULTIZOOM_STYLE_TABLE;
        }
        if (i != 2) {
            return null;
        }
        return COMPACT_MULTIZOOM_STYLE_TABLE_WITH_INLINING;
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

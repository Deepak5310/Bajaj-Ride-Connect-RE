package com.google.android.libraries.geo.mapcore.internal.model;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public enum at implements com.google.android.libraries.navigation.internal.ael.bm {
    DEFAULT(0),
    DRAW_OVER_LABELS(1),
    DRAW_OVER_LABELS_AND_CALLOUTS(2),
    DRAW_OVER_BUILDINGS(3);

    public static final com.google.android.libraries.navigation.internal.ael.bn e = new com.google.android.libraries.navigation.internal.ael.bn() { // from class: com.google.android.libraries.geo.mapcore.internal.model.as
        @Override // com.google.android.libraries.navigation.internal.ael.bn
        public final /* synthetic */ com.google.android.libraries.navigation.internal.ael.bm a(int i) {
            if (i == 0) {
                return at.DEFAULT;
            }
            if (i == 1) {
                return at.DRAW_OVER_LABELS;
            }
            if (i == 2) {
                return at.DRAW_OVER_LABELS_AND_CALLOUTS;
            }
            if (i != 3) {
                return null;
            }
            return at.DRAW_OVER_BUILDINGS;
        }
    };
    private final int g;

    at(int i) {
        this.g = i;
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

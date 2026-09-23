package com.google.android.libraries.navigation.internal.zp;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum ca implements com.google.android.libraries.navigation.internal.ael.bm {
    VISIBILITY_VISIBLE(0),
    VISIBILITY_HIDDEN(1),
    VISIBILITY_REPRESSED_COUNTERFACTUAL(2),
    VISIBILITY_CHILDREN_HIDDEN(3),
    VISIBILITY_REPRESSED_PRIVACY(4);

    public final int f;

    ca(int i) {
        this.f = i;
    }

    public static ca b(int i) {
        if (i == 0) {
            return VISIBILITY_VISIBLE;
        }
        if (i == 1) {
            return VISIBILITY_HIDDEN;
        }
        if (i == 2) {
            return VISIBILITY_REPRESSED_COUNTERFACTUAL;
        }
        if (i == 3) {
            return VISIBILITY_CHILDREN_HIDDEN;
        }
        if (i != 4) {
            return null;
        }
        return VISIBILITY_REPRESSED_PRIVACY;
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

package com.google.android.libraries.navigation.internal.px;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
enum dv {
    UNPLACED(false, false, false),
    TRUMPED(false, false, true),
    PLACED_IN_IMPRESSED_AREA(true, true, false),
    PLACED_OUTSIDE_IMPRESSED_AREA(true, false, false);

    public final boolean e;
    public final boolean f;
    public final boolean g;

    dv(boolean z, boolean z2, boolean z3) {
        this.e = z;
        this.f = z2;
        this.g = z3;
    }
}

package com.google.android.libraries.navigation.internal.px;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
enum dt {
    NOTHING_PLACED(false, false, false),
    ONLY_PRIMARY_PLACED(true, false, false),
    PRIMARY_AND_SECONDARY_PLACED(true, true, false),
    PRIMARY_AND_TERTIARY_PLACED(true, false, true),
    PRIMARY_SECONDARY_AND_TERTIARY_PLACED(true, true, true);

    final boolean f;
    final boolean g;
    final boolean h;

    dt(boolean z, boolean z2, boolean z3) {
        this.f = z;
        this.g = z2;
        this.h = z3;
    }
}

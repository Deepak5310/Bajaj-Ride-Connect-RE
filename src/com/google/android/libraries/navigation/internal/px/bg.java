package com.google.android.libraries.navigation.internal.px;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
enum bg {
    NONE(com.google.android.libraries.navigation.internal.adq.b.a),
    ON_SECONDARY(com.google.android.libraries.navigation.internal.adq.b.c),
    ON_PRIMARY(com.google.android.libraries.navigation.internal.adq.b.b);

    public final int d;

    bg(int i) {
        this.d = i;
    }

    final boolean a() {
        return this == ON_SECONDARY;
    }
}

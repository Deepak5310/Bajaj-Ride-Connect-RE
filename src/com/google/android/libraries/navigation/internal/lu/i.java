package com.google.android.libraries.navigation.internal.lu;

import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i {
    private long a;

    public i() {
        ar.b(true, "Invalid interval: 20000 should be greater than or equal to 0. Note: Long.MAX_VALUE is not a valid interval.");
        this.a = 20000L;
    }

    public final j a() {
        return new j(this.a, false);
    }
}

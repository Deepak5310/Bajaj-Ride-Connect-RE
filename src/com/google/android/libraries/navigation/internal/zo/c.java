package com.google.android.libraries.navigation.internal.zo;

import com.google.android.libraries.navigation.internal.yx.ak;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c extends d {
    public c(long j, int i) {
        super(j, i);
    }

    public final String toString() {
        return new ak("exponentialBackoff").d("firstDelayMs", this.b).a("multiplier", 2.0d).c("tries", this.a).toString();
    }
}

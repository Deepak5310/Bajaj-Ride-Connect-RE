package com.google.android.libraries.navigation.internal.ld;

import android.os.Looper;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m {
    public com.google.android.libraries.navigation.internal.le.h a;
    private Looper b;

    public final n a() {
        if (this.a == null) {
            this.a = new com.google.android.libraries.navigation.internal.le.h();
        }
        if (this.b == null) {
            this.b = Looper.getMainLooper();
        }
        return new n(this.a, this.b);
    }
}

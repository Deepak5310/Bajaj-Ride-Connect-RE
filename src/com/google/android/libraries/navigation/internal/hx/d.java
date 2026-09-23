package com.google.android.libraries.navigation.internal.hx;

import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    private int a;
    private final Runnable b;

    public d(int i, Runnable runnable) {
        ar.a(i > 0);
        this.a = i;
        this.b = runnable;
    }

    public final void a() {
        synchronized (this) {
            int i = this.a;
            if (i <= 0) {
                return;
            }
            int i2 = i - 1;
            this.a = i2;
            if (i2 == 0) {
                this.b.run();
            }
        }
    }
}

package com.google.android.libraries.navigation.internal.aga;

import androidx.core.app.NotificationCompat;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class k extends aq {
    private final u a;
    private final AtomicInteger b = new AtomicInteger(-2147483647);
    private volatile com.google.android.libraries.navigation.internal.afx.cl c;

    public k(u uVar, String str) {
        this.a = uVar;
        com.google.android.libraries.navigation.internal.yx.ar.r(str, "authority");
    }

    @Override // com.google.android.libraries.navigation.internal.aga.aq, com.google.android.libraries.navigation.internal.aga.de
    public final void c(com.google.android.libraries.navigation.internal.afx.cl clVar) {
        com.google.android.libraries.navigation.internal.yx.ar.r(clVar, NotificationCompat.CATEGORY_STATUS);
        synchronized (this) {
            if (this.b.get() < 0) {
                this.c = clVar;
                this.b.addAndGet(Integer.MAX_VALUE);
                if (this.b.get() != 0) {
                    return;
                }
                super.c(clVar);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.aga.aq
    protected final u d() {
        return this.a;
    }
}

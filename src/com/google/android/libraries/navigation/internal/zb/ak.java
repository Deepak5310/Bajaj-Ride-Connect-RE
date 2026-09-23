package com.google.android.libraries.navigation.internal.zb;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ak extends ah {
    public static final w a = new ai();
    public static final ThreadLocal b = new aj();
    final AtomicInteger e = new AtomicInteger();

    @Override // com.google.android.libraries.navigation.internal.zb.ah
    public final void a() {
        this.e.decrementAndGet();
    }
}

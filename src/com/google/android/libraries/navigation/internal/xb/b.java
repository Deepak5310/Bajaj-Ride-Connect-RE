package com.google.android.libraries.navigation.internal.xb;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends com.google.android.libraries.navigation.internal.xa.b {
    public b() {
        super((ThreadFactory) null, 750);
    }

    @Override // com.google.android.libraries.navigation.internal.xa.b
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final synchronized com.google.android.libraries.navigation.internal.wz.b a() {
        return com.google.android.libraries.navigation.internal.wz.b.c();
    }

    public b(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService, 750);
    }
}

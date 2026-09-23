package com.google.android.libraries.navigation.internal.zf;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k extends e {
    public static final k a = new k();

    private k() {
    }

    @Override // com.google.android.libraries.navigation.internal.zf.e
    public final long a() {
        return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
    }

    public final String toString() {
        return "Default millisecond precision clock";
    }
}

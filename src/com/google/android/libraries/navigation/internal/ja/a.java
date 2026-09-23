package com.google.android.libraries.navigation.internal.ja;

import j$.time.Duration;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static long a(Duration duration) {
        long seconds = duration.getSeconds();
        long nano = duration.getNano();
        return (seconds * 1000) + (nano / 1000000) + ((long) (nano % 1000000 >= 500000 ? 1 : 0));
    }

    public static long b(Duration duration) {
        return duration.getSeconds() + ((long) (duration.getNano() >= 500000000 ? 1 : 0));
    }
}

package com.google.android.libraries.navigation.internal.bp;

import j$.time.Duration;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class ae {
    public abstract Duration a();

    public abstract Duration b();

    public final Duration c() {
        Duration durationA = a();
        return durationA != null ? durationA : b();
    }

    public final boolean d() {
        return a() != null;
    }
}

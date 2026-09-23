package com.google.android.libraries.navigation.internal.bp;

import j$.time.Duration;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j extends ad {
    public Duration a;
    private Duration b;

    @Override // com.google.android.libraries.navigation.internal.bp.ad
    public final ae a() {
        Duration duration = this.b;
        if (duration != null) {
            return new k(duration, this.a);
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.navigation.internal.bp.ad
    public final void b(Duration duration) {
        Objects.requireNonNull(duration);
        this.b = duration;
    }
}

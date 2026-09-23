package com.google.android.libraries.navigation.internal.bp;

import j$.time.Duration;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class h extends c {
    private int a;
    private Duration b;
    private int c;
    private Duration d;
    private byte e;

    @Override // com.google.android.libraries.navigation.internal.bp.c
    public final d a() {
        Duration duration;
        Duration duration2;
        if (this.e != 3 || (duration = this.b) == null || (duration2 = this.d) == null) {
            throw new IllegalStateException();
        }
        return new i(this.a, duration, this.c, duration2);
    }

    @Override // com.google.android.libraries.navigation.internal.bp.c
    public final void b(Duration duration) {
        Objects.requireNonNull(duration);
        this.d = duration;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.c
    public final void c(int i) {
        this.c = i;
        this.e = (byte) (this.e | 2);
    }

    @Override // com.google.android.libraries.navigation.internal.bp.c
    public final void d(Duration duration) {
        Objects.requireNonNull(duration);
        this.b = duration;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.c
    public final void e(int i) {
        this.a = i;
        this.e = (byte) (this.e | 1);
    }
}

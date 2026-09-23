package com.google.android.libraries.navigation.internal.bp;

import j$.time.Duration;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class i extends d {
    private final int a;
    private final Duration b;
    private final int c;
    private final Duration d;

    public i(int i, Duration duration, int i2, Duration duration2) {
        this.a = i;
        this.b = duration;
        this.c = i2;
        this.d = duration2;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.d
    public final int a() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.d
    public final int b() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.d
    public final Duration c() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.d
    public final Duration d() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (this.a == dVar.b() && this.b.equals(dVar.d()) && this.c == dVar.a() && this.d.equals(dVar.c())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.a ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c) * 1000003) ^ this.d.hashCode();
    }

    public final String toString() {
        Duration duration = this.d;
        return "{" + this.a + ", " + String.valueOf(this.b) + ", " + this.c + ", " + String.valueOf(duration) + "}";
    }
}

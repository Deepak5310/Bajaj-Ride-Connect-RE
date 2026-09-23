package com.google.android.libraries.navigation.internal.bp;

import j$.time.Duration;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k extends ae {
    public final Duration a;
    public final Duration b;

    public k(Duration duration, Duration duration2) {
        this.a = duration;
        this.b = duration2;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.ae
    public final Duration a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.ae
    public final Duration b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        Duration duration;
        if (obj == this) {
            return true;
        }
        if (obj instanceof ae) {
            ae aeVar = (ae) obj;
            if (this.a.equals(aeVar.b()) && ((duration = this.b) != null ? duration.equals(aeVar.a()) : aeVar.a() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() ^ 1000003;
        Duration duration = this.b;
        return (iHashCode * 1000003) ^ (duration == null ? 0 : duration.hashCode());
    }

    public final String toString() {
        Duration duration = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(duration) + "}";
    }
}

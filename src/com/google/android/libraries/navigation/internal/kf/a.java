package com.google.android.libraries.navigation.internal.kf;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a extends e {
    private final int a;
    private final long b;

    public a(int i, long j) {
        this.a = i;
        this.b = j;
    }

    @Override // com.google.android.libraries.navigation.internal.kf.e
    public final int a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.kf.e
    public final long b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.a == eVar.a() && this.b == eVar.b()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.b;
        return ((int) (j ^ (j >>> 32))) ^ ((this.a ^ 1000003) * 1000003);
    }
}

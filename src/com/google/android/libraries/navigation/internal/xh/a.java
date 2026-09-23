package com.google.android.libraries.navigation.internal.xh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a extends b {
    public final boolean a;
    public final boolean b;
    public final long c;

    public a(boolean z, boolean z2, long j) {
        this.a = z;
        this.b = z2;
        this.c = j;
    }

    @Override // com.google.android.libraries.navigation.internal.xh.b
    public final long a() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.xh.b
    public final boolean b() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.xh.b
    public final boolean c() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.a == bVar.c() && this.b == bVar.b() && this.c == bVar.a()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = true != this.a ? 1237 : 1231;
        int i2 = true == this.b ? 1231 : 1237;
        long j = this.c;
        return ((((i ^ 1000003) * 1000003) ^ i2) * 1000003) ^ ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        return "ProjectProperties{isHappyMeal=" + this.a + ", canSkipToS=" + this.b + ", getProjectNumber=" + this.c + "}";
    }
}

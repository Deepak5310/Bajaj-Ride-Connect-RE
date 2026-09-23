package com.google.android.libraries.navigation.internal.bp;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class r extends bz {
    private final int a;
    private final int b;
    private final boolean c;
    private final boolean d;
    private final com.google.android.libraries.navigation.internal.yx.br e;

    public r(int i, int i2, boolean z, boolean z2, com.google.android.libraries.navigation.internal.yx.br brVar) {
        this.a = i;
        this.b = i2;
        this.c = z;
        this.d = z2;
        this.e = brVar;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.bz
    public final int a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.bz
    public final int b() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.bz
    public final com.google.android.libraries.navigation.internal.yx.br c() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.bz
    public final boolean d() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.bz
    public final boolean e() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        com.google.android.libraries.navigation.internal.yx.br brVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof bz) {
            bz bzVar = (bz) obj;
            if (this.a == bzVar.a() && this.b == bzVar.b() && this.c == bzVar.d() && this.d == bzVar.e() && ((brVar = this.e) != null ? brVar.equals(bzVar.c()) : bzVar.c() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        com.google.android.libraries.navigation.internal.yx.br brVar = this.e;
        int iHashCode = brVar == null ? 0 : brVar.hashCode();
        int i = this.a;
        int i2 = this.b;
        return iHashCode ^ ((((((((i ^ 1000003) * 1000003) ^ i2) * 1000003) ^ (true != this.c ? 1237 : 1231)) * 1000003) ^ (true == this.d ? 1231 : 1237)) * 1000003);
    }

    public final String toString() {
        return "{" + this.a + ", " + this.b + ", " + this.c + ", " + this.d + ", " + String.valueOf(this.e) + "}";
    }
}

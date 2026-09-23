package com.google.android.libraries.navigation.internal.gw;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class e extends x {
    public final Integer a;
    public final Integer b;
    private final boolean e;
    private final com.google.android.libraries.navigation.internal.o.d f;

    public e(Integer num, Integer num2, boolean z, com.google.android.libraries.navigation.internal.o.d dVar) {
        this.a = num;
        this.b = num2;
        this.e = z;
        this.f = dVar;
    }

    @Override // com.google.android.libraries.navigation.internal.gw.x
    public final com.google.android.libraries.navigation.internal.o.d a() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.gw.x
    public final Integer b() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.gw.x
    public final Integer c() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.gw.x
    public final boolean d() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.gw.x
    public final void e() {
    }

    public final boolean equals(Object obj) {
        com.google.android.libraries.navigation.internal.o.d dVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof x) {
            x xVar = (x) obj;
            Integer num = this.a;
            if (num != null ? num.equals(xVar.c()) : xVar.c() == null) {
                Integer num2 = this.b;
                if (num2 != null ? num2.equals(xVar.b()) : xVar.b() == null) {
                    xVar.e();
                    if (this.e == xVar.d() && ((dVar = this.f) != null ? dVar.equals(xVar.a()) : xVar.a() == null)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        Integer num = this.a;
        int iHashCode = num == null ? 0 : num.hashCode();
        Integer num2 = this.b;
        int iHashCode2 = (((((((iHashCode ^ 1000003) * 1000003) ^ (num2 == null ? 0 : num2.hashCode())) * 1000003) ^ 1237) * 1000003) ^ (true != this.e ? 1237 : 1231)) * 1000003;
        com.google.android.libraries.navigation.internal.o.d dVar = this.f;
        return iHashCode2 ^ (dVar != null ? dVar.hashCode() : 0);
    }

    public final String toString() {
        return "{" + this.a + ", " + this.b + ", false, " + this.e + ", " + String.valueOf(this.f) + "}";
    }
}

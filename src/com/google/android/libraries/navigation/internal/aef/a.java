package com.google.android.libraries.navigation.internal.aef;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends b {
    public final double a;
    public final double b;
    public final double c;

    public a(double d, double d2, double d3) {
        this.a = d;
        this.b = d2;
        this.c = d3;
    }

    @Override // com.google.android.libraries.navigation.internal.aef.b
    public final double a() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.aef.b
    public final double b() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.aef.b
    public final double c() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (Double.doubleToLongBits(this.a) == Double.doubleToLongBits(bVar.b()) && Double.doubleToLongBits(this.b) == Double.doubleToLongBits(bVar.c()) && Double.doubleToLongBits(this.c) == Double.doubleToLongBits(bVar.a())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        double d = this.a;
        long jDoubleToLongBits = Double.doubleToLongBits(d) ^ (Double.doubleToLongBits(d) >>> 32);
        double d2 = this.b;
        long jDoubleToLongBits2 = Double.doubleToLongBits(d2) ^ (Double.doubleToLongBits(d2) >>> 32);
        double d3 = this.c;
        return ((((((int) jDoubleToLongBits) ^ 1000003) * 1000003) ^ ((int) jDoubleToLongBits2)) * 1000003) ^ ((int) (Double.doubleToLongBits(d3) ^ (Double.doubleToLongBits(d3) >>> 32)));
    }

    public final String toString() {
        return "S2QuantizedLocation{latitude=" + this.a + ", longitude=" + this.b + ", accuracyMeters=" + this.c + "}";
    }
}

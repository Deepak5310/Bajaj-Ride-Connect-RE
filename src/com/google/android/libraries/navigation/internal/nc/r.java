package com.google.android.libraries.navigation.internal.nc;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class r extends aq {
    private final float a;

    public r(float f) {
        this.a = f;
    }

    @Override // com.google.android.libraries.navigation.internal.nc.aq
    public final float a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof aq) && Float.floatToIntBits(this.a) == Float.floatToIntBits(((aq) obj).a());
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.a) ^ 1000003;
    }

    public final String toString() {
        return "FixedFloatDimensionViewPropertyValue{value=" + this.a + "}";
    }
}

package com.google.android.libraries.navigation.internal.dq;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends h {
    private final float a;
    private final float b;
    private final float c;
    private final float d;
    private final float e;
    private final Float f;
    private final Integer g;
    private final Integer h;
    private final g i;

    public a(float f, float f2, float f3, float f4, float f5, Float f6, Integer num, Integer num2, g gVar) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.e = f5;
        this.f = f6;
        this.g = num;
        this.h = num2;
        Objects.requireNonNull(gVar);
        this.i = gVar;
    }

    @Override // com.google.android.libraries.navigation.internal.dq.h
    public final float a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.dq.h
    public final float b() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.dq.h
    public final float c() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.dq.h
    public final float d() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.dq.h
    public final float e() {
        return this.e;
    }

    public final boolean equals(Object obj) {
        Float f;
        Integer num;
        Integer num2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (Float.floatToIntBits(this.a) == Float.floatToIntBits(hVar.d()) && Float.floatToIntBits(this.b) == Float.floatToIntBits(hVar.a()) && Float.floatToIntBits(this.c) == Float.floatToIntBits(hVar.c()) && Float.floatToIntBits(this.d) == Float.floatToIntBits(hVar.b()) && Float.floatToIntBits(this.e) == Float.floatToIntBits(hVar.e()) && ((f = this.f) != null ? f.equals(hVar.g()) : hVar.g() == null) && ((num = this.g) != null ? num.equals(hVar.h()) : hVar.h() == null) && ((num2 = this.h) != null ? num2.equals(hVar.i()) : hVar.i() == null) && this.i.equals(hVar.f())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.dq.h
    public final g f() {
        return this.i;
    }

    @Override // com.google.android.libraries.navigation.internal.dq.h
    public final Float g() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.dq.h
    public final Integer h() {
        return this.g;
    }

    public final int hashCode() {
        int iFloatToIntBits = ((((((((Float.floatToIntBits(this.a) ^ 1000003) * 1000003) ^ Float.floatToIntBits(this.b)) * 1000003) ^ Float.floatToIntBits(this.c)) * 1000003) ^ Float.floatToIntBits(this.d)) * 1000003) ^ Float.floatToIntBits(this.e);
        Float f = this.f;
        int iHashCode = ((iFloatToIntBits * 1000003) ^ (f == null ? 0 : f.hashCode())) * 1000003;
        Integer num = this.g;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        Integer num2 = this.h;
        return ((iHashCode2 ^ (num2 != null ? num2.hashCode() : 0)) * 1000003) ^ this.i.hashCode();
    }

    @Override // com.google.android.libraries.navigation.internal.dq.h
    public final Integer i() {
        return this.h;
    }

    public final String toString() {
        return "{" + this.a + ", " + this.b + ", " + this.c + ", " + this.d + ", " + this.e + ", " + this.f + ", " + this.g + ", " + this.h + ", " + String.valueOf(this.i) + "}";
    }
}

package com.google.android.libraries.navigation.internal.qy;

import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends g {
    public final ev a;
    public final String b;
    public final float c;
    public final int d;
    public final int e;
    public final boolean f;
    public final int g;
    public final int h;

    public a(ev evVar, String str, float f, int i, int i2, boolean z, int i3, int i4) {
        Objects.requireNonNull(evVar);
        this.a = evVar;
        Objects.requireNonNull(str);
        this.b = str;
        this.c = f;
        this.d = i;
        this.e = i2;
        this.f = z;
        this.g = 0;
        this.h = 0;
    }

    @Override // com.google.android.libraries.navigation.internal.qy.g
    public final float a() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.qy.g
    public final int b() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.qy.g
    public final int c() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.qy.g
    public final int d() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.qy.g
    public final int e() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (hx.i(this.a, gVar.f()) && this.b.equals(gVar.g()) && Float.floatToIntBits(this.c) == Float.floatToIntBits(gVar.a()) && this.d == gVar.e() && this.e == gVar.d() && this.f == gVar.h()) {
                gVar.c();
                gVar.b();
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.qy.g
    public final ev f() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.qy.g
    public final String g() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.qy.g
    public final boolean h() {
        return this.f;
    }

    public final int hashCode() {
        return (((((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ Float.floatToIntBits(this.c)) * 1000003) ^ this.d) * 1000003) ^ this.e) * 1000003) ^ (true != this.f ? 1237 : 1231)) * (-721379959);
    }

    public final String toString() {
        return "{" + String.valueOf(this.a) + ", " + this.b + ", " + this.c + ", " + this.d + ", " + this.e + ", " + this.f + ", 0, 0}";
    }
}

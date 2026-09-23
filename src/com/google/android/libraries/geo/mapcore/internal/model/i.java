package com.google.android.libraries.geo.mapcore.internal.model;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class i extends z {
    private final String b;
    private final byte[] c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final aa h;

    public i(String str, byte[] bArr, int i, int i2, int i3, int i4, aa aaVar) {
        this.b = str;
        this.c = bArr;
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = i4;
        this.h = aaVar;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.z
    public final int a() {
        return this.g;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.z
    public final int b() {
        return this.f;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.z
    public final int c() {
        return this.e;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.z
    public final int d() {
        return this.d;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.z
    public final aa e() {
        return this.h;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof z) {
            z zVar = (z) obj;
            if (this.b.equals(zVar.f())) {
                if (Arrays.equals(this.c, zVar instanceof i ? ((i) zVar).c : zVar.g()) && this.d == zVar.d() && this.e == zVar.c() && this.f == zVar.b() && this.g == zVar.a() && this.h.equals(zVar.e())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.z
    public final String f() {
        return this.b;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.z
    public final byte[] g() {
        return this.c;
    }

    public final int hashCode() {
        return ((((((((((((this.b.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.c)) * 1000003) ^ this.d) * 1000003) ^ this.e) * 1000003) ^ this.f) * 1000003) ^ this.g) * 1000003) ^ this.h.hashCode();
    }

    public final String toString() {
        aa aaVar = this.h;
        return "{" + this.b + ", " + Arrays.toString(this.c) + ", " + this.d + ", " + this.e + ", " + this.f + ", " + this.g + ", " + String.valueOf(aaVar) + "}";
    }
}

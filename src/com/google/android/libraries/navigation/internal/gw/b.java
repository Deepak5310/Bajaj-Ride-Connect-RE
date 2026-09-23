package com.google.android.libraries.navigation.internal.gw;

import android.graphics.Bitmap;
import android.graphics.Picture;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class b extends s {
    private final Picture a;
    private final com.google.android.libraries.navigation.internal.o.d b;
    private final Bitmap.Config c;
    private final int d;
    private final int e;

    public b(Picture picture, com.google.android.libraries.navigation.internal.o.d dVar, Bitmap.Config config, int i, int i2) {
        this.a = picture;
        this.b = dVar;
        this.c = config;
        this.d = i;
        this.e = i2;
    }

    @Override // com.google.android.libraries.navigation.internal.gw.s
    public final int a() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.gw.s
    public final int b() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.gw.s
    public final Bitmap.Config c() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.gw.s
    public final Picture d() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.gw.s
    public final com.google.android.libraries.navigation.internal.o.d e() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof s) {
            s sVar = (s) obj;
            if (this.a.equals(sVar.d()) && this.b.equals(sVar.e()) && this.c.equals(sVar.c()) && this.d == sVar.b() && this.e == sVar.a()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d) * 1000003) ^ this.e;
    }

    public final String toString() {
        Bitmap.Config config = this.c;
        com.google.android.libraries.navigation.internal.o.d dVar = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(dVar) + ", " + String.valueOf(config) + ", " + this.d + ", " + this.e + "}";
    }
}

package com.google.android.libraries.navigation.internal.tu;

import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class i extends x {
    public final t a;
    public final Locale b;
    public final int c;
    public final String d;
    public final int e;

    public i(t tVar, Locale locale, int i, int i2, String str) {
        this.a = tVar;
        this.b = locale;
        this.c = i;
        this.e = i2;
        this.d = str;
    }

    @Override // com.google.android.libraries.navigation.internal.tu.x
    public final int a() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.tu.x
    public final t b() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.tu.x
    public final String c() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.tu.x
    public final Locale d() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.tu.x
    public final int e() {
        return this.e;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof x) {
            x xVar = (x) obj;
            t tVar = this.a;
            if (tVar != null ? tVar.equals(xVar.b()) : xVar.b() == null) {
                Locale locale = this.b;
                if (locale != null ? locale.equals(xVar.d()) : xVar.d() == null) {
                    if (this.c == xVar.a() && (this.e != 0 ? xVar.e() == 1 : xVar.e() == 0) && this.d.equals(xVar.c())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final String toString() {
        Locale locale = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(locale) + ", " + this.c + ", " + w.a(this.e) + ", " + this.d + "}";
    }

    public final int hashCode() {
        t tVar = this.a;
        int iHashCode = tVar == null ? 0 : tVar.hashCode();
        Locale locale = this.b;
        int iHashCode2 = locale == null ? 0 : locale.hashCode();
        int i = iHashCode ^ 1000003;
        return (((((((i * 1000003) ^ iHashCode2) * 1000003) ^ this.c) * 1000003) ^ (this.e != 0 ? 1 : 0)) * 1000003) ^ this.d.hashCode();
    }
}

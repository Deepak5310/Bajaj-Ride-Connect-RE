package com.google.android.libraries.navigation.internal.rz;

import com.google.android.libraries.navigation.internal.adr.hs;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class r extends an {
    private final am a;
    private final String b;
    private final String c;
    private final hs d;
    private final ae e;
    private final boolean f;

    public r(am amVar, String str, String str2, hs hsVar, ae aeVar, boolean z) {
        this.a = amVar;
        this.b = str;
        this.c = str2;
        this.d = hsVar;
        this.e = aeVar;
        this.f = z;
    }

    @Override // com.google.android.libraries.navigation.internal.rz.an
    public final ae a() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.rz.an
    public final am b() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.rz.an
    public final hs c() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.rz.an
    public final String d() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.rz.an
    public final String e() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof an) {
            an anVar = (an) obj;
            if (this.a.equals(anVar.b()) && this.b.equals(anVar.e()) && this.c.equals(anVar.d()) && this.d.equals(anVar.c()) && this.e.equals(anVar.a()) && this.f == anVar.f()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.rz.an
    public final boolean f() {
        return this.f;
    }

    public final int hashCode() {
        return ((((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003) ^ (true != this.f ? 1237 : 1231);
    }

    public final String toString() {
        ae aeVar = this.e;
        hs hsVar = this.d;
        return "{" + String.valueOf(this.a) + ", " + this.b + ", " + this.c + ", " + String.valueOf(hsVar) + ", " + String.valueOf(aeVar) + ", " + this.f + "}";
    }
}

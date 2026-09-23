package com.google.android.libraries.navigation.internal.px;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class u extends eb {
    public final ek a;
    public final dv b;
    public final dz c;
    public final com.google.android.libraries.navigation.internal.yx.an d;

    public u(ek ekVar, dv dvVar, dz dzVar, com.google.android.libraries.navigation.internal.yx.an anVar) {
        this.a = ekVar;
        this.b = dvVar;
        this.c = dzVar;
        this.d = anVar;
    }

    @Override // com.google.android.libraries.navigation.internal.px.eb
    public final dv a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.px.eb
    public final dz b() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.px.eb
    public final ek c() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.px.eb
    public final com.google.android.libraries.navigation.internal.yx.an d() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof eb) {
            eb ebVar = (eb) obj;
            if (this.a.equals(ebVar.c()) && this.b.equals(ebVar.a()) && this.c.equals(ebVar.b()) && this.d.equals(ebVar.d())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.an anVar = this.d;
        dz dzVar = this.c;
        dv dvVar = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(dvVar) + ", " + String.valueOf(dzVar) + ", " + String.valueOf(anVar) + "}";
    }
}

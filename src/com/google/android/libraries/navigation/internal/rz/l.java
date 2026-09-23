package com.google.android.libraries.navigation.internal.rz;

import com.google.android.libraries.navigation.internal.yx.br;
import java.util.Optional;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class l extends ag {
    public final Optional a;
    public final br b;
    public final ae c;
    private final int d;
    private final boolean e = false;
    private final boolean f = false;
    private final boolean g = false;
    private final boolean h = false;
    private final boolean i;
    private final br j;
    private final t k;
    private final String l;
    private final String m;

    public l(int i, boolean z, Optional optional, boolean z2, boolean z3, boolean z4, boolean z5, br brVar, br brVar2, ae aeVar, t tVar, String str, String str2) {
        this.d = i;
        this.a = optional;
        this.i = z5;
        this.b = brVar;
        this.j = brVar2;
        this.c = aeVar;
        this.k = tVar;
        this.l = str;
        this.m = str2;
    }

    @Override // com.google.android.libraries.navigation.internal.rz.ag
    @Deprecated
    public final int a() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.rz.ag
    public final t b() {
        return this.k;
    }

    @Override // com.google.android.libraries.navigation.internal.rz.ag
    public final ae c() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.rz.ag
    public final br d() {
        return this.j;
    }

    @Override // com.google.android.libraries.navigation.internal.rz.ag
    public final br e() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ag) {
            ag agVar = (ag) obj;
            if (this.d == agVar.a()) {
                agVar.i();
                if (this.a.equals(agVar.h())) {
                    agVar.j();
                    agVar.m();
                    agVar.l();
                    if (this.i == agVar.k() && this.b.equals(agVar.e()) && this.j.equals(agVar.d()) && this.c.equals(agVar.c()) && this.k.equals(agVar.b()) && this.l.equals(agVar.f()) && this.m.equals(agVar.g())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.rz.ag
    public final String f() {
        return this.l;
    }

    @Override // com.google.android.libraries.navigation.internal.rz.ag
    public final String g() {
        return this.m;
    }

    @Override // com.google.android.libraries.navigation.internal.rz.ag
    public final Optional h() {
        return this.a;
    }

    public final int hashCode() {
        return ((((((((((((((((((((((((this.d ^ 1000003) * 1000003) ^ 1237) * 1000003) ^ this.a.hashCode()) * 1000003) ^ 1237) * 1000003) ^ 1237) * 1000003) ^ 1237) * 1000003) ^ (true != this.i ? 1237 : 1231)) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.j.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.k.hashCode()) * 1000003) ^ this.l.hashCode()) * 1000003) ^ this.m.hashCode();
    }

    @Override // com.google.android.libraries.navigation.internal.rz.ag
    public final boolean i() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.rz.ag
    public final boolean j() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.rz.ag
    @Deprecated
    public final boolean k() {
        return this.i;
    }

    @Override // com.google.android.libraries.navigation.internal.rz.ag
    @Deprecated
    public final boolean l() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.rz.ag
    public final boolean m() {
        return false;
    }

    public final String toString() {
        t tVar = this.k;
        ae aeVar = this.c;
        br brVar = this.j;
        br brVar2 = this.b;
        return "{" + this.d + ", false, " + String.valueOf(this.a) + ", false, false, false, " + this.i + ", " + String.valueOf(brVar2) + ", " + String.valueOf(brVar) + ", " + String.valueOf(aeVar) + ", " + String.valueOf(tVar) + ", " + this.l + ", " + this.m + "}";
    }
}

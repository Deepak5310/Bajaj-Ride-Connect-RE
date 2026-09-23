package com.google.android.libraries.navigation.internal.bm;

import com.google.android.libraries.navigation.internal.aac.ca;
import com.google.android.libraries.navigation.internal.ck.cm;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a extends al {
    private final String a;
    private final cm b;
    private final ev c;
    private final boolean d;
    private final boolean e;
    private final ev f;
    private final ca g;

    public a(String str, cm cmVar, ev evVar, boolean z, boolean z2, ev evVar2, ca caVar) {
        Objects.requireNonNull(str);
        this.a = str;
        Objects.requireNonNull(cmVar);
        this.b = cmVar;
        Objects.requireNonNull(evVar);
        this.c = evVar;
        this.d = z;
        this.e = z2;
        Objects.requireNonNull(evVar2);
        this.f = evVar2;
        Objects.requireNonNull(caVar);
        this.g = caVar;
    }

    @Override // com.google.android.libraries.navigation.internal.bm.al
    public final cm a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.bm.al
    public final ev b() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.bm.al
    public final ev c() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.bm.al
    public final ca d() {
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.bm.al
    public final String e() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof al) {
            al alVar = (al) obj;
            if (this.a.equals(alVar.e()) && this.b.equals(alVar.a()) && hx.i(this.c, alVar.b()) && this.d == alVar.f() && this.e == alVar.g() && hx.i(this.f, alVar.c()) && this.g.equals(alVar.d())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.bm.al
    public final boolean f() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.bm.al
    public final boolean g() {
        return this.e;
    }

    public final int hashCode() {
        return ((((((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ (true != this.d ? 1237 : 1231)) * 1000003) ^ (true == this.e ? 1231 : 1237)) * 1000003) ^ this.f.hashCode()) * 1000003) ^ this.g.hashCode();
    }

    public final String toString() {
        ca caVar = this.g;
        ev evVar = this.f;
        ev evVar2 = this.c;
        return "{" + this.a + ", " + String.valueOf(this.b) + ", " + String.valueOf(evVar2) + ", " + this.d + ", " + this.e + ", " + String.valueOf(evVar) + ", " + String.valueOf(caVar) + "}";
    }
}

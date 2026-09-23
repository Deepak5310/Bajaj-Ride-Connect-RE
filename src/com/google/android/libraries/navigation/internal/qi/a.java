package com.google.android.libraries.navigation.internal.qi;

import com.google.android.libraries.geo.mapcore.internal.model.aq;
import com.google.android.libraries.geo.mapcore.internal.model.cg;
import com.google.android.libraries.navigation.internal.abh.bj;
import com.google.android.libraries.navigation.internal.oe.ap;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class a extends f {
    public final ap a;
    public final cg b;
    public final com.google.android.libraries.navigation.internal.rq.a c;
    public final aq d;
    public final int e;
    public final bj f;

    public a(ap apVar, cg cgVar, com.google.android.libraries.navigation.internal.rq.a aVar, aq aqVar, int i, bj bjVar) {
        Objects.requireNonNull(apVar);
        this.a = apVar;
        Objects.requireNonNull(cgVar);
        this.b = cgVar;
        Objects.requireNonNull(aVar);
        this.c = aVar;
        Objects.requireNonNull(aqVar);
        this.d = aqVar;
        this.e = i;
        this.f = null;
    }

    @Override // com.google.android.libraries.navigation.internal.qi.f
    public final int a() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.qi.f
    public final ap b() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.qi.f
    public final aq c() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.qi.f
    public final cg d() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.qi.f
    public final com.google.android.libraries.navigation.internal.rq.a e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.a.equals(fVar.b()) && this.b.equals(fVar.d()) && this.c.equals(fVar.e()) && this.d.equals(fVar.c()) && this.e == fVar.a()) {
                fVar.f();
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.qi.f
    public final bj f() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.qi.f
    public int hashCode() {
        return (((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e) * 1000003;
    }

    public String toString() {
        aq aqVar = this.d;
        com.google.android.libraries.navigation.internal.rq.a aVar = this.c;
        cg cgVar = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(cgVar) + ", " + String.valueOf(aVar) + ", " + String.valueOf(aqVar) + ", " + this.e + ", null}";
    }
}

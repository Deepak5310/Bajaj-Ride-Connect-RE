package com.google.android.libraries.navigation.internal.qq;

import com.google.android.libraries.geo.mapcore.renderer.ez;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends f {
    public final ez a;
    public final com.google.android.libraries.navigation.internal.rq.a b;
    public final com.google.android.libraries.geo.mapcore.internal.model.aq c;
    public final boolean d;
    public final e e;

    public b(ez ezVar, com.google.android.libraries.navigation.internal.rq.a aVar, com.google.android.libraries.geo.mapcore.internal.model.aq aqVar, boolean z, e eVar) {
        Objects.requireNonNull(ezVar);
        this.a = ezVar;
        Objects.requireNonNull(aVar);
        this.b = aVar;
        Objects.requireNonNull(aqVar);
        this.c = aqVar;
        this.d = z;
        this.e = eVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qq.f
    public final com.google.android.libraries.geo.mapcore.internal.model.aq a() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.qq.f
    public final e b() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.qq.f
    public final ez c() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.qq.f
    public final com.google.android.libraries.navigation.internal.rq.a d() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.qq.f
    public final boolean e() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        e eVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.a.equals(fVar.c()) && this.b.equals(fVar.d()) && this.c.equals(fVar.a()) && this.d == fVar.e() && ((eVar = this.e) != null ? eVar.equals(fVar.b()) : fVar.b() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode();
        e eVar = this.e;
        return (((iHashCode * 1000003) ^ (true != this.d ? 1237 : 1231)) * 1000003) ^ (eVar == null ? 0 : eVar.hashCode());
    }
}

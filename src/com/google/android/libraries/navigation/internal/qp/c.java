package com.google.android.libraries.navigation.internal.qp;

import com.google.android.libraries.geo.mapcore.internal.model.cd;
import com.google.android.libraries.navigation.internal.adi.an;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c extends aa {
    public final cd a;
    public final com.google.android.libraries.navigation.internal.gp.b b;
    public final com.google.android.libraries.navigation.internal.gd.h c;
    private final an d;
    private final String e;
    private final boolean f;
    private final p g;

    public c(an anVar, cd cdVar, String str, boolean z, p pVar, com.google.android.libraries.navigation.internal.gp.b bVar, com.google.android.libraries.navigation.internal.gd.h hVar) {
        Objects.requireNonNull(anVar);
        this.d = anVar;
        Objects.requireNonNull(cdVar);
        this.a = cdVar;
        Objects.requireNonNull(str);
        this.e = str;
        this.f = z;
        this.g = pVar;
        this.b = bVar;
        Objects.requireNonNull(hVar);
        this.c = hVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qp.aa
    public final com.google.android.libraries.navigation.internal.gd.h a() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.qp.aa
    public final com.google.android.libraries.navigation.internal.gp.b b() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.qp.aa
    public final cd c() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.qp.aa
    public final p d() {
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.qp.aa
    public final an e() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof aa) {
            aa aaVar = (aa) obj;
            if (this.d.equals(aaVar.e()) && this.a.equals(aaVar.c()) && this.e.equals(aaVar.f()) && this.f == aaVar.g() && this.g.equals(aaVar.d()) && this.b.equals(aaVar.b()) && this.c.equals(aaVar.a())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.qp.aa
    public final String f() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.qp.aa
    public final boolean g() {
        return this.f;
    }

    public final int hashCode() {
        return ((((((((((((this.d.hashCode() ^ 1000003) * 1000003) ^ this.a.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003) ^ (true != this.f ? 1237 : 1231)) * 1000003) ^ this.g.hashCode()) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode();
    }
}

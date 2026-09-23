package com.google.android.libraries.navigation.internal.m;

import com.google.android.libraries.navigation.internal.nc.ah;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a extends c {
    public final ah a;
    private final boolean b;

    public a(ah ahVar, boolean z) {
        this.a = ahVar;
        this.b = z;
    }

    @Override // com.google.android.libraries.navigation.internal.m.c
    protected final ah a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.m.c
    protected final boolean b() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.m.c
    protected final void c() {
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            ah ahVar = this.a;
            if (ahVar != null ? ahVar.equals(cVar.a()) : cVar.a() == null) {
                if (this.b == cVar.b()) {
                    cVar.c();
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        ah ahVar = this.a;
        return (((((ahVar == null ? 0 : ahVar.hashCode()) ^ 1000003) * 1000003) ^ (true != this.b ? 1237 : 1231)) * 1000003) ^ 1237;
    }

    public final String toString() {
        return "{" + String.valueOf(this.a) + ", " + this.b + ", false}";
    }
}

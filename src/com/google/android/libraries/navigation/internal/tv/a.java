package com.google.android.libraries.navigation.internal.tv;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends e {
    public final d a;
    public final d b;

    public a(d dVar, d dVar2) {
        this.a = dVar;
        this.b = dVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.tv.e
    public final d a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.tv.e
    public final d b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            d dVar = this.a;
            if (dVar != null ? dVar.equals(eVar.a()) : eVar.a() == null) {
                d dVar2 = this.b;
                if (dVar2 != null ? dVar2.equals(eVar.b()) : eVar.b() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String toString() {
        d dVar = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(dVar) + "}";
    }

    public final int hashCode() {
        d dVar = this.a;
        int iHashCode = dVar == null ? 0 : dVar.hashCode();
        d dVar2 = this.b;
        return ((iHashCode ^ 1000003) * 1000003) ^ (dVar2 != null ? dVar2.hashCode() : 0);
    }
}

package com.google.android.libraries.navigation.internal.sc;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class b extends d {
    private final com.google.android.libraries.navigation.internal.sd.b a;
    private final com.google.android.libraries.navigation.internal.sd.a b;

    public b(com.google.android.libraries.navigation.internal.sd.b bVar, com.google.android.libraries.navigation.internal.sd.a aVar) {
        this.a = bVar;
        this.b = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.sc.d
    public final com.google.android.libraries.navigation.internal.sd.a a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.sc.d
    public final com.google.android.libraries.navigation.internal.sd.b b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            com.google.android.libraries.navigation.internal.sd.b bVar = this.a;
            if (bVar != null ? bVar.equals(dVar.b()) : dVar.b() == null) {
                com.google.android.libraries.navigation.internal.sd.a aVar = this.b;
                if (aVar != null ? aVar.equals(dVar.a()) : dVar.a() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.sd.a aVar = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(aVar) + "}";
    }

    public final int hashCode() {
        com.google.android.libraries.navigation.internal.sd.b bVar = this.a;
        int iHashCode = bVar == null ? 0 : bVar.hashCode();
        com.google.android.libraries.navigation.internal.sd.a aVar = this.b;
        return ((iHashCode ^ 1000003) * 1000003) ^ (aVar != null ? aVar.hashCode() : 0);
    }
}

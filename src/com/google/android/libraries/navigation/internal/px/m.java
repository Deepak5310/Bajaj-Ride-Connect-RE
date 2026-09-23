package com.google.android.libraries.navigation.internal.px;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m extends cg {
    public final com.google.android.libraries.geo.mapcore.internal.model.c a;
    public final com.google.android.libraries.navigation.internal.oe.ad b;

    public m(com.google.android.libraries.geo.mapcore.internal.model.c cVar, com.google.android.libraries.navigation.internal.oe.ad adVar) {
        this.a = cVar;
        this.b = adVar;
    }

    @Override // com.google.android.libraries.navigation.internal.px.cg
    public final com.google.android.libraries.navigation.internal.oe.ad a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.px.cg
    public final com.google.android.libraries.geo.mapcore.internal.model.c b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof cg) {
            cg cgVar = (cg) obj;
            com.google.android.libraries.geo.mapcore.internal.model.c cVar = this.a;
            if (cVar != null ? cVar.equals(cgVar.b()) : cgVar.b() == null) {
                com.google.android.libraries.navigation.internal.oe.ad adVar = this.b;
                if (adVar != null ? adVar.equals(cgVar.a()) : cgVar.a() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.oe.ad adVar = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(adVar) + "}";
    }

    public final int hashCode() {
        com.google.android.libraries.geo.mapcore.internal.model.c cVar = this.a;
        int iHashCode = cVar == null ? 0 : cVar.hashCode();
        com.google.android.libraries.navigation.internal.oe.ad adVar = this.b;
        return ((iHashCode ^ 1000003) * 1000003) ^ (adVar != null ? adVar.hashCode() : 0);
    }
}

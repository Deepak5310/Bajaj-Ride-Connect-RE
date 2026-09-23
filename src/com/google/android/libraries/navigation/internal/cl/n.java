package com.google.android.libraries.navigation.internal.cl;

import com.google.android.libraries.navigation.internal.adr.cf;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class n extends bg {
    public final com.google.android.libraries.navigation.internal.ol.aq a;
    public final com.google.android.libraries.navigation.internal.oo.f b;
    private final cf c;

    public n(cf cfVar, com.google.android.libraries.navigation.internal.ol.aq aqVar, com.google.android.libraries.navigation.internal.oo.f fVar) {
        this.c = cfVar;
        this.a = aqVar;
        this.b = fVar;
    }

    @Override // com.google.android.libraries.navigation.internal.cl.bg
    public final com.google.android.libraries.navigation.internal.ol.aq a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.cl.bg
    public final com.google.android.libraries.navigation.internal.oo.f b() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.cl.bg
    public final cf c() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        com.google.android.libraries.navigation.internal.ol.aq aqVar;
        com.google.android.libraries.navigation.internal.oo.f fVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof bg) {
            bg bgVar = (bg) obj;
            if (this.c.equals(bgVar.c()) && ((aqVar = this.a) != null ? aqVar.equals(bgVar.a()) : bgVar.a() == null) && ((fVar = this.b) != null ? fVar.equals(bgVar.b()) : bgVar.b() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.c.hashCode() ^ 1000003;
        com.google.android.libraries.navigation.internal.ol.aq aqVar = this.a;
        int iHashCode2 = ((iHashCode * 1000003) ^ (aqVar == null ? 0 : aqVar.hashCode())) * 1000003;
        com.google.android.libraries.navigation.internal.oo.f fVar = this.b;
        return iHashCode2 ^ (fVar != null ? fVar.hashCode() : 0);
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.oo.f fVar = this.b;
        com.google.android.libraries.navigation.internal.ol.aq aqVar = this.a;
        return "{" + String.valueOf(this.c) + ", " + String.valueOf(aqVar) + ", " + String.valueOf(fVar) + "}";
    }
}

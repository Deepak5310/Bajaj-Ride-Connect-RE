package com.google.android.libraries.navigation.internal.rz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class j extends ae {
    private final ad a;

    public j(ad adVar) {
        this.a = adVar;
    }

    @Override // com.google.android.libraries.navigation.internal.rz.ae
    public final ad a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ae) {
            return this.a.equals(((ae) obj).a());
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "{" + String.valueOf(this.a) + "}";
    }
}

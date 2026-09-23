package com.google.android.libraries.navigation.internal.xt;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class f extends bp {
    public final com.google.android.libraries.navigation.internal.xs.k a;
    public final bq b;

    public f(com.google.android.libraries.navigation.internal.xs.k kVar, bq bqVar) {
        this.a = kVar;
        this.b = bqVar;
    }

    @Override // com.google.android.libraries.navigation.internal.xt.bp
    public final com.google.android.libraries.navigation.internal.xs.k a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.xt.bp
    public final bq b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof bp) {
            bp bpVar = (bp) obj;
            com.google.android.libraries.navigation.internal.xs.k kVar = this.a;
            if (kVar != null ? kVar.equals(bpVar.a()) : bpVar.a() == null) {
                if (this.b.equals(bpVar.b())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String toString() {
        bq bqVar = this.b;
        return "SnapshotBlobAndResult{snapshotBlob=" + String.valueOf(this.a) + ", snapshotResult=" + bqVar.toString() + "}";
    }

    public final int hashCode() {
        com.google.android.libraries.navigation.internal.xs.k kVar = this.a;
        return (((kVar == null ? 0 : kVar.hashCode()) ^ 1000003) * 1000003) ^ this.b.hashCode();
    }
}

package com.google.android.libraries.navigation.internal.rz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class h extends ab {
    private final z a;
    private final aa b;
    private final boolean c;

    public h(z zVar, aa aaVar, boolean z) {
        this.a = zVar;
        this.b = aaVar;
        this.c = z;
    }

    @Override // com.google.android.libraries.navigation.internal.rz.ab
    public final z a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.rz.ab
    public final aa b() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.rz.ab
    public final boolean c() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ab) {
            ab abVar = (ab) obj;
            if (this.a.equals(abVar.a()) && this.b.equals(abVar.b()) && this.c == abVar.c()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ (true != this.c ? 1237 : 1231);
    }

    public final String toString() {
        aa aaVar = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(aaVar) + ", " + this.c + "}";
    }
}

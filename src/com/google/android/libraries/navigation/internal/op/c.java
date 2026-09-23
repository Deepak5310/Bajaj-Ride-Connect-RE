package com.google.android.libraries.navigation.internal.op;

import com.google.android.libraries.navigation.internal.yz.fd;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c extends j {
    private final g a;
    private final fd b;

    public c(g gVar, fd fdVar) {
        Objects.requireNonNull(gVar);
        this.a = gVar;
        Objects.requireNonNull(fdVar);
        this.b = fdVar;
    }

    @Override // com.google.android.libraries.navigation.internal.op.j
    public final g a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.op.j
    public final fd b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            if (this.a.equals(jVar.a()) && this.b.equals(jVar.b())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public final String toString() {
        fd fdVar = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(fdVar) + "}";
    }
}

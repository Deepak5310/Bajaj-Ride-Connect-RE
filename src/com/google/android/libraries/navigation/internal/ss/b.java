package com.google.android.libraries.navigation.internal.ss;

import com.google.android.libraries.navigation.internal.si.h;
import java.util.Objects;
import java.util.Optional;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends e {
    private final Optional a;
    private final boolean b;
    private final h c;

    public b(Optional optional, boolean z, h hVar) {
        Objects.requireNonNull(optional);
        this.a = optional;
        this.b = z;
        Objects.requireNonNull(hVar);
        this.c = hVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ss.e
    public final h c() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.ss.e
    public final Optional d() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ss.e
    public final boolean e() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.a.equals(eVar.d()) && this.b == eVar.e() && this.c.equals(eVar.c())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ (true != this.b ? 1237 : 1231)) * 1000003) ^ this.c.hashCode();
    }

    public final String toString() {
        h hVar = this.c;
        return "{" + String.valueOf(this.a) + ", " + this.b + ", " + hVar.toString() + "}";
    }
}

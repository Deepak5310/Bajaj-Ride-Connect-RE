package com.google.android.libraries.navigation.internal.bp;

import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.hx;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n extends bl {
    public final ev a;
    public final ev b;
    private final fd c;

    public n(ev evVar, ev evVar2, fd fdVar) {
        Objects.requireNonNull(evVar);
        this.a = evVar;
        Objects.requireNonNull(evVar2);
        this.b = evVar2;
        Objects.requireNonNull(fdVar);
        this.c = fdVar;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.bl
    public final ev a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.bl
    public final ev b() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.bl
    public final fd c() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof bl) {
            bl blVar = (bl) obj;
            if (hx.i(this.a, blVar.b()) && hx.i(this.b, blVar.a()) && this.c.equals(blVar.c())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode();
    }

    public final String toString() {
        fd fdVar = this.c;
        ev evVar = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(evVar) + ", " + String.valueOf(fdVar) + "}";
    }
}

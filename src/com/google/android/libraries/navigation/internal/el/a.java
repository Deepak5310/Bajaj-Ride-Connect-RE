package com.google.android.libraries.navigation.internal.el;

import com.google.android.libraries.navigation.internal.ee.u;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends b {
    private final u a;
    private final boolean b;
    private final boolean c;
    private final boolean d;

    public a(u uVar, boolean z, boolean z2, boolean z3) {
        Objects.requireNonNull(uVar);
        this.a = uVar;
        this.b = z;
        this.c = z2;
        this.d = z3;
    }

    @Override // com.google.android.libraries.navigation.internal.el.b
    public final u a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.el.b
    public final boolean b() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.el.b
    public final boolean c() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.el.b
    public final boolean d() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.a.equals(bVar.a()) && this.b == bVar.b() && this.c == bVar.c() && this.d == bVar.d()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ (true != this.b ? 1237 : 1231)) * 1000003) ^ (true != this.c ? 1237 : 1231)) * 1000003) ^ (true == this.d ? 1231 : 1237);
    }

    public final String toString() {
        return "{" + this.a.toString() + ", " + this.b + ", " + this.c + ", " + this.d + "}";
    }
}

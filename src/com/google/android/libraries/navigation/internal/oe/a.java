package com.google.android.libraries.navigation.internal.oe;

import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends ae {
    private final x a;
    private final x b;
    private final List c;

    public a(x xVar, x xVar2, List list) {
        Objects.requireNonNull(xVar);
        this.a = xVar;
        Objects.requireNonNull(xVar2);
        this.b = xVar2;
        Objects.requireNonNull(list);
        this.c = list;
    }

    @Override // com.google.android.libraries.navigation.internal.oe.ae
    public final x a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.oe.ae
    public final x b() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.oe.ae
    public final List c() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ae) {
            ae aeVar = (ae) obj;
            if (this.a.equals(aeVar.b()) && this.b.equals(aeVar.a()) && this.c.equals(aeVar.c())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode();
    }

    public final String toString() {
        List list = this.c;
        x xVar = this.b;
        return "{" + this.a.toString() + ", " + xVar.toString() + ", " + list.toString() + "}";
    }
}

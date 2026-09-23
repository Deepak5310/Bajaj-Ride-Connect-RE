package com.google.android.libraries.navigation.internal.su;

import com.google.android.libraries.navigation.internal.ady.al;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class b extends d {
    private final al a;
    private final List b;

    public b(al alVar, List list) {
        this.a = alVar;
        this.b = list;
    }

    @Override // com.google.android.libraries.navigation.internal.su.d
    public final al a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.su.d
    public final List b() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.su.d
    public final void c() {
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (this.a.equals(dVar.a()) && this.b.equals(dVar.b())) {
                dVar.c();
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ 1237;
    }

    public final String toString() {
        List list = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(list) + ", false}";
    }
}

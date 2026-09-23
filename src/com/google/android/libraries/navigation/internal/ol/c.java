package com.google.android.libraries.navigation.internal.ol;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c extends al {
    private final com.google.android.libraries.navigation.internal.o.c a;
    private final com.google.android.libraries.navigation.internal.yx.an b;
    private final com.google.android.libraries.navigation.internal.yx.an c;

    public c(com.google.android.libraries.navigation.internal.o.c cVar, com.google.android.libraries.navigation.internal.yx.an anVar, com.google.android.libraries.navigation.internal.yx.an anVar2) {
        Objects.requireNonNull(cVar);
        this.a = cVar;
        Objects.requireNonNull(anVar);
        this.b = anVar;
        Objects.requireNonNull(anVar2);
        this.c = anVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.al
    public final com.google.android.libraries.navigation.internal.o.c a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.al
    public final com.google.android.libraries.navigation.internal.yx.an b() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.al
    public final com.google.android.libraries.navigation.internal.yx.an c() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof al) {
            al alVar = (al) obj;
            if (this.a.equals(alVar.a()) && this.b.equals(alVar.b()) && this.c.equals(alVar.c())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode();
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.an anVar = this.c;
        com.google.android.libraries.navigation.internal.yx.an anVar2 = this.b;
        return "{" + this.a.toString() + ", " + anVar2.toString() + ", " + anVar.toString() + "}";
    }
}

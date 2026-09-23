package com.google.android.libraries.navigation.internal.jy;

import com.google.android.libraries.navigation.internal.yx.an;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c extends m {
    public final com.google.android.libraries.navigation.internal.kb.c a;
    private final l b;
    private final an c;

    public c(com.google.android.libraries.navigation.internal.kb.c cVar, l lVar, an anVar) {
        Objects.requireNonNull(cVar);
        this.a = cVar;
        Objects.requireNonNull(lVar);
        this.b = lVar;
        Objects.requireNonNull(anVar);
        this.c = anVar;
    }

    @Override // com.google.android.libraries.navigation.internal.jy.m
    public final l a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.jy.m
    public final com.google.android.libraries.navigation.internal.kb.c b() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.jy.m
    public final an c() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (this.a.equals(mVar.b()) && this.b.equals(mVar.a()) && this.c.equals(mVar.c())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode();
    }

    public final String toString() {
        an anVar = this.c;
        l lVar = this.b;
        return "{" + String.valueOf(this.a) + ", " + lVar.toString() + ", " + anVar.toString() + "}";
    }
}

package com.google.android.libraries.navigation.internal.px;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class y extends en {
    private final com.google.android.libraries.navigation.internal.adg.dy a;
    private final int b;
    private final int c;
    private final com.google.android.libraries.navigation.internal.yx.an d;

    public y(com.google.android.libraries.navigation.internal.adg.dy dyVar, int i, int i2, com.google.android.libraries.navigation.internal.yx.an anVar) {
        Objects.requireNonNull(dyVar);
        this.a = dyVar;
        this.b = i;
        this.c = i2;
        Objects.requireNonNull(anVar);
        this.d = anVar;
    }

    @Override // com.google.android.libraries.navigation.internal.px.en
    public final int a() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.px.en
    public final int b() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.px.en
    public final com.google.android.libraries.navigation.internal.yx.an c() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.px.en
    public final com.google.android.libraries.navigation.internal.adg.dy d() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof en) {
            en enVar = (en) obj;
            if (this.a.equals(enVar.d()) && this.b == enVar.b() && this.c == enVar.a() && this.d.equals(enVar.c())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c) * 1000003) ^ this.d.hashCode();
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.an anVar = this.d;
        return "{" + this.a.toString() + ", " + this.b + ", " + this.c + ", " + anVar.toString() + "}";
    }
}

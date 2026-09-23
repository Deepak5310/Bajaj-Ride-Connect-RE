package com.google.android.libraries.navigation.internal.kh;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a extends h {
    private final String a;
    private final com.google.android.libraries.navigation.internal.ke.c b;

    public a(String str, com.google.android.libraries.navigation.internal.ke.c cVar) {
        Objects.requireNonNull(str);
        this.a = str;
        Objects.requireNonNull(cVar);
        this.b = cVar;
    }

    @Override // com.google.android.libraries.navigation.internal.kh.h
    public final com.google.android.libraries.navigation.internal.ke.c a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.kh.h
    public final String b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (this.a.equals(hVar.b()) && this.b.equals(hVar.a())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public final String toString() {
        return "{" + this.a + ", " + String.valueOf(this.b) + "}";
    }
}

package com.google.android.libraries.navigation.internal.fz;

import com.google.android.libraries.navigation.internal.ael.cz;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends c {
    public final String a;
    public final cz b;

    public a(String str, cz czVar) {
        Objects.requireNonNull(str);
        this.a = str;
        Objects.requireNonNull(czVar);
        this.b = czVar;
    }

    @Override // com.google.android.libraries.navigation.internal.fz.c
    public final cz a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.fz.c
    public final String b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.a.equals(cVar.b()) && this.b.equals(cVar.a())) {
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

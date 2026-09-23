package com.google.android.libraries.navigation.internal.ee;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends o {
    public final String a;
    public final int b;

    public e(String str, int i) {
        Objects.requireNonNull(str);
        this.a = str;
        this.b = i;
    }

    @Override // com.google.android.libraries.navigation.internal.ee.o
    public final int a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ee.o
    public final String b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            if (this.a.equals(oVar.b()) && this.b == oVar.a()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b;
    }

    public final String toString() {
        return "{" + this.a + ", " + this.b + "}";
    }
}

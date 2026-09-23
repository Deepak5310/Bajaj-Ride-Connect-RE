package com.google.android.libraries.navigation.internal.vg;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends b {
    public final String a;
    public final String b;

    public a(String str, String str2) {
        Objects.requireNonNull(str);
        this.a = str;
        Objects.requireNonNull(str2);
        this.b = str2;
    }

    @Override // com.google.android.libraries.navigation.internal.vg.b
    public final String a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.vg.b
    public final String b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.a.equals(bVar.b()) && this.b.equals(bVar.a())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public final String toString() {
        return "{" + this.a + ", " + this.b + "}";
    }
}

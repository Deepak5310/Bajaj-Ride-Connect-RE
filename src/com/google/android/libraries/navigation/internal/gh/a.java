package com.google.android.libraries.navigation.internal.gh;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends b {
    public final Object a;
    private final String b;

    public a(String str, Object obj) {
        Objects.requireNonNull(str);
        this.b = str;
        Objects.requireNonNull(obj);
        this.a = obj;
    }

    @Override // com.google.android.libraries.navigation.internal.gh.b
    public final Object a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.gh.b
    public final String b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.b.equals(bVar.b()) && this.a.equals(bVar.a())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.b.hashCode() ^ 1000003) * 1000003) ^ this.a.hashCode();
    }

    public final String toString() {
        return "{" + this.b + ", " + String.valueOf(this.a) + "}";
    }
}

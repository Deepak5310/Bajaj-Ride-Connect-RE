package com.google.android.libraries.navigation.internal.po;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g extends eq {
    public final com.google.android.libraries.navigation.internal.qq.f a;
    public final int b;

    public g(com.google.android.libraries.navigation.internal.qq.f fVar, int i) {
        this.a = fVar;
        this.b = i;
    }

    @Override // com.google.android.libraries.navigation.internal.po.eq
    public final int a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.po.eq
    public final com.google.android.libraries.navigation.internal.qq.f b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof eq) {
            eq eqVar = (eq) obj;
            if (this.a.equals(eqVar.b()) && this.b == eqVar.a()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b;
    }

    public final String toString() {
        return "{" + String.valueOf(this.a) + ", " + this.b + "}";
    }
}

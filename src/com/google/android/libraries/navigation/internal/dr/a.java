package com.google.android.libraries.navigation.internal.dr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a extends w {
    private final int a;
    private final boolean b;

    public a(int i, boolean z) {
        this.a = i;
        this.b = z;
    }

    @Override // com.google.android.libraries.navigation.internal.dr.w
    public final int a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.dr.w
    public final boolean b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof w) {
            w wVar = (w) obj;
            if (this.a == wVar.a() && this.b == wVar.b()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (true != this.b ? 1237 : 1231) ^ ((this.a ^ 1000003) * 1000003);
    }

    public final String toString() {
        return "{" + this.a + ", " + this.b + "}";
    }
}

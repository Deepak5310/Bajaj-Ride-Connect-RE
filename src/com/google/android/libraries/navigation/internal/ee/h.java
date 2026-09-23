package com.google.android.libraries.navigation.internal.ee;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h extends w {
    public final int a;
    private final q b;

    public h(int i, q qVar) {
        this.a = i;
        this.b = qVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ee.w
    public final int a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ee.w
    public final q b() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ee.w
    public final void c() {
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof w) {
            w wVar = (w) obj;
            if (this.a == wVar.a() && this.b.equals(wVar.b())) {
                wVar.c();
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.a ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ 1237;
    }

    public final String toString() {
        return "{" + this.a + ", " + String.valueOf(this.b) + ", false}";
    }
}

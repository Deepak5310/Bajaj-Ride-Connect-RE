package com.google.android.libraries.navigation.internal.io;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends b {
    public final boolean a;
    private final String d = "";
    private final boolean e;

    public a(boolean z, String str, boolean z2) {
        this.a = z;
        this.e = z2;
    }

    @Override // com.google.android.libraries.navigation.internal.io.b
    public final String a() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.io.b
    public final boolean b() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.io.b
    public final boolean c() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.a == bVar.c() && this.d.equals(bVar.a()) && this.e == bVar.b()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((((true != this.a ? 1237 : 1231) ^ 1000003) * 1000003) ^ this.d.hashCode()) * 1000003) ^ (true == this.e ? 1231 : 1237);
    }

    public final String toString() {
        return "{" + this.a + ", " + this.d + ", " + this.e + "}";
    }
}

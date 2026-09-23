package com.google.android.libraries.navigation.internal.rz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends t {
    private final String a;
    private final String b;
    private final String c;
    private final int d = 0;

    public b(String str, String str2, String str3, int i) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // com.google.android.libraries.navigation.internal.rz.t
    public final int a() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.rz.t
    public final String b() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.rz.t
    public final String c() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.rz.t
    public final String d() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof t) {
            t tVar = (t) obj;
            if (this.a.equals(tVar.c()) && this.b.equals(tVar.b()) && this.c.equals(tVar.d())) {
                tVar.a();
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003;
    }

    public final String toString() {
        return "{" + this.a + ", " + this.b + ", " + this.c + ", 0}";
    }
}

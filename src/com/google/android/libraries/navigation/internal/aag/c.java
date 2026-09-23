package com.google.android.libraries.navigation.internal.aag;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c extends l {
    private final String a;
    private final int b;
    private final int c;

    public c(String str, int i, int i2) {
        if (str == null) {
            throw new NullPointerException("Null host");
        }
        this.a = str;
        this.b = i;
        this.c = i2;
    }

    @Override // com.google.android.libraries.navigation.internal.aag.l
    public final int a() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.aag.l
    public final int b() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.aag.l
    public final String c() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (this.a.equals(lVar.c()) && this.b == lVar.b() && this.c == lVar.a()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c;
    }

    public final String toString() {
        return "QuicHint{host=" + this.a + ", port=" + this.b + ", alternatePort=" + this.c + "}";
    }
}

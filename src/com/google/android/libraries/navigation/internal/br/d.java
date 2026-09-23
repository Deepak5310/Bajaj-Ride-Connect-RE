package com.google.android.libraries.navigation.internal.br;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends k {
    public final String a;
    public final String b;

    public d(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    @Override // com.google.android.libraries.navigation.internal.br.k
    public final String a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.br.k
    public final String b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            String str = this.a;
            if (str != null ? str.equals(kVar.a()) : kVar.a() == null) {
                String str2 = this.b;
                if (str2 != null ? str2.equals(kVar.b()) : kVar.b() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = str == null ? 0 : str.hashCode();
        String str2 = this.b;
        return ((iHashCode ^ 1000003) * 1000003) ^ (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        return "{" + this.a + ", " + this.b + "}";
    }
}

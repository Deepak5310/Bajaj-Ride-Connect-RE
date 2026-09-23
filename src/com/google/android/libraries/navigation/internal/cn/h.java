package com.google.android.libraries.navigation.internal.cn;

import com.google.android.libraries.navigation.internal.aaq.an;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h extends u {
    private final String a;
    private final int b;
    private final int c;
    private final an d;
    private final com.google.android.libraries.navigation.internal.acg.c e;

    public h(String str, int i, int i2, an anVar, com.google.android.libraries.navigation.internal.acg.c cVar) {
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = anVar;
        this.e = cVar;
    }

    @Override // com.google.android.libraries.navigation.internal.cn.u
    public final int a() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.cn.u
    public final int b() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.cn.u
    public final an c() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.cn.u
    public final com.google.android.libraries.navigation.internal.acg.c d() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.cn.u
    public final String e() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        an anVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof u) {
            u uVar = (u) obj;
            if (this.a.equals(uVar.e()) && this.b == uVar.b() && this.c == uVar.a() && ((anVar = this.d) != null ? anVar.equals(uVar.c()) : uVar.c() == null) && this.e.equals(uVar.d())) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.acg.c cVar = this.e;
        return "{" + this.a + ", " + this.b + ", " + this.c + ", " + String.valueOf(this.d) + ", " + String.valueOf(cVar) + "}";
    }

    public final int hashCode() {
        int iN;
        int iHashCode = this.a.hashCode() ^ 1000003;
        an anVar = this.d;
        if (anVar == null) {
            iN = 0;
        } else if (anVar.H()) {
            iN = anVar.n();
        } else {
            int iN2 = anVar.ak;
            if (iN2 == 0) {
                iN2 = anVar.n();
                anVar.ak = iN2;
            }
            iN = iN2;
        }
        return (((((((iHashCode * 1000003) ^ this.b) * 1000003) ^ this.c) * 1000003) ^ iN) * 1000003) ^ this.e.hashCode();
    }
}

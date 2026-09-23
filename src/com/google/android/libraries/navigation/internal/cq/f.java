package com.google.android.libraries.navigation.internal.cq;

import com.google.android.libraries.navigation.internal.aaq.an;
import com.google.android.libraries.navigation.internal.adg.ex;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f extends ac {
    public final k a;
    public final ex b = null;
    private final int c;
    private final int d;
    private final String e;
    private final an f;

    public f(int i, int i2, String str, k kVar, ex exVar, an anVar) {
        this.c = i;
        this.d = i2;
        this.e = str;
        this.a = kVar;
        this.f = anVar;
    }

    @Override // com.google.android.libraries.navigation.internal.cq.ac
    public final int a() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.cq.ac
    public final int b() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.cq.ac
    public final k c() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.cq.ac
    public final an d() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.cq.ac
    public final ex e() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ac) {
            ac acVar = (ac) obj;
            if (this.c == acVar.b() && this.d == acVar.a() && this.e.equals(acVar.f()) && this.a.equals(acVar.c())) {
                acVar.e();
                an anVar = this.f;
                if (anVar != null ? anVar.equals(acVar.d()) : acVar.d() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.cq.ac
    public final String f() {
        return this.e;
    }

    public final int hashCode() {
        int iN;
        int iHashCode = ((((((this.c ^ 1000003) * 1000003) ^ this.d) * 1000003) ^ this.e.hashCode()) * 1000003) ^ this.a.hashCode();
        an anVar = this.f;
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
        return (iHashCode * (-721379959)) ^ iN;
    }

    public final String toString() {
        an anVar = this.f;
        return "{" + this.c + ", " + this.d + ", " + this.e + ", " + String.valueOf(this.a) + ", null, " + String.valueOf(anVar) + "}";
    }
}

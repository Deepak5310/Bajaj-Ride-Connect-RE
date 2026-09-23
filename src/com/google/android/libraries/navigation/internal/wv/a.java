package com.google.android.libraries.navigation.internal.wv;

import com.google.android.libraries.navigation.internal.aba.f;
import com.google.android.libraries.navigation.internal.aba.h;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends b {
    private final f a;
    private final h b;

    public a(f fVar, h hVar) {
        if (fVar == null) {
            throw new NullPointerException("Null signedOutState");
        }
        this.a = fVar;
        if (hVar == null) {
            throw new NullPointerException("Null signedOutStateResponse");
        }
        this.b = hVar;
    }

    @Override // com.google.android.libraries.navigation.internal.wv.b
    public final f a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.wv.b
    public final h b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.a.equals(bVar.a()) && this.b.equals(bVar.b())) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        h hVar = this.b;
        return "SignedOutStateHandler{signedOutState=" + this.a.toString() + ", signedOutStateResponse=" + hVar.toString() + "}";
    }

    public final int hashCode() {
        int iN;
        int iN2;
        f fVar = this.a;
        if (fVar.H()) {
            iN = fVar.n();
        } else {
            int iN3 = fVar.ak;
            if (iN3 == 0) {
                iN3 = fVar.n();
                fVar.ak = iN3;
            }
            iN = iN3;
        }
        h hVar = this.b;
        if (hVar.H()) {
            iN2 = hVar.n();
        } else {
            int iN4 = hVar.ak;
            if (iN4 == 0) {
                iN4 = hVar.n();
                hVar.ak = iN4;
            }
            iN2 = iN4;
        }
        return ((iN ^ 1000003) * 1000003) ^ iN2;
    }
}

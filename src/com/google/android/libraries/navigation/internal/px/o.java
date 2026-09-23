package com.google.android.libraries.navigation.internal.px;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o extends cp {
    private final com.google.android.libraries.navigation.internal.adl.u a;
    private final byte[] b;
    private final String c = null;

    public o(com.google.android.libraries.navigation.internal.adl.u uVar, byte[] bArr, String str) {
        this.a = uVar;
        this.b = bArr;
    }

    @Override // com.google.android.libraries.navigation.internal.px.cp
    public final com.google.android.libraries.navigation.internal.adl.u a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.px.cp
    public final String b() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.px.cp
    public final byte[] c() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof cp) {
            cp cpVar = (cp) obj;
            if (this.a.equals(cpVar.a())) {
                if (Arrays.equals(this.b, cpVar instanceof o ? ((o) cpVar).b : cpVar.c())) {
                    cpVar.b();
                    return true;
                }
            }
        }
        return false;
    }

    public final String toString() {
        byte[] bArr = this.b;
        return "{" + String.valueOf(this.a) + ", " + Arrays.toString(bArr) + ", null}";
    }

    public final int hashCode() {
        int iN;
        com.google.android.libraries.navigation.internal.adl.u uVar = this.a;
        if (uVar.H()) {
            iN = uVar.n();
        } else {
            int iN2 = uVar.ak;
            if (iN2 == 0) {
                iN2 = uVar.n();
                uVar.ak = iN2;
            }
            iN = iN2;
        }
        return (((iN ^ 1000003) * 1000003) ^ Arrays.hashCode(this.b)) * 1000003;
    }
}

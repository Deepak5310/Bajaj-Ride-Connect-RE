package com.google.android.libraries.geo.mapcore.renderer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class fb extends fe {
    private final byte[] d;

    public fb(byte[] bArr, int i, int i2) {
        super(bArr.length, 1, i, i2);
        this.d = bArr;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.fe
    public final bw a(bv bvVar, String str) {
        bw bwVarF = bvVar.f(str);
        bvVar.k(bwVarF);
        byte[] bArr = this.d;
        int i = this.a;
        bvVar.s(34962, i, bvVar.F(bArr, i), 35044);
        bvVar.z();
        return bwVarF;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.fe
    public final bw b(bv bvVar, String str, bq bqVar, int i) {
        return bqVar.c(i, bvVar, str, this.d, this.a);
    }
}

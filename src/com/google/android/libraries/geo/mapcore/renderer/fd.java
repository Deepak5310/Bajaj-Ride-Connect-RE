package com.google.android.libraries.geo.mapcore.renderer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class fd extends fe {
    private final int[] d;

    public fd(int[] iArr, int i, int i2) {
        super(iArr.length, 4, i, i2);
        this.d = iArr;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.fe
    public final bw a(bv bvVar, String str) {
        bw bwVarF = bvVar.f(str);
        bvVar.k(bwVarF);
        bvVar.L(34962, this.d, this.a);
        bvVar.z();
        return bwVarF;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.fe
    public final bw b(bv bvVar, String str, bq bqVar, int i) {
        return bqVar.e(i, bvVar, str, this.d, this.a);
    }
}

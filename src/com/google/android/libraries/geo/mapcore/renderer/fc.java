package com.google.android.libraries.geo.mapcore.renderer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class fc extends fe {
    private final float[] d;

    public fc(float[] fArr, int i, int i2) {
        super(fArr.length, 4, i, i2);
        this.d = fArr;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.fe
    public final bw a(bv bvVar, String str) {
        bw bwVarF = bvVar.f(str);
        bvVar.k(bwVarF);
        bvVar.K(this.d, this.a);
        bvVar.z();
        return bwVarF;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.fe
    public final bw b(bv bvVar, String str, bq bqVar, int i) {
        return bqVar.d(i, bvVar, str, this.d, this.a);
    }
}

package com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable;

import com.google.android.libraries.geo.mapcore.internal.model.ce;
import com.google.android.libraries.geo.mapcore.renderer.ey;
import com.google.android.libraries.navigation.internal.agi.bt;
import com.google.android.libraries.navigation.internal.agi.bu;
import com.google.android.libraries.navigation.internal.agi.bv;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class i extends k {
    private final float b;

    public i(ey eyVar, float f) {
        super(eyVar);
        this.b = f;
    }

    static i e(j jVar, ce ceVar) {
        float fMax = Math.max(jVar.d, 1.0f);
        n nVar = jVar.b;
        int iC = nVar.c() / 16;
        bt btVar = bv.a;
        return new i(f(new bu(nVar), fMax, iC + iC, false), (2048.0f / nVar.c()) / (256 << Math.max(ceVar.a(), 4)));
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.k
    public final float a(int i) {
        return (1.0f - b(i)) * 0.5f;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.k
    public final float b(int i) {
        return (i / 1.3333334f) + 1.0f;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.k
    public final float c() {
        return this.b;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.k
    public final float d(n nVar) {
        return 0.0f;
    }
}

package com.google.android.libraries.navigation.internal.qc;

import com.google.android.libraries.geo.mapcore.internal.model.ai;
import com.google.android.libraries.geo.mapcore.renderer.er;
import com.google.android.libraries.geo.mapcore.renderer.et;
import com.google.android.libraries.navigation.internal.yz.ev;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h extends i {
    private final com.google.android.libraries.navigation.internal.qe.b a;
    private final String b;
    private final ai c;
    private final int d;
    private final float e;
    private final float f;

    public h(com.google.android.libraries.navigation.internal.qe.b bVar, String str, ai aiVar, int i, float[] fArr) {
        super(fArr[0], fArr[1]);
        this.a = bVar;
        this.b = str;
        this.c = aiVar;
        this.d = i;
        this.e = fArr[2];
        this.f = fArr[3];
    }

    @Override // com.google.android.libraries.navigation.internal.qc.i
    public final float c() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.qc.i
    public final et j() {
        er erVarA = this.a.a(this.b, this.c, this.d);
        if (erVarA != null) {
            return new et(ev.q(erVarA));
        }
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.qc.i
    public final float k() {
        return this.f;
    }
}

package com.google.android.libraries.navigation.internal.abt;

import android.opengl.Matrix;
import com.google.android.libraries.navigation.internal.abf.aj;
import com.google.android.libraries.navigation.internal.abf.r;
import com.google.android.libraries.navigation.internal.abf.s;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n {
    public final String a;
    public final float b;
    public final float c;
    public final float d;
    public final float[] e;
    public final float[] f;
    public final float[] g;

    public n(String str, float f, float f2, float f3) {
        s.k(str, "panoId");
        this.a = str;
        s.i(f, "sceneCameraBearingDeg cannot be NaN");
        this.b = f;
        s.i(f2, "sceneTiltYawDeg cannot be NaN");
        this.c = f2;
        s.i(f3, "sceneTiltPitchDeg cannot be NaN");
        this.d = f3;
        float[] fArr = new float[16];
        this.e = fArr;
        Matrix.setIdentityM(fArr, 0);
        double radians = Math.toRadians(f2);
        Matrix.rotateM(fArr, 0, -f3, (float) (-Math.cos(radians)), 0.0f, (float) (-Math.sin(radians)));
        float[] fArr2 = new float[16];
        this.f = fArr2;
        Matrix.setIdentityM(fArr2, 0);
        Matrix.rotateM(fArr2, 0, -f, 0.0f, 1.0f, 0.0f);
        float[] fArr3 = new float[16];
        this.g = fArr3;
        Matrix.multiplyMM(fArr3, 0, fArr, 0, fArr2, 0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return r.a(this.a, nVar.a) && r.a(Float.valueOf(this.b), Float.valueOf(nVar.b)) && r.a(Float.valueOf(this.c), Float.valueOf(nVar.c)) && r.a(Float.valueOf(this.d), Float.valueOf(nVar.d));
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Float.valueOf(this.b), Float.valueOf(this.c), Float.valueOf(this.d)});
    }

    public final String toString() {
        aj ajVarF = aj.f(this);
        ajVarF.g("panoId", this.a);
        return ajVarF.b("sceneCameraBearingDeg", this.b).b("sceneTiltYawDeg", this.c).b("sceneTiltPitchDeg", this.d).toString();
    }
}

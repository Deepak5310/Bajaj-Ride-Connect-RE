package com.google.android.libraries.navigation.internal.df;

import android.hardware.GeomagneticField;
import android.hardware.SensorManager;
import com.google.android.libraries.navigation.internal.de.x;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends a {
    public final float[] w = new float[4];
    public final x x = new x();
    public final x y = new x();

    public b(float f, float f2, float f3, long j) {
        e(f, f2, f3, j);
    }

    @Override // com.google.android.libraries.navigation.internal.df.a
    public final float a(int i, float[] fArr) {
        if (i == 0) {
            return d.b(((float) Math.toDegrees(Math.atan2(fArr[0], fArr[3]))) - 90.0f, -180.0f, 180.0f);
        }
        float[] fArr2 = new float[9];
        int i2 = 129;
        int i3 = 2;
        if (i == 1) {
            i3 = 129;
            i2 = 2;
        } else if (i == 2) {
            i3 = 130;
        } else if (i != 3) {
            i2 = 1;
        } else {
            i3 = 1;
            i2 = 130;
        }
        SensorManager.remapCoordinateSystem(fArr, i2, i3, fArr2);
        return d.b(((float) Math.toDegrees(Math.atan2(fArr2[0], fArr2[3]))) - 90.0f, -180.0f, 180.0f);
    }

    @Override // com.google.android.libraries.navigation.internal.df.a
    public final void e(float f, float f2, float f3, long j) {
        float fieldStrength = 45.0f;
        if (!Float.isNaN(f) && !Float.isNaN(f2) && !Float.isNaN(f3) && f3 >= 0.0f) {
            fieldStrength = (float) (((double) new GeomagneticField(f, f2, f3, j).getFieldStrength()) / 1000.0d);
            this.t = fieldStrength;
        }
        f fVar = this.s;
        if (fVar == null) {
            this.s = new f(fieldStrength);
            return;
        }
        fVar.d = Float.NaN;
        fVar.e = Float.NaN;
        fVar.g = Float.NaN;
        fVar.i = Float.NaN;
        fVar.l = Float.NaN;
        fVar.m = Float.NaN;
        fVar.f393n.d();
        fVar.o.d();
        fVar.p.d();
        fVar.c = fieldStrength;
        fVar.q = true;
    }
}

package com.google.android.libraries.navigation.internal.abh;

import android.graphics.Bitmap;
import android.graphics.Color;
import com.bumptech.glide.Registry;
import com.google.maps.api.android.lib6.common.apiexception.ApiIllegalArgumentException;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p extends x {
    private final x a;
    private final float b;

    public p(x xVar, float f) {
        boolean z = false;
        if (f >= 0.0f && f < 360.0f) {
            z = true;
        }
        com.google.android.libraries.navigation.internal.abf.t.a(z, String.format("Invalid hue [%s] outside range [0.0,360.0)", Float.valueOf(f)));
        com.google.android.libraries.navigation.internal.abf.s.k(xVar, "baseBitmapDescriptorImpl");
        this.a = xVar;
        this.b = f;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.x
    public final Bitmap a(be beVar) {
        Bitmap bitmapA = this.a.a(beVar);
        com.google.android.libraries.navigation.internal.abf.s.k(bitmapA, Registry.BUCKET_BITMAP);
        int height = bitmapA.getHeight();
        int width = bitmapA.getWidth();
        int i = height * width;
        int[] iArr = new int[i];
        bitmapA.getPixels(iArr, 0, width, 0, 0, width, height);
        int[] iArr2 = new int[i];
        float[] fArr = new float[3];
        for (int i2 = 0; i2 < i; i2++) {
            float f = this.b;
            Color.colorToHSV(iArr[i2], fArr);
            fArr[0] = f;
            iArr2[i2] = Color.HSVToColor(Color.alpha(iArr[i2]), fArr);
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr2, 0, width, width, height, Bitmap.Config.ARGB_8888);
        if (bitmapCreateBitmap != null) {
            return bitmapCreateBitmap;
        }
        throw new ApiIllegalArgumentException("Failed to decode image. The provided image must be a Bitmap.");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return com.google.android.libraries.navigation.internal.abf.r.a(this.a, pVar.a) && Float.floatToIntBits(this.b) == Float.floatToIntBits(pVar.b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Float.valueOf(this.b)});
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.abf.aj ajVarF = com.google.android.libraries.navigation.internal.abf.aj.f(this);
        ajVarF.g("baseBitmapDescriptorImpl", this.a);
        return ajVarF.b("hue", this.b).toString();
    }
}

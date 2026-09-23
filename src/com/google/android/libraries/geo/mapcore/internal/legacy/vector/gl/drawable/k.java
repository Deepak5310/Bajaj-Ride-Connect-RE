package com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.google.android.libraries.geo.mapcore.renderer.cs;
import com.google.android.libraries.geo.mapcore.renderer.ey;
import com.google.android.libraries.navigation.internal.agi.br;
import com.google.android.libraries.navigation.internal.agi.bs;
import com.google.android.libraries.navigation.internal.agi.gi;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
abstract class k {
    public final ey a;

    public k(ey eyVar) {
        this.a = eyVar;
    }

    static ey f(bs bsVar, float f, int i, boolean z) {
        float f2;
        float f3;
        int i2;
        float fCeil = (float) Math.ceil(o.a * f);
        int iF = com.google.android.libraries.navigation.internal.nq.a.f(i, 1);
        if (z) {
            iF += iF;
        }
        float f4 = fCeil * 1.3333334f;
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        int iF2 = com.google.android.libraries.navigation.internal.nq.a.f((int) f4, 8);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iF2, iF, config);
        int i3 = 0;
        bitmapCreateBitmap.eraseColor(0);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setStrokeWidth(true != z ? 1.0f : 2.0f);
        paint.setAntiAlias(true);
        float width = bitmapCreateBitmap.getWidth();
        gi giVarListIterator = bsVar.p().listIterator();
        while (giVarListIterator.hasNext()) {
            br brVar = (br) giVarListIterator.next();
            int iA = brVar.a();
            com.google.android.libraries.geo.mapcore.internal.model.bs[] bsVarArrE = ((n) brVar.getKey()).e();
            int iC = ((n) brVar.getKey()).c();
            float f5 = iA;
            float height = canvas.getHeight();
            float f6 = iC;
            int length = bsVarArrE.length;
            while (i3 < length) {
                float f7 = iF2 / f4;
                com.google.android.libraries.geo.mapcore.internal.model.bs bsVar2 = bsVarArrE[i3];
                float f8 = f4;
                float f9 = bsVar2.h;
                int i4 = iF2;
                float f10 = bsVar2.d;
                int i5 = length;
                int i6 = bsVar2.b;
                int[] iArr = bsVar2.e;
                paint.setColor(i6);
                float f11 = (width * 0.5f) - (f9 * f7);
                float f12 = f10 * f7 * 0.5f;
                if (iArr.length == 0) {
                    float f13 = f11 + f12;
                    float f14 = f11 - f12;
                    if (iC == 1) {
                        float f15 = f5 + f5 + 1.0f;
                        f2 = f6;
                        f3 = height;
                        i2 = iC;
                        canvas.drawLine(f14, f15, f13, f15, paint);
                    } else {
                        f2 = f6;
                        f3 = height;
                        canvas.drawRect(f14, 0.0f, f13, canvas.getHeight(), paint);
                        i2 = iC;
                    }
                } else {
                    f2 = f6;
                    f3 = height;
                    i2 = iC;
                    boolean z2 = true;
                    int i7 = 0;
                    while (i7 < i2) {
                        int i8 = 0;
                        while (true) {
                            int length2 = iArr.length;
                            if (i8 <= (length2 & 1)) {
                                boolean z3 = z2;
                                int i9 = i7;
                                int i10 = 0;
                                while (i10 < length2) {
                                    int i11 = iArr[i10];
                                    float f16 = ((i11 / 16.0f) * (f3 / f2) * 16.0f) + f5;
                                    if (z3) {
                                        canvas.drawRect(f11 - f12, f5, f11 + f12, f16, paint);
                                    }
                                    z3 = !z3;
                                    i9 += i11;
                                    i10++;
                                    f5 = f16;
                                    length2 = length2;
                                    i8 = i8;
                                }
                                i8++;
                                z2 = z3;
                                i7 = i9;
                            }
                        }
                    }
                }
                i3++;
                iC = i2;
                length = i5;
                f4 = f8;
                iF2 = i4;
                f6 = f2;
                height = f3;
                f5 = f5;
                bsVarArrE = bsVarArrE;
            }
            i3 = 0;
        }
        return new ey(true != z ? "dashed_line_group" : "solid_line_group", new cs(bitmapCreateBitmap, true), 3, 4);
    }

    public abstract float a(int i);

    public abstract float b(int i);

    public abstract float c();

    public abstract float d(n nVar);
}

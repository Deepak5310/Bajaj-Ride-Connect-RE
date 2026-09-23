package com.google.android.libraries.navigation.internal.gw;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m extends Drawable {
    private static final ThreadLocal a = new h();
    private static final ThreadLocal b = new i();
    private k c;
    private boolean d;
    private Bitmap e;
    private final RectF f = new RectF();

    public m(k kVar) {
        this.c = kVar;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        com.google.android.libraries.navigation.internal.o.b bVar;
        com.google.android.libraries.navigation.internal.o.d dVar;
        Bitmap.Config config;
        Bitmap bitmapA;
        Rect bounds = getBounds();
        int iWidth = bounds.width();
        int iHeight = bounds.height();
        Matrix matrix = (Matrix) a.get();
        float[] fArr = (float[]) b.get();
        canvas.getMatrix(matrix);
        matrix.getValues(fArr);
        float fHypot = (float) Math.hypot(fArr[0], fArr[3]);
        float fHypot2 = (float) Math.hypot(fArr[4], fArr[1]);
        float f = fArr[2];
        float f2 = fArr[5];
        float fFloor = f - ((float) Math.floor(f));
        float fFloor2 = f2 - ((float) Math.floor(f2));
        float f3 = iWidth * fHypot;
        float f4 = fFloor + f3;
        double dCeil = Math.ceil(f4) - Math.floor(fFloor);
        float f5 = iHeight * fHypot2;
        float f6 = fFloor2 + f5;
        double dCeil2 = Math.ceil(f6) - Math.floor(fFloor2);
        this.f.left = bounds.left - (fFloor / fHypot);
        this.f.top = bounds.top - (fFloor2 / fHypot2);
        int i = (int) dCeil;
        this.f.right = bounds.left + ((i - fFloor) / fHypot);
        int i2 = (int) dCeil2;
        this.f.bottom = bounds.top + ((i2 - fFloor2) / fHypot2);
        if (i <= 0 || i2 <= 0) {
            this.e = null;
        } else {
            l lVar = this.c.a;
            u uVar = lVar.a;
            int i3 = lVar.f;
            int i4 = lVar.g;
            Picture picture = lVar.b;
            com.google.android.libraries.navigation.internal.o.d dVar2 = lVar.c;
            Bitmap.Config config2 = lVar.d;
            if (i3 <= 0 || i4 <= 0) {
                bVar = new com.google.android.libraries.navigation.internal.o.b(fFloor, fFloor2, f4, f6);
            } else {
                float f7 = f3 / i3;
                float f8 = f5 / i4;
                bVar = new com.google.android.libraries.navigation.internal.o.b((dVar2.b() * f7) + fFloor, fFloor2 + (dVar2.d() * f8), fFloor + (dVar2.c() * f7), fFloor2 + (dVar2.a() * f8));
            }
            a aVar = new a();
            Objects.requireNonNull(picture);
            aVar.a = picture;
            aVar.b = bVar;
            Objects.requireNonNull(config2);
            aVar.c = config2;
            aVar.d = i;
            byte b2 = aVar.f;
            aVar.e = i2;
            aVar.f = (byte) (b2 | 3);
            Picture picture2 = aVar.a;
            if (picture2 == null || (dVar = aVar.b) == null || (config = aVar.c) == null) {
                throw new IllegalStateException();
            }
            b bVar2 = new b(picture2, dVar, config, i, i2);
            j jVar = new j(picture, bVar, i, i2, config2);
            synchronized (uVar.b) {
                bitmapA = (Bitmap) uVar.b.f(bVar2);
                if (bitmapA == null) {
                    bitmapA = (Bitmap) uVar.d.b(bVar2);
                    if (bitmapA == null) {
                        bitmapA = jVar.a();
                    }
                    uVar.b.m(bVar2, bitmapA);
                }
                uVar.d.c(bVar2, bitmapA);
            }
            this.e = bitmapA;
        }
        Bitmap bitmap = this.e;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, (Rect) null, this.f, this.c.b);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.c;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.c.a.g;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.c.a.f;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        int i = this.c.a.e;
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        if (!this.d) {
            k kVar = this.c;
            this.c = new k(kVar.a, new Paint(kVar.b));
            this.d = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.c.b.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.c.b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setDither(boolean z) {
        this.c.b.setDither(z);
        invalidateSelf();
    }
}

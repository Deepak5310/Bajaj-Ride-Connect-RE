package com.google.android.libraries.navigation.internal.nc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.google.android.libraries.navigation.internal.yx.bq;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class al extends ah {
    final /* synthetic */ ah a;
    final /* synthetic */ ap b;
    final /* synthetic */ x c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public al(Object[] objArr, ah ahVar, ap apVar, x xVar) {
        super(objArr);
        this.a = ahVar;
        this.b = apVar;
        this.c = xVar;
    }

    @Override // com.google.android.libraries.navigation.internal.nc.ah
    public final Drawable a(Context context) {
        Bitmap bitmapExtractAlpha;
        Drawable drawableA = this.a.a(context);
        int iE = this.b.e(context);
        Drawable.ConstantState constantState = drawableA.getConstantState();
        int i = ((ae) this.c).a;
        com.google.android.libraries.navigation.internal.mu.a aVar = new com.google.android.libraries.navigation.internal.mu.a(constantState, iE, i);
        Bitmap bitmap = (Bitmap) com.google.android.libraries.navigation.internal.mu.e.a.b(aVar);
        if (bitmap == null) {
            int[] iArr = new int[2];
            int intrinsicWidth = drawableA.getIntrinsicWidth();
            int intrinsicHeight = drawableA.getIntrinsicHeight();
            boolean z = intrinsicWidth > 0 && intrinsicHeight > 0;
            Integer numValueOf = Integer.valueOf(intrinsicWidth);
            Integer numValueOf2 = Integer.valueOf(intrinsicHeight);
            if (!z) {
                throw new IllegalArgumentException(bq.a("The original Drawable doesn't have an intrinsic size. Drawable: %s, Width: %s, Height:%s", drawableA, numValueOf, numValueOf2));
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ALPHA_8);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawableA.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawableA.draw(canvas);
            Paint paint = new Paint();
            paint.setMaskFilter(new BlurMaskFilter(iE, BlurMaskFilter.Blur.OUTER));
            try {
                bitmapExtractAlpha = bitmapCreateBitmap.extractAlpha(paint, iArr);
            } catch (RuntimeException unused) {
                bitmapExtractAlpha = bitmapCreateBitmap;
            }
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmapExtractAlpha.getWidth(), bitmapExtractAlpha.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
            Paint paint2 = new Paint();
            paint2.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_ATOP));
            canvas2.drawBitmap(bitmapExtractAlpha, 0.0f, 0.0f, paint2);
            canvas2.translate(-iArr[0], -iArr[1]);
            drawableA.draw(canvas2);
            bitmapExtractAlpha.recycle();
            bitmapCreateBitmap.recycle();
            com.google.android.libraries.navigation.internal.mu.e.a.c(aVar, bitmapCreateBitmap2);
            bitmap = bitmapCreateBitmap2;
        }
        return new BitmapDrawable(context.getResources(), bitmap);
    }
}

package com.google.android.apps.gmm.base.views.linear;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.google.android.libraries.navigation.internal.f.j;
import com.google.android.libraries.navigation.internal.yz.hy;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class CircularMaskedLinearLayout extends LinearLayout {
    public static final /* synthetic */ int d = 0;
    private static final Paint e;
    private static final Map f;
    public Bitmap a;
    public int b;
    public int c;
    private Rect g;

    static {
        Paint paint = new Paint(1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        e = paint;
        f = new hy().c().f();
    }

    public CircularMaskedLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private final void a(int i, int i2) {
        this.g = new Rect(getPaddingLeft(), getPaddingTop(), i - getPaddingRight(), i2 - getPaddingBottom());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (getWidth() == 0) {
            getWidth();
            getHeight();
            return;
        }
        if (this.g == null) {
            a(getWidth(), getHeight());
        }
        canvas.drawBitmap((Bitmap) f.computeIfAbsent(Integer.valueOf(getWidth()), new Function() { // from class: com.google.android.apps.gmm.base.views.linear.a
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                int i = CircularMaskedLinearLayout.d;
                int iIntValue = ((Integer) obj).intValue();
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iIntValue, iIntValue, Bitmap.Config.ARGB_8888);
                Paint paint = new Paint(1);
                paint.setAlpha(255);
                float f2 = iIntValue;
                new Canvas(bitmapCreateBitmap).drawOval(new RectF(0.0f, 0.0f, f2, f2), paint);
                return bitmapCreateBitmap;
            }
        }), (Rect) null, this.g, e);
        if (this.b != 0) {
            int width = getWidth();
            Bitmap bitmap = this.a;
            if (bitmap == null || bitmap.getWidth() < width) {
                int i = this.b;
                int i2 = this.c;
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap);
                Paint paint = new Paint(1);
                paint.setColor(i);
                paint.setStrokeCap(Paint.Cap.ROUND);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(i2);
                int i3 = width - i2;
                float f2 = width / 2;
                canvas2.drawCircle(f2, f2, (float) (((double) (i3 / 2)) + 0.5d), paint);
                this.a = bitmapCreateBitmap;
            }
            canvas.drawBitmap(this.a, (Rect) null, this.g, new Paint());
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        a(i, i2);
    }

    public CircularMaskedLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayerType(2, null);
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, j.k, i, 0);
        this.b = typedArrayObtainStyledAttributes.getColor(j.l, 0);
        this.c = getResources().getDimensionPixelSize(com.google.android.libraries.navigation.internal.f.c.a);
        typedArrayObtainStyledAttributes.recycle();
    }
}

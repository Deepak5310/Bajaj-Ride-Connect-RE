package com.google.android.libraries.navigation.internal.qe;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import androidx.core.view.ViewCompat;
import com.google.android.libraries.geo.mapcore.internal.model.ai;
import com.google.android.libraries.geo.mapcore.internal.model.cb;
import com.google.android.libraries.geo.mapcore.internal.model.m;
import com.google.android.libraries.geo.mapcore.internal.model.o;
import com.google.android.libraries.geo.mapcore.renderer.eo;
import com.google.android.libraries.geo.mapcore.renderer.ep;
import com.google.android.libraries.geo.mapcore.renderer.er;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public final Paint a;
    public final float b;
    private final Paint c;
    private final Path d;
    private final ep e;
    private final float f;
    private final boolean g;

    public b(ep epVar, float f, Paint paint, Paint paint2, boolean z) {
        this.e = epVar;
        this.a = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        this.c = paint2;
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeJoin(Paint.Join.ROUND);
        this.d = new Path();
        this.b = f;
        this.f = f < 1.001f ? 1.03f : 1.0f;
        this.g = z;
    }

    private final float f(ai aiVar) {
        if (!aiVar.p()) {
            return 0.0f;
        }
        m mVar = (m) aiVar.s;
        if (Color.alpha(mVar.b.b) != 0) {
            return mVar.b.d * this.b;
        }
        return 0.0f;
    }

    public final er a(String str, ai aiVar, float f) {
        int i;
        int i2;
        float f2;
        float f3;
        int i3;
        int i4;
        int i5;
        int i6;
        int iD = com.google.android.libraries.navigation.internal.pz.b.d(aiVar);
        int iC = com.google.android.libraries.navigation.internal.pz.b.c(aiVar);
        float fA = com.google.android.libraries.navigation.internal.pz.b.a(aiVar);
        float f4 = f(aiVar);
        if (aiVar.p()) {
            m mVar = (m) aiVar.s;
            i = mVar.a;
            i2 = mVar.b.b;
            float f5 = mVar.g;
            float f6 = this.b;
            f3 = f5 * f6;
            f2 = mVar.h * f6;
            if (Color.alpha(i2) != 0) {
                i |= ViewCompat.MEASURED_STATE_MASK;
            }
        } else {
            i = 0;
            i2 = 0;
            f2 = 0.0f;
            f3 = 0.0f;
        }
        int iHashCode = Arrays.hashCode(new Object[]{str, Float.valueOf(f), aiVar.r, aiVar.s});
        er erVarG = this.e.g(iHashCode);
        if (erVarG != null) {
            return erVarG;
        }
        if (iC == 0) {
            if (i != 0) {
                iC = 0;
            } else {
                iC = 0;
                i = 0;
                fA = 0.0f;
            }
        }
        float f7 = this.b;
        float[] fArrE = e(str, aiVar, f);
        int i7 = i;
        int iCeil = (int) Math.ceil(fArrE[0]);
        int iCeil2 = (int) Math.ceil(fArrE[1]);
        if (iCeil <= 0 || iCeil2 <= 0) {
            return null;
        }
        eo eoVarJ = this.e.j(iHashCode, iCeil, iCeil2);
        int i8 = eoVarJ.a;
        if (eoVarJ.b) {
            i3 = iCeil + 2;
            i4 = iCeil2 + 2;
            i5 = 1;
            i6 = 0;
        } else {
            i3 = iCeil;
            i4 = iCeil2;
            i5 = 0;
            i6 = 1;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        b(aiVar.r);
        this.a.setTextSize(f);
        c(aiVar.r);
        if (i7 != 0) {
            int i9 = iCeil + i5;
            int i10 = iCeil2 + i5;
            float f8 = i5;
            if (i2 != 0) {
                this.a.setColor(i2);
                canvas.drawRect(f8, f8, i9, i10, this.a);
            }
            this.a.setColor(i7);
            float f9 = f8 + f4;
            canvas.drawRect(f9, f9, i9 - f4, i10 - f4, this.a);
        }
        float f10 = fA * f7;
        Paint paint = this.a;
        Paint paint2 = this.c;
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        paint2.setColor(iC);
        this.c.setStrokeWidth(f10);
        this.a.setColor(iD);
        boolean z = iC != 0 && f10 > 0.0f;
        float f11 = f10 / 2.0f;
        this.a.getTextPath(str, 0, str.length(), ((int) Math.ceil(f11 + f4 + f3)) + i5, ((int) Math.ceil(Math.max(-fontMetrics.top, (-fontMetrics.ascent) + f2) + f11 + f4)) + i5, this.d);
        if (z) {
            canvas.drawPath(this.d, this.c);
        }
        if (iD != 0) {
            canvas.drawPath(this.d, this.a);
        }
        return this.e.f(bitmapCreateBitmap, iHashCode, i8, i6, i5, 1.0f);
    }

    public final void c(cb cbVar) {
        if (cbVar != null) {
            this.a.setLetterSpacing(((o) cbVar).f);
        }
    }

    public final float[] d(String str, ai aiVar, float f) {
        int length = str.length();
        int i = length + 1;
        float[] fArr = new float[i];
        b(aiVar.r);
        this.a.setTextSize(f);
        c(aiVar.r);
        this.a.getTextWidths(str, fArr);
        float fCeil = (int) Math.ceil((com.google.android.libraries.navigation.internal.pz.b.a(aiVar) * this.b) / 2.0f);
        float f2 = fCeil;
        int i2 = 0;
        while (i2 < i) {
            float f3 = fArr[i2] + f2;
            fArr[i2] = f2;
            i2++;
            f2 = f3;
        }
        fArr[0] = fArr[0] - fCeil;
        float f4 = fArr[length] + fCeil;
        fArr[length] = f4;
        fArr[length] = f4 * this.f;
        return fArr;
    }

    public final float[] e(String str, ai aiVar, float f) {
        float f2;
        float f3;
        float f4;
        cb cbVar = aiVar.r;
        b(cbVar);
        this.a.setTextSize(f);
        c(cbVar);
        float fMeasureText = this.a.measureText(str);
        float fA = com.google.android.libraries.navigation.internal.pz.b.a(aiVar);
        float f5 = aiVar.q() ? ((o) aiVar.r).e : 1.0f;
        float f6 = f(aiVar);
        float f7 = 0.0f;
        if (aiVar.p()) {
            m mVar = (m) aiVar.s;
            float f8 = mVar.g;
            float f9 = this.b;
            f3 = f8 * f9;
            f2 = mVar.h * f9;
        } else {
            f2 = 0.0f;
            f3 = 0.0f;
        }
        Paint.FontMetrics fontMetrics = this.a.getFontMetrics();
        float fCeil = (float) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        float f10 = fontMetrics.ascent - fontMetrics.top;
        float f11 = fontMetrics.bottom - fontMetrics.descent;
        float f12 = f5 - 1.0f;
        if (fA > 0.0f && fMeasureText > 0.0f) {
            int iCeil = (int) Math.ceil((fA * this.b) / 2.0f);
            fMeasureText += iCeil + iCeil;
            float f13 = iCeil;
            f10 += f13;
            f11 += f13;
        }
        float f14 = this.f;
        float f15 = (f12 * fCeil) / 2.0f;
        float fMax = fCeil + f10 + f11 + Math.max(0.0f, f2 - (fontMetrics.ascent - fontMetrics.top)) + Math.max(0.0f, f2 - (fontMetrics.bottom - fontMetrics.descent));
        float f16 = (fMeasureText * f14) + f3 + f3;
        if (f6 > 0.0f) {
            float f17 = f6 + f6;
            f16 += f17;
            fMax += f17;
            f4 = 0.0f;
        } else {
            f7 = f10 - f15;
            f4 = f11 - f15;
        }
        return new float[]{f16, fMax, f7, f4};
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public final void b(cb cbVar) {
        ?? r1;
        Typeface typefaceDefaultFromStyle = null;
        if (cbVar != null) {
            boolean zK = cb.k(cbVar.d());
            if (cb.l(cbVar.d())) {
                r1 = zK;
                r1 = (zK ? 1 : 0) | 2;
            }
            r1 = zK;
            if (cb.m(cbVar.d())) {
                typefaceDefaultFromStyle = Typeface.create(true != this.g ? "sans-serif-light" : "google-sans-light", r1 == true ? 1 : 0);
            } else if (cb.n(cbVar.d())) {
                try {
                    typefaceDefaultFromStyle = Typeface.create(this.g ? "google-sans-medium" : "sans-serif-medium", r1 == true ? 1 : 0);
                } catch (Exception unused) {
                }
            }
        } else {
            r1 = 0;
        }
        if (typefaceDefaultFromStyle == null && this.g) {
            typefaceDefaultFromStyle = Typeface.create("google-sans", (int) r1);
        }
        if (typefaceDefaultFromStyle == null) {
            typefaceDefaultFromStyle = Typeface.defaultFromStyle(r1);
        }
        this.a.setTypeface(typefaceDefaultFromStyle);
    }
}

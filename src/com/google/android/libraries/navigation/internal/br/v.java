package com.google.android.libraries.navigation.internal.br;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import androidx.core.graphics.ColorUtils;
import com.google.android.libraries.navigation.internal.adr.ah;
import com.google.android.libraries.navigation.internal.adr.aj;
import com.google.android.libraries.navigation.internal.adr.gn;
import com.google.android.libraries.navigation.internal.yx.aq;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class v extends ReplacementSpan {
    private static final com.google.android.libraries.navigation.internal.zb.j b = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.br.v");
    private final ah A;
    private final boolean B;
    private final int C;
    private final Resources D;
    private final String E;
    public Integer a;
    private final float c;
    private final float d;
    private final float e;
    private final boolean f;
    private final int g;
    private final int h;
    private final Paint i;
    private final Paint j;
    private final Path k;
    private final boolean l;
    private final boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f358n;
    private final boolean o;
    private final boolean p;
    private final float q;
    private final float r;
    private final float s;
    private final Paint.FontMetrics t;
    private final RectF u;
    private int v;
    private int w;
    private CharSequence x;
    private final boolean y;
    private final com.google.android.libraries.navigation.internal.bn.d z;

    public v(gn gnVar, boolean z, boolean z2, Resources resources, com.google.android.libraries.navigation.internal.bn.d dVar, int i) {
        int color = resources.getColor(com.google.android.libraries.navigation.internal.bx.b.c);
        Paint paint = new Paint();
        this.i = paint;
        Paint paint2 = new Paint();
        this.j = paint2;
        this.k = new Path();
        this.t = new Paint.FontMetrics();
        this.u = new RectF();
        this.y = true;
        boolean z3 = false;
        this.C = 0;
        this.z = dVar;
        this.D = resources;
        this.B = false;
        this.m = z;
        this.f358n = z2;
        this.A = null;
        aj ajVar = gnVar.d;
        this.E = com.google.android.libraries.navigation.internal.ch.e.b((ajVar == null ? aj.a : ajVar).c, aq.b(null));
        float dimension = resources.getDimension(com.google.android.libraries.navigation.internal.bx.c.f);
        this.s = dimension;
        float f = dimension / 2.0f;
        float dimension2 = resources.getDimension(com.google.android.libraries.navigation.internal.bx.c.c);
        float dimension3 = resources.getDimension(com.google.android.libraries.navigation.internal.bx.c.e);
        this.e = resources.getDimension(com.google.android.libraries.navigation.internal.bx.c.d) + dimension2;
        this.q = resources.getDimension(com.google.android.libraries.navigation.internal.bx.c.a) + dimension3;
        this.c = dimension2 - f;
        this.d = dimension3 - f;
        this.r = resources.getDimension(com.google.android.libraries.navigation.internal.bx.c.b);
        boolean z4 = resources.getBoolean(com.google.android.libraries.navigation.internal.bx.a.a);
        this.l = z4;
        int color2 = resources.getColor(com.google.android.libraries.navigation.internal.bx.b.d);
        aj ajVar2 = gnVar.d;
        if (((ajVar2 == null ? aj.a : ajVar2).b & 8) != 0) {
            aj ajVar3 = gnVar.d;
            if (com.google.android.libraries.navigation.internal.gz.b.b((ajVar3 == null ? aj.a : ajVar3).f)) {
                aj ajVar4 = gnVar.d;
                color2 = Color.parseColor((ajVar4 == null ? aj.a : ajVar4).f);
            }
        }
        this.g = color2;
        int color3 = resources.getColor(com.google.android.libraries.navigation.internal.bx.b.e);
        this.h = color3;
        boolean zC = com.google.android.libraries.navigation.internal.gz.i.c(resources);
        this.f = zC;
        this.o = !(zC || z) || (zC && !z2);
        if ((!zC && !z2) || (zC && !z)) {
            z3 = true;
        }
        this.p = z3;
        int color4 = resources.getColor(com.google.android.libraries.navigation.internal.v.a.b);
        aj ajVar5 = gnVar.d;
        if (((ajVar5 == null ? aj.a : ajVar5).b & 4) != 0) {
            aj ajVar6 = gnVar.d;
            if (com.google.android.libraries.navigation.internal.gz.b.b((ajVar6 == null ? aj.a : ajVar6).e)) {
                aj ajVar7 = gnVar.d;
                color = Color.parseColor((ajVar7 == null ? aj.a : ajVar7).e);
                int iAlpha = Color.alpha(color);
                if (iAlpha != 255) {
                    color = ColorUtils.setAlphaComponent(ColorUtils.blendARGB(-1, color, iAlpha / 255.0f), 255);
                }
            }
        }
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color);
        double dCalculateContrast = ColorUtils.calculateContrast(color4, color);
        if (!z4 ? (color & 16777215) == 16777215 : dCalculateContrast < 3.0d) {
            paint2.setColor(color);
        } else {
            int iCompositeColors = ColorUtils.compositeColors(color3, color);
            paint2.setColor(ColorUtils.calculateContrast(color4, iCompositeColors) > dCalculateContrast ? iCompositeColors : color3);
        }
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(dimension);
        paint2.setStrokeJoin(Paint.Join.ROUND);
    }

    private final int a() {
        float f = 0.0f;
        float f2 = (this.m ? this.e : this.q) + 0.0f;
        if (!c()) {
            f = this.f358n ? this.e : this.q - this.r;
        }
        return (int) (f2 + f);
    }

    private final void b(float f, float f2, float f3, float f4, float f5) {
        this.u.set(f - f3, f2 - f3, f + f3, f2 + f3);
        this.k.arcTo(this.u, f4, f5);
    }

    private final boolean c() {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x002e  */
    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        float f2;
        float f3;
        if (this.y) {
            paint.getFontMetrics(this.t);
            if (this.f) {
                if (c()) {
                    f2 = 0.0f;
                } else if (this.o) {
                    f2 = this.q - this.r;
                } else {
                    f2 = this.e;
                }
            } else if (this.o) {
                f2 = this.q;
            } else {
                f2 = this.e;
            }
            float f4 = i4;
            float f5 = this.t.ascent + f4;
            float f6 = this.t.descent + f4;
            float f7 = this.s;
            float f8 = f7 / 2.0f;
            float f9 = f + f2 + f8;
            float f10 = f6 - f8;
            float f11 = f8 + f5;
            float f12 = f10 - f11;
            if (this.f) {
                float f13 = f7 * 1.5f;
                float f14 = this.v + f9;
                if (!c() || this.f358n) {
                    f3 = f9;
                } else {
                    f3 = f9 - ((-this.q) + this.r);
                }
                float f15 = this.q;
                float f16 = this.d;
                double dAtan = ((float) Math.atan(f12 / (f15 - f16))) / 2.0f;
                double d = f16;
                double dTan = d / Math.tan(dAtan);
                double dTan2 = d * Math.tan(dAtan);
                float degrees = (float) Math.toDegrees(dAtan);
                this.k.reset();
                float f17 = (f14 + 0.0f) - f13;
                float f18 = (float) dTan2;
                float f19 = (float) dTan;
                if (this.p) {
                    float f20 = degrees + degrees;
                    float f21 = this.d;
                    b((f17 + f21) - f18, f11 + f21, f21, 270.0f, f20);
                    float f22 = (f17 + this.q) - f19;
                    float f23 = this.d;
                    b(f22, f10 - f23, f23, f20 + 270.0f, 180.0f - f20);
                } else {
                    float f24 = this.e + f17;
                    float f25 = this.c;
                    b(f24 - f25, f11 + f25, f25, 270.0f, 90.0f);
                    float f26 = f17 + this.e;
                    float f27 = this.c;
                    b(f26 - f27, f10 - f27, f27, 0.0f, 90.0f);
                }
                if (this.o) {
                    float f28 = degrees + degrees;
                    float f29 = this.d;
                    b((f3 - f29) + f18, f10 - f29, f29, 90.0f, f28);
                    float f30 = (f3 - this.q) + f19;
                    float f31 = this.d;
                    b(f30, f11 + f31, f31, f28 + 90.0f, 180.0f - f28);
                } else {
                    float f32 = f3 - this.e;
                    float f33 = this.c;
                    b(f32 + f33, f10 - f33, f33, 90.0f, 90.0f);
                    float f34 = f3 - this.e;
                    float f35 = this.c;
                    b(f34 + f35, f11 + f35, f35, 180.0f, 90.0f);
                }
                this.k.close();
                canvas.drawPath(this.k, this.i);
                canvas.drawPath(this.k, this.j);
            } else {
                float f36 = ((this.v + f9) + 0.0f) - (f7 * 1.5f);
                if (c() && !this.f358n) {
                    f36 += (-this.q) + this.r;
                }
                float f37 = f36;
                float f38 = this.q;
                float f39 = this.d;
                double dAtan2 = ((float) Math.atan(f12 / (f38 - f39))) / 2.0f;
                double d2 = f39;
                double dTan3 = d2 / Math.tan(dAtan2);
                double dTan4 = d2 * Math.tan(dAtan2);
                float degrees2 = (float) Math.toDegrees(dAtan2);
                this.k.reset();
                float f40 = (float) dTan4;
                float f41 = (float) dTan3;
                if (this.o) {
                    float f42 = degrees2 + degrees2;
                    float f43 = (f9 - this.q) + f41;
                    float f44 = this.d;
                    b(f43, f10 - f44, f44, 90.0f, 180.0f - f42);
                    float f45 = this.d;
                    b((f9 - f45) + f40, f11 + f45, f45, 270.0f - f42, f42);
                } else {
                    float f46 = f9 - this.e;
                    float f47 = this.c;
                    b(f46 + f47, f10 - f47, f47, 90.0f, 90.0f);
                    float f48 = f9 - this.e;
                    float f49 = this.c;
                    b(f48 + f49, f11 + f49, f49, 180.0f, 90.0f);
                }
                if (this.p) {
                    float f50 = degrees2 + degrees2;
                    float f51 = (this.q + f37) - f41;
                    float f52 = this.d;
                    b(f51, f11 + f52, f52, 270.0f, 180.0f - f50);
                    float f53 = this.d;
                    b((f37 + f53) - f40, f10 - f53, f53, 90.0f - f50, f50);
                } else {
                    float f54 = this.e + f37;
                    float f55 = this.c;
                    b(f54 - f55, f11 + f55, f55, 270.0f, 90.0f);
                    float f56 = f37 + this.e;
                    float f57 = this.c;
                    b(f56 - f57, f10 - f57, f57, 0.0f, 90.0f);
                }
                this.k.close();
                canvas.drawPath(this.k, this.i);
                canvas.drawPath(this.k, this.j);
            }
            int color = paint.getColor();
            paint.setColor(this.g);
            float f58 = f9 + 0.0f;
            CharSequence charSequence2 = this.x;
            if (charSequence2 != null) {
                canvas.drawText(charSequence2, 0, charSequence2.length(), f58, f4, paint);
            } else {
                canvas.drawText(charSequence, i, i2, f58, f4, paint);
            }
            paint.setColor(color);
        }
    }

    @Override // android.text.style.ReplacementSpan
    public final CharSequence getContentDescription() {
        return this.E;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        if (!this.y) {
            return 0;
        }
        int iA = a();
        paint.measureText("…", 0, 1);
        int iMeasureText = (int) paint.measureText(charSequence, i, i2);
        this.v = iMeasureText;
        this.x = null;
        this.w = 0;
        return iMeasureText + iA;
    }
}

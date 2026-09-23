package com.google.android.libraries.navigation.internal.abl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.libraries.navigation.internal.abh.as;
import com.google.android.libraries.navigation.internal.abh.fy;
import com.google.android.libraries.navigation.internal.abh.fz;
import com.google.android.libraries.navigation.internal.abh.hm;
import com.mappls.sdk.maps.style.layers.Property;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class y implements fy, ab {
    List a;
    final List b;
    private final fz c;
    private final s d;
    private final w e;
    private final List f;

    public y(fz fzVar, s sVar) {
        w wVar = w.a;
        this.c = fzVar;
        this.d = sVar;
        sVar.j(this);
        this.a = new ArrayList();
        this.f = new ArrayList();
        this.b = new ArrayList();
        com.google.android.libraries.navigation.internal.abf.s.k(wVar, "polyUtils");
        this.e = wVar;
    }

    private final void g(Canvas canvas, Path path, PatternItem[] patternItemArr, int i, hm hmVar) {
        w wVar = this.e;
        if (patternItemArr == null) {
            wVar.c(canvas, path, hmVar.b(), hmVar.a(), i);
        } else {
            wVar.b(canvas, path, patternItemArr, hmVar.b(), i, hmVar.a());
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abl.ab
    public final float a() {
        return this.c.E();
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fy
    public final void b(int i) {
        this.d.m();
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fy
    public final void c() {
        this.d.n(this);
    }

    final void d(Canvas canvas, boolean z) {
        com.google.android.libraries.navigation.internal.abj.c cVarE;
        com.google.android.libraries.navigation.internal.abj.c cVarE2;
        if (this.a.isEmpty()) {
            return;
        }
        for (com.google.android.libraries.navigation.internal.abj.d dVar : this.a) {
            as asVarI = z ? this.c.I() : this.c.H();
            fz fzVar = this.c;
            int iA = asVarI.a();
            float fA = fzVar.J().a();
            boolean z2 = false;
            if (iA == 3) {
                Bitmap bitmap = asVarI.b;
                float fFloatValue = asVarI.c().floatValue();
                Paint paint = (Paint) w.d.get();
                com.google.android.libraries.navigation.internal.abf.s.k(canvas, "canvas");
                com.google.android.libraries.navigation.internal.abf.s.k(bitmap, "bitmap");
                com.google.android.libraries.navigation.internal.abf.s.a(fFloatValue > 0.0f, com.google.android.libraries.navigation.internal.b.b.h(fFloatValue, "bitmapRefWidthPx="));
                com.google.android.libraries.navigation.internal.abf.s.k(dVar, Property.SYMBOL_PLACEMENT_LINE);
                com.google.android.libraries.navigation.internal.abf.s.k(paint, "paint");
                if (fA > 0.0f && !dVar.i() && dVar.d() != 0 && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
                    if (z) {
                        cVarE = dVar.f(0);
                        z2 = true;
                    } else {
                        cVarE = dVar.e();
                    }
                    int i = cVarE.a;
                    int i2 = cVarE.b;
                    float f = fA / fFloatValue;
                    float degrees = ((float) Math.toDegrees(z2 ? dVar.a() : dVar.b())) + (z2 ? -90.0f : 90.0f);
                    paint.reset();
                    paint.setAntiAlias(true);
                    float f2 = i;
                    float f3 = i2;
                    canvas.rotate(degrees, f2, f3);
                    canvas.scale(f, f, f2, f3);
                    canvas.drawBitmap(bitmap, ((long) i) - Math.round(((double) bitmap.getWidth()) * 0.5d), ((long) i2) - Math.round(((double) bitmap.getHeight()) * 0.5d), paint);
                    float f4 = 1.0f / f;
                    canvas.scale(f4, f4, f2, f3);
                    canvas.rotate(-degrees, f2, f3);
                }
            } else {
                int iB = this.b.isEmpty() ? this.c.J().b() : ((hm) this.c.K().get(z ? 0 : this.c.K().size() - 1)).b();
                Paint paint2 = (Paint) w.c.get();
                com.google.android.libraries.navigation.internal.abf.s.k(canvas, "canvas");
                com.google.android.libraries.navigation.internal.abf.s.k(dVar, Property.SYMBOL_PLACEMENT_LINE);
                com.google.android.libraries.navigation.internal.abf.s.k(paint2, "paint");
                com.google.android.libraries.navigation.internal.abf.s.a(iA != 3, com.google.android.libraries.navigation.internal.b.b.b(iA, "Not a standard cap type: "));
                if (iA != 0 && fA > 0.0f && !dVar.i() && dVar.d() != 0 && Color.alpha(iB) != 0) {
                    if (z) {
                        cVarE2 = dVar.f(0);
                        z2 = true;
                    } else {
                        cVarE2 = dVar.e();
                    }
                    int i3 = cVarE2.a;
                    int i4 = cVarE2.b;
                    float fA2 = z2 ? dVar.a() : dVar.b();
                    paint2.reset();
                    paint2.setAntiAlias(true);
                    paint2.setPathEffect(null);
                    paint2.setColor(iB);
                    float f5 = 0.5f * fA;
                    if (iA == 1) {
                        float f6 = i4;
                        float f7 = i3;
                        if (z2) {
                            fA2 += 3.1415927f;
                        }
                        paint2.setStyle(Paint.Style.STROKE);
                        paint2.setStrokeWidth(fA);
                        double d = fA2;
                        canvas.drawLine(f7, f6, f7 + (((float) Math.cos(d)) * f5), f6 + (f5 * ((float) Math.sin(d))), paint2);
                    } else if (iA == 2) {
                        float f8 = i4;
                        float f9 = i3;
                        float f10 = fA2 + (z2 ? 1.5707964f : -1.5707964f);
                        paint2.setStyle(Paint.Style.FILL);
                        canvas.drawArc(new RectF(f9 - f5, f8 - f5, f9 + f5, f8 + f5), (float) Math.toDegrees(f10), 180.0f, true, paint2);
                    }
                }
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abl.ab
    public final void e(Canvas canvas, aa aaVar) {
        hm hmVarJ = this.c.J();
        if (hmVarJ.e()) {
            Path path = new Path();
            this.a = new ArrayList();
            this.c.L(this.f, this.b);
            this.e.a(this.f, aaVar, this.a, path);
            if (this.b.isEmpty()) {
                fz fzVar = this.c;
                g(canvas, path, fzVar.O(), fzVar.F(), hmVarJ);
            } else {
                List listK = this.c.K();
                int i = 0;
                while (i < listK.size()) {
                    hm hmVar = (hm) listK.get(i);
                    if (hmVar.e()) {
                        Path path2 = new Path();
                        this.e.a(this.f.subList(i == 0 ? 0 : ((Integer) this.b.get(i - 1)).intValue(), (i == listK.size() + (-1) ? this.f.size() - 1 : ((Integer) this.b.get(i)).intValue()) + 1), aaVar, new ArrayList(), path2);
                        fz fzVar2 = this.c;
                        g(canvas, path2, fzVar2.O(), fzVar2.F(), hmVar);
                    }
                    i++;
                }
            }
            d(canvas, true);
            d(canvas, false);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abl.ab
    public final boolean f(float f, float f2) {
        if (!this.c.N() || !this.e.f(f, f2, this.a)) {
            return false;
        }
        this.c.M();
        return true;
    }
}

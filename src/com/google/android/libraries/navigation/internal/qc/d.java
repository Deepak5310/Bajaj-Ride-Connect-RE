package com.google.android.libraries.navigation.internal.qc;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.google.android.libraries.geo.mapcore.internal.model.ai;
import com.google.android.libraries.geo.mapcore.internal.model.bz;
import com.google.android.libraries.geo.mapcore.internal.model.m;
import com.google.android.libraries.geo.mapcore.renderer.er;
import com.google.android.libraries.geo.mapcore.renderer.et;
import com.google.android.libraries.navigation.internal.adg.io;
import com.google.android.libraries.navigation.internal.oe.ay;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.zb.j;
import java.util.EnumMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class d extends a {
    private static final j a = j.e("com.google.android.libraries.navigation.internal.qc.d");
    private final com.google.android.libraries.navigation.internal.py.a b;
    private final com.google.android.libraries.navigation.internal.pz.a c;
    private final EnumMap d;
    private final Resources e;

    public d(com.google.android.libraries.navigation.internal.py.a aVar, com.google.android.libraries.navigation.internal.pz.a aVar2, Resources resources) {
        super(aVar.h, aVar.i);
        this.d = new EnumMap(com.google.android.libraries.navigation.internal.adg.b.class);
        this.b = aVar;
        this.c = aVar2;
        this.e = resources;
    }

    private static float e(float f, float f2) {
        double dMin = Math.min(f2, f);
        float f3 = f / 2.0f;
        return f3 - ((float) Math.sqrt(Math.pow(f3, 2.0d) - (Math.pow(dMin, 2.0d) / 4.0d)));
    }

    private final int f(float f) {
        return com.google.android.libraries.navigation.internal.rq.g.a(this.e.getDisplayMetrics().density, f);
    }

    private final Bitmap g() {
        RectF rectF;
        RectF rectF2;
        float fHeight;
        float fMin;
        float fE;
        Bitmap bitmapCreateBitmap = (Bitmap) this.d.get(this.b.g);
        if (bitmapCreateBitmap != null) {
            return bitmapCreateBitmap;
        }
        com.google.android.libraries.navigation.internal.py.a aVar = this.b;
        int i = (int) aVar.h;
        int i2 = (int) aVar.i;
        if (i <= 0 || i > 2048 || i2 <= 0 || i2 > 2048) {
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(1024)).t("Bitmap %d, %d creation failed", i, i2);
        } else {
            try {
                bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            } catch (OutOfMemoryError unused) {
            }
        }
        if (bitmapCreateBitmap == null) {
            return bitmapCreateBitmap;
        }
        bitmapCreateBitmap.setDensity(this.e.getDisplayMetrics().densityDpi);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        ai aiVar = this.b.a;
        if (aiVar != null) {
            if (aiVar.p()) {
                bz bzVar = this.b.a.s;
                m mVar = (m) bzVar;
                float f = f(mVar.b.d);
                RectF rectF3 = new RectF(f(bzVar.s()) + f, f(bzVar.q()) + f, (this.h - f(bzVar.t())) - f, (this.i - f(bzVar.r())) - f);
                com.google.android.libraries.navigation.internal.py.a aVar2 = this.b;
                float f2 = mVar.k;
                com.google.android.libraries.navigation.internal.adg.b bVar = aVar2.g;
                float f3 = f(f2);
                float f4 = f(mVar.i);
                switch (bVar) {
                    case CENTER:
                        rectF = new RectF(rectF3.left, rectF3.top, rectF3.right, rectF3.bottom);
                        break;
                    case LEFT:
                        rectF2 = new RectF(rectF3.left, rectF3.top, rectF3.right - f4, rectF3.bottom);
                        rectF = rectF2;
                        break;
                    case RIGHT:
                        rectF2 = new RectF(rectF3.left + f4, rectF3.top, rectF3.right, rectF3.bottom);
                        rectF = rectF2;
                        break;
                    case TOP:
                        rectF2 = new RectF(rectF3.left, rectF3.top, rectF3.right, rectF3.bottom - f4);
                        rectF = rectF2;
                        break;
                    case TOP_LEFT:
                        rectF = new RectF(rectF3.left, rectF3.top, rectF3.right - f3, rectF3.bottom - f3);
                        break;
                    case TOP_RIGHT:
                        rectF = new RectF(rectF3.left + f3, rectF3.top, rectF3.right, rectF3.bottom - f3);
                        break;
                    case BOTTOM:
                        rectF2 = new RectF(rectF3.left, rectF3.top + f4, rectF3.right, rectF3.bottom);
                        rectF = rectF2;
                        break;
                    case BOTTOM_LEFT:
                        rectF = new RectF(rectF3.left, rectF3.top + f3, rectF3.right - f3, rectF3.bottom);
                        break;
                    case BOTTOM_RIGHT:
                        rectF = new RectF(rectF3.left + f3, rectF3.top + f3, rectF3.right, rectF3.bottom);
                        break;
                    default:
                        ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1027)).p("Anchor position is not supported.");
                        rectF = null;
                        break;
                }
                if (rectF != null) {
                    float f5 = f(mVar.j);
                    float f6 = f(mVar.i);
                    if (mVar.f68n == io.ROUNDED_RECT) {
                        float f7 = f(mVar.l);
                        fHeight = f7 + f7;
                    } else {
                        fHeight = mVar.f68n == io.PILL ? rectF.height() : 0.0f;
                    }
                    float fMin2 = Math.min(fHeight, Math.min(rectF.height(), rectF.width()));
                    float f8 = fMin2 / 2.0f;
                    float fMin3 = Math.min(f5, Math.min(rectF3.height() - f8, rectF3.width() - f8));
                    float fMin4 = Math.min((rectF3.height() - fMin2) / 2.0f, (rectF3.width() - fMin2) / 2.0f);
                    if (bVar.equals(com.google.android.libraries.navigation.internal.adg.b.LEFT) || bVar.equals(com.google.android.libraries.navigation.internal.adg.b.RIGHT)) {
                        fMin = Math.min(f6, rectF3.height() / 2.0f);
                        float fHeight2 = (fMin + fMin) - (rectF3.height() - fMin2);
                        fE = fHeight2 > 0.0f ? e(fMin2, fHeight2) : 0.0f;
                    } else if ((bVar.equals(com.google.android.libraries.navigation.internal.adg.b.TOP) || bVar.equals(com.google.android.libraries.navigation.internal.adg.b.BOTTOM)) && mVar.f68n == io.PILL && rectF3.width() <= 4.0f + fMin2) {
                        fMin = Math.min(f6, rectF3.width() / 2.0f);
                        fE = e(fMin2, fMin + fMin);
                    } else if ((bVar.equals(com.google.android.libraries.navigation.internal.adg.b.TOP) || bVar.equals(com.google.android.libraries.navigation.internal.adg.b.BOTTOM)) && mVar.f68n == io.ROUNDED_RECT && rectF3.width() - fMin2 < f6 + f6 && fMin4 < rectF3.width() / 6.0f) {
                        fMin = Math.min(f6, rectF3.width() / 2.0f);
                        fE = e(fMin2, (fMin + fMin) - (rectF3.width() - fMin2));
                    } else {
                        fMin = Math.min(f6, fMin4);
                    }
                    Path path = new Path();
                    if (bVar.equals(com.google.android.libraries.navigation.internal.adg.b.BOTTOM_RIGHT)) {
                        ay ayVar = new ay(rectF.left, rectF3.top + fMin3);
                        path.moveTo(ayVar.b, ayVar.c);
                        h(path, ayVar, new ay(rectF3.left, rectF3.top), new ay(rectF3.left + fMin3, rectF.top));
                    } else {
                        float f9 = rectF.left;
                        float f10 = rectF3.top;
                        i(path, new RectF(rectF.left, rectF.top, rectF.left + fMin2, rectF.top + fMin2), 180.0f);
                    }
                    if (bVar.equals(com.google.android.libraries.navigation.internal.adg.b.BOTTOM)) {
                        float f11 = rectF.top + fE;
                        h(path, new ay(rectF.centerX() - fMin, f11), new ay(rectF.centerX(), rectF3.top), new ay(rectF.centerX() + fMin, f11));
                    }
                    if (bVar.equals(com.google.android.libraries.navigation.internal.adg.b.BOTTOM_LEFT)) {
                        h(path, new ay(rectF3.right - fMin3, rectF.top), new ay(rectF3.right, rectF3.top), new ay(rectF.right, rectF3.top + fMin3));
                    } else {
                        i(path, new RectF(rectF.right - fMin2, rectF.top, rectF.right, rectF.top + fMin2), 270.0f);
                    }
                    if (bVar.equals(com.google.android.libraries.navigation.internal.adg.b.LEFT)) {
                        float f12 = rectF.right - fE;
                        h(path, new ay(f12, rectF.centerY() - fMin), new ay(rectF3.right, rectF.centerY()), new ay(f12, rectF.centerY() + fMin));
                    }
                    if (bVar.equals(com.google.android.libraries.navigation.internal.adg.b.TOP_LEFT)) {
                        h(path, new ay(rectF.right, rectF3.bottom - fMin3), new ay(rectF3.right, rectF3.bottom), new ay(rectF3.right - fMin3, rectF.bottom));
                    } else {
                        i(path, new RectF(rectF.right - fMin2, rectF.bottom - fMin2, rectF.right, rectF.bottom), 0.0f);
                    }
                    if (bVar.equals(com.google.android.libraries.navigation.internal.adg.b.TOP)) {
                        float f13 = rectF.bottom - fE;
                        h(path, new ay(rectF.centerX() + fMin, f13), new ay(rectF.centerX(), rectF3.bottom), new ay(rectF.centerX() - fMin, f13));
                    }
                    if (bVar.equals(com.google.android.libraries.navigation.internal.adg.b.TOP_RIGHT)) {
                        h(path, new ay(rectF3.left + fMin3, rectF.bottom), new ay(rectF3.left, rectF3.bottom), new ay(rectF.left, rectF3.bottom - fMin3));
                    } else {
                        i(path, new RectF(rectF.left, rectF.bottom - fMin2, rectF.left + fMin2, rectF.bottom), 90.0f);
                    }
                    if (bVar.equals(com.google.android.libraries.navigation.internal.adg.b.RIGHT)) {
                        float f14 = rectF.left + fE;
                        h(path, new ay(f14, rectF.centerY() + fMin), new ay(rectF3.left, rectF.centerY()), new ay(f14, rectF.centerY() - fMin));
                    }
                    path.close();
                    Paint paint = new Paint();
                    paint.setAntiAlias(true);
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(mVar.a);
                    if (canvas.isHardwareAccelerated()) {
                        ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1026)).p("The canvas created to draw callout backgrounds was not expected to be hardware accelerated. Paint's setShadowLayer is only supported in the software rendering pipeline. The callout drop shadow will not be rendered.");
                    } else {
                        paint.setShadowLayer(f(mVar.f), f(mVar.c), f(mVar.d), mVar.e);
                    }
                    canvas.drawPath(path, paint);
                    if (mVar.b.d != 0.0f) {
                        Paint paint2 = new Paint();
                        paint2.setStyle(Paint.Style.STROKE);
                        if (mVar.l > 0.0f) {
                            paint2.setStrokeJoin(Paint.Join.ROUND);
                            paint2.setAntiAlias(true);
                        } else {
                            paint2.setStrokeJoin(Paint.Join.MITER);
                        }
                        paint2.setColor(mVar.b.b);
                        paint2.setStrokeWidth(mVar.b.d);
                        canvas.drawPath(path, paint2);
                    }
                }
            } else {
                ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1029)).p("Styles for CalloutGeometries should have a TextBoxStyle.");
            }
            bitmapCreateBitmap = bitmapCreateBitmap;
        } else {
            bitmapCreateBitmap = bitmapCreateBitmap;
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1028)).p("Callout style type not supported.");
        }
        Bitmap bitmap = bitmapCreateBitmap;
        this.d.put(this.b.g, bitmap);
        return bitmap;
    }

    private static void h(Path path, ay ayVar, ay ayVar2, ay ayVar3) {
        path.lineTo(ayVar.b, ayVar.c);
        path.lineTo(ayVar2.b, ayVar2.c);
        path.lineTo(ayVar3.b, ayVar3.c);
    }

    private static void i(Path path, RectF rectF, float f) {
        path.arcTo(rectF, f, 90.0f);
    }

    @Override // com.google.android.libraries.navigation.internal.qc.a
    public final RectF a() {
        return this.b.j;
    }

    @Override // com.google.android.libraries.navigation.internal.qc.i
    public final et j() {
        er erVarD;
        Bitmap bitmapG = g();
        if (bitmapG == null || (erVarD = this.c.d(bitmapG)) == null) {
            return null;
        }
        return new et(ev.q(erVarD));
    }
}

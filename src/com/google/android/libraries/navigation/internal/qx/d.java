package com.google.android.libraries.navigation.internal.qx;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import androidx.core.view.ViewCompat;
import com.google.android.libraries.geo.mapcore.internal.model.aa;
import com.google.android.libraries.geo.mapcore.internal.model.z;
import com.google.android.libraries.navigation.internal.agg.de;
import com.google.android.libraries.navigation.internal.yx.aq;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class d {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.qx.d");
    private static final int b = Color.argb(255, 0, 0, 0);
    private final c c = new c();
    private final com.google.android.libraries.navigation.internal.agl.a d;

    public d(com.google.android.libraries.navigation.internal.agl.a aVar) {
        this.d = aVar;
    }

    private static Bitmap b(Bitmap bitmap, int i, int i2, Rect rect) {
        byte b2;
        ar.k(bitmap.getHeight() > 0 && (bitmap.getHeight() + (-2)) % 4 == 0);
        ar.k(bitmap.getWidth() > 0 && (bitmap.getWidth() + (-2)) % 4 == 0);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i3 = width - 2;
        int i4 = height - 2;
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        de deVar = new de();
        int i5 = 0;
        int i6 = 0;
        boolean z = false;
        int i7 = 0;
        int i8 = 0;
        int i9 = -1;
        for (int i10 = 1; i10 < width - 1; i10++) {
            boolean z2 = iArr[i10] == -16777216;
            int i11 = iArr[i10 + ((height - 1) * width)];
            if (z2 != z) {
                deVar.c(i6);
                z = z2;
                i6 = 0;
            }
            i6++;
            if (z2) {
                i8++;
            } else {
                i7++;
            }
            if (i11 == -16777216) {
                if (i9 == -1) {
                    i9 = i10 - 1;
                }
                i5++;
            }
        }
        deVar.c(i6);
        int[] iArrM = deVar.M(new int[deVar.b]);
        deVar.clear();
        int i12 = i9;
        int i13 = 0;
        int i14 = -1;
        int i15 = 1;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        boolean z3 = false;
        while (i15 < height - 1) {
            int i19 = i15 * width;
            int i20 = height;
            boolean z4 = iArr[i19] == -16777216;
            int i21 = iArr[(i19 + width) - 1];
            if (z4 != z3) {
                deVar.c(i16);
                z3 = z4;
                i16 = 0;
            }
            i16++;
            if (z4) {
                i13++;
            } else {
                i17++;
            }
            if (i21 == -16777216) {
                b2 = -1;
                if (i14 == -1) {
                    i14 = i15 - 1;
                }
                i18++;
            } else {
                b2 = -1;
            }
            i15++;
            height = i20;
        }
        deVar.c(i16);
        int[] iArrM2 = deVar.M(new int[deVar.b]);
        float fE = com.google.android.libraries.navigation.internal.qy.d.e(i, i7, i8, i5);
        float f = com.google.android.libraries.navigation.internal.qy.d.f(i2, i17, i13, i18);
        int iD = com.google.android.libraries.navigation.internal.qy.d.d(fE, i7, i8);
        int iC = com.google.android.libraries.navigation.internal.qy.d.c(f, i17, i13);
        rect.set(new Rect(i12, i14, iD - ((iD - i12) - Math.max(i5, i)), iC - ((iC - i14) - Math.max(i18, i2))));
        float fE2 = com.google.android.libraries.navigation.internal.qy.d.e(i, i7, i8, i5);
        float f2 = com.google.android.libraries.navigation.internal.qy.d.f(i2, i17, i13, i18);
        if (fE2 == 1.0f && f2 == 1.0f) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.setPixels(iArr, width + 1, width, 0, 0, i3, i4);
            return bitmapCreateBitmap;
        }
        int iD2 = com.google.android.libraries.navigation.internal.qy.d.d(fE2, i7, i8);
        int iC2 = com.google.android.libraries.navigation.internal.qy.d.c(f2, i17, i13);
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(iD2, iC2, Bitmap.Config.ARGB_8888);
        float fE3 = com.google.android.libraries.navigation.internal.qy.d.e(i, i7, i8, i5);
        float f3 = com.google.android.libraries.navigation.internal.qy.d.f(i2, i17, i13, i18);
        int iD3 = com.google.android.libraries.navigation.internal.qy.d.d(fE3, i7, i8);
        int iC3 = com.google.android.libraries.navigation.internal.qy.d.c(f3, i17, i13);
        float[] fArrB = com.google.android.libraries.navigation.internal.qy.d.b(iArrM, fE3);
        float[] fArrB2 = com.google.android.libraries.navigation.internal.qy.d.b(iArrM2, f3);
        int[] iArr2 = new int[iD3 * iC3];
        for (int i22 = 0; i22 < iC3; i22++) {
            for (int i23 = 0; i23 < iD3; i23++) {
                iArr2[(i22 * iD3) + i23] = iArr[((int) com.google.android.libraries.navigation.internal.qy.d.a(fArrB, i23 + 0.5f)) + (((int) com.google.android.libraries.navigation.internal.qy.d.a(fArrB2, i22 + 0.5f)) * width)];
            }
        }
        bitmapCreateBitmap2.setPixels(iArr2, 0, iD2, 0, 0, iD2, iC2);
        return bitmapCreateBitmap2;
    }

    private static final boolean c(z zVar) {
        return !zVar.e().equals(z.a);
    }

    /* JADX WARN: Code duplicated, block: B:111:0x04b4  */
    /* JADX WARN: Multi-variable type inference failed */
    public final Bitmap a(Bitmap[] bitmapArr, com.google.android.libraries.navigation.internal.qy.g gVar, Rect rect) {
        Rect rect2;
        Bitmap bitmap;
        Bitmap bitmapCopy;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Bitmap bitmapCopy2;
        boolean z = ((com.google.android.libraries.navigation.internal.om.f) ((com.google.android.libraries.navigation.internal.om.p) this.d.a()).c()).d;
        Rect rect3 = new Rect();
        Bitmap bitmap2 = null;
        Bitmap bitmap3 = null;
        int i6 = 0;
        while (i6 < bitmapArr.length) {
            if (bitmapArr[i6] != 0) {
                com.google.android.libraries.navigation.internal.qy.a aVar = (com.google.android.libraries.navigation.internal.qy.a) gVar;
                z zVar = (z) aVar.a.get(i6);
                if (zVar.f().contains(".9.png") && aVar.f) {
                    Rect rectA = c.a(aVar.b, aVar.c * 4.0f, com.google.android.libraries.navigation.internal.pz.b.e(aVar.e, z));
                    bitmapCopy = b(bitmapArr[i6], rectA.width(), rectA.height(), rect3);
                } else {
                    try {
                        Bitmap bitmap4 = bitmapArr[i6];
                        bitmapCopy = bitmap4.copy(bitmap4.getConfig(), true);
                    } catch (OutOfMemoryError unused) {
                        Bitmap bitmap5 = bitmap2;
                        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1278)).s("Out of memory copying icon %s", zVar);
                        return bitmap5;
                    }
                }
                if (bitmapCopy == null) {
                    return bitmap2;
                }
                try {
                    int iC = zVar.c();
                    int i7 = ViewCompat.MEASURED_STATE_MASK;
                    if ((iC & ViewCompat.MEASURED_STATE_MASK) == 0) {
                        int i8 = iC & 16777215;
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapCopy.getWidth(), bitmapCopy.getHeight(), Bitmap.Config.ARGB_8888);
                        int height = bitmapCopy.getHeight() * bitmapCopy.getWidth();
                        int[] iArr = new int[height];
                        bitmapCopy.getPixels(iArr, 0, bitmapCopy.getWidth(), 0, 0, bitmapCopy.getWidth(), bitmapCopy.getHeight());
                        int i9 = 0;
                        while (i9 < height) {
                            int i10 = iArr[i9];
                            int i11 = i10 | i7;
                            if (i11 != i7 && i11 != -1) {
                                iArr[i9] = (b & i10) | i8;
                            }
                            i9++;
                            i7 = ViewCompat.MEASURED_STATE_MASK;
                        }
                        bitmapCreateBitmap.setPixels(iArr, 0, bitmapCopy.getWidth(), 0, 0, bitmapCopy.getWidth(), bitmapCopy.getHeight());
                        bitmapCopy = bitmapCreateBitmap;
                    }
                    int iA = zVar.a();
                    if (((-16777216) & iA) != 0) {
                        if (bitmapCopy.isMutable() && bitmapCopy.hasAlpha()) {
                            bitmapCopy2 = bitmapCopy;
                            i5 = 1;
                        } else {
                            i5 = 1;
                            bitmapCopy2 = bitmapCopy.copy(Bitmap.Config.ARGB_8888, true);
                        }
                        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(i5, i5, Bitmap.Config.ARGB_8888);
                        bitmapCreateBitmap2.setPixel(0, 0, iA);
                        Paint paint = new Paint();
                        Canvas canvas = new Canvas(bitmapCopy2);
                        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
                        canvas.drawBitmap(bitmapCreateBitmap2, new Rect(0, 0, 1, 1), new Rect(0, 0, bitmapCopy2.getWidth(), bitmapCopy2.getHeight()), paint);
                        bitmapCopy = bitmapCopy2;
                    }
                    if (bitmap3 == null) {
                        if (c(zVar)) {
                            aa aaVarE = zVar.e();
                            int i12 = ((com.google.android.libraries.geo.mapcore.internal.model.j) aaVarE).a;
                            int i13 = ((com.google.android.libraries.geo.mapcore.internal.model.j) aaVarE).b;
                            int i14 = ((com.google.android.libraries.geo.mapcore.internal.model.j) aaVarE).c;
                            int i15 = ((com.google.android.libraries.geo.mapcore.internal.model.j) aaVarE).d;
                            if (i12 < 0 || i12 > 1024 || i13 < 0 || i13 > 1024 || i14 < 0 || i14 > 1024 || i15 < 0 || i15 > 1024) {
                                ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(1276)).s("Cannot pad with icon with invalid values: %s", aaVarE);
                                z = z;
                                rect3 = rect3;
                                bitmap3 = bitmapCopy;
                            } else {
                                Bitmap bitmapCreateBitmap3 = Bitmap.createBitmap(bitmapCopy.getWidth() + i12 + i14, bitmapCopy.getHeight() + i13 + i15, Bitmap.Config.ARGB_8888);
                                new Canvas(bitmapCreateBitmap3).drawBitmap(bitmapCopy, new Rect(0, 0, bitmapCopy.getWidth(), bitmapCopy.getHeight()), new Rect(i12, i13, bitmapCopy.getWidth() + i12, bitmapCopy.getHeight() + i13), (Paint) null);
                                bitmap3 = bitmapCreateBitmap3;
                                z = z;
                                rect3 = rect3;
                            }
                        } else {
                            z = z;
                            rect3 = rect3;
                            bitmap3 = bitmapCopy;
                        }
                    } else if (c(zVar)) {
                        aa aaVarE2 = zVar.e();
                        int i16 = ((com.google.android.libraries.geo.mapcore.internal.model.j) aaVarE2).a;
                        if (i16 < 0 || i16 > 1024 || (i2 = ((com.google.android.libraries.geo.mapcore.internal.model.j) aaVarE2).b) < 0 || i2 > 1024 || (i3 = ((com.google.android.libraries.geo.mapcore.internal.model.j) aaVarE2).c) < 0 || i3 > 1024 || (i4 = ((com.google.android.libraries.geo.mapcore.internal.model.j) aaVarE2).d) < 0 || i4 > 1024) {
                            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(1275)).s("Cannot pad with icon with invalid values: %s", aaVarE2);
                            aaVarE2 = z.a;
                        }
                        int width = bitmap3.getWidth();
                        int height2 = bitmap3.getHeight();
                        int width2 = bitmapCopy.getWidth();
                        int height3 = bitmapCopy.getHeight();
                        int i17 = width / 2;
                        int i18 = height2 / 2;
                        Canvas canvas2 = new Canvas(bitmap3);
                        Paint paint2 = new Paint();
                        if (width < ((com.google.android.libraries.geo.mapcore.internal.model.j) aaVarE2).a + width2 + ((com.google.android.libraries.geo.mapcore.internal.model.j) aaVarE2).c || height2 < ((com.google.android.libraries.geo.mapcore.internal.model.j) aaVarE2).b + height3 + ((com.google.android.libraries.geo.mapcore.internal.model.j) aaVarE2).d || !bitmap3.isMutable() || !bitmap3.hasAlpha()) {
                            int iMax = Math.max(bitmap3.getWidth(), ((com.google.android.libraries.geo.mapcore.internal.model.j) aaVarE2).a + width2 + ((com.google.android.libraries.geo.mapcore.internal.model.j) aaVarE2).c);
                            int iMax2 = Math.max(bitmap3.getHeight(), ((com.google.android.libraries.geo.mapcore.internal.model.j) aaVarE2).b + height3 + ((com.google.android.libraries.geo.mapcore.internal.model.j) aaVarE2).d);
                            Bitmap bitmapCreateBitmap4 = Bitmap.createBitmap(iMax, iMax2, Bitmap.Config.ARGB_8888);
                            i = iMax / 2;
                            i18 = iMax2 / 2;
                            Canvas canvas3 = new Canvas(bitmapCreateBitmap4);
                            int i19 = width / 2;
                            int i20 = height2 / 2;
                            canvas3.drawBitmap(bitmap3, new Rect(0, 0, bitmap3.getWidth(), bitmap3.getHeight()), new Rect(i - i19, i18 - i20, i19 + i, i20 + i18), paint2);
                            canvas2 = canvas3;
                            bitmap3 = bitmapCreateBitmap4;
                        } else {
                            i = i17;
                        }
                        Rect rect4 = new Rect(0, 0, bitmapCopy.getWidth(), bitmapCopy.getHeight());
                        int i21 = width2 / 2;
                        int i22 = (((com.google.android.libraries.geo.mapcore.internal.model.j) aaVarE2).a - ((com.google.android.libraries.geo.mapcore.internal.model.j) aaVarE2).c) / 2;
                        int i23 = height3 / 2;
                        int i24 = (((com.google.android.libraries.geo.mapcore.internal.model.j) aaVarE2).b - ((com.google.android.libraries.geo.mapcore.internal.model.j) aaVarE2).d) / 2;
                        canvas2.drawBitmap(bitmapCopy, rect4, new Rect((i - i21) + i22, (i18 - i23) + i24, i + i21 + i22, i18 + i23 + i24), paint2);
                    } else {
                        z = z;
                        rect3 = rect3;
                        if (bitmap3.getWidth() < bitmapCopy.getWidth() || bitmap3.getHeight() < bitmapCopy.getHeight() || !bitmap3.isMutable() || !bitmap3.hasAlpha()) {
                            Bitmap bitmapCreateBitmap5 = Bitmap.createBitmap(Math.max(bitmap3.getWidth(), bitmapCopy.getWidth()), Math.max(bitmap3.getHeight(), bitmapCopy.getHeight()), Bitmap.Config.ARGB_8888);
                            int width3 = bitmapCreateBitmap5.getWidth() / 2;
                            int height4 = bitmapCreateBitmap5.getHeight() / 2;
                            Canvas canvas4 = new Canvas(bitmapCreateBitmap5);
                            Paint paint3 = new Paint();
                            canvas4.drawBitmap(bitmap3, new Rect(0, 0, bitmap3.getWidth(), bitmap3.getHeight()), new Rect(width3 - (bitmap3.getWidth() / 2), height4 - (bitmap3.getHeight() / 2), (bitmap3.getWidth() / 2) + width3, (bitmap3.getHeight() / 2) + height4), paint3);
                            canvas4.drawBitmap(bitmapCopy, new Rect(0, 0, bitmapCopy.getWidth(), bitmapCopy.getHeight()), new Rect(width3 - (bitmapCopy.getWidth() / 2), height4 - (bitmapCopy.getHeight() / 2), width3 + (bitmapCopy.getWidth() / 2), height4 + (bitmapCopy.getHeight() / 2)), paint3);
                            bitmap3 = bitmapCreateBitmap5;
                        } else {
                            int width4 = bitmap3.getWidth() / 2;
                            int height5 = bitmap3.getHeight() / 2;
                            int width5 = bitmapCopy.getWidth() / 2;
                            int height6 = bitmapCopy.getHeight() / 2;
                            new Canvas(bitmap3).drawBitmap(bitmapCopy, new Rect(0, 0, bitmapCopy.getWidth(), bitmapCopy.getHeight()), new Rect(width4 - width5, height5 - height6, width4 + width5, height5 + height6), new Paint());
                        }
                    }
                    bitmap = null;
                } catch (OutOfMemoryError unused2) {
                    bitmapCopy.getWidth();
                    bitmapCopy.getHeight();
                    return null;
                }
            } else {
                z = z;
                rect3 = rect3;
                bitmap = bitmap2;
            }
            i6++;
            bitmap2 = bitmap;
            rect3 = rect3;
            z = z;
        }
        boolean z2 = z;
        Rect rect5 = rect3;
        if (bitmap3 != null) {
            com.google.android.libraries.navigation.internal.qy.a aVar2 = (com.google.android.libraries.navigation.internal.qy.a) gVar;
            String str = aVar2.b;
            if (str.isEmpty()) {
                rect2 = rect5;
            } else {
                Rect rectA2 = c.a(str, aVar2.c * 4.0f, com.google.android.libraries.navigation.internal.pz.b.e(aVar2.e, z2));
                Rect rect6 = rect5.isEmpty() ? new Rect(0, 0, bitmap3.getWidth(), bitmap3.getHeight()) : rect5;
                b bVar = new b(bitmap3);
                bVar.a.setTextSize(aVar2.c * 4.0f);
                bVar.a.setColor(aVar2.d);
                bVar.a.setTypeface(com.google.android.libraries.navigation.internal.pz.b.e(aVar2.e, z2));
                int i25 = rect6.left - rectA2.left;
                int iWidth = rect6.width() - rectA2.width();
                int i26 = rect6.top - rectA2.bottom;
                int iHeight = rect6.height() + rectA2.height();
                String str2 = aVar2.b;
                if (!aq.c(str2)) {
                    bVar.b.drawText(str2, i25 + (iWidth / 2), i26 + (iHeight / 2), bVar.a);
                }
                rect2 = rect6;
            }
        } else {
            rect2 = rect5;
        }
        if (bitmap3 != null && !rect2.isEmpty() && rect != null) {
            rect.set(new Rect(rect2.left, rect2.top, bitmap3.getWidth() - rect2.right, bitmap3.getHeight() - rect2.bottom));
        }
        return bitmap3;
    }
}

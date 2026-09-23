package com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Build;
import com.drew.metadata.photoshop.PhotoshopDirectory;
import com.google.android.libraries.geo.mapcore.internal.model.cd;
import com.google.android.libraries.geo.mapcore.internal.model.cp;
import com.google.android.libraries.geo.mapcore.renderer.bq;
import com.google.android.libraries.geo.mapcore.renderer.bt;
import com.google.android.libraries.geo.mapcore.renderer.bv;
import com.google.android.libraries.geo.mapcore.renderer.cs;
import com.google.android.libraries.geo.mapcore.renderer.ex;
import com.google.android.libraries.geo.mapcore.renderer.ey;
import com.google.android.libraries.geo.mapcore.renderer.ff;
import com.google.android.libraries.geo.mapcore.renderer.fg;
import com.google.android.libraries.navigation.internal.adg.fs;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class r implements g {
    public final fs a;
    private int b;

    protected r(byte[] bArr, int i, cd cdVar, ba baVar, bq bqVar, com.google.android.libraries.geo.mapcore.renderer.af afVar, com.google.android.libraries.navigation.internal.ol.w wVar, com.google.android.libraries.geo.mapcore.internal.model.ai aiVar, ex exVar, GmmTextureStyleIdShaderState gmmTextureStyleIdShaderState, byte b, fg fgVar, boolean z, List list, com.google.android.libraries.geo.mapcore.renderer.ax axVar, fs fsVar) {
        boolean z2;
        cs csVar;
        this.a = fsVar;
        if (com.google.android.libraries.geo.mapcore.renderer.ab.a(bArr)) {
            com.google.android.libraries.geo.mapcore.renderer.ab abVar = new com.google.android.libraries.geo.mapcore.renderer.ab(bArr);
            cs csVar2 = new cs(new com.google.android.libraries.geo.mapcore.renderer.aa(abVar), abVar.a, abVar.b);
            this.b = bArr.length;
            csVar = csVar2;
            z2 = true;
        } else {
            try {
                float[] fArr = aiVar.G;
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPurgeable = true;
                options.inInputShareable = true;
                Bitmap.Config config = Bitmap.Config.ARGB_8888;
                if (bArr[0] == -1 && bArr[1] == -40) {
                    config = Bitmap.Config.RGB_565;
                }
                options.inPreferredConfig = config;
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, i, bArr.length - i, options);
                if (bitmapDecodeByteArray != null) {
                    if (Build.VERSION.SDK_INT >= 26 && bitmapDecodeByteArray.getConfig() != config) {
                        bitmapDecodeByteArray = bitmapDecodeByteArray.copy(config, false);
                    }
                    if (fArr != null) {
                        int width = bitmapDecodeByteArray.getWidth();
                        int height = bitmapDecodeByteArray.getHeight();
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, config);
                        if (bitmapCreateBitmap == null) {
                            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.h(com.google.android.libraries.navigation.internal.zb.an.FULL)).F(1049)).t("Bitmap creation failed. width %d height %d", width, height);
                            bitmapDecodeByteArray = null;
                        } else {
                            Paint paint = new Paint();
                            paint.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(fArr)));
                            new Canvas(bitmapCreateBitmap).drawBitmap(bitmapDecodeByteArray, 0.0f, 0.0f, paint);
                            bitmapDecodeByteArray = bitmapCreateBitmap;
                        }
                    }
                } else {
                    bitmapDecodeByteArray = null;
                }
                if (bitmapDecodeByteArray == null) {
                    ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.h(com.google.android.libraries.navigation.internal.zb.an.FULL)).F(1051)).s("Can't load GLRaster bitmap for tile %s", cdVar);
                    return;
                }
                int width2 = bitmapDecodeByteArray.getWidth();
                int height2 = bitmapDecodeByteArray.getHeight();
                boolean zA = bt.a().a(false);
                bitmapDecodeByteArray = zA ? bitmapDecodeByteArray : cs.e(bitmapDecodeByteArray, bitmapDecodeByteArray.getConfig(), false);
                int width3 = bitmapDecodeByteArray.getWidth();
                int height3 = bitmapDecodeByteArray.getHeight();
                this.b = bitmapDecodeByteArray.getByteCount();
                z2 = zA;
                csVar = new cs(new com.google.android.libraries.geo.mapcore.renderer.j(bitmapDecodeByteArray), width2, height2, width3, height3, false);
            } catch (OutOfMemoryError unused) {
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(1052)).s("Can't load GLRaster bitmap for tile %s", cdVar);
                return;
            }
        }
        com.google.android.libraries.geo.mapcore.renderer.ae aeVar = wVar != null ? new com.google.android.libraries.geo.mapcore.renderer.ae(wVar.a, wVar.b, 0L, 0L) : null;
        com.google.android.libraries.navigation.internal.qq.an anVar = aeVar != null ? new com.google.android.libraries.navigation.internal.qq.an(afVar, cdVar, baVar.a, aeVar, z) : new com.google.android.libraries.navigation.internal.qq.an(afVar, cdVar, baVar.a, fgVar, z);
        if (gmmTextureStyleIdShaderState != null) {
            float f = b;
            ff ffVarE = z2 ? e(0.0f, 1.0f, 0.0f, 1.0f, f, bqVar) : e(csVar.c(), csVar.a(), csVar.d(), csVar.b(), f, bqVar);
            ffVarE.c(true);
            anVar.w(ffVarE);
            anVar.v(gmmTextureStyleIdShaderState);
        } else {
            if (z2) {
                bv bvVar = axVar.r;
                if (bvVar.m == null) {
                    bvVar.m = new ff("unit_square_strip", new float[]{0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f}, 17, 5, null);
                }
                anVar.w(bvVar.m);
            } else {
                float fC = csVar.c();
                float fA = csVar.a();
                float fD = csVar.d();
                float fB = csVar.b();
                anVar.w(new ff("raster", new float[]{0.0f, 1.0f, 0.0f, fC, fD, 0.0f, 0.0f, 0.0f, fC, fB, 1.0f, 1.0f, 0.0f, fA, fD, 1.0f, 0.0f, 0.0f, fA, fB}, 17, 5, bqVar));
            }
            anVar.v(exVar);
        }
        anVar.B(0, new ey("raster", csVar, 2, 1));
        anVar.t(1, 771);
        anVar.t = 519;
        list.add(anVar);
        anVar.C(false);
    }

    public static byte c(aj ajVar, com.google.android.libraries.geo.mapcore.internal.model.ba baVar, int i) {
        ag agVar = new ag(baVar, i);
        int iC = ajVar.f.c(agVar);
        if (iC == 1) {
            ajVar.k.add(new com.google.android.libraries.navigation.internal.qh.d());
        } else if (iC == 3) {
            com.google.android.libraries.navigation.internal.zb.j.a aVar = com.google.android.libraries.navigation.internal.zb.j.b;
            new ah(ajVar, "raster", 4);
            ((com.google.android.libraries.navigation.internal.zb.h) aVar.F(PhotoshopDirectory.TAG_ALTERNATE_DUOTONE_COLORS)).o();
            return (byte) 0;
        }
        return ajVar.f.a(agVar);
    }

    public static r d(cd cdVar, ba baVar, bq bqVar, cp cpVar, com.google.android.libraries.geo.mapcore.renderer.ax axVar, com.google.android.libraries.geo.mapcore.renderer.af afVar, ex exVar, GmmTextureStyleIdShaderState gmmTextureStyleIdShaderState, aj ajVar, List list) {
        com.google.android.libraries.geo.mapcore.internal.model.bq bqVar2 = (com.google.android.libraries.geo.mapcore.internal.model.bq) cpVar.next();
        byte[] bArr = bqVar2.a;
        if (bArr == null) {
            return null;
        }
        com.google.android.libraries.geo.mapcore.internal.model.ai aiVarE = ajVar.a.e(bqVar2);
        if (aiVarE.h) {
            return null;
        }
        return new r(bArr, 0, cdVar, baVar, bqVar, afVar, null, aiVarE, exVar, gmmTextureStyleIdShaderState, c(ajVar, bqVar2.q, bqVar2.r), com.google.android.libraries.navigation.internal.qq.an.k(bqVar2, aiVarE), true, list, axVar, bqVar2.b);
    }

    private static ff e(float f, float f2, float f3, float f4, float f5, bq bqVar) {
        return new ff("raster", new float[]{0.0f, 1.0f, 0.0f, f, f3, f5, 0.0f, 0.0f, 0.0f, f, f4, f5, 1.0f, 1.0f, 0.0f, f2, f3, f5, 1.0f, 0.0f, 0.0f, f2, f4, f5}, 2065, 5, bqVar);
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.g
    public final int a() {
        return this.b;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.g
    public final int b() {
        return 96;
    }
}

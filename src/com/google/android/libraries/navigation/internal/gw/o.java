package com.google.android.libraries.navigation.internal.gw;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o {
    public final Resources a;
    private final z b;
    private final n c;

    public o(Application application, z zVar, n nVar) {
        this.a = application.getResources();
        this.b = zVar;
        this.c = nVar;
    }

    @Deprecated
    public static o c() {
        return ((p) com.google.android.libraries.navigation.internal.ii.b.a(p.class)).cb();
    }

    public final Drawable a(Resources resources, int i, x xVar) {
        return b(resources, this.b.a(resources, i), xVar);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x007e  */
    public final Drawable b(Resources resources, Picture picture, x xVar) {
        int iIntValue;
        int iIntValue2;
        int i;
        int iRound;
        com.google.android.libraries.navigation.internal.o.d dVarA;
        Bitmap.Config config = xVar.d() ? Bitmap.Config.ALPHA_8 : Bitmap.Config.ARGB_8888;
        xVar.e();
        Integer numC = xVar.c();
        Integer numB = xVar.b();
        if (numC == null) {
            if (numB == null) {
                float f = resources.getDisplayMetrics().density;
                int iRound2 = Math.round(picture.getWidth() * f);
                iRound = Math.round(picture.getHeight() * f);
                i = iRound2;
            } else {
                iIntValue = Math.round((numB.intValue() * picture.getWidth()) / picture.getHeight());
                iIntValue2 = numB.intValue();
            }
            dVarA = xVar.a();
            if (dVarA == null) {
                dVarA = com.google.android.libraries.navigation.internal.o.d.e(0.0f, 0.0f, i, iRound);
            }
            u uVar = (u) this.c.a.a();
            uVar.getClass();
            picture.getClass();
            config.getClass();
            l lVar = new l(uVar, picture, dVarA, i, iRound, config, -3);
            Paint paint = new Paint();
            paint.setDither(true);
            paint.setFilterBitmap(true);
            return new m(new k(lVar, paint));
        }
        if (numB == null) {
            iIntValue = numC.intValue();
            iIntValue2 = Math.round((numC.intValue() * picture.getHeight()) / picture.getWidth());
        } else {
            iIntValue = numC.intValue();
            iIntValue2 = numB.intValue();
        }
        i = iIntValue;
        iRound = iIntValue2;
        dVarA = xVar.a();
        if (dVarA == null) {
            dVarA = com.google.android.libraries.navigation.internal.o.d.e(0.0f, 0.0f, i, iRound);
        }
        u uVar2 = (u) this.c.a.a();
        uVar2.getClass();
        picture.getClass();
        config.getClass();
        l lVar2 = new l(uVar2, picture, dVarA, i, iRound, config, -3);
        Paint paint2 = new Paint();
        paint2.setDither(true);
        paint2.setFilterBitmap(true);
        return new m(new k(lVar2, paint2));
    }
}

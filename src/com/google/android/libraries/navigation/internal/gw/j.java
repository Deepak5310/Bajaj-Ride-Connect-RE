package com.google.android.libraries.navigation.internal.gw;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.graphics.RectF;
import com.google.android.libraries.navigation.internal.yx.br;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class j implements br {
    final /* synthetic */ Picture a;
    final /* synthetic */ com.google.android.libraries.navigation.internal.o.d b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ Bitmap.Config e;

    public j(Picture picture, com.google.android.libraries.navigation.internal.o.d dVar, int i, int i2, Bitmap.Config config) {
        this.a = picture;
        this.b = dVar;
        this.c = i;
        this.d = i2;
        this.e = config;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.br
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Bitmap a() {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.c, this.d, this.e);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        com.google.android.libraries.navigation.internal.o.b bVar = (com.google.android.libraries.navigation.internal.o.b) this.b;
        float f = bVar.d;
        float f2 = bVar.c;
        canvas.drawPicture(this.a, new RectF(bVar.a, bVar.b, f2, f));
        return bitmapCreateBitmap;
    }
}

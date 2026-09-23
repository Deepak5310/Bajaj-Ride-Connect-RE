package com.google.android.libraries.navigation.internal.abh;

import android.graphics.Bitmap;
import com.google.android.gms.maps.model.StampStyle;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class gw {
    public final StampStyle a;
    public final Bitmap b;
    public final z c;
    public final x d;

    public gw(StampStyle stampStyle, z zVar) {
        com.google.android.libraries.navigation.internal.abf.s.k(stampStyle, "clientStampStyle");
        com.google.android.libraries.navigation.internal.abf.s.k(zVar, "bitmapManager");
        this.a = stampStyle;
        this.c = zVar;
        x xVar = (x) com.google.android.libraries.navigation.internal.lo.n.b(stampStyle.getStamp().a);
        this.d = xVar;
        zVar.b(xVar);
        this.b = zVar.a(xVar);
    }
}

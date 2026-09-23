package com.google.android.libraries.navigation.internal.abh;

import android.graphics.Bitmap;
import com.google.android.gms.maps.model.Cap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class as {
    public final Cap a;
    public final Bitmap b;
    private final z c;
    private final x d;

    /* JADX WARN: Code duplicated, block: B:12:0x0021  */
    public as(Cap cap, z zVar, Bitmap bitmap, x xVar) {
        com.google.android.libraries.navigation.internal.abf.s.k(cap, "clientCap");
        com.google.android.libraries.navigation.internal.abf.s.k(zVar, "bitmapManager");
        int i = cap.a;
        boolean z = true;
        int i2 = 3;
        if (i != 3) {
            if (i == 3 && bitmap == null && xVar == null) {
                i2 = i;
            } else {
                i2 = i;
                z = false;
            }
        } else if (bitmap == null || xVar == null) {
            i = 3;
            if (i == 3) {
                i2 = i;
                z = false;
            } else {
                i2 = i;
                z = false;
            }
        }
        com.google.android.libraries.navigation.internal.abf.s.a(z, String.format("type=%s bitmap=%s descriptor=%s", Integer.valueOf(i2), bitmap, xVar));
        this.a = cap;
        this.c = zVar;
        this.b = bitmap;
        this.d = xVar;
    }

    public static as b(Cap cap, z zVar) {
        com.google.android.libraries.navigation.internal.abf.s.k(cap, "clientCap");
        com.google.android.libraries.navigation.internal.abf.s.k(zVar, "bitmapManager");
        if (cap.a != 3) {
            return new as(cap, zVar, null, null);
        }
        x xVar = (x) com.google.android.libraries.navigation.internal.lo.n.b(cap.b.a);
        zVar.b(xVar);
        return new as(cap, zVar, zVar.a(xVar), xVar);
    }

    public final int a() {
        return this.a.a;
    }

    public final Float c() {
        return this.a.c;
    }

    public final void d() {
        x xVar = this.d;
        if (xVar != null) {
            this.c.c(xVar);
        }
    }
}

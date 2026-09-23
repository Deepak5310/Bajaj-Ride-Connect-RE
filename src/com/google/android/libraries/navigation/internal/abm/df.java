package com.google.android.libraries.navigation.internal.abm;

import android.graphics.Bitmap;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.libraries.navigation.internal.adg.ic;
import com.google.android.libraries.navigation.internal.adg.id;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class df {
    public static final Bitmap a = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
    public static final df b = new df(f.a);
    public final f c;

    public df(f fVar) {
        this.c = fVar;
    }

    public static Bitmap c(PatternItem[] patternItemArr, com.google.android.libraries.navigation.internal.on.c cVar) {
        int i;
        com.google.android.libraries.navigation.internal.abf.s.k(patternItemArr, "patternItems");
        for (PatternItem patternItem : patternItemArr) {
            if (patternItem != null) {
                int i2 = patternItem.a;
                if (i2 == 0) {
                    cVar.c.add(new com.google.android.libraries.navigation.internal.on.a(-1, Math.round((patternItem.b.floatValue() * 8.0f) / cVar.b)));
                } else if (i2 == 1) {
                    cVar.c.add(new com.google.android.libraries.navigation.internal.on.b());
                } else if (i2 == 2) {
                    cVar.c.add(new com.google.android.libraries.navigation.internal.on.a(0, Math.round((patternItem.b.floatValue() * 8.0f) / cVar.b)));
                }
            }
        }
        Iterator it2 = cVar.c.iterator();
        int iA = 0;
        while (it2.hasNext()) {
            iA += ((com.google.android.libraries.navigation.internal.on.d) it2.next()).a(cVar.a);
        }
        if (iA == 0 || (i = cVar.a) == 0) {
            return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        }
        List list = cVar.c;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i * 4 * iA);
        Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            ((com.google.android.libraries.navigation.internal.on.d) it3.next()).b(byteBufferAllocate, cVar.a);
        }
        byteBufferAllocate.position(0);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(cVar.a, iA, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.copyPixelsFromBuffer(byteBufferAllocate);
        return bitmapCreateBitmap;
    }

    public final int a(com.google.android.libraries.navigation.internal.ol.z zVar, Bitmap bitmap, float f) {
        com.google.android.libraries.navigation.internal.abf.s.k(zVar, "phoenixGoogleMap");
        com.google.android.libraries.navigation.internal.abf.s.k(bitmap, "bitmap");
        return ((com.google.android.libraries.navigation.internal.po.dq) zVar.e().l(bitmap, this.c.b(f))).e;
    }

    public final int b(com.google.android.libraries.navigation.internal.ol.z zVar, ic icVar, int i, float f) {
        com.google.android.libraries.navigation.internal.abf.s.k(zVar, "phoenixGoogleMap");
        com.google.android.libraries.navigation.internal.abf.s.k(icVar, "strokeStyleBuilder");
        int iB = this.c.b(f);
        return ((com.google.android.libraries.navigation.internal.po.dq) zVar.e().b(i, iB, zVar.e().d(iB, ev.q(new com.google.android.libraries.navigation.internal.ol.b((id) icVar.t(), null, null, null))))).e;
    }

    public final void d(com.google.android.libraries.navigation.internal.ol.z zVar, int i) {
        com.google.android.libraries.navigation.internal.abf.s.k(zVar, "phoenixGoogleMap");
        zVar.e().j(zVar.e().i().c(i));
    }
}

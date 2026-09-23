package com.google.android.libraries.navigation.internal.ez;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.google.android.libraries.geo.mapcore.internal.model.z;
import com.google.android.libraries.navigation.internal.qx.d;
import com.google.android.libraries.navigation.internal.qy.e;
import com.google.android.libraries.navigation.internal.qy.f;
import com.google.android.libraries.navigation.internal.qy.g;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yx.aq;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements f {
    private final d a;
    private final e b;
    private final com.google.android.libraries.navigation.internal.ey.b c;

    public a(com.google.android.libraries.navigation.internal.ey.b bVar, an anVar, com.google.android.libraries.navigation.internal.agl.a aVar) {
        this.a = new d(aVar);
        this.c = bVar;
        this.b = (e) anVar.f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.qy.f
    public final Bitmap a(g gVar, Bitmap[] bitmapArr, Rect rect) {
        int length;
        Bitmap bitmapDecodeByteArray;
        Bitmap bitmap;
        com.google.android.libraries.navigation.internal.qy.a aVar = (com.google.android.libraries.navigation.internal.qy.a) gVar;
        Bitmap[] bitmapArr2 = new Bitmap[aVar.a.size()];
        for (int i = 0; i < aVar.a.size(); i++) {
            z zVar = (z) aVar.a.get(i);
            if (bitmapArr == null || (bitmap = bitmapArr[i]) == null) {
                String strF = zVar.f();
                byte[] bArrG = zVar.g();
                if (!aq.c(strF) || (bArrG != null && bArrG.length != 0)) {
                    if (bArrG == null || bArrG.length == 0) {
                        bArrG = this.c.a();
                    }
                    if (bArrG == null || (length = bArrG.length) == 0 || (bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrG, 0, length)) == null) {
                        return null;
                    }
                    bitmapArr2[i] = bitmapDecodeByteArray;
                }
            } else {
                bitmapArr2[i] = bitmap;
            }
        }
        return this.a.a(bitmapArr2, gVar, rect);
    }

    @Override // com.google.android.libraries.navigation.internal.qy.f
    public final boolean b(String str, Integer num, com.google.android.libraries.geo.mapcore.internal.model.aq aqVar) {
        d(str);
        if (this.b == null || aqVar == null || num == null) {
            return false;
        }
        Objects.toString(num);
        d("paint-parameters-epoch-".concat(num.toString()));
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.qy.b
    public final void c(String str) {
        this.c.a();
    }

    public final void d(String str) {
        this.c.b();
    }
}

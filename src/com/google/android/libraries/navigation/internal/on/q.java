package com.google.android.libraries.navigation.internal.on;

import android.graphics.Bitmap;
import com.google.android.libraries.navigation.internal.ol.ax;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class q {
    public final ax a;
    public final Map b = new HashMap();
    public final Map c = new EnumMap(com.google.android.libraries.navigation.internal.adg.b.class);

    public q(ax axVar) {
        this.a = axVar;
    }

    public final synchronized l a(com.google.android.libraries.navigation.internal.adg.b bVar) {
        p pVar = (p) this.c.get(bVar);
        if (pVar != null) {
            pVar.d();
            return pVar;
        }
        n nVar = new n(this, bVar);
        this.c.put(bVar, nVar);
        return nVar;
    }

    public final l b(long j) {
        return new m(this.a.g(j));
    }

    public final synchronized l c(Bitmap bitmap) {
        if (bitmap.isMutable()) {
            return new o(this, bitmap);
        }
        p pVar = (p) this.b.get(bitmap);
        if (pVar != null) {
            pVar.d();
            return pVar;
        }
        o oVar = new o(this, bitmap);
        this.b.put(bitmap, oVar);
        return oVar;
    }
}

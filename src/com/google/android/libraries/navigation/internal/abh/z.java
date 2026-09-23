package com.google.android.libraries.navigation.internal.abh;

import android.graphics.Bitmap;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class z {
    final Map a;
    private final be b;

    public z(be beVar) {
        com.google.android.libraries.navigation.internal.abf.s.k(beVar, "contextManager");
        this.b = beVar;
        this.a = new HashMap();
    }

    public final synchronized Bitmap a(x xVar) {
        y yVar;
        yVar = (y) this.a.get(xVar);
        com.google.android.libraries.navigation.internal.abf.s.a(yVar != null, "Unmanaged descriptor");
        return yVar.b;
    }

    public final void b(x xVar) {
        synchronized (this) {
            y yVar = (y) this.a.get(xVar);
            if (yVar != null) {
                yVar.a++;
                return;
            }
            Bitmap bitmapA = xVar.a(this.b);
            synchronized (this) {
                y yVar2 = (y) this.a.get(xVar);
                if (yVar2 == null) {
                    this.a.put(xVar, new y(bitmapA));
                } else {
                    yVar2.a++;
                }
            }
        }
    }

    public final synchronized void c(x xVar) {
        y yVar = (y) this.a.get(xVar);
        if (yVar == null) {
            com.google.android.libraries.navigation.internal.abf.p.c("Unmanaged Bitmap descriptor");
            return;
        }
        int i = yVar.a;
        if (i == 1) {
            this.a.remove(xVar);
        } else {
            yVar.a = i - 1;
        }
    }
}

package com.google.android.libraries.navigation.internal.ps;

import androidx.tracing.Trace;
import com.google.android.libraries.geo.mapcore.renderer.ex;
import com.google.android.libraries.navigation.internal.po.gr;
import com.google.android.libraries.navigation.internal.qq.an;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class q implements Runnable {
    public final float a;
    public boolean d;
    public final gr e;
    public final List c = new ArrayList();
    private final List f = new ArrayList();
    public final List b = new ArrayList();

    public q(float f, gr grVar) {
        this.a = f;
        this.e = grVar;
    }

    public final void a(an anVar) {
        if (this.a < 0.0f) {
            this.f.add(anVar);
            this.e.d(this);
            this.e.b();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("IndoorTileRunnable.run");
        try {
            Iterator it2 = this.c.iterator();
            while (it2.hasNext()) {
                ((ex) it2.next()).a(true != this.d ? 0.0f : 1.0f);
            }
            int i = true != this.d ? 1 : 3;
            for (an anVar : this.b) {
                anVar.u = true;
                anVar.v = 519;
                anVar.w = i;
                anVar.x = 3;
            }
            Iterator it3 = this.f.iterator();
            while (it3.hasNext()) {
                ((an) it3.next()).x(1, 1);
            }
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}

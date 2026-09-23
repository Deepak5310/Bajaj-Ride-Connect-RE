package com.google.android.libraries.navigation.internal.po;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.DisplayMetrics;
import androidx.tracing.Trace;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class fz implements com.google.android.libraries.navigation.internal.yx.br {
    final /* synthetic */ gm a;

    public fz(gm gmVar) {
        this.a = gmVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.br
    public final /* bridge */ /* synthetic */ Object a() {
        gm gmVar = this.a;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("PhoenixGoogleMapActivityEnvironment.createGmmCamera");
        try {
            DisplayMetrics displayMetrics = gmVar.f525n.getDisplayMetrics();
            com.google.android.libraries.navigation.internal.ob.f fVar = (com.google.android.libraries.navigation.internal.ob.f) gmVar.i.a();
            final com.google.android.libraries.geo.mapcore.renderer.ax axVar = (com.google.android.libraries.geo.mapcore.renderer.ax) gmVar.j.a();
            if (gmVar.f525n.getDisplayMetrics().widthPixels > 0 && gmVar.f525n.getDisplayMetrics().heightPixels > 0) {
                com.google.android.libraries.navigation.internal.pd.d dVarC = fVar.c();
                int i = displayMetrics.widthPixels;
                int i2 = displayMetrics.heightPixels;
                float f = displayMetrics.density;
                Objects.requireNonNull(axVar);
                com.google.android.libraries.navigation.internal.pb.t tVar = new com.google.android.libraries.navigation.internal.pb.t(dVarC, i, i2, f, new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.fp
                    @Override // java.lang.Runnable
                    public final void run() {
                        axVar.o();
                    }
                }, gmVar.r);
                tVar.g = true;
                if (dVarB != null) {
                    Trace.endSection();
                }
                return tVar;
            }
            String strConcat = String.format("Resources.size=%sx%s; ActivityContext.Resources.size=%sx%s; ApplicationContext.Resources.size=%sx%s", Integer.valueOf(gmVar.f525n.getDisplayMetrics().widthPixels), Integer.valueOf(gmVar.f525n.getDisplayMetrics().heightPixels), Integer.valueOf(gmVar.e.getResources().getDisplayMetrics().widthPixels), Integer.valueOf(gmVar.e.getResources().getDisplayMetrics().heightPixels), Integer.valueOf(gmVar.c.getResources().getDisplayMetrics().widthPixels), Integer.valueOf(gmVar.c.getResources().getDisplayMetrics().heightPixels));
            Context baseContext = gmVar.e;
            while (baseContext instanceof ContextWrapper) {
                baseContext = ((ContextWrapper) baseContext).getBaseContext();
                strConcat = String.valueOf(strConcat).concat(String.valueOf(String.format("; ActivityContext.base.Resources.size=%s.%s", Integer.valueOf(baseContext.getResources().getDisplayMetrics().widthPixels), Integer.valueOf(baseContext.getResources().getDisplayMetrics().heightPixels))));
            }
            throw new IllegalStateException(strConcat);
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

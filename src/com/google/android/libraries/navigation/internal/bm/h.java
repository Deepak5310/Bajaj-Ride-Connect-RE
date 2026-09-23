package com.google.android.libraries.navigation.internal.bm;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.afl.ku;
import com.google.android.libraries.navigation.internal.afl.kw;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h implements com.google.android.libraries.navigation.internal.bn.d {
    public final Executor a;
    public final Context b;
    final Application.ActivityLifecycleCallbacks c;
    public final ConcurrentMap d;
    private final com.google.android.libraries.navigation.internal.qy.h e;

    public h(Application application, Executor executor, com.google.android.libraries.navigation.internal.qy.h hVar) {
        c cVar = new c(this);
        this.c = cVar;
        this.d = new ConcurrentHashMap();
        this.b = application;
        this.a = executor;
        this.e = hVar;
        application.registerActivityLifecycleCallbacks(cVar);
    }

    @Override // com.google.android.libraries.navigation.internal.bn.d
    public final Drawable a(String str, com.google.android.libraries.navigation.internal.gw.x xVar) {
        com.google.android.libraries.navigation.internal.nc.ah ahVarC = c(str, xVar);
        if (ahVarC == null) {
            return null;
        }
        return ahVarC.a(this.b);
    }

    @Override // com.google.android.libraries.navigation.internal.bn.d
    public final com.google.android.libraries.navigation.internal.nc.ah b(String str, com.google.android.libraries.navigation.internal.bn.a aVar, boolean z, com.google.android.libraries.navigation.internal.gw.x xVar) {
        String strE = e(str, aVar, z);
        if (strE == null) {
            return null;
        }
        return c(strE, xVar);
    }

    @Override // com.google.android.libraries.navigation.internal.bn.d
    public final com.google.android.libraries.navigation.internal.nc.ah c(String str, com.google.android.libraries.navigation.internal.gw.x xVar) {
        return d(str, xVar, null);
    }

    @Override // com.google.android.libraries.navigation.internal.bn.d
    public final com.google.android.libraries.navigation.internal.nc.ah d(String str, com.google.android.libraries.navigation.internal.gw.x xVar, com.google.android.libraries.navigation.internal.bn.b bVar) {
        return this.e.b(str, "DIRECTIONS_ICON_MANAGER_IMPL", bVar != null ? new g(this, xVar, bVar) : null).g(xVar);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0018  */
    @Override // com.google.android.libraries.navigation.internal.bn.d
    public final String e(String str, com.google.android.libraries.navigation.internal.bn.a aVar, boolean z) {
        ku kuVar;
        int iOrdinal = aVar.ordinal();
        if (iOrdinal == 1) {
            kuVar = ku.SVG_LIGHT;
        } else if (iOrdinal == 2) {
            kuVar = ku.SVG_DARK;
        } else if (iOrdinal == 3) {
            kuVar = ku.SVG_INCIDENT_LIGHT;
        } else if (z) {
            kuVar = ku.SVG_DARK;
        } else {
            kuVar = ku.SVG_LIGHT;
        }
        kw kwVar = (kw) this.d.get(new com.google.android.libraries.navigation.internal.yx.ao(str, kuVar));
        if (kwVar == null) {
            return null;
        }
        return kwVar.e;
    }

    public final void f(Collection collection) {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("DirectionsIconManagerImpl.registerIcons()");
        try {
            Iterator it2 = collection.iterator();
            while (it2.hasNext()) {
                kw kwVar = (kw) it2.next();
                int i = kwVar.b;
                if ((i & 1) == 0 || (i & 2) == 0 || (i & 4) == 0) {
                    int i2 = kwVar.b;
                    int i3 = kwVar.b;
                } else {
                    ConcurrentMap concurrentMap = this.d;
                    String str = kwVar.c;
                    ku kuVarB = ku.b(kwVar.d);
                    if (kuVarB == null) {
                        kuVarB = ku.PIXEL_15;
                    }
                    concurrentMap.put(new com.google.android.libraries.navigation.internal.yx.ao(str, kuVarB), kwVar);
                }
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

    @Override // com.google.android.libraries.navigation.internal.bn.d
    public final Drawable g(String str, com.google.android.libraries.navigation.internal.bn.a aVar, boolean z, com.google.android.libraries.navigation.internal.br.u uVar) {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("DirectionsIconManagerImpl.createDrawable");
        try {
            String strE = e(str, aVar, z);
            Drawable drawableA = null;
            if (strE != null) {
                com.google.android.libraries.navigation.internal.nc.ah ahVarG = this.e.b(strE, "DIRECTIONS_ICON_MANAGER_IMPL", uVar != null ? new e(this, uVar) : null).g(com.google.android.libraries.navigation.internal.gw.x.c);
                if (ahVarG != null) {
                    drawableA = ahVarG.a(this.b);
                }
            }
            if (dVarB != null) {
                Trace.endSection();
            }
            return drawableA;
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

    @Override // com.google.android.libraries.navigation.internal.bn.d
    public final void h(Collection collection) {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("DirectionsIconManagerImpl.requestIconsByUrls");
        try {
            if (!collection.isEmpty()) {
                HashSet hashSet = new HashSet();
                Iterator it2 = collection.iterator();
                while (it2.hasNext()) {
                    hashSet.add(this.e.b((String) it2.next(), "DIRECTIONS_ICON_MANAGER_IMPL", null));
                }
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

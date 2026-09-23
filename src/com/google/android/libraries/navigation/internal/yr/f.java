package com.google.android.libraries.navigation.internal.yr;

import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f {
    private static final boolean a = true;
    private static final WeakHashMap b = new WeakHashMap();
    private static final WeakHashMap c = new WeakHashMap();

    public static void a(Throwable th) {
        Throwable cause;
        av avVar;
        synchronized (c) {
            cause = th;
            while (cause != null) {
                if (c.containsKey(cause)) {
                    break;
                } else {
                    cause = cause.getCause();
                }
            }
            c.put(th, Boolean.valueOf(cause != null));
        }
        if (cause != null) {
            return;
        }
        com.google.android.libraries.navigation.internal.yx.ar.l(true, "Trace uncaught exception is disabled.");
        synchronized (b) {
            Throwable cause2 = th;
            while (cause2 != null) {
                try {
                    if (b.containsKey(cause2)) {
                        break;
                    } else {
                        cause2 = cause2.getCause();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (cause2 == null) {
                avVar = null;
            } else {
                WeakHashMap weakHashMap = b;
                weakHashMap.put(th, (ak) weakHashMap.get(cause2));
                avVar = new av();
            }
        }
        if (avVar == null) {
            ArrayList arrayList = new ArrayList();
            for (ag agVarB = i.b(); agVarB != null; agVarB = agVarB.a()) {
                arrayList.add(agVarB);
            }
            eq eqVarJ = ev.j(arrayList.size());
            eq eqVarJ2 = ev.j(arrayList.size());
            for (ag agVar : hx.g(arrayList)) {
                eqVarJ2.h(agVar.b());
                eqVarJ.h(agVar.h());
            }
            ev evVarG = eqVarJ2.g();
            eqVarJ.g();
            ak akVar = new ak(evVarG);
            WeakHashMap weakHashMap2 = b;
            synchronized (weakHashMap2) {
                weakHashMap2.put(th, akVar);
            }
        }
    }
}

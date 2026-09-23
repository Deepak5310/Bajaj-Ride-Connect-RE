package com.google.android.libraries.navigation.internal.zd;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aj {
    public static final g a;
    private static final Set b;

    static {
        Set setSingleton = Collections.singleton(com.google.android.libraries.navigation.internal.zb.o.a);
        b = setSingleton;
        a = new ai(setSingleton);
    }

    public static String a(f fVar) {
        return l.b(fVar.k());
    }

    public static boolean b(f fVar, ae aeVar, Set set) {
        return (fVar.j() == null && aeVar.a() <= set.size() && set.containsAll(aeVar.c())) ? false : true;
    }

    public static void c(ae aeVar, u uVar, StringBuilder sb) {
        e eVar = new e(sb);
        aeVar.d(uVar, eVar);
        if (eVar.c) {
            eVar.b.append(eVar.a);
        }
    }
}

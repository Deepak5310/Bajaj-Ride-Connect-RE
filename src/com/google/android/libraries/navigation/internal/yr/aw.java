package com.google.android.libraries.navigation.internal.yr;

import java.util.UUID;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aw {
    /* JADX WARN: Multi-variable type inference failed */
    public static t a(t tVar, ax axVar) {
        com.google.android.libraries.navigation.internal.yx.ar.q(axVar);
        return i.d(tVar);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use [com.google.apps.tiktok.tracing.span] in kotlin instead.")
    public static w b(String str, ax axVar) {
        return c(str, axVar, y.a, true);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use [com.google.apps.tiktok.tracing.span] in kotlin instead.")
    public static w c(String str, ax axVar, z zVar, boolean z) {
        boolean z2;
        ag agVarE;
        s sVar;
        com.google.android.libraries.navigation.internal.yx.ar.q(axVar);
        ae aeVarA = i.a();
        ag agVar = aeVarA.b;
        if (agVar == u.b) {
            i.e(aeVarA, null);
            z2 = true;
            agVar = null;
        } else {
            z2 = false;
        }
        if (agVar == null) {
            UUID uuidB = m.a.b();
            if (ah.a()) {
                b bVar = new b();
                s.k(uuidB, bVar);
                sVar = new s(uuidB, str, zVar, bVar, z, i.h(bVar), aeVarA);
            } else {
                b bVar2 = q.b;
                s.k(uuidB, null);
                sVar = new s(uuidB, str, zVar, bVar2, z, false, aeVarA);
            }
            boolean z3 = sVar.b;
            agVarE = sVar;
            agVarE = sVar;
            if (!z3 && z) {
                i.j();
                agVarE = sVar;
            }
        } else {
            agVarE = agVar instanceof d ? ((d) agVar).e(str, zVar, z, aeVarA) : agVar.j(str, zVar, aeVarA);
        }
        i.e(aeVarA, agVarE);
        return new w(agVarE, z2);
    }

    public static boolean d(ax axVar) {
        com.google.android.libraries.navigation.internal.yx.ar.q(axVar);
        return i.i();
    }
}

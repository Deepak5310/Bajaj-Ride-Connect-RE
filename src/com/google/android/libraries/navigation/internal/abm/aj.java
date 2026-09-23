package com.google.android.libraries.navigation.internal.abm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aj {
    public final com.google.android.libraries.navigation.internal.pq.b a;
    private final ai b;

    public aj(com.google.android.libraries.navigation.internal.pq.b bVar) {
        ai aiVar = ai.a;
        com.google.android.libraries.navigation.internal.abf.s.k(bVar, "phoenixIndoorMapController");
        this.a = bVar;
        this.b = aiVar;
    }

    public final void a(Object obj) {
        com.google.android.libraries.navigation.internal.abf.s.k(obj, "levelId");
        com.google.android.libraries.navigation.internal.abf.s.b(true, "levelId type: %s", obj.getClass().getName());
        this.a.h((com.google.android.libraries.navigation.internal.oe.i) obj);
    }

    public final int b(ag agVar) {
        com.google.android.libraries.navigation.internal.abf.s.k(agVar, "building");
        int iA = this.a.a((com.google.android.libraries.navigation.internal.oe.i) agVar.c());
        return iA == -1 ? agVar.a() : iA;
    }

    public final ag c() {
        com.google.android.libraries.navigation.internal.pt.a aVarB = this.a.b();
        if (aVarB == null) {
            return null;
        }
        return new ag(aVarB);
    }
}

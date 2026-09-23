package com.google.android.libraries.navigation.internal.yr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class at {
    private final ag a;

    public at(ag agVar) {
        this.a = agVar;
    }

    public static at a(ax axVar) {
        com.google.android.libraries.navigation.internal.yx.ar.q(axVar);
        return new at(i.b());
    }

    public static void b(at atVar) {
        i.d(atVar.a);
    }

    public final String toString() {
        ag agVar = this.a;
        return agVar == null ? "null ref" : agVar.toString();
    }
}

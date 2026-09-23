package com.google.android.libraries.navigation.internal.xe;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class fu implements com.google.android.libraries.navigation.internal.gg.e {
    final /* synthetic */ com.google.android.libraries.navigation.internal.afm.b a;
    final /* synthetic */ int b;
    final /* synthetic */ fv c;

    public fu(fv fvVar, com.google.android.libraries.navigation.internal.afm.b bVar, int i) {
        this.a = bVar;
        this.b = i;
        this.c = fvVar;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.e
    public final void a(com.google.android.libraries.navigation.internal.gg.i iVar, com.google.android.libraries.navigation.internal.gg.o oVar) {
        if (com.google.android.libraries.navigation.internal.afw.j.c() && Objects.equals(oVar, com.google.android.libraries.navigation.internal.gg.o.h)) {
            fv fvVar = this.c;
            com.google.android.libraries.navigation.internal.afm.d dVarB = com.google.android.libraries.navigation.internal.afm.d.b(((com.google.android.libraries.navigation.internal.afm.e) this.a.b).c);
            if (dVarB == null) {
                dVarB = com.google.android.libraries.navigation.internal.afm.d.UNKNOWN_EVENT_TYPE;
            }
            fvVar.c.put(dVarB, null);
            com.google.android.libraries.navigation.internal.afm.d dVarB2 = com.google.android.libraries.navigation.internal.afm.d.b(((com.google.android.libraries.navigation.internal.afm.e) this.a.b).c);
            if (dVarB2 == null) {
                dVarB2 = com.google.android.libraries.navigation.internal.afm.d.UNKNOWN_EVENT_TYPE;
            }
            if (dVarB2 != com.google.android.libraries.navigation.internal.afm.d.NAVIGATION_INIT) {
                this.c.d();
                return;
            }
            return;
        }
        fv fvVar2 = this.c;
        com.google.android.libraries.navigation.internal.afm.d dVarB3 = com.google.android.libraries.navigation.internal.afm.d.b(((com.google.android.libraries.navigation.internal.afm.e) this.a.b).c);
        if (dVarB3 == null) {
            dVarB3 = com.google.android.libraries.navigation.internal.afm.d.UNKNOWN_EVENT_TYPE;
        }
        fvVar2.e(dVarB3, false);
        final int i = this.b;
        if (i + 1 < 8) {
            long jPow = (long) Math.pow(2.0d, i);
            fv fvVar3 = this.c;
            final com.google.android.libraries.navigation.internal.afm.b bVar = this.a;
            fvVar3.b.schedule(new Runnable() { // from class: com.google.android.libraries.navigation.internal.xe.ft
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.c.g(bVar, i + 1);
                }
            }, jPow, TimeUnit.SECONDS);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.gg.e
    public final /* bridge */ /* synthetic */ void b(com.google.android.libraries.navigation.internal.gg.i iVar, Object obj) {
        int iA = com.google.android.libraries.navigation.internal.afm.i.a(((com.google.android.libraries.navigation.internal.afm.j) obj).c);
        if (iA == 0) {
            iA = com.google.android.libraries.navigation.internal.afm.i.a;
        }
        fv fvVar = this.c;
        com.google.android.libraries.navigation.internal.afm.d dVarB = com.google.android.libraries.navigation.internal.afm.d.b(((com.google.android.libraries.navigation.internal.afm.e) this.a.b).c);
        if (dVarB == null) {
            dVarB = com.google.android.libraries.navigation.internal.afm.d.UNKNOWN_EVENT_TYPE;
        }
        fvVar.e(dVarB, iA == com.google.android.libraries.navigation.internal.afm.i.a);
    }
}

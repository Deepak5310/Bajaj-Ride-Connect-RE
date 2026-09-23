package com.google.android.libraries.navigation.internal.sv;

import com.google.android.libraries.navigation.internal.adr.Cdo;
import java.util.Objects;
import java.util.Optional;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bj {
    public final com.google.android.libraries.navigation.internal.kl.b a;
    public final boolean b;
    private final com.google.android.libraries.navigation.internal.rw.f c;
    private final com.google.android.libraries.navigation.internal.tt.d d;

    public bj(com.google.android.libraries.navigation.internal.kl.b bVar, com.google.android.libraries.navigation.internal.rw.f fVar, com.google.android.libraries.navigation.internal.tt.d dVar) {
        this.a = bVar;
        this.c = fVar;
        this.d = dVar;
        boolean z = true;
        if (dVar.m() != Cdo.INCIDENT_SPEED_TRAP && dVar.m() != Cdo.INCIDENT_POLICE_PRESENCE) {
            z = false;
        }
        this.b = z;
    }

    private final Optional c() {
        com.google.android.libraries.navigation.internal.tj.j jVar = ((com.google.android.libraries.navigation.internal.rw.i) this.c.a()).d;
        if (jVar == null) {
            return Optional.empty();
        }
        Integer numN = this.d.n();
        if (numN == null) {
            return Optional.empty();
        }
        double dA = jVar.c().a();
        com.google.android.libraries.navigation.internal.bp.bg bgVar = jVar.c().b;
        return dA < ((double) numN.intValue()) ? Optional.of(Long.valueOf(-bgVar.K(dA, numN.intValue()).toMillis())) : Optional.of(Long.valueOf(bgVar.K(numN.intValue(), dA).toMillis()));
    }

    public final void a() {
        if (this.b) {
            Optional optionalC = c();
            com.google.android.libraries.navigation.internal.kk.l lVar = (com.google.android.libraries.navigation.internal.kk.l) this.a.a(com.google.android.libraries.navigation.internal.km.af.c);
            Objects.requireNonNull(lVar);
            optionalC.ifPresent(new bi(lVar));
        }
    }

    public final void b() {
        if (this.b && this.d.C()) {
            Optional optionalC = c();
            com.google.android.libraries.navigation.internal.kk.l lVar = (com.google.android.libraries.navigation.internal.kk.l) this.a.a(com.google.android.libraries.navigation.internal.km.af.a);
            Objects.requireNonNull(lVar);
            optionalC.ifPresent(new bi(lVar));
        }
    }
}

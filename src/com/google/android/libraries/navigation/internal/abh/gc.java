package com.google.android.libraries.navigation.internal.abh;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class gc extends com.google.android.libraries.navigation.internal.abg.h {
    private final com.google.android.libraries.navigation.internal.afm.d b;
    private final gf c;
    private final com.google.android.libraries.navigation.internal.abf.u d;
    private com.google.android.libraries.navigation.internal.afm.f e;

    public gc(com.google.android.libraries.navigation.internal.afm.d dVar, gf gfVar, com.google.android.libraries.navigation.internal.abf.u uVar) {
        this.b = dVar;
        this.c = gfVar;
        this.d = uVar;
        synchronized (this) {
            this.e = null;
        }
    }

    private final synchronized com.google.android.libraries.navigation.internal.afm.f k() {
        return this.e;
    }

    private final synchronized void l(com.google.android.libraries.navigation.internal.afm.f fVar) {
        this.e = fVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abg.h, com.google.android.libraries.navigation.internal.abg.n
    public final void a() {
        super.a();
        this.c.d(k(), true);
        l(null);
    }

    @Override // com.google.android.libraries.navigation.internal.abg.h, com.google.android.libraries.navigation.internal.abg.n
    public final void b() {
        super.b();
        this.c.d(k(), false);
        l(null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof gc)) {
            return false;
        }
        gc gcVar = (gc) obj;
        return com.google.android.libraries.navigation.internal.abf.r.a(this.b, gcVar.b) && com.google.android.libraries.navigation.internal.abf.r.a(k(), gcVar.k());
    }

    @Override // com.google.android.libraries.navigation.internal.abg.n
    public final int h() {
        return 147;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, k()});
    }

    @Override // com.google.android.libraries.navigation.internal.abg.n
    public final void i(DataOutputStream dataOutputStream) throws IOException {
        com.google.android.libraries.navigation.internal.afm.f fVar;
        com.google.android.libraries.navigation.internal.afm.f fVarA = this.c.a();
        if (fVarA == null) {
            fVar = null;
        } else {
            com.google.android.libraries.navigation.internal.afm.a aVar = (com.google.android.libraries.navigation.internal.afm.a) com.google.android.libraries.navigation.internal.afm.f.a.q();
            for (int i = 0; i < fVarA.c.size(); i++) {
                com.google.android.libraries.navigation.internal.afm.e eVar = (com.google.android.libraries.navigation.internal.afm.e) fVarA.c.get(i);
                com.google.android.libraries.navigation.internal.afm.d dVarB = com.google.android.libraries.navigation.internal.afm.d.b(eVar.c);
                if (dVarB == null) {
                    dVarB = com.google.android.libraries.navigation.internal.afm.d.UNKNOWN_EVENT_TYPE;
                }
                com.google.android.libraries.navigation.internal.afm.d dVar = this.b;
                if (dVarB == dVar) {
                    aVar.d(eVar);
                    if (dVar == com.google.android.libraries.navigation.internal.afm.d.PREMIUM_MAP_LOAD) {
                        String str = eVar.e;
                        if (!aVar.b.H()) {
                            aVar.v();
                        }
                        com.google.android.libraries.navigation.internal.afm.f fVar2 = (com.google.android.libraries.navigation.internal.afm.f) aVar.b;
                        str.getClass();
                        fVar2.b |= 2;
                        fVar2.d = str;
                    }
                }
            }
            fVar = (com.google.android.libraries.navigation.internal.afm.f) aVar.t();
        }
        l(fVar);
        if (fVar == null || fVar.c.size() == 0) {
            return;
        }
        com.google.android.libraries.navigation.internal.abf.p.f(gf.a, 4);
        this.d.b(dataOutputStream, fVar);
    }

    @Override // com.google.android.libraries.navigation.internal.abg.n
    public final void j(DataInputStream dataInputStream) throws IOException {
        com.google.android.libraries.navigation.internal.afm.f fVarK = k();
        if (fVarK == null || fVarK.c.size() == 0) {
            return;
        }
        com.google.android.libraries.navigation.internal.afm.j jVar = (com.google.android.libraries.navigation.internal.afm.j) this.d.a((com.google.android.libraries.navigation.internal.ael.dg) com.google.android.libraries.navigation.internal.afm.j.a.aH(7, null), dataInputStream);
        int iA = com.google.android.libraries.navigation.internal.afm.i.a(jVar.c);
        if (iA == 0) {
            iA = com.google.android.libraries.navigation.internal.afm.i.a;
        }
        int i = jVar.b;
        String str = (i & 4) != 0 ? jVar.d : null;
        String str2 = (i & 8) != 0 ? jVar.e : null;
        com.google.android.libraries.navigation.internal.abf.p.f(gf.a, 4);
        int i2 = iA - 1;
        if (iA == 0) {
            throw null;
        }
        if (i2 == 0) {
            this.c.c(this.b, false, false, str, str2);
        } else if (i2 == 1) {
            this.c.c(this.b, false, true, str, str2);
        } else {
            if (i2 != 2) {
                return;
            }
            this.c.c(this.b, true, false, str, str2);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abg.h
    public final String toString() {
        com.google.android.libraries.navigation.internal.abf.aj ajVarF = com.google.android.libraries.navigation.internal.abf.aj.f(this);
        ajVarF.g("requestEventType", this.b);
        ajVarF.g("requestQuotaEvents", k());
        return ajVarF.toString();
    }
}

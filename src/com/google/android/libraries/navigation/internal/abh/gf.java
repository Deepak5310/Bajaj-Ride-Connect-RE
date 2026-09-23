package com.google.android.libraries.navigation.internal.abh;

import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class gf {
    public static final String a = "gf";
    boolean b;
    private final com.google.android.libraries.navigation.internal.yx.br c;
    private final ge d;
    private final HashMap e;
    private final com.google.android.libraries.navigation.internal.abf.h f;

    public gf(com.google.android.libraries.navigation.internal.yx.br brVar, ge geVar, com.google.android.libraries.navigation.internal.abf.h hVar) {
        new HashSet();
        com.google.android.libraries.navigation.internal.abf.s.k(brVar, "drd");
        this.c = brVar;
        this.d = geVar;
        this.f = hVar;
        synchronized (this) {
            this.b = false;
            this.e = new HashMap();
        }
    }

    private final void f() {
        synchronized (this) {
            if (this.b) {
                return;
            }
            com.google.android.libraries.navigation.internal.afm.f fVarA = a();
            if (fVarA != null && fVarA.c.size() != 0) {
                com.google.android.libraries.navigation.internal.afm.d dVarB = com.google.android.libraries.navigation.internal.afm.d.b(((com.google.android.libraries.navigation.internal.afm.e) fVarA.c.get(0)).c);
                if (dVarB == null) {
                    dVarB = com.google.android.libraries.navigation.internal.afm.d.UNKNOWN_EVENT_TYPE;
                }
                this.b = true;
                ((com.google.android.libraries.navigation.internal.abg.q) this.c.a()).j(new gc(dVarB, this, com.google.android.libraries.navigation.internal.abf.u.a));
            }
        }
    }

    public final synchronized com.google.android.libraries.navigation.internal.afm.f a() {
        return (com.google.android.libraries.navigation.internal.afm.f) this.f.a();
    }

    public final void b(com.google.android.libraries.navigation.internal.afm.d dVar, String str, ea eaVar) {
        com.google.android.libraries.navigation.internal.afm.a aVar;
        com.google.android.libraries.navigation.internal.abf.p.f(a, 4);
        com.google.android.libraries.navigation.internal.afm.b bVar = (com.google.android.libraries.navigation.internal.afm.b) com.google.android.libraries.navigation.internal.afm.e.a.q();
        if (!bVar.b.H()) {
            bVar.v();
        }
        com.google.android.libraries.navigation.internal.afm.e eVar = (com.google.android.libraries.navigation.internal.afm.e) bVar.b;
        eVar.c = dVar.k;
        eVar.b |= 1;
        if (!com.google.android.libraries.navigation.internal.abf.x.a(str)) {
            if (!bVar.b.H()) {
                bVar.v();
            }
            com.google.android.libraries.navigation.internal.afm.e eVar2 = (com.google.android.libraries.navigation.internal.afm.e) bVar.b;
            str.getClass();
            eVar2.b |= 16;
            eVar2.e = str;
        }
        if (eaVar != null) {
            String strA = eaVar.a();
            if (!bVar.b.H()) {
                bVar.v();
            }
            com.google.android.libraries.navigation.internal.afm.e eVar3 = (com.google.android.libraries.navigation.internal.afm.e) bVar.b;
            strA.getClass();
            eVar3.b |= 32;
            eVar3.f = strA;
        }
        synchronized (this) {
            com.google.android.libraries.navigation.internal.afm.f fVarA = a();
            if (fVarA != null) {
                com.google.android.libraries.navigation.internal.ael.bb bbVar = (com.google.android.libraries.navigation.internal.ael.bb) fVarA.aH(5, null);
                bbVar.x(fVarA);
                aVar = (com.google.android.libraries.navigation.internal.afm.a) bbVar;
            } else {
                aVar = (com.google.android.libraries.navigation.internal.afm.a) com.google.android.libraries.navigation.internal.afm.f.a.q();
            }
            aVar.d((com.google.android.libraries.navigation.internal.afm.e) bVar.t());
            if (!com.google.android.libraries.navigation.internal.abf.x.a(str)) {
                if (!aVar.b.H()) {
                    aVar.v();
                }
                com.google.android.libraries.navigation.internal.afm.f fVar = (com.google.android.libraries.navigation.internal.afm.f) aVar.b;
                str.getClass();
                fVar.b |= 2;
                fVar.d = str;
            }
            this.f.b((com.google.android.libraries.navigation.internal.afm.f) aVar.t());
        }
        f();
    }

    public final void c(com.google.android.libraries.navigation.internal.afm.d dVar, boolean z, boolean z2, String str, String str2) {
        ge geVar;
        com.google.android.libraries.navigation.internal.abf.p.f(a, 4);
        com.google.android.libraries.navigation.internal.afu.v.c();
        synchronized (this) {
            geVar = (ge) this.e.get(dVar);
        }
        if (geVar != null) {
            geVar.c(z, z2, str, str2);
        } else {
            this.d.c(z, z2, str, str2);
        }
    }

    public final void d(com.google.android.libraries.navigation.internal.afm.f fVar, boolean z) {
        com.google.android.libraries.navigation.internal.abf.p.f(a, 4);
        synchronized (this) {
            boolean z2 = false;
            this.b = false;
            if (z) {
                com.google.android.libraries.navigation.internal.afm.f fVar2 = (com.google.android.libraries.navigation.internal.afm.f) this.f.a();
                if (fVar2 == null) {
                    return;
                }
                if (fVar2.c.size() != 0 && fVar != null && fVar.c.size() != 0) {
                    com.google.android.libraries.navigation.internal.afm.a aVar = (com.google.android.libraries.navigation.internal.afm.a) com.google.android.libraries.navigation.internal.afm.f.a.q();
                    int i = 0;
                    int i2 = 0;
                    while (i < fVar2.c.size() && i2 < fVar.c.size()) {
                        if (com.google.android.libraries.navigation.internal.abf.r.a((com.google.android.libraries.navigation.internal.afm.e) fVar2.c.get(i), (com.google.android.libraries.navigation.internal.afm.e) fVar.c.get(i2))) {
                            i2++;
                        } else {
                            aVar.d((com.google.android.libraries.navigation.internal.afm.e) fVar2.c.get(i));
                        }
                        i++;
                    }
                    while (i < fVar2.c.size()) {
                        aVar.d((com.google.android.libraries.navigation.internal.afm.e) fVar2.c.get(i));
                        i++;
                    }
                    fVar2 = (com.google.android.libraries.navigation.internal.afm.f) aVar.t();
                }
                this.f.b(fVar2);
                if (fVar2 != null && fVar2.c.size() > 0) {
                    z2 = true;
                }
                com.google.android.libraries.navigation.internal.abf.p.f(a, 4);
                if (z2) {
                    f();
                }
            }
        }
    }

    public final synchronized void e(com.google.android.libraries.navigation.internal.afm.d dVar, ge geVar) {
        this.e.put(dVar, geVar);
    }
}

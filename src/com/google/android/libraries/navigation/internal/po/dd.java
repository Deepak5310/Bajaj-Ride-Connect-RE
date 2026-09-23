package com.google.android.libraries.navigation.internal.po;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dd implements com.google.android.libraries.navigation.internal.px.cr {
    public com.google.android.libraries.navigation.internal.px.bk e;
    public com.google.android.libraries.navigation.internal.ol.ah f;
    private boolean j;
    public final dc a = new dc(new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.po.cz
        @Override // com.google.android.libraries.navigation.internal.yx.aa
        public final Object ak(Object obj) {
            return com.google.android.libraries.navigation.internal.yz.de.d((Set) obj).e(new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.po.cy
                @Override // com.google.android.libraries.navigation.internal.yx.aa
                public final Object ak(Object obj2) {
                    return ((ag) obj2).g;
                }
            }).f();
        }
    });
    private final dc i = new dc(new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.po.da
        @Override // com.google.android.libraries.navigation.internal.yx.aa
        public final Object ak(Object obj) {
            return com.google.android.libraries.navigation.internal.yz.ev.o((Set) obj);
        }
    });
    public final dc b = new dc(new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.po.da
        @Override // com.google.android.libraries.navigation.internal.yx.aa
        public final Object ak(Object obj) {
            return com.google.android.libraries.navigation.internal.yz.ev.o((Set) obj);
        }
    });
    public final dc c = new dc(new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.po.db
        @Override // com.google.android.libraries.navigation.internal.yx.aa
        public final Object ak(Object obj) {
            return com.google.android.libraries.navigation.internal.yz.de.d((Set) obj).e(new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.po.cx
                @Override // com.google.android.libraries.navigation.internal.yx.aa
                public final Object ak(Object obj2) {
                    return ((aa) obj2).c;
                }
            }).f();
        }
    });
    public final Set d = new HashSet();
    public final Set g = new LinkedHashSet();
    public final Set h = new LinkedHashSet();
    private final com.google.android.libraries.navigation.internal.agg.bj k = new com.google.android.libraries.navigation.internal.agg.bz();

    @Override // com.google.android.libraries.navigation.internal.px.cr
    public final boolean Z() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.px.cr
    public final void aa(com.google.android.libraries.navigation.internal.px.cq cqVar) {
        com.google.android.libraries.navigation.internal.yz.ek ekVarA;
        com.google.android.libraries.navigation.internal.yz.ek ekVarA2;
        com.google.android.libraries.navigation.internal.yz.ek ekVarA3;
        com.google.android.libraries.navigation.internal.yz.ek ekVarA4;
        synchronized (this) {
            this.j = false;
            ekVarA = this.a.a();
            ekVarA2 = this.c.a();
            ekVarA3 = this.b.a();
            ekVarA4 = this.i.a();
            com.google.android.libraries.navigation.internal.agg.bj bjVar = this.k;
            if (!bjVar.isEmpty()) {
                com.google.android.libraries.navigation.internal.agi.gi giVarListIterator = ((com.google.android.libraries.navigation.internal.agg.bz) bjVar).l().listIterator();
                while (giVarListIterator.hasNext()) {
                    com.google.android.libraries.navigation.internal.agg.bh bhVar = (com.google.android.libraries.navigation.internal.agg.bh) giVarListIterator.next();
                    int iA = bhVar.a();
                    com.google.android.libraries.navigation.internal.ol.ab abVar = (com.google.android.libraries.navigation.internal.ol.ab) bhVar.getValue();
                    if (iA != 0) {
                        if (abVar != null) {
                            cqVar.e.a(iA, abVar);
                        } else if (cqVar.e.c(iA)) {
                            cqVar.e.b(iA);
                        }
                    }
                }
            }
        }
        if (ekVarA != null) {
            cqVar.b.addAll(ekVarA);
        }
        if (ekVarA3 != null) {
            cqVar.d.addAll(ekVarA3);
        }
        if (ekVarA2 != null) {
            cqVar.f.addAll(ekVarA2);
        }
        if (ekVarA4 != null) {
            cqVar.a(0, ekVarA4);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.px.cr
    public final com.google.android.libraries.navigation.internal.adi.an ab() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.px.cr
    public final void ac(com.google.android.libraries.navigation.internal.px.bk bkVar) {
        synchronized (this) {
            this.e = bkVar;
            this.j = false;
            for (com.google.android.libraries.navigation.internal.ol.ad adVar : this.h) {
                bkVar.e(adVar);
                this.g.add(adVar);
            }
            this.h.clear();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.px.cr
    public final void d(com.google.android.libraries.navigation.internal.px.bk bkVar) {
        synchronized (this) {
            for (com.google.android.libraries.navigation.internal.ol.ad adVar : this.g) {
                bkVar.o(adVar);
                this.h.add(adVar);
            }
            this.g.clear();
            this.j = false;
            this.e = null;
        }
    }

    final void f(com.google.android.libraries.navigation.internal.ol.ad adVar) {
        synchronized (this) {
            if (this.e == null) {
                this.h.add(adVar);
            } else if (!this.g.contains(adVar)) {
                this.e.e(adVar);
                this.g.add(adVar);
            }
        }
    }

    final void g() {
        h(false);
    }

    final void h(boolean z) {
        boolean z2;
        com.google.android.libraries.navigation.internal.px.bk bkVar;
        synchronized (this) {
            z2 = this.j;
            if (z) {
                this.a.d();
                this.i.d();
                this.c.d();
            }
            this.b.d();
            bkVar = this.e;
            this.j = bkVar != null;
        }
        if (bkVar == null || z2) {
            return;
        }
        bkVar.l(this);
    }

    final void i(ag agVar) {
        boolean zC;
        synchronized (this) {
            zC = agVar instanceof aa ? this.c.c(agVar) : this.a.c(agVar);
        }
        if (zC) {
            h(true);
        }
    }
}

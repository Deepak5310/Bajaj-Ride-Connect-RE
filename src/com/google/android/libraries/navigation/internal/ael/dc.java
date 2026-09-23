package com.google.android.libraries.navigation.internal.ael;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dc implements dr {
    private final cy a;
    private final ef b;
    private final boolean c;
    private final as d;

    public dc(ef efVar, as asVar, cy cyVar) {
        this.b = efVar;
        this.c = asVar.j(cyVar);
        this.d = asVar;
        this.a = cyVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dr
    public final int a(Object obj) {
        ef efVar = this.b;
        int iB = efVar.b(efVar.d(obj));
        if (!this.c) {
            return iB;
        }
        av avVarB = this.d.b(obj);
        int i = avVarB.b.b;
        int iB2 = 0;
        for (int i2 = 0; i2 < i; i2++) {
            iB2 += avVarB.b(avVarB.b.d(i2));
        }
        Iterator it2 = avVarB.b.a().iterator();
        while (it2.hasNext()) {
            iB2 += avVarB.b((Map.Entry) it2.next());
        }
        return iB + iB2;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dr
    public final int b(Object obj) {
        int iHashCode = this.b.d(obj).hashCode();
        return this.c ? (iHashCode * 53) + this.d.b(obj).hashCode() : iHashCode;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dr
    public final Object e() {
        cy cyVar = this.a;
        return cyVar instanceof bi ? ((bi) cyVar).u() : cyVar.aG().u();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dr
    public final void f(Object obj) {
        this.b.m(obj);
        this.d.f(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dr
    public final void g(Object obj, Object obj2) {
        dt.n(this.b, obj, obj2);
        if (this.c) {
            dt.m(this.d, obj, obj2);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dr
    public final void h(Object obj, dl dlVar, ar arVar) throws IOException {
        boolean zP;
        ef efVar = this.b;
        Object objC = efVar.c(obj);
        as asVar = this.d;
        av avVarC = asVar.c(obj);
        while (dlVar.c() != Integer.MAX_VALUE) {
            try {
                int i = ((ad) dlVar).b;
                int i2 = 0;
                if (i != eu.a) {
                    if (eu.b(i) == 2) {
                        Object objD = asVar.d(arVar, this.a, eu.a(i));
                        if (objD != null) {
                            asVar.g(dlVar, objD, arVar, avVarC);
                        } else {
                            zP = efVar.r(objC, dlVar, 0);
                        }
                    } else {
                        zP = dlVar.P();
                    }
                    if (!zP) {
                        break;
                    }
                } else {
                    Object objD2 = null;
                    x xVarO = null;
                    while (dlVar.c() != Integer.MAX_VALUE) {
                        int i3 = ((ad) dlVar).b;
                        if (i3 == eu.c) {
                            i2 = dlVar.i();
                            objD2 = asVar.d(arVar, this.a, i2);
                        } else if (i3 == eu.d) {
                            if (objD2 != null) {
                                asVar.g(dlVar, objD2, arVar, avVarC);
                            } else {
                                xVarO = dlVar.o();
                            }
                        } else if (i3 == eu.b || !dlVar.P()) {
                            break;
                        }
                    }
                    if (((ad) dlVar).b != eu.b) {
                        throw new cc("Protocol message end-group tag did not match expected tag.");
                    }
                    if (xVarO != null) {
                        if (objD2 != null) {
                            asVar.h(xVarO, objD2, arVar, avVarC);
                        } else {
                            efVar.k(objC, i2, xVarO);
                        }
                    }
                }
            } catch (Throwable th) {
                efVar.n(obj, objC);
                throw th;
            }
        }
        efVar.n(obj, objC);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:57:0x00c2 A[EDGE_INSN: B:57:0x00c2->B:33:0x00c2 BREAK  A[LOOP:1: B:18:0x0068->B:60:0x0068], SYNTHETIC] */
    @Override // com.google.android.libraries.navigation.internal.ael.dr
    public final void i(Object obj, byte[] bArr, int i, int i2, h hVar) throws IOException {
        bi biVar = (bi) obj;
        eg egVar = biVar.an;
        if (egVar == eg.a) {
            egVar = new eg();
            biVar.an = egVar;
        }
        av avVarG = ((be) obj).g();
        Object objD = null;
        while (i < i2) {
            int iM = i.m(bArr, i, hVar);
            int i3 = hVar.a;
            if (i3 == eu.a) {
                int i4 = 0;
                x xVar = null;
                while (iM < i2) {
                    iM = i.m(bArr, iM, hVar);
                    int i5 = hVar.a;
                    int iA = eu.a(i5);
                    int iB = eu.b(i5);
                    if (iA == 2) {
                        if (iB != 0) {
                            if (i5 != eu.b) {
                                break;
                                break;
                            }
                            iM = i.s(i5, bArr, iM, i2, hVar);
                        } else {
                            iM = i.m(bArr, iM, hVar);
                            i4 = hVar.a;
                            objD = this.d.d(hVar.d, this.a, i4);
                        }
                    } else {
                        if (iA == 3) {
                            if (objD != null) {
                                bh bhVar = (bh) objD;
                                iM = i.g(di.a.a(bhVar.c.getClass()), bArr, iM, i2, hVar);
                                avVarG.m(bhVar.d, hVar.c);
                            } else if (iB == 2) {
                                iM = i.c(bArr, iM, hVar);
                                xVar = (x) hVar.c;
                            }
                        }
                        if (i5 != eu.b) {
                            break;
                        } else {
                            iM = i.s(i5, bArr, iM, i2, hVar);
                        }
                    }
                }
                if (xVar != null) {
                    egVar.e(eu.c(i4, 2), xVar);
                }
                i = iM;
            } else if (eu.b(i3) == 2) {
                Object objD2 = this.d.d(hVar.d, this.a, eu.a(i3));
                if (objD2 != null) {
                    bh bhVar2 = (bh) objD2;
                    i = i.g(di.a.a(bhVar2.c.getClass()), bArr, iM, i2, hVar);
                    avVarG.m(bhVar2.d, hVar.c);
                } else {
                    i = i.l(i3, bArr, iM, i2, egVar, hVar);
                }
                objD = objD2;
            } else {
                i = i.s(i3, bArr, iM, i2, hVar);
            }
        }
        if (i != i2) {
            throw new cc("Failed to parse the message.");
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dr
    public final void j(Object obj, ev evVar) throws IOException {
        Iterator itD = this.d.b(obj).d();
        while (itD.hasNext()) {
            Map.Entry entry = (Map.Entry) itD.next();
            bg bgVar = (bg) entry.getKey();
            if (bgVar.c() != et.MESSAGE || bgVar.d()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof cf) {
                evVar.m(bgVar.a(), ((ch) ((cf) entry).a.getValue()).a());
            } else {
                evVar.m(bgVar.a(), entry.getValue());
            }
        }
        ef efVar = this.b;
        efVar.p(efVar.d(obj), evVar);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dr
    public final boolean k(Object obj, Object obj2) {
        ef efVar = this.b;
        if (!efVar.d(obj).equals(efVar.d(obj2))) {
            return false;
        }
        if (this.c) {
            return this.d.b(obj).equals(this.d.b(obj2));
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.dr
    public final boolean l(Object obj) {
        return this.d.b(obj).i();
    }
}

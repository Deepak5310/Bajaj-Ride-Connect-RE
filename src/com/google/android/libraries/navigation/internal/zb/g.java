package com.google.android.libraries.navigation.internal.zb;

import java.util.Random;
import java.util.logging.Level;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class g extends q implements z {
    protected g(Level level) {
        super(level);
    }

    @Override // com.google.android.libraries.navigation.internal.zb.q
    protected final com.google.android.libraries.navigation.internal.zi.d a() {
        return com.google.android.libraries.navigation.internal.zi.b.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10, types: [com.google.android.libraries.navigation.internal.zb.ak] */
    /* JADX WARN: Type inference failed for: r10v11, types: [com.google.android.libraries.navigation.internal.zb.ah] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7, types: [com.google.android.libraries.navigation.internal.zb.ah] */
    @Override // com.google.android.libraries.navigation.internal.zb.q
    protected final boolean b(u uVar) {
        int iA;
        int i;
        c cVar;
        ah ahVar;
        ?? r10;
        com.google.android.libraries.navigation.internal.zd.n nVarI = i();
        int iB = nVarI.b();
        for (int i2 = 0; i2 < iB; i2++) {
            if (nVarI.c(i2).a == "eye3tag") {
                if (nVarI.d(o.a) != null || nVarI.d(o.i) != null) {
                    break;
                    break;
                }
                n(o.i, an.SMALL);
                break;
            }
        }
        p pVar = this.c;
        if (pVar != null) {
            if (uVar != null) {
                ah ahVarB = f.b(pVar, uVar, this.b);
                p pVar2 = this.c;
                w wVar = c.a;
                Integer num = (Integer) pVar2.d(o.b);
                if (num == null) {
                    ahVar = null;
                } else {
                    cVar = (c) c.a.b(uVar, pVar2);
                    if (cVar.b.incrementAndGet() < num.intValue()) {
                        ahVar = cVar;
                        ahVar = c.c;
                    }
                }
                ahVar = cVar;
                ah ahVarC = ah.c(ahVarB, ahVar);
                p pVar3 = this.c;
                w wVar2 = ak.a;
                Integer num2 = (Integer) pVar3.d(o.c);
                if (num2 == null || num2.intValue() <= 0) {
                    r10 = 0;
                } else {
                    r10 = (ak) ak.a.b(uVar, pVar3);
                    if ((((Random) ak.b.get()).nextInt(num2.intValue()) == 0 ? r10.e.incrementAndGet() : r10.e.get()) <= 0) {
                        r10 = ak.c;
                    }
                }
                ah ahVarC2 = ah.c(ahVarC, r10);
                this.d = ahVarC2;
                if (ahVarC2 == ah.c) {
                    return false;
                }
            }
            an anVar = (an) this.c.d(o.i);
            if (anVar != null) {
                ac acVar = o.i;
                p pVar4 = this.c;
                if (pVar4 != null && (iA = pVar4.a(acVar)) >= 0) {
                    int i3 = iA + iA;
                    int i4 = i3 + 2;
                    while (true) {
                        i = pVar4.b;
                        if (i4 >= i + i) {
                            break;
                        }
                        Object obj = pVar4.a[i4];
                        if (!obj.equals(acVar)) {
                            Object[] objArr = pVar4.a;
                            objArr[i3] = obj;
                            objArr[i3 + 1] = objArr[i4 + 1];
                            i3 += 2;
                        }
                        i4 += 2;
                    }
                    pVar4.b = i - ((i4 - i3) >> 1);
                    while (i3 < i4) {
                        pVar4.a[i3] = null;
                        i3++;
                    }
                }
                Throwable th = (Throwable) i().d(o.a);
                int i5 = anVar.f;
                com.google.android.libraries.navigation.internal.zj.e eVar = com.google.android.libraries.navigation.internal.zj.a.a;
                if (i5 <= 0 && i5 != -1) {
                    throw new IllegalArgumentException("invalid maximum depth: 0");
                }
                n(o.a, new x(th, anVar, com.google.android.libraries.navigation.internal.zj.a.a.b(q.class, i5)));
            }
        }
        return true;
    }
}

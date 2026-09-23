package com.google.android.libraries.navigation.internal.hm;

import com.google.android.libraries.navigation.internal.ace.bs;
import com.google.android.libraries.navigation.internal.ace.cn;
import com.google.android.libraries.navigation.internal.ael.bq;
import com.google.android.libraries.navigation.internal.afl.ha;
import com.google.android.libraries.navigation.internal.afl.hb;
import com.google.android.libraries.navigation.internal.agg.bz;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a {
    private final f a;
    private com.google.android.libraries.navigation.internal.hp.d b = com.google.android.libraries.navigation.internal.hp.d.b;
    private long c = 0;

    public a(f fVar) {
        this.a = fVar;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.libraries.navigation.internal.fz.d, com.google.android.libraries.navigation.internal.hm.f] */
    /* JADX WARN: Type inference failed for: r0v13, types: [com.google.android.libraries.navigation.internal.fz.d, com.google.android.libraries.navigation.internal.hm.f] */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.google.android.libraries.navigation.internal.fz.d, com.google.android.libraries.navigation.internal.hm.f] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    final synchronized com.google.android.libraries.navigation.internal.hp.d a() {
        com.google.android.libraries.navigation.internal.hp.c cVar;
        if (!com.google.android.libraries.navigation.internal.fz.b.c(this.a).l) {
            return com.google.android.libraries.navigation.internal.hp.d.b;
        }
        if (this.b.b()) {
            hb hbVarL = this.a.L(ha.EXPERIMENT_ATTRIBUTION_MAP);
            com.google.android.libraries.navigation.internal.yx.an anVarJ = (hbVarL == null || (hbVarL.b & 2) == 0) ? com.google.android.libraries.navigation.internal.yx.a.a : com.google.android.libraries.navigation.internal.yx.an.j(Long.valueOf(hbVarL.f));
            if (anVarJ.g()) {
                this.c = ((Long) anVarJ.c()).longValue();
                hb hbVarL2 = this.a.L(ha.EXPERIMENT_ATTRIBUTION_MAP);
                bs bsVar = hbVarL2.c == 147 ? (bs) hbVarL2.d : bs.a;
                com.google.android.libraries.navigation.internal.hp.c cVar2 = new com.google.android.libraries.navigation.internal.hp.c();
                for (Map.Entry entry : Collections.unmodifiableMap(bsVar.b).entrySet()) {
                    int iIntValue = ((Integer) entry.getKey()).intValue();
                    cn cnVar = (cn) entry.getValue();
                    boolean z = true;
                    if ((cnVar.b & 1) == 0) {
                        bq bqVar = cnVar.c;
                        if (bqVar.size() >= 2) {
                            int size = bqVar.size() - 1;
                            int i = 0;
                            com.google.android.libraries.navigation.internal.hp.c cVar3 = cVar2;
                            for (int i2 = 0; i2 < bqVar.size(); i2++) {
                                int iIntValue2 = ((Integer) bqVar.get(i2)).intValue();
                                com.google.android.libraries.navigation.internal.hp.d dVar = (com.google.android.libraries.navigation.internal.hp.d) cVar3.a.p(iIntValue2);
                                if (i2 == size) {
                                    if (dVar != null) {
                                        if (!(dVar instanceof com.google.android.libraries.navigation.internal.hp.b)) {
                                            break;
                                        }
                                        bz bzVar = cVar3.a;
                                        com.google.android.libraries.navigation.internal.hp.b bVar = (com.google.android.libraries.navigation.internal.hp.b) dVar;
                                        int iB = bVar.a.b() + 1;
                                        if (iB < 0) {
                                            z = false;
                                        }
                                        com.google.android.libraries.navigation.internal.yx.ar.d(z, "Invalid initialCapacity: %s", iB);
                                        com.google.android.libraries.navigation.internal.zy.d dVar2 = new com.google.android.libraries.navigation.internal.zy.d(iB);
                                        while (true) {
                                            com.google.android.libraries.navigation.internal.zy.e eVar = bVar.a;
                                            if (i == eVar.b()) {
                                                dVar2.b(iIntValue);
                                                bVar = new com.google.android.libraries.navigation.internal.hp.b(dVar2.a());
                                                break;
                                            }
                                            int iA = eVar.a(i);
                                            if (iA == iIntValue) {
                                                break;
                                            }
                                            i++;
                                            if (iA > iIntValue) {
                                                dVar2.b(iIntValue);
                                                dVar2.b(iA);
                                                while (true) {
                                                    com.google.android.libraries.navigation.internal.zy.e eVar2 = bVar.a;
                                                    if (i >= eVar2.b()) {
                                                        break;
                                                    }
                                                    dVar2.b(eVar2.a(i));
                                                    i++;
                                                }
                                                bVar = new com.google.android.libraries.navigation.internal.hp.b(dVar2.a());
                                                break;
                                            }
                                            dVar2.b(iA);
                                        }
                                        bzVar.a(iIntValue2, bVar);
                                        break;
                                    }
                                    cVar3.a.a(iIntValue2, new com.google.android.libraries.navigation.internal.hp.b(com.google.android.libraries.navigation.internal.zy.e.c(iIntValue)));
                                    break;
                                }
                                if (dVar != null) {
                                    if (!(dVar instanceof com.google.android.libraries.navigation.internal.hp.c)) {
                                        break;
                                    }
                                    cVar = (com.google.android.libraries.navigation.internal.hp.c) dVar;
                                } else {
                                    cVar = new com.google.android.libraries.navigation.internal.hp.c();
                                    cVar3.a.a(iIntValue2, cVar);
                                }
                                cVar3 = cVar;
                            }
                        }
                    }
                }
                this.b = cVar2;
            }
        }
        return this.b;
    }

    final synchronized void b(long j) {
        if (this.c != j) {
            this.c = j;
            this.b = com.google.android.libraries.navigation.internal.hp.d.b;
        }
    }
}

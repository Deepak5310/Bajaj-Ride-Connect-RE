package com.google.android.libraries.navigation.internal.yz;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class br {
    public static final Collector a = Collector.of(new Supplier() { // from class: com.google.android.libraries.navigation.internal.yz.bb
        @Override // java.util.function.Supplier
        public final Object get() {
            int i = ev.d;
            return new eq();
        }
    }, new BiConsumer() { // from class: com.google.android.libraries.navigation.internal.yz.be
        @Override // java.util.function.BiConsumer
        public final void accept(Object obj, Object obj2) {
            ((eq) obj).h(obj2);
        }
    }, new BinaryOperator() { // from class: com.google.android.libraries.navigation.internal.yz.bf
        @Override // java.util.function.BiFunction
        public final Object apply(Object obj, Object obj2) {
            eq eqVar = (eq) obj;
            eq eqVar2 = (eq) obj2;
            eqVar.a(eqVar2.a, eqVar2.b);
            return eqVar;
        }
    }, new Function() { // from class: com.google.android.libraries.navigation.internal.yz.bg
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return ((eq) obj).g();
        }
    }, new Collector.Characteristics[0]);
    public static final Collector b = Collector.of(new Supplier() { // from class: com.google.android.libraries.navigation.internal.yz.bh
        @Override // java.util.function.Supplier
        public final Object get() {
            return new fw();
        }
    }, new BiConsumer() { // from class: com.google.android.libraries.navigation.internal.yz.bi
        @Override // java.util.function.BiConsumer
        public final void accept(Object obj, Object obj2) {
            ((fw) obj).g(obj2);
        }
    }, new BinaryOperator() { // from class: com.google.android.libraries.navigation.internal.yz.bj
        @Override // java.util.function.BiFunction
        public final Object apply(Object obj, Object obj2) {
            return ((fw) obj).h((fw) obj2);
        }
    }, new Function() { // from class: com.google.android.libraries.navigation.internal.yz.bk
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return ((fw) obj).i();
        }
    }, new Collector.Characteristics[0]);

    static {
        Collector.of(new Supplier() { // from class: com.google.android.libraries.navigation.internal.yz.bl
            @Override // java.util.function.Supplier
            public final Object get() {
                fv fvVar = fv.a;
                return new ft();
            }
        }, new BiConsumer() { // from class: com.google.android.libraries.navigation.internal.yz.bm
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((ft) obj).a((lr) obj2);
            }
        }, new BinaryOperator() { // from class: com.google.android.libraries.navigation.internal.yz.bc
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                ft ftVar = (ft) obj;
                Iterator it2 = ((ft) obj2).a.iterator();
                while (it2.hasNext()) {
                    ftVar.a((lr) it2.next());
                }
                return ftVar;
            }
        }, new Function() { // from class: com.google.android.libraries.navigation.internal.yz.bd
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                lr lrVar;
                ft ftVar = (ft) obj;
                eq eqVar = new eq(ftVar.a.size());
                List list = ftVar.a;
                lr lrVar2 = lr.a;
                Collections.sort(list, lq.a);
                gz gzVarI = hb.i(ftVar.a.iterator());
                while (gzVarI.hasNext()) {
                    lr lrVarD = (lr) gzVarI.next();
                    while (gzVarI.hasNext()) {
                        lr lrVar3 = (lr) gzVarI.a();
                        if (!lrVarD.h(lrVar3)) {
                            break;
                        }
                        int iA = lrVarD.b.a(lrVar3.b);
                        int iA2 = lrVarD.c.a(lrVar3.c);
                        if (iA >= 0 && iA2 <= 0) {
                            lrVar = lrVarD;
                        } else if (iA > 0 || iA2 < 0) {
                            cv cvVar = iA >= 0 ? lrVarD.b : lrVar3.b;
                            cv cvVar2 = iA2 <= 0 ? lrVarD.c : lrVar3.c;
                            com.google.android.libraries.navigation.internal.yx.ar.i(cvVar.a(cvVar2) <= 0, "intersection is undefined for disconnected ranges %s and %s", lrVarD, lrVar3);
                            lrVar = new lr(cvVar, cvVar2);
                        } else {
                            lrVar = lrVar3;
                        }
                        com.google.android.libraries.navigation.internal.yx.ar.i(lrVar.i(), "Overlapping ranges not permitted but found %s overlapping %s", lrVarD, lrVar3);
                        lrVarD = lrVarD.d((lr) gzVarI.next());
                    }
                    eqVar.h(lrVarD);
                }
                ev evVarG = eqVar.g();
                if (evVarG.isEmpty()) {
                    return fv.a;
                }
                return (((lv) evVarG).c == 1 && ((lr) gs.e(evVarG)).equals(lr.a)) ? fv.b : new fv(evVarG);
            }
        }, new Collector.Characteristics[0]);
    }

    public static Collector a(final Function function, final Function function2) {
        return Collector.of(new Supplier() { // from class: com.google.android.libraries.navigation.internal.yz.bn
            @Override // java.util.function.Supplier
            public final Object get() {
                return new ez();
            }
        }, new BiConsumer() { // from class: com.google.android.libraries.navigation.internal.yz.bo
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                Collector collector = br.a;
                ((ez) obj).f(function.apply(obj2), function2.apply(obj2));
            }
        }, new BinaryOperator() { // from class: com.google.android.libraries.navigation.internal.yz.bp
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                ez ezVar = (ez) obj;
                ez ezVar2 = (ez) obj2;
                com.google.android.libraries.navigation.internal.yx.ar.q(ezVar2);
                ezVar.e(ezVar.b + ezVar2.b);
                Object[] objArr = ezVar2.a;
                Object[] objArr2 = ezVar.a;
                int i = ezVar.b;
                int i2 = ezVar2.b;
                System.arraycopy(objArr, 0, objArr2, i + i, i2 + i2);
                ezVar.b += ezVar2.b;
                return ezVar;
            }
        }, new Function() { // from class: com.google.android.libraries.navigation.internal.yz.bq
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ez) obj).d();
            }
        }, new Collector.Characteristics[0]);
    }
}

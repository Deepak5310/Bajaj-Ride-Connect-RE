package com.google.android.libraries.navigation.internal.oh;

import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.qk.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p implements com.google.android.libraries.navigation.internal.oh.a {
    private final List a;
    private final int b;

    /* JADX INFO: compiled from: PG */
    public class a {
        private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.oh.p$a");
        private final List b = new ArrayList();

        public final p a() {
            ArrayList arrayList = new ArrayList(this.b);
            Collections.sort(arrayList, new Comparator() { // from class: com.google.android.libraries.navigation.internal.oh.o
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    q qVar = (q) obj;
                    q qVar2 = (q) obj2;
                    if (!qVar.a() || qVar2.a()) {
                        return (qVar.a() || !qVar2.a()) ? 0 : 1;
                    }
                    return -1;
                }
            });
            return new p(arrayList);
        }

        public final void c(com.google.android.libraries.navigation.internal.oh.a aVar) {
            this.b.add(new q(aVar, true, 0, 0.0f));
        }

        public final void d(int i, com.google.android.libraries.navigation.internal.oh.a aVar) {
            this.b.add(new q(aVar, true, i, Float.POSITIVE_INFINITY));
        }

        public final void e(int i, com.google.android.libraries.navigation.internal.oh.a aVar) {
            this.b.add(new q(aVar, false, i, Float.POSITIVE_INFINITY));
        }

        public final void b(int i, com.google.android.libraries.navigation.internal.oh.a aVar, float f) {
            if (f < 0.0f || f >= 1.0f) {
                ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 831)).p("threshold must be in range [0:1). Scorer will not be added.");
            } else {
                this.b.add(new q(aVar, true, i, f));
            }
        }
    }

    public p(List list) {
        this.a = list;
        Iterator it2 = list.iterator();
        int i = 0;
        while (it2.hasNext()) {
            i += ((q) it2.next()).c;
        }
        this.b = i;
    }

    @Override // com.google.android.libraries.navigation.internal.oh.a
    public final float a(com.google.android.libraries.navigation.internal.op.g gVar, com.google.android.libraries.navigation.internal.qk.q qVar, x xVar, com.google.android.libraries.navigation.internal.adg.b bVar, s sVar) {
        float fMax;
        Iterator it2 = this.a.iterator();
        float f = 0.0f;
        while (true) {
            if (!it2.hasNext()) {
                int i = this.b;
                fMax = i > 0 ? f / i : 0.5f;
                if (sVar != null) {
                    sVar.a(xVar, bVar, com.google.android.libraries.navigation.internal.b.b.h(fMax, "CompositeScore:"));
                }
                return fMax;
            }
            q qVar2 = (q) it2.next();
            com.google.android.libraries.navigation.internal.oh.a aVar = qVar2.a;
            float fA = aVar.a(gVar, qVar, xVar, bVar, sVar);
            if (fA < -1.0E-6f || fA > 1.000001f || Float.isNaN(fA)) {
                new IllegalStateException("Scorer '" + aVar.getClass().getSimpleName() + "' returned a value outside the valid range [0.0, 1.0] -/+ 1.0E-6: " + fA);
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 835)).p("Callout position scoring error");
            }
            fMax = Float.isNaN(fA) ? 0.5f : Math.max(0.0f, Math.min(1.0f, fA));
            if (fMax > qVar2.d) {
                if (sVar != null) {
                    sVar.a(xVar, bVar, "failFastIsPenalty:" + qVar2.b);
                }
                return qVar2.b ? 0.0f : 1.0f;
            }
            if (qVar2.b) {
                fMax = 1.0f - fMax;
            }
            f += fMax * qVar2.c;
        }
    }
}

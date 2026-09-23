package com.google.android.libraries.navigation.internal.fi;

import com.google.android.libraries.navigation.internal.agi.fb;
import com.google.android.libraries.navigation.internal.agi.fo;
import com.google.android.libraries.navigation.internal.agi.gi;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class i {
    private final ArrayDeque a = new ArrayDeque();
    private final Map b = new fo();
    private int c;
    private long d;
    private long e;

    public i(int i, int i2, int i3) {
        this.c = i;
        this.d = ((long) i2) * 60000;
        this.e = ((long) i3) * 60000;
    }

    private final void h(com.google.android.libraries.navigation.internal.kp.a aVar, long j) {
        String strF;
        if (aVar.e()) {
            strF = null;
        } else {
            long j2 = this.e;
            if (j2 == this.d || !(aVar instanceof com.google.android.libraries.navigation.internal.kp.d)) {
                return;
            }
            if (j2 != 0 && aVar.b() <= j) {
                return;
            } else {
                strF = ((com.google.android.libraries.navigation.internal.kp.d) aVar).f();
            }
        }
        String strD = aVar.d();
        if (strD != null) {
            if (strF != null) {
                strD = strD.concat(strF);
            }
            this.b.put(strD, aVar);
        }
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [com.google.android.libraries.navigation.internal.agi.ey, java.util.Map] */
    private final void i(int i, long j) {
        if (this.c != 0) {
            while (this.a.size() > i) {
                com.google.android.libraries.navigation.internal.kp.a aVar = (com.google.android.libraries.navigation.internal.kp.a) this.a.removeFirst();
                if (aVar.e()) {
                    h(aVar, 0L);
                }
                long jB = aVar.b();
                int i2 = j.c;
                if (jB + 600000 > j) {
                    break;
                }
            }
            this.b.b().removeIf(new Predicate() { // from class: com.google.android.libraries.navigation.internal.fi.h
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return !((com.google.android.libraries.navigation.internal.kp.a) ((Map.Entry) obj).getValue()).e();
                }
            });
        }
    }

    public final int a() {
        return this.a.size() + ((fo) this.b).h;
    }

    public final void b(com.google.android.libraries.navigation.internal.kp.a aVar) {
        this.a.addLast(aVar);
        long jB = aVar.b();
        i(this.c, jB);
        f(jB);
    }

    public final void c(List list, long j) {
        long j2 = j - this.d;
        gi giVarListIterator = ((fb) ((com.google.android.libraries.navigation.internal.agi.k) this.b).values()).listIterator();
        while (giVarListIterator.hasNext()) {
            com.google.android.libraries.navigation.internal.kp.a aVar = (com.google.android.libraries.navigation.internal.kp.a) giVarListIterator.next();
            if (aVar.e() || this.e == 0 || aVar.b() > j2) {
                list.add(aVar);
            }
        }
        list.addAll(this.a);
    }

    public final void d() {
        this.a.clear();
        this.b.clear();
    }

    public final void e(int i, int i2, int i3) {
        this.c = i;
        this.d = ((long) i2) * 60000;
        this.e = ((long) i3) * 60000;
    }

    public final void f(long j) {
        long j2 = this.d;
        if (j2 == 0) {
            return;
        }
        long j3 = j - j2;
        long j4 = j - this.e;
        while (!this.a.isEmpty() && ((com.google.android.libraries.navigation.internal.kp.a) this.a.peekFirst()).b() <= j3) {
            h((com.google.android.libraries.navigation.internal.kp.a) this.a.removeFirst(), j4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g(float f, long j, com.google.android.libraries.navigation.internal.kp.e eVar) {
        i((int) (a() * f), j);
        if (eVar != 0) {
            com.google.android.libraries.navigation.internal.kp.a aVar = (com.google.android.libraries.navigation.internal.kp.a) this.a.peekFirst();
            if (aVar != null) {
                j = Math.max(aVar.b() - 1, 0L);
            }
            ((com.google.android.libraries.navigation.internal.kp.c) eVar).q = j;
            this.a.addFirst(eVar);
            long jB = eVar.b();
            i(this.c, jB);
            f(jB);
        }
    }
}

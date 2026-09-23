package com.google.android.libraries.navigation.internal.ti;

import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.acd.on;
import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.ael.ed;
import com.google.android.libraries.navigation.internal.agi.fb;
import com.google.android.libraries.navigation.internal.agi.fg;
import com.google.android.libraries.navigation.internal.agi.fo;
import com.google.android.libraries.navigation.internal.agi.gi;
import com.google.android.libraries.navigation.internal.km.ag;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.zs.bj;
import com.google.android.libraries.navigation.internal.zs.db;
import com.google.android.libraries.navigation.internal.zs.dd;
import com.google.android.libraries.navigation.internal.zs.de;
import com.google.android.libraries.navigation.internal.zs.dg;
import com.google.android.libraries.navigation.internal.zs.di;
import com.google.android.libraries.navigation.internal.zs.dl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class h {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.ti.h");
    private static final long b = TimeUnit.HOURS.toMillis(1);
    private static final Comparator c = new Comparator() { // from class: com.google.android.libraries.navigation.internal.ti.f
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return Long.valueOf(h.c((on) obj)).compareTo(Long.valueOf(h.c((on) obj2)));
        }
    };
    private final com.google.android.libraries.navigation.internal.kl.b d;
    private final bn e;
    private final ad f;
    private final Map g = new fo();
    private final List h = new ArrayList();
    private final List i = new ArrayList();
    private final ArrayList j = new ArrayList();
    private boolean k;
    private int l;
    private long m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f595n;
    private final com.google.android.libraries.navigation.internal.gq.ad o;

    public h(com.google.android.libraries.navigation.internal.kl.b bVar, bn bnVar, ad adVar, com.google.android.libraries.navigation.internal.gq.ab abVar) {
        this.d = bVar;
        this.e = bnVar;
        this.f = adVar;
        com.google.android.libraries.navigation.internal.gd.j jVar = (com.google.android.libraries.navigation.internal.gd.j) com.google.android.libraries.navigation.internal.gd.k.a.q();
        long j = adVar.a.C;
        if (!jVar.b.H()) {
            jVar.v();
        }
        com.google.android.libraries.navigation.internal.gd.k kVar = (com.google.android.libraries.navigation.internal.gd.k) jVar.b;
        kVar.b |= 4;
        kVar.e = j;
        com.google.android.libraries.navigation.internal.gd.k kVar2 = (com.google.android.libraries.navigation.internal.gd.k) jVar.t();
        com.google.android.libraries.navigation.internal.gd.h hVar = com.google.android.libraries.navigation.internal.gd.h.TIME_CRITICAL;
        synchronized (abVar) {
            com.google.android.libraries.navigation.internal.gh.c cVarB = abVar.b();
            cVarB.a(kVar2);
            com.google.android.libraries.navigation.internal.gd.i iVar = new com.google.android.libraries.navigation.internal.gh.d(abVar.b()).b;
            bb bbVar = (bb) iVar.aH(5, null);
            bbVar.x(iVar);
            com.google.android.libraries.navigation.internal.gd.f fVar = (com.google.android.libraries.navigation.internal.gd.f) bbVar;
            if (!fVar.b.H()) {
                fVar.v();
            }
            com.google.android.libraries.navigation.internal.gd.i iVar2 = (com.google.android.libraries.navigation.internal.gd.i) fVar.b;
            iVar2.b |= 1;
            iVar2.c = false;
            if (!fVar.b.H()) {
                fVar.v();
            }
            com.google.android.libraries.navigation.internal.gd.i iVar3 = (com.google.android.libraries.navigation.internal.gd.i) fVar.b;
            iVar3.k = hVar.d;
            iVar3.b |= 256;
            cVarB.a = (com.google.android.libraries.navigation.internal.gd.i) fVar.t();
            this.o = abVar.c();
        }
    }

    /* JADX WARN: Code duplicated, block: B:57:0x00a3  */
    static long c(on onVar) {
        long jMin;
        int i;
        dl dlVar = onVar.d;
        if (dlVar == null) {
            dlVar = dl.a;
        }
        if (dlVar.d.size() <= 0) {
            jMin = Long.MAX_VALUE;
        } else {
            dl dlVar2 = onVar.d;
            if (dlVar2 == null) {
                dlVar2 = dl.a;
            }
            de deVar = (de) dlVar2.d.get(0);
            int i2 = deVar.b;
            if (i2 == 0) {
                i = dd.e;
            } else if (i2 == 1) {
                i = dd.a;
            } else if (i2 == 2) {
                i = dd.b;
            } else if (i2 != 3) {
                i = i2 != 4 ? 0 : dd.d;
            } else {
                i = dd.c;
            }
            if (i == 0) {
                throw null;
            }
            int i3 = i - 1;
            if (i3 == 0) {
                if ((deVar.b == 1 ? (dg) deVar.c : dg.a).b.size() > 0) {
                    jMin = ((bj) (deVar.b == 1 ? (dg) deVar.c : dg.a).b.get(0)).e;
                } else {
                    jMin = Long.MAX_VALUE;
                }
            } else if (i3 == 1) {
                ed edVar = (deVar.b == 2 ? (db) deVar.c : db.a).f;
                if (edVar == null) {
                    edVar = ed.a;
                }
                jMin = com.google.android.libraries.navigation.internal.aen.d.a(edVar);
            } else if (i3 != 3) {
                jMin = Long.MAX_VALUE;
            } else {
                ed edVar2 = (deVar.b == 4 ? (di) deVar.c : di.a).b;
                if (edVar2 == null) {
                    edVar2 = ed.a;
                }
                jMin = com.google.android.libraries.navigation.internal.aen.d.a(edVar2);
            }
        }
        com.google.android.libraries.navigation.internal.acl.d dVar = onVar.e;
        if (dVar == null) {
            dVar = com.google.android.libraries.navigation.internal.acl.d.a;
        }
        if (dVar.b.size() > 0) {
            com.google.android.libraries.navigation.internal.acl.d dVar2 = onVar.e;
            if (dVar2 == null) {
                dVar2 = com.google.android.libraries.navigation.internal.acl.d.a;
            }
            ed edVar3 = ((com.google.android.libraries.navigation.internal.acl.c) dVar2.b.get(0)).b;
            if (edVar3 == null) {
                edVar3 = ed.a;
            }
            jMin = Math.min(jMin, com.google.android.libraries.navigation.internal.aen.d.a(edVar3));
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    private final synchronized void j(on onVar, com.google.android.libraries.navigation.internal.gg.b bVar) {
        this.g.put(onVar, bVar);
    }

    final synchronized int a() {
        if (!this.i.isEmpty()) {
            this.i.size();
            Iterator it2 = this.i.iterator();
            while (it2.hasNext()) {
                e((on) it2.next());
            }
            this.i.clear();
        }
        return this.j.size();
    }

    final synchronized int b() {
        if (!this.h.isEmpty()) {
            this.h.size();
            Map map = this.g;
            ((com.google.android.libraries.navigation.internal.agi.k) map).keySet().removeAll(this.h);
            this.h.clear();
        }
        return ((fo) this.g).h;
    }

    final synchronized void d(StringBuilder sb, long j) {
        if (j == 0) {
            return;
        }
        int iB = b();
        int iA = a();
        sb.append(", GWS successful rpcs: ");
        sb.append(this.l);
        sb.append(" (");
        long j2 = this.l;
        long j3 = b;
        sb.append((j2 * j3) / j);
        sb.append(" per hour), GWS successful bytes: ");
        sb.append(this.m);
        sb.append(" (");
        sb.append((this.m * j3) / j);
        sb.append(" per hour), GWS failed rpcs: ");
        sb.append(this.f595n);
        sb.append(" (");
        sb.append((((long) this.f595n) * j3) / j);
        sb.append(" per hour), GWS in-flight rpcs: ");
        sb.append(iB);
        sb.append(", GWS pending requests: ");
        sb.append(iA);
    }

    final synchronized void e(on onVar) {
        int iBinarySearch = Collections.binarySearch(this.j, onVar, c);
        if (iBinarySearch < 0) {
            iBinarySearch = -(iBinarySearch + 1);
        }
        this.j.add(iBinarySearch, onVar);
        this.j.size();
    }

    public final synchronized void f(on onVar, com.google.android.libraries.navigation.internal.gg.o oVar) {
        ((com.google.android.libraries.navigation.internal.kk.i) this.d.a(ag.f)).a(false);
        ((com.google.android.libraries.navigation.internal.kk.k) this.d.a(ag.g)).a(oVar.p.ordinal());
        if (!this.k) {
            this.h.add(onVar);
            this.i.add(onVar);
        }
        this.f595n++;
    }

    public final synchronized void g(on onVar) {
        int iO;
        ((com.google.android.libraries.navigation.internal.kk.i) this.d.a(ag.f)).a(true);
        this.h.add(onVar);
        this.l++;
        long j = this.m;
        if (onVar.H()) {
            iO = onVar.o(null);
            if (iO < 0) {
                throw new IllegalStateException(com.google.android.libraries.navigation.internal.b.b.b(iO, "serialized size must be non-negative, was "));
            }
        } else {
            int iO2 = onVar.am & Integer.MAX_VALUE;
            if (iO2 == Integer.MAX_VALUE) {
                iO2 = onVar.o(null);
                if (iO2 < 0) {
                    throw new IllegalStateException(com.google.android.libraries.navigation.internal.b.b.b(iO2, "serialized size must be non-negative, was "));
                }
                onVar.am = (onVar.am & Integer.MIN_VALUE) | iO2;
            }
            iO = iO2;
        }
        this.m = j + ((long) iO);
    }

    final synchronized void h() {
        ar.k(!this.k);
        this.k = true;
        ((com.google.android.libraries.navigation.internal.kk.j) this.d.a(ag.k)).b(b() + a());
        this.j.clear();
        gi giVarListIterator = ((fb) ((com.google.android.libraries.navigation.internal.agi.k) this.g).values()).listIterator();
        while (giVarListIterator.hasNext()) {
            ((com.google.android.libraries.navigation.internal.gg.b) giVarListIterator.next()).a();
        }
        this.g.clear();
    }

    final synchronized void i(long j, boolean z) {
        int iO;
        int iO2;
        ar.k(!this.k);
        if (a() == 0) {
            b();
            return;
        }
        long millis = j - TimeUnit.SECONDS.toMillis(this.f.a.i);
        while (!this.j.isEmpty() && c((on) this.j.get(0)) < millis) {
            TimeUnit.MILLISECONDS.toSeconds(j - c((on) this.j.get(0)));
            this.j.remove(0);
            ((com.google.android.libraries.navigation.internal.kk.j) this.d.a(ag.i)).a();
        }
        int i = this.f.a.P;
        if (i > 0) {
            b();
            gi giVarListIterator = ((fg) ((com.google.android.libraries.navigation.internal.agi.k) this.g).keySet()).listIterator();
            long j2 = 0;
            while (giVarListIterator.hasNext()) {
                on onVar = (on) giVarListIterator.next();
                if (onVar.H()) {
                    iO2 = onVar.o(null);
                    if (iO2 < 0) {
                        throw new IllegalStateException(com.google.android.libraries.navigation.internal.b.b.b(iO2, "serialized size must be non-negative, was "));
                    }
                } else {
                    int iO3 = onVar.am & Integer.MAX_VALUE;
                    if (iO3 == Integer.MAX_VALUE) {
                        iO3 = onVar.o(null);
                        if (iO3 < 0) {
                            throw new IllegalStateException(com.google.android.libraries.navigation.internal.b.b.b(iO3, "serialized size must be non-negative, was "));
                        }
                        onVar.am = (onVar.am & Integer.MIN_VALUE) | iO3;
                    }
                    iO2 = iO3;
                }
                j2 += (long) iO2;
            }
            int size = this.j.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                on onVar2 = (on) this.j.get(size);
                if (onVar2.H()) {
                    iO = onVar2.o(null);
                    if (iO < 0) {
                        throw new IllegalStateException(com.google.android.libraries.navigation.internal.b.b.b(iO, "serialized size must be non-negative, was "));
                    }
                } else {
                    int iO4 = onVar2.am & Integer.MAX_VALUE;
                    if (iO4 == Integer.MAX_VALUE) {
                        iO4 = onVar2.o(null);
                        if (iO4 < 0) {
                            throw new IllegalStateException(com.google.android.libraries.navigation.internal.b.b.b(iO4, "serialized size must be non-negative, was "));
                        }
                        onVar2.am = (onVar2.am & Integer.MIN_VALUE) | iO4;
                    }
                    iO = iO4;
                }
                j2 += (long) iO;
                if (j2 > i) {
                    int i2 = size + 1;
                    this.j.subList(0, i2).clear();
                    ((com.google.android.libraries.navigation.internal.kk.j) this.d.a(ag.j)).b(i2);
                    break;
                }
            }
        }
        while (!this.j.isEmpty()) {
            int size2 = this.j.size() - 1;
            on onVar3 = (on) this.j.get(size2);
            if (b() >= this.f.a.B) {
                if (!z) {
                    break;
                }
                ((com.google.android.libraries.navigation.internal.kk.j) this.d.a(ag.h)).a();
                break;
            }
            if (onVar3.H()) {
                int iO5 = onVar3.o(null);
                if (iO5 < 0) {
                    throw new IllegalStateException(com.google.android.libraries.navigation.internal.b.b.b(iO5, "serialized size must be non-negative, was "));
                }
            } else if ((onVar3.am & Integer.MAX_VALUE) != Integer.MAX_VALUE) {
                continue;
            } else {
                int iO6 = onVar3.o(null);
                if (iO6 < 0) {
                    throw new IllegalStateException(com.google.android.libraries.navigation.internal.b.b.b(iO6, "serialized size must be non-negative, was "));
                }
                onVar3.am = iO6 | (onVar3.am & Integer.MIN_VALUE);
            }
            j(onVar3, this.o.a(onVar3, new g(this), this.e));
            this.j.remove(size2);
            z = false;
        }
        if (this.j.isEmpty() && this.g.isEmpty()) {
        }
    }
}

package com.google.android.libraries.navigation.internal.aga;

import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bt implements com.google.android.libraries.navigation.internal.afx.ai {
    public final bm a;
    public final ScheduledExecutorService b;
    public final com.google.android.libraries.navigation.internal.afx.ag c;
    public final com.google.android.libraries.navigation.internal.afx.g d;
    public final boolean e;
    public final List f;
    public final com.google.android.libraries.navigation.internal.afx.cq g;
    public final bn h;
    public volatile List i;
    public final com.google.android.libraries.navigation.internal.yx.bm j;
    public com.google.android.libraries.navigation.internal.afx.cp k;
    public com.google.android.libraries.navigation.internal.afx.cp l;
    public de m;
    public u p;
    public volatile de q;
    public com.google.android.libraries.navigation.internal.afx.cl s;
    public volatile com.google.android.libraries.navigation.internal.afx.c t;
    public ap u;
    private final com.google.android.libraries.navigation.internal.afx.aj v;
    private final String w;
    private final s x;
    private final n y;
    private final ao z;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Collection f333n = new ArrayList();
    public final bb o = new bd(this);
    public volatile com.google.android.libraries.navigation.internal.afx.s r = com.google.android.libraries.navigation.internal.afx.s.a(com.google.android.libraries.navigation.internal.afx.r.IDLE);

    public bt(com.google.android.libraries.navigation.internal.afx.ao aoVar, String str, ao aoVar2, s sVar, ScheduledExecutorService scheduledExecutorService, com.google.android.libraries.navigation.internal.yx.br brVar, com.google.android.libraries.navigation.internal.afx.cq cqVar, bm bmVar, com.google.android.libraries.navigation.internal.afx.ag agVar, n nVar, com.google.android.libraries.navigation.internal.afx.aj ajVar, com.google.android.libraries.navigation.internal.afx.g gVar, List list) {
        Object obj;
        List list2 = aoVar.a;
        com.google.android.libraries.navigation.internal.yx.ar.r(list2, "addressGroups");
        com.google.android.libraries.navigation.internal.yx.ar.b(!list2.isEmpty(), "addressGroups is empty");
        c(list2, "addressGroups contains null entry");
        List listUnmodifiableList = Collections.unmodifiableList(new ArrayList(list2));
        this.i = listUnmodifiableList;
        this.h = new bn(listUnmodifiableList);
        this.w = str;
        this.z = aoVar2;
        this.x = sVar;
        this.b = scheduledExecutorService;
        this.j = (com.google.android.libraries.navigation.internal.yx.bm) brVar.a();
        this.g = cqVar;
        this.a = bmVar;
        this.c = agVar;
        this.y = nVar;
        this.v = ajVar;
        this.d = gVar;
        this.f = list;
        com.google.android.libraries.navigation.internal.afx.an anVar = com.google.android.libraries.navigation.internal.afx.az.c;
        com.google.android.libraries.navigation.internal.yx.ar.r(anVar, "key");
        int i = 0;
        while (true) {
            Object[][] objArr = aoVar.c;
            if (i >= objArr.length) {
                obj = anVar.a;
                break;
            } else {
                if (anVar.equals(objArr[i][0])) {
                    obj = aoVar.c[i][1];
                    break;
                }
                i++;
            }
        }
        this.e = ((Boolean) obj).booleanValue();
    }

    public static void c(List list, String str) {
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            com.google.android.libraries.navigation.internal.yx.ar.r(it2.next(), str);
        }
    }

    public static final String j(com.google.android.libraries.navigation.internal.afx.cl clVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(clVar.g);
        if (clVar.h != null) {
            sb.append("(");
            sb.append(clVar.h);
            sb.append(")");
        }
        if (clVar.i != null) {
            sb.append("[");
            sb.append(clVar.i);
            sb.append("]");
        }
        return sb.toString();
    }

    public final q a() {
        de deVar = this.q;
        if (deVar != null) {
            return deVar;
        }
        this.g.execute(new bf(this));
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.afx.al
    public final com.google.android.libraries.navigation.internal.afx.aj b() {
        return this.v;
    }

    public final void d(com.google.android.libraries.navigation.internal.afx.r rVar) {
        this.g.d();
        e(com.google.android.libraries.navigation.internal.afx.s.a(rVar));
    }

    public final void e(com.google.android.libraries.navigation.internal.afx.s sVar) {
        this.g.d();
        if (this.r.a != sVar.a) {
            com.google.android.libraries.navigation.internal.yx.ar.l(this.r.a != com.google.android.libraries.navigation.internal.afx.r.SHUTDOWN, "Cannot transition out of SHUTDOWN to ".concat(sVar.toString()));
            if (this.e && sVar.a == com.google.android.libraries.navigation.internal.afx.r.TRANSIENT_FAILURE) {
                this.r = com.google.android.libraries.navigation.internal.afx.s.a(com.google.android.libraries.navigation.internal.afx.r.IDLE);
            } else {
                this.r = sVar;
            }
            bm bmVar = this.a;
            com.google.android.libraries.navigation.internal.yx.ar.l(true, "listener is null");
            ((co) bmVar).a.a(sVar);
        }
    }

    public final void f() {
        this.g.execute(new bj(this));
    }

    public final void g(com.google.android.libraries.navigation.internal.afx.cl clVar) {
        this.g.execute(new bi(this, clVar));
    }

    public final void h() {
        com.google.android.libraries.navigation.internal.afx.ac acVar;
        this.g.d();
        com.google.android.libraries.navigation.internal.yx.ar.l(this.k == null, "Should have no reconnectTask scheduled");
        bn bnVar = this.h;
        if (bnVar.b == 0 && bnVar.c == 0) {
            com.google.android.libraries.navigation.internal.yx.bm bmVar = this.j;
            bmVar.c();
            bmVar.d();
        }
        SocketAddress socketAddressB = this.h.b();
        if (socketAddressB instanceof com.google.android.libraries.navigation.internal.afx.ac) {
            com.google.android.libraries.navigation.internal.afx.ac acVar2 = (com.google.android.libraries.navigation.internal.afx.ac) socketAddressB;
            acVar = acVar2;
            socketAddressB = acVar2.a;
        } else {
            acVar = null;
        }
        com.google.android.libraries.navigation.internal.afx.c cVarA = this.h.a();
        String str = (String) cVarA.a(com.google.android.libraries.navigation.internal.afx.z.a);
        r rVar = new r();
        if (str == null) {
            str = this.w;
        }
        com.google.android.libraries.navigation.internal.yx.ar.r(str, "authority");
        rVar.a = str;
        com.google.android.libraries.navigation.internal.yx.ar.r(cVarA, "eagAttributes");
        rVar.b = cVarA;
        rVar.c = null;
        rVar.d = acVar;
        bs bsVar = new bs();
        bsVar.a = this.v;
        bl blVar = new bl(this.x.a(socketAddressB, rVar, bsVar));
        bsVar.a = blVar.b();
        com.google.android.libraries.navigation.internal.afx.ag.a(this.c.d, blVar);
        this.p = blVar;
        this.f333n.add(blVar);
        this.g.c(blVar.a(new br(this, blVar)));
        this.d.b(2, "Started transport {0}", bsVar.a);
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarD = com.google.android.libraries.navigation.internal.yx.al.b(this).d("logId", this.v.a);
        akVarD.g("addressGroups", this.i);
        return akVarD.toString();
    }
}

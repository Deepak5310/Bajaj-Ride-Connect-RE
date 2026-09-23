package com.google.android.libraries.navigation.internal.aga;

import com.google.android.libraries.navigation.internal.yz.hx;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dp extends com.google.android.libraries.navigation.internal.afx.az {
    public static final Logger f = Logger.getLogger(dp.class.getName());
    public final com.google.android.libraries.navigation.internal.afx.ar g;
    public final Map h = new HashMap();
    public final dk i;
    public com.google.android.libraries.navigation.internal.afx.cp j;
    public boolean k;
    public com.google.android.libraries.navigation.internal.afx.cp l;
    private int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f336n;
    private com.google.android.libraries.navigation.internal.afx.r o;
    private com.google.android.libraries.navigation.internal.afx.r p;
    private final boolean q;
    private final boolean r;
    private final ao s;
    private ap t;

    public dp(com.google.android.libraries.navigation.internal.afx.ar arVar) {
        int i = com.google.android.libraries.navigation.internal.yz.ev.d;
        this.i = new dk(lv.a);
        boolean z = false;
        this.m = 0;
        this.f336n = true;
        this.j = null;
        this.o = com.google.android.libraries.navigation.internal.afx.r.IDLE;
        this.p = com.google.android.libraries.navigation.internal.afx.r.IDLE;
        if (!h()) {
            int i2 = dv.b;
            if (az.b("GRPC_PF_USE_HAPPY_EYEBALLS")) {
                z = true;
            }
        }
        this.q = z;
        this.k = true;
        this.s = new ao();
        this.l = null;
        this.r = h();
        this.g = arVar;
    }

    static boolean h() {
        return az.b("GRPC_SERIALIZE_RETRIES");
    }

    private final void i() {
        com.google.android.libraries.navigation.internal.afx.cp cpVar = this.j;
        if (cpVar != null) {
            cpVar.a();
            this.j = null;
        }
    }

    private final void j() {
        if (this.r && this.l == null) {
            if (this.t == null) {
                this.t = new ap();
            }
            long jA = this.t.a();
            this.l = this.g.c().a(new dh(this), jA, TimeUnit.NANOSECONDS, this.g.d());
        }
    }

    private final void k() {
        if (this.q) {
            com.google.android.libraries.navigation.internal.afx.cp cpVar = this.j;
            if (cpVar == null || !cpVar.b()) {
                this.j = this.g.c().a(new di(this), 250L, TimeUnit.MILLISECONDS, this.g.d());
            }
        }
    }

    private final void l(com.google.android.libraries.navigation.internal.afx.r rVar, com.google.android.libraries.navigation.internal.afx.ax axVar) {
        if (rVar == this.p && (rVar == com.google.android.libraries.navigation.internal.afx.r.IDLE || rVar == com.google.android.libraries.navigation.internal.afx.r.CONNECTING)) {
            return;
        }
        this.p = rVar;
        this.g.f(rVar, axVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x000f  */
    private static final SocketAddress m(com.google.android.libraries.navigation.internal.afx.aw awVar) {
        boolean z;
        List listA = awVar.a();
        if (listA != null) {
            z = listA.size() == 1;
        }
        com.google.android.libraries.navigation.internal.yx.ar.o(z, "%s does not have exactly one group", listA);
        return (SocketAddress) ((com.google.android.libraries.navigation.internal.afx.z) listA.get(0)).b.get(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.afx.az
    public final com.google.android.libraries.navigation.internal.afx.cl a(com.google.android.libraries.navigation.internal.afx.av avVar) {
        dl dlVar;
        Boolean bool;
        if (this.o == com.google.android.libraries.navigation.internal.afx.r.SHUTDOWN) {
            return com.google.android.libraries.navigation.internal.afx.cl.d.b("Already shut down");
        }
        Boolean bool2 = (Boolean) avVar.b.a(e);
        this.k = bool2 == null || !bool2.booleanValue();
        List<com.google.android.libraries.navigation.internal.afx.z> list = avVar.a;
        if (list.isEmpty()) {
            List list2 = avVar.a;
            com.google.android.libraries.navigation.internal.afx.cl clVarB = com.google.android.libraries.navigation.internal.afx.cl.f.b("NameResolver returned no usable address. addrs=" + String.valueOf(list2) + ", attrs=" + String.valueOf(avVar.b));
            b(clVarB);
            return clVarB;
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            if (((com.google.android.libraries.navigation.internal.afx.z) it2.next()) == null) {
                List list3 = avVar.a;
                com.google.android.libraries.navigation.internal.afx.cl clVarB2 = com.google.android.libraries.navigation.internal.afx.cl.f.b("NameResolver returned address list with null endpoint. addrs=" + String.valueOf(list3) + ", attrs=" + String.valueOf(avVar.b));
                b(clVarB2);
                return clVarB2;
            }
        }
        this.f336n = true;
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (com.google.android.libraries.navigation.internal.afx.z zVar : list) {
            ArrayList arrayList2 = new ArrayList();
            for (SocketAddress socketAddress : zVar.b) {
                if (hashSet.add(socketAddress)) {
                    arrayList2.add(socketAddress);
                }
            }
            if (!arrayList2.isEmpty()) {
                arrayList.add(new com.google.android.libraries.navigation.internal.afx.z(arrayList2, zVar.c));
            }
        }
        Object obj = avVar.c;
        if ((obj instanceof dl) && (bool = (dlVar = (dl) obj).a) != null && bool.booleanValue()) {
            Long l = dlVar.b;
            Collections.shuffle(arrayList, new Random());
        }
        int i = com.google.android.libraries.navigation.internal.yz.ev.d;
        com.google.android.libraries.navigation.internal.yz.eq eqVar = new com.google.android.libraries.navigation.internal.yz.eq();
        eqVar.j(arrayList);
        com.google.android.libraries.navigation.internal.yz.ev evVarG = eqVar.g();
        if (this.o == com.google.android.libraries.navigation.internal.afx.r.READY) {
            dk dkVar = this.i;
            SocketAddress socketAddressB = dkVar.b();
            dkVar.d(evVarG);
            if (this.i.g(socketAddressB)) {
                com.google.android.libraries.navigation.internal.afx.aw awVar = ((Cdo) this.h.get(socketAddressB)).a;
                dk dkVar2 = this.i;
                awVar.e(Collections.singletonList(new com.google.android.libraries.navigation.internal.afx.z(dkVar2.b(), dkVar2.a())));
                return com.google.android.libraries.navigation.internal.afx.cl.b;
            }
        } else {
            this.i.d(evVarG);
        }
        HashSet<SocketAddress> hashSet2 = new HashSet(this.h.keySet());
        HashSet hashSet3 = new HashSet();
        int i2 = ((lv) evVarG).c;
        for (int i3 = 0; i3 < i2; i3++) {
            hashSet3.addAll(((com.google.android.libraries.navigation.internal.afx.z) evVarG.get(i3)).b);
        }
        for (SocketAddress socketAddress2 : hashSet2) {
            if (!hashSet3.contains(socketAddress2)) {
                ((Cdo) this.h.remove(socketAddress2)).a.c();
            }
        }
        if (hashSet2.size() == 0) {
            com.google.android.libraries.navigation.internal.afx.r rVar = com.google.android.libraries.navigation.internal.afx.r.CONNECTING;
            this.o = rVar;
            l(rVar, new dm(com.google.android.libraries.navigation.internal.afx.as.a));
        }
        com.google.android.libraries.navigation.internal.afx.r rVar2 = this.o;
        if (rVar2 == com.google.android.libraries.navigation.internal.afx.r.READY) {
            com.google.android.libraries.navigation.internal.afx.r rVar3 = com.google.android.libraries.navigation.internal.afx.r.IDLE;
            this.o = rVar3;
            l(rVar3, new dn(this, this));
        } else if (rVar2 == com.google.android.libraries.navigation.internal.afx.r.CONNECTING || rVar2 == com.google.android.libraries.navigation.internal.afx.r.TRANSIENT_FAILURE) {
            i();
            d();
        }
        return com.google.android.libraries.navigation.internal.afx.cl.b;
    }

    @Override // com.google.android.libraries.navigation.internal.afx.az
    public final void b(com.google.android.libraries.navigation.internal.afx.cl clVar) {
        if (this.o == com.google.android.libraries.navigation.internal.afx.r.SHUTDOWN) {
            return;
        }
        Iterator it2 = this.h.values().iterator();
        while (it2.hasNext()) {
            ((Cdo) it2.next()).a.c();
        }
        this.h.clear();
        dk dkVar = this.i;
        int i = com.google.android.libraries.navigation.internal.yz.ev.d;
        dkVar.d(lv.a);
        com.google.android.libraries.navigation.internal.afx.r rVar = com.google.android.libraries.navigation.internal.afx.r.TRANSIENT_FAILURE;
        this.o = rVar;
        l(rVar, new dm(com.google.android.libraries.navigation.internal.afx.as.b(clVar)));
    }

    @Override // com.google.android.libraries.navigation.internal.afx.az
    public final void d() {
        if (!this.i.f() || this.o == com.google.android.libraries.navigation.internal.afx.r.SHUTDOWN) {
            return;
        }
        dk dkVar = this.i;
        Map map = this.h;
        SocketAddress socketAddressB = dkVar.b();
        Cdo cdo = (Cdo) map.get(socketAddressB);
        if (cdo == null) {
            com.google.android.libraries.navigation.internal.afx.c cVarA = this.i.a();
            dj djVar = new dj(this);
            com.google.android.libraries.navigation.internal.afx.ar arVar = this.g;
            com.google.android.libraries.navigation.internal.afx.am amVar = new com.google.android.libraries.navigation.internal.afx.am();
            amVar.c(hx.d(new com.google.android.libraries.navigation.internal.afx.z(socketAddressB, cVarA)));
            amVar.b(b, djVar);
            amVar.b(com.google.android.libraries.navigation.internal.afx.az.c, Boolean.valueOf(this.r));
            com.google.android.libraries.navigation.internal.afx.aw awVarB = arVar.b(amVar.a());
            final Cdo cdo2 = new Cdo(awVarB, com.google.android.libraries.navigation.internal.afx.r.IDLE);
            djVar.a = cdo2;
            this.h.put(socketAddressB, cdo2);
            com.google.android.libraries.navigation.internal.afx.ao aoVar = ((cq) awVarB).a;
            if (this.k || aoVar.b.a(com.google.android.libraries.navigation.internal.afx.az.d) == null) {
                cdo2.d = com.google.android.libraries.navigation.internal.afx.s.a(com.google.android.libraries.navigation.internal.afx.r.READY);
            }
            awVarB.d(new com.google.android.libraries.navigation.internal.afx.ay() { // from class: com.google.android.libraries.navigation.internal.aga.dg
                @Override // com.google.android.libraries.navigation.internal.afx.ay
                public final void a(com.google.android.libraries.navigation.internal.afx.s sVar) {
                    this.a.f(cdo2, sVar);
                }
            });
            cdo = cdo2;
        }
        int iOrdinal = cdo.b.ordinal();
        if (iOrdinal == 0) {
            k();
            return;
        }
        if (iOrdinal != 2) {
            if (iOrdinal != 3) {
                return;
            }
            cdo.a.b();
            cdo.b(com.google.android.libraries.navigation.internal.afx.r.CONNECTING);
            k();
            return;
        }
        if (!this.r) {
            this.i.e();
            d();
        } else if (!this.i.f()) {
            j();
        } else {
            cdo.a.b();
            cdo.b(com.google.android.libraries.navigation.internal.afx.r.CONNECTING);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.afx.az
    public final void e() {
        f.logp(Level.FINE, "io.grpc.internal.PickFirstLeafLoadBalancer", "shutdown", "Shutting down, currently have {} subchannels created", Integer.valueOf(this.h.size()));
        this.o = com.google.android.libraries.navigation.internal.afx.r.SHUTDOWN;
        this.p = com.google.android.libraries.navigation.internal.afx.r.SHUTDOWN;
        i();
        com.google.android.libraries.navigation.internal.afx.cp cpVar = this.l;
        if (cpVar != null) {
            cpVar.a();
            this.l = null;
        }
        this.t = null;
        Iterator it2 = this.h.values().iterator();
        while (it2.hasNext()) {
            ((Cdo) it2.next()).a.c();
        }
        this.h.clear();
    }

    final void f(Cdo cdo, com.google.android.libraries.navigation.internal.afx.s sVar) {
        com.google.android.libraries.navigation.internal.afx.r rVar;
        if (cdo == this.h.get(m(cdo.a)) && (rVar = sVar.a) != com.google.android.libraries.navigation.internal.afx.r.SHUTDOWN) {
            if (rVar == com.google.android.libraries.navigation.internal.afx.r.IDLE && cdo.b == com.google.android.libraries.navigation.internal.afx.r.READY) {
                this.g.e();
            }
            cdo.b(rVar);
            com.google.android.libraries.navigation.internal.afx.r rVar2 = this.o;
            com.google.android.libraries.navigation.internal.afx.r rVar3 = com.google.android.libraries.navigation.internal.afx.r.TRANSIENT_FAILURE;
            if (rVar2 == rVar3 || this.p == rVar3) {
                if (rVar == com.google.android.libraries.navigation.internal.afx.r.CONNECTING) {
                    return;
                }
                if (rVar == com.google.android.libraries.navigation.internal.afx.r.IDLE) {
                    d();
                    return;
                }
            }
            int iOrdinal = rVar.ordinal();
            if (iOrdinal == 0) {
                com.google.android.libraries.navigation.internal.afx.r rVar4 = com.google.android.libraries.navigation.internal.afx.r.CONNECTING;
                this.o = rVar4;
                l(rVar4, new dm(com.google.android.libraries.navigation.internal.afx.as.a));
                return;
            }
            if (iOrdinal == 1) {
                com.google.android.libraries.navigation.internal.afx.cp cpVar = this.l;
                if (cpVar != null) {
                    cpVar.a();
                    this.l = null;
                }
                this.t = null;
                i();
                for (Cdo cdo2 : this.h.values()) {
                    if (!cdo2.a.equals(cdo.a)) {
                        cdo2.a.c();
                    }
                }
                this.h.clear();
                cdo.b(com.google.android.libraries.navigation.internal.afx.r.READY);
                this.h.put(m(cdo.a), cdo);
                this.i.g(m(cdo.a));
                this.o = com.google.android.libraries.navigation.internal.afx.r.READY;
                g(cdo);
                return;
            }
            if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    throw new IllegalArgumentException("Unsupported state:".concat(String.valueOf(String.valueOf(rVar))));
                }
                this.i.c();
                com.google.android.libraries.navigation.internal.afx.r rVar5 = com.google.android.libraries.navigation.internal.afx.r.IDLE;
                this.o = rVar5;
                l(rVar5, new dn(this, this));
                return;
            }
            if (this.i.f() && this.h.get(this.i.b()) == cdo) {
                if (this.i.e()) {
                    i();
                    d();
                } else {
                    j();
                }
            }
            if (this.h.size() >= this.i.a) {
                Iterator it2 = this.h.values().iterator();
                while (it2.hasNext()) {
                    if (!((Cdo) it2.next()).c) {
                        return;
                    }
                }
                com.google.android.libraries.navigation.internal.afx.r rVar6 = com.google.android.libraries.navigation.internal.afx.r.TRANSIENT_FAILURE;
                this.o = rVar6;
                l(rVar6, new dm(com.google.android.libraries.navigation.internal.afx.as.b(sVar.b)));
                int i = this.m + 1;
                this.m = i;
                if (i >= this.i.a || this.f336n) {
                    this.f336n = false;
                    this.m = 0;
                    this.g.e();
                }
            }
        }
    }

    public final void g(Cdo cdo) {
        if (cdo.b != com.google.android.libraries.navigation.internal.afx.r.READY) {
            return;
        }
        if (this.k || cdo.a() == com.google.android.libraries.navigation.internal.afx.r.READY) {
            l(com.google.android.libraries.navigation.internal.afx.r.READY, new com.google.android.libraries.navigation.internal.afx.aq(com.google.android.libraries.navigation.internal.afx.as.c(cdo.a)));
            return;
        }
        com.google.android.libraries.navigation.internal.afx.r rVarA = cdo.a();
        com.google.android.libraries.navigation.internal.afx.r rVar = com.google.android.libraries.navigation.internal.afx.r.TRANSIENT_FAILURE;
        if (rVarA == rVar) {
            l(rVar, new dm(com.google.android.libraries.navigation.internal.afx.as.b(cdo.d.b)));
        } else if (this.p != rVar) {
            l(cdo.a(), new dm(com.google.android.libraries.navigation.internal.afx.as.a));
        }
    }
}

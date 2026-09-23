package com.google.android.libraries.navigation.internal.le;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import androidx.collection.ArrayMap;
import androidx.work.PeriodicWorkRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ae implements com.google.android.libraries.navigation.internal.ld.q, com.google.android.libraries.navigation.internal.ld.r {
    public final com.google.android.libraries.navigation.internal.ld.i b;
    public final i c;
    public final int e;
    public boolean f;
    public final /* synthetic */ ai i;
    private final u j;
    private final bg l;
    public final Queue a = new LinkedList();
    private final Set k = new HashSet();
    public final Map d = new HashMap();
    public final List g = new ArrayList();
    private com.google.android.libraries.navigation.internal.lc.a m = null;
    public int h = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public ae(ai aiVar, com.google.android.libraries.navigation.internal.ld.o oVar) {
        this.i = aiVar;
        com.google.android.libraries.navigation.internal.ld.i iVarA = oVar.e.a.a(oVar.b, aiVar.p.getLooper(), oVar.e().a(), oVar.f, this, this);
        com.google.android.libraries.navigation.internal.ln.a aVar = oVar.d;
        if (aVar != null) {
            ((com.google.android.libraries.navigation.internal.lh.k) iVarA).l = aVar;
        } else {
            String str = oVar.c;
            if (str != null) {
                ((com.google.android.libraries.navigation.internal.lh.k) iVarA).k = str;
            }
        }
        this.b = iVarA;
        this.c = oVar.g;
        this.j = new u();
        this.e = oVar.i;
        if (iVarA.n()) {
            this.l = new bg(aiVar.h, aiVar.p, oVar.e().a());
        } else {
            this.l = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final com.google.android.libraries.navigation.internal.lc.d q(com.google.android.libraries.navigation.internal.lc.d[] dVarArr) {
        if (dVarArr != null) {
            com.google.android.libraries.navigation.internal.lc.d[] dVarArrO = this.b.o();
            if (dVarArrO == null) {
                dVarArrO = new com.google.android.libraries.navigation.internal.lc.d[0];
            }
            ArrayMap arrayMap = new ArrayMap(dVarArrO.length);
            for (com.google.android.libraries.navigation.internal.lc.d dVar : dVarArrO) {
                arrayMap.put(dVar.a, Long.valueOf(dVar.a()));
            }
            for (int i = 0; i <= 0; i++) {
                com.google.android.libraries.navigation.internal.lc.d dVar2 = dVarArr[i];
                Long l = (Long) arrayMap.get(dVar2.a);
                if (l == null || l.longValue() < dVar2.a()) {
                    return dVar2;
                }
            }
        }
        return null;
    }

    private final com.google.android.libraries.navigation.internal.ld.ab r(com.google.android.libraries.navigation.internal.lc.a aVar) {
        return ai.a(this.c, aVar);
    }

    private final void s(com.google.android.libraries.navigation.internal.lc.a aVar) {
        Iterator it2 = this.k.iterator();
        if (!it2.hasNext()) {
            this.k.clear();
            return;
        }
        if (com.google.android.libraries.navigation.internal.lh.az.a(aVar, com.google.android.libraries.navigation.internal.lc.a.a)) {
            this.b.q();
        }
        throw null;
    }

    private final void t(com.google.android.libraries.navigation.internal.ld.ab abVar, Exception exc, boolean z) {
        com.google.android.libraries.navigation.internal.lh.be.d(this.i.p);
        if ((abVar == null) == (exc == null)) {
            throw new IllegalArgumentException("Status XOR exception should be null");
        }
        Iterator it2 = this.a.iterator();
        while (it2.hasNext()) {
            g gVar = (g) it2.next();
            if (!z || gVar.c == 2) {
                if (abVar != null) {
                    gVar.d(abVar);
                } else {
                    gVar.e(exc);
                }
                it2.remove();
            }
        }
    }

    private final void u() {
        this.i.p.removeMessages(12, this.c);
        Handler handler = this.i.p;
        handler.sendMessageDelayed(handler.obtainMessage(12, this.c), this.i.f);
    }

    private final void v(g gVar) {
        gVar.g(this.j, o());
        try {
            gVar.f(this);
        } catch (DeadObjectException unused) {
            a(1);
            this.b.j("DeadObjectException thrown while running ApiCallRunner.");
        }
    }

    private final boolean w(g gVar) {
        if (!(gVar instanceof a)) {
            v(gVar);
            return true;
        }
        a aVar = (a) gVar;
        com.google.android.libraries.navigation.internal.lc.d dVarQ = q(aVar.b(this));
        if (dVarQ == null) {
            v(gVar);
            return true;
        }
        this.b.getClass();
        if (!this.i.q || !aVar.a(this)) {
            aVar.e(new com.google.android.libraries.navigation.internal.ld.ae(dVarQ));
            return true;
        }
        af afVar = new af(this.c, dVarQ);
        int iIndexOf = this.g.indexOf(afVar);
        if (iIndexOf >= 0) {
            af afVar2 = (af) this.g.get(iIndexOf);
            this.i.p.removeMessages(15, afVar2);
            Handler handler = this.i.p;
            handler.sendMessageDelayed(Message.obtain(handler, 15, afVar2), 5000L);
            return false;
        }
        this.g.add(afVar);
        Handler handler2 = this.i.p;
        handler2.sendMessageDelayed(Message.obtain(handler2, 15, afVar), 5000L);
        Handler handler3 = this.i.p;
        handler3.sendMessageDelayed(Message.obtain(handler3, 16, afVar), 120000L);
        com.google.android.libraries.navigation.internal.lc.a aVar2 = new com.google.android.libraries.navigation.internal.lc.a(2, null);
        x();
        this.i.g(aVar2, this.e);
        return false;
    }

    private final boolean x() {
        synchronized (ai.c) {
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.le.r
    public final void a(int i) {
        if (Looper.myLooper() == this.i.p.getLooper()) {
            k(i);
            return;
        }
        ai aiVar = this.i;
        aiVar.p.post(new ab(this, i));
    }

    @Override // com.google.android.libraries.navigation.internal.le.r
    public final void b() {
        if (Looper.myLooper() == this.i.p.getLooper()) {
            h();
            return;
        }
        ai aiVar = this.i;
        aiVar.p.post(new aa(this));
    }

    public final void c() {
        com.google.android.libraries.navigation.internal.lh.be.d(this.i.p);
        this.m = null;
    }

    /* JADX WARN: Type inference failed for: r2v7, types: [com.google.android.libraries.navigation.internal.ld.i, com.google.android.libraries.navigation.internal.mc.e] */
    public final void d() {
        int iF;
        com.google.android.libraries.navigation.internal.lh.be.d(this.i.p);
        if (this.b.l() || this.b.m()) {
            return;
        }
        try {
            ai aiVar = this.i;
            com.google.android.libraries.navigation.internal.lh.aj ajVar = aiVar.j;
            Context context = aiVar.h;
            com.google.android.libraries.navigation.internal.ld.i iVar = this.b;
            com.google.android.libraries.navigation.internal.lh.be.j(context);
            com.google.android.libraries.navigation.internal.lh.be.j(iVar);
            iVar.r();
            int iA = iVar.a();
            int iB = ajVar.b(iA);
            if (iB == -1) {
                synchronized (ajVar.a) {
                    int i = 0;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= ajVar.a.size()) {
                            i = -1;
                            break;
                        }
                        int iKeyAt = ajVar.a.keyAt(i2);
                        if (iKeyAt > iA && ajVar.a.get(iKeyAt) == 0) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    iF = i == -1 ? ajVar.b.f(context, iA) : i;
                    ajVar.a.put(iA, iF);
                }
                iB = iF;
            }
            if (iB != 0) {
                com.google.android.libraries.navigation.internal.lc.a aVar = new com.google.android.libraries.navigation.internal.lc.a(iB, null);
                this.b.getClass();
                i(aVar);
                return;
            }
            ai aiVar2 = this.i;
            com.google.android.libraries.navigation.internal.ld.i iVar2 = this.b;
            ah ahVar = new ah(aiVar2, iVar2, this.c);
            if (iVar2.n()) {
                bg bgVar = this.l;
                com.google.android.libraries.navigation.internal.lh.be.j(bgVar);
                com.google.android.libraries.navigation.internal.mc.e eVar = bgVar.f;
                if (eVar != null) {
                    eVar.i();
                }
                bgVar.e.g = Integer.valueOf(System.identityHashCode(bgVar));
                com.google.android.libraries.navigation.internal.ld.a aVar2 = bgVar.c;
                Context context2 = bgVar.a;
                Handler handler = bgVar.b;
                com.google.android.libraries.navigation.internal.lh.p pVar = bgVar.e;
                bgVar.f = aVar2.a(context2, handler.getLooper(), pVar, pVar.f, bgVar, bgVar);
                bgVar.g = ahVar;
                Set set = bgVar.d;
                if (set == null || set.isEmpty()) {
                    bgVar.b.post(new be(bgVar));
                } else {
                    bgVar.f.e();
                }
            }
            try {
                this.b.h(ahVar);
            } catch (SecurityException e) {
                j(new com.google.android.libraries.navigation.internal.lc.a(10), e);
            }
        } catch (IllegalStateException e2) {
            j(new com.google.android.libraries.navigation.internal.lc.a(10), e2);
        }
    }

    public final void e(g gVar) {
        com.google.android.libraries.navigation.internal.lh.be.d(this.i.p);
        if (this.b.l()) {
            if (w(gVar)) {
                u();
                return;
            } else {
                this.a.add(gVar);
                return;
            }
        }
        this.a.add(gVar);
        com.google.android.libraries.navigation.internal.lc.a aVar = this.m;
        if (aVar == null || !aVar.b()) {
            d();
        } else {
            i(this.m);
        }
    }

    public final void f(com.google.android.libraries.navigation.internal.ld.ab abVar) {
        com.google.android.libraries.navigation.internal.lh.be.d(this.i.p);
        t(abVar, null, false);
    }

    public final void g() {
        ArrayList arrayList = new ArrayList(this.a);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            g gVar = (g) arrayList.get(i);
            if (!this.b.l()) {
                return;
            }
            if (w(gVar)) {
                this.a.remove(gVar);
            }
        }
    }

    public final void h() {
        c();
        s(com.google.android.libraries.navigation.internal.lc.a.a);
        n();
        Iterator it2 = this.d.values().iterator();
        while (it2.hasNext()) {
            ax axVar = (ax) it2.next();
            if (q(axVar.a.b) != null) {
                it2.remove();
            } else {
                try {
                    axVar.a.b(this.b, new com.google.android.libraries.navigation.internal.me.aa());
                } catch (DeadObjectException unused) {
                    a(3);
                    this.b.j("DeadObjectException thrown while calling register listener method.");
                } catch (RemoteException | RuntimeException unused2) {
                    it2.remove();
                }
            }
        }
        g();
        u();
    }

    @Override // com.google.android.libraries.navigation.internal.le.au
    public final void i(com.google.android.libraries.navigation.internal.lc.a aVar) {
        j(aVar, null);
    }

    public final void j(com.google.android.libraries.navigation.internal.lc.a aVar, Exception exc) {
        com.google.android.libraries.navigation.internal.mc.e eVar;
        com.google.android.libraries.navigation.internal.lh.be.d(this.i.p);
        bg bgVar = this.l;
        if (bgVar != null && (eVar = bgVar.f) != null) {
            eVar.i();
        }
        c();
        this.i.j.a();
        s(aVar);
        if ((this.b instanceof com.google.android.libraries.navigation.internal.lj.f) && aVar.c != 24) {
            ai aiVar = this.i;
            aiVar.g = true;
            Handler handler = aiVar.p;
            handler.sendMessageDelayed(handler.obtainMessage(19), PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS);
        }
        int i = aVar.c;
        if (i == 4) {
            f(ai.b);
            return;
        }
        if (i == 25) {
            f(r(aVar));
            return;
        }
        if (this.a.isEmpty()) {
            this.m = aVar;
            return;
        }
        if (exc != null) {
            com.google.android.libraries.navigation.internal.lh.be.d(this.i.p);
            t(null, exc, false);
            return;
        }
        if (!this.i.q) {
            f(r(aVar));
            return;
        }
        t(r(aVar), null, true);
        if (this.a.isEmpty()) {
            return;
        }
        x();
        if (this.i.g(aVar, this.e)) {
            return;
        }
        if (aVar.c == 18) {
            this.f = true;
        }
        if (!this.f) {
            f(r(aVar));
            return;
        }
        ai aiVar2 = this.i;
        i iVar = this.c;
        Handler handler2 = aiVar2.p;
        handler2.sendMessageDelayed(Message.obtain(handler2, 9, iVar), 5000L);
    }

    public final void k(int i) {
        c();
        this.f = true;
        String strF = this.b.f();
        StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
        if (i == 1) {
            sb.append(" due to service disconnection.");
        } else if (i == 3) {
            sb.append(" due to dead object exception.");
        }
        if (strF != null) {
            sb.append(" Last reason for disconnect: ");
            sb.append(strF);
        }
        this.j.a(true, new com.google.android.libraries.navigation.internal.ld.ab(20, sb.toString()));
        ai aiVar = this.i;
        i iVar = this.c;
        Handler handler = aiVar.p;
        handler.sendMessageDelayed(Message.obtain(handler, 9, iVar), 5000L);
        ai aiVar2 = this.i;
        i iVar2 = this.c;
        Handler handler2 = aiVar2.p;
        handler2.sendMessageDelayed(Message.obtain(handler2, 11, iVar2), 120000L);
        this.i.j.a();
        Iterator it2 = this.d.values().iterator();
        while (it2.hasNext()) {
            Runnable runnable = ((ax) it2.next()).c;
        }
    }

    public final void l(com.google.android.libraries.navigation.internal.lc.a aVar) {
        com.google.android.libraries.navigation.internal.lh.be.d(this.i.p);
        com.google.android.libraries.navigation.internal.ld.i iVar = this.b;
        iVar.j("onSignInFailed for " + iVar.getClass().getName() + " with " + String.valueOf(aVar));
        i(aVar);
    }

    public final void m() {
        com.google.android.libraries.navigation.internal.lh.be.d(this.i.p);
        f(ai.a);
        this.j.a(false, ai.a);
        for (ao aoVar : (ao[]) this.d.keySet().toArray(new ao[0])) {
            e(new f(aoVar, new com.google.android.libraries.navigation.internal.me.aa()));
        }
        s(new com.google.android.libraries.navigation.internal.lc.a(4));
        if (this.b.l()) {
            this.b.p(new ad(this));
        }
    }

    public final void n() {
        if (this.f) {
            ai aiVar = this.i;
            aiVar.p.removeMessages(11, this.c);
            ai aiVar2 = this.i;
            aiVar2.p.removeMessages(9, this.c);
            this.f = false;
        }
    }

    public final boolean o() {
        return this.b.n();
    }

    public final void p(boolean z) {
        com.google.android.libraries.navigation.internal.lh.be.d(this.i.p);
        if (this.b.l() && this.d.isEmpty()) {
            u uVar = this.j;
            if (uVar.a.isEmpty() && uVar.b.isEmpty()) {
                this.b.j("Timing out service connection.");
            } else {
                u();
            }
        }
    }
}

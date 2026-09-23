package com.google.android.libraries.navigation.internal.b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ah implements s {
    public final Map a = new HashMap();
    public final aa b;
    private final e c;
    private final BlockingQueue d;

    public ah(e eVar, BlockingQueue blockingQueue, aa aaVar) {
        this.b = aaVar;
        this.c = eVar;
        this.d = blockingQueue;
    }

    @Override // com.google.android.libraries.navigation.internal.b.s
    public final synchronized void a(t tVar) {
        Map map = this.a;
        String strD = tVar.d();
        List list = (List) map.remove(strD);
        if (list == null || list.isEmpty()) {
            return;
        }
        if (ag.b) {
            ag.a("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(list.size()), strD);
        }
        t tVar2 = (t) list.remove(0);
        this.a.put(strD, list);
        tVar2.m(this);
        try {
            this.d.put(tVar2);
        } catch (InterruptedException e) {
            ag.b("Couldn't add request to queue. %s", e.toString());
            Thread.currentThread().interrupt();
            this.c.a();
        }
    }

    final synchronized boolean b(t tVar) {
        Map map = this.a;
        String strD = tVar.d();
        if (!map.containsKey(strD)) {
            this.a.put(strD, null);
            tVar.m(this);
            if (ag.b) {
                ag.b("new request, sending to network %s", strD);
            }
            return false;
        }
        List arrayList = (List) this.a.get(strD);
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        tVar.f("waiting-for-response");
        arrayList.add(tVar);
        this.a.put(strD, arrayList);
        if (ag.b) {
            ag.b("Request for cacheKey=%s is in flight, putting on hold.", strD);
        }
        return true;
    }
}

package com.google.android.libraries.navigation.internal.b;

import android.os.Process;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends Thread {
    private static final boolean b = ag.b;
    public final BlockingQueue a;
    private final BlockingQueue c;
    private final c d;
    private final aa e;
    private volatile boolean f = false;
    private final ah g;

    public e(BlockingQueue blockingQueue, BlockingQueue blockingQueue2, c cVar, aa aaVar) {
        this.c = blockingQueue;
        this.a = blockingQueue2;
        this.d = cVar;
        this.e = aaVar;
        this.g = new ah(this, blockingQueue2, aaVar);
    }

    private void b() throws InterruptedException {
        List arrayList;
        List list;
        t tVar = (t) this.c.take();
        tVar.f("cache-queue-take");
        tVar.l(1);
        try {
            if (tVar.n()) {
                tVar.i("cache-discard-canceled");
            } else {
                b bVarA = this.d.a(tVar.d());
                if (bVarA == null) {
                    tVar.f("cache-miss");
                    if (!this.g.b(tVar)) {
                        this.a.put(tVar);
                    }
                } else {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (bVarA.a(jCurrentTimeMillis)) {
                        tVar.f("cache-hit-expired");
                        tVar.k = bVarA;
                        if (!this.g.b(tVar)) {
                            this.a.put(tVar);
                        }
                    } else {
                        tVar.f("cache-hit");
                        byte[] bArr = bVarA.a;
                        Map map = bVarA.g;
                        if (map == null) {
                            list = null;
                        } else {
                            if (map.isEmpty()) {
                                arrayList = Collections.emptyList();
                            } else {
                                arrayList = new ArrayList(map.size());
                                for (Map.Entry entry : map.entrySet()) {
                                    arrayList.add(new k((String) entry.getKey(), (String) entry.getValue()));
                                }
                            }
                            list = arrayList;
                        }
                        z zVarB = tVar.b(new o(200, bArr, map, list, false));
                        tVar.f("cache-hit-parsed");
                        if (!zVarB.a()) {
                            tVar.f("cache-parsing-failed");
                            this.d.d(tVar.d());
                            tVar.k = null;
                            if (!this.g.b(tVar)) {
                                this.a.put(tVar);
                            }
                        } else if (bVarA.f < jCurrentTimeMillis) {
                            tVar.f("cache-hit-refresh-needed");
                            tVar.k = bVarA;
                            zVarB.d = true;
                            if (this.g.b(tVar)) {
                                this.e.b(tVar, zVarB);
                            } else {
                                aa aaVar = this.e;
                                d dVar = new d(this, tVar);
                                if (com.google.android.libraries.navigation.internal.abf.p.f(com.google.android.libraries.navigation.internal.abg.v.c, 3)) {
                                    com.google.android.libraries.navigation.internal.abg.v.e(tVar);
                                    com.google.android.libraries.navigation.internal.abg.v.f(zVarB);
                                }
                                if (tVar.i && zVarB.a()) {
                                    ((com.google.android.libraries.navigation.internal.abg.k) aaVar).a.put(tVar.c, zVarB);
                                }
                                ((com.google.android.libraries.navigation.internal.abg.k) aaVar).b.c(tVar, zVarB, dVar);
                            }
                        } else {
                            this.e.b(tVar, zVarB);
                        }
                    }
                }
            }
        } finally {
            tVar.l(2);
        }
    }

    public final void a() {
        this.f = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        if (b) {
            ag.a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.d.b();
        while (true) {
            try {
                b();
            } catch (InterruptedException unused) {
                if (this.f) {
                    Thread.currentThread().interrupt();
                    return;
                }
                ag.b("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}

package com.google.android.libraries.navigation.internal.le;

import android.app.ActivityManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.collection.ArraySet;
import androidx.work.PeriodicWorkRequest;
import com.google.android.gms.cloudmessaging.CloudMessagingReceiver;
import com.google.android.libraries.navigation.internal.lh.bp;
import com.google.android.libraries.navigation.internal.lh.bq;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ai implements Handler.Callback {
    public static final com.google.android.libraries.navigation.internal.ld.ab a = new com.google.android.libraries.navigation.internal.ld.ab(4, "Sign-out occurred while this API call was in progress.");
    public static final com.google.android.libraries.navigation.internal.ld.ab b = new com.google.android.libraries.navigation.internal.ld.ab(4, "The user must be signed in to make this API call.");
    public static final Object c = new Object();
    private static ai r;
    public final Context h;
    public final com.google.android.libraries.navigation.internal.lc.h i;
    public final com.google.android.libraries.navigation.internal.lh.aj j;
    public final Handler p;
    public volatile boolean q;
    private com.google.android.libraries.navigation.internal.lh.bn s;
    private bp t;
    public final long d = 5000;
    public final long e = 120000;
    public long f = 10000;
    public boolean g = false;
    public final AtomicInteger k = new AtomicInteger(1);
    public final AtomicInteger l = new AtomicInteger(0);
    public final Map m = new ConcurrentHashMap(5, 0.75f, 1);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final v f479n = null;
    public final Set o = new ArraySet();
    private final Set u = new ArraySet();

    private ai(Context context, Looper looper, com.google.android.libraries.navigation.internal.lc.h hVar) {
        this.q = true;
        this.h = context;
        com.google.android.libraries.navigation.internal.lt.c cVar = new com.google.android.libraries.navigation.internal.lt.c(looper, this);
        this.p = cVar;
        this.i = hVar;
        this.j = new com.google.android.libraries.navigation.internal.lh.aj(hVar);
        PackageManager packageManager = context.getPackageManager();
        if (com.google.android.libraries.navigation.internal.ll.e.b == null) {
            com.google.android.libraries.navigation.internal.ll.e.b = Boolean.valueOf(com.google.android.libraries.navigation.internal.ll.i.d() && packageManager.hasSystemFeature("android.hardware.type.automotive"));
        }
        if (com.google.android.libraries.navigation.internal.ll.e.b.booleanValue()) {
            this.q = false;
        }
        cVar.sendMessage(cVar.obtainMessage(6));
    }

    public static com.google.android.libraries.navigation.internal.ld.ab a(i iVar, com.google.android.libraries.navigation.internal.lc.a aVar) {
        return new com.google.android.libraries.navigation.internal.ld.ab(17, "API: " + iVar.a.c + " is not available on this device. Connection failed with: " + String.valueOf(aVar), aVar.d, aVar);
    }

    public static ai c(Context context) {
        ai aiVar;
        HandlerThread handlerThread;
        synchronized (c) {
            if (r == null) {
                synchronized (com.google.android.libraries.navigation.internal.lh.ad.b) {
                    handlerThread = com.google.android.libraries.navigation.internal.lh.ad.e;
                    if (handlerThread == null) {
                        com.google.android.libraries.navigation.internal.lh.ad.e = new HandlerThread("GoogleApiHandler", 9);
                        com.google.android.libraries.navigation.internal.lh.ad.e.start();
                        handlerThread = com.google.android.libraries.navigation.internal.lh.ad.e;
                    }
                }
                r = new ai(context.getApplicationContext(), handlerThread.getLooper(), com.google.android.libraries.navigation.internal.lc.h.a);
            }
            aiVar = r;
        }
        return aiVar;
    }

    private final ae h(com.google.android.libraries.navigation.internal.ld.o oVar) {
        Map map = this.m;
        i iVar = oVar.g;
        ae aeVar = (ae) map.get(iVar);
        if (aeVar == null) {
            aeVar = new ae(this, oVar);
            this.m.put(iVar, aeVar);
        }
        if (aeVar.o()) {
            this.u.add(iVar);
        }
        aeVar.d();
        return aeVar;
    }

    private final bp i() {
        if (this.t == null) {
            this.t = new com.google.android.libraries.navigation.internal.lj.e(this.h, bq.b);
        }
        return this.t;
    }

    private final void j() {
        com.google.android.libraries.navigation.internal.lh.bn bnVar = this.s;
        if (bnVar != null) {
            if (bnVar.a > 0 || f()) {
                i().a(bnVar);
            }
            this.s = null;
        }
    }

    final ae b(i iVar) {
        return (ae) this.m.get(iVar);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0047  */
    /* JADX WARN: Code duplicated, block: B:27:0x004e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:30:0x0056  */
    /* JADX WARN: Code duplicated, block: B:31:0x005c  */
    public final void d(com.google.android.libraries.navigation.internal.me.aa aaVar, int i, com.google.android.libraries.navigation.internal.ld.o oVar) {
        long jCurrentTimeMillis;
        long jElapsedRealtime;
        if (i != 0) {
            i iVar = oVar.g;
            as asVar = null;
            if (f()) {
                com.google.android.libraries.navigation.internal.lh.bl blVar = com.google.android.libraries.navigation.internal.lh.bk.a().a;
                boolean z = true;
                if (blVar == null) {
                    if (z) {
                        jCurrentTimeMillis = System.currentTimeMillis();
                    } else {
                        jCurrentTimeMillis = 0;
                    }
                    if (z) {
                        jElapsedRealtime = SystemClock.elapsedRealtime();
                    } else {
                        jElapsedRealtime = 0;
                    }
                    asVar = new as(this, i, iVar, jCurrentTimeMillis, jElapsedRealtime);
                } else if (blVar.b) {
                    boolean z2 = blVar.c;
                    ae aeVarB = b(iVar);
                    if (aeVarB != null) {
                        Object obj = aeVarB.b;
                        if (obj instanceof com.google.android.libraries.navigation.internal.lh.k) {
                            com.google.android.libraries.navigation.internal.lh.k kVar = (com.google.android.libraries.navigation.internal.lh.k) obj;
                            if (!kVar.A() || kVar.m()) {
                                z = z2;
                            } else {
                                com.google.android.libraries.navigation.internal.lh.t tVarB = as.b(aeVarB, kVar, i);
                                if (tVarB != null) {
                                    aeVarB.h++;
                                    z = tVarB.c;
                                }
                            }
                            if (z) {
                                jCurrentTimeMillis = System.currentTimeMillis();
                            } else {
                                jCurrentTimeMillis = 0;
                            }
                            if (z) {
                                jElapsedRealtime = SystemClock.elapsedRealtime();
                            } else {
                                jElapsedRealtime = 0;
                            }
                            asVar = new as(this, i, iVar, jCurrentTimeMillis, jElapsedRealtime);
                        }
                    } else {
                        z = z2;
                        if (z) {
                            jCurrentTimeMillis = System.currentTimeMillis();
                        } else {
                            jCurrentTimeMillis = 0;
                        }
                        if (z) {
                            jElapsedRealtime = SystemClock.elapsedRealtime();
                        } else {
                            jElapsedRealtime = 0;
                        }
                        asVar = new as(this, i, iVar, jCurrentTimeMillis, jElapsedRealtime);
                    }
                }
            }
            if (asVar != null) {
                com.google.android.libraries.navigation.internal.me.ae aeVar = aaVar.a;
                final Handler handler = this.p;
                Objects.requireNonNull(handler);
                aeVar.g(new Executor() { // from class: com.google.android.libraries.navigation.internal.le.y
                    @Override // java.util.concurrent.Executor
                    public final void execute(Runnable runnable) {
                        handler.post(runnable);
                    }
                }, asVar);
            }
        }
    }

    public final void e(com.google.android.libraries.navigation.internal.lc.a aVar, int i) {
        if (g(aVar, i)) {
            return;
        }
        Handler handler = this.p;
        handler.sendMessage(handler.obtainMessage(5, i, 0, aVar));
    }

    final boolean f() {
        if (this.g) {
            return false;
        }
        com.google.android.libraries.navigation.internal.lh.bl blVar = com.google.android.libraries.navigation.internal.lh.bk.a().a;
        if (blVar != null && !blVar.b) {
            return false;
        }
        int iB = this.j.b(203400000);
        return iB == -1 || iB == 0;
    }

    final boolean g(com.google.android.libraries.navigation.internal.lc.a aVar, int i) {
        Context context = this.h;
        if (com.google.android.libraries.navigation.internal.ln.b.a(context)) {
            return false;
        }
        com.google.android.libraries.navigation.internal.lc.h hVar = this.i;
        PendingIntent pendingIntentC = aVar.b() ? aVar.d : hVar.c(context, aVar.c, null);
        if (pendingIntentC == null) {
            return false;
        }
        int i2 = aVar.c;
        Intent intent = new Intent(context, (Class<?>) com.google.android.libraries.navigation.internal.ld.p.class);
        intent.putExtra(CloudMessagingReceiver.IntentKeys.PENDING_INTENT, pendingIntentC);
        intent.putExtra("failing_client_id", i);
        intent.putExtra("notify_manager", true);
        hVar.d(context, i2, PendingIntent.getActivity(context, 0, intent, com.google.android.libraries.navigation.internal.ls.a.a | 134217728));
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:108:0x0285  */
    /* JADX WARN: Code duplicated, block: B:122:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:124:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:125:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:126:0x02eb  */
    /* JADX WARN: Instruction removed from duplicated block: B:124:0x02b8, please report this as an issue */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        com.google.android.libraries.navigation.internal.lc.d[] dVarArrB;
        int i = message.what;
        long j = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
        ae aeVar = null;
        switch (i) {
            case 1:
                if (true == ((Boolean) message.obj).booleanValue()) {
                    j = 10000;
                }
                this.f = j;
                this.p.removeMessages(12);
                for (i iVar : this.m.keySet()) {
                    Handler handler = this.p;
                    handler.sendMessageDelayed(handler.obtainMessage(12, iVar), this.f);
                }
                return true;
            case 2:
                throw null;
            case 3:
                for (ae aeVar2 : this.m.values()) {
                    aeVar2.c();
                    aeVar2.d();
                }
                return true;
            case 4:
            case 8:
            case 13:
                av avVar = (av) message.obj;
                ae aeVarH = (ae) this.m.get(avVar.c.g);
                if (aeVarH == null) {
                    aeVarH = h(avVar.c);
                }
                if (!aeVarH.o() || this.l.get() == avVar.b) {
                    aeVarH.e(avVar.a);
                } else {
                    avVar.a.d(a);
                    aeVarH.m();
                }
                return true;
            case 5:
                int i2 = message.arg1;
                com.google.android.libraries.navigation.internal.lc.a aVar = (com.google.android.libraries.navigation.internal.lc.a) message.obj;
                for (ae aeVar3 : this.m.values()) {
                    if (aeVar3.e == i2) {
                        aeVar = aeVar3;
                        if (aeVar != null) {
                            new Exception();
                        } else if (aVar.c == 13) {
                            String str = aVar.e;
                            int i3 = com.google.android.libraries.navigation.internal.lc.ak.d;
                            aeVar.f(new com.google.android.libraries.navigation.internal.ld.ab(17, "Error resolution was canceled by the user, original error message: " + com.google.android.libraries.navigation.internal.lc.a.a(13) + ": " + str));
                        } else {
                            aeVar.f(a(aeVar.c, aVar));
                        }
                        return true;
                    }
                }
                if (aeVar != null) {
                    new Exception();
                } else if (aVar.c == 13) {
                    String str2 = aVar.e;
                    int i4 = com.google.android.libraries.navigation.internal.lc.ak.d;
                    aeVar.f(new com.google.android.libraries.navigation.internal.ld.ab(17, "Error resolution was canceled by the user, original error message: " + com.google.android.libraries.navigation.internal.lc.a.a(13) + ": " + str2));
                } else {
                    aeVar.f(a(aeVar.c, aVar));
                }
                return true;
            case 6:
                if (this.h.getApplicationContext() instanceof Application) {
                    Application application = (Application) this.h.getApplicationContext();
                    synchronized (k.a) {
                        k kVar = k.a;
                        if (!kVar.e) {
                            application.registerActivityLifecycleCallbacks(kVar);
                            application.registerComponentCallbacks(k.a);
                            k.a.e = true;
                        }
                        break;
                    }
                    k kVar2 = k.a;
                    z zVar = new z(this);
                    synchronized (kVar2) {
                        kVar2.d.add(zVar);
                        break;
                    }
                    k kVar3 = k.a;
                    if (kVar3.c.get()) {
                        if (!kVar3.b.get()) {
                            this.f = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
                        }
                    } else if (!com.google.android.libraries.navigation.internal.ll.j.a()) {
                        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                        ActivityManager.getMyMemoryState(runningAppProcessInfo);
                        if (!kVar3.c.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                            kVar3.b.set(true);
                        }
                        if (!kVar3.b.get()) {
                            this.f = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
                        }
                    }
                }
                return true;
            case 7:
                h((com.google.android.libraries.navigation.internal.ld.o) message.obj);
                return true;
            case 9:
                if (this.m.containsKey(message.obj)) {
                    ae aeVar4 = (ae) this.m.get(message.obj);
                    com.google.android.libraries.navigation.internal.lh.be.d(aeVar4.i.p);
                    if (aeVar4.f) {
                        aeVar4.d();
                    }
                }
                return true;
            case 10:
                Iterator it2 = this.u.iterator();
                while (it2.hasNext()) {
                    ae aeVar5 = (ae) this.m.remove((i) it2.next());
                    if (aeVar5 != null) {
                        aeVar5.m();
                    }
                }
                this.u.clear();
                return true;
            case 11:
                if (this.m.containsKey(message.obj)) {
                    ae aeVar6 = (ae) this.m.get(message.obj);
                    com.google.android.libraries.navigation.internal.lh.be.d(aeVar6.i.p);
                    if (aeVar6.f) {
                        aeVar6.n();
                        ai aiVar = aeVar6.i;
                        aeVar6.f(aiVar.i.e(aiVar.h) == 18 ? new com.google.android.libraries.navigation.internal.ld.ab(21, "Connection timed out waiting for Google Play services update to complete.") : new com.google.android.libraries.navigation.internal.ld.ab(22, "API failed to connect while resuming due to an unknown error."));
                        aeVar6.b.j("Timing out connection while resuming.");
                    }
                }
                return true;
            case 12:
                if (this.m.containsKey(message.obj)) {
                    ((ae) this.m.get(message.obj)).p(true);
                }
                return true;
            case 14:
                throw null;
            case 15:
                af afVar = (af) message.obj;
                if (this.m.containsKey(afVar.a)) {
                    ae aeVar7 = (ae) this.m.get(afVar.a);
                    if (aeVar7.g.contains(afVar) && !aeVar7.f) {
                        if (aeVar7.b.l()) {
                            aeVar7.g();
                        } else {
                            aeVar7.d();
                        }
                    }
                }
                return true;
            case 16:
                af afVar2 = (af) message.obj;
                if (this.m.containsKey(afVar2.a)) {
                    ae aeVar8 = (ae) this.m.get(afVar2.a);
                    if (aeVar8.g.remove(afVar2)) {
                        aeVar8.i.p.removeMessages(15, afVar2);
                        aeVar8.i.p.removeMessages(16, afVar2);
                        com.google.android.libraries.navigation.internal.lc.d dVar = afVar2.b;
                        ArrayList arrayList = new ArrayList(aeVar8.a.size());
                        for (g gVar : aeVar8.a) {
                            if ((gVar instanceof a) && (dVarArrB = ((a) gVar).b(aeVar8)) != null) {
                                for (int i5 = 0; i5 <= 0; i5++) {
                                    if (com.google.android.libraries.navigation.internal.lh.az.a(dVarArrB[i5], dVar)) {
                                        if (i5 < 0) {
                                        }
                                        arrayList.add(gVar);
                                    }
                                    break;
                                }
                            }
                        }
                        int size = arrayList.size();
                        for (int i6 = 0; i6 < size; i6++) {
                            g gVar2 = (g) arrayList.get(i6);
                            aeVar8.a.remove(gVar2);
                            gVar2.e(new com.google.android.libraries.navigation.internal.ld.ae(dVar));
                        }
                    }
                }
                return true;
            case 17:
                j();
                return true;
            case 18:
                at atVar = (at) message.obj;
                if (atVar.c == 0) {
                    i().a(new com.google.android.libraries.navigation.internal.lh.bn(atVar.b, Arrays.asList(atVar.a)));
                } else {
                    com.google.android.libraries.navigation.internal.lh.bn bnVar = this.s;
                    if (bnVar != null) {
                        List list = bnVar.b;
                        if (bnVar.a != atVar.b || (list != null && list.size() >= atVar.d)) {
                            this.p.removeMessages(17);
                            j();
                        } else {
                            com.google.android.libraries.navigation.internal.lh.bn bnVar2 = this.s;
                            com.google.android.libraries.navigation.internal.lh.aw awVar = atVar.a;
                            if (bnVar2.b == null) {
                                bnVar2.b = new ArrayList();
                            }
                            bnVar2.b.add(awVar);
                        }
                    }
                    if (this.s == null) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(atVar.a);
                        this.s = new com.google.android.libraries.navigation.internal.lh.bn(atVar.b, arrayList2);
                        Handler handler2 = this.p;
                        handler2.sendMessageDelayed(handler2.obtainMessage(17), atVar.c);
                    }
                }
                return true;
            case 19:
                this.g = false;
                return true;
            default:
                int i7 = message.what;
                return false;
        }
    }
}

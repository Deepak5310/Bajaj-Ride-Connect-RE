package com.google.android.libraries.navigation.internal.hx;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import androidx.core.app.ActivityManagerCompat;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ak implements ai, am {
    public static final int a;
    public static final int b;
    private static final int f;
    public final com.google.android.libraries.navigation.internal.mj.a c;
    final ConcurrentHashMap d = new ConcurrentHashMap(ap.values().length);
    public final boolean e;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        a = iAvailableProcessors;
        int i = iAvailableProcessors + iAvailableProcessors + (iAvailableProcessors / 2);
        f = i;
        b = Math.max(4, Math.min(8, i));
    }

    public ak(Context context, com.google.android.libraries.navigation.internal.mj.a aVar) {
        this.c = aVar;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ar.q(activityManager);
        this.e = ActivityManagerCompat.isLowRamDevice(activityManager);
        ap.K = this;
        a(ap.UI_THREAD);
    }

    @Override // com.google.android.libraries.navigation.internal.hx.ai
    public final Executor a(ap apVar) {
        Executor executorB = b(apVar, new aj(this));
        ar.q(executorB);
        return executorB;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00af  */
    /* JADX WARN: Code duplicated, block: B:36:0x00b8  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.lang.Object, java.util.concurrent.ExecutorService] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.concurrent.Executor] */
    final Executor b(ap apVar, aj ajVar) {
        AbstractExecutorService adVar;
        Object objB;
        Executor executor;
        Looper looper;
        ar.a(apVar != ap.CURRENT);
        Executor executor2 = (Executor) this.d.get(apVar);
        boolean z = executor2 instanceof ExecutorService;
        ?? r0 = executor2;
        if (z && ((ExecutorService) executor2).isShutdown()) {
            r0 = executor2;
            this.d.remove(apVar, executor2);
            r0 = (Executor) this.d.get(apVar);
        }
        if (r0 == 0) {
            int iA = apVar.a();
            ar.k(iA > 0);
            ap apVarD = apVar.d();
            int i = apVar.M & 2;
            ak akVar = ajVar.a;
            if (i != 0) {
                ar.k(iA == 1);
                if (apVar == ap.UI_THREAD) {
                    looper = Looper.getMainLooper();
                } else {
                    z zVar = new z(apVar);
                    zVar.start();
                    looper = zVar.getLooper();
                }
                adVar = new aa(looper, apVar, akVar.c);
            } else {
                ap apVar2 = ap.SCHEDULER;
                if (apVar == apVar2) {
                    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(iA, new w(ap.SCHEDULER));
                    scheduledThreadPoolExecutor.setRemoveOnCancelPolicy(true);
                    objB = scheduledThreadPoolExecutor;
                } else if (apVarD != null) {
                    objB = ((b) akVar.a(apVarD)).b(apVar.N, iA, apVar);
                } else {
                    Executor executorB = akVar.b(apVar2, new aj(akVar));
                    ar.q(executorB);
                    adVar = new ad(apVar, akVar.c, (ScheduledExecutorService) executorB);
                }
                r0 = objB;
                executor = (Executor) this.d.putIfAbsent(apVar, r0);
                if (executor == null) {
                    r0.getClass();
                    r0.hashCode();
                    String str = apVar.N;
                    r0.shutdown();
                    return executor;
                }
                r0.getClass();
                r0.hashCode();
                String str2 = apVar.N;
            }
            r0 = adVar;
            executor = (Executor) this.d.putIfAbsent(apVar, r0);
            if (executor == null) {
                r0.getClass();
                r0.hashCode();
                String str3 = apVar.N;
                r0.shutdown();
                return executor;
            }
            r0.getClass();
            r0.hashCode();
            String str4 = apVar.N;
        }
        return r0;
    }
}

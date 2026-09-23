package com.google.android.libraries.navigation.internal.mp;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import com.google.android.libraries.navigation.internal.aac.cc;
import com.google.android.libraries.navigation.internal.lc.i;
import com.google.android.libraries.navigation.internal.ld.ab;
import com.google.android.libraries.navigation.internal.ld.l;
import com.google.android.libraries.navigation.internal.le.bd;
import com.google.android.libraries.navigation.internal.le.bi;
import com.google.android.libraries.navigation.internal.ma.al;
import com.google.android.libraries.navigation.internal.me.ah;
import com.google.android.libraries.navigation.internal.me.r;
import com.google.android.libraries.navigation.internal.me.u;
import com.google.android.libraries.navigation.internal.me.w;
import com.google.android.libraries.navigation.internal.mn.e;
import com.google.android.libraries.navigation.internal.mn.g;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    private static final String[] c = {"COLLECTION_BASIS_VERIFIER"};
    public static boolean a = false;
    public static final Object b = new Object();

    public static void a(e eVar, com.google.android.libraries.navigation.internal.mq.a aVar) {
        final Executor threadPoolExecutor;
        com.google.android.libraries.navigation.internal.mn.b bVar = (com.google.android.libraries.navigation.internal.mn.b) eVar;
        final al alVar = new al(bVar.a);
        String strValueOf = String.valueOf(bVar.a.getPackageName());
        Integer num = aVar.a;
        Context context = bVar.a;
        if (num == null) {
            try {
                aVar.a = Integer.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
                aVar.a = -1;
            }
        }
        final String strConcat = "com.google.android.libraries.consentverifier#".concat(strValueOf);
        w wVarB = alVar.b(strConcat, aVar.a.intValue(), c);
        if (g.a(bVar.a)) {
            com.google.android.libraries.navigation.internal.lt.a aVar2 = com.google.android.libraries.navigation.internal.lt.b.a;
            ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(10, 10, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Executors.defaultThreadFactory());
            threadPoolExecutor2.allowCoreThreadTimeOut(true);
            threadPoolExecutor = Executors.unconfigurableExecutorService(threadPoolExecutor2);
        } else {
            RejectedExecutionHandler rejectedExecutionHandler = com.google.android.libraries.navigation.internal.mr.a.a;
            LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
            cc ccVar = new cc();
            ccVar.a = "ConsentVerifierLibraryThread-%d";
            threadPoolExecutor = new ThreadPoolExecutor(0, 10, 10L, TimeUnit.SECONDS, linkedBlockingQueue, cc.a(ccVar), com.google.android.libraries.navigation.internal.mr.a.a);
        }
        try {
            wVarB.k(threadPoolExecutor, new u() { // from class: com.google.android.libraries.navigation.internal.mp.a
                @Override // com.google.android.libraries.navigation.internal.me.u
                public final void d(Object obj) {
                    w wVarA;
                    boolean z = d.a;
                    al alVar2 = alVar;
                    int iF = i.d.f(alVar2.b, 12451000);
                    final String str = strConcat;
                    if (iF == 0) {
                        bi biVar = new bi();
                        biVar.a = new bd() { // from class: com.google.android.libraries.navigation.internal.ma.ac
                            public final /* synthetic */ String b = "";

                            @Override // com.google.android.libraries.navigation.internal.le.bd
                            public final void a(Object obj2, Object obj3) throws RemoteException {
                                int i = al.a;
                                ak akVar = new ak((com.google.android.libraries.navigation.internal.me.aa) obj3);
                                ((com.google.android.libraries.navigation.internal.mb.h) ((com.google.android.libraries.navigation.internal.mb.i) obj2).u()).e(akVar, "CURRENT:" + this.b + ":" + str);
                            }
                        };
                        wVarA = alVar2.g(biVar.a());
                    } else {
                        wVarA = ah.a(new l(new ab(16)));
                    }
                    wVarA.i(threadPoolExecutor, new r() { // from class: com.google.android.libraries.navigation.internal.mp.c
                        @Override // com.google.android.libraries.navigation.internal.me.r
                        public final void c(Exception exc) {
                            boolean z2 = d.a;
                        }
                    });
                }
            });
            wVarB.i(threadPoolExecutor, new r() { // from class: com.google.android.libraries.navigation.internal.mp.b
                @Override // com.google.android.libraries.navigation.internal.me.r
                public final void c(Exception exc) {
                    boolean z = d.a;
                }
            });
        } catch (RejectedExecutionException unused2) {
        }
    }
}

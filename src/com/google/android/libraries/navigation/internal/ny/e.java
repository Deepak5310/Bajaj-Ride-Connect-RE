package com.google.android.libraries.navigation.internal.ny;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import com.google.android.libraries.navigation.internal.ky.ab;
import com.google.android.libraries.navigation.internal.ky.ah;
import com.google.android.libraries.navigation.internal.ky.an;
import com.google.android.libraries.navigation.internal.ky.ao;
import com.google.android.libraries.navigation.internal.ky.ap;
import com.google.android.libraries.navigation.internal.ky.m;
import com.google.android.libraries.navigation.internal.ky.n;
import com.google.android.libraries.navigation.internal.ky.o;
import com.google.android.libraries.navigation.internal.zt.q;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class e {
    private static final ab i = new a();
    public final ap a;
    public final an b;
    public final an c;
    public final ExecutorService d;
    public final com.google.android.libraries.navigation.internal.mj.a e;
    public final Context f;
    public SharedPreferences g;
    public long h;

    public e(Context context, com.google.android.libraries.navigation.internal.mj.a aVar, ExecutorService executorService, o oVar) {
        ap apVar = new ap(oVar, "GMM_REALTIME_COUNTERS", com.google.android.libraries.navigation.internal.ll.d.a);
        this.a = apVar;
        ao aoVarD = apVar.d("SdkStartupTimeToMapLoaded", ap.a);
        this.b = new an(aoVarD, aoVarD);
        ao aoVarD2 = apVar.d("FrameTime", i);
        this.c = new an(aoVarD2, aoVarD2);
        this.d = executorService;
        this.e = aVar;
        this.f = context;
        oVar.g(new m() { // from class: com.google.android.libraries.navigation.internal.ny.c
            @Override // com.google.android.libraries.navigation.internal.ky.m
            public final n a(n nVar) {
                if (nVar.h.equals("GMM_REALTIME_COUNTERS")) {
                    nVar.l = com.google.android.libraries.navigation.internal.afk.c.d;
                }
                return nVar;
            }
        });
    }

    public static void e(q qVar) {
        if (Log.isLoggable("SdkMonitoringLogger", 3)) {
            Base64.encodeToString(qVar.m(), 2);
        }
    }

    public void a() {
        this.a.e();
        Log.isLoggable("SdkMonitoringLogger", 3);
    }

    public final void b(q qVar) {
        this.a.c("ApplicationProcessStarted").a(0L, 1L, ah.a(qVar));
        a();
        e(qVar);
    }

    public final void c(q qVar) {
        this.a.c("RecoveryAttempt").a(0L, 1L, ah.a(qVar));
        a();
        e(qVar);
    }

    public final void d(q qVar) {
        this.a.c("SdkCrashed").a(0L, 1L, ah.a(qVar));
        a();
        e(qVar);
    }
}

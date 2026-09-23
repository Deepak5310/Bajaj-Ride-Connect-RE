package com.google.android.libraries.navigation.internal.fr;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.libraries.navigation.internal.acd.ml;
import kotlin.Deprecated;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated(message = "use [DeviceNetworkStateImpl] instead on API 23+")
public final class q implements d {
    private static final com.google.android.libraries.navigation.internal.zb.j b;
    public final MutableStateFlow a;
    private final Context c;
    private final com.google.android.libraries.navigation.internal.gb.a d;
    private volatile NetworkInfo e;

    static {
        com.google.android.libraries.navigation.internal.zb.j jVarE = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.fr.q");
        Intrinsics.checkNotNullExpressionValue(jVarE, "forInjectedClassName(...)");
        b = jVarE;
    }

    public q(Context applicationContext, com.google.android.libraries.navigation.internal.gb.a offlineModeController) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(offlineModeController, "offlineModeController");
        this.c = applicationContext;
        this.d = offlineModeController;
        this.a = StateFlowKt.MutableStateFlow(new c(false, ml.b, 4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.fr.d
    public final /* synthetic */ c a() {
        return (c) this.a.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:27:0x004e A[Catch: SecurityException -> 0x0062, TryCatch #0 {SecurityException -> 0x0062, blocks: (B:3:0x000f, B:5:0x0018, B:8:0x0021, B:23:0x0042, B:28:0x0050, B:30:0x005c, B:24:0x0045, B:25:0x0048, B:26:0x004b, B:27:0x004e, B:29:0x0054), top: B:35:0x000f }] */
    @Override // com.google.android.libraries.navigation.internal.fr.d
    public final void b() {
        c cVar;
        int i;
        Object systemService = this.c.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
            this.e = activeNetworkInfo;
            if (activeNetworkInfo == null || this.d.a()) {
                cVar = new c(false, ml.b, 4);
            } else {
                boolean zIsConnected = activeNetworkInfo.isConnected();
                int type = activeNetworkInfo.getType();
                if (type == 0) {
                    i = ml.d;
                } else if (type == 1) {
                    i = ml.c;
                } else if (type == 2 || type == 3 || type == 4 || type == 5) {
                    i = ml.d;
                } else if (type != 7) {
                    i = type != 9 ? ml.a : ml.f;
                } else {
                    i = ml.e;
                }
                cVar = new c(zIsConnected, i, 4);
            }
            this.a.setValue(cVar);
        } catch (SecurityException e) {
            com.google.android.libraries.navigation.internal.nl.a aVar = com.google.android.libraries.navigation.internal.nl.a.a;
            ((com.google.android.libraries.navigation.internal.zb.h) b.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e).F(517)).p("Failed to get active network info");
        }
    }

    @Override // com.google.android.libraries.navigation.internal.fr.d
    public final boolean c() {
        return this.c.getPackageManager().hasSystemFeature("android.hardware.telephony");
    }

    @Override // com.google.android.libraries.navigation.internal.fr.d
    public final boolean d() {
        NetworkInfo networkInfo;
        if (this.d.a() || (networkInfo = this.e) == null) {
            return false;
        }
        return networkInfo.isConnected();
    }

    @Override // com.google.android.libraries.navigation.internal.fr.d
    public final boolean e() {
        b();
        return d();
    }

    @Override // com.google.android.libraries.navigation.internal.fr.d
    public final boolean f() {
        NetworkInfo networkInfo = this.e;
        return networkInfo != null && networkInfo.getType() == 1 && networkInfo.isConnected();
    }

    @Override // com.google.android.libraries.navigation.internal.fr.d
    public final boolean g() {
        Object objM2319constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM2319constructorimpl = Result.m2319constructorimpl(Boolean.valueOf(Intrinsics.areEqual("wifi-only", Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, "ro.carrier"))));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM2319constructorimpl = Result.m2319constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m2322exceptionOrNullimpl(objM2319constructorimpl) != null) {
            objM2319constructorimpl = false;
        }
        return ((Boolean) objM2319constructorimpl).booleanValue();
    }
}

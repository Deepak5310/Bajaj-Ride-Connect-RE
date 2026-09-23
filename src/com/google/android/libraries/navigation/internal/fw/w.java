package com.google.android.libraries.navigation.internal.fw;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.google.android.libraries.navigation.internal.km.ao;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class w implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ x a;

    public w(x xVar) {
        this.a = xVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final /* synthetic */ void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        x xVar = this.a;
        if (xVar.c) {
            xVar.c = false;
            long seconds = TimeUnit.MILLISECONDS.toSeconds(xVar.a.a() - xVar.d);
            if (seconds > 0) {
                ((com.google.android.libraries.navigation.internal.kk.l) xVar.b.a(ao.f468n)).a(xVar.f);
                ((com.google.android.libraries.navigation.internal.kk.l) xVar.b.a(ao.o)).a(xVar.e);
                ((com.google.android.libraries.navigation.internal.kk.l) xVar.b.a(ao.p)).a(xVar.g);
                ((com.google.android.libraries.navigation.internal.kk.l) xVar.b.a(ao.q)).a(xVar.h);
                ((com.google.android.libraries.navigation.internal.kk.l) xVar.b.a(ao.s)).a(xVar.f / seconds);
                ((com.google.android.libraries.navigation.internal.kk.l) xVar.b.a(ao.r)).a(xVar.e / seconds);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        x xVar = this.a;
        if (xVar.c) {
            return;
        }
        xVar.c = true;
        xVar.d = xVar.a.a();
        xVar.h = 0L;
        xVar.g = 0L;
        xVar.f = 0L;
        xVar.e = 0L;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final /* synthetic */ void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final /* synthetic */ void onActivityStarted(Activity activity) {
        com.google.android.libraries.navigation.internal.fo.a.a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final /* synthetic */ void onActivityStopped(Activity activity) {
        com.google.android.libraries.navigation.internal.fo.a.b(activity);
    }
}

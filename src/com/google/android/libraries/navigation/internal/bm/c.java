package com.google.android.libraries.navigation.internal.bm;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.afl.kw;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ h a;

    public c(h hVar) {
        this.a = hVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        if (bundle != null) {
            h hVar = this.a;
            Collection collection = (Collection) bundle.getSerializable("DIRECTIONS_ICON_MANAGER_ICON_MAP_ENTRIES_KEY");
            if (collection != null) {
                hVar.f(com.google.android.libraries.navigation.internal.hc.a.b(ev.o(collection), new eq(), (dg) kw.a.aH(7, null), kw.a));
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final /* synthetic */ void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final /* synthetic */ void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final /* synthetic */ void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        bundle.putSerializable("DIRECTIONS_ICON_MANAGER_ICON_MAP_ENTRIES_KEY", com.google.android.libraries.navigation.internal.hc.a.c(ev.o(this.a.d.values()), new eq()));
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

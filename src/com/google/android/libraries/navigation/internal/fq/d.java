package com.google.android.libraries.navigation.internal.fq;

import android.os.SystemClock;
import com.facebook.react.views.scroll.ReactScrollViewHelper;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    final /* synthetic */ f a;

    public d(f fVar) {
        this.a = fVar;
    }

    public final /* bridge */ /* synthetic */ void a() {
        f fVar = this.a;
        Runtime runtime = fVar.a;
        if ((runtime.totalMemory() - runtime.freeMemory()) / fVar.a.maxMemory() > 0.5f) {
            fVar.b(e.THRESHOLD_REACHED);
        }
        com.google.android.libraries.navigation.internal.hx.k.a("CacheManager.timeSinceTrim", fVar.d >= 0 ? Long.toString(SystemClock.elapsedRealtime() - fVar.d) : ReactScrollViewHelper.OVER_SCROLL_NEVER);
    }
}

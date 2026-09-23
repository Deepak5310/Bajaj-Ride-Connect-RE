package com.google.android.apps.gmm.offline.tilefetcher;

import com.google.android.apps.gmm.jni.util.NativeHelper;
import com.google.android.apps.gmm.offline.routing.NativeCapableSnaptileProvider;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.hx.n;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
final class EndTileWorkScheduler {
    public static final /* synthetic */ int a = 0;
    private final bn b;

    static {
        NativeHelper.c();
        nativeInitClass();
    }

    public EndTileWorkScheduler(bn bnVar) {
        this.b = bnVar;
    }

    public static native void nativeEndRoadGraphTileWork(long j);

    private static native boolean nativeInitClass();

    public void scheduleEndRoadGraphTileWork(final Object obj, long j) {
        n.a(this.b.schedule(new Runnable() { // from class: com.google.android.apps.gmm.offline.tilefetcher.a
            @Override // java.lang.Runnable
            public final void run() {
                int i = EndTileWorkScheduler.a;
                EndTileWorkScheduler.nativeEndRoadGraphTileWork(((NativeCapableSnaptileProvider) obj).a());
            }
        }, j, TimeUnit.MILLISECONDS), this.b);
    }
}

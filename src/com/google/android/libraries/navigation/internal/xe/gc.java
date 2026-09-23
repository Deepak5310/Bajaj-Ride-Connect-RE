package com.google.android.libraries.navigation.internal.xe;

import com.google.android.libraries.navigation.ListenableResultFuture;
import com.google.android.libraries.navigation.Navigator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class gc implements ListenableResultFuture {
    private final com.google.android.libraries.navigation.internal.vq.b a;

    public gc(com.google.android.libraries.navigation.internal.vq.b bVar) {
        this.a = bVar;
    }

    public static Navigator.RouteStatus a(com.google.android.libraries.navigation.internal.vp.c cVar) {
        switch (cVar) {
            case OK:
            case NAVIGATION_DISALLOWED:
                return Navigator.RouteStatus.OK;
            case NO_ROUTE_FOUND:
                return Navigator.RouteStatus.NO_ROUTE_FOUND;
            case NETWORK_ERROR:
                return Navigator.RouteStatus.NETWORK_ERROR;
            case QUOTA_CHECK_FAILED:
                return Navigator.RouteStatus.QUOTA_CHECK_FAILED;
            case ROUTE_CANCELED:
                return Navigator.RouteStatus.ROUTE_CANCELED;
            case LOCATION_DISABLED:
                return Navigator.RouteStatus.LOCATION_DISABLED;
            case LOCATION_UNKNOWN:
                return Navigator.RouteStatus.LOCATION_UNKNOWN;
            case WAYPOINT_ERROR:
                return Navigator.RouteStatus.WAYPOINT_ERROR;
            default:
                throw new IllegalArgumentException("Unsupported RouteStatus: ".concat(String.valueOf(String.valueOf(cVar))));
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return this.a.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public final /* bridge */ /* synthetic */ Object get() throws ExecutionException, InterruptedException {
        return a((com.google.android.libraries.navigation.internal.vp.c) this.a.get());
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.a.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.a.isDone();
    }

    @Override // com.google.android.libraries.navigation.ListenableResultFuture
    public final void setOnResultListener(ListenableResultFuture.OnResultListener<Navigator.RouteStatus> onResultListener) {
        this.a.c(new gb(onResultListener));
    }

    @Override // java.util.concurrent.Future
    public final /* bridge */ /* synthetic */ Object get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return a((com.google.android.libraries.navigation.internal.vp.c) this.a.get(j, timeUnit));
    }
}

package com.google.android.libraries.navigation.internal.sk;

import androidx.mediarouter.media.MediaControlIntent;
import androidx.mediarouter.media.MediaRouteSelector;
import androidx.mediarouter.media.MediaRouter;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ac implements aa {
    public static final MediaRouteSelector a = new MediaRouteSelector.Builder().addControlCategory(MediaControlIntent.CATEGORY_LIVE_AUDIO).build();
    public final MediaRouter b;
    public MediaRouter.RouteInfo c;
    public ab d;
    public int e;
    public av f;
    private final com.google.android.libraries.navigation.internal.iv.f g;

    public ac(com.google.android.libraries.navigation.internal.iv.f fVar, MediaRouter mediaRouter) {
        com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD.f();
        com.google.android.libraries.navigation.internal.yx.ar.q(fVar);
        this.g = fVar;
        com.google.android.libraries.navigation.internal.yx.ar.q(mediaRouter);
        this.b = mediaRouter;
        this.e = 1;
    }

    @Override // com.google.android.libraries.navigation.internal.sk.aa
    public final boolean a() {
        com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD.f();
        return com.google.android.libraries.navigation.internal.rq.d.a && !this.g.y(com.google.android.libraries.navigation.internal.iv.ab.aL, true) && !this.b.getSelectedRoute().getId().equals(this.b.getDefaultRoute().getId()) && this.e == 1;
    }
}

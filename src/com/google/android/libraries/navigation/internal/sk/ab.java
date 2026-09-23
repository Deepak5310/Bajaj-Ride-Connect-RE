package com.google.android.libraries.navigation.internal.sk;

import androidx.mediarouter.media.MediaRouter;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ab extends MediaRouter.Callback {
    final /* synthetic */ ac a;

    public ab(ac acVar) {
        this.a = acVar;
    }

    @Override // androidx.mediarouter.media.MediaRouter.Callback
    public final void onRouteSelected(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo, int i) {
        ac acVar = this.a;
        int i2 = acVar.e;
        int i3 = i2 - 1;
        if (i2 == 0) {
            throw null;
        }
        if (i3 == 1) {
            acVar.e = 3;
            av avVar = acVar.f;
            if (avVar != null) {
                avVar.a();
                return;
            }
            return;
        }
        if (i3 == 2) {
            acVar.c = routeInfo;
            return;
        }
        if (i3 != 3) {
            return;
        }
        acVar.e = 1;
        av avVar2 = acVar.f;
        if (avVar2 != null) {
            avVar2.b();
        }
        acVar.c = null;
    }
}

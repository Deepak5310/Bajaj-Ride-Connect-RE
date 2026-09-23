package com.mappls.sdk.direction.ui.plugin;

import com.mappls.sdk.services.api.directions.models.DirectionsRoute;

/* JADX INFO: loaded from: classes6.dex */
final class d implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ DirectionsRoute b;
    final /* synthetic */ f c;

    d(f fVar, int i, DirectionsRoute directionsRoute) {
        this.c = fVar;
        this.a = i;
        this.b = directionsRoute;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.c.f702n != null) {
            this.c.f702n.a(this.a, this.b);
        }
    }
}

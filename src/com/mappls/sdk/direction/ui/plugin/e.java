package com.mappls.sdk.direction.ui.plugin;

import com.mappls.sdk.services.api.directions.models.DirectionsRoute;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
final class e implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ int b;
    final /* synthetic */ f c;

    e(f fVar, List list, int i) {
        this.c = fVar;
        this.a = list;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.size() <= this.b || this.c.f702n == null) {
            return;
        }
        f.o oVar = this.c.f702n;
        int i = this.b;
        oVar.a(i, (DirectionsRoute) this.a.get(i));
    }
}

package com.mappls.sdk.navigation.ui.map.route;

import com.mappls.sdk.geojson.FeatureCollection;

/* JADX INFO: renamed from: com.mappls.sdk.navigation.ui.map.route.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
public final class RunnableC0221a implements Runnable {
    public final /* synthetic */ C a;
    public final /* synthetic */ C0222b b;

    public RunnableC0221a(C0222b c0222b, C c) {
        this.b = c0222b;
        this.a = c;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.b.d.get()) {
            return;
        }
        C c = this.a;
        FeatureCollection featureCollection = this.b.c;
        q qVar = ((k) c).a;
        qVar.e = featureCollection;
        String str = qVar.d;
        qVar.d = str;
        qVar.b.getStyle(new m(qVar, str));
    }
}

package com.mappls.sdk.navigation.ui.map.route;

import com.mappls.sdk.maps.Style;

/* JADX INFO: loaded from: classes4.dex */
public final class l implements Style.OnStyleLoaded {
    public final /* synthetic */ String a;
    public final /* synthetic */ q b;

    public l(q qVar, String str) {
        this.b = qVar;
        this.a = str;
    }

    @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
    public final void onStyleLoaded(Style style) {
        this.b.a(this.a, style);
    }
}

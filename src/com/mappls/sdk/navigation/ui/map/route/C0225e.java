package com.mappls.sdk.navigation.ui.map.route;

import com.mappls.sdk.maps.Style;

/* JADX INFO: renamed from: com.mappls.sdk.navigation.ui.map.route.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
public final class C0225e implements Style.OnStyleLoaded {
    public final /* synthetic */ String a;
    public final /* synthetic */ C0228h b;

    public C0225e(C0228h c0228h, String str) {
        this.b = c0228h;
        this.a = str;
    }

    @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
    public final void onStyleLoaded(Style style) {
        this.b.a(this.a, style);
    }
}

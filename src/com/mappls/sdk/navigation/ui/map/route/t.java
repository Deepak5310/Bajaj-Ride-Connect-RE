package com.mappls.sdk.navigation.ui.map.route;

import com.mappls.sdk.maps.Style;

/* JADX INFO: loaded from: classes4.dex */
public final class t implements Style.OnStyleLoaded {
    public final /* synthetic */ u a;

    public t(u uVar) {
        this.a = uVar;
    }

    @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
    public final void onStyleLoaded(Style style) {
        z zVar = this.a.a;
        zVar.a(zVar.w, style);
        z zVar2 = this.a.a;
        zVar2.a(zVar2.u);
        z zVar3 = this.a.a;
        zVar3.b(zVar3.v, style);
    }
}

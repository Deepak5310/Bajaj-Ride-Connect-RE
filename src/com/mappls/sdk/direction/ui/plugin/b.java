package com.mappls.sdk.direction.ui.plugin;

import com.mappls.sdk.maps.Style;

/* JADX INFO: loaded from: classes6.dex */
final class b implements Style.OnStyleLoaded {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
    public final void onStyleLoaded(Style style) {
        if (style.getSource("directions_bearing") == null) {
            a.a(this.a, style);
            return;
        }
        a aVar = this.a;
        aVar.getClass();
        a.a(aVar, false, style);
    }
}

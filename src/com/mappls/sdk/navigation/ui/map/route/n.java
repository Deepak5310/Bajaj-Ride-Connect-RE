package com.mappls.sdk.navigation.ui.map.route;

import android.graphics.Bitmap;
import com.mappls.sdk.maps.Style;

/* JADX INFO: loaded from: classes4.dex */
public final class n implements Style.OnStyleLoaded {
    public final /* synthetic */ String a;
    public final /* synthetic */ Bitmap b;

    public n(String str, Bitmap bitmap) {
        this.a = str;
        this.b = bitmap;
    }

    @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
    public final void onStyleLoaded(Style style) {
        style.addImageAsync(this.a, this.b);
    }
}

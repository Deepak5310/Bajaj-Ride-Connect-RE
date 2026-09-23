package com.mappls.sdk.navigation.ui.map.route;

import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.style.layers.Layer;
import com.mappls.sdk.maps.style.layers.PropertyFactory;
import java.util.Iterator;

/* JADX INFO: renamed from: com.mappls.sdk.navigation.ui.map.route.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
public final class C0227g implements Style.OnStyleLoaded {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ C0228h b;

    public C0227g(C0228h c0228h, boolean z) {
        this.b = c0228h;
        this.a = z;
    }

    @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
    public final void onStyleLoaded(Style style) {
        Iterator it2 = this.b.e.iterator();
        while (it2.hasNext()) {
            Layer layer = style.getLayer((String) it2.next());
            if (layer != null) {
                String str = this.a ? "visible" : "none";
                if (!str.equals(layer.getVisibility().getValue())) {
                    layer.setProperties(PropertyFactory.visibility(str));
                }
            }
        }
    }
}

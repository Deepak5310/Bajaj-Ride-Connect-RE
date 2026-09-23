package com.mappls.sdk.navigation.ui.map.plugins;

import androidx.core.content.ContextCompat;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.style.sources.GeoJsonSource;
import com.mappls.sdk.navigation.ui.R;
import java.util.ArrayList;
import timber.log.Timber;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements Style.OnStyleLoaded {
    public final /* synthetic */ c a;

    public a(c cVar) {
        this.a = cVar;
    }

    @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
    public final void onStyleLoaded(Style style) {
        if (style.getSource("directions_bearing") != null) {
            c cVar = this.a;
            cVar.getClass();
            cVar.a(false, style);
            return;
        }
        c cVar2 = this.a;
        cVar2.getClass();
        cVar2.g = new ArrayList();
        style.addSource(new GeoJsonSource("directions_bearing"));
        try {
            cVar2.a(ContextCompat.getDrawable(cVar2.f.getContext(), R.drawable.user_puck_icon_demo), style);
        } catch (Exception unused) {
            Timber.e("Unable to attach Traffic Layers to current style.", new Object[0]);
        }
    }
}

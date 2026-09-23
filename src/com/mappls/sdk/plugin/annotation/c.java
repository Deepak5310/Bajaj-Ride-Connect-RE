package com.mappls.sdk.plugin.annotation;

import com.mappls.sdk.maps.style.layers.Layer;
import com.mappls.sdk.maps.style.sources.GeoJsonOptions;
import com.mappls.sdk.maps.style.sources.GeoJsonSource;

/* JADX INFO: loaded from: classes4.dex */
interface c<L extends Layer> {
    GeoJsonSource a(GeoJsonOptions geoJsonOptions);

    String a();

    String b();

    L c();
}

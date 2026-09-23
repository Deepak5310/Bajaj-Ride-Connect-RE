package com.mappls.sdk.plugin.annotation;

import com.mappls.sdk.maps.style.layers.LineLayer;
import com.mappls.sdk.maps.style.sources.GeoJsonOptions;
import com.mappls.sdk.maps.style.sources.GeoJsonSource;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes4.dex */
class f implements c<LineLayer> {
    private static final AtomicLong c = new AtomicLong(0);
    private final String a;
    private final String b;

    f() {
        long jIncrementAndGet = c.incrementAndGet();
        this.a = String.format("mappls-android-line-layer-%s", Long.valueOf(jIncrementAndGet));
        this.b = String.format("mappls-android-line-source-%s", Long.valueOf(jIncrementAndGet));
    }

    @Override // com.mappls.sdk.plugin.annotation.c
    public GeoJsonSource a(GeoJsonOptions geoJsonOptions) {
        return new GeoJsonSource(this.b, geoJsonOptions);
    }

    @Override // com.mappls.sdk.plugin.annotation.c
    public String a() {
        return this.b;
    }

    @Override // com.mappls.sdk.plugin.annotation.c
    public String b() {
        return this.a;
    }

    @Override // com.mappls.sdk.plugin.annotation.c
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public LineLayer c() {
        return new LineLayer(this.a, this.b);
    }
}

package com.mappls.sdk.plugin.annotation;

import com.mappls.sdk.maps.style.layers.FillLayer;
import com.mappls.sdk.maps.style.sources.GeoJsonOptions;
import com.mappls.sdk.maps.style.sources.GeoJsonSource;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes4.dex */
class e implements c<FillLayer> {
    private static final AtomicLong c = new AtomicLong(0);
    private final String a;
    private final String b;

    e() {
        long jIncrementAndGet = c.incrementAndGet();
        this.a = String.format("mappls-android-fill-layer-%s", Long.valueOf(jIncrementAndGet));
        this.b = String.format("mappls-android-fill-source-%s", Long.valueOf(jIncrementAndGet));
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
    public FillLayer c() {
        return new FillLayer(this.a, this.b);
    }
}

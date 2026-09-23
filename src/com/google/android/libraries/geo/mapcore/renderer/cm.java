package com.google.android.libraries.geo.mapcore.renderer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public enum cm implements af {
    UNCATEGORIZED,
    AREA_HIGHLIGHT,
    MAJOR_EVENT,
    CRISIS_WILDFIRES,
    COVID19,
    SEARCH_RESULTS,
    AIR_QUALITY_HEATMAP;

    public static final int h = cd.b + cd.values().length;

    @Override // com.google.android.libraries.geo.mapcore.renderer.af
    public final int a() {
        return h + ordinal();
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.af
    public final int b() {
        return ordinal();
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.af
    public final dy c() {
        return dy.OVERLAY_TILE_PASS;
    }
}

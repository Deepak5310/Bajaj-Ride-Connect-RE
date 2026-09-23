package com.google.android.libraries.navigation.internal.fq;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum h {
    ALL_LRU(0, true),
    CURVED_SEGMENTS(1, true),
    INDOOR_ACTIVE_LEVELS(2, true),
    PERSONAL_LABEL_FACTORY(3, true),
    STALE_TILE(4, false),
    RECENTLY_UPDATED_TILE(5, false),
    FETCHED_VIEWPORT(6, false),
    IN_MEMORY_TILE(7, false),
    SOFT_IN_MEMORY_TILE(8, false),
    DASH_ALPHA(9, false),
    DASH_TEXTURE(10, false),
    PERSONAL_PLACE_LABEL_GENERATOR(11, true),
    SVG_PICTURE(12, true),
    SVG_BITMAP(13, true),
    ODELAY(14, true),
    PREFETCH_UPGRADES(15, true),
    INDOOR_METADATA(16, false),
    INDOOR_BUILDING(17, false),
    INDOOR_LEVEL(18, false),
    RESOURCE_MANAGER_BITMAP(19, true),
    RESOURCE_MANAGER_RESOURCE(20, true),
    RESOURCE_MANAGER_SOFT_RESOURCE(21, true),
    TRAFFIC_TO_PLACE_MINI_MAP_BITMAP(23, true),
    IN_MEMORY_VMS_TILE(24, true),
    IN_MEMORY_VMS_LANE_DATA(25, true),
    OTHER(22, true);

    public final int A;
    public final boolean B;

    h(int i, boolean z) {
        this.A = i;
        this.B = z;
    }
}

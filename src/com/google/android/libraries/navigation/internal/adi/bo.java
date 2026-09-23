package com.google.android.libraries.navigation.internal.adi;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum bo implements com.google.android.libraries.navigation.internal.ael.bm {
    UNKNOWN(0),
    AIR_QUALITY_HEATMAP(48),
    AIR_QUALITY_HEATMAP_DARK(49),
    BASEMAP_EDITING(19),
    BASEMAP_EDITING_SATELLITE(25),
    BROADCASTERS(24),
    BROADCASTERS_SATELLITE(34),
    CATEGORICAL_RESULTS_FOCUSED(26),
    CATEGORICAL_RESULTS_FOCUSED_DARK(33),
    COVID_VACCINE_LAYER(39),
    COVID_VACCINE_LAYER_DARK(40),
    DRIVING_FOCUSED(21),
    EARTH_LOW_DENSITY(1),
    EARTH_LOWER_DENSITY(2),
    EARTH_LOWEST_DENSITY(3),
    NAVIGATION(4),
    NAVIGATION_EGMM(50),
    NAVIGATION_AMBIENT(46),
    NAVIGATION_AMBIENT_DARK(47),
    NAVIGATION_EMBEDDED_AUTO(22),
    NAVIGATION_EMBEDDED_AUTO_LOW_LIGHT(23),
    NAVIGATION_EMBEDDED_AUTO_SATELLITE(43),
    NAVIGATION_FREENAV(14),
    NAVIGATION_FREENAV_LOW_LIGHT(17),
    NAVIGATION_HIGH_DETAIL(37),
    NAVIGATION_HIGH_DETAIL_LOW_LIGHT(38),
    NAVIGATION_MUTED(13),
    NAVIGATION_LOW_LIGHT(5),
    NAVIGATION_EGMM_LOW_LIGHT(51),
    NAVIGATION_SATELLITE(6),
    NAVIGATION_EGMM_SATELLITE(52),
    NON_ROADMAP(7),
    ROADMAP(8),
    ROADMAP_AMBIACTIVE(15),
    ROADMAP_AMBIACTIVE_LOW_BIT(16),
    ROADMAP_DARK(27),
    ROADMAP_GLASS(9),
    ROADMAP_MUTED(10),
    ROADMAP_SATELLITE(11),
    ROADMAP_INFO_LAYER(35),
    ROADMAP_INFO_LAYER_DARK(36),
    ROUTE_OVERVIEW(20),
    ROUTE_OVERVIEW_DARK(28),
    SAFETY(31),
    SAFETY_DARK(32),
    TERRAIN(12),
    TERRAIN_DARK(29),
    TERRAIN_VECTOR_CLIENT(44),
    TERRAIN_VECTOR_CLIENT_DARK(45),
    TRANSIT_FOCUSED(18),
    TRANSIT_FOCUSED_DARK(30),
    TRAVEL(41),
    TRAVEL_DARK(42);

    public final int ab;

    bo(int i) {
        this.ab = i;
    }

    public static bo b(int i) {
        switch (i) {
            case 0:
                return UNKNOWN;
            case 1:
                return EARTH_LOW_DENSITY;
            case 2:
                return EARTH_LOWER_DENSITY;
            case 3:
                return EARTH_LOWEST_DENSITY;
            case 4:
                return NAVIGATION;
            case 5:
                return NAVIGATION_LOW_LIGHT;
            case 6:
                return NAVIGATION_SATELLITE;
            case 7:
                return NON_ROADMAP;
            case 8:
                return ROADMAP;
            case 9:
                return ROADMAP_GLASS;
            case 10:
                return ROADMAP_MUTED;
            case 11:
                return ROADMAP_SATELLITE;
            case 12:
                return TERRAIN;
            case 13:
                return NAVIGATION_MUTED;
            case 14:
                return NAVIGATION_FREENAV;
            case 15:
                return ROADMAP_AMBIACTIVE;
            case 16:
                return ROADMAP_AMBIACTIVE_LOW_BIT;
            case 17:
                return NAVIGATION_FREENAV_LOW_LIGHT;
            case 18:
                return TRANSIT_FOCUSED;
            case 19:
                return BASEMAP_EDITING;
            case 20:
                return ROUTE_OVERVIEW;
            case 21:
                return DRIVING_FOCUSED;
            case 22:
                return NAVIGATION_EMBEDDED_AUTO;
            case 23:
                return NAVIGATION_EMBEDDED_AUTO_LOW_LIGHT;
            case 24:
                return BROADCASTERS;
            case 25:
                return BASEMAP_EDITING_SATELLITE;
            case 26:
                return CATEGORICAL_RESULTS_FOCUSED;
            case 27:
                return ROADMAP_DARK;
            case 28:
                return ROUTE_OVERVIEW_DARK;
            case 29:
                return TERRAIN_DARK;
            case 30:
                return TRANSIT_FOCUSED_DARK;
            case 31:
                return SAFETY;
            case 32:
                return SAFETY_DARK;
            case 33:
                return CATEGORICAL_RESULTS_FOCUSED_DARK;
            case 34:
                return BROADCASTERS_SATELLITE;
            case 35:
                return ROADMAP_INFO_LAYER;
            case 36:
                return ROADMAP_INFO_LAYER_DARK;
            case 37:
                return NAVIGATION_HIGH_DETAIL;
            case 38:
                return NAVIGATION_HIGH_DETAIL_LOW_LIGHT;
            case 39:
                return COVID_VACCINE_LAYER;
            case 40:
                return COVID_VACCINE_LAYER_DARK;
            case 41:
                return TRAVEL;
            case 42:
                return TRAVEL_DARK;
            case 43:
                return NAVIGATION_EMBEDDED_AUTO_SATELLITE;
            case 44:
                return TERRAIN_VECTOR_CLIENT;
            case 45:
                return TERRAIN_VECTOR_CLIENT_DARK;
            case 46:
                return NAVIGATION_AMBIENT;
            case 47:
                return NAVIGATION_AMBIENT_DARK;
            case 48:
                return AIR_QUALITY_HEATMAP;
            case 49:
                return AIR_QUALITY_HEATMAP_DARK;
            case 50:
                return NAVIGATION_EGMM;
            case 51:
                return NAVIGATION_EGMM_LOW_LIGHT;
            case 52:
                return NAVIGATION_EGMM_SATELLITE;
            default:
                return null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.ab;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.ab);
    }
}

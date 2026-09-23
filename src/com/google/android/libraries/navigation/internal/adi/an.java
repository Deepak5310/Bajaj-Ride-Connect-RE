package com.google.android.libraries.navigation.internal.adi;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum an implements com.google.android.libraries.navigation.internal.ael.bm {
    UNKNOWN(0),
    GMM_VECTOR_BASE(1),
    GMM_VECTOR_TRAFFIC_V2(2),
    GMM_VECTOR_BICYCLING_OVERLAY(3),
    GMM_LABELS_ONLY(4),
    GMM_REALTIME(5),
    GMM_HIGHLIGHT_RAP(6),
    GMM_TRAFFIC_CAR(7),
    GMM_TRAFFIC_CAR_JAPAN(54),
    GMM_TRANSIT(8),
    GMM_INDOOR(9),
    GMM_MY_MAPS(10),
    GMM_EXPLORE_EAT_AND_DRINK(11),
    GMM_EXPLORE_PLAY(12),
    GMM_EXPLORE_SHOP(13),
    GMM_EXPLORE_SERVICES(14),
    GMM_SATELLITE(15),
    GMM_TERRAIN(16),
    GMM_TERRAIN_DARK(26),
    GMM_ROAD_GRAPH(17),
    GMM_SPOTLIGHT_PERSONALIZED_SMARTMAPS(18),
    GMM_SPOTLIGHT_PERSONALIZED_SMARTMAPS_PER_TILE(19),
    GMM_SPOTLIGHT_HIGHLIGHTING(20),
    GMM_BUILDING_3D(21),
    GMM_MAJOR_EVENT(22),
    GMM_STREET_VIEW(23),
    GMM_SEARCH_RESULTS(24),
    GMM_PERSONAL_SAFETY(25),
    GMM_TRAVEL_HIGHLIGHT(27),
    GMM_LOCAL_RECOMMENDATIONS(29),
    GMM_BASEMAP_PERSONALIZATION(30),
    GMM_CATEGORICAL_SEARCH(31),
    GMM_CATEGORICAL_SEARCH_RESULTS_INJECTION(34),
    GMM_HOTEL_CATEGORICAL_SEARCH(36),
    GMM_HOTEL_CATEGORICAL_SEARCH_INJECTION(41),
    GMM_COVID19(32),
    GMM_BUSYNESS(33),
    GMM_WEATHER_POI_BASEMAP(35),
    GMM_AIR_QUALITY(37),
    GMM_AIR_QUALITY_HEATMAP(51),
    GMM_API_TILE_OVERLAY(38),
    GMM_CRISIS_AMBIENT_ALERTS_IN_ALL_ZOOMS_FOR_TESTING_OVERLAY(47),
    GMM_CRISIS_OVERLAY(44),
    GMM_CRISIS_WILDFIRES(39),
    GMM_AREA_BUSYNESS(40),
    GMM_BASEMAP_PHOTOS(42),
    GMM_RESTRICTIONS(48),
    GMM_SPOTLIT(43),
    GMM_IMMERSIVE_AUGMENTATIONS(50),
    GMM_IMMERSIVE_AUGMENTATIONS_SV(55),
    TRAVEL_MAP_REACHABILITY(45),
    MAPS_API_DDS_1P(46),
    MAPS_DIRECTIONS(49),
    STATIC_LABELS(52),
    MAPS_WAYFINDING(53),
    EVCS(56),
    ADDITIVE_STATIC_LABELS(57),
    INDOOR_DEFAULT(58),
    DESTINATIONS(59);

    public final int ah;

    an(int i) {
        this.ah = i;
    }

    public static an b(int i) {
        switch (i) {
            case 0:
                return UNKNOWN;
            case 1:
                return GMM_VECTOR_BASE;
            case 2:
                return GMM_VECTOR_TRAFFIC_V2;
            case 3:
                return GMM_VECTOR_BICYCLING_OVERLAY;
            case 4:
                return GMM_LABELS_ONLY;
            case 5:
                return GMM_REALTIME;
            case 6:
                return GMM_HIGHLIGHT_RAP;
            case 7:
                return GMM_TRAFFIC_CAR;
            case 8:
                return GMM_TRANSIT;
            case 9:
                return GMM_INDOOR;
            case 10:
                return GMM_MY_MAPS;
            case 11:
                return GMM_EXPLORE_EAT_AND_DRINK;
            case 12:
                return GMM_EXPLORE_PLAY;
            case 13:
                return GMM_EXPLORE_SHOP;
            case 14:
                return GMM_EXPLORE_SERVICES;
            case 15:
                return GMM_SATELLITE;
            case 16:
                return GMM_TERRAIN;
            case 17:
                return GMM_ROAD_GRAPH;
            case 18:
                return GMM_SPOTLIGHT_PERSONALIZED_SMARTMAPS;
            case 19:
                return GMM_SPOTLIGHT_PERSONALIZED_SMARTMAPS_PER_TILE;
            case 20:
                return GMM_SPOTLIGHT_HIGHLIGHTING;
            case 21:
                return GMM_BUILDING_3D;
            case 22:
                return GMM_MAJOR_EVENT;
            case 23:
                return GMM_STREET_VIEW;
            case 24:
                return GMM_SEARCH_RESULTS;
            case 25:
                return GMM_PERSONAL_SAFETY;
            case 26:
                return GMM_TERRAIN_DARK;
            case 27:
                return GMM_TRAVEL_HIGHLIGHT;
            case 28:
            default:
                return null;
            case 29:
                return GMM_LOCAL_RECOMMENDATIONS;
            case 30:
                return GMM_BASEMAP_PERSONALIZATION;
            case 31:
                return GMM_CATEGORICAL_SEARCH;
            case 32:
                return GMM_COVID19;
            case 33:
                return GMM_BUSYNESS;
            case 34:
                return GMM_CATEGORICAL_SEARCH_RESULTS_INJECTION;
            case 35:
                return GMM_WEATHER_POI_BASEMAP;
            case 36:
                return GMM_HOTEL_CATEGORICAL_SEARCH;
            case 37:
                return GMM_AIR_QUALITY;
            case 38:
                return GMM_API_TILE_OVERLAY;
            case 39:
                return GMM_CRISIS_WILDFIRES;
            case 40:
                return GMM_AREA_BUSYNESS;
            case 41:
                return GMM_HOTEL_CATEGORICAL_SEARCH_INJECTION;
            case 42:
                return GMM_BASEMAP_PHOTOS;
            case 43:
                return GMM_SPOTLIT;
            case 44:
                return GMM_CRISIS_OVERLAY;
            case 45:
                return TRAVEL_MAP_REACHABILITY;
            case 46:
                return MAPS_API_DDS_1P;
            case 47:
                return GMM_CRISIS_AMBIENT_ALERTS_IN_ALL_ZOOMS_FOR_TESTING_OVERLAY;
            case 48:
                return GMM_RESTRICTIONS;
            case 49:
                return MAPS_DIRECTIONS;
            case 50:
                return GMM_IMMERSIVE_AUGMENTATIONS;
            case 51:
                return GMM_AIR_QUALITY_HEATMAP;
            case 52:
                return STATIC_LABELS;
            case 53:
                return MAPS_WAYFINDING;
            case 54:
                return GMM_TRAFFIC_CAR_JAPAN;
            case 55:
                return GMM_IMMERSIVE_AUGMENTATIONS_SV;
            case 56:
                return EVCS;
            case 57:
                return ADDITIVE_STATIC_LABELS;
            case 58:
                return INDOOR_DEFAULT;
            case 59:
                return DESTINATIONS;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.ah;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.ah);
    }
}

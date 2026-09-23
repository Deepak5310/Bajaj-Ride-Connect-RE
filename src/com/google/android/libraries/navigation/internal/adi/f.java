package com.google.android.libraries.navigation.internal.adi;

import com.drew.metadata.exif.makernotes.LeicaMakernoteDirectory;
import com.drew.metadata.exif.makernotes.OlympusCameraSettingsMakernoteDirectory;
import com.drew.metadata.mov.metadata.QuickTimeMetadataDirectory;
import com.drew.metadata.photoshop.PhotoshopDirectory;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum f implements com.google.android.libraries.navigation.internal.ael.bm {
    TYPE_ALL(0),
    TYPE_ADMINISTRATIVE(1),
    TYPE_COUNTRY(17),
    TYPE_INTERNATIONAL_DISPUTED_BORDER(273),
    TYPE_TREATY_OR_PROVISIONAL_INTERNATIONAL_BORDER(274),
    TYPE_BORDER_ADMINISTRATIVE(275),
    TYPE_ADMINISTRATIVE_AREA1(18),
    TYPE_LOCALITY(19),
    TYPE_NEIGHBORHOOD(20),
    TYPE_LAND_PARCEL(21),
    TYPE_POI(2),
    TYPE_BUSINESS(33),
    TYPE_SHOPPING(529),
    TYPE_FOOD_AND_DRINK(530),
    TYPE_GAS_STATION(531),
    TYPE_CAR_RENTAL(532),
    TYPE_LODGING(533),
    TYPE_GOVERNMENT(34),
    TYPE_SCHOOL(35),
    TYPE_MEDICAL(36),
    TYPE_ATTRACTION(37),
    TYPE_PLACE_OF_WORSHIP(38),
    TYPE_SPORTS_COMPLEX(39),
    TYPE_PARK(40),
    TYPE_ROAD(3),
    TYPE_HIGHWAY(49),
    TYPE_CONTROLLED_ACCESS_HIGHWAY(785),
    TYPE_ARTERIAL_ROAD(50),
    TYPE_LOCAL_ROAD(51),
    TYPE_LOCAL_DRIVABLE_ROAD(LeicaMakernoteDirectory.TAG_CCD_BOARD_VERSION),
    TYPE_TRAIL(LeicaMakernoteDirectory.TAG_CONTROLLER_BOARD_VERSION),
    TYPE_LANE(52),
    TYPE_TRANSIT(4),
    TYPE_TRANSIT_LINE(65),
    TYPE_RAIL_LINE(PhotoshopDirectory.TAG_ICC_UNTAGGED_PROFILE),
    TYPE_FERRY_LINE(1042),
    TYPE_TRANSIT_LAYER_LINE(1043),
    TYPE_TRANSIT_STATION(66),
    TYPE_RAIL_STATION(PhotoshopDirectory.TAG_VERSION),
    TYPE_BUS_STOP(PhotoshopDirectory.TAG_EXIF_DATA_1),
    TYPE_AIRPORT(PhotoshopDirectory.TAG_EXIF_DATA_3),
    TYPE_FERRY_TERMINAL(PhotoshopDirectory.TAG_XMP_DATA),
    TYPE_LANDSCAPE(5),
    TYPE_MAN_MADE_STRUCTURE(81),
    TYPE_BUILDING(QuickTimeMetadataDirectory.TAG_YEAR),
    TYPE_BUILT_UP_AREA(QuickTimeMetadataDirectory.TAG_COLLECTION_USER),
    TYPE_AREA_OF_INTEREST(1299),
    TYPE_NATURAL_FEATURE(82),
    TYPE_LANDCOVER(OlympusCameraSettingsMakernoteDirectory.TagPictureModeSaturation),
    TYPE_TERRAIN(OlympusCameraSettingsMakernoteDirectory.TagPictureModeHue),
    TYPE_WATER(6);

    public static final com.google.android.libraries.navigation.internal.ael.bn Z = new com.google.android.libraries.navigation.internal.ael.bn() { // from class: com.google.android.libraries.navigation.internal.adi.e
        @Override // com.google.android.libraries.navigation.internal.ael.bn
        public final /* synthetic */ com.google.android.libraries.navigation.internal.ael.bm a(int i) {
            if (i == 65) {
                return f.TYPE_TRANSIT_LINE;
            }
            if (i == 66) {
                return f.TYPE_TRANSIT_STATION;
            }
            if (i == 81) {
                return f.TYPE_MAN_MADE_STRUCTURE;
            }
            if (i == 82) {
                return f.TYPE_NATURAL_FEATURE;
            }
            if (i == 817) {
                return f.TYPE_LOCAL_DRIVABLE_ROAD;
            }
            if (i == 818) {
                return f.TYPE_TRAIL;
            }
            switch (i) {
                case 0:
                    return f.TYPE_ALL;
                case 1:
                    return f.TYPE_ADMINISTRATIVE;
                case 2:
                    return f.TYPE_POI;
                case 3:
                    return f.TYPE_ROAD;
                case 4:
                    return f.TYPE_TRANSIT;
                case 5:
                    return f.TYPE_LANDSCAPE;
                case 6:
                    return f.TYPE_WATER;
                default:
                    switch (i) {
                        case 17:
                            return f.TYPE_COUNTRY;
                        case 18:
                            return f.TYPE_ADMINISTRATIVE_AREA1;
                        case 19:
                            return f.TYPE_LOCALITY;
                        case 20:
                            return f.TYPE_NEIGHBORHOOD;
                        case 21:
                            return f.TYPE_LAND_PARCEL;
                        default:
                            switch (i) {
                                case 33:
                                    return f.TYPE_BUSINESS;
                                case 34:
                                    return f.TYPE_GOVERNMENT;
                                case 35:
                                    return f.TYPE_SCHOOL;
                                case 36:
                                    return f.TYPE_MEDICAL;
                                case 37:
                                    return f.TYPE_ATTRACTION;
                                case 38:
                                    return f.TYPE_PLACE_OF_WORSHIP;
                                case 39:
                                    return f.TYPE_SPORTS_COMPLEX;
                                case 40:
                                    return f.TYPE_PARK;
                                case 785:
                                    return f.TYPE_CONTROLLED_ACCESS_HIGHWAY;
                                case PhotoshopDirectory.TAG_VERSION /* 1057 */:
                                    return f.TYPE_RAIL_STATION;
                                case PhotoshopDirectory.TAG_EXIF_DATA_1 /* 1058 */:
                                    return f.TYPE_BUS_STOP;
                                case PhotoshopDirectory.TAG_EXIF_DATA_3 /* 1059 */:
                                    return f.TYPE_AIRPORT;
                                case PhotoshopDirectory.TAG_XMP_DATA /* 1060 */:
                                    return f.TYPE_FERRY_TERMINAL;
                                case QuickTimeMetadataDirectory.TAG_YEAR /* 1297 */:
                                    return f.TYPE_BUILDING;
                                case QuickTimeMetadataDirectory.TAG_COLLECTION_USER /* 1298 */:
                                    return f.TYPE_BUILT_UP_AREA;
                                case 1299:
                                    return f.TYPE_AREA_OF_INTEREST;
                                case OlympusCameraSettingsMakernoteDirectory.TagPictureModeSaturation /* 1313 */:
                                    return f.TYPE_LANDCOVER;
                                case OlympusCameraSettingsMakernoteDirectory.TagPictureModeHue /* 1314 */:
                                    return f.TYPE_TERRAIN;
                                default:
                                    switch (i) {
                                        case 49:
                                            return f.TYPE_HIGHWAY;
                                        case 50:
                                            return f.TYPE_ARTERIAL_ROAD;
                                        case 51:
                                            return f.TYPE_LOCAL_ROAD;
                                        case 52:
                                            return f.TYPE_LANE;
                                        default:
                                            switch (i) {
                                                case 273:
                                                    return f.TYPE_INTERNATIONAL_DISPUTED_BORDER;
                                                case 274:
                                                    return f.TYPE_TREATY_OR_PROVISIONAL_INTERNATIONAL_BORDER;
                                                case 275:
                                                    return f.TYPE_BORDER_ADMINISTRATIVE;
                                                default:
                                                    switch (i) {
                                                        case 529:
                                                            return f.TYPE_SHOPPING;
                                                        case 530:
                                                            return f.TYPE_FOOD_AND_DRINK;
                                                        case 531:
                                                            return f.TYPE_GAS_STATION;
                                                        case 532:
                                                            return f.TYPE_CAR_RENTAL;
                                                        case 533:
                                                            return f.TYPE_LODGING;
                                                        default:
                                                            switch (i) {
                                                                case PhotoshopDirectory.TAG_ICC_UNTAGGED_PROFILE /* 1041 */:
                                                                    return f.TYPE_RAIL_LINE;
                                                                case 1042:
                                                                    return f.TYPE_FERRY_LINE;
                                                                case 1043:
                                                                    return f.TYPE_TRANSIT_LAYER_LINE;
                                                                default:
                                                                    return null;
                                                            }
                                                    }
                                            }
                                    }
                            }
                    }
            }
        }
    };
    private final int ab;

    f(int i) {
        this.ab = i;
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

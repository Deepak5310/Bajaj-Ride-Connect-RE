package com.mappls.sdk.maps.widgets.indoor;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class IndoorConstants {
    static final String QUERY_LAYER_1 = "indoor_venue";
    static final String QUERY_LAYER_2 = "footprints_indoor_3d_1_floor";
    static final String LAYER_TO_HIDE_AND_SHOW = "footprints_indoor_2_3floors";
    static final String[] INDOOR_LAYERS = {"indoor_units", QUERY_LAYER_1, "indoor_building_outline", QUERY_LAYER_2, "Indoor_othpoi", "indoor_entry_exit", "indoor_poi_withouticon", "indoor_poi2", "indoor_levelsname", "indoor_SHPMAL", LAYER_TO_HIDE_AND_SHOW, "Indoor_MISC1", "Indoor_MISC2", "Indoor_MISC3", "Indoor_MISC4", "Indoor_MISC5"};

    public static String getFloorName(int i) {
        if (i == 0) {
            return "G";
        }
        return i + "";
    }

    public static String getInternalFloorName(int i) {
        String str = String.format(Locale.getDefault(), "%03d", Integer.valueOf(Math.abs(i > -1 ? i + 1 : i)));
        return (i < 0 ? "B" : "L") + str;
    }

    public static List<String> getPossibleFloors() {
        ArrayList arrayList = new ArrayList();
        for (int i = 120; i > -20; i--) {
            arrayList.add(getInternalFloorName(i));
        }
        return arrayList;
    }

    public static List<Floor> getFloors(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        if (i2 < 0) {
            i += i2;
        }
        while (i2 < i) {
            arrayList.add(new Floor(Integer.valueOf(i2), getFloorName(i2), getInternalFloorName(i2)));
            i2++;
        }
        return arrayList;
    }
}

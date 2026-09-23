package com.mappls.sdk.direction.ui.common;

import android.content.Context;
import com.mappls.sdk.direction.ui.R;
import com.mappls.sdk.direction.ui.model.StopModel;
import com.mappls.sdk.maps.geometry.LatLng;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class e {
    public static int a(Context context, float f) {
        if (context == null) {
            return 0;
        }
        return (int) (f * context.getResources().getDisplayMetrics().density);
    }

    public static int a(List list) {
        if (list == null || list.isEmpty()) {
            return R.color.mappls_direction_eta_text_color_with_out_traffic;
        }
        List arrayList = list.isEmpty() ? new ArrayList() : list.subList(0, list.size());
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (((String) arrayList.get(i2)).equals("heavy") || ((String) arrayList.get(i2)).equals("moderate") || ((String) arrayList.get(i2)).equals("severe")) {
                i++;
            }
        }
        int size = !arrayList.isEmpty() ? (i * 100) / arrayList.size() : 1;
        if (size <= 10) {
            return R.color.mappls_direction_eta_text_color_with_out_traffic;
        }
        return size <= 25 ? R.color.mappls_direction_eta_text_color_with_low_traffic : R.color.mappls_direction_eta_text_color_with_traffic;
    }

    public static boolean a(StopModel stopModel, StopModel stopModel2) {
        if (stopModel != null && stopModel2 != null) {
            if (stopModel.getLocation() != null && stopModel2.getLocation() != null) {
                return new LatLng(stopModel.getLocation().latitude(), stopModel.getLocation().longitude()).distanceTo(new LatLng(stopModel2.getLocation().latitude(), stopModel2.getLocation().longitude())) < 10.0d;
            }
            if (stopModel.getMapplsPin() != null && stopModel2.getMapplsPin() != null) {
                return stopModel.getMapplsPin().equalsIgnoreCase(stopModel2.getMapplsPin());
            }
        }
        return false;
    }
}

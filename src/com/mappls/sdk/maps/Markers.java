package com.mappls.sdk.maps;

import android.graphics.RectF;
import com.mappls.sdk.maps.annotations.BaseMarkerOptions;
import com.mappls.sdk.maps.annotations.Marker;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
interface Markers {
    Marker addBy(BaseMarkerOptions baseMarkerOptions, MapplsMap mapplsMap, MapplsMap.OnMarkerAddedListener onMarkerAddedListener);

    List<Marker> addBy(List<? extends BaseMarkerOptions> list, MapplsMap mapplsMap, MapplsMap.OnMarkerAddedListener onMarkerAddedListener);

    List<Marker> obtainAll();

    List<Marker> obtainAllIn(RectF rectF);

    void reload();

    void update(Marker marker, MapplsMap mapplsMap, MapplsMap.OnMarkerAddedListener onMarkerAddedListener);
}

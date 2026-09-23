package com.mappls.sdk.maps;

import com.mappls.sdk.maps.annotations.Polyline;
import com.mappls.sdk.maps.annotations.PolylineOptions;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
interface Polylines {
    Polyline addBy(PolylineOptions polylineOptions, MapplsMap mapplsMap);

    List<Polyline> addBy(List<PolylineOptions> list, MapplsMap mapplsMap);

    List<Polyline> obtainAll();

    void update(Polyline polyline);
}

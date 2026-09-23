package com.mappls.sdk.maps;

import com.mappls.sdk.maps.annotations.Polygon;
import com.mappls.sdk.maps.annotations.PolygonOptions;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
interface Polygons {
    Polygon addBy(PolygonOptions polygonOptions, MapplsMap mapplsMap);

    List<Polygon> addBy(List<PolygonOptions> list, MapplsMap mapplsMap);

    List<Polygon> obtainAll();

    void update(Polygon polygon);
}

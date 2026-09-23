package com.mappls.sdk.navigation.ui.map.route;

import com.mappls.sdk.geojson.LineString;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.services.api.directions.models.DirectionsRoute;
import com.mappls.sdk.turf.TurfConstants;
import com.mappls.sdk.turf.TurfMeasurement;
import com.mappls.sdk.turf.TurfMisc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public final class i implements MapplsMap.OnMapClickListener {
    public final z a;
    public com.mappls.sdk.navigation.ui.navigation.f b;

    public i(z zVar) {
        this.a = zVar;
    }

    @Override // com.mappls.sdk.maps.MapplsMap.OnMapClickListener
    public final boolean onMapClick(LatLng latLng) {
        HashMap map;
        z zVar = this.a;
        if (zVar.v && (map = zVar.a) != null && !map.isEmpty()) {
            ArrayList arrayList = this.a.c;
            HashMap map2 = new HashMap();
            Point pointFromLngLat = Point.fromLngLat(latLng.getLongitude(), latLng.getLatitude());
            for (LineString lineString : map.keySet()) {
                Point point = (Point) TurfMisc.nearestPointOnLine(pointFromLngLat, lineString.coordinates()).geometry();
                if (point == null) {
                    break;
                }
                map2.put(Double.valueOf(TurfMeasurement.distance(pointFromLngLat, point, TurfConstants.UNIT_METERS)), (DirectionsRoute) map.get(lineString));
            }
            ArrayList arrayList2 = new ArrayList(map2.keySet());
            Collections.sort(arrayList2);
            int iIndexOf = arrayList.indexOf((DirectionsRoute) map2.get(arrayList2.get(0)));
            z zVar2 = this.a;
            boolean z = zVar2.u != iIndexOf && iIndexOf < zVar2.c.size() && iIndexOf >= 0;
            if (z) {
                zVar2.u = iIndexOf;
                zVar2.a(iIndexOf);
            }
            if (z && this.b != null) {
                MapplsNavigationHelper.getInstance().setSelectedIndex(iIndexOf);
            }
        }
        return false;
    }
}

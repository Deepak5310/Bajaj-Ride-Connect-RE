package com.mappls.sdk.navigation.ui.map.route;

import android.location.Location;
import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.LineString;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.geojson.utils.PolylineUtils;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.camera.ProgressChangeListener;
import com.mappls.sdk.navigation.camera.RouteInformation;
import com.mappls.sdk.navigation.routing.NavigationStep;
import com.mappls.sdk.services.api.directions.models.LegStep;
import com.mappls.sdk.turf.TurfConstants;
import com.mappls.sdk.turf.TurfMisc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class A implements ProgressChangeListener {
    public final C0228h a;

    public A(C0228h c0228h) {
        this.a = c0228h;
    }

    @Override // com.mappls.sdk.navigation.camera.ProgressChangeListener
    public final void onProgressChange(Location location, RouteInformation routeInformation) {
        C0228h c0228h = this.a;
        c0228h.getClass();
        if (routeInformation.getAdviseInfo() == null) {
            return;
        }
        List navigationSteps = MapplsNavigationHelper.getInstance().getNavigationSteps();
        int position = routeInformation.getAdviseInfo().getPosition();
        int position2 = routeInformation.getAdviseInfo().getPosition();
        if (position != 0) {
            position2--;
        }
        LegStep legStep = (LegStep) ((NavigationStep) navigationSteps.get(position2)).getExtraInfo();
        int i = position2 + 1;
        LegStep legStep2 = navigationSteps.size() > i ? (LegStep) ((NavigationStep) navigationSteps.get(i)).getExtraInfo() : null;
        if (legStep == null || legStep2 == null) {
            return;
        }
        List<Point> listDecode = PolylineUtils.decode(legStep2.geometry(), 6);
        List<Point> listDecode2 = PolylineUtils.decode(legStep.geometry(), 6);
        boolean z = listDecode == null || listDecode.size() < 2;
        boolean z2 = listDecode2.size() < 2;
        if (z || z2) {
            c0228h.d.getStyle(new C0227g(c0228h, false));
            return;
        }
        c0228h.d.getStyle(new C0227g(c0228h, true));
        Collections.reverse(listDecode2);
        LineString lineStringFromLngLats = LineString.fromLngLats(listDecode2);
        LineString lineStringFromLngLats2 = LineString.fromLngLats(listDecode);
        LineString lineStringLineSliceAlong = TurfMisc.lineSliceAlong(lineStringFromLngLats, 0.0d, 20.0d, TurfConstants.UNIT_METERS);
        LineString lineStringLineSliceAlong2 = TurfMisc.lineSliceAlong(lineStringFromLngLats2, 0.0d, 20.0d, TurfConstants.UNIT_METERS);
        Collections.reverse(lineStringLineSliceAlong.coordinates());
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(lineStringLineSliceAlong.coordinates());
        arrayList.addAll(lineStringLineSliceAlong2.coordinates());
        c0228h.h = arrayList;
        c0228h.f.setGeoJson(Feature.fromGeometry(LineString.fromLngLats(arrayList)));
        c0228h.a(c0228h.h);
    }
}

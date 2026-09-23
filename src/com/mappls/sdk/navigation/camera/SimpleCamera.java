package com.mappls.sdk.navigation.camera;

import com.google.android.libraries.places.api.model.PlaceTypes;
import com.mappls.sdk.geojson.LineString;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.model.AdviseInfo;
import com.mappls.sdk.services.api.directions.models.DirectionsRoute;
import com.mappls.sdk.services.api.directions.models.RouteOptions;
import com.mappls.sdk.turf.TurfConstants;
import com.mappls.sdk.turf.TurfMisc;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SimpleCamera.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/mappls/sdk/navigation/camera/SimpleCamera;", "Lcom/mappls/sdk/navigation/camera/Camera;", "()V", "defaultZoom", "", "getDefaultZoom", "()D", "setDefaultZoom", "(D)V", "generateRouteCoordinates", "", "Lcom/mappls/sdk/geojson/Point;", PlaceTypes.ROUTE, "Lcom/mappls/sdk/services/api/directions/models/DirectionsRoute;", "getCoordinates", "routeProgress", "Lcom/mappls/sdk/navigation/model/AdviseInfo;", "getLineString", "Lcom/mappls/sdk/geojson/LineString;", "getRoute", "routeInformation", "Lcom/mappls/sdk/navigation/camera/RouteInformation;", "overview", "tilt", "zoom", "Companion", "navigation-camera_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class SimpleCamera extends Camera {
    public static final double DEFAULT_TILT = 40.0d;
    public static final double DEFAULT_ZOOM = 15.0d;
    private double defaultZoom = 15.0d;

    @Override // com.mappls.sdk.navigation.camera.Camera
    public double tilt(RouteInformation routeInformation) {
        Intrinsics.checkNotNullParameter(routeInformation, "routeInformation");
        return 40.0d;
    }

    public final double getDefaultZoom() {
        return this.defaultZoom;
    }

    public final void setDefaultZoom(double d) {
        this.defaultZoom = d;
    }

    @Override // com.mappls.sdk.navigation.camera.Camera
    public double zoom(RouteInformation routeInformation) {
        Intrinsics.checkNotNullParameter(routeInformation, "routeInformation");
        return this.defaultZoom;
    }

    @Override // com.mappls.sdk.navigation.camera.Camera
    public List<Point> overview(RouteInformation routeInformation) {
        List<Point> coordinates;
        Intrinsics.checkNotNullParameter(routeInformation, "routeInformation");
        DirectionsRoute route = getRoute(routeInformation);
        if (route == null) {
            coordinates = null;
        } else if (routeInformation.getAdviseInfo() == null) {
            coordinates = generateRouteCoordinates(route);
        } else {
            coordinates = getCoordinates(route, routeInformation.getAdviseInfo());
        }
        return coordinates == null ? CollectionsKt.emptyList() : coordinates;
    }

    private final DirectionsRoute getRoute(RouteInformation routeInformation) {
        if (routeInformation.getRoute() == null) {
            return MapplsNavigationHelper.getInstance().getCurrentRoute();
        }
        return routeInformation.getRoute();
    }

    private final List<Point> getCoordinates(DirectionsRoute route, AdviseInfo routeProgress) {
        LineString lineString;
        Double dDistance;
        List<Point> listCoordinates = null;
        if (routeProgress != null && (lineString = getLineString(route)) != null && (dDistance = route.distance()) != null) {
            double dDoubleValue = dDistance.doubleValue() - ((double) routeProgress.getLeftDistance());
            Double dDistance2 = route.distance();
            Intrinsics.checkNotNull(dDistance2);
            Intrinsics.checkNotNullExpressionValue(dDistance2, "route.distance()!!");
            listCoordinates = TurfMisc.lineSliceAlong(lineString, dDoubleValue, dDistance2.doubleValue(), TurfConstants.UNIT_METERS).coordinates();
        }
        return listCoordinates == null ? CollectionsKt.emptyList() : listCoordinates;
    }

    private final List<Point> generateRouteCoordinates(DirectionsRoute route) {
        LineString lineString;
        List<Point> listCoordinates = null;
        if (route != null && (lineString = getLineString(route)) != null) {
            listCoordinates = lineString.coordinates();
        }
        return listCoordinates == null ? CollectionsKt.emptyList() : listCoordinates;
    }

    private final LineString getLineString(DirectionsRoute route) {
        String strGeometry = route.geometry();
        if (strGeometry == null) {
            return null;
        }
        RouteOptions routeOptions = route.routeOptions();
        return LineString.fromPolyline(strGeometry, Intrinsics.areEqual(routeOptions != null ? routeOptions.geometries() : null, "polyline") ? 5 : 6);
    }
}

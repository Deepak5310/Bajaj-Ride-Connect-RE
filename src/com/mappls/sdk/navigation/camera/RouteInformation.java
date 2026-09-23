package com.mappls.sdk.navigation.camera;

import android.location.Location;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mappls.sdk.navigation.model.AdviseInfo;
import com.mappls.sdk.services.api.directions.models.DirectionsRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RouteInformation.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/mappls/sdk/navigation/camera/RouteInformation;", "", PlaceTypes.ROUTE, "Lcom/mappls/sdk/services/api/directions/models/DirectionsRoute;", FirebaseAnalytics.Param.LOCATION, "Landroid/location/Location;", "adviseInfo", "Lcom/mappls/sdk/navigation/model/AdviseInfo;", "(Lcom/mappls/sdk/services/api/directions/models/DirectionsRoute;Landroid/location/Location;Lcom/mappls/sdk/navigation/model/AdviseInfo;)V", "getAdviseInfo", "()Lcom/mappls/sdk/navigation/model/AdviseInfo;", "getLocation", "()Landroid/location/Location;", "getRoute", "()Lcom/mappls/sdk/services/api/directions/models/DirectionsRoute;", "setRoute", "(Lcom/mappls/sdk/services/api/directions/models/DirectionsRoute;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "navigation-camera_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class RouteInformation {
    private final AdviseInfo adviseInfo;
    private final Location location;
    private DirectionsRoute route;

    public static /* synthetic */ RouteInformation copy$default(RouteInformation routeInformation, DirectionsRoute directionsRoute, Location location, AdviseInfo adviseInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            directionsRoute = routeInformation.route;
        }
        if ((i & 2) != 0) {
            location = routeInformation.location;
        }
        if ((i & 4) != 0) {
            adviseInfo = routeInformation.adviseInfo;
        }
        return routeInformation.copy(directionsRoute, location, adviseInfo);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final DirectionsRoute getRoute() {
        return this.route;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Location getLocation() {
        return this.location;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final AdviseInfo getAdviseInfo() {
        return this.adviseInfo;
    }

    public final RouteInformation copy(DirectionsRoute route, Location location, AdviseInfo adviseInfo) {
        return new RouteInformation(route, location, adviseInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RouteInformation)) {
            return false;
        }
        RouteInformation routeInformation = (RouteInformation) other;
        return Intrinsics.areEqual(this.route, routeInformation.route) && Intrinsics.areEqual(this.location, routeInformation.location) && Intrinsics.areEqual(this.adviseInfo, routeInformation.adviseInfo);
    }

    public int hashCode() {
        DirectionsRoute directionsRoute = this.route;
        int iHashCode = (directionsRoute == null ? 0 : directionsRoute.hashCode()) * 31;
        Location location = this.location;
        int iHashCode2 = (iHashCode + (location == null ? 0 : location.hashCode())) * 31;
        AdviseInfo adviseInfo = this.adviseInfo;
        return iHashCode2 + (adviseInfo != null ? adviseInfo.hashCode() : 0);
    }

    public String toString() {
        return "RouteInformation(route=" + this.route + ", location=" + this.location + ", adviseInfo=" + this.adviseInfo + ')';
    }

    public RouteInformation(DirectionsRoute directionsRoute, Location location, AdviseInfo adviseInfo) {
        this.route = directionsRoute;
        this.location = location;
        this.adviseInfo = adviseInfo;
    }

    public final DirectionsRoute getRoute() {
        return this.route;
    }

    public final void setRoute(DirectionsRoute directionsRoute) {
        this.route = directionsRoute;
    }

    public final Location getLocation() {
        return this.location;
    }

    public final AdviseInfo getAdviseInfo() {
        return this.adviseInfo;
    }
}

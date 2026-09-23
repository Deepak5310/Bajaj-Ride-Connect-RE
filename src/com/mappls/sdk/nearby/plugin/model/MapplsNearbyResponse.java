package com.mappls.sdk.nearby.plugin.model;

import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.nearby.plugin.CategoryCode;
import com.mappls.sdk.services.api.nearby.model.NearbyAtlasResponse;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class MapplsNearbyResponse {
    private final NearbyAtlasResponse nearbyAtlasResponse;
    private final LatLng refLocation;
    private final String refMapplsPin;
    private final List<CategoryCode> selectedCategory;

    /* JADX WARN: Multi-variable type inference failed */
    public MapplsNearbyResponse(NearbyAtlasResponse nearbyAtlasResponse, List<? extends CategoryCode> selectedCategory, LatLng latLng, String str) {
        Intrinsics.checkNotNullParameter(nearbyAtlasResponse, "nearbyAtlasResponse");
        Intrinsics.checkNotNullParameter(selectedCategory, "selectedCategory");
        this.nearbyAtlasResponse = nearbyAtlasResponse;
        this.selectedCategory = selectedCategory;
        this.refLocation = latLng;
        this.refMapplsPin = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MapplsNearbyResponse copy$default(MapplsNearbyResponse mapplsNearbyResponse, NearbyAtlasResponse nearbyAtlasResponse, List list, LatLng latLng, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            nearbyAtlasResponse = mapplsNearbyResponse.nearbyAtlasResponse;
        }
        if ((i & 2) != 0) {
            list = mapplsNearbyResponse.selectedCategory;
        }
        if ((i & 4) != 0) {
            latLng = mapplsNearbyResponse.refLocation;
        }
        if ((i & 8) != 0) {
            str = mapplsNearbyResponse.refMapplsPin;
        }
        return mapplsNearbyResponse.copy(nearbyAtlasResponse, list, latLng, str);
    }

    public final NearbyAtlasResponse component1() {
        return this.nearbyAtlasResponse;
    }

    public final List<CategoryCode> component2() {
        return this.selectedCategory;
    }

    public final LatLng component3() {
        return this.refLocation;
    }

    public final String component4() {
        return this.refMapplsPin;
    }

    public final MapplsNearbyResponse copy(NearbyAtlasResponse nearbyAtlasResponse, List<? extends CategoryCode> selectedCategory, LatLng latLng, String str) {
        Intrinsics.checkNotNullParameter(nearbyAtlasResponse, "nearbyAtlasResponse");
        Intrinsics.checkNotNullParameter(selectedCategory, "selectedCategory");
        return new MapplsNearbyResponse(nearbyAtlasResponse, selectedCategory, latLng, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MapplsNearbyResponse)) {
            return false;
        }
        MapplsNearbyResponse mapplsNearbyResponse = (MapplsNearbyResponse) obj;
        return Intrinsics.areEqual(this.nearbyAtlasResponse, mapplsNearbyResponse.nearbyAtlasResponse) && Intrinsics.areEqual(this.selectedCategory, mapplsNearbyResponse.selectedCategory) && Intrinsics.areEqual(this.refLocation, mapplsNearbyResponse.refLocation) && Intrinsics.areEqual(this.refMapplsPin, mapplsNearbyResponse.refMapplsPin);
    }

    public final NearbyAtlasResponse getNearbyAtlasResponse() {
        return this.nearbyAtlasResponse;
    }

    public final LatLng getRefLocation() {
        return this.refLocation;
    }

    public final String getRefMapplsPin() {
        return this.refMapplsPin;
    }

    public final List<CategoryCode> getSelectedCategory() {
        return this.selectedCategory;
    }

    public int hashCode() {
        int iHashCode = (this.selectedCategory.hashCode() + (this.nearbyAtlasResponse.hashCode() * 31)) * 31;
        LatLng latLng = this.refLocation;
        int iHashCode2 = (iHashCode + (latLng == null ? 0 : latLng.hashCode())) * 31;
        String str = this.refMapplsPin;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "MapplsNearbyResponse(nearbyAtlasResponse=" + this.nearbyAtlasResponse + ", selectedCategory=" + this.selectedCategory + ", refLocation=" + this.refLocation + ", refMapplsPin=" + this.refMapplsPin + ')';
    }
}

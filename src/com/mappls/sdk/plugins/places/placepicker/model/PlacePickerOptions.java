package com.mappls.sdk.plugins.places.placepicker.model;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Parcelable;
import com.mappls.sdk.maps.camera.CameraPosition;
import com.mappls.sdk.maps.geometry.LatLngBounds;
import com.mappls.sdk.plugins.places.R;
import com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions;
import com.mappls.sdk.services.utils.Constants;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class PlacePickerOptions implements Parcelable {

    public static abstract class Builder {
        public abstract Builder addressTextColor(Integer num);

        public abstract Builder baseUrl(String str);

        public abstract PlacePickerOptions build();

        public abstract Builder buildingAppearanceFillColor(String str);

        public abstract Builder buildingAppearanceFillOpacity(Double d);

        public abstract Builder buildingAppearanceStrokeColor(String str);

        public abstract Builder buildingAppearanceStrokeOpacity(Double d);

        public abstract Builder buildingAppearanceStrokeWidth(Integer num);

        public abstract Builder buildingFootprintsEnabled(Boolean bool);

        public abstract Builder entryCoordinateCircleColor(String str);

        public abstract Builder entryCoordinateCircleRadius(Float f);

        public abstract Builder entryCoordinateSnapEnable(Boolean bool);

        public abstract Builder entryCoordinateSnappingRadius(Integer num);

        public abstract Builder includeDeviceLocationButton(Boolean bool);

        public abstract Builder includeSearch(Boolean bool);

        public abstract Builder lang(String str);

        public abstract Builder mapMaxZoom(Double d);

        public abstract Builder mapMinZoom(Double d);

        public abstract Builder marker(Integer num);

        public abstract Builder markerBitmap(Bitmap bitmap);

        public abstract Builder pickerButtonBackgroundColor(Integer num);

        public abstract Builder pickerButtonBackgroundResource(Integer num);

        public abstract Builder pickerButtonText(String str);

        public abstract Builder pickerButtonTextColor(Integer num);

        public abstract Builder placeNameTextColor(Integer num);

        public abstract Builder searchPlaceOption(PlaceOptions placeOptions);

        public abstract Builder showEntryCoordinate(Boolean bool);

        public abstract Builder showMarkerShadow(Boolean bool);

        public abstract Builder startingBounds(LatLngBounds latLngBounds);

        public abstract Builder startingMapplsPinBounds(List<String> list);

        public abstract Builder startingMapplsPinPosition(String str);

        public abstract Builder statingCameraPosition(CameraPosition cameraPosition);

        public abstract Builder toolbarColor(Integer num);

        public abstract Builder toolbarTintColor(Integer num);
    }

    public static Builder builder() {
        PlaceOptions.Builder builderBackgroundColor = PlaceOptions.builder().backgroundColor(Color.parseColor("#FFFFFF"));
        Boolean bool = Boolean.TRUE;
        PlaceOptions placeOptionsBuild = builderBackgroundColor.tokenizeAddress(bool).build(2);
        Builder builderPickerButtonText = new a.C0115a().baseUrl(Constants.ADVANCE_MAP_BASE_URL).includeDeviceLocationButton(bool).mapMaxZoom(Double.valueOf(18.0d)).mapMinZoom(Double.valueOf(4.0d)).includeSearch(bool).showMarkerShadow(bool).placeNameTextColor(Integer.valueOf(Color.parseColor("#263d57"))).addressTextColor(Integer.valueOf(Color.parseColor("#949fac"))).toolbarTintColor(Integer.valueOf(Color.parseColor("#000000"))).pickerButtonTextColor(Integer.valueOf(Color.parseColor("#FFFFFF"))).pickerButtonBackgroundResource(Integer.valueOf(R.drawable.mappls_search_btn_bg)).marker(Integer.valueOf(R.drawable.mappls_search_pin_red_marker)).pickerButtonText("Done");
        Boolean bool2 = Boolean.FALSE;
        return builderPickerButtonText.buildingFootprintsEnabled(bool2).buildingAppearanceFillColor("#00FFFF").buildingAppearanceStrokeColor("#00FFFF").buildingAppearanceStrokeOpacity(Double.valueOf(1.0d)).buildingAppearanceFillOpacity(Double.valueOf(0.3d)).buildingAppearanceStrokeWidth(2).searchPlaceOption(placeOptionsBuild).showEntryCoordinate(bool2).entryCoordinateCircleColor("#0000FF").entryCoordinateCircleRadius(Float.valueOf(8.0f)).entryCoordinateSnapEnable(bool2).entryCoordinateSnappingRadius(50);
    }

    public abstract Integer addressTextColor();

    public abstract String baseUrl();

    public abstract String buildingAppearanceFillColor();

    public abstract Double buildingAppearanceFillOpacity();

    public abstract String buildingAppearanceStrokeColor();

    public abstract Double buildingAppearanceStrokeOpacity();

    public abstract Integer buildingAppearanceStrokeWidth();

    public abstract Boolean buildingFootprintsEnabled();

    public abstract String entryCoordinateCircleColor();

    public abstract Float entryCoordinateCircleRadius();

    public abstract Boolean entryCoordinateSnapEnable();

    public abstract Integer entryCoordinateSnappingRadius();

    public abstract Boolean includeDeviceLocationButton();

    public abstract Boolean includeSearch();

    public abstract String lang();

    public abstract Double mapMaxZoom();

    public abstract Double mapMinZoom();

    public abstract Integer marker();

    public abstract Bitmap markerBitmap();

    public abstract Integer pickerButtonBackgroundColor();

    public abstract Integer pickerButtonBackgroundResource();

    public abstract String pickerButtonText();

    public abstract Integer pickerButtonTextColor();

    public abstract Integer placeNameTextColor();

    public abstract PlaceOptions searchPlaceOption();

    public abstract Boolean showEntryCoordinate();

    public abstract Boolean showMarkerShadow();

    public abstract LatLngBounds startingBounds();

    public abstract List<String> startingMapplsPinBounds();

    public abstract String startingMapplsPinPosition();

    public abstract CameraPosition statingCameraPosition();

    public abstract Integer toolbarColor();

    public abstract Integer toolbarTintColor();
}

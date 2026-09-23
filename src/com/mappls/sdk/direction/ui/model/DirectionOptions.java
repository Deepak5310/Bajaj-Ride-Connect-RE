package com.mappls.sdk.direction.ui.model;

import android.graphics.Color;
import android.os.Parcelable;
import com.mappls.sdk.direction.ui.R;
import com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import com.mappls.sdk.services.utils.Constants;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public abstract class DirectionOptions implements Parcelable {
    public static final int DISTANCE_TYPE_IMPERIAL = 1;
    public static final int DISTANCE_TYPE_METRIC = 0;
    public static final int THEME_DAY = 1;
    public static final int THEME_DEFAULT = 0;
    public static final int THEME_NIGHT = 2;

    public static abstract class Builder {
        public abstract Builder alongRouteBuffer(Integer num);

        public abstract Builder alongRouteDarkTheme(Integer num);

        public abstract Builder alongRouteDayTheme(Integer num);

        public abstract Builder alternateCasingRouteColor(Integer num);

        public abstract Builder alternateRouteColor(Integer num);

        public abstract Builder annotation(List<String> list);

        public abstract DirectionOptions build();

        public abstract Builder continueStraight(Boolean bool);

        public abstract Builder destination(DirectionPoint directionPoint);

        public abstract Builder destinationMarker(Integer num);

        public abstract Builder directionDarkTheme(Integer num);

        public abstract Builder directionDayTheme(Integer num);

        public abstract Builder distanceType(Integer num);

        public abstract Builder excludes(List<String> list);

        abstract Builder firstWayPointMarker(Integer num);

        public abstract Builder geometries(String str);

        public abstract Builder instructions(Boolean bool);

        public abstract Builder isSort(Boolean bool);

        public abstract Builder lessVerbose(Boolean bool);

        public abstract Builder mapplsStyle(String str);

        public abstract Builder origin(DirectionPoint directionPoint);

        public abstract Builder overview(String str);

        public abstract Builder profile(String str);

        public abstract Builder resource(String str);

        public abstract Builder routeReportSummaryBaseUrl(String str);

        public abstract Builder routeType(Integer num);

        public abstract Builder routingBaseUrl(String str);

        public abstract Builder searchAlongRoute(Boolean bool);

        public abstract Builder searchPlaceOption(PlaceOptions placeOptions);

        abstract Builder secondWayPointMarker(Integer num);

        public abstract Builder selectedCasingRouteColor(Integer num);

        public abstract Builder selectedRouteColor(Integer num);

        public abstract Builder showAddWaypointOption(Boolean bool);

        public abstract Builder showAlternative(Boolean bool);

        public abstract Builder showCurrentLocationOnMap(Boolean bool);

        public abstract Builder showDefaultMap(Boolean bool);

        public abstract Builder showHeavyVehicleProfile(Boolean bool);

        public abstract Builder showProfileOption(Boolean bool);

        public abstract Builder showRouteReportSummary(Boolean bool);

        public abstract Builder showRouteReportSummaryOnMap(Boolean bool);

        public abstract Builder showStartNavigation(Boolean bool);

        public abstract Builder showTripCostSummary(Boolean bool);

        public abstract Builder showWalkingProfile(Boolean bool);

        public abstract Builder sourceMarker(Integer num);

        public abstract Builder steps(Boolean bool);

        public abstract Builder theme(Integer num);

        abstract Builder thirdWayPointMarker(Integer num);

        public abstract Builder tripCostEstimationBaseUrl(String str);

        public Builder viaPointMarker(Integer num, Integer num2, Integer num3) {
            return firstWayPointMarker(num).secondWayPointMarker(num2).thirdWayPointMarker(num3);
        }
    }

    public static Builder builder() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(DirectionsCriteria.ANNOTATION_CONGESTION);
        arrayList.add(DirectionsCriteria.ANNOTATION_NODES);
        PlaceOptions.Builder builderBackgroundColor = PlaceOptions.builder().backgroundColor(-1);
        Boolean bool = Boolean.TRUE;
        PlaceOptions placeOptionsBuild = builderBackgroundColor.isShowCurrentLocation(bool).build(2);
        Builder builderIsSort = new b.a().routingBaseUrl(Constants.ADVANCE_MAP_BASE_URL).routeReportSummaryBaseUrl(Constants.EXPLORE_BASE_URL).tripCostEstimationBaseUrl(Constants.EXPLORE_BASE_URL).distanceType(0).showAlternative(bool).continueStraight(bool).resource(DirectionsCriteria.RESOURCE_ROUTE_ETA).annotation(arrayList).isSort(bool);
        Boolean bool2 = Boolean.FALSE;
        return builderIsSort.instructions(bool2).showProfileOption(bool2).searchAlongRoute(bool2).geometries("polyline6").theme(1).showDefaultMap(bool).selectedRouteColor(Integer.valueOf(Color.parseColor("#07b9fc"))).selectedCasingRouteColor(Integer.valueOf(Color.parseColor("#000000"))).alternateRouteColor(Integer.valueOf(Color.parseColor("#a1bbd2"))).alternateCasingRouteColor(Integer.valueOf(Color.parseColor("#000000"))).steps(bool).showAddWaypointOption(bool).searchPlaceOption(placeOptionsBuild).overview("full").profile("driving").showStartNavigation(bool).destinationMarker(Integer.valueOf(R.drawable.mappls_direction_destination_marker)).sourceMarker(Integer.valueOf(R.drawable.mappls_direction_marker_source)).firstWayPointMarker(Integer.valueOf(R.drawable.mappls_direction_marker_via_1)).secondWayPointMarker(Integer.valueOf(R.drawable.mappls_direction_marker_via_2)).thirdWayPointMarker(Integer.valueOf(R.drawable.mappls_direction_marker_via_3)).directionDayTheme(Integer.valueOf(R.style.MapplsDirectionDayTheme)).directionDarkTheme(Integer.valueOf(R.style.MapplsDirectionNightTheme)).alongRouteDayTheme(Integer.valueOf(R.style.MapplsCategoryDayTheme)).alongRouteDarkTheme(Integer.valueOf(R.style.MapplsCategoryDarkTheme)).showRouteReportSummary(bool2).showRouteReportSummaryOnMap(bool2).showTripCostSummary(bool2).showHeavyVehicleProfile(bool).showWalkingProfile(bool).showCurrentLocationOnMap(bool);
    }

    public abstract Integer alongRouteBuffer();

    public abstract Integer alongRouteDarkTheme();

    public abstract Integer alongRouteDayTheme();

    public abstract Integer alternateCasingRouteColor();

    public abstract Integer alternateRouteColor();

    public abstract List<String> annotation();

    public abstract Boolean continueStraight();

    public abstract DirectionPoint destination();

    public abstract Integer destinationMarker();

    public abstract Integer directionDarkTheme();

    public abstract Integer directionDayTheme();

    public abstract Integer distanceType();

    public abstract List<String> excludes();

    public abstract Integer firstWayPointMarker();

    public abstract String geometries();

    public abstract Boolean instructions();

    public abstract Boolean isSort();

    public abstract Boolean lessVerbose();

    public abstract String mapplsStyle();

    public abstract DirectionPoint origin();

    public abstract String overview();

    public abstract String profile();

    public abstract String resource();

    public abstract String routeReportSummaryBaseUrl();

    public abstract Integer routeType();

    public abstract String routingBaseUrl();

    public abstract Boolean searchAlongRoute();

    public abstract PlaceOptions searchPlaceOption();

    public abstract Integer secondWayPointMarker();

    public abstract Integer selectedCasingRouteColor();

    public abstract Integer selectedRouteColor();

    public abstract Boolean showAddWaypointOption();

    public abstract Boolean showAlternative();

    public abstract Boolean showCurrentLocationOnMap();

    public abstract Boolean showDefaultMap();

    public abstract Boolean showHeavyVehicleProfile();

    public abstract Boolean showProfileOption();

    public abstract Boolean showRouteReportSummary();

    public abstract Boolean showRouteReportSummaryOnMap();

    public abstract Boolean showStartNavigation();

    public abstract Boolean showTripCostSummary();

    public abstract Boolean showWalkingProfile();

    public abstract Integer sourceMarker();

    public abstract Boolean steps();

    public abstract Integer theme();

    public abstract Integer thirdWayPointMarker();

    public abstract String tripCostEstimationBaseUrl();
}

package com.mappls.sdk.direction.ui.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.mappls.sdk.plugins.places.autocomplete.model.PlaceOptions;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
final class c extends b {
    public static final Parcelable.Creator<c> CREATOR = new a();

    final class a implements Parcelable.Creator<c> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public final c createFromParcel(Parcel parcel) {
            Boolean boolValueOf;
            Boolean boolValueOf2;
            Boolean boolValueOf3;
            Boolean boolValueOf4;
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            Boolean boolValueOf5 = Boolean.valueOf(parcel.readInt() == 1);
            Boolean boolValueOf6 = Boolean.valueOf(parcel.readInt() == 1);
            Integer numValueOf = Integer.valueOf(parcel.readInt());
            Integer numValueOf2 = Integer.valueOf(parcel.readInt());
            Integer numValueOf3 = Integer.valueOf(parcel.readInt());
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            String string6 = parcel.readString();
            ArrayList arrayList = parcel.readArrayList(DirectionOptions.class.getClassLoader());
            Boolean boolValueOf7 = Boolean.valueOf(parcel.readInt() == 1);
            if (parcel.readInt() == 0) {
                boolValueOf = Boolean.valueOf(parcel.readInt() == 1);
            } else {
                boolValueOf = null;
            }
            ArrayList arrayList2 = parcel.readArrayList(DirectionOptions.class.getClassLoader());
            Integer numValueOf4 = parcel.readInt() == 0 ? Integer.valueOf(parcel.readInt()) : null;
            if (parcel.readInt() == 0) {
                boolValueOf2 = Boolean.valueOf(parcel.readInt() == 1);
            } else {
                boolValueOf2 = null;
            }
            if (parcel.readInt() == 0) {
                boolValueOf3 = Boolean.valueOf(parcel.readInt() == 1);
            } else {
                boolValueOf3 = null;
            }
            String string7 = parcel.readString();
            if (parcel.readInt() == 0) {
                boolValueOf4 = Boolean.valueOf(parcel.readInt() == 1);
            } else {
                boolValueOf4 = null;
            }
            return new c(string, string2, string3, boolValueOf5, boolValueOf6, numValueOf, numValueOf2, numValueOf3, string4, string5, string6, arrayList, boolValueOf7, boolValueOf, arrayList2, numValueOf4, boolValueOf2, boolValueOf3, string7, boolValueOf4, Boolean.valueOf(parcel.readInt() == 1), (PlaceOptions) parcel.readParcelable(DirectionOptions.class.getClassLoader()), (DirectionPoint) parcel.readParcelable(DirectionOptions.class.getClassLoader()), (DirectionPoint) parcel.readParcelable(DirectionOptions.class.getClassLoader()), Boolean.valueOf(parcel.readInt() == 1), Boolean.valueOf(parcel.readInt() == 1), parcel.readInt() == 0 ? Integer.valueOf(parcel.readInt()) : null, Integer.valueOf(parcel.readInt()), Integer.valueOf(parcel.readInt()), Integer.valueOf(parcel.readInt()), Integer.valueOf(parcel.readInt()), Integer.valueOf(parcel.readInt()), Integer.valueOf(parcel.readInt()), Integer.valueOf(parcel.readInt()), Integer.valueOf(parcel.readInt()), Integer.valueOf(parcel.readInt()), Integer.valueOf(parcel.readInt()), Integer.valueOf(parcel.readInt()), Boolean.valueOf(parcel.readInt() == 1), Boolean.valueOf(parcel.readInt() == 1), Boolean.valueOf(parcel.readInt() == 1), Boolean.valueOf(parcel.readInt() == 1), Boolean.valueOf(parcel.readInt() == 1), Boolean.valueOf(parcel.readInt() == 1), parcel.readInt() == 0 ? parcel.readString() : null, Integer.valueOf(parcel.readInt()), Boolean.valueOf(parcel.readInt() == 1));
        }

        @Override // android.os.Parcelable.Creator
        public final c[] newArray(int i) {
            return new c[i];
        }
    }

    c(String str, String str2, String str3, Boolean bool, Boolean bool2, Integer num, Integer num2, Integer num3, String str4, String str5, String str6, List<String> list, Boolean bool3, Boolean bool4, List<String> list2, Integer num4, Boolean bool5, Boolean bool6, String str7, Boolean bool7, Boolean bool8, PlaceOptions placeOptions, DirectionPoint directionPoint, DirectionPoint directionPoint2, Boolean bool9, Boolean bool10, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Integer num13, Integer num14, Integer num15, Integer num16, Boolean bool11, Boolean bool12, Boolean bool13, Boolean bool14, Boolean bool15, Boolean bool16, String str8, Integer num17, Boolean bool17) {
        super(str, str2, str3, bool, bool2, num, num2, num3, str4, str5, str6, list, bool3, bool4, list2, num4, bool5, bool6, str7, bool7, bool8, placeOptions, directionPoint, directionPoint2, bool9, bool10, num5, num6, num7, num8, num9, num10, num11, num12, num13, num14, num15, num16, bool11, bool12, bool13, bool14, bool15, bool16, str8, num17, bool17);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(routingBaseUrl());
        parcel.writeString(routeReportSummaryBaseUrl());
        parcel.writeString(tripCostEstimationBaseUrl());
        parcel.writeInt(showProfileOption().booleanValue() ? 1 : 0);
        parcel.writeInt(showAlternative().booleanValue() ? 1 : 0);
        parcel.writeInt(theme().intValue());
        parcel.writeInt(directionDayTheme().intValue());
        parcel.writeInt(directionDarkTheme().intValue());
        parcel.writeString(resource());
        parcel.writeString(profile());
        parcel.writeString(overview());
        parcel.writeList(annotation());
        parcel.writeInt(steps().booleanValue() ? 1 : 0);
        if (isSort() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeInt(isSort().booleanValue() ? 1 : 0);
        }
        parcel.writeList(excludes());
        if (routeType() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeInt(routeType().intValue());
        }
        if (lessVerbose() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeInt(lessVerbose().booleanValue() ? 1 : 0);
        }
        if (continueStraight() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeInt(continueStraight().booleanValue() ? 1 : 0);
        }
        parcel.writeString(geometries());
        if (instructions() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeInt(instructions().booleanValue() ? 1 : 0);
        }
        parcel.writeInt(showStartNavigation().booleanValue() ? 1 : 0);
        parcel.writeParcelable(searchPlaceOption(), i);
        parcel.writeParcelable(destination(), i);
        parcel.writeParcelable(origin(), i);
        parcel.writeInt(showDefaultMap().booleanValue() ? 1 : 0);
        parcel.writeInt(searchAlongRoute().booleanValue() ? 1 : 0);
        if (alongRouteBuffer() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeInt(alongRouteBuffer().intValue());
        }
        parcel.writeInt(alongRouteDayTheme().intValue());
        parcel.writeInt(alongRouteDarkTheme().intValue());
        parcel.writeInt(selectedRouteColor().intValue());
        parcel.writeInt(selectedCasingRouteColor().intValue());
        parcel.writeInt(alternateRouteColor().intValue());
        parcel.writeInt(alternateCasingRouteColor().intValue());
        parcel.writeInt(destinationMarker().intValue());
        parcel.writeInt(sourceMarker().intValue());
        parcel.writeInt(firstWayPointMarker().intValue());
        parcel.writeInt(secondWayPointMarker().intValue());
        parcel.writeInt(thirdWayPointMarker().intValue());
        parcel.writeInt(showAddWaypointOption().booleanValue() ? 1 : 0);
        parcel.writeInt(showRouteReportSummary().booleanValue() ? 1 : 0);
        parcel.writeInt(showRouteReportSummaryOnMap().booleanValue() ? 1 : 0);
        parcel.writeInt(showTripCostSummary().booleanValue() ? 1 : 0);
        parcel.writeInt(showHeavyVehicleProfile().booleanValue() ? 1 : 0);
        parcel.writeInt(showWalkingProfile().booleanValue() ? 1 : 0);
        if (mapplsStyle() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(mapplsStyle());
        }
        parcel.writeInt(distanceType().intValue());
        parcel.writeInt(showCurrentLocationOnMap().booleanValue() ? 1 : 0);
    }
}

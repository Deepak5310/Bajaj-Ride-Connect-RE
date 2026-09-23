package com.mappls.sdk.plugins.places.autocomplete.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.mappls.sdk.geojson.Point;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
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
            Point point = parcel.readInt() == 0 ? (Point) parcel.readSerializable() : null;
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            Boolean boolValueOf4 = Boolean.valueOf(parcel.readInt() == 1);
            String string4 = parcel.readInt() == 0 ? parcel.readString() : null;
            int i = parcel.readInt();
            Integer numValueOf = parcel.readInt() == 0 ? Integer.valueOf(parcel.readInt()) : null;
            Integer numValueOf2 = parcel.readInt() == 0 ? Integer.valueOf(parcel.readInt()) : null;
            Double dValueOf = parcel.readInt() == 0 ? Double.valueOf(parcel.readDouble()) : null;
            Boolean boolValueOf5 = Boolean.valueOf(parcel.readInt() == 1);
            Boolean boolValueOf6 = Boolean.valueOf(parcel.readInt() == 1);
            String string5 = parcel.readInt() == 0 ? parcel.readString() : null;
            if (parcel.readInt() == 0) {
                boolValueOf = Boolean.valueOf(parcel.readInt() == 1);
            } else {
                boolValueOf = null;
            }
            ArrayList arrayList = parcel.readArrayList(PlaceOptions.class.getClassLoader());
            int i2 = parcel.readInt();
            int i3 = parcel.readInt();
            int i4 = parcel.readInt();
            int i5 = parcel.readInt();
            int i6 = parcel.readInt();
            int i7 = parcel.readInt();
            int i8 = parcel.readInt();
            int i9 = parcel.readInt();
            int i10 = parcel.readInt();
            int i11 = parcel.readInt();
            int i12 = parcel.readInt();
            Integer numValueOf3 = parcel.readInt() == 0 ? Integer.valueOf(parcel.readInt()) : null;
            Boolean boolValueOf7 = Boolean.valueOf(parcel.readInt() == 1);
            Integer numValueOf4 = Integer.valueOf(parcel.readInt());
            int i13 = parcel.readInt();
            int i14 = parcel.readInt();
            int i15 = parcel.readInt();
            int i16 = parcel.readInt();
            int i17 = parcel.readInt();
            Integer numValueOf5 = Integer.valueOf(parcel.readInt());
            String string6 = parcel.readInt() == 0 ? parcel.readString() : null;
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
            return new c(point, string, string2, string3, boolValueOf4, string4, i, numValueOf, numValueOf2, dValueOf, boolValueOf5, boolValueOf6, string5, boolValueOf, arrayList, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, numValueOf3, boolValueOf7, numValueOf4, i13, i14, i15, i16, i17, numValueOf5, string6, boolValueOf2, boolValueOf3, Boolean.valueOf(parcel.readInt() == 1), Integer.valueOf(parcel.readInt()), Integer.valueOf(parcel.readInt()), Integer.valueOf(parcel.readInt()), Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? Integer.valueOf(parcel.readInt()) : null);
        }

        @Override // android.os.Parcelable.Creator
        public final c[] newArray(int i) {
            return new c[i];
        }
    }

    c(Point point, String str, String str2, String str3, Boolean bool, String str4, int i, Integer num, Integer num2, Double d, Boolean bool2, Boolean bool3, String str5, Boolean bool4, List<String> list, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, Integer num3, Boolean bool5, Integer num4, int i13, int i14, int i15, int i16, int i17, Integer num5, String str6, Boolean bool6, Boolean bool7, Boolean bool8, Integer num6, Integer num7, Integer num8, Integer num9, String str7, Integer num10) {
        super(point, str, str2, str3, bool, str4, i, num, num2, d, bool2, bool3, str5, bool4, list, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, num3, bool5, num4, i13, i14, i15, i16, i17, num5, str6, bool6, bool7, bool8, num6, num7, num8, num9, str7, num10);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        if (location() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeSerializable(location());
        }
        parcel.writeString(autoSuggestBaseUrl());
        parcel.writeString(textSearchBaseUrl());
        parcel.writeString(feedbackBaseUrl());
        parcel.writeInt(userAddedLocationEnable().booleanValue() ? 1 : 0);
        if (filter() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(filter());
        }
        parcel.writeInt(limit());
        if (historyCount() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeInt(historyCount().intValue());
        }
        if (favoriteCount() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeInt(favoriteCount().intValue());
        }
        if (zoom() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeDouble(zoom().doubleValue());
        }
        parcel.writeInt(saveHistory().booleanValue() ? 1 : 0);
        parcel.writeInt(enableTextSearch().booleanValue() ? 1 : 0);
        if (pod() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(pod());
        }
        if (tokenizeAddress() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeInt(tokenizeAddress().booleanValue() ? 1 : 0);
        }
        parcel.writeList(injectedPlaces());
        parcel.writeInt(viewMode());
        parcel.writeInt(backgroundColor());
        parcel.writeInt(resultBackgroundColor());
        parcel.writeInt(placeNameTextColor());
        parcel.writeInt(addressTextColor());
        parcel.writeInt(savedPlaceNameTextColor());
        parcel.writeInt(favoritePlaceNameTextColor());
        parcel.writeInt(distanceTextColor());
        parcel.writeInt(errorBackgroundColor());
        parcel.writeInt(errorTextColor());
        parcel.writeInt(toolbarColor());
        if (statusBarColor() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeInt(statusBarColor().intValue());
        }
        parcel.writeInt(showPoweredByText().booleanValue() ? 1 : 0);
        parcel.writeInt(poweredByTextColor().intValue());
        parcel.writeInt(toolbarTintColor());
        parcel.writeInt(attributionVerticalAlignment());
        parcel.writeInt(attributionHorizontalAlignment());
        parcel.writeInt(attributionBackgroundColor());
        parcel.writeInt(logoSize());
        parcel.writeInt(internalMinCharactersForSearch().intValue());
        if (hint() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(hint());
        }
        if (hyperLocal() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeInt(hyperLocal().booleanValue() ? 1 : 0);
        }
        if (bridge() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeInt(bridge().booleanValue() ? 1 : 0);
        }
        parcel.writeInt(isShowCurrentLocation().booleanValue() ? 1 : 0);
        parcel.writeInt(currentLocationTextColor().intValue());
        parcel.writeInt(currentLocationBackground().intValue());
        parcel.writeInt(internalDebounce().intValue());
        parcel.writeInt(currentLocationIcon().intValue());
        if (responseLang() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(responseLang());
        }
        if (hintColor() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeInt(hintColor().intValue());
        }
    }
}

package com.mappls.sdk.plugins.places.autocomplete.model;

import android.graphics.Color;
import android.os.Parcelable;
import androidx.core.view.ViewCompat;
import com.google.android.gms.common.ConnectionResult;
import com.google.gson.Gson;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.plugins.places.R;
import com.mappls.sdk.services.utils.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class PlaceOptions implements Parcelable {
    public static final int GRAVITY_BOTTOM = 7;
    public static final int GRAVITY_CENTER = 4;
    public static final int GRAVITY_LEFT = 3;
    public static final int GRAVITY_RIGHT = 5;
    public static final int GRAVITY_TOP = 6;
    public static final int MODE_CARDS = 2;
    public static final int MODE_FULLSCREEN = 1;
    public static final int SIZE_LARGE = 10;
    public static final int SIZE_MEDIUM = 9;
    public static final int SIZE_SMALL = 8;

    public static abstract class Builder {
        private List<String> countries = new ArrayList();
        private Integer debounceValue = 0;

        public abstract Builder addressTextColor(int i);

        public abstract Builder attributionBackgroundColor(int i);

        public abstract Builder attributionHorizontalAlignment(int i);

        public abstract Builder attributionVerticalAlignment(int i);

        abstract PlaceOptions autoBuild();

        public abstract Builder autoSuggestBaseUrl(String str);

        public abstract Builder backgroundColor(int i);

        public abstract Builder bridge(Boolean bool);

        public PlaceOptions build() {
            return build(1);
        }

        public PlaceOptions build(int i) {
            int iValueOf;
            viewMode(i);
            if (this.debounceValue.intValue() >= 0) {
                iValueOf = this.debounceValue.intValue() > 1500 ? Integer.valueOf(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED) : 0;
                internalDebounce(this.debounceValue);
                return autoBuild();
            }
            this.debounceValue = iValueOf;
            internalDebounce(this.debounceValue);
            return autoBuild();
        }

        public abstract Builder currentLocationBackground(Integer num);

        public abstract Builder currentLocationIcon(Integer num);

        public abstract Builder currentLocationTextColor(Integer num);

        public Builder debounce(Integer num) {
            this.debounceValue = num;
            return this;
        }

        public abstract Builder distanceTextColor(int i);

        public abstract Builder enableTextSearch(Boolean bool);

        public abstract Builder errorBackgroundColor(int i);

        public abstract Builder errorTextColor(int i);

        public abstract Builder favoriteCount(Integer num);

        public abstract Builder favoritePlaceNameTextColor(int i);

        public Builder favoritePlaces(List<MapplsFavoritePlace> list) {
            ArrayList arrayList = new ArrayList();
            Iterator<MapplsFavoritePlace> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList.add(new Gson().toJson(it2.next()));
            }
            return injectedPlaces(arrayList);
        }

        public abstract Builder feedbackBaseUrl(String str);

        public abstract Builder filter(String str);

        public abstract Builder hint(String str);

        public abstract Builder hintColor(Integer num);

        public abstract Builder historyCount(Integer num);

        public abstract Builder hyperLocal(Boolean bool);

        abstract Builder injectedPlaces(List<String> list);

        abstract Builder internalDebounce(Integer num);

        public abstract Builder internalMinCharactersForSearch(Integer num);

        public abstract Builder isShowCurrentLocation(Boolean bool);

        public abstract Builder limit(int i);

        public abstract Builder location(Point point);

        public abstract Builder logoSize(int i);

        public Builder minCharactersForSearch(Integer num) {
            return num.intValue() < 2 ? internalMinCharactersForSearch(3) : internalMinCharactersForSearch(num);
        }

        public abstract Builder placeNameTextColor(int i);

        public abstract Builder pod(String str);

        public abstract Builder poweredByTextColor(Integer num);

        public abstract Builder responseLang(String str);

        public abstract Builder resultBackgroundColor(int i);

        public abstract Builder saveHistory(Boolean bool);

        public abstract Builder savedPlaceNameTextColor(int i);

        public abstract Builder showPoweredByText(Boolean bool);

        public abstract Builder statusBarColor(Integer num);

        public abstract Builder textSearchBaseUrl(String str);

        public abstract Builder tokenizeAddress(Boolean bool);

        public abstract Builder toolbarColor(int i);

        public abstract Builder toolbarTintColor(int i);

        public abstract Builder userAddedLocationEnable(Boolean bool);

        abstract Builder viewMode(int i);

        public abstract Builder zoom(Double d);
    }

    public static Builder builder() {
        Builder builder = new b.a().autoSuggestBaseUrl(Constants.ATLAS_BASE_URL).textSearchBaseUrl(Constants.ATLAS_BASE_URL).feedbackBaseUrl(Constants.ATLAS_BASE_URL).backgroundColor(0).resultBackgroundColor(-1).placeNameTextColor(Color.parseColor("#263d57")).addressTextColor(Color.parseColor("#949fac")).distanceTextColor(Color.parseColor("#949fac")).errorBackgroundColor(-1).errorTextColor(Color.parseColor("#4a90e2")).favoritePlaceNameTextColor(Color.parseColor("#263d57")).savedPlaceNameTextColor(Color.parseColor("#4a90e2")).toolbarColor(-1);
        Boolean bool = Boolean.FALSE;
        return builder.userAddedLocationEnable(bool).toolbarTintColor(ViewCompat.MEASURED_STATE_MASK).enableTextSearch(bool).debounce(0).saveHistory(bool).showPoweredByText(Boolean.TRUE).poweredByTextColor(Integer.valueOf(ViewCompat.MEASURED_STATE_MASK)).favoriteCount(2).logoSize(9).minCharactersForSearch(3).attributionHorizontalAlignment(6).attributionBackgroundColor(-1).attributionVerticalAlignment(3).isShowCurrentLocation(bool).currentLocationTextColor(Integer.valueOf(Color.parseColor("#263d57"))).currentLocationBackground(-1).currentLocationIcon(Integer.valueOf(R.drawable.mappls_search_my_location)).limit(20);
    }

    public abstract int addressTextColor();

    public abstract int attributionBackgroundColor();

    public abstract int attributionHorizontalAlignment();

    public abstract int attributionVerticalAlignment();

    public abstract String autoSuggestBaseUrl();

    public abstract int backgroundColor();

    public abstract Boolean bridge();

    public abstract Integer currentLocationBackground();

    public abstract Integer currentLocationIcon();

    public abstract Integer currentLocationTextColor();

    public abstract int distanceTextColor();

    public abstract Boolean enableTextSearch();

    public abstract int errorBackgroundColor();

    public abstract int errorTextColor();

    public abstract Integer favoriteCount();

    public abstract int favoritePlaceNameTextColor();

    public abstract String feedbackBaseUrl();

    public abstract String filter();

    public abstract String hint();

    public abstract Integer hintColor();

    public abstract Integer historyCount();

    public abstract Boolean hyperLocal();

    public abstract List<String> injectedPlaces();

    public abstract Integer internalDebounce();

    public abstract Integer internalMinCharactersForSearch();

    public abstract Boolean isShowCurrentLocation();

    public abstract int limit();

    public abstract Point location();

    public abstract int logoSize();

    public abstract int placeNameTextColor();

    public abstract String pod();

    public abstract Integer poweredByTextColor();

    public abstract String responseLang();

    public abstract int resultBackgroundColor();

    public abstract Boolean saveHistory();

    public abstract int savedPlaceNameTextColor();

    public abstract Boolean showPoweredByText();

    public abstract Integer statusBarColor();

    public abstract String textSearchBaseUrl();

    public abstract Boolean tokenizeAddress();

    public abstract int toolbarColor();

    public abstract int toolbarTintColor();

    public abstract Boolean userAddedLocationEnable();

    public abstract int viewMode();

    public abstract Double zoom();
}

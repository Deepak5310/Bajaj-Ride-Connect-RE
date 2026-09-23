package com.mappls.sdk.category.model;

import android.os.Parcelable;

/* JADX INFO: loaded from: classes6.dex */
public abstract class SearchCategoryOption implements Parcelable {
    public static final int NEARBY_SEARCH = 0;
    public static final int POI_ALONG_ROUTE_SEARCH = 1;

    public static abstract class Builder {
        public abstract Builder bounds(String str);

        public abstract Builder buffer(Integer num);

        public abstract SearchCategoryOption build();

        public abstract Builder explain(Boolean bool);

        public abstract Builder filter(String str);

        public abstract Builder geometries(String str);

        public abstract Builder isSort(Boolean bool);

        public abstract Builder isUsingInternalMap(Boolean bool);

        public Builder location(double d, double d2) {
            return location(d + "," + d2);
        }

        public abstract Builder location(String str);

        public abstract Builder maxSelectionCount(Integer num);

        public abstract Builder page(Integer num);

        public abstract Builder path(String str);

        public abstract Builder pod(String str);

        public abstract Builder radius(Integer num);

        public abstract Builder richData(Boolean bool);

        public abstract Builder searchBy(String str);

        public abstract Builder searchType(Integer num);

        public abstract Builder showRequestOnMap(Boolean bool);

        public abstract Builder sortBy(String str);

        public abstract Builder userName(String str);
    }

    public static Builder builder() {
        Builder builderSearchType = new b.a().maxSelectionCount(1).radius(1000).geometries("polyline6").searchType(1);
        Boolean bool = Boolean.TRUE;
        return builderSearchType.isUsingInternalMap(bool).showRequestOnMap(bool);
    }

    public abstract String bounds();

    public abstract Integer buffer();

    public abstract Boolean explain();

    public abstract String filter();

    public abstract String geometries();

    public abstract Boolean isSort();

    public abstract Boolean isUsingInternalMap();

    public abstract String location();

    public abstract Integer maxSelectionCount();

    public abstract Integer page();

    public abstract String path();

    public abstract String pod();

    public abstract Integer radius();

    public abstract Boolean richData();

    public abstract String searchBy();

    public abstract Integer searchType();

    public abstract Boolean showRequestOnMap();

    public abstract String sortBy();

    public abstract String userName();
}

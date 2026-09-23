package com.mappls.sdk.geoanalytics;

import com.mappls.sdk.services.utils.MapplsUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public abstract class MapplsGeoAnalyticsRequest {

    public static abstract class Builder {
        public abstract Builder attribute(String str);

        public abstract MapplsGeoAnalyticsRequest build();

        public Builder geoBound(String... strArr) {
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                arrayList.add(str);
            }
            return geoBoundList(arrayList);
        }

        abstract Builder geoBoundList(List<String> list);

        public abstract Builder geoboundType(String str);

        abstract Builder propertyNames(String str);

        public Builder propertyNames(String... strArr) {
            return propertyNames(MapplsUtils.join(",", strArr));
        }

        public abstract Builder query(String str);

        public abstract Builder style(GeoAnalyticsAppearanceOption geoAnalyticsAppearanceOption);

        public abstract Builder transparent(Boolean bool);
    }

    public static Builder builder() {
        return new b.C0079b().style(new GeoAnalyticsAppearanceOption()).transparent(Boolean.TRUE);
    }

    abstract String attribute();

    abstract List<String> geoBoundList();

    abstract String geoboundType();

    abstract String propertyNames();

    abstract String query();

    abstract GeoAnalyticsAppearanceOption style();

    abstract Boolean transparent();
}

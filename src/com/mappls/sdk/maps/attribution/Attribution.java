package com.mappls.sdk.maps.attribution;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class Attribution {
    static final List<String> IMPROVE_MAP_URLS;
    static final String MAPPLS_URL = "https://about.mappls.com/";
    private static final String OPENSTREETMAP = "OpenStreetMap";
    private static final String OPENSTREETMAP_ABBR = "Open Street Map";
    private String title;
    private String url;

    static {
        ArrayList arrayList = new ArrayList();
        IMPROVE_MAP_URLS = arrayList;
        arrayList.add("https://www.mappls.com/feedback/");
        arrayList.add("https://www.mappls.com/map-feedback/");
        arrayList.add("https://apps.mappls.com/feedback/");
    }

    Attribution(String str, String str2) {
        this.title = str;
        this.url = str2;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTitleAbbreviated() {
        if (this.title.equals(OPENSTREETMAP)) {
            return OPENSTREETMAP_ABBR;
        }
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Attribution attribution = (Attribution) obj;
        String str = this.title;
        if (str == null ? attribution.title != null : !str.equals(attribution.title)) {
            return false;
        }
        String str2 = this.url;
        String str3 = attribution.url;
        if (str2 != null) {
            return str2.equals(str3);
        }
        return str3 == null;
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.url;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }
}

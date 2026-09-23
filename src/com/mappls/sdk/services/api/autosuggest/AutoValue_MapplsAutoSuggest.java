package com.mappls.sdk.services.api.autosuggest;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsAutoSuggest extends MapplsAutoSuggest {
    private final String baseUrl;
    private final Boolean bridge;
    private final Boolean explain;
    private final String filter;
    private final Boolean hyperLocal;
    private final String internalQuery;
    private final Double internalZoom;
    private final String isPrimary;
    private final String location;
    private final String mapCentre;
    private final String pod;
    private final String responseLang;
    private final Boolean tokenizeAddress;

    private AutoValue_MapplsAutoSuggest(String str, String str2, String str3, Double d, Boolean bool, String str4, String str5, Boolean bool2, Boolean bool3, String str6, String str7, Boolean bool4, String str8) {
        this.baseUrl = str;
        this.internalQuery = str2;
        this.location = str3;
        this.internalZoom = d;
        this.tokenizeAddress = bool;
        this.pod = str4;
        this.filter = str5;
        this.bridge = bool2;
        this.hyperLocal = bool3;
        this.mapCentre = str6;
        this.isPrimary = str7;
        this.explain = bool4;
        this.responseLang = str8;
    }

    @Override // com.mappls.sdk.services.api.autosuggest.MapplsAutoSuggest, com.mappls.sdk.services.api.MapplsService
    public String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mappls.sdk.services.api.autosuggest.MapplsAutoSuggest
    public String internalQuery() {
        return this.internalQuery;
    }

    @Override // com.mappls.sdk.services.api.autosuggest.MapplsAutoSuggest
    public String location() {
        return this.location;
    }

    @Override // com.mappls.sdk.services.api.autosuggest.MapplsAutoSuggest
    public Double internalZoom() {
        return this.internalZoom;
    }

    @Override // com.mappls.sdk.services.api.autosuggest.MapplsAutoSuggest
    public Boolean tokenizeAddress() {
        return this.tokenizeAddress;
    }

    @Override // com.mappls.sdk.services.api.autosuggest.MapplsAutoSuggest
    public String pod() {
        return this.pod;
    }

    @Override // com.mappls.sdk.services.api.autosuggest.MapplsAutoSuggest
    public String filter() {
        return this.filter;
    }

    @Override // com.mappls.sdk.services.api.autosuggest.MapplsAutoSuggest
    public Boolean bridge() {
        return this.bridge;
    }

    @Override // com.mappls.sdk.services.api.autosuggest.MapplsAutoSuggest
    public Boolean hyperLocal() {
        return this.hyperLocal;
    }

    @Override // com.mappls.sdk.services.api.autosuggest.MapplsAutoSuggest
    public String mapCentre() {
        return this.mapCentre;
    }

    @Override // com.mappls.sdk.services.api.autosuggest.MapplsAutoSuggest
    public String isPrimary() {
        return this.isPrimary;
    }

    @Override // com.mappls.sdk.services.api.autosuggest.MapplsAutoSuggest
    public Boolean explain() {
        return this.explain;
    }

    @Override // com.mappls.sdk.services.api.autosuggest.MapplsAutoSuggest
    public String responseLang() {
        return this.responseLang;
    }

    public String toString() {
        return "MapplsAutoSuggest{baseUrl=" + this.baseUrl + ", internalQuery=" + this.internalQuery + ", location=" + this.location + ", internalZoom=" + this.internalZoom + ", tokenizeAddress=" + this.tokenizeAddress + ", pod=" + this.pod + ", filter=" + this.filter + ", bridge=" + this.bridge + ", hyperLocal=" + this.hyperLocal + ", mapCentre=" + this.mapCentre + ", isPrimary=" + this.isPrimary + ", explain=" + this.explain + ", responseLang=" + this.responseLang + "}";
    }

    public boolean equals(Object obj) {
        String str;
        Double d;
        Boolean bool;
        String str2;
        String str3;
        Boolean bool2;
        Boolean bool3;
        String str4;
        String str5;
        Boolean bool4;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsAutoSuggest)) {
            return false;
        }
        MapplsAutoSuggest mapplsAutoSuggest = (MapplsAutoSuggest) obj;
        if (this.baseUrl.equals(mapplsAutoSuggest.baseUrl()) && this.internalQuery.equals(mapplsAutoSuggest.internalQuery()) && ((str = this.location) != null ? str.equals(mapplsAutoSuggest.location()) : mapplsAutoSuggest.location() == null) && ((d = this.internalZoom) != null ? d.equals(mapplsAutoSuggest.internalZoom()) : mapplsAutoSuggest.internalZoom() == null) && ((bool = this.tokenizeAddress) != null ? bool.equals(mapplsAutoSuggest.tokenizeAddress()) : mapplsAutoSuggest.tokenizeAddress() == null) && ((str2 = this.pod) != null ? str2.equals(mapplsAutoSuggest.pod()) : mapplsAutoSuggest.pod() == null) && ((str3 = this.filter) != null ? str3.equals(mapplsAutoSuggest.filter()) : mapplsAutoSuggest.filter() == null) && ((bool2 = this.bridge) != null ? bool2.equals(mapplsAutoSuggest.bridge()) : mapplsAutoSuggest.bridge() == null) && ((bool3 = this.hyperLocal) != null ? bool3.equals(mapplsAutoSuggest.hyperLocal()) : mapplsAutoSuggest.hyperLocal() == null) && ((str4 = this.mapCentre) != null ? str4.equals(mapplsAutoSuggest.mapCentre()) : mapplsAutoSuggest.mapCentre() == null) && ((str5 = this.isPrimary) != null ? str5.equals(mapplsAutoSuggest.isPrimary()) : mapplsAutoSuggest.isPrimary() == null) && ((bool4 = this.explain) != null ? bool4.equals(mapplsAutoSuggest.explain()) : mapplsAutoSuggest.explain() == null)) {
            String str6 = this.responseLang;
            if (str6 == null) {
                if (mapplsAutoSuggest.responseLang() == null) {
                    return true;
                }
            } else if (str6.equals(mapplsAutoSuggest.responseLang())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((this.baseUrl.hashCode() ^ 1000003) * 1000003) ^ this.internalQuery.hashCode()) * 1000003;
        String str = this.location;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        Double d = this.internalZoom;
        int iHashCode3 = (iHashCode2 ^ (d == null ? 0 : d.hashCode())) * 1000003;
        Boolean bool = this.tokenizeAddress;
        int iHashCode4 = (iHashCode3 ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        String str2 = this.pod;
        int iHashCode5 = (iHashCode4 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.filter;
        int iHashCode6 = (iHashCode5 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        Boolean bool2 = this.bridge;
        int iHashCode7 = (iHashCode6 ^ (bool2 == null ? 0 : bool2.hashCode())) * 1000003;
        Boolean bool3 = this.hyperLocal;
        int iHashCode8 = (iHashCode7 ^ (bool3 == null ? 0 : bool3.hashCode())) * 1000003;
        String str4 = this.mapCentre;
        int iHashCode9 = (iHashCode8 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.isPrimary;
        int iHashCode10 = (iHashCode9 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        Boolean bool4 = this.explain;
        int iHashCode11 = (iHashCode10 ^ (bool4 == null ? 0 : bool4.hashCode())) * 1000003;
        String str6 = this.responseLang;
        return iHashCode11 ^ (str6 != null ? str6.hashCode() : 0);
    }

    static final class Builder extends MapplsAutoSuggest.Builder {
        private String baseUrl;
        private Boolean bridge;
        private Boolean explain;
        private String filter;
        private Boolean hyperLocal;
        private String internalQuery;
        private Double internalZoom;
        private String isPrimary;
        private String location;
        private String mapCentre;
        private String pod;
        private String responseLang;
        private Boolean tokenizeAddress;

        Builder() {
        }

        @Override // com.mappls.sdk.services.api.autosuggest.MapplsAutoSuggest.Builder
        public MapplsAutoSuggest.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.autosuggest.MapplsAutoSuggest.Builder
        MapplsAutoSuggest.Builder internalQuery(String str) {
            if (str == null) {
                throw new NullPointerException("Null internalQuery");
            }
            this.internalQuery = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.autosuggest.MapplsAutoSuggest.Builder
        MapplsAutoSuggest.Builder location(String str) {
            this.location = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.autosuggest.MapplsAutoSuggest.Builder
        MapplsAutoSuggest.Builder internalZoom(Double d) {
            this.internalZoom = d;
            return this;
        }

        @Override // com.mappls.sdk.services.api.autosuggest.MapplsAutoSuggest.Builder
        public MapplsAutoSuggest.Builder tokenizeAddress(Boolean bool) {
            this.tokenizeAddress = bool;
            return this;
        }

        @Override // com.mappls.sdk.services.api.autosuggest.MapplsAutoSuggest.Builder
        public MapplsAutoSuggest.Builder pod(String str) {
            this.pod = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.autosuggest.MapplsAutoSuggest.Builder
        public MapplsAutoSuggest.Builder filter(String str) {
            this.filter = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.autosuggest.MapplsAutoSuggest.Builder
        public MapplsAutoSuggest.Builder bridge(Boolean bool) {
            this.bridge = bool;
            return this;
        }

        @Override // com.mappls.sdk.services.api.autosuggest.MapplsAutoSuggest.Builder
        public MapplsAutoSuggest.Builder hyperLocal(Boolean bool) {
            this.hyperLocal = bool;
            return this;
        }

        @Override // com.mappls.sdk.services.api.autosuggest.MapplsAutoSuggest.Builder
        MapplsAutoSuggest.Builder mapCentre(String str) {
            this.mapCentre = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.autosuggest.MapplsAutoSuggest.Builder
        public MapplsAutoSuggest.Builder isPrimary(String str) {
            this.isPrimary = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.autosuggest.MapplsAutoSuggest.Builder
        public MapplsAutoSuggest.Builder explain(Boolean bool) {
            this.explain = bool;
            return this;
        }

        @Override // com.mappls.sdk.services.api.autosuggest.MapplsAutoSuggest.Builder
        public MapplsAutoSuggest.Builder responseLang(String str) {
            this.responseLang = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.autosuggest.MapplsAutoSuggest.Builder
        MapplsAutoSuggest autoBuild() {
            if (this.baseUrl == null || this.internalQuery == null) {
                StringBuilder sb = new StringBuilder();
                if (this.baseUrl == null) {
                    sb.append(" baseUrl");
                }
                if (this.internalQuery == null) {
                    sb.append(" internalQuery");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_MapplsAutoSuggest(this.baseUrl, this.internalQuery, this.location, this.internalZoom, this.tokenizeAddress, this.pod, this.filter, this.bridge, this.hyperLocal, this.mapCentre, this.isPrimary, this.explain, this.responseLang);
        }
    }
}

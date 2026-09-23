package com.mappls.sdk.maps;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsGetStyle extends MapplsGetStyle {
    private final String baseUrl;
    private final String logoResolution;

    private AutoValue_MapplsGetStyle(String str, String str2) {
        this.baseUrl = str;
        this.logoResolution = str2;
    }

    @Override // com.mappls.sdk.maps.MapplsGetStyle, com.mappls.sdk.services.api.MapplsService
    protected String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mappls.sdk.maps.MapplsGetStyle
    protected String logoResolution() {
        return this.logoResolution;
    }

    public String toString() {
        return "MapplsGetStyle{baseUrl=" + this.baseUrl + ", logoResolution=" + this.logoResolution + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsGetStyle)) {
            return false;
        }
        MapplsGetStyle mapplsGetStyle = (MapplsGetStyle) obj;
        return this.baseUrl.equals(mapplsGetStyle.baseUrl()) && this.logoResolution.equals(mapplsGetStyle.logoResolution());
    }

    public int hashCode() {
        return ((this.baseUrl.hashCode() ^ 1000003) * 1000003) ^ this.logoResolution.hashCode();
    }

    static final class Builder extends MapplsGetStyle.Builder {
        private String baseUrl;
        private String logoResolution;

        Builder() {
        }

        @Override // com.mappls.sdk.maps.MapplsGetStyle.Builder
        public MapplsGetStyle.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.maps.MapplsGetStyle.Builder
        public MapplsGetStyle.Builder logoResolution(String str) {
            if (str == null) {
                throw new NullPointerException("Null logoResolution");
            }
            this.logoResolution = str;
            return this;
        }

        @Override // com.mappls.sdk.maps.MapplsGetStyle.Builder
        MapplsGetStyle autoBuild() {
            String str;
            if (this.baseUrl != null) {
                str = "";
            } else {
                str = " baseUrl";
            }
            if (this.logoResolution == null) {
                str = str + " logoResolution";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_MapplsGetStyle(this.baseUrl, this.logoResolution);
        }
    }
}

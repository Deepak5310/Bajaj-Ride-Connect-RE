package com.mappls.sdk.services.api.placedetail;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsPlaceDetail extends MapplsPlaceDetail {
    private final String baseUrl;
    private final String mapplsPin;

    private AutoValue_MapplsPlaceDetail(String str, String str2) {
        this.baseUrl = str;
        this.mapplsPin = str2;
    }

    @Override // com.mappls.sdk.services.api.placedetail.MapplsPlaceDetail, com.mappls.sdk.services.api.MapplsService
    protected String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mappls.sdk.services.api.placedetail.MapplsPlaceDetail
    String mapplsPin() {
        return this.mapplsPin;
    }

    public String toString() {
        return "MapplsPlaceDetail{baseUrl=" + this.baseUrl + ", mapplsPin=" + this.mapplsPin + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsPlaceDetail)) {
            return false;
        }
        MapplsPlaceDetail mapplsPlaceDetail = (MapplsPlaceDetail) obj;
        return this.baseUrl.equals(mapplsPlaceDetail.baseUrl()) && this.mapplsPin.equals(mapplsPlaceDetail.mapplsPin());
    }

    public int hashCode() {
        return ((this.baseUrl.hashCode() ^ 1000003) * 1000003) ^ this.mapplsPin.hashCode();
    }

    static final class Builder extends MapplsPlaceDetail.Builder {
        private String baseUrl;
        private String mapplsPin;

        Builder() {
        }

        @Override // com.mappls.sdk.services.api.placedetail.MapplsPlaceDetail.Builder
        public MapplsPlaceDetail.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.placedetail.MapplsPlaceDetail.Builder
        public MapplsPlaceDetail.Builder mapplsPin(String str) {
            if (str == null) {
                throw new NullPointerException("Null mapplsPin");
            }
            this.mapplsPin = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.placedetail.MapplsPlaceDetail.Builder
        MapplsPlaceDetail autoBuild() {
            if (this.baseUrl == null || this.mapplsPin == null) {
                StringBuilder sb = new StringBuilder();
                if (this.baseUrl == null) {
                    sb.append(" baseUrl");
                }
                if (this.mapplsPin == null) {
                    sb.append(" mapplsPin");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_MapplsPlaceDetail(this.baseUrl, this.mapplsPin);
        }
    }
}

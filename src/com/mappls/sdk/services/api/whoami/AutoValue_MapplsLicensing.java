package com.mappls.sdk.services.api.whoami;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsLicensing extends MapplsLicensing {
    private final String baseUrl;
    private final String deviceId;

    private AutoValue_MapplsLicensing(String str, String str2) {
        this.baseUrl = str;
        this.deviceId = str2;
    }

    @Override // com.mappls.sdk.services.api.whoami.MapplsLicensing, com.mappls.sdk.services.api.MapplsService
    protected String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mappls.sdk.services.api.whoami.MapplsLicensing
    String deviceId() {
        return this.deviceId;
    }

    public String toString() {
        return "MapplsLicensing{baseUrl=" + this.baseUrl + ", deviceId=" + this.deviceId + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsLicensing)) {
            return false;
        }
        MapplsLicensing mapplsLicensing = (MapplsLicensing) obj;
        if (this.baseUrl.equals(mapplsLicensing.baseUrl())) {
            String str = this.deviceId;
            if (str == null) {
                if (mapplsLicensing.deviceId() == null) {
                    return true;
                }
            } else if (str.equals(mapplsLicensing.deviceId())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.baseUrl.hashCode() ^ 1000003) * 1000003;
        String str = this.deviceId;
        return iHashCode ^ (str == null ? 0 : str.hashCode());
    }

    static final class Builder extends MapplsLicensing.Builder {
        private String baseUrl;
        private String deviceId;

        Builder() {
        }

        @Override // com.mappls.sdk.services.api.whoami.MapplsLicensing.Builder
        MapplsLicensing.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.whoami.MapplsLicensing.Builder
        public MapplsLicensing.Builder deviceId(String str) {
            this.deviceId = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.whoami.MapplsLicensing.Builder
        MapplsLicensing autoBuild() {
            if (this.baseUrl == null) {
                throw new IllegalStateException("Missing required properties: baseUrl");
            }
            return new AutoValue_MapplsLicensing(this.baseUrl, this.deviceId);
        }
    }
}

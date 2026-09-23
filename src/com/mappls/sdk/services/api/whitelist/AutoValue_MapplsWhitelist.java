package com.mappls.sdk.services.api.whitelist;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsWhitelist extends MapplsWhitelist {
    private final String baseUrl;
    private final String otp;
    private final String refLocation;
    private final String userHandle;

    private AutoValue_MapplsWhitelist(String str, String str2, String str3, String str4) {
        this.baseUrl = str;
        this.userHandle = str2;
        this.refLocation = str3;
        this.otp = str4;
    }

    @Override // com.mappls.sdk.services.api.whitelist.MapplsWhitelist, com.mappls.sdk.services.api.MapplsService
    protected String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mappls.sdk.services.api.whitelist.MapplsWhitelist
    String userHandle() {
        return this.userHandle;
    }

    @Override // com.mappls.sdk.services.api.whitelist.MapplsWhitelist
    String refLocation() {
        return this.refLocation;
    }

    @Override // com.mappls.sdk.services.api.whitelist.MapplsWhitelist
    String otp() {
        return this.otp;
    }

    public String toString() {
        return "MapplsWhitelist{baseUrl=" + this.baseUrl + ", userHandle=" + this.userHandle + ", refLocation=" + this.refLocation + ", otp=" + this.otp + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsWhitelist)) {
            return false;
        }
        MapplsWhitelist mapplsWhitelist = (MapplsWhitelist) obj;
        return this.baseUrl.equals(mapplsWhitelist.baseUrl()) && this.userHandle.equals(mapplsWhitelist.userHandle()) && this.refLocation.equals(mapplsWhitelist.refLocation()) && this.otp.equals(mapplsWhitelist.otp());
    }

    public int hashCode() {
        return ((((((this.baseUrl.hashCode() ^ 1000003) * 1000003) ^ this.userHandle.hashCode()) * 1000003) ^ this.refLocation.hashCode()) * 1000003) ^ this.otp.hashCode();
    }

    static final class Builder extends MapplsWhitelist.Builder {
        private String baseUrl;
        private String otp;
        private String refLocation;
        private String userHandle;

        Builder() {
        }

        @Override // com.mappls.sdk.services.api.whitelist.MapplsWhitelist.Builder
        MapplsWhitelist.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.whitelist.MapplsWhitelist.Builder
        public MapplsWhitelist.Builder userHandle(String str) {
            if (str == null) {
                throw new NullPointerException("Null userHandle");
            }
            this.userHandle = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.whitelist.MapplsWhitelist.Builder
        public MapplsWhitelist.Builder refLocation(String str) {
            if (str == null) {
                throw new NullPointerException("Null refLocation");
            }
            this.refLocation = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.whitelist.MapplsWhitelist.Builder
        public MapplsWhitelist.Builder otp(String str) {
            if (str == null) {
                throw new NullPointerException("Null otp");
            }
            this.otp = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.whitelist.MapplsWhitelist.Builder
        public MapplsWhitelist build() {
            if (this.baseUrl == null || this.userHandle == null || this.refLocation == null || this.otp == null) {
                StringBuilder sb = new StringBuilder();
                if (this.baseUrl == null) {
                    sb.append(" baseUrl");
                }
                if (this.userHandle == null) {
                    sb.append(" userHandle");
                }
                if (this.refLocation == null) {
                    sb.append(" refLocation");
                }
                if (this.otp == null) {
                    sb.append(" otp");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_MapplsWhitelist(this.baseUrl, this.userHandle, this.refLocation, this.otp);
        }
    }
}

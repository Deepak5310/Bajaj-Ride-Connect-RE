package com.mappls.sdk.services.api.auth;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsAuthentication extends MapplsAuthentication {
    private final String baseUrl;
    private final String grantType;
    private final String refreshToken;

    private AutoValue_MapplsAuthentication(String str, String str2, String str3) {
        this.baseUrl = str;
        this.grantType = str2;
        this.refreshToken = str3;
    }

    @Override // com.mappls.sdk.services.api.auth.MapplsAuthentication, com.mappls.sdk.services.api.MapplsService
    protected String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mappls.sdk.services.api.auth.MapplsAuthentication
    String grantType() {
        return this.grantType;
    }

    @Override // com.mappls.sdk.services.api.auth.MapplsAuthentication
    String refreshToken() {
        return this.refreshToken;
    }

    public String toString() {
        return "MapplsAuthentication{baseUrl=" + this.baseUrl + ", grantType=" + this.grantType + ", refreshToken=" + this.refreshToken + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsAuthentication)) {
            return false;
        }
        MapplsAuthentication mapplsAuthentication = (MapplsAuthentication) obj;
        if (this.baseUrl.equals(mapplsAuthentication.baseUrl()) && this.grantType.equals(mapplsAuthentication.grantType())) {
            String str = this.refreshToken;
            if (str == null) {
                if (mapplsAuthentication.refreshToken() == null) {
                    return true;
                }
            } else if (str.equals(mapplsAuthentication.refreshToken())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((this.baseUrl.hashCode() ^ 1000003) * 1000003) ^ this.grantType.hashCode()) * 1000003;
        String str = this.refreshToken;
        return iHashCode ^ (str == null ? 0 : str.hashCode());
    }

    static final class Builder extends MapplsAuthentication.Builder {
        private String baseUrl;
        private String grantType;
        private String refreshToken;

        Builder() {
        }

        @Override // com.mappls.sdk.services.api.auth.MapplsAuthentication.Builder
        MapplsAuthentication.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.auth.MapplsAuthentication.Builder
        public MapplsAuthentication.Builder grantType(String str) {
            if (str == null) {
                throw new NullPointerException("Null grantType");
            }
            this.grantType = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.auth.MapplsAuthentication.Builder
        public MapplsAuthentication.Builder refreshToken(String str) {
            this.refreshToken = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.auth.MapplsAuthentication.Builder
        MapplsAuthentication autoBuild() {
            if (this.baseUrl == null || this.grantType == null) {
                StringBuilder sb = new StringBuilder();
                if (this.baseUrl == null) {
                    sb.append(" baseUrl");
                }
                if (this.grantType == null) {
                    sb.append(" grantType");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_MapplsAuthentication(this.baseUrl, this.grantType, this.refreshToken);
        }
    }
}

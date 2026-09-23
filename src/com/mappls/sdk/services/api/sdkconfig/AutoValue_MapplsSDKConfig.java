package com.mappls.sdk.services.api.sdkconfig;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsSDKConfig extends MapplsSDKConfig {
    private final String baseUrl;
    private final String configUrl;

    private AutoValue_MapplsSDKConfig(String str, String str2) {
        this.baseUrl = str;
        this.configUrl = str2;
    }

    @Override // com.mappls.sdk.services.api.sdkconfig.MapplsSDKConfig, com.mappls.sdk.services.api.MapplsService
    protected String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mappls.sdk.services.api.sdkconfig.MapplsSDKConfig
    String configUrl() {
        return this.configUrl;
    }

    public String toString() {
        return "MapplsSDKConfig{baseUrl=" + this.baseUrl + ", configUrl=" + this.configUrl + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsSDKConfig)) {
            return false;
        }
        MapplsSDKConfig mapplsSDKConfig = (MapplsSDKConfig) obj;
        return this.baseUrl.equals(mapplsSDKConfig.baseUrl()) && this.configUrl.equals(mapplsSDKConfig.configUrl());
    }

    public int hashCode() {
        return ((this.baseUrl.hashCode() ^ 1000003) * 1000003) ^ this.configUrl.hashCode();
    }

    static final class Builder extends MapplsSDKConfig.Builder {
        private String baseUrl;
        private String configUrl;

        Builder() {
        }

        @Override // com.mappls.sdk.services.api.sdkconfig.MapplsSDKConfig.Builder
        public MapplsSDKConfig.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.sdkconfig.MapplsSDKConfig.Builder
        public MapplsSDKConfig.Builder configUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null configUrl");
            }
            this.configUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.sdkconfig.MapplsSDKConfig.Builder
        public MapplsSDKConfig build() {
            if (this.baseUrl == null || this.configUrl == null) {
                StringBuilder sb = new StringBuilder();
                if (this.baseUrl == null) {
                    sb.append(" baseUrl");
                }
                if (this.configUrl == null) {
                    sb.append(" configUrl");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_MapplsSDKConfig(this.baseUrl, this.configUrl);
        }
    }
}

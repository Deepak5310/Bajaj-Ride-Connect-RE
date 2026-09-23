package com.mappls.sdk.services.api.session.devicelist;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsClusterLinkedDevices extends MapplsClusterLinkedDevices {
    private final String baseUrl;
    private final String clusterId;
    private final String sessionType;

    private AutoValue_MapplsClusterLinkedDevices(String str, String str2, String str3) {
        this.baseUrl = str;
        this.sessionType = str2;
        this.clusterId = str3;
    }

    @Override // com.mappls.sdk.services.api.session.devicelist.MapplsClusterLinkedDevices, com.mappls.sdk.services.api.MapplsService
    protected String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mappls.sdk.services.api.session.devicelist.MapplsClusterLinkedDevices
    String sessionType() {
        return this.sessionType;
    }

    @Override // com.mappls.sdk.services.api.session.devicelist.MapplsClusterLinkedDevices
    String clusterId() {
        return this.clusterId;
    }

    public String toString() {
        return "MapplsClusterLinkedDevices{baseUrl=" + this.baseUrl + ", sessionType=" + this.sessionType + ", clusterId=" + this.clusterId + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsClusterLinkedDevices)) {
            return false;
        }
        MapplsClusterLinkedDevices mapplsClusterLinkedDevices = (MapplsClusterLinkedDevices) obj;
        return this.baseUrl.equals(mapplsClusterLinkedDevices.baseUrl()) && this.sessionType.equals(mapplsClusterLinkedDevices.sessionType()) && this.clusterId.equals(mapplsClusterLinkedDevices.clusterId());
    }

    public int hashCode() {
        return ((((this.baseUrl.hashCode() ^ 1000003) * 1000003) ^ this.sessionType.hashCode()) * 1000003) ^ this.clusterId.hashCode();
    }

    static final class Builder extends MapplsClusterLinkedDevices.Builder {
        private String baseUrl;
        private String clusterId;
        private String sessionType;

        Builder() {
        }

        @Override // com.mappls.sdk.services.api.session.devicelist.MapplsClusterLinkedDevices.Builder
        public MapplsClusterLinkedDevices.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.session.devicelist.MapplsClusterLinkedDevices.Builder
        public MapplsClusterLinkedDevices.Builder sessionType(String str) {
            if (str == null) {
                throw new NullPointerException("Null sessionType");
            }
            this.sessionType = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.session.devicelist.MapplsClusterLinkedDevices.Builder
        public MapplsClusterLinkedDevices.Builder clusterId(String str) {
            if (str == null) {
                throw new NullPointerException("Null clusterId");
            }
            this.clusterId = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.session.devicelist.MapplsClusterLinkedDevices.Builder
        MapplsClusterLinkedDevices autoBuild() {
            if (this.baseUrl == null || this.sessionType == null || this.clusterId == null) {
                StringBuilder sb = new StringBuilder();
                if (this.baseUrl == null) {
                    sb.append(" baseUrl");
                }
                if (this.sessionType == null) {
                    sb.append(" sessionType");
                }
                if (this.clusterId == null) {
                    sb.append(" clusterId");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_MapplsClusterLinkedDevices(this.baseUrl, this.sessionType, this.clusterId);
        }
    }
}

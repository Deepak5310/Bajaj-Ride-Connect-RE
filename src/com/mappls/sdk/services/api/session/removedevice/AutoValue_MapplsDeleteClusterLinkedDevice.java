package com.mappls.sdk.services.api.session.removedevice;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsDeleteClusterLinkedDevice extends MapplsDeleteClusterLinkedDevice {
    private final String baseUrl;
    private final String clusterId;
    private final String linkedDevice;
    private final String sessionType;

    private AutoValue_MapplsDeleteClusterLinkedDevice(String str, String str2, String str3, String str4) {
        this.baseUrl = str;
        this.sessionType = str2;
        this.clusterId = str3;
        this.linkedDevice = str4;
    }

    @Override // com.mappls.sdk.services.api.session.removedevice.MapplsDeleteClusterLinkedDevice, com.mappls.sdk.services.api.MapplsService
    protected String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mappls.sdk.services.api.session.removedevice.MapplsDeleteClusterLinkedDevice
    String sessionType() {
        return this.sessionType;
    }

    @Override // com.mappls.sdk.services.api.session.removedevice.MapplsDeleteClusterLinkedDevice
    String clusterId() {
        return this.clusterId;
    }

    @Override // com.mappls.sdk.services.api.session.removedevice.MapplsDeleteClusterLinkedDevice
    String linkedDevice() {
        return this.linkedDevice;
    }

    public String toString() {
        return "MapplsDeleteClusterLinkedDevice{baseUrl=" + this.baseUrl + ", sessionType=" + this.sessionType + ", clusterId=" + this.clusterId + ", linkedDevice=" + this.linkedDevice + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsDeleteClusterLinkedDevice)) {
            return false;
        }
        MapplsDeleteClusterLinkedDevice mapplsDeleteClusterLinkedDevice = (MapplsDeleteClusterLinkedDevice) obj;
        return this.baseUrl.equals(mapplsDeleteClusterLinkedDevice.baseUrl()) && this.sessionType.equals(mapplsDeleteClusterLinkedDevice.sessionType()) && this.clusterId.equals(mapplsDeleteClusterLinkedDevice.clusterId()) && this.linkedDevice.equals(mapplsDeleteClusterLinkedDevice.linkedDevice());
    }

    public int hashCode() {
        return ((((((this.baseUrl.hashCode() ^ 1000003) * 1000003) ^ this.sessionType.hashCode()) * 1000003) ^ this.clusterId.hashCode()) * 1000003) ^ this.linkedDevice.hashCode();
    }

    static final class Builder extends MapplsDeleteClusterLinkedDevice.Builder {
        private String baseUrl;
        private String clusterId;
        private String linkedDevice;
        private String sessionType;

        Builder() {
        }

        @Override // com.mappls.sdk.services.api.session.removedevice.MapplsDeleteClusterLinkedDevice.Builder
        public MapplsDeleteClusterLinkedDevice.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.session.removedevice.MapplsDeleteClusterLinkedDevice.Builder
        public MapplsDeleteClusterLinkedDevice.Builder sessionType(String str) {
            if (str == null) {
                throw new NullPointerException("Null sessionType");
            }
            this.sessionType = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.session.removedevice.MapplsDeleteClusterLinkedDevice.Builder
        public MapplsDeleteClusterLinkedDevice.Builder clusterId(String str) {
            if (str == null) {
                throw new NullPointerException("Null clusterId");
            }
            this.clusterId = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.session.removedevice.MapplsDeleteClusterLinkedDevice.Builder
        public MapplsDeleteClusterLinkedDevice.Builder linkedDevice(String str) {
            if (str == null) {
                throw new NullPointerException("Null linkedDevice");
            }
            this.linkedDevice = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.session.removedevice.MapplsDeleteClusterLinkedDevice.Builder
        MapplsDeleteClusterLinkedDevice autoBuild() {
            if (this.baseUrl == null || this.sessionType == null || this.clusterId == null || this.linkedDevice == null) {
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
                if (this.linkedDevice == null) {
                    sb.append(" linkedDevice");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_MapplsDeleteClusterLinkedDevice(this.baseUrl, this.sessionType, this.clusterId, this.linkedDevice);
        }
    }
}

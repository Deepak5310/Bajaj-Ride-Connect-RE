package com.mappls.sdk.services.api.generateotp;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsGenerateOTP extends MapplsGenerateOTP {
    private final String baseUrl;
    private final String userHandle;

    private AutoValue_MapplsGenerateOTP(String str, String str2) {
        this.baseUrl = str;
        this.userHandle = str2;
    }

    @Override // com.mappls.sdk.services.api.generateotp.MapplsGenerateOTP, com.mappls.sdk.services.api.MapplsService
    protected String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mappls.sdk.services.api.generateotp.MapplsGenerateOTP
    String userHandle() {
        return this.userHandle;
    }

    public String toString() {
        return "MapplsGenerateOTP{baseUrl=" + this.baseUrl + ", userHandle=" + this.userHandle + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsGenerateOTP)) {
            return false;
        }
        MapplsGenerateOTP mapplsGenerateOTP = (MapplsGenerateOTP) obj;
        return this.baseUrl.equals(mapplsGenerateOTP.baseUrl()) && this.userHandle.equals(mapplsGenerateOTP.userHandle());
    }

    public int hashCode() {
        return ((this.baseUrl.hashCode() ^ 1000003) * 1000003) ^ this.userHandle.hashCode();
    }

    static final class Builder extends MapplsGenerateOTP.Builder {
        private String baseUrl;
        private String userHandle;

        Builder() {
        }

        @Override // com.mappls.sdk.services.api.generateotp.MapplsGenerateOTP.Builder
        public MapplsGenerateOTP.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.generateotp.MapplsGenerateOTP.Builder
        public MapplsGenerateOTP.Builder userHandle(String str) {
            if (str == null) {
                throw new NullPointerException("Null userHandle");
            }
            this.userHandle = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.generateotp.MapplsGenerateOTP.Builder
        MapplsGenerateOTP autoBuild() {
            if (this.baseUrl == null || this.userHandle == null) {
                StringBuilder sb = new StringBuilder();
                if (this.baseUrl == null) {
                    sb.append(" baseUrl");
                }
                if (this.userHandle == null) {
                    sb.append(" userHandle");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_MapplsGenerateOTP(this.baseUrl, this.userHandle);
        }
    }
}

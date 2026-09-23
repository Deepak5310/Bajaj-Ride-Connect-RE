package com.mappls.sdk.services.api.session.delete;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsDeleteSession extends MapplsDeleteSession {
    private final String baseUrl;
    private final String hyperlink;

    private AutoValue_MapplsDeleteSession(String str, String str2) {
        this.baseUrl = str;
        this.hyperlink = str2;
    }

    @Override // com.mappls.sdk.services.api.session.delete.MapplsDeleteSession, com.mappls.sdk.services.api.MapplsService
    protected String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mappls.sdk.services.api.session.delete.MapplsDeleteSession
    String hyperlink() {
        return this.hyperlink;
    }

    public String toString() {
        return "MapplsDeleteSession{baseUrl=" + this.baseUrl + ", hyperlink=" + this.hyperlink + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsDeleteSession)) {
            return false;
        }
        MapplsDeleteSession mapplsDeleteSession = (MapplsDeleteSession) obj;
        return this.baseUrl.equals(mapplsDeleteSession.baseUrl()) && this.hyperlink.equals(mapplsDeleteSession.hyperlink());
    }

    public int hashCode() {
        return ((this.baseUrl.hashCode() ^ 1000003) * 1000003) ^ this.hyperlink.hashCode();
    }

    static final class Builder extends MapplsDeleteSession.Builder {
        private String baseUrl;
        private String hyperlink;

        Builder() {
        }

        @Override // com.mappls.sdk.services.api.session.delete.MapplsDeleteSession.Builder
        public MapplsDeleteSession.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.session.delete.MapplsDeleteSession.Builder
        public MapplsDeleteSession.Builder hyperlink(String str) {
            if (str == null) {
                throw new NullPointerException("Null hyperlink");
            }
            this.hyperlink = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.session.delete.MapplsDeleteSession.Builder
        public MapplsDeleteSession build() {
            if (this.baseUrl == null || this.hyperlink == null) {
                StringBuilder sb = new StringBuilder();
                if (this.baseUrl == null) {
                    sb.append(" baseUrl");
                }
                if (this.hyperlink == null) {
                    sb.append(" hyperlink");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_MapplsDeleteSession(this.baseUrl, this.hyperlink);
        }
    }
}

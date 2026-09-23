package com.mappls.sdk.services.api.session.update;

import com.mappls.sdk.services.api.session.create.model.SessionRequestModel;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsUpdateSession extends MapplsUpdateSession {
    private final String baseUrl;
    private final String clusterId;
    private final String hyperlink;
    private final SessionRequestModel sessionRequest;

    private AutoValue_MapplsUpdateSession(String str, String str2, SessionRequestModel sessionRequestModel, String str3) {
        this.baseUrl = str;
        this.clusterId = str2;
        this.sessionRequest = sessionRequestModel;
        this.hyperlink = str3;
    }

    @Override // com.mappls.sdk.services.api.session.update.MapplsUpdateSession, com.mappls.sdk.services.api.MapplsService
    protected String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mappls.sdk.services.api.session.update.MapplsUpdateSession
    String clusterId() {
        return this.clusterId;
    }

    @Override // com.mappls.sdk.services.api.session.update.MapplsUpdateSession
    SessionRequestModel sessionRequest() {
        return this.sessionRequest;
    }

    @Override // com.mappls.sdk.services.api.session.update.MapplsUpdateSession
    String hyperlink() {
        return this.hyperlink;
    }

    public String toString() {
        return "MapplsUpdateSession{baseUrl=" + this.baseUrl + ", clusterId=" + this.clusterId + ", sessionRequest=" + this.sessionRequest + ", hyperlink=" + this.hyperlink + "}";
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsUpdateSession)) {
            return false;
        }
        MapplsUpdateSession mapplsUpdateSession = (MapplsUpdateSession) obj;
        return this.baseUrl.equals(mapplsUpdateSession.baseUrl()) && ((str = this.clusterId) != null ? str.equals(mapplsUpdateSession.clusterId()) : mapplsUpdateSession.clusterId() == null) && this.sessionRequest.equals(mapplsUpdateSession.sessionRequest()) && this.hyperlink.equals(mapplsUpdateSession.hyperlink());
    }

    public int hashCode() {
        int iHashCode = (this.baseUrl.hashCode() ^ 1000003) * 1000003;
        String str = this.clusterId;
        return ((((iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.sessionRequest.hashCode()) * 1000003) ^ this.hyperlink.hashCode();
    }

    static final class Builder extends MapplsUpdateSession.Builder {
        private String baseUrl;
        private String clusterId;
        private String hyperlink;
        private SessionRequestModel sessionRequest;

        Builder() {
        }

        @Override // com.mappls.sdk.services.api.session.update.MapplsUpdateSession.Builder
        public MapplsUpdateSession.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.session.update.MapplsUpdateSession.Builder
        public MapplsUpdateSession.Builder clusterId(String str) {
            this.clusterId = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.session.update.MapplsUpdateSession.Builder
        public MapplsUpdateSession.Builder sessionRequest(SessionRequestModel sessionRequestModel) {
            if (sessionRequestModel == null) {
                throw new NullPointerException("Null sessionRequest");
            }
            this.sessionRequest = sessionRequestModel;
            return this;
        }

        @Override // com.mappls.sdk.services.api.session.update.MapplsUpdateSession.Builder
        public MapplsUpdateSession.Builder hyperlink(String str) {
            if (str == null) {
                throw new NullPointerException("Null hyperlink");
            }
            this.hyperlink = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.session.update.MapplsUpdateSession.Builder
        public MapplsUpdateSession build() {
            if (this.baseUrl == null || this.sessionRequest == null || this.hyperlink == null) {
                StringBuilder sb = new StringBuilder();
                if (this.baseUrl == null) {
                    sb.append(" baseUrl");
                }
                if (this.sessionRequest == null) {
                    sb.append(" sessionRequest");
                }
                if (this.hyperlink == null) {
                    sb.append(" hyperlink");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_MapplsUpdateSession(this.baseUrl, this.clusterId, this.sessionRequest, this.hyperlink);
        }
    }
}

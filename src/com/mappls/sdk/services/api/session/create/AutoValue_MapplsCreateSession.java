package com.mappls.sdk.services.api.session.create;

import com.mappls.sdk.services.api.session.create.model.SessionRequestModel;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsCreateSession extends MapplsCreateSession {
    private final String baseUrl;
    private final String clusterId;
    private final SessionRequestModel sessionRequest;
    private final String sessionType;

    private AutoValue_MapplsCreateSession(String str, String str2, SessionRequestModel sessionRequestModel, String str3) {
        this.baseUrl = str;
        this.clusterId = str2;
        this.sessionRequest = sessionRequestModel;
        this.sessionType = str3;
    }

    @Override // com.mappls.sdk.services.api.session.create.MapplsCreateSession, com.mappls.sdk.services.api.MapplsService
    protected String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mappls.sdk.services.api.session.create.MapplsCreateSession
    String clusterId() {
        return this.clusterId;
    }

    @Override // com.mappls.sdk.services.api.session.create.MapplsCreateSession
    SessionRequestModel sessionRequest() {
        return this.sessionRequest;
    }

    @Override // com.mappls.sdk.services.api.session.create.MapplsCreateSession
    String sessionType() {
        return this.sessionType;
    }

    public String toString() {
        return "MapplsCreateSession{baseUrl=" + this.baseUrl + ", clusterId=" + this.clusterId + ", sessionRequest=" + this.sessionRequest + ", sessionType=" + this.sessionType + "}";
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsCreateSession)) {
            return false;
        }
        MapplsCreateSession mapplsCreateSession = (MapplsCreateSession) obj;
        return this.baseUrl.equals(mapplsCreateSession.baseUrl()) && ((str = this.clusterId) != null ? str.equals(mapplsCreateSession.clusterId()) : mapplsCreateSession.clusterId() == null) && this.sessionRequest.equals(mapplsCreateSession.sessionRequest()) && this.sessionType.equals(mapplsCreateSession.sessionType());
    }

    public int hashCode() {
        int iHashCode = (this.baseUrl.hashCode() ^ 1000003) * 1000003;
        String str = this.clusterId;
        return ((((iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.sessionRequest.hashCode()) * 1000003) ^ this.sessionType.hashCode();
    }

    static final class Builder extends MapplsCreateSession.Builder {
        private String baseUrl;
        private String clusterId;
        private SessionRequestModel sessionRequest;
        private String sessionType;

        Builder() {
        }

        @Override // com.mappls.sdk.services.api.session.create.MapplsCreateSession.Builder
        public MapplsCreateSession.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.session.create.MapplsCreateSession.Builder
        public MapplsCreateSession.Builder clusterId(String str) {
            this.clusterId = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.session.create.MapplsCreateSession.Builder
        public MapplsCreateSession.Builder sessionRequest(SessionRequestModel sessionRequestModel) {
            if (sessionRequestModel == null) {
                throw new NullPointerException("Null sessionRequest");
            }
            this.sessionRequest = sessionRequestModel;
            return this;
        }

        @Override // com.mappls.sdk.services.api.session.create.MapplsCreateSession.Builder
        public MapplsCreateSession.Builder sessionType(String str) {
            if (str == null) {
                throw new NullPointerException("Null sessionType");
            }
            this.sessionType = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.session.create.MapplsCreateSession.Builder
        public MapplsCreateSession build() {
            if (this.baseUrl == null || this.sessionRequest == null || this.sessionType == null) {
                StringBuilder sb = new StringBuilder();
                if (this.baseUrl == null) {
                    sb.append(" baseUrl");
                }
                if (this.sessionRequest == null) {
                    sb.append(" sessionRequest");
                }
                if (this.sessionType == null) {
                    sb.append(" sessionType");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_MapplsCreateSession(this.baseUrl, this.clusterId, this.sessionRequest, this.sessionType);
        }
    }
}

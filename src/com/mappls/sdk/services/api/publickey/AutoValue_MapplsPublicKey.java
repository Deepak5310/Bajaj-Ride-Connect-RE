package com.mappls.sdk.services.api.publickey;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsPublicKey extends MapplsPublicKey {
    private final String baseUrl;

    private AutoValue_MapplsPublicKey(String str) {
        this.baseUrl = str;
    }

    @Override // com.mappls.sdk.services.api.publickey.MapplsPublicKey, com.mappls.sdk.services.api.MapplsService
    protected String baseUrl() {
        return this.baseUrl;
    }

    public String toString() {
        return "MapplsPublicKey{baseUrl=" + this.baseUrl + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MapplsPublicKey) {
            return this.baseUrl.equals(((MapplsPublicKey) obj).baseUrl());
        }
        return false;
    }

    public int hashCode() {
        return this.baseUrl.hashCode() ^ 1000003;
    }

    static final class Builder extends MapplsPublicKey.Builder {
        private String baseUrl;

        Builder() {
        }

        @Override // com.mappls.sdk.services.api.publickey.MapplsPublicKey.Builder
        public MapplsPublicKey.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.publickey.MapplsPublicKey.Builder
        MapplsPublicKey autobuild() {
            if (this.baseUrl == null) {
                throw new IllegalStateException("Missing required properties: baseUrl");
            }
            return new AutoValue_MapplsPublicKey(this.baseUrl);
        }
    }
}

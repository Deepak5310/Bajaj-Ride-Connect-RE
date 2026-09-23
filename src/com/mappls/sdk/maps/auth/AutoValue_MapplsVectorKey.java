package com.mappls.sdk.maps.auth;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsVectorKey extends MapplsVectorKey {
    private final String baseUrl;

    private AutoValue_MapplsVectorKey(String str) {
        this.baseUrl = str;
    }

    @Override // com.mappls.sdk.maps.auth.MapplsVectorKey, com.mappls.sdk.services.api.MapplsService
    protected String baseUrl() {
        return this.baseUrl;
    }

    public String toString() {
        return "MapplsVectorKey{baseUrl=" + this.baseUrl + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MapplsVectorKey) {
            return this.baseUrl.equals(((MapplsVectorKey) obj).baseUrl());
        }
        return false;
    }

    public int hashCode() {
        return this.baseUrl.hashCode() ^ 1000003;
    }

    static final class Builder extends MapplsVectorKey.Builder {
        private String baseUrl;

        Builder() {
        }

        @Override // com.mappls.sdk.maps.auth.MapplsVectorKey.Builder
        MapplsVectorKey.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.maps.auth.MapplsVectorKey.Builder
        MapplsVectorKey autoBuild() {
            String str;
            if (this.baseUrl != null) {
                str = "";
            } else {
                str = " baseUrl";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_MapplsVectorKey(this.baseUrl);
        }
    }
}

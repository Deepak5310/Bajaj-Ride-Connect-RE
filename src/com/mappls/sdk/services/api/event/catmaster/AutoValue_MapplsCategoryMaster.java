package com.mappls.sdk.services.api.event.catmaster;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsCategoryMaster extends MapplsCategoryMaster {
    private final String baseUrl;

    private AutoValue_MapplsCategoryMaster(String str) {
        this.baseUrl = str;
    }

    @Override // com.mappls.sdk.services.api.event.catmaster.MapplsCategoryMaster, com.mappls.sdk.services.api.MapplsService
    protected String baseUrl() {
        return this.baseUrl;
    }

    public String toString() {
        return "MapplsCategoryMaster{baseUrl=" + this.baseUrl + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MapplsCategoryMaster) {
            return this.baseUrl.equals(((MapplsCategoryMaster) obj).baseUrl());
        }
        return false;
    }

    public int hashCode() {
        return this.baseUrl.hashCode() ^ 1000003;
    }

    static final class Builder extends MapplsCategoryMaster.Builder {
        private String baseUrl;

        Builder() {
        }

        @Override // com.mappls.sdk.services.api.event.catmaster.MapplsCategoryMaster.Builder
        public MapplsCategoryMaster.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.event.catmaster.MapplsCategoryMaster.Builder
        MapplsCategoryMaster autoBuild() {
            if (this.baseUrl == null) {
                throw new IllegalStateException("Missing required properties: baseUrl");
            }
            return new AutoValue_MapplsCategoryMaster(this.baseUrl);
        }
    }
}

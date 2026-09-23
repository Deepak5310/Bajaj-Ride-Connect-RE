package com.mappls.sdk.maps.promo;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsPromo extends MapplsPromo {
    private final String baseUrl;

    private AutoValue_MapplsPromo(String str) {
        this.baseUrl = str;
    }

    @Override // com.mappls.sdk.maps.promo.MapplsPromo, com.mappls.sdk.services.api.MapplsService
    protected String baseUrl() {
        return this.baseUrl;
    }

    public String toString() {
        return "MapplsPromo{baseUrl=" + this.baseUrl + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MapplsPromo) {
            return this.baseUrl.equals(((MapplsPromo) obj).baseUrl());
        }
        return false;
    }

    public int hashCode() {
        return this.baseUrl.hashCode() ^ 1000003;
    }

    static final class Builder extends MapplsPromo.Builder {
        private String baseUrl;

        Builder() {
        }

        @Override // com.mappls.sdk.maps.promo.MapplsPromo.Builder
        MapplsPromo.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.maps.promo.MapplsPromo.Builder
        MapplsPromo autoBuild() {
            String str;
            if (this.baseUrl != null) {
                str = "";
            } else {
                str = " baseUrl";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_MapplsPromo(this.baseUrl);
        }
    }
}

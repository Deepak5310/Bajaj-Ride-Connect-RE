package com.mappls.sdk.maps;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsGetCoordinates extends MapplsGetCoordinates {
    private final String baseUrl;
    private final String formattedMapplsPin;

    private AutoValue_MapplsGetCoordinates(String str, String str2) {
        this.baseUrl = str;
        this.formattedMapplsPin = str2;
    }

    @Override // com.mappls.sdk.maps.MapplsGetCoordinates, com.mappls.sdk.services.api.MapplsService
    protected String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mappls.sdk.maps.MapplsGetCoordinates
    String formattedMapplsPin() {
        return this.formattedMapplsPin;
    }

    public String toString() {
        return "MapplsGetCoordinates{baseUrl=" + this.baseUrl + ", formattedMapplsPin=" + this.formattedMapplsPin + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsGetCoordinates)) {
            return false;
        }
        MapplsGetCoordinates mapplsGetCoordinates = (MapplsGetCoordinates) obj;
        return this.baseUrl.equals(mapplsGetCoordinates.baseUrl()) && this.formattedMapplsPin.equals(mapplsGetCoordinates.formattedMapplsPin());
    }

    public int hashCode() {
        return ((this.baseUrl.hashCode() ^ 1000003) * 1000003) ^ this.formattedMapplsPin.hashCode();
    }

    static final class Builder extends MapplsGetCoordinates.Builder {
        private String baseUrl;
        private String formattedMapplsPin;

        Builder() {
        }

        @Override // com.mappls.sdk.maps.MapplsGetCoordinates.Builder
        public MapplsGetCoordinates.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.maps.MapplsGetCoordinates.Builder
        MapplsGetCoordinates.Builder formattedMapplsPin(String str) {
            if (str == null) {
                throw new NullPointerException("Null formattedMapplsPin");
            }
            this.formattedMapplsPin = str;
            return this;
        }

        @Override // com.mappls.sdk.maps.MapplsGetCoordinates.Builder
        MapplsGetCoordinates autoBuild() {
            String str;
            if (this.baseUrl != null) {
                str = "";
            } else {
                str = " baseUrl";
            }
            if (this.formattedMapplsPin == null) {
                str = str + " formattedMapplsPin";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_MapplsGetCoordinates(this.baseUrl, this.formattedMapplsPin);
        }
    }
}

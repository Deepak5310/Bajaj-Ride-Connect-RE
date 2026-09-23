package com.mappls.sdk.services.api.costestimation;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsCostEstimation extends MapplsCostEstimation {
    private final String baseUrl;
    private final Double distance;
    private final Integer fuelEfficiency;
    private final String fuelEfficiencyUnit;
    private final Double fuelPrice;
    private final Boolean isTollEnabled;
    private final Double latitude;
    private final Double longitude;
    private final String routeId;
    private final Integer routeIndex;
    private final String vehicleFuelType;
    private final String vehicleType;

    private AutoValue_MapplsCostEstimation(String str, String str2, Integer num, String str3, Boolean bool, String str4, Integer num2, String str5, Double d, Double d2, Double d3, Double d4) {
        this.baseUrl = str;
        this.routeId = str2;
        this.routeIndex = num;
        this.vehicleType = str3;
        this.isTollEnabled = bool;
        this.vehicleFuelType = str4;
        this.fuelEfficiency = num2;
        this.fuelEfficiencyUnit = str5;
        this.fuelPrice = d;
        this.distance = d2;
        this.latitude = d3;
        this.longitude = d4;
    }

    @Override // com.mappls.sdk.services.api.costestimation.MapplsCostEstimation, com.mappls.sdk.services.api.MapplsService
    public String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mappls.sdk.services.api.costestimation.MapplsCostEstimation
    String routeId() {
        return this.routeId;
    }

    @Override // com.mappls.sdk.services.api.costestimation.MapplsCostEstimation
    Integer routeIndex() {
        return this.routeIndex;
    }

    @Override // com.mappls.sdk.services.api.costestimation.MapplsCostEstimation
    String vehicleType() {
        return this.vehicleType;
    }

    @Override // com.mappls.sdk.services.api.costestimation.MapplsCostEstimation
    Boolean isTollEnabled() {
        return this.isTollEnabled;
    }

    @Override // com.mappls.sdk.services.api.costestimation.MapplsCostEstimation
    String vehicleFuelType() {
        return this.vehicleFuelType;
    }

    @Override // com.mappls.sdk.services.api.costestimation.MapplsCostEstimation
    Integer fuelEfficiency() {
        return this.fuelEfficiency;
    }

    @Override // com.mappls.sdk.services.api.costestimation.MapplsCostEstimation
    String fuelEfficiencyUnit() {
        return this.fuelEfficiencyUnit;
    }

    @Override // com.mappls.sdk.services.api.costestimation.MapplsCostEstimation
    Double fuelPrice() {
        return this.fuelPrice;
    }

    @Override // com.mappls.sdk.services.api.costestimation.MapplsCostEstimation
    Double distance() {
        return this.distance;
    }

    @Override // com.mappls.sdk.services.api.costestimation.MapplsCostEstimation
    Double latitude() {
        return this.latitude;
    }

    @Override // com.mappls.sdk.services.api.costestimation.MapplsCostEstimation
    Double longitude() {
        return this.longitude;
    }

    public String toString() {
        return "MapplsCostEstimation{baseUrl=" + this.baseUrl + ", routeId=" + this.routeId + ", routeIndex=" + this.routeIndex + ", vehicleType=" + this.vehicleType + ", isTollEnabled=" + this.isTollEnabled + ", vehicleFuelType=" + this.vehicleFuelType + ", fuelEfficiency=" + this.fuelEfficiency + ", fuelEfficiencyUnit=" + this.fuelEfficiencyUnit + ", fuelPrice=" + this.fuelPrice + ", distance=" + this.distance + ", latitude=" + this.latitude + ", longitude=" + this.longitude + "}";
    }

    public boolean equals(Object obj) {
        String str;
        Integer num;
        String str2;
        Boolean bool;
        String str3;
        Integer num2;
        String str4;
        Double d;
        Double d2;
        Double d3;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsCostEstimation)) {
            return false;
        }
        MapplsCostEstimation mapplsCostEstimation = (MapplsCostEstimation) obj;
        if (this.baseUrl.equals(mapplsCostEstimation.baseUrl()) && ((str = this.routeId) != null ? str.equals(mapplsCostEstimation.routeId()) : mapplsCostEstimation.routeId() == null) && ((num = this.routeIndex) != null ? num.equals(mapplsCostEstimation.routeIndex()) : mapplsCostEstimation.routeIndex() == null) && ((str2 = this.vehicleType) != null ? str2.equals(mapplsCostEstimation.vehicleType()) : mapplsCostEstimation.vehicleType() == null) && ((bool = this.isTollEnabled) != null ? bool.equals(mapplsCostEstimation.isTollEnabled()) : mapplsCostEstimation.isTollEnabled() == null) && ((str3 = this.vehicleFuelType) != null ? str3.equals(mapplsCostEstimation.vehicleFuelType()) : mapplsCostEstimation.vehicleFuelType() == null) && ((num2 = this.fuelEfficiency) != null ? num2.equals(mapplsCostEstimation.fuelEfficiency()) : mapplsCostEstimation.fuelEfficiency() == null) && ((str4 = this.fuelEfficiencyUnit) != null ? str4.equals(mapplsCostEstimation.fuelEfficiencyUnit()) : mapplsCostEstimation.fuelEfficiencyUnit() == null) && ((d = this.fuelPrice) != null ? d.equals(mapplsCostEstimation.fuelPrice()) : mapplsCostEstimation.fuelPrice() == null) && ((d2 = this.distance) != null ? d2.equals(mapplsCostEstimation.distance()) : mapplsCostEstimation.distance() == null) && ((d3 = this.latitude) != null ? d3.equals(mapplsCostEstimation.latitude()) : mapplsCostEstimation.latitude() == null)) {
            Double d4 = this.longitude;
            if (d4 == null) {
                if (mapplsCostEstimation.longitude() == null) {
                    return true;
                }
            } else if (d4.equals(mapplsCostEstimation.longitude())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.baseUrl.hashCode() ^ 1000003) * 1000003;
        String str = this.routeId;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        Integer num = this.routeIndex;
        int iHashCode3 = (iHashCode2 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str2 = this.vehicleType;
        int iHashCode4 = (iHashCode3 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        Boolean bool = this.isTollEnabled;
        int iHashCode5 = (iHashCode4 ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        String str3 = this.vehicleFuelType;
        int iHashCode6 = (iHashCode5 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        Integer num2 = this.fuelEfficiency;
        int iHashCode7 = (iHashCode6 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
        String str4 = this.fuelEfficiencyUnit;
        int iHashCode8 = (iHashCode7 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        Double d = this.fuelPrice;
        int iHashCode9 = (iHashCode8 ^ (d == null ? 0 : d.hashCode())) * 1000003;
        Double d2 = this.distance;
        int iHashCode10 = (iHashCode9 ^ (d2 == null ? 0 : d2.hashCode())) * 1000003;
        Double d3 = this.latitude;
        int iHashCode11 = (iHashCode10 ^ (d3 == null ? 0 : d3.hashCode())) * 1000003;
        Double d4 = this.longitude;
        return iHashCode11 ^ (d4 != null ? d4.hashCode() : 0);
    }

    static final class Builder extends MapplsCostEstimation.Builder {
        private String baseUrl;
        private Double distance;
        private Integer fuelEfficiency;
        private String fuelEfficiencyUnit;
        private Double fuelPrice;
        private Boolean isTollEnabled;
        private Double latitude;
        private Double longitude;
        private String routeId;
        private Integer routeIndex;
        private String vehicleFuelType;
        private String vehicleType;

        Builder() {
        }

        @Override // com.mappls.sdk.services.api.costestimation.MapplsCostEstimation.Builder
        public MapplsCostEstimation.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.costestimation.MapplsCostEstimation.Builder
        public MapplsCostEstimation.Builder routeId(String str) {
            this.routeId = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.costestimation.MapplsCostEstimation.Builder
        public MapplsCostEstimation.Builder routeIndex(Integer num) {
            this.routeIndex = num;
            return this;
        }

        @Override // com.mappls.sdk.services.api.costestimation.MapplsCostEstimation.Builder
        public MapplsCostEstimation.Builder vehicleType(String str) {
            this.vehicleType = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.costestimation.MapplsCostEstimation.Builder
        public MapplsCostEstimation.Builder isTollEnabled(Boolean bool) {
            this.isTollEnabled = bool;
            return this;
        }

        @Override // com.mappls.sdk.services.api.costestimation.MapplsCostEstimation.Builder
        public MapplsCostEstimation.Builder vehicleFuelType(String str) {
            this.vehicleFuelType = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.costestimation.MapplsCostEstimation.Builder
        public MapplsCostEstimation.Builder fuelEfficiency(Integer num) {
            this.fuelEfficiency = num;
            return this;
        }

        @Override // com.mappls.sdk.services.api.costestimation.MapplsCostEstimation.Builder
        public MapplsCostEstimation.Builder fuelEfficiencyUnit(String str) {
            this.fuelEfficiencyUnit = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.costestimation.MapplsCostEstimation.Builder
        public MapplsCostEstimation.Builder fuelPrice(Double d) {
            this.fuelPrice = d;
            return this;
        }

        @Override // com.mappls.sdk.services.api.costestimation.MapplsCostEstimation.Builder
        public MapplsCostEstimation.Builder distance(Double d) {
            this.distance = d;
            return this;
        }

        @Override // com.mappls.sdk.services.api.costestimation.MapplsCostEstimation.Builder
        public MapplsCostEstimation.Builder latitude(Double d) {
            this.latitude = d;
            return this;
        }

        @Override // com.mappls.sdk.services.api.costestimation.MapplsCostEstimation.Builder
        public MapplsCostEstimation.Builder longitude(Double d) {
            this.longitude = d;
            return this;
        }

        @Override // com.mappls.sdk.services.api.costestimation.MapplsCostEstimation.Builder
        MapplsCostEstimation autoBuild() {
            if (this.baseUrl == null) {
                throw new IllegalStateException("Missing required properties: baseUrl");
            }
            return new AutoValue_MapplsCostEstimation(this.baseUrl, this.routeId, this.routeIndex, this.vehicleType, this.isTollEnabled, this.vehicleFuelType, this.fuelEfficiency, this.fuelEfficiencyUnit, this.fuelPrice, this.distance, this.latitude, this.longitude);
        }
    }
}

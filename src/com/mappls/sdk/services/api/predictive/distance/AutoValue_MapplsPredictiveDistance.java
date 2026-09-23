package com.mappls.sdk.services.api.predictive.distance;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsPredictiveDistance extends MapplsPredictiveDistance {
    private final String baseUrl;
    private final String internalDateTime;
    private final List<String> internalDestination;
    private final List<String> internalSources;
    private final String internalSpeedType;
    private final String profile;

    private AutoValue_MapplsPredictiveDistance(String str, List<String> list, List<String> list2, String str2, String str3, String str4) {
        this.baseUrl = str;
        this.internalSources = list;
        this.internalDestination = list2;
        this.profile = str2;
        this.internalSpeedType = str3;
        this.internalDateTime = str4;
    }

    @Override // com.mappls.sdk.services.api.predictive.distance.MapplsPredictiveDistance, com.mappls.sdk.services.api.MapplsService
    protected String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mappls.sdk.services.api.predictive.distance.MapplsPredictiveDistance
    List<String> internalSources() {
        return this.internalSources;
    }

    @Override // com.mappls.sdk.services.api.predictive.distance.MapplsPredictiveDistance
    List<String> internalDestination() {
        return this.internalDestination;
    }

    @Override // com.mappls.sdk.services.api.predictive.distance.MapplsPredictiveDistance
    String profile() {
        return this.profile;
    }

    @Override // com.mappls.sdk.services.api.predictive.distance.MapplsPredictiveDistance
    String internalSpeedType() {
        return this.internalSpeedType;
    }

    @Override // com.mappls.sdk.services.api.predictive.distance.MapplsPredictiveDistance
    String internalDateTime() {
        return this.internalDateTime;
    }

    public String toString() {
        return "MapplsPredictiveDistance{baseUrl=" + this.baseUrl + ", internalSources=" + this.internalSources + ", internalDestination=" + this.internalDestination + ", profile=" + this.profile + ", internalSpeedType=" + this.internalSpeedType + ", internalDateTime=" + this.internalDateTime + "}";
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsPredictiveDistance)) {
            return false;
        }
        MapplsPredictiveDistance mapplsPredictiveDistance = (MapplsPredictiveDistance) obj;
        if (this.baseUrl.equals(mapplsPredictiveDistance.baseUrl()) && this.internalSources.equals(mapplsPredictiveDistance.internalSources()) && this.internalDestination.equals(mapplsPredictiveDistance.internalDestination()) && this.profile.equals(mapplsPredictiveDistance.profile()) && ((str = this.internalSpeedType) != null ? str.equals(mapplsPredictiveDistance.internalSpeedType()) : mapplsPredictiveDistance.internalSpeedType() == null)) {
            String str2 = this.internalDateTime;
            if (str2 == null) {
                if (mapplsPredictiveDistance.internalDateTime() == null) {
                    return true;
                }
            } else if (str2.equals(mapplsPredictiveDistance.internalDateTime())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((((((this.baseUrl.hashCode() ^ 1000003) * 1000003) ^ this.internalSources.hashCode()) * 1000003) ^ this.internalDestination.hashCode()) * 1000003) ^ this.profile.hashCode()) * 1000003;
        String str = this.internalSpeedType;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.internalDateTime;
        return iHashCode2 ^ (str2 != null ? str2.hashCode() : 0);
    }

    static final class Builder extends MapplsPredictiveDistance.Builder {
        private String baseUrl;
        private String internalDateTime;
        private List<String> internalDestination;
        private List<String> internalSources;
        private String internalSpeedType;
        private String profile;

        Builder() {
        }

        @Override // com.mappls.sdk.services.api.predictive.distance.MapplsPredictiveDistance.Builder
        public MapplsPredictiveDistance.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.predictive.distance.MapplsPredictiveDistance.Builder
        MapplsPredictiveDistance.Builder internalSources(List<String> list) {
            if (list == null) {
                throw new NullPointerException("Null internalSources");
            }
            this.internalSources = list;
            return this;
        }

        @Override // com.mappls.sdk.services.api.predictive.distance.MapplsPredictiveDistance.Builder
        MapplsPredictiveDistance.Builder internalDestination(List<String> list) {
            if (list == null) {
                throw new NullPointerException("Null internalDestination");
            }
            this.internalDestination = list;
            return this;
        }

        @Override // com.mappls.sdk.services.api.predictive.distance.MapplsPredictiveDistance.Builder
        public MapplsPredictiveDistance.Builder profile(String str) {
            if (str == null) {
                throw new NullPointerException("Null profile");
            }
            this.profile = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.predictive.distance.MapplsPredictiveDistance.Builder
        MapplsPredictiveDistance.Builder internalSpeedType(String str) {
            this.internalSpeedType = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.predictive.distance.MapplsPredictiveDistance.Builder
        MapplsPredictiveDistance.Builder internalDateTime(String str) {
            this.internalDateTime = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.predictive.distance.MapplsPredictiveDistance.Builder
        MapplsPredictiveDistance autoBuild() {
            if (this.baseUrl == null || this.internalSources == null || this.internalDestination == null || this.profile == null) {
                StringBuilder sb = new StringBuilder();
                if (this.baseUrl == null) {
                    sb.append(" baseUrl");
                }
                if (this.internalSources == null) {
                    sb.append(" internalSources");
                }
                if (this.internalDestination == null) {
                    sb.append(" internalDestination");
                }
                if (this.profile == null) {
                    sb.append(" profile");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_MapplsPredictiveDistance(this.baseUrl, this.internalSources, this.internalDestination, this.profile, this.internalSpeedType, this.internalDateTime);
        }
    }
}

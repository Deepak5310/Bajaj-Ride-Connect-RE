package com.mappls.sdk.services.api.event.route;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MapplsRouteSummary extends MapplsRouteSummary {
    private final String baseUrl;
    private final String currentNode;
    private final String internalCategories;
    private final Integer isGroup;
    private final String routeId;
    private final Integer routeIdx;
    private final String screenName;

    private AutoValue_MapplsRouteSummary(String str, String str2, Integer num, String str3, Integer num2, String str4, String str5) {
        this.baseUrl = str;
        this.routeId = str2;
        this.routeIdx = num;
        this.currentNode = str3;
        this.isGroup = num2;
        this.internalCategories = str4;
        this.screenName = str5;
    }

    @Override // com.mappls.sdk.services.api.event.route.MapplsRouteSummary, com.mappls.sdk.services.api.MapplsService
    protected String baseUrl() {
        return this.baseUrl;
    }

    @Override // com.mappls.sdk.services.api.event.route.MapplsRouteSummary
    protected String routeId() {
        return this.routeId;
    }

    @Override // com.mappls.sdk.services.api.event.route.MapplsRouteSummary
    protected Integer routeIdx() {
        return this.routeIdx;
    }

    @Override // com.mappls.sdk.services.api.event.route.MapplsRouteSummary
    protected String currentNode() {
        return this.currentNode;
    }

    @Override // com.mappls.sdk.services.api.event.route.MapplsRouteSummary
    protected Integer isGroup() {
        return this.isGroup;
    }

    @Override // com.mappls.sdk.services.api.event.route.MapplsRouteSummary
    protected String internalCategories() {
        return this.internalCategories;
    }

    @Override // com.mappls.sdk.services.api.event.route.MapplsRouteSummary
    protected String screenName() {
        return this.screenName;
    }

    public String toString() {
        return "MapplsRouteSummary{baseUrl=" + this.baseUrl + ", routeId=" + this.routeId + ", routeIdx=" + this.routeIdx + ", currentNode=" + this.currentNode + ", isGroup=" + this.isGroup + ", internalCategories=" + this.internalCategories + ", screenName=" + this.screenName + "}";
    }

    public boolean equals(Object obj) {
        Integer num;
        String str;
        Integer num2;
        String str2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapplsRouteSummary)) {
            return false;
        }
        MapplsRouteSummary mapplsRouteSummary = (MapplsRouteSummary) obj;
        if (this.baseUrl.equals(mapplsRouteSummary.baseUrl()) && this.routeId.equals(mapplsRouteSummary.routeId()) && ((num = this.routeIdx) != null ? num.equals(mapplsRouteSummary.routeIdx()) : mapplsRouteSummary.routeIdx() == null) && ((str = this.currentNode) != null ? str.equals(mapplsRouteSummary.currentNode()) : mapplsRouteSummary.currentNode() == null) && ((num2 = this.isGroup) != null ? num2.equals(mapplsRouteSummary.isGroup()) : mapplsRouteSummary.isGroup() == null) && ((str2 = this.internalCategories) != null ? str2.equals(mapplsRouteSummary.internalCategories()) : mapplsRouteSummary.internalCategories() == null)) {
            String str3 = this.screenName;
            if (str3 == null) {
                if (mapplsRouteSummary.screenName() == null) {
                    return true;
                }
            } else if (str3.equals(mapplsRouteSummary.screenName())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((this.baseUrl.hashCode() ^ 1000003) * 1000003) ^ this.routeId.hashCode()) * 1000003;
        Integer num = this.routeIdx;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.currentNode;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        Integer num2 = this.isGroup;
        int iHashCode4 = (iHashCode3 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
        String str2 = this.internalCategories;
        int iHashCode5 = (iHashCode4 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.screenName;
        return iHashCode5 ^ (str3 != null ? str3.hashCode() : 0);
    }

    static final class Builder extends MapplsRouteSummary.Builder {
        private String baseUrl;
        private String currentNode;
        private String internalCategories;
        private Integer isGroup;
        private String routeId;
        private Integer routeIdx;
        private String screenName;

        Builder() {
        }

        @Override // com.mappls.sdk.services.api.event.route.MapplsRouteSummary.Builder
        public MapplsRouteSummary.Builder baseUrl(String str) {
            if (str == null) {
                throw new NullPointerException("Null baseUrl");
            }
            this.baseUrl = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.event.route.MapplsRouteSummary.Builder
        public MapplsRouteSummary.Builder routeId(String str) {
            if (str == null) {
                throw new NullPointerException("Null routeId");
            }
            this.routeId = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.event.route.MapplsRouteSummary.Builder
        public MapplsRouteSummary.Builder routeIdx(Integer num) {
            this.routeIdx = num;
            return this;
        }

        @Override // com.mappls.sdk.services.api.event.route.MapplsRouteSummary.Builder
        public MapplsRouteSummary.Builder currentNode(String str) {
            this.currentNode = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.event.route.MapplsRouteSummary.Builder
        public MapplsRouteSummary.Builder isGroup(Integer num) {
            this.isGroup = num;
            return this;
        }

        @Override // com.mappls.sdk.services.api.event.route.MapplsRouteSummary.Builder
        MapplsRouteSummary.Builder internalCategories(String str) {
            this.internalCategories = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.event.route.MapplsRouteSummary.Builder
        public MapplsRouteSummary.Builder screenName(String str) {
            this.screenName = str;
            return this;
        }

        @Override // com.mappls.sdk.services.api.event.route.MapplsRouteSummary.Builder
        MapplsRouteSummary autoBuild() {
            if (this.baseUrl == null || this.routeId == null) {
                StringBuilder sb = new StringBuilder();
                if (this.baseUrl == null) {
                    sb.append(" baseUrl");
                }
                if (this.routeId == null) {
                    sb.append(" routeId");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_MapplsRouteSummary(this.baseUrl, this.routeId, this.routeIdx, this.currentNode, this.isGroup, this.internalCategories, this.screenName);
        }
    }
}

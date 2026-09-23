package com.mappls.sdk.services.api.directions.models;

import com.google.android.gms.common.Scopes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mappls.sdk.services.api.directions.WalkingOptions;
import com.spotify.sdk.android.auth.AccountsQueryParameters;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_RouteOptions extends C$AutoValue_RouteOptions {
    AutoValue_RouteOptions(String str, String str2, String str3, String str4, String str5, List<String> list, Boolean bool, String str6, String str7, String str8, Boolean bool2, String str9, String str10, Boolean bool3, String str11, String str12, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, String str13, String str14, String str15, String str16, String str17, String str18, String str19, WalkingOptions walkingOptions, Integer num, Boolean bool8, Boolean bool9, Boolean bool10, String str20, String str21, Integer num2, Integer num3, Double d, Double d2, Double d3) {
        new RouteOptions(str, str2, str3, str4, str5, list, bool, str6, str7, str8, bool2, str9, str10, bool3, str11, str12, bool4, bool5, bool6, bool7, str13, str14, str15, str16, str17, str18, str19, walkingOptions, num, bool8, bool9, bool10, str20, str21, num2, num3, d, d2, d3) { // from class: com.mappls.sdk.services.api.directions.models.$AutoValue_RouteOptions
            private final String accessToken;
            private final Boolean alternatives;
            private final String annotations;
            private final String approaches;
            private final Double aux;
            private final Boolean bannerInstructions;
            private final String baseUrl;
            private final Integer batteryCapacity;
            private final String bearings;
            private final Boolean continueStraight;
            private final List<String> coordinates;
            private final String dateTime;
            private final String deviceID;
            private final Double efficiency;
            private final String exclude;
            private final String geometries;
            private final Boolean instructions;
            private final Boolean isSort;
            private final String language;
            private final Boolean lessVerbose;
            private final Integer mass;
            private final String overview;
            private final String profile;
            private final String radiuses;
            private final Double regen;
            private final String requestUuid;
            private final String resource;
            private final Boolean roundaboutExits;
            private final Boolean routeRefresh;
            private final Integer routeType;
            private final String sessionId;
            private final Boolean skipWaypoints;
            private final String soc;
            private final Boolean steps;
            private final String user;
            private final WalkingOptions walkingOptions;
            private final String waypointIndices;
            private final String waypointNames;
            private final String waypointTargets;

            {
                if (str == null) {
                    throw new NullPointerException("Null baseUrl");
                }
                this.baseUrl = str;
                this.deviceID = str2;
                if (str3 == null) {
                    throw new NullPointerException("Null user");
                }
                this.user = str3;
                if (str4 == null) {
                    throw new NullPointerException("Null profile");
                }
                this.profile = str4;
                if (str5 == null) {
                    throw new NullPointerException("Null resource");
                }
                this.resource = str5;
                if (list == null) {
                    throw new NullPointerException("Null coordinates");
                }
                this.coordinates = list;
                this.alternatives = bool;
                this.language = str6;
                this.radiuses = str7;
                this.bearings = str8;
                this.lessVerbose = bool2;
                if (str9 == null) {
                    throw new NullPointerException("Null geometries");
                }
                this.geometries = str9;
                this.overview = str10;
                this.steps = bool3;
                this.annotations = str11;
                this.exclude = str12;
                this.continueStraight = bool4;
                this.bannerInstructions = bool5;
                this.instructions = bool6;
                this.skipWaypoints = bool7;
                this.accessToken = str13;
                this.requestUuid = str14;
                this.sessionId = str15;
                this.approaches = str16;
                this.waypointIndices = str17;
                this.waypointNames = str18;
                this.waypointTargets = str19;
                this.walkingOptions = walkingOptions;
                this.routeType = num;
                this.isSort = bool8;
                this.routeRefresh = bool9;
                this.roundaboutExits = bool10;
                this.dateTime = str20;
                this.soc = str21;
                this.batteryCapacity = num2;
                this.mass = num3;
                this.efficiency = d;
                this.aux = d2;
                this.regen = d3;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            public String baseUrl() {
                return this.baseUrl;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            public String deviceID() {
                return this.deviceID;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            public String user() {
                return this.user;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            public String profile() {
                return this.profile;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            public String resource() {
                return this.resource;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            public List<String> coordinates() {
                return this.coordinates;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            public Boolean alternatives() {
                return this.alternatives;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            public String language() {
                return this.language;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            public String radiuses() {
                return this.radiuses;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            public String bearings() {
                return this.bearings;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            @SerializedName("lessverbose")
            public Boolean lessVerbose() {
                return this.lessVerbose;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            public String geometries() {
                return this.geometries;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            public String overview() {
                return this.overview;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            public Boolean steps() {
                return this.steps;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            public String annotations() {
                return this.annotations;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            public String exclude() {
                return this.exclude;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            @SerializedName("continueStraight")
            public Boolean continueStraight() {
                return this.continueStraight;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            @SerializedName("banner_instructions")
            public Boolean bannerInstructions() {
                return this.bannerInstructions;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            @SerializedName("instructions")
            public Boolean instructions() {
                return this.instructions;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            @SerializedName("skip_waypoints")
            public Boolean skipWaypoints() {
                return this.skipWaypoints;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            @SerializedName(AccountsQueryParameters.ACCESS_TOKEN)
            public String accessToken() {
                return this.accessToken;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            @SerializedName("uuid")
            public String requestUuid() {
                return this.requestUuid;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            @SerializedName("sessionId")
            public String sessionId() {
                return this.sessionId;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            public String approaches() {
                return this.approaches;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            @SerializedName("waypoints")
            public String waypointIndices() {
                return this.waypointIndices;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            @SerializedName("waypoint_names")
            public String waypointNames() {
                return this.waypointNames;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            @SerializedName("waypoint_targets")
            public String waypointTargets() {
                return this.waypointTargets;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            public WalkingOptions walkingOptions() {
                return this.walkingOptions;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            public Integer routeType() {
                return this.routeType;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            public Boolean isSort() {
                return this.isSort;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            public Boolean routeRefresh() {
                return this.routeRefresh;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            public Boolean roundaboutExits() {
                return this.roundaboutExits;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            public String dateTime() {
                return this.dateTime;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            public String soc() {
                return this.soc;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            public Integer batteryCapacity() {
                return this.batteryCapacity;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            public Integer mass() {
                return this.mass;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            public Double efficiency() {
                return this.efficiency;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            public Double aux() {
                return this.aux;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            public Double regen() {
                return this.regen;
            }

            public String toString() {
                return "RouteOptions{baseUrl=" + this.baseUrl + ", deviceID=" + this.deviceID + ", user=" + this.user + ", profile=" + this.profile + ", resource=" + this.resource + ", coordinates=" + this.coordinates + ", alternatives=" + this.alternatives + ", language=" + this.language + ", radiuses=" + this.radiuses + ", bearings=" + this.bearings + ", lessVerbose=" + this.lessVerbose + ", geometries=" + this.geometries + ", overview=" + this.overview + ", steps=" + this.steps + ", annotations=" + this.annotations + ", exclude=" + this.exclude + ", continueStraight=" + this.continueStraight + ", bannerInstructions=" + this.bannerInstructions + ", instructions=" + this.instructions + ", skipWaypoints=" + this.skipWaypoints + ", accessToken=" + this.accessToken + ", requestUuid=" + this.requestUuid + ", sessionId=" + this.sessionId + ", approaches=" + this.approaches + ", waypointIndices=" + this.waypointIndices + ", waypointNames=" + this.waypointNames + ", waypointTargets=" + this.waypointTargets + ", walkingOptions=" + this.walkingOptions + ", routeType=" + this.routeType + ", isSort=" + this.isSort + ", routeRefresh=" + this.routeRefresh + ", roundaboutExits=" + this.roundaboutExits + ", dateTime=" + this.dateTime + ", soc=" + this.soc + ", batteryCapacity=" + this.batteryCapacity + ", mass=" + this.mass + ", efficiency=" + this.efficiency + ", aux=" + this.aux + ", regen=" + this.regen + "}";
            }

            public boolean equals(Object obj) {
                String str22;
                Boolean bool11;
                String str23;
                String str24;
                String str25;
                Boolean bool12;
                String str26;
                Boolean bool13;
                String str27;
                String str28;
                Boolean bool14;
                Boolean bool15;
                Boolean bool16;
                Boolean bool17;
                String str29;
                String str30;
                String str31;
                String str32;
                String str33;
                String str34;
                String str35;
                WalkingOptions walkingOptions2;
                Integer num4;
                Boolean bool18;
                Boolean bool19;
                Boolean bool20;
                String str36;
                String str37;
                Integer num5;
                Integer num6;
                Double d4;
                Double d5;
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof RouteOptions)) {
                    return false;
                }
                RouteOptions routeOptions = (RouteOptions) obj;
                if (this.baseUrl.equals(routeOptions.baseUrl()) && ((str22 = this.deviceID) != null ? str22.equals(routeOptions.deviceID()) : routeOptions.deviceID() == null) && this.user.equals(routeOptions.user()) && this.profile.equals(routeOptions.profile()) && this.resource.equals(routeOptions.resource()) && this.coordinates.equals(routeOptions.coordinates()) && ((bool11 = this.alternatives) != null ? bool11.equals(routeOptions.alternatives()) : routeOptions.alternatives() == null) && ((str23 = this.language) != null ? str23.equals(routeOptions.language()) : routeOptions.language() == null) && ((str24 = this.radiuses) != null ? str24.equals(routeOptions.radiuses()) : routeOptions.radiuses() == null) && ((str25 = this.bearings) != null ? str25.equals(routeOptions.bearings()) : routeOptions.bearings() == null) && ((bool12 = this.lessVerbose) != null ? bool12.equals(routeOptions.lessVerbose()) : routeOptions.lessVerbose() == null) && this.geometries.equals(routeOptions.geometries()) && ((str26 = this.overview) != null ? str26.equals(routeOptions.overview()) : routeOptions.overview() == null) && ((bool13 = this.steps) != null ? bool13.equals(routeOptions.steps()) : routeOptions.steps() == null) && ((str27 = this.annotations) != null ? str27.equals(routeOptions.annotations()) : routeOptions.annotations() == null) && ((str28 = this.exclude) != null ? str28.equals(routeOptions.exclude()) : routeOptions.exclude() == null) && ((bool14 = this.continueStraight) != null ? bool14.equals(routeOptions.continueStraight()) : routeOptions.continueStraight() == null) && ((bool15 = this.bannerInstructions) != null ? bool15.equals(routeOptions.bannerInstructions()) : routeOptions.bannerInstructions() == null) && ((bool16 = this.instructions) != null ? bool16.equals(routeOptions.instructions()) : routeOptions.instructions() == null) && ((bool17 = this.skipWaypoints) != null ? bool17.equals(routeOptions.skipWaypoints()) : routeOptions.skipWaypoints() == null) && ((str29 = this.accessToken) != null ? str29.equals(routeOptions.accessToken()) : routeOptions.accessToken() == null) && ((str30 = this.requestUuid) != null ? str30.equals(routeOptions.requestUuid()) : routeOptions.requestUuid() == null) && ((str31 = this.sessionId) != null ? str31.equals(routeOptions.sessionId()) : routeOptions.sessionId() == null) && ((str32 = this.approaches) != null ? str32.equals(routeOptions.approaches()) : routeOptions.approaches() == null) && ((str33 = this.waypointIndices) != null ? str33.equals(routeOptions.waypointIndices()) : routeOptions.waypointIndices() == null) && ((str34 = this.waypointNames) != null ? str34.equals(routeOptions.waypointNames()) : routeOptions.waypointNames() == null) && ((str35 = this.waypointTargets) != null ? str35.equals(routeOptions.waypointTargets()) : routeOptions.waypointTargets() == null) && ((walkingOptions2 = this.walkingOptions) != null ? walkingOptions2.equals(routeOptions.walkingOptions()) : routeOptions.walkingOptions() == null) && ((num4 = this.routeType) != null ? num4.equals(routeOptions.routeType()) : routeOptions.routeType() == null) && ((bool18 = this.isSort) != null ? bool18.equals(routeOptions.isSort()) : routeOptions.isSort() == null) && ((bool19 = this.routeRefresh) != null ? bool19.equals(routeOptions.routeRefresh()) : routeOptions.routeRefresh() == null) && ((bool20 = this.roundaboutExits) != null ? bool20.equals(routeOptions.roundaboutExits()) : routeOptions.roundaboutExits() == null) && ((str36 = this.dateTime) != null ? str36.equals(routeOptions.dateTime()) : routeOptions.dateTime() == null) && ((str37 = this.soc) != null ? str37.equals(routeOptions.soc()) : routeOptions.soc() == null) && ((num5 = this.batteryCapacity) != null ? num5.equals(routeOptions.batteryCapacity()) : routeOptions.batteryCapacity() == null) && ((num6 = this.mass) != null ? num6.equals(routeOptions.mass()) : routeOptions.mass() == null) && ((d4 = this.efficiency) != null ? d4.equals(routeOptions.efficiency()) : routeOptions.efficiency() == null) && ((d5 = this.aux) != null ? d5.equals(routeOptions.aux()) : routeOptions.aux() == null)) {
                    Double d6 = this.regen;
                    if (d6 == null) {
                        if (routeOptions.regen() == null) {
                            return true;
                        }
                    } else if (d6.equals(routeOptions.regen())) {
                        return true;
                    }
                }
                return false;
            }

            public int hashCode() {
                int iHashCode = (this.baseUrl.hashCode() ^ 1000003) * 1000003;
                String str22 = this.deviceID;
                int iHashCode2 = (((((((((iHashCode ^ (str22 == null ? 0 : str22.hashCode())) * 1000003) ^ this.user.hashCode()) * 1000003) ^ this.profile.hashCode()) * 1000003) ^ this.resource.hashCode()) * 1000003) ^ this.coordinates.hashCode()) * 1000003;
                Boolean bool11 = this.alternatives;
                int iHashCode3 = (iHashCode2 ^ (bool11 == null ? 0 : bool11.hashCode())) * 1000003;
                String str23 = this.language;
                int iHashCode4 = (iHashCode3 ^ (str23 == null ? 0 : str23.hashCode())) * 1000003;
                String str24 = this.radiuses;
                int iHashCode5 = (iHashCode4 ^ (str24 == null ? 0 : str24.hashCode())) * 1000003;
                String str25 = this.bearings;
                int iHashCode6 = (iHashCode5 ^ (str25 == null ? 0 : str25.hashCode())) * 1000003;
                Boolean bool12 = this.lessVerbose;
                int iHashCode7 = (((iHashCode6 ^ (bool12 == null ? 0 : bool12.hashCode())) * 1000003) ^ this.geometries.hashCode()) * 1000003;
                String str26 = this.overview;
                int iHashCode8 = (iHashCode7 ^ (str26 == null ? 0 : str26.hashCode())) * 1000003;
                Boolean bool13 = this.steps;
                int iHashCode9 = (iHashCode8 ^ (bool13 == null ? 0 : bool13.hashCode())) * 1000003;
                String str27 = this.annotations;
                int iHashCode10 = (iHashCode9 ^ (str27 == null ? 0 : str27.hashCode())) * 1000003;
                String str28 = this.exclude;
                int iHashCode11 = (iHashCode10 ^ (str28 == null ? 0 : str28.hashCode())) * 1000003;
                Boolean bool14 = this.continueStraight;
                int iHashCode12 = (iHashCode11 ^ (bool14 == null ? 0 : bool14.hashCode())) * 1000003;
                Boolean bool15 = this.bannerInstructions;
                int iHashCode13 = (iHashCode12 ^ (bool15 == null ? 0 : bool15.hashCode())) * 1000003;
                Boolean bool16 = this.instructions;
                int iHashCode14 = (iHashCode13 ^ (bool16 == null ? 0 : bool16.hashCode())) * 1000003;
                Boolean bool17 = this.skipWaypoints;
                int iHashCode15 = (iHashCode14 ^ (bool17 == null ? 0 : bool17.hashCode())) * 1000003;
                String str29 = this.accessToken;
                int iHashCode16 = (iHashCode15 ^ (str29 == null ? 0 : str29.hashCode())) * 1000003;
                String str30 = this.requestUuid;
                int iHashCode17 = (iHashCode16 ^ (str30 == null ? 0 : str30.hashCode())) * 1000003;
                String str31 = this.sessionId;
                int iHashCode18 = (iHashCode17 ^ (str31 == null ? 0 : str31.hashCode())) * 1000003;
                String str32 = this.approaches;
                int iHashCode19 = (iHashCode18 ^ (str32 == null ? 0 : str32.hashCode())) * 1000003;
                String str33 = this.waypointIndices;
                int iHashCode20 = (iHashCode19 ^ (str33 == null ? 0 : str33.hashCode())) * 1000003;
                String str34 = this.waypointNames;
                int iHashCode21 = (iHashCode20 ^ (str34 == null ? 0 : str34.hashCode())) * 1000003;
                String str35 = this.waypointTargets;
                int iHashCode22 = (iHashCode21 ^ (str35 == null ? 0 : str35.hashCode())) * 1000003;
                WalkingOptions walkingOptions2 = this.walkingOptions;
                int iHashCode23 = (iHashCode22 ^ (walkingOptions2 == null ? 0 : walkingOptions2.hashCode())) * 1000003;
                Integer num4 = this.routeType;
                int iHashCode24 = (iHashCode23 ^ (num4 == null ? 0 : num4.hashCode())) * 1000003;
                Boolean bool18 = this.isSort;
                int iHashCode25 = (iHashCode24 ^ (bool18 == null ? 0 : bool18.hashCode())) * 1000003;
                Boolean bool19 = this.routeRefresh;
                int iHashCode26 = (iHashCode25 ^ (bool19 == null ? 0 : bool19.hashCode())) * 1000003;
                Boolean bool20 = this.roundaboutExits;
                int iHashCode27 = (iHashCode26 ^ (bool20 == null ? 0 : bool20.hashCode())) * 1000003;
                String str36 = this.dateTime;
                int iHashCode28 = (iHashCode27 ^ (str36 == null ? 0 : str36.hashCode())) * 1000003;
                String str37 = this.soc;
                int iHashCode29 = (iHashCode28 ^ (str37 == null ? 0 : str37.hashCode())) * 1000003;
                Integer num5 = this.batteryCapacity;
                int iHashCode30 = (iHashCode29 ^ (num5 == null ? 0 : num5.hashCode())) * 1000003;
                Integer num6 = this.mass;
                int iHashCode31 = (iHashCode30 ^ (num6 == null ? 0 : num6.hashCode())) * 1000003;
                Double d4 = this.efficiency;
                int iHashCode32 = (iHashCode31 ^ (d4 == null ? 0 : d4.hashCode())) * 1000003;
                Double d5 = this.aux;
                int iHashCode33 = (iHashCode32 ^ (d5 == null ? 0 : d5.hashCode())) * 1000003;
                Double d6 = this.regen;
                return iHashCode33 ^ (d6 != null ? d6.hashCode() : 0);
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteOptions
            public RouteOptions.Builder toBuilder() {
                return new Builder(this);
            }

            /* JADX INFO: renamed from: com.mappls.sdk.services.api.directions.models.$AutoValue_RouteOptions$Builder */
            static class Builder extends RouteOptions.Builder {
                private String accessToken;
                private Boolean alternatives;
                private String annotations;
                private String approaches;
                private Double aux;
                private Boolean bannerInstructions;
                private String baseUrl;
                private Integer batteryCapacity;
                private String bearings;
                private Boolean continueStraight;
                private List<String> coordinates;
                private String dateTime;
                private String deviceID;
                private Double efficiency;
                private String exclude;
                private String geometries;
                private Boolean instructions;
                private Boolean isSort;
                private String language;
                private Boolean lessVerbose;
                private Integer mass;
                private String overview;
                private String profile;
                private String radiuses;
                private Double regen;
                private String requestUuid;
                private String resource;
                private Boolean roundaboutExits;
                private Boolean routeRefresh;
                private Integer routeType;
                private String sessionId;
                private Boolean skipWaypoints;
                private String soc;
                private Boolean steps;
                private String user;
                private WalkingOptions walkingOptions;
                private String waypointIndices;
                private String waypointNames;
                private String waypointTargets;

                Builder() {
                }

                private Builder(RouteOptions routeOptions) {
                    this.baseUrl = routeOptions.baseUrl();
                    this.deviceID = routeOptions.deviceID();
                    this.user = routeOptions.user();
                    this.profile = routeOptions.profile();
                    this.resource = routeOptions.resource();
                    this.coordinates = routeOptions.coordinates();
                    this.alternatives = routeOptions.alternatives();
                    this.language = routeOptions.language();
                    this.radiuses = routeOptions.radiuses();
                    this.bearings = routeOptions.bearings();
                    this.lessVerbose = routeOptions.lessVerbose();
                    this.geometries = routeOptions.geometries();
                    this.overview = routeOptions.overview();
                    this.steps = routeOptions.steps();
                    this.annotations = routeOptions.annotations();
                    this.exclude = routeOptions.exclude();
                    this.continueStraight = routeOptions.continueStraight();
                    this.bannerInstructions = routeOptions.bannerInstructions();
                    this.instructions = routeOptions.instructions();
                    this.skipWaypoints = routeOptions.skipWaypoints();
                    this.accessToken = routeOptions.accessToken();
                    this.requestUuid = routeOptions.requestUuid();
                    this.sessionId = routeOptions.sessionId();
                    this.approaches = routeOptions.approaches();
                    this.waypointIndices = routeOptions.waypointIndices();
                    this.waypointNames = routeOptions.waypointNames();
                    this.waypointTargets = routeOptions.waypointTargets();
                    this.walkingOptions = routeOptions.walkingOptions();
                    this.routeType = routeOptions.routeType();
                    this.isSort = routeOptions.isSort();
                    this.routeRefresh = routeOptions.routeRefresh();
                    this.roundaboutExits = routeOptions.roundaboutExits();
                    this.dateTime = routeOptions.dateTime();
                    this.soc = routeOptions.soc();
                    this.batteryCapacity = routeOptions.batteryCapacity();
                    this.mass = routeOptions.mass();
                    this.efficiency = routeOptions.efficiency();
                    this.aux = routeOptions.aux();
                    this.regen = routeOptions.regen();
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder baseUrl(String str) {
                    if (str == null) {
                        throw new NullPointerException("Null baseUrl");
                    }
                    this.baseUrl = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder deviceID(String str) {
                    this.deviceID = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder user(String str) {
                    if (str == null) {
                        throw new NullPointerException("Null user");
                    }
                    this.user = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder profile(String str) {
                    if (str == null) {
                        throw new NullPointerException("Null profile");
                    }
                    this.profile = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder resource(String str) {
                    if (str == null) {
                        throw new NullPointerException("Null resource");
                    }
                    this.resource = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder coordinates(List<String> list) {
                    if (list == null) {
                        throw new NullPointerException("Null coordinates");
                    }
                    this.coordinates = list;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder alternatives(Boolean bool) {
                    this.alternatives = bool;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder language(String str) {
                    this.language = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder radiuses(String str) {
                    this.radiuses = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder bearings(String str) {
                    this.bearings = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder lessVerbose(Boolean bool) {
                    this.lessVerbose = bool;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder geometries(String str) {
                    if (str == null) {
                        throw new NullPointerException("Null geometries");
                    }
                    this.geometries = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder overview(String str) {
                    this.overview = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder steps(Boolean bool) {
                    this.steps = bool;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder annotations(String str) {
                    this.annotations = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder exclude(String str) {
                    this.exclude = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder continueStraight(Boolean bool) {
                    this.continueStraight = bool;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder bannerInstructions(Boolean bool) {
                    this.bannerInstructions = bool;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder instructions(Boolean bool) {
                    this.instructions = bool;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder skipWaypoints(Boolean bool) {
                    this.skipWaypoints = bool;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder accessToken(String str) {
                    this.accessToken = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder requestUuid(String str) {
                    this.requestUuid = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder sessionId(String str) {
                    this.sessionId = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder approaches(String str) {
                    this.approaches = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder waypointIndices(String str) {
                    this.waypointIndices = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder waypointNames(String str) {
                    this.waypointNames = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder waypointTargets(String str) {
                    this.waypointTargets = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder walkingOptions(WalkingOptions walkingOptions) {
                    this.walkingOptions = walkingOptions;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder routeType(Integer num) {
                    this.routeType = num;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder isSort(Boolean bool) {
                    this.isSort = bool;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder routeRefresh(Boolean bool) {
                    this.routeRefresh = bool;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder roundaboutExits(Boolean bool) {
                    this.roundaboutExits = bool;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder dateTime(String str) {
                    this.dateTime = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder soc(String str) {
                    this.soc = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder batteryCapacity(Integer num) {
                    this.batteryCapacity = num;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder mass(Integer num) {
                    this.mass = num;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder efficiency(Double d) {
                    this.efficiency = d;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder aux(Double d) {
                    this.aux = d;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions.Builder regen(Double d) {
                    this.regen = d;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteOptions.Builder
                public RouteOptions build() {
                    String str;
                    String str2;
                    String str3;
                    List<String> list;
                    String str4;
                    String str5 = this.baseUrl;
                    if (str5 == null || (str = this.user) == null || (str2 = this.profile) == null || (str3 = this.resource) == null || (list = this.coordinates) == null || (str4 = this.geometries) == null) {
                        StringBuilder sb = new StringBuilder();
                        if (this.baseUrl == null) {
                            sb.append(" baseUrl");
                        }
                        if (this.user == null) {
                            sb.append(" user");
                        }
                        if (this.profile == null) {
                            sb.append(" profile");
                        }
                        if (this.resource == null) {
                            sb.append(" resource");
                        }
                        if (this.coordinates == null) {
                            sb.append(" coordinates");
                        }
                        if (this.geometries == null) {
                            sb.append(" geometries");
                        }
                        throw new IllegalStateException("Missing required properties:" + ((Object) sb));
                    }
                    return new AutoValue_RouteOptions(str5, this.deviceID, str, str2, str3, list, this.alternatives, this.language, this.radiuses, this.bearings, this.lessVerbose, str4, this.overview, this.steps, this.annotations, this.exclude, this.continueStraight, this.bannerInstructions, this.instructions, this.skipWaypoints, this.accessToken, this.requestUuid, this.sessionId, this.approaches, this.waypointIndices, this.waypointNames, this.waypointTargets, this.walkingOptions, this.routeType, this.isSort, this.routeRefresh, this.roundaboutExits, this.dateTime, this.soc, this.batteryCapacity, this.mass, this.efficiency, this.aux, this.regen);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<RouteOptions> {
        private volatile TypeAdapter<Boolean> boolean__adapter;
        private volatile TypeAdapter<Double> double__adapter;
        private final Gson gson;
        private volatile TypeAdapter<Integer> integer_adapter;
        private volatile TypeAdapter<List<String>> list__string_adapter;
        private volatile TypeAdapter<String> string_adapter;
        private volatile TypeAdapter<WalkingOptions> walkingOptions_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, RouteOptions routeOptions) throws IOException {
            if (routeOptions == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("baseUrl");
            if (routeOptions.baseUrl() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter = this.string_adapter;
                if (adapter == null) {
                    adapter = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter;
                }
                adapter.write(jsonWriter, routeOptions.baseUrl());
            }
            jsonWriter.name("deviceID");
            if (routeOptions.deviceID() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter2 = this.string_adapter;
                if (adapter2 == null) {
                    adapter2 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter2;
                }
                adapter2.write(jsonWriter, routeOptions.deviceID());
            }
            jsonWriter.name("user");
            if (routeOptions.user() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter3 = this.string_adapter;
                if (adapter3 == null) {
                    adapter3 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter3;
                }
                adapter3.write(jsonWriter, routeOptions.user());
            }
            jsonWriter.name(Scopes.PROFILE);
            if (routeOptions.profile() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter4 = this.string_adapter;
                if (adapter4 == null) {
                    adapter4 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter4;
                }
                adapter4.write(jsonWriter, routeOptions.profile());
            }
            jsonWriter.name("resource");
            if (routeOptions.resource() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter5 = this.string_adapter;
                if (adapter5 == null) {
                    adapter5 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter5;
                }
                adapter5.write(jsonWriter, routeOptions.resource());
            }
            jsonWriter.name("coordinates");
            if (routeOptions.coordinates() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<String>> adapter6 = this.list__string_adapter;
                if (adapter6 == null) {
                    adapter6 = this.gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
                    this.list__string_adapter = adapter6;
                }
                adapter6.write(jsonWriter, routeOptions.coordinates());
            }
            jsonWriter.name("alternatives");
            if (routeOptions.alternatives() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> adapter7 = this.boolean__adapter;
                if (adapter7 == null) {
                    adapter7 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = adapter7;
                }
                adapter7.write(jsonWriter, routeOptions.alternatives());
            }
            jsonWriter.name("language");
            if (routeOptions.language() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter8 = this.string_adapter;
                if (adapter8 == null) {
                    adapter8 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter8;
                }
                adapter8.write(jsonWriter, routeOptions.language());
            }
            jsonWriter.name("radiuses");
            if (routeOptions.radiuses() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter9 = this.string_adapter;
                if (adapter9 == null) {
                    adapter9 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter9;
                }
                adapter9.write(jsonWriter, routeOptions.radiuses());
            }
            jsonWriter.name("bearings");
            if (routeOptions.bearings() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter10 = this.string_adapter;
                if (adapter10 == null) {
                    adapter10 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter10;
                }
                adapter10.write(jsonWriter, routeOptions.bearings());
            }
            jsonWriter.name("lessverbose");
            if (routeOptions.lessVerbose() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> adapter11 = this.boolean__adapter;
                if (adapter11 == null) {
                    adapter11 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = adapter11;
                }
                adapter11.write(jsonWriter, routeOptions.lessVerbose());
            }
            jsonWriter.name("geometries");
            if (routeOptions.geometries() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter12 = this.string_adapter;
                if (adapter12 == null) {
                    adapter12 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter12;
                }
                adapter12.write(jsonWriter, routeOptions.geometries());
            }
            jsonWriter.name("overview");
            if (routeOptions.overview() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter13 = this.string_adapter;
                if (adapter13 == null) {
                    adapter13 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter13;
                }
                adapter13.write(jsonWriter, routeOptions.overview());
            }
            jsonWriter.name("steps");
            if (routeOptions.steps() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> adapter14 = this.boolean__adapter;
                if (adapter14 == null) {
                    adapter14 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = adapter14;
                }
                adapter14.write(jsonWriter, routeOptions.steps());
            }
            jsonWriter.name("annotations");
            if (routeOptions.annotations() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter15 = this.string_adapter;
                if (adapter15 == null) {
                    adapter15 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter15;
                }
                adapter15.write(jsonWriter, routeOptions.annotations());
            }
            jsonWriter.name("exclude");
            if (routeOptions.exclude() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter16 = this.string_adapter;
                if (adapter16 == null) {
                    adapter16 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter16;
                }
                adapter16.write(jsonWriter, routeOptions.exclude());
            }
            jsonWriter.name("continueStraight");
            if (routeOptions.continueStraight() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> adapter17 = this.boolean__adapter;
                if (adapter17 == null) {
                    adapter17 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = adapter17;
                }
                adapter17.write(jsonWriter, routeOptions.continueStraight());
            }
            jsonWriter.name("banner_instructions");
            if (routeOptions.bannerInstructions() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> adapter18 = this.boolean__adapter;
                if (adapter18 == null) {
                    adapter18 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = adapter18;
                }
                adapter18.write(jsonWriter, routeOptions.bannerInstructions());
            }
            jsonWriter.name("instructions");
            if (routeOptions.instructions() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> adapter19 = this.boolean__adapter;
                if (adapter19 == null) {
                    adapter19 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = adapter19;
                }
                adapter19.write(jsonWriter, routeOptions.instructions());
            }
            jsonWriter.name("skip_waypoints");
            if (routeOptions.skipWaypoints() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> adapter20 = this.boolean__adapter;
                if (adapter20 == null) {
                    adapter20 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = adapter20;
                }
                adapter20.write(jsonWriter, routeOptions.skipWaypoints());
            }
            jsonWriter.name(AccountsQueryParameters.ACCESS_TOKEN);
            if (routeOptions.accessToken() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter21 = this.string_adapter;
                if (adapter21 == null) {
                    adapter21 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter21;
                }
                adapter21.write(jsonWriter, routeOptions.accessToken());
            }
            jsonWriter.name("uuid");
            if (routeOptions.requestUuid() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter22 = this.string_adapter;
                if (adapter22 == null) {
                    adapter22 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter22;
                }
                adapter22.write(jsonWriter, routeOptions.requestUuid());
            }
            jsonWriter.name("sessionId");
            if (routeOptions.sessionId() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter23 = this.string_adapter;
                if (adapter23 == null) {
                    adapter23 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter23;
                }
                adapter23.write(jsonWriter, routeOptions.sessionId());
            }
            jsonWriter.name("approaches");
            if (routeOptions.approaches() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter24 = this.string_adapter;
                if (adapter24 == null) {
                    adapter24 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter24;
                }
                adapter24.write(jsonWriter, routeOptions.approaches());
            }
            jsonWriter.name("waypoints");
            if (routeOptions.waypointIndices() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter25 = this.string_adapter;
                if (adapter25 == null) {
                    adapter25 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter25;
                }
                adapter25.write(jsonWriter, routeOptions.waypointIndices());
            }
            jsonWriter.name("waypoint_names");
            if (routeOptions.waypointNames() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter26 = this.string_adapter;
                if (adapter26 == null) {
                    adapter26 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter26;
                }
                adapter26.write(jsonWriter, routeOptions.waypointNames());
            }
            jsonWriter.name("waypoint_targets");
            if (routeOptions.waypointTargets() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter27 = this.string_adapter;
                if (adapter27 == null) {
                    adapter27 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter27;
                }
                adapter27.write(jsonWriter, routeOptions.waypointTargets());
            }
            jsonWriter.name("walkingOptions");
            if (routeOptions.walkingOptions() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<WalkingOptions> adapter28 = this.walkingOptions_adapter;
                if (adapter28 == null) {
                    adapter28 = this.gson.getAdapter(WalkingOptions.class);
                    this.walkingOptions_adapter = adapter28;
                }
                adapter28.write(jsonWriter, routeOptions.walkingOptions());
            }
            jsonWriter.name("routeType");
            if (routeOptions.routeType() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> adapter29 = this.integer_adapter;
                if (adapter29 == null) {
                    adapter29 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = adapter29;
                }
                adapter29.write(jsonWriter, routeOptions.routeType());
            }
            jsonWriter.name("isSort");
            if (routeOptions.isSort() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> adapter30 = this.boolean__adapter;
                if (adapter30 == null) {
                    adapter30 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = adapter30;
                }
                adapter30.write(jsonWriter, routeOptions.isSort());
            }
            jsonWriter.name("routeRefresh");
            if (routeOptions.routeRefresh() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> adapter31 = this.boolean__adapter;
                if (adapter31 == null) {
                    adapter31 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = adapter31;
                }
                adapter31.write(jsonWriter, routeOptions.routeRefresh());
            }
            jsonWriter.name("roundaboutExits");
            if (routeOptions.roundaboutExits() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> adapter32 = this.boolean__adapter;
                if (adapter32 == null) {
                    adapter32 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = adapter32;
                }
                adapter32.write(jsonWriter, routeOptions.roundaboutExits());
            }
            jsonWriter.name("dateTime");
            if (routeOptions.dateTime() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter33 = this.string_adapter;
                if (adapter33 == null) {
                    adapter33 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter33;
                }
                adapter33.write(jsonWriter, routeOptions.dateTime());
            }
            jsonWriter.name("soc");
            if (routeOptions.soc() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter34 = this.string_adapter;
                if (adapter34 == null) {
                    adapter34 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter34;
                }
                adapter34.write(jsonWriter, routeOptions.soc());
            }
            jsonWriter.name("batteryCapacity");
            if (routeOptions.batteryCapacity() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> adapter35 = this.integer_adapter;
                if (adapter35 == null) {
                    adapter35 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = adapter35;
                }
                adapter35.write(jsonWriter, routeOptions.batteryCapacity());
            }
            jsonWriter.name("mass");
            if (routeOptions.mass() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> adapter36 = this.integer_adapter;
                if (adapter36 == null) {
                    adapter36 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = adapter36;
                }
                adapter36.write(jsonWriter, routeOptions.mass());
            }
            jsonWriter.name("efficiency");
            if (routeOptions.efficiency() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> adapter37 = this.double__adapter;
                if (adapter37 == null) {
                    adapter37 = this.gson.getAdapter(Double.class);
                    this.double__adapter = adapter37;
                }
                adapter37.write(jsonWriter, routeOptions.efficiency());
            }
            jsonWriter.name("aux");
            if (routeOptions.aux() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> adapter38 = this.double__adapter;
                if (adapter38 == null) {
                    adapter38 = this.gson.getAdapter(Double.class);
                    this.double__adapter = adapter38;
                }
                adapter38.write(jsonWriter, routeOptions.aux());
            }
            jsonWriter.name("regen");
            if (routeOptions.regen() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> adapter39 = this.double__adapter;
                if (adapter39 == null) {
                    adapter39 = this.gson.getAdapter(Double.class);
                    this.double__adapter = adapter39;
                }
                adapter39.write(jsonWriter, routeOptions.regen());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unexpected iteration count in SwitchBreakVisitor. Please report as an issue */
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: read */
        public RouteOptions read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            RouteOptions.Builder builder = RouteOptions.builder();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    strNextName.hashCode();
                    switch (strNextName) {
                        case "banner_instructions":
                            TypeAdapter<Boolean> adapter = this.boolean__adapter;
                            if (adapter == null) {
                                adapter = this.gson.getAdapter(Boolean.class);
                                this.boolean__adapter = adapter;
                            }
                            builder.bannerInstructions(adapter.read2(jsonReader));
                            break;
                        case "lessverbose":
                            TypeAdapter<Boolean> adapter2 = this.boolean__adapter;
                            if (adapter2 == null) {
                                adapter2 = this.gson.getAdapter(Boolean.class);
                                this.boolean__adapter = adapter2;
                            }
                            builder.lessVerbose(adapter2.read2(jsonReader));
                            break;
                        case "access_token":
                            TypeAdapter<String> adapter3 = this.string_adapter;
                            if (adapter3 == null) {
                                adapter3 = this.gson.getAdapter(String.class);
                                this.string_adapter = adapter3;
                            }
                            builder.accessToken(adapter3.read2(jsonReader));
                            break;
                        case "waypoint_targets":
                            TypeAdapter<String> adapter4 = this.string_adapter;
                            if (adapter4 == null) {
                                adapter4 = this.gson.getAdapter(String.class);
                                this.string_adapter = adapter4;
                            }
                            builder.waypointTargets(adapter4.read2(jsonReader));
                            break;
                        case "uuid":
                            TypeAdapter<String> adapter5 = this.string_adapter;
                            if (adapter5 == null) {
                                adapter5 = this.gson.getAdapter(String.class);
                                this.string_adapter = adapter5;
                            }
                            builder.requestUuid(adapter5.read2(jsonReader));
                            break;
                        case "continueStraight":
                            TypeAdapter<Boolean> adapter6 = this.boolean__adapter;
                            if (adapter6 == null) {
                                adapter6 = this.gson.getAdapter(Boolean.class);
                                this.boolean__adapter = adapter6;
                            }
                            builder.continueStraight(adapter6.read2(jsonReader));
                            break;
                        case "waypoints":
                            TypeAdapter<String> adapter7 = this.string_adapter;
                            if (adapter7 == null) {
                                adapter7 = this.gson.getAdapter(String.class);
                                this.string_adapter = adapter7;
                            }
                            builder.waypointIndices(adapter7.read2(jsonReader));
                            break;
                        case "waypoint_names":
                            TypeAdapter<String> adapter8 = this.string_adapter;
                            if (adapter8 == null) {
                                adapter8 = this.gson.getAdapter(String.class);
                                this.string_adapter = adapter8;
                            }
                            builder.waypointNames(adapter8.read2(jsonReader));
                            break;
                        case "sessionId":
                            TypeAdapter<String> adapter9 = this.string_adapter;
                            if (adapter9 == null) {
                                adapter9 = this.gson.getAdapter(String.class);
                                this.string_adapter = adapter9;
                            }
                            builder.sessionId(adapter9.read2(jsonReader));
                            break;
                        case "skip_waypoints":
                            TypeAdapter<Boolean> adapter10 = this.boolean__adapter;
                            if (adapter10 == null) {
                                adapter10 = this.gson.getAdapter(Boolean.class);
                                this.boolean__adapter = adapter10;
                            }
                            builder.skipWaypoints(adapter10.read2(jsonReader));
                            break;
                        case "instructions":
                            TypeAdapter<Boolean> adapter11 = this.boolean__adapter;
                            if (adapter11 == null) {
                                adapter11 = this.gson.getAdapter(Boolean.class);
                                this.boolean__adapter = adapter11;
                            }
                            builder.instructions(adapter11.read2(jsonReader));
                            break;
                        default:
                            if ("baseUrl".equals(strNextName)) {
                                TypeAdapter<String> adapter12 = this.string_adapter;
                                if (adapter12 == null) {
                                    adapter12 = this.gson.getAdapter(String.class);
                                    this.string_adapter = adapter12;
                                }
                                builder.baseUrl(adapter12.read2(jsonReader));
                                break;
                            } else if ("deviceID".equals(strNextName)) {
                                TypeAdapter<String> adapter13 = this.string_adapter;
                                if (adapter13 == null) {
                                    adapter13 = this.gson.getAdapter(String.class);
                                    this.string_adapter = adapter13;
                                }
                                builder.deviceID(adapter13.read2(jsonReader));
                                break;
                            } else if ("user".equals(strNextName)) {
                                TypeAdapter<String> adapter14 = this.string_adapter;
                                if (adapter14 == null) {
                                    adapter14 = this.gson.getAdapter(String.class);
                                    this.string_adapter = adapter14;
                                }
                                builder.user(adapter14.read2(jsonReader));
                                break;
                            } else if (Scopes.PROFILE.equals(strNextName)) {
                                TypeAdapter<String> adapter15 = this.string_adapter;
                                if (adapter15 == null) {
                                    adapter15 = this.gson.getAdapter(String.class);
                                    this.string_adapter = adapter15;
                                }
                                builder.profile(adapter15.read2(jsonReader));
                                break;
                            } else if ("resource".equals(strNextName)) {
                                TypeAdapter<String> adapter16 = this.string_adapter;
                                if (adapter16 == null) {
                                    adapter16 = this.gson.getAdapter(String.class);
                                    this.string_adapter = adapter16;
                                }
                                builder.resource(adapter16.read2(jsonReader));
                                break;
                            } else if ("coordinates".equals(strNextName)) {
                                TypeAdapter<List<String>> adapter17 = this.list__string_adapter;
                                if (adapter17 == null) {
                                    adapter17 = this.gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
                                    this.list__string_adapter = adapter17;
                                }
                                builder.coordinates(adapter17.read2(jsonReader));
                                break;
                            } else {
                                if ("alternatives".equals(strNextName)) {
                                    TypeAdapter<Boolean> adapter18 = this.boolean__adapter;
                                    if (adapter18 == null) {
                                        adapter18 = this.gson.getAdapter(Boolean.class);
                                        this.boolean__adapter = adapter18;
                                    }
                                    builder.alternatives(adapter18.read2(jsonReader));
                                } else if ("language".equals(strNextName)) {
                                    TypeAdapter<String> adapter19 = this.string_adapter;
                                    if (adapter19 == null) {
                                        adapter19 = this.gson.getAdapter(String.class);
                                        this.string_adapter = adapter19;
                                    }
                                    builder.language(adapter19.read2(jsonReader));
                                } else if ("radiuses".equals(strNextName)) {
                                    TypeAdapter<String> adapter20 = this.string_adapter;
                                    if (adapter20 == null) {
                                        adapter20 = this.gson.getAdapter(String.class);
                                        this.string_adapter = adapter20;
                                    }
                                    builder.radiuses(adapter20.read2(jsonReader));
                                } else if ("bearings".equals(strNextName)) {
                                    TypeAdapter<String> adapter21 = this.string_adapter;
                                    if (adapter21 == null) {
                                        adapter21 = this.gson.getAdapter(String.class);
                                        this.string_adapter = adapter21;
                                    }
                                    builder.bearings(adapter21.read2(jsonReader));
                                } else if ("geometries".equals(strNextName)) {
                                    TypeAdapter<String> adapter22 = this.string_adapter;
                                    if (adapter22 == null) {
                                        adapter22 = this.gson.getAdapter(String.class);
                                        this.string_adapter = adapter22;
                                    }
                                    builder.geometries(adapter22.read2(jsonReader));
                                } else if ("overview".equals(strNextName)) {
                                    TypeAdapter<String> adapter23 = this.string_adapter;
                                    if (adapter23 == null) {
                                        adapter23 = this.gson.getAdapter(String.class);
                                        this.string_adapter = adapter23;
                                    }
                                    builder.overview(adapter23.read2(jsonReader));
                                } else if ("steps".equals(strNextName)) {
                                    TypeAdapter<Boolean> adapter24 = this.boolean__adapter;
                                    if (adapter24 == null) {
                                        adapter24 = this.gson.getAdapter(Boolean.class);
                                        this.boolean__adapter = adapter24;
                                    }
                                    builder.steps(adapter24.read2(jsonReader));
                                } else if ("annotations".equals(strNextName)) {
                                    TypeAdapter<String> adapter25 = this.string_adapter;
                                    if (adapter25 == null) {
                                        adapter25 = this.gson.getAdapter(String.class);
                                        this.string_adapter = adapter25;
                                    }
                                    builder.annotations(adapter25.read2(jsonReader));
                                } else if ("exclude".equals(strNextName)) {
                                    TypeAdapter<String> adapter26 = this.string_adapter;
                                    if (adapter26 == null) {
                                        adapter26 = this.gson.getAdapter(String.class);
                                        this.string_adapter = adapter26;
                                    }
                                    builder.exclude(adapter26.read2(jsonReader));
                                } else if ("approaches".equals(strNextName)) {
                                    TypeAdapter<String> adapter27 = this.string_adapter;
                                    if (adapter27 == null) {
                                        adapter27 = this.gson.getAdapter(String.class);
                                        this.string_adapter = adapter27;
                                    }
                                    builder.approaches(adapter27.read2(jsonReader));
                                } else if ("walkingOptions".equals(strNextName)) {
                                    TypeAdapter<WalkingOptions> adapter28 = this.walkingOptions_adapter;
                                    if (adapter28 == null) {
                                        adapter28 = this.gson.getAdapter(WalkingOptions.class);
                                        this.walkingOptions_adapter = adapter28;
                                    }
                                    builder.walkingOptions(adapter28.read2(jsonReader));
                                } else if ("routeType".equals(strNextName)) {
                                    TypeAdapter<Integer> adapter29 = this.integer_adapter;
                                    if (adapter29 == null) {
                                        adapter29 = this.gson.getAdapter(Integer.class);
                                        this.integer_adapter = adapter29;
                                    }
                                    builder.routeType(adapter29.read2(jsonReader));
                                } else if ("isSort".equals(strNextName)) {
                                    TypeAdapter<Boolean> adapter30 = this.boolean__adapter;
                                    if (adapter30 == null) {
                                        adapter30 = this.gson.getAdapter(Boolean.class);
                                        this.boolean__adapter = adapter30;
                                    }
                                    builder.isSort(adapter30.read2(jsonReader));
                                } else if ("routeRefresh".equals(strNextName)) {
                                    TypeAdapter<Boolean> adapter31 = this.boolean__adapter;
                                    if (adapter31 == null) {
                                        adapter31 = this.gson.getAdapter(Boolean.class);
                                        this.boolean__adapter = adapter31;
                                    }
                                    builder.routeRefresh(adapter31.read2(jsonReader));
                                } else if ("roundaboutExits".equals(strNextName)) {
                                    TypeAdapter<Boolean> adapter32 = this.boolean__adapter;
                                    if (adapter32 == null) {
                                        adapter32 = this.gson.getAdapter(Boolean.class);
                                        this.boolean__adapter = adapter32;
                                    }
                                    builder.roundaboutExits(adapter32.read2(jsonReader));
                                } else if ("dateTime".equals(strNextName)) {
                                    TypeAdapter<String> adapter33 = this.string_adapter;
                                    if (adapter33 == null) {
                                        adapter33 = this.gson.getAdapter(String.class);
                                        this.string_adapter = adapter33;
                                    }
                                    builder.dateTime(adapter33.read2(jsonReader));
                                } else if ("soc".equals(strNextName)) {
                                    TypeAdapter<String> adapter34 = this.string_adapter;
                                    if (adapter34 == null) {
                                        adapter34 = this.gson.getAdapter(String.class);
                                        this.string_adapter = adapter34;
                                    }
                                    builder.soc(adapter34.read2(jsonReader));
                                } else if ("batteryCapacity".equals(strNextName)) {
                                    TypeAdapter<Integer> adapter35 = this.integer_adapter;
                                    if (adapter35 == null) {
                                        adapter35 = this.gson.getAdapter(Integer.class);
                                        this.integer_adapter = adapter35;
                                    }
                                    builder.batteryCapacity(adapter35.read2(jsonReader));
                                } else if ("mass".equals(strNextName)) {
                                    TypeAdapter<Integer> adapter36 = this.integer_adapter;
                                    if (adapter36 == null) {
                                        adapter36 = this.gson.getAdapter(Integer.class);
                                        this.integer_adapter = adapter36;
                                    }
                                    builder.mass(adapter36.read2(jsonReader));
                                } else if ("efficiency".equals(strNextName)) {
                                    TypeAdapter<Double> adapter37 = this.double__adapter;
                                    if (adapter37 == null) {
                                        adapter37 = this.gson.getAdapter(Double.class);
                                        this.double__adapter = adapter37;
                                    }
                                    builder.efficiency(adapter37.read2(jsonReader));
                                } else if ("aux".equals(strNextName)) {
                                    TypeAdapter<Double> adapter38 = this.double__adapter;
                                    if (adapter38 == null) {
                                        adapter38 = this.gson.getAdapter(Double.class);
                                        this.double__adapter = adapter38;
                                    }
                                    builder.aux(adapter38.read2(jsonReader));
                                } else if ("regen".equals(strNextName)) {
                                    TypeAdapter<Double> adapter39 = this.double__adapter;
                                    if (adapter39 == null) {
                                        adapter39 = this.gson.getAdapter(Double.class);
                                        this.double__adapter = adapter39;
                                    }
                                    builder.regen(adapter39.read2(jsonReader));
                                } else {
                                    jsonReader.skipValue();
                                }
                                break;
                            }
                            break;
                    }
                }
            }
            jsonReader.endObject();
            return builder.build();
        }

        public String toString() {
            return "TypeAdapter(RouteOptions)";
        }
    }
}

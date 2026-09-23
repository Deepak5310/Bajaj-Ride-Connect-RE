package com.mappls.sdk.services.api.directions.models;

import androidx.mediarouter.media.MediaRouteProviderProtocol;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_DirectionsRoute extends C$AutoValue_DirectionsRoute {
    AutoValue_DirectionsRoute(Double d, Double d2, String str, Double d3, String str2, List<RouteLeg> list, RouteOptions routeOptions, Integer num, RouteClasses routeClasses, String str3, List<DirectionsRoute> list2, String str4, String str5, Double d4, Double d5, Double d6, Double d7, Double d8, Double d9) {
        new DirectionsRoute(d, d2, str, d3, str2, list, routeOptions, num, routeClasses, str3, list2, str4, str5, d4, d5, d6, d7, d8, d9) { // from class: com.mappls.sdk.services.api.directions.models.$AutoValue_DirectionsRoute
            private final List<DirectionsRoute> alternatives;
            private final String betterRouteId;
            private final Double distance;
            private final Double dsocd;
            private final Double duration;
            private final String geometry;
            private final List<RouteLeg> legs;
            private final Double rdrd;
            private final Double rdrdm;
            private final RouteClasses routeClasses;
            private final String routeId;
            private final Integer routeIndex;
            private final RouteOptions routeOptions;
            private final Double socdi;
            private final Double socdm;
            private final String summary;
            private final Double tc;
            private final Double weight;
            private final String weightName;

            {
                this.distance = d;
                this.duration = d2;
                this.geometry = str;
                this.weight = d3;
                this.weightName = str2;
                this.legs = list;
                this.routeOptions = routeOptions;
                this.routeIndex = num;
                this.routeClasses = routeClasses;
                this.summary = str3;
                this.alternatives = list2;
                this.betterRouteId = str4;
                this.routeId = str5;
                this.rdrd = d4;
                this.rdrdm = d5;
                this.dsocd = d6;
                this.socdi = d7;
                this.socdm = d8;
                this.tc = d9;
            }

            @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute
            public Double distance() {
                return this.distance;
            }

            @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute
            public Double duration() {
                return this.duration;
            }

            @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute
            public String geometry() {
                return this.geometry;
            }

            @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute
            public Double weight() {
                return this.weight;
            }

            @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute
            @SerializedName("weight_name")
            public String weightName() {
                return this.weightName;
            }

            @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute
            public List<RouteLeg> legs() {
                return this.legs;
            }

            @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute
            public RouteOptions routeOptions() {
                return this.routeOptions;
            }

            @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute
            public Integer routeIndex() {
                return this.routeIndex;
            }

            @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute
            @SerializedName("contains_classes")
            public RouteClasses routeClasses() {
                return this.routeClasses;
            }

            @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute
            public String summary() {
                return this.summary;
            }

            @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute
            public List<DirectionsRoute> alternatives() {
                return this.alternatives;
            }

            @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute
            public String betterRouteId() {
                return this.betterRouteId;
            }

            @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute
            public String routeId() {
                return this.routeId;
            }

            @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute
            public Double rdrd() {
                return this.rdrd;
            }

            @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute
            public Double rdrdm() {
                return this.rdrdm;
            }

            @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute
            public Double dsocd() {
                return this.dsocd;
            }

            @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute
            public Double socdi() {
                return this.socdi;
            }

            @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute
            public Double socdm() {
                return this.socdm;
            }

            @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute
            public Double tc() {
                return this.tc;
            }

            public String toString() {
                return "DirectionsRoute{distance=" + this.distance + ", duration=" + this.duration + ", geometry=" + this.geometry + ", weight=" + this.weight + ", weightName=" + this.weightName + ", legs=" + this.legs + ", routeOptions=" + this.routeOptions + ", routeIndex=" + this.routeIndex + ", routeClasses=" + this.routeClasses + ", summary=" + this.summary + ", alternatives=" + this.alternatives + ", betterRouteId=" + this.betterRouteId + ", routeId=" + this.routeId + ", rdrd=" + this.rdrd + ", rdrdm=" + this.rdrdm + ", dsocd=" + this.dsocd + ", socdi=" + this.socdi + ", socdm=" + this.socdm + ", tc=" + this.tc + "}";
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof DirectionsRoute)) {
                    return false;
                }
                DirectionsRoute directionsRoute = (DirectionsRoute) obj;
                Double d10 = this.distance;
                if (d10 != null ? d10.equals(directionsRoute.distance()) : directionsRoute.distance() == null) {
                    Double d11 = this.duration;
                    if (d11 != null ? d11.equals(directionsRoute.duration()) : directionsRoute.duration() == null) {
                        String str6 = this.geometry;
                        if (str6 != null ? str6.equals(directionsRoute.geometry()) : directionsRoute.geometry() == null) {
                            Double d12 = this.weight;
                            if (d12 != null ? d12.equals(directionsRoute.weight()) : directionsRoute.weight() == null) {
                                String str7 = this.weightName;
                                if (str7 != null ? str7.equals(directionsRoute.weightName()) : directionsRoute.weightName() == null) {
                                    List<RouteLeg> list3 = this.legs;
                                    if (list3 != null ? list3.equals(directionsRoute.legs()) : directionsRoute.legs() == null) {
                                        RouteOptions routeOptions2 = this.routeOptions;
                                        if (routeOptions2 != null ? routeOptions2.equals(directionsRoute.routeOptions()) : directionsRoute.routeOptions() == null) {
                                            Integer num2 = this.routeIndex;
                                            if (num2 != null ? num2.equals(directionsRoute.routeIndex()) : directionsRoute.routeIndex() == null) {
                                                RouteClasses routeClasses2 = this.routeClasses;
                                                if (routeClasses2 != null ? routeClasses2.equals(directionsRoute.routeClasses()) : directionsRoute.routeClasses() == null) {
                                                    String str8 = this.summary;
                                                    if (str8 != null ? str8.equals(directionsRoute.summary()) : directionsRoute.summary() == null) {
                                                        List<DirectionsRoute> list4 = this.alternatives;
                                                        if (list4 != null ? list4.equals(directionsRoute.alternatives()) : directionsRoute.alternatives() == null) {
                                                            String str9 = this.betterRouteId;
                                                            if (str9 != null ? str9.equals(directionsRoute.betterRouteId()) : directionsRoute.betterRouteId() == null) {
                                                                String str10 = this.routeId;
                                                                if (str10 != null ? str10.equals(directionsRoute.routeId()) : directionsRoute.routeId() == null) {
                                                                    Double d13 = this.rdrd;
                                                                    if (d13 != null ? d13.equals(directionsRoute.rdrd()) : directionsRoute.rdrd() == null) {
                                                                        Double d14 = this.rdrdm;
                                                                        if (d14 != null ? d14.equals(directionsRoute.rdrdm()) : directionsRoute.rdrdm() == null) {
                                                                            Double d15 = this.dsocd;
                                                                            if (d15 != null ? d15.equals(directionsRoute.dsocd()) : directionsRoute.dsocd() == null) {
                                                                                Double d16 = this.socdi;
                                                                                if (d16 != null ? d16.equals(directionsRoute.socdi()) : directionsRoute.socdi() == null) {
                                                                                    Double d17 = this.socdm;
                                                                                    if (d17 != null ? d17.equals(directionsRoute.socdm()) : directionsRoute.socdm() == null) {
                                                                                        Double d18 = this.tc;
                                                                                        if (d18 == null) {
                                                                                            if (directionsRoute.tc() == null) {
                                                                                                return true;
                                                                                            }
                                                                                        } else if (d18.equals(directionsRoute.tc())) {
                                                                                            return true;
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            }

            public int hashCode() {
                Double d10 = this.distance;
                int iHashCode = ((d10 == null ? 0 : d10.hashCode()) ^ 1000003) * 1000003;
                Double d11 = this.duration;
                int iHashCode2 = (iHashCode ^ (d11 == null ? 0 : d11.hashCode())) * 1000003;
                String str6 = this.geometry;
                int iHashCode3 = (iHashCode2 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
                Double d12 = this.weight;
                int iHashCode4 = (iHashCode3 ^ (d12 == null ? 0 : d12.hashCode())) * 1000003;
                String str7 = this.weightName;
                int iHashCode5 = (iHashCode4 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
                List<RouteLeg> list3 = this.legs;
                int iHashCode6 = (iHashCode5 ^ (list3 == null ? 0 : list3.hashCode())) * 1000003;
                RouteOptions routeOptions2 = this.routeOptions;
                int iHashCode7 = (iHashCode6 ^ (routeOptions2 == null ? 0 : routeOptions2.hashCode())) * 1000003;
                Integer num2 = this.routeIndex;
                int iHashCode8 = (iHashCode7 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
                RouteClasses routeClasses2 = this.routeClasses;
                int iHashCode9 = (iHashCode8 ^ (routeClasses2 == null ? 0 : routeClasses2.hashCode())) * 1000003;
                String str8 = this.summary;
                int iHashCode10 = (iHashCode9 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
                List<DirectionsRoute> list4 = this.alternatives;
                int iHashCode11 = (iHashCode10 ^ (list4 == null ? 0 : list4.hashCode())) * 1000003;
                String str9 = this.betterRouteId;
                int iHashCode12 = (iHashCode11 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
                String str10 = this.routeId;
                int iHashCode13 = (iHashCode12 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
                Double d13 = this.rdrd;
                int iHashCode14 = (iHashCode13 ^ (d13 == null ? 0 : d13.hashCode())) * 1000003;
                Double d14 = this.rdrdm;
                int iHashCode15 = (iHashCode14 ^ (d14 == null ? 0 : d14.hashCode())) * 1000003;
                Double d15 = this.dsocd;
                int iHashCode16 = (iHashCode15 ^ (d15 == null ? 0 : d15.hashCode())) * 1000003;
                Double d16 = this.socdi;
                int iHashCode17 = (iHashCode16 ^ (d16 == null ? 0 : d16.hashCode())) * 1000003;
                Double d17 = this.socdm;
                int iHashCode18 = (iHashCode17 ^ (d17 == null ? 0 : d17.hashCode())) * 1000003;
                Double d18 = this.tc;
                return iHashCode18 ^ (d18 != null ? d18.hashCode() : 0);
            }

            @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute
            public DirectionsRoute.Builder toBuilder() {
                return new Builder(this);
            }

            /* JADX INFO: renamed from: com.mappls.sdk.services.api.directions.models.$AutoValue_DirectionsRoute$Builder */
            static class Builder extends DirectionsRoute.Builder {
                private List<DirectionsRoute> alternatives;
                private String betterRouteId;
                private Double distance;
                private Double dsocd;
                private Double duration;
                private String geometry;
                private List<RouteLeg> legs;
                private Double rdrd;
                private Double rdrdm;
                private RouteClasses routeClasses;
                private String routeId;
                private Integer routeIndex;
                private RouteOptions routeOptions;
                private Double socdi;
                private Double socdm;
                private String summary;
                private Double tc;
                private Double weight;
                private String weightName;

                Builder() {
                }

                private Builder(DirectionsRoute directionsRoute) {
                    this.distance = directionsRoute.distance();
                    this.duration = directionsRoute.duration();
                    this.geometry = directionsRoute.geometry();
                    this.weight = directionsRoute.weight();
                    this.weightName = directionsRoute.weightName();
                    this.legs = directionsRoute.legs();
                    this.routeOptions = directionsRoute.routeOptions();
                    this.routeIndex = directionsRoute.routeIndex();
                    this.routeClasses = directionsRoute.routeClasses();
                    this.summary = directionsRoute.summary();
                    this.alternatives = directionsRoute.alternatives();
                    this.betterRouteId = directionsRoute.betterRouteId();
                    this.routeId = directionsRoute.routeId();
                    this.rdrd = directionsRoute.rdrd();
                    this.rdrdm = directionsRoute.rdrdm();
                    this.dsocd = directionsRoute.dsocd();
                    this.socdi = directionsRoute.socdi();
                    this.socdm = directionsRoute.socdm();
                    this.tc = directionsRoute.tc();
                }

                @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute.Builder
                public DirectionsRoute.Builder distance(Double d) {
                    this.distance = d;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute.Builder
                public DirectionsRoute.Builder duration(Double d) {
                    this.duration = d;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute.Builder
                public DirectionsRoute.Builder geometry(String str) {
                    this.geometry = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute.Builder
                public DirectionsRoute.Builder weight(Double d) {
                    this.weight = d;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute.Builder
                public DirectionsRoute.Builder weightName(String str) {
                    this.weightName = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute.Builder
                public DirectionsRoute.Builder legs(List<RouteLeg> list) {
                    this.legs = list;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute.Builder
                public DirectionsRoute.Builder routeOptions(RouteOptions routeOptions) {
                    this.routeOptions = routeOptions;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute.Builder
                public DirectionsRoute.Builder routeIndex(Integer num) {
                    this.routeIndex = num;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute.Builder
                public DirectionsRoute.Builder routeClasses(RouteClasses routeClasses) {
                    this.routeClasses = routeClasses;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute.Builder
                public DirectionsRoute.Builder summary(String str) {
                    this.summary = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute.Builder
                public DirectionsRoute.Builder alternatives(List<DirectionsRoute> list) {
                    this.alternatives = list;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute.Builder
                public DirectionsRoute.Builder betterRouteId(String str) {
                    this.betterRouteId = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute.Builder
                public DirectionsRoute.Builder routeId(String str) {
                    this.routeId = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute.Builder
                public DirectionsRoute.Builder rdrd(Double d) {
                    this.rdrd = d;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute.Builder
                public DirectionsRoute.Builder rdrdm(Double d) {
                    this.rdrdm = d;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute.Builder
                public DirectionsRoute.Builder dsocd(Double d) {
                    this.dsocd = d;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute.Builder
                public DirectionsRoute.Builder socdi(Double d) {
                    this.socdi = d;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute.Builder
                public DirectionsRoute.Builder socdm(Double d) {
                    this.socdm = d;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute.Builder
                public DirectionsRoute.Builder tc(Double d) {
                    this.tc = d;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.DirectionsRoute.Builder
                public DirectionsRoute build() {
                    return new AutoValue_DirectionsRoute(this.distance, this.duration, this.geometry, this.weight, this.weightName, this.legs, this.routeOptions, this.routeIndex, this.routeClasses, this.summary, this.alternatives, this.betterRouteId, this.routeId, this.rdrd, this.rdrdm, this.dsocd, this.socdi, this.socdm, this.tc);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<DirectionsRoute> {
        private volatile TypeAdapter<Double> double__adapter;
        private final Gson gson;
        private volatile TypeAdapter<Integer> integer_adapter;
        private volatile TypeAdapter<List<DirectionsRoute>> list__directionsRoute_adapter;
        private volatile TypeAdapter<List<RouteLeg>> list__routeLeg_adapter;
        private volatile TypeAdapter<RouteClasses> routeClasses_adapter;
        private volatile TypeAdapter<RouteOptions> routeOptions_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, DirectionsRoute directionsRoute) throws IOException {
            if (directionsRoute == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name(DirectionsCriteria.ANNOTATION_DISTANCE);
            if (directionsRoute.distance() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> adapter = this.double__adapter;
                if (adapter == null) {
                    adapter = this.gson.getAdapter(Double.class);
                    this.double__adapter = adapter;
                }
                adapter.write(jsonWriter, directionsRoute.distance());
            }
            jsonWriter.name("duration");
            if (directionsRoute.duration() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> adapter2 = this.double__adapter;
                if (adapter2 == null) {
                    adapter2 = this.gson.getAdapter(Double.class);
                    this.double__adapter = adapter2;
                }
                adapter2.write(jsonWriter, directionsRoute.duration());
            }
            jsonWriter.name("geometry");
            if (directionsRoute.geometry() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter3 = this.string_adapter;
                if (adapter3 == null) {
                    adapter3 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter3;
                }
                adapter3.write(jsonWriter, directionsRoute.geometry());
            }
            jsonWriter.name("weight");
            if (directionsRoute.weight() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> adapter4 = this.double__adapter;
                if (adapter4 == null) {
                    adapter4 = this.gson.getAdapter(Double.class);
                    this.double__adapter = adapter4;
                }
                adapter4.write(jsonWriter, directionsRoute.weight());
            }
            jsonWriter.name("weight_name");
            if (directionsRoute.weightName() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter5 = this.string_adapter;
                if (adapter5 == null) {
                    adapter5 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter5;
                }
                adapter5.write(jsonWriter, directionsRoute.weightName());
            }
            jsonWriter.name("legs");
            if (directionsRoute.legs() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<RouteLeg>> adapter6 = this.list__routeLeg_adapter;
                if (adapter6 == null) {
                    adapter6 = this.gson.getAdapter(TypeToken.getParameterized(List.class, RouteLeg.class));
                    this.list__routeLeg_adapter = adapter6;
                }
                adapter6.write(jsonWriter, directionsRoute.legs());
            }
            jsonWriter.name("routeOptions");
            if (directionsRoute.routeOptions() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<RouteOptions> adapter7 = this.routeOptions_adapter;
                if (adapter7 == null) {
                    adapter7 = this.gson.getAdapter(RouteOptions.class);
                    this.routeOptions_adapter = adapter7;
                }
                adapter7.write(jsonWriter, directionsRoute.routeOptions());
            }
            jsonWriter.name("routeIndex");
            if (directionsRoute.routeIndex() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> adapter8 = this.integer_adapter;
                if (adapter8 == null) {
                    adapter8 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = adapter8;
                }
                adapter8.write(jsonWriter, directionsRoute.routeIndex());
            }
            jsonWriter.name("contains_classes");
            if (directionsRoute.routeClasses() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<RouteClasses> adapter9 = this.routeClasses_adapter;
                if (adapter9 == null) {
                    adapter9 = this.gson.getAdapter(RouteClasses.class);
                    this.routeClasses_adapter = adapter9;
                }
                adapter9.write(jsonWriter, directionsRoute.routeClasses());
            }
            jsonWriter.name("summary");
            if (directionsRoute.summary() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter10 = this.string_adapter;
                if (adapter10 == null) {
                    adapter10 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter10;
                }
                adapter10.write(jsonWriter, directionsRoute.summary());
            }
            jsonWriter.name("alternatives");
            if (directionsRoute.alternatives() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<DirectionsRoute>> adapter11 = this.list__directionsRoute_adapter;
                if (adapter11 == null) {
                    adapter11 = this.gson.getAdapter(TypeToken.getParameterized(List.class, DirectionsRoute.class));
                    this.list__directionsRoute_adapter = adapter11;
                }
                adapter11.write(jsonWriter, directionsRoute.alternatives());
            }
            jsonWriter.name("betterRouteId");
            if (directionsRoute.betterRouteId() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter12 = this.string_adapter;
                if (adapter12 == null) {
                    adapter12 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter12;
                }
                adapter12.write(jsonWriter, directionsRoute.betterRouteId());
            }
            jsonWriter.name(MediaRouteProviderProtocol.CLIENT_DATA_ROUTE_ID);
            if (directionsRoute.routeId() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter13 = this.string_adapter;
                if (adapter13 == null) {
                    adapter13 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter13;
                }
                adapter13.write(jsonWriter, directionsRoute.routeId());
            }
            jsonWriter.name("rdrd");
            if (directionsRoute.rdrd() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> adapter14 = this.double__adapter;
                if (adapter14 == null) {
                    adapter14 = this.gson.getAdapter(Double.class);
                    this.double__adapter = adapter14;
                }
                adapter14.write(jsonWriter, directionsRoute.rdrd());
            }
            jsonWriter.name("rdrdm");
            if (directionsRoute.rdrdm() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> adapter15 = this.double__adapter;
                if (adapter15 == null) {
                    adapter15 = this.gson.getAdapter(Double.class);
                    this.double__adapter = adapter15;
                }
                adapter15.write(jsonWriter, directionsRoute.rdrdm());
            }
            jsonWriter.name("dsocd");
            if (directionsRoute.dsocd() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> adapter16 = this.double__adapter;
                if (adapter16 == null) {
                    adapter16 = this.gson.getAdapter(Double.class);
                    this.double__adapter = adapter16;
                }
                adapter16.write(jsonWriter, directionsRoute.dsocd());
            }
            jsonWriter.name("socdi");
            if (directionsRoute.socdi() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> adapter17 = this.double__adapter;
                if (adapter17 == null) {
                    adapter17 = this.gson.getAdapter(Double.class);
                    this.double__adapter = adapter17;
                }
                adapter17.write(jsonWriter, directionsRoute.socdi());
            }
            jsonWriter.name("socdm");
            if (directionsRoute.socdm() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> adapter18 = this.double__adapter;
                if (adapter18 == null) {
                    adapter18 = this.gson.getAdapter(Double.class);
                    this.double__adapter = adapter18;
                }
                adapter18.write(jsonWriter, directionsRoute.socdm());
            }
            jsonWriter.name("tc");
            if (directionsRoute.tc() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> adapter19 = this.double__adapter;
                if (adapter19 == null) {
                    adapter19 = this.gson.getAdapter(Double.class);
                    this.double__adapter = adapter19;
                }
                adapter19.write(jsonWriter, directionsRoute.tc());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: read */
        public DirectionsRoute read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            DirectionsRoute.Builder builder = DirectionsRoute.builder();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    strNextName.hashCode();
                    if (strNextName.equals("contains_classes")) {
                        TypeAdapter<RouteClasses> adapter = this.routeClasses_adapter;
                        if (adapter == null) {
                            adapter = this.gson.getAdapter(RouteClasses.class);
                            this.routeClasses_adapter = adapter;
                        }
                        builder.routeClasses(adapter.read2(jsonReader));
                    } else if (strNextName.equals("weight_name")) {
                        TypeAdapter<String> adapter2 = this.string_adapter;
                        if (adapter2 == null) {
                            adapter2 = this.gson.getAdapter(String.class);
                            this.string_adapter = adapter2;
                        }
                        builder.weightName(adapter2.read2(jsonReader));
                    } else if (DirectionsCriteria.ANNOTATION_DISTANCE.equals(strNextName)) {
                        TypeAdapter<Double> adapter3 = this.double__adapter;
                        if (adapter3 == null) {
                            adapter3 = this.gson.getAdapter(Double.class);
                            this.double__adapter = adapter3;
                        }
                        builder.distance(adapter3.read2(jsonReader));
                    } else if ("duration".equals(strNextName)) {
                        TypeAdapter<Double> adapter4 = this.double__adapter;
                        if (adapter4 == null) {
                            adapter4 = this.gson.getAdapter(Double.class);
                            this.double__adapter = adapter4;
                        }
                        builder.duration(adapter4.read2(jsonReader));
                    } else if ("geometry".equals(strNextName)) {
                        TypeAdapter<String> adapter5 = this.string_adapter;
                        if (adapter5 == null) {
                            adapter5 = this.gson.getAdapter(String.class);
                            this.string_adapter = adapter5;
                        }
                        builder.geometry(adapter5.read2(jsonReader));
                    } else if ("weight".equals(strNextName)) {
                        TypeAdapter<Double> adapter6 = this.double__adapter;
                        if (adapter6 == null) {
                            adapter6 = this.gson.getAdapter(Double.class);
                            this.double__adapter = adapter6;
                        }
                        builder.weight(adapter6.read2(jsonReader));
                    } else if ("legs".equals(strNextName)) {
                        TypeAdapter<List<RouteLeg>> adapter7 = this.list__routeLeg_adapter;
                        if (adapter7 == null) {
                            adapter7 = this.gson.getAdapter(TypeToken.getParameterized(List.class, RouteLeg.class));
                            this.list__routeLeg_adapter = adapter7;
                        }
                        builder.legs(adapter7.read2(jsonReader));
                    } else if ("routeOptions".equals(strNextName)) {
                        TypeAdapter<RouteOptions> adapter8 = this.routeOptions_adapter;
                        if (adapter8 == null) {
                            adapter8 = this.gson.getAdapter(RouteOptions.class);
                            this.routeOptions_adapter = adapter8;
                        }
                        builder.routeOptions(adapter8.read2(jsonReader));
                    } else if ("routeIndex".equals(strNextName)) {
                        TypeAdapter<Integer> adapter9 = this.integer_adapter;
                        if (adapter9 == null) {
                            adapter9 = this.gson.getAdapter(Integer.class);
                            this.integer_adapter = adapter9;
                        }
                        builder.routeIndex(adapter9.read2(jsonReader));
                    } else if ("summary".equals(strNextName)) {
                        TypeAdapter<String> adapter10 = this.string_adapter;
                        if (adapter10 == null) {
                            adapter10 = this.gson.getAdapter(String.class);
                            this.string_adapter = adapter10;
                        }
                        builder.summary(adapter10.read2(jsonReader));
                    } else if ("alternatives".equals(strNextName)) {
                        TypeAdapter<List<DirectionsRoute>> adapter11 = this.list__directionsRoute_adapter;
                        if (adapter11 == null) {
                            adapter11 = this.gson.getAdapter(TypeToken.getParameterized(List.class, DirectionsRoute.class));
                            this.list__directionsRoute_adapter = adapter11;
                        }
                        builder.alternatives(adapter11.read2(jsonReader));
                    } else if ("betterRouteId".equals(strNextName)) {
                        TypeAdapter<String> adapter12 = this.string_adapter;
                        if (adapter12 == null) {
                            adapter12 = this.gson.getAdapter(String.class);
                            this.string_adapter = adapter12;
                        }
                        builder.betterRouteId(adapter12.read2(jsonReader));
                    } else if (MediaRouteProviderProtocol.CLIENT_DATA_ROUTE_ID.equals(strNextName)) {
                        TypeAdapter<String> adapter13 = this.string_adapter;
                        if (adapter13 == null) {
                            adapter13 = this.gson.getAdapter(String.class);
                            this.string_adapter = adapter13;
                        }
                        builder.routeId(adapter13.read2(jsonReader));
                    } else if ("rdrd".equals(strNextName)) {
                        TypeAdapter<Double> adapter14 = this.double__adapter;
                        if (adapter14 == null) {
                            adapter14 = this.gson.getAdapter(Double.class);
                            this.double__adapter = adapter14;
                        }
                        builder.rdrd(adapter14.read2(jsonReader));
                    } else if ("rdrdm".equals(strNextName)) {
                        TypeAdapter<Double> adapter15 = this.double__adapter;
                        if (adapter15 == null) {
                            adapter15 = this.gson.getAdapter(Double.class);
                            this.double__adapter = adapter15;
                        }
                        builder.rdrdm(adapter15.read2(jsonReader));
                    } else if ("dsocd".equals(strNextName)) {
                        TypeAdapter<Double> adapter16 = this.double__adapter;
                        if (adapter16 == null) {
                            adapter16 = this.gson.getAdapter(Double.class);
                            this.double__adapter = adapter16;
                        }
                        builder.dsocd(adapter16.read2(jsonReader));
                    } else if ("socdi".equals(strNextName)) {
                        TypeAdapter<Double> adapter17 = this.double__adapter;
                        if (adapter17 == null) {
                            adapter17 = this.gson.getAdapter(Double.class);
                            this.double__adapter = adapter17;
                        }
                        builder.socdi(adapter17.read2(jsonReader));
                    } else if ("socdm".equals(strNextName)) {
                        TypeAdapter<Double> adapter18 = this.double__adapter;
                        if (adapter18 == null) {
                            adapter18 = this.gson.getAdapter(Double.class);
                            this.double__adapter = adapter18;
                        }
                        builder.socdm(adapter18.read2(jsonReader));
                    } else if ("tc".equals(strNextName)) {
                        TypeAdapter<Double> adapter19 = this.double__adapter;
                        if (adapter19 == null) {
                            adapter19 = this.gson.getAdapter(Double.class);
                            this.double__adapter = adapter19;
                        }
                        builder.tc(adapter19.read2(jsonReader));
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return builder.build();
        }

        public String toString() {
            return "TypeAdapter(DirectionsRoute)";
        }
    }
}

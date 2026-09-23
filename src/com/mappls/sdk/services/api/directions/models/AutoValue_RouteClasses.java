package com.mappls.sdk.services.api.directions.models;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_RouteClasses extends C$AutoValue_RouteClasses {
    AutoValue_RouteClasses(Integer num, Integer num2, Integer num3, Integer num4, Integer num5) {
        new RouteClasses(num, num2, num3, num4, num5) { // from class: com.mappls.sdk.services.api.directions.models.$AutoValue_RouteClasses
            private final Integer ferry;
            private final Integer motorway;
            private final Integer restricted;
            private final Integer toll;
            private final Integer tunnel;

            {
                this.motorway = num;
                this.tunnel = num2;
                this.toll = num3;
                this.ferry = num4;
                this.restricted = num5;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteClasses
            public Integer motorway() {
                return this.motorway;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteClasses
            public Integer tunnel() {
                return this.tunnel;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteClasses
            public Integer toll() {
                return this.toll;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteClasses
            public Integer ferry() {
                return this.ferry;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteClasses
            public Integer restricted() {
                return this.restricted;
            }

            public String toString() {
                return "RouteClasses{motorway=" + this.motorway + ", tunnel=" + this.tunnel + ", toll=" + this.toll + ", ferry=" + this.ferry + ", restricted=" + this.restricted + "}";
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof RouteClasses)) {
                    return false;
                }
                RouteClasses routeClasses = (RouteClasses) obj;
                Integer num6 = this.motorway;
                if (num6 != null ? num6.equals(routeClasses.motorway()) : routeClasses.motorway() == null) {
                    Integer num7 = this.tunnel;
                    if (num7 != null ? num7.equals(routeClasses.tunnel()) : routeClasses.tunnel() == null) {
                        Integer num8 = this.toll;
                        if (num8 != null ? num8.equals(routeClasses.toll()) : routeClasses.toll() == null) {
                            Integer num9 = this.ferry;
                            if (num9 != null ? num9.equals(routeClasses.ferry()) : routeClasses.ferry() == null) {
                                Integer num10 = this.restricted;
                                if (num10 == null) {
                                    if (routeClasses.restricted() == null) {
                                        return true;
                                    }
                                } else if (num10.equals(routeClasses.restricted())) {
                                    return true;
                                }
                            }
                        }
                    }
                }
                return false;
            }

            public int hashCode() {
                Integer num6 = this.motorway;
                int iHashCode = ((num6 == null ? 0 : num6.hashCode()) ^ 1000003) * 1000003;
                Integer num7 = this.tunnel;
                int iHashCode2 = (iHashCode ^ (num7 == null ? 0 : num7.hashCode())) * 1000003;
                Integer num8 = this.toll;
                int iHashCode3 = (iHashCode2 ^ (num8 == null ? 0 : num8.hashCode())) * 1000003;
                Integer num9 = this.ferry;
                int iHashCode4 = (iHashCode3 ^ (num9 == null ? 0 : num9.hashCode())) * 1000003;
                Integer num10 = this.restricted;
                return iHashCode4 ^ (num10 != null ? num10.hashCode() : 0);
            }

            /* JADX INFO: renamed from: com.mappls.sdk.services.api.directions.models.$AutoValue_RouteClasses$Builder */
            static class Builder extends RouteClasses.Builder {
                private Integer ferry;
                private Integer motorway;
                private Integer restricted;
                private Integer toll;
                private Integer tunnel;

                Builder() {
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteClasses.Builder
                public RouteClasses.Builder motorway(Integer num) {
                    this.motorway = num;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteClasses.Builder
                public RouteClasses.Builder tunnel(Integer num) {
                    this.tunnel = num;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteClasses.Builder
                public RouteClasses.Builder toll(Integer num) {
                    this.toll = num;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteClasses.Builder
                public RouteClasses.Builder ferry(Integer num) {
                    this.ferry = num;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteClasses.Builder
                public RouteClasses.Builder restricted(Integer num) {
                    this.restricted = num;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteClasses.Builder
                public RouteClasses build() {
                    return new AutoValue_RouteClasses(this.motorway, this.tunnel, this.toll, this.ferry, this.restricted);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<RouteClasses> {
        private final Gson gson;
        private volatile TypeAdapter<Integer> integer_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, RouteClasses routeClasses) throws IOException {
            if (routeClasses == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name(DirectionsCriteria.EXCLUDE_MOTORWAY);
            if (routeClasses.motorway() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> adapter = this.integer_adapter;
                if (adapter == null) {
                    adapter = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = adapter;
                }
                adapter.write(jsonWriter, routeClasses.motorway());
            }
            jsonWriter.name(DirectionsCriteria.EXCLUDE_TUNNEL);
            if (routeClasses.tunnel() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> adapter2 = this.integer_adapter;
                if (adapter2 == null) {
                    adapter2 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = adapter2;
                }
                adapter2.write(jsonWriter, routeClasses.tunnel());
            }
            jsonWriter.name(DirectionsCriteria.EXCLUDE_TOLL);
            if (routeClasses.toll() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> adapter3 = this.integer_adapter;
                if (adapter3 == null) {
                    adapter3 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = adapter3;
                }
                adapter3.write(jsonWriter, routeClasses.toll());
            }
            jsonWriter.name(DirectionsCriteria.EXCLUDE_FERRY);
            if (routeClasses.ferry() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> adapter4 = this.integer_adapter;
                if (adapter4 == null) {
                    adapter4 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = adapter4;
                }
                adapter4.write(jsonWriter, routeClasses.ferry());
            }
            jsonWriter.name(DirectionsCriteria.EXCLUDE_RESTRICTED);
            if (routeClasses.restricted() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> adapter5 = this.integer_adapter;
                if (adapter5 == null) {
                    adapter5 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = adapter5;
                }
                adapter5.write(jsonWriter, routeClasses.restricted());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: read */
        public RouteClasses read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            RouteClasses.Builder builder = RouteClasses.builder();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    strNextName.hashCode();
                    if (DirectionsCriteria.EXCLUDE_MOTORWAY.equals(strNextName)) {
                        TypeAdapter<Integer> adapter = this.integer_adapter;
                        if (adapter == null) {
                            adapter = this.gson.getAdapter(Integer.class);
                            this.integer_adapter = adapter;
                        }
                        builder.motorway(adapter.read2(jsonReader));
                    } else if (DirectionsCriteria.EXCLUDE_TUNNEL.equals(strNextName)) {
                        TypeAdapter<Integer> adapter2 = this.integer_adapter;
                        if (adapter2 == null) {
                            adapter2 = this.gson.getAdapter(Integer.class);
                            this.integer_adapter = adapter2;
                        }
                        builder.tunnel(adapter2.read2(jsonReader));
                    } else if (DirectionsCriteria.EXCLUDE_TOLL.equals(strNextName)) {
                        TypeAdapter<Integer> adapter3 = this.integer_adapter;
                        if (adapter3 == null) {
                            adapter3 = this.gson.getAdapter(Integer.class);
                            this.integer_adapter = adapter3;
                        }
                        builder.toll(adapter3.read2(jsonReader));
                    } else if (DirectionsCriteria.EXCLUDE_FERRY.equals(strNextName)) {
                        TypeAdapter<Integer> adapter4 = this.integer_adapter;
                        if (adapter4 == null) {
                            adapter4 = this.gson.getAdapter(Integer.class);
                            this.integer_adapter = adapter4;
                        }
                        builder.ferry(adapter4.read2(jsonReader));
                    } else if (DirectionsCriteria.EXCLUDE_RESTRICTED.equals(strNextName)) {
                        TypeAdapter<Integer> adapter5 = this.integer_adapter;
                        if (adapter5 == null) {
                            adapter5 = this.gson.getAdapter(Integer.class);
                            this.integer_adapter = adapter5;
                        }
                        builder.restricted(adapter5.read2(jsonReader));
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return builder.build();
        }

        public String toString() {
            return "TypeAdapter(RouteClasses)";
        }
    }
}

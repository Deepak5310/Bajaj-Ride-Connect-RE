package com.mappls.sdk.services.api.directions.models;

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
final class AutoValue_LegAnnotation extends C$AutoValue_LegAnnotation {
    AutoValue_LegAnnotation(List<Double> list, List<Double> list2, List<Double> list3, List<MaxSpeed> list4, List<String> list5, List<String> list6, List<Long> list7, List<Double> list8, List<Double> list9) {
        new LegAnnotation(list, list2, list3, list4, list5, list6, list7, list8, list9) { // from class: com.mappls.sdk.services.api.directions.models.$AutoValue_LegAnnotation
            private final List<Double> baseDuration;
            private final List<String> congestion;
            private final List<Double> distance;
            private final List<Double> duration;
            private final List<MaxSpeed> maxspeed;
            private final List<Long> nodes;
            private final List<Double> speed;
            private final List<Double> speedLimit;
            private final List<String> tollRoad;

            {
                this.distance = list;
                this.duration = list2;
                this.speed = list3;
                this.maxspeed = list4;
                this.congestion = list5;
                this.tollRoad = list6;
                this.nodes = list7;
                this.baseDuration = list8;
                this.speedLimit = list9;
            }

            @Override // com.mappls.sdk.services.api.directions.models.LegAnnotation
            public List<Double> distance() {
                return this.distance;
            }

            @Override // com.mappls.sdk.services.api.directions.models.LegAnnotation
            public List<Double> duration() {
                return this.duration;
            }

            @Override // com.mappls.sdk.services.api.directions.models.LegAnnotation
            public List<Double> speed() {
                return this.speed;
            }

            @Override // com.mappls.sdk.services.api.directions.models.LegAnnotation
            public List<MaxSpeed> maxspeed() {
                return this.maxspeed;
            }

            @Override // com.mappls.sdk.services.api.directions.models.LegAnnotation
            public List<String> congestion() {
                return this.congestion;
            }

            @Override // com.mappls.sdk.services.api.directions.models.LegAnnotation
            @SerializedName(DirectionsCriteria.ANNOTATION_TOLL_ROAD)
            public List<String> tollRoad() {
                return this.tollRoad;
            }

            @Override // com.mappls.sdk.services.api.directions.models.LegAnnotation
            public List<Long> nodes() {
                return this.nodes;
            }

            @Override // com.mappls.sdk.services.api.directions.models.LegAnnotation
            public List<Double> baseDuration() {
                return this.baseDuration;
            }

            @Override // com.mappls.sdk.services.api.directions.models.LegAnnotation
            @SerializedName(DirectionsCriteria.ANNOTATION_SPEED_LIMIT)
            public List<Double> speedLimit() {
                return this.speedLimit;
            }

            public String toString() {
                return "LegAnnotation{distance=" + this.distance + ", duration=" + this.duration + ", speed=" + this.speed + ", maxspeed=" + this.maxspeed + ", congestion=" + this.congestion + ", tollRoad=" + this.tollRoad + ", nodes=" + this.nodes + ", baseDuration=" + this.baseDuration + ", speedLimit=" + this.speedLimit + "}";
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof LegAnnotation)) {
                    return false;
                }
                LegAnnotation legAnnotation = (LegAnnotation) obj;
                List<Double> list10 = this.distance;
                if (list10 != null ? list10.equals(legAnnotation.distance()) : legAnnotation.distance() == null) {
                    List<Double> list11 = this.duration;
                    if (list11 != null ? list11.equals(legAnnotation.duration()) : legAnnotation.duration() == null) {
                        List<Double> list12 = this.speed;
                        if (list12 != null ? list12.equals(legAnnotation.speed()) : legAnnotation.speed() == null) {
                            List<MaxSpeed> list13 = this.maxspeed;
                            if (list13 != null ? list13.equals(legAnnotation.maxspeed()) : legAnnotation.maxspeed() == null) {
                                List<String> list14 = this.congestion;
                                if (list14 != null ? list14.equals(legAnnotation.congestion()) : legAnnotation.congestion() == null) {
                                    List<String> list15 = this.tollRoad;
                                    if (list15 != null ? list15.equals(legAnnotation.tollRoad()) : legAnnotation.tollRoad() == null) {
                                        List<Long> list16 = this.nodes;
                                        if (list16 != null ? list16.equals(legAnnotation.nodes()) : legAnnotation.nodes() == null) {
                                            List<Double> list17 = this.baseDuration;
                                            if (list17 != null ? list17.equals(legAnnotation.baseDuration()) : legAnnotation.baseDuration() == null) {
                                                List<Double> list18 = this.speedLimit;
                                                if (list18 == null) {
                                                    if (legAnnotation.speedLimit() == null) {
                                                        return true;
                                                    }
                                                } else if (list18.equals(legAnnotation.speedLimit())) {
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
                return false;
            }

            public int hashCode() {
                List<Double> list10 = this.distance;
                int iHashCode = ((list10 == null ? 0 : list10.hashCode()) ^ 1000003) * 1000003;
                List<Double> list11 = this.duration;
                int iHashCode2 = (iHashCode ^ (list11 == null ? 0 : list11.hashCode())) * 1000003;
                List<Double> list12 = this.speed;
                int iHashCode3 = (iHashCode2 ^ (list12 == null ? 0 : list12.hashCode())) * 1000003;
                List<MaxSpeed> list13 = this.maxspeed;
                int iHashCode4 = (iHashCode3 ^ (list13 == null ? 0 : list13.hashCode())) * 1000003;
                List<String> list14 = this.congestion;
                int iHashCode5 = (iHashCode4 ^ (list14 == null ? 0 : list14.hashCode())) * 1000003;
                List<String> list15 = this.tollRoad;
                int iHashCode6 = (iHashCode5 ^ (list15 == null ? 0 : list15.hashCode())) * 1000003;
                List<Long> list16 = this.nodes;
                int iHashCode7 = (iHashCode6 ^ (list16 == null ? 0 : list16.hashCode())) * 1000003;
                List<Double> list17 = this.baseDuration;
                int iHashCode8 = (iHashCode7 ^ (list17 == null ? 0 : list17.hashCode())) * 1000003;
                List<Double> list18 = this.speedLimit;
                return iHashCode8 ^ (list18 != null ? list18.hashCode() : 0);
            }

            @Override // com.mappls.sdk.services.api.directions.models.LegAnnotation
            public LegAnnotation.Builder toBuilder() {
                return new Builder(this);
            }

            /* JADX INFO: renamed from: com.mappls.sdk.services.api.directions.models.$AutoValue_LegAnnotation$Builder */
            static class Builder extends LegAnnotation.Builder {
                private List<Double> baseDuration;
                private List<String> congestion;
                private List<Double> distance;
                private List<Double> duration;
                private List<MaxSpeed> maxspeed;
                private List<Long> nodes;
                private List<Double> speed;
                private List<Double> speedLimit;
                private List<String> tollRoad;

                Builder() {
                }

                private Builder(LegAnnotation legAnnotation) {
                    this.distance = legAnnotation.distance();
                    this.duration = legAnnotation.duration();
                    this.speed = legAnnotation.speed();
                    this.maxspeed = legAnnotation.maxspeed();
                    this.congestion = legAnnotation.congestion();
                    this.tollRoad = legAnnotation.tollRoad();
                    this.nodes = legAnnotation.nodes();
                    this.baseDuration = legAnnotation.baseDuration();
                    this.speedLimit = legAnnotation.speedLimit();
                }

                @Override // com.mappls.sdk.services.api.directions.models.LegAnnotation.Builder
                public LegAnnotation.Builder distance(List<Double> list) {
                    this.distance = list;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.LegAnnotation.Builder
                public LegAnnotation.Builder duration(List<Double> list) {
                    this.duration = list;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.LegAnnotation.Builder
                public LegAnnotation.Builder speed(List<Double> list) {
                    this.speed = list;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.LegAnnotation.Builder
                public LegAnnotation.Builder maxspeed(List<MaxSpeed> list) {
                    this.maxspeed = list;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.LegAnnotation.Builder
                public LegAnnotation.Builder congestion(List<String> list) {
                    this.congestion = list;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.LegAnnotation.Builder
                public LegAnnotation.Builder tollRoad(List<String> list) {
                    this.tollRoad = list;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.LegAnnotation.Builder
                public LegAnnotation.Builder nodes(List<Long> list) {
                    this.nodes = list;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.LegAnnotation.Builder
                public LegAnnotation.Builder baseDuration(List<Double> list) {
                    this.baseDuration = list;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.LegAnnotation.Builder
                public LegAnnotation.Builder speedLimit(List<Double> list) {
                    this.speedLimit = list;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.LegAnnotation.Builder
                public LegAnnotation build() {
                    return new AutoValue_LegAnnotation(this.distance, this.duration, this.speed, this.maxspeed, this.congestion, this.tollRoad, this.nodes, this.baseDuration, this.speedLimit);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<LegAnnotation> {
        private final Gson gson;
        private volatile TypeAdapter<List<Double>> list__double_adapter;
        private volatile TypeAdapter<List<Long>> list__long_adapter;
        private volatile TypeAdapter<List<MaxSpeed>> list__maxSpeed_adapter;
        private volatile TypeAdapter<List<String>> list__string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, LegAnnotation legAnnotation) throws IOException {
            if (legAnnotation == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name(DirectionsCriteria.ANNOTATION_DISTANCE);
            if (legAnnotation.distance() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<Double>> adapter = this.list__double_adapter;
                if (adapter == null) {
                    adapter = this.gson.getAdapter(TypeToken.getParameterized(List.class, Double.class));
                    this.list__double_adapter = adapter;
                }
                adapter.write(jsonWriter, legAnnotation.distance());
            }
            jsonWriter.name("duration");
            if (legAnnotation.duration() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<Double>> adapter2 = this.list__double_adapter;
                if (adapter2 == null) {
                    adapter2 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Double.class));
                    this.list__double_adapter = adapter2;
                }
                adapter2.write(jsonWriter, legAnnotation.duration());
            }
            jsonWriter.name("speed");
            if (legAnnotation.speed() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<Double>> adapter3 = this.list__double_adapter;
                if (adapter3 == null) {
                    adapter3 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Double.class));
                    this.list__double_adapter = adapter3;
                }
                adapter3.write(jsonWriter, legAnnotation.speed());
            }
            jsonWriter.name(DirectionsCriteria.ANNOTATION_MAXSPEED);
            if (legAnnotation.maxspeed() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<MaxSpeed>> adapter4 = this.list__maxSpeed_adapter;
                if (adapter4 == null) {
                    adapter4 = this.gson.getAdapter(TypeToken.getParameterized(List.class, MaxSpeed.class));
                    this.list__maxSpeed_adapter = adapter4;
                }
                adapter4.write(jsonWriter, legAnnotation.maxspeed());
            }
            jsonWriter.name(DirectionsCriteria.ANNOTATION_CONGESTION);
            if (legAnnotation.congestion() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<String>> adapter5 = this.list__string_adapter;
                if (adapter5 == null) {
                    adapter5 = this.gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
                    this.list__string_adapter = adapter5;
                }
                adapter5.write(jsonWriter, legAnnotation.congestion());
            }
            jsonWriter.name(DirectionsCriteria.ANNOTATION_TOLL_ROAD);
            if (legAnnotation.tollRoad() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<String>> adapter6 = this.list__string_adapter;
                if (adapter6 == null) {
                    adapter6 = this.gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
                    this.list__string_adapter = adapter6;
                }
                adapter6.write(jsonWriter, legAnnotation.tollRoad());
            }
            jsonWriter.name(DirectionsCriteria.ANNOTATION_NODES);
            if (legAnnotation.nodes() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<Long>> adapter7 = this.list__long_adapter;
                if (adapter7 == null) {
                    adapter7 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Long.class));
                    this.list__long_adapter = adapter7;
                }
                adapter7.write(jsonWriter, legAnnotation.nodes());
            }
            jsonWriter.name(DirectionsCriteria.ANNOTATION_BASE_DURATION);
            if (legAnnotation.baseDuration() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<Double>> adapter8 = this.list__double_adapter;
                if (adapter8 == null) {
                    adapter8 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Double.class));
                    this.list__double_adapter = adapter8;
                }
                adapter8.write(jsonWriter, legAnnotation.baseDuration());
            }
            jsonWriter.name(DirectionsCriteria.ANNOTATION_SPEED_LIMIT);
            if (legAnnotation.speedLimit() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<Double>> adapter9 = this.list__double_adapter;
                if (adapter9 == null) {
                    adapter9 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Double.class));
                    this.list__double_adapter = adapter9;
                }
                adapter9.write(jsonWriter, legAnnotation.speedLimit());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: read */
        public LegAnnotation read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            LegAnnotation.Builder builder = LegAnnotation.builder();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    strNextName.hashCode();
                    if (strNextName.equals(DirectionsCriteria.ANNOTATION_SPEED_LIMIT)) {
                        TypeAdapter<List<Double>> adapter = this.list__double_adapter;
                        if (adapter == null) {
                            adapter = this.gson.getAdapter(TypeToken.getParameterized(List.class, Double.class));
                            this.list__double_adapter = adapter;
                        }
                        builder.speedLimit(adapter.read2(jsonReader));
                    } else if (strNextName.equals(DirectionsCriteria.ANNOTATION_TOLL_ROAD)) {
                        TypeAdapter<List<String>> adapter2 = this.list__string_adapter;
                        if (adapter2 == null) {
                            adapter2 = this.gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
                            this.list__string_adapter = adapter2;
                        }
                        builder.tollRoad(adapter2.read2(jsonReader));
                    } else if (DirectionsCriteria.ANNOTATION_DISTANCE.equals(strNextName)) {
                        TypeAdapter<List<Double>> adapter3 = this.list__double_adapter;
                        if (adapter3 == null) {
                            adapter3 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Double.class));
                            this.list__double_adapter = adapter3;
                        }
                        builder.distance(adapter3.read2(jsonReader));
                    } else if ("duration".equals(strNextName)) {
                        TypeAdapter<List<Double>> adapter4 = this.list__double_adapter;
                        if (adapter4 == null) {
                            adapter4 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Double.class));
                            this.list__double_adapter = adapter4;
                        }
                        builder.duration(adapter4.read2(jsonReader));
                    } else if ("speed".equals(strNextName)) {
                        TypeAdapter<List<Double>> adapter5 = this.list__double_adapter;
                        if (adapter5 == null) {
                            adapter5 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Double.class));
                            this.list__double_adapter = adapter5;
                        }
                        builder.speed(adapter5.read2(jsonReader));
                    } else if (DirectionsCriteria.ANNOTATION_MAXSPEED.equals(strNextName)) {
                        TypeAdapter<List<MaxSpeed>> adapter6 = this.list__maxSpeed_adapter;
                        if (adapter6 == null) {
                            adapter6 = this.gson.getAdapter(TypeToken.getParameterized(List.class, MaxSpeed.class));
                            this.list__maxSpeed_adapter = adapter6;
                        }
                        builder.maxspeed(adapter6.read2(jsonReader));
                    } else if (DirectionsCriteria.ANNOTATION_CONGESTION.equals(strNextName)) {
                        TypeAdapter<List<String>> adapter7 = this.list__string_adapter;
                        if (adapter7 == null) {
                            adapter7 = this.gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
                            this.list__string_adapter = adapter7;
                        }
                        builder.congestion(adapter7.read2(jsonReader));
                    } else if (DirectionsCriteria.ANNOTATION_NODES.equals(strNextName)) {
                        TypeAdapter<List<Long>> adapter8 = this.list__long_adapter;
                        if (adapter8 == null) {
                            adapter8 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Long.class));
                            this.list__long_adapter = adapter8;
                        }
                        builder.nodes(adapter8.read2(jsonReader));
                    } else if (DirectionsCriteria.ANNOTATION_BASE_DURATION.equals(strNextName)) {
                        TypeAdapter<List<Double>> adapter9 = this.list__double_adapter;
                        if (adapter9 == null) {
                            adapter9 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Double.class));
                            this.list__double_adapter = adapter9;
                        }
                        builder.baseDuration(adapter9.read2(jsonReader));
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return builder.build();
        }

        public String toString() {
            return "TypeAdapter(LegAnnotation)";
        }
    }
}

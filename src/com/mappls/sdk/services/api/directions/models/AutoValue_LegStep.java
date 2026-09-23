package com.mappls.sdk.services.api.directions.models;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.henninghall.date_picker.props.ModeProp;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_LegStep extends C$AutoValue_LegStep {
    AutoValue_LegStep(double d, double d2, String str, String str2, String str3, String str4, String str5, StepManeuver stepManeuver, List<BannerInstructions> list, String str6, Double d3, List<StepIntersection> list2, String str7) {
        new LegStep(d, d2, str, str2, str3, str4, str5, stepManeuver, list, str6, d3, list2, str7) { // from class: com.mappls.sdk.services.api.directions.models.$AutoValue_LegStep
            private final List<BannerInstructions> bannerInstructions;
            private final String destinations;
            private final double distance;
            private final String drivingSide;
            private final double duration;
            private final String geometry;
            private final List<StepIntersection> intersections;
            private final StepManeuver maneuver;
            private final String mode;
            private final String name;
            private final String ref;
            private final String rotaryName;
            private final Double weight;

            {
                this.distance = d;
                this.duration = d2;
                this.geometry = str;
                this.name = str2;
                this.destinations = str3;
                if (str4 == null) {
                    throw new NullPointerException("Null mode");
                }
                this.mode = str4;
                this.rotaryName = str5;
                if (stepManeuver == null) {
                    throw new NullPointerException("Null maneuver");
                }
                this.maneuver = stepManeuver;
                this.bannerInstructions = list;
                this.drivingSide = str6;
                this.weight = d3;
                this.intersections = list2;
                this.ref = str7;
            }

            @Override // com.mappls.sdk.services.api.directions.models.LegStep
            public double distance() {
                return this.distance;
            }

            @Override // com.mappls.sdk.services.api.directions.models.LegStep
            public double duration() {
                return this.duration;
            }

            @Override // com.mappls.sdk.services.api.directions.models.LegStep
            public String geometry() {
                return this.geometry;
            }

            @Override // com.mappls.sdk.services.api.directions.models.LegStep
            public String name() {
                return this.name;
            }

            @Override // com.mappls.sdk.services.api.directions.models.LegStep
            public String destinations() {
                return this.destinations;
            }

            @Override // com.mappls.sdk.services.api.directions.models.LegStep
            public String mode() {
                return this.mode;
            }

            @Override // com.mappls.sdk.services.api.directions.models.LegStep
            @SerializedName("rotary_name")
            public String rotaryName() {
                return this.rotaryName;
            }

            @Override // com.mappls.sdk.services.api.directions.models.LegStep
            public StepManeuver maneuver() {
                return this.maneuver;
            }

            @Override // com.mappls.sdk.services.api.directions.models.LegStep
            @SerializedName("banner_instructions")
            public List<BannerInstructions> bannerInstructions() {
                return this.bannerInstructions;
            }

            @Override // com.mappls.sdk.services.api.directions.models.LegStep
            @SerializedName("driving_side")
            public String drivingSide() {
                return this.drivingSide;
            }

            @Override // com.mappls.sdk.services.api.directions.models.LegStep
            public Double weight() {
                return this.weight;
            }

            @Override // com.mappls.sdk.services.api.directions.models.LegStep
            public List<StepIntersection> intersections() {
                return this.intersections;
            }

            @Override // com.mappls.sdk.services.api.directions.models.LegStep
            public String ref() {
                return this.ref;
            }

            public String toString() {
                return "LegStep{distance=" + this.distance + ", duration=" + this.duration + ", geometry=" + this.geometry + ", name=" + this.name + ", destinations=" + this.destinations + ", mode=" + this.mode + ", rotaryName=" + this.rotaryName + ", maneuver=" + this.maneuver + ", bannerInstructions=" + this.bannerInstructions + ", drivingSide=" + this.drivingSide + ", weight=" + this.weight + ", intersections=" + this.intersections + ", ref=" + this.ref + "}";
            }

            public boolean equals(Object obj) {
                String str8;
                String str9;
                String str10;
                String str11;
                List<BannerInstructions> list3;
                String str12;
                Double d4;
                List<StepIntersection> list4;
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof LegStep)) {
                    return false;
                }
                LegStep legStep = (LegStep) obj;
                if (Double.doubleToLongBits(this.distance) == Double.doubleToLongBits(legStep.distance()) && Double.doubleToLongBits(this.duration) == Double.doubleToLongBits(legStep.duration()) && ((str8 = this.geometry) != null ? str8.equals(legStep.geometry()) : legStep.geometry() == null) && ((str9 = this.name) != null ? str9.equals(legStep.name()) : legStep.name() == null) && ((str10 = this.destinations) != null ? str10.equals(legStep.destinations()) : legStep.destinations() == null) && this.mode.equals(legStep.mode()) && ((str11 = this.rotaryName) != null ? str11.equals(legStep.rotaryName()) : legStep.rotaryName() == null) && this.maneuver.equals(legStep.maneuver()) && ((list3 = this.bannerInstructions) != null ? list3.equals(legStep.bannerInstructions()) : legStep.bannerInstructions() == null) && ((str12 = this.drivingSide) != null ? str12.equals(legStep.drivingSide()) : legStep.drivingSide() == null) && ((d4 = this.weight) != null ? d4.equals(legStep.weight()) : legStep.weight() == null) && ((list4 = this.intersections) != null ? list4.equals(legStep.intersections()) : legStep.intersections() == null)) {
                    String str13 = this.ref;
                    if (str13 == null) {
                        if (legStep.ref() == null) {
                            return true;
                        }
                    } else if (str13.equals(legStep.ref())) {
                        return true;
                    }
                }
                return false;
            }

            public int hashCode() {
                int iDoubleToLongBits = (((((int) ((Double.doubleToLongBits(this.distance) >>> 32) ^ Double.doubleToLongBits(this.distance))) ^ 1000003) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.duration) >>> 32) ^ Double.doubleToLongBits(this.duration)))) * 1000003;
                String str8 = this.geometry;
                int iHashCode = (iDoubleToLongBits ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
                String str9 = this.name;
                int iHashCode2 = (iHashCode ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
                String str10 = this.destinations;
                int iHashCode3 = (((iHashCode2 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003) ^ this.mode.hashCode()) * 1000003;
                String str11 = this.rotaryName;
                int iHashCode4 = (((iHashCode3 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003) ^ this.maneuver.hashCode()) * 1000003;
                List<BannerInstructions> list3 = this.bannerInstructions;
                int iHashCode5 = (iHashCode4 ^ (list3 == null ? 0 : list3.hashCode())) * 1000003;
                String str12 = this.drivingSide;
                int iHashCode6 = (iHashCode5 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
                Double d4 = this.weight;
                int iHashCode7 = (iHashCode6 ^ (d4 == null ? 0 : d4.hashCode())) * 1000003;
                List<StepIntersection> list4 = this.intersections;
                int iHashCode8 = (iHashCode7 ^ (list4 == null ? 0 : list4.hashCode())) * 1000003;
                String str13 = this.ref;
                return iHashCode8 ^ (str13 != null ? str13.hashCode() : 0);
            }

            @Override // com.mappls.sdk.services.api.directions.models.LegStep
            public LegStep.Builder toBuilder() {
                return new Builder(this);
            }

            /* JADX INFO: renamed from: com.mappls.sdk.services.api.directions.models.$AutoValue_LegStep$Builder */
            static class Builder extends LegStep.Builder {
                private List<BannerInstructions> bannerInstructions;
                private String destinations;
                private double distance;
                private String drivingSide;
                private double duration;
                private String geometry;
                private List<StepIntersection> intersections;
                private StepManeuver maneuver;
                private String mode;
                private String name;
                private String ref;
                private String rotaryName;
                private byte set$0;
                private Double weight;

                Builder() {
                }

                private Builder(LegStep legStep) {
                    this.distance = legStep.distance();
                    this.duration = legStep.duration();
                    this.geometry = legStep.geometry();
                    this.name = legStep.name();
                    this.destinations = legStep.destinations();
                    this.mode = legStep.mode();
                    this.rotaryName = legStep.rotaryName();
                    this.maneuver = legStep.maneuver();
                    this.bannerInstructions = legStep.bannerInstructions();
                    this.drivingSide = legStep.drivingSide();
                    this.weight = legStep.weight();
                    this.intersections = legStep.intersections();
                    this.ref = legStep.ref();
                    this.set$0 = (byte) 3;
                }

                @Override // com.mappls.sdk.services.api.directions.models.LegStep.Builder
                public LegStep.Builder distance(double d) {
                    this.distance = d;
                    this.set$0 = (byte) (this.set$0 | 1);
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.LegStep.Builder
                public LegStep.Builder duration(double d) {
                    this.duration = d;
                    this.set$0 = (byte) (this.set$0 | 2);
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.LegStep.Builder
                public LegStep.Builder geometry(String str) {
                    this.geometry = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.LegStep.Builder
                public LegStep.Builder name(String str) {
                    this.name = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.LegStep.Builder
                public LegStep.Builder destinations(String str) {
                    this.destinations = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.LegStep.Builder
                public LegStep.Builder mode(String str) {
                    if (str == null) {
                        throw new NullPointerException("Null mode");
                    }
                    this.mode = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.LegStep.Builder
                public LegStep.Builder rotaryName(String str) {
                    this.rotaryName = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.LegStep.Builder
                public LegStep.Builder maneuver(StepManeuver stepManeuver) {
                    if (stepManeuver == null) {
                        throw new NullPointerException("Null maneuver");
                    }
                    this.maneuver = stepManeuver;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.LegStep.Builder
                public LegStep.Builder bannerInstructions(List<BannerInstructions> list) {
                    this.bannerInstructions = list;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.LegStep.Builder
                public LegStep.Builder drivingSide(String str) {
                    this.drivingSide = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.LegStep.Builder
                public LegStep.Builder weight(Double d) {
                    this.weight = d;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.LegStep.Builder
                public LegStep.Builder intersections(List<StepIntersection> list) {
                    this.intersections = list;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.LegStep.Builder
                public LegStep.Builder ref(String str) {
                    this.ref = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.LegStep.Builder
                public LegStep build() {
                    String str;
                    StepManeuver stepManeuver;
                    if (this.set$0 != 3 || (str = this.mode) == null || (stepManeuver = this.maneuver) == null) {
                        StringBuilder sb = new StringBuilder();
                        if ((this.set$0 & 1) == 0) {
                            sb.append(" distance");
                        }
                        if ((this.set$0 & 2) == 0) {
                            sb.append(" duration");
                        }
                        if (this.mode == null) {
                            sb.append(" mode");
                        }
                        if (this.maneuver == null) {
                            sb.append(" maneuver");
                        }
                        throw new IllegalStateException("Missing required properties:" + ((Object) sb));
                    }
                    return new AutoValue_LegStep(this.distance, this.duration, this.geometry, this.name, this.destinations, str, this.rotaryName, stepManeuver, this.bannerInstructions, this.drivingSide, this.weight, this.intersections, this.ref);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<LegStep> {
        private volatile TypeAdapter<Double> double___adapter;
        private volatile TypeAdapter<Double> double__adapter;
        private final Gson gson;
        private volatile TypeAdapter<List<BannerInstructions>> list__bannerInstructions_adapter;
        private volatile TypeAdapter<List<StepIntersection>> list__stepIntersection_adapter;
        private volatile TypeAdapter<StepManeuver> stepManeuver_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, LegStep legStep) throws IOException {
            if (legStep == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name(DirectionsCriteria.ANNOTATION_DISTANCE);
            TypeAdapter<Double> adapter = this.double__adapter;
            if (adapter == null) {
                adapter = this.gson.getAdapter(Double.class);
                this.double__adapter = adapter;
            }
            adapter.write(jsonWriter, Double.valueOf(legStep.distance()));
            jsonWriter.name("duration");
            TypeAdapter<Double> adapter2 = this.double__adapter;
            if (adapter2 == null) {
                adapter2 = this.gson.getAdapter(Double.class);
                this.double__adapter = adapter2;
            }
            adapter2.write(jsonWriter, Double.valueOf(legStep.duration()));
            jsonWriter.name("geometry");
            if (legStep.geometry() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter3 = this.string_adapter;
                if (adapter3 == null) {
                    adapter3 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter3;
                }
                adapter3.write(jsonWriter, legStep.geometry());
            }
            jsonWriter.name("name");
            if (legStep.name() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter4 = this.string_adapter;
                if (adapter4 == null) {
                    adapter4 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter4;
                }
                adapter4.write(jsonWriter, legStep.name());
            }
            jsonWriter.name("destinations");
            if (legStep.destinations() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter5 = this.string_adapter;
                if (adapter5 == null) {
                    adapter5 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter5;
                }
                adapter5.write(jsonWriter, legStep.destinations());
            }
            jsonWriter.name(ModeProp.name);
            if (legStep.mode() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter6 = this.string_adapter;
                if (adapter6 == null) {
                    adapter6 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter6;
                }
                adapter6.write(jsonWriter, legStep.mode());
            }
            jsonWriter.name("rotary_name");
            if (legStep.rotaryName() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter7 = this.string_adapter;
                if (adapter7 == null) {
                    adapter7 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter7;
                }
                adapter7.write(jsonWriter, legStep.rotaryName());
            }
            jsonWriter.name("maneuver");
            if (legStep.maneuver() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<StepManeuver> adapter8 = this.stepManeuver_adapter;
                if (adapter8 == null) {
                    adapter8 = this.gson.getAdapter(StepManeuver.class);
                    this.stepManeuver_adapter = adapter8;
                }
                adapter8.write(jsonWriter, legStep.maneuver());
            }
            jsonWriter.name("banner_instructions");
            if (legStep.bannerInstructions() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<BannerInstructions>> adapter9 = this.list__bannerInstructions_adapter;
                if (adapter9 == null) {
                    adapter9 = this.gson.getAdapter(TypeToken.getParameterized(List.class, BannerInstructions.class));
                    this.list__bannerInstructions_adapter = adapter9;
                }
                adapter9.write(jsonWriter, legStep.bannerInstructions());
            }
            jsonWriter.name("driving_side");
            if (legStep.drivingSide() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter10 = this.string_adapter;
                if (adapter10 == null) {
                    adapter10 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter10;
                }
                adapter10.write(jsonWriter, legStep.drivingSide());
            }
            jsonWriter.name("weight");
            if (legStep.weight() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> adapter11 = this.double___adapter;
                if (adapter11 == null) {
                    adapter11 = this.gson.getAdapter(Double.class);
                    this.double___adapter = adapter11;
                }
                adapter11.write(jsonWriter, legStep.weight());
            }
            jsonWriter.name("intersections");
            if (legStep.intersections() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<StepIntersection>> adapter12 = this.list__stepIntersection_adapter;
                if (adapter12 == null) {
                    adapter12 = this.gson.getAdapter(TypeToken.getParameterized(List.class, StepIntersection.class));
                    this.list__stepIntersection_adapter = adapter12;
                }
                adapter12.write(jsonWriter, legStep.intersections());
            }
            jsonWriter.name("ref");
            if (legStep.ref() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter13 = this.string_adapter;
                if (adapter13 == null) {
                    adapter13 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter13;
                }
                adapter13.write(jsonWriter, legStep.ref());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: read */
        public LegStep read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            LegStep.Builder builder = LegStep.builder();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    strNextName.hashCode();
                    switch (strNextName) {
                        case "banner_instructions":
                            TypeAdapter<List<BannerInstructions>> adapter = this.list__bannerInstructions_adapter;
                            if (adapter == null) {
                                adapter = this.gson.getAdapter(TypeToken.getParameterized(List.class, BannerInstructions.class));
                                this.list__bannerInstructions_adapter = adapter;
                            }
                            builder.bannerInstructions(adapter.read2(jsonReader));
                            break;
                        case "driving_side":
                            TypeAdapter<String> adapter2 = this.string_adapter;
                            if (adapter2 == null) {
                                adapter2 = this.gson.getAdapter(String.class);
                                this.string_adapter = adapter2;
                            }
                            builder.drivingSide(adapter2.read2(jsonReader));
                            break;
                        case "rotary_name":
                            TypeAdapter<String> adapter3 = this.string_adapter;
                            if (adapter3 == null) {
                                adapter3 = this.gson.getAdapter(String.class);
                                this.string_adapter = adapter3;
                            }
                            builder.rotaryName(adapter3.read2(jsonReader));
                            break;
                        default:
                            if (DirectionsCriteria.ANNOTATION_DISTANCE.equals(strNextName)) {
                                TypeAdapter<Double> adapter4 = this.double__adapter;
                                if (adapter4 == null) {
                                    adapter4 = this.gson.getAdapter(Double.class);
                                    this.double__adapter = adapter4;
                                }
                                builder.distance(adapter4.read2(jsonReader).doubleValue());
                                break;
                            } else {
                                if ("duration".equals(strNextName)) {
                                    TypeAdapter<Double> adapter5 = this.double__adapter;
                                    if (adapter5 == null) {
                                        adapter5 = this.gson.getAdapter(Double.class);
                                        this.double__adapter = adapter5;
                                    }
                                    builder.duration(adapter5.read2(jsonReader).doubleValue());
                                } else if ("geometry".equals(strNextName)) {
                                    TypeAdapter<String> adapter6 = this.string_adapter;
                                    if (adapter6 == null) {
                                        adapter6 = this.gson.getAdapter(String.class);
                                        this.string_adapter = adapter6;
                                    }
                                    builder.geometry(adapter6.read2(jsonReader));
                                } else if ("name".equals(strNextName)) {
                                    TypeAdapter<String> adapter7 = this.string_adapter;
                                    if (adapter7 == null) {
                                        adapter7 = this.gson.getAdapter(String.class);
                                        this.string_adapter = adapter7;
                                    }
                                    builder.name(adapter7.read2(jsonReader));
                                } else if ("destinations".equals(strNextName)) {
                                    TypeAdapter<String> adapter8 = this.string_adapter;
                                    if (adapter8 == null) {
                                        adapter8 = this.gson.getAdapter(String.class);
                                        this.string_adapter = adapter8;
                                    }
                                    builder.destinations(adapter8.read2(jsonReader));
                                } else if (ModeProp.name.equals(strNextName)) {
                                    TypeAdapter<String> adapter9 = this.string_adapter;
                                    if (adapter9 == null) {
                                        adapter9 = this.gson.getAdapter(String.class);
                                        this.string_adapter = adapter9;
                                    }
                                    builder.mode(adapter9.read2(jsonReader));
                                } else if ("maneuver".equals(strNextName)) {
                                    TypeAdapter<StepManeuver> adapter10 = this.stepManeuver_adapter;
                                    if (adapter10 == null) {
                                        adapter10 = this.gson.getAdapter(StepManeuver.class);
                                        this.stepManeuver_adapter = adapter10;
                                    }
                                    builder.maneuver(adapter10.read2(jsonReader));
                                } else if ("weight".equals(strNextName)) {
                                    TypeAdapter<Double> adapter11 = this.double___adapter;
                                    if (adapter11 == null) {
                                        adapter11 = this.gson.getAdapter(Double.class);
                                        this.double___adapter = adapter11;
                                    }
                                    builder.weight(adapter11.read2(jsonReader));
                                } else if ("intersections".equals(strNextName)) {
                                    TypeAdapter<List<StepIntersection>> adapter12 = this.list__stepIntersection_adapter;
                                    if (adapter12 == null) {
                                        adapter12 = this.gson.getAdapter(TypeToken.getParameterized(List.class, StepIntersection.class));
                                        this.list__stepIntersection_adapter = adapter12;
                                    }
                                    builder.intersections(adapter12.read2(jsonReader));
                                } else if ("ref".equals(strNextName)) {
                                    TypeAdapter<String> adapter13 = this.string_adapter;
                                    if (adapter13 == null) {
                                        adapter13 = this.gson.getAdapter(String.class);
                                        this.string_adapter = adapter13;
                                    }
                                    builder.ref(adapter13.read2(jsonReader));
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
            return "TypeAdapter(LegStep)";
        }
    }
}

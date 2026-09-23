package com.mappls.sdk.services.api.directions.models;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_RouteLeg extends C$AutoValue_RouteLeg {
    AutoValue_RouteLeg(Double d, Double d2, String str, List<LegStep> list, LegAnnotation legAnnotation, Double d3, Double d4, Double d5, Double d6, Double d7, Double d8, Double d9) {
        new RouteLeg(d, d2, str, list, legAnnotation, d3, d4, d5, d6, d7, d8, d9) { // from class: com.mappls.sdk.services.api.directions.models.$AutoValue_RouteLeg
            private final LegAnnotation annotation;
            private final Double distance;
            private final Double dsocd;
            private final Double duration;
            private final Double rdrd;
            private final Double rdrdm;
            private final Double socdi;
            private final Double socdm;
            private final List<LegStep> steps;
            private final String summary;
            private final Double tc;
            private final Double weight;

            {
                this.distance = d;
                this.duration = d2;
                this.summary = str;
                this.steps = list;
                this.annotation = legAnnotation;
                this.weight = d3;
                this.rdrd = d4;
                this.rdrdm = d5;
                this.dsocd = d6;
                this.socdi = d7;
                this.socdm = d8;
                this.tc = d9;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteLeg
            public Double distance() {
                return this.distance;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteLeg
            public Double duration() {
                return this.duration;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteLeg
            public String summary() {
                return this.summary;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteLeg
            public List<LegStep> steps() {
                return this.steps;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteLeg
            public LegAnnotation annotation() {
                return this.annotation;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteLeg
            public Double weight() {
                return this.weight;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteLeg
            public Double rdrd() {
                return this.rdrd;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteLeg
            public Double rdrdm() {
                return this.rdrdm;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteLeg
            public Double dsocd() {
                return this.dsocd;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteLeg
            public Double socdi() {
                return this.socdi;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteLeg
            public Double socdm() {
                return this.socdm;
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteLeg
            public Double tc() {
                return this.tc;
            }

            public String toString() {
                return "RouteLeg{distance=" + this.distance + ", duration=" + this.duration + ", summary=" + this.summary + ", steps=" + this.steps + ", annotation=" + this.annotation + ", weight=" + this.weight + ", rdrd=" + this.rdrd + ", rdrdm=" + this.rdrdm + ", dsocd=" + this.dsocd + ", socdi=" + this.socdi + ", socdm=" + this.socdm + ", tc=" + this.tc + "}";
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof RouteLeg)) {
                    return false;
                }
                RouteLeg routeLeg = (RouteLeg) obj;
                Double d10 = this.distance;
                if (d10 != null ? d10.equals(routeLeg.distance()) : routeLeg.distance() == null) {
                    Double d11 = this.duration;
                    if (d11 != null ? d11.equals(routeLeg.duration()) : routeLeg.duration() == null) {
                        String str2 = this.summary;
                        if (str2 != null ? str2.equals(routeLeg.summary()) : routeLeg.summary() == null) {
                            List<LegStep> list2 = this.steps;
                            if (list2 != null ? list2.equals(routeLeg.steps()) : routeLeg.steps() == null) {
                                LegAnnotation legAnnotation2 = this.annotation;
                                if (legAnnotation2 != null ? legAnnotation2.equals(routeLeg.annotation()) : routeLeg.annotation() == null) {
                                    Double d12 = this.weight;
                                    if (d12 != null ? d12.equals(routeLeg.weight()) : routeLeg.weight() == null) {
                                        Double d13 = this.rdrd;
                                        if (d13 != null ? d13.equals(routeLeg.rdrd()) : routeLeg.rdrd() == null) {
                                            Double d14 = this.rdrdm;
                                            if (d14 != null ? d14.equals(routeLeg.rdrdm()) : routeLeg.rdrdm() == null) {
                                                Double d15 = this.dsocd;
                                                if (d15 != null ? d15.equals(routeLeg.dsocd()) : routeLeg.dsocd() == null) {
                                                    Double d16 = this.socdi;
                                                    if (d16 != null ? d16.equals(routeLeg.socdi()) : routeLeg.socdi() == null) {
                                                        Double d17 = this.socdm;
                                                        if (d17 != null ? d17.equals(routeLeg.socdm()) : routeLeg.socdm() == null) {
                                                            Double d18 = this.tc;
                                                            if (d18 == null) {
                                                                if (routeLeg.tc() == null) {
                                                                    return true;
                                                                }
                                                            } else if (d18.equals(routeLeg.tc())) {
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
                return false;
            }

            public int hashCode() {
                Double d10 = this.distance;
                int iHashCode = ((d10 == null ? 0 : d10.hashCode()) ^ 1000003) * 1000003;
                Double d11 = this.duration;
                int iHashCode2 = (iHashCode ^ (d11 == null ? 0 : d11.hashCode())) * 1000003;
                String str2 = this.summary;
                int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
                List<LegStep> list2 = this.steps;
                int iHashCode4 = (iHashCode3 ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
                LegAnnotation legAnnotation2 = this.annotation;
                int iHashCode5 = (iHashCode4 ^ (legAnnotation2 == null ? 0 : legAnnotation2.hashCode())) * 1000003;
                Double d12 = this.weight;
                int iHashCode6 = (iHashCode5 ^ (d12 == null ? 0 : d12.hashCode())) * 1000003;
                Double d13 = this.rdrd;
                int iHashCode7 = (iHashCode6 ^ (d13 == null ? 0 : d13.hashCode())) * 1000003;
                Double d14 = this.rdrdm;
                int iHashCode8 = (iHashCode7 ^ (d14 == null ? 0 : d14.hashCode())) * 1000003;
                Double d15 = this.dsocd;
                int iHashCode9 = (iHashCode8 ^ (d15 == null ? 0 : d15.hashCode())) * 1000003;
                Double d16 = this.socdi;
                int iHashCode10 = (iHashCode9 ^ (d16 == null ? 0 : d16.hashCode())) * 1000003;
                Double d17 = this.socdm;
                int iHashCode11 = (iHashCode10 ^ (d17 == null ? 0 : d17.hashCode())) * 1000003;
                Double d18 = this.tc;
                return iHashCode11 ^ (d18 != null ? d18.hashCode() : 0);
            }

            @Override // com.mappls.sdk.services.api.directions.models.RouteLeg
            public RouteLeg.Builder toBuilder() {
                return new Builder(this);
            }

            /* JADX INFO: renamed from: com.mappls.sdk.services.api.directions.models.$AutoValue_RouteLeg$Builder */
            static class Builder extends RouteLeg.Builder {
                private LegAnnotation annotation;
                private Double distance;
                private Double dsocd;
                private Double duration;
                private Double rdrd;
                private Double rdrdm;
                private Double socdi;
                private Double socdm;
                private List<LegStep> steps;
                private String summary;
                private Double tc;
                private Double weight;

                Builder() {
                }

                private Builder(RouteLeg routeLeg) {
                    this.distance = routeLeg.distance();
                    this.duration = routeLeg.duration();
                    this.summary = routeLeg.summary();
                    this.steps = routeLeg.steps();
                    this.annotation = routeLeg.annotation();
                    this.weight = routeLeg.weight();
                    this.rdrd = routeLeg.rdrd();
                    this.rdrdm = routeLeg.rdrdm();
                    this.dsocd = routeLeg.dsocd();
                    this.socdi = routeLeg.socdi();
                    this.socdm = routeLeg.socdm();
                    this.tc = routeLeg.tc();
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteLeg.Builder
                public RouteLeg.Builder distance(Double d) {
                    this.distance = d;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteLeg.Builder
                public RouteLeg.Builder duration(Double d) {
                    this.duration = d;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteLeg.Builder
                public RouteLeg.Builder summary(String str) {
                    this.summary = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteLeg.Builder
                public RouteLeg.Builder steps(List<LegStep> list) {
                    this.steps = list;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteLeg.Builder
                public RouteLeg.Builder annotation(LegAnnotation legAnnotation) {
                    this.annotation = legAnnotation;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteLeg.Builder
                public RouteLeg.Builder weight(Double d) {
                    this.weight = d;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteLeg.Builder
                public RouteLeg.Builder rdrd(Double d) {
                    this.rdrd = d;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteLeg.Builder
                public RouteLeg.Builder rdrdm(Double d) {
                    this.rdrdm = d;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteLeg.Builder
                public RouteLeg.Builder dsocd(Double d) {
                    this.dsocd = d;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteLeg.Builder
                public RouteLeg.Builder socdi(Double d) {
                    this.socdi = d;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteLeg.Builder
                public RouteLeg.Builder socdm(Double d) {
                    this.socdm = d;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteLeg.Builder
                public RouteLeg.Builder tc(Double d) {
                    this.tc = d;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.RouteLeg.Builder
                public RouteLeg build() {
                    return new AutoValue_RouteLeg(this.distance, this.duration, this.summary, this.steps, this.annotation, this.weight, this.rdrd, this.rdrdm, this.dsocd, this.socdi, this.socdm, this.tc);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<RouteLeg> {
        private volatile TypeAdapter<Double> double__adapter;
        private final Gson gson;
        private volatile TypeAdapter<LegAnnotation> legAnnotation_adapter;
        private volatile TypeAdapter<List<LegStep>> list__legStep_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, RouteLeg routeLeg) throws IOException {
            if (routeLeg == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name(DirectionsCriteria.ANNOTATION_DISTANCE);
            if (routeLeg.distance() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> adapter = this.double__adapter;
                if (adapter == null) {
                    adapter = this.gson.getAdapter(Double.class);
                    this.double__adapter = adapter;
                }
                adapter.write(jsonWriter, routeLeg.distance());
            }
            jsonWriter.name("duration");
            if (routeLeg.duration() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> adapter2 = this.double__adapter;
                if (adapter2 == null) {
                    adapter2 = this.gson.getAdapter(Double.class);
                    this.double__adapter = adapter2;
                }
                adapter2.write(jsonWriter, routeLeg.duration());
            }
            jsonWriter.name("summary");
            if (routeLeg.summary() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter3 = this.string_adapter;
                if (adapter3 == null) {
                    adapter3 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter3;
                }
                adapter3.write(jsonWriter, routeLeg.summary());
            }
            jsonWriter.name("steps");
            if (routeLeg.steps() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<LegStep>> adapter4 = this.list__legStep_adapter;
                if (adapter4 == null) {
                    adapter4 = this.gson.getAdapter(TypeToken.getParameterized(List.class, LegStep.class));
                    this.list__legStep_adapter = adapter4;
                }
                adapter4.write(jsonWriter, routeLeg.steps());
            }
            jsonWriter.name("annotation");
            if (routeLeg.annotation() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<LegAnnotation> adapter5 = this.legAnnotation_adapter;
                if (adapter5 == null) {
                    adapter5 = this.gson.getAdapter(LegAnnotation.class);
                    this.legAnnotation_adapter = adapter5;
                }
                adapter5.write(jsonWriter, routeLeg.annotation());
            }
            jsonWriter.name("weight");
            if (routeLeg.weight() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> adapter6 = this.double__adapter;
                if (adapter6 == null) {
                    adapter6 = this.gson.getAdapter(Double.class);
                    this.double__adapter = adapter6;
                }
                adapter6.write(jsonWriter, routeLeg.weight());
            }
            jsonWriter.name("rdrd");
            if (routeLeg.rdrd() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> adapter7 = this.double__adapter;
                if (adapter7 == null) {
                    adapter7 = this.gson.getAdapter(Double.class);
                    this.double__adapter = adapter7;
                }
                adapter7.write(jsonWriter, routeLeg.rdrd());
            }
            jsonWriter.name("rdrdm");
            if (routeLeg.rdrdm() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> adapter8 = this.double__adapter;
                if (adapter8 == null) {
                    adapter8 = this.gson.getAdapter(Double.class);
                    this.double__adapter = adapter8;
                }
                adapter8.write(jsonWriter, routeLeg.rdrdm());
            }
            jsonWriter.name("dsocd");
            if (routeLeg.dsocd() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> adapter9 = this.double__adapter;
                if (adapter9 == null) {
                    adapter9 = this.gson.getAdapter(Double.class);
                    this.double__adapter = adapter9;
                }
                adapter9.write(jsonWriter, routeLeg.dsocd());
            }
            jsonWriter.name("socdi");
            if (routeLeg.socdi() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> adapter10 = this.double__adapter;
                if (adapter10 == null) {
                    adapter10 = this.gson.getAdapter(Double.class);
                    this.double__adapter = adapter10;
                }
                adapter10.write(jsonWriter, routeLeg.socdi());
            }
            jsonWriter.name("socdm");
            if (routeLeg.socdm() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> adapter11 = this.double__adapter;
                if (adapter11 == null) {
                    adapter11 = this.gson.getAdapter(Double.class);
                    this.double__adapter = adapter11;
                }
                adapter11.write(jsonWriter, routeLeg.socdm());
            }
            jsonWriter.name("tc");
            if (routeLeg.tc() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> adapter12 = this.double__adapter;
                if (adapter12 == null) {
                    adapter12 = this.gson.getAdapter(Double.class);
                    this.double__adapter = adapter12;
                }
                adapter12.write(jsonWriter, routeLeg.tc());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: read */
        public RouteLeg read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            RouteLeg.Builder builder = RouteLeg.builder();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    strNextName.hashCode();
                    if (DirectionsCriteria.ANNOTATION_DISTANCE.equals(strNextName)) {
                        TypeAdapter<Double> adapter = this.double__adapter;
                        if (adapter == null) {
                            adapter = this.gson.getAdapter(Double.class);
                            this.double__adapter = adapter;
                        }
                        builder.distance(adapter.read2(jsonReader));
                    } else if ("duration".equals(strNextName)) {
                        TypeAdapter<Double> adapter2 = this.double__adapter;
                        if (adapter2 == null) {
                            adapter2 = this.gson.getAdapter(Double.class);
                            this.double__adapter = adapter2;
                        }
                        builder.duration(adapter2.read2(jsonReader));
                    } else if ("summary".equals(strNextName)) {
                        TypeAdapter<String> adapter3 = this.string_adapter;
                        if (adapter3 == null) {
                            adapter3 = this.gson.getAdapter(String.class);
                            this.string_adapter = adapter3;
                        }
                        builder.summary(adapter3.read2(jsonReader));
                    } else if ("steps".equals(strNextName)) {
                        TypeAdapter<List<LegStep>> adapter4 = this.list__legStep_adapter;
                        if (adapter4 == null) {
                            adapter4 = this.gson.getAdapter(TypeToken.getParameterized(List.class, LegStep.class));
                            this.list__legStep_adapter = adapter4;
                        }
                        builder.steps(adapter4.read2(jsonReader));
                    } else if ("annotation".equals(strNextName)) {
                        TypeAdapter<LegAnnotation> adapter5 = this.legAnnotation_adapter;
                        if (adapter5 == null) {
                            adapter5 = this.gson.getAdapter(LegAnnotation.class);
                            this.legAnnotation_adapter = adapter5;
                        }
                        builder.annotation(adapter5.read2(jsonReader));
                    } else if ("weight".equals(strNextName)) {
                        TypeAdapter<Double> adapter6 = this.double__adapter;
                        if (adapter6 == null) {
                            adapter6 = this.gson.getAdapter(Double.class);
                            this.double__adapter = adapter6;
                        }
                        builder.weight(adapter6.read2(jsonReader));
                    } else if ("rdrd".equals(strNextName)) {
                        TypeAdapter<Double> adapter7 = this.double__adapter;
                        if (adapter7 == null) {
                            adapter7 = this.gson.getAdapter(Double.class);
                            this.double__adapter = adapter7;
                        }
                        builder.rdrd(adapter7.read2(jsonReader));
                    } else if ("rdrdm".equals(strNextName)) {
                        TypeAdapter<Double> adapter8 = this.double__adapter;
                        if (adapter8 == null) {
                            adapter8 = this.gson.getAdapter(Double.class);
                            this.double__adapter = adapter8;
                        }
                        builder.rdrdm(adapter8.read2(jsonReader));
                    } else if ("dsocd".equals(strNextName)) {
                        TypeAdapter<Double> adapter9 = this.double__adapter;
                        if (adapter9 == null) {
                            adapter9 = this.gson.getAdapter(Double.class);
                            this.double__adapter = adapter9;
                        }
                        builder.dsocd(adapter9.read2(jsonReader));
                    } else if ("socdi".equals(strNextName)) {
                        TypeAdapter<Double> adapter10 = this.double__adapter;
                        if (adapter10 == null) {
                            adapter10 = this.gson.getAdapter(Double.class);
                            this.double__adapter = adapter10;
                        }
                        builder.socdi(adapter10.read2(jsonReader));
                    } else if ("socdm".equals(strNextName)) {
                        TypeAdapter<Double> adapter11 = this.double__adapter;
                        if (adapter11 == null) {
                            adapter11 = this.gson.getAdapter(Double.class);
                            this.double__adapter = adapter11;
                        }
                        builder.socdm(adapter11.read2(jsonReader));
                    } else if ("tc".equals(strNextName)) {
                        TypeAdapter<Double> adapter12 = this.double__adapter;
                        if (adapter12 == null) {
                            adapter12 = this.gson.getAdapter(Double.class);
                            this.double__adapter = adapter12;
                        }
                        builder.tc(adapter12.read2(jsonReader));
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return builder.build();
        }

        public String toString() {
            return "TypeAdapter(RouteLeg)";
        }
    }
}

package com.mappls.sdk.services.api.directions.models;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_StepIntersection extends C$AutoValue_StepIntersection {
    AutoValue_StepIntersection(double[] dArr, List<Integer> list, List<String> list2, List<Boolean> list3, Integer num, Integer num2, List<IntersectionLanes> list4) {
        new StepIntersection(dArr, list, list2, list3, num, num2, list4) { // from class: com.mappls.sdk.services.api.directions.models.$AutoValue_StepIntersection
            private final List<Integer> bearings;
            private final List<String> classes;
            private final List<Boolean> entry;
            private final Integer in;
            private final List<IntersectionLanes> lanes;
            private final Integer out;
            private final double[] rawLocation;

            {
                if (dArr == null) {
                    throw new NullPointerException("Null rawLocation");
                }
                this.rawLocation = dArr;
                this.bearings = list;
                this.classes = list2;
                this.entry = list3;
                this.in = num;
                this.out = num2;
                this.lanes = list4;
            }

            @Override // com.mappls.sdk.services.api.directions.models.StepIntersection
            @SerializedName(FirebaseAnalytics.Param.LOCATION)
            protected double[] rawLocation() {
                return this.rawLocation;
            }

            @Override // com.mappls.sdk.services.api.directions.models.StepIntersection
            public List<Integer> bearings() {
                return this.bearings;
            }

            @Override // com.mappls.sdk.services.api.directions.models.StepIntersection
            public List<String> classes() {
                return this.classes;
            }

            @Override // com.mappls.sdk.services.api.directions.models.StepIntersection
            public List<Boolean> entry() {
                return this.entry;
            }

            @Override // com.mappls.sdk.services.api.directions.models.StepIntersection
            public Integer in() {
                return this.in;
            }

            @Override // com.mappls.sdk.services.api.directions.models.StepIntersection
            public Integer out() {
                return this.out;
            }

            @Override // com.mappls.sdk.services.api.directions.models.StepIntersection
            public List<IntersectionLanes> lanes() {
                return this.lanes;
            }

            public String toString() {
                return "StepIntersection{rawLocation=" + Arrays.toString(this.rawLocation) + ", bearings=" + this.bearings + ", classes=" + this.classes + ", entry=" + this.entry + ", in=" + this.in + ", out=" + this.out + ", lanes=" + this.lanes + "}";
            }

            public boolean equals(Object obj) {
                List<Integer> list5;
                List<String> list6;
                List<Boolean> list7;
                Integer num3;
                Integer num4;
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof StepIntersection)) {
                    return false;
                }
                StepIntersection stepIntersection = (StepIntersection) obj;
                if (Arrays.equals(this.rawLocation, stepIntersection instanceof C$AutoValue_StepIntersection ? ((C$AutoValue_StepIntersection) stepIntersection).rawLocation : stepIntersection.rawLocation()) && ((list5 = this.bearings) != null ? list5.equals(stepIntersection.bearings()) : stepIntersection.bearings() == null) && ((list6 = this.classes) != null ? list6.equals(stepIntersection.classes()) : stepIntersection.classes() == null) && ((list7 = this.entry) != null ? list7.equals(stepIntersection.entry()) : stepIntersection.entry() == null) && ((num3 = this.in) != null ? num3.equals(stepIntersection.in()) : stepIntersection.in() == null) && ((num4 = this.out) != null ? num4.equals(stepIntersection.out()) : stepIntersection.out() == null)) {
                    List<IntersectionLanes> list8 = this.lanes;
                    if (list8 == null) {
                        if (stepIntersection.lanes() == null) {
                            return true;
                        }
                    } else if (list8.equals(stepIntersection.lanes())) {
                        return true;
                    }
                }
                return false;
            }

            public int hashCode() {
                int iHashCode = (Arrays.hashCode(this.rawLocation) ^ 1000003) * 1000003;
                List<Integer> list5 = this.bearings;
                int iHashCode2 = (iHashCode ^ (list5 == null ? 0 : list5.hashCode())) * 1000003;
                List<String> list6 = this.classes;
                int iHashCode3 = (iHashCode2 ^ (list6 == null ? 0 : list6.hashCode())) * 1000003;
                List<Boolean> list7 = this.entry;
                int iHashCode4 = (iHashCode3 ^ (list7 == null ? 0 : list7.hashCode())) * 1000003;
                Integer num3 = this.in;
                int iHashCode5 = (iHashCode4 ^ (num3 == null ? 0 : num3.hashCode())) * 1000003;
                Integer num4 = this.out;
                int iHashCode6 = (iHashCode5 ^ (num4 == null ? 0 : num4.hashCode())) * 1000003;
                List<IntersectionLanes> list8 = this.lanes;
                return iHashCode6 ^ (list8 != null ? list8.hashCode() : 0);
            }

            @Override // com.mappls.sdk.services.api.directions.models.StepIntersection
            public StepIntersection.Builder toBuilder() {
                return new Builder(this);
            }

            /* JADX INFO: renamed from: com.mappls.sdk.services.api.directions.models.$AutoValue_StepIntersection$Builder */
            static class Builder extends StepIntersection.Builder {
                private List<Integer> bearings;
                private List<String> classes;
                private List<Boolean> entry;
                private Integer in;
                private List<IntersectionLanes> lanes;
                private Integer out;
                private double[] rawLocation;

                Builder() {
                }

                private Builder(StepIntersection stepIntersection) {
                    this.rawLocation = stepIntersection.rawLocation();
                    this.bearings = stepIntersection.bearings();
                    this.classes = stepIntersection.classes();
                    this.entry = stepIntersection.entry();
                    this.in = stepIntersection.in();
                    this.out = stepIntersection.out();
                    this.lanes = stepIntersection.lanes();
                }

                @Override // com.mappls.sdk.services.api.directions.models.StepIntersection.Builder
                public StepIntersection.Builder rawLocation(double[] dArr) {
                    if (dArr == null) {
                        throw new NullPointerException("Null rawLocation");
                    }
                    this.rawLocation = dArr;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.StepIntersection.Builder
                public StepIntersection.Builder bearings(List<Integer> list) {
                    this.bearings = list;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.StepIntersection.Builder
                public StepIntersection.Builder classes(List<String> list) {
                    this.classes = list;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.StepIntersection.Builder
                public StepIntersection.Builder entry(List<Boolean> list) {
                    this.entry = list;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.StepIntersection.Builder
                public StepIntersection.Builder in(Integer num) {
                    this.in = num;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.StepIntersection.Builder
                public StepIntersection.Builder out(Integer num) {
                    this.out = num;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.StepIntersection.Builder
                public StepIntersection.Builder lanes(List<IntersectionLanes> list) {
                    this.lanes = list;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.StepIntersection.Builder
                public StepIntersection build() {
                    double[] dArr = this.rawLocation;
                    if (dArr == null) {
                        throw new IllegalStateException("Missing required properties: rawLocation");
                    }
                    return new AutoValue_StepIntersection(dArr, this.bearings, this.classes, this.entry, this.in, this.out, this.lanes);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<StepIntersection> {
        private volatile TypeAdapter<double[]> array__double_adapter;
        private final Gson gson;
        private volatile TypeAdapter<Integer> integer_adapter;
        private volatile TypeAdapter<List<Boolean>> list__boolean_adapter;
        private volatile TypeAdapter<List<Integer>> list__integer_adapter;
        private volatile TypeAdapter<List<IntersectionLanes>> list__intersectionLanes_adapter;
        private volatile TypeAdapter<List<String>> list__string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, StepIntersection stepIntersection) throws IOException {
            if (stepIntersection == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name(FirebaseAnalytics.Param.LOCATION);
            if (stepIntersection.rawLocation() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<double[]> adapter = this.array__double_adapter;
                if (adapter == null) {
                    adapter = this.gson.getAdapter(double[].class);
                    this.array__double_adapter = adapter;
                }
                adapter.write(jsonWriter, stepIntersection.rawLocation());
            }
            jsonWriter.name("bearings");
            if (stepIntersection.bearings() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<Integer>> adapter2 = this.list__integer_adapter;
                if (adapter2 == null) {
                    adapter2 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Integer.class));
                    this.list__integer_adapter = adapter2;
                }
                adapter2.write(jsonWriter, stepIntersection.bearings());
            }
            jsonWriter.name("classes");
            if (stepIntersection.classes() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<String>> adapter3 = this.list__string_adapter;
                if (adapter3 == null) {
                    adapter3 = this.gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
                    this.list__string_adapter = adapter3;
                }
                adapter3.write(jsonWriter, stepIntersection.classes());
            }
            jsonWriter.name("entry");
            if (stepIntersection.entry() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<Boolean>> adapter4 = this.list__boolean_adapter;
                if (adapter4 == null) {
                    adapter4 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Boolean.class));
                    this.list__boolean_adapter = adapter4;
                }
                adapter4.write(jsonWriter, stepIntersection.entry());
            }
            jsonWriter.name("in");
            if (stepIntersection.in() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> adapter5 = this.integer_adapter;
                if (adapter5 == null) {
                    adapter5 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = adapter5;
                }
                adapter5.write(jsonWriter, stepIntersection.in());
            }
            jsonWriter.name("out");
            if (stepIntersection.out() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> adapter6 = this.integer_adapter;
                if (adapter6 == null) {
                    adapter6 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = adapter6;
                }
                adapter6.write(jsonWriter, stepIntersection.out());
            }
            jsonWriter.name("lanes");
            if (stepIntersection.lanes() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<IntersectionLanes>> adapter7 = this.list__intersectionLanes_adapter;
                if (adapter7 == null) {
                    adapter7 = this.gson.getAdapter(TypeToken.getParameterized(List.class, IntersectionLanes.class));
                    this.list__intersectionLanes_adapter = adapter7;
                }
                adapter7.write(jsonWriter, stepIntersection.lanes());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: read */
        public StepIntersection read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            StepIntersection.Builder builder = StepIntersection.builder();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    strNextName.hashCode();
                    if (strNextName.equals(FirebaseAnalytics.Param.LOCATION)) {
                        TypeAdapter<double[]> adapter = this.array__double_adapter;
                        if (adapter == null) {
                            adapter = this.gson.getAdapter(double[].class);
                            this.array__double_adapter = adapter;
                        }
                        builder.rawLocation(adapter.read2(jsonReader));
                    } else if ("bearings".equals(strNextName)) {
                        TypeAdapter<List<Integer>> adapter2 = this.list__integer_adapter;
                        if (adapter2 == null) {
                            adapter2 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Integer.class));
                            this.list__integer_adapter = adapter2;
                        }
                        builder.bearings(adapter2.read2(jsonReader));
                    } else if ("classes".equals(strNextName)) {
                        TypeAdapter<List<String>> adapter3 = this.list__string_adapter;
                        if (adapter3 == null) {
                            adapter3 = this.gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
                            this.list__string_adapter = adapter3;
                        }
                        builder.classes(adapter3.read2(jsonReader));
                    } else if ("entry".equals(strNextName)) {
                        TypeAdapter<List<Boolean>> adapter4 = this.list__boolean_adapter;
                        if (adapter4 == null) {
                            adapter4 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Boolean.class));
                            this.list__boolean_adapter = adapter4;
                        }
                        builder.entry(adapter4.read2(jsonReader));
                    } else if ("in".equals(strNextName)) {
                        TypeAdapter<Integer> adapter5 = this.integer_adapter;
                        if (adapter5 == null) {
                            adapter5 = this.gson.getAdapter(Integer.class);
                            this.integer_adapter = adapter5;
                        }
                        builder.in(adapter5.read2(jsonReader));
                    } else if ("out".equals(strNextName)) {
                        TypeAdapter<Integer> adapter6 = this.integer_adapter;
                        if (adapter6 == null) {
                            adapter6 = this.gson.getAdapter(Integer.class);
                            this.integer_adapter = adapter6;
                        }
                        builder.out(adapter6.read2(jsonReader));
                    } else if ("lanes".equals(strNextName)) {
                        TypeAdapter<List<IntersectionLanes>> adapter7 = this.list__intersectionLanes_adapter;
                        if (adapter7 == null) {
                            adapter7 = this.gson.getAdapter(TypeToken.getParameterized(List.class, IntersectionLanes.class));
                            this.list__intersectionLanes_adapter = adapter7;
                        }
                        builder.lanes(adapter7.read2(jsonReader));
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return builder.build();
        }

        public String toString() {
            return "TypeAdapter(StepIntersection)";
        }
    }
}

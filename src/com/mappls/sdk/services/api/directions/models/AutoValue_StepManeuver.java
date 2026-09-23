package com.mappls.sdk.services.api.directions.models;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_StepManeuver extends C$AutoValue_StepManeuver {
    AutoValue_StepManeuver(Double d, double[] dArr, Double d2, Double d3, String str, String str2, Integer num, String str3, String str4, Integer num2) {
        new StepManeuver(d, dArr, d2, d3, str, str2, num, str3, str4, num2) { // from class: com.mappls.sdk.services.api.directions.models.$AutoValue_StepManeuver
            private final Double bearingAfter;
            private final Double bearingBefore;
            private final Double degree;
            private final Integer exit;
            private final String instruction;
            private final Integer maneuverId;
            private final String modifier;
            private final double[] rawLocation;
            private final String shortInstruction;
            private final String type;

            {
                this.degree = d;
                if (dArr == null) {
                    throw new NullPointerException("Null rawLocation");
                }
                this.rawLocation = dArr;
                this.bearingBefore = d2;
                this.bearingAfter = d3;
                this.instruction = str;
                this.shortInstruction = str2;
                this.maneuverId = num;
                this.type = str3;
                this.modifier = str4;
                this.exit = num2;
            }

            @Override // com.mappls.sdk.services.api.directions.models.StepManeuver
            @SerializedName("degree")
            public Double degree() {
                return this.degree;
            }

            @Override // com.mappls.sdk.services.api.directions.models.StepManeuver
            @SerializedName(FirebaseAnalytics.Param.LOCATION)
            protected double[] rawLocation() {
                return this.rawLocation;
            }

            @Override // com.mappls.sdk.services.api.directions.models.StepManeuver
            @SerializedName("bearing_before")
            public Double bearingBefore() {
                return this.bearingBefore;
            }

            @Override // com.mappls.sdk.services.api.directions.models.StepManeuver
            @SerializedName("bearing_after")
            public Double bearingAfter() {
                return this.bearingAfter;
            }

            @Override // com.mappls.sdk.services.api.directions.models.StepManeuver
            public String instruction() {
                return this.instruction;
            }

            @Override // com.mappls.sdk.services.api.directions.models.StepManeuver
            @SerializedName("short_instruction")
            public String shortInstruction() {
                return this.shortInstruction;
            }

            @Override // com.mappls.sdk.services.api.directions.models.StepManeuver
            @SerializedName("maneuver_id")
            public Integer maneuverId() {
                return this.maneuverId;
            }

            @Override // com.mappls.sdk.services.api.directions.models.StepManeuver
            public String type() {
                return this.type;
            }

            @Override // com.mappls.sdk.services.api.directions.models.StepManeuver
            public String modifier() {
                return this.modifier;
            }

            @Override // com.mappls.sdk.services.api.directions.models.StepManeuver
            public Integer exit() {
                return this.exit;
            }

            public String toString() {
                return "StepManeuver{degree=" + this.degree + ", rawLocation=" + Arrays.toString(this.rawLocation) + ", bearingBefore=" + this.bearingBefore + ", bearingAfter=" + this.bearingAfter + ", instruction=" + this.instruction + ", shortInstruction=" + this.shortInstruction + ", maneuverId=" + this.maneuverId + ", type=" + this.type + ", modifier=" + this.modifier + ", exit=" + this.exit + "}";
            }

            public boolean equals(Object obj) {
                Double d4;
                Double d5;
                String str5;
                String str6;
                Integer num3;
                String str7;
                String str8;
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof StepManeuver)) {
                    return false;
                }
                StepManeuver stepManeuver = (StepManeuver) obj;
                Double d6 = this.degree;
                if (d6 != null ? d6.equals(stepManeuver.degree()) : stepManeuver.degree() == null) {
                    if (Arrays.equals(this.rawLocation, stepManeuver instanceof C$AutoValue_StepManeuver ? ((C$AutoValue_StepManeuver) stepManeuver).rawLocation : stepManeuver.rawLocation()) && ((d4 = this.bearingBefore) != null ? d4.equals(stepManeuver.bearingBefore()) : stepManeuver.bearingBefore() == null) && ((d5 = this.bearingAfter) != null ? d5.equals(stepManeuver.bearingAfter()) : stepManeuver.bearingAfter() == null) && ((str5 = this.instruction) != null ? str5.equals(stepManeuver.instruction()) : stepManeuver.instruction() == null) && ((str6 = this.shortInstruction) != null ? str6.equals(stepManeuver.shortInstruction()) : stepManeuver.shortInstruction() == null) && ((num3 = this.maneuverId) != null ? num3.equals(stepManeuver.maneuverId()) : stepManeuver.maneuverId() == null) && ((str7 = this.type) != null ? str7.equals(stepManeuver.type()) : stepManeuver.type() == null) && ((str8 = this.modifier) != null ? str8.equals(stepManeuver.modifier()) : stepManeuver.modifier() == null)) {
                        Integer num4 = this.exit;
                        if (num4 == null) {
                            if (stepManeuver.exit() == null) {
                                return true;
                            }
                        } else if (num4.equals(stepManeuver.exit())) {
                            return true;
                        }
                    }
                }
                return false;
            }

            public int hashCode() {
                Double d4 = this.degree;
                int iHashCode = ((((d4 == null ? 0 : d4.hashCode()) ^ 1000003) * 1000003) ^ Arrays.hashCode(this.rawLocation)) * 1000003;
                Double d5 = this.bearingBefore;
                int iHashCode2 = (iHashCode ^ (d5 == null ? 0 : d5.hashCode())) * 1000003;
                Double d6 = this.bearingAfter;
                int iHashCode3 = (iHashCode2 ^ (d6 == null ? 0 : d6.hashCode())) * 1000003;
                String str5 = this.instruction;
                int iHashCode4 = (iHashCode3 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
                String str6 = this.shortInstruction;
                int iHashCode5 = (iHashCode4 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
                Integer num3 = this.maneuverId;
                int iHashCode6 = (iHashCode5 ^ (num3 == null ? 0 : num3.hashCode())) * 1000003;
                String str7 = this.type;
                int iHashCode7 = (iHashCode6 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
                String str8 = this.modifier;
                int iHashCode8 = (iHashCode7 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
                Integer num4 = this.exit;
                return iHashCode8 ^ (num4 != null ? num4.hashCode() : 0);
            }

            @Override // com.mappls.sdk.services.api.directions.models.StepManeuver
            public StepManeuver.Builder toBuilder() {
                return new Builder(this);
            }

            /* JADX INFO: renamed from: com.mappls.sdk.services.api.directions.models.$AutoValue_StepManeuver$Builder */
            static class Builder extends StepManeuver.Builder {
                private Double bearingAfter;
                private Double bearingBefore;
                private Double degree;
                private Integer exit;
                private String instruction;
                private Integer maneuverId;
                private String modifier;
                private double[] rawLocation;
                private String shortInstruction;
                private String type;

                Builder() {
                }

                private Builder(StepManeuver stepManeuver) {
                    this.degree = stepManeuver.degree();
                    this.rawLocation = stepManeuver.rawLocation();
                    this.bearingBefore = stepManeuver.bearingBefore();
                    this.bearingAfter = stepManeuver.bearingAfter();
                    this.instruction = stepManeuver.instruction();
                    this.shortInstruction = stepManeuver.shortInstruction();
                    this.maneuverId = stepManeuver.maneuverId();
                    this.type = stepManeuver.type();
                    this.modifier = stepManeuver.modifier();
                    this.exit = stepManeuver.exit();
                }

                @Override // com.mappls.sdk.services.api.directions.models.StepManeuver.Builder
                public StepManeuver.Builder degree(Double d) {
                    this.degree = d;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.StepManeuver.Builder
                public StepManeuver.Builder rawLocation(double[] dArr) {
                    if (dArr == null) {
                        throw new NullPointerException("Null rawLocation");
                    }
                    this.rawLocation = dArr;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.StepManeuver.Builder
                public StepManeuver.Builder bearingBefore(Double d) {
                    this.bearingBefore = d;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.StepManeuver.Builder
                public StepManeuver.Builder bearingAfter(Double d) {
                    this.bearingAfter = d;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.StepManeuver.Builder
                public StepManeuver.Builder instruction(String str) {
                    this.instruction = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.StepManeuver.Builder
                public StepManeuver.Builder shortInstruction(String str) {
                    this.shortInstruction = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.StepManeuver.Builder
                public StepManeuver.Builder maneuverId(Integer num) {
                    this.maneuverId = num;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.StepManeuver.Builder
                public StepManeuver.Builder type(String str) {
                    this.type = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.StepManeuver.Builder
                public StepManeuver.Builder modifier(String str) {
                    this.modifier = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.StepManeuver.Builder
                public StepManeuver.Builder exit(Integer num) {
                    this.exit = num;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.StepManeuver.Builder
                public StepManeuver build() {
                    double[] dArr = this.rawLocation;
                    if (dArr == null) {
                        throw new IllegalStateException("Missing required properties: rawLocation");
                    }
                    return new AutoValue_StepManeuver(this.degree, dArr, this.bearingBefore, this.bearingAfter, this.instruction, this.shortInstruction, this.maneuverId, this.type, this.modifier, this.exit);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<StepManeuver> {
        private volatile TypeAdapter<double[]> array__double_adapter;
        private volatile TypeAdapter<Double> double__adapter;
        private final Gson gson;
        private volatile TypeAdapter<Integer> integer_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, StepManeuver stepManeuver) throws IOException {
            if (stepManeuver == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("degree");
            if (stepManeuver.degree() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> adapter = this.double__adapter;
                if (adapter == null) {
                    adapter = this.gson.getAdapter(Double.class);
                    this.double__adapter = adapter;
                }
                adapter.write(jsonWriter, stepManeuver.degree());
            }
            jsonWriter.name(FirebaseAnalytics.Param.LOCATION);
            if (stepManeuver.rawLocation() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<double[]> adapter2 = this.array__double_adapter;
                if (adapter2 == null) {
                    adapter2 = this.gson.getAdapter(double[].class);
                    this.array__double_adapter = adapter2;
                }
                adapter2.write(jsonWriter, stepManeuver.rawLocation());
            }
            jsonWriter.name("bearing_before");
            if (stepManeuver.bearingBefore() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> adapter3 = this.double__adapter;
                if (adapter3 == null) {
                    adapter3 = this.gson.getAdapter(Double.class);
                    this.double__adapter = adapter3;
                }
                adapter3.write(jsonWriter, stepManeuver.bearingBefore());
            }
            jsonWriter.name("bearing_after");
            if (stepManeuver.bearingAfter() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> adapter4 = this.double__adapter;
                if (adapter4 == null) {
                    adapter4 = this.gson.getAdapter(Double.class);
                    this.double__adapter = adapter4;
                }
                adapter4.write(jsonWriter, stepManeuver.bearingAfter());
            }
            jsonWriter.name("instruction");
            if (stepManeuver.instruction() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter5 = this.string_adapter;
                if (adapter5 == null) {
                    adapter5 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter5;
                }
                adapter5.write(jsonWriter, stepManeuver.instruction());
            }
            jsonWriter.name("short_instruction");
            if (stepManeuver.shortInstruction() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter6 = this.string_adapter;
                if (adapter6 == null) {
                    adapter6 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter6;
                }
                adapter6.write(jsonWriter, stepManeuver.shortInstruction());
            }
            jsonWriter.name("maneuver_id");
            if (stepManeuver.maneuverId() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> adapter7 = this.integer_adapter;
                if (adapter7 == null) {
                    adapter7 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = adapter7;
                }
                adapter7.write(jsonWriter, stepManeuver.maneuverId());
            }
            jsonWriter.name("type");
            if (stepManeuver.type() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter8 = this.string_adapter;
                if (adapter8 == null) {
                    adapter8 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter8;
                }
                adapter8.write(jsonWriter, stepManeuver.type());
            }
            jsonWriter.name("modifier");
            if (stepManeuver.modifier() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter9 = this.string_adapter;
                if (adapter9 == null) {
                    adapter9 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter9;
                }
                adapter9.write(jsonWriter, stepManeuver.modifier());
            }
            jsonWriter.name("exit");
            if (stepManeuver.exit() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> adapter10 = this.integer_adapter;
                if (adapter10 == null) {
                    adapter10 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = adapter10;
                }
                adapter10.write(jsonWriter, stepManeuver.exit());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: read */
        public StepManeuver read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            StepManeuver.Builder builder = StepManeuver.builder();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    strNextName.hashCode();
                    switch (strNextName) {
                        case "maneuver_id":
                            TypeAdapter<Integer> adapter = this.integer_adapter;
                            if (adapter == null) {
                                adapter = this.gson.getAdapter(Integer.class);
                                this.integer_adapter = adapter;
                            }
                            builder.maneuverId(adapter.read2(jsonReader));
                            break;
                        case "degree":
                            TypeAdapter<Double> adapter2 = this.double__adapter;
                            if (adapter2 == null) {
                                adapter2 = this.gson.getAdapter(Double.class);
                                this.double__adapter = adapter2;
                            }
                            builder.degree(adapter2.read2(jsonReader));
                            break;
                        case "bearing_before":
                            TypeAdapter<Double> adapter3 = this.double__adapter;
                            if (adapter3 == null) {
                                adapter3 = this.gson.getAdapter(Double.class);
                                this.double__adapter = adapter3;
                            }
                            builder.bearingBefore(adapter3.read2(jsonReader));
                            break;
                        case "bearing_after":
                            TypeAdapter<Double> adapter4 = this.double__adapter;
                            if (adapter4 == null) {
                                adapter4 = this.gson.getAdapter(Double.class);
                                this.double__adapter = adapter4;
                            }
                            builder.bearingAfter(adapter4.read2(jsonReader));
                            break;
                        case "short_instruction":
                            TypeAdapter<String> adapter5 = this.string_adapter;
                            if (adapter5 == null) {
                                adapter5 = this.gson.getAdapter(String.class);
                                this.string_adapter = adapter5;
                            }
                            builder.shortInstruction(adapter5.read2(jsonReader));
                            break;
                        case "location":
                            TypeAdapter<double[]> adapter6 = this.array__double_adapter;
                            if (adapter6 == null) {
                                adapter6 = this.gson.getAdapter(double[].class);
                                this.array__double_adapter = adapter6;
                            }
                            builder.rawLocation(adapter6.read2(jsonReader));
                            break;
                        default:
                            if ("instruction".equals(strNextName)) {
                                TypeAdapter<String> adapter7 = this.string_adapter;
                                if (adapter7 == null) {
                                    adapter7 = this.gson.getAdapter(String.class);
                                    this.string_adapter = adapter7;
                                }
                                builder.instruction(adapter7.read2(jsonReader));
                                break;
                            } else {
                                if ("type".equals(strNextName)) {
                                    TypeAdapter<String> adapter8 = this.string_adapter;
                                    if (adapter8 == null) {
                                        adapter8 = this.gson.getAdapter(String.class);
                                        this.string_adapter = adapter8;
                                    }
                                    builder.type(adapter8.read2(jsonReader));
                                } else if ("modifier".equals(strNextName)) {
                                    TypeAdapter<String> adapter9 = this.string_adapter;
                                    if (adapter9 == null) {
                                        adapter9 = this.gson.getAdapter(String.class);
                                        this.string_adapter = adapter9;
                                    }
                                    builder.modifier(adapter9.read2(jsonReader));
                                } else if ("exit".equals(strNextName)) {
                                    TypeAdapter<Integer> adapter10 = this.integer_adapter;
                                    if (adapter10 == null) {
                                        adapter10 = this.gson.getAdapter(Integer.class);
                                        this.integer_adapter = adapter10;
                                    }
                                    builder.exit(adapter10.read2(jsonReader));
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
            return "TypeAdapter(StepManeuver)";
        }
    }
}

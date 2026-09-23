package com.mappls.sdk.services.api.directions;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_WalkingOptions extends C$AutoValue_WalkingOptions {
    AutoValue_WalkingOptions(Double d, Double d2, Double d3) {
        new WalkingOptions(d, d2, d3) { // from class: com.mappls.sdk.services.api.directions.$AutoValue_WalkingOptions
            private final Double alleyBias;
            private final Double walkingSpeed;
            private final Double walkwayBias;

            {
                this.walkingSpeed = d;
                this.walkwayBias = d2;
                this.alleyBias = d3;
            }

            @Override // com.mappls.sdk.services.api.directions.WalkingOptions
            @SerializedName("walking_speed")
            public Double walkingSpeed() {
                return this.walkingSpeed;
            }

            @Override // com.mappls.sdk.services.api.directions.WalkingOptions
            @SerializedName("walkway_bias")
            public Double walkwayBias() {
                return this.walkwayBias;
            }

            @Override // com.mappls.sdk.services.api.directions.WalkingOptions
            @SerializedName("alley_bias")
            public Double alleyBias() {
                return this.alleyBias;
            }

            public String toString() {
                return "WalkingOptions{walkingSpeed=" + this.walkingSpeed + ", walkwayBias=" + this.walkwayBias + ", alleyBias=" + this.alleyBias + "}";
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof WalkingOptions)) {
                    return false;
                }
                WalkingOptions walkingOptions = (WalkingOptions) obj;
                Double d4 = this.walkingSpeed;
                if (d4 != null ? d4.equals(walkingOptions.walkingSpeed()) : walkingOptions.walkingSpeed() == null) {
                    Double d5 = this.walkwayBias;
                    if (d5 != null ? d5.equals(walkingOptions.walkwayBias()) : walkingOptions.walkwayBias() == null) {
                        Double d6 = this.alleyBias;
                        if (d6 == null) {
                            if (walkingOptions.alleyBias() == null) {
                                return true;
                            }
                        } else if (d6.equals(walkingOptions.alleyBias())) {
                            return true;
                        }
                    }
                }
                return false;
            }

            public int hashCode() {
                Double d4 = this.walkingSpeed;
                int iHashCode = ((d4 == null ? 0 : d4.hashCode()) ^ 1000003) * 1000003;
                Double d5 = this.walkwayBias;
                int iHashCode2 = (iHashCode ^ (d5 == null ? 0 : d5.hashCode())) * 1000003;
                Double d6 = this.alleyBias;
                return iHashCode2 ^ (d6 != null ? d6.hashCode() : 0);
            }

            /* JADX INFO: renamed from: com.mappls.sdk.services.api.directions.$AutoValue_WalkingOptions$Builder */
            static class Builder extends WalkingOptions.Builder {
                private Double alleyBias;
                private Double walkingSpeed;
                private Double walkwayBias;

                Builder() {
                }

                @Override // com.mappls.sdk.services.api.directions.WalkingOptions.Builder
                public WalkingOptions.Builder walkingSpeed(Double d) {
                    this.walkingSpeed = d;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.WalkingOptions.Builder
                public WalkingOptions.Builder walkwayBias(Double d) {
                    this.walkwayBias = d;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.WalkingOptions.Builder
                public WalkingOptions.Builder alleyBias(Double d) {
                    this.alleyBias = d;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.WalkingOptions.Builder
                public WalkingOptions build() {
                    return new AutoValue_WalkingOptions(this.walkingSpeed, this.walkwayBias, this.alleyBias);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<WalkingOptions> {
        private volatile TypeAdapter<Double> double__adapter;
        private final Gson gson;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, WalkingOptions walkingOptions) throws IOException {
            if (walkingOptions == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("walking_speed");
            if (walkingOptions.walkingSpeed() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> adapter = this.double__adapter;
                if (adapter == null) {
                    adapter = this.gson.getAdapter(Double.class);
                    this.double__adapter = adapter;
                }
                adapter.write(jsonWriter, walkingOptions.walkingSpeed());
            }
            jsonWriter.name("walkway_bias");
            if (walkingOptions.walkwayBias() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> adapter2 = this.double__adapter;
                if (adapter2 == null) {
                    adapter2 = this.gson.getAdapter(Double.class);
                    this.double__adapter = adapter2;
                }
                adapter2.write(jsonWriter, walkingOptions.walkwayBias());
            }
            jsonWriter.name("alley_bias");
            if (walkingOptions.alleyBias() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> adapter3 = this.double__adapter;
                if (adapter3 == null) {
                    adapter3 = this.gson.getAdapter(Double.class);
                    this.double__adapter = adapter3;
                }
                adapter3.write(jsonWriter, walkingOptions.alleyBias());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: read */
        public WalkingOptions read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            WalkingOptions.Builder builder = WalkingOptions.builder();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    strNextName.hashCode();
                    switch (strNextName) {
                        case "alley_bias":
                            TypeAdapter<Double> adapter = this.double__adapter;
                            if (adapter == null) {
                                adapter = this.gson.getAdapter(Double.class);
                                this.double__adapter = adapter;
                            }
                            builder.alleyBias(adapter.read2(jsonReader));
                            break;
                        case "walking_speed":
                            TypeAdapter<Double> adapter2 = this.double__adapter;
                            if (adapter2 == null) {
                                adapter2 = this.gson.getAdapter(Double.class);
                                this.double__adapter = adapter2;
                            }
                            builder.walkingSpeed(adapter2.read2(jsonReader));
                            break;
                        case "walkway_bias":
                            TypeAdapter<Double> adapter3 = this.double__adapter;
                            if (adapter3 == null) {
                                adapter3 = this.gson.getAdapter(Double.class);
                                this.double__adapter = adapter3;
                            }
                            builder.walkwayBias(adapter3.read2(jsonReader));
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
            }
            jsonReader.endObject();
            return builder.build();
        }

        public String toString() {
            return "TypeAdapter(WalkingOptions)";
        }
    }
}

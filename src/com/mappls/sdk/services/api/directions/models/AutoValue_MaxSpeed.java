package com.mappls.sdk.services.api.directions.models;

import androidx.core.os.EnvironmentCompat;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MaxSpeed extends C$AutoValue_MaxSpeed {
    AutoValue_MaxSpeed(Integer num, String str, Boolean bool, Boolean bool2) {
        new MaxSpeed(num, str, bool, bool2) { // from class: com.mappls.sdk.services.api.directions.models.$AutoValue_MaxSpeed
            private final Boolean none;
            private final Integer speed;
            private final String unit;
            private final Boolean unknown;

            {
                this.speed = num;
                this.unit = str;
                this.unknown = bool;
                this.none = bool2;
            }

            @Override // com.mappls.sdk.services.api.directions.models.MaxSpeed
            public Integer speed() {
                return this.speed;
            }

            @Override // com.mappls.sdk.services.api.directions.models.MaxSpeed
            public String unit() {
                return this.unit;
            }

            @Override // com.mappls.sdk.services.api.directions.models.MaxSpeed
            public Boolean unknown() {
                return this.unknown;
            }

            @Override // com.mappls.sdk.services.api.directions.models.MaxSpeed
            public Boolean none() {
                return this.none;
            }

            public String toString() {
                return "MaxSpeed{speed=" + this.speed + ", unit=" + this.unit + ", unknown=" + this.unknown + ", none=" + this.none + "}";
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof MaxSpeed)) {
                    return false;
                }
                MaxSpeed maxSpeed = (MaxSpeed) obj;
                Integer num2 = this.speed;
                if (num2 != null ? num2.equals(maxSpeed.speed()) : maxSpeed.speed() == null) {
                    String str2 = this.unit;
                    if (str2 != null ? str2.equals(maxSpeed.unit()) : maxSpeed.unit() == null) {
                        Boolean bool3 = this.unknown;
                        if (bool3 != null ? bool3.equals(maxSpeed.unknown()) : maxSpeed.unknown() == null) {
                            Boolean bool4 = this.none;
                            if (bool4 == null) {
                                if (maxSpeed.none() == null) {
                                    return true;
                                }
                            } else if (bool4.equals(maxSpeed.none())) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }

            public int hashCode() {
                Integer num2 = this.speed;
                int iHashCode = ((num2 == null ? 0 : num2.hashCode()) ^ 1000003) * 1000003;
                String str2 = this.unit;
                int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
                Boolean bool3 = this.unknown;
                int iHashCode3 = (iHashCode2 ^ (bool3 == null ? 0 : bool3.hashCode())) * 1000003;
                Boolean bool4 = this.none;
                return iHashCode3 ^ (bool4 != null ? bool4.hashCode() : 0);
            }

            @Override // com.mappls.sdk.services.api.directions.models.MaxSpeed
            public MaxSpeed.Builder toBuilder() {
                return new Builder(this);
            }

            /* JADX INFO: renamed from: com.mappls.sdk.services.api.directions.models.$AutoValue_MaxSpeed$Builder */
            static class Builder extends MaxSpeed.Builder {
                private Boolean none;
                private Integer speed;
                private String unit;
                private Boolean unknown;

                Builder() {
                }

                private Builder(MaxSpeed maxSpeed) {
                    this.speed = maxSpeed.speed();
                    this.unit = maxSpeed.unit();
                    this.unknown = maxSpeed.unknown();
                    this.none = maxSpeed.none();
                }

                @Override // com.mappls.sdk.services.api.directions.models.MaxSpeed.Builder
                public MaxSpeed.Builder speed(Integer num) {
                    this.speed = num;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.MaxSpeed.Builder
                public MaxSpeed.Builder unit(String str) {
                    this.unit = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.MaxSpeed.Builder
                public MaxSpeed.Builder unknown(Boolean bool) {
                    this.unknown = bool;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.MaxSpeed.Builder
                public MaxSpeed.Builder none(Boolean bool) {
                    this.none = bool;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.MaxSpeed.Builder
                public MaxSpeed build() {
                    return new AutoValue_MaxSpeed(this.speed, this.unit, this.unknown, this.none);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<MaxSpeed> {
        private volatile TypeAdapter<Boolean> boolean__adapter;
        private final Gson gson;
        private volatile TypeAdapter<Integer> integer_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, MaxSpeed maxSpeed) throws IOException {
            if (maxSpeed == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("speed");
            if (maxSpeed.speed() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> adapter = this.integer_adapter;
                if (adapter == null) {
                    adapter = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = adapter;
                }
                adapter.write(jsonWriter, maxSpeed.speed());
            }
            jsonWriter.name("unit");
            if (maxSpeed.unit() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter2 = this.string_adapter;
                if (adapter2 == null) {
                    adapter2 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter2;
                }
                adapter2.write(jsonWriter, maxSpeed.unit());
            }
            jsonWriter.name(EnvironmentCompat.MEDIA_UNKNOWN);
            if (maxSpeed.unknown() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> adapter3 = this.boolean__adapter;
                if (adapter3 == null) {
                    adapter3 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = adapter3;
                }
                adapter3.write(jsonWriter, maxSpeed.unknown());
            }
            jsonWriter.name("none");
            if (maxSpeed.none() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> adapter4 = this.boolean__adapter;
                if (adapter4 == null) {
                    adapter4 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = adapter4;
                }
                adapter4.write(jsonWriter, maxSpeed.none());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: read */
        public MaxSpeed read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            MaxSpeed.Builder builder = MaxSpeed.builder();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    strNextName.hashCode();
                    if ("speed".equals(strNextName)) {
                        TypeAdapter<Integer> adapter = this.integer_adapter;
                        if (adapter == null) {
                            adapter = this.gson.getAdapter(Integer.class);
                            this.integer_adapter = adapter;
                        }
                        builder.speed(adapter.read2(jsonReader));
                    } else if ("unit".equals(strNextName)) {
                        TypeAdapter<String> adapter2 = this.string_adapter;
                        if (adapter2 == null) {
                            adapter2 = this.gson.getAdapter(String.class);
                            this.string_adapter = adapter2;
                        }
                        builder.unit(adapter2.read2(jsonReader));
                    } else if (EnvironmentCompat.MEDIA_UNKNOWN.equals(strNextName)) {
                        TypeAdapter<Boolean> adapter3 = this.boolean__adapter;
                        if (adapter3 == null) {
                            adapter3 = this.gson.getAdapter(Boolean.class);
                            this.boolean__adapter = adapter3;
                        }
                        builder.unknown(adapter3.read2(jsonReader));
                    } else if ("none".equals(strNextName)) {
                        TypeAdapter<Boolean> adapter4 = this.boolean__adapter;
                        if (adapter4 == null) {
                            adapter4 = this.gson.getAdapter(Boolean.class);
                            this.boolean__adapter = adapter4;
                        }
                        builder.none(adapter4.read2(jsonReader));
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return builder.build();
        }

        public String toString() {
            return "TypeAdapter(MaxSpeed)";
        }
    }
}

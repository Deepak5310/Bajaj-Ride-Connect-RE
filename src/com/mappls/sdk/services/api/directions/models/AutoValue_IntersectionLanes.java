package com.mappls.sdk.services.api.directions.models;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_IntersectionLanes extends C$AutoValue_IntersectionLanes {
    AutoValue_IntersectionLanes(Boolean bool, List<String> list) {
        new IntersectionLanes(bool, list) { // from class: com.mappls.sdk.services.api.directions.models.$AutoValue_IntersectionLanes
            private final List<String> indications;
            private final Boolean valid;

            {
                this.valid = bool;
                this.indications = list;
            }

            @Override // com.mappls.sdk.services.api.directions.models.IntersectionLanes
            public Boolean valid() {
                return this.valid;
            }

            @Override // com.mappls.sdk.services.api.directions.models.IntersectionLanes
            public List<String> indications() {
                return this.indications;
            }

            public String toString() {
                return "IntersectionLanes{valid=" + this.valid + ", indications=" + this.indications + "}";
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof IntersectionLanes)) {
                    return false;
                }
                IntersectionLanes intersectionLanes = (IntersectionLanes) obj;
                Boolean bool2 = this.valid;
                if (bool2 != null ? bool2.equals(intersectionLanes.valid()) : intersectionLanes.valid() == null) {
                    List<String> list2 = this.indications;
                    if (list2 == null) {
                        if (intersectionLanes.indications() == null) {
                            return true;
                        }
                    } else if (list2.equals(intersectionLanes.indications())) {
                        return true;
                    }
                }
                return false;
            }

            public int hashCode() {
                Boolean bool2 = this.valid;
                int iHashCode = ((bool2 == null ? 0 : bool2.hashCode()) ^ 1000003) * 1000003;
                List<String> list2 = this.indications;
                return iHashCode ^ (list2 != null ? list2.hashCode() : 0);
            }

            @Override // com.mappls.sdk.services.api.directions.models.IntersectionLanes
            public IntersectionLanes.Builder toBuilder() {
                return new Builder(this);
            }

            /* JADX INFO: renamed from: com.mappls.sdk.services.api.directions.models.$AutoValue_IntersectionLanes$Builder */
            static class Builder extends IntersectionLanes.Builder {
                private List<String> indications;
                private Boolean valid;

                Builder() {
                }

                private Builder(IntersectionLanes intersectionLanes) {
                    this.valid = intersectionLanes.valid();
                    this.indications = intersectionLanes.indications();
                }

                @Override // com.mappls.sdk.services.api.directions.models.IntersectionLanes.Builder
                public IntersectionLanes.Builder valid(Boolean bool) {
                    this.valid = bool;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.IntersectionLanes.Builder
                public IntersectionLanes.Builder indications(List<String> list) {
                    this.indications = list;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.IntersectionLanes.Builder
                public IntersectionLanes build() {
                    return new AutoValue_IntersectionLanes(this.valid, this.indications);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<IntersectionLanes> {
        private volatile TypeAdapter<Boolean> boolean__adapter;
        private final Gson gson;
        private volatile TypeAdapter<List<String>> list__string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, IntersectionLanes intersectionLanes) throws IOException {
            if (intersectionLanes == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("valid");
            if (intersectionLanes.valid() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> adapter = this.boolean__adapter;
                if (adapter == null) {
                    adapter = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = adapter;
                }
                adapter.write(jsonWriter, intersectionLanes.valid());
            }
            jsonWriter.name("indications");
            if (intersectionLanes.indications() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<String>> adapter2 = this.list__string_adapter;
                if (adapter2 == null) {
                    adapter2 = this.gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
                    this.list__string_adapter = adapter2;
                }
                adapter2.write(jsonWriter, intersectionLanes.indications());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: read */
        public IntersectionLanes read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            IntersectionLanes.Builder builder = IntersectionLanes.builder();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    strNextName.hashCode();
                    if ("valid".equals(strNextName)) {
                        TypeAdapter<Boolean> adapter = this.boolean__adapter;
                        if (adapter == null) {
                            adapter = this.gson.getAdapter(Boolean.class);
                            this.boolean__adapter = adapter;
                        }
                        builder.valid(adapter.read2(jsonReader));
                    } else if ("indications".equals(strNextName)) {
                        TypeAdapter<List<String>> adapter2 = this.list__string_adapter;
                        if (adapter2 == null) {
                            adapter2 = this.gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
                            this.list__string_adapter = adapter2;
                        }
                        builder.indications(adapter2.read2(jsonReader));
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return builder.build();
        }

        public String toString() {
            return "TypeAdapter(IntersectionLanes)";
        }
    }
}

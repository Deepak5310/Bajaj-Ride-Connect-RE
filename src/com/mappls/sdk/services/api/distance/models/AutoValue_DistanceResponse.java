package com.mappls.sdk.services.api.distance.models;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_DistanceResponse extends C$AutoValue_DistanceResponse {
    AutoValue_DistanceResponse(String str, DistanceResults distanceResults, long j) {
        new DistanceResponse(str, distanceResults, j) { // from class: com.mappls.sdk.services.api.distance.models.$AutoValue_DistanceResponse
            private final long responseCode;
            private final DistanceResults results;
            private final String version;

            {
                this.version = str;
                this.results = distanceResults;
                this.responseCode = j;
            }

            @Override // com.mappls.sdk.services.api.distance.models.DistanceResponse
            public String version() {
                return this.version;
            }

            @Override // com.mappls.sdk.services.api.distance.models.DistanceResponse
            @SerializedName("results")
            public DistanceResults results() {
                return this.results;
            }

            @Override // com.mappls.sdk.services.api.distance.models.DistanceResponse
            public long responseCode() {
                return this.responseCode;
            }

            public String toString() {
                return "DistanceResponse{version=" + this.version + ", results=" + this.results + ", responseCode=" + this.responseCode + "}";
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof DistanceResponse)) {
                    return false;
                }
                DistanceResponse distanceResponse = (DistanceResponse) obj;
                String str2 = this.version;
                if (str2 != null ? str2.equals(distanceResponse.version()) : distanceResponse.version() == null) {
                    DistanceResults distanceResults2 = this.results;
                    if (distanceResults2 != null ? distanceResults2.equals(distanceResponse.results()) : distanceResponse.results() == null) {
                        if (this.responseCode == distanceResponse.responseCode()) {
                            return true;
                        }
                    }
                }
                return false;
            }

            public int hashCode() {
                String str2 = this.version;
                int iHashCode = ((str2 == null ? 0 : str2.hashCode()) ^ 1000003) * 1000003;
                DistanceResults distanceResults2 = this.results;
                int iHashCode2 = (iHashCode ^ (distanceResults2 != null ? distanceResults2.hashCode() : 0)) * 1000003;
                long j2 = this.responseCode;
                return iHashCode2 ^ ((int) (j2 ^ (j2 >>> 32)));
            }

            @Override // com.mappls.sdk.services.api.distance.models.DistanceResponse
            public DistanceResponse.Builder toBuilder() {
                return new Builder(this);
            }

            /* JADX INFO: renamed from: com.mappls.sdk.services.api.distance.models.$AutoValue_DistanceResponse$Builder */
            static class Builder extends DistanceResponse.Builder {
                private long responseCode;
                private DistanceResults results;
                private byte set$0;
                private String version;

                Builder() {
                }

                private Builder(DistanceResponse distanceResponse) {
                    this.version = distanceResponse.version();
                    this.results = distanceResponse.results();
                    this.responseCode = distanceResponse.responseCode();
                    this.set$0 = (byte) 1;
                }

                @Override // com.mappls.sdk.services.api.distance.models.DistanceResponse.Builder
                public DistanceResponse.Builder version(String str) {
                    this.version = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.distance.models.DistanceResponse.Builder
                public DistanceResponse.Builder results(DistanceResults distanceResults) {
                    this.results = distanceResults;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.distance.models.DistanceResponse.Builder
                public DistanceResponse.Builder responseCode(long j) {
                    this.responseCode = j;
                    this.set$0 = (byte) (this.set$0 | 1);
                    return this;
                }

                @Override // com.mappls.sdk.services.api.distance.models.DistanceResponse.Builder
                public DistanceResponse build() {
                    if (this.set$0 != 1) {
                        throw new IllegalStateException("Missing required properties: responseCode");
                    }
                    return new AutoValue_DistanceResponse(this.version, this.results, this.responseCode);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<DistanceResponse> {
        private volatile TypeAdapter<DistanceResults> distanceResults_adapter;
        private final Gson gson;
        private volatile TypeAdapter<Long> long__adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, DistanceResponse distanceResponse) throws IOException {
            if (distanceResponse == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("version");
            if (distanceResponse.version() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter = this.string_adapter;
                if (adapter == null) {
                    adapter = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter;
                }
                adapter.write(jsonWriter, distanceResponse.version());
            }
            jsonWriter.name("results");
            if (distanceResponse.results() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<DistanceResults> adapter2 = this.distanceResults_adapter;
                if (adapter2 == null) {
                    adapter2 = this.gson.getAdapter(DistanceResults.class);
                    this.distanceResults_adapter = adapter2;
                }
                adapter2.write(jsonWriter, distanceResponse.results());
            }
            jsonWriter.name("responseCode");
            TypeAdapter<Long> adapter3 = this.long__adapter;
            if (adapter3 == null) {
                adapter3 = this.gson.getAdapter(Long.class);
                this.long__adapter = adapter3;
            }
            adapter3.write(jsonWriter, Long.valueOf(distanceResponse.responseCode()));
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: read */
        public DistanceResponse read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            DistanceResponse.Builder builder = DistanceResponse.builder();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    strNextName.hashCode();
                    if (strNextName.equals("results")) {
                        TypeAdapter<DistanceResults> adapter = this.distanceResults_adapter;
                        if (adapter == null) {
                            adapter = this.gson.getAdapter(DistanceResults.class);
                            this.distanceResults_adapter = adapter;
                        }
                        builder.results(adapter.read2(jsonReader));
                    } else if ("version".equals(strNextName)) {
                        TypeAdapter<String> adapter2 = this.string_adapter;
                        if (adapter2 == null) {
                            adapter2 = this.gson.getAdapter(String.class);
                            this.string_adapter = adapter2;
                        }
                        builder.version(adapter2.read2(jsonReader));
                    } else if ("responseCode".equals(strNextName)) {
                        TypeAdapter<Long> adapter3 = this.long__adapter;
                        if (adapter3 == null) {
                            adapter3 = this.gson.getAdapter(Long.class);
                            this.long__adapter = adapter3;
                        }
                        builder.responseCode(adapter3.read2(jsonReader).longValue());
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return builder.build();
        }

        public String toString() {
            return "TypeAdapter(DistanceResponse)";
        }
    }
}

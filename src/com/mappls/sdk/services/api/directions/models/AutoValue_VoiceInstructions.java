package com.mappls.sdk.services.api.directions.models;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_VoiceInstructions extends C$AutoValue_VoiceInstructions {
    AutoValue_VoiceInstructions(Double d, String str, String str2) {
        new VoiceInstructions(d, str, str2) { // from class: com.mappls.sdk.services.api.directions.models.$AutoValue_VoiceInstructions
            private final String announcement;
            private final Double distanceAlongGeometry;
            private final String ssmlAnnouncement;

            {
                this.distanceAlongGeometry = d;
                this.announcement = str;
                this.ssmlAnnouncement = str2;
            }

            @Override // com.mappls.sdk.services.api.directions.models.VoiceInstructions
            public Double distanceAlongGeometry() {
                return this.distanceAlongGeometry;
            }

            @Override // com.mappls.sdk.services.api.directions.models.VoiceInstructions
            public String announcement() {
                return this.announcement;
            }

            @Override // com.mappls.sdk.services.api.directions.models.VoiceInstructions
            public String ssmlAnnouncement() {
                return this.ssmlAnnouncement;
            }

            public String toString() {
                return "VoiceInstructions{distanceAlongGeometry=" + this.distanceAlongGeometry + ", announcement=" + this.announcement + ", ssmlAnnouncement=" + this.ssmlAnnouncement + "}";
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof VoiceInstructions)) {
                    return false;
                }
                VoiceInstructions voiceInstructions = (VoiceInstructions) obj;
                Double d2 = this.distanceAlongGeometry;
                if (d2 != null ? d2.equals(voiceInstructions.distanceAlongGeometry()) : voiceInstructions.distanceAlongGeometry() == null) {
                    String str3 = this.announcement;
                    if (str3 != null ? str3.equals(voiceInstructions.announcement()) : voiceInstructions.announcement() == null) {
                        String str4 = this.ssmlAnnouncement;
                        if (str4 == null) {
                            if (voiceInstructions.ssmlAnnouncement() == null) {
                                return true;
                            }
                        } else if (str4.equals(voiceInstructions.ssmlAnnouncement())) {
                            return true;
                        }
                    }
                }
                return false;
            }

            public int hashCode() {
                Double d2 = this.distanceAlongGeometry;
                int iHashCode = ((d2 == null ? 0 : d2.hashCode()) ^ 1000003) * 1000003;
                String str3 = this.announcement;
                int iHashCode2 = (iHashCode ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
                String str4 = this.ssmlAnnouncement;
                return iHashCode2 ^ (str4 != null ? str4.hashCode() : 0);
            }

            @Override // com.mappls.sdk.services.api.directions.models.VoiceInstructions
            public VoiceInstructions.Builder toBuilder() {
                return new Builder(this);
            }

            /* JADX INFO: renamed from: com.mappls.sdk.services.api.directions.models.$AutoValue_VoiceInstructions$Builder */
            static class Builder extends VoiceInstructions.Builder {
                private String announcement;
                private Double distanceAlongGeometry;
                private String ssmlAnnouncement;

                Builder() {
                }

                private Builder(VoiceInstructions voiceInstructions) {
                    this.distanceAlongGeometry = voiceInstructions.distanceAlongGeometry();
                    this.announcement = voiceInstructions.announcement();
                    this.ssmlAnnouncement = voiceInstructions.ssmlAnnouncement();
                }

                @Override // com.mappls.sdk.services.api.directions.models.VoiceInstructions.Builder
                public VoiceInstructions.Builder distanceAlongGeometry(Double d) {
                    this.distanceAlongGeometry = d;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.VoiceInstructions.Builder
                public VoiceInstructions.Builder announcement(String str) {
                    this.announcement = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.VoiceInstructions.Builder
                public VoiceInstructions.Builder ssmlAnnouncement(String str) {
                    this.ssmlAnnouncement = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.VoiceInstructions.Builder
                public VoiceInstructions build() {
                    return new AutoValue_VoiceInstructions(this.distanceAlongGeometry, this.announcement, this.ssmlAnnouncement);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<VoiceInstructions> {
        private volatile TypeAdapter<Double> double__adapter;
        private final Gson gson;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, VoiceInstructions voiceInstructions) throws IOException {
            if (voiceInstructions == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("distanceAlongGeometry");
            if (voiceInstructions.distanceAlongGeometry() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> adapter = this.double__adapter;
                if (adapter == null) {
                    adapter = this.gson.getAdapter(Double.class);
                    this.double__adapter = adapter;
                }
                adapter.write(jsonWriter, voiceInstructions.distanceAlongGeometry());
            }
            jsonWriter.name("announcement");
            if (voiceInstructions.announcement() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter2 = this.string_adapter;
                if (adapter2 == null) {
                    adapter2 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter2;
                }
                adapter2.write(jsonWriter, voiceInstructions.announcement());
            }
            jsonWriter.name("ssmlAnnouncement");
            if (voiceInstructions.ssmlAnnouncement() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter3 = this.string_adapter;
                if (adapter3 == null) {
                    adapter3 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter3;
                }
                adapter3.write(jsonWriter, voiceInstructions.ssmlAnnouncement());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: read */
        public VoiceInstructions read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            VoiceInstructions.Builder builder = VoiceInstructions.builder();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    strNextName.hashCode();
                    if ("distanceAlongGeometry".equals(strNextName)) {
                        TypeAdapter<Double> adapter = this.double__adapter;
                        if (adapter == null) {
                            adapter = this.gson.getAdapter(Double.class);
                            this.double__adapter = adapter;
                        }
                        builder.distanceAlongGeometry(adapter.read2(jsonReader));
                    } else if ("announcement".equals(strNextName)) {
                        TypeAdapter<String> adapter2 = this.string_adapter;
                        if (adapter2 == null) {
                            adapter2 = this.gson.getAdapter(String.class);
                            this.string_adapter = adapter2;
                        }
                        builder.announcement(adapter2.read2(jsonReader));
                    } else if ("ssmlAnnouncement".equals(strNextName)) {
                        TypeAdapter<String> adapter3 = this.string_adapter;
                        if (adapter3 == null) {
                            adapter3 = this.gson.getAdapter(String.class);
                            this.string_adapter = adapter3;
                        }
                        builder.ssmlAnnouncement(adapter3.read2(jsonReader));
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return builder.build();
        }

        public String toString() {
            return "TypeAdapter(VoiceInstructions)";
        }
    }
}

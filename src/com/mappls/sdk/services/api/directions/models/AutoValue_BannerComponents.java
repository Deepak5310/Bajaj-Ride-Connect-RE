package com.mappls.sdk.services.api.directions.models;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_BannerComponents extends C$AutoValue_BannerComponents {
    AutoValue_BannerComponents(String str, String str2) {
        new BannerComponents(str, str2) { // from class: com.mappls.sdk.services.api.directions.models.$AutoValue_BannerComponents
            private final String text;
            private final String type;

            {
                if (str == null) {
                    throw new NullPointerException("Null text");
                }
                this.text = str;
                if (str2 == null) {
                    throw new NullPointerException("Null type");
                }
                this.type = str2;
            }

            @Override // com.mappls.sdk.services.api.directions.models.BannerComponents
            public String text() {
                return this.text;
            }

            @Override // com.mappls.sdk.services.api.directions.models.BannerComponents
            public String type() {
                return this.type;
            }

            public String toString() {
                return "BannerComponents{text=" + this.text + ", type=" + this.type + "}";
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof BannerComponents)) {
                    return false;
                }
                BannerComponents bannerComponents = (BannerComponents) obj;
                return this.text.equals(bannerComponents.text()) && this.type.equals(bannerComponents.type());
            }

            public int hashCode() {
                return ((this.text.hashCode() ^ 1000003) * 1000003) ^ this.type.hashCode();
            }

            @Override // com.mappls.sdk.services.api.directions.models.BannerComponents
            public BannerComponents.Builder toBuilder() {
                return new Builder(this);
            }

            /* JADX INFO: renamed from: com.mappls.sdk.services.api.directions.models.$AutoValue_BannerComponents$Builder */
            static class Builder extends BannerComponents.Builder {
                private String text;
                private String type;

                Builder() {
                }

                private Builder(BannerComponents bannerComponents) {
                    this.text = bannerComponents.text();
                    this.type = bannerComponents.type();
                }

                @Override // com.mappls.sdk.services.api.directions.models.BannerComponents.Builder
                public BannerComponents.Builder text(String str) {
                    if (str == null) {
                        throw new NullPointerException("Null text");
                    }
                    this.text = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.BannerComponents.Builder
                public BannerComponents.Builder type(String str) {
                    if (str == null) {
                        throw new NullPointerException("Null type");
                    }
                    this.type = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.BannerComponents.Builder
                public BannerComponents build() {
                    String str;
                    String str2 = this.text;
                    if (str2 == null || (str = this.type) == null) {
                        StringBuilder sb = new StringBuilder();
                        if (this.text == null) {
                            sb.append(" text");
                        }
                        if (this.type == null) {
                            sb.append(" type");
                        }
                        throw new IllegalStateException("Missing required properties:" + ((Object) sb));
                    }
                    return new AutoValue_BannerComponents(str2, str);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<BannerComponents> {
        private final Gson gson;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, BannerComponents bannerComponents) throws IOException {
            if (bannerComponents == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("text");
            if (bannerComponents.text() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter = this.string_adapter;
                if (adapter == null) {
                    adapter = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter;
                }
                adapter.write(jsonWriter, bannerComponents.text());
            }
            jsonWriter.name("type");
            if (bannerComponents.type() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter2 = this.string_adapter;
                if (adapter2 == null) {
                    adapter2 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter2;
                }
                adapter2.write(jsonWriter, bannerComponents.type());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: read */
        public BannerComponents read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            BannerComponents.Builder builder = BannerComponents.builder();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    strNextName.hashCode();
                    if ("text".equals(strNextName)) {
                        TypeAdapter<String> adapter = this.string_adapter;
                        if (adapter == null) {
                            adapter = this.gson.getAdapter(String.class);
                            this.string_adapter = adapter;
                        }
                        builder.text(adapter.read2(jsonReader));
                    } else if ("type".equals(strNextName)) {
                        TypeAdapter<String> adapter2 = this.string_adapter;
                        if (adapter2 == null) {
                            adapter2 = this.gson.getAdapter(String.class);
                            this.string_adapter = adapter2;
                        }
                        builder.type(adapter2.read2(jsonReader));
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return builder.build();
        }

        public String toString() {
            return "TypeAdapter(BannerComponents)";
        }
    }
}

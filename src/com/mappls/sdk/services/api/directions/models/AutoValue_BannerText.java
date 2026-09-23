package com.mappls.sdk.services.api.directions.models;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mappls.sdk.turf.TurfConstants;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_BannerText extends C$AutoValue_BannerText {
    AutoValue_BannerText(List<BannerComponents> list, String str, String str2, Double d, String str3, String str4) {
        new BannerText(list, str, str2, d, str3, str4) { // from class: com.mappls.sdk.services.api.directions.models.$AutoValue_BannerText
            private final List<BannerComponents> components;
            private final Double degrees;
            private final String drivingSide;
            private final String modifier;
            private final String text;
            private final String type;

            {
                this.components = list;
                if (str == null) {
                    throw new NullPointerException("Null text");
                }
                this.text = str;
                this.modifier = str2;
                this.degrees = d;
                this.drivingSide = str3;
                this.type = str4;
            }

            @Override // com.mappls.sdk.services.api.directions.models.BannerText
            public List<BannerComponents> components() {
                return this.components;
            }

            @Override // com.mappls.sdk.services.api.directions.models.BannerText
            public String text() {
                return this.text;
            }

            @Override // com.mappls.sdk.services.api.directions.models.BannerText
            public String modifier() {
                return this.modifier;
            }

            @Override // com.mappls.sdk.services.api.directions.models.BannerText
            public Double degrees() {
                return this.degrees;
            }

            @Override // com.mappls.sdk.services.api.directions.models.BannerText
            @SerializedName("driving_side")
            public String drivingSide() {
                return this.drivingSide;
            }

            @Override // com.mappls.sdk.services.api.directions.models.BannerText
            public String type() {
                return this.type;
            }

            public String toString() {
                return "BannerText{components=" + this.components + ", text=" + this.text + ", modifier=" + this.modifier + ", degrees=" + this.degrees + ", drivingSide=" + this.drivingSide + ", type=" + this.type + "}";
            }

            public boolean equals(Object obj) {
                String str5;
                Double d2;
                String str6;
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof BannerText)) {
                    return false;
                }
                BannerText bannerText = (BannerText) obj;
                List<BannerComponents> list2 = this.components;
                if (list2 != null ? list2.equals(bannerText.components()) : bannerText.components() == null) {
                    if (this.text.equals(bannerText.text()) && ((str5 = this.modifier) != null ? str5.equals(bannerText.modifier()) : bannerText.modifier() == null) && ((d2 = this.degrees) != null ? d2.equals(bannerText.degrees()) : bannerText.degrees() == null) && ((str6 = this.drivingSide) != null ? str6.equals(bannerText.drivingSide()) : bannerText.drivingSide() == null)) {
                        String str7 = this.type;
                        if (str7 == null) {
                            if (bannerText.type() == null) {
                                return true;
                            }
                        } else if (str7.equals(bannerText.type())) {
                            return true;
                        }
                    }
                }
                return false;
            }

            public int hashCode() {
                List<BannerComponents> list2 = this.components;
                int iHashCode = ((((list2 == null ? 0 : list2.hashCode()) ^ 1000003) * 1000003) ^ this.text.hashCode()) * 1000003;
                String str5 = this.modifier;
                int iHashCode2 = (iHashCode ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
                Double d2 = this.degrees;
                int iHashCode3 = (iHashCode2 ^ (d2 == null ? 0 : d2.hashCode())) * 1000003;
                String str6 = this.drivingSide;
                int iHashCode4 = (iHashCode3 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
                String str7 = this.type;
                return iHashCode4 ^ (str7 != null ? str7.hashCode() : 0);
            }

            @Override // com.mappls.sdk.services.api.directions.models.BannerText
            public BannerText.Builder toBuilder() {
                return new Builder(this);
            }

            /* JADX INFO: renamed from: com.mappls.sdk.services.api.directions.models.$AutoValue_BannerText$Builder */
            static class Builder extends BannerText.Builder {
                private List<BannerComponents> components;
                private Double degrees;
                private String drivingSide;
                private String modifier;
                private String text;
                private String type;

                Builder() {
                }

                private Builder(BannerText bannerText) {
                    this.components = bannerText.components();
                    this.text = bannerText.text();
                    this.modifier = bannerText.modifier();
                    this.degrees = bannerText.degrees();
                    this.drivingSide = bannerText.drivingSide();
                    this.type = bannerText.type();
                }

                @Override // com.mappls.sdk.services.api.directions.models.BannerText.Builder
                public BannerText.Builder components(List<BannerComponents> list) {
                    this.components = list;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.BannerText.Builder
                public BannerText.Builder text(String str) {
                    if (str == null) {
                        throw new NullPointerException("Null text");
                    }
                    this.text = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.BannerText.Builder
                public BannerText.Builder modifier(String str) {
                    this.modifier = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.BannerText.Builder
                public BannerText.Builder degrees(Double d) {
                    this.degrees = d;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.BannerText.Builder
                public BannerText.Builder drivingSide(String str) {
                    this.drivingSide = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.BannerText.Builder
                public BannerText.Builder type(String str) {
                    this.type = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.BannerText.Builder
                public BannerText build() {
                    String str = this.text;
                    if (str == null) {
                        throw new IllegalStateException("Missing required properties: text");
                    }
                    return new AutoValue_BannerText(this.components, str, this.modifier, this.degrees, this.drivingSide, this.type);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<BannerText> {
        private volatile TypeAdapter<Double> double__adapter;
        private final Gson gson;
        private volatile TypeAdapter<List<BannerComponents>> list__bannerComponents_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, BannerText bannerText) throws IOException {
            if (bannerText == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("components");
            if (bannerText.components() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<BannerComponents>> adapter = this.list__bannerComponents_adapter;
                if (adapter == null) {
                    adapter = this.gson.getAdapter(TypeToken.getParameterized(List.class, BannerComponents.class));
                    this.list__bannerComponents_adapter = adapter;
                }
                adapter.write(jsonWriter, bannerText.components());
            }
            jsonWriter.name("text");
            if (bannerText.text() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter2 = this.string_adapter;
                if (adapter2 == null) {
                    adapter2 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter2;
                }
                adapter2.write(jsonWriter, bannerText.text());
            }
            jsonWriter.name("modifier");
            if (bannerText.modifier() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter3 = this.string_adapter;
                if (adapter3 == null) {
                    adapter3 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter3;
                }
                adapter3.write(jsonWriter, bannerText.modifier());
            }
            jsonWriter.name(TurfConstants.UNIT_DEGREES);
            if (bannerText.degrees() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> adapter4 = this.double__adapter;
                if (adapter4 == null) {
                    adapter4 = this.gson.getAdapter(Double.class);
                    this.double__adapter = adapter4;
                }
                adapter4.write(jsonWriter, bannerText.degrees());
            }
            jsonWriter.name("driving_side");
            if (bannerText.drivingSide() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter5 = this.string_adapter;
                if (adapter5 == null) {
                    adapter5 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter5;
                }
                adapter5.write(jsonWriter, bannerText.drivingSide());
            }
            jsonWriter.name("type");
            if (bannerText.type() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter6 = this.string_adapter;
                if (adapter6 == null) {
                    adapter6 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter6;
                }
                adapter6.write(jsonWriter, bannerText.type());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: read */
        public BannerText read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            BannerText.Builder builder = BannerText.builder();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    strNextName.hashCode();
                    if (strNextName.equals("driving_side")) {
                        TypeAdapter<String> adapter = this.string_adapter;
                        if (adapter == null) {
                            adapter = this.gson.getAdapter(String.class);
                            this.string_adapter = adapter;
                        }
                        builder.drivingSide(adapter.read2(jsonReader));
                    } else if ("components".equals(strNextName)) {
                        TypeAdapter<List<BannerComponents>> adapter2 = this.list__bannerComponents_adapter;
                        if (adapter2 == null) {
                            adapter2 = this.gson.getAdapter(TypeToken.getParameterized(List.class, BannerComponents.class));
                            this.list__bannerComponents_adapter = adapter2;
                        }
                        builder.components(adapter2.read2(jsonReader));
                    } else if ("text".equals(strNextName)) {
                        TypeAdapter<String> adapter3 = this.string_adapter;
                        if (adapter3 == null) {
                            adapter3 = this.gson.getAdapter(String.class);
                            this.string_adapter = adapter3;
                        }
                        builder.text(adapter3.read2(jsonReader));
                    } else if ("modifier".equals(strNextName)) {
                        TypeAdapter<String> adapter4 = this.string_adapter;
                        if (adapter4 == null) {
                            adapter4 = this.gson.getAdapter(String.class);
                            this.string_adapter = adapter4;
                        }
                        builder.modifier(adapter4.read2(jsonReader));
                    } else if (TurfConstants.UNIT_DEGREES.equals(strNextName)) {
                        TypeAdapter<Double> adapter5 = this.double__adapter;
                        if (adapter5 == null) {
                            adapter5 = this.gson.getAdapter(Double.class);
                            this.double__adapter = adapter5;
                        }
                        builder.degrees(adapter5.read2(jsonReader));
                    } else if ("type".equals(strNextName)) {
                        TypeAdapter<String> adapter6 = this.string_adapter;
                        if (adapter6 == null) {
                            adapter6 = this.gson.getAdapter(String.class);
                            this.string_adapter = adapter6;
                        }
                        builder.type(adapter6.read2(jsonReader));
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return builder.build();
        }

        public String toString() {
            return "TypeAdapter(BannerText)";
        }
    }
}

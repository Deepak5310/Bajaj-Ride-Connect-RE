package com.mappls.sdk.services.api.directions.models;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_BannerInstructions extends C$AutoValue_BannerInstructions {
    AutoValue_BannerInstructions(double d, Integer num, BannerText bannerText, BannerText bannerText2) {
        new BannerInstructions(d, num, bannerText, bannerText2) { // from class: com.mappls.sdk.services.api.directions.models.$AutoValue_BannerInstructions
            private final double distanceAlongGeometry;
            private final BannerText primary;
            private final Integer secondary;
            private final BannerText sub;

            {
                this.distanceAlongGeometry = d;
                this.secondary = num;
                if (bannerText == null) {
                    throw new NullPointerException("Null primary");
                }
                this.primary = bannerText;
                this.sub = bannerText2;
            }

            @Override // com.mappls.sdk.services.api.directions.models.BannerInstructions
            @SerializedName("distance_along_geometry")
            public double distanceAlongGeometry() {
                return this.distanceAlongGeometry;
            }

            @Override // com.mappls.sdk.services.api.directions.models.BannerInstructions
            public Integer secondary() {
                return this.secondary;
            }

            @Override // com.mappls.sdk.services.api.directions.models.BannerInstructions
            public BannerText primary() {
                return this.primary;
            }

            @Override // com.mappls.sdk.services.api.directions.models.BannerInstructions
            public BannerText sub() {
                return this.sub;
            }

            public String toString() {
                return "BannerInstructions{distanceAlongGeometry=" + this.distanceAlongGeometry + ", secondary=" + this.secondary + ", primary=" + this.primary + ", sub=" + this.sub + "}";
            }

            public boolean equals(Object obj) {
                Integer num2;
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof BannerInstructions)) {
                    return false;
                }
                BannerInstructions bannerInstructions = (BannerInstructions) obj;
                if (Double.doubleToLongBits(this.distanceAlongGeometry) == Double.doubleToLongBits(bannerInstructions.distanceAlongGeometry()) && ((num2 = this.secondary) != null ? num2.equals(bannerInstructions.secondary()) : bannerInstructions.secondary() == null) && this.primary.equals(bannerInstructions.primary())) {
                    BannerText bannerText3 = this.sub;
                    if (bannerText3 == null) {
                        if (bannerInstructions.sub() == null) {
                            return true;
                        }
                    } else if (bannerText3.equals(bannerInstructions.sub())) {
                        return true;
                    }
                }
                return false;
            }

            public int hashCode() {
                int iDoubleToLongBits = (((int) ((Double.doubleToLongBits(this.distanceAlongGeometry) >>> 32) ^ Double.doubleToLongBits(this.distanceAlongGeometry))) ^ 1000003) * 1000003;
                Integer num2 = this.secondary;
                int iHashCode = (((iDoubleToLongBits ^ (num2 == null ? 0 : num2.hashCode())) * 1000003) ^ this.primary.hashCode()) * 1000003;
                BannerText bannerText3 = this.sub;
                return iHashCode ^ (bannerText3 != null ? bannerText3.hashCode() : 0);
            }

            @Override // com.mappls.sdk.services.api.directions.models.BannerInstructions
            public BannerInstructions.Builder toBuilder() {
                return new Builder(this);
            }

            /* JADX INFO: renamed from: com.mappls.sdk.services.api.directions.models.$AutoValue_BannerInstructions$Builder */
            static class Builder extends BannerInstructions.Builder {
                private double distanceAlongGeometry;
                private BannerText primary;
                private Integer secondary;
                private byte set$0;
                private BannerText sub;

                Builder() {
                }

                private Builder(BannerInstructions bannerInstructions) {
                    this.distanceAlongGeometry = bannerInstructions.distanceAlongGeometry();
                    this.secondary = bannerInstructions.secondary();
                    this.primary = bannerInstructions.primary();
                    this.sub = bannerInstructions.sub();
                    this.set$0 = (byte) 1;
                }

                @Override // com.mappls.sdk.services.api.directions.models.BannerInstructions.Builder
                public BannerInstructions.Builder distanceAlongGeometry(double d) {
                    this.distanceAlongGeometry = d;
                    this.set$0 = (byte) (this.set$0 | 1);
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.BannerInstructions.Builder
                public BannerInstructions.Builder secondary(Integer num) {
                    this.secondary = num;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.BannerInstructions.Builder
                public BannerInstructions.Builder primary(BannerText bannerText) {
                    if (bannerText == null) {
                        throw new NullPointerException("Null primary");
                    }
                    this.primary = bannerText;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.BannerInstructions.Builder
                public BannerInstructions.Builder sub(BannerText bannerText) {
                    this.sub = bannerText;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.BannerInstructions.Builder
                public BannerInstructions build() {
                    BannerText bannerText;
                    if (this.set$0 != 1 || (bannerText = this.primary) == null) {
                        StringBuilder sb = new StringBuilder();
                        if ((1 & this.set$0) == 0) {
                            sb.append(" distanceAlongGeometry");
                        }
                        if (this.primary == null) {
                            sb.append(" primary");
                        }
                        throw new IllegalStateException("Missing required properties:" + ((Object) sb));
                    }
                    return new AutoValue_BannerInstructions(this.distanceAlongGeometry, this.secondary, bannerText, this.sub);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<BannerInstructions> {
        private volatile TypeAdapter<BannerText> bannerText_adapter;
        private volatile TypeAdapter<Double> double__adapter;
        private final Gson gson;
        private volatile TypeAdapter<Integer> integer_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, BannerInstructions bannerInstructions) throws IOException {
            if (bannerInstructions == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("distance_along_geometry");
            TypeAdapter<Double> adapter = this.double__adapter;
            if (adapter == null) {
                adapter = this.gson.getAdapter(Double.class);
                this.double__adapter = adapter;
            }
            adapter.write(jsonWriter, Double.valueOf(bannerInstructions.distanceAlongGeometry()));
            jsonWriter.name("secondary");
            if (bannerInstructions.secondary() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> adapter2 = this.integer_adapter;
                if (adapter2 == null) {
                    adapter2 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = adapter2;
                }
                adapter2.write(jsonWriter, bannerInstructions.secondary());
            }
            jsonWriter.name("primary");
            if (bannerInstructions.primary() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<BannerText> adapter3 = this.bannerText_adapter;
                if (adapter3 == null) {
                    adapter3 = this.gson.getAdapter(BannerText.class);
                    this.bannerText_adapter = adapter3;
                }
                adapter3.write(jsonWriter, bannerInstructions.primary());
            }
            jsonWriter.name("sub");
            if (bannerInstructions.sub() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<BannerText> adapter4 = this.bannerText_adapter;
                if (adapter4 == null) {
                    adapter4 = this.gson.getAdapter(BannerText.class);
                    this.bannerText_adapter = adapter4;
                }
                adapter4.write(jsonWriter, bannerInstructions.sub());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: read */
        public BannerInstructions read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            BannerInstructions.Builder builder = BannerInstructions.builder();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    strNextName.hashCode();
                    if (strNextName.equals("distance_along_geometry")) {
                        TypeAdapter<Double> adapter = this.double__adapter;
                        if (adapter == null) {
                            adapter = this.gson.getAdapter(Double.class);
                            this.double__adapter = adapter;
                        }
                        builder.distanceAlongGeometry(adapter.read2(jsonReader).doubleValue());
                    } else if ("secondary".equals(strNextName)) {
                        TypeAdapter<Integer> adapter2 = this.integer_adapter;
                        if (adapter2 == null) {
                            adapter2 = this.gson.getAdapter(Integer.class);
                            this.integer_adapter = adapter2;
                        }
                        builder.secondary(adapter2.read2(jsonReader));
                    } else if ("primary".equals(strNextName)) {
                        TypeAdapter<BannerText> adapter3 = this.bannerText_adapter;
                        if (adapter3 == null) {
                            adapter3 = this.gson.getAdapter(BannerText.class);
                            this.bannerText_adapter = adapter3;
                        }
                        builder.primary(adapter3.read2(jsonReader));
                    } else if ("sub".equals(strNextName)) {
                        TypeAdapter<BannerText> adapter4 = this.bannerText_adapter;
                        if (adapter4 == null) {
                            adapter4 = this.gson.getAdapter(BannerText.class);
                            this.bannerText_adapter = adapter4;
                        }
                        builder.sub(adapter4.read2(jsonReader));
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return builder.build();
        }

        public String toString() {
            return "TypeAdapter(BannerInstructions)";
        }
    }
}

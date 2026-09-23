package com.mappls.sdk.services.api.directions.models;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_DirectionsWaypoint extends C$AutoValue_DirectionsWaypoint {
    AutoValue_DirectionsWaypoint(String str, double[] dArr, Double d, String str2) {
        new DirectionsWaypoint(str, dArr, d, str2) { // from class: com.mappls.sdk.services.api.directions.models.$AutoValue_DirectionsWaypoint
            private final Double distance;
            private final String hint;
            private final String name;
            private final double[] rawLocation;

            {
                this.name = str;
                this.rawLocation = dArr;
                this.distance = d;
                this.hint = str2;
            }

            @Override // com.mappls.sdk.services.api.directions.models.DirectionsWaypoint
            public String name() {
                return this.name;
            }

            @Override // com.mappls.sdk.services.api.directions.models.DirectionsWaypoint
            @SerializedName(FirebaseAnalytics.Param.LOCATION)
            double[] rawLocation() {
                return this.rawLocation;
            }

            @Override // com.mappls.sdk.services.api.directions.models.DirectionsWaypoint
            public Double distance() {
                return this.distance;
            }

            @Override // com.mappls.sdk.services.api.directions.models.DirectionsWaypoint
            public String hint() {
                return this.hint;
            }

            public String toString() {
                return "DirectionsWaypoint{name=" + this.name + ", rawLocation=" + Arrays.toString(this.rawLocation) + ", distance=" + this.distance + ", hint=" + this.hint + "}";
            }

            public boolean equals(Object obj) {
                Double d2;
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof DirectionsWaypoint)) {
                    return false;
                }
                DirectionsWaypoint directionsWaypoint = (DirectionsWaypoint) obj;
                String str3 = this.name;
                if (str3 != null ? str3.equals(directionsWaypoint.name()) : directionsWaypoint.name() == null) {
                    if (Arrays.equals(this.rawLocation, directionsWaypoint instanceof C$AutoValue_DirectionsWaypoint ? ((C$AutoValue_DirectionsWaypoint) directionsWaypoint).rawLocation : directionsWaypoint.rawLocation()) && ((d2 = this.distance) != null ? d2.equals(directionsWaypoint.distance()) : directionsWaypoint.distance() == null)) {
                        String str4 = this.hint;
                        if (str4 == null) {
                            if (directionsWaypoint.hint() == null) {
                                return true;
                            }
                        } else if (str4.equals(directionsWaypoint.hint())) {
                            return true;
                        }
                    }
                }
                return false;
            }

            public int hashCode() {
                String str3 = this.name;
                int iHashCode = ((((str3 == null ? 0 : str3.hashCode()) ^ 1000003) * 1000003) ^ Arrays.hashCode(this.rawLocation)) * 1000003;
                Double d2 = this.distance;
                int iHashCode2 = (iHashCode ^ (d2 == null ? 0 : d2.hashCode())) * 1000003;
                String str4 = this.hint;
                return iHashCode2 ^ (str4 != null ? str4.hashCode() : 0);
            }

            @Override // com.mappls.sdk.services.api.directions.models.DirectionsWaypoint
            public DirectionsWaypoint.Builder toBuilder() {
                return new Builder(this);
            }

            /* JADX INFO: renamed from: com.mappls.sdk.services.api.directions.models.$AutoValue_DirectionsWaypoint$Builder */
            static class Builder extends DirectionsWaypoint.Builder {
                private Double distance;
                private String hint;
                private String name;
                private double[] rawLocation;

                Builder() {
                }

                private Builder(DirectionsWaypoint directionsWaypoint) {
                    this.name = directionsWaypoint.name();
                    this.rawLocation = directionsWaypoint.rawLocation();
                    this.distance = directionsWaypoint.distance();
                    this.hint = directionsWaypoint.hint();
                }

                @Override // com.mappls.sdk.services.api.directions.models.DirectionsWaypoint.Builder
                public DirectionsWaypoint.Builder name(String str) {
                    this.name = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.DirectionsWaypoint.Builder
                public DirectionsWaypoint.Builder rawLocation(double[] dArr) {
                    this.rawLocation = dArr;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.DirectionsWaypoint.Builder
                public DirectionsWaypoint.Builder distance(Double d) {
                    this.distance = d;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.DirectionsWaypoint.Builder
                public DirectionsWaypoint.Builder hint(String str) {
                    this.hint = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.DirectionsWaypoint.Builder
                public DirectionsWaypoint build() {
                    return new AutoValue_DirectionsWaypoint(this.name, this.rawLocation, this.distance, this.hint);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<DirectionsWaypoint> {
        private volatile TypeAdapter<double[]> array__double_adapter;
        private volatile TypeAdapter<Double> double__adapter;
        private final Gson gson;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, DirectionsWaypoint directionsWaypoint) throws IOException {
            if (directionsWaypoint == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("name");
            if (directionsWaypoint.name() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter = this.string_adapter;
                if (adapter == null) {
                    adapter = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter;
                }
                adapter.write(jsonWriter, directionsWaypoint.name());
            }
            jsonWriter.name(FirebaseAnalytics.Param.LOCATION);
            if (directionsWaypoint.rawLocation() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<double[]> adapter2 = this.array__double_adapter;
                if (adapter2 == null) {
                    adapter2 = this.gson.getAdapter(double[].class);
                    this.array__double_adapter = adapter2;
                }
                adapter2.write(jsonWriter, directionsWaypoint.rawLocation());
            }
            jsonWriter.name(DirectionsCriteria.ANNOTATION_DISTANCE);
            if (directionsWaypoint.distance() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> adapter3 = this.double__adapter;
                if (adapter3 == null) {
                    adapter3 = this.gson.getAdapter(Double.class);
                    this.double__adapter = adapter3;
                }
                adapter3.write(jsonWriter, directionsWaypoint.distance());
            }
            jsonWriter.name("hint");
            if (directionsWaypoint.hint() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter4 = this.string_adapter;
                if (adapter4 == null) {
                    adapter4 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter4;
                }
                adapter4.write(jsonWriter, directionsWaypoint.hint());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: read */
        public DirectionsWaypoint read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            DirectionsWaypoint.Builder builder = DirectionsWaypoint.builder();
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
                    } else if ("name".equals(strNextName)) {
                        TypeAdapter<String> adapter2 = this.string_adapter;
                        if (adapter2 == null) {
                            adapter2 = this.gson.getAdapter(String.class);
                            this.string_adapter = adapter2;
                        }
                        builder.name(adapter2.read2(jsonReader));
                    } else if (DirectionsCriteria.ANNOTATION_DISTANCE.equals(strNextName)) {
                        TypeAdapter<Double> adapter3 = this.double__adapter;
                        if (adapter3 == null) {
                            adapter3 = this.gson.getAdapter(Double.class);
                            this.double__adapter = adapter3;
                        }
                        builder.distance(adapter3.read2(jsonReader));
                    } else if ("hint".equals(strNextName)) {
                        TypeAdapter<String> adapter4 = this.string_adapter;
                        if (adapter4 == null) {
                            adapter4 = this.gson.getAdapter(String.class);
                            this.string_adapter = adapter4;
                        }
                        builder.hint(adapter4.read2(jsonReader));
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return builder.build();
        }

        public String toString() {
            return "TypeAdapter(DirectionsWaypoint)";
        }
    }
}

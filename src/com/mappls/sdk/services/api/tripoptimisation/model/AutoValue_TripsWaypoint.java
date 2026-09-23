package com.mappls.sdk.services.api.tripoptimisation.model;

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
final class AutoValue_TripsWaypoint extends C$AutoValue_TripsWaypoint {
    AutoValue_TripsWaypoint(String str, double[] dArr, Double d, String str2, Integer num, Integer num2) {
        new TripsWaypoint(str, dArr, d, str2, num, num2) { // from class: com.mappls.sdk.services.api.tripoptimisation.model.$AutoValue_TripsWaypoint
            private final Double distance;
            private final String hint;
            private final String name;
            private final double[] rawLocation;
            private final Integer tripsIndex;
            private final Integer waypointIndex;

            {
                this.name = str;
                this.rawLocation = dArr;
                this.distance = d;
                this.hint = str2;
                this.waypointIndex = num;
                this.tripsIndex = num2;
            }

            @Override // com.mappls.sdk.services.api.tripoptimisation.model.TripsWaypoint
            public String name() {
                return this.name;
            }

            @Override // com.mappls.sdk.services.api.tripoptimisation.model.TripsWaypoint
            @SerializedName(FirebaseAnalytics.Param.LOCATION)
            double[] rawLocation() {
                return this.rawLocation;
            }

            @Override // com.mappls.sdk.services.api.tripoptimisation.model.TripsWaypoint
            public Double distance() {
                return this.distance;
            }

            @Override // com.mappls.sdk.services.api.tripoptimisation.model.TripsWaypoint
            public String hint() {
                return this.hint;
            }

            @Override // com.mappls.sdk.services.api.tripoptimisation.model.TripsWaypoint
            @SerializedName("waypoint_index")
            public Integer waypointIndex() {
                return this.waypointIndex;
            }

            @Override // com.mappls.sdk.services.api.tripoptimisation.model.TripsWaypoint
            @SerializedName("trips_index")
            public Integer tripsIndex() {
                return this.tripsIndex;
            }

            public String toString() {
                return "TripsWaypoint{name=" + this.name + ", rawLocation=" + Arrays.toString(this.rawLocation) + ", distance=" + this.distance + ", hint=" + this.hint + ", waypointIndex=" + this.waypointIndex + ", tripsIndex=" + this.tripsIndex + "}";
            }

            public boolean equals(Object obj) {
                Double d2;
                String str3;
                Integer num3;
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof TripsWaypoint)) {
                    return false;
                }
                TripsWaypoint tripsWaypoint = (TripsWaypoint) obj;
                String str4 = this.name;
                if (str4 != null ? str4.equals(tripsWaypoint.name()) : tripsWaypoint.name() == null) {
                    if (Arrays.equals(this.rawLocation, tripsWaypoint instanceof C$AutoValue_TripsWaypoint ? ((C$AutoValue_TripsWaypoint) tripsWaypoint).rawLocation : tripsWaypoint.rawLocation()) && ((d2 = this.distance) != null ? d2.equals(tripsWaypoint.distance()) : tripsWaypoint.distance() == null) && ((str3 = this.hint) != null ? str3.equals(tripsWaypoint.hint()) : tripsWaypoint.hint() == null) && ((num3 = this.waypointIndex) != null ? num3.equals(tripsWaypoint.waypointIndex()) : tripsWaypoint.waypointIndex() == null)) {
                        Integer num4 = this.tripsIndex;
                        if (num4 == null) {
                            if (tripsWaypoint.tripsIndex() == null) {
                                return true;
                            }
                        } else if (num4.equals(tripsWaypoint.tripsIndex())) {
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
                int iHashCode3 = (iHashCode2 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
                Integer num3 = this.waypointIndex;
                int iHashCode4 = (iHashCode3 ^ (num3 == null ? 0 : num3.hashCode())) * 1000003;
                Integer num4 = this.tripsIndex;
                return iHashCode4 ^ (num4 != null ? num4.hashCode() : 0);
            }

            @Override // com.mappls.sdk.services.api.tripoptimisation.model.TripsWaypoint
            public TripsWaypoint.Builder toBuilder() {
                return new Builder(this);
            }

            /* JADX INFO: renamed from: com.mappls.sdk.services.api.tripoptimisation.model.$AutoValue_TripsWaypoint$Builder */
            static class Builder extends TripsWaypoint.Builder {
                private Double distance;
                private String hint;
                private String name;
                private double[] rawLocation;
                private Integer tripsIndex;
                private Integer waypointIndex;

                Builder() {
                }

                private Builder(TripsWaypoint tripsWaypoint) {
                    this.name = tripsWaypoint.name();
                    this.rawLocation = tripsWaypoint.rawLocation();
                    this.distance = tripsWaypoint.distance();
                    this.hint = tripsWaypoint.hint();
                    this.waypointIndex = tripsWaypoint.waypointIndex();
                    this.tripsIndex = tripsWaypoint.tripsIndex();
                }

                @Override // com.mappls.sdk.services.api.tripoptimisation.model.TripsWaypoint.Builder
                public TripsWaypoint.Builder name(String str) {
                    this.name = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.tripoptimisation.model.TripsWaypoint.Builder
                public TripsWaypoint.Builder rawLocation(double[] dArr) {
                    this.rawLocation = dArr;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.tripoptimisation.model.TripsWaypoint.Builder
                public TripsWaypoint.Builder distance(Double d) {
                    this.distance = d;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.tripoptimisation.model.TripsWaypoint.Builder
                public TripsWaypoint.Builder hint(String str) {
                    this.hint = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.tripoptimisation.model.TripsWaypoint.Builder
                public TripsWaypoint.Builder waypointIndex(Integer num) {
                    this.waypointIndex = num;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.tripoptimisation.model.TripsWaypoint.Builder
                public TripsWaypoint.Builder tripsIndex(Integer num) {
                    this.tripsIndex = num;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.tripoptimisation.model.TripsWaypoint.Builder
                public TripsWaypoint build() {
                    return new AutoValue_TripsWaypoint(this.name, this.rawLocation, this.distance, this.hint, this.waypointIndex, this.tripsIndex);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<TripsWaypoint> {
        private volatile TypeAdapter<double[]> array__double_adapter;
        private volatile TypeAdapter<Double> double__adapter;
        private final Gson gson;
        private volatile TypeAdapter<Integer> integer_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, TripsWaypoint tripsWaypoint) throws IOException {
            if (tripsWaypoint == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("name");
            if (tripsWaypoint.name() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter = this.string_adapter;
                if (adapter == null) {
                    adapter = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter;
                }
                adapter.write(jsonWriter, tripsWaypoint.name());
            }
            jsonWriter.name(FirebaseAnalytics.Param.LOCATION);
            if (tripsWaypoint.rawLocation() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<double[]> adapter2 = this.array__double_adapter;
                if (adapter2 == null) {
                    adapter2 = this.gson.getAdapter(double[].class);
                    this.array__double_adapter = adapter2;
                }
                adapter2.write(jsonWriter, tripsWaypoint.rawLocation());
            }
            jsonWriter.name(DirectionsCriteria.ANNOTATION_DISTANCE);
            if (tripsWaypoint.distance() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> adapter3 = this.double__adapter;
                if (adapter3 == null) {
                    adapter3 = this.gson.getAdapter(Double.class);
                    this.double__adapter = adapter3;
                }
                adapter3.write(jsonWriter, tripsWaypoint.distance());
            }
            jsonWriter.name("hint");
            if (tripsWaypoint.hint() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter4 = this.string_adapter;
                if (adapter4 == null) {
                    adapter4 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter4;
                }
                adapter4.write(jsonWriter, tripsWaypoint.hint());
            }
            jsonWriter.name("waypoint_index");
            if (tripsWaypoint.waypointIndex() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> adapter5 = this.integer_adapter;
                if (adapter5 == null) {
                    adapter5 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = adapter5;
                }
                adapter5.write(jsonWriter, tripsWaypoint.waypointIndex());
            }
            jsonWriter.name("trips_index");
            if (tripsWaypoint.tripsIndex() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> adapter6 = this.integer_adapter;
                if (adapter6 == null) {
                    adapter6 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = adapter6;
                }
                adapter6.write(jsonWriter, tripsWaypoint.tripsIndex());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: read */
        public TripsWaypoint read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            TripsWaypoint.Builder builder = TripsWaypoint.builder();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    strNextName.hashCode();
                    switch (strNextName) {
                        case "trips_index":
                            TypeAdapter<Integer> adapter = this.integer_adapter;
                            if (adapter == null) {
                                adapter = this.gson.getAdapter(Integer.class);
                                this.integer_adapter = adapter;
                            }
                            builder.tripsIndex(adapter.read2(jsonReader));
                            break;
                        case "waypoint_index":
                            TypeAdapter<Integer> adapter2 = this.integer_adapter;
                            if (adapter2 == null) {
                                adapter2 = this.gson.getAdapter(Integer.class);
                                this.integer_adapter = adapter2;
                            }
                            builder.waypointIndex(adapter2.read2(jsonReader));
                            break;
                        case "location":
                            TypeAdapter<double[]> adapter3 = this.array__double_adapter;
                            if (adapter3 == null) {
                                adapter3 = this.gson.getAdapter(double[].class);
                                this.array__double_adapter = adapter3;
                            }
                            builder.rawLocation(adapter3.read2(jsonReader));
                            break;
                        default:
                            if ("name".equals(strNextName)) {
                                TypeAdapter<String> adapter4 = this.string_adapter;
                                if (adapter4 == null) {
                                    adapter4 = this.gson.getAdapter(String.class);
                                    this.string_adapter = adapter4;
                                }
                                builder.name(adapter4.read2(jsonReader));
                                break;
                            } else {
                                if (DirectionsCriteria.ANNOTATION_DISTANCE.equals(strNextName)) {
                                    TypeAdapter<Double> adapter5 = this.double__adapter;
                                    if (adapter5 == null) {
                                        adapter5 = this.gson.getAdapter(Double.class);
                                        this.double__adapter = adapter5;
                                    }
                                    builder.distance(adapter5.read2(jsonReader));
                                } else if ("hint".equals(strNextName)) {
                                    TypeAdapter<String> adapter6 = this.string_adapter;
                                    if (adapter6 == null) {
                                        adapter6 = this.gson.getAdapter(String.class);
                                        this.string_adapter = adapter6;
                                    }
                                    builder.hint(adapter6.read2(jsonReader));
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
            return "TypeAdapter(TripsWaypoint)";
        }
    }
}

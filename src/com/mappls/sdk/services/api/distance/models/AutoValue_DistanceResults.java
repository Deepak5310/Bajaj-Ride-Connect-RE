package com.mappls.sdk.services.api.distance.models;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mappls.sdk.services.api.directions.models.DirectionsWaypoint;
import com.spotify.sdk.android.auth.AccountsQueryParameters;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_DistanceResults extends C$AutoValue_DistanceResults {
    AutoValue_DistanceResults(String str, List<DirectionsWaypoint> list, List<DirectionsWaypoint> list2, List<Double[]> list3, List<Double[]> list4, List<Double[]> list5) {
        new DistanceResults(str, list, list2, list3, list4, list5) { // from class: com.mappls.sdk.services.api.distance.models.$AutoValue_DistanceResults
            private final String code;
            private final List<DirectionsWaypoint> destinations;
            private final List<Double[]> distances;
            private final List<Double[]> durations;
            private final List<Double[]> fallbackSpeedCells;
            private final List<DirectionsWaypoint> sources;

            {
                if (str == null) {
                    throw new NullPointerException("Null code");
                }
                this.code = str;
                this.destinations = list;
                this.sources = list2;
                this.durations = list3;
                this.distances = list4;
                this.fallbackSpeedCells = list5;
            }

            @Override // com.mappls.sdk.services.api.distance.models.DistanceResults
            public String code() {
                return this.code;
            }

            @Override // com.mappls.sdk.services.api.distance.models.DistanceResults
            public List<DirectionsWaypoint> destinations() {
                return this.destinations;
            }

            @Override // com.mappls.sdk.services.api.distance.models.DistanceResults
            public List<DirectionsWaypoint> sources() {
                return this.sources;
            }

            @Override // com.mappls.sdk.services.api.distance.models.DistanceResults
            @SerializedName("durations")
            public List<Double[]> durations() {
                return this.durations;
            }

            @Override // com.mappls.sdk.services.api.distance.models.DistanceResults
            @SerializedName("distances")
            public List<Double[]> distances() {
                return this.distances;
            }

            @Override // com.mappls.sdk.services.api.distance.models.DistanceResults
            @SerializedName("fallback_speed_cells")
            public List<Double[]> fallbackSpeedCells() {
                return this.fallbackSpeedCells;
            }

            public String toString() {
                return "DistanceResults{code=" + this.code + ", destinations=" + this.destinations + ", sources=" + this.sources + ", durations=" + this.durations + ", distances=" + this.distances + ", fallbackSpeedCells=" + this.fallbackSpeedCells + "}";
            }

            public boolean equals(Object obj) {
                List<DirectionsWaypoint> list6;
                List<DirectionsWaypoint> list7;
                List<Double[]> list8;
                List<Double[]> list9;
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof DistanceResults)) {
                    return false;
                }
                DistanceResults distanceResults = (DistanceResults) obj;
                if (this.code.equals(distanceResults.code()) && ((list6 = this.destinations) != null ? list6.equals(distanceResults.destinations()) : distanceResults.destinations() == null) && ((list7 = this.sources) != null ? list7.equals(distanceResults.sources()) : distanceResults.sources() == null) && ((list8 = this.durations) != null ? list8.equals(distanceResults.durations()) : distanceResults.durations() == null) && ((list9 = this.distances) != null ? list9.equals(distanceResults.distances()) : distanceResults.distances() == null)) {
                    List<Double[]> list10 = this.fallbackSpeedCells;
                    if (list10 == null) {
                        if (distanceResults.fallbackSpeedCells() == null) {
                            return true;
                        }
                    } else if (list10.equals(distanceResults.fallbackSpeedCells())) {
                        return true;
                    }
                }
                return false;
            }

            public int hashCode() {
                int iHashCode = (this.code.hashCode() ^ 1000003) * 1000003;
                List<DirectionsWaypoint> list6 = this.destinations;
                int iHashCode2 = (iHashCode ^ (list6 == null ? 0 : list6.hashCode())) * 1000003;
                List<DirectionsWaypoint> list7 = this.sources;
                int iHashCode3 = (iHashCode2 ^ (list7 == null ? 0 : list7.hashCode())) * 1000003;
                List<Double[]> list8 = this.durations;
                int iHashCode4 = (iHashCode3 ^ (list8 == null ? 0 : list8.hashCode())) * 1000003;
                List<Double[]> list9 = this.distances;
                int iHashCode5 = (iHashCode4 ^ (list9 == null ? 0 : list9.hashCode())) * 1000003;
                List<Double[]> list10 = this.fallbackSpeedCells;
                return iHashCode5 ^ (list10 != null ? list10.hashCode() : 0);
            }

            @Override // com.mappls.sdk.services.api.distance.models.DistanceResults
            public DistanceResults.Builder toBuilder() {
                return new Builder(this);
            }

            /* JADX INFO: renamed from: com.mappls.sdk.services.api.distance.models.$AutoValue_DistanceResults$Builder */
            static class Builder extends DistanceResults.Builder {
                private String code;
                private List<DirectionsWaypoint> destinations;
                private List<Double[]> distances;
                private List<Double[]> durations;
                private List<Double[]> fallbackSpeedCells;
                private List<DirectionsWaypoint> sources;

                Builder() {
                }

                private Builder(DistanceResults distanceResults) {
                    this.code = distanceResults.code();
                    this.destinations = distanceResults.destinations();
                    this.sources = distanceResults.sources();
                    this.durations = distanceResults.durations();
                    this.distances = distanceResults.distances();
                    this.fallbackSpeedCells = distanceResults.fallbackSpeedCells();
                }

                @Override // com.mappls.sdk.services.api.distance.models.DistanceResults.Builder
                public DistanceResults.Builder code(String str) {
                    if (str == null) {
                        throw new NullPointerException("Null code");
                    }
                    this.code = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.distance.models.DistanceResults.Builder
                public DistanceResults.Builder destinations(List<DirectionsWaypoint> list) {
                    this.destinations = list;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.distance.models.DistanceResults.Builder
                public DistanceResults.Builder sources(List<DirectionsWaypoint> list) {
                    this.sources = list;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.distance.models.DistanceResults.Builder
                public DistanceResults.Builder durations(List<Double[]> list) {
                    this.durations = list;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.distance.models.DistanceResults.Builder
                public DistanceResults.Builder distances(List<Double[]> list) {
                    this.distances = list;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.distance.models.DistanceResults.Builder
                public DistanceResults.Builder fallbackSpeedCells(List<Double[]> list) {
                    this.fallbackSpeedCells = list;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.distance.models.DistanceResults.Builder
                public DistanceResults build() {
                    String str = this.code;
                    if (str == null) {
                        throw new IllegalStateException("Missing required properties: code");
                    }
                    return new AutoValue_DistanceResults(str, this.destinations, this.sources, this.durations, this.distances, this.fallbackSpeedCells);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<DistanceResults> {
        private final Gson gson;
        private volatile TypeAdapter<List<Double[]>> list__array__double_adapter;
        private volatile TypeAdapter<List<DirectionsWaypoint>> list__directionsWaypoint_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, DistanceResults distanceResults) throws IOException {
            if (distanceResults == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name(AccountsQueryParameters.CODE);
            if (distanceResults.code() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter = this.string_adapter;
                if (adapter == null) {
                    adapter = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter;
                }
                adapter.write(jsonWriter, distanceResults.code());
            }
            jsonWriter.name("destinations");
            if (distanceResults.destinations() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<DirectionsWaypoint>> adapter2 = this.list__directionsWaypoint_adapter;
                if (adapter2 == null) {
                    adapter2 = this.gson.getAdapter(TypeToken.getParameterized(List.class, DirectionsWaypoint.class));
                    this.list__directionsWaypoint_adapter = adapter2;
                }
                adapter2.write(jsonWriter, distanceResults.destinations());
            }
            jsonWriter.name("sources");
            if (distanceResults.sources() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<DirectionsWaypoint>> adapter3 = this.list__directionsWaypoint_adapter;
                if (adapter3 == null) {
                    adapter3 = this.gson.getAdapter(TypeToken.getParameterized(List.class, DirectionsWaypoint.class));
                    this.list__directionsWaypoint_adapter = adapter3;
                }
                adapter3.write(jsonWriter, distanceResults.sources());
            }
            jsonWriter.name("durations");
            if (distanceResults.durations() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<Double[]>> adapter4 = this.list__array__double_adapter;
                if (adapter4 == null) {
                    adapter4 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Double[].class));
                    this.list__array__double_adapter = adapter4;
                }
                adapter4.write(jsonWriter, distanceResults.durations());
            }
            jsonWriter.name("distances");
            if (distanceResults.distances() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<Double[]>> adapter5 = this.list__array__double_adapter;
                if (adapter5 == null) {
                    adapter5 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Double[].class));
                    this.list__array__double_adapter = adapter5;
                }
                adapter5.write(jsonWriter, distanceResults.distances());
            }
            jsonWriter.name("fallback_speed_cells");
            if (distanceResults.fallbackSpeedCells() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<Double[]>> adapter6 = this.list__array__double_adapter;
                if (adapter6 == null) {
                    adapter6 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Double[].class));
                    this.list__array__double_adapter = adapter6;
                }
                adapter6.write(jsonWriter, distanceResults.fallbackSpeedCells());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: read */
        public DistanceResults read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            DistanceResults.Builder builder = DistanceResults.builder();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    strNextName.hashCode();
                    switch (strNextName) {
                        case "durations":
                            TypeAdapter<List<Double[]>> adapter = this.list__array__double_adapter;
                            if (adapter == null) {
                                adapter = this.gson.getAdapter(TypeToken.getParameterized(List.class, Double[].class));
                                this.list__array__double_adapter = adapter;
                            }
                            builder.durations(adapter.read2(jsonReader));
                            break;
                        case "fallback_speed_cells":
                            TypeAdapter<List<Double[]>> adapter2 = this.list__array__double_adapter;
                            if (adapter2 == null) {
                                adapter2 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Double[].class));
                                this.list__array__double_adapter = adapter2;
                            }
                            builder.fallbackSpeedCells(adapter2.read2(jsonReader));
                            break;
                        case "distances":
                            TypeAdapter<List<Double[]>> adapter3 = this.list__array__double_adapter;
                            if (adapter3 == null) {
                                adapter3 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Double[].class));
                                this.list__array__double_adapter = adapter3;
                            }
                            builder.distances(adapter3.read2(jsonReader));
                            break;
                        default:
                            if (AccountsQueryParameters.CODE.equals(strNextName)) {
                                TypeAdapter<String> adapter4 = this.string_adapter;
                                if (adapter4 == null) {
                                    adapter4 = this.gson.getAdapter(String.class);
                                    this.string_adapter = adapter4;
                                }
                                builder.code(adapter4.read2(jsonReader));
                                break;
                            } else {
                                if ("destinations".equals(strNextName)) {
                                    TypeAdapter<List<DirectionsWaypoint>> adapter5 = this.list__directionsWaypoint_adapter;
                                    if (adapter5 == null) {
                                        adapter5 = this.gson.getAdapter(TypeToken.getParameterized(List.class, DirectionsWaypoint.class));
                                        this.list__directionsWaypoint_adapter = adapter5;
                                    }
                                    builder.destinations(adapter5.read2(jsonReader));
                                } else if ("sources".equals(strNextName)) {
                                    TypeAdapter<List<DirectionsWaypoint>> adapter6 = this.list__directionsWaypoint_adapter;
                                    if (adapter6 == null) {
                                        adapter6 = this.gson.getAdapter(TypeToken.getParameterized(List.class, DirectionsWaypoint.class));
                                        this.list__directionsWaypoint_adapter = adapter6;
                                    }
                                    builder.sources(adapter6.read2(jsonReader));
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
            return "TypeAdapter(DistanceResults)";
        }
    }
}

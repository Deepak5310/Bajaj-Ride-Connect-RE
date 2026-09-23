package com.mappls.sdk.services.api.tripoptimisation.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mappls.sdk.services.api.directions.models.DirectionsRoute;
import com.spotify.sdk.android.auth.AccountsQueryParameters;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_TripOptimisationResponse extends C$AutoValue_TripOptimisationResponse {
    AutoValue_TripOptimisationResponse(String str, List<DirectionsRoute> list, List<TripsWaypoint> list2) {
        new TripOptimisationResponse(str, list, list2) { // from class: com.mappls.sdk.services.api.tripoptimisation.model.$AutoValue_TripOptimisationResponse
            private final String code;
            private final List<DirectionsRoute> trips;
            private final List<TripsWaypoint> waypoints;

            {
                if (str == null) {
                    throw new NullPointerException("Null code");
                }
                this.code = str;
                if (list == null) {
                    throw new NullPointerException("Null trips");
                }
                this.trips = list;
                this.waypoints = list2;
            }

            @Override // com.mappls.sdk.services.api.tripoptimisation.model.TripOptimisationResponse
            public String code() {
                return this.code;
            }

            @Override // com.mappls.sdk.services.api.tripoptimisation.model.TripOptimisationResponse
            public List<DirectionsRoute> trips() {
                return this.trips;
            }

            @Override // com.mappls.sdk.services.api.tripoptimisation.model.TripOptimisationResponse
            public List<TripsWaypoint> waypoints() {
                return this.waypoints;
            }

            public String toString() {
                return "TripOptimisationResponse{code=" + this.code + ", trips=" + this.trips + ", waypoints=" + this.waypoints + "}";
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof TripOptimisationResponse)) {
                    return false;
                }
                TripOptimisationResponse tripOptimisationResponse = (TripOptimisationResponse) obj;
                if (this.code.equals(tripOptimisationResponse.code()) && this.trips.equals(tripOptimisationResponse.trips())) {
                    List<TripsWaypoint> list3 = this.waypoints;
                    if (list3 == null) {
                        if (tripOptimisationResponse.waypoints() == null) {
                            return true;
                        }
                    } else if (list3.equals(tripOptimisationResponse.waypoints())) {
                        return true;
                    }
                }
                return false;
            }

            public int hashCode() {
                int iHashCode = (((this.code.hashCode() ^ 1000003) * 1000003) ^ this.trips.hashCode()) * 1000003;
                List<TripsWaypoint> list3 = this.waypoints;
                return iHashCode ^ (list3 == null ? 0 : list3.hashCode());
            }

            @Override // com.mappls.sdk.services.api.tripoptimisation.model.TripOptimisationResponse
            public TripOptimisationResponse.Builder toBuilder() {
                return new Builder(this);
            }

            /* JADX INFO: renamed from: com.mappls.sdk.services.api.tripoptimisation.model.$AutoValue_TripOptimisationResponse$Builder */
            static class Builder extends TripOptimisationResponse.Builder {
                private String code;
                private List<DirectionsRoute> trips;
                private List<TripsWaypoint> waypoints;

                Builder() {
                }

                private Builder(TripOptimisationResponse tripOptimisationResponse) {
                    this.code = tripOptimisationResponse.code();
                    this.trips = tripOptimisationResponse.trips();
                    this.waypoints = tripOptimisationResponse.waypoints();
                }

                @Override // com.mappls.sdk.services.api.tripoptimisation.model.TripOptimisationResponse.Builder
                public TripOptimisationResponse.Builder code(String str) {
                    if (str == null) {
                        throw new NullPointerException("Null code");
                    }
                    this.code = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.tripoptimisation.model.TripOptimisationResponse.Builder
                public TripOptimisationResponse.Builder trips(List<DirectionsRoute> list) {
                    if (list == null) {
                        throw new NullPointerException("Null trips");
                    }
                    this.trips = list;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.tripoptimisation.model.TripOptimisationResponse.Builder
                public TripOptimisationResponse.Builder waypoints(List<TripsWaypoint> list) {
                    this.waypoints = list;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.tripoptimisation.model.TripOptimisationResponse.Builder
                public TripOptimisationResponse build() {
                    List<DirectionsRoute> list;
                    String str = this.code;
                    if (str == null || (list = this.trips) == null) {
                        StringBuilder sb = new StringBuilder();
                        if (this.code == null) {
                            sb.append(" code");
                        }
                        if (this.trips == null) {
                            sb.append(" trips");
                        }
                        throw new IllegalStateException("Missing required properties:" + ((Object) sb));
                    }
                    return new AutoValue_TripOptimisationResponse(str, list, this.waypoints);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<TripOptimisationResponse> {
        private final Gson gson;
        private volatile TypeAdapter<List<DirectionsRoute>> list__directionsRoute_adapter;
        private volatile TypeAdapter<List<TripsWaypoint>> list__tripsWaypoint_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, TripOptimisationResponse tripOptimisationResponse) throws IOException {
            if (tripOptimisationResponse == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name(AccountsQueryParameters.CODE);
            if (tripOptimisationResponse.code() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter = this.string_adapter;
                if (adapter == null) {
                    adapter = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter;
                }
                adapter.write(jsonWriter, tripOptimisationResponse.code());
            }
            jsonWriter.name("trips");
            if (tripOptimisationResponse.trips() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<DirectionsRoute>> adapter2 = this.list__directionsRoute_adapter;
                if (adapter2 == null) {
                    adapter2 = this.gson.getAdapter(TypeToken.getParameterized(List.class, DirectionsRoute.class));
                    this.list__directionsRoute_adapter = adapter2;
                }
                adapter2.write(jsonWriter, tripOptimisationResponse.trips());
            }
            jsonWriter.name("waypoints");
            if (tripOptimisationResponse.waypoints() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<TripsWaypoint>> adapter3 = this.list__tripsWaypoint_adapter;
                if (adapter3 == null) {
                    adapter3 = this.gson.getAdapter(TypeToken.getParameterized(List.class, TripsWaypoint.class));
                    this.list__tripsWaypoint_adapter = adapter3;
                }
                adapter3.write(jsonWriter, tripOptimisationResponse.waypoints());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: read */
        public TripOptimisationResponse read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            TripOptimisationResponse.Builder builder = TripOptimisationResponse.builder();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    strNextName.hashCode();
                    if (AccountsQueryParameters.CODE.equals(strNextName)) {
                        TypeAdapter<String> adapter = this.string_adapter;
                        if (adapter == null) {
                            adapter = this.gson.getAdapter(String.class);
                            this.string_adapter = adapter;
                        }
                        builder.code(adapter.read2(jsonReader));
                    } else if ("trips".equals(strNextName)) {
                        TypeAdapter<List<DirectionsRoute>> adapter2 = this.list__directionsRoute_adapter;
                        if (adapter2 == null) {
                            adapter2 = this.gson.getAdapter(TypeToken.getParameterized(List.class, DirectionsRoute.class));
                            this.list__directionsRoute_adapter = adapter2;
                        }
                        builder.trips(adapter2.read2(jsonReader));
                    } else if ("waypoints".equals(strNextName)) {
                        TypeAdapter<List<TripsWaypoint>> adapter3 = this.list__tripsWaypoint_adapter;
                        if (adapter3 == null) {
                            adapter3 = this.gson.getAdapter(TypeToken.getParameterized(List.class, TripsWaypoint.class));
                            this.list__tripsWaypoint_adapter = adapter3;
                        }
                        builder.waypoints(adapter3.read2(jsonReader));
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return builder.build();
        }

        public String toString() {
            return "TypeAdapter(TripOptimisationResponse)";
        }
    }
}

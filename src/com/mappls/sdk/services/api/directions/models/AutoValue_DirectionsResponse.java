package com.mappls.sdk.services.api.directions.models;

import androidx.mediarouter.media.MediaRouteProviderProtocol;
import com.facebook.react.devsupport.StackTraceHelper;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.spotify.sdk.android.auth.AccountsQueryParameters;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_DirectionsResponse extends C$AutoValue_DirectionsResponse {
    AutoValue_DirectionsResponse(String str, String str2, List<DirectionsWaypoint> list, List<DirectionsRoute> list2, String str3, String str4) {
        new DirectionsResponse(str, str2, list, list2, str3, str4) { // from class: com.mappls.sdk.services.api.directions.models.$AutoValue_DirectionsResponse
            private final String code;
            private final String message;
            private final List<DirectionsRoute> routes;
            private final String sessionId;
            private final String uuid;
            private final List<DirectionsWaypoint> waypoints;

            {
                if (str == null) {
                    throw new NullPointerException("Null code");
                }
                this.code = str;
                this.message = str2;
                this.waypoints = list;
                if (list2 == null) {
                    throw new NullPointerException("Null routes");
                }
                this.routes = list2;
                this.uuid = str3;
                this.sessionId = str4;
            }

            @Override // com.mappls.sdk.services.api.directions.models.DirectionsResponse
            public String code() {
                return this.code;
            }

            @Override // com.mappls.sdk.services.api.directions.models.DirectionsResponse
            public String message() {
                return this.message;
            }

            @Override // com.mappls.sdk.services.api.directions.models.DirectionsResponse
            public List<DirectionsWaypoint> waypoints() {
                return this.waypoints;
            }

            @Override // com.mappls.sdk.services.api.directions.models.DirectionsResponse
            public List<DirectionsRoute> routes() {
                return this.routes;
            }

            @Override // com.mappls.sdk.services.api.directions.models.DirectionsResponse
            @SerializedName(MediaRouteProviderProtocol.CLIENT_DATA_ROUTE_ID)
            public String uuid() {
                return this.uuid;
            }

            @Override // com.mappls.sdk.services.api.directions.models.DirectionsResponse
            @SerializedName("sessionId")
            public String sessionId() {
                return this.sessionId;
            }

            public String toString() {
                return "DirectionsResponse{code=" + this.code + ", message=" + this.message + ", waypoints=" + this.waypoints + ", routes=" + this.routes + ", uuid=" + this.uuid + ", sessionId=" + this.sessionId + "}";
            }

            public boolean equals(Object obj) {
                String str5;
                List<DirectionsWaypoint> list3;
                String str6;
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof DirectionsResponse)) {
                    return false;
                }
                DirectionsResponse directionsResponse = (DirectionsResponse) obj;
                if (this.code.equals(directionsResponse.code()) && ((str5 = this.message) != null ? str5.equals(directionsResponse.message()) : directionsResponse.message() == null) && ((list3 = this.waypoints) != null ? list3.equals(directionsResponse.waypoints()) : directionsResponse.waypoints() == null) && this.routes.equals(directionsResponse.routes()) && ((str6 = this.uuid) != null ? str6.equals(directionsResponse.uuid()) : directionsResponse.uuid() == null)) {
                    String str7 = this.sessionId;
                    if (str7 == null) {
                        if (directionsResponse.sessionId() == null) {
                            return true;
                        }
                    } else if (str7.equals(directionsResponse.sessionId())) {
                        return true;
                    }
                }
                return false;
            }

            public int hashCode() {
                int iHashCode = (this.code.hashCode() ^ 1000003) * 1000003;
                String str5 = this.message;
                int iHashCode2 = (iHashCode ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
                List<DirectionsWaypoint> list3 = this.waypoints;
                int iHashCode3 = (((iHashCode2 ^ (list3 == null ? 0 : list3.hashCode())) * 1000003) ^ this.routes.hashCode()) * 1000003;
                String str6 = this.uuid;
                int iHashCode4 = (iHashCode3 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
                String str7 = this.sessionId;
                return iHashCode4 ^ (str7 != null ? str7.hashCode() : 0);
            }

            @Override // com.mappls.sdk.services.api.directions.models.DirectionsResponse
            public DirectionsResponse.Builder toBuilder() {
                return new Builder(this);
            }

            /* JADX INFO: renamed from: com.mappls.sdk.services.api.directions.models.$AutoValue_DirectionsResponse$Builder */
            static class Builder extends DirectionsResponse.Builder {
                private String code;
                private String message;
                private List<DirectionsRoute> routes;
                private String sessionId;
                private String uuid;
                private List<DirectionsWaypoint> waypoints;

                Builder() {
                }

                private Builder(DirectionsResponse directionsResponse) {
                    this.code = directionsResponse.code();
                    this.message = directionsResponse.message();
                    this.waypoints = directionsResponse.waypoints();
                    this.routes = directionsResponse.routes();
                    this.uuid = directionsResponse.uuid();
                    this.sessionId = directionsResponse.sessionId();
                }

                @Override // com.mappls.sdk.services.api.directions.models.DirectionsResponse.Builder
                public DirectionsResponse.Builder code(String str) {
                    if (str == null) {
                        throw new NullPointerException("Null code");
                    }
                    this.code = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.DirectionsResponse.Builder
                public DirectionsResponse.Builder message(String str) {
                    this.message = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.DirectionsResponse.Builder
                public DirectionsResponse.Builder waypoints(List<DirectionsWaypoint> list) {
                    this.waypoints = list;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.DirectionsResponse.Builder
                public DirectionsResponse.Builder routes(List<DirectionsRoute> list) {
                    if (list == null) {
                        throw new NullPointerException("Null routes");
                    }
                    this.routes = list;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.DirectionsResponse.Builder
                List<DirectionsRoute> routes() {
                    List<DirectionsRoute> list = this.routes;
                    if (list != null) {
                        return list;
                    }
                    throw new IllegalStateException("Property \"routes\" has not been set");
                }

                @Override // com.mappls.sdk.services.api.directions.models.DirectionsResponse.Builder
                public DirectionsResponse.Builder uuid(String str) {
                    this.uuid = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.DirectionsResponse.Builder
                public DirectionsResponse.Builder sessionId(String str) {
                    this.sessionId = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.DirectionsResponse.Builder
                DirectionsResponse autoBuild() {
                    List<DirectionsRoute> list;
                    String str = this.code;
                    if (str == null || (list = this.routes) == null) {
                        StringBuilder sb = new StringBuilder();
                        if (this.code == null) {
                            sb.append(" code");
                        }
                        if (this.routes == null) {
                            sb.append(" routes");
                        }
                        throw new IllegalStateException("Missing required properties:" + ((Object) sb));
                    }
                    return new AutoValue_DirectionsResponse(str, this.message, this.waypoints, list, this.uuid, this.sessionId);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<DirectionsResponse> {
        private final Gson gson;
        private volatile TypeAdapter<List<DirectionsRoute>> list__directionsRoute_adapter;
        private volatile TypeAdapter<List<DirectionsWaypoint>> list__directionsWaypoint_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, DirectionsResponse directionsResponse) throws IOException {
            if (directionsResponse == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name(AccountsQueryParameters.CODE);
            if (directionsResponse.code() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter = this.string_adapter;
                if (adapter == null) {
                    adapter = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter;
                }
                adapter.write(jsonWriter, directionsResponse.code());
            }
            jsonWriter.name(StackTraceHelper.MESSAGE_KEY);
            if (directionsResponse.message() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter2 = this.string_adapter;
                if (adapter2 == null) {
                    adapter2 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter2;
                }
                adapter2.write(jsonWriter, directionsResponse.message());
            }
            jsonWriter.name("waypoints");
            if (directionsResponse.waypoints() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<DirectionsWaypoint>> adapter3 = this.list__directionsWaypoint_adapter;
                if (adapter3 == null) {
                    adapter3 = this.gson.getAdapter(TypeToken.getParameterized(List.class, DirectionsWaypoint.class));
                    this.list__directionsWaypoint_adapter = adapter3;
                }
                adapter3.write(jsonWriter, directionsResponse.waypoints());
            }
            jsonWriter.name("routes");
            if (directionsResponse.routes() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<DirectionsRoute>> adapter4 = this.list__directionsRoute_adapter;
                if (adapter4 == null) {
                    adapter4 = this.gson.getAdapter(TypeToken.getParameterized(List.class, DirectionsRoute.class));
                    this.list__directionsRoute_adapter = adapter4;
                }
                adapter4.write(jsonWriter, directionsResponse.routes());
            }
            jsonWriter.name(MediaRouteProviderProtocol.CLIENT_DATA_ROUTE_ID);
            if (directionsResponse.uuid() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter5 = this.string_adapter;
                if (adapter5 == null) {
                    adapter5 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter5;
                }
                adapter5.write(jsonWriter, directionsResponse.uuid());
            }
            jsonWriter.name("sessionId");
            if (directionsResponse.sessionId() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter6 = this.string_adapter;
                if (adapter6 == null) {
                    adapter6 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter6;
                }
                adapter6.write(jsonWriter, directionsResponse.sessionId());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: read */
        public DirectionsResponse read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            DirectionsResponse.Builder builder = DirectionsResponse.builder();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    strNextName.hashCode();
                    if (strNextName.equals("sessionId")) {
                        TypeAdapter<String> adapter = this.string_adapter;
                        if (adapter == null) {
                            adapter = this.gson.getAdapter(String.class);
                            this.string_adapter = adapter;
                        }
                        builder.sessionId(adapter.read2(jsonReader));
                    } else if (strNextName.equals(MediaRouteProviderProtocol.CLIENT_DATA_ROUTE_ID)) {
                        TypeAdapter<String> adapter2 = this.string_adapter;
                        if (adapter2 == null) {
                            adapter2 = this.gson.getAdapter(String.class);
                            this.string_adapter = adapter2;
                        }
                        builder.uuid(adapter2.read2(jsonReader));
                    } else if (AccountsQueryParameters.CODE.equals(strNextName)) {
                        TypeAdapter<String> adapter3 = this.string_adapter;
                        if (adapter3 == null) {
                            adapter3 = this.gson.getAdapter(String.class);
                            this.string_adapter = adapter3;
                        }
                        builder.code(adapter3.read2(jsonReader));
                    } else if (StackTraceHelper.MESSAGE_KEY.equals(strNextName)) {
                        TypeAdapter<String> adapter4 = this.string_adapter;
                        if (adapter4 == null) {
                            adapter4 = this.gson.getAdapter(String.class);
                            this.string_adapter = adapter4;
                        }
                        builder.message(adapter4.read2(jsonReader));
                    } else if ("waypoints".equals(strNextName)) {
                        TypeAdapter<List<DirectionsWaypoint>> adapter5 = this.list__directionsWaypoint_adapter;
                        if (adapter5 == null) {
                            adapter5 = this.gson.getAdapter(TypeToken.getParameterized(List.class, DirectionsWaypoint.class));
                            this.list__directionsWaypoint_adapter = adapter5;
                        }
                        builder.waypoints(adapter5.read2(jsonReader));
                    } else if ("routes".equals(strNextName)) {
                        TypeAdapter<List<DirectionsRoute>> adapter6 = this.list__directionsRoute_adapter;
                        if (adapter6 == null) {
                            adapter6 = this.gson.getAdapter(TypeToken.getParameterized(List.class, DirectionsRoute.class));
                            this.list__directionsRoute_adapter = adapter6;
                        }
                        builder.routes(adapter6.read2(jsonReader));
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return builder.build();
        }

        public String toString() {
            return "TypeAdapter(DirectionsResponse)";
        }
    }
}

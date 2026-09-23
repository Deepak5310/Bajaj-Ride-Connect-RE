package com.mappls.sdk.services.api.directionsrefresh.models;

import com.facebook.react.devsupport.StackTraceHelper;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mappls.sdk.services.api.directions.models.DirectionsRoute;
import com.spotify.sdk.android.auth.AccountsQueryParameters;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_DirectionsRefreshResponse extends C$AutoValue_DirectionsRefreshResponse {
    AutoValue_DirectionsRefreshResponse(String str, String str2, DirectionsRoute directionsRoute) {
        new DirectionsRefreshResponse(str, str2, directionsRoute) { // from class: com.mappls.sdk.services.api.directionsrefresh.models.$AutoValue_DirectionsRefreshResponse
            private final String code;
            private final String message;
            private final DirectionsRoute route;

            {
                if (str == null) {
                    throw new NullPointerException("Null code");
                }
                this.code = str;
                this.message = str2;
                this.route = directionsRoute;
            }

            @Override // com.mappls.sdk.services.api.directionsrefresh.models.DirectionsRefreshResponse
            public String code() {
                return this.code;
            }

            @Override // com.mappls.sdk.services.api.directionsrefresh.models.DirectionsRefreshResponse
            public String message() {
                return this.message;
            }

            @Override // com.mappls.sdk.services.api.directionsrefresh.models.DirectionsRefreshResponse
            public DirectionsRoute route() {
                return this.route;
            }

            public String toString() {
                return "DirectionsRefreshResponse{code=" + this.code + ", message=" + this.message + ", route=" + this.route + "}";
            }

            public boolean equals(Object obj) {
                String str3;
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof DirectionsRefreshResponse)) {
                    return false;
                }
                DirectionsRefreshResponse directionsRefreshResponse = (DirectionsRefreshResponse) obj;
                if (this.code.equals(directionsRefreshResponse.code()) && ((str3 = this.message) != null ? str3.equals(directionsRefreshResponse.message()) : directionsRefreshResponse.message() == null)) {
                    DirectionsRoute directionsRoute2 = this.route;
                    if (directionsRoute2 == null) {
                        if (directionsRefreshResponse.route() == null) {
                            return true;
                        }
                    } else if (directionsRoute2.equals(directionsRefreshResponse.route())) {
                        return true;
                    }
                }
                return false;
            }

            public int hashCode() {
                int iHashCode = (this.code.hashCode() ^ 1000003) * 1000003;
                String str3 = this.message;
                int iHashCode2 = (iHashCode ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
                DirectionsRoute directionsRoute2 = this.route;
                return iHashCode2 ^ (directionsRoute2 != null ? directionsRoute2.hashCode() : 0);
            }

            /* JADX INFO: renamed from: com.mappls.sdk.services.api.directionsrefresh.models.$AutoValue_DirectionsRefreshResponse$Builder */
            static class Builder extends DirectionsRefreshResponse.Builder {
                private String code;
                private String message;
                private DirectionsRoute route;

                Builder() {
                }

                @Override // com.mappls.sdk.services.api.directionsrefresh.models.DirectionsRefreshResponse.Builder
                public DirectionsRefreshResponse.Builder code(String str) {
                    if (str == null) {
                        throw new NullPointerException("Null code");
                    }
                    this.code = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directionsrefresh.models.DirectionsRefreshResponse.Builder
                public DirectionsRefreshResponse.Builder message(String str) {
                    this.message = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directionsrefresh.models.DirectionsRefreshResponse.Builder
                public DirectionsRefreshResponse.Builder route(DirectionsRoute directionsRoute) {
                    this.route = directionsRoute;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directionsrefresh.models.DirectionsRefreshResponse.Builder
                public DirectionsRefreshResponse build() {
                    String str = this.code;
                    if (str == null) {
                        throw new IllegalStateException("Missing required properties: code");
                    }
                    return new AutoValue_DirectionsRefreshResponse(str, this.message, this.route);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<DirectionsRefreshResponse> {
        private volatile TypeAdapter<DirectionsRoute> directionsRoute_adapter;
        private final Gson gson;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, DirectionsRefreshResponse directionsRefreshResponse) throws IOException {
            if (directionsRefreshResponse == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name(AccountsQueryParameters.CODE);
            if (directionsRefreshResponse.code() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter = this.string_adapter;
                if (adapter == null) {
                    adapter = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter;
                }
                adapter.write(jsonWriter, directionsRefreshResponse.code());
            }
            jsonWriter.name(StackTraceHelper.MESSAGE_KEY);
            if (directionsRefreshResponse.message() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter2 = this.string_adapter;
                if (adapter2 == null) {
                    adapter2 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter2;
                }
                adapter2.write(jsonWriter, directionsRefreshResponse.message());
            }
            jsonWriter.name(PlaceTypes.ROUTE);
            if (directionsRefreshResponse.route() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<DirectionsRoute> adapter3 = this.directionsRoute_adapter;
                if (adapter3 == null) {
                    adapter3 = this.gson.getAdapter(DirectionsRoute.class);
                    this.directionsRoute_adapter = adapter3;
                }
                adapter3.write(jsonWriter, directionsRefreshResponse.route());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: read */
        public DirectionsRefreshResponse read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            DirectionsRefreshResponse.Builder builder = DirectionsRefreshResponse.builder();
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
                    } else if (StackTraceHelper.MESSAGE_KEY.equals(strNextName)) {
                        TypeAdapter<String> adapter2 = this.string_adapter;
                        if (adapter2 == null) {
                            adapter2 = this.gson.getAdapter(String.class);
                            this.string_adapter = adapter2;
                        }
                        builder.message(adapter2.read2(jsonReader));
                    } else if (PlaceTypes.ROUTE.equals(strNextName)) {
                        TypeAdapter<DirectionsRoute> adapter3 = this.directionsRoute_adapter;
                        if (adapter3 == null) {
                            adapter3 = this.gson.getAdapter(DirectionsRoute.class);
                            this.directionsRoute_adapter = adapter3;
                        }
                        builder.route(adapter3.read2(jsonReader));
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return builder.build();
        }

        public String toString() {
            return "TypeAdapter(DirectionsRefreshResponse)";
        }
    }
}

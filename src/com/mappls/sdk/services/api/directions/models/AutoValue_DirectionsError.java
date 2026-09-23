package com.mappls.sdk.services.api.directions.models;

import com.facebook.react.devsupport.StackTraceHelper;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.spotify.sdk.android.auth.AccountsQueryParameters;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_DirectionsError extends C$AutoValue_DirectionsError {
    AutoValue_DirectionsError(final String str, final String str2) {
        new DirectionsError(str, str2) { // from class: com.mappls.sdk.services.api.directions.models.$AutoValue_DirectionsError
            private final String code;
            private final String message;

            {
                this.code = str;
                this.message = str2;
            }

            @Override // com.mappls.sdk.services.api.directions.models.DirectionsError
            public String code() {
                return this.code;
            }

            @Override // com.mappls.sdk.services.api.directions.models.DirectionsError
            public String message() {
                return this.message;
            }

            public String toString() {
                return "DirectionsError{code=" + this.code + ", message=" + this.message + "}";
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof DirectionsError)) {
                    return false;
                }
                DirectionsError directionsError = (DirectionsError) obj;
                String str3 = this.code;
                if (str3 != null ? str3.equals(directionsError.code()) : directionsError.code() == null) {
                    String str4 = this.message;
                    if (str4 == null) {
                        if (directionsError.message() == null) {
                            return true;
                        }
                    } else if (str4.equals(directionsError.message())) {
                        return true;
                    }
                }
                return false;
            }

            public int hashCode() {
                String str3 = this.code;
                int iHashCode = ((str3 == null ? 0 : str3.hashCode()) ^ 1000003) * 1000003;
                String str4 = this.message;
                return iHashCode ^ (str4 != null ? str4.hashCode() : 0);
            }

            @Override // com.mappls.sdk.services.api.directions.models.DirectionsError
            public DirectionsError.Builder toBuilder() {
                return new Builder(this);
            }

            /* JADX INFO: renamed from: com.mappls.sdk.services.api.directions.models.$AutoValue_DirectionsError$Builder */
            static class Builder extends DirectionsError.Builder {
                private String code;
                private String message;

                Builder() {
                }

                private Builder(DirectionsError directionsError) {
                    this.code = directionsError.code();
                    this.message = directionsError.message();
                }

                @Override // com.mappls.sdk.services.api.directions.models.DirectionsError.Builder
                public DirectionsError.Builder code(String str) {
                    this.code = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.DirectionsError.Builder
                public DirectionsError.Builder message(String str) {
                    this.message = str;
                    return this;
                }

                @Override // com.mappls.sdk.services.api.directions.models.DirectionsError.Builder
                public DirectionsError build() {
                    return new AutoValue_DirectionsError(this.code, this.message);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<DirectionsError> {
        private final Gson gson;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, DirectionsError directionsError) throws IOException {
            if (directionsError == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name(AccountsQueryParameters.CODE);
            if (directionsError.code() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter = this.string_adapter;
                if (adapter == null) {
                    adapter = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter;
                }
                adapter.write(jsonWriter, directionsError.code());
            }
            jsonWriter.name(StackTraceHelper.MESSAGE_KEY);
            if (directionsError.message() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> adapter2 = this.string_adapter;
                if (adapter2 == null) {
                    adapter2 = this.gson.getAdapter(String.class);
                    this.string_adapter = adapter2;
                }
                adapter2.write(jsonWriter, directionsError.message());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: read */
        public DirectionsError read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            DirectionsError.Builder builder = DirectionsError.builder();
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
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return builder.build();
        }

        public String toString() {
            return "TypeAdapter(DirectionsError)";
        }
    }
}

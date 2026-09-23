package com.mappls.sdk.services.api.directions.models;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DirectionsError implements Serializable {

    public static abstract class Builder {
        public abstract DirectionsError build();

        public abstract Builder code(String str);

        public abstract Builder message(String str);
    }

    public abstract String code();

    public abstract String message();

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new C$AutoValue_DirectionsError.Builder();
    }

    public static TypeAdapter<DirectionsError> typeAdapter(Gson gson) {
        return new AutoValue_DirectionsError.GsonTypeAdapter(gson);
    }
}

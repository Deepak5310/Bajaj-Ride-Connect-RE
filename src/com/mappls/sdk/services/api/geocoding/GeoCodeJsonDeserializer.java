package com.mappls.sdk.services.api.geocoding;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class GeoCodeJsonDeserializer implements JsonDeserializer<GeoCodeResponse> {
    private List<GeoCode> itemsContent = null;
    private GeoCode itemContent = null;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public GeoCodeResponse deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        Gson gsonCreate = new GsonBuilder().create();
        GeoCodeResponse geoCodeResponse = new GeoCodeResponse();
        JsonElement jsonElement2 = asJsonObject.get("copResults");
        if (jsonElement2.isJsonObject()) {
            this.itemContent = (GeoCode) gsonCreate.fromJson(jsonElement2, GeoCode.class);
        } else {
            this.itemsContent = (List) gsonCreate.fromJson(jsonElement2, new TypeToken<List<GeoCode>>() { // from class: com.mappls.sdk.services.api.geocoding.GeoCodeJsonDeserializer.1
            }.getType());
        }
        if (this.itemsContent == null && this.itemContent != null) {
            ArrayList arrayList = new ArrayList();
            this.itemsContent = arrayList;
            arrayList.add(this.itemContent);
        }
        geoCodeResponse.setResults(this.itemsContent);
        return geoCodeResponse;
    }
}

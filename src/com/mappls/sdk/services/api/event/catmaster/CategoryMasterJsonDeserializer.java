package com.mappls.sdk.services.api.event.catmaster;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.mappls.sdk.services.api.event.catmaster.model.ParentCategory;
import com.mappls.sdk.services.api.event.catmaster.model.ReportMasterResponse;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
class CategoryMasterJsonDeserializer implements JsonDeserializer<ReportMasterResponse> {
    CategoryMasterJsonDeserializer() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public ReportMasterResponse deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        Gson gsonCreate = new GsonBuilder().create();
        JsonObject asJsonObject2 = asJsonObject.getAsJsonObject("baseURLObj");
        JsonArray asJsonArray = asJsonObject.getAsJsonArray("parentCategories");
        if (asJsonArray != null && asJsonObject2 != null) {
            ArrayList arrayList = new ArrayList();
            ReportMasterResponse reportMasterResponse = new ReportMasterResponse();
            for (int i = 0; i < asJsonArray.size(); i++) {
                JsonObject asJsonObject3 = asJsonArray.get(i).getAsJsonObject();
                if (asJsonObject2.get("icon_url") != null && !asJsonObject2.get("icon_url").isJsonNull()) {
                    JsonArray asJsonArray2 = asJsonObject3.get("childCategories").getAsJsonArray();
                    asJsonObject3.addProperty("iconBaseUrl", asJsonObject2.get("icon_url").getAsString());
                    if (asJsonObject3.get("childCategories") != null && !asJsonObject3.get("childCategories").isJsonNull()) {
                        for (int i2 = 0; i2 < asJsonArray2.size(); i2++) {
                            JsonObject asJsonObject4 = asJsonArray2.get(i2).getAsJsonObject();
                            asJsonObject4.addProperty("iconBaseUrl", asJsonObject2.get("icon_url").getAsString());
                            if (asJsonObject4.get("subChildCategories") != null && !asJsonObject4.get("subChildCategories").isJsonNull()) {
                                JsonArray asJsonArray3 = asJsonObject4.get("subChildCategories").getAsJsonArray();
                                for (int i3 = 0; i3 < asJsonArray3.size(); i3++) {
                                    asJsonArray3.get(i3).getAsJsonObject().addProperty("iconBaseUrl", asJsonObject2.get("icon_url").getAsString());
                                }
                            }
                        }
                    }
                }
                arrayList.add((ParentCategory) gsonCreate.fromJson((JsonElement) asJsonObject3, ParentCategory.class));
            }
            reportMasterResponse.setParentCategories(arrayList);
        }
        return (ReportMasterResponse) gsonCreate.fromJson(jsonElement, type);
    }
}

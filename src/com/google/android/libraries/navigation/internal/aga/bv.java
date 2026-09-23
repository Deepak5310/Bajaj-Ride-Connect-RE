package com.google.android.libraries.navigation.internal.aga;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.logging.Logger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bv {
    public static final Logger a = Logger.getLogger(bv.class.getName());

    private bv() {
    }

    public static Object a(JsonReader jsonReader) throws IOException {
        com.google.android.libraries.navigation.internal.yx.ar.l(jsonReader.hasNext(), "unexpected end of JSON");
        switch (bu.a[jsonReader.peek().ordinal()]) {
            case 1:
                jsonReader.beginArray();
                ArrayList arrayList = new ArrayList();
                while (jsonReader.hasNext()) {
                    arrayList.add(a(jsonReader));
                }
                com.google.android.libraries.navigation.internal.yx.ar.l(jsonReader.peek() == JsonToken.END_ARRAY, "Bad token: ".concat(String.valueOf(jsonReader.getPath())));
                jsonReader.endArray();
                return Collections.unmodifiableList(arrayList);
            case 2:
                jsonReader.beginObject();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                while (jsonReader.hasNext()) {
                    String strNextName = jsonReader.nextName();
                    com.google.android.libraries.navigation.internal.yx.ar.f(!linkedHashMap.containsKey(strNextName), "Duplicate key found: %s", strNextName);
                    linkedHashMap.put(strNextName, a(jsonReader));
                }
                com.google.android.libraries.navigation.internal.yx.ar.l(jsonReader.peek() == JsonToken.END_OBJECT, "Bad token: ".concat(String.valueOf(jsonReader.getPath())));
                jsonReader.endObject();
                return Collections.unmodifiableMap(linkedHashMap);
            case 3:
                return jsonReader.nextString();
            case 4:
                return Double.valueOf(jsonReader.nextDouble());
            case 5:
                return Boolean.valueOf(jsonReader.nextBoolean());
            case 6:
                jsonReader.nextNull();
                return null;
            default:
                throw new IllegalStateException("Bad token: ".concat(String.valueOf(jsonReader.getPath())));
        }
    }
}

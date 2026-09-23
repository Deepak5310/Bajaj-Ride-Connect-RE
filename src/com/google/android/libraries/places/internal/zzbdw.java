package com.google.android.libraries.places.internal;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbdw {
    private static final Logger zza = Logger.getLogger(zzbdw.class.getName());

    private zzbdw() {
    }

    public static Object zza(String str) throws IOException {
        JsonReader jsonReader = new JsonReader(new StringReader(str));
        try {
            return zzb(jsonReader);
        } finally {
            try {
                jsonReader.close();
            } catch (IOException e) {
                zza.logp(Level.WARNING, "io.grpc.internal.JsonParser", "parse", "Failed to close", (Throwable) e);
            }
        }
    }

    private static Object zzb(JsonReader jsonReader) throws IOException {
        zzkt.zzo(jsonReader.hasNext(), "unexpected end of JSON");
        switch (zzbdv.zza[jsonReader.peek().ordinal()]) {
            case 1:
                jsonReader.beginArray();
                ArrayList arrayList = new ArrayList();
                while (jsonReader.hasNext()) {
                    arrayList.add(zzb(jsonReader));
                }
                zzkt.zzo(jsonReader.peek() == JsonToken.END_ARRAY, "Bad token: ".concat(String.valueOf(jsonReader.getPath())));
                jsonReader.endArray();
                return Collections.unmodifiableList(arrayList);
            case 2:
                jsonReader.beginObject();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                while (jsonReader.hasNext()) {
                    linkedHashMap.put(jsonReader.nextName(), zzb(jsonReader));
                }
                zzkt.zzo(jsonReader.peek() == JsonToken.END_OBJECT, "Bad token: ".concat(String.valueOf(jsonReader.getPath())));
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

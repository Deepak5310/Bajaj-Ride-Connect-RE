package com.bajajconnect.wifi.navv2;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.libraries.places.api.model.PlaceTypes;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class NavigationRecentTripsStore {
    private static final String KEY = "nav_v2_recent_trips_v1";
    private static final int MAX = 5;
    private static final String PREFS = "nav_v2_recent_trips";

    private NavigationRecentTripsStore() {
    }

    public static List<NavV2Models.IndexedPlace> load(Context context) {
        ArrayList arrayList = new ArrayList();
        if (context == null) {
            return arrayList;
        }
        try {
            String string = prefs(context).getString(KEY, "[]");
            JSONArray jSONArray = new JSONArray(string != null ? string : "[]");
            for (int i = 0; i < jSONArray.length() && arrayList.size() < 5; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("name", "");
                    if (!strOptString.trim().isEmpty()) {
                        arrayList.add(new NavV2Models.IndexedPlace(arrayList.size(), strOptString, jSONObjectOptJSONObject.optDouble("latitude", 0.0d), jSONObjectOptJSONObject.optDouble("longitude", 0.0d), jSONObjectOptJSONObject.optString(PlaceTypes.ADDRESS, strOptString)));
                    }
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public static void importTripsFromBridge(Context context, List<NavV2Models.IndexedPlace> list) {
        if (context == null || list == null || list.isEmpty() || !load(context).isEmpty()) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (NavV2Models.IndexedPlace indexedPlace : list) {
            if (indexedPlace != null && !indexedPlace.name.trim().isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("name", indexedPlace.name);
                    jSONObject.put("latitude", indexedPlace.latitude);
                    jSONObject.put("longitude", indexedPlace.longitude);
                    jSONObject.put(PlaceTypes.ADDRESS, indexedPlace.address.isEmpty() ? indexedPlace.name : indexedPlace.address);
                    jSONArray.put(jSONObject);
                } catch (Exception unused) {
                }
                if (jSONArray.length() >= 5) {
                    break;
                }
            }
        }
        prefs(context).edit().putString(KEY, jSONArray.toString()).apply();
    }

    public static void recordTrip(Context context, String str, double d, double d2, String str2) {
        if (context == null) {
            return;
        }
        String strTrim = str != null ? str.trim() : "";
        if (strTrim.isEmpty()) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (NavV2Models.IndexedPlace indexedPlace : load(context)) {
                if (!strTrim.equals(indexedPlace.name)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("name", indexedPlace.name);
                    jSONObject.put("latitude", indexedPlace.latitude);
                    jSONObject.put("longitude", indexedPlace.longitude);
                    jSONObject.put(PlaceTypes.ADDRESS, indexedPlace.address);
                    jSONArray.put(jSONObject);
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("name", strTrim);
            jSONObject2.put("latitude", d);
            jSONObject2.put("longitude", d2);
            if (str2 != null && !str2.isEmpty()) {
                strTrim = str2;
            }
            jSONObject2.put(PlaceTypes.ADDRESS, strTrim);
            jSONArray2.put(jSONObject2);
            for (int i = 0; i < jSONArray.length() && jSONArray2.length() < 5; i++) {
                jSONArray2.put(jSONArray.getJSONObject(i));
            }
            prefs(context).edit().putString(KEY, jSONArray2.toString()).apply();
        } catch (Exception unused) {
        }
    }

    private static SharedPreferences prefs(Context context) {
        return context.getApplicationContext().getSharedPreferences(PREFS, 0);
    }
}

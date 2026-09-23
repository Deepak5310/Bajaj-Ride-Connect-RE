package com.bajajconnect.gMaps.util;

import android.util.Log;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class GmapUtil {
    private static final String key = "AIzaSyAAlsCn_f-wXFxU00E2-iAukNMvcAUyoGM";

    public interface ResultListener<T> {
        void fail(String str);

        void success(T t);
    }

    public static String getApiKey() {
        return key;
    }

    public static void reverseGeoCode(String str, final ResultListener<String> resultListener) {
        String str2 = "https://maps.googleapis.com/maps/api/geocode/json?latlng=" + str + "&key=" + key;
        Log.e("GMapUtil", str2);
        FirebasePerfOkHttpClient.enqueue(new OkHttpClient().newCall(new Request.Builder().url(str2).build()), new Callback() { // from class: com.bajajconnect.gMaps.util.GmapUtil.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                iOException.printStackTrace();
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful()) {
                    try {
                        String strString = response.body().string();
                        Log.e("GmapUtil", strString.toString());
                        JSONArray jSONArray = new JSONObject(strString).getJSONArray("results");
                        if (jSONArray.length() > 0) {
                            String string = jSONArray.getJSONObject(0).getString("formatted_address");
                            Log.e("GmapUtil", string);
                            resultListener.success(string);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}

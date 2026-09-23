package com.mappls.sdk.geoanalytics;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.FeatureCollection;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.annotations.BubbleLayout;
import com.mappls.sdk.services.api.geocoding.GeoCodingCriteria;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: classes6.dex */
class f extends AsyncTask<FeatureCollection, Void, HashMap<String, Bitmap>> {
    private final HashMap<String, View> a = new HashMap<>();
    private final WeakReference<g> b;
    private MapView c;

    f(g gVar, MapView mapView) {
        this.b = new WeakReference<>(gVar);
        this.c = mapView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public HashMap<String, Bitmap> doInBackground(FeatureCollection... featureCollectionArr) {
        if (this.b.get() == null) {
            return null;
        }
        HashMap<String, Bitmap> map = new HashMap<>();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.c.getContext());
        FeatureCollection featureCollection = featureCollectionArr[0];
        if (featureCollection.features() != null) {
            for (Feature feature : featureCollection.features()) {
                BubbleLayout bubbleLayout = (BubbleLayout) layoutInflaterFrom.inflate(R.layout.mappls_geoanalytics_info_window, (ViewGroup) null);
                if (feature.hasProperty("properties")) {
                    JsonObject jsonObject = (JsonObject) feature.getProperty("properties");
                    String stringProperty = "name";
                    if (jsonObject != null) {
                        stringProperty = feature.hasProperty("id") ? feature.getStringProperty("id") : "name";
                        if (jsonObject.has("stt_nme") && !(jsonObject.get("stt_nme") instanceof JsonNull)) {
                            String asString = jsonObject.get("stt_nme").getAsString();
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_name)).setText("State Name: ");
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_name_value)).setText(asString);
                        }
                        if (jsonObject.has("dst_nme") && !(jsonObject.get("dst_nme") instanceof JsonNull)) {
                            String asString2 = jsonObject.get("dst_nme").getAsString();
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_name)).setText("District Name: ");
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_name_value)).setText(asString2);
                        }
                        if (jsonObject.has("sdb_nme") && !(jsonObject.get("sdb_nme") instanceof JsonNull)) {
                            String asString3 = jsonObject.get("sdb_nme").getAsString();
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_name)).setText("Sub District Name: ");
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_name_value)).setText(asString3);
                        }
                        if (jsonObject.has("loc_nme") && !(jsonObject.get("loc_nme") instanceof JsonNull)) {
                            String asString4 = jsonObject.get("loc_nme").getAsString();
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_name)).setText("Locality Name: ");
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_name_value)).setText(asString4);
                        }
                        if (jsonObject.has("pnc_nme") && !(jsonObject.get("pnc_nme") instanceof JsonNull)) {
                            String asString5 = jsonObject.get("pnc_nme").getAsString();
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_name)).setText("Panchayat Name: ");
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_name_value)).setText(asString5);
                        }
                        if (jsonObject.has("blk_nme") && !(jsonObject.get("blk_nme") instanceof JsonNull)) {
                            String asString6 = jsonObject.get("blk_nme").getAsString();
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_name)).setText("Block Name: ");
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_name_value)).setText(asString6);
                        }
                        if (jsonObject.has(GeoCodingCriteria.POD_PINCODE) && !(jsonObject.get(GeoCodingCriteria.POD_PINCODE) instanceof JsonNull)) {
                            String asString7 = jsonObject.get(GeoCodingCriteria.POD_PINCODE).getAsString();
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_name)).setText("Pincode: ");
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_name_value)).setText(asString7);
                        }
                        if (jsonObject.has("twn_nme") && !(jsonObject.get("twn_nme") instanceof JsonNull)) {
                            String asString8 = jsonObject.get("twn_nme").getAsString();
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_name)).setText("Town Name: ");
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_name_value)).setText(asString8);
                        }
                        if (jsonObject.has("city_nme") && !(jsonObject.get("city_nme") instanceof JsonNull)) {
                            String asString9 = jsonObject.get("city_nme").getAsString();
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_name)).setText("City Name: ");
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_name_value)).setText(asString9);
                        }
                        if (jsonObject.has("vil_nme") && !(jsonObject.get("vil_nme") instanceof JsonNull)) {
                            String asString10 = jsonObject.get("vil_nme").getAsString();
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_name)).setText("Village Name: ");
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_name_value)).setText(asString10);
                        }
                        if (jsonObject.has("subl_nme") && !(jsonObject.get("subl_nme") instanceof JsonNull)) {
                            String asString11 = jsonObject.get("subl_nme").getAsString();
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_name)).setText("Sub Locality Name: ");
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_name_value)).setText(asString11);
                        }
                        if (jsonObject.has("sslc_nme") && !(jsonObject.get("sslc_nme") instanceof JsonNull)) {
                            String asString12 = jsonObject.get("sslc_nme").getAsString();
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_name)).setText("Sub Sub Locality Name: ");
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_name_value)).setText(asString12);
                        }
                        if (jsonObject.has("stt_id") && !(jsonObject.get("stt_id") instanceof JsonNull)) {
                            long asLong = jsonObject.get("stt_id").getAsLong();
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_id)).setText("State Id: ");
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_id_value)).setText(asLong + "");
                        }
                        if (jsonObject.has("dst_id") && !(jsonObject.get("dst_id") instanceof JsonNull)) {
                            long asLong2 = jsonObject.get("dst_id").getAsLong();
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_id)).setText("District Id: ");
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_id_value)).setText(asLong2 + "");
                        }
                        if (jsonObject.has("sdb_id") && !(jsonObject.get("sdb_id") instanceof JsonNull)) {
                            long asLong3 = jsonObject.get("sdb_id").getAsLong();
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_id)).setText("Sub District Id: ");
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_id_value)).setText(asLong3 + "");
                        }
                        if (jsonObject.has("ward_no") && !(jsonObject.get("ward_no") instanceof JsonNull)) {
                            long asLong4 = jsonObject.get("ward_no").getAsLong();
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_id)).setText("Ward Number: ");
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_id_value)).setText(asLong4 + "");
                        }
                        if (jsonObject.has("loc_id") && !(jsonObject.get("loc_id") instanceof JsonNull)) {
                            long asLong5 = jsonObject.get("loc_id").getAsLong();
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_id)).setText("Locality Id: ");
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_id_value)).setText(asLong5 + "");
                        }
                        if (jsonObject.has("pnc_id") && !(jsonObject.get("pnc_id") instanceof JsonNull)) {
                            long asLong6 = jsonObject.get("pnc_id").getAsLong();
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_id)).setText("Panchayat Id: ");
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_id_value)).setText(asLong6 + "");
                        }
                        if (jsonObject.has("blk_id") && !(jsonObject.get("blk_id") instanceof JsonNull)) {
                            long asLong7 = jsonObject.get("blk_id").getAsLong();
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_id)).setText("Block Id: ");
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_id_value)).setText(asLong7 + "");
                        }
                        if (jsonObject.has("twn_id") && !(jsonObject.get("twn_id") instanceof JsonNull)) {
                            long asLong8 = jsonObject.get("twn_id").getAsLong();
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_id)).setText("Town Id: ");
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_id_value)).setText(asLong8 + "");
                        }
                        if (jsonObject.has("city_id") && !(jsonObject.get("city_id") instanceof JsonNull)) {
                            long asLong9 = jsonObject.get("city_id").getAsLong();
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_id)).setText("City Id: ");
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_id_value)).setText(asLong9 + "");
                        }
                        if (jsonObject.has("id") && !(jsonObject.get("id") instanceof JsonNull)) {
                            long asLong10 = jsonObject.get("id").getAsLong();
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_id)).setText("Village Id: ");
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_id_value)).setText(asLong10 + "");
                        }
                        if (jsonObject.has("subl_id") && !(jsonObject.get("subl_id") instanceof JsonNull)) {
                            long asLong11 = jsonObject.get("subl_id").getAsLong();
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_id)).setText("Sub Locality Id: ");
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_id_value)).setText(asLong11 + "");
                        }
                        if (jsonObject.has("sslc_id") && !(jsonObject.get("sslc_id") instanceof JsonNull)) {
                            long asLong12 = jsonObject.get("sslc_id").getAsLong();
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_id)).setText("Sub Sub Locality Id: ");
                            ((TextView) bubbleLayout.findViewById(R.id.tv_type_id_value)).setText(asLong12 + "");
                        }
                        if (!jsonObject.has("t_p") || (jsonObject.get("t_p") instanceof JsonNull)) {
                            bubbleLayout.findViewById(R.id.layout_pop).setVisibility(8);
                        } else {
                            bubbleLayout.findViewById(R.id.layout_pop).setVisibility(0);
                            ((TextView) bubbleLayout.findViewById(R.id.tv_population)).setText(jsonObject.get("t_p").getAsString());
                        }
                    }
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
                    bubbleLayout.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    bubbleLayout.setArrowPosition((bubbleLayout.getMeasuredWidth() / 2.0f) - 5.0f);
                    map.put(stringProperty, i.a(bubbleLayout));
                    this.a.put(stringProperty, bubbleLayout);
                }
            }
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(HashMap<String, Bitmap> map) {
        super.onPostExecute(map);
        g gVar = this.b.get();
        if (gVar == null || map == null) {
            return;
        }
        gVar.a(map);
        gVar.c();
    }
}

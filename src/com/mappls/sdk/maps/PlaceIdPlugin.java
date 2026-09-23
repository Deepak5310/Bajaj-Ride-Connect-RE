package com.mappls.sdk.maps;

import com.google.gson.JsonObject;
import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.maps.geometry.LatLng;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class PlaceIdPlugin implements MapplsMap.OnMapClickListener {
    private static final String[] LAYER_ID = {"Health & Wellness7", "General3", "Shopping6", "Shopping5", "Automotive3", "Automotive2", "General2", "Shopping4", "Shopping3", "Commercial & Industrial2", "Financial_Services3", "Community_Services12", "Financial_Services1", "Financial_Services2", "Health & Wellness6", "Transportation10", "Transportation9", "Transportation8", "Transportation7", "Health & Wellness5", "Health & Wellness4", "Community_Services11", "Community_Services10", "Health & Wellness3", "Restaurant&Dining3", "Community_Services9", "Community_Services8", "Recreation&Entertainment10", "Community_Services7", "Recreation&Entertainment9", "Recreation&Entertainment8", "Recreation&Entertainment7", "Community_Services6", "Automotive1", "Community_Services5", "Hotels&Dining4", "Restaurant&Dining2", "Recreation&Entertainment5", "Recreation&Entertainment6", "Recreation&Entertainment4", "Transportation6", "Shopping2", "General1", "admin_label7", "Transportation5", "Health & Wellness2", "Commercial & Industrial1", "Residential2", "Community_Services4", "Community_Services2", "admin4_label", "admin4_label_z12", "Restaurant&Dining1", "Recreation&Entertainment3", "Nature4", "Community_Services3", "Recreation&Entertainment2", "admin5_label", "PilgrimPlaces1", "Residential1", "Health & Wellness1", "Hotels&Dining3", "Admin5_label", "Nature3", "Hotels&Dining2", "Hotels&Dining1", "Shopping1", "Historical Places1", "Transportation4", "Recreation&Entertainment1", "admin4_other_label", "admin4_minor_label", "admin4_major_label", "admin4_Imp_Loc_label", "Nature2", "Community_Services1", "Nature1", "poi_TRNMON", "poi_TRNMET", "Transportation3", "Transportation2", "admin4_major_label2", "admin4_major_label3", "admin4_major_label4", "admin4_imp_city_label", "Transportation1", "admin9_major_label", "Admin3__label", "Admin2__label", "city_centre_cc", "city_centre_delhi", "city_centre_delhinoicon", "city_centre_sc_hyderabad", "label_mapmyindia", "India Gate", "statue_boss", "national_war_memorial", "red_fort", "Qutub_Minar", "Gateway_of_India", "Lotus_Temple", "Akshardham", "Taj_Mahal", "Buddha_statue", "statue_of_unity", "admin_embassy", "Housenumber_label", "House_Name", "Admin_misc1", "Admin_misc2", "Admin_misc3", "Admin_misc4", "Admin_misc5", "Admin_misc6", "Admin_misc7", "Admin_misc8", "Poi_misc1", "Poi_misc2", "Poi_misc3", "Poi_misc4", "Poi_misc5", "Poi_misc6", "Poi_misc7", "Poi_misc8", "Poi_misc9", "Poi_misc10"};
    private MapplsMap mapplsMap;
    private OnPlaceClickListener onPlaceClickListener;

    PlaceIdPlugin(MapplsMap mapplsMap) {
        this.mapplsMap = mapplsMap;
        mapplsMap.addOnMapClickListener(this);
    }

    void setOnPlaceClickListener(OnPlaceClickListener onPlaceClickListener) {
        this.onPlaceClickListener = onPlaceClickListener;
    }

    @Override // com.mappls.sdk.maps.MapplsMap.OnMapClickListener
    public boolean onMapClick(LatLng latLng) {
        if (this.onPlaceClickListener == null) {
            return false;
        }
        List<Feature> listQueryRenderedFeatures = this.mapplsMap.queryRenderedFeatures(this.mapplsMap.getProjection().toScreenLocation(latLng), new String[0]);
        ArrayList arrayList = new ArrayList();
        for (Feature feature : listQueryRenderedFeatures) {
            if (feature.geometry() instanceof Point) {
                arrayList.add(feature);
            }
        }
        if (arrayList.size() > 0) {
            JsonObject jsonObjectProperties = ((Feature) arrayList.get(arrayList.size() - 1)).properties();
            if (jsonObjectProperties != null && jsonObjectProperties.size() > 0) {
                String asString = (!jsonObjectProperties.has("ELOC") || jsonObjectProperties.get("ELOC").isJsonNull()) ? null : jsonObjectProperties.get("ELOC").getAsString();
                if (jsonObjectProperties.has("name_en") && !jsonObjectProperties.get("name_en").isJsonNull()) {
                    jsonObjectProperties.get("name_en").getAsString();
                }
                if (asString == null) {
                    asString = (!jsonObjectProperties.has("eLoc") || jsonObjectProperties.get("eLoc").isJsonNull()) ? null : jsonObjectProperties.get("eLoc").getAsString();
                }
                if (asString == null) {
                    asString = (!jsonObjectProperties.has("placeId") || jsonObjectProperties.get("placeId").isJsonNull()) ? null : jsonObjectProperties.get("placeId").getAsString();
                }
                if (asString != null) {
                    return this.onPlaceClickListener.onPlaceClick(asString);
                }
                this.onPlaceClickListener.onPlaceClick(null);
            }
        } else {
            this.onPlaceClickListener.onPlaceClick(null);
        }
        return false;
    }
}

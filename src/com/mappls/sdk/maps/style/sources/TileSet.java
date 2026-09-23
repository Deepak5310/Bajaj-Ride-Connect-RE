package com.mappls.sdk.maps.style.sources;

import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.navigation.util.SavingTrackHelper;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class TileSet {
    private String attribution;
    private Float[] bounds;
    private Float[] center;
    private String[] data;
    private String description;
    private String encoding;
    private String[] grids;
    private String legend;
    private Float maxZoom;
    private Float minZoom;
    private String name;
    private String scheme;
    private String template;
    private final String tilejson;
    private final String[] tiles;
    private String version;

    public TileSet(String str, String... strArr) {
        this.tilejson = str;
        this.tiles = strArr;
    }

    public String getTilejson() {
        return this.tilejson;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String getAttribution() {
        return this.attribution;
    }

    public void setAttribution(String str) {
        this.attribution = str;
    }

    public String getTemplate() {
        return this.template;
    }

    public void setTemplate(String str) {
        this.template = str;
    }

    public String getLegend() {
        return this.legend;
    }

    public void setLegend(String str) {
        this.legend = str;
    }

    public String getScheme() {
        return this.scheme;
    }

    public void setScheme(String str) {
        this.scheme = str;
    }

    public String[] getTiles() {
        return this.tiles;
    }

    public String[] getGrids() {
        return this.grids;
    }

    public void setGrids(String... strArr) {
        this.grids = strArr;
    }

    public String[] getData() {
        return this.data;
    }

    public void setData(String... strArr) {
        this.data = strArr;
    }

    public float getMinZoom() {
        return this.minZoom.floatValue();
    }

    public void setMinZoom(float f) {
        this.minZoom = Float.valueOf(f);
    }

    public float getMaxZoom() {
        return this.maxZoom.floatValue();
    }

    public void setMaxZoom(float f) {
        this.maxZoom = Float.valueOf(f);
    }

    public Float[] getBounds() {
        return this.bounds;
    }

    public void setBounds(Float... fArr) {
        this.bounds = fArr;
    }

    public String getEncoding() {
        return this.encoding;
    }

    public void setEncoding(String str) {
        this.encoding = str;
    }

    public Float[] getCenter() {
        return this.center;
    }

    public void setCenter(Float... fArr) {
        this.center = fArr;
    }

    public void setCenter(LatLng latLng) {
        this.center = new Float[]{Float.valueOf((float) latLng.getLongitude()), Float.valueOf((float) latLng.getLatitude())};
    }

    Map<String, Object> toValueObject() {
        HashMap map = new HashMap();
        map.put("tilejson", this.tilejson);
        map.put("tiles", this.tiles);
        String str = this.name;
        if (str != null) {
            map.put("name", str);
        }
        String str2 = this.description;
        if (str2 != null) {
            map.put(SavingTrackHelper.POINT_COL_DESCRIPTION, str2);
        }
        String str3 = this.version;
        if (str3 != null) {
            map.put("version", str3);
        }
        String str4 = this.attribution;
        if (str4 != null) {
            map.put("attribution", str4);
        }
        String str5 = this.template;
        if (str5 != null) {
            map.put("template", str5);
        }
        String str6 = this.legend;
        if (str6 != null) {
            map.put("legend", str6);
        }
        String str7 = this.scheme;
        if (str7 != null) {
            map.put("scheme", str7);
        }
        String[] strArr = this.grids;
        if (strArr != null) {
            map.put("grids", strArr);
        }
        String[] strArr2 = this.data;
        if (strArr2 != null) {
            map.put("data", strArr2);
        }
        Float f = this.minZoom;
        if (f != null) {
            map.put("minzoom", f);
        }
        Float f2 = this.maxZoom;
        if (f2 != null) {
            map.put("maxzoom", f2);
        }
        Float[] fArr = this.bounds;
        if (fArr != null) {
            map.put("bounds", fArr);
        }
        Float[] fArr2 = this.center;
        if (fArr2 != null) {
            map.put("center", fArr2);
        }
        String str8 = this.encoding;
        if (str8 != null) {
            map.put("encoding", str8);
        }
        return map;
    }
}

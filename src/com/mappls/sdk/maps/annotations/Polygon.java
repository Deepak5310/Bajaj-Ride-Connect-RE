package com.mappls.sdk.maps.annotations;

import androidx.core.view.ViewCompat;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.geometry.LatLng;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class Polygon extends BasePointCollection {
    private int fillColor = ViewCompat.MEASURED_STATE_MASK;
    private int strokeColor = ViewCompat.MEASURED_STATE_MASK;
    private List<List<LatLng>> holes = new ArrayList();

    Polygon() {
    }

    public int getFillColor() {
        return this.fillColor;
    }

    public int getStrokeColor() {
        return this.strokeColor;
    }

    public List<List<LatLng>> getHoles() {
        return new ArrayList(this.holes);
    }

    public void setFillColor(int i) {
        this.fillColor = i;
        update();
    }

    public void setStrokeColor(int i) {
        this.strokeColor = i;
        update();
    }

    public void setHoles(List<? extends List<LatLng>> list) {
        this.holes = new ArrayList(list);
        update();
    }

    void addHole(List<LatLng> list) {
        this.holes.add(list);
        update();
    }

    @Override // com.mappls.sdk.maps.annotations.BasePointCollection
    void update() {
        MapplsMap mapplsMap = getMapplsMap();
        if (mapplsMap != null) {
            mapplsMap.updatePolygon(this);
        }
    }
}

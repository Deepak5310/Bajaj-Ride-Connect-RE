package com.mappls.sdk.maps.annotations;

import androidx.core.view.ViewCompat;
import com.mappls.sdk.maps.MapplsMap;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class Polyline extends BasePointCollection {
    private int color = ViewCompat.MEASURED_STATE_MASK;
    private float width = 10.0f;

    Polyline() {
    }

    public int getColor() {
        return this.color;
    }

    public float getWidth() {
        return this.width;
    }

    public void setColor(int i) {
        this.color = i;
        update();
    }

    public void setWidth(float f) {
        this.width = f;
        update();
    }

    @Override // com.mappls.sdk.maps.annotations.BasePointCollection
    void update() {
        MapplsMap mapplsMap = getMapplsMap();
        if (mapplsMap != null) {
            mapplsMap.updatePolyline(this);
        }
    }
}

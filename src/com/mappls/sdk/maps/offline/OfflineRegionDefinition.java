package com.mappls.sdk.maps.offline;

import android.os.Parcelable;
import com.mappls.sdk.maps.geometry.LatLngBounds;

/* JADX INFO: loaded from: classes4.dex */
public interface OfflineRegionDefinition extends Parcelable {
    LatLngBounds getBounds();

    boolean getIncludeIdeographs();

    double getMaxZoom();

    double getMinZoom();

    float getPixelRatio();

    String getStyleURL();

    String getType();
}

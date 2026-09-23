package com.mappls.sdk.navigation.ui.map;

import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.navigation.ui.R;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public final MapplsMap a;
    public final int[] b;

    public a(MapView mapView, MapplsMap mapplsMap) {
        this.a = mapplsMap;
        this.b = new int[]{0, (mapView.getHeight() - (((int) mapView.getContext().getResources().getDimension(R.dimen.summary_bottomsheet_height)) * 4)) - (((int) mapView.getContext().getResources().getDimension(R.dimen.wayname_view_height)) * 2), 0, 0};
    }

    public final void a(int[] iArr) {
        this.a.setPadding(iArr[0], iArr[1], iArr[2], iArr[3]);
    }
}

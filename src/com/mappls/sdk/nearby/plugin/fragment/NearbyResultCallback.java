package com.mappls.sdk.nearby.plugin.fragment;

import com.mappls.sdk.services.api.nearby.model.NearbyAtlasResult;

/* JADX INFO: loaded from: classes4.dex */
public interface NearbyResultCallback {
    void onLocationClick();

    void onNearbyResultClick(NearbyAtlasResult nearbyAtlasResult);
}

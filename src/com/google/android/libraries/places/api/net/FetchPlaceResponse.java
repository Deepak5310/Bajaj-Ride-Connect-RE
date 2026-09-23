package com.google.android.libraries.places.api.net;

import com.google.android.libraries.places.api.model.Place;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class FetchPlaceResponse {
    public static FetchPlaceResponse newInstance(Place place) {
        return new zzh(place);
    }

    public abstract Place getPlace();
}

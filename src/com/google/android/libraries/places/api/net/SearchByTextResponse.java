package com.google.android.libraries.places.api.net;

import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.internal.zzlx;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class SearchByTextResponse {
    public static SearchByTextResponse newInstance(List<Place> list) {
        return new zzx(zzlx.zzj(list));
    }

    public abstract List<Place> getPlaces();
}

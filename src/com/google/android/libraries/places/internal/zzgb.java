package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzgb extends zzgo {
    zzgb(FetchPlaceRequest fetchPlaceRequest, Locale locale, String str, boolean z, zzij zzijVar) {
        super(fetchPlaceRequest, locale, str, false, zzijVar);
    }

    @Override // com.google.android.libraries.places.internal.zzgo
    protected final String zze() {
        return "details/json";
    }

    @Override // com.google.android.libraries.places.internal.zzgo
    public final Map zzf() {
        FetchPlaceRequest fetchPlaceRequest = (FetchPlaceRequest) zzb();
        HashMap map = new HashMap();
        zzg(map, "placeid", fetchPlaceRequest.getPlaceId(), null);
        zzg(map, "sessiontoken", fetchPlaceRequest.getSessionToken(), null);
        zzg(map, "fields", zzhh.zza(fetchPlaceRequest.getPlaceFields()), null);
        return map;
    }
}

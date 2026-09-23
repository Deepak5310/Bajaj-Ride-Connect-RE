package com.google.android.libraries.places.internal;

import android.location.Location;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mappls.sdk.navigation.NavigationConstants;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzgj extends zzgo {
    private final Location zza;
    private final zzlx zzb;

    zzgj(FindCurrentPlaceRequest findCurrentPlaceRequest, Location location, zzlx zzlxVar, Locale locale, String str, boolean z, zzij zzijVar) {
        super(findCurrentPlaceRequest, locale, str, false, zzijVar);
        this.zza = location;
        this.zzb = zzlxVar;
    }

    @Override // com.google.android.libraries.places.internal.zzgo
    protected final String zze() {
        return "findplacefromuserlocation/json";
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0028  */
    @Override // com.google.android.libraries.places.internal.zzgo
    public final Map zzf() {
        Integer numValueOf;
        FindCurrentPlaceRequest findCurrentPlaceRequest = (FindCurrentPlaceRequest) zzb();
        HashMap map = new HashMap();
        zzg(map, FirebaseAnalytics.Param.LOCATION, zzhg.zza(this.zza), null);
        zzg(map, "wifiaccesspoints", zzhg.zze(this.zzb, NavigationConstants.UI_HANDLER_MAP_CONTROLS), null);
        Location location = this.zza;
        if (location == null) {
            numValueOf = null;
        } else {
            float accuracy = location.getAccuracy();
            if (!location.hasAccuracy() || accuracy <= 0.0f) {
                numValueOf = null;
            } else {
                numValueOf = Integer.valueOf(Math.round(accuracy * 100.0f));
            }
        }
        zzg(map, "precision", numValueOf, null);
        zzg(map, "timestamp", Long.valueOf(this.zza.getTime()), null);
        zzg(map, "fields", zzhh.zza(findCurrentPlaceRequest.getPlaceFields()), null);
        return map;
    }
}

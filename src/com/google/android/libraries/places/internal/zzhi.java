package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.android.libraries.places.api.model.TypeFilter;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzhi {
    private static final zzma zza;

    static {
        zzlz zzlzVar = new zzlz();
        zzlzVar.zza(TypeFilter.ADDRESS, PlaceTypes.ADDRESS);
        zzlzVar.zza(TypeFilter.CITIES, PlaceTypes.CITIES);
        zzlzVar.zza(TypeFilter.ESTABLISHMENT, PlaceTypes.ESTABLISHMENT);
        zzlzVar.zza(TypeFilter.GEOCODE, PlaceTypes.GEOCODE);
        zzlzVar.zza(TypeFilter.REGIONS, PlaceTypes.REGIONS);
        zza = zzlzVar.zzc();
    }

    public static String zza(TypeFilter typeFilter) {
        String str = (String) zza.get(typeFilter);
        return str == null ? "" : str;
    }
}

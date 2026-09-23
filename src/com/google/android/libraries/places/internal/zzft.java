package com.google.android.libraries.places.internal;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.model.CircularBounds;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.RectangularBounds;
import com.google.android.libraries.places.api.net.SearchByTextRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzft {
    static final zzft zza = new zzft();

    private zzft() {
    }

    static final zzalr zza(SearchByTextRequest searchByTextRequest, Locale locale) {
        zzalm zzalmVarZza = zzalr.zza();
        String includedType = searchByTextRequest.getIncludedType();
        if (includedType != null) {
            zzalmVarZza.zzb(includedType);
        }
        LocationBias locationBias = searchByTextRequest.getLocationBias();
        if (locationBias != null) {
            boolean z = locationBias instanceof RectangularBounds;
            zzkt.zzf(z || (locationBias instanceof CircularBounds), "LocationBias must be of type RectangularBounds or CircularBounds.");
            zzaln zzalnVarZza = zzalo.zza();
            if (z) {
                zzalnVarZza.zzb(zzb((RectangularBounds) locationBias));
            } else {
                CircularBounds circularBounds = (CircularBounds) locationBias;
                LatLng center = circularBounds.getCenter();
                zzajh zzajhVarZza = zzaji.zza();
                zzarh zzarhVarZzd = zzari.zzd();
                zzarhVarZzd.zza(center.latitude);
                zzarhVarZzd.zzb(center.longitude);
                zzajhVarZza.zza(zzarhVarZzd);
                zzajhVarZza.zzb(circularBounds.getRadius());
                zzalnVarZza.zza((zzaji) zzajhVarZza.zzq());
            }
            zzalmVarZza.zzd((zzalo) zzalnVarZza.zzq());
        }
        LocationRestriction locationRestriction = searchByTextRequest.getLocationRestriction();
        if (locationRestriction != null) {
            zzkt.zzf(locationRestriction instanceof RectangularBounds, "LocationRestriction must be of type RectangularBounds.");
            zzalp zzalpVarZza = zzalq.zza();
            zzalpVarZza.zza(zzb((RectangularBounds) locationRestriction));
            zzalmVarZza.zze((zzalq) zzalpVarZza.zzq());
        }
        Integer maxResultCount = searchByTextRequest.getMaxResultCount();
        if (maxResultCount != null) {
            zzalmVarZza.zzf(maxResultCount.intValue());
        }
        Double minRating = searchByTextRequest.getMinRating();
        if (minRating != null) {
            zzalmVarZza.zzg(minRating.doubleValue());
        }
        zzalmVarZza.zzh(searchByTextRequest.isOpenNow());
        List<Integer> priceLevels = searchByTextRequest.getPriceLevels();
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it2 = priceLevels.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            int iIntValue = it2.next().intValue();
            if (iIntValue == 0) {
                arrayList.add(zzalh.PRICE_LEVEL_FREE);
            } else if (iIntValue == 1) {
                arrayList.add(zzalh.PRICE_LEVEL_INEXPENSIVE);
            } else if (iIntValue == 2) {
                arrayList.add(zzalh.PRICE_LEVEL_MODERATE);
            } else if (iIntValue == 3) {
                arrayList.add(zzalh.PRICE_LEVEL_EXPENSIVE);
            } else if (iIntValue == 4) {
                arrayList.add(zzalh.PRICE_LEVEL_VERY_EXPENSIVE);
            }
        }
        zzalmVarZza.zza(arrayList);
        zzalmVarZza.zzl(true != searchByTextRequest.getRankPreference().equals(SearchByTextRequest.RankPreference.RELEVANCE) ? 3 : 4);
        String regionCode = searchByTextRequest.getRegionCode();
        if (regionCode != null) {
            zzalmVarZza.zzi(regionCode);
        }
        zzalmVarZza.zzj(searchByTextRequest.isStrictTypeFiltering());
        zzalmVarZza.zzk(searchByTextRequest.getTextQuery());
        zzalmVarZza.zzc(locale.toLanguageTag());
        return (zzalr) zzalmVarZza.zzq();
    }

    private static final zzahw zzb(RectangularBounds rectangularBounds) {
        LatLng southwest = rectangularBounds.getSouthwest();
        LatLng northeast = rectangularBounds.getNortheast();
        zzahv zzahvVarZza = zzahw.zza();
        zzarh zzarhVarZzd = zzari.zzd();
        zzarhVarZzd.zza(southwest.latitude);
        zzarhVarZzd.zzb(southwest.longitude);
        zzahvVarZza.zzb((zzari) zzarhVarZzd.zzq());
        zzarh zzarhVarZzd2 = zzari.zzd();
        zzarhVarZzd2.zza(northeast.latitude);
        zzarhVarZzd2.zzb(northeast.longitude);
        zzahvVarZza.zza((zzari) zzarhVarZzd2.zzq());
        return (zzahw) zzahvVarZza.zzq();
    }
}

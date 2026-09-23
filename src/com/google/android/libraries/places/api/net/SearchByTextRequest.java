package com.google.android.libraries.places.api.net;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.internal.zzhx;
import com.google.android.libraries.places.internal.zzkt;
import com.google.android.libraries.places.internal.zzlx;
import com.google.android.libraries.places.internal.zzmk;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class SearchByTextRequest implements zzhx {

    /* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
    public static abstract class Builder {
        public SearchByTextRequest build() {
            setPlaceFields(zzlx.zzj(getPlaceFields()));
            setPriceLevels(zzlx.zzj(getPriceLevels()));
            Double minRating = getMinRating();
            Double dValueOf = Double.valueOf(5.0d);
            Double dValueOf2 = Double.valueOf(1.0d);
            if (minRating != null) {
                zzkt.zzl(minRating.doubleValue() >= 1.0d && minRating.doubleValue() <= 5.0d, "Min rating must not be out of range of %s to %s, but was: %s.", dValueOf2, dValueOf, minRating);
            }
            List<Integer> priceLevels = getPriceLevels();
            if (!priceLevels.isEmpty()) {
                for (Integer num : priceLevels) {
                    zzkt.zzl(zzmk.zzb(0, 4).zzd(num), "Price level must not be out of range of %s to %s, but was: %s.", dValueOf2, dValueOf, num);
                }
            }
            return zza();
        }

        public abstract CancellationToken getCancellationToken();

        public abstract String getIncludedType();

        public abstract LocationBias getLocationBias();

        public abstract LocationRestriction getLocationRestriction();

        public abstract Integer getMaxResultCount();

        public abstract Double getMinRating();

        public abstract List<Place.Field> getPlaceFields();

        public abstract List<Integer> getPriceLevels();

        public abstract RankPreference getRankPreference();

        public abstract String getRegionCode();

        public abstract String getTextQuery();

        public abstract boolean isOpenNow();

        public abstract boolean isStrictTypeFiltering();

        public abstract Builder setCancellationToken(CancellationToken cancellationToken);

        public abstract Builder setIncludedType(String str);

        public abstract Builder setLocationBias(LocationBias locationBias);

        public abstract Builder setLocationRestriction(LocationRestriction locationRestriction);

        public abstract Builder setMaxResultCount(Integer num);

        public abstract Builder setMinRating(Double d);

        public abstract Builder setOpenNow(boolean z);

        public abstract Builder setPlaceFields(List<Place.Field> list);

        public abstract Builder setPriceLevels(List<Integer> list);

        public abstract Builder setRankPreference(RankPreference rankPreference);

        public abstract Builder setRegionCode(String str);

        public abstract Builder setStrictTypeFiltering(boolean z);

        public abstract Builder setTextQuery(String str);

        abstract SearchByTextRequest zza();
    }

    /* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
    public enum RankPreference {
        DISTANCE,
        RELEVANCE
    }

    public static Builder builder(String str, List<Place.Field> list) {
        zzu zzuVar = new zzu();
        zzuVar.setOpenNow(false);
        zzuVar.setPlaceFields(list);
        zzuVar.setPriceLevels(new ArrayList());
        zzuVar.setTextQuery(str);
        zzuVar.setRankPreference(RankPreference.DISTANCE);
        zzuVar.setStrictTypeFiltering(false);
        return zzuVar;
    }

    public static SearchByTextRequest newInstance(String str, List<Place.Field> list) {
        return builder(str, list).build();
    }

    public abstract String getIncludedType();

    public abstract LocationBias getLocationBias();

    public abstract LocationRestriction getLocationRestriction();

    public abstract Integer getMaxResultCount();

    public abstract Double getMinRating();

    public abstract List<Place.Field> getPlaceFields();

    public abstract List<Integer> getPriceLevels();

    public abstract RankPreference getRankPreference();

    public abstract String getRegionCode();

    public abstract String getTextQuery();

    public abstract boolean isOpenNow();

    public abstract boolean isStrictTypeFiltering();
}

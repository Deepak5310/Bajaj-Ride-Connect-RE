package com.google.android.libraries.places.api.net;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.internal.zzhx;
import com.google.android.libraries.places.internal.zzlx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class FindAutocompletePredictionsRequest implements zzhx {

    /* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
    public static abstract class Builder {
        public FindAutocompletePredictionsRequest build() {
            setCountries(zzlx.zzj(getCountries()));
            setTypesFilter(zzlx.zzj(getTypesFilter()));
            return zza();
        }

        public abstract CancellationToken getCancellationToken();

        public abstract List<String> getCountries();

        public abstract LocationBias getLocationBias();

        public abstract LocationRestriction getLocationRestriction();

        public abstract LatLng getOrigin();

        public abstract String getQuery();

        public abstract AutocompleteSessionToken getSessionToken();

        @Deprecated
        public abstract TypeFilter getTypeFilter();

        public abstract List<String> getTypesFilter();

        public abstract Builder setCancellationToken(CancellationToken cancellationToken);

        public abstract Builder setCountries(List<String> list);

        public Builder setCountries(String... strArr) {
            return setCountries(zzlx.zzk(strArr));
        }

        @Deprecated
        public Builder setCountry(String str) {
            setCountries(str == null ? zzlx.zzl() : zzlx.zzm(str));
            return this;
        }

        public abstract Builder setLocationBias(LocationBias locationBias);

        public abstract Builder setLocationRestriction(LocationRestriction locationRestriction);

        public abstract Builder setOrigin(LatLng latLng);

        public abstract Builder setQuery(String str);

        public abstract Builder setSessionToken(AutocompleteSessionToken autocompleteSessionToken);

        @Deprecated
        public abstract Builder setTypeFilter(TypeFilter typeFilter);

        public abstract Builder setTypesFilter(List<String> list);

        abstract FindAutocompletePredictionsRequest zza();
    }

    public static Builder builder() {
        zzi zziVar = new zzi();
        zziVar.setCountries(new ArrayList());
        zziVar.setTypesFilter(new ArrayList());
        return zziVar;
    }

    public static FindAutocompletePredictionsRequest newInstance(String str) {
        Builder builder = builder();
        builder.setQuery(str);
        return builder.build();
    }

    @Override // com.google.android.libraries.places.internal.zzhx
    public abstract CancellationToken getCancellationToken();

    public abstract List<String> getCountries();

    @Deprecated
    public String getCountry() {
        if (getCountries().size() > 1) {
            throw new UnsupportedOperationException("Multiple countries found in this request - use getCountries() instead of getCountry().");
        }
        Iterator<T> it2 = getCountries().iterator();
        return (String) (it2.hasNext() ? it2.next() : null);
    }

    public abstract LocationBias getLocationBias();

    public abstract LocationRestriction getLocationRestriction();

    public abstract LatLng getOrigin();

    public abstract String getQuery();

    public abstract AutocompleteSessionToken getSessionToken();

    @Deprecated
    public abstract TypeFilter getTypeFilter();

    public abstract List<String> getTypesFilter();
}

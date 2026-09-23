package com.google.android.libraries.places.widget;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.TypedValue;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.internal.zzif;
import com.google.android.libraries.places.internal.zzis;
import com.google.android.libraries.places.internal.zzit;
import com.google.android.libraries.places.internal.zziu;
import com.google.android.libraries.places.internal.zzix;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class Autocomplete {

    /* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
    public static class IntentBuilder {
        private final zzit zza;

        public IntentBuilder(zziu zziuVar) {
            this.zza = zziuVar.zzg();
        }

        public IntentBuilder(AutocompleteActivityMode autocompleteActivityMode, List<Place.Field> list) {
            this.zza = zziu.zzn(autocompleteActivityMode, list, zzis.INTENT);
        }

        public Intent build(Context context) {
            try {
                Intent intent = new Intent(context, (Class<?>) AutocompleteActivity.class);
                zzit zzitVar = this.zza;
                Resources.Theme theme = context.getTheme();
                TypedValue typedValue = new TypedValue();
                if (theme.resolveAttribute(R.attr.colorPrimary, typedValue, true)) {
                    zzitVar.zzi(typedValue.data);
                }
                TypedValue typedValue2 = new TypedValue();
                if (theme.resolveAttribute(R.attr.colorPrimaryDark, typedValue2, true)) {
                    zzitVar.zzj(typedValue2.data);
                }
                intent.putExtra("places/AutocompleteOptions", this.zza.zzm());
                return intent;
            } catch (Error | RuntimeException e) {
                zzif.zzb(e);
                throw e;
            }
        }

        public IntentBuilder setCountries(List<String> list) {
            this.zza.zza(list);
            return this;
        }

        @Deprecated
        public IntentBuilder setCountry(String str) {
            this.zza.zzn(str);
            return this;
        }

        public IntentBuilder setHint(String str) {
            this.zza.zzb(str);
            return this;
        }

        public IntentBuilder setInitialQuery(String str) {
            this.zza.zzc(str);
            return this;
        }

        public IntentBuilder setLocationBias(LocationBias locationBias) {
            this.zza.zzd(locationBias);
            return this;
        }

        public IntentBuilder setLocationRestriction(LocationRestriction locationRestriction) {
            this.zza.zze(locationRestriction);
            return this;
        }

        @Deprecated
        public IntentBuilder setTypeFilter(TypeFilter typeFilter) {
            this.zza.zzk(typeFilter);
            return this;
        }

        public IntentBuilder setTypesFilter(List<String> list) {
            this.zza.zzl(list);
            return this;
        }

        public final IntentBuilder zza(zzis zzisVar) {
            this.zza.zzg(zzisVar);
            return this;
        }
    }

    private Autocomplete() {
    }

    public static Place getPlaceFromIntent(Intent intent) {
        return zzix.zzb(intent);
    }

    public static Status getStatusFromIntent(Intent intent) {
        return zzix.zza(intent);
    }
}

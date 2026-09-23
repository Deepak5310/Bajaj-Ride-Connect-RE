package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzit {
    public abstract zzit zza(List list);

    public abstract zzit zzb(String str);

    public abstract zzit zzc(String str);

    public abstract zzit zzd(LocationBias locationBias);

    public abstract zzit zze(LocationRestriction locationRestriction);

    public abstract zzit zzf(AutocompleteActivityMode autocompleteActivityMode);

    public abstract zzit zzg(zzis zzisVar);

    public abstract zzit zzh(List list);

    public abstract zzit zzi(int i);

    public abstract zzit zzj(int i);

    @Deprecated
    public abstract zzit zzk(TypeFilter typeFilter);

    public abstract zzit zzl(List list);

    public abstract zziu zzm();

    @Deprecated
    public final zzit zzn(String str) {
        return zza(str == null ? zzlx.zzl() : zzlx.zzm(str));
    }
}

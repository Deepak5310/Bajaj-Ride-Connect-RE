package com.google.android.libraries.places.internal;

import android.os.Parcelable;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zziu implements Parcelable {
    public static zzit zzn(AutocompleteActivityMode autocompleteActivityMode, List list, zzis zzisVar) {
        zzik zzikVar = new zzik();
        zzikVar.zza(new ArrayList());
        zzikVar.zzl(new ArrayList());
        zzikVar.zzf(autocompleteActivityMode);
        zzikVar.zzh(list);
        zzikVar.zzg(zzisVar);
        zzikVar.zzi(0);
        zzikVar.zzj(0);
        return zzikVar;
    }

    public abstract int zza();

    public abstract int zzb();

    public abstract LocationBias zzc();

    public abstract LocationRestriction zzd();

    @Deprecated
    public abstract TypeFilter zze();

    public abstract zzis zzf();

    public abstract zzit zzg();

    public abstract AutocompleteActivityMode zzh();

    public abstract zzlx zzi();

    public abstract zzlx zzj();

    public abstract zzlx zzk();

    public abstract String zzl();

    public abstract String zzm();
}

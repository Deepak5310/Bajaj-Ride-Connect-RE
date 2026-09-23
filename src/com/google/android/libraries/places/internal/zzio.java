package com.google.android.libraries.places.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.Place;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzio extends zziv {
    private String zza;
    private zzlx zzb;
    private Place zzc;
    private AutocompletePrediction zzd;
    private Status zze;
    private int zzf;

    zzio() {
    }

    @Override // com.google.android.libraries.places.internal.zziv
    public final zziv zza(Place place) {
        this.zzc = place;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zziv
    public final zziv zzb(AutocompletePrediction autocompletePrediction) {
        this.zzd = autocompletePrediction;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zziv
    public final zziv zzc(List list) {
        this.zzb = zzlx.zzj(list);
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zziv
    public final zziv zzd(String str) {
        this.zza = str;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zziv
    public final zziv zze(Status status) {
        this.zze = status;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zziv
    public final zziw zzf() {
        int i = this.zzf;
        if (i != 0) {
            return new zziq(i, this.zza, this.zzb, this.zzc, this.zzd, this.zze, null);
        }
        throw new IllegalStateException("Missing required properties: type");
    }

    public final zziv zzg(int i) {
        this.zzf = i;
        return this;
    }
}

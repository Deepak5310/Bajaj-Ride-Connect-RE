package com.google.android.libraries.places.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.Place;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zziq extends zziw {
    private final String zza;
    private final zzlx zzb;
    private final Place zzc;
    private final AutocompletePrediction zzd;
    private final Status zze;
    private final int zzf;

    /* synthetic */ zziq(int i, String str, zzlx zzlxVar, Place place, AutocompletePrediction autocompletePrediction, Status status, zzip zzipVar) {
        this.zzf = i;
        this.zza = str;
        this.zzb = zzlxVar;
        this.zzc = place;
        this.zzd = autocompletePrediction;
        this.zze = status;
    }

    public final boolean equals(Object obj) {
        String str;
        zzlx zzlxVar;
        Place place;
        AutocompletePrediction autocompletePrediction;
        Status status;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zziw) {
            zziw zziwVar = (zziw) obj;
            if (this.zzf == zziwVar.zzf() && ((str = this.zza) != null ? str.equals(zziwVar.zze()) : zziwVar.zze() == null) && ((zzlxVar = this.zzb) != null ? zzlxVar.equals(zziwVar.zzd()) : zziwVar.zzd() == null) && ((place = this.zzc) != null ? place.equals(zziwVar.zzc()) : zziwVar.zzc() == null) && ((autocompletePrediction = this.zzd) != null ? autocompletePrediction.equals(zziwVar.zzb()) : zziwVar.zzb() == null) && ((status = this.zze) != null ? status.equals(zziwVar.zza()) : zziwVar.zza() == null)) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        String str;
        switch (this.zzf) {
            case 1:
                str = "START";
                break;
            case 2:
                str = "RESET";
                break;
            case 3:
                str = "LOADING";
                break;
            case 4:
                str = "TRY_AGAIN_PROGRESS_LOADING";
                break;
            case 5:
                str = "SUCCESS_PREDICTIONS";
                break;
            case 6:
                str = "FAILURE_NO_PREDICTIONS";
                break;
            case 7:
                str = "FAILURE_PREDICTIONS";
                break;
            case 8:
                str = "SUCCESS_SELECTION";
                break;
            case 9:
                str = "FAILURE_SELECTION";
                break;
            default:
                str = "FAILURE_UNRESOLVABLE";
                break;
        }
        String str2 = this.zza;
        zzlx zzlxVar = this.zzb;
        Place place = this.zzc;
        AutocompletePrediction autocompletePrediction = this.zzd;
        Status status = this.zze;
        return "AutocompleteState{type=" + str + ", query=" + str2 + ", predictions=" + String.valueOf(zzlxVar) + ", place=" + String.valueOf(place) + ", prediction=" + String.valueOf(autocompletePrediction) + ", status=" + String.valueOf(status) + "}";
    }

    @Override // com.google.android.libraries.places.internal.zziw
    public final Status zza() {
        return this.zze;
    }

    @Override // com.google.android.libraries.places.internal.zziw
    public final AutocompletePrediction zzb() {
        return this.zzd;
    }

    @Override // com.google.android.libraries.places.internal.zziw
    public final Place zzc() {
        return this.zzc;
    }

    @Override // com.google.android.libraries.places.internal.zziw
    public final zzlx zzd() {
        return this.zzb;
    }

    @Override // com.google.android.libraries.places.internal.zziw
    public final String zze() {
        return this.zza;
    }

    @Override // com.google.android.libraries.places.internal.zziw
    public final int zzf() {
        return this.zzf;
    }

    public final int hashCode() {
        String str = this.zza;
        int iHashCode = str == null ? 0 : str.hashCode();
        int i = this.zzf;
        zzlx zzlxVar = this.zzb;
        int iHashCode2 = zzlxVar == null ? 0 : zzlxVar.hashCode();
        int i2 = iHashCode ^ ((i ^ 1000003) * 1000003);
        Place place = this.zzc;
        int iHashCode3 = ((((i2 * 1000003) ^ iHashCode2) * 1000003) ^ (place == null ? 0 : place.hashCode())) * 1000003;
        AutocompletePrediction autocompletePrediction = this.zzd;
        int iHashCode4 = (iHashCode3 ^ (autocompletePrediction == null ? 0 : autocompletePrediction.hashCode())) * 1000003;
        Status status = this.zze;
        return iHashCode4 ^ (status != null ? status.hashCode() : 0);
    }
}

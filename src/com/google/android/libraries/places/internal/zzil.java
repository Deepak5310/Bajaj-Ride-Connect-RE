package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
abstract class zzil extends zziu {
    private final AutocompleteActivityMode zza;
    private final zzlx zzb;
    private final zzis zzc;
    private final String zzd;
    private final String zze;
    private final LocationBias zzf;
    private final LocationRestriction zzg;
    private final zzlx zzh;
    private final TypeFilter zzi;
    private final zzlx zzj;
    private final int zzk;
    private final int zzl;

    zzil(AutocompleteActivityMode autocompleteActivityMode, zzlx zzlxVar, zzis zzisVar, String str, String str2, LocationBias locationBias, LocationRestriction locationRestriction, zzlx zzlxVar2, TypeFilter typeFilter, zzlx zzlxVar3, int i, int i2) {
        if (autocompleteActivityMode == null) {
            throw new NullPointerException("Null mode");
        }
        this.zza = autocompleteActivityMode;
        if (zzlxVar == null) {
            throw new NullPointerException("Null placeFields");
        }
        this.zzb = zzlxVar;
        if (zzisVar == null) {
            throw new NullPointerException("Null origin");
        }
        this.zzc = zzisVar;
        this.zzd = str;
        this.zze = str2;
        this.zzf = locationBias;
        this.zzg = locationRestriction;
        if (zzlxVar2 == null) {
            throw new NullPointerException("Null countries");
        }
        this.zzh = zzlxVar2;
        this.zzi = typeFilter;
        if (zzlxVar3 == null) {
            throw new NullPointerException("Null typesFilter");
        }
        this.zzj = zzlxVar3;
        this.zzk = i;
        this.zzl = i2;
    }

    public final boolean equals(Object obj) {
        String str;
        String str2;
        LocationBias locationBias;
        LocationRestriction locationRestriction;
        TypeFilter typeFilter;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zziu) {
            zziu zziuVar = (zziu) obj;
            if (this.zza.equals(zziuVar.zzh()) && this.zzb.equals(zziuVar.zzj()) && this.zzc.equals(zziuVar.zzf()) && ((str = this.zzd) != null ? str.equals(zziuVar.zzm()) : zziuVar.zzm() == null) && ((str2 = this.zze) != null ? str2.equals(zziuVar.zzl()) : zziuVar.zzl() == null) && ((locationBias = this.zzf) != null ? locationBias.equals(zziuVar.zzc()) : zziuVar.zzc() == null) && ((locationRestriction = this.zzg) != null ? locationRestriction.equals(zziuVar.zzd()) : zziuVar.zzd() == null) && this.zzh.equals(zziuVar.zzi()) && ((typeFilter = this.zzi) != null ? typeFilter.equals(zziuVar.zze()) : zziuVar.zze() == null) && this.zzj.equals(zziuVar.zzk()) && this.zzk == zziuVar.zza() && this.zzl == zziuVar.zzb()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = ((((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode()) * 1000003) ^ this.zzc.hashCode();
        String str = this.zzd;
        int iHashCode2 = ((iHashCode * 1000003) ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.zze;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        LocationBias locationBias = this.zzf;
        int iHashCode4 = (iHashCode3 ^ (locationBias == null ? 0 : locationBias.hashCode())) * 1000003;
        LocationRestriction locationRestriction = this.zzg;
        int iHashCode5 = (((iHashCode4 ^ (locationRestriction == null ? 0 : locationRestriction.hashCode())) * 1000003) ^ this.zzh.hashCode()) * 1000003;
        TypeFilter typeFilter = this.zzi;
        return ((((((iHashCode5 ^ (typeFilter != null ? typeFilter.hashCode() : 0)) * 1000003) ^ this.zzj.hashCode()) * 1000003) ^ this.zzk) * 1000003) ^ this.zzl;
    }

    public final String toString() {
        zzlx zzlxVar = this.zzj;
        TypeFilter typeFilter = this.zzi;
        zzlx zzlxVar2 = this.zzh;
        LocationRestriction locationRestriction = this.zzg;
        LocationBias locationBias = this.zzf;
        zzis zzisVar = this.zzc;
        zzlx zzlxVar3 = this.zzb;
        return "AutocompleteOptions{mode=" + this.zza.toString() + ", placeFields=" + zzlxVar3.toString() + ", origin=" + zzisVar.toString() + ", initialQuery=" + this.zzd + ", hint=" + this.zze + ", locationBias=" + String.valueOf(locationBias) + ", locationRestriction=" + String.valueOf(locationRestriction) + ", countries=" + zzlxVar2.toString() + ", typeFilter=" + String.valueOf(typeFilter) + ", typesFilter=" + zzlxVar.toString() + ", primaryColor=" + this.zzk + ", primaryColorDark=" + this.zzl + "}";
    }

    @Override // com.google.android.libraries.places.internal.zziu
    public final int zza() {
        return this.zzk;
    }

    @Override // com.google.android.libraries.places.internal.zziu
    public final int zzb() {
        return this.zzl;
    }

    @Override // com.google.android.libraries.places.internal.zziu
    public final LocationBias zzc() {
        return this.zzf;
    }

    @Override // com.google.android.libraries.places.internal.zziu
    public final LocationRestriction zzd() {
        return this.zzg;
    }

    @Override // com.google.android.libraries.places.internal.zziu
    @Deprecated
    public final TypeFilter zze() {
        return this.zzi;
    }

    @Override // com.google.android.libraries.places.internal.zziu
    public final zzis zzf() {
        return this.zzc;
    }

    @Override // com.google.android.libraries.places.internal.zziu
    public final zzit zzg() {
        return new zzik(this);
    }

    @Override // com.google.android.libraries.places.internal.zziu
    public final AutocompleteActivityMode zzh() {
        return this.zza;
    }

    @Override // com.google.android.libraries.places.internal.zziu
    public final zzlx zzi() {
        return this.zzh;
    }

    @Override // com.google.android.libraries.places.internal.zziu
    public final zzlx zzj() {
        return this.zzb;
    }

    @Override // com.google.android.libraries.places.internal.zziu
    public final zzlx zzk() {
        return this.zzj;
    }

    @Override // com.google.android.libraries.places.internal.zziu
    public final String zzl() {
        return this.zze;
    }

    @Override // com.google.android.libraries.places.internal.zziu
    public final String zzm() {
        return this.zzd;
    }
}

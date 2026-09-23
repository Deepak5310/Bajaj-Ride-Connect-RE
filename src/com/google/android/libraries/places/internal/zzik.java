package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzik extends zzit {
    private AutocompleteActivityMode zza;
    private zzlx zzb;
    private zzis zzc;
    private String zzd;
    private String zze;
    private LocationBias zzf;
    private LocationRestriction zzg;
    private zzlx zzh;
    private TypeFilter zzi;
    private zzlx zzj;
    private int zzk;
    private int zzl;
    private byte zzm;

    zzik() {
    }

    zzik(zziu zziuVar) {
        this.zza = zziuVar.zzh();
        this.zzb = zziuVar.zzj();
        this.zzc = zziuVar.zzf();
        this.zzd = zziuVar.zzm();
        this.zze = zziuVar.zzl();
        this.zzf = zziuVar.zzc();
        this.zzg = zziuVar.zzd();
        this.zzh = zziuVar.zzi();
        this.zzi = zziuVar.zze();
        this.zzj = zziuVar.zzk();
        this.zzk = zziuVar.zza();
        this.zzl = zziuVar.zzb();
        this.zzm = (byte) 3;
    }

    @Override // com.google.android.libraries.places.internal.zzit
    public final zzit zza(List list) {
        this.zzh = zzlx.zzj(list);
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzit
    public final zzit zzb(String str) {
        this.zze = str;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzit
    public final zzit zzc(String str) {
        this.zzd = str;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzit
    public final zzit zzd(LocationBias locationBias) {
        this.zzf = locationBias;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzit
    public final zzit zze(LocationRestriction locationRestriction) {
        this.zzg = locationRestriction;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzit
    public final zzit zzf(AutocompleteActivityMode autocompleteActivityMode) {
        if (autocompleteActivityMode == null) {
            throw new NullPointerException("Null mode");
        }
        this.zza = autocompleteActivityMode;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzit
    public final zzit zzg(zzis zzisVar) {
        if (zzisVar == null) {
            throw new NullPointerException("Null origin");
        }
        this.zzc = zzisVar;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzit
    public final zzit zzh(List list) {
        this.zzb = zzlx.zzj(list);
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzit
    public final zzit zzi(int i) {
        this.zzk = i;
        this.zzm = (byte) (this.zzm | 1);
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzit
    public final zzit zzj(int i) {
        this.zzl = i;
        this.zzm = (byte) (this.zzm | 2);
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzit
    public final zzit zzk(TypeFilter typeFilter) {
        this.zzi = typeFilter;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzit
    public final zzit zzl(List list) {
        this.zzj = zzlx.zzj(list);
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzit
    public final zziu zzm() {
        AutocompleteActivityMode autocompleteActivityMode;
        zzlx zzlxVar;
        zzis zzisVar;
        zzlx zzlxVar2;
        zzlx zzlxVar3;
        if (this.zzm == 3 && (autocompleteActivityMode = this.zza) != null && (zzlxVar = this.zzb) != null && (zzisVar = this.zzc) != null && (zzlxVar2 = this.zzh) != null && (zzlxVar3 = this.zzj) != null) {
            return new zzin(autocompleteActivityMode, zzlxVar, zzisVar, this.zzd, this.zze, this.zzf, this.zzg, zzlxVar2, this.zzi, zzlxVar3, this.zzk, this.zzl);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" mode");
        }
        if (this.zzb == null) {
            sb.append(" placeFields");
        }
        if (this.zzc == null) {
            sb.append(" origin");
        }
        if (this.zzh == null) {
            sb.append(" countries");
        }
        if (this.zzj == null) {
            sb.append(" typesFilter");
        }
        if ((this.zzm & 1) == 0) {
            sb.append(" primaryColor");
        }
        if ((this.zzm & 2) == 0) {
            sb.append(" primaryColorDark");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}

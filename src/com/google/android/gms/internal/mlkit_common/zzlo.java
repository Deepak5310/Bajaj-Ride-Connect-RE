package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: com.google.mlkit:common@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzlo implements zzlc {
    private final zzif zza;
    private zzjz zzb = new zzjz();

    private zzlo(zzif zzifVar, int i) {
        this.zza = zzifVar;
        zzlz.zza();
    }

    public static zzlc zzf(zzif zzifVar) {
        return new zzlo(zzifVar, 0);
    }

    public static zzlc zzg() {
        return new zzlo(new zzif(), 0);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzlc
    public final zzlc zza(zzie zzieVar) {
        this.zza.zzf(zzieVar);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzlc
    public final zzlc zzb(zzil zzilVar) {
        this.zza.zzi(zzilVar);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzlc
    public final zzlc zzc(zzjz zzjzVar) {
        this.zzb = zzjzVar;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzlc
    public final String zzd() {
        zzkb zzkbVarZzf = this.zza.zzk().zzf();
        return (zzkbVarZzf == null || zzac.zzc(zzkbVarZzf.zzk())) ? "NA" : (String) Preconditions.checkNotNull(zzkbVarZzf.zzk());
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzlc
    public final byte[] zze(int i, boolean z) {
        this.zzb.zzf(Boolean.valueOf(1 == (i ^ 1)));
        this.zzb.zze(false);
        this.zza.zzj(this.zzb.zzm());
        try {
            zzlz.zza();
            if (i == 0) {
                return new JsonDataEncoderBuilder().configureWith(zzgp.zza).ignoreNullValues(true).build().encode(this.zza.zzk()).getBytes("utf-8");
            }
            zzih zzihVarZzk = this.zza.zzk();
            zzbm zzbmVar = new zzbm();
            zzgp.zza.configure(zzbmVar);
            return zzbmVar.zza().zza(zzihVarZzk);
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }
}

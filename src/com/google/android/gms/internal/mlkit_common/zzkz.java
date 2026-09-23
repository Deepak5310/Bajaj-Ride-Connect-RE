package com.google.android.gms.internal.mlkit_common;

import com.google.mlkit.common.sdkinternal.ModelType;

/* JADX INFO: compiled from: com.google.mlkit:common@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzkz extends zzlm {
    private zzid zza;
    private String zzb;
    private boolean zzc;
    private boolean zzd;
    private ModelType zze;
    private zzij zzf;
    private int zzg;
    private byte zzh;

    zzkz() {
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzlm
    public final zzlm zza(zzij zzijVar) {
        if (zzijVar == null) {
            throw new NullPointerException("Null downloadStatus");
        }
        this.zzf = zzijVar;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzlm
    public final zzlm zzb(zzid zzidVar) {
        if (zzidVar == null) {
            throw new NullPointerException("Null errorCode");
        }
        this.zza = zzidVar;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzlm
    public final zzlm zzc(int i) {
        this.zzg = i;
        this.zzh = (byte) (this.zzh | 4);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzlm
    public final zzlm zzd(ModelType modelType) {
        if (modelType == null) {
            throw new NullPointerException("Null modelType");
        }
        this.zze = modelType;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzlm
    public final zzlm zze(boolean z) {
        this.zzd = z;
        this.zzh = (byte) (this.zzh | 2);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzlm
    public final zzlm zzf(boolean z) {
        this.zzc = z;
        this.zzh = (byte) (this.zzh | 1);
        return this;
    }

    public final zzlm zzg(String str) {
        this.zzb = "NA";
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzlm
    public final zzln zzh() {
        zzid zzidVar;
        String str;
        ModelType modelType;
        zzij zzijVar;
        if (this.zzh == 7 && (zzidVar = this.zza) != null && (str = this.zzb) != null && (modelType = this.zze) != null && (zzijVar = this.zzf) != null) {
            return new zzlb(zzidVar, str, this.zzc, this.zzd, modelType, zzijVar, this.zzg, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" errorCode");
        }
        if (this.zzb == null) {
            sb.append(" tfliteSchemaVersion");
        }
        if ((this.zzh & 1) == 0) {
            sb.append(" shouldLogRoughDownloadTime");
        }
        if ((this.zzh & 2) == 0) {
            sb.append(" shouldLogExactDownloadTime");
        }
        if (this.zze == null) {
            sb.append(" modelType");
        }
        if (this.zzf == null) {
            sb.append(" downloadStatus");
        }
        if ((this.zzh & 4) == 0) {
            sb.append(" failureStatusCode");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}

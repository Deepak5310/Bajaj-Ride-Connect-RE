package com.google.android.libraries.places.internal;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzapd implements zzapm {
    private final zzaoz zza;
    private final zzaqg zzb;
    private final boolean zzc;
    private final zzane zzd;

    private zzapd(zzaqg zzaqgVar, zzane zzaneVar, zzaoz zzaozVar) {
        this.zzb = zzaqgVar;
        this.zzc = zzaneVar.zzh(zzaozVar);
        this.zzd = zzaneVar;
        this.zza = zzaozVar;
    }

    static zzapd zzi(zzaqg zzaqgVar, zzane zzaneVar, zzaoz zzaozVar) {
        return new zzapd(zzaqgVar, zzaneVar, zzaozVar);
    }

    @Override // com.google.android.libraries.places.internal.zzapm
    public final int zza(Object obj) {
        zzaqg zzaqgVar = this.zzb;
        int iZzb = zzaqgVar.zzb(zzaqgVar.zzd(obj));
        if (!this.zzc) {
            return iZzb;
        }
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzapm
    public final int zzb(Object obj) {
        int iHashCode = this.zzb.zzd(obj).hashCode();
        if (!this.zzc) {
            return iHashCode;
        }
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzapm
    public final Object zzc() {
        zzaoz zzaozVar = this.zza;
        return zzaozVar instanceof zzanr ? ((zzanr) zzaozVar).zzao() : zzaozVar.zzau().zzs();
    }

    @Override // com.google.android.libraries.places.internal.zzapm
    public final void zzd(Object obj) {
        this.zzb.zzm(obj);
        this.zzd.zze(obj);
    }

    @Override // com.google.android.libraries.places.internal.zzapm
    public final void zze(Object obj, Object obj2) {
        zzapo.zzq(this.zzb, obj, obj2);
        if (this.zzc) {
            this.zzd.zza(obj2);
            throw null;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzapm
    public final void zzf(Object obj, zzapl zzaplVar, zzand zzandVar) throws IOException {
        boolean zZzO;
        zzaqg zzaqgVar = this.zzb;
        Object objZzc = zzaqgVar.zzc(obj);
        zzane zzaneVar = this.zzd;
        zzani zzaniVarZzb = zzaneVar.zzb(obj);
        while (zzaplVar.zzc() != Integer.MAX_VALUE) {
            try {
                int iZzd = zzaplVar.zzd();
                if (iZzd != 11) {
                    if ((iZzd & 7) == 2) {
                        Object objZzc2 = zzaneVar.zzc(zzandVar, this.zza, iZzd >>> 3);
                        if (objZzc2 != null) {
                            zzaneVar.zzf(zzaplVar, objZzc2, zzandVar, zzaniVarZzb);
                        } else {
                            zZzO = zzaqgVar.zzp(objZzc, zzaplVar);
                        }
                    } else {
                        zZzO = zzaplVar.zzO();
                    }
                    if (!zZzO) {
                        break;
                    }
                } else {
                    Object objZzc3 = null;
                    int iZzj = 0;
                    zzaml zzamlVarZzp = null;
                    while (zzaplVar.zzc() != Integer.MAX_VALUE) {
                        int iZzd2 = zzaplVar.zzd();
                        if (iZzd2 == 16) {
                            iZzj = zzaplVar.zzj();
                            objZzc3 = zzaneVar.zzc(zzandVar, this.zza, iZzj);
                        } else if (iZzd2 == 26) {
                            if (objZzc3 != null) {
                                zzaneVar.zzf(zzaplVar, objZzc3, zzandVar, zzaniVarZzb);
                            } else {
                                zzamlVarZzp = zzaplVar.zzp();
                            }
                        } else if (!zzaplVar.zzO()) {
                            break;
                        }
                    }
                    if (zzaplVar.zzd() != 12) {
                        throw zzaoc.zzb();
                    }
                    if (zzamlVarZzp != null) {
                        if (objZzc3 != null) {
                            zzaneVar.zzg(zzamlVarZzp, objZzc3, zzandVar, zzaniVarZzb);
                        } else {
                            zzaqgVar.zzk(objZzc, iZzj, zzamlVarZzp);
                        }
                    }
                }
            } catch (Throwable th) {
                zzaqgVar.zzn(obj, objZzc);
                throw th;
            }
        }
        zzaqgVar.zzn(obj, objZzc);
    }

    @Override // com.google.android.libraries.places.internal.zzapm
    public final boolean zzg(Object obj, Object obj2) {
        zzaqg zzaqgVar = this.zzb;
        if (!zzaqgVar.zzd(obj).equals(zzaqgVar.zzd(obj2))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        this.zzd.zza(obj);
        this.zzd.zza(obj2);
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzapm
    public final boolean zzh(Object obj) {
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzapm
    public final void zzj(Object obj, zzamz zzamzVar) throws IOException {
        this.zzd.zza(obj);
        throw null;
    }
}

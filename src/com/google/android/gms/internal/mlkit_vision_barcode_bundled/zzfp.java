package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.mlkit:barcode-scanning@@17.0.2 */
/* JADX INFO: loaded from: classes2.dex */
final class zzfp implements zzgb {
    private final zzfl zza;
    private final zzgp zzb;
    private final boolean zzc;
    private final zzdo zzd;

    private zzfp(zzgp zzgpVar, zzdo zzdoVar, zzfl zzflVar) {
        this.zzb = zzgpVar;
        this.zzc = zzdoVar.zzf(zzflVar);
        this.zzd = zzdoVar;
        this.zza = zzflVar;
    }

    static zzfp zzc(zzgp zzgpVar, zzdo zzdoVar, zzfl zzflVar) {
        return new zzfp(zzgpVar, zzdoVar, zzflVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgb
    public final int zza(Object obj) {
        zzgp zzgpVar = this.zzb;
        int iZzb = zzgpVar.zzb(zzgpVar.zzc(obj));
        return this.zzc ? iZzb + this.zzd.zzb(obj).zzb() : iZzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgb
    public final int zzb(Object obj) {
        int iHashCode = this.zzb.zzc(obj).hashCode();
        return this.zzc ? (iHashCode * 53) + this.zzd.zzb(obj).zza.hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgb
    public final Object zze() {
        return this.zza.zzU().zzm();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgb
    public final void zzf(Object obj) {
        this.zzb.zzg(obj);
        this.zzd.zze(obj);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgb
    public final void zzg(Object obj, Object obj2) {
        zzgd.zzF(this.zzb, obj, obj2);
        if (this.zzc) {
            zzgd.zzE(this.zzd, obj, obj2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:57:0x00bf A[EDGE_INSN: B:57:0x00bf->B:33:0x00bf BREAK  A[LOOP:1: B:18:0x0067->B:60:0x0067], SYNTHETIC] */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgb
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzco zzcoVar) throws IOException {
        zzec zzecVar = (zzec) obj;
        zzgq zzgqVarZze = zzecVar.zzc;
        if (zzgqVarZze == zzgq.zzc()) {
            zzgqVarZze = zzgq.zze();
            zzecVar.zzc = zzgqVarZze;
        }
        zzds zzdsVarZzc = ((zzdy) obj).zzc();
        Object objZzd = null;
        while (i < i2) {
            int iZzj = zzcp.zzj(bArr, i, zzcoVar);
            int i3 = zzcoVar.zza;
            if (i3 == 11) {
                int i4 = 0;
                zzdb zzdbVar = null;
                while (iZzj < i2) {
                    iZzj = zzcp.zzj(bArr, iZzj, zzcoVar);
                    int i5 = zzcoVar.zza;
                    int i6 = i5 & 7;
                    int i7 = i5 >>> 3;
                    if (i7 == 2) {
                        if (i6 != 0) {
                            if (i5 != 12) {
                                break;
                                break;
                            }
                            iZzj = zzcp.zzn(i5, bArr, iZzj, i2, zzcoVar);
                        } else {
                            iZzj = zzcp.zzj(bArr, iZzj, zzcoVar);
                            i4 = zzcoVar.zza;
                            objZzd = this.zzd.zzd(zzcoVar.zzd, this.zza, i4);
                        }
                    } else {
                        if (i7 == 3) {
                            if (objZzd != null) {
                                zzea zzeaVar = (zzea) objZzd;
                                iZzj = zzcp.zzd(zzfu.zza().zzb(zzeaVar.zzc.getClass()), bArr, iZzj, i2, zzcoVar);
                                zzdsVarZzc.zzi(zzeaVar.zzd, zzcoVar.zzc);
                            } else if (i6 == 2) {
                                iZzj = zzcp.zza(bArr, iZzj, zzcoVar);
                                zzdbVar = (zzdb) zzcoVar.zzc;
                            }
                        }
                        if (i5 != 12) {
                            break;
                        } else {
                            iZzj = zzcp.zzn(i5, bArr, iZzj, i2, zzcoVar);
                        }
                    }
                }
                if (zzdbVar != null) {
                    zzgqVarZze.zzh((i4 << 3) | 2, zzdbVar);
                }
                i = iZzj;
            } else if ((i3 & 7) == 2) {
                Object objZzd2 = this.zzd.zzd(zzcoVar.zzd, this.zza, i3 >>> 3);
                if (objZzd2 != null) {
                    zzea zzeaVar2 = (zzea) objZzd2;
                    i = zzcp.zzd(zzfu.zza().zzb(zzeaVar2.zzc.getClass()), bArr, iZzj, i2, zzcoVar);
                    zzdsVarZzc.zzi(zzeaVar2.zzd, zzcoVar.zzc);
                } else {
                    i = zzcp.zzi(i3, bArr, iZzj, i2, zzgqVarZze, zzcoVar);
                }
                objZzd = objZzd2;
            } else {
                i = zzcp.zzn(i3, bArr, iZzj, i2, zzcoVar);
            }
        }
        if (i != i2) {
            throw zzen.zze();
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgb
    public final boolean zzi(Object obj, Object obj2) {
        if (!this.zzb.zzc(obj).equals(this.zzb.zzc(obj2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zzb(obj).equals(this.zzd.zzb(obj2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgb
    public final boolean zzj(Object obj) {
        return this.zzd.zzb(obj).zzk();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgb
    public final void zzm(Object obj, zzdj zzdjVar) throws IOException {
        Iterator itZzf = this.zzd.zzb(obj).zzf();
        while (itZzf.hasNext()) {
            Map.Entry entry = (Map.Entry) itZzf.next();
            zzdr zzdrVar = (zzdr) entry.getKey();
            if (zzdrVar.zze() != zzhg.MESSAGE) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            zzdrVar.zzg();
            zzdrVar.zzf();
            if (entry instanceof zzeq) {
                zzdjVar.zzw(zzdrVar.zza(), ((zzeq) entry).zza().zzb());
            } else {
                zzdjVar.zzw(zzdrVar.zza(), entry.getValue());
            }
        }
        zzgp zzgpVar = this.zzb;
        zzgpVar.zzi(zzgpVar.zzc(obj), zzdjVar);
    }
}

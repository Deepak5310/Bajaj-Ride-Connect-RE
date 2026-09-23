package com.google.android.libraries.places.internal;

import io.grpc.internal.GrpcUtil;
import java.nio.charset.Charset;
import java.util.Locale;
import javax.annotation.Nullable;
import okhttp3.internal.http2.Header;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzbcx extends zzaxt {
    private static final zzaug zza;
    private static final zzavp zzb;
    private zzaxd zzc;
    private zzavu zzd;
    private Charset zze;
    private boolean zzf;

    static {
        zzbcw zzbcwVar = new zzbcw();
        zza = zzbcwVar;
        zzb = zzauh.zzb(Header.RESPONSE_STATUS_UTF8, zzbcwVar);
    }

    protected zzbcx(int i, zzbjt zzbjtVar, zzbke zzbkeVar) {
        super(i, zzbjtVar, zzbkeVar);
        this.zze = zzkc.zzc;
    }

    private static Charset zzG(zzavu zzavuVar) {
        String str = (String) zzavuVar.zzb(zzbcu.zzh);
        if (str != null) {
            String[] strArrSplit = str.split("charset=", 2);
            try {
                return Charset.forName(strArrSplit[strArrSplit.length - 1].trim());
            } catch (Exception unused) {
            }
        }
        return zzkc.zzc;
    }

    private static void zzH(zzavu zzavuVar) {
        zzavuVar.zzd(zzb);
        zzavuVar.zzd(zzauj.zzb);
        zzavuVar.zzd(zzauj.zza);
    }

    @Nullable
    private static final zzaxd zzI(zzavu zzavuVar) {
        char cCharAt;
        Integer num = (Integer) zzavuVar.zzb(zzb);
        if (num == null) {
            return zzaxd.zzo.zzg("Missing HTTP status code");
        }
        String str = (String) zzavuVar.zzb(zzbcu.zzh);
        if (str != null && str.length() >= 16) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (lowerCase.startsWith(GrpcUtil.CONTENT_TYPE_GRPC) && (lowerCase.length() == 16 || (cCharAt = lowerCase.charAt(16)) == '+' || cCharAt == ';')) {
                return null;
            }
        }
        return zzbcu.zza(num.intValue()).zzc("invalid content-type: ".concat(String.valueOf(str)));
    }

    protected abstract void zzA(zzaxd zzaxdVar, boolean z, zzavu zzavuVar);

    protected final void zzB(zzbhb zzbhbVar, boolean z) {
        zzaxd zzaxdVar = this.zzc;
        if (zzaxdVar != null) {
            Charset charset = this.zze;
            zzkt.zzc(charset, "charset");
            int iZzf = zzbhbVar.zzf();
            byte[] bArr = new byte[iZzf];
            zzbhbVar.zzk(bArr, 0, iZzf);
            this.zzc = zzaxdVar.zzc("DATA-----------------------------\n".concat(new String(bArr, charset)));
            zzbhbVar.close();
            if (this.zzc.zzi().length() > 1000 || z) {
                zzA(this.zzc, false, this.zzd);
                return;
            }
            return;
        }
        if (!this.zzf) {
            zzA(zzaxd.zzo.zzg("headers not received before payload"), false, new zzavu());
            return;
        }
        int iZzf2 = zzbhbVar.zzf();
        zzf(zzbhbVar);
        if (z) {
            if (iZzf2 > 0) {
                this.zzc = zzaxd.zzo.zzg("Received unexpected EOS on non-empty DATA frame from server");
            } else {
                this.zzc = zzaxd.zzo.zzg("Received unexpected EOS on empty DATA frame from server");
            }
            zzavu zzavuVar = new zzavu();
            this.zzd = zzavuVar;
            zzj(this.zzc, zzazj.PROCESSED, false, zzavuVar);
        }
    }

    protected final void zzC(zzavu zzavuVar) {
        zzaxd zzaxdVar = this.zzc;
        if (zzaxdVar != null) {
            this.zzc = zzaxdVar.zzc("headers: ".concat(zzavuVar.toString()));
            return;
        }
        try {
            if (this.zzf) {
                this.zzc = zzaxd.zzo.zzg("Received headers twice");
            } else {
                Integer num = (Integer) zzavuVar.zzb(zzb);
                if (num == null || num.intValue() < 100 || num.intValue() >= 200) {
                    this.zzf = true;
                    zzaxd zzaxdVarZzI = zzI(zzavuVar);
                    this.zzc = zzaxdVarZzI;
                    if (zzaxdVarZzI != null) {
                        this.zzc = zzaxdVarZzI.zzc("headers: ".concat(zzavuVar.toString()));
                        this.zzd = zzavuVar;
                        this.zze = zzG(zzavuVar);
                        return;
                    }
                    zzH(zzavuVar);
                    zzg(zzavuVar);
                }
            }
            zzaxd zzaxdVar2 = this.zzc;
            if (zzaxdVar2 != null) {
                this.zzc = zzaxdVar2.zzc("headers: ".concat(zzavuVar.toString()));
                this.zzd = zzavuVar;
                this.zze = zzG(zzavuVar);
            }
        } catch (Throwable th) {
            zzaxd zzaxdVar3 = this.zzc;
            if (zzaxdVar3 != null) {
                this.zzc = zzaxdVar3.zzc("headers: ".concat(zzavuVar.toString()));
                this.zzd = zzavuVar;
                this.zze = zzG(zzavuVar);
            }
            throw th;
        }
    }

    protected final void zzD(zzavu zzavuVar) {
        zzaxd zzaxdVarZzc;
        zzaxd zzaxdVarZzI = this.zzc;
        if (zzaxdVarZzI == null && !this.zzf) {
            zzaxdVarZzI = zzI(zzavuVar);
            this.zzc = zzaxdVarZzI;
            if (zzaxdVarZzI != null) {
                this.zzd = zzavuVar;
            }
        }
        if (zzaxdVarZzI != null) {
            zzaxd zzaxdVarZzc2 = zzaxdVarZzI.zzc("trailers: ".concat(zzavuVar.toString()));
            this.zzc = zzaxdVarZzc2;
            zzA(zzaxdVarZzc2, false, this.zzd);
            return;
        }
        zzaxd zzaxdVar = (zzaxd) zzavuVar.zzb(zzauj.zzb);
        if (zzaxdVar != null) {
            zzaxdVarZzc = zzaxdVar.zzg((String) zzavuVar.zzb(zzauj.zza));
        } else if (this.zzf) {
            zzaxdVarZzc = zzaxd.zzc.zzg("missing GRPC status in response");
        } else {
            Integer num = (Integer) zzavuVar.zzb(zzb);
            zzaxdVarZzc = (num != null ? zzbcu.zza(num.intValue()) : zzaxd.zzo.zzg("missing HTTP status code")).zzc("missing GRPC status, inferred error from HTTP status code");
        }
        zzH(zzavuVar);
        zzh(zzavuVar, zzaxdVarZzc);
    }
}

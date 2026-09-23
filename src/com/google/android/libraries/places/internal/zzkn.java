package com.google.android.libraries.places.internal;

import java.util.Arrays;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzkn {
    private final String zza;
    private final zzkl zzb;
    private zzkl zzc;
    private boolean zzd;

    /* synthetic */ zzkn(String str, zzkm zzkmVar) {
        zzkl zzklVar = new zzkl();
        this.zzb = zzklVar;
        this.zzc = zzklVar;
        this.zzd = false;
        str.getClass();
        this.zza = str;
    }

    private final zzkl zzh() {
        zzkl zzklVar = new zzkl();
        this.zzc.zzc = zzklVar;
        this.zzc = zzklVar;
        return zzklVar;
    }

    private final zzkn zzi(String str, Object obj) {
        zzkk zzkkVar = new zzkk(null);
        this.zzc.zzc = zzkkVar;
        this.zzc = zzkkVar;
        zzkkVar.zzb = obj;
        zzkkVar.zza = str;
        return this;
    }

    public final String toString() {
        boolean z = this.zzd;
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append('{');
        String str = "";
        for (zzkl zzklVar = this.zzb.zzc; zzklVar != null; zzklVar = zzklVar.zzc) {
            boolean z2 = zzklVar instanceof zzkk;
            Object obj = zzklVar.zzb;
            if (z2 || obj != null || !z) {
                sb.append(str);
                String str2 = zzklVar.zza;
                if (str2 != null) {
                    sb.append(str2);
                    sb.append('=');
                }
                if (obj == null || !obj.getClass().isArray()) {
                    sb.append(obj);
                } else {
                    String strDeepToString = Arrays.deepToString(new Object[]{obj});
                    sb.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
                }
                str = ", ";
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzkn zza(String str, double d) {
        zzi("backoffMultiplier", String.valueOf(d));
        return this;
    }

    public final zzkn zzb(String str, int i) {
        zzi(str, String.valueOf(i));
        return this;
    }

    public final zzkn zzc(String str, long j) {
        zzi(str, String.valueOf(j));
        return this;
    }

    public final zzkn zzd(String str, @CheckForNull Object obj) {
        zzkl zzklVarZzh = zzh();
        zzklVarZzh.zzb = obj;
        zzklVarZzh.zza = str;
        return this;
    }

    public final zzkn zze(String str, boolean z) {
        zzi(str, String.valueOf(z));
        return this;
    }

    public final zzkn zzf(@CheckForNull Object obj) {
        zzh().zzb = obj;
        return this;
    }

    public final zzkn zzg() {
        this.zzd = true;
        return this;
    }
}

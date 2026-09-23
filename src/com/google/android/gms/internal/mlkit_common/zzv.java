package com.google.android.gms.internal.mlkit_common;

import java.util.Arrays;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.mlkit:common@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzv {
    private final String zza;
    private final zzu zzb;
    private zzu zzc;

    /* synthetic */ zzv(String str, zzs zzsVar) {
        zzu zzuVar = new zzu(null);
        this.zzb = zzuVar;
        this.zzc = zzuVar;
        str.getClass();
        this.zza = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append('{');
        zzu zzuVar = this.zzb.zzc;
        String str = "";
        while (zzuVar != null) {
            Object obj = zzuVar.zzb;
            sb.append(str);
            String str2 = zzuVar.zza;
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
            zzuVar = zzuVar.zzc;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzv zza(String str, @CheckForNull Object obj) {
        zzu zzuVar = new zzu(null);
        this.zzc.zzc = zzuVar;
        this.zzc = zzuVar;
        zzuVar.zzb = obj;
        zzuVar.zza = str;
        return this;
    }

    public final zzv zzb(String str, boolean z) {
        String strValueOf = String.valueOf(z);
        zzt zztVar = new zzt(null);
        this.zzc.zzc = zztVar;
        this.zzc = zztVar;
        zztVar.zzb = strValueOf;
        zztVar.zza = "isManifestFile";
        return this;
    }
}

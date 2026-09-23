package com.google.android.libraries.places.internal;

import java.io.Serializable;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzmk extends zzml implements Serializable {
    public static final /* synthetic */ int zzc = 0;
    private static final zzmk zzd = new zzmk(zzln.zzb, zzll.zzb);
    final zzlp zza;
    final zzlp zzb;

    private zzmk(zzlp zzlpVar, zzlp zzlpVar2) {
        this.zza = zzlpVar;
        this.zzb = zzlpVar2;
        if (zzlpVar.compareTo(zzlpVar2) > 0 || zzlpVar == zzll.zzb || zzlpVar2 == zzln.zzb) {
            throw new IllegalArgumentException("Invalid range: ".concat(zze(zzlpVar, zzlpVar2)));
        }
    }

    public static zzmk zza(Comparable comparable) {
        return new zzmk(new zzlo(comparable), zzll.zzb);
    }

    public static zzmk zzb(Comparable comparable, Comparable comparable2) {
        return new zzmk(new zzlo(comparable), new zzlm(comparable2));
    }

    public static zzmk zzc(Comparable comparable, Comparable comparable2) {
        return new zzmk(new zzlo(comparable), new zzlo(comparable2));
    }

    private static String zze(zzlp zzlpVar, zzlp zzlpVar2) {
        StringBuilder sb = new StringBuilder(16);
        zzlpVar.zzc(sb);
        sb.append("..");
        zzlpVar2.zzd(sb);
        return sb.toString();
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzmk) {
            zzmk zzmkVar = (zzmk) obj;
            if (this.zza.equals(zzmkVar.zza) && this.zzb.equals(zzmkVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.zza.hashCode() * 31) + this.zzb.hashCode();
    }

    public final String toString() {
        return zze(this.zza, this.zzb);
    }

    public final boolean zzd(Comparable comparable) {
        comparable.getClass();
        return this.zza.zze(comparable) && !this.zzb.zze(comparable);
    }
}

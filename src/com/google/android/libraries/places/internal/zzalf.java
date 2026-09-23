package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzalf {
    private static volatile zzawa zza;
    private static volatile zzawa zzb;

    private zzalf() {
    }

    public static zzale zza(zzasb zzasbVar) {
        return (zzale) zzbnx.zzb(new zzalc(), zzasbVar, zzasa.zza);
    }

    public static zzawa zzb() {
        zzawa zzawaVarZzf = zzb;
        if (zzawaVarZzf == null) {
            synchronized (zzalf.class) {
                zzawaVarZzf = zzb;
                if (zzawaVarZzf == null) {
                    zzavw zzavwVarZza = zzawa.zza(null, null);
                    zzavwVarZza.zze(zzavy.UNARY);
                    zzavwVarZza.zza(zzawa.zze("google.maps.places.v1.Places", "GetPlace"));
                    zzavwVarZza.zzd(true);
                    zzavwVarZza.zzb(zzbnw.zza(zzajv.zzd()));
                    zzavwVarZza.zzc(zzbnw.zza(zzalb.zzl()));
                    zzawaVarZzf = zzavwVarZza.zzf();
                    zzb = zzawaVarZzf;
                }
            }
        }
        return zzawaVarZzf;
    }

    public static zzawa zzc() {
        zzawa zzawaVarZzf = zza;
        if (zzawaVarZzf == null) {
            synchronized (zzalf.class) {
                zzawaVarZzf = zza;
                if (zzawaVarZzf == null) {
                    zzavw zzavwVarZza = zzawa.zza(null, null);
                    zzavwVarZza.zze(zzavy.UNARY);
                    zzavwVarZza.zza(zzawa.zze("google.maps.places.v1.Places", "SearchText"));
                    zzavwVarZza.zzd(true);
                    zzavwVarZza.zzb(zzbnw.zza(zzalr.zzd()));
                    zzavwVarZza.zzc(zzbnw.zza(zzalu.zzc()));
                    zzawaVarZzf = zzavwVarZza.zzf();
                    zza = zzawaVarZzf;
                }
            }
        }
        return zzawaVarZzf;
    }
}

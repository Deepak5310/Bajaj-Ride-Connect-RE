package com.google.android.libraries.places.internal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzatx {
    private static final Logger zza = Logger.getLogger(zzatx.class.getName());
    private static final zzatx zzb = new zzatx();
    private final ConcurrentNavigableMap zzc = new ConcurrentSkipListMap();
    private final ConcurrentNavigableMap zzd = new ConcurrentSkipListMap();
    private final ConcurrentMap zze = new ConcurrentHashMap();
    private final ConcurrentMap zzf = new ConcurrentHashMap();
    private final ConcurrentMap zzg = new ConcurrentHashMap();

    public static zzatx zza() {
        return zzb;
    }

    private static void zzi(Map map, zzaue zzaueVar) {
    }

    private static void zzj(Map map, zzaue zzaueVar) {
    }

    public final void zzc(zzaue zzaueVar) {
        zzi(this.zzf, zzaueVar);
    }

    public final void zzd(zzaue zzaueVar) {
        zzi(this.zzd, zzaueVar);
    }

    public final void zze(zzaue zzaueVar) {
        zzi(this.zze, zzaueVar);
    }

    public final void zzf(zzaue zzaueVar) {
        zzj(this.zzf, zzaueVar);
    }

    public final void zzg(zzaue zzaueVar) {
        zzj(this.zzd, zzaueVar);
    }

    public final void zzh(zzaue zzaueVar) {
        zzj(this.zze, zzaueVar);
    }
}

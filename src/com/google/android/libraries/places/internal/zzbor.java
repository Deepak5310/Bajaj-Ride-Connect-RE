package com.google.android.libraries.places.internal;

import java.util.Arrays;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbor {
    final /* synthetic */ zzbot zza;
    private final Object zzb;
    private zzaux zzc;
    private final zzboo zzd;
    private final zzavd zze;
    private zzasu zzf = zzasu.CONNECTING;
    private zzauz zzg;
    private boolean zzh;

    public zzbor(zzbot zzbotVar, Object obj, zzavd zzavdVar, Object obj2, zzauz zzauzVar) {
        this.zza = zzbotVar;
        this.zzb = obj;
        this.zze = zzavdVar;
        zzboo zzbooVar = new zzboo(new zzboq(this, null));
        this.zzd = zzbooVar;
        zzbooVar.zzp(zzavdVar);
        this.zzg = zzauzVar;
    }

    public final String toString() {
        return "Address = " + Arrays.toString(((zzbos) this.zzb).zza) + ", state = " + String.valueOf(this.zzf) + ", picker type: " + String.valueOf(this.zzg.getClass()) + ", lb: " + String.valueOf(this.zzd.zzg().getClass()) + (true != this.zzh ? "" : ", deactivated");
    }

    public final zzasu zza() {
        return this.zzf;
    }

    public final zzauz zzb() {
        return this.zzg;
    }

    public final zzavd zzc() {
        return this.zze;
    }

    protected final void zzh() {
        if (this.zzh) {
            return;
        }
        zzk();
        zzbot zzbotVar = this.zza;
        zzbotVar.zzg.remove(this.zzb);
        this.zzh = true;
        zzbot.zzf.logp(Level.FINE, "io.grpc.util.MultiChildLoadBalancer$ChildLbState", "deactivate", "Child balancer {0} deactivated", this.zzb);
    }

    protected final void zzi(zzavd zzavdVar) {
        zzbot.zzf.logp(Level.FINE, "io.grpc.util.MultiChildLoadBalancer$ChildLbState", "reactivate", "Child balancer {0} reactivated", this.zzb);
        this.zzd.zze(this.zzc);
        this.zzh = false;
    }

    protected final void zzj(zzaux zzauxVar) {
        this.zzc = zzauxVar;
    }

    protected final void zzk() {
        this.zzd.zzd();
        this.zzf = zzasu.SHUTDOWN;
        zzbot.zzf.logp(Level.FINE, "io.grpc.util.MultiChildLoadBalancer$ChildLbState", "shutdown", "Child balancer {0} deleted", this.zzb);
    }

    public final boolean zzm() {
        return this.zzh;
    }
}

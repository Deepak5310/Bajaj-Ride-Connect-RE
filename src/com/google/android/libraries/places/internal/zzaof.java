package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzaof {
    private static final zzand zzb = zzand.zza;
    protected volatile zzaoz zza;
    private volatile zzaml zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaof)) {
            return false;
        }
        zzaof zzaofVar = (zzaof) obj;
        zzaoz zzaozVar = this.zza;
        zzaoz zzaozVar2 = zzaofVar.zza;
        if (zzaozVar == null && zzaozVar2 == null) {
            return zzb().equals(zzaofVar.zzb());
        }
        if (zzaozVar != null && zzaozVar2 != null) {
            return zzaozVar.equals(zzaozVar2);
        }
        if (zzaozVar != null) {
            zzaofVar.zzc(zzaozVar.zzaE());
            return zzaozVar.equals(zzaofVar.zza);
        }
        zzc(zzaozVar2.zzaE());
        return this.zza.equals(zzaozVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzami) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzal();
        }
        return 0;
    }

    public final zzaml zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                return this.zzc;
            }
            if (this.zza == null) {
                this.zzc = zzaml.zzb;
            } else {
                this.zzc = this.zza.zzah();
            }
            return this.zzc;
        }
    }

    protected final void zzc(zzaoz zzaozVar) {
        if (this.zza != null) {
            return;
        }
        synchronized (this) {
            if (this.zza != null) {
                return;
            }
            try {
                this.zza = zzaozVar;
                this.zzc = zzaml.zzb;
            } catch (zzaoc unused) {
                this.zza = zzaozVar;
                this.zzc = zzaml.zzb;
            }
        }
    }
}

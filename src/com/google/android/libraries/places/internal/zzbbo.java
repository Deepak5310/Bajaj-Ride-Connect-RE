package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbbo implements zzazk {
    private final zzazk zza;
    private volatile boolean zzb;
    private List zzc = new ArrayList();

    public zzbbo(zzazk zzazkVar) {
        this.zza = zzazkVar;
    }

    private final void zzc(Runnable runnable) {
        synchronized (this) {
            if (this.zzb) {
                runnable.run();
            } else {
                this.zzc.add(runnable);
            }
        }
    }

    public final void zzb() {
        List list;
        List arrayList = new ArrayList();
        while (true) {
            synchronized (this) {
                if (this.zzc.isEmpty()) {
                    this.zzc = null;
                    this.zzb = true;
                    return;
                } else {
                    list = this.zzc;
                    this.zzc = arrayList;
                }
            }
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                ((Runnable) it2.next()).run();
            }
            list.clear();
            arrayList = list;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzazk
    public final void zzd(zzaxd zzaxdVar, zzazj zzazjVar, zzavu zzavuVar) {
        zzc(new zzbbn(this, zzaxdVar, zzazjVar, zzavuVar));
    }

    @Override // com.google.android.libraries.places.internal.zzazk
    public final void zze(zzavu zzavuVar) {
        zzc(new zzbbm(this, zzavuVar));
    }

    @Override // com.google.android.libraries.places.internal.zzbjw
    public final void zzf(zzbjv zzbjvVar) {
        if (this.zzb) {
            this.zza.zzf(zzbjvVar);
        } else {
            zzc(new zzbbk(this, zzbjvVar));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbjw
    public final void zzg() {
        if (this.zzb) {
            this.zza.zzg();
        } else {
            zzc(new zzbbl(this));
        }
    }
}

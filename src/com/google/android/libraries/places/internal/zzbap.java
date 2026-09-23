package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbap extends zzase {
    private final zzase zza;
    private volatile boolean zzb;
    private List zzc = new ArrayList();

    public zzbap(zzase zzaseVar) {
        this.zza = zzaseVar;
    }

    private final void zzg(Runnable runnable) {
        synchronized (this) {
            if (this.zzb) {
                runnable.run();
            } else {
                this.zzc.add(runnable);
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzase
    public final void zza(zzaxd zzaxdVar, zzavu zzavuVar) {
        zzg(new zzban(this, zzaxdVar, zzavuVar));
    }

    @Override // com.google.android.libraries.places.internal.zzase
    public final void zzb(zzavu zzavuVar) {
        if (this.zzb) {
            this.zza.zzb(zzavuVar);
        } else {
            zzg(new zzbal(this, zzavuVar));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzase
    public final void zzc(Object obj) {
        if (this.zzb) {
            this.zza.zzc(obj);
        } else {
            zzg(new zzbam(this, obj));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzase
    public final void zzd() {
        if (this.zzb) {
            this.zza.zzd();
        } else {
            zzg(new zzbao(this));
        }
    }

    final void zzf() {
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
}

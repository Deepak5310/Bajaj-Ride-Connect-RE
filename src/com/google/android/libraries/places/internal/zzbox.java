package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbox extends zzbot {
    static final zzart zzf = zzart.zza("state-info");
    private static final zzaxd zzh = zzaxd.zza.zzg("no subchannels ready");
    protected zzbow zzg;
    private final Random zzi;

    public zzbox(zzaus zzausVar) {
        super(zzausVar);
        this.zzg = new zzbou(zzh);
        this.zzi = new Random();
    }

    private final void zzn(zzasu zzasuVar, zzbow zzbowVar) {
        if (zzasuVar == this.zze && zzbowVar.zzb(this.zzg)) {
            return;
        }
        zzh().zzd(zzasuVar, zzbowVar);
        this.zze = zzasuVar;
        this.zzg = zzbowVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbot
    protected final void zzl() {
        ArrayList arrayList = new ArrayList();
        for (zzbor zzborVar : zzi()) {
            if (!zzborVar.zzm() && zzborVar.zza() == zzasu.READY) {
                arrayList.add(zzborVar);
            }
        }
        if (!arrayList.isEmpty()) {
            zzn(zzasu.READY, zzm(arrayList));
            return;
        }
        Iterator it2 = zzi().iterator();
        while (it2.hasNext()) {
            zzasu zzasuVarZza = ((zzbor) it2.next()).zza();
            if (zzasuVarZza == zzasu.CONNECTING || zzasuVarZza == zzasu.IDLE) {
                zzn(zzasu.CONNECTING, new zzbou(zzaxd.zza));
                return;
            }
        }
        zzn(zzasu.TRANSIENT_FAILURE, zzm(zzi()));
    }

    protected final zzbow zzm(Collection collection) {
        int iNextInt = this.zzi.nextInt(collection.size());
        ArrayList arrayList = new ArrayList();
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            arrayList.add(((zzbor) it2.next()).zzb());
        }
        return new zzbov(arrayList, iNextInt);
    }
}

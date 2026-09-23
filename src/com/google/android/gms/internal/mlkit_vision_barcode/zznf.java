package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zznf implements zznl {
    final List zza;

    public zznf(Context context, zzne zzneVar) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        if (zzneVar.zzc()) {
            arrayList.add(new zznu(context, zzneVar));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zznl
    public final void zza(zznp zznpVar) {
        Iterator it2 = this.zza.iterator();
        while (it2.hasNext()) {
            ((zznl) it2.next()).zza(zznpVar);
        }
    }
}

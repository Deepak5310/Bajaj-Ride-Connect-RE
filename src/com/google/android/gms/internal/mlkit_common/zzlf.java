package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.mlkit:common@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzlf implements zzlk {
    final List zza;

    public zzlf(Context context, zzle zzleVar) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        if (zzleVar.zzc()) {
            arrayList.add(new zzlt(context, zzleVar));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzlk
    public final void zza(zzlc zzlcVar) {
        Iterator it2 = this.zza.iterator();
        while (it2.hasNext()) {
            ((zzlk) it2.next()).zza(zzlcVar);
        }
    }
}

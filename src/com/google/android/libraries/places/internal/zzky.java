package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzky {
    private final zzkb zza;
    private final zzkv zzb;

    private zzky(zzkv zzkvVar, boolean z, zzkb zzkbVar, int i) {
        this.zzb = zzkvVar;
        this.zza = zzkbVar;
    }

    public static zzky zzb(zzkb zzkbVar) {
        return new zzky(new zzkv(zzkbVar), false, zzjz.zza, Integer.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Iterator zzg(CharSequence charSequence) {
        return new zzku(this.zzb, this, charSequence);
    }

    public final zzky zzc(zzkb zzkbVar) {
        zzkbVar.getClass();
        return new zzky(this.zzb, false, zzkbVar, Integer.MAX_VALUE);
    }

    public final Iterable zzd(CharSequence charSequence) {
        charSequence.getClass();
        return new zzkw(this, charSequence);
    }

    public final List zzf(CharSequence charSequence) {
        Iterator itZzg = zzg("3.3.0");
        ArrayList arrayList = new ArrayList();
        while (itZzg.hasNext()) {
            arrayList.add((String) itZzg.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}

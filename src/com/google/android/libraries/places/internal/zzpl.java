package com.google.android.libraries.places.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzpl implements Iterator {
    final /* synthetic */ zzpm zza;
    private int zzb = 0;

    zzpl(zzpm zzpmVar) {
        this.zza = zzpmVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.zzb;
        zzpm zzpmVar = this.zza;
        return i < zzpmVar.zza() - zzpmVar.zzb();
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.zzb;
        zzpm zzpmVar = this.zza;
        if (i >= zzpmVar.zza() - zzpmVar.zzb()) {
            throw new NoSuchElementException();
        }
        zzpm zzpmVar2 = this.zza;
        Object obj = zzpmVar2.zzb.zzb[zzpmVar2.zzb() + i];
        this.zzb = i + 1;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

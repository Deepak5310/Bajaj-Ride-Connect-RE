package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.mlkit:barcode-scanning@@17.0.2 */
/* JADX INFO: loaded from: classes2.dex */
final class zzgt implements Iterator {
    final Iterator zza;
    final /* synthetic */ zzgu zzb;

    zzgt(zzgu zzguVar) {
        this.zzb = zzguVar;
        this.zza = zzguVar.zza.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

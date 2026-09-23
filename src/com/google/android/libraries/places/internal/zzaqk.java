package com.google.android.libraries.places.internal;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaqk implements Iterator {
    final Iterator zza;
    final /* synthetic */ zzaql zzb;

    zzaqk(zzaql zzaqlVar) {
        this.zzb = zzaqlVar;
        this.zza = zzaqlVar.zza.iterator();
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

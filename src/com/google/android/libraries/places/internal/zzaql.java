package com.google.android.libraries.places.internal;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class zzaql extends AbstractList implements RandomAccess, zzaoh {
    private final zzaoh zza;

    public zzaql(zzaoh zzaohVar) {
        this.zza = zzaohVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        return ((zzaog) this.zza).get(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new zzaqk(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new zzaqj(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.libraries.places.internal.zzaoh
    public final zzaoh zze() {
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzaoh
    public final Object zzf(int i) {
        return this.zza.zzf(i);
    }

    @Override // com.google.android.libraries.places.internal.zzaoh
    public final List zzh() {
        return this.zza.zzh();
    }

    @Override // com.google.android.libraries.places.internal.zzaoh
    public final void zzi(zzaml zzamlVar) {
        throw new UnsupportedOperationException();
    }
}

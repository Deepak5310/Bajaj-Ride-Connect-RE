package com.google.android.libraries.places.internal;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzkw implements Iterable {
    final /* synthetic */ CharSequence zza;
    final /* synthetic */ zzky zzb;

    zzkw(zzky zzkyVar, CharSequence charSequence) {
        this.zzb = zzkyVar;
        this.zza = charSequence;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.zzb.zzg(this.zza);
    }

    public final String toString() {
        zzki zzkiVarZzc = zzki.zzc(", ");
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        zzkiVarZzc.zzg(sb, iterator());
        sb.append(']');
        return sb.toString();
    }
}

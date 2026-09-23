package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbii {
    final boolean zza;

    @Nullable
    final List zzb;
    final Collection zzc;
    final Collection zzd;
    final int zze;

    @Nullable
    final zzbir zzf;
    final boolean zzg;
    final boolean zzh;

    zzbii(@Nullable List list, Collection collection, Collection collection2, @Nullable zzbir zzbirVar, boolean z, boolean z2, boolean z3, int i) {
        this.zzb = list;
        zzkt.zzc(collection, "drainedSubstreams");
        this.zzc = collection;
        this.zzf = zzbirVar;
        this.zzd = collection2;
        this.zzg = z;
        this.zza = z2;
        this.zzh = z3;
        this.zze = i;
        zzkt.zzo(!z2 || list == null, "passThrough should imply buffer is null");
        zzkt.zzo((z2 && zzbirVar == null) ? false : true, "passThrough should imply winningSubstream != null");
        zzkt.zzo(!z2 || (collection.size() == 1 && collection.contains(zzbirVar)) || (collection.size() == 0 && zzbirVar.zzb), "passThrough should imply winningSubstream is drained");
        zzkt.zzo((z && zzbirVar == null) ? false : true, "cancelled should imply committed");
    }

    @CheckReturnValue
    final zzbii zza(zzbir zzbirVar) {
        Collection collectionUnmodifiableCollection;
        zzkt.zzo(!this.zzh, "hedging frozen");
        zzkt.zzo(this.zzf == null, "already committed");
        Collection collection = this.zzd;
        if (collection == null) {
            collectionUnmodifiableCollection = Collections.singleton(zzbirVar);
        } else {
            ArrayList arrayList = new ArrayList(collection);
            arrayList.add(zzbirVar);
            collectionUnmodifiableCollection = Collections.unmodifiableCollection(arrayList);
        }
        return new zzbii(this.zzb, this.zzc, collectionUnmodifiableCollection, this.zzf, this.zzg, this.zza, this.zzh, this.zze + 1);
    }

    @CheckReturnValue
    final zzbii zzb() {
        return this.zzh ? this : new zzbii(this.zzb, this.zzc, this.zzd, this.zzf, this.zzg, this.zza, true, this.zze);
    }

    @CheckReturnValue
    final zzbii zzc(zzbir zzbirVar) {
        Collection collectionUnmodifiableCollection;
        zzkt.zzo(!this.zza, "Already passThrough");
        if (zzbirVar.zzb) {
            collectionUnmodifiableCollection = this.zzc;
        } else if (this.zzc.isEmpty()) {
            collectionUnmodifiableCollection = Collections.singletonList(zzbirVar);
        } else {
            ArrayList arrayList = new ArrayList(this.zzc);
            arrayList.add(zzbirVar);
            collectionUnmodifiableCollection = Collections.unmodifiableCollection(arrayList);
        }
        Collection collection = collectionUnmodifiableCollection;
        zzbir zzbirVar2 = this.zzf;
        boolean z = zzbirVar2 != null;
        List list = this.zzb;
        if (z) {
            zzkt.zzo(zzbirVar2 == zzbirVar, "Another RPC attempt has already committed");
            list = null;
        }
        return new zzbii(list, collection, this.zzd, this.zzf, this.zzg, z, this.zzh, this.zze);
    }
}

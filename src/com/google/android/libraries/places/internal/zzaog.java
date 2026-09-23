package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaog extends zzaly implements RandomAccess, zzaoh {

    @Deprecated
    public static final zzaoh zza;
    private static final zzaog zzb;
    private final List zzc;

    static {
        zzaog zzaogVar = new zzaog(false);
        zzb = zzaogVar;
        zza = zzaogVar;
    }

    public zzaog() {
        this(10);
    }

    private static String zzj(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        return obj instanceof zzaml ? ((zzaml) obj).zzm(zzaoa.zzb) : zzaoa.zzd((byte[]) obj);
    }

    @Override // com.google.android.libraries.places.internal.zzaly, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        zza();
        this.zzc.add(i, (String) obj);
        this.modCount++;
    }

    @Override // com.google.android.libraries.places.internal.zzaly, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        zza();
        if (collection instanceof zzaoh) {
            collection = ((zzaoh) collection).zzh();
        }
        boolean zAddAll = this.zzc.addAll(i, collection);
        this.modCount++;
        return zAddAll;
    }

    @Override // com.google.android.libraries.places.internal.zzaly, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zza();
        this.zzc.clear();
        this.modCount++;
    }

    @Override // com.google.android.libraries.places.internal.zzaly, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zza();
        Object objRemove = this.zzc.remove(i);
        this.modCount++;
        return zzj(objRemove);
    }

    @Override // com.google.android.libraries.places.internal.zzaly, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        zza();
        return zzj(this.zzc.set(i, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc.size();
    }

    @Override // com.google.android.libraries.places.internal.zzanz
    public final /* bridge */ /* synthetic */ zzanz zzd(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.zzc);
        return new zzaog(arrayList);
    }

    @Override // com.google.android.libraries.places.internal.zzaoh
    public final zzaoh zze() {
        return zzc() ? new zzaql(this) : this;
    }

    @Override // com.google.android.libraries.places.internal.zzaoh
    public final Object zzf(int i) {
        return this.zzc.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final String get(int i) {
        Object obj = this.zzc.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzaml) {
            zzaml zzamlVar = (zzaml) obj;
            String strZzm = zzamlVar.zzm(zzaoa.zzb);
            if (zzamlVar.zzi()) {
                this.zzc.set(i, strZzm);
            }
            return strZzm;
        }
        byte[] bArr = (byte[]) obj;
        String strZzd = zzaoa.zzd(bArr);
        if (zzaqv.zze(bArr)) {
            this.zzc.set(i, strZzd);
        }
        return strZzd;
    }

    @Override // com.google.android.libraries.places.internal.zzaoh
    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    @Override // com.google.android.libraries.places.internal.zzaoh
    public final void zzi(zzaml zzamlVar) {
        zza();
        this.zzc.add(zzamlVar);
        this.modCount++;
    }

    public zzaog(int i) {
        ArrayList arrayList = new ArrayList(i);
        super(true);
        this.zzc = arrayList;
    }

    private zzaog(ArrayList arrayList) {
        super(true);
        this.zzc = arrayList;
    }

    private zzaog(boolean z) {
        super(false);
        this.zzc = Collections.emptyList();
    }

    @Override // com.google.android.libraries.places.internal.zzaly, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}

package com.google.android.libraries.places.internal;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzma implements Map, Serializable {

    @CheckForNull
    private transient zzmb zza;

    @CheckForNull
    private transient zzmb zzb;

    @CheckForNull
    private transient zzlt zzc;

    zzma() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static zzma zzc(Iterable iterable) {
        zzlz zzlzVar = new zzlz(iterable instanceof Collection ? iterable.size() : 4);
        zzlzVar.zzb(iterable);
        return zzlzVar.zzc();
    }

    public static zzma zzd() {
        return zzmr.zza;
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean containsKey(@CheckForNull Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(@CheckForNull Object obj) {
        return values().contains(obj);
    }

    @Override // java.util.Map
    public final boolean equals(@CheckForNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    @CheckForNull
    public abstract Object get(@CheckForNull Object obj);

    @Override // java.util.Map
    @CheckForNull
    public final Object getOrDefault(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        return zzmt.zza(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        zzmb zzmbVar = this.zzb;
        if (zzmbVar != null) {
            return zzmbVar;
        }
        zzmb zzmbVarZzf = zzf();
        this.zzb = zzmbVarZzf;
        return zzmbVarZzf;
    }

    @Override // java.util.Map
    @CheckForNull
    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @CheckForNull
    @Deprecated
    public final Object remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        if (size < 0) {
            throw new IllegalArgumentException("size cannot be negative but was: " + size);
        }
        StringBuilder sb = new StringBuilder((int) Math.min(((long) size) * 8, 1073741824L));
        sb.append('{');
        boolean z = true;
        for (Map.Entry entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z = false;
        }
        sb.append('}');
        return sb.toString();
    }

    abstract zzlt zza();

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzlt values() {
        zzlt zzltVar = this.zzc;
        if (zzltVar != null) {
            return zzltVar;
        }
        zzlt zzltVarZza = zza();
        this.zzc = zzltVarZza;
        return zzltVarZza;
    }

    abstract zzmb zze();

    abstract zzmb zzf();

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final zzmb entrySet() {
        zzmb zzmbVar = this.zza;
        if (zzmbVar != null) {
            return zzmbVar;
        }
        zzmb zzmbVarZze = zze();
        this.zza = zzmbVarZze;
        return zzmbVarZze;
    }
}

package com.google.android.gms.internal.mlkit_common;

import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.mlkit:common@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaw extends zzao {
    static final zzao zza = new zzaw(null, new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    private zzaw(@CheckForNull Object obj, Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    static zzaw zzg(int i, Object[] objArr, zzan zzanVar) {
        Object obj = objArr[0];
        obj.getClass();
        Object obj2 = objArr[1];
        obj2.getClass();
        zzae.zza(obj, obj2);
        return new zzaw(null, objArr, 1);
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0007  */
    @Override // com.google.android.gms.internal.mlkit_common.zzao, java.util.Map
    @CheckForNull
    public final Object get(@CheckForNull Object obj) {
        Object obj2;
        Object[] objArr = this.zzb;
        int i = this.zzc;
        if (obj != null && i == 1) {
            Object obj3 = objArr[0];
            obj3.getClass();
            if (obj3.equals(obj)) {
                obj2 = objArr[1];
                obj2.getClass();
            } else {
                obj2 = null;
            }
        } else {
            obj2 = null;
        }
        if (obj2 == null) {
            return null;
        }
        return obj2;
    }

    @Override // java.util.Map
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzao
    final zzai zza() {
        return new zzav(this.zzb, 1, this.zzc);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzao
    final zzap zzd() {
        return new zzat(this, this.zzb, 0, this.zzc);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzao
    final zzap zze() {
        return new zzau(this, new zzav(this.zzb, 0, this.zzc));
    }
}

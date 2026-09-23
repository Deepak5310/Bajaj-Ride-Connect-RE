package com.google.android.libraries.places.internal;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzlu extends zzlr {
    public zzlu() {
        super(4);
    }

    public final zzlu zzb(Object obj) {
        int i = this.zzb + 1;
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (length < i) {
            this.zza = Arrays.copyOf(objArr, zzlr.zza(length, i));
            this.zzc = false;
        } else if (this.zzc) {
            this.zza = (Object[]) objArr.clone();
            this.zzc = false;
        }
        Object[] objArr2 = this.zza;
        int i2 = this.zzb;
        this.zzb = i2 + 1;
        objArr2[i2] = obj;
        return this;
    }

    public final zzlx zzc() {
        this.zzc = true;
        return zzlx.zzi(this.zza, this.zzb);
    }
}

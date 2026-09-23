package com.google.android.libraries.places.internal;

import java.net.SocketAddress;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbos {
    final String[] zza;
    final int zzb;

    zzbos(zzati zzatiVar) {
        zzkt.zzc(zzatiVar, "eag");
        this.zza = new String[zzatiVar.zzb().size()];
        Iterator it2 = zzatiVar.zzb().iterator();
        while (it2.hasNext()) {
            this.zza[0] = ((SocketAddress) it2.next()).toString();
        }
        Arrays.sort(this.zza);
        this.zzb = Arrays.hashCode(this.zza);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzbos)) {
            return false;
        }
        zzbos zzbosVar = (zzbos) obj;
        if (zzbosVar.zzb == this.zzb) {
            String[] strArr = zzbosVar.zza;
            String[] strArr2 = this.zza;
            if (strArr.length == strArr2.length) {
                return Arrays.equals(strArr, strArr2);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zzb;
    }

    public final String toString() {
        return Arrays.toString(this.zza);
    }
}

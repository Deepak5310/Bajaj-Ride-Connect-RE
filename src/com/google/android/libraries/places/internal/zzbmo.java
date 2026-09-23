package com.google.android.libraries.places.internal;

import java.lang.reflect.Method;
import java.security.Provider;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbmo extends zzbmt {
    private final zzbmk zzb;
    private final zzbmk zzc;
    private final Method zzd;
    private final Method zze;
    private final zzbmk zzf;
    private final zzbmk zzg;
    private final int zzh;

    public zzbmo(zzbmk zzbmkVar, zzbmk zzbmkVar2, Method method, Method method2, zzbmk zzbmkVar3, zzbmk zzbmkVar4, Provider provider, int i) {
        super(provider);
        this.zzb = zzbmkVar;
        this.zzc = zzbmkVar2;
        this.zzd = method;
        this.zze = method2;
        this.zzf = zzbmkVar3;
        this.zzg = zzbmkVar4;
        this.zzh = i;
    }

    @Override // com.google.android.libraries.places.internal.zzbmt
    public final String zza(SSLSocket sSLSocket) {
        byte[] bArr;
        if (this.zzf.zzc(sSLSocket) && (bArr = (byte[]) this.zzf.zzb(sSLSocket, new Object[0])) != null) {
            return new String(bArr, zzbmw.zzb);
        }
        return null;
    }

    @Override // com.google.android.libraries.places.internal.zzbmt
    public final void zzb(SSLSocket sSLSocket, String str, List list) {
        if (str != null) {
            this.zzb.zza(sSLSocket, true);
            this.zzc.zza(sSLSocket, str);
        }
        if (this.zzg.zzc(sSLSocket)) {
            this.zzg.zzb(sSLSocket, zzg(list));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbmt
    public final int zzc() {
        return this.zzh;
    }
}

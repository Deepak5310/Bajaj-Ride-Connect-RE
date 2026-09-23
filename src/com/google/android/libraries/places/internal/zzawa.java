package com.google.android.libraries.places.internal;

import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReferenceArray;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzawa {
    private final zzavy zza;
    private final String zzb;

    @Nullable
    private final String zzc;
    private final zzavx zzd;
    private final zzavx zze;
    private final boolean zzf;
    private final AtomicReferenceArray zzg = new AtomicReferenceArray(2);

    /* synthetic */ zzawa(zzavy zzavyVar, String str, zzavx zzavxVar, zzavx zzavxVar2, Object obj, boolean z, boolean z2, boolean z3, zzavz zzavzVar) {
        zzkt.zzc(zzavyVar, "type");
        this.zza = zzavyVar;
        zzkt.zzc(str, "fullMethodName");
        this.zzb = str;
        zzkt.zzc(str, "fullMethodName");
        int iLastIndexOf = str.lastIndexOf(47);
        this.zzc = iLastIndexOf == -1 ? null : str.substring(0, iLastIndexOf);
        zzkt.zzc(zzavxVar, "requestMarshaller");
        this.zzd = zzavxVar;
        zzkt.zzc(zzavxVar2, "responseMarshaller");
        this.zze = zzavxVar2;
        this.zzf = z3;
    }

    @CheckReturnValue
    public static zzavw zza(zzavx zzavxVar, zzavx zzavxVar2) {
        zzavw zzavwVar = new zzavw(null);
        zzavwVar.zzb(null);
        zzavwVar.zzc(null);
        return zzavwVar;
    }

    public static String zze(String str, String str2) {
        zzkt.zzc(str, "fullServiceName");
        zzkt.zzc(str2, "methodName");
        return str + RemoteSettings.FORWARD_SLASH_STRING + str2;
    }

    public final String toString() {
        zzkn zzknVarZzb = zzko.zzb(this);
        zzknVarZzb.zzd("fullMethodName", this.zzb);
        zzknVarZzb.zzd("type", this.zza);
        zzknVarZzb.zze("idempotent", false);
        zzknVarZzb.zze("safe", false);
        zzknVarZzb.zze("sampledToLocalTracing", this.zzf);
        zzknVarZzb.zzd("requestMarshaller", this.zzd);
        zzknVarZzb.zzd("responseMarshaller", this.zze);
        zzknVarZzb.zzd("schemaDescriptor", null);
        zzknVarZzb.zzg();
        return zzknVarZzb.toString();
    }

    public final zzavy zzb() {
        return this.zza;
    }

    public final InputStream zzc(Object obj) {
        return this.zzd.zza(obj);
    }

    public final Object zzd(InputStream inputStream) {
        return this.zze.zzb(inputStream);
    }

    public final String zzf() {
        return this.zzb;
    }

    @Nullable
    public final String zzg() {
        return this.zzc;
    }
}

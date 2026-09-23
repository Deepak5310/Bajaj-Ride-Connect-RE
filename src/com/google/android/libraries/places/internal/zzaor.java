package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaor implements zzapn {
    private static final zzaox zza = new zzaop();
    private final zzaox zzb;

    public zzaor() {
        zzaox zzaoxVar;
        zzaox[] zzaoxVarArr = new zzaox[2];
        zzaoxVarArr[0] = zzanl.zza();
        try {
            zzaoxVar = (zzaox) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            zzaoxVar = zza;
        }
        zzaoxVarArr[1] = zzaoxVar;
        zzaoq zzaoqVar = new zzaoq(zzaoxVarArr);
        byte[] bArr = zzaoa.zzd;
        this.zzb = zzaoqVar;
    }

    private static boolean zzb(zzaow zzaowVar) {
        return zzaowVar.zzc() + (-1) != 1;
    }

    @Override // com.google.android.libraries.places.internal.zzapn
    public final zzapm zza(Class cls) {
        zzapo.zzr(cls);
        zzaow zzaowVarZzb = this.zzb.zzb(cls);
        if (zzaowVarZzb.zzb()) {
            return zzanr.class.isAssignableFrom(cls) ? zzapd.zzi(zzapo.zzn(), zzang.zzb(), zzaowVarZzb.zza()) : zzapd.zzi(zzapo.zzm(), zzang.zza(), zzaowVarZzb.zza());
        }
        if (zzanr.class.isAssignableFrom(cls)) {
            return zzb(zzaowVarZzb) ? zzapc.zzi(cls, zzaowVarZzb, zzapf.zzb(), zzaon.zze(), zzapo.zzn(), zzang.zzb(), zzaov.zzb()) : zzapc.zzi(cls, zzaowVarZzb, zzapf.zzb(), zzaon.zze(), zzapo.zzn(), null, zzaov.zzb());
        }
        return zzb(zzaowVarZzb) ? zzapc.zzi(cls, zzaowVarZzb, zzapf.zza(), zzaon.zzd(), zzapo.zzm(), zzang.zza(), zzaov.zza()) : zzapc.zzi(cls, zzaowVarZzb, zzapf.zza(), zzaon.zzd(), zzapo.zzm(), null, zzaov.zza());
    }
}

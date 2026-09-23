package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: com.google.mlkit:barcode-scanning@@17.0.2 */
/* JADX INFO: loaded from: classes2.dex */
final class zzfd implements zzgc {
    private static final zzfj zza = new zzfb();
    private final zzfj zzb;

    public zzfd() {
        zzfj zzfjVar;
        zzfj[] zzfjVarArr = new zzfj[2];
        zzfjVarArr[0] = zzdv.zza();
        try {
            zzfjVar = (zzfj) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            zzfjVar = zza;
        }
        zzfjVarArr[1] = zzfjVar;
        zzfc zzfcVar = new zzfc(zzfjVarArr);
        zzel.zzf(zzfcVar, "messageInfoFactory");
        this.zzb = zzfcVar;
    }

    private static boolean zzb(zzfi zzfiVar) {
        return zzfiVar.zzc() == 1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgc
    public final zzgb zza(Class cls) {
        zzgd.zzG(cls);
        zzfi zzfiVarZzb = this.zzb.zzb(cls);
        if (zzfiVarZzb.zzb()) {
            return zzec.class.isAssignableFrom(cls) ? zzfp.zzc(zzgd.zzB(), zzdq.zzb(), zzfiVarZzb.zza()) : zzfp.zzc(zzgd.zzz(), zzdq.zza(), zzfiVarZzb.zza());
        }
        if (zzec.class.isAssignableFrom(cls)) {
            return zzb(zzfiVarZzb) ? zzfo.zzk(cls, zzfiVarZzb, zzfs.zzb(), zzez.zzd(), zzgd.zzB(), zzdq.zzb(), zzfh.zzb()) : zzfo.zzk(cls, zzfiVarZzb, zzfs.zzb(), zzez.zzd(), zzgd.zzB(), null, zzfh.zzb());
        }
        return zzb(zzfiVarZzb) ? zzfo.zzk(cls, zzfiVarZzb, zzfs.zza(), zzez.zzc(), zzgd.zzz(), zzdq.zza(), zzfh.zza()) : zzfo.zzk(cls, zzfiVarZzb, zzfs.zza(), zzez.zzc(), zzgd.zzA(), null, zzfh.zza());
    }
}

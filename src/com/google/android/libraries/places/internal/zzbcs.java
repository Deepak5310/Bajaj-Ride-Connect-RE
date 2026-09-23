package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public enum zzbcs {
    NO_ERROR(0, zzaxd.zzp),
    PROTOCOL_ERROR(1, zzaxd.zzo),
    INTERNAL_ERROR(2, zzaxd.zzo),
    FLOW_CONTROL_ERROR(3, zzaxd.zzo),
    SETTINGS_TIMEOUT(4, zzaxd.zzo),
    STREAM_CLOSED(5, zzaxd.zzo),
    FRAME_SIZE_ERROR(6, zzaxd.zzo),
    REFUSED_STREAM(7, zzaxd.zzp),
    CANCEL(8, zzaxd.zzb),
    COMPRESSION_ERROR(9, zzaxd.zzo),
    CONNECT_ERROR(10, zzaxd.zzo),
    ENHANCE_YOUR_CALM(11, zzaxd.zzj.zzg("Bandwidth exhausted")),
    INADEQUATE_SECURITY(12, zzaxd.zzh.zzg("Permission denied as protocol is not secure enough to call")),
    HTTP_1_1_REQUIRED(13, zzaxd.zzc);

    private static final zzbcs[] zzo;
    private final int zzq;
    private final zzaxd zzr;

    static {
        zzbcs[] zzbcsVarArrValues = values();
        zzbcs[] zzbcsVarArr = new zzbcs[zzbcsVarArrValues[zzbcsVarArrValues.length - 1].zzq + 1];
        for (zzbcs zzbcsVar : zzbcsVarArrValues) {
            zzbcsVarArr[zzbcsVar.zzq] = zzbcsVar;
        }
        zzo = zzbcsVarArr;
    }

    zzbcs(int i, zzaxd zzaxdVar) {
        this.zzq = i;
        String strConcat = "HTTP/2 error code: ".concat(String.valueOf(name()));
        if (zzaxdVar.zzi() != null) {
            strConcat = strConcat + " (" + zzaxdVar.zzi() + ")";
        }
        this.zzr = zzaxdVar.zzg(strConcat);
    }

    public static zzaxd zza(long j) {
        zzbcs[] zzbcsVarArr = zzo;
        zzbcs zzbcsVar = null;
        if (j < zzbcsVarArr.length && j >= 0) {
            zzbcsVar = zzbcsVarArr[(int) j];
        }
        if (zzbcsVar != null) {
            return zzbcsVar.zzr;
        }
        return zzaxd.zzd(INTERNAL_ERROR.zzr.zza().zza()).zzg("Unrecognized HTTP/2 error code: " + j);
    }
}

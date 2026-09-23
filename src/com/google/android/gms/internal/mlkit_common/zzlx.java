package com.google.android.gms.internal.mlkit_common;

import android.os.SystemClock;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* JADX INFO: compiled from: com.google.mlkit:common@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzlx {
    private static final GmsLogger zza = new GmsLogger("RemoteModelUtils", "");

    public static zzil zza(RemoteModel remoteModel, SharedPrefManager sharedPrefManager, zzln zzlnVar) {
        zzin zzinVar;
        ModelType modelTypeZzb = zzlnVar.zzb();
        String modelHash = remoteModel.getModelHash();
        zzir zzirVar = new zzir();
        zzim zzimVar = new zzim();
        zzimVar.zzc(remoteModel.getModelNameForBackend());
        zzimVar.zzd(zzio.CLOUD);
        zzimVar.zza(zzac.zzb(modelHash));
        int iOrdinal = modelTypeZzb.ordinal();
        if (iOrdinal == 2) {
            zzinVar = zzin.BASE_TRANSLATE;
        } else if (iOrdinal != 4) {
            zzinVar = iOrdinal != 5 ? zzin.TYPE_UNKNOWN : zzin.BASE_DIGITAL_INK;
        } else {
            zzinVar = zzin.CUSTOM;
        }
        zzimVar.zzb(zzinVar);
        zzirVar.zzb(zzimVar.zzg());
        zziu zziuVarZzc = zzirVar.zzc();
        zzii zziiVar = new zzii();
        zziiVar.zzd(zzlnVar.zzc());
        zziiVar.zzc(zzlnVar.zzd());
        zziiVar.zzb(Long.valueOf(zzlnVar.zza()));
        zziiVar.zzf(zziuVarZzc);
        if (zzlnVar.zzg()) {
            long modelDownloadBeginTimeMs = sharedPrefManager.getModelDownloadBeginTimeMs(remoteModel);
            if (modelDownloadBeginTimeMs == 0) {
                zza.w("RemoteModelUtils", "Model downloaded without its beginning time recorded.");
            } else {
                long modelFirstUseTimeMs = sharedPrefManager.getModelFirstUseTimeMs(remoteModel);
                if (modelFirstUseTimeMs == 0) {
                    modelFirstUseTimeMs = SystemClock.elapsedRealtime();
                    sharedPrefManager.setModelFirstUseTimeMs(remoteModel, modelFirstUseTimeMs);
                }
                zziiVar.zzg(Long.valueOf(modelFirstUseTimeMs - modelDownloadBeginTimeMs));
            }
        }
        if (zzlnVar.zzf()) {
            long modelDownloadBeginTimeMs2 = sharedPrefManager.getModelDownloadBeginTimeMs(remoteModel);
            if (modelDownloadBeginTimeMs2 == 0) {
                zza.w("RemoteModelUtils", "Model downloaded without its beginning time recorded.");
            } else {
                zziiVar.zze(Long.valueOf(SystemClock.elapsedRealtime() - modelDownloadBeginTimeMs2));
            }
        }
        return zziiVar.zzi();
    }
}

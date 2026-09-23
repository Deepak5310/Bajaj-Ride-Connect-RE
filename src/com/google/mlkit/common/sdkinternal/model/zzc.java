package com.google.mlkit.common.sdkinternal.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.mlkit_common.zzid;
import com.google.android.gms.internal.mlkit_common.zzij;
import com.google.android.gms.internal.mlkit_common.zzlc;
import com.google.android.gms.internal.mlkit_common.zzll;
import com.google.android.gms.internal.mlkit_common.zzlm;
import com.google.android.gms.internal.mlkit_common.zzln;
import com.google.android.gms.internal.mlkit_common.zzlo;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.RemoteModel;

/* JADX INFO: compiled from: com.google.mlkit:common@@18.0.0 */
/* JADX INFO: loaded from: classes6.dex */
final class zzc extends BroadcastReceiver {
    final /* synthetic */ RemoteModelDownloadManager zza;
    private final long zzb;
    private final TaskCompletionSource zzc;

    /* synthetic */ zzc(RemoteModelDownloadManager remoteModelDownloadManager, long j, TaskCompletionSource taskCompletionSource, zzb zzbVar) {
        this.zza = remoteModelDownloadManager;
        this.zzb = j;
        this.zzc = taskCompletionSource;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        long longExtra = intent.getLongExtra("extra_download_id", -1L);
        if (longExtra != this.zzb) {
            return;
        }
        Integer downloadingModelStatusCode = this.zza.getDownloadingModelStatusCode();
        synchronized (this.zza) {
            try {
                this.zza.zze.getApplicationContext().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                RemoteModelDownloadManager.zza.w("ModelDownloadManager", "Exception thrown while trying to unregister the broadcast receiver for the download", e);
            }
            this.zza.zzc.remove(this.zzb);
            this.zza.zzd.remove(this.zzb);
        }
        if (downloadingModelStatusCode != null) {
            if (downloadingModelStatusCode.intValue() == 16) {
                zzll zzllVar = this.zza.zzi;
                zzlc zzlcVarZzg = zzlo.zzg();
                RemoteModelDownloadManager remoteModelDownloadManager = this.zza;
                RemoteModel remoteModel = remoteModelDownloadManager.zzg;
                Long lValueOf = Long.valueOf(longExtra);
                zzllVar.zzd(zzlcVarZzg, remoteModel, false, remoteModelDownloadManager.getFailureReason(lValueOf));
                this.zzc.setException(this.zza.zzl(lValueOf));
                return;
            }
            if (downloadingModelStatusCode.intValue() == 8) {
                zzll zzllVar2 = this.zza.zzi;
                zzlc zzlcVarZzg2 = zzlo.zzg();
                RemoteModel remoteModel2 = this.zza.zzg;
                zzlm zzlmVarZzh = zzln.zzh();
                zzlmVarZzh.zzb(zzid.NO_ERROR);
                zzlmVarZzh.zze(true);
                zzlmVarZzh.zzd(this.zza.zzg.getModelType());
                zzlmVarZzh.zza(zzij.SUCCEEDED);
                zzllVar2.zzf(zzlcVarZzg2, remoteModel2, zzlmVarZzh.zzh());
                this.zzc.setResult(null);
                return;
            }
        }
        this.zza.zzi.zzd(zzlo.zzg(), this.zza.zzg, false, 0);
        this.zzc.setException(new MlKitException("Model downloading failed", 13));
    }
}

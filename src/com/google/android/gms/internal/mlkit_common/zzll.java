package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import android.content.res.Resources;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.mlkit:common@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzll {
    public static final /* synthetic */ int zza = 0;
    private static zzam zzb;
    private static final zzao zzc = zzao.zzc("optional-module-barcode", "com.google.android.gms.vision.barcode");
    private final String zzd;
    private final String zze;
    private final zzlk zzf;
    private final SharedPrefManager zzg;
    private final Task zzh;
    private final Task zzi;
    private final String zzj;
    private final int zzk;
    private final Map zzl = new HashMap();
    private final Map zzm = new HashMap();

    public zzll(Context context, final SharedPrefManager sharedPrefManager, zzlk zzlkVar, final String str) {
        this.zzd = context.getPackageName();
        this.zze = CommonUtils.getAppVersion(context);
        this.zzg = sharedPrefManager;
        this.zzf = zzlkVar;
        this.zzj = str;
        this.zzh = MLTaskExecutor.getInstance().scheduleCallable(new Callable() { // from class: com.google.android.gms.internal.mlkit_common.zzlj
            @Override // java.util.concurrent.Callable
            public final Object call() {
                String str2 = str;
                int i = zzll.zza;
                return LibraryVersion.getInstance().getVersion(str2);
            }
        });
        MLTaskExecutor mLTaskExecutor = MLTaskExecutor.getInstance();
        sharedPrefManager.getClass();
        this.zzi = mLTaskExecutor.scheduleCallable(new Callable() { // from class: com.google.android.gms.internal.mlkit_common.zzli
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return sharedPrefManager.getMlSdkInstanceId();
            }
        });
        zzao zzaoVar = zzc;
        this.zzk = zzaoVar.containsKey(str) ? DynamiteModule.getRemoteVersion(context, (String) zzaoVar.get(str)) : -1;
    }

    private static synchronized zzam zzg() {
        zzam zzamVar = zzb;
        if (zzamVar != null) {
            return zzamVar;
        }
        LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
        zzaj zzajVar = new zzaj();
        for (int i = 0; i < locales.size(); i++) {
            zzajVar.zzb(CommonUtils.languageTagFromLocale(locales.get(i)));
        }
        zzam zzamVarZzc = zzajVar.zzc();
        zzb = zzamVarZzc;
        return zzamVarZzc;
    }

    private final zzjz zzh(String str, String str2) {
        zzjz zzjzVar = new zzjz();
        zzjzVar.zzb(this.zzd);
        zzjzVar.zzc(this.zze);
        zzjzVar.zzh(zzg());
        zzjzVar.zzg(true);
        zzjzVar.zzl(str);
        zzjzVar.zzj(str2);
        zzjzVar.zzi(this.zzi.isSuccessful() ? (String) this.zzi.getResult() : this.zzg.getMlSdkInstanceId());
        zzjzVar.zzd(10);
        zzjzVar.zzk(Integer.valueOf(this.zzk));
        return zzjzVar;
    }

    private final String zzi() {
        return this.zzh.isSuccessful() ? (String) this.zzh.getResult() : LibraryVersion.getInstance().getVersion(this.zzj);
    }

    final /* synthetic */ void zza(zzlc zzlcVar, zzie zzieVar, String str) {
        zzlcVar.zza(zzieVar);
        zzlcVar.zzc(zzh(zzlcVar.zzd(), str));
        this.zzf.zza(zzlcVar);
    }

    final /* synthetic */ void zzb(zzlc zzlcVar, zzln zzlnVar, RemoteModel remoteModel) {
        zzlcVar.zza(zzie.MODEL_DOWNLOAD);
        zzlcVar.zzc(zzh(zzlnVar.zze(), zzi()));
        zzlcVar.zzb(zzlx.zza(remoteModel, this.zzg, zzlnVar));
        this.zzf.zza(zzlcVar);
    }

    public final void zzc(final zzlc zzlcVar, final zzie zzieVar) {
        final String strZzi = zzi();
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable() { // from class: com.google.android.gms.internal.mlkit_common.zzlg
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza(zzlcVar, zzieVar, strZzi);
            }
        });
    }

    public final void zzd(zzlc zzlcVar, RemoteModel remoteModel, boolean z, int i) {
        zzlm zzlmVarZzh = zzln.zzh();
        zzlmVarZzh.zzf(false);
        zzlmVarZzh.zzd(remoteModel.getModelType());
        zzlmVarZzh.zza(zzij.FAILED);
        zzlmVarZzh.zzb(zzid.DOWNLOAD_FAILED);
        zzlmVarZzh.zzc(i);
        zzf(zzlcVar, remoteModel, zzlmVarZzh.zzh());
    }

    public final void zze(zzlc zzlcVar, RemoteModel remoteModel, zzid zzidVar, boolean z, ModelType modelType, zzij zzijVar) {
        zzlm zzlmVarZzh = zzln.zzh();
        zzlmVarZzh.zzf(z);
        zzlmVarZzh.zzd(modelType);
        zzlmVarZzh.zzb(zzidVar);
        zzlmVarZzh.zza(zzijVar);
        zzf(zzlcVar, remoteModel, zzlmVarZzh.zzh());
    }

    public final void zzf(final zzlc zzlcVar, final RemoteModel remoteModel, final zzln zzlnVar) {
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable() { // from class: com.google.android.gms.internal.mlkit_common.zzlh
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzb(zzlcVar, zzlnVar, remoteModel);
            }
        });
    }
}

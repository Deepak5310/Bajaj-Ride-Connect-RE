package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.mlkit:vision-common@@17.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzjt {
    public static final /* synthetic */ int zza = 0;
    private static zzp zzb;
    private static final zzr zzc = zzr.zzc("optional-module-barcode", "com.google.android.gms.vision.barcode");
    private final String zzd;
    private final String zze;
    private final zzjs zzf;
    private final SharedPrefManager zzg;
    private final Task zzh;
    private final Task zzi;
    private final String zzj;
    private final int zzk;
    private final Map zzl = new HashMap();
    private final Map zzm = new HashMap();

    public zzjt(Context context, final SharedPrefManager sharedPrefManager, zzjs zzjsVar, final String str) {
        this.zzd = context.getPackageName();
        this.zze = CommonUtils.getAppVersion(context);
        this.zzg = sharedPrefManager;
        this.zzf = zzjsVar;
        this.zzj = str;
        this.zzh = MLTaskExecutor.getInstance().scheduleCallable(new Callable() { // from class: com.google.android.gms.internal.mlkit_vision_common.zzjr
            @Override // java.util.concurrent.Callable
            public final Object call() {
                String str2 = str;
                int i = zzjt.zza;
                return LibraryVersion.getInstance().getVersion(str2);
            }
        });
        MLTaskExecutor mLTaskExecutor = MLTaskExecutor.getInstance();
        sharedPrefManager.getClass();
        this.zzi = mLTaskExecutor.scheduleCallable(new Callable() { // from class: com.google.android.gms.internal.mlkit_vision_common.zzjq
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return sharedPrefManager.getMlSdkInstanceId();
            }
        });
        zzr zzrVar = zzc;
        this.zzk = zzrVar.containsKey(str) ? DynamiteModule.getRemoteVersion(context, (String) zzrVar.get(str)) : -1;
    }

    private static synchronized zzp zzc() {
        zzp zzpVar = zzb;
        if (zzpVar != null) {
            return zzpVar;
        }
        LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
        zzm zzmVar = new zzm();
        for (int i = 0; i < locales.size(); i++) {
            zzmVar.zzb(CommonUtils.languageTagFromLocale(locales.get(i)));
        }
        zzp zzpVarZzc = zzmVar.zzc();
        zzb = zzpVarZzc;
        return zzpVarZzc;
    }

    final /* synthetic */ void zza(zzju zzjuVar, zzgz zzgzVar, String str) {
        zzjuVar.zzd(zzgzVar);
        String strZza = zzjuVar.zza();
        zzil zzilVar = new zzil();
        zzilVar.zzb(this.zzd);
        zzilVar.zzc(this.zze);
        zzilVar.zzh(zzc());
        zzilVar.zzg(true);
        zzilVar.zzl(strZza);
        zzilVar.zzj(str);
        zzilVar.zzi(this.zzi.isSuccessful() ? (String) this.zzi.getResult() : this.zzg.getMlSdkInstanceId());
        zzilVar.zzd(10);
        zzilVar.zzk(Integer.valueOf(this.zzk));
        zzjuVar.zze(zzilVar);
        this.zzf.zza(zzjuVar);
    }

    public final void zzb(zzkd zzkdVar, final zzgz zzgzVar) {
        zzgn zzgnVar;
        zzgs zzgsVar;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.zzl.get(zzgzVar) != null && jElapsedRealtime - ((Long) this.zzl.get(zzgzVar)).longValue() <= TimeUnit.SECONDS.toMillis(30L)) {
            return;
        }
        this.zzl.put(zzgzVar, Long.valueOf(jElapsedRealtime));
        int i = zzkdVar.zza;
        int i2 = zzkdVar.zzb;
        int i3 = zzkdVar.zzc;
        int i4 = zzkdVar.zzd;
        int i5 = zzkdVar.zze;
        long j = zzkdVar.zzf;
        int i6 = zzkdVar.zzg;
        zzgr zzgrVar = new zzgr();
        if (i == -1) {
            zzgnVar = zzgn.BITMAP;
        } else if (i == 35) {
            zzgnVar = zzgn.YUV_420_888;
        } else if (i == 842094169) {
            zzgnVar = zzgn.YV12;
        } else if (i != 16) {
            zzgnVar = i != 17 ? zzgn.UNKNOWN_FORMAT : zzgn.NV21;
        } else {
            zzgnVar = zzgn.NV16;
        }
        zzgrVar.zzd(zzgnVar);
        if (i2 == 1) {
            zzgsVar = zzgs.BITMAP;
        } else if (i2 == 2) {
            zzgsVar = zzgs.BYTEARRAY;
        } else if (i2 != 3) {
            zzgsVar = i2 != 4 ? zzgs.ANDROID_MEDIA_IMAGE : zzgs.FILEPATH;
        } else {
            zzgsVar = zzgs.BYTEBUFFER;
        }
        zzgrVar.zzf(zzgsVar);
        zzgrVar.zzc(Integer.valueOf(i3));
        zzgrVar.zze(Integer.valueOf(i4));
        zzgrVar.zzg(Integer.valueOf(i5));
        zzgrVar.zzb(Long.valueOf(j));
        zzgrVar.zzh(Integer.valueOf(i6));
        zzgu zzguVarZzj = zzgrVar.zzj();
        zzha zzhaVar = new zzha();
        zzhaVar.zzd(zzguVarZzj);
        final zzju zzjuVarZzc = zzju.zzc(zzhaVar);
        final String version = this.zzh.isSuccessful() ? (String) this.zzh.getResult() : LibraryVersion.getInstance().getVersion(this.zzj);
        final byte[] bArr = null;
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable(zzjuVarZzc, zzgzVar, version, bArr) { // from class: com.google.android.gms.internal.mlkit_vision_common.zzjp
            public final /* synthetic */ zzgz zzb;
            public final /* synthetic */ String zzc;
            public final /* synthetic */ zzju zzd;

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza(this.zzd, this.zzb, this.zzc);
            }
        });
    }
}

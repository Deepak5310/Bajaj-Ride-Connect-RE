package com.google.android.libraries.places.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzjo extends ViewModel {
    private final zzjb zza;
    private final zzjr zzb;
    private final zzjs zzc;
    private Runnable zze;
    private final Handler zzd = new Handler(Looper.getMainLooper());
    private final MutableLiveData zzf = new MutableLiveData();

    /* synthetic */ zzjo(zzjb zzjbVar, zzjr zzjrVar, zzjs zzjsVar, zzjn zzjnVar) {
        this.zza = zzjbVar;
        this.zzb = zzjrVar;
        this.zzc = zzjsVar;
    }

    private static Status zzn(Exception exc) {
        return exc instanceof ApiException ? ((ApiException) exc).getStatus() : new Status(13, exc.getMessage());
    }

    private final void zzo(zziw zziwVar) {
        if (zziwVar.equals(this.zzf.getValue())) {
            return;
        }
        this.zzf.setValue(zziwVar);
    }

    private static boolean zzp(Status status) {
        return status.isCanceled() || status.getStatusCode() == 9012 || status.getStatusCode() == 9011;
    }

    public final LiveData zza() {
        return this.zzf;
    }

    final /* synthetic */ void zzb(String str, Task task) {
        if (task.isCanceled()) {
            return;
        }
        Exception exception = task.getException();
        if (exception == null) {
            this.zzb.zzp();
            List<AutocompletePrediction> autocompletePredictions = ((FindAutocompletePredictionsResponse) task.getResult()).getAutocompletePredictions();
            if (autocompletePredictions.isEmpty()) {
                zzo(zziw.zzh(str));
                return;
            } else {
                zzo(zziw.zzj(autocompletePredictions));
                return;
            }
        }
        this.zzb.zzr();
        Status statusZzn = zzn(exception);
        if (zzp(statusZzn)) {
            zzo(zziw.zzq(statusZzn));
        } else {
            zzo(zziw.zzi(str, statusZzn));
        }
    }

    final /* synthetic */ void zzc(AutocompletePrediction autocompletePrediction, Task task) {
        if (task.isCanceled()) {
            return;
        }
        Exception exception = task.getException();
        if (exception == null) {
            this.zzb.zzq();
            zzo(zziw.zzn(((FetchPlaceResponse) task.getResult()).getPlace()));
            return;
        }
        this.zzb.zzs();
        Status statusZzn = zzn(exception);
        if (zzp(statusZzn)) {
            zzo(zziw.zzq(statusZzn));
        } else {
            zzo(zziw.zzm(autocompletePrediction, statusZzn));
        }
    }

    final /* synthetic */ void zzd(final String str) {
        this.zza.zzb(str).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.libraries.places.internal.zzjl
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.zza.zzb(str, task);
            }
        });
    }

    public final void zze(Bundle bundle) {
        if (bundle == null) {
            this.zzf.setValue(zziw.zzo());
        }
    }

    public final void zzf(final AutocompletePrediction autocompletePrediction, int i) {
        this.zzb.zzu(i);
        Task taskZza = this.zza.zza(autocompletePrediction);
        if (!taskZza.isComplete()) {
            zzo(zziw.zzg());
        }
        taskZza.addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.libraries.places.internal.zzjj
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.zza.zzc(autocompletePrediction, task);
            }
        });
    }

    public final void zzg() {
        this.zzb.zzv();
    }

    public final void zzh() {
        this.zzb.zzl();
    }

    public final void zzi() {
        this.zzb.zzm();
    }

    public final void zzj() {
        this.zzb.zzn();
        zzo(zziw.zzl());
    }

    public final void zzk() {
        this.zzb.zzw();
        zzm("");
    }

    public final void zzl(String str) {
        this.zza.zzc();
        zzm(str);
        zzo(zziw.zzp());
    }

    public final void zzm(final String str) {
        this.zzb.zzt(str);
        this.zzd.removeCallbacks(this.zze);
        if (str.isEmpty()) {
            this.zza.zzc();
            zzo(zziw.zzk());
        } else {
            Runnable runnable = new Runnable() { // from class: com.google.android.libraries.places.internal.zzjk
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzd(str);
                }
            };
            this.zze = runnable;
            this.zzd.postDelayed(runnable, 100L);
            zzo(zziw.zzg());
        }
    }

    @Override // androidx.lifecycle.ViewModel
    protected final void onCleared() {
        try {
            this.zza.zzc();
            this.zzd.removeCallbacks(this.zze);
            this.zzb.zzo();
            this.zzc.zza(this.zzb);
        } catch (Error | RuntimeException e) {
            zzif.zzb(e);
            throw e;
        }
    }
}

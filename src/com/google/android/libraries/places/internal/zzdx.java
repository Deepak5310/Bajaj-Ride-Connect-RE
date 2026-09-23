package com.google.android.libraries.places.internal;

import android.location.Location;
import com.google.android.gms.location.CurrentLocationRequest;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdx {
    private static final long zza = TimeUnit.SECONDS.toMillis(30);
    private final FusedLocationProviderClient zzb;
    private final zzhn zzc;

    zzdx(FusedLocationProviderClient fusedLocationProviderClient, zzhn zzhnVar) {
        this.zzb = fusedLocationProviderClient;
        this.zzc = zzhnVar;
    }

    public final Task zza(CancellationToken cancellationToken) {
        Task<Location> currentLocation;
        CurrentLocationRequest.Builder priority = new CurrentLocationRequest.Builder().setPriority(100);
        long j = zza;
        CurrentLocationRequest currentLocationRequestBuild = priority.setDurationMillis(j).build();
        if (FusedLocationProviderClient.class.isInterface()) {
            currentLocation = this.zzb.getCurrentLocation(currentLocationRequestBuild, cancellationToken);
        } else {
            try {
                currentLocation = (Task) FusedLocationProviderClient.class.getMethod("getCurrentLocation", CurrentLocationRequest.class, CancellationToken.class).invoke(this.zzb, currentLocationRequestBuild, cancellationToken);
            } catch (ReflectiveOperationException e) {
                throw new IllegalStateException(e);
            }
        }
        final zzhn zzhnVar = this.zzc;
        final TaskCompletionSource taskCompletionSource = cancellationToken == null ? new TaskCompletionSource() : new TaskCompletionSource(cancellationToken);
        zzhnVar.zza(taskCompletionSource, j, "Location timeout.");
        currentLocation.continueWithTask(new Continuation() { // from class: com.google.android.libraries.places.internal.zzhl
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
                Exception exception = task.getException();
                if (task.isSuccessful()) {
                    taskCompletionSource2.setResult(task.getResult());
                } else if (!task.isCanceled() && exception != null) {
                    taskCompletionSource2.setException(exception);
                }
                return taskCompletionSource2.getTask();
            }
        });
        taskCompletionSource.getTask().addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.libraries.places.internal.zzhm
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                zzhnVar.zzb(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask().continueWithTask(new zzdw(this));
    }
}

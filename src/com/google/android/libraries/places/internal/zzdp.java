package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdp {
    public static Task zza(zzaho zzahoVar) {
        CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationTokenSource.getToken());
        zzahm.zza(zzahoVar, new zzdo(taskCompletionSource, zzahoVar, cancellationTokenSource), zzahp.zza());
        return taskCompletionSource.getTask();
    }
}

package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdo implements zzahk {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ zzaho zzb;
    final /* synthetic */ CancellationTokenSource zzc;

    zzdo(TaskCompletionSource taskCompletionSource, zzaho zzahoVar, CancellationTokenSource cancellationTokenSource) {
        this.zza = taskCompletionSource;
        this.zzb = zzahoVar;
        this.zzc = cancellationTokenSource;
    }

    @Override // com.google.android.libraries.places.internal.zzahk
    public final void zza(Throwable th) {
        if (this.zzb.isCancelled()) {
            this.zzc.cancel();
        } else if (th instanceof Exception) {
            this.zza.setException((Exception) th);
        } else {
            this.zza.setException(new ExecutionException(th));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzahk
    public final void zzb(Object obj) {
        this.zza.setResult(obj);
    }
}

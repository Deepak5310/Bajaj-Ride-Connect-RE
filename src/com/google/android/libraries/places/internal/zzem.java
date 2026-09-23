package com.google.android.libraries.places.internal;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.OnTokenCanceledListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzem {
    private final RequestQueue zza;
    private final zzgn zzb;

    zzem(RequestQueue requestQueue, zzgn zzgnVar) {
        this.zza = requestQueue;
        this.zzb = zzgnVar;
    }

    static /* synthetic */ void zzc(TaskCompletionSource taskCompletionSource, VolleyError volleyError) {
        try {
            taskCompletionSource.trySetException(zzeg.zza(volleyError));
        } catch (Error | RuntimeException e) {
            zzif.zzb(e);
            throw e;
        }
    }

    public final Task zza(zzeu zzeuVar, final Class cls) {
        String strZzc = zzeuVar.zzc();
        Map mapZzd = zzeuVar.zzd();
        CancellationToken cancellationTokenZza = zzeuVar.zza();
        final TaskCompletionSource taskCompletionSource = cancellationTokenZza != null ? new TaskCompletionSource(cancellationTokenZza) : new TaskCompletionSource();
        final zzel zzelVar = new zzel(this, 0, strZzc, null, new Response.Listener() { // from class: com.google.android.libraries.places.internal.zzei
            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) {
                this.zza.zzb(cls, taskCompletionSource, (JSONObject) obj);
            }
        }, new Response.ErrorListener() { // from class: com.google.android.libraries.places.internal.zzej
            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                zzem.zzc(taskCompletionSource, volleyError);
            }
        }, mapZzd);
        if (cancellationTokenZza != null) {
            cancellationTokenZza.onCanceledRequested(new OnTokenCanceledListener() { // from class: com.google.android.libraries.places.internal.zzek
                @Override // com.google.android.gms.tasks.OnTokenCanceledListener
                public final void onCanceled() {
                    zzelVar.cancel();
                }
            });
        }
        this.zza.add(zzelVar);
        return taskCompletionSource.getTask();
    }

    final /* synthetic */ void zzb(Class cls, TaskCompletionSource taskCompletionSource, JSONObject jSONObject) {
        try {
            try {
                taskCompletionSource.trySetResult((zzev) this.zzb.zza(jSONObject.toString(), cls));
            } catch (zzew e) {
                taskCompletionSource.trySetException(new ApiException(new Status(8, e.getMessage())));
            }
        } catch (Error | RuntimeException e2) {
            zzif.zzb(e2);
            throw e2;
        }
    }
}

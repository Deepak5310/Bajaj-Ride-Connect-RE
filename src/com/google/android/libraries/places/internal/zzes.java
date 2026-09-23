package com.google.android.libraries.places.internal;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.OnTokenCanceledListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.libraries.places.api.net.PlacesStatusCodes;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzes {
    private final RequestQueue zza;

    zzes(RequestQueue requestQueue) {
        this.zza = requestQueue;
    }

    static /* synthetic */ void zza(TaskCompletionSource taskCompletionSource, VolleyError volleyError) {
        ApiException apiExceptionZza;
        try {
            if (volleyError.networkResponse != null) {
                int i = volleyError.networkResponse.statusCode;
                if (i != 400) {
                    apiExceptionZza = i != 403 ? zzeg.zza(volleyError) : new ApiException(new Status(PlacesStatusCodes.REQUEST_DENIED, "The provided API key is invalid."));
                } else {
                    apiExceptionZza = new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "The provided parameters are invalid (did you include a max width or height?)."));
                }
            }
            taskCompletionSource.trySetException(apiExceptionZza);
        } catch (Error | RuntimeException e) {
            zzif.zzb(e);
            throw e;
        }
    }

    static /* synthetic */ void zzc(zzfw zzfwVar, TaskCompletionSource taskCompletionSource, Bitmap bitmap) {
        try {
            zzfwVar.zzb(bitmap);
            taskCompletionSource.trySetResult(zzfwVar.zza());
        } catch (Error | RuntimeException e) {
            zzif.zzb(e);
            throw e;
        }
    }

    public final Task zzb(zzeu zzeuVar, final zzfw zzfwVar) {
        String strZzc = zzeuVar.zzc();
        Map mapZzd = zzeuVar.zzd();
        CancellationToken cancellationTokenZza = zzeuVar.zza();
        final TaskCompletionSource taskCompletionSource = cancellationTokenZza != null ? new TaskCompletionSource(cancellationTokenZza) : new TaskCompletionSource();
        final zzer zzerVar = new zzer(this, strZzc, new Response.Listener() { // from class: com.google.android.libraries.places.internal.zzeo
            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) {
                zzes.zzc(zzfwVar, taskCompletionSource, (Bitmap) obj);
            }
        }, 0, 0, ImageView.ScaleType.CENTER, Bitmap.Config.ARGB_8888, new Response.ErrorListener() { // from class: com.google.android.libraries.places.internal.zzep
            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                zzes.zza(taskCompletionSource, volleyError);
            }
        }, mapZzd);
        if (cancellationTokenZza != null) {
            cancellationTokenZza.onCanceledRequested(new OnTokenCanceledListener() { // from class: com.google.android.libraries.places.internal.zzeq
                @Override // com.google.android.gms.tasks.OnTokenCanceledListener
                public final void onCanceled() {
                    zzerVar.cancel();
                }
            });
        }
        this.zza.add(zzerVar);
        return taskCompletionSource.getTask();
    }
}

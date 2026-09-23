package com.google.android.libraries.places.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.libraries.places.api.net.PlacesStatusCodes;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class zzez implements Continuation {
    public static final /* synthetic */ zzez zza = new zzez();

    private /* synthetic */ zzez() {
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final Object then(Task task) {
        ApiException apiException;
        Exception exception = task.getException();
        if (exception == null) {
            return task;
        }
        if (exception instanceof ApiException) {
            apiException = (ApiException) exception;
        } else if (exception instanceof zzaxf) {
            zzaxd zzaxdVarZze = zzaxd.zze((zzaxf) exception);
            zzawy zzawyVar = zzawy.OK;
            int iOrdinal = zzaxdVarZze.zza().ordinal();
            if (iOrdinal == 3) {
                apiException = new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, zzaxdVarZze.zzi()));
            } else if (iOrdinal == 4) {
                apiException = new ApiException(new Status(15, zzaxdVarZze.zzi()));
            } else if (iOrdinal == 5) {
                apiException = new ApiException(new Status(PlacesStatusCodes.NOT_FOUND, zzaxdVarZze.zzi()));
            } else if (iOrdinal == 7) {
                apiException = new ApiException(new Status(PlacesStatusCodes.REQUEST_DENIED, zzaxdVarZze.zzi()));
            } else if (iOrdinal != 13) {
                apiException = iOrdinal != 14 ? new ApiException(new Status(13, zzaxdVarZze.zzi())) : new ApiException(new Status(7, zzaxdVarZze.zzi()));
            } else {
                apiException = new ApiException(new Status(8, zzaxdVarZze.zzi()));
            }
        } else {
            apiException = new ApiException(new Status(13, exception.toString()));
        }
        return Tasks.forException(apiException);
    }
}

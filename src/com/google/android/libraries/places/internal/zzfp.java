package com.google.android.libraries.places.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnTokenCanceledListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import com.google.android.libraries.places.api.net.PlacesStatusCodes;
import com.google.android.libraries.places.api.net.SearchByTextRequest;
import com.google.android.libraries.places.api.net.SearchByTextResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzfp {
    private final zzale zza;
    private final Context zzb;
    private final String zzc;
    private final zzhv zzd;
    private final zzdh zze;
    private final zzhw zzf;

    zzfp(zzhw zzhwVar, zzasb zzasbVar, Context context, String str, zzhv zzhvVar, zzdh zzdhVar) {
        this.zzf = zzhwVar;
        this.zza = zzalf.zza(zzasbVar);
        this.zzb = context;
        this.zzc = str;
        this.zzd = zzhvVar;
        this.zze = zzdhVar;
    }

    private final zzavu zze(String str) {
        zzavu zzavuVar = new zzavu();
        zzavuVar.zzf(zzavp.zzc("X-Goog-Api-Key", zzavu.zzb), this.zzf.zza());
        zzavuVar.zzf(zzavp.zzc("X-Goog-FieldMask", zzavu.zzb), str);
        if (!TextUtils.isEmpty(this.zzc)) {
            zzavuVar.zzf(zzavp.zzc("X-Android-Package", zzavu.zzb), this.zzb.getPackageName());
            zzavuVar.zzf(zzavp.zzc("X-Android-Cert", zzavu.zzb), this.zzc);
        }
        return zzavuVar;
    }

    public final Task zza(FetchPlaceRequest fetchPlaceRequest) {
        if (fetchPlaceRequest.getPlaceId().isEmpty()) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Place id must not be an empty string.")));
        }
        List<Place.Field> placeFields = fetchPlaceRequest.getPlaceFields();
        if (placeFields.isEmpty()) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Place fields must not be empty.")));
        }
        String regionCode = fetchPlaceRequest.getRegionCode();
        if (regionCode != null && regionCode.isEmpty()) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Region code must not be an empty string.")));
        }
        final long jZza = this.zze.zza();
        zzbnz zzbnzVarZze = this.zza.zze(zzboi.zza(zze(zzfs.zzb(placeFields))));
        Locale localeZzb = this.zzf.zzb();
        zzaju zzajuVarZza = zzajv.zza();
        zzajuVarZza.zzb("places/".concat(String.valueOf(fetchPlaceRequest.getPlaceId())));
        String regionCode2 = fetchPlaceRequest.getRegionCode();
        if (regionCode2 != null) {
            zzajuVarZza.zzc(regionCode2);
        }
        zzajuVarZza.zza(localeZzb.toLanguageTag());
        final zzaho zzahoVarZza = zzbof.zza(zzbnzVarZze.zzd().zza(zzalf.zzb(), zzbnzVarZze.zzc()), (zzajv) zzajuVarZza.zzq());
        CancellationToken cancellationToken = fetchPlaceRequest.getCancellationToken();
        if (cancellationToken != null) {
            cancellationToken.onCanceledRequested(new OnTokenCanceledListener() { // from class: com.google.android.libraries.places.internal.zzfj
                @Override // com.google.android.gms.tasks.OnTokenCanceledListener
                public final void onCanceled() {
                    zzahoVarZza.cancel(true);
                }
            });
        }
        return zzdp.zza(zzahoVarZza).onSuccessTask(new SuccessContinuation() { // from class: com.google.android.libraries.places.internal.zzfk
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                taskCompletionSource.setResult(FetchPlaceResponse.newInstance(zzfr.zza.zza((zzalb) obj)));
                return taskCompletionSource.getTask();
            }
        }).continueWithTask(new Continuation() { // from class: com.google.android.libraries.places.internal.zzfl
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) throws Exception {
                this.zza.zzb(jZza, task);
                return task;
            }
        });
    }

    final /* synthetic */ Task zzb(long j, Task task) throws Exception {
        if (task.isCanceled()) {
            return task;
        }
        this.zzd.zzd(task, j, this.zze.zza());
        return task;
    }

    final /* synthetic */ Task zzc(SearchByTextRequest searchByTextRequest, long j, Task task) throws Exception {
        if (task.isCanceled()) {
            return task;
        }
        this.zzd.zzj(searchByTextRequest, task, j, this.zze.zza());
        return task;
    }

    public final Task zzd(final SearchByTextRequest searchByTextRequest) {
        List<Place.Field> placeFields = searchByTextRequest.getPlaceFields();
        if (placeFields.isEmpty()) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Place fields must not be empty.")));
        }
        if (searchByTextRequest.getTextQuery().isEmpty()) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Text query must not be an empty string.")));
        }
        String includedType = searchByTextRequest.getIncludedType();
        if (includedType != null && includedType.isEmpty()) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Included type must not be an empty string.")));
        }
        String regionCode = searchByTextRequest.getRegionCode();
        if (regionCode != null && regionCode.isEmpty()) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Region code must not be an empty string.")));
        }
        final long jZza = this.zze.zza();
        zzbnz zzbnzVarZze = this.zza.zze(zzboi.zza(zze(zzfs.zza(placeFields))));
        final zzaho zzahoVarZza = zzbof.zza(zzbnzVarZze.zzd().zza(zzalf.zzc(), zzbnzVarZze.zzc()), zzft.zza(searchByTextRequest, this.zzf.zzb()));
        CancellationToken cancellationToken = searchByTextRequest.getCancellationToken();
        if (cancellationToken != null) {
            cancellationToken.onCanceledRequested(new OnTokenCanceledListener() { // from class: com.google.android.libraries.places.internal.zzfm
                @Override // com.google.android.gms.tasks.OnTokenCanceledListener
                public final void onCanceled() {
                    zzahoVarZza.cancel(true);
                }
            });
        }
        return zzdp.zza(zzahoVarZza).onSuccessTask(new SuccessContinuation() { // from class: com.google.android.libraries.places.internal.zzfn
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                List listZzd = ((zzalu) obj).zzd();
                ArrayList arrayList = new ArrayList();
                Iterator it2 = listZzd.iterator();
                while (it2.hasNext()) {
                    arrayList.add(zzfr.zza.zza((zzalb) it2.next()));
                }
                taskCompletionSource.setResult(SearchByTextResponse.newInstance(arrayList));
                return taskCompletionSource.getTask();
            }
        }).continueWithTask(new Continuation() { // from class: com.google.android.libraries.places.internal.zzfo
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) throws Exception {
                this.zza.zzc(searchByTextRequest, jZza, task);
                return task;
            }
        });
    }
}

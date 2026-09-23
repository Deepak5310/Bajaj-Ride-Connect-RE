package com.google.android.libraries.places.internal;

import android.location.Location;
import android.text.TextUtils;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.libraries.places.api.model.PlaceLikelihood;
import com.google.android.libraries.places.api.net.FetchPhotoRequest;
import com.google.android.libraries.places.api.net.FetchPhotoResponse;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.google.android.libraries.places.api.net.FindCurrentPlaceResponse;
import com.google.android.libraries.places.api.net.PlacesStatusCodes;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzgy implements zzeh {
    private final zzij zza;
    private final zzem zzb;
    private final zzes zzc;
    private final zzhv zzd;
    private final zzdh zze;
    private final zzfz zzf;
    private final zzgd zzg;
    private final zzgh zzh;
    private final zzgl zzi;
    private final zzhw zzj;

    zzgy(zzhw zzhwVar, zzij zzijVar, zzem zzemVar, zzes zzesVar, zzhv zzhvVar, zzdh zzdhVar, zzfz zzfzVar, zzgd zzgdVar, zzgh zzghVar, zzgl zzglVar) {
        this.zzj = zzhwVar;
        this.zza = zzijVar;
        this.zzb = zzemVar;
        this.zzc = zzesVar;
        this.zzd = zzhvVar;
        this.zze = zzdhVar;
        this.zzf = zzfzVar;
        this.zzg = zzgdVar;
        this.zzh = zzghVar;
        this.zzi = zzglVar;
    }

    static final /* synthetic */ FetchPlaceResponse zzi(Task task) throws Exception {
        zzgc zzgcVar = (zzgc) task.getResult();
        int iZza = zzhf.zza(zzgcVar.status);
        if (PlacesStatusCodes.isError(iZza)) {
            throw new ApiException(new Status(iZza, zzhf.zzb(zzgcVar.status, zzgcVar.errorMessage)));
        }
        zzhe zzheVar = zzgcVar.result;
        String[] strArr = zzgcVar.htmlAttributions;
        return FetchPlaceResponse.newInstance(zzhb.zzg(zzheVar, strArr != null ? zzlx.zzk(strArr) : null));
    }

    static final /* synthetic */ FindCurrentPlaceResponse zzj(Task task) throws Exception {
        zzgk zzgkVar = (zzgk) task.getResult();
        int iZza = zzhf.zza(zzgkVar.status);
        if (PlacesStatusCodes.isError(iZza)) {
            throw new ApiException(new Status(iZza, zzhf.zzb(zzgkVar.status, zzgkVar.errorMessage)));
        }
        ArrayList arrayList = new ArrayList();
        zzhd[] zzhdVarArr = zzgkVar.predictions;
        if (zzhdVarArr != null) {
            for (zzhd zzhdVar : zzhdVarArr) {
                if (zzhdVar.zza() == null) {
                    throw new ApiException(new Status(8, "Unexpected server error: PlaceLikelihood returned without a Place value"));
                }
                Double dZzb = zzhdVar.zzb();
                if (dZzb == null) {
                    throw new ApiException(new Status(8, "Unexpected server error: PlaceLikelihood returned without a likelihood value"));
                }
                zzhe zzheVarZza = zzhdVar.zza();
                String[] strArr = zzgkVar.htmlAttributions;
                arrayList.add(PlaceLikelihood.newInstance(zzhb.zzg(zzheVarZza, strArr != null ? zzlx.zzk(strArr) : null), dZzb.doubleValue()));
            }
        }
        return FindCurrentPlaceResponse.newInstance(arrayList);
    }

    @Override // com.google.android.libraries.places.internal.zzeh
    public final Task zza(FetchPhotoRequest fetchPhotoRequest) {
        Integer maxWidth = fetchPhotoRequest.getMaxWidth();
        Integer maxHeight = fetchPhotoRequest.getMaxHeight();
        if (maxWidth == null && maxHeight == null) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Must include max width or max height in request.")));
        }
        if (maxWidth != null && maxWidth.intValue() <= 0) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, String.format("Max Width must not be < 1, but was: %d.", maxWidth))));
        }
        if (maxHeight != null && maxHeight.intValue() <= 0) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, String.format("Max Height must not be < 1, but was: %d.", maxHeight))));
        }
        zzhw zzhwVar = this.zzj;
        String strZza = zzhwVar.zza();
        zzhwVar.zzf();
        zzfv zzfvVar = new zzfv(fetchPhotoRequest, strZza, false, this.zza);
        zzdh zzdhVar = this.zze;
        zzes zzesVar = this.zzc;
        final long jZza = zzdhVar.zza();
        return zzesVar.zzb(zzfvVar, new zzfw()).continueWith(new Continuation() { // from class: com.google.android.libraries.places.internal.zzgu
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return FetchPhotoResponse.newInstance(((zzfy) task.getResult()).zza);
            }
        }).continueWith(new Continuation() { // from class: com.google.android.libraries.places.internal.zzgv
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return this.zza.zze(jZza, task);
            }
        });
    }

    @Override // com.google.android.libraries.places.internal.zzeh
    public final Task zzb(FetchPlaceRequest fetchPlaceRequest) {
        if (TextUtils.isEmpty(fetchPlaceRequest.getPlaceId())) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Place ID must not be empty.")));
        }
        if (fetchPlaceRequest.getPlaceFields().isEmpty()) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Place Fields must not be empty.")));
        }
        zzhw zzhwVar = this.zzj;
        Locale localeZzb = zzhwVar.zzb();
        String strZza = zzhwVar.zza();
        zzhwVar.zzf();
        zzgb zzgbVar = new zzgb(fetchPlaceRequest, localeZzb, strZza, false, this.zza);
        zzdh zzdhVar = this.zze;
        zzem zzemVar = this.zzb;
        final long jZza = zzdhVar.zza();
        return zzemVar.zza(zzgbVar, zzgc.class).continueWith(new Continuation() { // from class: com.google.android.libraries.places.internal.zzgs
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return zzgy.zzi(task);
            }
        }).continueWith(new Continuation() { // from class: com.google.android.libraries.places.internal.zzgt
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return this.zza.zzf(jZza, task);
            }
        });
    }

    @Override // com.google.android.libraries.places.internal.zzeh
    public final Task zzc(FindAutocompletePredictionsRequest findAutocompletePredictionsRequest) {
        String query = findAutocompletePredictionsRequest.getQuery();
        if (query == null || TextUtils.isEmpty(query.trim())) {
            return Tasks.forResult(FindAutocompletePredictionsResponse.newInstance(zzlx.zzl()));
        }
        zzhw zzhwVar = this.zzj;
        Locale localeZzb = zzhwVar.zzb();
        String strZza = zzhwVar.zza();
        zzhwVar.zzf();
        zzgf zzgfVar = new zzgf(findAutocompletePredictionsRequest, localeZzb, strZza, false, this.zza);
        zzdh zzdhVar = this.zze;
        zzem zzemVar = this.zzb;
        final long jZza = zzdhVar.zza();
        return zzemVar.zza(zzgfVar, zzgg.class).continueWith(new Continuation() { // from class: com.google.android.libraries.places.internal.zzgw
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return zzgh.zza((zzgg) task.getResult());
            }
        }).continueWith(new Continuation() { // from class: com.google.android.libraries.places.internal.zzgx
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return this.zza.zzg(jZza, task);
            }
        });
    }

    @Override // com.google.android.libraries.places.internal.zzeh
    public final Task zzd(FindCurrentPlaceRequest findCurrentPlaceRequest, Location location, zzlx zzlxVar) {
        if (findCurrentPlaceRequest.getPlaceFields().isEmpty()) {
            return Tasks.forException(new ApiException(new Status(PlacesStatusCodes.INVALID_REQUEST, "Place Fields must not be empty.")));
        }
        zzhw zzhwVar = this.zzj;
        Locale localeZzb = zzhwVar.zzb();
        String strZza = zzhwVar.zza();
        zzhwVar.zzf();
        zzgj zzgjVar = new zzgj(findCurrentPlaceRequest, location, zzlxVar, localeZzb, strZza, false, this.zza);
        zzdh zzdhVar = this.zze;
        zzem zzemVar = this.zzb;
        final long jZza = zzdhVar.zza();
        return zzemVar.zza(zzgjVar, zzgk.class).continueWith(new Continuation() { // from class: com.google.android.libraries.places.internal.zzgq
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return zzgy.zzj(task);
            }
        }).continueWith(new Continuation() { // from class: com.google.android.libraries.places.internal.zzgr
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return this.zza.zzh(jZza, task);
            }
        });
    }

    final /* synthetic */ FetchPhotoResponse zze(long j, Task task) throws Exception {
        this.zzd.zzb(task, j, this.zze.zza());
        return (FetchPhotoResponse) task.getResult();
    }

    final /* synthetic */ FetchPlaceResponse zzf(long j, Task task) throws Exception {
        this.zzd.zzd(task, j, this.zze.zza());
        return (FetchPlaceResponse) task.getResult();
    }

    final /* synthetic */ FindAutocompletePredictionsResponse zzg(long j, Task task) throws Exception {
        this.zzd.zzf(task, j, this.zze.zza());
        return (FindAutocompletePredictionsResponse) task.getResult();
    }

    final /* synthetic */ FindCurrentPlaceResponse zzh(long j, Task task) throws Exception {
        this.zzd.zzh(task, j, this.zze.zza());
        return (FindCurrentPlaceResponse) task.getResult();
    }
}

package com.google.android.libraries.places.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.api.net.FetchPhotoRequest;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.google.android.libraries.places.api.net.FindCurrentPlaceResponse;
import com.google.android.libraries.places.api.net.SearchByTextRequest;
import com.google.android.libraries.places.api.net.SearchByTextResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzee implements zzhv {
    private final zzid zza;
    private final zzih zzb;
    private final zzhw zzc;

    zzee(zzih zzihVar, zzid zzidVar, zzhw zzhwVar) {
        this.zzb = zzihVar;
        this.zza = zzidVar;
        this.zzc = zzhwVar;
    }

    static final int zzk(Task task) {
        if (task.isSuccessful()) {
            return 2;
        }
        Exception exception = task.getException();
        exception.getClass();
        int statusCode = (exception instanceof ApiException ? (ApiException) exception : new ApiException(new Status(13, exception.getMessage()))).getStatusCode();
        if (statusCode != 7) {
            return statusCode != 15 ? 1 : 3;
        }
        return 4;
    }

    private final zzafk zzl() {
        Locale localeZzb = this.zzc.zzb();
        Locale locale = Locale.getDefault();
        zzafk zzafkVarZza = zzafm.zza();
        zzafkVarZza.zzd(localeZzb.toString());
        if (!localeZzb.equals(locale)) {
            zzafkVarZza.zzb(locale.toString());
        }
        return zzafkVarZza;
    }

    private final void zzm(zzaea zzaeaVar) {
        this.zzb.zza(zzii.zza(zzaeaVar));
    }

    private final void zzn(zzacs zzacsVar, int i) {
        zzadu zzaduVarZzb = zzii.zzb(this.zza, i);
        zzaduVarZzb.zzm(16);
        zzaduVarZzb.zze(zzacsVar);
        zzaduVarZzb.zza(this.zzc.zza());
        zzm((zzaea) zzaduVarZzb.zzq());
    }

    @Override // com.google.android.libraries.places.internal.zzhv
    public final void zza(FetchPhotoRequest fetchPhotoRequest) {
        zzafc zzafcVarZza = zzafe.zza();
        zzafcVarZza.zza(2);
        zzafe zzafeVar = (zzafe) zzafcVarZza.zzq();
        zzadu zzaduVarZzb = zzii.zzb(this.zza, 2);
        zzaduVarZzb.zzm(5);
        zzaduVarZzb.zzg(zzafeVar);
        zzaduVarZzb.zza(this.zzc.zza());
        zzm((zzaea) zzaduVarZzb.zzq());
    }

    @Override // com.google.android.libraries.places.internal.zzhv
    public final void zzb(Task task, long j, long j2) {
        zzacn zzacnVarZza = zzacs.zza();
        zzacnVarZza.zzg(15);
        zzacnVarZza.zzf(zzk(task));
        zzacnVarZza.zzd((int) (j2 - j));
        zzn((zzacs) zzacnVarZza.zzq(), 2);
    }

    @Override // com.google.android.libraries.places.internal.zzhv
    public final void zzc(FetchPlaceRequest fetchPlaceRequest) {
        zzaeg zzaegVarZza = zzaeh.zza();
        zzaegVarZza.zza(1);
        zzaff zzaffVarZza = zzafg.zza();
        zzaffVarZza.zza(zzhh.zzb(fetchPlaceRequest.getPlaceFields()));
        zzaegVarZza.zzb((zzafg) zzaffVarZza.zzq());
        zzaeh zzaehVar = (zzaeh) zzaegVarZza.zzq();
        zzafk zzafkVarZzl = zzl();
        zzafkVarZzl.zzf(5);
        zzafkVarZzl.zzc(zzaehVar);
        zzafm zzafmVar = (zzafm) zzafkVarZzl.zzq();
        zzadu zzaduVarZzb = zzii.zzb(this.zza, 2);
        zzaduVarZzb.zzm(1);
        zzaduVarZzb.zzh(zzafmVar);
        zzaduVarZzb.zza(this.zzc.zza());
        AutocompleteSessionToken sessionToken = fetchPlaceRequest.getSessionToken();
        if (sessionToken != null) {
            zzaduVarZzb.zzj(sessionToken.toString());
        }
        zzm((zzaea) zzaduVarZzb.zzq());
    }

    @Override // com.google.android.libraries.places.internal.zzhv
    public final void zzd(Task task, long j, long j2) {
        boolean zIsSuccessful = task.isSuccessful();
        zzacf zzacfVarZza = zzacg.zza();
        zzacfVarZza.zza(1);
        zzacfVarZza.zzb(zIsSuccessful ? 1 : 0);
        zzacg zzacgVar = (zzacg) zzacfVarZza.zzq();
        zzacn zzacnVarZza = zzacs.zza();
        zzacnVarZza.zzg(8);
        zzacnVarZza.zzc(zzacgVar);
        zzacnVarZza.zzf(zzk(task));
        zzacnVarZza.zzd((int) (j2 - j));
        zzn((zzacs) zzacnVarZza.zzq(), 2);
    }

    @Override // com.google.android.libraries.places.internal.zzhv
    public final void zze(FindAutocompletePredictionsRequest findAutocompletePredictionsRequest) {
        zzacw zzacwVarZza = zzacx.zza();
        List<String> typesFilter = findAutocompletePredictionsRequest.getTypesFilter();
        TypeFilter typeFilter = findAutocompletePredictionsRequest.getTypeFilter();
        if (!typesFilter.isEmpty()) {
            Iterator<String> it2 = typesFilter.iterator();
            while (it2.hasNext()) {
                zzacwVarZza.zza(it2.next());
            }
        } else if (typeFilter != null) {
            zzacwVarZza.zza(zzhi.zza(typeFilter));
        }
        zzacx zzacxVar = (zzacx) zzacwVarZza.zzq();
        zzadi zzadiVarZza = zzadj.zza();
        if (zzacxVar != null) {
            zzadiVarZza.zza(zzacxVar);
        }
        zzadj zzadjVar = (zzadj) zzadiVarZza.zzq();
        zzafk zzafkVarZzl = zzl();
        zzafkVarZzl.zzf(6);
        zzafkVarZzl.zza(zzadjVar);
        zzafm zzafmVar = (zzafm) zzafkVarZzl.zzq();
        zzadu zzaduVarZzb = zzii.zzb(this.zza, 2);
        zzaduVarZzb.zzm(1);
        zzaduVarZzb.zzh(zzafmVar);
        zzaduVarZzb.zza(this.zzc.zza());
        AutocompleteSessionToken sessionToken = findAutocompletePredictionsRequest.getSessionToken();
        if (sessionToken != null) {
            zzaduVarZzb.zzj(sessionToken.toString());
        }
        zzm((zzaea) zzaduVarZzb.zzq());
    }

    @Override // com.google.android.libraries.places.internal.zzhv
    public final void zzf(Task task, long j, long j2) {
        int size = task.isSuccessful() ? ((FindAutocompletePredictionsResponse) task.getResult()).getAutocompletePredictions().size() : 0;
        zzaca zzacaVarZza = zzacb.zza();
        zzacaVarZza.zza(size);
        zzacb zzacbVar = (zzacb) zzacaVarZza.zzq();
        zzacn zzacnVarZza = zzacs.zza();
        zzacnVarZza.zzg(6);
        zzacnVarZza.zzb(zzacbVar);
        zzacnVarZza.zzf(zzk(task));
        zzacnVarZza.zzd((int) (j2 - j));
        zzn((zzacs) zzacnVarZza.zzq(), 2);
    }

    @Override // com.google.android.libraries.places.internal.zzhv
    public final void zzg(FindCurrentPlaceRequest findCurrentPlaceRequest, Task task, long j, long j2) {
        boolean zIsSuccessful = task.isSuccessful();
        zzaem zzaemVarZza = zzaeo.zza();
        zzaff zzaffVarZza = zzafg.zza();
        zzaffVarZza.zza(zzhh.zzb(findCurrentPlaceRequest.getPlaceFields()));
        zzaemVarZza.zzb((zzafg) zzaffVarZza.zzq());
        zzaemVarZza.zza((int) (j2 - j));
        zzaemVarZza.zzc(true == zIsSuccessful ? 2 : 1);
        zzaeo zzaeoVar = (zzaeo) zzaemVarZza.zzq();
        zzadu zzaduVarZzb = zzii.zzb(this.zza, 2);
        zzaduVarZzb.zzm(6);
        zzaduVarZzb.zzd(zzaeoVar);
        zzaduVarZzb.zza(this.zzc.zza());
        zzm((zzaea) zzaduVarZzb.zzq());
    }

    @Override // com.google.android.libraries.places.internal.zzhv
    public final void zzh(Task task, long j, long j2) {
        int size = task.isSuccessful() ? ((FindCurrentPlaceResponse) task.getResult()).getPlaceLikelihoods().size() : 0;
        zzabt zzabtVarZza = zzabu.zza();
        zzabtVarZza.zza(size);
        zzabu zzabuVar = (zzabu) zzabtVarZza.zzq();
        zzacn zzacnVarZza = zzacs.zza();
        zzacnVarZza.zzg(4);
        zzacnVarZza.zza(zzabuVar);
        zzacnVarZza.zzf(zzk(task));
        zzacnVarZza.zzd((int) (j2 - j));
        zzn((zzacs) zzacnVarZza.zzq(), 2);
    }

    @Override // com.google.android.libraries.places.internal.zzhv
    public final void zzi(SearchByTextRequest searchByTextRequest) {
        boolean zEquals = searchByTextRequest.getRankPreference().equals(SearchByTextRequest.RankPreference.DISTANCE);
        zzaft zzaftVarZza = zzafv.zza();
        zzaftVarZza.zze(searchByTextRequest.isOpenNow());
        zzaff zzaffVarZza = zzafg.zza();
        zzaffVarZza.zza(zzfs.zzc(searchByTextRequest.getPlaceFields()));
        zzaftVarZza.zzf((zzafg) zzaffVarZza.zzq());
        zzaftVarZza.zzh(true != zEquals ? 3 : 2);
        zzaftVarZza.zzg(searchByTextRequest.isStrictTypeFiltering());
        String includedType = searchByTextRequest.getIncludedType();
        if (includedType != null) {
            zzaftVarZza.zzb(includedType);
        }
        Double minRating = searchByTextRequest.getMinRating();
        if (minRating != null) {
            zzaftVarZza.zzd(minRating.doubleValue());
        }
        Integer maxResultCount = searchByTextRequest.getMaxResultCount();
        if (maxResultCount != null) {
            zzaftVarZza.zzc(maxResultCount.intValue());
        }
        ArrayList arrayList = new ArrayList();
        for (Integer num : searchByTextRequest.getPriceLevels()) {
            if (num != null) {
                arrayList.add(num);
            }
        }
        zzaftVarZza.zza(arrayList);
        zzafk zzafkVarZzl = zzl();
        zzafkVarZzl.zzf(2);
        zzafkVarZzl.zze((zzafv) zzaftVarZza.zzq());
        zzafm zzafmVar = (zzafm) zzafkVarZzl.zzq();
        zzadu zzaduVarZzb = zzii.zzb(this.zza, 3);
        zzaduVarZzb.zzm(1);
        zzaduVarZzb.zzh(zzafmVar);
        zzaduVarZzb.zza(this.zzc.zza());
        zzm((zzaea) zzaduVarZzb.zzq());
    }

    @Override // com.google.android.libraries.places.internal.zzhv
    public final void zzj(SearchByTextRequest searchByTextRequest, Task task, long j, long j2) {
        int size = task.isSuccessful() ? ((SearchByTextResponse) task.getResult()).getPlaces().size() : 0;
        Integer maxResultCount = searchByTextRequest.getMaxResultCount();
        zzagn zzagnVarZza = zzago.zza();
        zzagnVarZza.zza(maxResultCount != null ? maxResultCount.intValue() : 0);
        zzagnVarZza.zzb(size);
        zzago zzagoVar = (zzago) zzagnVarZza.zzq();
        zzacn zzacnVarZza = zzacs.zza();
        zzacnVarZza.zzg(10);
        zzacnVarZza.zze(zzagoVar);
        zzacnVarZza.zzf(zzk(task));
        zzacnVarZza.zzd((int) (j2 - j));
        zzn((zzacs) zzacnVarZza.zzq(), 3);
    }
}

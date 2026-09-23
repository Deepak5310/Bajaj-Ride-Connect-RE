package com.google.android.libraries.places.internal;

import android.location.Location;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.libraries.places.api.model.OpeningHours;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.FetchPhotoRequest;
import com.google.android.libraries.places.api.net.FetchPhotoResponse;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.google.android.libraries.places.api.net.FindCurrentPlaceResponse;
import com.google.android.libraries.places.api.net.IsOpenRequest;
import com.google.android.libraries.places.api.net.IsOpenResponse;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.api.net.SearchByTextRequest;
import com.google.android.libraries.places.api.net.SearchByTextResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzfh implements PlacesClient {
    private final zzeh zza;
    private final zzdx zzb;
    private final zzec zzc;
    private final zzhv zzd;
    private final zzdh zze;
    private final zzfp zzf;
    private final zzhw zzg;

    zzfh(zzhw zzhwVar, zzeh zzehVar, zzdx zzdxVar, zzec zzecVar, zzhv zzhvVar, zzdh zzdhVar, zzfp zzfpVar) {
        this.zzg = zzhwVar;
        this.zza = zzehVar;
        this.zzb = zzdxVar;
        this.zzc = zzecVar;
        this.zzd = zzhvVar;
        this.zze = zzdhVar;
        this.zzf = zzfpVar;
    }

    private static void zzj(zzdr zzdrVar, zzdv zzdvVar) {
        zzdr.zza(zzdrVar, zzdr.zzb("Duration"));
        zzdm.zza();
        zzdm.zza();
        zzdr.zza(zzdrVar, zzdr.zzb("Battery"));
        zzdm.zza();
    }

    @Override // com.google.android.libraries.places.api.net.PlacesClient
    public final Task<FetchPhotoResponse> fetchPhoto(final FetchPhotoRequest fetchPhotoRequest) {
        try {
            zzkt.zzc(fetchPhotoRequest, "Request must not be null.");
            zzdm.zza();
            final zzdv zzdvVarZza = zzdv.zza();
            return this.zza.zza(fetchPhotoRequest).continueWith(new Continuation() { // from class: com.google.android.libraries.places.internal.zzfc
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return this.zza.zzc(fetchPhotoRequest, zzdvVarZza, task);
                }
            }).continueWithTask(zzez.zza);
        } catch (Error | RuntimeException e) {
            zzif.zzb(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.places.api.net.PlacesClient
    public final Task<FetchPlaceResponse> fetchPlace(final FetchPlaceRequest fetchPlaceRequest) {
        try {
            zzkt.zzc(fetchPlaceRequest, "Request must not be null.");
            zzdm.zza();
            final zzdv zzdvVarZza = zzdv.zza();
            return this.zzg.zzh() ? this.zzf.zza(fetchPlaceRequest).continueWith(new Continuation() { // from class: com.google.android.libraries.places.internal.zzff
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return this.zza.zzd(fetchPlaceRequest, zzdvVarZza, task);
                }
            }).continueWithTask(zzez.zza) : this.zza.zzb(fetchPlaceRequest).continueWith(new Continuation() { // from class: com.google.android.libraries.places.internal.zzfg
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return this.zza.zze(fetchPlaceRequest, zzdvVarZza, task);
                }
            }).continueWithTask(zzez.zza);
        } catch (Error | RuntimeException e) {
            zzif.zzb(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.places.api.net.PlacesClient
    public final Task<FindAutocompletePredictionsResponse> findAutocompletePredictions(final FindAutocompletePredictionsRequest findAutocompletePredictionsRequest) {
        try {
            zzkt.zzc(findAutocompletePredictionsRequest, "Request must not be null.");
            zzdm.zza();
            final zzdv zzdvVarZza = zzdv.zza();
            return this.zza.zzc(findAutocompletePredictionsRequest).continueWith(new Continuation() { // from class: com.google.android.libraries.places.internal.zzfb
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return this.zza.zzg(findAutocompletePredictionsRequest, zzdvVarZza, task);
                }
            }).continueWithTask(zzez.zza);
        } catch (Error | RuntimeException e) {
            zzif.zzb(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.places.api.net.PlacesClient
    public final Task<FindCurrentPlaceResponse> findCurrentPlace(FindCurrentPlaceRequest findCurrentPlaceRequest) {
        return zza(findCurrentPlaceRequest, null);
    }

    @Override // com.google.android.libraries.places.api.net.PlacesClient
    public final Task<IsOpenResponse> isOpen(IsOpenRequest isOpenRequest) {
        List arrayList;
        try {
            zzkt.zzc(isOpenRequest, "Request must not be null.");
            final Place place = isOpenRequest.getPlace();
            String placeId = isOpenRequest.getPlaceId();
            final long utcTimeMillis = isOpenRequest.getUtcTimeMillis();
            final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            if (place == null) {
                int i = com.google.android.libraries.places.api.model.zzce.zza;
                arrayList = Arrays.asList(Place.Field.BUSINESS_STATUS, Place.Field.CURRENT_OPENING_HOURS, Place.Field.OPENING_HOURS, Place.Field.UTC_OFFSET);
            } else {
                arrayList = new ArrayList();
                Place.BusinessStatus businessStatus = place.getBusinessStatus();
                if (businessStatus == null || businessStatus == Place.BusinessStatus.OPERATIONAL) {
                    if (businessStatus == null) {
                        arrayList.add(Place.Field.BUSINESS_STATUS);
                    }
                    if (place.getCurrentOpeningHours() == null) {
                        arrayList.add(Place.Field.CURRENT_OPENING_HOURS);
                    }
                    if (place.getOpeningHours() == null) {
                        arrayList.add(Place.Field.OPENING_HOURS);
                    }
                    if (place.getUtcOffsetMinutes() == null) {
                        arrayList.add(Place.Field.UTC_OFFSET);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                if (place == null) {
                    throw null;
                }
                taskCompletionSource.setResult(IsOpenResponse.newInstance(com.google.android.libraries.places.api.model.zzce.zza(place, utcTimeMillis)));
                return taskCompletionSource.getTask();
            }
            if (place != null) {
                placeId = place.getId();
            }
            if (placeId == null) {
                throw null;
            }
            FetchPlaceRequest.Builder builder = FetchPlaceRequest.builder(placeId, arrayList);
            builder.setCancellationToken(isOpenRequest.getCancellationToken());
            final FetchPlaceRequest fetchPlaceRequestBuild = builder.build();
            zzdm.zza();
            final zzdv zzdvVarZza = zzdv.zza();
            return this.zza.zzb(fetchPlaceRequestBuild).continueWith(new Continuation() { // from class: com.google.android.libraries.places.internal.zzex
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return this.zza.zzf(fetchPlaceRequestBuild, zzdvVarZza, task);
                }
            }).onSuccessTask(new SuccessContinuation() { // from class: com.google.android.libraries.places.internal.zzey
                @Override // com.google.android.gms.tasks.SuccessContinuation
                public final Task then(Object obj) {
                    Place place2 = ((FetchPlaceResponse) obj).getPlace();
                    Place.BusinessStatus businessStatus2 = place2.getBusinessStatus();
                    OpeningHours currentOpeningHours = place2.getCurrentOpeningHours();
                    OpeningHours openingHours = place2.getOpeningHours();
                    Integer utcOffsetMinutes = place2.getUtcOffsetMinutes();
                    Place place3 = place;
                    if (place3 != null) {
                        if (utcOffsetMinutes == null) {
                            utcOffsetMinutes = place3.getUtcOffsetMinutes();
                        }
                        if (businessStatus2 == null) {
                            businessStatus2 = place3.getBusinessStatus();
                        }
                        if (currentOpeningHours == null) {
                            currentOpeningHours = place3.getCurrentOpeningHours();
                        }
                        if (openingHours == null) {
                            openingHours = place3.getOpeningHours();
                        }
                    }
                    TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
                    long j = utcTimeMillis;
                    Place.Builder builder2 = Place.builder();
                    builder2.setBusinessStatus(businessStatus2);
                    builder2.setCurrentOpeningHours(currentOpeningHours);
                    builder2.setOpeningHours(openingHours);
                    builder2.setUtcOffsetMinutes(utcOffsetMinutes);
                    taskCompletionSource2.setResult(IsOpenResponse.newInstance(com.google.android.libraries.places.api.model.zzce.zza(builder2.build(), j)));
                    return taskCompletionSource2.getTask();
                }
            }).continueWithTask(zzez.zza);
        } catch (Error | RuntimeException e) {
            zzif.zzb(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.places.api.net.PlacesClient
    public final Task<SearchByTextResponse> searchByText(final SearchByTextRequest searchByTextRequest) {
        try {
            zzkt.zzc(searchByTextRequest, "Request must not be null.");
            zzdm.zza();
            final zzdv zzdvVarZza = zzdv.zza();
            return this.zzf.zzd(searchByTextRequest).continueWith(new Continuation() { // from class: com.google.android.libraries.places.internal.zzfa
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return this.zza.zzi(searchByTextRequest, zzdvVarZza, task);
                }
            }).continueWithTask(zzez.zza);
        } catch (Error | RuntimeException e) {
            zzif.zzb(e);
            throw e;
        }
    }

    public final Task zza(final FindCurrentPlaceRequest findCurrentPlaceRequest, String str) {
        try {
            zzkt.zzc(findCurrentPlaceRequest, "Request must not be null.");
            final long jZza = this.zze.zza();
            zzdm.zza();
            final zzdv zzdvVarZza = zzdv.zza();
            final String str2 = null;
            return this.zzb.zza(findCurrentPlaceRequest.getCancellationToken()).onSuccessTask(new SuccessContinuation(findCurrentPlaceRequest, str2) { // from class: com.google.android.libraries.places.internal.zzfd
                public final /* synthetic */ FindCurrentPlaceRequest zzb;

                @Override // com.google.android.gms.tasks.SuccessContinuation
                public final Task then(Object obj) {
                    return this.zza.zzb(this.zzb, null, (Location) obj);
                }
            }).continueWith(new Continuation() { // from class: com.google.android.libraries.places.internal.zzfe
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return this.zza.zzh(findCurrentPlaceRequest, jZza, zzdvVarZza, task);
                }
            }).continueWithTask(zzez.zza);
        } catch (Error | RuntimeException e) {
            zzif.zzb(e);
            throw e;
        }
    }

    final /* synthetic */ Task zzb(FindCurrentPlaceRequest findCurrentPlaceRequest, String str, Location location) throws Exception {
        zzkt.zzc(location, "Location must not be null.");
        return this.zza.zzd(findCurrentPlaceRequest, location, this.zzc.zza(null));
    }

    final /* synthetic */ FetchPhotoResponse zzc(FetchPhotoRequest fetchPhotoRequest, zzdv zzdvVar, Task task) throws Exception {
        this.zzd.zza(fetchPhotoRequest);
        zzj(zzdr.zzb("FetchPhoto"), zzdvVar);
        return (FetchPhotoResponse) task.getResult();
    }

    final /* synthetic */ FetchPlaceResponse zzd(FetchPlaceRequest fetchPlaceRequest, zzdv zzdvVar, Task task) throws Exception {
        this.zzd.zzc(fetchPlaceRequest);
        zzj(zzdr.zzb("GetPlace"), zzdvVar);
        return (FetchPlaceResponse) task.getResult();
    }

    final /* synthetic */ FetchPlaceResponse zze(FetchPlaceRequest fetchPlaceRequest, zzdv zzdvVar, Task task) throws Exception {
        this.zzd.zzc(fetchPlaceRequest);
        zzj(zzdr.zzb("FetchPlace"), zzdvVar);
        return (FetchPlaceResponse) task.getResult();
    }

    final /* synthetic */ FetchPlaceResponse zzf(FetchPlaceRequest fetchPlaceRequest, zzdv zzdvVar, Task task) throws Exception {
        this.zzd.zzc(fetchPlaceRequest);
        zzj(zzdr.zzb("IsOpenFetchPlace"), zzdvVar);
        return (FetchPlaceResponse) task.getResult();
    }

    final /* synthetic */ FindAutocompletePredictionsResponse zzg(FindAutocompletePredictionsRequest findAutocompletePredictionsRequest, zzdv zzdvVar, Task task) throws Exception {
        this.zzd.zze(findAutocompletePredictionsRequest);
        zzj(zzdr.zzb("FindAutocompletePredictions"), zzdvVar);
        return (FindAutocompletePredictionsResponse) task.getResult();
    }

    final /* synthetic */ FindCurrentPlaceResponse zzh(FindCurrentPlaceRequest findCurrentPlaceRequest, long j, zzdv zzdvVar, Task task) throws Exception {
        this.zzd.zzg(findCurrentPlaceRequest, task, j, this.zze.zza());
        zzj(zzdr.zzb("FindCurrentPlace"), zzdvVar);
        return (FindCurrentPlaceResponse) task.getResult();
    }

    final /* synthetic */ SearchByTextResponse zzi(SearchByTextRequest searchByTextRequest, zzdv zzdvVar, Task task) throws Exception {
        this.zzd.zzi(searchByTextRequest);
        zzj(zzdr.zzb("SearchByText"), zzdvVar);
        return (SearchByTextResponse) task.getResult();
    }
}

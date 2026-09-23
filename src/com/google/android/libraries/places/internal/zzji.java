package com.google.android.libraries.places.internal;

import android.text.TextUtils;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import com.google.android.libraries.places.api.net.PlacesClient;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzji implements zzjb {
    public static final /* synthetic */ int zza = 0;
    private static final zzlx zzb = zzlx.zzn(Place.Field.ID, Place.Field.TYPES);
    private final PlacesClient zzc;
    private final zziu zzd;
    private final AutocompleteSessionToken zze;
    private zzje zzf;
    private zzjf zzg;

    public zzji(PlacesClient placesClient, zziu zziuVar, AutocompleteSessionToken autocompleteSessionToken) {
        this.zzc = placesClient;
        this.zzd = zziuVar;
        this.zze = autocompleteSessionToken;
    }

    @Override // com.google.android.libraries.places.internal.zzjb
    public final Task zza(AutocompletePrediction autocompletePrediction) {
        if (zzb.containsAll(this.zzd.zzj())) {
            Place.Builder builder = Place.builder();
            builder.setId(autocompletePrediction.getPlaceId());
            builder.setTypes(autocompletePrediction.getPlaceTypes().isEmpty() ? null : autocompletePrediction.getPlaceTypes());
            return Tasks.forResult(FetchPlaceResponse.newInstance(builder.build()));
        }
        zzjf zzjfVar = this.zzg;
        if (zzjfVar != null) {
            if (zzjfVar.zzb().equals(autocompletePrediction.getPlaceId())) {
                Task taskZzc = zzjfVar.zzc();
                taskZzc.getClass();
                return taskZzc;
            }
            zzjfVar.zza().cancel();
        }
        final zzja zzjaVar = new zzja(new CancellationTokenSource(), autocompletePrediction.getPlaceId());
        this.zzg = zzjaVar;
        PlacesClient placesClient = this.zzc;
        FetchPlaceRequest.Builder builder2 = FetchPlaceRequest.builder(autocompletePrediction.getPlaceId(), this.zzd.zzj());
        builder2.setSessionToken(this.zze);
        builder2.setCancellationToken(zzjaVar.zza().getToken());
        Task taskContinueWithTask = placesClient.fetchPlace(builder2.build()).continueWithTask(new Continuation() { // from class: com.google.android.libraries.places.internal.zzjd
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                int i = zzji.zza;
                return zzjaVar.zza().getToken().isCancellationRequested() ? Tasks.forCanceled() : task;
            }
        });
        zzjaVar.zzd(taskContinueWithTask);
        return taskContinueWithTask;
    }

    @Override // com.google.android.libraries.places.internal.zzjb
    public final Task zzb(String str) {
        zzkt.zze(!TextUtils.isEmpty(str));
        zzje zzjeVar = this.zzf;
        if (zzjeVar != null) {
            if (zzjeVar.zzb().equals(str)) {
                Task taskZzc = zzjeVar.zzc();
                taskZzc.getClass();
                return taskZzc;
            }
            zzjeVar.zza().cancel();
        }
        final zziz zzizVar = new zziz(new CancellationTokenSource(), str);
        this.zzf = zzizVar;
        PlacesClient placesClient = this.zzc;
        FindAutocompletePredictionsRequest.Builder builder = FindAutocompletePredictionsRequest.builder();
        builder.setQuery(str);
        builder.setLocationBias(this.zzd.zzc());
        builder.setLocationRestriction(this.zzd.zzd());
        builder.setCountries(this.zzd.zzi());
        builder.setTypeFilter(this.zzd.zze());
        builder.setTypesFilter(this.zzd.zzk());
        builder.setSessionToken(this.zze);
        builder.setCancellationToken(zzizVar.zza().getToken());
        Task taskContinueWithTask = placesClient.findAutocompletePredictions(builder.build()).continueWithTask(new Continuation() { // from class: com.google.android.libraries.places.internal.zzjc
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                int i = zzji.zza;
                return zzizVar.zza().getToken().isCancellationRequested() ? Tasks.forCanceled() : task;
            }
        });
        zzizVar.zzd(taskContinueWithTask);
        return taskContinueWithTask;
    }

    @Override // com.google.android.libraries.places.internal.zzjb
    public final void zzc() {
        zzje zzjeVar = this.zzf;
        if (zzjeVar != null) {
            zzjeVar.zza().cancel();
        }
        zzjf zzjfVar = this.zzg;
        if (zzjfVar != null) {
            zzjfVar.zza().cancel();
        }
        this.zzf = null;
        this.zzg = null;
    }
}

package com.google.android.libraries.places.internal;

import android.text.TextUtils;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import com.google.android.libraries.places.api.net.PlacesStatusCodes;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzgh {
    zzgh() {
    }

    public static final FindAutocompletePredictionsResponse zza(zzgg zzggVar) throws ApiException {
        int iZza = zzhf.zza(zzggVar.status);
        if (PlacesStatusCodes.isError(iZza)) {
            throw new ApiException(new Status(iZza, zzhf.zzb(zzggVar.status, zzggVar.errorMessage)));
        }
        ArrayList arrayList = new ArrayList();
        zzfu[] zzfuVarArr = zzggVar.predictions;
        if (zzfuVarArr != null) {
            for (zzfu zzfuVar : zzfuVarArr) {
                if (zzfuVar == null || TextUtils.isEmpty(zzfuVar.zzf())) {
                    throw new ApiException(new Status(8, "Unexpected server error: Place ID not provided for an autocomplete prediction result"));
                }
                AutocompletePrediction.Builder builder = AutocompletePrediction.builder(zzfuVar.zzf());
                builder.setDistanceMeters(zzfuVar.zzd());
                builder.setPlaceTypes(zzhb.zzd(zzhb.zze(zzfuVar.zzc())));
                builder.setTypes(zzhb.zzd(zzhb.zzf(zzfuVar.zzc())));
                builder.setFullText(zzlb.zzc(zzfuVar.zze()));
                builder.zza(zzb(zzfuVar.zzb()));
                zzfu.zza zzaVarZza = zzfuVar.zza();
                if (zzaVarZza != null) {
                    builder.setPrimaryText(zzlb.zzc(zzaVarZza.zzc()));
                    builder.zzc(zzb(zzaVarZza.zza()));
                    builder.setSecondaryText(zzlb.zzc(zzaVarZza.zzd()));
                    builder.zzd(zzb(zzaVarZza.zzb()));
                }
                arrayList.add(builder.build());
            }
        }
        return FindAutocompletePredictionsResponse.newInstance(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static List zzb(List list) throws ApiException {
        ArrayList arrayList = new ArrayList();
        zzmy zzmyVarListIterator = ((zzlx) list).listIterator(0);
        while (zzmyVarListIterator.hasNext()) {
            zzfu.zzb zzbVar = (zzfu.zzb) zzmyVarListIterator.next();
            Status status = new Status(8, "Unexpected server error: Place ID not provided for an autocomplete prediction result");
            if (zzbVar == null) {
                throw new ApiException(status);
            }
            Integer num = zzbVar.offset;
            Integer num2 = zzbVar.length;
            if (num == null || num2 == null) {
                throw new ApiException(status);
            }
            com.google.android.libraries.places.api.model.zzbx zzbxVarZzc = com.google.android.libraries.places.api.model.zzby.zzc();
            zzbxVarZzc.zzb(num.intValue());
            zzbxVarZzc.zza(num2.intValue());
            arrayList.add(zzbxVarZzc.zzc());
        }
        return arrayList;
    }
}

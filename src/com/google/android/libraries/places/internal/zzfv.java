package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.PhotoMetadata;
import com.google.android.libraries.places.api.net.FetchPhotoRequest;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzfv extends zzgo {
    zzfv(FetchPhotoRequest fetchPhotoRequest, String str, boolean z, zzij zzijVar) {
        super(fetchPhotoRequest, null, str, false, zzijVar);
    }

    @Override // com.google.android.libraries.places.internal.zzgo
    protected final String zze() {
        return "photo";
    }

    @Override // com.google.android.libraries.places.internal.zzgo
    public final Map zzf() {
        FetchPhotoRequest fetchPhotoRequest = (FetchPhotoRequest) zzb();
        PhotoMetadata photoMetadata = fetchPhotoRequest.getPhotoMetadata();
        HashMap map = new HashMap();
        zzg(map, "maxheight", fetchPhotoRequest.getMaxHeight(), null);
        zzg(map, "maxwidth", fetchPhotoRequest.getMaxWidth(), null);
        map.put("photoreference", photoMetadata.zza());
        return map;
    }
}
